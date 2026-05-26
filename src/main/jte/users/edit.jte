@import org.example.hexlet.NamedRoutes
@param org.example.hexlet.model.User user

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <title>Редактирование пользователя</title>
</head>
<body>
    <h1>Редактирование пользователя</h1>
    
    <form action="${NamedRoutes.userPath(user.getId())}" method="post">
        <input type="hidden" name="_method" value="patch">
        
        <div>
            <label>Имя:</label><br>
            <input type="text" name="firstName" value="${user.getFirstName()}">
        </div>
        <div>
            <label>Фамилия:</label><br>
            <input type="text" name="lastName" value="${user.getLastName()}">
        </div>
        <div>
            <label>Email:</label><br>
            <input type="email" name="email" value="${user.getEmail()}">
        </div>
        <button type="submit">Сохранить</button>
        <a href="${NamedRoutes.usersPath()}">Отмена</a>
    </form>
</body>
</html>
