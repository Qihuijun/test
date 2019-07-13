public class ttt {
      public static void main(String args[]){
          int a[]={5,4,3,2,1};
          int n;
          //外层循环控制排序趟数 　5 0,1,2,3 3,2,1,0
          for (int i=0;i<a.length;i++){
              //内层循环控制每一趟排序多少次
              for (int j=0;j<a.length-1;j++){
                  if (a[j+1]<a[j]){
                     n= a[j];
                     a[j]=a[j+1];
                     a[j+1]=n;
                  }
              }
          }
          for (int i=0;i<a.length;i++){
              System.out.println(a[i]);
          }
            }
  }
