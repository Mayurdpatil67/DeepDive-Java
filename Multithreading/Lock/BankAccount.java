package Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance = 100;

    private final Lock lock = new ReentrantLock();

    public void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + "Attempting to withdraw " + amount);
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS))
                if (balance >= amount) {
                    try {
                        System.out.println(Thread.currentThread().getName() + "Processing transaction");
                        Thread.sleep(3000);
                        balance -= amount;
                        System.out.println(
                                Thread.currentThread().getName() + "Complete withdrawal . Remaining ammount :"
                                        + amount);
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        lock.unlock();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + "Insufficient balance ");
                }
            else {
                System.out.println(Thread.currentThread().getName() + "Could not aquire lock , will try again later");

            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();

        }
    }
}
