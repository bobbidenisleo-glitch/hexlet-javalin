@import org.example.hexlet.dto.MainPage
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
            <form action="/sessions/delete" method="post" style="display: inline;">
                <button type="submit">Выйти</button>
            </form>
        </div>
    @else
        <div style="background-color: #e8f4f8; padding: 10px; margin: 20px 0;">
            <p>Вы не авторизованы. <a href="/sessions/build">Войти</a></p>
        </div>
    @endif

    <ul>
        <li><a href="/users">Пользователи</a></li>
        <li><a href="/courses">Курсы</a></li>
    </ul>
</body>
</html>
