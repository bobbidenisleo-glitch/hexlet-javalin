@import org.example.hexlet.NamedRoutes

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <title>Вход</title>
</head>
<body>
    <h1>Вход в систему</h1>
    
    <form action="${NamedRoutes.sessionsPath()}" method="post">
        <div>
            <label>Имя пользователя:</label><br>
            <input type="text" name="nickname" placeholder="Введите nickname" required>
        </div>
        <div>
            <label>Пароль:</label><br>
            <input type="password" name="password" placeholder="Введите пароль">
        </div>
        <button type="submit">Войти</button>
    </form>
    
    <div style="margin-top: 20px;">
        <a href="/">← На главную</a>
    </div>
</body>
</html>
