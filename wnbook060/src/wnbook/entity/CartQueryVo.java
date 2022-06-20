package wnbook.entity;
//用于显示购物车
public class CartQueryVo {
    private int cartId;
    private int userId;
    private int buyCount;
    private int bookId;
    private String bookImage;
    private String bookName;
    private double bookPrice;

    public CartQueryVo() {
    }

    public CartQueryVo(int cartId, int userId, int buyCount, int bookId, String bookImage, String bookName, double bookPrice) {
        this.cartId = cartId;
        this.userId = userId;
        this.buyCount = buyCount;
        this.bookId = bookId;
        this.bookImage = bookImage;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
    }

    public CartQueryVo(int userId, int buyCount, int bookId, String bookImage, String bookName, double bookPrice) {
        this.userId = userId;
        this.buyCount = buyCount;
        this.bookId = bookId;
        this.bookImage = bookImage;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(int buyCount) {
        this.buyCount = buyCount;
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

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    @Override
    public String toString() {
        return "CartQueryVo{" +
                "cartId=" + cartId +
                ", userId=" + userId +
                ", buyCount=" + buyCount +
                ", bookId=" + bookId +
                ", bookImage='" + bookImage + '\'' +
                ", bookName='" + bookName + '\'' +
                ", bookPrice=" + bookPrice +
                '}';
    }
}
