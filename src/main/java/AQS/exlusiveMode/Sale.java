package AQS.exlusiveMode;

class Sale  implements Runnable {

    private final Mutex mutexLock = new Mutex();

    private int count = 200; //车票总数

    @Override
    public void run() {
        while(true){
            mutexLock.lock();

            try{
                if (count > 0){

                    Thread.sleep(100);  //模拟购票等待时间

                    System.out.println(Thread.currentThread().getName() + "当前售卖的票的编号：" + count);
                    count--;
                }else{
                    System.out.println("车票已经售卖完毕");
                    return;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            finally{
                mutexLock.unlock();
            }
        }
    }

}//end class