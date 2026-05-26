package gg.jte.generated.ondemand.users;
public final class JtebuildGenerated {
	public static final String JTE_NAME = "users/build.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,0,2,2,29,29,29,30,30,30,30,30,30};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor) {
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n        <h1>Регистрация нового пользователя</h1>\n        \n        <form action=\"/users\" method=\"post\">\n            <div style=\"margin-bottom: 15px;\">\n                <label for=\"name\">Имя:</label><br>\n                <input type=\"text\" id=\"name\" name=\"name\" required style=\"width: 100%; padding: 8px;\">\n            </div>\n            \n            <div style=\"margin-bottom: 15px;\">\n                <label for=\"email\">Email:</label><br>\n                <input type=\"email\" id=\"email\" name=\"email\" required style=\"width: 100%; padding: 8px;\">\n            </div>\n            \n            <div style=\"margin-bottom: 15px;\">\n                <label for=\"password\">Пароль:</label><br>\n                <input type=\"password\" id=\"password\" name=\"password\" required style=\"width: 100%; padding: 8px;\">\n            </div>\n            \n            <div style=\"margin-bottom: 15px;\">\n                <label for=\"passwordConfirmation\">Подтверждение пароля:</label><br>\n                <input type=\"password\" id=\"passwordConfirmation\" name=\"passwordConfirmation\" required style=\"width: 100%; padding: 8px;\">\n            </div>\n            \n            <button type=\"submit\" style=\"background-color: #28a745; color: white; padding: 10px 15px; border: none; border-radius: 4px;\">Зарегистрировать</button>\n            <a href=\"/users\" style=\"margin-left: 10px;\">Отмена</a>\n        </form>\n    ");
			}
		});
		jteOutput.writeContent("\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		render(jteOutput, jteHtmlInterceptor);
	}
}
