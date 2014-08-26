<html>
<head>
<#include "../common/scripts.ftl">

        <script type="text/javascript">
            jQuery(document).ready(function(){
            
             $.getJSON("showLocations.do", function(data){
             $('#locationSelect').append(
        					$('<option></option>').val('-1').html(" --- Select --- ")
    					);               		
  					$.each(data, function(index, text) {  						
    					$('#locationSelect').append(
        					$('<option></option>').val(index).html(text)
    					);
  					});
			  }); 
                
                //Preventing caching for ajax calls
                $.ajaxSetup({ cache: false });
            
                var varroleID;
                var idRole="";
                jQuery("#list4").jqGrid({
                    url:"getAllProfiles.do",
                    datatype: 'json',
                    width: 530,
                    height:210,
                    colNames:['profileID','Profile', 'Level Access'],
                    colModel:[
                        {name:'profileID',index:'profileID', width:200, align:"center",hidden:true},
                        {name:'profilename',index:'profilename', width:150, align:"center"},
                        {name:'levelaccess',index:'levelaccess', width:150, align:"center"}
                        
                    ],
                    // rowNum:10,
                    //  rowList:[10,20,30],
                    viewrecords: true,
                    //  pager: '#pglist4',
                    multiselect: true,
                    loadonce:true,
                    ignoreCase:true,
                    imgpath: "themes/basic/images",
                    //caption:"Profile and Role Mapping",
                    onSelectRow: function(rowid){
                        varroleID = rowid;
                    },gridComplete:function(){
                        $("#cb_"+$("#list4")[0].id).hide();
                    }
                });

                $("#txtuserRole").autocomplete({
                    minLength : 1,
                    source : function(request, response) {
                        var temp=    $.ajax({
                            url : "flexBoxRoles.do?flexRoleName="+$("#txtuserRole").val() ,
                            dataType : "json",
                            type:"POST",
                            data : {name_startsWith : request.term},
                            success : function(data) {
                                
                                response($.map(data.results,function(item) {
                                    return {id : item.id,label : item.name};

                                }));
                            }
                        });
                    }, select: function( event, ui ) {
                        idRole = ui.item.id;
                        $.ajax({
                            url: "getRoleLocationProfileDtl.do?SelidRole="+idRole,
                            global: false,
                            type: "POST",
                            dataType:"json",
                            contanttype: 'text/json',
                            async:false,
                            error:function(){
                                alert("Can not connect to server");
                            },
                            success: function(data){
                                //                                alert("server data : "+data.rows.profileIdList);
                                //                                alert("Location : "+ data.location);
                                //                                alert("server data length : "+data.rows.profileIdList.length);
                                $("#locationSelect").val(data.location);
                                var tableDataIds= jQuery('#list4').getDataIDs();
                                //                               alert("tab : "+tableDataIds);

                                if(data.rows.profileIdList.length>0){                                   
                                    if(data.rows.profileIdList[0]!="-1"){
                                        //alert("Data " + data.rows.profileIdList[0]);
                                        for(var index=1;index<=tableDataIds.length;index++)
                                        {
                                            var rowData = jQuery('#list4').getRowData(tableDataIds[index-1]);
                                            for(var i=0; i<data.rows.profileIdList.length ; i++){
                                                if(data.rows.profileIdList[i]==rowData.profileID){                                                  
                                                    jQuery('#list4').jqGrid('setSelection',index);
                                                }
                                            }
                                        }
                                    }  
                                }
                            }
                        });
                    }
                });

                $("#btnSubmit").click(function (){
                    if(idRole.length==0){
                        alert("Please Select Role Name!");
                        $("#txtuserRole").focus();
                        return false;
                    }
                    var location=$("#locationSelect").val();
                    if(location=="-1"){
                        alert("Please Select Location!");
                        return false;
                    }
                    var id = $('#list4').jqGrid('getGridParam','selarrrow');
                    if(id.length==0){
                        alert("Please Select Profile for selected Role!");
                        return false;
                    }
                    $("#SelectedIDs").val(id);
                    $("#txtroleID").val(idRole);
                    
                });

                $("#btnReset").click(function (data){
                    idRole="";
                    $("#SelectedIDs").val("");
                    $("#msg").html('');
                    $("#txtuserRole").val("");
                    $("#txtroleID").val("");
                    $("#locationSel").val("-1");
                    jQuery("#list4").jqGrid('setGridParam',{url:'getAllProfiles',datatype:'json',page:1}).trigger("reloadGrid");

                });
            });
        </script>
</head>
        
<body>
			<#include "../common/menu.ftl">
	 <form action="createUpdateProfile.do" method="post">
            <table width="100%" align="center" >
                
                <tr>
                    <td>
                        <table  width="100%">
                            <tr><td align="center"><h1>Role & Profile Mapping</h1></td></tr>
                             <tr><td style="height:5px"></td></tr>
                            <tr align="center">
                                <td>
                                    <div id="msg" >
                                        <#if msg??>${msg}</#if>
                                    </div>
                                </td>
                            </tr>
                            <tr><td style="height:5px"></td></tr>
                            <tr>
                                <td>
                                    <table align="center">
                                        <tr>
                                            <td>
                                                Role Name:<span class="errorText">&nbsp;*</span>
                                            </td>
                                            <td>
                                                <input type="text" id="txtuserRole" name="txtuserRole" size="40" />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                Location:<span class="errorText">&nbsp;*</span>
                                            </td>
                                            <td>
                                                <select id="locationSelect" name="locationSelect"></select>
                                            </td>
                                        </tr>

                                    </table>
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
                                <td align="center">
                                    <table width="40%">
                                        <tr>
                                            <td align="right" >
                                                <input type="submit"  id="btnSubmit" name="btnSubmit" value="Submit" cssClass="btn" action="submitrolemapping" />
                                                <input type="hidden" id="txtroleID" name="txtroleID" />
                                                <input type="hidden" name="SelectedIDs" id="SelectedIDs"/>
                                            </td>
                                            <td align="left">
                                                <input id="btnReset" name="btnReset" type="button" value="Clear"  class="btn"/>
                                            </td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
        </form>
	
</body>
</html>