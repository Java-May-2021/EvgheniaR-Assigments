public class StringManipulation{
    public String trimAndConcat(String string1, String string2){
        return string1.trim().concat(string2.trim());
    }
    public Integer getIndexOrNull(String input, char c){
        if(input.indexOf(c) == -1) {
            return null;
        }
        return input.indexOf(c);
    }
    public Integer getIndexOrNull(String input, String sub) {
        if(input.indexOf(sub) == -1) {
            return null;
        }
        return input.indexOf(sub);
    }
    public String concatSubstring(String input, int number1, int number2, String replacement){
        String substr = input.substring(number1, number2);
        return substr.concat(replacement);
    }

}