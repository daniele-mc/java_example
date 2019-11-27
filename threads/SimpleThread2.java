public class SimpleThread2 {
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread() {
            @Override
            public void run() {
                
                while (true) {
                    System.out.println("Processo em paralelo");
                    try {
                        sleep(1000);
                    } 
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }            
                
            }
        };
        
        


        Runnable runnable = new Runnable(){
            @Override
            public void run() {
                // Função a rodar na Thread                
            }
        };

       

        

        thread.start();
        
        System.out.println(thread.getPriority());
        


        while(true){        
            System.out.println("Processo principal");
            Thread.sleep(1000);
        }

    }

}