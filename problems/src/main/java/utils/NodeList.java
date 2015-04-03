package utils;

/**
 * Created by baathreya on 4/3/15.
 */
public class NodeList {

    private Node head;

    public NodeList(Node head){
        setHead(head);
    }
    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    @Override
    public String toString(){
        if(head == null){
            return "empty list";
        }
        Node node = head;
        StringBuilder builder = new StringBuilder();
        while (node != null){
            builder.append(node.getValue()).append(", ");
            node = node.getNext();
        }
        return builder.toString();
    }
}
