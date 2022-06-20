package wnbook.entity;

import java.util.Date;
import java.util.List;

//用于显示订单
public class OrderQueryVo {
    private int orderId;
    private String orderNum;
    private int userId;
    private double totalPrice;
    private int addressId;
    //订单详情
    private List<OrderDetailQueryVo> list;
    private Date gmtCreate;
    private Date gmtModified;
    private int isDelete;

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmyModified() {
        return gmtModified;
    }

    public void setGmyModified(Date gmyModified) {
        this.gmtModified = gmyModified;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public List<OrderDetailQueryVo> getList() {
        return list;
    }

    public void setList(List<OrderDetailQueryVo> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "OrderQueryVo{" +
                "orderId=" + orderId +
                ", orderNum='" + orderNum + '\'' +
                ", userId=" + userId +
                ", totalPrice=" + totalPrice +
                ", addressId=" + addressId +
                ", list=" + list +
                ", gmtCreate=" + gmtCreate +
                ", gmyModified=" + gmtModified +
                ", isDelete=" + isDelete +
                '}';
    }
}
