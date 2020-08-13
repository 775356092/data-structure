package Thread;

/**
 * @description: unsafe
 * @author: wang hao
 * @create: 2020-07-29 15:51
 */
public class Demo31 {

    private static int num = 0;
    private static boolean ready = false;

    static class ReadThread extends Thread {
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                if (ready) {
                    System.out.println(num + num);
                }
                System.out.println("read thread...");
            }
        }
    }

    static class WriteThread extends Thread {
        @Override
        public void run() {
            num = 2;
            ready = true;
            System.out.println("writeThread set over...");
        }
    }

    public static void main(String[] args) throws Exception {
        ReadThread readThread = new ReadThread();
        readThread.start();
        WriteThread writeThread = new WriteThread();
        writeThread.start();
        Thread.sleep(10);
        readThread.interrupt();
        System.out.println("main thread end");
    }

    static class TestForContent {
        static final int row = 1024;
        static final int col = 1024;


        public static void main(String[] args) {
            long curr = System.currentTimeMillis();
            long[][] array = new long[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    array[i][j] = i * 2 + j;
                }
            }
            long end = System.currentTimeMillis();
            System.out.println(end - curr);
        }
    }


    static class TestForContent2 {
        static final int row = 1024;
        static final int col = 1024;


        public static void main(String[] args) {
            long curr = System.currentTimeMillis();
            long[][] array = new long[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    array[j][i] = i * 2 + j;
                }
            }
            long end = System.currentTimeMillis();
            System.out.println(end - curr);
        }
    }
}
