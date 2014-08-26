<html>
<head>
<#include "../common/scripts.ftl">
        <script type="text/javascript">

            jQuery(document).ready(function(){
            
            $("#btnF1Submit").click(function (){
                    if(idEmp.length==0){
                        alert("Please Select Employee!");
                        return false;
                    }                    
                    $('#sendEmpId').val(idEmp);                    
                    $('#sendProfileId').val("1");
                    var fileid=  document.getElementById("mchuserF1File").value;
                    // alert(fileid);
                    if(fileid==null ||fileid==""){
                        alert("Please select file to upload.");
                        return false;
                    }
                    var valid_extensions = /(.csv)$/i;
                    if(valid_extensions.test(fileid)){
                    } else{
                        alert('Invalid File! Please Upload CSV File Only');
                        return false;
                    }
                });
                
                $("#btnF2Submit").click(function (){
                    if(idEmp.length==0){
                        alert("Please Select Employee!");
                        return false;
                    }                    
                    $('#sendEmpId').val(idEmp);                    
                    $('#sendProfileId').val("2");
                    var fileid=  document.getElementById("mchuserF2File").value;
                    // alert(fileid);
                    if(fileid==null ||fileid==""){
                        alert("Please select file to upload.");
                        return false;
                    }
                    var valid_extensions = /(.csv)$/i;
                    if(valid_extensions.test(fileid)){
                    } else{
                        alert('Invalid File! Please Upload CSV File Only');
                        return false;
                    }
                });
                
                $("#btnF3Submit").click(function (){
                    if(idEmp.length==0){
                        alert("Please Select Employee!");
                        return false;
                    }                    
                    $('#sendEmpId').val(idEmp);                    
                    $('#sendProfileId').val("3");
                    var fileid=  document.getElementById("mchuserF3File").value;
                    // alert(fileid);
                    if(fileid==null ||fileid==""){
                        alert("Please select file to upload.");
                        return false;
                    }
                    var valid_extensions = /(.csv)$/i;
                    if(valid_extensions.test(fileid)){
                    } else{
                        alert('Invalid File! Please Upload CSV File Only');
                        return false;
                    }
                });
            
            $("#btnF1Download").click(function (){
                    //alert("F1");
                    if(idEmp.length==0){
                        alert("Please Select Employee!");
                        return false;
                    }
                    $('#sendEmpId').val(idEmp);
                    
                    document.location.href = "downloadMCHUser.do?sendEmpId="+idEmp+"&type=f1";
                });
                
                $("#btnF2Download").click(function (){
                    //alert("F1");
                    if(idEmp.length==0){
                        alert("Please Select Employee!");
                        return false;
                    }
                    $('#sendEmpId').val(idEmp);
                    
                    document.location.href = "downloadMCHUser.do?sendEmpId="+idEmp+"&type=f2";
                });
                
                $("#btnF3Download").click(function (){
                    //alert("F1");
                    if(idEmp.length==0){
                        alert("Please Select Employee!");
                        return false;
                    }
                    $('#sendEmpId').val(idEmp);
                    
                    document.location.href = "downloadMCHUser.do?sendEmpId="+idEmp+"&type=f3";
                });
            
            	$("#txtuserempName").autocomplete({
                    minLength : 1,
                    //delay:10,
                    //scrollHeight:100,
                    source : function(request, response) {
                        var temp=    $.ajax({
                            url : "getEmployeeForFlexBox.do?txtuserempName="+$("#txtuserempName").val() ,
                            dataType : "json",
                            type:"POST",
                            data : {name_startsWith : request.term},
                            success : function(data) {      
                             //alert(data.results);                            
                                response($.map(data.results,function(item) {
                                    return {id : item.id,label : item.name};
                               }));
                            }
                        });
                    }, select: function( event, ui ) {
                        idEmp = ui.item.id;
                    }
                });
            
                var idEmp;

                var redirectemp=$("#redEmpId").val();
                //                  $("#exisEmpTr").show();
                //                    $("#redirectEmpTr").hide();
 
                if(redirectemp.length>0){
                    idEmp=redirectemp;
 
                    //document.getElementById('exisEmpTr').style.display = 'none';
                    $("#redirectEmpTr").show();
                    document.getElementById('exisEmpTr').style.display = 'none';
                    //   $("#exisEmpTr").hide();
                }else{
                    idEmp="";
                    //                     $("#exisEmpTr").show();
                    //                    $("#redirectEmpTr").hide();
                }
               
                var getEmpProfileData;
                

                function getuserprofileInfo(idEmp){
                    $.ajax({
                        url: "getUserProfile?EmpID="+idEmp,
                        global: false,
                        type: "POST",
                        dataType:"json",
                        contanttype: 'text/json',
                        async:false,
                        error:function(){
                            alert("Can not connect to server");
                        },
                        success: function(data){
                            //alert("server data : "+data.rows.profileIdList);
                            getEmpProfileData= data.rows.profileIdList
                            setTabOptionByProfile(getEmpProfileData);
                        }
                    });
                }
                var activeTabName;
                function setTabOptionByProfile(profile){
                    $("#tab_1").attr("href", "#");
                    $("#tab_2").attr("href", "#");
                    $("#tab_3").attr("href", "#");
                    $("#btnF1Download").attr("disabled",false);
                    $("#btnF1Submit").attr("disabled",false);
                    //$("#tab_4").attr("href", "#");

                    if(profile.length>0){
                        for(var index=0;index<profile.length;index++)
                        {
                            //                            alert("Data :"+profile[index]);
                            if(profile[index]=="2" || profile[index]=="9"){
                                tabSwitch_2(1,3, 'tab_', 'content_');
                                $("#tab_1").attr("href", "javascript:tabSwitch_2(1,3,'tab_','content_');");
                                activeTabName="f1Tab";
                                //                                break;
                            }else if(profile[index]=="3"){
                                tabSwitch_2(2,3, 'tab_', 'content_');
                                $("#tab_2").attr("href", "javascript:tabSwitch_2(2,3,'tab_','content_');");
                                activeTabName="f2Tab";
                                //                                break;
                            }else if(profile[index]=="4"){
                                tabSwitch_2(3,3, 'tab_', 'content_');
                                $("#tab_3").attr("href", "javascript:tabSwitch_2(3,3,'tab_','content_');");
                                activeTabName="f3Tab";
                                //                                break;
                            }else if(profile[index]=="8"){
                                tabSwitch_2(1,3, 'tab_', 'content_');
                                $("#tab_1").attr("href", "javascript:tabSwitch_2(1,3,'tab_','content_');");
                                $("#tab_2").attr("href", "javascript:tabSwitch_2(2,3,'tab_','content_');");
                                $("#tab_3").attr("href", "javascript:tabSwitch_2(3,3,'tab_','content_');");
                                break;
                            }else{
                                tabSwitch_2(1,3, 'tab_', 'content_');
                                $("#tab_1").attr("href", "javascript:tabSwitch_2(1,3,'tab_','content_');");

                                $("#btnF1Download").attr("disabled",true);
                                $("#btnF1Submit").attr("disabled",true);
                            }
                            //                            if(profile[index]=="6"){
                            //                                tabSwitch_2(4,4, 'tab_', 'content_');
                            //                                $("#tab_4").attr("href", "javascript:tabSwitch_2(4,4,'tab_','content_');");
                            //                                activeTabName="f5Tab";
                            //                            }
                        }
                    }

                }
                
                $("#btnF5Download").click(function (){
                    //alert("F4");
                    if(idEmp.length==0){
                        alert("Please Select Employee!");
                        return false;
                    }
                    $('#sendEmpId').val(idEmp);
                    
                    downloadFile("downloadF5UserFile");
                });
                $("#btnDownloadUSerMC").click(function (){
                    $('#wait-animation').show();
                    document.location.href = "downloadUserMCHMappingFile";
                    $('#wait-animation').hide();
                });

                function downloadFile(urlAction){
                	alert(urlAction);
                   // $('#wait-animation').show();
                    document.location.href = urlAction+".do?sendEmpId="+idEmp;
                    //$('#wait-animation').hide();
                }
                
                $("#btnF2Submit").click(function (){
                    if(idEmp.length==0){
                        alert("Please Select Employee!");
                        return false;
                    }
                    $('#sendEmpId').val(idEmp);
                    $('#sendProfileId').val("3");

                    var fileid=  document.getElementById("mchuserF2File").value;
                    // alert(fileid);
                    if(fileid==null ||fileid==""){
                        alert("Please select file to upload.");
                        return false;
                    }
                    var valid_extensions = /(.csv)$/i;
                    if(valid_extensions.test(fileid)){
                    } else{
                        alert('Invalid File! Please Upload CSV File Only');
                        return false;
                    }
                });
                $("#btnF3Submit").click(function (){
                    if(idEmp.length==0){
                        alert("Please Select Employee!");
                        return false;
                    }
                    $('#sendEmpId').val(idEmp);
                    $('#sendProfileId').val("4");
                    var fileid=  document.getElementById("mchuserF3File").value;
                    // alert(fileid);
                    if(fileid==null ||fileid==""){
                        alert("Please select file to upload.");
                        return false;
                    }
                    var valid_extensions = /(.csv)$/i;
                    if(valid_extensions.test(fileid)){
                    } else{
                        alert('Invalid File! Please Upload CSV File Only');
                        return false;
                    }
                });
                $("#btnF5Submit").click(function (){
                    if(idEmp.length==0){
                        alert("Please Select Employee!");
                        return false;
                    }
                    $('#sendEmpId').val(idEmp);
                    $('#sendProfileId').val("6");
                    var fileid=  document.getElementById("mchuserF5File").value;
                    // alert(fileid);
                    if(fileid==null ||fileid==""){
                        alert("Please select file to upload.");
                        return false;
                    }
                    var valid_extensions = /(.csv)$/i;
                    if(valid_extensions.test(fileid)){
                    } else{
                        alert('Invalid File! Please Upload CSV File Only');
                        return false;
                    }
                });

                $("#btnReset").click(function (data){
                    $("#msg").html("");
                    $('#mapuser')[0].reset();
                    $('#sendEmpId').val('');
                    $("#sendProfileId").val('');
                    $('#redEmpName').val('');
                    $("#redEmpId").val('');
                    idEmp="";
                    $("#txtuserempName").val('');
                    tabSwitch_2(1,3, 'tab_', 'content_');
                    $("#tab_1").attr("href", "javascript:tabSwitch_2(1,3,'tab_','content_');");
                    $("#btnF1Download").attr("disabled",false);
                    $("#btnF1Submit").attr("disabled",false);
                });

            });
        </script>
    </head>
    <body>
