<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!--360浏览器优先以webkit内核解析-->


    <title> - 主页示例</title>

    <link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content">
    <div class="row">
        <div class="col-sm-10">
            <div class="row">
                <div class="col-sm-4">
                    <div class="row row-sm text-center">
                        <div class="col-xs-6">
                            <div class="panel padder-v item">
                                <div class="h1 text-info font-thin h1">302</div>
                                <span class="text-muted text-xs">登记人数</span>
                                <div class="top text-right w-full">
                                    <i class="fa fa-caret-down text-warning m-r-sm"></i>
                                </div>
                            </div>
                        </div>
                        <div class="col-xs-6">
                            <div class="panel padder-v item bg-info">
                                <div class="h1 text-fff font-thin h1">521</div>
                                <span class="text-muted text-xs">缴费成功人数</span>
                                <div class="top text-right w-full">
                                    <i class="fa fa-caret-down text-warning m-r-sm"></i>
                                </div>
                            </div>
                        </div>
                        <div class="col-xs-6">
                            <div class="panel padder-v item bg-primary">
                                <div class="h1 text-fff font-thin h1">521</div>
                                <span class="text-muted text-xs">未缴费人数</span>
                                <div class="top text-right w-full">
                                    <i class="fa fa-caret-down text-warning m-r-sm"></i>
                                </div>
                            </div>
                        </div>
                        <div class="col-xs-6">
                            <div class="panel padder-v item">
                                <div class="font-thin h1">$3720</div>
                                <span class="text-muted text-xs">社费合计</span>
                                <div class="bottom text-left">
                                    <i class="fa fa-caret-up text-warning m-l-sm"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-sm-8">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title" style="border-bottom:none;background:#fff;">
                            <h5>服务器状态</h5>
                        </div>
                        <div class="ibox-content" style="border-top:none;">
                            <div id="flot-line-chart-moving" style="height:217px;">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-5">
                    <div class="ibox float-e-margins">
                        <div class="" id="ibox-content">

                            <div id="vertical-timeline" class="vertical-container light-timeline">
                                <div class="vertical-timeline-block">
                                    <div class="vertical-timeline-icon navy-bg">
                                        <i class="fa fa-upload"></i>
                                    </div>

                                    <div class="vertical-timeline-content">
                                        <h2>后台管理系统上线</h2>
                                        <p>目前系统处于测试阶段，功能正在完善中，若发现BUG请立刻联系我。
                                        </p>
                                        <span class="vertical-date">
                                    章硕 <br>
                                    <small>8月20日</small>
                                </span>
                                    </div>
                                </div>

                                <div class="vertical-timeline-block">
                                    <div class="vertical-timeline-icon blue-bg">
                                        <i class="fa fa-file-text"></i>
                                    </div>

                                    <div class="vertical-timeline-content">
                                        <h2>使用须知</h2>
                                        <p>系统使用详情与介绍在【其他-关于-本站信息】中有详细文档说明，请参考该文档进行使用。</p>
                                        <a href="#" class="btn btn-sm btn-success"> 查看文档 </a>
                                        <span class="vertical-date">
                                    章硕 <br>
                                    <small>8月20日</small>
                                </span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-sm-7">
                    <div class="ibox">
                        <div class="ibox-title">
                            <h5>社员信息</h5>
                            <div class="ibox-tools">
                                <a href="projects.html" class="btn btn-primary btn-xs">社员管理</a>
                            </div>
                        </div>
                        <div class="ibox-content">
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-2">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>前台信息</h5>
                    <div class="ibox-tools">
                        <a href="projects.html" class="btn btn-xs btn-info">前台管理</a>
                    </div>
                </div>
                <div class="ibox-content">
                </div>
            </div>
        </div>
    </div>
</div>
<!-- 全局js -->
<script src="js/jquery.min.js?v=2.1.4"></script>
<script src="js/bootstrap.min.js?v=3.3.6"></script>
<script src="js/plugins/layer/layer.min.js"></script>
<!-- Flot -->
<script src="js/plugins/flot/jquery.flot.js"></script>
<script src="js/plugins/flot/jquery.flot.tooltip.min.js"></script>
<script src="js/plugins/flot/jquery.flot.resize.js"></script>
<script src="js/plugins/flot/jquery.flot.pie.js"></script>
<!-- 自定义js -->
<script src="js/content.js"></script>
<!--flotdemo-->
<script type="text/javascript">
    $(function() {
        var container = $("#flot-line-chart-moving");
        var maximum = container.outerWidth() / 2 || 300;
        var data = [];

        function getRandomData() {
            if (data.length) {
                data = data.slice(1);
            }
            while (data.length < maximum) {
                var previous = data.length ? data[data.length - 1] : 50;
                var y = previous + Math.random() * 10 - 5;
                data.push(y < 0 ? 0 : y > 100 ? 100 : y);
            }
            var res = [];
            for (var i = 0; i < data.length; ++i) {
                res.push([i, data[i]])
            }
            return res;
        }
        series = [{
            data: getRandomData(),
            lines: {
                fill: true
            }
        }];
        var plot = $.plot(container, series, {
            grid: {

                color: "#999999",
                tickColor: "#f7f9fb",
                borderWidth:0,
                minBorderMargin: 20,
                labelMargin: 10,
                backgroundColor: {
                    colors: ["#ffffff", "#ffffff"]
                },
                margin: {
                    top: 8,
                    bottom: 20,
                    left: 20
                },
                markings: function(axes) {
                    var markings = [];
                    var xaxis = axes.xaxis;
                    for (var x = Math.floor(xaxis.min); x < xaxis.max; x += xaxis.tickSize * 2) {
                        markings.push({
                            xaxis: {
                                from: x,
                                to: x + xaxis.tickSize
                            },
                            color: "#fff"
                        });
                    }
                    return markings;
                }
            },
            colors: ["#4fc5ea"],
            xaxis: {
                tickFormatter: function() {
                    return "";
                }
            },
            yaxis: {
                min: 0,
                max: 110
            },
            legend: {
                show: true
            }
        });
        setInterval(function updateRandom() {
            series[0].data = getRandomData();
            plot.setData(series);
            plot.draw();
        }, 40);
    });
</script>
</body>

</html>

