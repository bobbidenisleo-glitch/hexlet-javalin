@import org.example.hexlet.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
    content = @`
        @if(page.getFlash() != null)
            <div class="alert alert-${page.getFlashType()}">
                ${page.getFlash()}
            </div>
        @endif
        
        <div style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 20px;">
            <h1>Список пользователей</h1>
            <a href="/users/build" style="background-color: #28a745; color: white; padding: 8px 12px; text-decoration: none; border-radius: 4px;">➕ Добавить пользователя</a>
        </div>
        
        @if(page.getUsers().isEmpty())
            <p>Пользователей пока нет</p>
        @else
            <table border="1" style="border-collapse: collapse; width: 100%;">
                <thead>
                    <tr style="background-color: #f2f2f2;">
                        <th style="padding: 8px;">ID</th>
                        <th style="padding: 8px;">Имя</th>
                        <th style="padding: 8px;">Фамилия</th>
                        <th style="padding: 8px;">Email</th>
                        <th style="padding: 8px;">Действие</th>
                    </tr>
                </thead>
                <tbody>
                    @for(var user : page.getUsers())
                        <tr>
                            <td style="padding: 8px;">${user.getId()}</td>
                            <td style="padding: 8px;">${user.getFirstName()}</td>
                            <td style="padding: 8px;">${user.getLastName()}</td>
                            <td style="padding: 8px;">${user.getEmail()}</td>
                            <td style="padding: 8px;"><a href="/users/${user.getId()}">Просмотр</a></td>
                        </tr>
                    @endfor
                </tbody>
            </table>
        @endif
    `
)
