function chg(id,chk){
    var el = document.getElementById(id);
    var ch = document.getElementById(chk);
    if (el.src.indexOf("nottick64.png")>0){
        el.src="tick64.png"
        ch.checked="true";
    }else{
        el.src="nottick64.png"
        ch.checked="";
    }
}

