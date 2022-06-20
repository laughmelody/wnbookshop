package wnbook.entity;

import java.util.Date;

public class WnBookCart {
    private Integer id;
    private Integer userId;
    private Integer bookId;
    private Integer buyCount;
    private Date gmtCreate;
    private Date gmtModified;
    private Integer isDelete;

    public WnBookCart(Integer id, Integer userId, Integer bookId, Integer buyCount, Date gmtCreate, Date gmtModified, Integer isDelete) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.buyCount = buyCount;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.isDelete = isDelete;
    }

    public WnBookCart(Integer userId, Integer bookId, Integer buyCount, Date gmtCreate, Date gmtModified, Integer isDelete) {
        this.userId = userId;
        this.bookId = bookId;
        this.buyCount = buyCount;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.isDelete = isDelete;
    }

    public WnBookCart() {
    }

    public WnBookCart(Integer userId, Integer bookId, Integer buyCount) {
        this.userId = userId;
        this.bookId = bookId;
        this.buyCount = buyCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
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
        return "WnBookCart{" +
                "id=" + id +
                ", userId=" + userId +
                ", bookId=" + bookId +
                ", buyCount=" + buyCount +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", isDelete=" + isDelete +
                '}';
    }
}
