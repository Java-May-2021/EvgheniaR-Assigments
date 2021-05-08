import java.util.ArrayList;
import java.util.Arrays;

public class BasicJava {
    public static void Print1To255() {
        for(int i=1; i<=255; i++){
            System.out.println(i);
        }
    }
    public static void PrintOdd1To255() {
        for(int i=1; i<=255; i++){
            if(i%2 != 0) {
                System.out.println(i);
            }
        }
    }
    public static void PrintSum() {
        int sum = 0;
        for(int i=0; i<=255; i++) {
            sum = sum+1;
            System.out.println("New number:" + i + "Sum:" + sum);
        }
    }
    public static void IteratingThroughAnArray(int[] arr){
        for(int val:arr){
            System.out.println(val);
        }
    }
    public static void FindMax(int[] arr){
        int max = arr[0];
        for(int i=1; i<arr.length; i++) {
            if(max < arr[i]) {
                max = arr[i];
            }
        }
        System.out.println(max);
    }
    public static void FindAverage(int[] arr){
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            sum = sum + arr[i];
        }
        System.out.println(sum/arr.length);
    }
    public static void ArrayWithOdd() {
        ArrayList <Integer> arr = new ArrayList <Integer>();
        for(int i = 1; i <= 255; i++){
            if(i%2 != 0){
                arr.add(i);
            }
        }
        System.out.println(arr);
    }
    public static int GreaterThanY(int[] arr, int y){
        int count = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] > y){
                count++;
            }
        }
        return count;
    }
    public static void SquareTheValues(int[] arr){
        for(int i = 0; i<arr.length; i++){
            arr[i]= arr[i]*arr[i];
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void NegativesNumbers(int[] arr){
        for(int i=0; i<arr.length; i++){
            if(arr[i]< 0) {
                arr[i] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void MaxMinAvg(int[] arr){
        int max = arr[0];
        int min = arr[0];
        int sum = 0;
        for(int i=0;i<arr.length; i++){
            if(arr[i]>max) {
                max = arr[i];
            }
            if(arr[i]<min) {
                min = arr[i];
            }
            sum = sum +arr[i];
        }
        int avg = sum/arr.length;
        int[] arrNew = {max, min, avg};
        System.out.println("Maximum:"+ max + "Minumum:" + min + "Average:"+ avg);
    }
    public static void ShiftingTheValues(int[] arr){
        int temp = arr[0];
        arr[0] = arr[arr.length-1];
        arr[arr.length-1] = temp;
        System.out.println(Arrays.toString(arr));
    }
}