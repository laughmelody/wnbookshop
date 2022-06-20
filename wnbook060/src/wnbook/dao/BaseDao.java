package wnbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
    private Connection conn;
    private ResultSet set;
    private PreparedStatement ps;
//通用的增删改
    public int updateData(Connection conn,String sql,Object... objs) throws SQLException {
        this.conn = conn;
        this.ps = conn.prepareStatement(sql);
        for (int i = 0; i < objs.length; i++) {
            ps.setObject(i + 1, objs[i]);
        }
        return ps.executeUpdate();
    }
//通用的查方法
    public ResultSet selectData(Connection conn,String sql,Object... objs) throws SQLException {
        this.conn = conn;
        this.ps = conn.prepareStatement(sql);
        for (int i = 0;i< objs.length;i++){
            ps.setObject(i+1,objs[i]);
        }
        this.set=ps.executeQuery();
        return  this.set;
    }
    public void closeAll()  {
        if (set!=null){
            try {
                set.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("资源关闭");
    }
}
