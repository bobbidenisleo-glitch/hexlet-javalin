package gg.jte.generated.ondemand;
import org.example.hexlet.dto.MainPage;
import org.example.hexlet.NamedRoutes;
public final class JteindexGenerated {
	public static final String JTE_NAME = "index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,13,13,13,15,15,15,18,18,18,18,18,18,18,18,18,22,22,25,25,25,25,25,25,25,25,25,27,27,35,35,35,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, MainPage page) {
		jteOutput.writeContent("\n<!DOCTYPE html>\n<html lang=\"ru\">\n<head>\n    <meta charset=\"utf-8\">\n    <title>Главная</title>\n</head>\n<body>\n    <h1>Добро пожаловать!</h1>\n    \n    ");
		if (page.getCurrentUser() != null) {
			jteOutput.writeContent("\n        <div style=\"background-color: #d4edda; padding: 10px; margin: 20px 0;\">\n            <strong>Вы вошли как: ");
			jteOutput.setContext("strong", null);
			jteOutput.writeUserContent(page.getCurrentUser());
			jteOutput.writeContent("</strong>\n        </div>\n        \n        <form");
			var __jte_html_attribute_0 = NamedRoutes.sessionsPath();
			if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
				jteOutput.writeContent(" action=\"");
				jteOutput.setContext("form", "action");
				jteOutput.writeUserContent(__jte_html_attribute_0);
				jteOutput.setContext("form", null);
				jteOutput.writeContent("\"");
			}
			jteOutput.writeContent(" method=\"post\">\n            <input type=\"hidden\" name=\"_method\" value=\"delete\">\n            <button type=\"submit\">Выйти</button>\n        </form>\n    ");
		} else {
			jteOutput.writeContent("\n        <div style=\"background-color: #e8f4f8; padding: 10px; margin: 20px 0;\">\n            <p>Вы не авторизованы.</p>\n            <p><a");
			var __jte_html_attribute_1 = NamedRoutes.buildSessionPath();
			if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
				jteOutput.writeContent(" href=\"");
				jteOutput.setContext("a", "href");
				jteOutput.writeUserContent(__jte_html_attribute_1);
				jteOutput.setContext("a", null);
				jteOutput.writeContent("\"");
			}
			jteOutput.writeContent(">Войти</a></p>\n        </div>\n    ");
		}
		jteOutput.writeContent("\n    \n    <ul>\n        <li><a href=\"/u\">Пользователи</a></li>\n        <li><a href=\"/courses\">Курсы</a></li>\n    </ul>\n</body>\n</html>\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		MainPage page = (MainPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
