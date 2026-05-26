@import org.example.hexlet.NamedRoutes
@import org.example.hexlet.dto.users.BuildUserPage
@param BuildUserPage page

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <title>Регистрация</title>
</head>
<body>
    <h1>Регистрация нового пользователя</h1>
    
    @if(page.getErrors() != null && !page.getErrors().isEmpty())
        <div style="background-color: #fee; border: 1px solid #fcc; padding: 10px; margin-bottom: 20px;">
            <ul style="color: #c33;">
                @for(var errors : page.getErrors().values())
                    @for(var error : errors)
                        <li>${error.getMessage()}</li>
                    @endfor
                @endfor
            </ul>
        </div>
    @endif
    
    <form action="${NamedRoutes.usersPath()}" method="post">
        <div>
            <label>Имя:</label><br>
            <input type="text" name="firstName" value="${page.getFirstName() != null ? page.getFirstName() : ""}">
        </div>
        <div>
            <label>Фамилия:</label><br>
            <input type="text" name="lastName" value="${page.getLastName() != null ? page.getLastName() : ""}">
        </div>
        <div>
            <label>Email:</label><br>
            <input type="email" name="email" value="${page.getEmail() != null ? page.getEmail() : ""}">
        </div>
        <div>
            <label>Пароль:</label><br>
            <input type="password" name="password">
        </div>
        <div>
            <label>Подтверждение пароля:</label><br>
            <input type="password" name="passwordConfirmation">
        </div>
        <button type="submit">Зарегистрировать</button>
        <a href="${NamedRoutes.usersPath()}">Отмена</a>
    </form>
</body>
</html>
