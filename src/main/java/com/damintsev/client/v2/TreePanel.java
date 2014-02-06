package com.damintsev.client.v2;

import com.damintsev.common.entity.TreeItem;
import com.damintsev.common.utils.AvalueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.TreeStore;
import com.sencha.gxt.widget.core.client.tree.Tree;
import com.sencha.gxt.widget.core.client.treegrid.TreeGrid;

/**
 * User: adamintsev
 * Date: 06.02.14
 * //todo написать комментарии
 */
public class TreePanel<T extends TreeItem> {

    Tree<T, String> tree;

    public TreePanel() {
        TreeStore<T> treeStore = new TreeStore<T>(new ModelKeyProvider<T>() {
            @Override
            public String getKey(T item) {
                return item.getId().toString();
            }
        });
        tree = new Tree<T, String>(treeStore, new AvalueProvider<T, String>() {
            @Override
            public String getValue(T object) {
                return object.getName();
            }
        });
    }
}
