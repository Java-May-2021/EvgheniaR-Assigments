public class StringManipulationTesting{
    public static void main(String[] args){
        StringManipulation manipulator = new StringManipulation();
        String str = manipulator.trimAndConcat("    Hello     ","     World    ");
        System.out.println(str); 
        
        char letter = 'o';
        Integer d = manipulator.getIndexOrNull("Coding", letter);
        Integer e = manipulator.getIndexOrNull("Hello World", letter);
        Integer c = manipulator.getIndexOrNull("Hi", letter);
        System.out.println(d); 
        System.out.println(e); 
        System.out.println(c); 
        
        String word = "Hello";
        String subString = "llo";
        String notSubString = "world";
        Integer a = manipulator.getIndexOrNull(word, subString);
        Integer b = manipulator.getIndexOrNull(word, notSubString);
        System.out.println(a); 
        System.out.println(b); 
        
        String substr = manipulator.concatSubstring("Hello", 1, 2, "world");
        System.out.println(substr); 

    }
}