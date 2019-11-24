public class ThreadTest extends Thread {
    @Override
    public void run() {
        while (true){
            System.out.println("Sou o processo de PID: " + this.toString());
        }
    }
}
