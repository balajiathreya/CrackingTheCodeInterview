package chapter2;

import utils.Node;
import utils.NodeList;

/**
 * Created by baathreya on 6/3/15.
 *
 * Implement an algorithm to delete a node in the middle of a single linked list, given only access to that node.
 EXAMPLE
 Input: the node ‘c’ from the linked list a->b->c->d->e
 Result: nothing is returned, but the new linked list looks like a->b->d->e
 */

public class NodeDeletion {

    private NodeList nodeList;

    public static void main(String[] args) {
        NodeDeletion nodeDeletion = new NodeDeletion();
        nodeDeletion.nodeList = makeList();
        System.out.println("=====");
        nodeDeletion.printList();
        System.out.println("=====");
        Node nodeToRemove = nodeDeletion.getNode(12);
        System.out.println("removing 12");
        nodeDeletion.removeNode(nodeToRemove);
        nodeDeletion.printList();
        nodeToRemove = nodeDeletion.getNode(10);
        System.out.println("removing 10");
        nodeDeletion.removeNode(nodeToRemove);
        nodeDeletion.printList();
        System.out.println("removing 19");
        nodeToRemove = nodeDeletion.getNode(19);
        nodeDeletion.removeNode(nodeToRemove);
        nodeDeletion.printList();
        System.out.println("removing 1");
        nodeToRemove = nodeDeletion.getNode(1);
        nodeDeletion.removeNode(nodeToRemove);
        nodeDeletion.printList();
    }

    private void printList(){
        Node root = nodeList.getHead();
        while (root != null){
            System.out.print(root.getValue()+" ");
            root = root.getNext();
        }
        System.out.println();
    }



    public void removeNode(Node node) {
        if(node.getNext() == null){
            System.out.println("Sorry, can't remove last element");
            return;
        }
        while (true){
            Node next = node.getNext();
            if(next == null){
                return;
            }
            else if(next.getNext() == null){
                int val = next.getValue();
                node.setValue(val);
                node.setNext(null);
                return;
            }
            else {
                int val = next.getValue();
                node.setValue(val);
                node = next;
            }
        }
    }


    private static NodeList makeList(){
        Node root = new Node(1,null);
        NodeList list = new NodeList(root);
        Node prev = list.getHead();
        for(int i = 2; i < 20; i++){
            Node node = new Node(i,null);
            prev.setNext(node);
            prev = node;
        }
        return list;
    }

    private Node getNode(int value){
        Node root = nodeList.getHead();
        while (root != null){
            if(root.getValue() == value){
                return root;
            }
            else {
                root = root.getNext();
            }
        }
        return null;
    }

}
