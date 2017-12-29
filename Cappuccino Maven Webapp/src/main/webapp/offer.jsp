<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
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

<style>
.all-offers>div:hover {
	background: #f5f5f5;
}
</style>
</head>
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

						</div>
					</li>
				</ul>
			</div>
		</nav>
		<div id="page-wrapper" class="gray-bg dashbard-1">
			<div class="row border-bottom">
				<nav class="navbar navbar-static-top" role="navigation"
					style="margin-bottom: 0">
					<div class="navbar-header" style="padding-left: 30px">
						<h2 style="margin-top: 16px">
							<i class="fa fa-shopping-cart"></i> Approved offers
						</h2>
					</div>
					<ul class="nav navbar-top-links navbar-right">
						<a
							class="navbar-minimalize btn btn-primary m-t-sm m-r-sm hidden-lg hidden-md hidden-sm pull-right"
							href="javascript:;"> <i class="fa fa-bars"></i> </a>
						<li><img
							src="http://publishers.turbob.mobi/_assets/img/no_userpic.png"
							alt="manager avatar" style="width: 50px" />
						</li>
						<li><a style="font-weight: normal" class="hidden-xs">nikichen@freeplayweb.com</a>
						</li>
						<li><a class="dropdown-toggle count-info"
							href="http://publishers.turbob.mobi/support"><i
								class="fa fa-envelope"></i> </a>
						</li>
						<li><a href="http://turbob.mobi/logout"> <i
								class="fa fa-sign-out"></i> Log out </a>
						</li>
					</ul>
				</nav>
			</div>


			<div class="wrapper wrapper-content animated fadeInRight">
				<form method="get">
					<div class="row">
						<div id="offers-area"
							class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-inline">
							<div class="ibox float-e-margins no-drop">
								<div class="ibox-title blue">
									<div class="pull-right" style="margin-top: -9px">
										<button type="button" class="btn btn-success"
											id="search-button">
											<i class="fa fa-search"></i> Search
										</button>
									</div>
									<h5>
										Browse approved offers <small class="m-l-sm"> Click on
											the thumbnail to see offer's quick info. </small>
									</h5>
								</div>
								<div class="ibox-content">
									<div class="row m-b-md">
										<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
											<div class="inline" style="width: 100%">
												<div class="input-group m-r-md m-b-xs">
													<input name="search" type="text" class="form-control"
														value="" placeholder="Search name or ID" style="">
													<span class="input-group-btn">
														<button class="btn btn-primary" type="submit">
															<i class="fa fa-search"></i>
														</button> </span>
												</div>

												<div class="btn-group m-b-xs">
													<input type="hidden" id="sort" name="sort" value="id" /> <input
														type="hidden" id="order" name="order" value="desc" />
													<div class="dropdown btn-group inline">
														<button class="btn btn-white" type="button"
															title="Sort by" data-toggle="dropdown"
															aria-haspopup="true" role="button" aria-expanded="false">
															Offer ID <span class="caret"></span>
														</button>
														<button class="btn btn-white" type="button"
															title="Sort direction"
															onclick="$('input#order').val($('input#order').val()=='asc' ? 'desc' : 'asc'); $(this).parents('form').submit()">
															<i class="fa fa-sort-amount-desc"></i>
														</button>
														<ul class="dropdown-menu" role="menu"
															aria-labelledby="dLabel">
															<li><a
																onclick="$('input#sort').val('id'); $(this).parents('form').submit()">Offer
																	ID</a>
															</li>
															<li><a
																onclick="$('input#sort').val('name'); $(this).parents('form').submit()">Offer
																	name</a>
															</li>
															<li><a
																onclick="$('input#sort').val('payout'); $(this).parents('form').submit()">Payout</a>
															</li>
															<li><a
																onclick="$('input#sort').val('ratio'); $(this).parents('form').submit()">Global
																	conversion ratio</a>
															</li>
															<li><a
																onclick="$('input#sort').val('date'); $(this).parents('form').submit()">Date
																	created</a>
															</li>
															<li><a
																onclick="$('input#sort').val('geo'); $(this).parents('form').submit()">Geography</a>
															</li>
															<li><a
																onclick="$('input#sort').val('platform'); $(this).parents('form').submit()">Platform</a>
															</li>
															<li><a
																onclick="$('input#sort').val('tag'); $(this).parents('form').submit()">Category</a>
															</li>
														</ul>
													</div>
												</div>
												<div class="btn-group m-b-xs">
													<select id="o_type" name="o_type"
														class="form-control chosen-select-width"
														title="Offer type"
														onchange="$(this).parents(&quot;form&quot;).submit();">
														<option selected="selected" value="1">Mobile Apps</option>
														<option value="2">CPA</option>
														<option value="3">Dynamic</option>
														<option value="0">All</option>
														<option value="10">Mobile Apps & CPA</option>
													</select>
												</div>

												<div class="btn-group m-r-md btn-select-all">
													<a class="btn btn-success btn-sm"
														onclick="$('.selector .sel').iCheck('check')"
														style="width: 99px"> <i class="fa fa-check-square-o"
														aria-hidden="true"></i> select all </a>
												</div>
												<div class="btn-group m-r-md btn-unselect-all"
													style="display: none;">
													<a class="btn btn-default btn-sm"
														onclick="$('.selector .sel').iCheck('uncheck')"
														style="width: 99px"> <i class="fa fa-square-o"
														aria-hidden="true"></i> unselect all </a>
												</div>
											</div>
										</div>
									</div>

									<div class="all-offers">
										<div class="row"
											style="padding-bottom: 10px; padding-top: 10px; border-top: 1px solid #eee">
											<div class="col-lg-2 col-md-3 col-sm-3 col-xs-3">
												<div
													style="width: 24px; height: 80px; display: inline-block"
													class="pull-left m-r-md">
													<div class="checkbox i-checks selector"
														style="margin-top: 30px" data-id="42767">
														<label> <input class="sel-disabled"
															type="checkbox" name="sel[]" value="42767" disabled /> </label>
													</div>
												</div>
												<a data-toggle="ajaxModal" data-remote="/offers/popup/42767">
													<img
													src="http://publishers.turbob.mobi/creatives/Eueob2nNaNpYc1Rm1GvwKJuPUF8xZi7TC2zWy8IJ"
													class="img-responsive img-rounded related-offer"
													title="Show quick info" data-placement="right"
													style="width: 80px"> </a>
											</div>

											<div class="col-lg-10 col-md-9 col-sm-9 col-xs-9">
												<div class="row">
													<div class="col-xs-12 col-sm-12 col-md-12 col-lg-6 m-b-sm">
														<h4>
															<img class="os-logo"
																src="http://publishers.turbob.mobi/_assets/img/android_logo.png"
																title="Android" style="margin-top: -4px"> <a
																href="http://publishers.turbob.mobi/offers/details/42767">
																Data Recharge &amp; Data Saver 4G CPR (Android 3.0+) IN
																- Incent </a> <a
																href="http://publishers.turbob.mobi/offers?type=1&options=1">
																<i class="fa fa-asterisk" style="color:#FF5555"
																title="Incent"></i> </a>

														</h4>

														<div style="line-height: 24px">
															<span class="label" title="Offer ID"
																data-placement="bottom" style="vertical-align: middle">
																#42767</span> <span class="m-l-sm m-r-sm" title="Payout"
																data-placement="bottom"
																style="font-size: 16px; vertical-align: middle">
																$0.09 </span> <a
																href="https://play.google.com/store/apps/details?id=free.mobile.internet.data.recharge"
																class="text-navy preview-link"
																style="padding:3px; vertical-align: middle"
																target="_blank"><i
																class="fa fa-external-link-square"></i> Preview</a> <span
																class="label" title="Offer type" data-placement="bottom"
																style="vertical-align: middle"> Mobile Apps</span>
														</div>
													</div>
													<div class="col-xs-12 col-sm-12 col-md-12 col-lg-3 m-b-md">
														<span style="line-height: 24px"> <a
															href="http://publishers.turbob.mobi/offers?geo[]=IN&options=1"
															class="label" title="India">IN</a> </span> <span
															style="line-height: 24px"> <a
															href="http://publishers.turbob.mobi/offers?tags[]=17&options=1"
															class="label label-info">Lifestyle</a> </span>
													</div>
													<div class="col-xs-12 col-sm-12 col-md-12 col-lg-3">
														<a
															href="http://publishers.turbob.mobi/offers/details/42767"
															class="btn btn-primary"
															title="View offer details and grab tracking links"> <i
															class="fa fa-bullhorn m-r-xs" style="opacity:0.5"></i>
															Promote </a>
													</div>
												</div>
											</div>
										</div>
										<div class="row"
											style="padding-bottom: 10px; padding-top: 10px; border-top: 1px solid #eee">
											<div class="col-lg-2 col-md-3 col-sm-3 col-xs-3">
												<div
													style="width: 24px; height: 80px; display: inline-block"
													class="pull-left m-r-md">
													<div class="checkbox i-checks selector"
														style="margin-top: 30px" data-id="20169">
														<label> <input class="sel-disabled"
															type="checkbox" name="sel[]" value="20169" disabled /> </label>
													</div>
												</div>
												<a data-toggle="ajaxModal" data-remote="/offers/popup/20169">
													<img
													src="http://publishers.turbob.mobi/creatives/s6TAZJHCaf1Bp63vW5hXIRVCS2W8wBM7HcogZEqj"
													class="img-responsive img-rounded related-offer"
													title="Show quick info" data-placement="right"
													style="width: 80px"> </a>
											</div>

											<div class="col-lg-10 col-md-9 col-sm-9 col-xs-9">
												<div class="row">
													<div class="col-xs-12 col-sm-12 col-md-12 col-lg-6 m-b-sm">
														<h4>
															<img class="os-logo"
																src="http://publishers.turbob.mobi/_assets/img/android_logo.png"
																title="Android" style="margin-top: -4px"> <a
																href="http://publishers.turbob.mobi/offers/details/20169">
																File Manager (Android 4.0.3+) US DE JP - Non incent </a>
														</h4>
														<div style="line-height: 24px">
															<span class="label" title="Offer ID"
																data-placement="bottom" style="vertical-align: middle">
																#20169</span> <span class="m-l-sm m-r-sm" title="Payout"
																data-placement="bottom"
																style="font-size: 16px; vertical-align: middle">
																$0.39 </span> <a
																href="https://play.google.com/store/apps/details?id=com.onegogo.explorer"
																class="text-navy preview-link"
																style="padding:3px; vertical-align: middle"
																target="_blank"><i
																class="fa fa-external-link-square"></i> Preview</a> <span
																class="label" title="Offer type" data-placement="bottom"
																style="vertical-align: middle"> Mobile Apps</span>
														</div>
													</div>
													<div class="col-xs-12 col-sm-12 col-md-12 col-lg-3 m-b-md">
														<span style="line-height: 24px"> <a
															href="http://publishers.turbob.mobi/offers?geo[]=US&options=1"
															class="label" title="United States">US</a> <a
															href="http://publishers.turbob.mobi/offers?geo[]=DE&options=1"
															class="label" title="Germany">DE</a> <a
															href="http://publishers.turbob.mobi/offers?geo[]=JP&options=1"
															class="label" title="Japan">JP</a> </span> <span
															style="line-height: 24px"> <a
															href="http://publishers.turbob.mobi/offers?tags[]=23&options=1"
															class="label label-info">Tools</a> </span>
													</div>
													<div class="col-xs-12 col-sm-12 col-md-12 col-lg-3">
														<a
															href="http://publishers.turbob.mobi/offers/details/20169"
															class="btn btn-primary"
															title="View offer details and grab tracking links"> <i
															class="fa fa-bullhorn m-r-xs" style="opacity:0.5"></i>
															Promote </a>
													</div>
												</div>
											</div>
										</div>
										<div class="row"
											style="padding-bottom: 10px; padding-top: 10px; border-top: 1px solid #eee">
											<div class="col-lg-2 col-md-3 col-sm-3 col-xs-3">
												<div
													style="width: 24px; height: 80px; display: inline-block"
													class="pull-left m-r-md">
													<div class="checkbox i-checks selector"
														style="margin-top: 30px" data-id="10115">
														<label> <input class="sel-disabled"
															type="checkbox" name="sel[]" value="10115" disabled /> </label>
													</div>
												</div>
												<a data-toggle="ajaxModal" data-remote="/offers/popup/10115">
													<img
													src="http://publishers.turbob.mobi/creatives/cbIlkPnNetj060xOYn1XUwzrNnLunLJrQ0IVTsg4"
													class="img-responsive img-rounded related-offer"
													title="Show quick info" data-placement="right"
													style="width: 80px"> </a>
											</div>

											<div class="col-lg-10 col-md-9 col-sm-9 col-xs-9">
												<div class="row">
													<div class="col-xs-12 col-sm-12 col-md-12 col-lg-6 m-b-sm">
														<h4>
															<img class="os-logo"
																src="http://publishers.turbob.mobi/_assets/img/android_logo.png"
																title="Android" style="margin-top: -4px"> <a
																href="http://publishers.turbob.mobi/offers/details/10115">
																Bitbop - LIVE (Android 3.0+) AE - Non incent </a>


														</h4>

														<div style="line-height: 24px">
															<span class="label" title="Offer ID"
																data-placement="bottom" style="vertical-align: middle">
																#10115</span> <span class="m-l-sm m-r-sm" title="Payout"
																data-placement="bottom"
																style="font-size: 16px; vertical-align: middle">
																$0.62 </span> <a
																href="https://play.google.com/store/apps/details?id=com.freenet.bitbop"
																class="text-navy preview-link"
																style="padding:3px; vertical-align: middle"
																target="_blank"><i
																class="fa fa-external-link-square"></i> Preview</a> <span
																class="label" title="Offer type" data-placement="bottom"
																style="vertical-align: middle"> Mobile Apps</span>
														</div>
													</div>
													<div class="col-xs-12 col-sm-12 col-md-12 col-lg-3 m-b-md">
														<span style="line-height: 24px"> <a
															href="http://publishers.turbob.mobi/offers?geo[]=AE&options=1"
															class="label" title="United Arab Emirates">AE</a> </span> <span
															style="line-height: 24px"> <a
															href="http://publishers.turbob.mobi/offers?tags[]=14&options=1"
															class="label label-info">Entertainment</a> </span>
													</div>
													<div class="col-xs-12 col-sm-12 col-md-12 col-lg-3">
														<a
															href="http://publishers.turbob.mobi/offers/details/10115"
															class="btn btn-primary"
															title="View offer details and grab tracking links"> <i
															class="fa fa-bullhorn m-r-xs" style="opacity:0.5"></i>
															Promote </a>
													</div>
												</div>
											</div>
										</div>
										<div class="row"
											style="padding-bottom: 10px; padding-top: 10px; border-top: 1px solid #eee">
											<div class="col-lg-2 col-md-3 col-sm-3 col-xs-3">
												<div
													style="width: 24px; height: 80px; display: inline-block"
													class="pull-left m-r-md">
													<div class="checkbox i-checks selector"
														style="margin-top: 30px" data-id="37">
														<label> <input class="sel-disabled"
															type="checkbox" name="sel[]" value="37" disabled /> </label>
													</div>
												</div>
												<a data-toggle="ajaxModal" data-remote="/offers/popup/37">
													<img
													src="http://publishers.turbob.mobi/creatives/aInmKjrAhh5IkSQT4PSCubuik7OtwaCubUJp8PRv"
													class="img-responsive img-rounded related-offer"
													title="Show quick info" data-placement="right"
													style="width: 80px"> </a>
											</div>

											<div class="col-lg-10 col-md-9 col-sm-9 col-xs-9">
												<div class="row">
													<div class="col-xs-12 col-sm-12 col-md-12 col-lg-6 m-b-sm">
														<h4>
															<img class="os-logo"
																src="http://publishers.turbob.mobi/_assets/img/android_logo.png"
																title="Android" style="margin-top: -4px"> <a
																href="http://publishers.turbob.mobi/offers/details/37">
																Cellfun (Android 3.0+) PL - Incent </a> <a
																href="http://publishers.turbob.mobi/offers?type=1&options=1">
																<i class="fa fa-asterisk" style="color:#FF5555"
																title="Incent"></i> </a>

														</h4>

														<div style="line-height: 24px">
															<span class="label" title="Offer ID"
																data-placement="bottom" style="vertical-align: middle">
																#37</span> <span class="m-l-sm m-r-sm" title="Payout"
																data-placement="bottom"
																style="font-size: 16px; vertical-align: middle">
																$0.59 </span> <a
																href="https://play.google.com/store/apps/details?id=com.specialapps.cellfun"
																class="text-navy preview-link"
																style="padding:3px; vertical-align: middle"
																target="_blank"><i
																class="fa fa-external-link-square"></i> Preview</a> <span
																class="label" title="Offer type" data-placement="bottom"
																style="vertical-align: middle"> Mobile Apps</span>
														</div>
													</div>
													<div class="col-xs-12 col-sm-12 col-md-12 col-lg-3 m-b-md">
														<span style="line-height: 24px"> <a
															href="http://publishers.turbob.mobi/offers?geo[]=PL&options=1"
															class="label" title="Poland">PL</a> </span> <span
															style="line-height: 24px"> <a
															href="http://publishers.turbob.mobi/offers?tags[]=14&options=1"
															class="label label-info">Entertainment</a> </span>
													</div>
													<div class="col-xs-12 col-sm-12 col-md-12 col-lg-3">
														<a href="http://publishers.turbob.mobi/offers/details/37"
															class="btn btn-primary"
															title="View offer details and grab tracking links"> <i
															class="fa fa-bullhorn m-r-xs" style="opacity:0.5"></i>
															Promote </a>
													</div>
												</div>
											</div>
										</div>

									</div>
									<ul class="pagination auto-pagination pull-right m-t-lg"
										data-count="4" data-size="15" data-current="1"
										data-url="?page={page}">
										<li class="prev-page"><a href="#">‹</a></li>
										<li class="page-button"><a href="#">1</a></li>
										<li class="next-page"><a href="#">›</a></li>
									</ul>
									<input type="hidden" name="page" value="1">
									<div class="clearfix"></div>
								</div>
							</div>
						</div>


						<div id="search-options"
							class="col-lg-3 col-sm-12 col-xs-12 col-md-4"
							style="display: none">
							<div class="ibox float-e-margins no-drop">
								<div class="ibox-title">
									<h5>Search options</h5>

									<div class="ibox-tools">
										<a href="#" id="close-search"> <i class="fa fa-times"></i>
										</a>
									</div>
								</div>
								<div class="ibox-content" style="display: block;">

									<div class="form-group">
										<label>Geography</label> <select name="geo[]"
											class="chosen-select-width" data-placeholder="Geography"
											multiple="1">
											<option value="XX">All countries</option>
											<option value="US">United States</option>
											<option value="AU">Australia</option>
											<option value="AT">Austria</option>
											<option value="BE">Belgium</option>
											<option value="BA">Bosnia and Herzegovina</option>
											<option value="BR">Brazil</option>
											<option value="BG">Bulgaria</option>
											<option value="CA">Canada</option>
											<option value="CN">China</option>
											<option value="CY">Cyprus</option>
											<option value="CZ">Czech Republic</option>
											<option value="DK">Denmark</option>
											<option value="EG">Egypt</option>
											<option value="FI">Finland</option>
											<option value="FR">France</option>
											<option value="DE">Germany</option>
											<option value="GR">Greece</option>
											<option value="IN">India</option>
											<option value="ID">Indonesia</option>
											<option value="IL">Israel</option>
											<option value="IT">Italy</option>
											<option value="JP">Japan</option>
											<option value="KR">Korea, Republic of</option>
											<option value="MX">Mexico</option>
											<option value="NL">Netherlands</option>
											<option value="NZ">New Zealand</option>
											<option value="NO">Norway</option>
											<option value="RO">Romania</option>
											<option value="RU">Russian Federation</option>
											<option value="RS">Serbia</option>
											<option value="SK">Slovakia</option>
											<option value="SI">Slovenia</option>
											<option value="ZA">South Africa</option>
											<option value="ES">Spain</option>
											<option value="SE">Sweden</option>
											<option value="CH">Switzerland</option>
											<option value="TW">Taiwan</option>
											<option value="TH">Thailand</option>
											<option value="TR">Turkey</option>
											<option value="GB">United Kingdom</option>
											<option value="VN">Vietnam</option>
											<option value="AF">Afghanistan</option>
											<option value="AX">Aland Islands</option>
											<option value="AL">Albania</option>
											<option value="DZ">Algeria</option>
											<option value="AS">American Samoa</option>
											<option value="AD">Andorra</option>
											<option value="AO">Angola</option>
											<option value="AI">Anguilla</option>
											<option value="AQ">Antarctica</option>
											<option value="AG">Antigua and Barbuda</option>
											<option value="AR">Argentina</option>
											<option value="AM">Armenia</option>
											<option value="AW">Aruba</option>
											<option value="AP">Asia/Pacific Region</option>
											<option value="AZ">Azerbaijan</option>
											<option value="BS">Bahamas</option>
											<option value="BH">Bahrain</option>
											<option value="BD">Bangladesh</option>
											<option value="BB">Barbados</option>
											<option value="BY">Belarus</option>
											<option value="BZ">Belize</option>
											<option value="BJ">Benin</option>
											<option value="BM">Bermuda</option>
											<option value="BT">Bhutan</option>
											<option value="BO">Bolivia</option>
											<option value="BQ">Bonaire, Saint Eustatius and Saba</option>
											<option value="BW">Botswana</option>
											<option value="BV">Bouvet Island</option>
											<option value="IO">British Indian Ocean Territory</option>
											<option value="BN">Brunei Darussalam</option>
											<option value="BF">Burkina Faso</option>
											<option value="BI">Burundi</option>
											<option value="KH">Cambodia</option>
											<option value="CM">Cameroon</option>
											<option value="CV">Cape Verde</option>
											<option value="KY">Cayman Islands</option>
											<option value="CF">Central African Republic</option>
											<option value="TD">Chad</option>
											<option value="CL">Chile</option>
											<option value="CX">Christmas Island</option>
											<option value="CC">Cocos (Keeling) Islands</option>
											<option value="CO">Colombia</option>
											<option value="KM">Comoros</option>
											<option value="CG">Congo</option>
											<option value="CD">Congo, The Democratic Republic of
												the</option>
											<option value="CK">Cook Islands</option>
											<option value="CR">Costa Rica</option>
											<option value="CI">Cote d'Ivoire</option>
											<option value="HR">Croatia</option>
											<option value="CU">Cuba</option>
											<option value="CW">Curacao</option>
											<option value="DJ">Djibouti</option>
											<option value="DM">Dominica</option>
											<option value="DO">Dominican Republic</option>
											<option value="EC">Ecuador</option>
											<option value="SV">El Salvador</option>
											<option value="GQ">Equatorial Guinea</option>
											<option value="ER">Eritrea</option>
											<option value="EE">Estonia</option>
											<option value="ET">Ethiopia</option>
											<option value="FK">Falkland Islands (Malvinas)</option>
											<option value="FO">Faroe Islands</option>
											<option value="FJ">Fiji</option>
											<option value="GF">French Guiana</option>
											<option value="PF">French Polynesia</option>
											<option value="TF">French Southern Territories</option>
											<option value="GA">Gabon</option>
											<option value="GM">Gambia</option>
											<option value="GE">Georgia</option>
											<option value="GH">Ghana</option>
											<option value="GI">Gibraltar</option>
											<option value="GL">Greenland</option>
											<option value="GD">Grenada</option>
											<option value="GP">Guadeloupe</option>
											<option value="GU">Guam</option>
											<option value="GT">Guatemala</option>
											<option value="GG">Guernsey</option>
											<option value="GN">Guinea</option>
											<option value="GW">Guinea-Bissau</option>
											<option value="GY">Guyana</option>
											<option value="HT">Haiti</option>
											<option value="HM">Heard Island and McDonald Islands</option>
											<option value="VA">Holy See (Vatican City State)</option>
											<option value="HN">Honduras</option>
											<option value="HK">Hong Kong</option>
											<option value="HU">Hungary</option>
											<option value="IS">Iceland</option>
											<option value="IR">Iran, Islamic Republic of</option>
											<option value="IQ">Iraq</option>
											<option value="IE">Ireland</option>
											<option value="IM">Isle of Man</option>
											<option value="JM">Jamaica</option>
											<option value="JE">Jersey</option>
											<option value="JO">Jordan</option>
											<option value="KZ">Kazakhstan</option>
											<option value="KE">Kenya</option>
											<option value="KI">Kiribati</option>
											<option value="KP">Korea, Democratic People's
												Republic of</option>
											<option value="KW">Kuwait</option>
											<option value="KG">Kyrgyzstan</option>
											<option value="LA">Lao People's Democratic Republic</option>
											<option value="LV">Latvia</option>
											<option value="LB">Lebanon</option>
											<option value="LS">Lesotho</option>
											<option value="LR">Liberia</option>
											<option value="LY">Libyan Arab Jamahiriya</option>
											<option value="LI">Liechtenstein</option>
											<option value="LT">Lithuania</option>
											<option value="LU">Luxembourg</option>
											<option value="MO">Macao</option>
											<option value="MK">Macedonia</option>
											<option value="MG">Madagascar</option>
											<option value="MW">Malawi</option>
											<option value="MY">Malaysia</option>
											<option value="MV">Maldives</option>
											<option value="ML">Mali</option>
											<option value="MT">Malta</option>
											<option value="MH">Marshall Islands</option>
											<option value="MQ">Martinique</option>
											<option value="MR">Mauritania</option>
											<option value="MU">Mauritius</option>
											<option value="YT">Mayotte</option>
											<option value="FM">Micronesia, Federated States of</option>
											<option value="MD">Moldova, Republic of</option>
											<option value="MC">Monaco</option>
											<option value="MN">Mongolia</option>
											<option value="ME">Montenegro</option>
											<option value="MS">Montserrat</option>
											<option value="MA">Morocco</option>
											<option value="MZ">Mozambique</option>
											<option value="MM">Myanmar</option>
											<option value="NA">Namibia</option>
											<option value="NR">Nauru</option>
											<option value="NP">Nepal</option>
											<option value="NC">New Caledonia</option>
											<option value="NI">Nicaragua</option>
											<option value="NE">Niger</option>
											<option value="NG">Nigeria</option>
											<option value="NU">Niue</option>
											<option value="NF">Norfolk Island</option>
											<option value="MP">Northern Mariana Islands</option>
											<option value="OM">Oman</option>
											<option value="PK">Pakistan</option>
											<option value="PW">Palau</option>
											<option value="PS">Palestinian Territory</option>
											<option value="PA">Panama</option>
											<option value="PG">Papua New Guinea</option>
											<option value="PY">Paraguay</option>
											<option value="PE">Peru</option>
											<option value="PH">Philippines</option>
											<option value="PN">Pitcairn</option>
											<option value="PL">Poland</option>
											<option value="PT">Portugal</option>
											<option value="PR">Puerto Rico</option>
											<option value="QA">Qatar</option>
											<option value="RE">Reunion</option>
											<option value="RW">Rwanda</option>
											<option value="BL">Saint Bartelemey</option>
											<option value="SH">Saint Helena</option>
											<option value="KN">Saint Kitts and Nevis</option>
											<option value="LC">Saint Lucia</option>
											<option value="MF">Saint Martin</option>
											<option value="PM">Saint Pierre and Miquelon</option>
											<option value="VC">Saint Vincent and the Grenadines</option>
											<option value="WS">Samoa</option>
											<option value="SM">San Marino</option>
											<option value="ST">Sao Tome and Principe</option>
											<option value="SA">Saudi Arabia</option>
											<option value="SN">Senegal</option>
											<option value="SC">Seychelles</option>
											<option value="SL">Sierra Leone</option>
											<option value="SG">Singapore</option>
											<option value="SX">Sint Maarten</option>
											<option value="SB">Solomon Islands</option>
											<option value="SO">Somalia</option>
											<option value="GS">South Georgia and the South
												Sandwich Islands</option>
											<option value="SS">South Sudan</option>
											<option value="LK">Sri Lanka</option>
											<option value="SD">Sudan</option>
											<option value="SR">Suriname</option>
											<option value="SJ">Svalbard and Jan Mayen</option>
											<option value="SZ">Swaziland</option>
											<option value="SY">Syrian Arab Republic</option>
											<option value="TJ">Tajikistan</option>
											<option value="TZ">Tanzania, United Republic of</option>
											<option value="TL">Timor-Leste</option>
											<option value="TG">Togo</option>
											<option value="TK">Tokelau</option>
											<option value="TO">Tonga</option>
											<option value="TT">Trinidad and Tobago</option>
											<option value="TN">Tunisia</option>
											<option value="TM">Turkmenistan</option>
											<option value="TC">Turks and Caicos Islands</option>
											<option value="TV">Tuvalu</option>
											<option value="UG">Uganda</option>
											<option value="UA">Ukraine</option>
											<option value="AE">United Arab Emirates</option>
											<option value="UM">United States Minor Outlying
												Islands</option>
											<option value="UY">Uruguay</option>
											<option value="UZ">Uzbekistan</option>
											<option value="VU">Vanuatu</option>
											<option value="VE">Venezuela</option>
											<option value="VG">Virgin Islands, British</option>
											<option value="VI">Virgin Islands, U.S.</option>
											<option value="WF">Wallis and Futuna</option>
											<option value="EH">Western Sahara</option>
											<option value="YE">Yemen</option>
											<option value="ZM">Zambia</option>
											<option value="ZW">Zimbabwe</option>
											<option value="EU">Europe</option>
											<option value="O1">Other Country</option>
										</select>
									</div>
									<div class="form-group">
										<label>Category</label> <select name="tags[]"
											class="chosen-select-width" data-placeholder="Category"
											multiple="1">
											<option value="1">All</option>
											<option value="2">Adult</option>
											<option value="3">Games</option>
											<option value="4">Gambling</option>
											<option value="5">Utilities</option>
											<option value="6">Mobile subscriptions</option>
											<option value="7">Web</option>
											<option value="8">Business</option>
											<option value="9">Travel</option>
											<option value="10">Casual</option>
											<option value="11">Dating</option>
											<option value="12">Shopping</option>
											<option value="13">Rewards</option>
											<option value="14">Entertainment</option>
											<option value="15">Health</option>
											<option value="16">News & Magazines</option>
											<option value="17">Lifestyle</option>
											<option value="18">Social</option>
											<option value="19">Communication</option>
											<option value="20">Sports</option>
											<option value="21">Food & Drink</option>
											<option value="22">Finance</option>
											<option value="23">Tools</option>
											<option value="24">Education</option>
											<option value="25">Music & Audio</option>
											<option value="26">Personalization</option>
											<option value="27">Transportation</option>
											<option value="28">Productivity</option>
											<option value="29">Photo & Video</option>
											<option value="30">Catalogues</option>
											<option value="33">Books</option>
											<option value="34">Maps and navigation</option>
										</select>
									</div>

									<div class="form-group">
										<label>Platform</label> <select name="platforms[]"
											class="chosen-select-width" data-placeholder="Platform"
											multiple="1">
											<option value="2">iPhone</option>
											<option value="3">iPad</option>
											<option value="4">Android</option>
											<option value="5">Windows phone</option>
											<option value="6">BlackBerry</option>
											<option value="7">Kindle</option>
											<option value="8">Desktop</option>
											<option value="9">Other mobile</option>
										</select>
									</div>

									<div>
										<div class="row">
											<div class="form-group col-lg-6">
												<label>Min, $</label> <input type="text" id="min" name="min"
													value="" class="form-control" />
											</div>
											<div class="form-group col-lg-6">
												<label>Max, $</label> <input type="text" id="max" name="max"
													value="" class="form-control" />
											</div>
										</div>
									</div>

									<div class="form-group">
										<label>Type</label> <select name="type" id="type"
											class="chosen-select-width">
											<option value="" selected="selected">Incent &amp;
												Non incent</option>
											<option value="1">Incent</option>
											<option value="2">Non incent</option>
										</select>
									</div>

									<div class="form-group">
										<label>Show only</label>

										<div class="checkbox i-checks">
											<label style="padding-left:0"> <input type="checkbox"
												name="new" value="1"> <i></i> <span>New
													offers</span> </label>
										</div>
										<div class="checkbox i-checks">
											<label style="padding-left:0"> <input type="checkbox"
												name="approved" disabled="disabled" value="1" checked>
												<i></i> <span>Approved offers</span> </label>
										</div>
									</div>

									<div class="text-center">
										<input type="hidden" name="options" id="options_sw" value="0">
										<button class="btn btn-rounded btn-success">
											&nbsp;&nbsp; <i class="fa fa-check"></i> Apply &nbsp;&nbsp;
										</button>
									</div>

								</div>
							</div>
						</div>
					</div>
				</form>
			</div>

			<div id="fpanel"
				style="height: 50px; background-color: #ddd; text-align: center; position: fixed; left:0; bottom:0; right: 0; z-index: 100000; display: none">
				<button id="btn-add-offers" class="btn m-t-sm btn-success"
					type="button">
					<i class="fa fa-check"></i> Request selected offers
				</button>
			</div>

			<div class="modal fade" id="confirmModal" tabindex="-1" role="dialog"
				aria-labelledby="confirmModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<h4 class="modal-title" id="confirmModalLabel">Request
								offers</h4>
						</div>
						<div class="modal-body">
							<div id="confirm-modal-propmt">
								<h3>
									Confirm approval request for <span></span> offers
								</h3>
							</div>
							<div id="confirm-modal-spinner" style="display: none">
								<h3>
									<i class="fa fa-spin fa-spinner m-r-sm"></i> Processing your
									requests
								</h3>
							</div>
							<div id="confirm-modal-success" style="display: none">
								<h3>
									<span style="color:#18A689"> <i class="fa fa-check"></i>
										Offers requested successfully. </span>
								</h3>
							</div>
							<div id="confirm-modal-errors" class="m-t-md"
								style="display: none">
								<h3>
									<span class="text-danger"> Following errors occured: </span>
								</h3>
								<div></div>
							</div>

						</div>
						<div id="confirm-modal-footer" class="modal-footer">
							<button id="btn-dismiss" type="button" class="btn btn-default"
								data-dismiss="modal">Cancel</button>
							<button id="btn-request-offers" type="button"
								class="btn btn-primary">Request</button>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>

	<!-- Mainly scripts -->
	<script type="text/javascript"
		src="http://publishers.turbob.mobi/_assets/js/jquery-1.10.2.js"></script>
	<script type="text/javascript"
		src="http://publishers.turbob.mobi/_assets/js/plugins/jquery-ui/jquery-ui.min.js"></script>
	<script type="text/javascript"
		src="http://publishers.turbob.mobi/_assets/js/plugins/jquery_cookie/js.cookie.js"></script>
	<script type="text/javascript"
		src="http://publishers.turbob.mobi/_assets/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="http://publishers.turbob.mobi/_assets/js/plugins/metisMenu/jquery.metisMenu.js"></script>
	<script type="text/javascript"
		src="http://publishers.turbob.mobi/_assets/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

	<!-- Flot -->
	<script type="text/javascript"
		src="http://publishers.turbob.mobi/_assets/js/plugins/flot/jquery.flot.js"></script>
	<script type="text/javascript"
		src="http://publishers.turbob.mobi/_assets/js/plugins/flot/jquery.flot.tooltip.min.js"></script>
	<script type="text/javascript"
		src="http://publishers.turbob.mobi/_assets/js/plugins/flot/jquery.flot.spline.js"></script>
	<script type="text/javascript"
		src="http://publishers.turbob.mobi/_assets/js/plugins/flot/jquery.flot.resize.js"></script>
	<script type="text/javascript"
		src="http://publishers.turbob.mobi/_assets/js/plugins/flot/jquery.flot.pie.js"></script>

	<!-- Peity -->
	<script type="text/javascript"
		src="http://publishers.turbob.mobi/_assets/js/plugins/peity/jquery.peity.min.js"></script>

	<!-- Custom and plugin javascript -->
	<script type="text/javascript"
		src="http://publishers.turbob.mobi/_assets/js/inspinia.js"></script>

	<!-- GITTER -->
	<script type="text/javascript"
		src="http://publishers.turbob.mobi/_assets/js/plugins/gritter/jquery.gritter.min.js"></script>

	<!-- Sparkline -->
	<script type="text/javascript"
		src="http://publishers.turbob.mobi/_assets/js/plugins/sparkline/jquery.sparkline.min.js"></script>

	<!-- ChartNewJS-->
	<script type="text/javascript"
		src="http://publishers.turbob.mobi/_assets/js/plugins/chartNewJs/ChartNew.js"></script>

	<!-- Chosen -->
	<script type="text/javascript"
		src="http://publishers.turbob.mobi/_assets/js/plugins/chosen/chosen.jquery.js"></script>
	<script type="text/javascript"
		src="http://publishers.turbob.mobi/_assets/js/plugins/chosen/ajax-chosen.js"></script>

	<!-- NoUiSlider -->
	<script type="text/javascript"
		src="http://publishers.turbob.mobi/_assets/js/plugins/nouslider/jquery.nouislider.all.min.js"></script>

	<!-- Data Tables -->
	<script type="text/javascript"
		src="http://publishers.turbob.mobi/_assets/js/plugins/dataTables/jquery.dataTables.js"></script>
	<script type="text/javascript"
		src="http://publishers.turbob.mobi/_assets/js/plugins/dataTables/dataTables.bootstrap.js"></script>
	<script>
    var config = {
        '.chosen-select': {},
        '.chosen-select-deselect': {allow_single_deselect: true},
        '.chosen-select-no-single': {disable_search_threshold: 10},
        '.chosen-select-no-results': {no_results_text: 'Oops, nothing found!'},
        '.chosen-select-width': {width: "100%", disable_search_threshold: 10}
    }
    for (var selector in config) {
        $(selector).chosen(config[selector]);
    }
