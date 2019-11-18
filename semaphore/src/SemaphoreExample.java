import java.util.concurrent.Semaphore;

public class SemaphoreExample extends Thread{ // poderiamos criar uma classe estática dentro da classe SemaphoreExample
    private static Semaphore semaphore = new Semaphore(4);
    private String threadId;


    public SemaphoreExample(String threadId) {
        this.threadId = threadId;
    }

    @Override
    public void run() {
        try {
            System.out.println(threadId + " Locking...");
            System.out.println("Avalible Permits: " + semaphore.availablePermits());
            semaphore.acquire();
            System.out.println(threadId + " conseguiu a permissão");

            try {
                for(int i=0;i<5;i++){ // vai ficar coisando por 5 segundos
                    System.out.println(threadId + " está realizando uma ação, Avalible permits: " + semaphore.availablePermits());
                    sleep(1000);
                }
            }
            finally { // caso as ações dentro da thread ocorram corretamente
                System.out.println("Realeasing " + threadId);
                semaphore.release();
                System.out.println("Semáforo agora permite " + semaphore.availablePermits() + " threads");
            }



        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

    }





    public static void main(String[] args) {

        SemaphoreExample t1 = new SemaphoreExample("t1");
        t1.start();

        SemaphoreExample t2 = new SemaphoreExample("t2");
        t2.start();

        SemaphoreExample t3 = new SemaphoreExample("t3");
        t3.start();

        SemaphoreExample t4 = new SemaphoreExample("t4");
        t4.start();

    }


}



