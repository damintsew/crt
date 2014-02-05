package com.damintsev.common.entity;

import com.damintsev.common.utils.Intell;
import com.google.gwt.user.client.rpc.IsSerializable;
import com.sencha.gxt.data.shared.PropertyAccess;

/**
 * User: adamintsev
 * Date: 04.02.14
 * //todo написать комментарии
 */
public interface TreeItem extends IsSerializable{

    Long getId();

    String getName();

}
