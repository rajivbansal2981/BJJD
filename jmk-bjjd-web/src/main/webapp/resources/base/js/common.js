/*******************************************************
* Client  : Godfrey Phillips India Ltd (GPI)
* Project : Merchandising Management System
* Author  : Deepak Singh
* File    : common.js
* Created : Dec 05, 2006
* Purpose : This file to be included in all jsp's and html
*******************************************************/
//
var m_blnIsProcessing = false;

//Counter for the Steps involved in Particalur form submission process
var intStepCounter = 1;

//Common variables used for implementing Ajax.
var req;
var xmlResponse;
var which;

//Valid extensions for Media Files
var validPictureFileExtensions=new Array("png","gif","jpg","jpeg");
var validMusicFileExtensions=new Array("wav","wmv","mp3","aif");
var validVideoFileExtensions=new Array("mpeg","mpg","miv","mp2","mpax","avi","wmv");
var validDocumentFileExtensions=new Array("doc","xls","ppt","pps","pdf");

/*
	 @author  : Deepak Singh
	 @Purpose : Function to Javascript Debugging/Errors/Exceptions
	 @param string (msg : Errors/Exception Message)
	 @param string (URL : The title that would be displayed for Popup)
	 @param string (lineNum : Line Number where Errors/Exceptions Occurred)
	 @exception : No Action
*/
// turn off javascript error dialogs
function turnOffErrorDialog() {
    window.onerror = doNothing;
}
// turn on javascript error dialogs with hard reload
function turnOffErrorDialog() {
    window.onerror = handleError;
}
// assign default javascript error handler
window.onerror = handleError
// javascript error handler when errors are turned off...prevents error dialog
function doNothing() {return true;}
// javascript error handler when errors are turned on...displays error dialog
function handleError(msg, URL, lineNum) {
    var errWind = window.open("","errors","HEIGHT=280,WIDTH=500,TOP="+((screen.height-280)/2)+",LEFT="+((screen.width-500)/2)+"");
    var wintxt  = "<HTML>";
       	wintxt += "<head>";
       	wintxt += "<title>Javascript Error !!</title>";
       	wintxt += "<style type='text/css'>";
       	wintxt += ".normaltextcls {font-family: Tahoma;font-size: 11px;font-weight: normal;color: #CC0000;text-decoration: none;}";
       	wintxt += ".textboxcls {font-family: Arial, Helvetica, sans-serif;font-size: 11px;font-weight: normal;padding: 1px;color: #CC0033;border: 1px solid #000000;}";
      	wintxt += ".buttoncls {font-family: Arial, Helvetica, sans-serif;}";
       	wintxt += "</style>";
       	wintxt += "</head>";
       	wintxt += "";
       	wintxt += "";
       	wintxt += "";
    	wintxt += "<BODY>";
	    wintxt += "<div class='normaltextcls'>";
	    wintxt += "<B>An error has occurred on this page. Please report it to GPI-MMS Development Team.<B>";
		wintxt += "</div>";
	    wintxt += "<FORM METHOD=POST ENCTYPE='text/html' ";
	    wintxt += "ACTION='mailTo:deepaks@cressanda.com;garimaa@cressanda.com;ananyat@cressanda.com;ankurj@cressanda.com;sunainas@cressanda.com'>";
    	wintxt += "<TEXTAREA class='textboxcls' NAME='errMsg' COLS=92 ROWS=12 WRAP=VIRTUAL>";
	    wintxt += "Error: " + msg + "\n";
    	wintxt += "URL: " + URL + "\n";
	    wintxt += "Line: " + lineNum + "\n";
    	wintxt += "Client: " + navigator.userAgent + "\n";
	    wintxt += "----------------------------------------------------------------------------------------------------------------\n";
	    wintxt += "Please describe what you were doing when the error occurred:";
	    wintxt += "</TEXTAREA><P>";
	    wintxt += "<center><INPUT TYPE=SUBMIT class='textboxcls' VALUE='Send Error Report'>&nbsp;&nbsp;&nbsp;&nbsp;";
	    wintxt += "<INPUT TYPE=button class='textboxcls' VALUE='Close' onClick='self.close()'></center>";
    	wintxt += "</FORM>";
    wintxt += "</BODY></HTML>";
    errWind.document.write(wintxt);
    errWind.document.close();
    return true;
}
/*
	@author  : Deepak Singh
	@Purpose : Function to alert Exception. Used by all other java methods in catch block
	@param string (strFileFunction : In which file & in which method the exception is occurred
					e.g. "index.jsp|myMethod" )
	@param string (strId : Id attribute of the html element)
	@exception : No Action
*/
function alertException(strFileFunction,objExcp){
	try{
		var strExcpMessage = "An exception occurred in the script.\n\n" +

							"\n\n File/Function : " + strFileFunction	+

							"\n\n Error message: " + objExcp.message +

							"\n\n Error name: " + objExcp.name +

							"\n\n Error number: " + objExcp.number +

							"\n\n Error description: " + objExcp.description ;
		alert(strExcpMessage);
	 }
	catch(e){
		alert("Exception in alertException() Itself. Please Repair ASAP : \n\n"+e.message);
	}
}
/*
* Author : Deepak Singh
*/
function acceptIntOnlyLimitLength(p_ObjFormField,length){
	var str = p_ObjFormField.value;
	if(getIntegerValue(str)==0){
		p_ObjFormField.value=0;
	}
	if(str.length>length){
		alert("Only "+length+" Digits are allowed");
		p_ObjFormField.value=0;
	}
	p_ObjFormField.focus();
}
/*
	 @author  : Deepak Singh
	 @Purpose : Function to handle XML's special characters
	 @param string (value : String to be replaced for special character parsed by XML API)
	 @exception : same value is returned
*/
function validateXML(value)
{
	try{
		value=value.replace('&apos;','\'');
		value=value.replace('&quot;','\"');
		value=value.replace('&gt;','>');
		value=value.replace('&lt;','<');
		value=value.replace('&amp;','&');
		return value;
	}catch(e){
		alertException("common.js|validateXML",e);
		return value;
	}
}
/*
	 @author  : Deepak Singh
	 @Purpose : Function would construct xml Object
	 @param string (xmlStr : string which would be converted to xml Object)
	 @exception : Returns null
*/
function loadXmlFromServer(p_strURL) {
	try{
			//variable for the created DOM Document
            var objDOM = null;
            // code for IE
            if (window.ActiveXObject) {
       				      var aVersions=["Msxml2.DOMDocument.5.0", "Msxml2.DOMDocument.4.0", "Msxml2.DOMDocument.3.0", "MSXML2.DOMDocument", "MSXML.DOMDocument", "Microsoft.XMLDOM"];
					      for (var i = 0; i < aVersions.length; i++) {
					        try {
					            var objDOM = new ActiveXObject(aVersions[i]);
					            objDOM.async=false;
								objDOM.load(p_strURL);
	                        	return objDOM.documentElement;
					        } catch (oError) {
					            //Do nothing
					        }
					      }
					      throw new Error("XMLDOM object not installed on this Browser.");
            }
            // code for Mozilla, etc.
            else if (document.implementation && document.implementation.createDocument) {
				objDOM= document.implementation.createDocument("","",null);
				//create a DOMParser
				var objDOMParser = new DOMParser();
				//create new document from string
				var objDOM = objDOMParser.parseFromString(xmlStr, "text/xml");
                return objDOM;
            } else {
				throw new Error("XMLDOM object not installed on this Browser.");
			}
	}catch(e){
		alertException("common.js|loadXmlFromServer()",e);
	}
}
/*
	 @author  : Deepak Singh
	 @Purpose : Function would construct xml Object
	 @param string (xmlStr : string which would be converted to xml Object)
	 @exception : Returns null
*/
function createDOMDocument (xmlStr) {
	try{
            //variable for the created DOM Document
            var objDOM = null;
            // code for IE
            if (window.ActiveXObject) {
       				      var aVersions=["Msxml2.DOMDocument.5.0", "Msxml2.DOMDocument.4.0", "Msxml2.DOMDocument.3.0", "MSXML2.DOMDocument", "MSXML.DOMDocument", "Microsoft.XMLDOM"];
					      for (var i = 0; i < aVersions.length; i++) {
					        try {
					            var objDOM = new ActiveXObject(aVersions[i]);
					            objDOM.async=false;
								objDOM.loadXML(xmlStr);
	                        	return objDOM.documentElement;
					        } catch (oError) {
					            //Do nothing
					        }
					      }
					      throw new Error("XMLDOM object not installed on this Browser.");
            }
            // code for Mozilla, etc.
            else if (document.implementation && document.implementation.createDocument) {
				objDOM= document.implementation.createDocument("","",null);
				//create a DOMParser
				var objDOMParser = new DOMParser();
				//create new document from string
				var objDOM = objDOMParser.parseFromString(xmlStr, "text/xml");
                return objDOM;
            } else {
				throw new Error("XMLDOM object not installed on this Browser.");
			}
	}catch(e){
		alertException("common.js|createDOMDocument",e);
		throw new Error("XMLDOM object not installed on this Browser.");
	}
}
function alertAjaxResponseType(){
	try{
		var sContentType = req.getResponseHeader("Content-Type");
		alert(sContentType);
	}catch(e){
		alertException("common.js|alertAjaxResponseType",e);
	}
}
function alertAjaxResponseHeaders(){
	try{
		if(req){
			var sHeaders = req.getAllResponseHeaders();
			var aHeaders = sHeaders.split(/\r?\n/);
			var msg = "Ajax Response Header Data: \n";
			for (var i=0; i < aHeaders.length; i++) {
			    msg=msg+"["+(i+1)+"] : "+"\n"+aHeaders[i];
			}
			alert(msg);
		}
	}catch (oError){
    	alertException("common.js|alertAjaxResponseHeaders",oError);
    }
}
/*
	 @author  : Deepak Singh
	 @Purpose : Function to create XMLHttpRequest Object according to version of explorer
	 @exception : No Action
*/
function createXMLHttp() {

    if (typeof XMLHttpRequest != "undefined") {
          return new XMLHttpRequest();
    }else if (window.ActiveXObject) {
	      var aVersions=["Msxml2.XMLHTTP.5.0", "Msxml2.XMLHTTP.4.0", "MSXML2.XMLHTTP.3.0", "MSXML2.XMLHTTP", "Microsoft.XMLHTTP"];
	      for (var i = 0; i < aVersions.length; i++) {
	        try {
	            var oXmlHttp = new ActiveXObject(aVersions[i]);
	            return oXmlHttp;
	        } catch (oError) {
	            //Do nothing
	        }
	      }
    }
    throw new Error("XMLHTTP object not installed on this Browser.");
}
/*
	 @author  : Deepak Singh
	 @Purpose : Function to Call Action Classes using AJAX
	 @param string (url : For calling an action)
	 @exception : No Action
*/
function retrieveURL(url) {
	try{
			req = createXMLHttp();
			req.onreadystatechange = processStateChange;
			if(url.indexOf("?")>0){
				url+="&datetime="+getFormattedDate("h:i:s:a",new Date());
			}else{
				url+="?datetime="+getFormattedDate("h:i:s:a",new Date());
			}
			req.open("GET", url, true);
			req.send(null);
	}catch(e){
		alertException("common.js|retrieveURL",e);
	}
}
/*
	@author	 : Deepak Singh
	@Purpose : Function to Call Action Classes using AJAX
	@param string (url : For calling an action class)
	@param string (method : POST or GET)
	@param string (isSynchronous : Whether the request/response should be synchronous)
	@param string (queryString : In Case of POST method, if GET method pass null)
	@exception : No Action
*/
function retrieveCustomizedURL(url,method,isSynchronous,queryString) {
	try{
		req = createXMLHttp();
		req.onreadystatechange = processStateChange;
		if(url.indexOf("?")>0){
			url+="&datetime="+getFormattedDate("h:i:s:a",new Date());
		}else{
			url+="?datetime="+getFormattedDate("h:i:s:a",new Date());
		}
		req.open(method, url, isSynchronous);
		req.send(queryString);
	}catch(e){
		alertException("common.js|retrieveCustomizedURL",e);
	}
  }
