
/*
    执行确认框提示，以及跳转到指定的地址。
 */
function confirmAndRedirect(message, url)
{
    if(confirm(message))
    {
        window.location.href=url;
    }
}


