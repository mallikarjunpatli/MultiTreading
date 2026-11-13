package MultiTreading;

class Demo13 extends Thread {
	
    public void run() {
        for(int i = 1; i <= 5; i++) {
            try {
                System.out.println("JAVA");
                Thread.sleep(2000);
            }
            catch (Exception e) {
                System.out.println();
            }
        }
    }
}

public class join {
    public static void main(String args[]) throws InterruptedException {
        System.out.println("Main thread started");
        
        Demo13 d1 = new Demo13();
        d1.start();
        d1.join();
        
        System.out.println("Main thread completed");
    }
}

