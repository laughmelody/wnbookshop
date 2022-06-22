package wnbook.entity;

import java.util.Date;

public class WnBookOrder {
    private Integer id;
    private String orderNum;
    private Integer userId;
    private Integer addressId;
    private double totalPrice;
    private Integer status;
    private Date gmtCreate;
    private Date gmtModified;
    private Integer isDelete;

    public WnBookOrder(String orderNum, Integer userId, Integer addressId, double totalPrice, Integer status, Date gmtCreate, Date gmtModified, Integer isDelete) {
        this.orderNum = orderNum;
        this.userId = userId;
        this.addressId = addressId;
        this.totalPrice = totalPrice;
        this.status = status;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.isDelete = isDelete;
    }

    public WnBookOrder() {
    }

    public WnBookOrder(Integer id, String orderNum, Integer userId, Integer addressId, double totalPrice, Integer status, Date gmtCreate, Date gmtModified, Integer isDelete) {
        this.id = id;
        this.orderNum = orderNum;
        this.userId = userId;
        this.addressId = addressId;
        this.totalPrice = totalPrice;
        this.status = status;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.isDelete = isDelete;
    }

    public WnBookOrder(String orderNum, Integer userId, Integer addressId, double totalPrice) {
        this.orderNum = orderNum;
        this.userId = userId;
        this.addressId = addressId;
        this.totalPrice = totalPrice;
    }

    public WnBookOrder(String orderNum, Integer userId, Integer status) {
        this.orderNum = orderNum;
        this.userId = userId;
        this.status = status;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
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

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "WnBookOrder{" +
                "id=" + id +
                ", orderNum='" + orderNum + '\'' +
                ", userId=" + userId +
                ", addressId=" + addressId +
                ", totalPrice=" + totalPrice +
                ", status=" + status +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", isDelete=" + isDelete +
                '}';
    }
}
