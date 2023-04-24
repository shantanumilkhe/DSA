package leetcode;

import java.util.Stack;

class temp{
    int temp, index;
    public temp(int temp, int index){
        this.temp= temp;
         this.index = index;
    }


}
public class leet739 {

    public static void te(int[] temperatures){
        int n = temperatures.length;
        int[] output = new int[n];

        Stack<temp> st  = new Stack<>();

        for(int i =0; i<n; i++){
            if(st.isEmpty()){
                st.push(new temp(temperatures[i], i));
                continue;
            }

            int cur = temperatures[i];

            while(!st.isEmpty() && cur>st.peek().temp ){
                int sti = st.peek().index;
                st.pop();
                output[sti] = i-sti;
            }
            st.push(new temp(cur, i));
        }
        for(int a:output){
            System.out.println(a);
        }
    }
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        int[] temps = {73,74,75,71,69,72,76,73};
        te(temps);

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
