public class CalculatorTest{
    public static void main(String[] args){
        Calculator c = new Calculator();
        c.setOperationOne(10.5);
        c.setOperationTwo(5.2);
        c.setOperation('+');
        c.performOperation();
        c.getResult();
    }
}