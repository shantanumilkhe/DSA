package Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node{
    int data;
    Node left;
    Node right;


    public Node(int key){
        this.data = key;
    }
    public Node(int key, Node left, Node right){
        this.data = key;
        this.left =left;
        this.right=right;
    }


    public void inOrder(Node node){
        if(node==null) return;

        inOrder(node.left);
        System.out.println(node.data);
        inOrder(node.right);
    }

    public void preOrder(Node node){
        if(node==null) return;

        System.out.println(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void postOrder(Node node){
        if(node==null) return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.data);
    }

    public List<List<Integer>> levelOrder(Node node){

        Queue<Node> q = new LinkedList<>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        if(node==null) return wrapList;
        q.offer(node);

        while(!q.isEmpty()){

            int level = q.size();
            List<Integer> subList = new LinkedList<>();
            for(int i =0; i<level; i++) {
                if (q.peek().left != null) q.offer(q.peek().left);
                if (q.peek().right != null) q.offer(q.peek().right);
                subList.add(q.poll().data);
            }
            wrapList.add(subList);
        }
        return wrapList;
    }



}
public class BinaryTree {
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        // Write your code here

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
