package misc;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baathreya on 9/13/15.
 */
public class BreadthFirstSearch {

    protected TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    protected void processNode(TreeNode node){
        System.out.println(node.getValue());
    }

    public static void main(String[] args) {
        TreeNode root = buildSampleTree();
        List<TreeNode> nodes = new ArrayList<TreeNode>();
        nodes.add(root);
        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();
        breadthFirstSearch.search(nodes);
    }

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
                }
            }
            search(newNodes);
        }
    }



    protected static TreeNode buildSampleTree(){
        TreeNode root = new TreeNode();
        root.setValue(1);
        TreeNode lRoot = new TreeNode();
        TreeNode rRoot = new TreeNode();
        lRoot.setValue(2);
        rRoot.setValue(3);
        root.addAllChildren(lRoot, rRoot);
        TreeNode llRoot = new TreeNode();
        TreeNode lrRoot = new TreeNode();
        llRoot.setValue(4);
        lrRoot.setValue(5);
        lRoot.addAllChildren(llRoot, lrRoot);
        TreeNode rlRoot = new TreeNode();
        TreeNode rrRoot = new TreeNode();
        rlRoot.setValue(6);
        rrRoot.setValue(7);
        lRoot.addAllChildren(rlRoot, rrRoot);
        TreeNode llrRoot = new TreeNode();
        TreeNode rrlRoot = new TreeNode();
        llrRoot.setValue(8);
        rrlRoot.setValue(9);
        llRoot.addAllChildren(llrRoot);
        rrRoot.addAllChildren(rrlRoot);
        return root;
    }

}
