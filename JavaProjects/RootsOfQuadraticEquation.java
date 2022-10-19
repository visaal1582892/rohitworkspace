package rohitworkspace.JavaProjects;

import java.util.Scanner;

import java.lang.Math;

class RootsOfQuadraticEquation
{
    public static void roots(double a,double b,double c) {
        double d=(b*b)-4*a*c;
        if(d<0)
        {
            System.out.println("no real roots for given equation");
        }
        if(d>0)
        {
            System.out.println("give equation has distinct real roots");
            double r1=((-b)+Math.sqrt(b*b-4*a*c))/(2*a);
            double r2=((-b)-Math.sqrt(b*b-4*a*c))/(2*a);
            System.out.println("they are : "+r1+" and "+r2);
        }
        if(d==0)
        {
            System.out.println("give equation has real and equal roots");
            double r1=(-b)/(2*a);
            double r2=(-b)/(2*a);
            System.out.println("they are : "+r1+" and "+r2);
        }
        }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("The general form of quadratic equation is ax^2+bx+c");
        System.out.println("now enter the value of x^2 coefficient");
        double a=scanner.nextDouble();
        System.out.println("now enter the value of x coefficient");
        double b=scanner.nextDouble();
        System.out.println("now enter the value of constant");
        double c=scanner.nextDouble();
        roots(a,b,c);   
        scanner.close();
    }
} 