layui.use(['echarts'], function() {
	let echarts = layui.echarts;

	var line3 = echarts.init(document.getElementById('line3'));

	const colorList = ["#9E87FF", '#73DDFF', '#fe9a8b', '#F56948', '#FFB761','#616A6B','#8E44AD','#73C6B6','#EB984E','#27AE60']

	var word = document.getElementById('zhang').innerText;

	var series1 = [];
	var series2 = [];
	var series3 = [];
	console.log("zzzzzzzzzz")

	$.ajax({
		type: 'post',
		async : false,
		data:{
			word: word
		},
		url: 'http://localhost:8888/grade/setLine',//请求数据的地址
		dataType: "json",        //返回数据形式为json
		success: function (result) {
			$.each(result, function (index, item) {
				console.log(item);
				var temp1 = item.compkey;
				var temp2 = item.cpgrades;
				if(temp1 == null || temp2 == null) {
					series1.push(0);
					series3.push(0);
				} else {
					series1.push(temp1);
					series3.push(temp2);
				}
			});
		},
		error: function (errorMsg) {
			//请求失败时执行该函数
			alert("图表请求数据失败!");
			echarts.hideLoading();
		}
	});
	option = {
		backgroundColor: '#fff',
		title: {
			text: "竞争关键字",
			left: "18px",
			top: "0",
			textStyle: {
				color: "#999",
				fontSize: 12,
				fontWeight: '400'
			}
		},
		color:colorList,
		// color: ['#73A0FA', '#73DEB3', '#FFB761','#b173de', '#FFB761'],
		tooltip: {
			trigger: 'axis',
			axisPointer: {
				type: 'cross',
				crossStyle: {
					color: '#999'
				},
				lineStyle: {
					type: 'dashed'
				}
			}
		},
		grid: {
			left: '25',
			right: '25',
			bottom: '24',
			top: '75',
			containLabel: true
		},
		legend: {
			data: series1,
			orient: 'horizontal',
			icon: "rect",
			show: true,
			left: 20,
			top: 25,
		},
		xAxis: {
			type: 'category',
			data: ['1次前', '2次前', '3次前', '4次前', '5次前'],
			splitLine: {
				show: false
			},
			axisTick: {
				show: false
			},
			axisLine: {
				show: false
			},
		},
		yAxis: {
			type: 'value',
			axisLabel: {
				color: '#999',
				textStyle: {
					fontSize: 12
				},
			},
			splitLine: {
				show: true,
				lineStyle: {
					color: '#F3F4F4'
				}
			},
			axisTick: {
				show: false
			},
			axisLine: {
				show: false
			},
		},
		series: [{
				name: series1[0],
				type: 'line',
				smooth: true,
				data: series3[0]
			},
			{
				name: series1[1],
				type: 'line',
				smooth: true,
				data: series3[1]
			},
			{
				name: series1[2],
				type: 'line',
				smooth: true,
				data: series3[2]
			},
			{
				name: series1[3],
				type: 'line',
				smooth: true,
				data: series3[3]
			},
			{
				name: series1[4],
				type: 'line',
				smooth: true,
				data: series3[4]
			},
			{
				name: series1[5],
				type: 'line',
				smooth: true,
				data: series3[5]
			},
			{
				name: series1[6],
				type: 'line',
				smooth: true,
				data: series3[6]
			},
			{
				name: series1[7],
				type: 'line',
				smooth: true,
				data: series3[7]
			},
			{
				name: series1[8],
				type: 'line',
				smooth: true,
				data: series3[8]
			},
			{
				name: series1[9],
				type: 'line',
				smooth: true,
				data: series3[9]
			}
		]
	};

	line3.setOption(option);

	window.onresize = function() {
		line3.resize();
	}
})
