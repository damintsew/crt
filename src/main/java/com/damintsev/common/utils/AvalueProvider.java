package com.damintsev.common.utils;

import com.sencha.gxt.core.client.ValueProvider;

/**
 * User: adamintsev
 * Date: 04.02.14
 * Default ValueProvider to reduce code
 */
public abstract class AvalueProvider<T, V> implements ValueProvider<T, V> {

    private String name;

    protected AvalueProvider() {
        this("name");
    }

    protected AvalueProvider(String name) {
        this.name = name;
    }

    @Override
    public abstract V getValue(T object);

    @Override
    public void setValue(T object, V value) {
    }

    @Override
    public String getPath() {
        return name;
    }
}
