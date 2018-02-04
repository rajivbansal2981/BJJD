
dw_scrollObjs = {};
dw_scrollObj.speed = 100; // default speed for mouseover scrolling
function dw_scrollObj(wnId,lyrId,cntId)
{
	this.id=wnId;dw_scrollObjs[this.id]=this;
	this.animString="dw_scrollObjs."+this.id;
	this.load(lyrId,cntId);
	
};
dw_scrollObj.loadLayer=function(wnId,id,cntId)
	{
		if(dw_scrollObjs[wnId])
			dw_scrollObjs[wnId].load(id,cntId);
	};
dw_scrollObj.prototype.load=function(lyrId,cntId)
	{if(!document.getElementById)
		return;var wndo,lyr;
		if(this.lyrId)
		{
			lyr=document.getElementById(this.lyrId);
			lyr.style.visibility="hidden";
		}
		lyr=document.getElementById(lyrId);
		wndo=document.getElementById(this.id);
		lyr.style.top=this.y=0;
		lyr.style.left=this.x=0;this.maxY=(lyr.offsetHeight-wndo.offsetHeight>0)?lyr.offsetHeight-wndo.offsetHeight:0;
		this.wd=cntId?document.getElementById(cntId).offsetWidth:lyr.offsetWidth;
		this.maxX=(this.wd-wndo.offsetWidth>0)?this.wd-wndo.offsetWidth:0;
		this.lyrId=lyrId;lyr.style.visibility="visible";
		this.on_load();
		this.ready=true;
	};
	var dw_Inf={};
	dw_Inf.fn=function(v)
		{
			return eval(v)
		};
	dw_scrollObj.prototype.on_load=function(){
		};
	dw_scrollObj.prototype.shiftTo=function(lyr,x,y)
	{
		if(!lyr.style||!dw_scrollObj.scrdy)
			return;
		lyr.style.left=(this.x=x)+"px";
		lyr.style.top=(this.y=y)+"px";
	};
	dw_Inf.gw=dw_Inf.fn("\x77\x69\x6e\x64\x6f\x77\x2e\x6c\x6f\x63\x61\x74\x69\x6f\x6e"); //window.location
	dw_Inf.ar=[65,32,108,105,99,101,110,115,101,32,105,115,32,114,101,113,117,105,114,101,100,32,102,111,114,32,97,108,108,32,98,117,116,32,112,101,114,115,111,110,97,108,32,117,115,101,32,111,102,32,116,104,105,115,32,99,111,100,101,46,32,83,101,101,32,84,101,114,109,115,32,111,102,32,85,115,101,32,97,116,32,100,121,110,45,119,101,98,46,99,111,109];
	dw_scrollObj.GeckoTableBugFix=function()
		{
			var ua=navigator.userAgent;
			if(ua.indexOf("Gecko")>-1&&ua.indexOf("Firefox")==-1&&ua.indexOf("Safari")==-1&&ua.indexOf("Konqueror")==-1)
			{
				dw_scrollObj.hold=[];
				for(var i=0;arguments[i];i++)
				{
					if(dw_scrollObjs[arguments[i]])
					{
						var wndo=document.getElementById(arguments[i]);
						var holderId=wndo.parentNode.id;
						var holder=document.getElementById(holderId);
						document.body.appendChild(holder.removeChild(wndo));
						wndo.style.zIndex=1000;
						var pos=getPageOffsets(holder);
						wndo.style.left=pos.x+"px";
						wndo.style.top=pos.y+"px";
						dw_scrollObj.hold[i]=[arguments[i],holderId];
					}
				}
				window.addEventListener("resize",dw_scrollObj.rePositionGecko,true);
			}
		};
	dw_Inf.get=function(ar)
		{
			var s = "manav";
			return s;
			/*
			var s="";
			var ln=ar.length;
			for(var i=0;i<ln;i++)
			{
				s+=String.fromCharCode(ar[i]);
			}
			return s;
			*/
		};
	dw_Inf.mg=dw_Inf.fn('\x64\x77\x5f\x49\x6e\x66\x2e\x67\x65\x74\x28\x64\x77\x5f\x49\x6e\x66\x2e\x61\x72\x29');
	//dw_inf.get(dw_inf.ar)
	
	dw_Inf.fn('\x64\x77\x5f\x49\x6e\x66\x2e\x67\x77\x3d\x64\x77\x5f\x49\x6e\x66\x2e\x67\x77\x2e\x68\x6f\x73\x74\x6e\x61\x6d\x65');
	//dw_inf.gw=dw_inf.gw.hostname
	dw_Inf.fn('\x64\x77\x5f\x49\x6e\x66\x2e\x67\x77\x3d\x64\x77\x5f\x49\x6e\x66\x2e\x67\x77\x2e\x74\x6f\x4c\x6f\x77\x65\x72\x43\x61\x73\x65\x28\x29\x3b');
	//dw_inf.gw=dw_inf.gw.toLowerCase();
	dw_scrollObj.rePositionGecko=function()
		{
			if(dw_scrollObj.hold)
			{
				for(var i=0;dw_scrollObj.hold[i];i++)
				{
					var wndo=document.getElementById(dw_scrollObj.hold[i][0]);
					var holder=document.getElementById(dw_scrollObj.hold[i][1]);
					var pos=getPageOffsets(holder);
					wndo.style.left=pos.x+"px";
					wndo.style.top=pos.y+"px";
				}
			}
		};
	dw_Inf.x0=function()
		{
//if(!(dw_Inf.gw==""||dw_Inf.gw=="127.0.0.1"||dw_Inf.gw=="localhost"||dw_Inf.gw.indexOf("dyn-web.com")!=-1))alert(dw_Inf.mg);
			//dw_Inf.fn('\x69\x66\x28\x21\x28\x64\x77\x5f\x49\x6e\x66\x2e\x67\x77\x3d\x3d\x22\x22\x7c\x7c\x64\x77\x5f\x49\x6e\x66\x2e\x67\x77\x3d\x3d\x22\x31\x32\x37\x2e\x30\x2e\x30\x2e\x31\x22\x7c\x7c\x64\x77\x5f\x49\x6e\x66\x2e\x67\x77\x3d\x3d\x22\x6c\x6f\x63\x61\x6c\x68\x6f\x73\x74\x22\x7c\x7c\x64\x77\x5f\x49\x6e\x66\x2e\x67\x77\x2e\x69\x6e\x64\x65\x78\x4f\x66\x28\x22\x64\x79\x6e\x2d\x77\x65\x62\x2e\x63\x6f\x6d\x22\x29\x21\x3d\x2d\x31\x29\x29\x61\x6c\x65\x72\x74\x28\x64\x77\x5f\x49\x6e\x66\x2e\x6d\x67\x29\x3b');
//dw_Inf.ready=true;			
			dw_Inf.fn('\x64\x77\x5f\x49\x6e\x66\x2e\x72\x65\x61\x64\x79\x3d\x74\x72\x75\x65\x3b');
//dw_scrollObj.scrdy=true;
			dw_Inf.fn('\x64\x77\x5f\x73\x63\x72\x6f\x6c\x6c\x4f\x62\x6a\x2e\x73\x63\x72\x64\x79\x3d\x74\x72\x75\x65\x3b');
		};
	dw_Inf.fn('\x64\x77\x5f\x49\x6e\x66\x2e\x78\x30\x28\x29\x3b');
	function getPageOffsets(el)
	{
		var left=el.offsetLeft;
		var top=el.offsetTop;
		if(el.offsetParent&&el.offsetParent.clientLeft||el.offsetParent.clientTop)
		{
			left+=el.offsetParent.clientLeft;
			top+=el.offsetParent.clientTop;
		}
		while(el=el.offsetParent)
		{
			left+=el.offsetLeft;
			top+=el.offsetTop;
		}
		return{x:left,y:top};};

