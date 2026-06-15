<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
                Quản lý tòa nhà
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
                       action="/admin/building-list"
                       method="GET">

                <div class="panel-body">

                    <!-- ROW 1 -->
                    <div class="form-group">
                        <div class="col-sm-6">
                            <label>Tên tòa nhà</label>
                            <form:input path="name" cssClass="form-control"/>
                        </div>
                        <div class="col-sm-6">
                            <label>Diện tích sàn</label>
                            <form:input path="floorArea" cssClass="form-control"/>
                        </div>
                    </div>

                    <!-- ROW 2 -->
                    <div class="form-group">
                        <div class="col-sm-4">
                            <label>Quận</label>
                            <form:select path="district" cssClass="form-control">
                                <form:option value="">---Chọn Quận---</form:option>
                                <form:options items="${districts}"/>
                            </form:select>
                        </div>
                        <div class="col-sm-4">
                            <label>Phường</label>
                            <form:input path="ward" cssClass="form-control"/>
                        </div>
                        <div class="col-sm-4">
                            <label>Đường</label>
                            <form:input path="street" cssClass="form-control"/>
                        </div>
                    </div>

                    <!-- ROW 3 -->
                    <div class="form-group">
                        <div class="col-sm-4">
                            <label>Số tầng hầm</label>
                            <form:input path="numberOfBasement" cssClass="form-control"/>
                        </div>
                        <div class="col-sm-4">
                            <label>Hướng</label>
                            <form:input path="direction" cssClass="form-control"/>
                        </div>
                        <div class="col-sm-4">
                            <label>Hạng</label>
                            <form:input path="level" cssClass="form-control"/>
                        </div>
                    </div>

                    <!-- ROW 4 -->
                    <div class="form-group">
                        <div class="col-sm-3">
                            <label>Diện tích từ</label>
                            <form:input path="areaFrom" cssClass="form-control"/>
                        </div>
                        <div class="col-sm-3">
                            <label>Diện tích đến</label>
                            <form:input path="areaTo" cssClass="form-control"/>
                        </div>
                        <div class="col-sm-3">
                            <label>Giá thuê từ</label>
                            <form:input path="rentPriceFrom" cssClass="form-control"/>
                        </div>
                        <div class="col-sm-3">
                            <label>Giá thuê đến</label>
                            <form:input path="rentPriceTo" cssClass="form-control"/>
                        </div>
                    </div>
                        <div class="col-sm-4">
                            <label>Nhan vien</label>
                            <form:select path="staffId" cssClass="form-control">
                                <form:option value="">---Chọn Nhan Vien---</form:option>
                                <form:options items="${listStaffs}"/>
                            </form:select>
                        </div>
                    <!-- CHECKBOX -->
                    <div class="form-group">
                        <div class="col-sm-12">
                            <label>Loại tòa nhà</label>
                            <br/>
                                <form:checkboxes path="typeCode" items="${typeCodes}"/>
                        </div>
                    </div>

                    <!-- BUTTON -->
                    <div class="form-group">
                        <div class="col-sm-12">
                            <button type="submit" class="btn btn-danger" id="btnSearchBuilding">
                                <i class="fa fa-search"></i> Tìm kiếm
                            </button>

                            <!-- ACTION BUTTON -->
                            <div class="pull-right">
                                <a href="/admin/building-edit" class="btn btn-sm btn-info">
                                    <i class="fa fa-building"></i>
                                </a>
                                <button type="button" class="btn btn-sm btn-danger" id="btnDeleteBuilding">
                                    <i class="fa fa-trash"></i>
                                </button>
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
                            <th>Tên tòa nhà</th>
                            <th>Địa chỉ</th>
                            <th>Số tầng hầm</th>
                            <th>Tên quản lý</th>
                            <th>SĐT</th>
                            <th>DT sàn</th>
                            <th>DT thuê</th>
                            <th width="150px">Thao tác</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="item" items="${buildingList}">
                           <tr>
                                                       <td><input type="checkbox" name="checkList" value=${item.id}></td>
                                                       <td>${item.name}</td>
                                                       <td>${item.address}</td>
                                                       <td>${item.numberOfBasement}</td>
                                                       <td>${item.managerName}</td>
                                                       <td>${item.managerPhone}</td>
                                                       <td>${item.floorArea}</td>
                                                       <td>${item.rentArea}</td>
                                                       <td>
                                                           <!-- Nút gọi modal giao tòa nhà -->
                                                           <button type="button" class="btn btn-xs btn-success" id="btnassignmentBuilding" onclick="assignmentBuilding(${item.id})">
                                                               <i class="fa fa-plus"></i>
                                                           </button>

                                                           <a href="/admin/building-edit-${item.id}" class="btn btn-xs btn-primary">
                                                               <i class="fa fa-pencil"></i>
                                                           </a>

                                                           <button type="button" class="btn btn-xs btn-danger" onclick="deleteBuilding(${item.id})">
                                                               <i class="fa fa-trash"></i>
                                                           </button>
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
<div class="modal fade" id="assignmentBuildingModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="modalLabel">Giao tòa nhà</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <!-- Input ẩn lưu trữ buildingId -->
                <input type="hidden" id="buildingId" name="buildingId" value="">

                <!-- Giao diện chọn nhân viên (ví dụ) -->

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
                <button type="button" class="btn btn-primary" id="btnAssignBuilding">Giao tòa nhà</button>
            </div>
        </div>
    </div>
</div>

<script>
    // Hàm mở Modal khi click vào nút dấu +
    function assignmentBuilding(id) {
        // Gán id của tòa nhà vào thẻ input hidden trong modal
        $('#buildingId').val(id);
        loadStaff(id);
        // Hiển thị modal
        $('#assignmentBuildingModal').modal('show');

    }

    function  loadStaff(buildingId) {
        $.ajax({
            type: 'GET',
            url: "http://localhost:8080/api/building/" + buildingId + '/staffs',
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
    $('#btnAssignBuilding').click(function(e) {

        e.preventDefault();

        var data = {};
        data['buildingId'] = $('#buildingId').val();
        var staffs = $('#assignmentBuildingModal').find('input[type=checkbox]:checked').map(function() {
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
                            url: "http://localhost:8080/api/building/assignment",
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
    $('#btnSearchBuilding').click(function(e) {
        e.preventDefault();
        // Submit form có id là ListForm
        $('#ListForm').submit();
    });

    function deleteBuilding(data) {
        var buildingId=[data];
        deleteBuildings(buildingId);
    }

    $('#btnDeleteBuilding').click(function(e){
    e.preventDefault();
    var buildingIds=$('#tableList').find('tbody input[type = checkbox]:checked').map(function(){
    return $(this).val();
    }).get();
    console.log(buildingIds);
    deleteBuildings(buildingIds);
    });

    function deleteBuildings(data) {
        $.ajax({
            type: "DELETE",
            url: "http://localhost:8080/api/building/" + data,
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