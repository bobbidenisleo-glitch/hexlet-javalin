package gg.jte.generated.ondemand.sessions;
import org.example.hexlet.NamedRoutes;
public final class JtebuildGenerated {
	public static final String JTE_NAME = "sessions/build.jte";
	public static final int[] JTE_LINE_INFO = {0,0,11,11,11,11,11,11,11,11,11,11,11,11,11,28,28,28,28,28,28};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor) {
		jteOutput.writeContent("\n<!DOCTYPE html>\n<html lang=\"ru\">\n<head>\n    <meta charset=\"utf-8\">\n    <title>Вход</title>\n</head>\n<body>\n    <h1>Вход в систему</h1>\n    \n    <form");
		var __jte_html_attribute_0 = NamedRoutes.sessionsPath();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeContent(" action=\"");
			jteOutput.setContext("form", "action");
			jteOutput.writeUserContent(__jte_html_attribute_0);
			jteOutput.setContext("form", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(" method=\"post\">\n        <div>\n            <label>Имя пользователя:</label><br>\n            <input type=\"text\" name=\"nickname\" placeholder=\"Введите nickname\" required>\n        </div>\n        <div>\n            <label>Пароль:</label><br>\n            <input type=\"password\" name=\"password\" placeholder=\"Введите пароль\">\n        </div>\n        <button type=\"submit\">Войти</button>\n    </form>\n    \n    <div style=\"margin-top: 20px;\">\n        <a href=\"/\">← На главную</a>\n    </div>\n</body>\n</html>\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		render(jteOutput, jteHtmlInterceptor);
	}
}
