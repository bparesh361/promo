<html>
<head>
<#include "../../common/scripts.ftl">
<script type="text/javascript">
            jQuery(document).ready(function(){
                $("#campaignName").val("");
                $("#txtCampID").val("");
                $("#isActive").val("-1");
              
                jQuery("#list4").jqGrid({
                    url:"showCampaignData.do",
                    datatype: 'json',
                    width: 530,
                    height:210,
                    colNames:['Id','Objective Name','Status'],
                    colModel:[
                        {name:'campid',index:'campid', width:60, align:"center"},
                        {name:'campname',index:'campname', width:250, align:"center"},
                        {name:'status',index:'status', width:250, align:"center"},
                    ],
                    rowNum:10,
                    rowList:[10,20,30],
                    viewrecords: true,
                    pager: '#pglist4',
                    multiselect: false,
                    loadonce:true,
                    ignoreCase:true,
                    imgpath: "themes/basic/images",
                    // caption:'Event Type Master',
                    onSelectRow: function(rowid){
                       
                        var id = $("#list4").getCell(rowid,"campid");
                        var name = $("#list4").getCell(rowid,"campname");
                        $("#campaignName").val(name);
                        $("#campaignId").val(id);
                        var status = $("#list4").getCell(rowid, 'status');
                        var statusvalue="";
                        if(status=="Active"){
                            statusvalue = "0";
                        } else if(status=="Blocked"){
                            statusvalue = "1";
                        } else {
                            statusvalue="-1";
                        }                        
                        $("#isActive").val(statusvalue);
                        var x = $("#dmsg").text();
                        //alert(x);
                        $('#dmsg').html('');
                    }
                });

                $("#btnSubmit").click(function (){
                    var mktgname = $("#campaignName").val();
                    mktgname=$.trim(mktgname);
                    var checkblank = isBlank(mktgname,"Objective Name ");
                    if(checkblank[0]==false){
                        alert(checkblank[1]);
                        $("#campaignName").focus();
                        return false;
                    }
                    var checklengthresp = checkLength(mktgname,"Objective Name ",50);
                    if(checklengthresp[0]==false){
                        alert(checklengthresp[1]);
                        return false;
                    }
                    var status=$("#isActive").val();
                    if(status==-1){
                        alert("Please select Status.");
                        return false;
                    }
                });

                $("#btnReset").click(function (data){                   
                    $("#campaignName").val("");
                    $("#campaignId").val("");
                    $("#isActive").val("-1");
                    $("#dmsg").html('');
                    jQuery("#list4").jqGrid('setGridParam',{url:'getAllCampaignDetail',datatype:'json',page:1}).trigger("reloadGrid");

                });

            });
        </script>
</head>
<body>
	<#include "../../common/menu.ftl">
	<form action="updateCampaign.do" >
            <table width="100%" border="0" cellspacing="0" cellpadding="0" align="center" >
                <tr>
                    <td>
                        <table  width="100%">
                            <tr><td height="5px"></td></tr>
                            <tr><td class="errorText" align="right">(Fields marked with a * are mandatory.)</td></tr>
                            <tr><td align="center"><h1>Objective</h1></td></tr>
                            <tr align="center">
                                <td colspan="2">
                                    <div id="msg" >
                                        <s:actionmessage cssClass="successText"/>
                                        <s:actionerror cssClass="errorText" />
                                    </div>
                                </td>
                            </tr>
                            <tr><td style="height:5px"></td></tr>
                            <tr>
                                <td  align="center" colspan="2" >
                                    <table id="list4"></table>
                                    <div id="pglist4"></div>
                                </td>
                            </tr>
                            <tr><td style="height:5px" ></td></tr>
                            <tr>
                                <td>
                                    <table align="center">
                                        <tr>
                                            <td>
                                                Objective:<span class="errorText">&nbsp;*</span>
                                            </td>
                                            <td>
                                                <input type="text" id="campaignName" name="campaignName" size="35" />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                Status:<span class="errorText">&nbsp;*</span></td>
                                            <td>
                                                <select name="isActive" id="isActive" class="dropdown">
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
                                    <table width="60%">
                                        <tr>
                                            <td align="right" >
                                                <input type="submit"  id="btnSubmit" name="btnSubmit" value="Submit" class="btn" />
                                                <input type="hidden" id="campaignId" name="campaignId" />
                                            </td>
                                            <td align="left">
                                                <input id="btnReset" name="btnReset" type="button" value="Clear"  class="btn"/>
                                            </td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                            <tr>
                            	<td align="center"><div id="dmsg" class="dmsg"><#if msg??>${msg}</#if></div></td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
        </form>
       
	</body>
	</html>