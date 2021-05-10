import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class PuzzlingTest{
    public static void main(String[] args){
        Puzzling puzz = new Puzzling();
        int [] arr1 = {3,5,1,2,7,9,8,13,25,32};
        puzz.SumAndGreater(arr1);
        ArrayList<String> arr2 = new ArrayList<String>(Arrays.asList("Nancy","Jinichi","Fujibayashi","Momochi","Ishikawa"));
        System.out.println(puzz.GetNamesAndShuffle(arr2));
        puzz.GetAlphabet();
        System.out.println(puzz.RandomNumbers());
        System.out.println(puzz.MaxMinNumbers());
        System.out.println(puzz.RandomString());
        System.out.println(puzz.TenLong());
    }
}