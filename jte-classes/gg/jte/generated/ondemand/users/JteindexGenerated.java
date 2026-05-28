package gg.jte.generated.ondemand.users;
import org.example.hexlet.dto.users.UsersPage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "users/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,3,3,5,5,6,6,7,7,7,7,8,8,8,10,10,17,17,19,19,31,31,33,33,33,34,34,34,35,35,35,36,36,36,37,37,37,37,39,39,42,42,43,43,43,44,44,44,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UsersPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n        ");
				if (page.getFlash() != null) {
					jteOutput.writeContent("\n            <div class=\"alert alert-");
					jteOutput.setContext("div", "class");
					jteOutput.writeUserContent(page.getFlashType());
					jteOutput.setContext("div", null);
					jteOutput.writeContent("\">\n                ");
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(page.getFlash());
					jteOutput.writeContent("\n            </div>\n        ");
				}
				jteOutput.writeContent("\n        \n        <div style=\"display: flex; justify-content: space-between; align-items: center; margin-bottom: 20px;\">\n            <h1>Список пользователей</h1>\n            <a href=\"/users/build\" style=\"background-color: #28a745; color: white; padding: 8px 12px; text-decoration: none; border-radius: 4px;\">➕ Добавить пользователя</a>\n        </div>\n        \n        ");
				if (page.getUsers().isEmpty()) {
					jteOutput.writeContent("\n            <p>Пользователей пока нет</p>\n        ");
				} else {
					jteOutput.writeContent("\n            <table border=\"1\" style=\"border-collapse: collapse; width: 100%;\">\n                <thead>\n                    <tr style=\"background-color: #f2f2f2;\">\n                        <th style=\"padding: 8px;\">ID</th>\n                        <th style=\"padding: 8px;\">Имя</th>\n                        <th style=\"padding: 8px;\">Фамилия</th>\n                        <th style=\"padding: 8px;\">Email</th>\n                        <th style=\"padding: 8px;\">Действие</th>\n                    </tr>\n                </thead>\n                <tbody>\n                    ");
					for (var user : page.getUsers()) {
						jteOutput.writeContent("\n                        <tr>\n                            <td style=\"padding: 8px;\">");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(user.getId());
						jteOutput.writeContent("</td>\n                            <td style=\"padding: 8px;\">");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(user.getFirstName());
						jteOutput.writeContent("</td>\n                            <td style=\"padding: 8px;\">");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(user.getLastName());
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
