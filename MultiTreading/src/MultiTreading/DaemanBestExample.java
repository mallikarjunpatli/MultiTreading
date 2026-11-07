package MultiTreading;

class Demo extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("User thread executing");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("Some problem occurred");
            }
        }
        System.out.println("User thread completed");
    }
}

class Demo12 extends Thread {
    public void run() {
        for ( ; ; ) {
            System.out.println("Daemon thread executing");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("Some problem occurred");
            }
        }
    }
}
public class DaemanBestExample {
    public static void main(String args[]) throws Exception {
        System.out.println("Main() started execution");
        
        Demo d1 = new Demo(); // Creating an instance of the user thread
        Demo12 d2 = new Demo12(); // Creating an instance of the daemon thread
        
        d2.setDaemon(true);     // Setting true to the daemon property
        
        d1.start();             // Starting the user thread
        d2.start();             // Starting the daemon thread
        
        System.out.println("Main() completed execution");
    }
}