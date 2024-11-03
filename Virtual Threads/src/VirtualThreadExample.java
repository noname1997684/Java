public class VirtualThreadExample {

    public static void main(String[] args) {
        // Đếm số lượng Virtual Threads đã hoàn thành
        int totalThreads = 100000;

        // Tạo một ExecutorService sử dụng Virtual Threads
        try (var executor = java.util.concurrent.Executors.newVirtualThreadPerTaskExecutor()) {

            // Khởi chạy 100.000 luồng ảo
            for (int i = 0; i < totalThreads; i++) {
                final int threadNumber = i;
                executor.submit(() -> {
                    System.out.println("Virtual Thread #" + threadNumber);
                });
            }

        } // ExecutorService sẽ tự động đóng lại khi kết thúc
    }
}
