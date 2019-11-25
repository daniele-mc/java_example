public class SimpleThread {
    public static void main(String[] args) {

        new ThreadTest().start();

        while (true){
            System.out.println("Sou o processo principal");
        }
    }


}
