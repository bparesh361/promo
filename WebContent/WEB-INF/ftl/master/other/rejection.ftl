<html>
<head>
<#include "../../common/scripts.ftl">
<script type="text/javascript">
             jQuery(document).ready(function(){
               var varroleID;
                jQuery("#list4").jqGrid({
                    url:"getAllRejection.do?isApprover=0",
                    datatype: 'json',
                    width: 530,
                    height:210,
                    colNames:['Id','Reason Of Rejection','Status'],
                    colModel:[
                        {name:'rejectionid',index:'rejectionid', width:60, align:"center"},
                        {name:'rejectionname',index:'rejectionname', width:250, align:"center"}, 
                        {name:'status',index:'status', width:250, align:"center"}
                    ],
                    rowNum:10,
                    rowList:[10,20,30],
                    viewrecords: true,
                    pager: '#pglist4',
                    multiselect: false,
                    loadonce:true,
                    ignoreCase:true,
                    imgpath: "themes/basic/images",
                   // caption:'Reason Rejection for HO / Zonal Promo Team',
                    onSelectRow: function(rowid){                         
                        varroleID = rowid;
                        var rejectionid = $("#list4").getCell(rowid,"rejectionid");  
                        var rejectionname = $("#list4").getCell(rowid,"rejectionname");                          
                        $("#rejectionname").val(rejectionname);
                        $("#txRejectionID").val(rejectionid);  
                        var isapprover = $("#isApprover").val();  
                        //alert(isapprover);
                        var status = $("#list4").getCell(rowid, 'status');    
                        var statusvalue="";
                        if(status=="Active"){
                            statusvalue = "0";
                        } else if(status=="Blocked"){
                            statusvalue = "1";
                        } else {
                            statusvalue="-1";
                        }          
                        
                        $("#selStatus").val(statusvalue);
                    }

                });
                $("#btnSubmit").click(function (){                                                          
                    var mktgname = $("#rejectionname").val();
                    mktgname=$.trim(mktgname);
                    var checkblank = isBlank(mktgname,"Rejection Name ");
                    if(checkblank[0]==false){
                        alert(checkblank[1]); 
                        return false;
                    }                                       
                    var checklengthresp = checkLength(mktgname,"Rejection Name ",50);
                    if(checklengthresp[0]==false){
                        alert(checklengthresp[1]);
                        return false;
                    }
                    var status=$("#selStatus").val();
                    if(status==-1){
                        alert("Please select Status.");
                        return false;
                    }
                });
                $("#btnReset").click(function (data){
                    idRole="";
                    $("#rejectionname").val("");
                    $("#txRejectionID").val("");    
                    $("#selStatus").val("-1");
                    $("#msg").html('');
                    jQuery("#list4").jqGrid('setGridParam',{url:'"getAllRejection?isApprover=0"',datatype:'json',page:1}).trigger("reloadGrid");

                });
                
                jQuery("#list5").jqGrid({
                    url:"getAllRejection.do?isApprover=1",
                    datatype: 'json',
                    width: 530,
                    height:210,
                    colNames:['Id','Reason Of Rejection','Status'],
                    colModel:[
                        {name:'rejectionid1',index:'rejectionid1', width:60, align:"center"},
                        {name:'rejectionname1',index:'rejectionname1', width:250, align:"center"}, 
                        {name:'status1',index:'status1', width:250, align:"center"}
                    ],
                    rowNum:10,
                    rowList:[10,20,30],
                    viewrecords: true,
                    pager: '#pglist5',
                    multiselect: false,
                    loadonce:true,
                    ignoreCase:true,
                    imgpath: "themes/basic/images",
                    //caption:'Reason Rejection for Approver',
                    onSelectRow: function(rowid){                         
                        varroleID = rowid;
                        var rejectionid = $("#list5").getCell(rowid,"rejectionid1");  
                        var rejectionname = $("#list5").getCell(rowid,"rejectionname1");                          
                        $("#rejectionname1").val(rejectionname);
                        $("#txRejectionID1").val(rejectionid);  
                        var isapprover = $("#isApprover").val();  
                        //alert(isapprover);
                        var status = $("#list5").getCell(rowid, 'status1');    
                        var statusvalue="";
                        if(status=="Active"){
                            statusvalue = "0";
                        } else if(status=="Blocked"){
                            statusvalue = "1";
                        } else {
                            statusvalue="-1";
                        }          
                        
                        $("#selStatus1").val(statusvalue);
                    }

                });
                $("#btnSubmit1").click(function (){                                                          
                    var mktgname = $("#rejectionname1").val();
                    mktgname=$.trim(mktgname);
                    var checkblank = isBlank(mktgname,"Rejection Name ");
                    if(checkblank[0]==false){
                        alert(checkblank[1]); 
                        return false;
                    }                                       
                    var checklengthresp = checkLength(mktgname,"Rejection Name ",50);
                    if(checklengthresp[0]==false){
                        alert(checklengthresp[1]);
                        return false;
                    }
                    var status=$("#selStatus1").val();
                    if(status==-1){
                        alert("Please select Status.");
                        return false;
                    }
                });
                $("#btnReset1").click(function (data){
                    idRole="";
                    $("#rejectionname1").val("");
                    $("#txRejectionID1").val("");    
                    $("#selStatus1").val("-1");
                    $("#msg").html('');
                    jQuery("#list5").jqGrid('setGridParam',{url:'getAllRejection?isApprover=1',datatype:'json',page:1}).trigger("reloadGrid");

                });
            });
        </script>

