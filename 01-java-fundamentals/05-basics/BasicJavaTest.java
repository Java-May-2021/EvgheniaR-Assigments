public class BasicJavaTest{
    public static void main(String[] args) {
        BasicJava total = new BasicJava();
        int[] arr1 = {1,3,5,7,9,13};
        int[] arr2 = {1,5,10-2};
        int[] arr3 = {3,5,4,10};
        int[] arr4 = {1,5,10,7,-2};
        int [] arr5 = {10,3,6,8};
        total.Print1To255();
        total.PrintOdd1To255();
        total.PrintSum();
        total.IteratingThroughAnArray(arr1);
        total.FindMax(arr1);
        total.FindAverage(arr1);
        total.ArrayWithOdd();
        total.GreaterThanY(arr2, 3);
        total.SquareTheValues(arr3);
        total.NegativesNumbers(arr4);
        total.MaxMinAvg(arr5);
        total.ShiftingTheValues(arr5);
    }
}