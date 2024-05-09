package thread.exceptionHandler;

public class ThreadExceptionHandler {

    public static void main(String[] args) {
        Thread thread = getThread();
        setThreadExceptionHandler(thread);
        configureThread(thread);

        thread.start();
    }

    private static Thread getThread() {
        return new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("We are now in the thread: " + Thread.currentThread().getName());
                throw new RuntimeException("Intentional Exception");
            }
        });
    }

    private static void setThreadExceptionHandler(Thread thread) {
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("A critical error happened in thread: '"
                        + t.getName()
                        + "', the error is: "
                        + e.getMessage());
            }
        });
    }

    private static void configureThread(Thread thread) {
        thread.setName("Misbehaving thread");
        thread.setPriority(Thread.MAX_PRIORITY);
    }
}
