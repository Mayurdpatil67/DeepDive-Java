public class MyThread1 extends Thread {
    @Override
    public void run() {

        System.out.println("Thread is running !");
        for (int i = 0; i <= 5; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }

        }

    }

    public static void main(String[] args) throws InterruptedException {
        MyThread1 t1 = new MyThread1();
        t1.start();
        t1.join();
        System.out.println("Hello");

    }

}
