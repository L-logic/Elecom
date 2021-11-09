layui.use(['echarts'],function (){
	var chartDom = document.getElementById('line1');
	var myChart = echarts.init(chartDom);
	var option;

	setTimeout(function () {
		option = {
			// legend: {},
			// tooltip: {
			// 	trigger: 'axis',
			// 	showContent: false
			// },
			dataset: {
				source: [
					['product', '2012', '2013', '2014', '2015', '2016', '2017'],
					['Milk Tea', 56.5, 82.1, 88.7, 70.1, 53.4, 85.1],
					['Matcha Latte', 51.1, 51.4, 55.1, 53.3, 73.8, 68.7],
					['Cheese Cocoa', 40.1, 62.2, 69.5, 36.4, 45.2, 32.5],
					['Walnut Brownie', 25.2, 37.1, 41.2, 18, 33.9, 49.1]
				]
			},
			// xAxis: { type: 'category' },
			// yAxis: { gridIndex: 0 },
			// grid: { top: '55%' },
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
					dataView: { show: true, readOnly: false },
					magicType: { show: true, type: ['line', 'bar'] },
					restore: { show: true },
					saveAsImage: { show: true }
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
					name: '数据量',
					type: 'category',
					boundaryGap: false,
					data: ['5M', '10M', '15M', '20M', '25M', '30M']
				}
			],
			yAxis: [
				{
					name: '运行时间',
					type: 'value'
				}
			],
			series: [
				{
					name: '2个',
					stack: 'Total',
					areaStyle: {},
					label: {
						show: true,
						position: 'top'
					},
					seriesLayoutBy: 'row',
					// data: [10681,11297,19421,26051,31533,41962],
					type: 'line',
					smooth: true,
					emphasis: { focus: 'series' }
				},
				{
					type: 'line',
					smooth: true,
					seriesLayoutBy: 'row',
					emphasis: { focus: 'series' }
				},
				{
					type: 'line',
					smooth: true,
					seriesLayoutBy: 'row',
					emphasis: { focus: 'series' }
				},
				{
					type: 'line',
					smooth: true,
					seriesLayoutBy: 'row',
					emphasis: { focus: 'series' }
				},
				{
					type: 'pie',
					id: 'pie',
					radius: '30%',
					center: ['50%', '25%'],
					emphasis: {
						focus: 'self'
					},
					label: {
						formatter: '{b}: {@2012} ({d}%)'
					},
					encode: {
						itemName: 'product',
						value: '2012',
						tooltip: '2012'
					}
				}
			]
		};
		myChart.on('updateAxisPointer', function (event) {
			const xAxisInfo = event.axesInfo[0];
			if (xAxisInfo) {
				const dimension = xAxisInfo.value + 1;
				myChart.setOption({
					series: {
						id: 'pie',
						label: {
							formatter: '{b}: {@[' + dimension + ']} ({d}%)'
						},
						encode: {
							value: dimension,
							tooltip: dimension
						}
					}
				});
			}
		});
		myChart.setOption(option);
	});

	option && myChart.setOption(option);
})