$(function (){
    showUser(1,5);
})
function showUser(currentPage,pageSize){
    $.ajax({
        url:"./user",
        data:{
            "op":"ajaxShow",
            "currentPage":currentPage,
            "pageSize":pageSize
        },
        type:"get",
        dataType:"json",
        success:function (jsonPage){

            //把得到的json格式字符串，变成json对象
            //let jsonArr = JSON.parse(msg);
            //每次加载数据前，要先删除元数据
            $("tr:not(:first):not(:last)").remove();
            for (u of jsonPage.list){
                $("tr:last").before(`
                    <tr>
                        <td>${u.id}</td>
                        <td>${u.username}</td>
                        <td>${u.password}</td>
                        <td>
                            <a class="btn btn-info" onclick="edit(${u.id})">修改</a>
                            <a class="btn btn-danger" onclick="del(${u.id})">删除</a>
                        </td>
                    </tr>
                    `)
            }
            //设置总页数和当前页
            $("#totalPage").html(jsonPage.totalPage);
            $("#currentPage").html(jsonPage.currentPage);
            $("#prePage").attr("data-index",jsonPage.prePage);
            $("#nextPage").attr("data-index",jsonPage.nextPage);
        }
    })
}
function prePage(obj){
    if ($("#currentPage").html()==1){
        return;
    }
    showUser($("#prePage").attr("data-index"),5)
}
function nextPage() {
    if ($("#currentPage").html()==$("#totalPage").html()){
        return;
    }
    showUser($("#nextPage").attr("data-index"),5)
}


function doEdit(){
    $("form").submit();
}
function edit(obj){
    // alert("edit:"+id);
    // let arr = $("form input");
    // $(obj).parent().siblings("td").each(function (index,o){
    //     arr[index].value = o.innerHTML;
    // })
}
function del(id){
    location.href="user?op=del&id='+id+'currentPage=${page.currentPage}";
}