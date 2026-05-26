package gg.jte.generated.ondemand.users;
import org.example.hexlet.NamedRoutes;
public final class JteeditGenerated {
	public static final String JTE_NAME = "users/edit.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,12,12,12,12,12,12,12,12,12,12,17,17,17,17,17,17,17,17,17,21,21,21,21,21,21,21,21,21,25,25,25,25,25,25,25,25,25,28,28,28,28,28,28,28,28,28,32,32,32,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, org.example.hexlet.model.User user) {
		jteOutput.writeContent("\n<!DOCTYPE html>\n<html lang=\"ru\">\n<head>\n    <meta charset=\"utf-8\">\n    <title>Редактирование пользователя</title>\n</head>\n<body>\n    <h1>Редактирование пользователя</h1>\n    \n    <form");
		var __jte_html_attribute_0 = NamedRoutes.userPath(user.getId());
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeContent(" action=\"");
			jteOutput.setContext("form", "action");
			jteOutput.writeUserContent(__jte_html_attribute_0);
			jteOutput.setContext("form", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(" method=\"post\">\n        <input type=\"hidden\" name=\"_method\" value=\"patch\">\n        \n        <div>\n            <label>Имя:</label><br>\n            <input type=\"text\" name=\"firstName\"");
		var __jte_html_attribute_1 = user.getFirstName();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(__jte_html_attribute_1);
			jteOutput.setContext("input", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">\n        </div>\n        <div>\n            <label>Фамилия:</label><br>\n            <input type=\"text\" name=\"lastName\"");
		var __jte_html_attribute_2 = user.getLastName();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_2)) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(__jte_html_attribute_2);
			jteOutput.setContext("input", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">\n        </div>\n        <div>\n            <label>Email:</label><br>\n            <input type=\"email\" name=\"email\"");
		var __jte_html_attribute_3 = user.getEmail();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_3)) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(__jte_html_attribute_3);
			jteOutput.setContext("input", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">\n        </div>\n        <button type=\"submit\">Сохранить</button>\n        <a");
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
		org.example.hexlet.model.User user = (org.example.hexlet.model.User)params.get("user");
		render(jteOutput, jteHtmlInterceptor, user);
	}
}
