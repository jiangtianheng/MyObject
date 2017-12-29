function loadResEvent(nn){
//	var button=$("button.btn.btn-white.btn-sm");
//	if (typeof(nn) != "undefined"){ 
//		console.log(nn);
//		button.siblings().removeClass("active");
//		nn.addClass("active");
//	}
	 var myChart,myChart1;
	 if (myChart != null && myChart != "" && myChart != undefined) {
	        myChart.dispose();
	 }
	 if (myChart1 != null && myChart1 != "" && myChart1 != undefined) {
		 myChart1.dispose();
	    }
	  myChart = echarts.init(document.getElementById('lineChart2'));
	  myChart1 = echarts.init(document.getElementById('main'));
	 myChart.clear();
	 myChart1.clear();
	 option = {
			   /* title: {
			        text: '堆叠区域图'
			    },*/
			    tooltip : {
			        trigger: 'axis',
			        axisPointer: {
			            type: 'cross',
			            label: {
			                backgroundColor: '#6a7985'
			            }
			        }
			    },
			   /* legend: {
			        data:['邮件营销','联盟广告','视频广告','直接访问','搜索引擎']
			    },*/
			    toolbox: {
			        feature: {
			            saveAsImage: {}
			        }
			    },
			    grid: {
			        left: '3%',
			        right: '4%',
			        bottom: '3%',
			        containLabel: true
			    },
			    xAxis : [
			        {
			            type : 'category',
			            boundaryGap : false,
			            data : ['周一','周二','周三','周四','周五','周六','周日']
			        }
			    ],
			    yAxis : [
			        {
			            type : 'value'
			        }
			    ],
			    series : [
			        {
			            name:'邮件营销',
			            type:'line',
			            stack: '总量',
			            areaStyle: {normal: {}},
			            data:[120, 132, 101, 134, 90, 230, 210]
			        },
			        {
			            name:'联盟广告',
			            type:'line',
			            stack: '总量',
			            areaStyle: {normal: {}},
			            data:[220, 182, 191, 234, 290, 330, 310]
			        },
			        {
			            name:'视频广告',
			            type:'line',
			            stack: '总量',
			            areaStyle: {normal: {}},
			            data:[150, 232, 201, 154, 190, 330, 410]
			        },
			        {
			            name:'直接访问',
			            type:'line',
			            stack: '总量',
			            areaStyle: {normal: {}},
			            data:[320, 332, 301, 334, 390, 330, 320]
			        },
			        {
			            name:'搜索引擎',
			            type:'line',
			            stack: '总量',
			            label: {
			                normal: {
			                    show: true,
			                    position: 'top'
			                }
			            },
			            areaStyle: {normal: {}},
			            data:[820, 932, 901, 934, 1290, 1330, 1320]
			        }
			    ]
			};
	/* var option = {
		    tooltip : {
		        trigger: 'axis'
		    },
		    legend: {
		        data:['邮件营销','联盟广告','视频广告','直接访问','搜索引擎']
		    },
		    toolbox: {
		        show : true,
		        feature : {
		            mark : {show: true},
		            dataView : {show: true, readOnly: false},
		            magicType : {show: true, type: ['line', 'bar', 'stack', 'tiled']},
		            restore : {show: true},
		            saveAsImage : {show: true}
		        }
		    },
		    calculable : true,
		    xAxis : [
		        {
		            type : 'category',
		            boundaryGap : false,
		            data : ['周一','周二','周三','周四','周五','周六','周日']
		        }
		    ],
		    yAxis : [
		        {
		            type : 'value'
		        }
		    ],
		    series : [
		        {
		            name:'邮件营销',
		            type:'line',
		            stack: '总量',
		            data:[120, 132, 101, 134, 90, 230, 210]
		        },
		        {
		            name:'联盟广告',
		            type:'line',
		            stack: '总量',
		            data:[220, 182, 191, 234, 290, 330, 310]
		        },
		        {
		            name:'视频广告',
		            type:'line',
		            stack: '总量',
		            data:[150, 232, 201, 154, 190, 330, 410]
		        },
		        {
		            name:'直接访问',
		            type:'line',
		            stack: '总量',
		            data:[320, 332, 301, 334, 390, 330, 320]
		        },
		        {
		            name:'搜索引擎',
		            type:'line',
		            stack: '总量',
		            data:[820, 932, 901, 934, 1290, 1330, 1320]
		        }
		    ]
		};*/
	 	myChart.setOption(option);
	 	myChart1.setOption(option);

/*	$.ajax({
		url:,
		type:"get",
		dataType:"json",
		success:function(result){
			//登录信息失效，ajax请求静态页面拦截
            onComplete(result);
			if(result.status == 1){
				var y = result.data;
				var x = result.dataSub;
        //无数据时,制造一些数据,使显示表格内容
        if (y.length===0) {
          y = [{
            data:[0,0,0,0,0,0,0,0,0,0,0,0],
            name:'无数据',
            type:"line",
          }];
        }
                var myChart = echarts.init(document.getElementById('lineChart2'));
                var option = {
                		//智能仪器,硬件,软件,其他
						color:['#EDA6BB','#84C0E4','#F0D272','#FDB071'],
                		title: {
                	        text: '资产分类事件趋势图',
            	        	left:'25',
            	            top:10,
            	            textStyle: {
            	                fontSize: '12',
            	                fontWeight: 'lighter'
            	            }
                	    },
                	    tooltip: {
                	        trigger: 'axis'
                	    },
                	    legend: {
                	    	bottom:'10',
//                	    	orient:"vertical",
                	        // data:['硬件','软件','智能仪器','其他'],
                          data:['智能仪器','硬件','软件','其他'],
                	    },
                	    grid: {
                	        left: '3%',
                	        right: '4%',
                	        bottom: '15%',
                	        containLabel: true
                	    },
                	    xAxis: {
                	        type: 'category',
                	        boundaryGap: false,
                	        axisTick:{
                	        	interval:0
                	        },
                	        data: x
                	    },
                	    yAxis: {
                	        type: 'value'
                	    },

                	    series:  y


                	};
            	myChart.setOption(option);
			}
		},
		error:function(XMLHttpRequest){
			error_500(XMLHttpRequest.responseText);
		}
	});*/
}

$(function(){
	loadResEvent();	
});