/*
	 @author  : Ankur Jain
	 @Purpose : Function for Adding page as a Bookmark
	 @param string  (url  : web url to bookmark)
	 @param string  (name : url bookmark with given name)
	 @exception : No Action
*/
function addBookMark(url,name)
{
	try{
		if (window.sidebar) { // Mozilla Firefox Bookmark
                window.sidebar.addPanel(name, url,"");
        } else if( window.external ) { // IE Favorite
                window.external.AddFavorite( url, name);
		}
        else if(window.opera && window.print) { // Opera Hotlist
                return true;
		}
	}catch(e){
		alertException("common.js|addBookMark",e);
	}
}
/*
	 @author  : Ankur Jain
	 @Purpose : Saving a Page to Local Disk
	 @param string  (filename : which file to save)
	 @exception : No Action
*/
function saveAs() {
	try{
		if (document.all) {
			var OLECMDID_SAVEAS = 4;
			var OLECMDEXECOPT_DONTPROMPTUSER = 2;
			var OLECMDEXECOPT_PROMPTUSER = 1;
			var WebBrowser = "<OBJECT ID=\"WebBrowser1\" WIDTH=0 HEIGHT=0 CLASSID=\"CLSID:8856F961-340A-11D0-A96B-00C04FD705A2\"></OBJECT>";
			document.body.insertAdjacentHTML("beforeEnd", WebBrowser);
			WebBrowser1.ExecWB(OLECMDID_SAVEAS, OLECMDEXECOPT_PROMPTUSER);
			WebBrowser1.outerHTML = "";
			} else {
			alert("Sorry, your browser does not support this feature. Save the web page from the FILE menu of your browser.");
		}
	}catch(e){
		alertException("common.js|saveAs",e);
	}
}
/*
	 @author  : Ankur Jain
	 @Purpose : Saving a Page to Local Disk
	 @param string (filename : which file to save)
	 @exception : No Action
*/
function doSaveAs(filename)
{
 	try{
		 if (document.execCommand){
		  document.execCommand("SaveAs",null,"SALSA_"+filename+".html");
		 }
		 else {
		  alert("Some Problem While Saving...")
		 }
	}catch(e){
		alertException("common.js|doSaveAs",e);
	}
}
/*
	 @author  : Ankur Jain
	 @Purpose : Function for Resizing the Window size
	 @param string (height :  of window to resize)
	 @param string (width  :  of window to resize)
	 @exception : No Action
*/
function resizeWindow(height,width) {
	try{
		window.resizeTo(height,width);
	}catch(e){
		alertException("common.js|resizeWindow",e);
	}
}
/*
	 @author  : Deepak Singh
	 @Purpose : Function to Open Popups
	 @param string (theURL : The url for popup)
	 @param string (winName : The title that would be displayed for Popup)
	 @param string (features : Features of popup opened,
	 				it includes height,width,scroll,noscroll,maxmizable,not maxmizable etc)
	 @exception : No Action
*/
function openPopup(theURL,winName,features) {
	try{
		  window.open(theURL,winName,features);
  	}catch(e){
		alertException("common.js|openPopup",e);
	}
}
/*
	 @author  : Ankur Jain
	 @Purpose : Auto Re-Sizing of pop-up window According to Image Size
	 @param string  (imageURL : The url of image)
	 @param string  (imageTitle : The title that would be displayed for Popup)
	 @exception : No Action

*/
// Set the horizontal and vertical position for the popup
PositionX = 100;
PositionY = 100;
// Set these value approximately 20 pixels greater than the
// size of the largest image to be used (needed for Netscape)
defaultWidth  = 500;
defaultHeight = 500;
// Set autoclose true to have the window close automatically
// Set autoclose false to allow multiple popup windows
var AutoClose = true;
if (parseInt(navigator.appVersion.charAt(0))>=4){
var isNN=(navigator.appName=="Netscape")?1:0;
var isIE=(navigator.appName.indexOf("Microsoft")!=-1)?1:0;}
var optNN='scrollbars=yes,width='+defaultWidth+',height='+defaultHeight+',left='+PositionX+',top='+PositionY;
var optIE='scrollbars=yes,width=150,height=100,left='+PositionX+',top='+PositionY;

