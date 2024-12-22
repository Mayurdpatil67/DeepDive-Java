public class MyThread5 extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("Hello world !");
        }
    }

    public static void main(String[] args) {
        MyThread5 t1 = new MyThread5();
        t1.setDaemon(true);
        MyThread5 t2 = new MyThread5();
        t2.start();
        t1.start();
        System.out.println("Main done ");

    }
}
