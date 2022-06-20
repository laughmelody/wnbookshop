package wnbook.entity;

import java.util.Date;

public class WnBookOrderDetail {
    private Integer id;
    private Integer bookId;
    private double bookPrice;
    private Integer orderId;
    private Integer buyCount;
    private double total;
    private Date gmtCreate;
    private Date gmtModified;
    private Integer isDelete;

    public WnBookOrderDetail(Integer id, Integer bookId, double bookPrice, Integer orderId, Integer buyCount, double total, Date gmtCreate, Date gmtModified, Integer isDelete) {
        this.id = id;
        this.bookId = bookId;
        this.bookPrice = bookPrice;
        this.orderId = orderId;
        this.buyCount = buyCount;
        this.total = total;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.isDelete = isDelete;
    }

    public WnBookOrderDetail(Integer bookId, double bookPrice, Integer orderId, Integer buyCount, double total, Date gmtCreate, Date gmtModified, Integer isDelete) {
        this.bookId = bookId;
        this.bookPrice = bookPrice;
        this.orderId = orderId;
        this.buyCount = buyCount;
        this.total = total;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.isDelete = isDelete;
    }

    public WnBookOrderDetail() {
    }

    public WnBookOrderDetail(Integer orderId,Integer bookId, double bookPrice,  Integer buyCount, double total) {
        this.bookId = bookId;
        this.bookPrice = bookPrice;
        this.orderId = orderId;
        this.buyCount = buyCount;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
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
        return "WnBookOrderDetail{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", bookPrice=" + bookPrice +
                ", orderId=" + orderId +
                ", buyCount=" + buyCount +
                ", total=" + total +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", isDelete=" + isDelete +
                '}';
    }
}