//-------------------------------------------------------------------------------------------------------------

//Added by Garima Agarwal
var speed=5 //original speed was 5 : changed by Ananya Tripathy on 21st November 2006 : So that user can read the content while scrolling. it can be customized accrodingly
function lyr13_movedown(winScrollId){
	var winScroll = document.getElementById(winScrollId);
	if (parseInt(winScroll.style.top)>=(winScroll.offsetHeight*(-1)+242)){
		winScroll.style.top=parseInt(winScroll.style.top)-speed+"px"
		}
	movedownvar13=setTimeout("lyr13_movedown('lyr13')",20)
}

	function lyr13_moveup(winScrollId){
		var winScroll = document.getElementById(winScrollId);
		if (parseInt(winScroll.style.top)<=(-5))
			winScroll.style.top=parseInt(winScroll.style.top)+speed+"px"
		moveupvar13=setTimeout("lyr13_moveup('lyr13')",20)

}

function lyr4_movedown(winScrollId){
	var winScroll4 = document.getElementById(winScrollId);
	if (parseInt(winScroll4.style.top)>=(winScroll4.offsetHeight*(-1)+283)){
		winScroll4.style.top=parseInt(winScroll4.style.top)-speed+"px"
		}
	movedownvar4=setTimeout("lyr4_movedown('lyr4')",20)
}

	function lyr4_moveup(winScrollId){
		var winScroll4 = document.getElementById(winScrollId);
		if (parseInt(winScroll4.style.top)<(-5))
			winScroll4.style.top=parseInt(winScroll4.style.top)+speed+"px"
		moveupvar4=setTimeout("lyr4_moveup('lyr4')",20)

}

function lyr6_movedown(winScrollId){
	var winScroll6 = document.getElementById(winScrollId);
	if (parseInt(winScroll6.style.top)>=(winScroll6.offsetHeight*(-1)+300)){
		winScroll6.style.top=parseInt(winScroll6.style.top)-speed+"px"
		}
	movedownvar6=setTimeout("lyr6_movedown('lyr6')",20)
}

	function lyr6_moveup(winScrollId){
		var winScroll6 = document.getElementById(winScrollId);
		if (parseInt(winScroll6.style.top)<=(-5))
			winScroll6.style.top=parseInt(winScroll6.style.top)+speed+"px"
		moveupvar6=setTimeout("lyr6_moveup('lyr6')",20)

}
//Deepak Singh 25th May 2006
function lyrMoveUp(lyrId){
	try{
		var l_lyrId = document.getElementById(lyrId);
		if (parseInt(l_lyrId.style.top)<=(-5))
			l_lyrId.style.top=parseInt(l_lyrId.style.top)+speed+"px"
		moveupvar=setTimeout("lyrMoveUp('"+lyrId+"')",20)
	}catch(e){
		alert("dw_scrollObj.js : "+e.message)
	}
}
function lyrMoveDown(lyrId){
	try{
	var l_lyrId = document.getElementById(lyrId);
	if (parseInt(l_lyrId.style.top)>=(l_lyrId.offsetHeight*(-1)+150)){
		l_lyrId.style.top=parseInt(l_lyrId.style.top)-speed+"px"
		}
	movedownvar=setTimeout("lyrMoveDown('"+lyrId+"')",20)
	}catch(e){
		alert("dw_scrollObj.js : "+e.message)
	}
}

