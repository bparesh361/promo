<html>
<head>
<#include "../common/scripts.ftl">
        <script type="text/javascript">
            jQuery(document).ready(function()
            {
             
                //Preventing caching for ajax calls
                $.ajaxSetup({ cache: false });
                $("#btnSendPassword").click(function(){
                	alert('called');
                    $("#error").html('');
                    $("#success").html('');
                    var userID=$("#userId").val();
                    //This regex is from the jquery.numeric plugin itself
                    if(!isNumeric(userID)){
                        alert("User name should be numeric.");
                        $("#userName").val("");
                        $("#userName").focus();
                        return false;
                    }

                    if(userID==''){
                        $("#error").html('Please Enter UserID');
                    }else{
                        $.ajax({
                            url:"forgotpasswordreq.do?userId="+$("#userId").val(),
                            global: false,
                            type: "POST",
                            dataType: "json",
                            async:false,
                            error:function(){
                                alert("Can not Connect to Server");
                            },
                            success: function(data){
                                for(var key in data){
                                    if(key=="success"){
                                        $("#success").html(data[key]);
                                    }else {
                                        $("#error").html(data[key]);
                                    }
                                }
                            }
                        });
                    }
                });
                

              
            });
        </script>

    </head>
    <body>
    	<form action="forgotpasswordreq.do" method="post">
        <table width="50%"  align="center">
            <tr>
                <td>
                    <div id="login_page">
                        <!--                        <div class="home_logo"><img src="images/promotion_workflow_logo.png"/></div>-->
                        
                        <div class="login_box">
                          
                            <div id="headertxt" align="center"><b>Reset Password</b></div>                            
                            <div class="login_successmsg" id="success"><#if msg??>${msg}</#if></div>

                            <div class="full_width mt20">
                                <div class="login_txt left">USER ID<span class="errorText">&nbsp;*</span></div>
                                <input type="text" name="userId" id="userId" />

                            </div>
                            <div id="login_btn" class="mt20 left" align="center">                                
                                <input type="submit" name="btnSendPassword" id="btnSendPassword" value="Submit" class="but_login"/>
                                <!--                        <input type="submit" name="button" id="button" value="Clear" class="but_login" />-->
                            </div>

                        </div>
  
                    </div>
                </td>
            </tr>
        </table>
       </form>
    </body>
</html>

