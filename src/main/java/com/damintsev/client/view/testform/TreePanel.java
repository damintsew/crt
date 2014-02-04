package com.damintsev.client.view.testform;

import com.google.gwt.user.client.ui.Composite;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.TabItemConfig;
import com.sencha.gxt.widget.core.client.TabPanel;

/**
 * @author Damintsev Andrey
 *         04.02.14.
 */
public class TreePanel extends Composite {

    public TreePanel() {
        TabPanel panel = new TabPanel();
        TabItemConfig config = new TabItemConfig();
        config.setText("Ответф");
        panel.add(new ContentPanel(), config);

        config = new TabItemConfig("Сущности");
        panel.add(new ContentPanel(), config);

        initWidget(panel);
    }
}
