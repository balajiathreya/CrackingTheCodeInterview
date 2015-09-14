package utils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by baathreya on 9/9/15.
 */
public class TreeNode {
    private int value;
    private List<TreeNode> children = new LinkedList<TreeNode>();
    private int depth;
    private boolean visited;    // for dfs

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void addAllChildren(TreeNode... nodes){
        children.addAll(Arrays.asList(nodes));
    }

    @Override
    public String toString(){
        return ""+getValue();
    }
}
