package com.damintsev.common.entity;

import com.google.gwt.user.client.rpc.IsSerializable;

import java.io.Serializable;

/**
 * User: adamintsev
 * Date: 04.02.14
 */

/**
 * Interface uses in Trees
 */
public interface TreeItem extends IsSerializable {

    /**
     * Long Id
     * @return
     */
    Long getId();

    /**
     * Returns Class.getName() + getId(). To set unique Id in the Trees
     * @return
     */
    String getStringId();

    /**
     * Return name to display in Tree
     * @return
     */
    String getName();

}
