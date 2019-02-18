package multiThreadProgramming.chap3.wait_notify_insert_test;

//验证： 等待/通知 之 交叉备份
public class Test {

    public static void main(String[] args) {
        DBTools dbTools = new DBTools();

        for (int i = 1; i < 11; i++) {
            BackupA backupA = new BackupA(dbTools);
            backupA.setName(i + "");
            backupA.start();
        }

        for (int i = 11; i < 21; i++) {
            BackupB backupB = new BackupB(dbTools);
            backupB.setName(i + "");
            backupB.start();
        }

    }//end main
}
