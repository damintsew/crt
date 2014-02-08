package com.damintsev.server.logic;

/**
 * User: adamintsev
 * Date: 05.02.14
 */

import com.damintsev.common.entity.*;

import java.util.List;

/**
 * BusinessLayer layer
 */
public interface BusinessLayer {

    /**
     * Return list of all Topics entities
     * @return
     */
    List<TreeNode<TreeItem>> getListTreeItems();

    /**
     * Return Ansewr entity bi his Id
     * @param asnwerId
     * @return
     */
    Answer getAnswerById(Long asnwerId);

    List<EntityAnswer> getEntitiesByAnswerId(Long asnwerId);
}