<#include "../common/menu.ftl">

    <div id="middle_cont">
                <table width="100%" border="0" cellspacing="0" cellpadding="0"  align="center">
                    <tr>
                        <td align="center"><h1>User MC-Code Mapping</h1></td>
                    </tr>

                    <tr><td height="15px"></td></tr>
                    <tr align="center">
                        <td align="center">
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
                                <tr id="redirectEmpTr" style="display: none">
                                    <td align="center" > Employee Name
                                    </td>
                                </tr>
                                <tr align="center" id="exisEmpTr">
                                    <td>
                                        <table width="40%" border="0" align="center" cellpadding="2" cellspacing="4" >
                                            <tr>
                                                <td >Employee Name :<span class="errorText">&nbsp;*</span></td>
                                                <td align="left"><input type="text" size="42px" id="txtuserempName" class="flexdrop"/></td>
                                             </tr>
                                             
                                        </table>
                                    </td>

                                </tr>
                                <tr>
                                    <td align="center">
                                    <form action="uploadfile.do" method="post" enctype="multipart/form-data">
                                        <table width="74%" border="0" align="center" cellpadding="2" cellspacing="4" >
                                            <tr><td  style="height:20px"></td></tr>
                                            <input type="hidden" id="sendEmpId" name="sendEmpId" />
                                            <input type="hidden" id="sendProfileId" name="sendProfileId" />
                                            <tr>
                                                <td align="center">
                                                    <div id="tabMaster" class="tabbed_box">
                                                        <ul class="tabs">
                                                            <li><a href="javascript:tabSwitch_2(1,3,'tab_','content_');" id="tab_1" class="active">F1 - Initiator</a></li>
                                                            <li><a href="javascript:tabSwitch_2(2,3,'tab_','content_');" id="tab_2">F2 - Approver 1</a></li>
                                                            <li><a href="javascript:tabSwitch_2(3,3,'tab_','content_');" id="tab_3">F3 - Approver 2</a></li>
                                                            <!--                                                            <li><a href="javascript:tabSwitch_2(4,4,'tab_','content_');" id="tab_4">Profile - F5</a></li>-->

                                                        </ul>
                                                        <div id="content_1" class="content">
                                                        	
                                                            <table id="profile1" width="65%" >
                                                                <tr><td height="10px"></td>
                                                                <tr>
                                                                    <td align="left">
                                                                        Upload MCH-F1 File:
                                                                    </td>
                                                                    <td align="left">
                                                                        <input type="file" id ="mchuserF1File" name="filef1" ></s:file>
                                                                    </td>
                                                                    <td align="left" >  
                                                                        <input type="submit"  id="btnF1Submit" name="btnF1Submit" value="Upload" cssClass="btn"></s:submit>
                                                                    </td>
                                                                </tr>
                                                                <tr><td height="15px"></td>
                                                                </tr>
                                                                <tr>
                                                                    <td  colspan="2"align="right">                                                                        
                                                                        <input type="button" id="btnF1Download" name="btnF1Download" value=" Download F1 User MCH File" Class="largebtn"/>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                           
                                                        </div>

                                                        <div id="content_2" class="content">
                                                            <table id="profile2" class="proposalMenu"   width="65%" >
                                                                <tr><td height="10px"></td>
                                                                <tr>
                                                                    <td align="left">
                                                                        Upload MCH-F2 File:
                                                                    </td>
                                                                    <td align="left">
                                                                        <input type="file" id ="mchuserF2File" name="filef2" ></s:file>
                                                                    </td>
                                                                    <td align="left" >
                                                                        <input type="submit"  id="btnF2Submit" name="btnF2Submit" value="Upload" cssClass="btn" action="submitUserMCH" />
                                                                    </td>
                                                                </tr>
                                                                <tr><td height="15px"></td>
                                                                <tr>
                                                                    <td  colspan="2"align="right">                                                                        
                                                                        <input type="button" id="btnF2Download" name="btnF2Download" value=" Download F2 User MCH File" Class="largebtn"/>
                                                                    </td>
                                                                </tr>                                                               
                                                            </table>
                                                        </div>

                                                        <div id="content_3" class="content">
                                                            <table id="profile3" class="initateMenu"   width="65%" >
                                                                <tr><td height="10px"></td>
                                                                <tr>
                                                                    <td align="left">
                                                                        Upload MCH-F3 File:
                                                                    </td>
                                                                    <td align="left">
                                                                        <input type="file" id ="mchuserF3File" name="filef3" ></s:file>
                                                                    </td>
                                                                    <td align="left" >
                                                                        <input type="submit" id="btnF3Submit" name="btnF3Submit" value="Upload" cssClass="btn" action="submitUserMCH" ></s:submit>
                                                                    </td>
                                                                </tr>
                                                                <tr><td height="15px"></td>
                                                                <tr>
                                                                    <td  colspan="2"align="right">
                                                                        
                                                                        <input type="button" id="btnF3Download" name="btnF3Downlaod" value=" Download F3 User MCH File" Class="largebtn"/>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                	<td colspan="2" align="right>
                                                                		<#if msg??>${msg}</#if>
                                                                	</td>
                                                                </tr>
                                                            </table>
                                                        </div>
                                                        <div id="content_4" class="content" style="display: none">
                                                            <table id="profile4" class="approvalMenu"   width="65%" >
                                                                <tr><td height="10px"></td>
                                                                <tr>
                                                                    <td align="left">
                                                                        Upload MCH-F5 File:
                                                                    </td>
                                                                    <td align="left">
                                                                        <s:file id ="mchuserF5File" name="userMCHF5File" ></s:file>
                                                                    </td>
                                                                    <td align="left" >
                                                                        <s:submit  id="btnF5Submit" name="btnF5Submit" value="Upload" cssClass="btn" action="submitUserMCH" ></s:submit>
                                                                    </td>
                                                                </tr>
                                                                <tr><td height="15px"></td>
                                                                <tr>
                                                                    <td  colspan="2"align="right">
                                                                        <%--<s:submit id="btnF5Download" name="btnF4Downlaod" value=" Download F4 User MCH File" cssClass="largebtn" action="downloadF4UserFile" ></s:submit>--%>
                                                                        <input type="button" id="btnF5Download" name="btnF5Download" value=" Download F5 User MCH File" Class="largebtn"/>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </div>
                                                    </div>
                                                </td>
                                                 </form>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <table width="20%" align="center">
                                            <tr>
                                                <td align="center">
                                                    <input id="btnReset" name="btnReset" type="button" value="CLEAR"  class="btn"/>
                                                </td>
                                                <td align="center">
                                                    <input id="btnDownloadUSerMC" name ="btnDownloadUSerMC" type="button" value="Download User MCH" class="largebtn" />
                                                </td>
                                            </tr>
                                        </table>
                                    </td>

                                </tr>

                            </table>
                        </td>
                    </tr>
                </table>
            <table>
            	<tr>
                     <td colspan="2" align="right>
                     	<#if msg??>${msg}</#if>
                     </td>
                </tr>
            </table>
        </div>
    </body>
</html>
    