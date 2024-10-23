// Given an array of intervals representing ‘N’ appointments, find out if a person can attend all the appointments.

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;

public class ConflictingAppointments{
    public static boolean conflictingAppointments(List<Interval> input){
        input.sort(Comparator.comparingInt(i->i.start));
        int n=input.size();
        boolean output=true;
        for(int i=1; i<n; i++){
            if(input.get(i).start<input.get(i-1).end){
                output=false;
                break;
            }
        }
        return output;
    }
    public static void main(String [] args){
        List<Interval> l1=new ArrayList<>();
        Interval i1=new Interval(6,7);
        Interval i2=new Interval(2,4);
        Interval i3=new Interval(8,12);
        // Interval i4=new Interval(2,3);
        // Interval i5=new Interval(5,7);
        l1.addAll(Arrays.asList(i1,i2,i3));
        // l2.addAll(Arrays.asList(i4,i5));
        boolean out=ConflictingAppointments.conflictingAppointments(l1);
        System.out.println(out);
    }
}