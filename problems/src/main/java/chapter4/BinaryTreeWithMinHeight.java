package chapter4;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baathreya on 9/13/15.
 *
 * Given a sorted (increasing order) array, write an algorithm to create a binary tree with minimal height.
 */
public class BinaryTreeWithMinHeight {

    public static void main(String[] args) {
        BinaryTreeWithMinHeight binaryTreeWithMinHeight = new BinaryTreeWithMinHeight();
        int[] arr1 =  {1,2,3,4,5,6};
        int[] arr2 =  {1,2,3,4,5};
        int[] arr3 = {1,2,3};
        TreeNode node1 = binaryTreeWithMinHeight.buildTree(arr1);
        TreeNode node2 = binaryTreeWithMinHeight.buildTree(arr2);
        TreeNode node3 = binaryTreeWithMinHeight.buildTree(arr3);
        System.out.println();
    }


    protected TreeNode buildTree(int[] array) {
        if(array.length == 0) {
            return null;
        }
        else if(array.length == 1){
            TreeNode node = new TreeNode();
            node.setValue(array[0]);
            return node;
        }
        else if(array.length == 2) {
            TreeNode node1 = new TreeNode();
            TreeNode node2 = new TreeNode();
            int i = array[0];
            int j = array[1];
            node1.setValue(i);
            node2.setValue(j);
            List<TreeNode> children = new ArrayList<TreeNode>();
            children.add(node2);
            node1.setChildren(children);
            return node1;
        }
        else {
            int median = (int) Math.floor(array.length/2);
            TreeNode node = new TreeNode();
            node.setValue(array[median]);
            int[] leftArr =getLeftArr(array, median - 1);
            int[] rightArr = getRightArr(array, median + 1);
            TreeNode leftNode = buildTree(leftArr);
            TreeNode rightNode = buildTree(rightArr);
            node.addAllChildren(leftNode,rightNode);
            return node;
        }


    }

    protected int[] getLeftArr(int[] array, int endIndex) {
        int[] arr = new int[endIndex + 1];
        System.arraycopy(array, 0, arr, 0, arr.length);
        return arr;
    }

    protected int[] getRightArr(int[] array, int startIndex) {
        int[] arr = new int[array.length - startIndex];
        System.arraycopy(array, startIndex, arr, 0, arr.length);
        return arr;
    }


}
