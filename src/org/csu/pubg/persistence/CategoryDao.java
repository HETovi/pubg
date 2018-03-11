package org.csu.pubg.persistence;

import org.csu.pubg.domain.Category;

import java.util.*;

/**
 * Created by Tovi on 2017/9/19.
 */
public interface CategoryDao {
//查询出所有的最大分类Id
    List<String> findAllCategoriesId();
//查询出所有的最大分类信息（以list返回）
    List<Category> getCategoryList();
    // 通过categoryID获取category
    Category getCategoryBycategoryId(int categoryId);
    //通过parentID获取category，结果返回list集
    List<Category> getCategoryListByParentId(String parentId);
}