function popImage(imageURL,imageTitle){
	try{
		if (isNN){imgWin=window.open('about:blank','',optNN);}
		if (isIE){imgWin=window.open('about:blank','',optIE);}
		with (imgWin.document){
		writeln('<html><head><title>Loading...</title><style>body{margin:0px;}</style>');writeln('<sc'+'ript>');
		writeln('var isNN,isIE;');writeln('if (parseInt(navigator.appVersion.charAt(0))>=4){');
		writeln('isNN=(navigator.appName=="Netscape")?1:0;');writeln('isIE=(navigator.appName.indexOf("Microsoft")!=-1)?1:0;}');
		writeln('function reSizeToImage(){');writeln('if (isIE){');writeln('window.resizeTo(100,100);');
		writeln('width=120-(document.body.clientWidth-document.images[0].width);');
		writeln('height=100-(document.body.clientHeight-document.images[0].height);');
		writeln('window.resizeTo(width,height);}');writeln('if (isNN){');
		writeln('window.innerWidth=document.images["George"].width;');writeln('window.innerHeight=document.images["George"].height;}}');
		writeln('function doTitle(){document.title="'+imageTitle+'";}');writeln('</sc'+'ript>');
		if (!AutoClose) writeln('</head><body bgcolor=000000 scroll="yes" onload="reSizeToImage();doTitle();self.focus()">')
		else writeln('</head><body bgcolor=000000 scroll="yes" onload="reSizeToImage();doTitle();self.focus()" onblur="self.close()">');
		writeln('<img name="George" src=\''+imageURL+'\' style="display:block"></body></html>');
		close();
	}
	}catch(e){
		alertException("common.js|popImage",e);
	}
}
/*
	 @author  : Deepak Singh
	 @Purpose : Trim Leading & Trailing Spaces in Given String
	 @Usage   : strVar.trim();
	 @exception : returns the same string object without any change
*/
String.prototype.trim = function() {
	try{
		return (this.replace(/^[\s\xA0]+/, "").replace(/[\s\xA0]+$/, ""));
	}catch(e){
		alertException("common.js|String.prototype.trim",e);
		return this;
	}
}
String.prototype.trimAll = function() {
	try{
		return str.replace(/\s+/g," ").trim();
	}catch(e){
		alertException("common.js|String.prototype.trimAll",e);
		return this;
	}
}
/*
	 @author  : Deepak Singh
	 @Purpose : Replace all occurence of  string in provided string
	 @param string sString 		(Original String)
	 @param string sReplaceThis (String to be replaced from)
	 @param string sWithThis 	(String to be replaced to)
	 @exception : returns the same String (sString)

*/
function replaceAllString(sString, sReplaceThis, sWithThis) {
	try{
		if (sReplaceThis != "" && sReplaceThis != sWithThis) {
			var counter = 0;
			var start = 0;
			var before = "";
			var after = "";
			while (counter<sString.length) {
				start = sString.indexOf(sReplaceThis, counter);
				if (start == -1) {
					break;
				} else {
				before = sString.substr(0, start);
				after = sString.substr(start + sReplaceThis.length, sString.length);
				sString = before + sWithThis + after;
				counter = before.length + sWithThis.length;
				}
			}
		}
		//alert(sString+"\n\nHi");
	  	return sString;
	}catch(e){
		alertException("common.js|replaceAllString",e);
		return sString;
	}
}

