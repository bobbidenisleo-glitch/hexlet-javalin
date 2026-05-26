@template.layout.page(
    content = @`
        <h1>Регистрация нового пользователя</h1>
        
        <form action="/users" method="post">
            <div style="margin-bottom: 15px;">
                <label for="name">Имя:</label><br>
                <input type="text" id="name" name="name" required style="width: 100%; padding: 8px;">
            </div>
            
            <div style="margin-bottom: 15px;">
                <label for="email">Email:</label><br>
                <input type="email" id="email" name="email" required style="width: 100%; padding: 8px;">
            </div>
            
            <div style="margin-bottom: 15px;">
                <label for="password">Пароль:</label><br>
                <input type="password" id="password" name="password" required style="width: 100%; padding: 8px;">
            </div>
            
            <div style="margin-bottom: 15px;">
                <label for="passwordConfirmation">Подтверждение пароля:</label><br>
                <input type="password" id="passwordConfirmation" name="passwordConfirmation" required style="width: 100%; padding: 8px;">
            </div>
            
            <button type="submit" style="background-color: #28a745; color: white; padding: 10px 15px; border: none; border-radius: 4px;">Зарегистрировать</button>
            <a href="/users" style="margin-left: 10px;">Отмена</a>
        </form>
    `
)
