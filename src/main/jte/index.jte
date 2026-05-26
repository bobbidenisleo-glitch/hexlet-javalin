@import org.example.hexlet.NamedRoutes

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <title>Главная</title>
</head>
<body>
    <h1>Добро пожаловать!</h1>
    
    <ul>
        <li><a href="${NamedRoutes.usersPath()}">Пользователи</a></li>
        <li><a href="${NamedRoutes.coursesPath()}">Курсы</a></li>
    </ul>
</body>
</html>
