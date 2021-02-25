<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<html>

    <style>
        strong {text-align: center;}
        head {text-align: center;}
        div {text-align: center; font-size: larger}
        br {text-align: center;}
        body {text-align: center;}
        span, input {margin: 5px;}
    </style>

    <title>Index</title>
    <body>
        <div>
            <form method="post" action="/search">
                Enter User ID:
                <label>
                    <input type="number"  min="1" minlength="1" name="id" required><br>
                </label>
                <div>
                    <button type="submit" class="btn btn-primary">Search</button>
                </div>
            </form>
        </div>
    </body>
</html>