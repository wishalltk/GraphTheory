package com.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeNode {
    int id;
    TreeNode parent;
    List<TreeNode> childrenList = new ArrayList<>();

    public TreeNode(int id) {
        this.id = id;
    }

    public void addChildren(TreeNode... children){
        childrenList.addAll(Arrays.asList(children));
    }
}
