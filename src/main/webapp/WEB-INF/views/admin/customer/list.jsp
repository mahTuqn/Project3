<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<body>

<div class="main-content">

    <!-- Breadcrumb -->
    <div class="breadcrumbs">
        <ul class="breadcrumb">
            <li>
                <i class="ace-icon fa fa-home home-icon"></i>
                Dashboard
            </li>
            <li class="active">
                Quản lý khách hang
            </li>
        </ul>
    </div>

    <div class="page-content">

        <!-- SEARCH PANEL -->
        <div class="panel panel-default">
            <div class="panel-heading">
                <i class="fa fa-search"></i>
                Tìm kiếm
            </div>

            <form:form id="ListForm"
                       modelAttribute="modelSearch"
                       action="/admin/customer-list"
                       method="GET">

                <div class="panel-body">

                    <!-- ROW 1 -->
                    <div class="form-group">
                        <div class="col-sm-6">
                            <label>Ten khach hang</label>
                            <form:input path="fullName" cssClass="form-control"/>
                        </div>
                        <div class="col-sm-6">
                            <label>So dien thoai</label>
                            <form:input path="customerPhone" cssClass="form-control"/>
                        </div>
                        <div class="col-sm-6">
                            <label>Email</label>
                            <form:input path="email" cssClass="form-control"/>
                        </div>
                        <div class="col-sm-6">
                            <label>Dia chi</label>
                            <form:input path="companyName" cssClass="form-control"/>
                        </div>
                        <div class="col-sm-4">
                           <label>Nhan vien</label>
                        <form:select path="staffId" cssClass="form-control">
                                <form:option value="">---Chọn Nhan Vien---</form:option>
                               <form:options items="${listStaffs}"/>
                                 </form:select>
                         </div>
                    </div>

                    <!-- BUTTON -->
                    <div class="form-group">
                        <div class="col-sm-12">
                            <button type="submit" class="btn btn-danger" id="btnSearchCustomer">
                                <i class="fa fa-search"></i> Tìm kiếm
                            </button>

                            <!-- ACTION BUTTON -->
                            <div class="pull-right">
                                <a href="/admin/customer-edit" class="btn btn-sm btn-info">
                                    <i class="fa fa-building"></i>
                                </a>
                                <security:authorize access="hasRole('MANAGER')">
                                <button type="button" class="btn btn-sm btn-danger" id="btnDeleteCustomer">
                                    <i class="fa fa-trash"></i>
                                </button>
                                </security:authorize>
                            </div>
                        </div>
                    </div>

                </div>
            </form:form>
        </div>

        <!-- TABLE PANEL -->
        <div class="panel panel-default">
            <div class="panel-heading">
                <i class="fa fa-table"></i> Danh sách tòa nhà
            </div>
            <div class="panel-body">
                <div class="table-responsive">
                    <table id="tableList" class="table table-striped table-bordered table-hover">
                        <thead>
                        <tr>
                            <th width="50px"><input type="checkbox"/></th>
                            <th>Tên khach hang</th>
                            <th>Địa chỉ</th>
                            <th>SĐT</th>
                            <th> emil</th>
                            <th>Ngay tao</th>
                            <th>Nguoi tao</th>
                            <th>Thao tac</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="item" items="${customerList}">
                           <tr>
                                                       <td><input type="checkbox" name="checkList" value=${item.id}></td>
                                                       <td>${item.fullName}</td>
                                                       <td>${item.address}</td>
                                                       <td>${item.phone}</td>
                                                       <td>${item.email}</td>
                                                       <td>${item.createdDate}</td>
                                                       <td>${item.createdBy}</td>
                                                       <td>
                                                           <!-- Nút gọi modal giao tòa nhà -->
                                                           <security:authorize access="hasRole('MANAGER')">
                                                           <button type="button" class="btn btn-xs btn-success" id="btnAssignmentCustomer" onclick="assignmentCustomer(${item.id})">
                                                               <i class="fa fa-plus"></i>
                                                           </button>
                                                           </security:authorize>
                                                           <a href="/admin/customer-edit-${item.id}" class="btn btn-xs btn-primary">
                                                               <i class="fa fa-pencil"></i>
                                                           </a>
                                                            <security:authorize access="hasRole('MANAGER')">
                                                           <button type="button" class="btn btn-xs btn-danger" onclick="deleteCustomer(${item.id})">
                                                               <i class="fa fa-trash"></i>
                                                           </button>
                                                           </security:authorize>
                                                       </td>
                                                   </tr>
                        </c:forEach>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>

    </div>
