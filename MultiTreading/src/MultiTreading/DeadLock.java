package MultiTreading;

class Warrior extends Thread
{
	String res1 ="Bramhatra";
	String res2="Pasupastra";
	String res3="shashatra";


	@Override
	public void  run()
	{
		String name=getName();
		if(name.equals("Arjun"))
		{
			Arjun();
		}
		else
		{
			karna();
		}
	}


	public void Arjun()
	{
		try {
			Thread.sleep(5000);

			synchronized(res1)
			{
				System.out.println("Arjun got  Bramhatra:");
				Thread.sleep(5000);

				synchronized(res2) 
				{
					System.out.println("Arjun got  Pasupastra:");
					Thread.sleep(5000);

					synchronized(res3) 
					{
						System.out.println("Arjun got  shashatra:");

					}

				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	public void karna()
	{
		try {
			Thread.sleep(5000);

			synchronized(res3)
			{
				System.out.println("karna got   shashatra:");
				Thread.sleep(5000);

				synchronized(res2) 
				{
					System.out.println("karna got  Pasupastra:");
					Thread.sleep(5000);

					synchronized(res1) 
					{
						System.out.println("karna got Bramhatra :");

					}

				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}


	public class DeadLock {

		public static void main(String[] args) {
			// TODO Auto-generated method stub

			Warrior w1=new Warrior();
			Warrior w2=new Warrior();

			w1.setName("Arjun");
			w2.setName("Karna");

			w1.start();
			w2.start();


		}

	}
