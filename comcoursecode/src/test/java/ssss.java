import java.text.DecimalFormat;
public class ssss {

    public static void main(String args[]){
    DecimalFormat f = new DecimalFormat("0000");
    int a= 1;
    String str = f.format(a);
    System.out.println(str);}
}