/*
	 @author  : Deepak Singh
	 @Purpose : For deleting all rows in given table
	 @param string (tableID : id of the table)
	 @exception : No Action
*/
function deleteAllRows(tableID){
	try{
		var tbl = document.getElementById(tableID);
		var rowCount = tbl.rows.length;
		for(i=0 ; i<rowCount ; i++){
			tbl.deleteRow(0);
		}
	}catch(e){
		alertException("common.js|deleteAllRows",e);
	}
}
/*
	 @author  : Deepak Singh
	 @Purpose : For Displaying the text length entered in Text area.
	 @param string (field 	: form field name)
	 @param string (cntfield : current count of text that is entered)
	 @param string (maxlimit : maximum limit of text to be entered)
	 @param object (e : Event Object for tracking the key press event)
	 @exception : No Action
*/
function textCounter(field,cntfield,maxlimit,e) {
	try{
		if(e==null){
			var y=maxlimit - field.value.length;
				cntfield.innerText = (maxlimit - field.value.length)+ " characters left." ;
		}
		if(e!=null && e.keyCode!=13){
			if (field.value.length > maxlimit){ // if too long...trim it!
					field.value = field.value.substring(0, maxlimit);
			}
			// otherwise, update 'characters left' counter
			else{
				var y=maxlimit - field.value.length;
				cntfield.innerText = (maxlimit - field.value.length)+ " characters left." ;
			}
		}
	}catch(e){
		alertException("common.js|textCounter",e);
	}
}
/*
	 @author  : Ananya Tripathy
	 @Modified by : Deepak Singh
	 @Purpose : Function for removing all options in combo and adding "Select One" Option.
	 @param string (fieldId : form field name)
	 @exception : No Action
*/
function combo_DelteAllOptions(paramObjCombo,paramStrFieldId){
	try{
		var objCombo=getObject(paramObjCombo,paramStrFieldId);
		if(objCombo==null){
			alert("Cannot Construct Combo Box Object Using paramObjCombo/paramStrFieldId !");
		}
		var arrComboOptions = objCombo.options;
	   	for(var i=arrComboOptions.length;i>=0;i--){
			objCombo.remove(i);
		}
		var objOption = document.createElement("OPTION");
		objOption.text ="-----------------Select One------------------";
		objOption.value ='-1';
		if(window.ActiveXObject){
			objCombo.add(objOption);
		}
		else{
			objCombo.appendChild(objOption);
		}
	}catch(e){
		alertException("common.js|combo_DelteAllOptions",e);
	}
}
/*
	 @author  : Deepak Singh
	 @Purpose : Function for adding single option at last index of combo. Either of the paramObjCombo/paramStrFieldId
	 			should be passed not both.
	 @param string (paramObjCombo : form field object)
	 @param string (paramStrFieldId : form field id)
	 @param string (strText : text for combo option)
	 @param string (strValue : value for combo option)
	 @exception : No Action
*/
function combo_AddOption(paramObjCombo,paramStrFieldId,strText,strValue){
	try{
		var objCombo=getObject(paramObjCombo,paramStrFieldId);
		if(objCombo==null){
			alert("Cannot Construct Combo Box Object Using paramObjCombo/paramStrFieldId !");
		}
		var objOption = document.createElement("OPTION");
		objOption.text =strText;
		objOption.value =strValue;
		if(window.ActiveXObject){
			objCombo.add(objOption);
		}
		else{
			objCombo.appendChild(objOption);
		}
	}catch(e){
		alertException("common.js|combo_AddOption",e);
	}
}
/*
	 @author  : Deepak Singh
	 @Purpose : Function for validating combo box. Either of the paramObjCombo/paramStrFieldId
	 			should be passed not both.
	 @param string (paramObjCombo : form field object)
	 @param string (paramStrFieldId : form field id)
	 @param string (str : Combo box actual field name which would be displayed to user in error message)
	 @exception : return false
*/
function combo_Validator(paramObjCombo,paramStrFieldId,str)
{
	try{
		var objCombo = getObject(paramObjCombo,paramStrFieldId);
		if (objCombo.selectedIndex == 0 || objCombo.selectedIndex == null)
		{
			alert("Choose one "+str+" from the drop-down List.");
			objCombo.focus();
			return false;
		}
		return true;
	}catch(e){
		alertException("common.js|combo_Validator",e);
		return false;
	}
}
/*
	 @author  : Deepak Singh
	 @Purpose : Checks all the checkboxes (grouped with common Name/Id)
	 @param string (paramObjCheckbox : form field object for checkbox)
	 @exception : No Action
*/
function checkbox_CheckAll(paramObjCheckbox)
{
	try{
		if(paramObjCheckbox.length==null || paramObjCheckbox.length=='undefined'){
			paramObjCheckbox.checked = true ;
		}else{
			for (i = 0; i < paramObjCheckbox.length; i++)
				paramObjCheckbox[i].checked = true ;
		}

	}catch(e){
		alertException("common.js|checkbox_CheckAll",e);
	}
}
/*
	 @author  : Deepak Singh
	 @Purpose : UnChecks all the checkboxes (grouped with common Name/Id)
	 @param string (paramObjCheckbox : form field object for checkbox)
	 @exception : No Action
*/
function checkbox_UnCheckAll(paramObjCheckbox)
{
	try{
		if(paramObjCheckbox.length==null || paramObjCheckbox.length=='undefined'){
			paramObjCheckbox.checked = false;
		}else{
			for (i = 0; i < paramObjCheckbox.length; i++)
				paramObjCheckbox[i].checked = false ;
		}
	}catch(e){
		alertException("common.js|checkbox_UnCheckAll",e);
	}
}

/*
	 @author  : Deepak Singh
	 @Purpose : disables all the checkboxes (grouped with common Name/Id)
	 @param string (paramObjCheckbox : form field object for checkbox)
	 @exception : No Action
*/
function checkbox_disableAll(paramObjCheckbox)
{
	try{
		if(paramObjCheckbox.length==null || paramObjCheckbox.length=='undefined'){
			paramObjCheckbox.disabled = true;
		}else{
			for (i = 0; i < paramObjCheckbox.length; i++)
				paramObjCheckbox[i].disabled = true ;
		}
	}catch(e){
		alertException("common.js|checkbox_disableAll",e);
	}
}

/*
	 @author  : Deepak Singh
	 @Purpose : Enables all the checkboxes (grouped with common Name/Id)
	 @param string (paramObjCheckbox : form field object for checkbox)
	 @exception : No Action
*/
function checkbox_enableAll(paramObjCheckbox)
{
	try{
		if(paramObjCheckbox.length==null || paramObjCheckbox.length=='undefined'){
			paramObjCheckbox.disabled = false;
		}else{
			for (i = 0; i < paramObjCheckbox.length; i++)
				paramObjCheckbox[i].disabled = false ;
		}
	}catch(e){
		alertException("common.js|checkbox_disableAll",e);
	}
}
/*
	 @author  : Deepak Singh
	 @Purpose : Validates if none of the checkboxes (grouped with common Name/Id) is selected
	 @param string (paramObjCheckbox : form field object for checkbox)
	 @exception : No Action
*/
function checkbox_Validator(paramObjCheckbox,str)
{
	try{
		if(paramObjCheckbox.length==null || paramObjCheckbox.length=='undefined'){
			if( paramObjCheckbox.checked == true ){
				return true;
			}
		}
		else{
			for (i = 0; i < paramObjCheckbox.length; i++){
				if( paramObjCheckbox[i].checked == true ){
					return true;
				}
			}
		}
		alert("Please check atleast one checkbox to "+str+" ");
		return false;
	}catch(e){
		alertException("common.js|checkbox_Validator",e);
		return false;
	}
}

function checkbox_CountValidator(paramObjCheckbox,str)
{
	try{
		var chkCount=0;
		if(paramObjCheckbox.length==null || paramObjCheckbox.length=='undefined'){
			if( paramObjCheckbox.checked == true ){
				return true;
			}
		}
		else{
			for (i = 0; i < paramObjCheckbox.length; i++){
				if( paramObjCheckbox[i].checked == true ){
					chkCount++;

				}
			}

		}
		if(chkCount>2){
			alert("Please select only one checkbox to "+str+" ");
			return false;
		}else{
			return true;
		}
	}catch(e){
		alertException("common.js|checkbox_CountValidator",e);
		return false;
	}
}

