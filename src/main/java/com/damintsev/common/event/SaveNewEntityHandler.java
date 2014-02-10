package com.damintsev.common.event;

import com.google.gwt.event.shared.EventHandler;

/**
 * @author Damintsev Andrey
 *         09.02.14.
 */
public interface SaveNewEntityHandler extends EventHandler {

    void onEvent(SaveNewEntityEvent event);
}
