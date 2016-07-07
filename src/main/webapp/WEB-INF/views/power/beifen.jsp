<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
    <jsp:include page="../common/common.jsp"/>
</head>
<body>
<h3>备份数据库:</h3><br/>
<form class="form-inline definewidth m20" action="index" method="get">
    <input type="file" id="back-path-hidden" style="display:none;">
    <input type="text" id="back-path" name="backup" class="abc input-default" placeholder="" value="">&nbsp;&nbsp;
    <button type="button" id="path" class="btn btn-primary">备份路径</button>
    &nbsp;&nbsp;
    <button type="submit" class="btn btn-primary">确认备份</button>
</form>
<h3>恢复数据库:</h3><br/>
<form class="form-inline definewidth m20" action="index" method="get">
    <input type="file" id="recovery-file-hidden" style="display:none;">
    <input type="text" name="recovery" class="abc input-default" placeholder="" value="">&nbsp;&nbsp;
    <button type="button" id="file" class="btn btn-primary">选择文件</button>
    &nbsp;&nbsp;
    <button type="submit" class="btn btn-primary">确认恢复</button>
</form>
<h3>初始化数据库:</h3><br/>
<form class="form-inline definewidth m20" action="index" method="get">
    <input type="checkbox" name="init-keep-basic" class="abc input-default" placeholder="" value="">仅保留基本数据&nbsp;&nbsp;
    <input type="checkbox" name="init-All" class="abc input-default" placeholder="" value="">清空数据库&nbsp;&nbsp;
    <button type="submit" class="btn btn-primary">确认初始化</button>
</form>
<div class="demo-content">
    <div class="row">
        <div class="span8">
            <div id="J_Uploader">
            </div>
        </div>
    </div>
</div>

</body>
<script type="text/javascript">
    BUI.use('bui/uploader', function (Uploader) {
        var uploader = new Uploader.Uploader({
            render: '#J_Uploader',
            url: '../../../test/upload/upload.php',
//可以直接在这里直接设置成功的回调
            success: function (result) {
            },
//isSuccess : function(result){},
//失败的回调
            error: function (result) {
            }
        }).render();

//上传成功时会触发
        uploader.on('success', function (ev) {
            var result = ev.result;
        })

//上传成功时会触发
        uploader.on('error', function (ev) {
            var result = ev.result;
        });
    });
</script>
</html>
