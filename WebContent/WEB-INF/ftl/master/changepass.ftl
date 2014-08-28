<html>
<head>
<#include "../common/scripts.ftl">
        <script type="text/javascript">

            jQuery(document).ready(function(){

                //Preventing caching for ajax calls
                $.ajaxSetup({ cache: false });

                $("#btnsubmit").click(function(){

                    if($("#oldPass").val().length ==0){
                        alert ("Please enter Current Password.") ;
                        $("#oldPass").focus();
                        return false ;
                    }
                    if($("#newPass").val()==""){
                        alert ("Please enter New Password.") ;
                        $("#newPass").focus();
                        return false ;
                    }
                    if($("#newPass").val()=="india123"){
                        alert ("New Password should not be system generated password.") ;
                        $("#newPass").val('');
                        $("#rePass").val('');
                        $("#newPass").focus();
                        return false ;
                    }
                    if($("#rePass").val() == "")
                    {
                        alert ("Confirm password should not be blank.") ;
                        $("#rePass").focus();
                        return false ;
                    }


                    if($("#rePass").val() != $("#newPass").val()){
                        alert ("Confirm Password must same as New Password.") ;
                        $("#rePass").val('');
                        $("#rePass").focus();
                        return false ;
                    }
                    if($("#newPass").val() == $("#oldPass").val()){
                        alert ("New Password should not same as Current Password.") ;
                        $("#newPass").val('');
                        $("#newPass").focus();
                        return false ;
                    }
                    $("#changePassformId").submit();
                });
            });

        </script>
    </head>
    <body>
    	<#include "../common/menu.ftl">
        <form action="changePassword.do">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr><td style="height:10px"></td></tr>
                <tr>
                    <td>
                        <table width="70%" border="0" align="center" cellpadding="0" cellspacing="0">
                            <tr>
                                <td>
                                    <div id="headertxt" align="center"><h1>Change Password</h1></div>
                                </td>
                            </tr>
                            <tr><td style="height:30px"></td></tr>

                            <tr>
                                <td width="100%" align="center" >
                                    <div id="message">
                                        <#if msg??>${msg}</#if>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td  width="70%">
                                    <table width="80%" >
                                        <tr >
                                            <td class="formtext" align="right">Current Password : &nbsp;<span class="errorText">&nbsp;*</span></td>
                                            <td class="formtext" style="height:25px" align="left">  <!--<input type="text" id="oldPass" name="oldPass" size="11" align="middle"/>-->
                                                <input type="password" name="oldPass"  value="" id="oldPass" size="12" />
                                            </td>
                                            <td style="height:10px;"></td>
                                        </tr>
                                        <tr>
                                            <td class="formtext" align="right">New Password : &nbsp;<span class="errorText">&nbsp;*</span></td>
                                            <td class="formtext" style="height:25px" align="left">  <!--            <input type="text" id="newPass" name="newPass" size="11" align="middle"/>-->
                                                <input type="password" name="newPass"  value="" id="newPass" size="12" />
                                            </td>
                                            <td style="height:10px;"></td>
                                        </tr>
                                        <tr>
                                            <td class="formtext" align="right">Confirm New Password : &nbsp;<span class="errorText">&nbsp;*</span></td>
                                            <td class="formtext" style="height:25px" align="left">  <!--            <input type="text" id="rePass" name="rePass" size="11" align="middle"/>-->
                                                <input type="password" name="rePass"  value="" id="rePass" size="12 /"
                                            </td>
                                            <td style="height:10px;"></td>
                                        </tr>
                                        <tr><td style="height:10px"></td></tr>
                                        <tr>
                                            <td colspan="2" align="center" >                                                           
                                                            <input align="left" type="submit" id="btnsubmit" name="btnsubmit" value="Change Password" class="largebtn"  />
                                                        </td>
                                        </tr>                                       
                                        <tr><td style="height:10px"></td></tr>
                                    </table>
                                </td>
                            </tr>                          
                        </table>
                    </td>
                </tr>
            </table>
        </s:form>
    </body>
</html>
