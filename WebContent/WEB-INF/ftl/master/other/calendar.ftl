<html>
<head>
<#include "../../common/scripts.ftl">
<script type="text/javascript">
            jQuery(document).ready(function(){
                $(function() {
                    $("#popup_container1").datepicker({
                        changeMonth: true,
                        changeYear: true,
                        dateFormat: 'yy-mm-dd',
                        //maxDate : '+0d',
                        yearRange: "-100"

                    });
                });

                jQuery("#list4").jqGrid({
                    url:"showCalendarData.do",
                    datatype: 'json',
                    width: 530,
                    height:210,
                    colNames:['Caledar Id','Calendar Date','Description'],
                    colModel:[
                        {name:'id',index:'id', width:60, align:"center",editable:true,hidden:true},
                        {name:'cdate',index:'cdate', width:250, align:"center"},
                        {name:'description',index:'description', width:250, align:"center",editable:true},
                    ],
                    rowNum:10,
                    rowList:[10,20,30],
                    viewrecords: true,
                    pager: '#pglist4',
                    multiselect: false,
                    loadonce:true,
                    ignoreCase:true,
                    imgpath: "themes/basic/images",                  
                    onSelectRow: function(rowid){
                        varroleID = rowid;
                        var calid = $("#list4").getCell(rowid, 'id');
                        var caldate = $("#list4").getCell(rowid, 'cdate');
                        var caldesc = $("#list4").getCell(rowid, 'description');
                        $("#txtid").val(calid);
                        $("#popup_container1").val(caldate);
                        $("#txtdescription").val(caldesc);
                    }
                })
                .navGrid('#pglist4',
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
                        $("#txtid").val('');
                        $("#popup_container1").val('');
                        $("#txtdescription").val('');
                        var dates = $("input[id$='popup_container1']");
                        dates.attr('value', '');
                        dates.each(function(){
                            $.datepicker._clearDate(this);
                        });
                        if(toDelete!=null){
                            if(maxRows>1){
                                $("#list4").jqGrid(
                                'delGridRow',
                                toDelete,
                                {
                                    url:'deleteCalander?selIdToDelete='+toDelete,
                                    reloadAfterSubmit:true
                                }
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
              
                $("#btnCalSubmit").click(function (){

                    var date=  $("#popup_container1").val();
                    var dsc=   $("#txtdescription").val();

                    if(date==''){
                        alert("Please select Date.");
                        return false;
                    }
                    if(dsc==''){
                        alert("Please Enter Description");
                        return false;
                    }

                    //                    alert(urlcal);
                    jQuery("#list4").jqGrid('setGridParam',{url:urlcal,datatype:'json',page:1}).trigger("reloadGrid");
                    return false;
                });

                $("#btnSubmit").click(function (){
                    var month=$("#selMonth option:selected").val();                    
                    //                    alert(month);
                    var year = $("#year").val();
                    //                    alert(year);                    
                    var urlcal='getAllCalendarByYearAndMonth.do';
                    if(month != -1){
                        if(year == ""){
                            alert("Please enter year");
                            return false;
                        }
                        urlcal = urlcal + '?year='+year+'&month='+month;
                    } else {
                        urlcal = urlcal + '?year='+year;
                    }                    
                    jQuery("#list4").jqGrid('setGridParam',{url:urlcal,datatype:'json',page:1}).trigger("reloadGrid");
                    return false;
                });
                $("#btnReset").click(function (){                   
                    $('#selStatus').val('-1');
                    $("#mktgName").val('');
                    $("#txMktgID").val('');
                    $("#msg").html('');
                    $("#year").val('');
                    $('#selMonth').val('-1');
                    $("#txtid").val('');
                    $("#popup_container1").val('');
                    $("#txtdescription").val('');

                    jQuery("#list4").jqGrid('setGridParam',{url:'getAllCalender',datatype:'json',page:1}).trigger("reloadGrid");
                });
            });

        </script>
</head>
<body>
	<#include "../../common/menu.ftl">
	<div id="middle_cont">
            <form action="searchCalendar.do" method="post">
                <table width="100%" border="0" cellspacing="0" cellpadding="0" align="center" >                   
                    <tr>
                        <td  colspan="2" align="center"><h1>Calendar</h1></td>
                    </tr>
                    <tr align="center">
                        <td colspan="2" >
                            <div id="msg" >
                                <s:actionmessage cssClass="successText"/>
                                <s:actionerror cssClass="errorText" />
                            </div>
                        </td>
                    </tr>
                    <tr><td height="10px"></td></tr>
                    <tr>
                        <td align="center" style="height:100px">
                            <table  width="100%">
                                <tr>
                                    <td>
                                        <table align="center">
                                            <tr>
                                                <td>Year :</td>
                                                <td><input type="text" id="year" name="year" size="40"/>  </td>
                                            </tr>
                                            <tr><td height="10px"></td></tr>
                                            <tr>
                                                <td>
                                                    Month:</td>
                                                <td>
                                                    <select name="selMonth" id="selMonth" class="dropdown">
                                                        <OPTION value="-1">----- Select Month -----</OPTION>
                                                        <OPTION value="1">Jan</OPTION>
                                                        <OPTION value="2">Feb</OPTION>
                                                        <OPTION value="3">March</OPTION>
                                                        <OPTION value="4">April</OPTION>
                                                        <OPTION value="5">May</OPTION>
                                                        <OPTION value="6">June</OPTION>
                                                        <OPTION value="7">July</OPTION>
                                                        <OPTION value="8">Aug</OPTION>
                                                        <OPTION value="9">Sept</OPTION>
                                                        <OPTION value="10">Oct</OPTION> 
                                                        <OPTION value="11">Nov</OPTION>
                                                        <OPTION value="12">Dec</OPTION>
                                                    </select>
                                                </td>
                                                <td></td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                                <tr><td style="height:10px"></td></tr>
                                <tr>
                                    <td>
                                        <table width="40%" align="center">
                                            <tr>
                                                <td align="center" >
                                                    <input type="submit"  id="btnSubmit" name="btnSubmit" value="Search" class="btn" />
                                                    <s:hidden id="txMktgID" name="txMktgID" />
                                                </td>
                                                <td align="left">
                                                    <input id="btnReset" name="btnReset" type="button" value="Clear"  class="btn"/>
                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                                <tr><td style="height:10px" ></td></tr>

                            </table>
                        </td>
                        <td style="height:100px">
                            <table align="center" width="100%">
                                <tr><td style="height:10px" ></td></tr>
                                <tr>
                                    <td>
                                        <table>
                                            <tr>
                                                <td>Date :<span class="errorText">&nbsp;*</span></td>
                                                <td>
                                                    <s:hidden id ="txtid" name="txtid" />
                                                    <input name="txtcdate" type="text" class="datef" id="popup_container1" readonly="readonly"/>

                                                </td>
                                                <td>Description: <span class="errorText">&nbsp;*</span></td>
                                                <td>
                                                    <s:textfield id ="txtdescription" name="txtdescription" maxLength="30" />
                                                </td>
                                                <td>
                                                    <s:submit id="btnCalSubmit" name="btnCalSubmit" value="Add/Edit"  cssClass="btn" action="submitCalendar" ></s:submit>
                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                                <tr><td style="height:3px" ></td></tr>
                                <tr>
                                    <td  align="center" >
                                        <table id="list4"></table>
                                        <div id="pglist4"></div>
                                    </td>
                                </tr>

                            </table>
                        </td>
                    </tr>
                </table>
            </form>
            <s:form action="submitCalendarFile" method="post" enctype="multipart/form-data">
                <table width="100%" border="0" cellspacing="0" cellpadding="0" align="center" >
                    <tr>
                        <td>
                            <table  width="100%">
                                <tr><td style="height:10px" ></td></tr>
                                <tr>
                                    <td>
                                        <table width="65%" align="center">
                                            <tr>
                                                <td>Upload Calendar File:</td>
                                                <td align="center">
                                                    <s:file id ="calendarFile" name="calendarFile" ></s:file>
                                                </td>
                                                <td align="right" >
                                                    <s:submit  id="btnSubmit" name="btnSubmit" value="Upload" cssClass="btn" ></s:submit>
                                                </td>
                                                <td align="center">
                                                    <s:submit id="downloadSampleCalendarFile" name="downloadSampleCalendarFile" value="Download Template"  cssClass="largebtn" action="downloadSampleCalendarFile" ></s:submit>
                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>

                    </tr>
                </table>
            </s:form>
        </div>

	</body>
	</html>