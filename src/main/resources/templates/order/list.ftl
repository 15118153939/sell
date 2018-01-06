<html>
<#include "../common/header.ftl">
<body>


<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table">
                <thead>
                <tr>
                    <th>订单id</th>
                    <th>姓名</th>
                    <th>手机号</th>
                    <th>地址</th>
                    <th>金额</th>
                    <th>订单状态</th>
                    <th>支付状态</th>
                    <th>创建时间</th>
                    <th colspan="2">操作</th>
                </tr>
                </thead>
                <tbody>

                <#list orderDTOPage.content as orderDTO>

                <tr>
                    <td>${orderDTO.orderId}</td>
                    <td>${orderDTO.buyerName}</td>
                    <td>${orderDTO.buyerPhone}</td>
                    <td>${orderDTO.buyerAddress}</td>
                    <td>${orderDTO.orderAmount}</td>
                    <td>${orderDTO.getOrderStatusEnum().message}</td>
                    <td>${orderDTO.getPayStatusEnum().message}</td>
                    <td>${orderDTO.createTime}</td>

                    <td><a href="/sell/seller/order/detail?orderId=${orderDTO.orderId}">详情</a></td>
                    <#--只有新订单才有取消-->
                    <td>
                        <#if orderDTO.getOrderStatusEnum().message == "新订单">
                            <a href="/sell/seller/order/cancel?orderId=${orderDTO.orderId}">取消</a>
                        </#if>
                    </td>


                </tr>
                </#list>
                </tbody>

            </table>
        </div>
    <#--分页-->
        <div class="col-md-12 column">
            <ul class="pagination pull-right">
            <#--总页数-->
            <#--上一页start-->
            <#if currentPage lte 1>
            <#--如果当前页是1，则上一页不能用-->
                <li class="disabled"><a href="#">上一页</a></li>
            <#else>
            <#--否则，上一页就是当前页-1-->
                <li><a href="/sell/seller/order/list?page=${currentPage - 1}&size=${size}">上一页</a></li>
            </#if>
            <#--上一页end-->




            <#list 1..orderDTOPage.getTotalPages() as index>
            <#--设置当前页为disabled样式-->
                <#if currentPage == index>
                    <li class="disabled"><a href="#">${index}</a></li>
                <#else>
                    <li><a href="/sell/seller/order/list?page=${index}&size=${size}">${index}</a></li>
                </#if>
            </#list>


                <#--待完成，就是实现...多分页情况-->

            <#--<#if orderDTOPage.getTotalPages() gte 10>-->
                <#--<#list 1..10 as index>-->
                    <#--<#if currentPage == index>-->
                        <#--<li class="disabled"><a href="#">${index}</a></li>-->
                    <#--<#else>-->
                        <#--<li><a href="/sell/seller/order/list?page=${index}&size=${size}">${index}</a></li>-->
                    <#--</#if>-->
                <#--</#list>-->

                <#--<li><a href="#">...</a></li>-->
                <#--<li><a href="/sell/seller/order/list?page=${orderDTOPage.getTotalPages()}&size=${size}">${orderDTOPage.getTotalPages()}</a></li>-->
            <#--</#if>-->




            <#--下一页start-->
            <#--当前页大于等于总数则不能用-->
            <#if currentPage gte orderDTOPage.getTotalPages()>
                <li class="disabled"><a href="#">下一页</a></li>
            <#else>
            <#--否则就是当前页+1-->
            <li> <a href="/sell/seller/order/list?page=${currentPage +1}&size=${size}">下一页</a>
            </#if>
            <#--下一页end-->


            </ul>
        </div>
    </div>
</div>

</body>
</html>


</head>

<#--freemarker 遍历数据-->


