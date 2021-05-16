public class PhoneTest{
    public static void main(String[] args){
        IPhone iphone11 = new IPhone("11",100,"Verizon","Ring Ring");
        iphone11.displayInfo();
        System.out.println(iphone11.ring());
        System.out.println(iphone11.unlock());

        Galaxy s9 = new Galaxy("S9",80,"T-Mobile","Zing Zing");
        s9.displayInfo();
        System.out.println(s9.ring());
        System.out.println(s9.unlock());
    }
}