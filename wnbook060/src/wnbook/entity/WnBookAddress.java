package wnbook.entity;

import java.util.Date;

public class WnBookAddress {
    private Integer id;
    private String detailAddress;
    private String receiver;
    private Long tel;
    private Integer userId;
    private Integer isDefault;
    private Integer status;
    private Date gmtCreate;
    private Date gmtModified;
    private Integer isDelete;

    public WnBookAddress(Integer id, String detailAddress, String receiver, Long tel, Integer userId, Integer isDefault, Integer status, Date gmtCreate, Date gmtModified, Integer isDelete) {
        this.id = id;
        this.detailAddress = detailAddress;
        this.receiver = receiver;
        this.tel = tel;
        this.userId = userId;
        this.isDefault = isDefault;
        this.status = status;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.isDelete = isDelete;
    }

    public WnBookAddress(String detailAddress, String receiver, Long tel, Integer userId, Integer isDefault, Integer status, Date gmtCreate, Date gmtModified, Integer isDelete) {
        this.detailAddress = detailAddress;
        this.receiver = receiver;
        this.tel = tel;
        this.userId = userId;
        this.isDefault = isDefault;
        this.status = status;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.isDelete = isDelete;
    }

    public WnBookAddress() {
    }

    public WnBookAddress(String detailAddress,Long tel, String receiver ) {
        this.detailAddress = detailAddress;
        this.receiver = receiver;
        this.tel = tel;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public Long getTel() {
        return tel;
    }

    public void setTel(Long tel) {
        this.tel = tel;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
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
        return "WnBookAddress{" +
                "id=" + id +
                ", detailAddress='" + detailAddress + '\'' +
                ", receiver='" + receiver + '\'' +
                ", tel=" + tel +
                ", userId=" + userId +
                ", isDefault=" + isDefault +
                ", status=" + status +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", isDelete=" + isDelete +
                '}';
    }
}
