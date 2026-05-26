package gg.jte.generated.ondemand.users;
import org.example.hexlet.dto.users.UsersPage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "users/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,3,3,5,5,13,13,13,13,13,13,13,13,13,15,15,17,17,20,20,22,22,33,33,35,35,35,36,36,36,37,37,37,38,38,38,38,40,40,43,43,44,44,44,45,45,45,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UsersPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n        <div style=\"display: flex; justify-content: space-between; align-items: center; margin-bottom: 20px;\">\n            <h1>Список пользователей</h1>\n            <a href=\"/users/build\" style=\"background-color: #28a745; color: white; padding: 8px 12px; text-decoration: none; border-radius: 4px;\">➕ Добавить пользователя</a>\n        </div>\n        \n        <form method=\"get\" action=\"/users\" style=\"margin-bottom: 20px;\">\n            <label for=\"term\">Фильтр по имени:</label>\n            <input type=\"text\" id=\"term\" name=\"term\"");
				var __jte_html_attribute_0 = page.getTerm() != null ? page.getTerm() : "";
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" placeholder=\"Введите начало имени...\">\n            <button type=\"submit\">Найти</button>\n            ");
				if (page.getTerm() != null && !page.getTerm().isEmpty()) {
					jteOutput.writeContent("\n                <a href=\"/users\">Сбросить</a>\n            ");
				}
				jteOutput.writeContent("\n        </form>\n        \n        ");
				if (page.getUsers().isEmpty()) {
					jteOutput.writeContent("\n            <p>Пользователи не найдены</p>\n        ");
				} else {
					jteOutput.writeContent("\n            <table border=\"1\" style=\"border-collapse: collapse; width: 100%;\">\n                <thead>\n                    <tr style=\"background-color: #f2f2f2;\">\n                        <th style=\"padding: 8px;\">ID</th>\n                        <th style=\"padding: 8px;\">Имя</th>\n                        <th style=\"padding: 8px;\">Email</th>\n                        <th style=\"padding: 8px;\">Действие</th>\n                    </tr>\n                </thead>\n                <tbody>\n                    ");
					for (var user : page.getUsers()) {
						jteOutput.writeContent("\n                        <tr>\n                            <td style=\"padding: 8px;\">");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(user.getId());
						jteOutput.writeContent("</td>\n                            <td style=\"padding: 8px;\">");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(user.getName());
						jteOutput.writeContent("</td>\n                            <td style=\"padding: 8px;\">");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(user.getEmail());
						jteOutput.writeContent("</td>\n                            <td style=\"padding: 8px;\"><a href=\"/users/");
						jteOutput.setContext("a", "href");
						jteOutput.writeUserContent(user.getId());
						jteOutput.setContext("a", null);
						jteOutput.writeContent("\">Просмотр</a></td>\n                        </tr>\n                    ");
					}
					jteOutput.writeContent("\n                </tbody>\n            </table>\n        ");
				}
				jteOutput.writeContent("\n    ");
			}
		});
		jteOutput.writeContent("\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UsersPage page = (UsersPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