</script>

	<!-- iCheck -->
	<script type="text/javascript"
		src="http://publishers.turbob.mobi/_assets/js/plugins/iCheck/icheck.min.js"></script>
	<script>
    $(document).ready(function () {
        $('.i-checks').iCheck({
            checkboxClass: 'icheckbox_square-green',
            radioClass: 'iradio_square-green'
        });
    });
</script>


	<!-- Jasny -->
	<script type="text/javascript"
		src="http://publishers.turbob.mobi/_assets/js/plugins/jasny/jasny-bootstrap.min.js"></script>
	<script type="text/javascript"
		src="http://publishers.turbob.mobi/_assets/js/plugins/daterangepicker/moment.js"></script>
	<script type="text/javascript"
		src="http://publishers.turbob.mobi/_assets/js/plugins/daterangepicker/moment-timezone.js"></script>
	<script type="text/javascript"
		src="http://publishers.turbob.mobi/_assets/js/plugins/daterangepicker/daterangepicker.js"></script>
	<script type="text/javascript"
		src="http://publishers.turbob.mobi/_assets/js/plugins/datapicker/bootstrap-datepicker.js"></script>

	<!-- Jvectormap -->
	<script type="text/javascript"
		src="http://publishers.turbob.mobi/_assets/js/plugins/jvectormap/jquery-jvectormap-2.0.0.min.js"></script>
	<script type="text/javascript"
		src="http://publishers.turbob.mobi/_assets/js/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>

	<script>
    window.serverTime = new Date("Jun 12 2017 8:50:46");
