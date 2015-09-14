package chapter4;

import misc.BreadthFirstSearch;
import utils.TreeNode;

import java.util.*;

/**
 * Created by baathreya on 9/9/15.
 *
 * Implement a function to check if a tree is balanced. For the purposes of this question, a balanced tree is defined
 * to be a tree such that no two leaf nodes differ in distance from the root by more than one.
 *
 */

public class CheckForBalancedTree extends BreadthFirstSearch{

    private int currentDepth;
    private Set<Integer> depths = new HashSet<Integer>();

    public static void main(String[] args) {
        TreeNode root = buildSampleTree();
        List<TreeNode> nodes = new ArrayList<TreeNode>();
        nodes.add(root);
        CheckForBalancedTree breadthFirstSearch = new CheckForBalancedTree();
        breadthFirstSearch.search(nodes);
    }

    @Override
    protected void search(List<TreeNode> nodes) {
        if(nodes == null || nodes.size() == 0) {
            return;
        }
        else {
            List<TreeNode> newNodes = new ArrayList<TreeNode>();
            for(TreeNode node : nodes) {
                if(node != null) {
                    processNode(node);
                    if(node.getChildren() != null && node.getChildren().size() != 0){
                        newNodes.addAll(node.getChildren());
                    }
                    else {
                        if(!depths.contains(currentDepth)) {
                            depths.add(currentDepth);
                        }

                        if(depths.size() ==  3) {
                            System.out.println("Tree is not balanced");
                            System.out.println(depths);
                            System.exit(0);
                        }
                    }
                }
            }
            currentDepth++;
            search(newNodes);
        }
    }

    @Override
    protected void processNode(TreeNode node){
        node.setDepth(currentDepth);
        System.out.println(node.getValue() +" has depth " + currentDepth);
    }

}