/*
	@author  : Ananya Tripathy
	 @Purpose : Function for getting object of particular form field from either of the paramObj/paramStrFieldId.
	 			paramObj or paramStrId should should be passed not both. i.e either of them should be null
	 @param string (paramObjCombo : form field object)
	 @param string (strName : ComboName)
	 @param string(type : Input type for text box  e,g Char,Numeric)
	 @exception : returns null if nothing is correct else return either of them
*/
function textField_Validator(paramObj,strName,type)
{
	if (paramObj.value == "")
	{
		alert("Please enter "+strName+".");
		paramObj.focus();
		return (false);
	}else{
		return validateText(paramObj,type,strName);
	}
	return (true);
}
/*
*  By Ananya
*  Function validateText to validate text inputType
*/
var lwr = 'abcdefghijklmnopqrstuvwxyz';
var upr = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
var scr = '-_';
var sp  = ' ';
var numb = '0123456789.';
var alphaNum = lwr+upr+scr+sp+numb;

function validateText(paramObj,type,str)
{
	var txtval = paramObj.value.trim();
	paramObj.value = txtval;
	if(txtval==""){
		alert("Please enter "+str+".");
		paramObj.focus();
		return (false);
	}
	if (txtval.length > 25){
		mesg = "You have entered " + paramObj.value.length + " character(s)\n"
		mesg = mesg + "Valid entries should be less than 25 characters.\n"
		mesg = mesg + "Please verify your input and submit again."
		alert(mesg);
		//validateText(obj,type);
		paramObj.focus();
		return (false);
	}

	paramObj.focus();
	if(type=='Char'){
		return checkForCharacters(txtval,lwr+upr+scr+sp,str);
	}else if(type=='Num'){
		return checkForNumeric(txtval,numb,str);
	}else if(type=='AlphaNum'){
		return checkForAlphaNumeric(txtval,alphaNum,str);
	}else if(type==''){
		return true;
	}
}
/*
*  By Ananya
*  Function checkForCharacters to check text should be in characters only
*/
function checkForCharacters(param,val,str) {
  if (param == "") return true;
  for (i=0; i<param.length; i++) {
    if (val.indexOf(param.charAt(i),0) == -1) {
		alert(str+" should be in characters.")
		return false;
	}
  }
  return true;
}
/*
*  By Ananya
*  Function checkForNumeric to check text should be in numeric only
*/
function checkForNumeric(param,val,str){
if (param == "") return true;
  for (i=0; i<param.length; i++) {
    if (val.indexOf(param.charAt(i),0) == -1) {
		alert(str+" should be in Numeric.")
		return false;
	}
  }
  return true;
}
/*
*  By Ananya
*  Function checkForNumeric to check text should be in Alphabets & numeric only
*/
function checkForAlphaNumeric(param,val,str){
if (param == "") return true;
  for (i=0; i<param.length; i++) {
    if (val.indexOf(param.charAt(i),0) == -1) {
		alert(str+" should be in AlphaNumeric.")
		return false;
	}
  }
  return true;
}
/*
	 @author  : Deepak Singh
	 @Purpose : Function for getting object of particular form field from either of the paramObj/paramStrFieldId.
	 			paramObj or paramStrId should should be passed not both. i.e either of them should be null
	 @param string (paramObjCombo : form field object)
	 @param string (paramStrFieldId : form field id)
	 @exception : returns null if nothing is correct else return either of them
*/
function getObject(paramObj,paramStrId){
	try{
		var obj;
		if(paramStrId!=null){
			obj=document.getElementById(paramStrId);
			return obj;
		}
		if(paramObj!=null){
			obj=paramObj;
			return obj;
		}
		return null;
	}catch(e){
		alertException("common.js|getObject",e);
		return null;
	}
}
/*
	 @author  : Deepak Singh
	 @Purpose : Function for toggling html elements
	 @param string (strId : Id attribute of the html element)
	 @exception : No Action
*/
function toggle(paramObj,paramStrId) {
	try{
		var ObjElement = getObject(paramObj,paramStrId);
		ObjElement.style.display = (ObjElement.style.display != 'none' ? 'none' : '' );
	}catch(e){
		alertException("common.js|toggle",e);
		return null;
	}
}
/*
	Input 	Output
	---------------------------------------------------------------------------
	a 		"am" or "pm"
	A 		"AM" or "PM"
	d 		day of the month, 2 digits with leading zeros; i.e. "01" to "31"
	D 		day of the week, textual, 3 letters; i.e. "Fri"
	F 		month, textual, long; i.e. "January"
	g 		hour, 12-hour format without leading zeros; i.e. "1" to "12"
	G 		hour, 24-hour format without leading zeros; i.e. "0" to "23"
	h 		hour, 12-hour format; i.e. "01" to "12"
	H 		hour, 24-hour format; i.e. "00" to "23"
	i 		minutes; i.e. "00" to "59"
	j 		day of the month without leading zeros; i.e. "1" to "31"
	l 		(lowercase 'L') day of the week, textual, long; i.e. "Friday"
	L 		boolean for whether it is a leap year; i.e. "0" or "1"
	m 		month; i.e. "01" to "12"
	M 		month, textual, 3 letters; i.e. "Jan"
	n 		month without leading zeros; i.e. "1" to "12"
	r 		RFC 822 formatted date; i.e. "Thu, 21 Dec 2000 16:01:07 +0200"
	s 		seconds; i.e. "00" to "59"
	S 		English ordinal suffix, textual, 2 characters; i.e. "th", "nd"
	t 		number of days in the given month; i.e. "28" to "31"
	T 		Timezone setting of this machine; i.e. "MDT"
	U 		seconds since the UNIX epoch (1/1/1970)
	w 		day of the week, numeric, i.e. "0" (Sunday) to "6" (Saturday)
	Y 		year, 4 digits; i.e. "1999"
	y 		year, 2 digits; i.e. "99"
	z 		day of the year; i.e. "0" to "365"
	Z 		timezone offset in seconds (i.e. "-43200" to "43200")

	e.g if format is : "l jS of F Y, h:i:s a"
	then output is   : Thursday 5th of December 2006, 04:50:25 pm

	@author  : Deepak Singh
	@Purpose : Function to get current date in different format. Used by all other java methods in catch block
	@param string (format : specify format in which date should be return. format are detailed above
	@param object (dateObj : date object)
	@exception : No Action
*/
function getFormattedDate(format, dateObj)
{
	var val = new Array();

	if(dateObj.getHours() < 12) val['a'] = 'am';
	else val['a'] = 'pm';
	val['A'] = val['a'].toUpperCase();

	val['j'] = dateObj.getDate();
	val['d'] = padZero(val['j']);


	var day = new Array('Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday');
	val['w'] = dateObj.getDay();
	val['l'] = day[val['w']];
	val['D'] = val['l'].substring(0, 3);

	var month = new Array('January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December');
	val['F'] = month[dateObj.getMonth()];
	val['M'] = val['F'].substring(0, 3);

	val['G'] = dateObj.getHours();
	val['H'] = padZero(val['G']);

	val['g'] = val['G'];
	if(val['g'] > 12) val['g'] -= 12;
	val['h'] = padZero(val['g']);

	val['i'] = padZero(dateObj.getMinutes());


	if(dateObj.getFullYear()%4 == 0) val['L'] = 1;
	else val['L'] = 0;
	if((dateObj.getFullYear()%100 == 0) && (dateObj.getFullYear()%400 != 0)) val['L'] = 0; //important point
	val['n'] = dateObj.getMonth() + 1;
	val['m'] = padZero(val['n']);

	val['s'] = padZero(dateObj.getSeconds());

	var dateDigit2 = val['d'].toString().substring(val['d'].toString().length-1, 2);
	val['S'] = 'th';

	switch(dateDigit2)
	{
		case '1': val['S'] = 'st'; break;
		case '2': val['S'] = 'nd'; break;
		case '3': val['S'] = 'rd'; break;
	}
	if((val['j'] >= 11) && (val['j'] <= 13))
	val['S'] = 'th';


	var daysInMonth = new Array(31, 31, 28 + val['L'], 31, 30, 31, 30, 31, 31, 30, 31, 30)
	val['t'] = daysInMonth[dateObj.getMonth()];

	val['T'] = dateObj.toString().split(" ")[4].substring(0, 3);

	val['U'] = parseInt(dateObj.getTime() / 1000);

	val['Y'] = dateObj.getFullYear();
	val['y'] = val['Y'].toString().substring(1, 3);


	var dayNums = new Array();
	dayNums[0] = 0;
	var totalDays = 0;
	for(var x=1; x<=12; x++)
	{
		dayNums[x] = totalDays + daysInMonth[x-1];
		totalDays += daysInMonth[x-1];
	}
	val['z'] = dayNums[dateObj.getMonth()] + dateObj.getDate() - 1;

	val['Z'] = dateObj.getTimezoneOffset() * 60;

	val['r'] = val['D'] + ', ' + val['j'] + ' ' + val['M'] + ' ' + val['Y'] + ' ' + val['H'] + ':' + val['i'] + ':' + val['s'];
	var offset = val['Z']/3600;
	if(offset < 1) offset = ' -' + padZero(Math.abs(offset)) + '00';
	else offset = ' +' + padZero(Math.abs(offset)) + '00';
	if(offset != '+0000') val['r'] += offset;


	var newStr = '';
	for(var x=0; x<format.length; x++)
	{
		if(typeof(val[format.charAt(x)]) != 'undefined') newStr += val[format.charAt(x)];
		else newStr += format.charAt(x);
	}

	return newStr;
}
/*
	 @author  : Deepak Singh
	 @Purpose : used by getCurrentDate function
	 @param string value
	 @exception : returns false
*/
function padZero(value)
{
	if(value < 10) return '0' + value;
	return value;
}
/*
	 @author  : Deepak Singh
	 @Purpose : For checking valid file extension of picture/image/video/music
	 @param object pFileObject	(pFileObject object of input type=file)
	 @param boolean pblnIsRequired	(pblnIsRequired  true|false. true:if File field is require; else false. )
	 @exception : returns false
*/
function validateFile(pFileObject,pFileType,pblnIsRequired){
	try{
		//e.g. C:\Documents and Settings\sunainas\My Documents\My Pictures\cute baby 2.jpg
		var l_strFilePath = pFileObject.value;
		if(!(l_strFilePath==null || l_strFilePath==''))
		{
			//Retrieving the extension from provided file path
			var l_intStartIndex = l_strFilePath.lastIndexOf('.')+1;
			var l_intEndIndex = l_strFilePath.length;
			var l_strFileExtension = l_strFilePath.substr(l_intStartIndex,l_intEndIndex);

			//checking for valid file extensions of image files
			if(pFileType.toLowerCase()=='image' || pFileType.toLowerCase()=='picture'){
				 for(var i=0;i<validPictureFileExtensions.length;i++){
					if(l_strFileExtension.toLowerCase()==validPictureFileExtensions[i].toLowerCase()){
						return true;
					}
				}
			}
			//checking for valid file extensions of music files
			else if(pFileType.toLowerCase()=='music'){
				for(var i=0;i<validMusicFileExtensions.length;i++){
					if(l_strFileExtension.toLowerCase()==validMusicFileExtensions[i].toLowerCase()){
						return true;
					}
				}
			}
			//checking for valid file extensions of video files
			else if(pFileType.toLowerCase()=='video'){
				for(var i=0;i<validVideoFileExtensions.length;i++){
					if(l_strFileExtension.toLowerCase()==validMusicFileExtensions[i].toLowerCase()){
						return true;
					}
				}
			}
			//checking for valid file extensions of documnet files
			else if(pFileType.toLowerCase()=='document'){
				for(var i=0;i<validDocumentFileExtensions.length;i++){
					if(l_strFileExtension.toLowerCase()==validDocumentFileExtensions[i].toLowerCase()){
						return true;
					}
				}
			}
			else{
				alert("Please Provide Valid Media-Type(picture/image/music/video/document) to Check !");
			}
		}
		else
		{
			if(pblnIsRequired)
				alert("Please Specify File Path !");
			else
				return true;
		}
		return false;
	}catch(e){
		alertException("common.js|isValidateFile",e);
		return false;
	}
}
/*
	@author  : New Media Team
	@Purpose : Functions for loading,toggling images
	@exception : No Action
*/
function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}
function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}
/*
	@author  : Ankur jain
	@Purpose : Functions for opening a new page in the same window
	@Purpose : (usrl : URL for the page to openss)
*/
function fwdPage(url){
window.location.href(url);
}
/*
	@author  : Ananya Tripathy
	@Purpose : Functions for compairing two String
	 @param string value :

*/
function equalsIgnoreCase(string1,string2){
try{
		var lStr1 = string1.toLowerCase();
		var lStr2 = string2.toLowerCase();
		if(lStr1==lStr2){
			return true;
		}else{
			return false;
		}
	}catch(e){
		alertException("common.js|equalsIgnoreCase",e);
		return false;
	}

}
/*
	@author : Deepak Singh
	@Purpose : To convert string to int
	@Param : string
	@return : int
*/
function getIntegerValue(p_strString){
	try{
		p_strString= ""+p_strString;
		if(isNaN(p_strString)){
			return 0;
		}else{
			return parseInt(p_strString);
		}
	}catch(e){
		alertException("common.js|getIntegerValue",e);
	}
}
/*
	@author : Deepak Singh
	@Purpose : To convert string to float
	@Param : string
	@return : float
*/
function getFloatValue(p_strString){
	try{
		if(isNaN(p_strString)){
			return 0.00;
		}else{
			return parseFloat(p_strString);
		}
	}catch(e){
		alertException("common.js|getFloatValue",e);
	}
}
/*
	@author : Garima Agarwal
	@Purpose : To get days differenes between two days.
	@Param : Date
	@Param : Date
	@return : float
*/
function days_between(paramDateOne, paramDateTwo) {
	try{
	    // The number of milliseconds in one day
	    var ONE_DAY = 1000 * 60 * 60 * 24

	    // Convert both dates to milliseconds
	    var lDate1_ms = paramDateOne.getTime()
	    var lDate2_ms = paramDateTwo.getTime()

	    // Calculate the difference in milliseconds
	    var lintDifference_ms = Math.abs(lDate1_ms - lDate2_ms)

	    // Convert back to days and return
	    return Math.round(lintDifference_ms/ONE_DAY)
	}catch(e){
		alertException("common.js|days_between",e);
	}
}
/*
	@author : Garima Agarwal
	@Purpose : Used when processing is not complete on the jsp page.
	@Param : String (p_divProcess: contains div ID where processing text will appear)
	@Param : String (p_divAppText: contains div ID where jsp related text will appear)
	@Param : String (p_objForm: contains form object. The elements of form will disabled when processign is going on. In case there is no form object defined, pass "")
*/
function doProcessing(p_divProcess, p_divAppText, p_objForm){
	try{
		//set m_blnIsProcessing as false.
		m_blnIsProcessing = true;
		document.getElementById(p_divProcess).innerHTML="<table><tr><td width='5%'>&nbsp;</td><td width='20%'><img src='resources/images/processing.gif'/></td><td class='txt_adminblue' valign='center'><font size='3'><b>    &nbsp;&nbsp;Processing.......</b></font></td></tr></table>";
		document.getElementById(p_divProcess).style.display="block";
		document.getElementById(p_divAppText).style.display="none";
		if(p_objForm!=""){
			for(var i=0; i<p_objForm.elements.length; i++){
				p_objForm.elements[i].disabled = true;
			}
		}
	}catch(e){
		alertException("common.js|doProcessing",e);
	}
}
/*
	@author : Garima Agarwal
	@Purpose : Used when processing is completed on the jsp page.
	@Param : String (p_divProcess: contains div ID where processing text will appear)
	@Param : String (p_divAppText: contains div ID where jsp related text will appear)
	@Param : String (p_objForm: contains form object. The elements of form will enabled when processign is completed. In case there is no form object defined, pass "")
*/
function endProcessing(p_divProcess, p_divAppText, p_objForm){
	try{
		document.getElementById(p_divProcess).innerHTML = "";
		document.getElementById(p_divProcess).style.display="none";
		document.getElementById(p_divAppText).style.display="block";
		if(p_objForm!=""){
			for(var i=0; i<p_objForm.elements.length; i++){
				p_objForm.elements[i].disabled = false;
			}

		}
		//set the m_blnIsProcessing as true
		m_blnIsProcessing = false;
	}catch(e){
		alertException("common.js|endProcessing",e);
	}
}
/*
	@author : Garima Agarwal
	@Purpose : return the m_blnIsProcessing, and give alert if Processing is not complete.
	@return : boolean (m_blnIsProcessing: )
*/
function isProcessing(){
	try{
		if(m_blnIsProcessing){
			alert("Processing is going on. Please wait!!");
		}
		return m_blnIsProcessing;
	}catch(e){
		alertException("common.js|isProcessing",e);
	}
}
/*
* Deepak Singh the Great
*/
function breakString(p_str,p_intLenghToCut,p_strArrayOrHtml){
	try{
		var brokenStrArray = new Array();
		var counter=0;
		var html="";
		var l_intCurrentPos = 0;
		while(l_intCurrentPos<p_str.length){
			if((l_intCurrentPos+p_intLenghToCut)<p_str.length){
					if(p_strArrayOrHtml=='Array'){
						brokenStrArray[counter++]=p_str.substring(l_intCurrentPos,(l_intCurrentPos+p_intLenghToCut));
					}
					if(p_strArrayOrHtml=='HTML'){
						html+=p_str.substring(l_intCurrentPos,(l_intCurrentPos+p_intLenghToCut))+"<BR>";
					}
			}else{
					if(p_strArrayOrHtml=='Array'){
						brokenStrArray[counter++]=p_str.substring(l_intCurrentPos,(l_intCurrentPos+p_intLenghToCut));
					}
					if(p_strArrayOrHtml=='HTML'){
						html+=p_str.substring(l_intCurrentPos,(l_intCurrentPos+p_intLenghToCut));
					}
			}
			l_intCurrentPos += p_intLenghToCut ;
		}
		if(p_strArrayOrHtml=='Array')
			return brokenStrArray;
		if(p_strArrayOrHtml=='HTML')
			return html;
	}catch(e){
		alert("common.js|breakString",e);
	}
}
/*
	@author  : Annaya Tripathy
	@purpose : To set value to a month.
	@param string : Month
	@exception : No Action
*/
function getstrMonth(paramMonth)
{
	try{
		var lstrResult;
		switch(paramMonth){
			case "0": lstrResult="Jan";
						break
			case "1": lstrResult="Feb";
						break
			case "2": lstrResult="Mar";
						break
			case "3": lstrResult="Apr";
						break
			case "4": lstrResult="May";
						break
			case "5": lstrResult="Jun";
						break
			case "6": lstrResult="Jul";
						break
			case "7": lstrResult="Aug";
						break
			case "8": lstrResult="Sep";
						break
			case "9": lstrResult="Oct";
						break
			case "10": lstrResult="Nov";
						break
			case "11": lstrResult="Dec";
						break

		}
		return lstrResult;
	}catch(e){
		alertException("common.js|getstrMonth",e);
	}
}
/*
* Author : Deepak Singh
* Method to accepts only letters from 0-9
*/
function acceptIntegerOnly(paramObj,paramStrId){
   try{
		var l_DomObject = getObject(paramObj,paramStrId);
		if(l_DomObject!=null){
			var value = l_DomObject.value;
			value = value.trim();
			if(value=="0"){
				//do nothing
			}else if (value==""){
				l_DomObject.value="0";
			}else if(getIntegerValue(value)==0 || value.charAt(0)=='0'){
				alert('Invalid Integer Value');
				l_DomObject.value="0";
				l_DomObject.focus();
				return false;
			}else if(value<0){
				alert("Negative values are not allowed");
				l_DomObject.value="0";
				l_DomObject.focus();
			}
		}
	 return true;
	}catch(e){
		alertException("common.js|acceptIntegerOnly",e);
	}
}

