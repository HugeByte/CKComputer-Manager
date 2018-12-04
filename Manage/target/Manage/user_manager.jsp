<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title> - jqGird</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <!-- jqgrid-->
    <link href="css/plugins/jqgrid/ui.jqgrid.css?0820" rel="stylesheet">

    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">

    <style>
        /* Additional style to fix warning dialog position */

        #alertmod_table_list_2 {
            top: 900px !important;
        }
    </style>

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content  animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox ">
                <div class="ibox-title">
                    <h5>社员管理</h5>
                </div>
                <div class="ibox-content">
                    <h4 class="m-t">正式社员管理</h4>
                    <div class="jqGrid_wrapper">
                        <table id="table_list_2"></table>
                        <div id="pager_list_2"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- 全局js -->
<script src="js/jquery.min.js?v=2.1.4"></script>
<script src="js/bootstrap.min.js?v=3.3.6"></script>



<!-- Peity -->
<script src="js/plugins/peity/jquery.peity.min.js"></script>

<!-- jqGrid -->
<script src="js/plugins/jqgrid/i18n/grid.locale-cn.js?0820"></script>
<script src="js/plugins/jqgrid/jquery.jqGrid.min.js?0820"></script>

<!-- 自定义js -->
<script src="js/content.js?v=1.0.0"></script>

<!-- Page-Level Scripts -->
<script>
    $(document).ready(function () {

        $.jgrid.defaults.styleUI = 'Bootstrap';
        // Examle data for jqGrid
        var mydata = [
            {
                id: "1",
                name: "章硕",
                class: "软工1502",
                qq: "694677073",
                tel: "17671696807",
            },
            {
                id: "2",
                name: "测试数据1",
                class: "软工1501",
                qq: "1213456",
                tel: "17702710807",
            },
            {
                id: "3",
                name: "测试数据1",
                class: "软工1501",
                qq: "1213456",
                tel: "17702710807",
            },
            {
                id: "4",
                name: "测试数据1",
                class: "软工1501",
                qq: "1213456",
                tel: "17702710807",
            },
            {
                id: "5",
                name: "测试数据1",
                class: "软工1501",
                qq: "1213456",
                tel: "17702710807",
            },
            {
                id: "6",
                name: "测试数据1",
                class: "软工1501",
                qq: "1213456",
                tel: "17702710807",
            },
            {
                id: "7",
                name: "测试数据1",
                class: "软工1501",
                qq: "1213456",
                tel: "17702710807",
            },
            {
                id: "8",
                name: "测试数据1",
                class: "软工1501",
                qq: "1213456",
                tel: "17702710807",
            },
            {
                id: "9",
                name: "测试数据1",
                class: "软工1501",
                qq: "1213456",
                tel: "17702710807",
            },
            {
                id: "10",
                name: "测试数据1",
                class: "软工1501",
                qq: "1213456",
                tel: "17702710807",
            },
            {
                id: "11",
                name: "测试数据11",
                class: "计科1502",
                qq: "1213456",
                tel: "17702710807",
            },

        ];


        // Configuration for jqGrid Example 2
        $("#table_list_2").jqGrid({
            data: mydata,
            datatype: "local",
            height: 400,
            autowidth: true,
            shrinkToFit: true,
            rowNum: 20,
            rowList: [10, 20, 30],
            colNames: ['序号','姓名', '班级', 'QQ', '手机号'],
            colModel: [
                {
                    name: 'id',
                    index: 'id',
                    editable: true,
                    width: 60,
                    sorttype: "int",
                    search: true
                },
                {
                    name: 'name',
                    index: 'name',
                    editable: true,
                    width: 60,
                },
                {
                    name: 'class',
                    index: 'class',
                    editable: true,
                    width: 80,
                },
                {
                    name: 'qq',
                    index: 'qq',
                    editable: true,
                    width: 80,
                },
                {
                    name: 'tel',
                    index: 'tel',
                    editable: true,
                    width: 80,
                },
            ],
            pager: "#pager_list_2",
            viewrecords: true,
            caption: "社员信息",
            add: true,
            edit: true,
            addtext: 'Add',
            edittext: 'Edit',
            hidegrid: false
        });

        // Add selection
        $("#table_list_2").setSelection(4, true);


        // Setup buttons
        $("#table_list_2").jqGrid('navGrid', '#pager_list_2', {
            edit: true,
            add: true,
            del: true,
            search: true
        }, {
            height: 300,
            reloadAfterSubmit: true
        });

        // Add responsive to jqGrid
        $(window).bind('resize', function () {
            var width = $('.jqGrid_wrapper').width();
            $('#table_list_2').setGridWidth(width);
        });
    });
</script>




</body>

</html>
