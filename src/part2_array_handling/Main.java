package part2_array_handling;

import common.Input;
import java.util.Random;
import java.util.Arrays;
public class Main {
    public static int[] inputArray(int length) {
        if(length<0) throw new IllegalArgumentException("Negative length");
        int[] a=new int[length];
        for(int i=0;i<length;i++) a[i]=Input.integer("Element "+i+": ",Integer.MIN_VALUE,Integer.MAX_VALUE);
        return a;
    }
    public static int[] randomArray(int length) {
        if(length<0) throw new IllegalArgumentException("Negative length");
        Random random=new Random(); int[] a=new int[length];
        for(int i=0;i<length;i++) a[i]=random.nextInt(201)-100;
        return a;
    }
    public static void printArray(int[] a) { System.out.println(Arrays.toString(a)); }
    public static long sum(int[] a) { long sum=0; for(int v:a) sum+=v; return sum; }
    public static int max(int[] a) {
        if(a.length==0) throw new IllegalArgumentException("Empty array has no maximum");
        int best=a[0]; for(int value:a) if(value>best) best=value; return best;
    }
    public static int search(int[] a,int target) {
        for(int i=0;i<a.length;i++) if(a[i]==target) return i; return -1;
    }
    public static void main(String[] args) {
        int n=Input.integer("Length of input array (1-1000): ",1,1000);
        int[] a=inputArray(n); printArray(a); System.out.println("Sum: "+sum(a));
        n=Input.integer("Length of random array (1-1000): ",1,1000);
        int[] b=randomArray(n); printArray(b); System.out.println("Maximum: "+max(b));
        int target=Input.integer("Search for an integer in the input array: ",Integer.MIN_VALUE,Integer.MAX_VALUE);
        System.out.println("Index (-1 means absent): "+search(a,target));
    }
}
