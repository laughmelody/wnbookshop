//package wnbook.service.imp;
//
//import wnbook.dao.imp.WnBookCategoryDaoImp;
//import wnbook.entity.WnBookCategory;
//import wnbook.service.WnBookCategoryService;
//import wnbook.util.DbHelper;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Timestamp;
//import java.util.ArrayList;
//import java.util.List;
//
//public class WnBookCategoryServiceImp副本 implements WnBookCategoryService {
//    private WnBookCategoryDaoImp wnBookCategoryDaoImp;
//    public WnBookCategoryServiceImp副本(){
//        wnBookCategoryDaoImp = new WnBookCategoryDaoImp();
//    }
//    @Override
//    public WnBookCategory findCategoryByName(String name) {
//        return null;
//    }
//
//    @Override
//    public int addCategory(WnBookCategory cate) {
//        return 0;
//    }
//
//    @Override
//    public int modifyCategory(WnBookCategory category) {
//        return 0;
//    }
//
//    @Override
//    public int removeWnBookCategoryById(int id) {
//        return 0;
//    }
//
//    @Override
//    public List<WnBookCategory> findAllCategory() {
//        ArrayList<WnBookCategory> list = new ArrayList<WnBookCategory>();
//        Connection conn = DbHelper.getConnection();
//        try {
//            ResultSet set = wnBookCategoryDaoImp.selectAllCategory(conn);
//            while (set.next()){
//                int id = set.getInt("id");
//                String typeName = set.getString("type_name");
//                Timestamp gmtCreate = set.getTimestamp("gmt_create");
//                Timestamp gmtModified = set.getTimestamp("gmt_modified");
//                boolean isDelete = set.getInt("is_delete")>0?true:false;
//                list.add(new WnBookCategory(id,typeName,gmtCreate,gmtModified,isDelete));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            wnBookCategoryDaoImp.closeAll();
//        }
//        return list;
//    }
//
//    @Override
//    public WnBookCategory findCategoryById(int id) {
//        return null;
//    }
//}
