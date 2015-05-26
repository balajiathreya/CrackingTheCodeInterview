package chapter2;

import utils.Node;
import utils.NodeList;

import java.util.Stack;

/**
 * Created by baathreya on 4/10/15.
 *
 * Implement an algorithm to find the nth to last element of a singly linked list.
 *
 */
public class NthElementInAList {

    NodeList list;


    public static void main(String[] args) {
        NthElementInAList nthElementInAList = new NthElementInAList(getAList());
        nthElementInAList.getNthElementWithStack(3);
        nthElementInAList.getNthElementWithStack(2);
        nthElementInAList.getNthElementWithStack(0);
    }

    public NthElementInAList(NodeList list){
        this.list = list;
    }

    private void getNthElement(int n){
        int index = n;
        Node head = list.getHead();
        Node p1  = head;
        Node p2  = head;
        while (index != 0){
            Node next = p2.getNext();
            if(next == null){
                System.out.println("invalid n");
            }
            else {
                p2 = next;
            }
            index--;
        }
    }

    private void getNthElementWithStack(int n){
        Stack<Node> stack = new Stack<Node>();
        fillStack(stack);
        System.out.println("getting element at position "+ n +" from the last");
        int index = stack.size() - n;
        System.out.println("so looking for index: "+ index);
        if(n <= 0){
            System.out.println("invalid n: "+ n);
        }
        else {
            int i = stack.size() - 1;
            while (i > index){
                i--;
                stack.pop();
            }
            System.out.println(stack.pop().getValue());;
        }
    }

    private void fillStack(Stack<Node> stack){
        Node node = list.getHead();
        while (node != null){
            stack.push(node);
            node = node.getNext();
        }
    }

    private static NodeList getAList(){
        Node root = new Node(1,null);
        Node n1 = new Node(2, null);
        Node n2 = new Node(14, null);
        Node n3 = new Node(64, null);
        Node n4 = new Node(12, null);
        Node n5 = new Node(140, null);
        root.setNext(n1);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        NodeList list = new NodeList(root);
        System.out.println(list);
        return list;
    }
}
