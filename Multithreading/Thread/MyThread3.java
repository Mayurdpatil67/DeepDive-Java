public class MyThread3 extends Thread {
    @Override
    public void run() {

        try {
            Thread.sleep(1000);
            System.out.println("Thread is runnig !");
        } catch (InterruptedException e) {
            System.out.println("Thread is interrupted" + e);
        }

    }

    public static void main(String[] args) {
        MyThread3 t1 = new MyThread3();
        t1.start();
        t1.interrupt();

    }

}
