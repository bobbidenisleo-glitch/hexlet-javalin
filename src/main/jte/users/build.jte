@import org.example.hexlet.dto.users.BuildUserPage
@param BuildUserPage page

@template.layout.page(
    content = @`
        <h1>Регистрация нового пользователя</h1>
        
        @if(page.getErrors() != null && !page.getErrors().isEmpty())
            <div style="background-color: #fee; border: 1px solid #fcc; padding: 10px; margin-bottom: 20px; border-radius: 4px;">
                <ul style="margin: 0; padding-left: 20px; color: #c33;">
                    @for(var errors : page.getErrors().values())
                        @for(var error : errors)
                            <li>${error.getMessage()}</li>
                        @endfor
                    @endfor
                </ul>
            </div>
        @endif
        
        <form action="/users" method="post">
            <div style="margin-bottom: 15px;">
                <label for="firstName">Имя:</label><br>
                <input type="text" id="firstName" name="firstName" 
                       value="${page.getFirstName() != null ? page.getFirstName() : ""}" 
                       style="width: 100%; padding: 8px;">
            </div>
            
            <div style="margin-bottom: 15px;">
                <label for="lastName">Фамилия:</label><br>
                <input type="text" id="lastName" name="lastName" 
                       value="${page.getLastName() != null ? page.getLastName() : ""}" 
                       style="width: 100%; padding: 8px;">
            </div>
            
            <div style="margin-bottom: 15px;">
                <label for="email">Email:</label><br>
                <input type="email" id="email" name="email" 
                       value="${page.getEmail() != null ? page.getEmail() : ""}" 
                       style="width: 100%; padding: 8px;">
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
