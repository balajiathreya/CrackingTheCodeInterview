package utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baathreya on 9/13/15.
 *
 * Adjacency list
 */
public class AdjacencyListGraph {

    private List<Node> nodes = new ArrayList<Node>();

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public void addNode(Node n){
        nodes.add(n);
    }

    public static class Node {
        private int value;
        private List<Node> neighborNodes = new ArrayList<Node>();
        private boolean isVisited;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public List<Node> getNeighborNodes() {
            return neighborNodes;
        }

        public void setNeighborNodes(List<Node> neighborNodes) {
            this.neighborNodes = neighborNodes;
        }

        public boolean isVisited() {
            return isVisited;
        }

        public void setVisited(boolean isVisited) {
            this.isVisited = isVisited;
        }

        public void addNeighbor(Node node){
            neighborNodes.add(node);
        }
    }

}
