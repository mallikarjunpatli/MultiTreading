package MultiTreading;


	class Family1 implements Runnable {
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
	            synchronized (resources1) {
	                System.out.println("Rohit acquired Playstation");
	                Thread.sleep(1000);
	                synchronized (resources2) {
	                    System.out.println("Rohit acquired Controller");
	                    Thread.sleep(1000);
	                }
	            }
	        } catch (InterruptedException e) {
	            System.out.println("Rohit Failed");
	        }
	    }

	    void vijayAcquiredResources() {
	        try {
	            synchronized (resources1) {
	                System.out.println("Vijay acquired Playstation");
	                Thread.sleep(1000);
	                synchronized (resources2) {
	                    System.out.println("Vijay acquired Controller");
	                    Thread.sleep(1000);
	                }
	            }
	        } catch (InterruptedException e) {
	            System.out.println("Vijay Failed");
	        }
	    }
	}
	public class DeadLockSolveProblem {
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
		
	