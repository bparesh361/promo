<html>
<head>
<#include "../common/scripts.ftl">
<script type="text/javascript">
            jQuery(document).ready(function(){
                var lastsel2;
                jQuery("#list4").jqGrid({
                    url:"getStatusForLeadTime.do",
                    datatype: 'json',
                    width: 530,
                    height:210,
                    colNames:['Status Id','Status','L1','L2','L5'],
                    colModel:[
                        {name:'id',index:'id', width:60, align:"center", hidden:true, editable:true},
                        {name:'status',index:'status', width:250, align:"center"},   
                        {name:'L1',index:'L1', width:250, align:"center", editable:true,edittype:'text',editoptions: { size:15 , maxlength: 12} ,editrules:{custom:true, custom_func:validateTAT }},   
                        {name:'L2',index:'L2', width:250, align:"center", editable:true,edittype:'text',editoptions: { size:15 , maxlength: 12},editrules:{custom:true, custom_func:validateTAT }},   
                        {name:'L5',index:'L5', width:250, align:"center", editable:true,edittype:'text',editoptions: { size:15 , maxlength: 12} ,editrules:{custom:true, custom_func:validateTAT }},   
                    ],
                    rowNum:10,
                    rowList:[10,20,30],
                    viewrecords: true,
                    pager: '#pglist4',
                    multiselect: false,
                    loadonce:true,
                    ignoreCase:true,
                    imgpath: "themes/basic/images",
                    //caption:'Escalation Lead Time Configuration',
                    editurl: "updateLeadTime.do",  
                    onSelectRow: function(id){                                     
                        if(id && id!==lastsel2){
                            jQuery('#list4').restoreRow(lastsel2);                            
                            lastsel2=id;
                        }
                        jQuery('#list4').editRow(id,true);
                    }                       
                });                               
                var regValidateDigit = /^(([1-8][0-9]?|9[0-8]?)\.\d+|[1-9][0-9]?)$/;
                function validateTAT(duration){                                           
                    if(duration.length==0){
                        return [false,'Value Can Not Be Blank.'];
                    }
                    if(duration.length>0){                        
                        if(!isNumeric(duration)){
                            return [false,'Value should be numeric !'];
                        }
                        if(!regValidateDigit.test(duration)){
                            return [false,'Value should not be negative and should not be greater than 99'];
                        }
                    }
                    if(duration.length>3){
                        return [false,'Max Value should be 999!'];
                    }
                    
                    return [true,''];
                }
                
                $("#btnSubmit").click(function (){                                       
                    var duration = $("#leadTimeValue").val();
                    duration=$.trim(duration);
                    var checkblank = isBlank(duration,"Duration");
                    if(checkblank[0]==false){
                        alert(checkblank[1]); 
                        return false;
                    }
                    if(duration.length>0){                        
                        if(!isNumeric(duration)){
                            alert('Value should be numeric!');
                            $("#msg").html('');
                            return false;
                        }                        
                    }
                    if(duration.length>3){
                        alert('Max Value should be 999!');
                        $("#msg").html('');
                        return false;
                    }
                                   
                
                });
                
                $.ajax({
                    url: "getLeadTimeForPromoSetUp.do",
                    cache:false,
                    global: false,
                    type: "POST",
                    dataType:"json",
                    contanttype: 'text/json',
                    async:false,
                    error:function(){
                        alert("Can not connect to server");
                    },
                    success: function(data){                                                
                        $("#leadTimeValue").val(data.leadTimeValue);
                    }                
                });
              
                $("#btnReset").click(function (data){
                    // $("#leadTimeValue").val("");
                    $("#msg").html('');
                    jQuery("#list4").jqGrid('setGridParam',{url:'getStatusForLeadTime',datatype:'json',page:1}).trigger("reloadGrid");                });
                
            });
        </script>

</head>
<body>
	<#include "../common/menu.ftl">
	<form action="updatePromoLeadTime.do" method="post">
            <table width="100%" border="0" cellspacing="0" cellpadding="0" align="center" >
                <tr>
                    <td>
                        <table  width="100%">
                            <tr><td height="10px"></td></tr>
                            <tr><td align="center"><h1>Escalation Lead Time Configuration</h1></td></tr>
                            <tr align="center">
                                <td colspan="2">
                                    <div id="msg" >
                                        <!-- messages -->
                                    </div>
                                </td>
                            </tr>
                            <tr><td style="height:10px"></td></tr>
                            <tr>
                                <td  align="center" colspan="2" >
                                    <table id="list4"></table>
                                    <div id="pglist4"></div>
                                </td>
                            </tr>
                            <tr><td style="height:10px" ></td></tr>                           
                            <tr>
                                <td align="center">
                                    <table align="center">
                                        <tr>
                                            <td>
                                                Lead time for Promo Setup :<span class="errorText">&nbsp;*</span>
                                            </td>
                                            <td>
                                                <input type="text" id="leadTimeValue" name="leadTimeValue"  />
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
                                                <input type="submit"  id="btnSubmit" name="btnSubmit" value="Submit" cssClass="btn" action="updateLeadTimeForPromoSetUp"></input>
                                            </td>
                                            <td align="left">
                                                <input type="reset" id="btnReset" name="btnReset" type="button" value="Clear"  class="btn"/>
                                            </td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                        </table>
            </table>
    </form>       
	</body>
	</html>