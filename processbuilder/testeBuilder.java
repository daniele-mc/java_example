public class testeBuilder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try 
        { 
              
            // create a new process 
            System.out.println("Creating Process"); 
              
            ProcessBuilder builder = new ProcessBuilder("./processo"); 
            Process pro = builder.start(); 
      
            // wait 10 seconds 
            System.out.println("Waiting"); 
            Thread.sleep(10000); 
      
            // kill the process 
            pro.destroy(); 
            System.out.println("Process destroyed"); 
      
        }  
            catch (Exception ex)  
        { 
            ex.printStackTrace(); 
        } 
    }   
}