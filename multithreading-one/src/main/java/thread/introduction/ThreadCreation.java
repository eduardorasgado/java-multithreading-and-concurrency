package thread.introduction;

public class ThreadCreation {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("-----------------");
                System.out.println("We are now in the thread: " + Thread.currentThread().getName());
                System.out.println("Current thread priority is: " + Thread.currentThread().getPriority());
                System.out.println("-----------------");
            }
        });

        thread.setName("New worker thread");
        thread.setPriority(Thread.MAX_PRIORITY);

        System.out.println(
                "       We are in thread: '"
                        + Thread.currentThread().getName()
                        + "'  before starting a new thread "
                        + "with priority: "
                        + Thread.currentThread().getPriority());

        thread.start();

        System.out.println(
                "       We are in thread: '"
                        + Thread.currentThread().getName()
                        + "'  after starting a new thread");

        //Thread.sleep(5000);
    }
}
