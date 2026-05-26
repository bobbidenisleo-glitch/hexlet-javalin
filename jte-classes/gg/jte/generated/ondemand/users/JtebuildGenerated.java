package gg.jte.generated.ondemand.users;
import org.example.hexlet.NamedRoutes;
import org.example.hexlet.dto.users.BuildUserPage;
public final class JtebuildGenerated {
	public static final String JTE_NAME = "users/build.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,13,13,13,16,16,17,17,18,18,18,19,19,20,20,23,23,25,25,25,25,25,25,25,25,25,28,28,28,28,28,28,28,28,28,32,32,32,32,32,32,32,32,32,36,36,36,36,36,36,36,36,36,47,47,47,47,47,47,47,47,47,51,51,51,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, BuildUserPage page) {
		jteOutput.writeContent("\n<!DOCTYPE html>\n<html lang=\"ru\">\n<head>\n    <meta charset=\"utf-8\">\n    <title>Регистрация</title>\n</head>\n<body>\n    <h1>Регистрация нового пользователя</h1>\n    \n    ");
		if (page.getErrors() != null && !page.getErrors().isEmpty()) {
			jteOutput.writeContent("\n        <div style=\"background-color: #fee; border: 1px solid #fcc; padding: 10px; margin-bottom: 20px;\">\n            <ul style=\"color: #c33;\">\n                ");
			for (var errors : page.getErrors().values()) {
				jteOutput.writeContent("\n                    ");
				for (var error : errors) {
					jteOutput.writeContent("\n                        <li>");
					jteOutput.setContext("li", null);
					jteOutput.writeUserContent(error.getMessage());
					jteOutput.writeContent("</li>\n                    ");
				}
				jteOutput.writeContent("\n                ");
			}
			jteOutput.writeContent("\n            </ul>\n        </div>\n    ");
		}
		jteOutput.writeContent("\n    \n    <form");
		var __jte_html_attribute_0 = NamedRoutes.usersPath();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeContent(" action=\"");
			jteOutput.setContext("form", "action");
			jteOutput.writeUserContent(__jte_html_attribute_0);
			jteOutput.setContext("form", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(" method=\"post\">\n        <div>\n            <label>Имя:</label><br>\n            <input type=\"text\" name=\"firstName\"");
		var __jte_html_attribute_1 = page.getFirstName() != null ? page.getFirstName() : "";
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(__jte_html_attribute_1);
			jteOutput.setContext("input", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">\n        </div>\n        <div>\n            <label>Фамилия:</label><br>\n            <input type=\"text\" name=\"lastName\"");
		var __jte_html_attribute_2 = page.getLastName() != null ? page.getLastName() : "";
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_2)) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(__jte_html_attribute_2);
			jteOutput.setContext("input", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">\n        </div>\n        <div>\n            <label>Email:</label><br>\n            <input type=\"email\" name=\"email\"");
		var __jte_html_attribute_3 = page.getEmail() != null ? page.getEmail() : "";
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_3)) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(__jte_html_attribute_3);
			jteOutput.setContext("input", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">\n        </div>\n        <div>\n            <label>Пароль:</label><br>\n            <input type=\"password\" name=\"password\">\n        </div>\n        <div>\n            <label>Подтверждение пароля:</label><br>\n            <input type=\"password\" name=\"passwordConfirmation\">\n        </div>\n        <button type=\"submit\">Зарегистрировать</button>\n        <a");
		var __jte_html_attribute_4 = NamedRoutes.usersPath();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_4)) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(__jte_html_attribute_4);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Отмена</a>\n    </form>\n</body>\n</html>\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		BuildUserPage page = (BuildUserPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
