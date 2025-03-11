package multithreading.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class OrderProcessingService {

    public void processOrder(String orderId) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3); // 3 tasks to complete
        System.out.println("Order Processing Started for Order ID: " + orderId);

        // Subtask 1: Inventory Check
        new Thread(() -> {
            try {
                System.out.println("Checking inventory for Order ID: " + orderId);
                Thread.sleep(2000); // Simulate inventory check
                System.out.println("Inventory check complete for Order ID: " + orderId);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                latch.countDown(); // Decrement the latch count
            }
        }).start();

        // Subtask 2: Payment Processing
        new Thread(() -> {
            try {
                System.out.println("Payment processignfor order ID "+ orderId);
                Thread.sleep(2000);
                System.out.println("Payment processed for Order ID: " + orderId);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                latch.countDown(); // Decrement the latch count
            }
        }).start();

        // Subtask 3: Sending Notification
        new Thread(() -> {
            try {
                System.out.println("Sending notification for Order ID: " + orderId);
                Thread.sleep(1000); // Simulate notification
                System.out.println("Notification sent for Order ID: " + orderId);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                latch.countDown(); // Decrement the latch count
            }
        }).start();

        // Wait for all tasks to complete
        latch.await();
        System.out.println("Order Processing Complete for Order ID: " + orderId);
    }
}