package wnbook.entity;

import java.io.Serializable;
import java.util.Date;

public class WnBook implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String bookName;
    private String bookImage;
    private String bookAuthor;
    private String bookPublish;
    private Date bookPublishDate;
    private Double bookPrice;
    private WnBookCategory cate;
    private String bookIntroduce;
    private Integer bookStoreCount;
    private Integer bookCollectionCount;
    private Integer bookStatus;
    private Date gmtCreate;
    private Date gmtModified;
    private Boolean isDelete;
    private Integer bookSaleCount;

    public WnBook(Integer id, String bookName, String bookImage, String bookAuthor, String bookPublish, Date bookPublishDate, Double bookPrice, WnBookCategory cate, String bookIntroduce, Integer bookStoreCount,Integer bookSaleCount, Integer bookCollectionCount, Integer bookStatus, Date gmtCreate, Date gmtModified, Boolean isDelete ) {
        this.id = id;
        this.bookName = bookName;
        this.bookImage = bookImage;
        this.bookAuthor = bookAuthor;
        this.bookPublish = bookPublish;
        this.bookPublishDate = bookPublishDate;
        this.bookPrice = bookPrice;
        this.cate = cate;
        this.bookIntroduce = bookIntroduce;
        this.bookStoreCount = bookStoreCount;
        this.bookCollectionCount = bookCollectionCount;
        this.bookStatus = bookStatus;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.isDelete = isDelete;
        this.bookSaleCount = bookSaleCount;
    }

    public WnBook(String bookName, String bookImage, String bookAuthor, String bookPublish, Date bookPublishDate, Double bookPrice, WnBookCategory cate, String bookIntroduce, Integer bookStoreCount,Integer bookSaleCount, Integer bookCollectionCount, Integer bookStatus, Date gmtCreate, Date gmtModified, Boolean isDelete ) {
        this.bookName = bookName;
        this.bookImage = bookImage;
        this.bookAuthor = bookAuthor;
        this.bookPublish = bookPublish;
        this.bookPublishDate = bookPublishDate;
        this.bookPrice = bookPrice;
        this.cate = cate;
        this.bookIntroduce = bookIntroduce;
        this.bookStoreCount = bookStoreCount;
        this.bookCollectionCount = bookCollectionCount;
        this.bookStatus = bookStatus;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.isDelete = isDelete;
        this.bookSaleCount = bookSaleCount;
    }

    public WnBook() {
    }

    public WnBook(String bookName, Double bookPrice) {
        this.bookName = bookName;
        this.bookPrice = bookPrice;
    }

    public WnBook(String bookName, Double bookPrice, String bookImage, String bookAuthor, String bookPublish, Date bookPublishDate, WnBookCategory cate) {
        this.bookName = bookName;
        this.bookImage = bookImage;
        this.bookAuthor = bookAuthor;
        this.bookPublish = bookPublish;
        this.bookPublishDate = bookPublishDate;
        this.bookPrice = bookPrice;
        this.cate = cate;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookImage() {
        return bookImage;
    }

    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookPublish() {
        return bookPublish;
    }

    public void setBookPublish(String bookPublish) {
        this.bookPublish = bookPublish;
    }

    public Date getBookPublishDate() {
        return bookPublishDate;
    }

    public void setBookPublishDate(Date bookPublishDate) {
        this.bookPublishDate = bookPublishDate;
    }

    public Double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public WnBookCategory getCate() {
        return cate;
    }

    public void setCate(WnBookCategory cate) {
        this.cate = cate;
    }

    public String getBookIntroduce() {
        return bookIntroduce;
    }

    public void setBookIntroduce(String bookIntroduce) {
        this.bookIntroduce = bookIntroduce;
    }

    public Integer getBookStoreCount() {
        return bookStoreCount;
    }

    public void setBookStoreCount(Integer bookStoreCount) {
        this.bookStoreCount = bookStoreCount;
    }

    public Integer getBookCollectionCount() {
        return bookCollectionCount;
    }

    public void setBookCollectionCount(Integer bookCollectionCount) {
        this.bookCollectionCount = bookCollectionCount;
    }

    public Integer getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(Integer bookStatus) {
        this.bookStatus = bookStatus;
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

    public Integer getBookSaleCount() {
        return bookSaleCount;
    }

    public void setBookSaleCount(Integer bookSaleCount) {
        this.bookSaleCount = bookSaleCount;
    }

    @Override
    public String toString() {
        return "WnBook{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", bookImage='" + bookImage + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookPublish='" + bookPublish + '\'' +
                ", bookPublishDate=" + bookPublishDate +
                ", bookPrice=" + bookPrice +
                ", cate=" + cate +
                ", bookIntroduce='" + bookIntroduce + '\'' +
                ", bookStoreCount=" + bookStoreCount +
                ", bookCollectionCount=" + bookCollectionCount +
                ", bookStatus=" + bookStatus +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", isDelete=" + isDelete +
                ", bookSaleCount=" + bookSaleCount +
                '}';
    }
}
