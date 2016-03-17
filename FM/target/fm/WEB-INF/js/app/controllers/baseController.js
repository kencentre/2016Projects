/**
 * Created by jack on 2015/11/20.
 */



function getSubUrl(){
    var current_url =  window.location+"";
    var admin_index = current_url.indexOf("financial");
    var var_url = current_url.substring(0,admin_index+9);
    return var_url;
}

function gotoManagement(){
    console.log(getSubUrl());
    window.location.replace(getSubUrl()+"/view/management.html#/card/record/new/");
}

function gotoCardManage(){
    console.log(getSubUrl());
    window.location.replace(getSubUrl()+"/view/cardManage.html#/");
}

function gotoLogin(){
    window.location.replace(getSubUrl() + "/");
}