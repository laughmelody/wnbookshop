package wnbook.entity;
//用于显示订单
public class OrderDetailQueryVo {
    private int detailId;
    private int bookId;
    private String bookImage;
    private double bookPrice;
    private int buyCount;
    private String bookName;
    private double total;

    public OrderDetailQueryVo(int detailId, int bookId, String bookImage, double bookPrice, int buyCount, String bookName, double total) {
        this.detailId = detailId;
        this.bookId = bookId;
        this.bookImage = bookImage;
        this.bookPrice = bookPrice;
        this.buyCount = buyCount;
        this.bookName = bookName;
        this.total = total;
    }

    public OrderDetailQueryVo() {
    }

    public int getDetailId() {
        return detailId;
    }

    public void setDetailId(int detailId) {
        this.detailId = detailId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookImage() {
        return bookImage;
    }

    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public int getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(int buyCount) {
        this.buyCount = buyCount;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "OrderDetailQueryVo{" +
                "detailId=" + detailId +
                ", bookId=" + bookId +
                ", bookImage='" + bookImage + '\'' +
                ", bookPrice=" + bookPrice +
                ", buyCount=" + buyCount +
                ", bookName='" + bookName + '\'' +
                ", total=" + total +
                '}';
    }
}
