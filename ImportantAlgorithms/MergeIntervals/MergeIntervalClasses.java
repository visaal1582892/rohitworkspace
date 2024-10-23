// Given a list of intervals, merge all the overlapping intervals to produce a list that has only mutually exclusive intervals.

import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;

class Interval{
    int start;
    int end;
    Interval(int start,int end){
        this.start=start;
        this.end=end;
    }
}

public class MergeIntervalClasses{
    public static List<Interval> merger(List<Interval> inputList){
        int n=inputList.size();
        List<Interval> outputList=new LinkedList<>();
        outputList.addFirst(inputList.get(0));
        for(int i=1; i<n; i++){
            Interval i1=outputList.getLast();
            outputList.removeLast();
            Interval i2=inputList.get(i);
            if(i1.end<i2.start){
                outputList.addLast(i1);
                outputList.addLast(i2);
            }
            else{
                outputList.addLast(new Interval(i1.start,Integer.max(i1.end, i2.end)));
            }
        }
        return outputList;
    }
    public static List<Interval> mergeIntervalClasses(List<Interval> inputList){
        List<Interval> outputList=new LinkedList<>();
        // this is for creating custom comparatyor class.
        // class CustomComparator implements Comparator<Interval>{
        //     @Override
        //     public int compare(Interval i1, Interval i2){
        //         return Integer.compare(i1.start, i2.start);
        //     }
        // }

        // using inbuilt function of Comparator class.
        inputList.sort(Comparator.comparingInt(i1 -> i1.start));
        outputList=MergeIntervalClasses.merger(inputList);
        return outputList;
    }
    public static void main(String [] args){
        List<Interval> inputList=new ArrayList<>();
        List<Interval> outputList=new ArrayList<>();
        Interval i1=new Interval(1,4);
        Interval i2=new Interval(2,6);
        Interval i3=new Interval(3,5);
        inputList.addAll(Arrays.asList(i1,i2,i3));
        outputList=MergeIntervalClasses.mergeIntervalClasses(inputList);
        outputList.forEach(i -> System.out.println(i.start+" "+i.end));
    }
}