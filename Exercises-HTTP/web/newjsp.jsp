<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>

        <table border="1">
            <tbody>
                <tr>
                    <td>Host</td>
                    <td><%= request.getHeader("host")%></td>
                </tr>
                <tr>
                    <td>Connection</td>
                    <td><%= request.getHeader("connection")%></td>
                </tr>
                <tr>
                    <td>Cache-control</td>
                    <td><%= request.getHeader("cache-control")%></td>
                </tr>
                <tr>
                    <td>Accept</td>
                    <td><%= request.getHeader("accept")%></td>
                </tr>
                <tr>
                    <td>User-agent</td>
                    <td><%= request.getHeader("user-agent")%></td>
                </tr>
                <tr>
                    <td>Accept-coding</td>
                    <td><%= request.getHeader("accept-coding")%></td>
                </tr>
                <tr>
                    <td>Accept-language</td>
                    <td><%= request.getHeader("accept-language")%></td>
                </tr>
            </tbody>
        </table>

    </body>
</html>
