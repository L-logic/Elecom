layui.use(['echarts'], function() {
	let echarts = layui.echarts;

	var line4 = echarts.init(document.getElementById('line4'));

	const colorList = ["#9E87FF", '#73DDFF', '#fe9a8b', '#F56948', '#9E87FF']
	option = {
		title: {
			text: '算法运行效率分析'
		},
		tooltip: {
			trigger: 'axis',
			axisPointer: {
				type: 'line',
				label: {
					backgroundColor: '#6a7985'
				}
			}
		},
		legend: {
			data: ['2个', '4个', '6个', '8个', '10个']
		},
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
		xAxis: [
			{
				type: 'category',
				boundaryGap: false,
				data: ['5M', '10M', '15M', '20M', '25M', '30M']
			}
		],
		yAxis: [
			{
				type: 'value'
			}
		],
		series: [
			{
				name: '2个',
				type: 'line',
				stack: 'Total',
				areaStyle: {},
				label: {
					show: true,
					position: 'top'
				},
				emphasis: {
					focus: 'series'
				},
				data: [10681,11297,19421,26051,31533,41962]
			},
			{
				name: '4个',
				type: 'line',
				stack: 'Total',
				areaStyle: {},
				label: {
					show: true,
					position: 'top'
				},
				emphasis: {
					focus: 'series'
				},
				data: [15117,21922,32278,47643,55973,71282]
			},
			{
				name: '6个',
				type: 'line',
				stack: 'Total',
				areaStyle: {},
				label: {
					show: true,
					position: 'top'
				},
				emphasis: {
					focus: 'series'
				},
				data: [16973,33556,51460,69417,89866,105050]
			},
			{
				name: '8个',
				type: 'line',
				stack: 'Total',
				label: {
					show: true,
					position: 'top'
				},
				areaStyle: {},
				emphasis: {
					focus: 'series'
				},
				data: [20028,39363,60374,79691,105856,130924]
			},
			{
				name: '10个',
				type: 'line',
				stack: 'Total',
				label: {
					show: true,
					position: 'top'
				},
				areaStyle: {},
				emphasis: {
					focus: 'series'
				},
				data: [44787,49189,71376,96163,118967,157293]
			}
		]
	};

	line4.setOption(option);

	window.onresize = function() {
		line4.resize();
	}
})
