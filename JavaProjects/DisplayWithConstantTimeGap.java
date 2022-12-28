package rohitworkspace.JavaProjects;

import java.lang.Thread;
class Mythread1 implements Runnable
{
    public void run()
    {
        int i=0;
        while(i<300){
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println(e);    
        }
        System.out.println("Good Morning");
        i++;
    }
    }
}
class Mythread2 implements Runnable
{
    public void run()
    {
        int i=0;
        while(i<300){
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println(e);    
        }
        System.out.println("Hello");
        i++;
    }
    }
}
class Mythread3 implements Runnable
{
    public void run()
    {
        int i=0;
        while(i<300){
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println(e);    
        }
        System.out.println("Welcome");
        i++;
    }
    }
}
public class DisplayWithConstantTimeGap {

    public static void main(String[] args) {
        Mythread1 t1=new Mythread1();
        Thread t11=new Thread(t1);
        Mythread2 t2=new Mythread2();
        Thread t22=new Thread(t2);
        Mythread3 t3=new Mythread3();
        Thread t33=new Thread(t3);
        t11.start();
        t22.start();
        t33.start();
    }
}
