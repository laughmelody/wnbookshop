package wnbook.service;

import com.github.pagehelper.Page;
import wnbook.entity.WnBookCategory;

import java.util.List;

public interface WnBookCategoryService {

    WnBookCategory findCategoryByName(String name);

    Page<WnBookCategory> findAllCategory(int offset, int limit);
    List<WnBookCategory> selectAll();
    WnBookCategory findCategoryById(int id);

    int addCategory( WnBookCategory category);

    int modifyCategory(WnBookCategory category);

    int removeWnBookCategoryById(int id);
}
