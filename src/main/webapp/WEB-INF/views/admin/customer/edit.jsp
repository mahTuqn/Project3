<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="main-content">

    <div class="breadcrumbs">
        <ul class="breadcrumb">
            <li>
                <i class="ace-icon fa fa-home home-icon"></i>
                Dashboard
            </li>

            <li class="active">
                Them khach hang
            </li>
        </ul>
    </div>

    <div class="page-content">

        <div class="page-header">
            <h1>Thong tin khach hang</h1>
        </div>

        <form:form modelAttribute="customerEdit"
                   id="ListForm">

            <form:hidden path="id" id="customerId"/>

            <div class="col-xs-12">

                <!-- Tên tòa nhà -->
                <div class="form-group">
                    <label class="col-sm-3 control-label">
                        Tên khach hang
                    </label>

                    <div class="col-sm-9">
                        <form:input path="fullName"
                                    cssClass="form-control"/>
                    </div>
                </div>

                <!-- Quận -->
                <div class="form-group">
                    <label class="col-sm-3 control-label">
                        So dien thoai
                    </label>


                    <div class="col-sm-9">
                        <form:input path="customerPhone"
                                    cssClass="form-control"/>
                    </div>

                </div>

                <!-- Phường -->
                <div class="form-group">
                    <label class="col-sm-3 control-label">
                        Ten cong ty
                    </label>

                    <div class="col-sm-9">
                        <form:input path="companyName"
                                    cssClass="form-control"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">
                        Email
                    </label>

                    <div class="col-sm-9">
                        <form:input path="email"
                                    cssClass="form-control" />
                    </div>
                </div>

                   <div class="form-group">
                    <label class="col-sm-3 control-label">
                        Nhu cau
                    </label>

                    <div class="col-sm-9">
                        <form:input path="demand"
                                    cssClass="form-control" />
                    </div>

                </div>
<div class="form-group">
                    <label class="col-sm-3 control-label">
                        Trang thai
                    </label>

                    <div class="col-sm-9">
                        <form:input path="status"
                                    cssClass="form-control" />
                    </div>

                </div>


                <!-- BUTTON -->
                <c:if test="${not empty customerEdit.id}">
                    <div class="clearfix form-actions">
                        <div class="col-md-offset-3 col-md-9">

                            <button class="btn btn-info"
                                    type="submit"
                                    id="btnAddOrUpdateCustomer">
                                <i class="ace-icon fa fa-check bigger-110"></i>
                                Cập nhật khach hang
                            </button>

                            &nbsp;&nbsp;&nbsp;

                            <button class="btn"
                                    type="reset"
                                    id="btnCancel">
                                <i class="ace-icon fa fa-undo bigger-110"></i>
                                Hủy
                            </button>

                            <c:forEach var="item" items="${transactionType}">

                                <c:if test="${item.key=='DDX'}">
                                    <h2>Dan di xem</h2>
                                    <td> <button type="button" class="btn btn-xs btn-success" id="btnAssignmentTransaction" onclick="addTransaction(${customerEdit.id},'DDX')"><i class="fa fa-plus"></i></button></td>
                                    <div class="col-xs-12">
                                    <table id="simple-table" class ="table table-striped table-borderd table-hover">
                                    <thead>
                                        <tr>
                                            <th>Ngay tao</th>
                                            <th>Nguoi tao</th>
                                            <th>Chi tiet giao dich</th>
                                            <th>Thao tac</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="transaction" items="${transactionList1}">
                                        <tr>
                                            <td>${transaction.createdDate}</td>
                                            <td>${transaction.staffName}</td>
                                            <td>${transaction.note}</td>
                                            <td>
                                                <td> <button type="button" class="btn btn-xs btn-success" id="btnAssignmentTransaction" onclick="updateTransaction(${customerEdit.id},${transaction.id},'DDX','${transaction.note}')"><i class="fa fa-pencil"></i></button></td>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                    </table>
                                    </div>
                                </c:if>

                                <c:if test="${item.key=='CSKH'}">
                                                                    <h2>Cham soc khach hang</h2>
                                                                    <td> <button type="button" class="btn btn-xs btn-success" id="btnAssignmentTransaction" onclick="addTransaction(${customerEdit.id},'CSKH')"><i class="fa fa-plus"></i></button></td>
                                                                    <div class="col-xs-12">
                                                                    <table id="simple-table" class ="table table-striped table-borderd table-hover">
                                                                    <thead>
                                                                        <tr>
                                                                            <th>Ngay tao</th>
                                                                            <th>Nguoi tao</th>
                                                                            <th>Chi tiet giao dich</th>
                                                                            <th>Thao tac</th>
                                                                        </tr>
                                                                    </thead>
                                                                    <tbody>
                                                                    <c:forEach var="transaction" items="${transactionList2}">
                                                                        <tr>

                                                                            <td>${transaction.createdDate}</td>
                                                                            <td>${transaction.staffName}</td>
                                                                            <td>${transaction.note}</td>
                                                                            <td>
                                                                                <td> <button type="button" class="btn btn-xs btn-success" id="btnAssignmentTransaction" onclick="updateTransaction(${customerEdit.id},${transaction.id},'CSKH','${transaction.note}')"><i class="fa fa-pencil"></i></button></td>
                                                                            </td>
                                                                        </tr>
                                                                    </c:forEach>
                                                                    </tbody>
                                                                    </table>
                                                                    </div>
                                                                </c:if>

                            </c:forEach>

                        </div>
                    </div>
                </c:if>

                <c:if test="${empty customerEdit.id}">
                    <div class="clearfix form-actions">
                        <div class="col-md-offset-3 col-md-9">

                            <button class="btn btn-info"
                                    type="submit"
                                    id="btnAddOrUpdateCustomer">
                                <i class="ace-icon fa fa-check bigger-110"></i>
                                Thêm mới khach hang
                            </button>

                            &nbsp;&nbsp;&nbsp;

                            <button class="btn"
                                    type="reset"
                                    id="btnCancel">
                                <i class="ace-icon fa fa-undo bigger-110"></i>
                                Hủy
                            </button>

                        </div>
                    </div>
                </c:if>

            </div>

        </form:form>

    </div>

