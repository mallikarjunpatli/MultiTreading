package MultiTreading;

class PrintJob implements Runnable {

	@Override
    public synchronized void run() {
        String threadName = Thread.currentThread().getName();
        
        System.out.println(threadName + " started printing");
        
        // Loop to print the status 3 times
        for (int i = 0; i < 3; i++) {
            System.out.println(threadName + " is printing");
           try {
        	   Thread.sleep(5000);
           }
           catch(Exception e)
           {
        	   System.out.println("Something is wrong");
           }
        }
        
        System.out.println(threadName + " completed printing");
    }
}

public class Synchronize {
    public static void main(String[] args) {
        // Shared resource/runnable object
        PrintJob p = new PrintJob();

        // Creating three threads sharing the same target object 'p'
        Thread t1 = new Thread(p);
        Thread t2 = new Thread(p);
        Thread t3 = new Thread(p);

        // Setting names for the threads as shown in the book
        t1.setName("MEN");
        t2.setName("WOMEN");
        t3.setName("CHILD");

        // Starting the threads
        t1.start();
        t2.start();
        t3.start();
    }
}