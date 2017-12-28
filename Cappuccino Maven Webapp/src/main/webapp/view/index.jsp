<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Cappuccino Media</title>
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
<link rel="icon" href="images/favicon.ico" type="image/x-icon">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css" />
<link rel="stylesheet" type="text/css" href="css/style.min.css?v=1.2" />
<link rel="stylesheet" type="text/css"
	href="css/plugins/iCheck/custom.css" />
<link rel="stylesheet" type="text/css"
	href="css/plugins/chosen/chosen.css" />
<link rel="stylesheet" type="text/css"
	href="css/plugins/jasny/jasny-bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="css/plugins/daterangepicker/daterangepicker-bs3.css" />
<link rel="stylesheet" type="text/css"
	href="css/plugins/flags/flags.css" />
<link rel="stylesheet" type="text/css"
	href="css/plugins/jvectormap/jquery-jvectormap.css" />
<link rel="stylesheet" type="text/css"
	href="css/plugins/spectrum/spectrum.css" />
<link rel="stylesheet" type="text/css" href="css/animate.css" />
<link rel="stylesheet" type="text/css" href="css/common.css" />
<!-- Mainly scripts -->
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript"
	src="js/plugins/jquery-ui/jquery-ui.min.js"></script>

<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="js/plugins/metisMenu/jquery.metisMenu.js"></script>
<!-- Peity -->
<script type="text/javascript"
	src="js/plugins/peity/jquery.peity.min.js"></script>
<!-- Custom and plugin javascript -->
<script type="text/javascript" src="js/inspinia.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<!-- Custom and plugin javascript -->
<script type="text/javascript" src="js/Chart.min.js"></script>
</head>

