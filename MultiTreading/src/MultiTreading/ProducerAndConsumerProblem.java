package MultiTreading;
class Queue
{
	private int data;
	boolean DataIs=false;

	public synchronized void setData(int data)
	{
		if(DataIs==false)
		{
			this.data=data;
			System.out.println("Producer produce data: "+data);
			DataIs=true;
			notify();
		}
		else
		{
			try {
				wait();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	public  synchronized void getData()
	{
		if(DataIs==true)
		{
			System.out.println( "Consumer  get data "+data);
			DataIs=false;
			notify();
		}
		else
		{
			try {
				wait();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}

class Producer extends Thread
{

	Queue q;

	Producer (Queue q)
	{
		this.q=q;
	}


	@Override
	public void run()
	{
		int i=1;

		for(; ;) {
			q.setData(i++);
		}

	}
}

class Consumer extends Thread
{

	Queue q;

	Consumer (Queue q)
	{
		this.q=q;
	}
	@Override
	public void run()
	{

		for(; ;) {
			q.getData();
		}

	}
}



public class ProducerAndConsumerProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue q=new Queue();

		Producer p=new Producer(q);
		p.setName("Producer");
		Consumer c=new Consumer(q);
		p.setName("Consumer");

		p.start();
		c.start();
	}

}
