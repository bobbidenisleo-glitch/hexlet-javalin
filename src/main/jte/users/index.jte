@import org.example.hexlet.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
    content = @`
        <h1>${page.getHeader()}</h1>
        
        <a href="/users/build" style="display: inline-block; margin-bottom: 1rem; padding: 0.5rem 1rem; background-color: #28a745; color: #fff; text-decoration: none; border-radius: 4px;">➕ Создать пользователя</a>
        
        @if(page.getUsers().isEmpty())
            <p>Пока не добавлено ни одного пользователя</p>
        @else
            <table style="width: 100%; border-collapse: collapse;">
                <thead>
                    <tr style="background-color: #f2f2f2;">
                        <th style="padding: 12px; text-align: left; border-bottom: 1px solid #ddd;">ID</th>
                        <th style="padding: 12px; text-align: left; border-bottom: 1px solid #ddd;">Имя</th>
                        <th style="padding: 12px; text-align: left; border-bottom: 1px solid #ddd;">Фамилия</th>
                        <th style="padding: 12px; text-align: left; border-bottom: 1px solid #ddd;">Email</th>
                        <th style="padding: 12px; text-align: left; border-bottom: 1px solid #ddd;">Действие</th>
                    </tr>
                </thead>
                <tbody>
                    @for(var user : page.getUsers())
                        <tr style="border-bottom: 1px solid #ddd;">
                            <td style="padding: 12px;">${user.getId()}</td>
                            <td style="padding: 12px;">${user.getFirstName()}</td>
                            <td style="padding: 12px;">${user.getLastName()}</td>
                            <td style="padding: 12px;">${user.getEmail()}</td>
                            <td style="padding: 12px;"><a href="/users/${user.getId()}" style="color: #007bff; text-decoration: none;">Просмотр</a></td>
                        </tr>
                    @endfor
                </tbody>
            </table>
        @endif
    `
)