function convertStrToDate(strDate){
	try{
		if(strDate.length==eval("10")){
			strDate = "0"+strDate;
		}
		var ldtDate = new Date(strDate.substr(7,4), getIntMonth(strDate.substr(3,3)), strDate.substr(0,2));
		return ldtDate;
	}catch(e){
		alert(e);
	}
}
function getDaysBetwDates(strDate1, strDate2){
	/*if(!validateDate(strDate1)) {
		alert("Invalid Format of the Date");
		return;
	}
	if(!validateDate(strDate2)) {
		alert("Invalid Format of the Date");
		return;
	}*/

	if(strDate1.length==eval("10"))
		strDate1 = "0"+strDate1;
	if(strDate2.length==eval("10"))
		strDate2 = "0"+strDate2;
	var ldtDate1 = new Date(strDate1.substr(7,4), getIntMonth(strDate1.substr(3,3)), strDate1.substr(0,2));
	var ldtDate2 = new Date(strDate2.substr(7,4), getIntMonth(strDate2.substr(3,3)), strDate2.substr(0,2));

	// The number of milliseconds in one day
    var ONE_DAY = 1000 * 60 * 60 * 24

    // Convert both dates to milliseconds
    var lDate1_ms = ldtDate1.getTime()
    var lDate2_ms = ldtDate2.getTime()

    // Calculate the difference in milliseconds
    var lintDifference_ms = Math.abs(lDate1_ms - lDate2_ms)

    // Convert back to days and return
    return Math.round(lintDifference_ms/ONE_DAY)

}
/*
 	@author  : Sunaina Sharma
 	@Purpose : Function to Compare Dates (Time is not considering).
 	@param string (strDate1 : string date value)
 	@param string (strDate2 : string date value)
 	@return : 0, if both Dates are equal.
			: 1, if strDate1 is greater than strDate2.
			:-1, if strDate1 is less than strDate2.
*/
function compareDates(strDate1, strDate2) {
	var LESS 	= -1;
	var GREATER =  1;
	var EQUAL 	=  0;

	/*if(!validateDate(strDate1)) {
		alert("Invalid Format of the Date");
		return;
	}
	if(!validateDate(strDate2)) {
		alert("Invalid Format of the Date");
		return;
	}*/

	if(strDate1.length==eval("10"))
		strDate1 = "0"+strDate1;
	if(strDate2.length==eval("10"))
		strDate2 = "0"+strDate2;
	var ldtDate1 = new Date(strDate1.substr(7,4), getIntMonth(strDate1.substr(3,3)), strDate1.substr(0,2));
	var ldtDate2 = new Date(strDate2.substr(7,4), getIntMonth(strDate2.substr(3,3)), strDate2.substr(0,2));

	var ldtDate1_date = ldtDate1.getDate();
	var ldtDate1_mnth = ldtDate1.getMonth();
	var ldtDate1_year = ldtDate1.getFullYear();

	var ldtDate2_date = ldtDate2.getDate();
	var ldtDate2_mnth = ldtDate2.getMonth();
	var ldtDate2_year = ldtDate2.getFullYear();

	if(ldtDate1_year > ldtDate2_year) {
		return GREATER;
	}
	else if(ldtDate1_year < ldtDate2_year) {
		return LESS;
	}
	else {
		if(ldtDate1_mnth > ldtDate2_mnth) {
			return GREATER;
		}
		else if(ldtDate1_mnth < ldtDate2_mnth) {
			return LESS;
		}
		else {
			if(ldtDate1_date > ldtDate2_date) {
				return GREATER;
			}
			else if(ldtDate1_date < ldtDate2_date) {
				return LESS;
			}
			else {
				return EQUAL;
			}
		}
	}
}

