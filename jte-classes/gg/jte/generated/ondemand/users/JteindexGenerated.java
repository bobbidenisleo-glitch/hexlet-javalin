package gg.jte.generated.ondemand.users;
import org.example.hexlet.NamedRoutes;
import org.example.hexlet.dto.users.UsersPage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "users/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,13,13,13,13,13,13,13,13,13,13,15,15,17,17,29,29,31,31,31,32,32,32,33,33,33,34,34,34,35,35,35,35,35,35,35,35,35,37,37,40,40,43,43,43,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UsersPage page) {
		jteOutput.writeContent("\n<!DOCTYPE html>\n<html lang=\"ru\">\n<head>\n    <meta charset=\"utf-8\">\n    <title>Список пользователей</title>\n</head>\n<body>\n    <h1>Список пользователей</h1>\n    \n    <a");
		var __jte_html_attribute_0 = NamedRoutes.buildUserPath();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(__jte_html_attribute_0);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">➕ Добавить пользователя</a>\n    \n    ");
		if (page.getUsers().isEmpty()) {
			jteOutput.writeContent("\n        <p>Пользователей пока нет</p>\n    ");
		} else {
			jteOutput.writeContent("\n        <table border=\"1\">\n            <thead>\n                <tr>\n                    <th>ID</th>\n                    <th>Имя</th>\n                    <th>Фамилия</th>\n                    <th>Email</th>\n                    <th>Действие</th>\n                </tr>\n            </thead>\n            <tbody>\n                ");
			for (var user : page.getUsers()) {
				jteOutput.writeContent("\n                    <tr>\n                        <td>");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(user.getId());
				jteOutput.writeContent("</td>\n                        <td>");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(user.getFirstName());
				jteOutput.writeContent("</td>\n                        <td>");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(user.getLastName());
				jteOutput.writeContent("</td>\n                        <td>");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(user.getEmail());
				jteOutput.writeContent("</td>\n                        <td><a");
				var __jte_html_attribute_1 = NamedRoutes.userPath(user.getId());
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
					jteOutput.writeContent(" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(__jte_html_attribute_1);
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">Просмотр</a></td>\n                    </tr>\n                ");
			}
			jteOutput.writeContent("\n            </tbody>\n        </table>\n    ");
		}
		jteOutput.writeContent("\n</body>\n</html>\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UsersPage page = (UsersPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
