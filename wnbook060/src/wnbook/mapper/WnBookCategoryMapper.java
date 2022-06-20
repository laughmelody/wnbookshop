package wnbook.mapper;

import wnbook.entity.WnBookCategory;
import wnbook.entity.WnBookUser;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import java.util.List;

public interface WnBookCategoryMapper {
    WnBookCategory selectCategoryById(int id);
    WnBookCategory selectAllHaveList(int id);
    int insertCategory(WnBookCategory category);
    int updateCategory(WnBookCategory category);
    int deleteCategoryById(int id);
    Page<WnBookCategory> selectAllCategory();
    List<WnBookCategory> showAll();
}
