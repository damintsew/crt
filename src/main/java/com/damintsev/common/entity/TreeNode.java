//package com.damintsev.common.entity;
//
//import com.google.gwt.user.client.rpc.IsSerializable;
//import com.sencha.gxt.data.shared.TreeStore;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * User: adamintsev
// * Date: 05.02.14
// * //todo написать комментарии
// */
////public class TreeNode<T extends TreeStore.TreeNode<V>, V> implements TreeStore.TreeNode<V>, IsSerializable {
////
////    private V data;
////    private List<TreeNode<T,V>> children;
////
////    public TreeNode() {
////    }
////
////    public TreeNode(V data) {
////        this.data = data;
////        children = new ArrayList<TreeNode<T,V>>();
////    }
////
////    @Override
////    public List<? extends TreeStore.TreeNode<V>> getChildren() {
////        return children;
////    }
////
////    @Override
////    public V getData() {
////        return data;
////    }
////
////    public void appendChildren(TreeNode<T,V> treeItem) {
////        children.add(treeItem);
////    }
////}
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
