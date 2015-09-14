package chapter4;

import utils.AdjacencyListGraph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baathreya on 9/13/15.
 */
public class RoutebetweenNodes {

    public static void main(String[] args) {
        AdjacencyListGraph graph = buildGraph();
        AdjacencyListGraph.Node a = graph.getNodes().get(0);
        AdjacencyListGraph.Node b = graph.getNodes().get(1);
        AdjacencyListGraph.Node e = graph.getNodes().get(4);
        AdjacencyListGraph.Node g = graph.getNodes().get(6);
        RoutebetweenNodes routebetweenNodes = new RoutebetweenNodes();
        System.out.println(routebetweenNodes.search(a.getNeighborNodes(),e));
        clearGraph(graph);
        System.out.println(routebetweenNodes.search(e.getNeighborNodes(),a));
        clearGraph(graph);
        System.out.println(routebetweenNodes.search(g.getNeighborNodes(),a));
        clearGraph(graph);
        System.out.println(routebetweenNodes.search(g.getNeighborNodes(),e));
        clearGraph(graph);
        System.out.println(routebetweenNodes.search(g.getNeighborNodes(),b));
    }

    protected boolean search(List<AdjacencyListGraph.Node> nodes, AdjacencyListGraph.Node dest) {
        if(nodes == null || nodes.size() == 0){
            return false;
        }
        List<AdjacencyListGraph.Node> newNodes = new ArrayList<AdjacencyListGraph.Node>();
        for(AdjacencyListGraph.Node node : nodes) {
            if(dest.equals(node)){
                return true;
            }
            if(node.getNeighborNodes() != null  && !node.isVisited()) {
                newNodes.addAll(node.getNeighborNodes());
                node.setVisited(true);
            }
        }
        return search(newNodes, dest);
    }

    protected static void clearGraph(AdjacencyListGraph graph){
        for(AdjacencyListGraph.Node n : graph.getNodes()){
            n.setVisited(false);
        }
    }


    protected static AdjacencyListGraph buildGraph(){
        AdjacencyListGraph graph = new AdjacencyListGraph();
        AdjacencyListGraph.Node a = new AdjacencyListGraph.Node();
        AdjacencyListGraph.Node b = new AdjacencyListGraph.Node();
        AdjacencyListGraph.Node c = new AdjacencyListGraph.Node();
        AdjacencyListGraph.Node d = new AdjacencyListGraph.Node();
        AdjacencyListGraph.Node e = new AdjacencyListGraph.Node();
        AdjacencyListGraph.Node f = new AdjacencyListGraph.Node();
        AdjacencyListGraph.Node g = new AdjacencyListGraph.Node();
        a.addNeighbor(b);
        b.addNeighbor(c);
        c.addNeighbor(d);
        c.addNeighbor(e);
        d.addNeighbor(e);
        e.addNeighbor(f);
        g.addNeighbor(b);
        graph.addNode(a);
        graph.addNode(b);
        graph.addNode(c);
        graph.addNode(d);
        graph.addNode(e);
        graph.addNode(f);
        graph.addNode(g);
        return graph;
    }
}
