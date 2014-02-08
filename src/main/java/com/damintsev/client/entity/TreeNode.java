package com.damintsev.client.entity;

import com.google.gwt.user.client.rpc.IsSerializable;

import java.util.ArrayList;
import java.util.List;

/**
* User: adamintsev
* Date: 05.02.14
* //todo написать комментарии
*/
public class TreeNode<T extends TreeItem> implements IsSerializable {

    private T data;
    private List<TreeNode<T>> children;

    public TreeNode() {
    }

    public TreeNode(T data) {
        this.data = data;
        children = new ArrayList<TreeNode<T>>();
    }

    public boolean haveChildren() {
        return children.size() > 0;
    }

    public List<TreeNode<T>> getChildren() {
        return children;
    }

    public T getData() {
        return data;
    }

    public void appendChildren(TreeNode<T> treeItem) {
        children.add(treeItem);
    }
}
//public class TreeNode implements TreeStore.TreeNode, IsSerializable {
//
//    private TreeItem data;
//    private List<TreeNode> children;
//
//    public TreeNode() {
//    }
//
//    public TreeNode(TreeItem data) {
//        this.data = data;
//        children = new ArrayList<>();
//    }
//
//    @Override
//    public List<? extends TreeStore.TreeNode<TreeItem>> getChildren() {
//        return children;
//    }
//
//    @Override
//    public TreeItem getData() {
//        return data;
//    }
//
//    public void appendChildren(TreeNode treeItem) {
//        children.add(treeItem);
//    }
//}
