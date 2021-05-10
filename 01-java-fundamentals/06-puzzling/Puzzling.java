import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Puzzling{
    public static ArrayList<Integer> SumAndGreater(int[] arr){
        ArrayList<Integer> newArr = new ArrayList<Integer>();
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            sum = sum + arr[i];
            if(arr[i]>10){
                newArr.add(arr[i]);
            }
        }
        System.out.println("Sum is:" + sum + "Greater is:" + newArr);
        return newArr;
    }
    public static ArrayList<String> GetNamesAndShuffle(ArrayList<String> arr){
        ArrayList<String> newArr = new ArrayList<String>();
        Collections.shuffle(arr);
        System.out.println(arr);
        for(int i=0; i<arr.size(); i++){
            if(arr.get(i).length() > 5){
                newArr.add(arr.get(i));
            }
        }
        return newArr;
    }
    public static void GetAlphabet(){
        ArrayList<Character> alphabet = new ArrayList<Character>();
        for(char ch = 'a'; ch<= 'z'; ++ch){
            alphabet.add(ch);
            System.out.println(ch);
        }
        Collections.shuffle(alphabet);
        System.out.println(alphabet);
        System.out.println(alphabet.get(25));
        System.out.println(alphabet.get(0));
        String vowels = "aeiou";
        int fc = vowels.indexOf(alphabet.get(0));
        if(fc > -1){
            System.out.println("This is a vowel");
        }
    }
    public static ArrayList<Integer> RandomNumbers(){
        ArrayList<Integer> result = new ArrayList<Integer>();
        Random r = new Random();
        for(int i =1; i<=10; i++){
            result.add (r.nextInt(100-55)+55);
        }
        return result;
    }
    public static ArrayList<Integer> MaxMinNumbers(){
        ArrayList<Integer> result = new ArrayList<Integer>();
        Random r = new Random();
        for(int i =1; i<=10; i++){
            result.add (r.nextInt(100-55)+55);
        } 
        Collections.sort(result);
        System.out.println(result);
        System.out.println("Minimum number is:" + result.get(0));
        System.out.println("Maximum number is:" + result.get(9));
        return result;
    }
    public static String RandomString() {
        String word = "";
        Random r = new Random();
        for(int i=0; i<5; i++) {
            word = word + (char)(r.nextInt((65+26) - 65) + 65);
        }
        return word;
    }
    public static ArrayList<String> TenLong(){
        ArrayList<String> var = new ArrayList<String>();
        for (int i=1; i<=10;i++){
            var.add(RandomString());
        }
        return var;
    }
}
