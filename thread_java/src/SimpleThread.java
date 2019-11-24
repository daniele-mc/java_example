public class SimpleThread {
    public static void main(String[] args) {

        //new Thread().start();

        new ThreadTest().start();

        String name = java.lang.management.ManagementFactory.getRuntimeMXBean().getName();
        String[] splitedName = name.split("@");
        String pid = splitedName[0];


        while (true){
            System.out.println("Sou o processo principal de PID: " + pid);
        }



    }


//    private static Runnable runnable = new Runnable() {
//        @Override
//        public void run() {
//            String name = java.lang.management.ManagementFactory.getRuntimeMXBean().getName();
//            String[] splitedName = name.split("@");
//            String pid = splitedName[0];
//
//            while (true){
//                System.out.println("Sou o processo de PID: " + pid);
//            }
//
//        }
//    };

}