</div>

<div class="modal fade" id="transactionModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <!-- Input ẩn lưu trữ buildingId -->
                <input type="hidden" id="transactionId" name="transactionId" value="">

                <!-- Giao diện chọn nhân viên (ví dụ) -->

               <table id="transactionTableEdit">
                   <thead>
                       <tr>
                               <th class="center"><h5 id = "modalTitle">Thêm mới giao dịch</h5></th>
                       </tr>
                   </thead>
                   <tbody>
                   <tr>
                   <th>
                   <form:form modelAttribute="transactionEdit" id="transactionFormId">
                       <form:hidden path="id" id="transactionEditId"/>
                       <form:hidden path="code" id="transactionEditCode"/>
                       <form:hidden path="customerId" id="transactionEditCustomerId"/> <!-- Cực kỳ quan trọng -->
                       <form:input path="note" cssClass="form-control" id="transactionEditNote"/>
                   </form:form>

                   </th>
                   </tr>
                   </tbody>
               </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
                <button type="button" class="btn btn-primary" id="btnAddOrUpdateTransaction">Cap nhat giao dich</button>
            </div>
        </div>
    </div>
</div>

<script>
    $('#btnAddOrUpdateCustomer').click(function(e){
        e.preventDefault();
        var data = {};
        var fullName;
        var customerPhone;
        var formData = $('#ListForm').serializeArray();
        $.each(formData, function(i, v){
                data["" + v.name + ""] = v.value;
                if(v.name=="fullName") {
                    fullName = v.value;
                }
                if(v.name=="customerPhone"){
                    customerPhone = v.value;
                }
        });
        console.log("OK")
        //call api
        if (fullName != null && fullName != "" && customerPhone != null && customerPhone !="" ) {
            addOrUpdateCustomer(data);
            window.location.href="/admin/customer-list";
            // window.location.reload();
        }
        else{
            window.location.href="/admin/customer-edit?typeCode=required";
        }
    });

    function addOrUpdateCustomer(data) {
        $.ajax({
            type: "POST",
            url: "http://localhost:8081/api/customer",
            data: JSON.stringify(data),
            contentType: "application/json",
            dataType: "JSON",
            success: function (respond) {
                console.log("Success");
                window.location.href="/admin/customer-list";
                window.location.reload();
            },
            error: function(respond){
                console.log("failed");
                console.log(respond);
            }
        });
    }

    $('#btnCancel').click(function() {
        window.location.href="/admin/customer-list";
    });

    $('#btnAddOrUpdateTransaction').click(function(e) {
        e.preventDefault();
        var data = {};
        var note;
        var transactionFormId = $('#transactionFormId').serializeArray();
                $.each(transactionFormId, function(i, v){
                        data["" + v.name + ""] = v.value;
                        if(v.name=="note") {
                            note = v.value;
                        }
                });
           if(note!=null) {
            addOrUpdateTransaction(data);
            // window.location.reload();
           }


    });

   function updateTransaction(customerId, transactionId, code, note) {
       $('#modalTitle').text("Cập nhật giao dịch");
       $('#transactionEditId').val(transactionId);
       $('#transactionEditCode').val(code);
       $('#transactionEditCustomerId').val(customerId);
       $('#transactionEditNote').val(note); // Hiển thị note cũ để sửa

       $('#transactionModal').modal('show');
   }

   function addTransaction(customerId, code) {
       $('#modalTitle').text("Thêm mới giao dịch");
       $('#transactionEditId').val("");
       $('#transactionEditCode').val(code);
       $('#transactionEditCustomerId').val(customerId);
       $('#transactionEditNote').val(""); // Xóa trắng để nhập note mới

       $('#transactionModal').modal('show');
   }


    function addOrUpdateTransaction(data) {
            $.ajax({
                type: "POST",
                url: "http://localhost:8081/api/transaction",
                data: JSON.stringify(data),
                contentType: "application/json",
                dataType: "JSON",
                success: function (respond) {
                    console.log("Success");
                    window.location.reload();
                },
                error: function(respond){
                    console.log("failed");
                    console.log(respond);
                }
            });
        }
</script>

