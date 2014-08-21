<html>
<head>
<#include "../common/scripts.ftl">

  <script type="text/javascript">
            jQuery(document).ready(function(){
                $("#tdErrorFile").hide();
                setUploadFormForFileValidationFailure();
                function setUploadFormForFileValidationFailure(){
                    var hdnFileError=$("#isuploaderror").val();

                    if(hdnFileError!=undefined && hdnFileError.length>0 && hdnFileError=="1"){

                        $("#tdErrorFile").show();
                    }

                }

                jQuery("#workflow").jqGrid({
                    url:"getAllMCH.do",
                    datatype: 'json',
                    width: 710,
                    height:260,
                    colNames:['Category','Sub Category', 'MC Code','MC Description', 'Location', 'locationid'],
                    colModel:[
                        {name:'category',index:'category', width:200, align:"center"},
                        {name:'subcat',index:'subcat', width:200, align:"center"},
                        {name:'mccode',index:'mccode', width:150, align:"center"},
                        {name:'mcdesc',index:'mcdesc', width:200, align:"center"},
                        {name:'location',index:'location', width:100, align:"center"},
                        {name:'lid',index:'lid', width:15, align:"center",hidden:true},
                       
                    ],
                    rowNum:10,
                    rowList:[10,20,30],
                    viewrecords: true,
                    pager: '#pgworkflow',
                    //multiselect: true,
                    loadonce:true,
                    ignoreCase:true,
                    imgpath: "themes/basic/images"
                    //caption:"Workflow Master"
                });
                
                $("#btnSubmit").click(function (){
                    var fileid=  document.getElementById("workflowFile").value;
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
                
                  $("#btnDownlaod").click(function (){
                 	$.ajax({
                    url: "downloadMCH.do",
                    cache:false,
                    global: false,
                    type: "GET",
                    dataType:"text",
                    contanttype: 'text/csv',
                    async:false,
                    error:function(){
                        alert("Can not connect to server");
                    },
                    success: function(data){                                               
                        
                    }                
                }); 
                 });


            });
        </script>

</head>
<body>
	<#include "../common/menu.ftl">
	<div id="middle_cont">

            <form id="searchemp" action="mchUpload.do" method="POST" enctype="multipart/form-data">                
                <table width="100%" border="0" cellspacing="0" cellpadding="0"  align="center">
                    <tr><td height="15px"></td>
                    </tr>
                    <tr>
                        <td align="center"><h1>MCH</h1></td>
                    </tr>                    
                    <tr><td height="15px"></td></tr>
                    <tr>
                        <td>
                            <table width="100%" border="0" align="center" cellpadding="2" cellspacing="4">
                                <tr>
                                    <td  align="center"  >
                                        <table id="workflow"></table>
                                        <div id="pgworkflow"></div>
                                    </td>

                                </tr>
                                <tr><td height="15px"></td>
                                </tr>
                                <tr>
                                    <td align="center">
                                        <table width="75%">
                                            <tr>
                                                <td>
                                                    Upload File :<span class="errorText">&nbsp;*</span>
                                                </td>
                                                <td align="center">
                                                    <input type="file" id ="workflowFile" name="file" ></input>                                                    
                                                </td>
                                                <td align="right" >
                                                    <input type="submit"  id="btnSubmit" name="btnSubmit" value="Upload" cssClass="btn" action="submitworkflow" ></input>
                                                </td>
                                                <td align="right">
                                                    <a href="downloadMCH.do">download</a><input type="button" id="btnDownlaod" value="download"></input>
                                                </td>
                                                <td align="center" id="tdErrorFile">
                                                    <s:a  href="%{formVo.errorfilePath}" class="downloadError" id="downloadErrorFile" > Error File </s:a>
                                                </td>                                                
                                            </tr>
                                            <tr>
                                            	<td align="center" colspan=4><#if msg??>${msg}</#if></td>
                                            </tr>
                                        </table>
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
