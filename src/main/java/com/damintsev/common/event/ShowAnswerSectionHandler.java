package com.damintsev.common.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

/**
 * @author Damintsev Andrey
 *         04.02.14.
 */
public interface ShowAnswerSectionHandler extends EventHandler {

    void onShow(ShowAnswerSectionEvent event);
}