/*
 	@author  :Sunaina Sharma
 	@Purpose : Function to get month as integer(0 - 11) by passing month as string
 	@param string (p_strMonth : string month value)
 	@return : integer 0 for 'Jan'  |  1 for 'Feb' and so on
*/
function getIntMonth(p_strMonth) {
	var l_intMonth;
	switch(p_strMonth){
		case "Jan": l_intMonth=0
			break
		case "Feb": l_intMonth=1
			break
		case "Mar": l_intMonth=2
			break
		case "Apr": l_intMonth=3
			break
		case "May": l_intMonth=4
			break
		case "Jun": l_intMonth=5
			break
		case "Jul": l_intMonth=6
			break
		case "Aug": l_intMonth=7
			break
		case "Sep": l_intMonth=8
			break
		case "Oct": l_intMonth=9
			break
		case "Nov": l_intMonth=10
			break
		case "Dec": l_intMonth=11
			break
	}
	return l_intMonth;
}

/*
 	@author  : Sunaina Sharnma
 	@Purpose : Function to parse month string
 	@param string (p_strDate : string month value)
 	@return : true, if p_strDate is on format
				correct formats : 28-Feb-2007 | 8-Feb-2007
				incorrect formats : 28-feb-2007 | 11-Feb-2007
*/
function validateDate(p_strDate) {
	var pattern = /^([0-9]{1}([0-9]{1})?)-([A-Z]){1}([a-z]){2}-([0-9]{4})$/;
	if(!pattern.test(p_strDate))
		return false;
	else
		return true;
}
/*
*
* Deepak Singh
*
*/
function escapeStringChars(txt) {
	var retval=txt;
	retval = replaceAllString(retval,"\n","<BR>");
	retval = replaceAllString(retval,"\t","&nbsp;&nbsp;&nbsp;&nbsp;");
	//alert(retval);
	return retval;
}
/*
* Deepak Singh
*/
function toggleFormElementGroup( pGroupObject, booleanValue ) {
	if(pGroupObject!=null){
	    for( var i = 0; i < pGroupObject.length; i++ ) {
	        pGroupObject[i].disabled = booleanValue;
	    }
	}
}
/*
*	Author : Deepak Singh
*	Method Desc: Used to print HTML page for Printer Friendly Version
*/
function printPage(){
	try{
		var divElements = null;
		var divPropArray = new Array();
		divElements = document.all.tags("div");
		if(divElements!=null && divElements.length!="undefined" && divElements.length>0){
			var totalElements = divElements.length;
			for(var i = 0 ; i < totalElements ; i++){
				divPropArray[i]=divElements[i].style.overflow;
				divElements[i].style.overflow="visible";
			}
		}
		var textAreaElements = document.all.tags("textarea");
		var textAreaPropArray = new Array();
		if(textAreaElements!=null && textAreaElements.length!="undefined" && textAreaElements.length>0){
			var totalElements = textAreaElements.length;
			for(var i = 0 ; i < totalElements ; i++){
				textAreaPropArray[i]=textAreaElements[i].style.overflow;
				textAreaElements[i].style.overflow="visible";
			}
		}
		setPageMargings("19px auto");
		window.print();
		resetProperties(divElements,divPropArray);
		resetProperties(textAreaElements,textAreaPropArray);
		//window.location.reload();
		/*newwindow = window.open("a.html","popup","toolbar=no,status=no,scrollbars=1,resizable=1");
		newwindow.document.write(window.document.body.innerHTML);
		//newwindow.document.body.style.marginLeft = '0px';
		newwindow.document.body.style.marginRight = '1000px';
		//newwindow.document.body.style.marginTop = '0px';
		*/
	}catch(e){
		alertException("common.js|printPage" , e);
	}
}
function setPageMargings(pstrCommaSepMargin){
	try{
		document.body.style.margin=pstrCommaSepMargin;
	}catch(e){
		alertException("common.js|setPageMargings" , e);
	}
}
function resetProperties(pHtmlObject,pPropArray){
	try{
		if(pHtmlObject!=null && pPropArray!=null){
			var totalElements = pHtmlObject.length;
			var totalProps = pPropArray.length;
			for(var i = 0 ; i < totalElements && i < totalProps ; i++){
				pHtmlObject[i].style.overflow=pPropArray[i];
			}
		}
	}catch(e){
		alertException("common.js|resetProperties" , e);
	}
}