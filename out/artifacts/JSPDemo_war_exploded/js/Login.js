function check(form){
    var name=form.name.value;
    var password=form.password.value;
    var tip=document.getElementById("tips");
    if(name === "" ||password === ""){
        // alert("用户名或密码不能为空哦~");
        tip.innerHTML="用户名或密码不能为空哦~";
        return false;
    }
}
function pcheck(form) {
    var tip=document.getElementById("ptips");
    var password=form.password.value;
    if(!password.match( /^[0-9a-zA-Z]+$/)){
        tip.innerHTML="密码只能包含数字和字母";
    }else{
        tip.innerHTML="";
    }
}
function nameCheck(form) {
    var tip=document.getElementById("ptips");
    var name = form.name.value;
    if(!name.match( /^[0-9a-zA-Z]+$/)){
        tip.innerHTML="账号只能包含数字和字母";
    }else{
        tip.innerHTML="";
    }
}