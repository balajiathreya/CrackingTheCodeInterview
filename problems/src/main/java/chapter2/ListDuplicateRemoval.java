package chapter2;

import utils.Node;
import utils.NodeList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by baathreya on 4/3/15.
 *
 * Write code to remove duplicates from an unsorted linked list.
 *
 * FOLLOW UP:
 *
 * How would you solve this problem if a temporary buffer is not allowed? 
 */
public class ListDuplicateRemoval {

    private NodeList nodeList;

    public NodeList getNodeList() {
        return nodeList;
    }

    public void setNodeList(NodeList nodeList) {
        this.nodeList = nodeList;
    }

    public ListDuplicateRemoval(NodeList list){
        setNodeList(list);
    }

    public static void main(String[] args) {
        ListDuplicateRemoval duplicateList = new ListDuplicateRemoval(makeListWithOneDuplicate());
        duplicateList.removeDuplicatesWithBuffer();
        duplicateList.removeDuplicatesWithoutBuffer();
        duplicateList = new ListDuplicateRemoval(makeListWithNoDuplicate());
        duplicateList.removeDuplicatesWithBuffer();
        duplicateList.removeDuplicatesWithoutBuffer();
        duplicateList = new ListDuplicateRemoval(makeListWithManyDuplicate());
        duplicateList.removeDuplicatesWithBuffer();
        duplicateList.removeDuplicatesWithoutBuffer();
        duplicateList = new ListDuplicateRemoval(makeListWithManyDuplicateInMiddle());
        duplicateList.removeDuplicatesWithBuffer();
        duplicateList.removeDuplicatesWithoutBuffer();
    }

    private void removeDuplicatesWithBuffer(){
        Set<Integer> set = new HashSet<Integer>();
        Node node = nodeList.getHead();
        Node prev = null;
        if(node.getNext() == null){
            return;
        }
        while (node != null){
            int val = node.getValue();
            if(set.contains(Integer.valueOf(val))){
                Node next = node.getNext();
                prev.setNext(next);
                node = next;
            }
            else{
                set.add(Integer.valueOf(val));
                prev = node;
                node = node.getNext();
            }
        }
        System.out.println("withBuffer: " + getNodeList());

    }

    private void removeDuplicatesWithoutBuffer(){
        Node head = nodeList.getHead();
        Node current = head.getNext();
        Node runner = null;
        Node prev = current;
        if(current == null){
            // do nothing
        }
        else if(head.getValue() == current.getValue()){
            head.setNext(null);
        }
        else {
            current = current.getNext();
            while (current != null){
                runner = head;
                while (runner != current) {
                    if(runner.getValue() == current.getValue()){
                        prev.setNext(runner.getNext());
                    }
                    else{
                        prev = runner;
                    }
                    runner = runner.getNext();
                }
                current = current.getNext();
            }
        }
        System.out.println("withoutBuffer: " + getNodeList());
        System.out.println();

    }


    private static NodeList makeListWithOneDuplicate(){
        Node root = new Node(1,null);
        Node n1 = new Node(2, null);
        Node n2 = new Node(4, null);
        Node n3 = new Node(6, null);
        Node n4 = new Node(2, null);
        Node n5 = new Node(10, null);
        root.setNext(n1);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        NodeList list = new NodeList(root);
        System.out.println(list);
        return list;
    }

    private static NodeList makeListWithNoDuplicate(){
        Node root = new Node(1,null);
        Node n1 = new Node(2, null);
        Node n2 = new Node(4, null);
        Node n3 = new Node(6, null);
        Node n4 = new Node(19, null);
        root.setNext(n1);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        NodeList list = new NodeList(root);
        System.out.println(list);
        return list;
    }
    private static NodeList makeListWithManyDuplicate(){
        Node root = new Node(1,null);
        Node n1 = new Node(2, null);
        Node n2 = new Node(4, null);
        Node n3 = new Node(6, null);
        Node n4 = new Node(2, null);
        Node n5 = new Node(10, null);
        Node n6 = new Node(10, null);
        Node n7 = new Node(10, null);
        root.setNext(n1);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n6);
        n6.setNext(n7);
        NodeList list =  new NodeList(root);
        System.out.println(list);
        return list;
    }
    private static NodeList makeListWithManyDuplicateInMiddle(){
        Node root = new Node(1,null);
        Node n1 = new Node(2, null);
        Node n2 = new Node(10, null);
        Node n3 = new Node(2, null);
        Node n4 = new Node(10, null);
        Node n5 = new Node(6, null);
        Node n6 = new Node(10, null);
        Node n7 = new Node(10, null);
        root.setNext(n1);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n6);
        n6.setNext(n7);
        NodeList list = new NodeList(root);
        System.out.println(list);
        return list;
    }

}
