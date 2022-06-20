package wnbook.entity;

import java.util.Date;

public class WnBookAdmin {
    private Integer id;
    private String username;
    private String password;
    private String tel;
    private Date gmtCreate;
    private Date gmtModified;
    private Integer isDelete;

    public WnBookAdmin(Integer id, String username, String password, String tel, Date gmtCreate, Date gmtModified, Integer isDelete) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.tel = tel;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.isDelete = isDelete;
    }

    public WnBookAdmin(String username, String password,String tel, Date gmtCreate, Date gmtModified, Integer isDelete) {
        this.username = username;
        this.password = password;
        this.tel = tel;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.isDelete = isDelete;
    }

    public WnBookAdmin() {
    }

    public WnBookAdmin(int id, String username, String password, String tel) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.tel = tel;
    }

    public WnBookAdmin(String username, String password, String tel) {
        this.username = username;
        this.password = password;
        this.tel = tel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "WnBookAdmin{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", tel=" + tel +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", isDelete=" + isDelete +
                '}';
    }
}
