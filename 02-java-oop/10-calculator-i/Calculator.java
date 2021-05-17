
public class Calculator{
    private double operationOne;
    private double operationTwo;
    private char operation;
    private double result;

    public Calculator(){
    }
    public void setOperationOne(double operationOne){
        this.operationOne = operationOne;
    }
    public void setOperationTwo(double operationTwo){
        this.operationTwo = operationTwo;
    }
    public void setOperation(char operation){
        this.operation = operation;
    }
    public Double getOperationOne(double operationOne){
        return operationOne;
    }
    public Double getOperationTwo(double operationTwo){
        return operationTwo;
    }
    public char getOperation(char operation){
        return operation;
    }
    public void performOperation(){
        if(this.operation == '+'){
            this.result = operationOne + operationTwo;
        }
        if(this.operation == '-'){
            this.result = operationOne - operationTwo;
        }
    }
    public void getResult(){
        System.out.println(this.operationOne + "" + this.operation + "" + this.operationTwo + "" + "=" + this.result);
    }
}