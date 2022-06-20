package wnbook.entity;

import java.util.Date;

public class WnBookUser {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String username;
    private String password;
    private String avatar;
    private String gender;
    private String tel;
    private String email;
    private Integer status;
    private Date gmtCreate;
    private Date gmtModified;
    private boolean isDelete;
    private Date lastLoginTime;

    public WnBookUser(String username, String password, String avatar, String gender, String tel, String email, Integer status, Date gmtCreate, Date gmtModified, boolean isDelete, Date lastLoginTime) {
        this.username = username;
        this.password = password;
        this.avatar = avatar;
        this.gender = gender;
        this.tel = tel;
        this.email = email;
        this.status = status;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.isDelete = isDelete;
        this.lastLoginTime = lastLoginTime;
    }

    public WnBookUser(Integer id, String username, String password, String avatar, String gender, String tel, String email, Integer status, Date gmtCreate, Date gmtModified, boolean isDelete, Date lastLoginTime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.avatar = avatar;
        this.gender = gender;
        this.tel = tel;
        this.email = email;
        this.status = status;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.isDelete = isDelete;
        this.lastLoginTime = lastLoginTime;
    }

    public WnBookUser() {
    }

    public WnBookUser(String username, String password) {
        this.username=username;
        this.password=password;
    }

    public WnBookUser(int id, String username, String password) {
        this.password = password;
        this.id = id;
        this.username = username;
    }

    public WnBookUser(String username, String password, String tel) {
        this.username = username;
        this.password = password;
        this.tel = tel;
    }

    public WnBookUser(Integer id, String username, String password, String tel) {
        this.id = id;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    @Override
    public String toString() {
        return "WnBookUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", avatar='" + avatar + '\'' +
                ", gender='" + gender + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", isDelete=" + isDelete +
                ", lastLoginTime=" + lastLoginTime +
                '}';
    }
}
