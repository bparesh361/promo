<html>
<head>
<#include "../../common/scripts.ftl">
<script type="text/javascript">
jQuery(document).ready(function(){

                //Preventing caching for ajax calls
                $.ajaxSetup({ cache: false });

                jQuery("#list4").jqGrid({
                    url:"getAllUsersForStorePRndingProposal.do",
                    datatype: 'json',
                    width: 500,
                    height:280,
                    colNames:['S.No','Email IDs','Zone','Zone ID'],
                    colModel:[
                        {name:'sno',index:'sno', width:50, align:"center"},
                        {name:'emailId',index:'emailId', width:200, align:"center"},
                        {name:'zone',index:'zone', width:100, align:"center"},
                        {name:'zoneId',index:'zoneID', width:150, align:"center",hidden:true}
                    ],
                    rowNum:15,
                    rowList:[10,20,30],
                    viewrecords: true,
                    pager: '#pglist4',
                    multiselect: false,
                    loadonce:true,
                    ignoreCase:true,
                    imgpath: "themes/basic/images"
                    
                }) .navGrid('#pglist4',
                {add:false, edit:false, del:false, search:false, refresh: false },
                {width:"auto"},// Default for Add
                {width:"auto"},// Default for edit
                {width:"auto"}// Default for Delete
            ).navButtonAdd(
                '#pglist4',
                {
                    caption:"DELETE",
                    buttonicon:"ui-icon-add",
                    onClickButton: function(){
                        var toDelete = $("#list4").jqGrid('getGridParam','selrow');
                        //alert("Selected Row :"+toDelete);
                        var maxRows=jQuery("#list4 tr").length;
                        //alert(maxRows);
                        $('#uploadFile')[0].reset();
                      
                        if(toDelete!=null){
                            if(maxRows>1){
                                $("#list4").jqGrid(
                                'delGridRow',
                                toDelete,
                                {
                                    url:'deleteUserPendingProposal?selIdToDelete='+toDelete,
                                    reloadAfterSubmit:true
                                }
                            );
                                $('#msg').html('');
                                return true;
                            }
                        }else{
                            alert("Please, Select a Row");
                            return false;
                        }
                    }
                }
            );
                $("#btnClear").click(function (){
                    $('#msg').html('');
                    $('#uploadFile')[0].reset();
                    jQuery("#list4").jqGrid('setGridParam',{url:"getAllUsersForStorePRndingProposal",datatype:'json',page:1}).trigger("reloadGrid");
                });
                $("#btnSearch").click(function (){
                    //email
                    var txtemail=$("#tbEmailId").val();
                    var zoneNames = Array();
                    var zoneIds = Array();
                    ;
                    var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;

                    var checkblanktxtemail = isBlank(txtemail,"Email Id ");
                    var checklengthtxtemail = checkLength(txtemail,"Email Id ",50);
                    if(checkblanktxtemail[0]==false){
                        alert(checkblanktxtemail[1]);
                        $("#txtemail").focus();
                        return false;
                    }else if(!emailReg.test(txtemail)) {
                        $("#txtemail").val("");
                        alert('Enter Valid Email ID!!');
                        return false;
                    }else if(checklengthtxtemail[0]==false){
                        $("#txtemail").focus();
                        alert(checklengthtxtemail[1]);
                        return false;
                    }
                    
                    $('#ZoneSelect option:selected').each(function(index){
                        //alert("Inside");
                        zoneNames[index] = $(this).text();
                        zoneIds[index] = $(this).val();
                    });
                    
                    //if(zoneIds.length==0){
                     //   alert("Please select Zone.");
                      //  return false;
                    //}
                    $("#hdzoneName").val(zoneNames);
                    $("#hdzoneIds").val(zoneIds);
                   
                });
                 
              $.getJSON("showZones.do?storeType=3", function(data){               		               			            		
  					$.each(data, function(index, text) {  						
    					$('#zoneSelect').append(
        					$('<option></option>').val(index).html(text)
    					);
  					});
			  }); 
                
                });
        </script>
    </head>
    <body>
  		<#include "../../common/menu.ftl">
   <div id="middle_cont">
            <form  action="createStoreProposalReport.do"  method="post" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0" align="center" >
                    <tr>
                        <td>
                            <table  width="100%">
                                <tr><td height="5px"></td></tr>
                                <tr>
                                    <td align="center"><h1>Store Proposal Pending Report</h1></td>
                                </tr>
                                <tr align="center">
                                    <td align="center" >
                                        <div id="msg" >
                                            <#if msg??>${msg}</#if>
                                        </div>
                                    </td>
                                </tr>
                                <tr><td style="height:5px"></td></tr>
                                <tr>
                                    <td align="center">
                                        <table width="40%" border="0" align="center" cellpadding="2" cellspacing="4">
                                            <tr>
                                                <td>
                                                    Email Id
                                                </td>
                                                <td align="left">
                                                    <input type="text" name="tbEmailId" id ="tbEmailId"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    Zone
                                                </td>
                                                <input type="hidden" name="hdzoneIds" id="hdzoneIds"/>
                                                <input type="hidden" name="hdzoneName" id="hdzoneName"/>
                                                <td align="left" ><div id="zoneSelectSection"><select id="zoneSelect" name="zoneSelect"><option value="-1"> --- Select --- </option></select></div></td>
                                            </tr>
                                            <tr id="searchTR" >
                                                <td colspan="8" align="center">
                                                    <table align="center" >
                                                        <tr>
                                                            <td align="center" >
                                                                <input type="submit"  type="button" name="btnSearch" id="btnSearch" value="Submit" class="btn" />
                                                            </td>
                                                            <td>
                                                                <input type="button" name="btnClear" id="btnClear" value="Clear" class="btn"/>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                                <tr><td style="height:5px"></td></tr>
                                <tr>
                                    <td  align="center"  >
                                        <table id="list4"></table>
                                        <div id="pglist4"></div>
                                    </td>
                                </tr>

                            </table>
                        </td>
                    </tr>
                </table>
            </s:form>
        </div>
    </body>
</html>
