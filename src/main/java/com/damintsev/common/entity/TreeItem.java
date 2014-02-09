package com.damintsev.common.entity;

import com.google.gwt.user.client.rpc.IsSerializable;

import java.io.Serializable;

/**
 * User: adamintsev
 * Date: 04.02.14
 * //todo написать комментарии
 */
public interface TreeItem extends IsSerializable {

    Long getId();

    String getStringId();

    String getName();

}
