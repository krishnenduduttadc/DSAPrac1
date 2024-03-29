package GenericTreeL1;

import java.util.ArrayList;
import java.util.Stack;

public class KthLargest {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void display(Node node) {
        String str = node.data + " -> ";
        for (Node child : node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node child : node.children) {
            display(child);
        }
    }

    public static Node construct(int[] arr) {
        Node root = null;

        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];

                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }

                st.push(t);
            }
        }

        return root;
    }


    static int ceil;
    static int floor;
    public static void ceilAndFloor(Node node, int data) {
        // Write your code here
        if(node.data>data){
            if(node.data<ceil){
                ceil=node.data;
            }
        }

        if(node.data<data){
            if(node.data>floor){
                floor=node.data;
            }
        }

        for(Node child:node.children){
            ceilAndFloor(child,data);
        }
    }

    static int kthlargest(Node node,int k){
        floor=Integer.MIN_VALUE;
        int factor=Integer.MAX_VALUE;
        for(int i=0;i<k;i++){
            ceilAndFloor(node,factor);
            factor=floor;
            floor=Integer.MIN_VALUE;
        }
        return factor;
    }

    public static void main(String[] args) throws Exception {
        int[] arr = {24, 10, 20, -50, -1, 60, -1, -1, 30, 70, -1, -80, 110, -1, -120, -1, -1, 90, -1, -1, 40, -100, -1, -1, -1};


        int data = 8;
        Node root = construct(arr);

        System.out.println(kthlargest(root,data));
    }
}
/*
24
10 20 -50 -1 60 -1 -1 30 70 -1 -80 110 -1 -120 -1 -1 90 -1 -1 40 -100 -1 -1 -1
8
 */
