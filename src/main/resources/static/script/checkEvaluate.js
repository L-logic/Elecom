function checkEvaluate()
{
    var tips = document.querySelectorAll(".form-control");
    console.log(tips);
    // var tips = document.getElementById('tips').value ;
    var msg = document.getElementById('msg');
    console.log(tips.length)
    for(i=0;i<tips.length;i++)
    {
        console.log(tips[i].value);
        if(tips[i].value==="1"||tips[i].value==="2"||tips[i].value==="3"||tips[i].value==="4"||tips[i].value==="5"||tips[i].value==="1.5"||tips[i].value==="2.5"||tips[i].value==="3.5"||tips[i].value==="4.5"||tips[i].value===null)
        {
            msg.className = 'okTips'
            msg.innerText = '感谢您的参与！';
        }
        else
        {
            msg.className = 'errorTips'
            msg.innerText = '请输入1-5的打分！（可以打.5分）';
            break;
        }
    }
    // if(tips==="1"||tips==="2"||tips==="3"||tips==="4"||tips==="5"||tips==="1.5"||tips==="2.5"||tips==="3.5"||tips==="4.5"||tips===null)
    // {
    //     msg.className = 'okTips'
    //     msg.innerText = '感谢您的参与！';
    // }
    // else
    // {
    //     msg.className = 'errorTips'
    //     msg.innerText = '请输入1-5的打分！（可以打.5分）';
    // }
}