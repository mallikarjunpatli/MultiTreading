package MultiTreading;

class Family implements Runnable {
    String resources1 = "PlayStation";
    String resources2 = "Controller";

    public void run() {
        String name = Thread.currentThread().getName();

        if (name.equals("Rohit") == true) {
            rohitAcquiredResources();
        } else {
            vijayAcquiredResources();
        }
    }

    void rohitAcquiredResources() {
        try {
            synchronized (resources2) {
                System.out.println("Rohit acquired Controller");
                Thread.sleep(1000);
                synchronized (resources1) {
                    System.out.println("Rohit acquired PlayStation");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Completed logically to demonstrate the deadlock scenario
    void vijayAcquiredResources() {
        try {
            synchronized (resources1) {
                System.out.println("Vijay acquired PlayStation");
                Thread.sleep(1000);
                synchronized (resources2) {
                    System.out.println("Vijay acquired Controller");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

public class DeadLocks
{
    public static void main(String[] args) {
        Family familyJob = new Family();

        Thread t1 = new Thread(familyJob);
        Thread t2 = new Thread(familyJob);

        t1.setName("Rohit");
        t2.setName("Vijay");

        t1.start();
        t2.start();
    }
}
}