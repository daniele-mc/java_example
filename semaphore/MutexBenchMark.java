import java.util.concurrent.Semaphore;

public class MutexBenchMark extends Thread { // poderiamos criar uma classe estática dentro da classe MutexBenchMark
    private static Semaphore semaphore = new Semaphore(1);
    private String threadId;

    public MutexBenchMark(String threadId) {
        this.threadId = threadId;
    }

    @Override
    public void run() {
        try {
            System.out.println(threadId + " Locking...");
            semaphore.acquire();

            try {
                for (int i = 0; i < 5; i++) { // vai ficar coisando por 5 segundos
                    System.out.println(threadId + " está realizando uma ação");
                }
            } finally { // caso as ações dentro da thread ocorram corretamente
                System.out.println("Realeasing " + threadId);
                semaphore.release();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        MutexBenchMark t1 = new MutexBenchMark("t1");
        t1.start();

        MutexBenchMark t2 = new MutexBenchMark("t2");
        t2.start();

        MutexBenchMark t3 = new MutexBenchMark("t3");
        t3.start();

        MutexBenchMark t4 = new MutexBenchMark("t4");
        t4.start();

    }

}
