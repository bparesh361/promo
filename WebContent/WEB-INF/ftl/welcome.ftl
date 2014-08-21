<html>
<head>
<#include "common/scripts.ftl">
</head>
<body>
	<#include "common/menu.ftl">

		<div id="middle_cont">            
                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="f14">
                    <div>
                        <table width="50%" align="center" cellpadding="0" cellspacing="0">
                            <tr>
                                <td height="80px" align="center">
                                    <h1>Welcome To Promotion Workflow</h1>
                                </td>
                            </tr>
                            <tr>
                                <td align="center">
                                    <table width="70%" border="0" align="center" cellpadding="0" cellspacing="0">
                                        <tr>
                                            <td align="left">User Code </td><td> :&nbsp;&nbsp;</td>
                                            <td align="left">
                                                ${emp.empCode}
                                            </td>
                                        </tr>
                                        <tr><td height="10px"></td></tr>
                                        <tr>
                                            <td align="left">User Name </td><td> :&nbsp;&nbsp;</td>
                                            <td align="left">
                                                 ${emp.employeeName}
                                            </td>
                                        </tr>
                                        <tr><td height="10px"></td></tr>
                                        <tr>
                                            <td align="left">Contact No </td><td> :&nbsp;&nbsp;</td>
                                            <td align="left" >
                                                 ${emp.contactNo}
                                            </td>
                                        </tr>
                                        <tr><td height="10px"></td></tr>
                                        <tr>
                                            <td align="left">Email Id</td><td> :&nbsp;&nbsp;</td>
                                            <td align="left">
                                                ${emp.emailId}
                                            </td>
                                        </tr>
                                        <tr><td height="10px"></td></tr>
                                        <tr>
                                            <td align="left">Role </td><td> :&nbsp;&nbsp;</td>
                                            <td align="left">
                                                ${emp.mstRole.roleName}
                                            </td>
                                        </tr>
                                        <tr><td height="10px"></td></tr>
                                        <tr>
                                            <td align="left">Store Code</td><td> :&nbsp;&nbsp;</td>
                                            <td align="left">
                                                ${emp.mstRole.roleName}
                                            </td>
                                        </tr>
                                        <tr><td height="10px"></td></tr>
                                        <tr>
                                            <td align="left">Store Description</td><td> :&nbsp;&nbsp;</td>
                                            <td align="left">
                                                ${emp.mstStore.siteDescription}
                                            </td>
                                        </tr>
                                        <tr><td height="10px"></td></tr>
                                        <tr>
                                            <td align="left">Zone</td><td> :&nbsp;&nbsp;</td>
                                            <td align="left">
                                               	${emp.mstStore.mstZone.zoneName}
                                            </td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                        </table>
                    </div>
                </table>
        </div>
		


</body>
</html>