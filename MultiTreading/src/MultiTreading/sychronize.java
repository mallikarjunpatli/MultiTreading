package MultiTreading;
class BothRoom
{
	 synchronized public void use()
	{
		Thread t=Thread.currentThread();
		
		String name=t.getName();
		
	try {
		System.out.println(name+" is Started ");
		Thread.sleep(3000);
		System.out.println(name+" is using ");
		Thread.sleep(3000);
		System.out.println(name+" is complet ");
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	}
}

class Boy extends Thread
{
	BothRoom ba;

	public Boy(BothRoom ba)
	{
		this.ba=ba;
	}

	@Override 
	public void run()
	{
		ba.use();

	}
}
class Girle extends Thread
{
	BothRoom ba;

	public Girle(BothRoom ba)
	{
		this.ba=ba;
	}
	@Override 
	public void run()
	{
		ba.use();

	}
}
class others extends Thread
{
	BothRoom ba;

	public others(BothRoom ba)
	{
		this.ba=ba;
	}
	@Override 
	public void run()
	{
		ba.use();

	}
}
public class sychronize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BothRoom ba=new  BothRoom();

		Boy b=new Boy(ba);
		b.setName("Boy");
		Girle g=new Girle(ba);
		g.setName("Girle");
		others o=new others(ba);
		o.setName("other");

		b.start();
		g.start();
		o.start();


	}

}
