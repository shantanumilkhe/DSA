package Graph.Topological;

import java.util.*;

public class alienDict {

    public static void kahn(int V,  ArrayList<ArrayList<Integer>> adj){
        int[] inDegree = new int[V];

        for (ArrayList<Integer> integers : adj) {
            for (int a : integers) {
                inDegree[a]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i =0; i<V; i++){
            if(inDegree[i] ==0){
                q.add(i);
            }
        }

        int[] sort = new int[V];
        int k =0;

        while(!q.isEmpty()){
            int node = q.poll();
            sort[k++]= node;

            for(int a : adj.get(node)){
                inDegree[a]--;
                if(inDegree[a]==0) q.add(a);
            }
        }

        for(int a: sort){
            char ans = (char) (a + 'a');
            System.out.println(ans+ " ");
        }
    }

    public static void alien(int n, int k, String[] dict){

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0; i<k; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 1; i<dict.length; i++){
            String s1 = dict[i-1];
            String s2 = dict[i];
            int len = Math.min(s1.length(), s2.length());
            for(int j =0; j<len; j++){
                if(s1.charAt(j)!=s2.charAt(j)){
                    adj.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');
                    break;
                }
            }
        }

        kahn(k, adj);
    }
    public static void main(String[] args) {
        long startTime = System.nanoTime();


        String[] dict = {"baa", "abcd", "abca", "cab", "cad"};
        int n = dict.length;
        int k = 4;

        alien(n, k ,dict);

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