</head>
<body>
	<#include "../../common/menu.ftl">
	 <table width="100%" border="0" cellspacing="0" cellpadding="0" align="center" >
             <tr><td class="errorText" align="right">(Fields marked with a * are mandatory.)</td></tr>
            <tr>
                <td>
                    <table  width="100%">
                        <tr><td height="5px"></td></tr>
                        
                        <tr><td align="center" colspan="2"><h1>Reason for Rejection</h1></td></tr>
                        <tr align="center">
                            <td colspan="2" align="center">
                                <div id="msg" >                                   
                                        <#if msg??>${msg}</#if>                                  
                                </div>
                            </td>
                        </tr>
                        <tr><td style="height:5px"></td></tr>
                        <tr>
                            <td width="50%">
                                <table align="center" >
                                    <form action="submitReasonHO.do">
                                        <tr><td><h1>Reason Rejection for HO / Zonal Promo Team</h1></td></tr>
                                        <tr>
                                            <td  align="center" colspan="2" >
                                                <table id="list4"></table>
                                                <div id="pglist4"></div>
                                            </td>
                                        </tr>

                                        <tr><td style="height:10px" ></td></tr>
                                        <tr>
                                            <td>
                                                <table align="center">
                                                    <tr>
                                                        <td>
                                                            Rejection Name :<span class="errorText">&nbsp;*</span>

                                                        </td>
                                                        <td>
                                                            <input type="text" id="rejectionname" name="rejectionname" size="40" />
                                                        </td>

                                                    </tr>
                                                    <tr>
                                                        <td>
                                                            Status:<span class="errorText">&nbsp;*</span></td>
                                                        <td>
                                                            <select name="selStatus" id="selStatus" class="dropdown">
                                                                <OPTION value="-1">----- Select Status -----</OPTION>
                                                                <OPTION value="0">Active</OPTION>
                                                                <OPTION value="1">In-Active</OPTION>
                                                            </select>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td align="center">
                                                <table width="40%">
                                                    <tr>
                                                        <td align="center" >
                                                            <input type="submit"  id="btnSubmit" name="btnSubmit" value="Submit" class="btn" action="submitRejectionMaster"></s:submit>
                                                            <input type="hidden" id="txRejectionID" name="txRejectionID" />
                                                            <input type="hidden" id="isApprover" name="isApprover" value="0" />

                                                        </td>
                                                        <td align="left">
                                                            <input id="btnReset" name="btnReset" type="button" value="Clear"  class="btn"/>
                                                        </td>
                                                    </tr>
                                                </table>

                                            </td>
                                        </tr>
                                    </form>
                                </table>
                            </td>
                            <td width="50%">
                                <table align="center" >
                                    <form action="submitReason.do">
                                         <tr><td><h1>Reason Rejection for Approver</h1></td></tr>
                                        <tr>
                                            <td  align="center" colspan="2" >
                                                <table id="list5"></table>
                                                <div id="pglist5"></div>
                                            </td>
                                        </tr>
                                        <tr><td style="height:10px" ></td></tr>
                                        <tr>
                                            <td>
                                                <table align="center">
                                                    <tr>
                                                        <td>
                                                            Rejection Name :<span class="errorText">&nbsp;*</span>
                                                        </td>
                                                        <td>
                                                            <input type="text" id="rejectionname1" name="rejectionname1" size="40" />
                                                        </td>

                                                    </tr>
                                                    <tr>
                                                        <td>
                                                            Status:<span class="errorText">&nbsp;*</span></td>
                                                        <td>
                                                            <select name="selStatus1" id="selStatus1" class="dropdown">
                                                                <OPTION value="-1">----- Select Status -----</OPTION>
                                                                <OPTION value="0">Active</OPTION>
                                                                <OPTION value="1">In-Active</OPTION>
                                                            </select>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td align="center">
                                                <table width="40%">
                                                    <tr>
                                                        <td align="center" >
                                                            <input type="submit"  id="btnSubmit1" name="btnSubmit1" value="Submit" class="btn" action="submitRejectionMasterForApprover"></s:submit>
                                                            <input type="hidden" id="txRejectionID1" name="txRejectionID1" />
                                                            <input type="hidden" id="isApprover" name="isApprover" value="1" />

                                                        </td>
                                                        <td align="left">
                                                            <input id="btnReset1" name="btnReset1" type="button" value="Clear"  class="btn"/>
                                                        </td>
                                                    </tr>
                                                </table>

                                            </td>
                                        </tr>
                                    </form>
                                </table>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>

	</body>
	</html>