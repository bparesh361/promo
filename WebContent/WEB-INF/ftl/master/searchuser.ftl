<html>
<head>
<#include "../common/scripts.ftl">
<script type="text/javascript">
            jQuery(document).ready(function(){

                var idEmp="";
                $("#txtuserempName").autocomplete({
                    minLength : 1,
                    delay:10,
                    scrollHeight:100,
                    source : function(request, response) {
                        var temp=    $.ajax({
                            url : "getEmployeeForFlexBox.do?txtuserempName="+$("#txtuserempName").val() ,
                            dataType : "json",
                            type:"POST",
                            data : {name_startsWith : request.term},
                            success : function(data) {                                   // alert(data);
                                response($.map(data.results,function(item) {
                                    return {id : item.id,label : item.name};

                                }));
                            }
                        });
                    }, select: function( event, ui ) {
                        idEmp = ui.item.id;
                    }
                });
                
                 $.getJSON("showRoles.do", function(data){      
                     $('#rolesel').append(
        					$('<option></option>').val(-1).html('---Select---')
    					);     		   			            		
  					$.each(data, function(index, text) {  						
    					$('#rolesel').append(
        					$('<option></option>').val(index).html(text)
    					);
  					});
			  }); 
			  
			  $.getJSON("showLocations.do", function(data){ 
			  $('#locationsel').append(
        					$('<option></option>').val(-1).html('---Select---')
    					);	               		   			            		
  					$.each(data, function(index, text) {  						
    					$('#locationsel').append(
        					$('<option></option>').val(index).html(text)
    					);
  					});
			  }); 
			  
			  $.getJSON("showZones.do", function(data){               	
			  		$('#zonesel').append(
        					$('<option></option>').val(-1).html('---Select---')
    					);	            		
  					$.each(data, function(index, text) {  						
    					$('#zonesel').append(
        					$('<option></option>').val(index).html(text)
    					);
  					});
			  }); 


                var idStore="";
                $("#txtsitecode").autocomplete({
                    minLength : 1,
                    delay:10,
                    scrollHeight:100,
                    source : function(request, response) {
                        var temp=    $.ajax({
                            url : "getStoresForFlexbox.do?txtsitecode="+$("#txtsitecode").val() ,
                            dataType : "json",
                            type:"POST",
                            data : {name_startsWith : request.term},
                            success : function(data) {                                   // alert(data);
                                response($.map(data.results,function(item) {
                                    return {id : item.id,label : item.name};

                                }));
                            }
                        });
                    }, select: function( event, ui ) {
                        idStore = ui.item.id;
                    }
                });

                jQuery("#empGrid").jqGrid({
                    url:"getAllEmpSearch",                  
                    datatype: 'json',
                    width: 1300,
                    height:230,
                    colNames:['empId','Emp Code', 'Emp Name','Format', 'Contact No', 'Email Id','Site Code','City','Region', 'Zone','Location', 'Department','Reporting Manager','Task Manager','Role','Status','F1','F2','F3','F4'],
                    colModel:[
                        {name:'empId',index:'empId', width:10, align:"center",hidden:true},
                        {name:'empcode',index:'empcode', width:100, align:"center"},
                        {name:'empName',index:'empName', width:200, align:"center"},
                        {name:'format',index:'format', width:100, align:"center"},
                        {name:'number',index:'number', width:100, align:"center"},
                        {name:'emailId',index:'emailId', width:150, align:"center"},
                        {name:'sitecode',index:'sitecode', width:100, align:"center"},
                        {name:'city',index:'city', width:100, align:"center"},
                        {name:'region',index:'region', width:100, align:"center"},
                        {name:'zone',index:'zone', width:100, align:"center"},
                        {name:'location',index:'location', width:100, align:"center"},
                        {name:'dept',index:'dept', width:200, align:"center"},
                        {name:'repmanager',index:'repmanager', width:150, align:"center"},
                        {name:'taskmag',index:'taskmag', width:150, align:"center"},
                        {name:'role',index:'role', width:150, align:"center"},
                        {name:'ustatus',index:'ustatus', width:150, align:"center"},
                        {name:'F1',index:'F1', width:80, align:"center",hidden:true},
                        {name:'F2',index:'F2', width:80, align:"center",hidden:true},
                        {name:'F3',index:'F3', width:80, align:"center",hidden:true},
                        {name:'F4',index:'F4', width:80, align:"center",hidden:true},
                    ],
                     rowNum:30,
                    rowList:[30],
                    viewrecords: true,
                    pager: '#pgempGrid',
                    // multiselect: true,
                    // loadonce:true,
                    ignoreCase:true,
                    imgpath: "themes/basic/images"
                    //caption:"Employee Detail"
                 

                }).navGrid('#pgempGrid',
                {add:false, edit:false, del:false, search:false, refresh: false},
                {width:"auto"},// Default for Add
                {width:"auto"},// Default for edit
                {width:"auto"}// Default for Delete
            ).navButtonAdd(
                '#pgempGrid',
                {
                    caption:"DELETE",
                    buttonicon:"ui-icon-add",
                    onClickButton: function(){
                        var toDelete = $("#empGrid").jqGrid('getGridParam','selrow');
                        //alert("Selected Row :"+toDelete);
                        var maxRows=jQuery("#empGrid tr").length;
                        //alert(maxRows);
                        if(toDelete!=null){
                            if(maxRows>1){
                                $("#empGrid").jqGrid(
                                'delGridRow',
                                toDelete,
                                {url:'deleteEmployee?selIdToDelete='+toDelete,reloadAfterSubmit:true}
                            );
                                return true;
                            }
                        }else{
                            alert("Please, Select a Row");
                            return false;
                        }
                    }
                }
            );

                $("#zonesel").attr("disabled", true);
                $("#locationsel").attr("disabled", true);
                $("#txtuserempName").attr("disabled", true);
                $("#txtsitecode").attr("disabled", true);
                $("#roleSel").attr("disabled", true);

                $("#selSearch").change(function(){
                    var seltype=$("#selSearch option:selected").val();
                    if(seltype !=-1){
                        if(seltype=="0"){
                            $("#zonesel").attr("disabled", false);
                            $("#locationsel").attr("disabled", true);
                            $("#txtuserempName").attr("disabled", true);
                            $("#txtsitecode").attr("disabled", true);
                            $("#rolesel").attr("disabled", true);
                            $("#locationsel").val("-1");
                            $("#txtuserempName").val("");
                            $("#txtsitecode").val("");
                            idStore="";
                            idEmp="";
                            
                        }else if(seltype=="1"){
                            $("#txtuserempName").attr("disabled", false);
                            $("#rolesel").attr("disabled", true);
                            $("#zonesel").attr("disabled", true);
                            $("#locationsel").attr("disabled", true);
                            $("#txtsitecode").attr("disabled", true);
                            $("#locationsel").val("-1");
                            $("#zonesel").val("-1");
                            $("#txtsitecode").val("");
                            idStore="";
                   
                        }else if(seltype=="2"){
                            $("#txtsitecode").attr("disabled", false);
                            $("#rolesel").attr("disabled", true);
                            $("#zonesel").attr("disabled", true);
                            $("#locationsel").attr("disabled", true);
                            $("#txtuserempName").attr("disabled", true);
                            $("#locationsel").val("-1");
                            $("#txtuserempName").val("");
                            $("#zonesel").val("-1");
                            idEmp="";

                        }else if(seltype=="3"){
                            idStore="";
                            idEmp="";
                            $("#locationsel").attr("disabled", false);
                            $("#rolesel").attr("disabled", true);
                            $("#zonesel").attr("disabled", true);
                            $("#txtuserempName").attr("disabled", true);
                            $("#txtsitecode").attr("disabled", true);
                            $("#zonesel").val("-1");
                            $("#txtuserempName").val("");
                            $("#txtsitecode").val("");
                        }else if(seltype=="4"){
                            idStore="";
                            idEmp="";
                            $("#locationsel").attr("disabled", true);
                            $("#rolesel").attr("disabled", false);
                            $("#zonesel").attr("disabled", true);
                            $("#txtuserempName").attr("disabled", true);
                            $("#txtsitecode").attr("disabled", true);
                            $("#zonesel").val("-1");
                            $("#txtuserempName").val("");
                            $("#txtsitecode").val("");
                        }                      
                    }else{
                        alert("Please Select Search Type!");
                        $("#zonesel").attr("disabled", true);
                         $("#rolesel").attr("disabled", true);
                        $("#locationsel").attr("disabled", true);
                        $("#txtuserempName").attr("disabled", true);
                        $("#txtsitecode").attr("disabled", true);
                        $("#zonesel").val("-1");
                        $("#locationsel").val("-1");
                        $("#txtuserempName").val("");
                        $("#txtsitecode").val("");
                        return false;
                    }
                });
                $("#btnView").click(function (){
                    var seltype=$('#selSearch').val();
                    if(seltype=="-1"){
                        alert("Please Select Search Type!");
                        return false;
                    }
                    var zone =$('#zonesel').val();
                    var location =$('#locationsel').val();
                     var role =$('#rolesel').val();
                    if(seltype=="0"){
                        if(zone=="-1"){
                            alert("Please Select Zone!");
                            return false;
                        }
                    }
                    if(seltype=="1"){
                        if(idEmp.length==0){
                            alert("Please select Employee !");
                            return false;
                        }
                    }
                    if(seltype=="2"){
                        if(idStore.length==0){
                            alert("Please select Store !");
                            return false;
                        }
                    }
                    if(seltype=="3"){
                        if(location=="-1"){
                            alert("Please Select Location!");
                            return false;
                        }
                    }
                    if(seltype=="4"){
                        if(role=="-1"){
                            alert("Please Select Role!");
                            return false;
                        }
                    }

                    jQuery("#empGrid").jqGrid('setGridParam',{url:"getEmpSearchBy.do?idStore="+idStore+"&idEmp="+idEmp+"&idZone="+zone+"&idLocation="+location+"&idRole="+role,datatype:'json',page:1}).trigger("reloadGrid");
                });

                $("#btnReset").click(function (data){
                    idStore="";
                    idEmp="";
                    $("#msg").html("");
                    $('#selSearch').val('-1');
                    $('#zonesel').val('-1');
                     $('#roleSel').val('-1');
                    $('#locationsel').val('-1');
                    $("#txtuserempName").val('');
                    $("#txtsitecode").val('');

                    $("#zonesel").attr("disabled", true);
                    $("#roleSel").attr("disabled", true);

                    $("#locationsel").attr("disabled", true);
                    $("#txtuserempName").attr("disabled", true);
                    $("#txtsitecode").attr("disabled", true);
                       
                    jQuery("#empGrid").jqGrid('setGridParam',{url:"getAllEmpSearch",datatype:'json',page:1}).trigger("reloadGrid");

                });
                //                $("#btndelet").click(function (data){
                //                    var id = $('#empGrid').jqGrid('getGridParam','selarrrow');
                //                    //alert(id);
                //                    if(id.length==0){
                //                        alert("Please Select Employee.");
                //                        return false;
                //                    }
                //                    $('#selIdToDelete').val(id);
                //                });

            });
        </script>




