package com.damintsev.common.event;

import com.damintsev.common.entity.TreeItem;
import com.google.gwt.event.shared.GwtEvent;

/**
 * @author Damintsev Andrey
 *         09.02.14.
 */
public class AddNewEntityEvent extends GwtEvent<AddNewEntityHandler> {

    public static Type<AddNewEntityHandler> TYPE = new Type<AddNewEntityHandler>();

    private TreeItem item;

    public AddNewEntityEvent() {
        this(null);
    }

    public AddNewEntityEvent(TreeItem item) {
        this.item = item;
    }

    @Override
    public Type<AddNewEntityHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(AddNewEntityHandler handler) {
        handler.onEvent(this);
    }

    public TreeItem getItem() {
        return item;
    }
}
