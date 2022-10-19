package rohitworkspace.JavaProjects;
import java.util.Scanner;

class rohitworkspace
{
    public static void main(String[] args) {
        System.out.println("enter the speeds of five racers in order");
        Scanner sc=new Scanner(System.in);
        double a[]=new double[5];
        double sum=0;
        for(int i=0;i<5;i++)
        {
            a[i]=sc.nextDouble();
            sum=sum+a[i];
        }
        double average=sum/5.0;
        System.out.print("The speeds of qualifying racers are ");
        for(int i=0;i<5;i++)
        {
            if(a[i]>average)
            {
                System.out.print(a[i]+" ");
            }
        }
        sc.close();
    }
}