</head>

<body>

<#include "../common/menu.ftl">


 <table width="100%" border="0" cellspacing="0" cellpadding="0"  align="center">

            <tr align="center">
                <td>
                    <div id="msg" >
                        <s:actionmessage cssClass="successText"/>
                        <s:actionerror cssClass="errorText" />
                    </div>
                </td>
            </tr>
            <tr><td height="15px"></td></tr>
            <tr>
                <td>
                    <table width="100%" border="0" align="center" cellpadding="2" cellspacing="4">
                        <tr>
                            <td align="center">
                                <table width="50%" border="0" align="center" cellpadding="2" cellspacing="4" >
                                    <tr>
                                        <td></td>
                                        <td align="right">
                                            Search Type
                                        </td>
                                        <td align="left">
                                            <select name="selSearch" id="selSearch" class="dropdown">
                                                <OPTION value="-1">----- Select Search By -----</OPTION>
                                                <OPTION value="0">Zone</OPTION>
                                                <OPTION value="1">Employee Name</OPTION>
                                                <OPTION value="2">Site Code</OPTION>
                                                <OPTION value="3">Location</OPTION>
                                                <OPTION value="4">Role</OPTION>
                                            </select>
                                        </td><td></td>

                                    </tr>
                                    <tr>
                                        <td  align="right" id="scode">Zone</td>
                                        <td align="left"> <select name="zonesel" id="zonesel"  list="zoneMap" headerKey="-1" headerValue="---Select Zone---" value="---Select Zone---" cssClass="dropdown" /></td>
                                        <td  align="right" id="scode">Employee Name</td>
                                        <td align="left"><input type="text" size="42px" id="txtuserempName" /></td>
                                    </tr>
                                    <tr><td  align="right" id="scode">Location</td>
                                        <td align="left"> <select name="locationsel" id="locationsel"  list="locationMap" headerKey="-1" headerValue="---Select Location---" value="---Select Location---" cssClass="dropdown"/></td>

                                        <td  align="right" id="scode">Site Code</td>
                                        <td align="left"><input type="text" size="42px" id="txtsitecode" /></td>
                                    </tr>
                                    <tr>
                                        <td width="13%" align="right">Role</td>
                                        <td width="37%"><select name="rolesel" id="rolesel"  headerKey="-1" headerValue="---Select Role---" value="---Select Role---"  cssClass="dropdown"/></td>
                                        <td width="12%" align="right">&nbsp;</td>
                                        <td width="38%">&nbsp;</td>
                                    </tr>
                                    <tr>
                                        <td colspan="4" align="center">
                                            <input type="button" id="btnView" name="btnView" class="btn" value="View"/>
                                            <input type="submit" id="btnReset" name="btnReset" class="btn" value="Clear"/>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                        <tr>
                            <td align="left">
                                <table>
                                    <tr>
                                        <td ><h1>Employee Detail</h1></td>
                                        <td>
                                            <a href ="downloadEmployeeMasterdtl.do">
                                                Download Employee Details
                                            </a>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="4" align="center">
                                <table id="empGrid"></table>
                                <div id="pgempGrid"></div>
                            </td>
                        <tr>
                            <td  colspan="4" align="center">
                                <%--<s:submit action="deleteEmployee" id="btndelet" name="btndelet" cssClass="but_sub" value="Delete"/>--%>
                                <s:hidden id="selIdToDelete" name="selIdToDelete"/>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
</body>
</html>