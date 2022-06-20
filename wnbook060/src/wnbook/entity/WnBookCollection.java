package wnbook.entity;

import java.util.Date;

public class WnBookCollection {
    private Integer userId;
    private Integer bookId;
    private Date gmtCreate;
    private Date gmtModified;
    private Integer isDelete;

    public WnBookCollection(Integer userId, Integer bookId, Date gmtCreate, Date gmtModified, Integer isDelete) {
        this.userId = userId;
        this.bookId = bookId;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.isDelete = isDelete;
    }

    public WnBookCollection() {
    }

    @Override
    public String toString() {
        return "WnBookCollection{" +
                "userId=" + userId +
                ", bookId=" + bookId +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", isDelete=" + isDelete +
                '}';
    }
}
