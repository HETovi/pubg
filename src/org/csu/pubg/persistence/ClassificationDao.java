package org.csu.pubg.persistence;

import org.csu.pubg.domain.Classification;

import java.util.List;

/**
 * Created by liulin on 2017/9/21.
 */
public interface ClassificationDao {
    List<Integer> getItemIdByCategoryId(int categoryid);
    List<Classification> getClassByItemId(int id);
    boolean addClassification(Classification classification);
}
