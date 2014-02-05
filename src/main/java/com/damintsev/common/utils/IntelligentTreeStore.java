package com.damintsev.common.utils;

import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.TreeStore;

import java.util.List;

/**
 * Умный TreeStore, имеющий метод append, который сам умеет определять родителя и добавлять в нему детеныйшей
 * @param <M> - модель
 */
public class IntelligentTreeStore<M> extends TreeStore<M> {

    private Intell<M> intell;

    /**
     * Creates a tree store with the given key provider. The key provider is
     * responsible for returning a unique key for a given model
     *
     * @param keyProvider the key provider
     */
    public IntelligentTreeStore(ModelKeyProvider<? super M> keyProvider, Intell<M> intell) {
        super(keyProvider);
        this.intell = intell;
    }

    public void append(M item) {
        if(findModel(item) != null) return;
        M parent = intell.getParent(item);
        if(parent == null) add(item);
        else {
            if(findModel(parent) == null ){
                append(parent);
            }
            add(parent, item);
        }
    }

    public void appendAll(List<M> items) {
        for(M item : items) {
            append(item);
        }
    }

    public void update(M item) {
        remove(item);
        append(item);
    }
}
