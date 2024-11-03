public class PlatformThreadExample {
    public static void main(String[] args) throws InterruptedException {
        int totalThreads = 100000;
        Thread[] threads = new Thread[totalThreads];

        for (int i = 0; i < totalThreads; i++) {
            final int threadNumber = i;
            threads[i] = new Thread(() -> {
                System.out.println("Platform Thread #" + threadNumber);
            });
            threads[i].start();
        }

        // Đợi tất cả các luồng hoàn thành
        for (int i = 0; i < totalThreads; i++) {
            threads[i].join();
        }
    }
}