</script>
	<script type="text/javascript"
		src="http://publishers.turbob.mobi/_assets/js/common.js"></script>

	<script>
    $(function () {
        $(document).delegate('a.approve', 'click', function () {
            var parent = $(this);
            var id = $(this).attr('data-id');
            $.ajax({
                url: 'offers/approve',
                data: {
                    ids: [id]
                },
                dataType: "json",
                method: 'POST',
                success: function (data) {
                    if(!data.success) {
                        if(data.error) {
                            alert(data.error);
                        } else {
                            alert('Something gone wrong. Please contact your manager.');
                        }
                        return;
                    }

                    if (data.data) {
                        if (typeof data.data[id] == 'undefined') {
                            alert('You cannot request this offer');
                        } else {
                            $("#ajaxModal").modal("hide");
                            var checkbox = $(".selector[data-id=" + id + "] input.sel");
                            checkbox.iCheck('uncheck');
                            checkbox.iCheck('disable');
                            checkbox.removeClass('sel').addClass('sel-disabled');

                            $(".offer-request[data-id=" + id + "]").fadeOut("slow", function () {
                                var p = $("<span class='label'>Pending approval</span>").hide();
                                $(this).replaceWith(p);
                                p.fadeIn("slow");
                            });
                        }
                    }
                }
            });

            return false;
        });

        $("#search-button, #close-search").on("click", function () {
            $("#offers-area").toggleClass("col-lg-9").toggleClass("col-md-8");
            $("#search-options").toggle();
            $("#options_sw").val($("#search-options:visible").length);
            if ($("#search-options:visible").length && $("body").width() < 980) {
                $('html, body').animate({
                    scrollTop: $("#search-options").offset().top
                }, 300);
            }
        });

        if ($("#options_sw").val() == 1) {
            $("#search-options").toggle();
            $("#offers-area").toggleClass("col-lg-9").toggleClass("col-md-8");
        }

        $("#options_sw").val($("#search-options:visible").length);

        $(".geo_cut_toggle").on("click", function (e) {
            $(this).hide();
            $(this).next().fadeToggle('fast');
            e.preventDefault();
        });

        $("input.sel").on('ifChecked', function(){
            $("#fpanel").fadeIn();
            $(".btn-select-all").hide();
            $(".btn-unselect-all").show();
        }).on('ifUnchecked', function(){
            if ($(".selector div.checked").length == 1) {
                $("#fpanel").fadeOut();
                $(".btn-unselect-all").hide();
                $(".btn-select-all").show();
            }
        });

        $("#btn-add-offers").on('click', function (e) {
            e.preventDefault();

            var ids = [];
            $("input.sel").each(function () {
                if ($(this).prop("checked")) {
                    ids.push($(this).val());
                }
            });

            $("#fpanel").fadeOut();
            if (ids.length == 0) {
                alert('Please select offers to send approval request!');
                return;
            }

            $("#confirm-modal-propmt").show();
            $("#confirm-modal-success").hide();
            $("#confirm-modal-errors").hide();
            $("#confirm-modal-footer button").removeAttr("disabled");

            $("#confirm-modal-propmt span").text(ids.length);
            $("#confirmModal").modal({
                show: true,
                backdrop: "static",
                keyboard: false
            }).one("hidden.bs.modal", function () {
                if ($("input.sel:checked:not([disabled])").length) {
                    $("#fpanel").fadeIn();
                }
            });

            $("#btn-request-offers").on("click", function () {
                $("#confirm-modal-propmt").hide();
                $("#confirm-modal-success").hide();
                $("#confirm-modal-errors").hide();
                $("#confirm-modal-spinner").show();
                $("#confirm-modal-footer button").attr("disabled", "disabled");

                $.ajax({
                    url: 'offers/approve',
                    data: {
                        ids: ids
                    },
                    dataType: "json",
                    method: 'POST',
                    success: function (data) {
                        $("#confirm-modal-spinner").hide();
                        if (!data.success) {
                            $("#confirm-modal-footer button").removeAttr("disabled");

                            var text = "";
                            if (!$.isEmptyObject(data.error)) {
                                text = data.error;
                            } else {
                                text = 'Something gone wrong. Please contact your manager.';
                            }

                            $("#confirm-modal-errors div").html(text);
                            $("#confirm-modal-errors").show();
                        } else {
                            $("#confirm-modal-success").show();
                            $("#confirm-modal-footer #btn-dismiss").removeAttr("disabled");

                            if (data.data) {
                                var text = '';
                                for (var id in ids) {
                                    if (typeof data.data[ids[id]] == 'undefined') {
                                        text += 'You don\'t have permission to request offer #' + ids[id] + "<br>";
                                    } else {
                                        var checkbox = $(".selector[data-id=" + ids[id] + "] input.sel");
                                        checkbox.iCheck('uncheck');
                                        checkbox.iCheck('disable');
                                        checkbox.removeClass('sel').addClass('sel-disabled');
                                        $(".offer-request[data-id=" + ids[id] + "]").fadeOut("slow", function () {
                                            var p = $("<span class='label'>Pending approval</span>").hide();
                                            $(this).replaceWith(p);
                                            p.fadeIn("slow");
                                        });
                                    }
                                }

                                if (text != '') {
                                    $("#confirm-modal-errors div").html(text);
                                    $("#confirm-modal-errors").show();
                                } else {
                                    setTimeout(function () {
                                        $("#confirmModal").modal("hide");
                                    }, 1000);
                                }

                                ids = [];
                            }
                        }
                    },
                    error: function () {
                        $("#confirm-modal-spinner").hide();
                        $("#confirm-modal-footer button").removeAttr("disabled");
                        $("#confirmModal").modal("hide");
                    }
                });
            });

            $("#btn-dismiss").one("click", function () {
                $("#btn-request-offers").off("click");
            })
        });
    });

    function changeOfferSdk(offerId, status){
        $('.sdk-btns-' + offerId).empty();
        if(status === 1){
            $.post('http://publishers.turbob.mobi/sdk/apps-offers/add', {offerId: offerId}, function(response){
                if(response.status !== "OK"){
                    location.reload();
                    return false;
                }
                $('.sdk-btns-' + offerId).append(
                    '<div class="btn btn-primary" onclick="changeOfferSdk('+offerId+', 2)">'+
                        '<i class="fa fa-bullhorn m-r-xs" style="opacity:0.5"></i> Remove from SDK' +
                    '</div>'
                );
            }, 'json');
        }else{
            $.post('http://publishers.turbob.mobi/sdk/apps-offers/remove', {offerId: offerId}, function(response){
                if(response.status !== "OK"){
                    location.reload();
                    return false;
                }
                $('.sdk-btns-' + offerId).append(
                    '<div class="btn btn-primary" onclick="changeOfferSdk('+offerId+', 1)">'+
                        '<i class="fa fa-bullhorn m-r-xs" style="opacity:0.5"></i> Add to SDK' +
                    '</div>'
                );
            }, 'json');
        }
    }
    </script>

</body>
</html>