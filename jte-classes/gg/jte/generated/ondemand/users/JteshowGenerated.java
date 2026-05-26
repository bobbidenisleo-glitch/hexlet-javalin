package gg.jte.generated.ondemand.users;
import org.example.hexlet.dto.users.UserPage;
public final class JteshowGenerated {
	public static final String JTE_NAME = "users/show.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,3,3,5,5,10,10,10,13,13,13,16,16,16,19,19,19,24,24,24,25,25,25,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UserPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n        <h1>Информация о пользователе</h1>\n        \n        <div style=\"border: 1px solid #ddd; border-radius: 8px; padding: 20px; background-color: #f9f9f9;\">\n            <div style=\"margin: 10px 0;\">\n                <strong>ID:</strong> ");
				jteOutput.setContext("div", null);
				jteOutput.writeUserContent(page.getUser().getId());
				jteOutput.writeContent("\n            </div>\n            <div style=\"margin: 10px 0;\">\n                <strong>Имя:</strong> ");
				jteOutput.setContext("div", null);
				jteOutput.writeUserContent(page.getUser().getFirstName());
				jteOutput.writeContent("\n            </div>\n            <div style=\"margin: 10px 0;\">\n                <strong>Фамилия:</strong> ");
				jteOutput.setContext("div", null);
				jteOutput.writeUserContent(page.getUser().getLastName());
				jteOutput.writeContent("\n            </div>\n            <div style=\"margin: 10px 0;\">\n                <strong>Email:</strong> ");
				jteOutput.setContext("div", null);
				jteOutput.writeUserContent(page.getUser().getEmail());
				jteOutput.writeContent("\n            </div>\n        </div>\n        \n        <a href=\"/users\" style=\"display: inline-block; margin-top: 1rem; padding: 0.5rem 1rem; background-color: #6c757d; color: #fff; text-decoration: none; border-radius: 4px;\">← Назад к списку</a>\n    ");
			}
		});
		jteOutput.writeContent("\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UserPage page = (UserPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
