@import org.example.hexlet.dto.users.UserPage
@param UserPage page

@template.layout.page(
    content = @`
        <h1>Информация о пользователе</h1>
        
        <div style="border: 1px solid #ddd; border-radius: 8px; padding: 20px; background-color: #f9f9f9;">
            <div style="margin: 10px 0;"><strong>ID:</strong> ${page.getUser().getId()}</div>
            <div style="margin: 10px 0;"><strong>Имя:</strong> ${page.getUser().getFirstName()}</div>
            <div style="margin: 10px 0;"><strong>Фамилия:</strong> ${page.getUser().getLastName()}</div>
            <div style="margin: 10px 0;"><strong>Email:</strong> ${page.getUser().getEmail()}</div>
        </div>
        
        <a href="/users" style="display: inline-block; margin-top: 1rem; padding: 0.5rem 1rem; background-color: #6c757d; color: #fff; text-decoration: none; border-radius: 4px;">← Назад к списку</a>
    `
)
