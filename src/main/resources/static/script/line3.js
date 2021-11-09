layui.use(['echarts'], function() {
	let echarts = layui.echarts;

	var line3 = echarts.init(document.getElementById('line3'));

	const colorList = ["#9E87FF", '#73DDFF', '#fe9a8b', '#F56948', '#FFB761']

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
			data: ['怀孕', '做法','名字','qq','视频'],
			orient: 'horizontal',
			icon: "rect",
			show: true,
			left: 20,
			top: 25,
		},
		xAxis: {
			type: 'category',
			data: ['5次前', '4次前', '3次前', '2次前', '1次前'],
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
				name: '怀孕',
				type: 'line',
				smooth: true,
				data: [3.5, 5, 5, 5, 5]
			},
			{
				name: '做法',
				type: 'line',
				smooth: true,
				data: [4.5, 3, 4, 2, 5]
			},
			{
				name: '名字',
				type: 'line',
				smooth: true,
				data: [2.5, 3, 5, 4, 5]
			},
			{
				name: 'qq',
				type: 'line',
				smooth: true,
				data: [4, 1.5, 2, 1.5, 3]
			},
			{
				name: '视频',
				type: 'line',
				smooth: true,
				data: [2, 3, 1.5, 4.5, 5]
			}
		]
	};

	line3.setOption(option);

	window.onresize = function() {
		line3.resize();
	}
})
