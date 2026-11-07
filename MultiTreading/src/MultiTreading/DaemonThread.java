package MultiTreading;

class Captain extends Thread
{

	@Override
	public void run() {



		try {
			BatingCoatch ba=new BatingCoatch();

			BowlingCoatch bo=new BowlingCoatch();

			ba.setName("BatingCoatch");
			bo.setName("BowlingCoatch");

			ba.setDaemon(true);
			bo.setDaemon(true);

			ba.start();
			bo.start();


			System.out.println("Captaint enter the ground:");
			sleep(5000);

			System.out.println("Capatin warm-uping");
			sleep(5000);

			System.out.println("Captain practice bating");
			sleep(5000);

			System.out.println("Captain in the hotel");
			sleep(5000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}


	}
}
class BowlingCoatch extends Thread
{
	@Override
	public void run()
	{
		for( ; ; )
		{
			System.out.println("BowlingCoatch in the ground");
			try
			{
				sleep(5000);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}


	}
}
class BatingCoatch extends Thread
{
	@Override
	public void run()
	{
		for( ; ; )
		{
			System.out.println("BatingCoatch in the ground");
			try
			{
				sleep(5000);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

}
public class DaemonThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Captain c=new Captain();
		c.start();
	}
}


