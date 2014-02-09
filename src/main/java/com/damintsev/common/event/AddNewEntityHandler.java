package com.damintsev.common.event;

import com.google.gwt.event.shared.EventHandler;

/**
 * @author Damintsev Andrey
 *         09.02.14.
 */
public interface AddNewEntityHandler extends EventHandler {

    void onEvent(AddNewEntityEvent event);
}
