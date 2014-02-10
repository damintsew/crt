package com.damintsev.common.utils;

import com.damintsev.common.entity.TreeItem;
import com.google.gwt.user.client.rpc.IsSerializable;

import java.util.ArrayList;
import java.util.List;

/**
* User: adamintsev
* Date: 05.02.14
*/

/**
 * Class uses in trees. Represents root node and his child's.
 * @param <T>
 */
public class TreeNode<T extends TreeItem> implements IsSerializable {

    private T data;
    private List<TreeNode<T>> children;

    public TreeNode() {
    }

    /**
     * @param data - root node
     */
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

    /**
     * Returns root element
     * @return
     */
    public T getData() {
        return data;
    }

    /**
     * Append child
     * @param treeItem
     */
    public void appendChildren(TreeNode<T> treeItem) {
        children.add(treeItem);
    }
}