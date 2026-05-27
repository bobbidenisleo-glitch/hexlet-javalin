@import org.example.hexlet.dto.MainPage
@import org.example.hexlet.NamedRoutes
@param MainPage page

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <title>Главная</title>
</head>
<body>
    <h1>Добро пожаловать!</h1>
    
    @if(page.getCurrentUser() != null)
        <div style="background-color: #d4edda; padding: 10px; margin: 20px 0;">
            <strong>Вы вошли как: ${page.getCurrentUser()}</strong>
        </div>
        
        <form action="${NamedRoutes.sessionsPath()}" method="post">
            <input type="hidden" name="_method" value="delete">
            <button type="submit">Выйти</button>
        </form>
    @else
        <div style="background-color: #e8f4f8; padding: 10px; margin: 20px 0;">
            <p>Вы не авторизованы.</p>
            <p><a href="${NamedRoutes.buildSessionPath()}">Войти</a></p>
        </div>
    @endif
    
    <ul>
        <li><a href="/u">Пользователи</a></li>
        <li><a href="/courses">Курсы</a></li>
    </ul>
</body>
</html>
