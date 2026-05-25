@import gg.jte.Content
@param Content content

<!doctype html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Hexlet Javalin</title>
    <style>
        * { margin: 0; padding: 0; box-sizing: border-box; }
        body { font-family: Arial, sans-serif; line-height: 1.6; background-color: #f4f4f4; }
        .container { max-width: 1200px; margin: 0 auto; padding: 20px; }
        .header { background-color: #333; color: #fff; padding: 1rem 0; margin-bottom: 2rem; }
        .header .container { display: flex; justify-content: space-between; align-items: center; }
        .header h1 { font-size: 1.5rem; }
        .header a { color: #fff; text-decoration: none; margin-left: 1rem; }
        .header a:hover { text-decoration: underline; }
        .main-content { background-color: #fff; border-radius: 8px; padding: 20px; box-shadow: 0 2px 4px rgba(0,0,0,0.1); min-height: 70vh; }
        .footer { background-color: #333; color: #fff; text-align: center; padding: 1rem 0; margin-top: 2rem; }
        .footer a { color: #fff; text-decoration: none; }
        .footer a:hover { text-decoration: underline; }
    </style>
</head>
<body>
    <div class="header">
        <div class="container">
            <h1>Hexlet Javalin</h1>
            <nav>
                <a href="/">Главная</a>
                <a href="/users">Пользователи</a>
                <a href="/courses">Курсы</a>
            </nav>
        </div>
    </div>
    <div class="container">
        <div class="main-content">
            ${content}
        </div>
    </div>
    <div class="footer">
        <div class="container">
            <p>© 2025 Hexlet Javalin | <a href="https://github.com/bobbidenisleo-glitch" target="_blank">Мой GitHub</a></p>
        </div>
    </div>
</body>
</html>
