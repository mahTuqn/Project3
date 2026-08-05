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
                Cập nhật tòa nhà
            </li>
        </ul>
    </div>

    <div class="page-content">

        <div class="page-header">
            <h1>Cập nhật thông tin tòa nhà</h1>
        </div>

        <form:form modelAttribute="buildingEdit"
                   id="ListForm">

            <form:hidden path="id" id="buildingId"/>

            <div class="col-xs-12">

                <!-- Tên tòa nhà -->
                <div class="form-group">
                    <label class="col-sm-3 control-label">
                        Tên tòa nhà
                    </label>

                    <div class="col-sm-9">
                        <form:input path="name"
                                    cssClass="form-control"/>
                    </div>
                </div>

                <!-- Quận -->
                <div class="form-group">
                    <label class="col-sm-3 control-label">
                        Quận
                    </label>

                    <div class="col-sm-9">
                        <form:select path="district"
                                     cssClass="form-control">
                            <form:option value="">
                                ---Chọn Quận---
                            </form:option>

                            <form:options items="${districts}"/>
                        </form:select>
                    </div>
                </div>

                <!-- Phường -->
                <div class="form-group">
                    <label class="col-sm-3 control-label">
                        Phường
                    </label>

                    <div class="col-sm-9">
                        <form:input path="ward"
                                    cssClass="form-control"
                                    id="ward"/>
                    </div>
                </div>

                <!-- Đường -->
                <div class="form-group">
                    <label class="col-sm-3 control-label">
                        Đường
                    </label>

                    <div class="col-sm-9">
                        <form:input path="street"
                                    cssClass="form-control"
                                    id="street"/>
                    </div>
                </div>

                <!-- Kết cấu -->
                <div class="form-group">
                    <label class="col-sm-3 control-label">
                        Kết cấu
                    </label>

                    <div class="col-sm-9">
                        <form:input path="structure"
                                    cssClass="form-control"
                                    id="structure"/>
                    </div>
                </div>

                <!-- Số tầng hầm -->
                <div class="form-group">
                    <label class="col-sm-3 control-label">
                        Số tầng hầm
                    </label>

                    <div class="col-sm-9">
                        <form:input path="numberOfBasement"
                                    cssClass="form-control"
                                    id="numberofbasement"
                                    type="number"/>
                    </div>
                </div>

                <!-- Diện tích sàn -->
                <div class="form-group">
                    <label class="col-sm-3 control-label">
                        Diện tích sàn
                    </label>

                    <div class="col-sm-9">
                        <form:input path="floorArea"
                                    cssClass="form-control"
                                    id="floorarea"
                                    type="number"/>
                    </div>
                </div>

                <!-- Hướng -->
                <div class="form-group">
                    <label class="col-sm-3 control-label">
                        Hướng
                    </label>

                    <div class="col-sm-9">
                        <form:input path="direction"
                                    cssClass="form-control"
                                    id="direction"/>
                    </div>
                </div>

                <!-- Hạng -->
                <div class="form-group">
                    <label class="col-sm-3 control-label">
                        Hạng
                    </label>

                    <div class="col-sm-9">
                        <form:input path="level"
                                    cssClass="form-control"
                                    id="level"/>
                    </div>
                </div>

                <!-- Diện tích thuê -->
                <div class="form-group">
                    <label class="col-sm-3 control-label">
                        Diện tích thuê
                    </label>

                    <div class="col-sm-9">
                        <form:input path="rentArea"
                                    cssClass="form-control"
                                    id="rentarea"
                                    placeholder="VD: 100,200,300"/>
                    </div>
                </div>

                <!-- Giá thuê -->
                <div class="form-group">
                    <label class="col-sm-3 control-label">
                        Giá thuê
                    </label>

                    <div class="col-sm-9">
                        <form:input path="rentPrice"
                                    cssClass="form-control"
                                    id="rentprice"
                                    type="number"/>
                    </div>
                </div>

                <!-- Mô tả giá -->
                <div class="form-group">
                    <label class="col-sm-3 control-label">
                        Mô tả giá
                    </label>

                    <div class="col-sm-9">
                        <form:input path="rentPriceDescription"
                                    cssClass="form-control"
                                    id="rentpricedescription"/>
                    </div>
                </div>

                <!-- Tên quản lý -->
                <div class="form-group">
                    <label class="col-sm-3 control-label">
                        Tên quản lý
                    </label>

                    <div class="col-sm-9">
                        <form:input path="managerName"
                                    cssClass="form-control"/>
                    </div>
                </div>

                <!-- SĐT quản lý -->
                <div class="form-group">
                    <label class="col-sm-3 control-label">
                        SĐT quản lý
                    </label>

                    <div class="col-sm-9">
                        <form:input path="managerPhone"
                                    cssClass="form-control"/>
                    </div>
                </div>

                <!-- Loại tòa nhà -->
                <div class="form-group">
                    <label class="col-sm-3 control-label">
                        Loại tòa nhà
                    </label>

                    <div class="col-sm-9">
                        <form:checkboxes path="typeCode"
                                         items="${typeCodes}"/>
                    </div>
                </div>

                <!-- Ghi chú -->
                <div class="form-group">
                    <label class="col-sm-3 control-label">
                        Ghi chú
                    </label>

                    <div class="col-sm-9">
                        <form:textarea path="note"
                                       cssClass="form-control"
                                       rows="5"
                                       id="note"/>
                    </div>
                </div>

                <!-- Hình ảnh -->
                <div class="form-group">
                    <label class="col-sm-3 control-label">
                        Hình đại diện
                    </label>

                    <div class="col-sm-9">
                        <input type="file"
                               class="form-control"
                               id="image"
                               name="image"/>
                    </div>
                </div>

                <!-- BUTTON -->
                <c:if test="${not empty buildingEdit.id}">
                    <div class="clearfix form-actions">
                        <div class="col-md-offset-3 col-md-9">

                            <button class="btn btn-info"
                                    type="submit"
                                    id="btnAddOrUpdateBuilding">
                                <i class="ace-icon fa fa-check bigger-110"></i>
                                Cập nhật tòa nhà
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

                <c:if test="${empty buildingEdit.id}">
                    <div class="clearfix form-actions">
                        <div class="col-md-offset-3 col-md-9">

                            <button class="btn btn-info"
                                    type="submit"
                                    id="btnAddOrUpdateBuilding">
                                <i class="ace-icon fa fa-check bigger-110"></i>
                                Thêm mới tòa nhà
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

<script>
    $('#btnAddOrUpdateBuilding').click(function(e){
    e.preventDefault();
        var data = {};
        var typeCode = [];
        var formData = $('#ListForm').serializeArray();
        $.each(formData, function(i, v){
            if(v.name != 'typeCode'){
                data["" + v.name + ""] = v.value;
            }
            else {
                typeCode.push(v.value);
            }
        });
        data['typeCode'] = typeCode;
        console.log("OK")
        //call api
        if (typeCode && typeCode.length > 0) {
            addOrUpdateBuilding(data);
            window.location.href="/admin/building-list";
           // window.location.reload();
        }
        else{
            window.location.href="/admin/building-edit?typeCode=required";
        }
    });

    function addOrUpdateBuilding(data) {
        $.ajax({
                    type: "POST",
                    url: "http://localhost:8081/api/building",
                    data: JSON.stringify(data),
                    contentType: "application/json",
                    dataType: "JSON",
                    success: function (respond) {
                        console.log("Success");
                        window.location.href="/admin/building-list";
                        window.location.reload();
                    },
                    error: function(respond){
                        console.log("failed");
                        console.log(respond);
                    }
                });
    }

    $('#btnCancel').click(function() {
        window.location.href="/admin/building-list";
    });
</script>