</div>

<!-- Modal Giao Tòa Nhà -->
<div class="modal fade" id="assignmentCustomerModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="modalLabel">Giao khach hang</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <!-- Input ẩn lưu trữ buildingId -->
                <input type="hidden" id="customerId" name="customerId" value="">

                <table id="staffList">
                    <thead>
                        <th class="center">Chon</th>
                        <th> Ten nhan vien </th>
                    </thead>
                    <tbody>

                    </tbody>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
                <button type="button" class="btn btn-primary" id="btnAssignCustomer">Giao tòa nhà</button>
            </div>
        </div>
    </div>
</div>

<script>
    // Hàm mở Modal khi click vào nút dấu +
    function assignmentCustomer(id) {
        // Gán id của tòa nhà vào thẻ input hidden trong modal
        $('#customerId').val(id);
        loadStaff(id);
        // Hiển thị modal
        $('#assignmentCustomerModal').modal('show');

    }

    function  loadStaff(customerId) {
        $.ajax({
            type: 'GET',
            url: "http://localhost:8081/api/customer/" + customerId + '/staffs',
            contentType: 'application/json',
            dataType: 'JSON',
            success: function (response) {
                var row='';
                $.each(response.data, function(index, item) {

                    row += '<tr>';

                    row += '<td class="text-center">';
                    row += '<input type="checkbox" value="' + item.staffId + '" ';

                    if(item.checked === 'checked'){
                        row += 'checked ';
                    }

                    row += '/>';
                    row += '</td>';

                    row += '<td>' + item.fullName + '</td>';

                    row += '</tr>';
                });
                $('#staffList tbody').html(row);
            },
            error: function (response) {

                console.log("Failed");
                console.log(response);
            }
        });
    }

    // Bắt sự kiện khi click vào nút "Giao tòa nhà" BÊN TRONG MODAL
    $('#btnAssignCustomer').click(function(e) {

        e.preventDefault();

        var data = {};
        data['customerId'] = $('#customerId').val();
        var staffs = $('#assignmentCustomerModal').find('input[type=checkbox]:checked').map(function() {
            return $(this).val();
        }).get();

        data['staffs'] = staffs;
       if (data.staffs && data.staffs.length > 0) {
           assignment(data);
       }
        // assignment(data);
        console.log("Dữ liệu chuẩn bị gửi đi: ", data);
    });

    function assignment(data){
        $.ajax({
                            type: "POST",
                            url: "http://localhost:8081/api/customer/assignment",
                            data: JSON.stringify(data),
                            contentType: "application/json",
                            dataType: "JSON",
                            success: function (respond) {
                                console.log("Success");
                            },
                            error: function(respond){
                                console.log("failed");
                                console.log(respond);
                            }
                        });
            }

    // Bắt sự kiện khi click vào nút Tìm kiếm
    $('#btnSearchCustomer').click(function(e) {
        e.preventDefault();
        // Submit form có id là ListForm
        $('#ListForm').submit();
    });

    function deleteCustomer(data) {
        var customerId=[data];
        deleteCustomers(customerId);
    }

    $('#btnDeleteCustomer').click(function(e){
    e.preventDefault();
    var customerIds=$('#tableList').find('tbody input[type = checkbox]:checked').map(function(){
    return $(this).val();
    }).get();
    console.log(customerIds);
    deleteCustomers(customerIds);
    });

    function deleteCustomers(data) {
        $.ajax({
            type: "DELETE",
            url: "http://localhost:8081/api/customer/" + data,
            // Không cần gửi data trong body vì đã truyền qua URL (PathVariable)
            success: function (respond) {
                console.log("Success");
                // Load lại trang để cập nhật danh sách tòa nhà
                window.location.reload();
            },
            error: function(respond){
                console.log("failed");
                console.log(respond);
            }
        });
    }
</script>

</body>
</html>
