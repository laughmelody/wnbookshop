$(function(){
    $.ajax({
        url:"./book",
        data:{
            "op":"indexBook"
        },
        type:"get",
        dataType:"json",
        success:function (jsonArr){
            let hotBook = jsonArr[0];
            let newBook = jsonArr[1];
            let collBook = jsonArr[2];
            for (book of hotBook){
                $("#hotBook").append(`
                <li>
                    <a href="./book?op=findById&id=${book.id}">                  
                        <img src="http://localhost/${book.bookImage}" >
                        <p class="book-name">${book.bookName}</p>
                        <p class="book-price">price:${book.bookPrice}</p>
                    </a>
                </li>
                `);
            }
            for (book of newBook){
                $("#newBook").append(`
                <li>
                    <a href="#">
                        <img src="http://localhost/${book.bookImage}" >
                        <p class="book-name">${book.bookName}</p>
                        <p class="book-price">price:${book.bookPrice}</p>
                    </a>
                </li>
                `);
            }
            for (book of collBook){
                $("#collBook").append(`
                <li>
                    <a href="#">
                        <img src="http://localhost/${book.bookImage}" >
                        <p class="book-name">${book.bookName}</p>
                        <p class="book-price">price:${book.bookPrice}</p>
                    </a>
                </li>
                `);
            }
        }
    })
})
