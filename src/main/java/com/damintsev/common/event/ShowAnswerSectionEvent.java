package com.damintsev.common.event;

import com.google.gwt.event.shared.GwtEvent;

/**
 * @author Damintsev Andrey
 *         04.02.14.
 */
public class ShowAnswerSectionEvent extends GwtEvent<ShowAnswerSectionHandler> {

    public static GwtEvent.Type<ShowAnswerSectionHandler> TYPE = new GwtEvent.Type<ShowAnswerSectionHandler>();

    private Long answerId;

    public ShowAnswerSectionEvent(Long answerId) {
        this.answerId = answerId;
    }

    @Override
    public Type<ShowAnswerSectionHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(ShowAnswerSectionHandler handler) {
        handler.onShow(this);
    }

    public Long getAnswerId() {
        return answerId;
    }
}
