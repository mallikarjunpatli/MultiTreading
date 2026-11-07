package MultiTreading;

import java.util.Scanner;

class SingleRunTask implements Runnable
{
    @Override
    public void run()
    {
        Thread t = Thread.currentThread();
        String name = t.getName();

        if (name.equals("ADD"))
        {
            add();
        }
        else if (name.equals("CHAR"))
        {
            charPrint();
        }
        else
        {
            numPrint();
        }
    }

    public void add()
    {
        System.out.println("Addition activity started");

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the first number");
        int a = scan.nextInt();

        System.out.println("Enter the second number");
        int b = scan.nextInt();

        int c = a + b;

        System.out.println(c);

        System.out.println("Addition activity ended");
    }

    public void charPrint()
    {
        System.out.println("Character printing activity started");

        for (int i = 65; i <= 75; i++)
        {
            System.out.println((char)i);

            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

        System.out.println("Character printing activity ended");
    }

    public void numPrint()
    {
        System.out.println("Number printing activity started");

        for (int i = 1; i <= 10; i++)
        {
            System.out.println(i);

            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

        System.out.println("Number printing activity ended");
    }
}

public class SingleRunMethod
{
    public static void main(String[] args)
    {
        SingleRunTask sr = new SingleRunTask();

        Thread t1 = new Thread(sr);
        Thread t2 = new Thread(sr);
        Thread t3 = new Thread(sr);

        t1.setName("ADD");
        t2.setName("CHAR");
        t3.setName("NUM");

        t1.start();
        t2.start();
        t3.start();
    }
}