<body>
	<div id="wrapper">
		<%@include file="index/left.jsp"%>
		<div id="page-wrapper" class="gray-bg dashbard-1">
			<div class="row border-bottom">
				<nav class="navbar navbar-static-top" role="navigation"
					style="margin-bottom: 0">
					<div class="navbar-header" style="padding-left: 30px">
						<h2 style="margin-top: 16px">
							<i class="fa fa-th-large"></i> Dashboard
						</h2>
					</div>
					<ul class="nav navbar-top-links navbar-right">
						<a
							class="navbar-minimalize btn btn-primary m-t-sm m-r-sm hidden-lg hidden-md hidden-sm pull-right"
							href="javascript:;"> <i class="fa fa-bars"></i> </a>
						<li><img src="images/no_userpic.png" alt="manager avatar"
							style="width: 50px" /></li>
						<li><a style="font-weight: normal" class="hidden-xs">nikichen@freeplayweb.com</a>
						</li>
						<li><a class="dropdown-toggle count-info" href="#"><i
								class="fa fa-envelope"></i> </a></li>
						<li><a href="#"> <i class="fa fa-sign-out"></i> Log out </a>
						</li>
					</ul>
				</nav>
			</div>

			<div class="row border-bottom white-bg dashboard-header">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<h2>Offers</h2>
					<hr>
				</div>
				<div class="row m-t-sm">
					<div
						class="col-lg-2 col-md-4 col-sm-4 col-xs-6 font-thin font-big text-center m-b-sm">
						<span
							class="label label-info font-thin font-big stat-refresh autoload"
							data-period="today"> 465453</span>
						<div class="text-muted">
							<small>Today</small>
						</div>
					</div>
					<div
						class="col-lg-2 col-md-4 col-sm-4 col-xs-6 font-thin font-big text-center m-b-sm">
						<span
							class="label label-primary font-thin font-big stat-refresh autoload"
							data-period="yesterday">645245</span>
						<div class="text-muted">
							<small>Yesterday</small>
						</div>
					</div>
					<div
						class="col-lg-2 col-md-4 col-sm-4 col-xs-6 font-thin font-big text-center m-b-sm">
						<span
							class="label label-default font-thin font-big stat-refresh autoload"
							data-period="last7days">45645</span>
						<div class="text-muted">
							<small>Last 7 days</small>
						</div>
					</div>
					<div
						class="col-lg-2 col-md-4 col-sm-4 col-xs-6 font-thin font-big text-center m-b-sm">
						<span
							class="label label-warning font-thin font-big stat-refresh autoload"
							data-period="this_month">45654</span>
						<div class="text-muted">
							<small>This month</small>
						</div>
					</div>
					<div
						class="col-lg-2 col-md-4 col-sm-4 col-xs-6 font-thin font-big text-center m-b-sm">
						<span
							class="label label-success font-thin font-big stat-refresh autoload"
							data-period="last_month">4654</span>
						<div class="text-muted">
							<small>Last month</small>
						</div>
					</div>
					<div
						class="col-lg-2 col-md-4 col-sm-4 col-xs-6 font-thin font-big text-center m-b-sm">
						<span
							class="label label-danger font-big font-thin stat-refresh autoload"
							data-period="all_time">45654</span>
						<div class="text-muted">
							<small>All time</small>
						</div>
					</div>
				</div>
			</div>



			<div class="wrapper wrapper-content">
				<div class="row">

					<div class="col-lg-12">

						<div class="row">

							<div class="col-lg-6">
								<div class="ibox float-e-margins ui-draggable ui-droppable"
									style="position: relative;">
									<div class="ibox-title">
										<h5>Payout chart</h5>

										<div class="ibox-tools">
											<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
											</a> <a class="close-link"> <i class="fa fa-times"></i> </a>
										</div>
									</div>
									<div class="ibox-content" style="display: block">
										<div class="pull-right">
											<i class="fa fa-spin fa-spinner m-r-sm"
												style="font-size: 18px; display: none;"></i>

											<div class="btn-group"
												data-query-url="dashboard/charts/payouts"
												data-chart-type="payout">
												<button data-role="chart-period" data-period="today"
													class="btn btn-white btn-sm">Today</button>
												<button data-role="chart-period" data-period="yesterday"
													class="btn btn-white btn-sm">Yesterday</button>
												<button data-role="chart-period" data-period="week"
													class="btn btn-white btn-sm active">Week</button>
												<button data-role="chart-period" data-period="this_month"
													class="btn btn-white btn-sm">This Month</button>
												<button data-role="chart-period" data-period="last_month"
													class="btn btn-white btn-sm">Last Month</button>
												<button data-role="chart-period" data-period="year"
													class="btn btn-white btn-sm">Year</button>
											</div>
										</div>
										<!--收益曲线-->
										<div>
											<canvas id="lineChart_payout"></canvas>
										</div>

										<div class="row">
											<div class="col-md-3">
												<span id="payout-chart-total-clicks"
													class="h4 font-bold m-t block">0</span> <small
													class="text-muted m-b block">Total clicks for
													period</small>
											</div>
											<div class="col-md-3">
												<span id="payout-chart-avg-clicks"
													class="h4 font-bold m-t block">0</span> <small
													class="text-muted m-b block">Average clicks per day</small>
											</div>
											<div class="col-md-3">
												<span id="payout-chart-total-payout"
													class="h4 font-bold m-t block">$0.00</span> <small
													class="text-muted m-b block">Total payout for
													period</small>
											</div>
											<div class="col-md-3">
												<span id="payout-chart-avg-payout"
													class="h4 font-bold m-t block">$0.00</span> <small
													class="text-muted m-b block">Average payout per day</small>
											</div>
										</div>
									</div>
								</div>
								<script type="text/javascript">
									if ($('#lineChart_payout').length) {

										var ctx = document
												.getElementById("lineChart_payout");
										var lineChart_payout = new Chart(
												ctx,
												{
													type : 'line',
													data : {
														labels : [ "January",
																"February",
																"March",
																"April", "May",
																"June", "July" ],
														datasets : [
																{
																	label : "My First dataset",
																	backgroundColor : "rgba(38, 185, 154, 0.31)",
																	borderColor : "rgba(38, 185, 154, 0.7)",
																	pointBorderColor : "rgba(38, 185, 154, 0.7)",
																	pointBackgroundColor : "rgba(38, 185, 154, 0.7)",
																	pointHoverBackgroundColor : "#fff",
																	pointHoverBorderColor : "rgba(220,220,220,1)",
																	pointBorderWidth : 1,
																	data : [
																			31,
																			74,
																			6,
																			39,
																			20,
																			85,
																			7 ]
																},
																{
																	label : "My Second dataset",
																	backgroundColor : "rgba(3, 88, 106, 0.3)",
																	borderColor : "rgba(3, 88, 106, 0.70)",
																	pointBorderColor : "rgba(3, 88, 106, 0.70)",
																	pointBackgroundColor : "rgba(3, 88, 106, 0.70)",
																	pointHoverBackgroundColor : "#fff",
																	pointHoverBorderColor : "rgba(151,187,205,1)",
																	pointBorderWidth : 1,
																	data : [
																			82,
																			23,
																			66,
																			9,
																			99,
																			4,
																			2 ]
																} ]
													},
												});

									}
								</script>



							</div>

							<div class="col-lg-6">
								<div class="ibox float-e-margins ui-draggable ui-droppable"
									style="position: relative;">
									<div class="ibox-title">
										<h5>Conversion chart</h5>
										<div class="ibox-tools">
											<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
											</a> <a class="close-link"> <i class="fa fa-times"></i> </a>
										</div>
									</div>
									<div class="ibox-content" style="display: block">
										<div class="pull-right">
											<i class="fa fa-spin fa-spinner m-r-sm"
												style="font-size: 18px; display: none;"></i>
											<div class="btn-group"
												data-query-url="dashboard/charts/conversions"
												data-chart-type="conversions">
												<button data-role="chart-period" data-period="today"
													class="btn btn-white btn-sm active">Today</button>
												<button data-role="chart-period" data-period="yesterday"
													class="btn btn-white btn-sm">Yesterday</button>
												<button data-role="chart-period" data-period="week"
													class="btn btn-white btn-sm ">Week</button>
												<button data-role="chart-period" data-period="this_month"
													class="btn btn-white btn-sm">This Month</button>
												<button data-role="chart-period" data-period="last_month"
													class="btn btn-white btn-sm">Last Month</button>
												<button data-role="chart-period" data-period="year"
													class="btn btn-white btn-sm">Year</button>
											</div>
										</div>

										<div>
											<canvas id="lineChart_Conversion"></canvas>
										</div>

										<div class="row">
											<div class="col-md-3">
												<span id="conversions-chart-cpa"
													class="h4 font-bold m-t block">$0.00</span> <small
													class="text-muted m-b block">Cost Per Action</small>
											</div>
											<div class="col-md-3">
												<span id="conversions-chart-cpc"
													class="h4 font-bold m-t block">$0.00</span> <small
													class="text-muted m-b block">Cost Per Click</small>
											</div>
											<div class="col-md-3">
												<span id="conversions-chart-total-conversions"
													class="h4 font-bold m-t block">0</span> <small
													class="text-muted m-b block">Total conversions</small>
											</div>
											<div class="col-md-3">
												<span id="conversions-chart-avg-conversions"
													class="h4 font-bold m-t block">0</span> <small
													class="text-muted m-b block">Avg conversions per
													day</small>
											</div>
										</div>
									</div>
								</div>
								<script type="text/javascript">
									if ($('#lineChart_Conversion').length) {

										var ctx = document
												.getElementById("lineChart_Conversion");

										var lineChart_Conversion = new Chart(
												ctx,
												{
													type : 'line',
													data : {
														labels : [ "January",
																"February",
																"March",
																"April", "May",
																"June", "July" ],
														datasets : [
																{
																	label : "My First dataset",
																	backgroundColor : "rgba(38, 185, 154, 0.31)",
																	borderColor : "rgba(38, 185, 154, 0.7)",
																	pointBorderColor : "rgba(38, 185, 154, 0.7)",
																	pointBackgroundColor : "rgba(38, 185, 154, 0.7)",
																	pointHoverBackgroundColor : "#fff",
																	pointHoverBorderColor : "rgba(220,220,220,1)",
																	pointBorderWidth : 1,
																	data : [
																			31,
																			74,
																			6,
																			39,
																			20,
																			85,
																			7 ]
																},
																{
																	label : "My Second dataset",
																	backgroundColor : "rgba(3, 88, 106, 0.3)",
																	borderColor : "rgba(3, 88, 106, 0.70)",
																	pointBorderColor : "rgba(3, 88, 106, 0.70)",
																	pointBackgroundColor : "rgba(3, 88, 106, 0.70)",
																	pointHoverBackgroundColor : "#fff",
																	pointHoverBorderColor : "rgba(151,187,205,1)",
																	pointBorderWidth : 1,
																	data : [
																			82,
																			23,
																			66,
																			9,
																			99,
																			4,
																			2 ]
																} ]
													},
												});

									}
								</script>



							</div>
						</div>

						<div class="row">

							<div class="col-lg-12">
								<div class="ibox float-e-margins ui-draggable ui-droppable"
									style="position: relative;">
									<div class="ibox-title">
										<h5>Geography</h5>
										<div class="ibox-tools">
											<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
											</a> <a class="close-link"> <i class="fa fa-times"></i> </a>
										</div>
									</div>
									<div class="ibox-content" style="display: block">
										<div class="row">
											<div class="col-lg-5">
												<div>
													<div class="btn-group"
														data-query-url="dashboard/charts/geo"
														data-chart-type="geo">
														<button data-role="chart-period" data-period="today"
															class="btn btn-white btn-sm">Today</button>
														<button data-role="chart-period" data-period="yesterday"
															class="btn btn-white btn-sm">Yesterday</button>
														<button data-role="chart-period" data-period="week"
															class="btn btn-white btn-sm active">Week</button>
														<button data-role="chart-period" data-period="this_month"
															class="btn btn-white btn-sm">This Month</button>
														<button data-role="chart-period" data-period="last_month"
															class="btn btn-white btn-sm">Last Month</button>
														<button data-role="chart-period" data-period="year"
															class="btn btn-white btn-sm">Year</button>
													</div>
													<i class="fa fa-spin fa-spinner m-r-sm"
														style="font-size: 18px; display: none;"></i>
												</div>
												<table id="geo-top" class="table table-hover">
													<thead>
														<tr>
															<th>Country</th>
															<th class="text-right">Clicks</th>
															<th class="text-right">Conversions</th>
															<th class="text-right">Payout</th>
														</tr>
													</thead>
													<tbody>
														<tr class="geo-row-tpl hidden">
															<td><i class="flag-{geo}"></i> <span
																class="geo-country-name"></span>
															</td>
															<td class="geo-clicks text-right"></td>
															<td class="geo-conversions text-right"></td>
															<td class="text-right"><span
																class="geo-payout label label-success"></span>
															</td>
														</tr>
														<tr class="">
															<td><i class="flag-{geo} flag-JP"></i> <span
																class="geo-country-name">JP</span>
															</td>
															<td class="geo-clicks text-right">399</td>
															<td class="geo-conversions text-right">0</td>
															<td class="text-right"><span
																class="geo-payout label label-success">$ 0.00</span>
															</td>
														</tr>
													</tbody>
												</table>
											</div>

											<div class="col-lg-7">
												<div class="col-lg-12 m-t-md">
													<div id="echart_world_map" style="height:370px;"></div>
												</div>

											</div>

										</div>
									</div>
								</div>

							</div>

						</div>
						<script type="text/javascript">
							//echart Map

							if ($('#echart_world_map').length) {

								var echartMap = echarts.init(document
										.getElementById('echart_world_map'),
										theme);

								alert(1)
								echartMap
										.setOption({
											title : {
												text : 'World Population (2010)',
												subtext : 'from United Nations, Total population, both sexes combined, as of 1 July (thousands)',
												x : 'center',
												y : 'top'
											},
											tooltip : {
												trigger : 'item',
												formatter : function(params) {
													var value = (params.value + '')
															.split('.');
													value = value[0]
															.replace(
																	/(\d{1,3})(?=(?:\d{3})+(?!\d))/g,
																	'$1,')
															+ '.' + value[1];
													return params.seriesName
															+ '<br/>'
															+ params.name
															+ ' : ' + value;
												}
											},
											toolbox : {
												show : true,
												orient : 'vertical',
												x : 'right',
												y : 'center',
												feature : {
													mark : {
														show : true
													},
													dataView : {
														show : true,
														title : "Text View",
														lang : [ "Text View",
																"Close",
																"Refresh", ],
														readOnly : false
													},
													restore : {
														show : true,
														title : "Restore"
													},
													saveAsImage : {
														show : true,
														title : "Save Image"
													}
												}
											},
											dataRange : {
												min : 0,
												max : 1000000,
												text : [ 'High', 'Low' ],
												realtime : false,
												calculable : true,
												color : [ '#087E65', '#26B99A',
														'#CBEAE3' ]
											},
											series : [ {
												name : 'World Population (2010)',
												type : 'map',
												mapType : 'world',
												roam : false,
												mapLocation : {
													y : 60
												},
												itemStyle : {
													emphasis : {
														label : {
															show : true
														}
													}
												},
												data : [
														{
															name : 'Afghanistan',
															value : 28397.812
														},
														{
															name : 'Angola',
															value : 19549.124
														},
														{
															name : 'Albania',
															value : 3150.143
														},
														{
															name : 'United Arab Emirates',
															value : 8441.537
														},
														{
															name : 'Argentina',
															value : 40374.224
														},
														{
															name : 'Armenia',
															value : 2963.496
														},
														{
															name : 'French Southern and Antarctic Lands',
															value : 268.065
														},
														{
															name : 'Australia',
															value : 22404.488
														},
														{
															name : 'Austria',
															value : 8401.924
														},
														{
															name : 'Azerbaijan',
															value : 9094.718
														},
														{
															name : 'Burundi',
															value : 9232.753
														},
														{
															name : 'Belgium',
															value : 10941.288
														},
														{
															name : 'Benin',
															value : 9509.798
														},
														{
															name : 'Burkina Faso',
															value : 15540.284
														},
														{
															name : 'Bangladesh',
															value : 151125.475
														},
														{
															name : 'Bulgaria',
															value : 7389.175
														},
														{
															name : 'The Bahamas',
															value : 66402.316
														},
														{
															name : 'Bosnia and Herzegovina',
															value : 3845.929
														},
														{
															name : 'Belarus',
															value : 9491.07
														},
														{
															name : 'Belize',
															value : 308.595
														},
														{
															name : 'Bermuda',
															value : 64.951
														},
														{
															name : 'Bolivia',
															value : 716.939
														},
														{
															name : 'Brazil',
															value : 195210.154
														},
														{
															name : 'Brunei',
															value : 27.223
														},
														{
															name : 'Bhutan',
															value : 716.939
														},
														{
															name : 'Botswana',
															value : 1969.341
														},
														{
															name : 'Central African Republic',
															value : 4349.921
														},
														{
															name : 'Canada',
															value : 34126.24
														},
														{
															name : 'Switzerland',
															value : 7830.534
														},
														{
															name : 'Chile',
															value : 17150.76
														},
														{
															name : 'China',
															value : 1359821.465
														},
														{
															name : 'Ivory Coast',
															value : 60508.978
														},
														{
															name : 'Cameroon',
															value : 20624.343
														},
														{
															name : 'Democratic Republic of the Congo',
															value : 62191.161
														},
														{
															name : 'Republic of the Congo',
															value : 3573.024
														},
														{
															name : 'Colombia',
															value : 46444.798
														},
														{
															name : 'Costa Rica',
															value : 4669.685
														},
														{
															name : 'Cuba',
															value : 11281.768
														},
														{
															name : 'Northern Cyprus',
															value : 1.468
														},
														{
															name : 'Cyprus',
															value : 1103.685
														},
														{
															name : 'Czech Republic',
															value : 10553.701
														},
														{
															name : 'Germany',
															value : 83017.404
														},
														{
															name : 'Djibouti',
															value : 834.036
														},
														{
															name : 'Denmark',
															value : 5550.959
														},
														{
															name : 'Dominican Republic',
															value : 10016.797
														},
														{
															name : 'Algeria',
															value : 37062.82
														},
														{
															name : 'Ecuador',
															value : 15001.072
														},
														{
															name : 'Egypt',
															value : 78075.705
														},
														{
															name : 'Eritrea',
															value : 5741.159
														},
														{
															name : 'Spain',
															value : 46182.038
														},
														{
															name : 'Estonia',
															value : 1298.533
														},
														{
															name : 'Ethiopia',
															value : 87095.281
														},
														{
															name : 'Finland',
															value : 5367.693
														},
														{
															name : 'Fiji',
															value : 860.559
														},
														{
															name : 'Falkland Islands',
															value : 49.581
														},
														{
															name : 'France',
															value : 63230.866
														},
														{
															name : 'Gabon',
															value : 1556.222
														},
														{
															name : 'United Kingdom',
															value : 62066.35
														},
														{
															name : 'Georgia',
															value : 4388.674
														},
														{
															name : 'Ghana',
															value : 24262.901
														},
														{
															name : 'Guinea',
															value : 10876.033
														},
														{
															name : 'Gambia',
															value : 1680.64
														},
														{
															name : 'Guinea Bissau',
															value : 10876.033
														},
														{
															name : 'Equatorial Guinea',
															value : 696.167
														},
														{
															name : 'Greece',
															value : 11109.999
														},
														{
															name : 'Greenland',
															value : 56.546
														},
														{
															name : 'Guatemala',
															value : 14341.576
														},
														{
															name : 'French Guiana',
															value : 231.169
														},
														{
															name : 'Guyana',
															value : 786.126
														},
														{
															name : 'Honduras',
															value : 7621.204
														},
														{
															name : 'Croatia',
															value : 4338.027
														},
														{
															name : 'Haiti',
															value : 9896.4
														},
														{
															name : 'Hungary',
															value : 10014.633
														},
														{
															name : 'Indonesia',
															value : 240676.485
														},
														{
															name : 'India',
															value : 1205624.648
														},
														{
															name : 'Ireland',
															value : 4467.561
														},
														{
															name : 'Iran',
															value : 240676.485
														},
														{
															name : 'Iraq',
															value : 30962.38
														},
														{
															name : 'Iceland',
															value : 318.042
														},
														{
															name : 'Israel',
															value : 7420.368
														},
														{
															name : 'Italy',
															value : 60508.978
														},
														{
															name : 'Jamaica',
															value : 2741.485
														},
														{
															name : 'Jordan',
															value : 6454.554
														},
														{
															name : 'Japan',
															value : 127352.833
														},
														{
															name : 'Kazakhstan',
															value : 15921.127
														},
														{
															name : 'Kenya',
															value : 40909.194
														},
														{
															name : 'Kyrgyzstan',
															value : 5334.223
														},
														{
															name : 'Cambodia',
															value : 14364.931
														},
														{
															name : 'South Korea',
															value : 51452.352
														},
														{
															name : 'Kosovo',
															value : 97.743
														},
														{
															name : 'Kuwait',
															value : 2991.58
														},
														{
															name : 'Laos',
															value : 6395.713
														},
														{
															name : 'Lebanon',
															value : 4341.092
														},
														{
															name : 'Liberia',
															value : 3957.99
														},
														{
															name : 'Libya',
															value : 6040.612
														},
														{
															name : 'Sri Lanka',
															value : 20758.779
														},
														{
															name : 'Lesotho',
															value : 2008.921
														},
														{
															name : 'Lithuania',
															value : 3068.457
														},
														{
															name : 'Luxembourg',
															value : 507.885
														},
														{
															name : 'Latvia',
															value : 2090.519
														},
														{
															name : 'Morocco',
															value : 31642.36
														},
														{
															name : 'Moldova',
															value : 103.619
														},
														{
															name : 'Madagascar',
															value : 21079.532
														},
														{
															name : 'Mexico',
															value : 117886.404
														},
														{
															name : 'Macedonia',
															value : 507.885
														},
														{
															name : 'Mali',
															value : 13985.961
														},
														{
															name : 'Myanmar',
															value : 51931.231
														},
														{
															name : 'Montenegro',
															value : 620.078
														},
														{
															name : 'Mongolia',
															value : 2712.738
														},
														{
															name : 'Mozambique',
															value : 23967.265
														},
														{
															name : 'Mauritania',
															value : 3609.42
														},
														{
															name : 'Malawi',
															value : 15013.694
														},
														{
															name : 'Malaysia',
															value : 28275.835
														},
														{
															name : 'Namibia',
															value : 2178.967
														},
														{
															name : 'New Caledonia',
															value : 246.379
														},
														{
															name : 'Niger',
															value : 15893.746
														},
														{
															name : 'Nigeria',
															value : 159707.78
														},
														{
															name : 'Nicaragua',
															value : 5822.209
														},
														{
															name : 'Netherlands',
															value : 16615.243
														},
														{
															name : 'Norway',
															value : 4891.251
														},
														{
															name : 'Nepal',
															value : 26846.016
														},
														{
															name : 'New Zealand',
															value : 4368.136
														},
														{
															name : 'Oman',
															value : 2802.768
														},
														{
															name : 'Pakistan',
															value : 173149.306
														},
														{
															name : 'Panama',
															value : 3678.128
														},
														{
															name : 'Peru',
															value : 29262.83
														},
														{
															name : 'Philippines',
															value : 93444.322
														},
														{
															name : 'Papua New Guinea',
															value : 6858.945
														},
														{
															name : 'Poland',
															value : 38198.754
														},
														{
															name : 'Puerto Rico',
															value : 3709.671
														},
														{
															name : 'North Korea',
															value : 1.468
														},
														{
															name : 'Portugal',
															value : 10589.792
														},
														{
															name : 'Paraguay',
															value : 6459.721
														},
														{
															name : 'Qatar',
															value : 1749.713
														},
														{
															name : 'Romania',
															value : 21861.476
														},
														{
															name : 'Russia',
															value : 21861.476
														},
														{
															name : 'Rwanda',
															value : 10836.732
														},
														{
															name : 'Western Sahara',
															value : 514.648
														},
														{
															name : 'Saudi Arabia',
															value : 27258.387
														},
														{
															name : 'Sudan',
															value : 35652.002
														},
														{
															name : 'South Sudan',
															value : 9940.929
														},
														{
															name : 'Senegal',
															value : 12950.564
														},
														{
															name : 'Solomon Islands',
															value : 526.447
														},
														{
															name : 'Sierra Leone',
															value : 5751.976
														},
														{
															name : 'El Salvador',
															value : 6218.195
														},
														{
															name : 'Somaliland',
															value : 9636.173
														},
														{
															name : 'Somalia',
															value : 9636.173
														},
														{
															name : 'Republic of Serbia',
															value : 3573.024
														},
														{
															name : 'Suriname',
															value : 524.96
														},
														{
															name : 'Slovakia',
															value : 5433.437
														},
														{
															name : 'Slovenia',
															value : 2054.232
														},
														{
															name : 'Sweden',
															value : 9382.297
														},
														{
															name : 'Swaziland',
															value : 1193.148
														},
														{
															name : 'Syria',
															value : 7830.534
														},
														{
															name : 'Chad',
															value : 11720.781
														},
														{
															name : 'Togo',
															value : 6306.014
														},
														{
															name : 'Thailand',
															value : 66402.316
														},
														{
															name : 'Tajikistan',
															value : 7627.326
														},
														{
															name : 'Turkmenistan',
															value : 5041.995
														},
														{
															name : 'East Timor',
															value : 10016.797
														},
														{
															name : 'Trinidad and Tobago',
															value : 1328.095
														},
														{
															name : 'Tunisia',
															value : 10631.83
														},
														{
															name : 'Turkey',
															value : 72137.546
														},
														{
															name : 'United Republic of Tanzania',
															value : 44973.33
														},
														{
															name : 'Uganda',
															value : 33987.213
														},
														{
															name : 'Ukraine',
															value : 46050.22
														},
														{
															name : 'Uruguay',
															value : 3371.982
														},
														{
															name : 'United States of America',
															value : 312247.116
														},
														{
															name : 'Uzbekistan',
															value : 27769.27
														},
														{
															name : 'Venezuela',
															value : 236.299
														},
														{
															name : 'Vietnam',
															value : 89047.397
														},
														{
															name : 'Vanuatu',
															value : 236.299
														},
														{
															name : 'West Bank',
															value : 13.565
														},
														{
															name : 'Yemen',
															value : 22763.008
														},
														{
															name : 'South Africa',
															value : 51452.352
														}, {
															name : 'Zambia',
															value : 13216.985
														}, {
															name : 'Zimbabwe',
															value : 13076.978
														} ]
											} ]
										});

							}
						</script>
						<div class="row">
							<div class="col-lg-6">

								<div class="ibox float-e-margins ui-draggable ui-droppable"
									style="position: relative">
									<div class="ibox-title">
										<h5>Your top converting offers</h5>
										<div class="ibox-tools">
											<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
											</a> <a class="close-link"> <i class="fa fa-times"></i> </a>
										</div>
									</div>
									<div class="ibox-content" style="display: block">
										<div class="pull-right">
											<i class="fa fa-spin fa-spinner m-r-sm"
												style="font-size: 18px; display: none;"></i>
											<div class="btn-group"
												data-query-url="dashboard/charts/top_offers"
												data-chart-type="top">
												<button data-role="chart-period" data-period="today"
													class="btn btn-white btn-sm">Today</button>
												<button data-role="chart-period" data-period="yesterday"
													class="btn btn-white btn-sm">Yesterday</button>
												<button data-role="chart-period" data-period="week"
													class="btn btn-white btn-sm active">Week</button>
												<button data-role="chart-period" data-period="this_month"
													class="btn btn-white btn-sm">This Month</button>
												<button data-role="chart-period" data-period="last_month"
													class="btn btn-white btn-sm">Last Month</button>
												<button data-role="chart-period" data-period="year"
													class="btn btn-white btn-sm">Year</button>
											</div>
										</div>

										<div>

											<div class="m-t-md" style="height: 20px; overflow: auto;">

											</div>
											<div class="top-offer-item border-bottom m-t-sm">
												<div class="clearfix"></div>
											</div>
											<div class="top-offer-item border-bottom m-t-sm">
												<span class="label label-info pull-left m-r-md">3</span> <span>
													<a data-toggle="ajaxModal"> <img
														class="img-circle pull-left m-r-sm m-b-sm related-offer"
														title="Show quick info" data-placement="right"
														src="http://publishers.turbob.mobi/creatives/Eueob2nNaNpYc1Rm1GvwKJuPUF8xZi7TC2zWy8IJ"
														style="width:50px"> </a> </span> <a
													href="http://publishers.turbob.mobi/offers/details/42767"
													style="font-size: 13px">Data Recharge &amp; Data Saver
													4G CPR (Android 3.0+) IN - Incent</a>

												<h3 class="font-noraml text-navy">$ 0.09</h3>

												<div class="clearfix"></div>
											</div>

										</div>
									</div>
								</div>




							</div>

							<div class="col-lg-6">
								<div class="ibox float-e-margins ui-draggable ui-droppable"
									style="position: relative;">
									<div class="ibox-title">
										<h5>Top converting offers</h5>

										<div class="ibox-tools">
											<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
											</a> <a class="close-link"> <i class="fa fa-times"></i> </a>
										</div>
									</div>
									<div class="ibox-content">
										<div>
											<div class="top-offer-item border-bottom m-t-sm">
												<span class="label label-info pull-left m-r-md">1</span> <span>
													<a data-toggle="modal" data-target="#myModal"> <img
														class="img-circle pull-left m-r-sm m-b-sm related-offer"
														title="Show quick info" data-placement="right"
														src="http://publishers.turbob.mobi/creatives/hYv4FZ2Xjl3wN60aH6En7trigOpJlE3U3tFjO887"
														style="width:50px"> </a> </span> <a href="#"
													style="font-size: 13px">DeutschlandCard (Android 4.1+)
													DE - Incent</a>

												<h3 class="font-noraml text-navy">$ 0.17</h3>

												<div class="clearfix"></div>
											</div>

										</div>
										<div class="m-t-lg">
											<a href="#" class="btn btn-primary btn-sm btn-block"><i
												class="fa fa-arrow-down"></i> Show more</a>
										</div>
									</div>

								</div>
								<!-- // Top offers -->
							</div>

						</div>
					</div>

				</div>
			</div>



		</div>
	</div>
	<!-- -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">×</button>
					<h3 class="modal-title">
						Quick info <small>To view full details click "Offer
							details" button below</small>
					</h3>
				</div>

				<div class="modal-body">

					<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 m-b-md">
						<div class="row">
							<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10 m-b-md">
								<h2 class="m-t-xs">
									#42767 <a
										href="http://publishers.turbob.mobi/offers/details/42767"
										title="" data-original-title="Click to open offer details">Data
										Recharge &amp; Data Saver 4G CPR (Android 3.0+) IN - Incent</a>
								</h2>
							</div>
							<div class="col-lg-2 col-md-2 hidden-sm hidden-xs">
								<div class="offer-thumb m-b-md pull-right">
									<img class="img-rounded" style="width: 80px"
										src="http://publishers.turbob.mobi/creatives/Eueob2nNaNpYc1Rm1GvwKJuPUF8xZi7TC2zWy8IJ">
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 m-b-md">
								<div style="padding: 5px; border: 1px solid #eee">
									<div style="height: 120px; overflow: auto; ">
										<p>
											<b>Databack saves your 2G, 3G and 4G mobile data</b> that you
											spend when using apps.<br>Save upto 500MB mobile data
											every month !<br>Saved data can be used to recharge your
											phone for free :)<br> <br>TOP FEATURES<br> <br>
											<b>1. Data Saver</b><br>Databack saves upto 20% of your
											mobile data everyday! <br>Install Databack --&gt; use
											your favourite apps --&gt; save data<br> <br> <b>2.
												Spin &amp; Win 3G/4G</b><br>Win upto 50MB daily bonus from
											Spin the wheel<br> <br> <br> <b>3. Data
												Monitor</b><br>i) See which app uses maximum mobile data<br>ii)
											Live data tracker shows you data consumed by each app in
											real-time<br> <br> <b>4. Offline mode</b><br>Databack
											works without internet also<br>Monitor your internet
											usage in offline mode also (no internet required)<br> <br>
											<b>5. Free Data Recharge</b><br>Take free data recharge
											packs from the data you save!<br> <br> <br>You
											will also <b>get 50MB mobile data</b> for every friend who
											joins on your invitation.<br> <br>Our app is still
											new - please help us improve our app by sending in your
											feedback and suggestions.<br>Please write to us at
											support@databackapp.com<br> <br>Install now to
											start saving your mobile data &amp; get free mobile data
											recharges :)<br> <br> <br>Recharges work just
											the way your regular data recharges work.<br>No
											restriction whatsoever!
										</p>
										<p>
											<br>
										</p>
										<p>
											<span
												style="font-weight: bold; color: inherit; font-size: 13px;">conversion
												flow: install + open + register</span><br>
										</p>
									</div>
								</div>
							</div>

						</div>
					</div>


					<div class="col-lg-6 col-md-6 m-b-md">
						<table class="table table-condensed">
							<thead>
								<tr>
									<td>Payout</td>
									<td><span style="font-size: 16px">$0.09</span></td>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>Platforms</td>
									<td class="font-bold">Android 3.0+</td>
								</tr>
								<tr>
									<td>Geography</td>
									<td style="line-height: 24px;"><label class="label"
										title="India">IN</label></td>
								</tr>
								<tr>
									<td>Categories</td>
									<td><label class="label label-info">Lifestyle</label></td>
								</tr>
								<tr>
									<td>Approval</td>
									<td class="font-bold text-navy">Approved</td>

								</tr>
								<tr>
									<td>Date start/end</td>
									<td>2017/04/04 - 2018/04/04</td>
								</tr>
								<tr>
									<td>Landing page</td>
									<td><a
										href="https://play.google.com/store/apps/details?id=free.mobile.internet.data.recharge"
										target="_blank">Preview <i
											class="fa fa-external-link-square"></i> </a></td>
								</tr>
							</tbody>
						</table>

						<span data-toggle="collapse" data-target="#offer_goal_popup_42767"
							style="cursor: pointer; font-size: 14px"> Goals <span
							class="badge badge-info">1</span> </span>

						<div class="collapse" id="offer_goal_popup_42767">
							<h4>Install</h4>
							<table class="table table-condensed goals">
								<tbody>
									<tr>
										<td style="width: 35%">Payout</td>
										<td><span class="m-r-sm" title="Payout"
											style="font-size: 16px"> $0.09</span></td>
									</tr>
									<tr>
										<td style="width: 35%">Geography</td>
										<td style="line-height: 24px;"><label class="label"
											title="India">IN</label></td>
									</tr>
									<tr>
										<td style="width: 35%">Platforms</td>
										<td class="font-bold">Android 3.0+</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>

					<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 m-b-md">
						<table style="width: 100%; vertical-align: top">
							<tbody>
								<tr>
									<td style="vertical-align: top">
										<h4>Allowed traffic</h4>
										<ul class="allowed-traffic">
											<li><i class="fa fa-check"></i> Incentivized traffic</li>
										</ul></td>

									<td style="vertical-align: top">
										<h4>Restricted traffic</h4>
										<ul class="restricted-traffic">
											<li><i class="fa fa-close"></i> Adult traffic</li>
											<li><i class="fa fa-close"></i> Bot traffic</li>
											<li><i class="fa fa-close"></i> Fraudulent traffic</li>
										</ul></td>
								</tr>
							</tbody>
						</table>
					</div>

				</div>


				<div class="clearfix"></div>

				<div class="modal-footer">
					<a href="#" class="btn btn-white" data-dismiss="modal"><i
						class="fa fa-remove m-r-xs" style="opacity:0.5"></i> Close</a> <a
						href="http://publishers.turbob.mobi/offers/details/42767"
						class="btn btn-primary"><i class="fa fa-reorder m-r-xs"
						style="opacity:0.5"></i> Offer details</a>

				</div>
			</div>
		</div>


	</div>

</body>
</html>



