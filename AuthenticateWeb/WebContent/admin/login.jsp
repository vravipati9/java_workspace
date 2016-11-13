<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Login Form</title>
    </head>

	<body>            
           <form name="loginForm" method="post" action="j_security_check">
                <table id="loginTable">
                    <tr><td>&nbsp;</td><td>&nbsp;</td></tr>
                    <tr>
                        <td>Please Enter Your username and password ...</td>
                    </tr>
                    <tr><td>&nbsp;</td><td>&nbsp;</td></tr>
                    <tr>
                        <td><label for="username_id">UserName</label></td>
                        <td class="right">
                            <input type="text" name="j_username" id="username_id" /></td>
                    </tr>
                    <tr><td>&nbsp;</td><td>&nbsp;</td></tr>
                    <tr>
                        <td><label for="password_id">Password</label></td>
                        <td class="right"><input type="password" name="j_password" id="password_id" /></td>
                    </tr>
                    <tr><td>&nbsp;</td></tr>
                    <tr>
                        <td colspan="2" class="right"><input type="submit" value="Submit" /></td>
                    </tr>
                </table>

            </form>            
   </body>
</html>

