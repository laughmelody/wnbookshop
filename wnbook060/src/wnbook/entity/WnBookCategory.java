package wnbook.entity;

import java.util.Date;
import java.util.List;

public class WnBookCategory {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String typeName;
    private Date gmtCreate;
    private Date gmtModified;
    private Boolean isDelete;
    //这个list代表当前目录下有哪些书籍
    private List<WnBook> list;
    public WnBookCategory(Integer id, String typeName) {
        this.id = id;
        this.typeName = typeName;
    }

    public WnBookCategory(Integer id, String typeName, Date gmtModified) {
        this.id = id;
        this.typeName = typeName;
        this.gmtModified = gmtModified;
    }

    public WnBookCategory(Integer id, String typeName, Date gmtCreate, Date gmtModified, Boolean isDelete) {
        this.id = id;
        this.typeName = typeName;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.isDelete = isDelete;
    }

    public WnBookCategory(String typeName, Date gmtCreate, Date gmtModified, Boolean isDelete) {
        this.typeName = typeName;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.isDelete = isDelete;
    }

    public WnBookCategory() {
    }

    public WnBookCategory(Integer id) {
        this.id = id;
    }

    public WnBookCategory(String typeName) {
        this.typeName = typeName;
    }

    public List<WnBook> getList() {
        return list;
    }

    public void setList(List<WnBook> list) {
        this.list = list;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }

    @Override
    public String toString() {
        return "WnBookCategory{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", isDelete=" + isDelete +
                '}';
    }
}
