package com.damintsev.common.event;

import com.google.gwt.event.shared.GwtEvent;

/**
 * User: adamintsev
 * Date: 11.02.14
 * //todo написать комментарии
 */
public class ShowAnswerTreeMenuEvent extends GwtEvent<ShowAnswerTreeMenuHandler> {

    public final static Type<ShowAnswerTreeMenuHandler> TYPE = new Type<ShowAnswerTreeMenuHandler>();

    @Override
    public Type<ShowAnswerTreeMenuHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(ShowAnswerTreeMenuHandler handler) {
        handler.onEvent(this);
    }
}
