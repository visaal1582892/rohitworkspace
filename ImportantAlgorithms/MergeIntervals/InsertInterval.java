// Given a list of non-overlapping intervals sorted by their start time, insert a given interval at the correct position and merge all necessary intervals to produce a list that has only mutually exclusive intervals.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class InsertInterval{
    public static List<Interval> insertInterval(List<Interval> inputList,Interval i){
        LinkedList<Interval> output=new LinkedList<>();
        int it=0;
        int n=inputList.size();
        while(it<n && inputList.get(it).end<i.start){
            output.addLast(inputList.get(it));
            it++;
        }
        while(it<n && inputList.get(it).start<=i.end){
            i.start=Integer.min(inputList.get(it).start,i.start);
            i.end=Integer.max(inputList.get(it).end,i.end);
            it++;
        }
        output.addLast(i);
        while(it<n){
            output.addLast(inputList.get(it));
            it++;
        }
        return output;
    }
    public static void main(String [] args){
        List<Interval> inputList=new ArrayList<>();
        List<Interval> output=new LinkedList<>();
        Interval i1=new Interval(1,3);
        Interval i2=new Interval(5,7);
        Interval i3=new Interval(8,12);
        Interval i4=new Interval(4,10);
        inputList.addAll(Arrays.asList(i1,i2,i3));
        output=InsertInterval.insertInterval(inputList,i4);
        output.forEach(i -> System.out.println(i.start+" "+i.end));
    }
}