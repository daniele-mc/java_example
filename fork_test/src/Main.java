import com.sun.akuma.Daemon;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Daemon d = new Daemon();

        try {
            if(d.isDaemonized()){
                d.init();
            }

            d.daemonize();


        }
        catch (Exception e){
            e.printStackTrace();
        }




    }
}
