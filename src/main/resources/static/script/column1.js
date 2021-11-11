layui.use(['echarts'], function() {
	let echarts = layui.echarts;

	var column1 = echarts.init(document.getElementById('column1'));
	var word = document.getElementById('zhang').innerText;

    var series1 = [];
    var series2 = [];
    var series3 = [];
    //console.log("xxxxxxxxxxxxxx")

    $.ajax({
        type: 'post',
        async : false,
        data:{
            word: word
        },
        url: 'http://localhost:8888/grade/setGrade',//请求数据的地址
        dataType: "json",        //返回数据形式为json
        success: function (result) {
            // console.log(result)
            $.each(result.data, function (index, item) {
                console.log(item);
                var temp1 = item.compPower;
                var temp2 = item.satisfaction;
                series2.push(item.compkey);
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
            data: series2,

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
                data: series1
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
                data: series3
            }
        ]
    };

	column1.setOption(option);

	window.onresize = function() {
		column1.resize();
	}
})
