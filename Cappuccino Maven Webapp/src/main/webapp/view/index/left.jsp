<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
	<div id="wrapper">
		<nav class="navbar-default navbar-static-side" role="navigation">
			<div class="sidebar-collapse">
				<ul class="nav" id="side-menu">
					<li class="nav-header"
						style="background-size: 100% 100%; padding-top: 14px">
						<div>
							<img src="images/logo.png" class="hidden-xs" alt="Logo"
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
					<li class="active"><a href=""><i class="fa fa-th-large"></i>
							<span class="nav-label">Dashboard </span> </a>
					</li>
					<li><a href=""><i class="fa fa-bar-chart-o"></i> <span
							class="nav-label">Reports </span> </a>
					</li>
					<li><a href="#"> <i
							class="fa fa-lg fa-fw fa-shopping-cart"></i> <span
							class="nav-label">Superlink</span> <span
							style="margin-left: 5px;" class="fa arrow"></span> </a>

						<ul class="nav nav-second-level ">
							<li><a href="#">URLs</a></li>
							<li><a href="#">Statistics</a></li>
							<li><a href="#">Integration</a></li>
						</ul>
					</li>
					<li><a href="#"><i class="fa fa-check-square-o "></i> <span
							class="nav-label">Conversions </span> </a>
					</li>
					<li><a href="#"> <i
							class="fa fa-lg fa-fw fa-shopping-cart"></i> <span
							class="nav-label">Offers</span> <span style="margin-left: 5px;"
							class="fa arrow"></span> </a>

						<ul class="nav nav-second-level ">
							<li><a href="#">All offers</a>
							</li>
							<li><a href="#">Approved offers</a>
							</li>
						</ul>
					</li>
					<li><a href="#"><i class="fa fa-dollar"></i> <span
							class="nav-label">Billing</span> </a>
					</li>
					<li><a href="#"><i class="fa fa-user"></i> <span
							class="nav-label">Profile</span> </a>
					</li>
				</ul>

			</div>
		</nav>
	</div>


</body>
</html>

