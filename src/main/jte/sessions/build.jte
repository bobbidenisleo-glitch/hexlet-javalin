@import org.example.hexlet.NamedRoutes
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <title>Вход</title>
</head>
<body>
    <h1>Вход</h1>
    <form action="/sessions" method="post">
        <input type="email" name="email" placeholder="Email" required>
        <input type="password" name="password" placeholder="Пароль" required>
        <button type="submit">Войти</button>
    </form>
    <p><a href="/">На главную</a></p>
</body>
</html>
