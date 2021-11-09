layui.use(['echarts'], function() {
	let echarts = layui.echarts;

	var column1 = echarts.init(document.getElementById('column1'));
option = {
    tooltip: {
        trigger: 'axis',
        axisPointer: { 
            type: 'shadow' ,
            textStyle: {
                color: '#fff',
                fontSize: '26'
            },
        }
    },
    legend: {
        top:'5%',
        right:'10%',
        data: ['竞争度', 'Grade'],
        textStyle:{
            fontSize:12,
            color:'#808080'
        },
        icon:'rect'
    },
    grid: {
        top:60,
        left:50,
        bottom:60,
        right:60
    },
    xAxis: [{
        type: 'category',
        axisTick:{
            show:false
        },
        axisLine:{
            show:false
        },
        axisLabel:{
            color:'#4D4D4D',
            fontSize:14,
            margin:21,
            fontWeight:'bold'
        },
        data: ['怀孕', '做法', 'qq', '视频'],
       
    }],
    yAxis: [{
        // name:'单位：万',
        nameTextStyle:{
            color:'#808080',
            fontSize:12,
            padding:[0, 0, 0, -5]
        },
        max: function(value) {
            if(value.max<5){
                return 5
            }else{
                return value.max
            }
        },
        type: 'value',
        axisLine:{
            show:false
        },
        axisLabel:{
            color:'#808080',
            fontSize:12,
            margin:5
        },
        splitLine:{
            show:false
        },
        axisTick:{
            show:false
        }
    }],
    series: [
        {
            name: '竞争度',
            type: 'bar',
            label:{
                show:true,
                position:'top',
                fontSize:14,
                color:'#5be8da',
                // color:'#3DC3F0',
                fontWeight:'bold'
            },
            barMaxWidth:60,
            itemStyle:{
                color: {
                    type: 'linear',
                    x: 0,
                    y: 0,
                    x2: 0,
                    y2: 1,
                    colorStops: [{
                        offset: 0,color: '#5be8da'
                        // offset: 0, color: '#3DC3F0' // 0% 处的颜色
                    }, {
                        offset: 1, color: '#ffffff' // 100% 处的颜色
                        // offset: 1, color: '#CCF2FF' // 100% 处的颜色
                    }]
                }
            },
            data: [0.7242, 0.5489, 0.3532, 0.1333]
        }, 
        {
            name: '打分',
            type: 'bar',
            label:{
                show:true,
                position:'top',
                fontSize:14,
                color:'#009688',
                // color:'#3D8BF0',
                fontWeight:'bold'
            },
            barMaxWidth:60,
            itemStyle:{
                color: {
                    type: 'linear',
                    x: 0,
                    y: 0,
                    x2: 0,
                    y2: 1,
                    colorStops: [{
                        offset: 0,color: '#009688'
                        // offset: 0, color: '#3D8BF0' // 0% 处的颜色
                    }, {
                        offset: 1, color: '#ffffff' // 100% 处的颜色
                        // offset: 1, color: '#CCE2FF' // 100% 处的颜色
                    }]
                }
            },
            data: [5, 4.5, 1, 2.5]
        }
    ]
};

	column1.setOption(option);

	window.onresize = function() {
		column1.resize();
	}
})
