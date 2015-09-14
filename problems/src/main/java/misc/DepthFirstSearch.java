package misc;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by baathreya on 9/13/15.
 */
public class DepthFirstSearch {

    public static void main(String[] args) {
        TreeNode root = buildSampleTree();
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
        depthFirstSearch.search(root);
    }

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

    protected void search(TreeNode node) {
        if(node == null) {
            return;
        }
        else {
            processNode(node);
            List<TreeNode> children = node.getChildren();
            for(TreeNode child : children) {
                if(!child.isVisited()) {
                    search(child);
                }
            }
            node.setVisited(true);
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
