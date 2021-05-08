public class BasicJavaTest{
    public static void main(String[] args) {
        BasicJava total = new BasicJava();
        int[] arr1 = {1,3,5,7,9,13};
        int[] arr2 = {1,5,10-2};
        int[] arr3 = {1,5,10,7,-2};
        total.Print1To255();
        total.PrintOdd1To255();
        total.PrintSum();
        total.IteratingThroughAnArray(arr1);
        total.FindMax(arr1);
        total.FindAverage(arr1);
        total.ArrayWithOdd();
        total.GreaterThanY(arr1, 3);
        total.SquareTheValues(arr1);
        total.NegativesNumbers(arr1);
        total.MaxMinAvg(arr2);
        total.ShiftingTheValues(arr3);
    }
}