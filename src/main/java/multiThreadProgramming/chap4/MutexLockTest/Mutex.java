package multiThreadProgramming.chap4.MutexLockTest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

//排他锁：基于Lock接口、AQS实现
public class Mutex implements Lock, java.io.Serializable {

    //Our internal helper class
    private static class Sync extends AbstractQueuedSynchronizer{

        protected boolean isHeldExclusiveley(){
            return getState() == 1;
        }

        public boolean tryAcquire(int acquires){
            assert acquires == 1; //Otherwise unused
            if (compareAndSetState(0, 1)){
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }

            return false;
        }

        public boolean tryRelease(int releases){
            assert releases == 1;  //Otherwise unused
            if (getState() == 0) throw new IllegalMonitorStateException();
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        // Provides a Condition
        Condition newCondition(){
            return new ConditionObject();
        }

        // Deserializes properly
        private void readObject(ObjectInputStream s)
                throws IOException, ClassNotFoundException {
            s.defaultReadObject();
            setState(0);  // reset to unlocked state
        }
    }

    // The sync object does all hard work. We just forward to it.
    private final Sync sync = new Sync();


    public void lock() {
        sync.acquire(1);
    }
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(time));
    }
    public void unlock() {
        sync.release(1);
    }
    public boolean isLocked(){
        return sync.isHeldExclusiveley();
    }
    public boolean hasQueuedThreads(){
        return sync.hasQueuedThreads();
    }

    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    public Condition newCondition() {
        return sync.newCondition();
    }


}
