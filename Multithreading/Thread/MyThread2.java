public class MyThread2 extends Thread {
    public MyThread2(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i <= 5; i++) {
            @SuppressWarnings("unused")
            String a = "";
            for (int j = 0; j <= 10000; j++) {
                a += "a";

            }
            System.out.println(Thread.currentThread().getName() + " - Priority :" + Thread.currentThread().getPriority()
                    + "- Count:" + i);
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    public static void main(String[] args) {
        MyThread2 l = new MyThread2("Mayur");
        MyThread2 m = new MyThread2("Mayur");
        MyThread2 h = new MyThread2("Mayur");
        l.setPriority(MIN_PRIORITY);
        m.setPriority(NORM_PRIORITY);
        h.setPriority(MAX_PRIORITY);
        l.start();
        m.start();
        h.start();

    }
}
