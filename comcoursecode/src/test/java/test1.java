
public class test1 {
    public static void main(String[] args) {
        String a="a,b,v,dffccccfffcvf,a,ccac";
        int n=0;
        String[] str=a.split("c");
        if (a.lastIndexOf("c")==(a.length()-1)){
            n=str.length;
        }else {n=str.length-1;}
        System.out.println(n);
    }
}
