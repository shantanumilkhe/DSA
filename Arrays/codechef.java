package Arrays;/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static void main (String[] args) throws java.lang.Exception
    {
        try {
            Scanner sc = new Scanner(System.in);
            int t=sc.nextInt();
            while(t-->0)
            {
                int n = sc.nextInt();
                String bin = sc.next();
                char[] arr = bin.toCharArray();
                int count0 = 0;
                int count1 =0;
                for (int i=0;i<n ; i++ ){
                    if(arr[i]=='1') count1++;
                    else count0++;
                }
                System.out.println(count0+" "+count1);
                if(count0==n){
                    System.out.println(0);
                }else if(
                        count1==n) {
                    System.out.println(1);
                } else System.out.println(count1);




            }

        } catch(Exception e) {
            return;
        }
    }
}
