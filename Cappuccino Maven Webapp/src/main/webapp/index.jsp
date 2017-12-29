<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@include file="../base/head.jsp"%>
<script type="text/javascript" src="js/payout.js"></script>
<script type="text/javascript" src="js/echarts.js"></script>
<body>
	<div id="wrapper">
		<nav class="navbar-default navbar-static-side" role="navigation">
			<div class="sidebar-collapse">
				<ul class="nav" id="side-menu">
					<li class="nav-header" id="test"
						style="background-size: 100% 100%; padding-top: 14px">
						<div>
							<img src="images/logo.jpg" class="hidden-xs" alt="Logo"
								style="width: 180px;" />
						</div>
						<div class="dropdown profile-element">
							<div class="m-t">
								<div>
									<span class="text-muted font-thin">Server time</span> <span
										id="server-time" class="text-success font-thin pull-right"
										style="font-size: 20px; margin-top: -2px;"> 10:34:23 </span>
									<div class="text-left"
										style="font-size: 18px; margin-top: -2px; color: #B2E1CA">GMT+3</div>
								</div>
							</div>
							<div class="m-t">
								<div>
									<span class="text-muted font-thin">Today</span> <span
										class="text-warning font-thin pull-right stat-refresh autoload"
										data-period="today" style="font-size: 20px; margin-top: -2px;">
									</span>
								</div>
							</div>

							<div class="m-t">
								<div>
									<span class="text-muted font-thin">Approved offers</span> <span
										class="text-warning font-thin pull-right"
										style="font-size: 20px; margin-top: -2px;"> 2 </span>
								</div>
							</div>

							<div class="m-t">
								<div>
									<span class="text-muted font-thin">Clicks</span> <span
										class="text-warning font-thin pull-right"
										style="font-size: 20px;">5656464 <span
										class="minibar-traffic-publisher" title="14 days traffic"></span>
									</span>
								</div>
							</div>

							<div class="m-t">
								<div>
									<span class="text-muted font-thin">Conversions</span> <span
										class="text-warning font-thin pull-right"
										style="font-size: 20px;">12454 <span
										class="minibar-conversions-publisher" title="14 days revenue"></span>
									</span>
								</div>
							</div>

							<div class="m-t">
								<div>
									<span class="text-muted font-thin">Payout</span> <span
										class="text-warning font-thin pull-right"
										style="font-size: 20px;">$45457 <span
										class="minibar-revenue-publisher" title="14 days revenue"></span>
									</span>
								</div>
							</div>

							<form method="get" action="">
								<div style="margin-top: 32px;" class="input-group">
									<input class="form-control text-navy"
										placeholder="Search offers" name="search"
										title="Type keyword or offer ID"
										style="background: transparent; border: 1px solid #1ab394; padding: 7px; font-size: 13px"
										type="text"> <span class="input-group-btn">
										<button class="btn btn-primary" type="submit">
											<i class="fa fa-search"></i>
										</button> </span>

								</div>
							</form>

							<div style="margin-top: 10px;"
								class="font-bold text-muted hidden">
								<small>Server time</small> <span class="pull-right">Dec
									27, 10:23</span>
								<div class="text-left"
									style="font-size: 12px; margin-top: -2px; color: #B2E1CA">Etc/GMT-3</div>
							</div>
							<div style="margin-top: 10px;"
								class="font-bold text-muted hidden">
								<small>Today</small> <span class="label label-danger pull-right">$
									-155.97</span>
							</div>

						</div></li>
				</ul>
			</div>
		</nav>

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

											<div class="btn-group" id="btn-1">
												<!-- data-query-url="dashboard/charts/payouts" data-chart-type="payout" -->
												<button data-role="chart-period" data-period="today"
													class="btn btn-white btn-sm active"
													onclick="loadResEvent(this)">Today</button>
												<button data-role="chart-period" data-period="yesterday"
													class="btn btn-white btn-sm" onclick="loadResEvent(this)">Yesterday</button>
												<button data-role="chart-period" data-period="week"
													class="btn btn-white btn-sm " onclick="loadResEvent(this)">Week</button>
												<button data-role="chart-period" data-period="this_month"
													class="btn btn-white btn-sm" onclick="loadResEvent(this)">This
													Month</button>
												<button data-role="chart-period" data-period="last_month"
													class="btn btn-white btn-sm" onclick="loadResEvent(this)">Last
													Month</button>
												<button data-role="chart-period" data-period="year"
													class="btn btn-white btn-sm" onclick="loadResEvent(this)">Year</button>
											</div>
										</div>

										<div>
											<div id="main"
												style="height:350px; weight:676px; margin-top:25px;"></div>
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
											<div id="lineChart2"
												style="height:350px; weight:476px; margin-top:25px;"></div>
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
													<div id="main_world" style="height:300px;"></div>
												</div>

											</div>

										</div>
									</div>
								</div>
							</div>
						</div>

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
									#42767 <a href="#" title=""
										data-original-title="Click to open offer details">Data
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




