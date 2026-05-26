@import org.example.hexlet.NamedRoutes
@import org.example.hexlet.dto.users.UserPage
@param UserPage page

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <title>Пользователь ${page.getUser().getFirstName()}</title>
</head>
<body>
    <h1>Информация о пользователе</h1>
    
    <p><strong>ID:</strong> ${page.getUser().getId()}</p>
    <p><strong>Имя:</strong> ${page.getUser().getFirstName()}</p>
    <p><strong>Фамилия:</strong> ${page.getUser().getLastName()}</p>
    <p><strong>Email:</strong> ${page.getUser().getEmail()}</p>
    
    <a href="${NamedRoutes.usersPath()}">← Назад к списку</a>
</body>
</html>
