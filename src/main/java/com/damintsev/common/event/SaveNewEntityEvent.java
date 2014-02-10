package com.damintsev.common.event;

import com.damintsev.common.entity.TreeItem;
import com.google.gwt.event.shared.GwtEvent;

/**
 * @author Damintsev Andrey
 *         09.02.14.
 */
public class SaveNewEntityEvent extends GwtEvent<SaveNewEntityHandler> {

    public static GwtEvent.Type<SaveNewEntityHandler> TYPE = new GwtEvent.Type<SaveNewEntityHandler>();

    private TreeItem item;

    public SaveNewEntityEvent(TreeItem item) {
        this.item = item;
    }

    @Override
    public Type<SaveNewEntityHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(SaveNewEntityHandler handler) {
        handler.onEvent(this);
    }

    public TreeItem getItem() {
        return item;
    }
}
