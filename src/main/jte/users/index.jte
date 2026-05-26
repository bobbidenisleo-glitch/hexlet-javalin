@import org.example.hexlet.NamedRoutes
@import org.example.hexlet.dto.users.UsersPage
@param UsersPage page

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <title>Список пользователей</title>
</head>
<body>
    <h1>Список пользователей</h1>
    
    <a href="${NamedRoutes.buildUserPath()}">➕ Добавить пользователя</a>
    
    @if(page.getUsers().isEmpty())
        <p>Пользователей пока нет</p>
    @else
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Имя</th>
                    <th>Фамилия</th>
                    <th>Email</th>
                    <th>Действие</th>
                </tr>
            </thead>
            <tbody>
                @for(var user : page.getUsers())
                    <tr>
                        <td>${user.getId()}</td>
                        <td>${user.getFirstName()}</td>
                        <td>${user.getLastName()}</td>
                        <td>${user.getEmail()}</td>
                        <td><a href="${NamedRoutes.userPath(user.getId())}">Просмотр</a></td>
                    </tr>
                @endfor
            </tbody>
        </table>
    @endif
</body>
</html>
