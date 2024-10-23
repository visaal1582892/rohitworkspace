// Given two lists of intervals, find the intersection of these two lists. Each list consists of disjoint intervals sorted on their start time.

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class IntervalsIntersection{
    public static List<Interval> intervalsIntersection(List<Interval> l1, List<Interval> l2){
        List<Interval> out=new LinkedList<>();
        int n1=l1.size();
        int n2=l2.size();
        int i=0,j=0;
        while(i<n1 && j<n2){
            Interval i1=l1.get(i);
            Interval i2=l2.get(j);
            if(i1.start<=i2.start && i2.start<=i1.end || i2.start<=i1.start && i1.start<=i2.end){
                out.addLast(new Interval(Integer.max(i1.start,i2.start),Integer.min(i1.end,i2.end)));
            }
            if(i1.end<i2.end){
                i++;
            }
            else{
                j++;
            }
        }
        return out;
    }
    public static void main(String [] args){
        List<Interval> l1=new ArrayList<>();
        List<Interval> l2=new ArrayList<>();
        Interval i1=new Interval(1,3);
        Interval i2=new Interval(5,6);
        Interval i3=new Interval(7,9);
        Interval i4=new Interval(2,3);
        Interval i5=new Interval(5,7);
        l1.addAll(Arrays.asList(i1,i2,i3));
        l2.addAll(Arrays.asList(i4,i5));
        List<Interval> out=IntervalsIntersection.intervalsIntersection(l1, l2);
        out.forEach(i -> System.out.println(i.start+" "+i.end));
    }
}
