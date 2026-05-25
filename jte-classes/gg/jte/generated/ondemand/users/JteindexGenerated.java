package gg.jte.generated.ondemand.users;
import org.example.hexlet.dto.users.UsersPage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "users/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,3,3,5,5,6,6,6,10,10,12,12,24,24,26,26,26,27,27,27,28,28,28,29,29,29,30,30,30,30,32,32,35,35,36,36,36,37,37,37,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UsersPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n        <h1>");
				jteOutput.setContext("h1", null);
				jteOutput.writeUserContent(page.getHeader());
				jteOutput.writeContent("</h1>\n        \n        <a href=\"/users/build\" style=\"display: inline-block; margin-bottom: 1rem; padding: 0.5rem 1rem; background-color: #28a745; color: #fff; text-decoration: none; border-radius: 4px;\">➕ Создать пользователя</a>\n        \n        ");
				if (page.getUsers().isEmpty()) {
					jteOutput.writeContent("\n            <p>Пока не добавлено ни одного пользователя</p>\n        ");
				} else {
					jteOutput.writeContent("\n            <table style=\"width: 100%; border-collapse: collapse;\">\n                <thead>\n                    <tr style=\"background-color: #f2f2f2;\">\n                        <th style=\"padding: 12px; text-align: left; border-bottom: 1px solid #ddd;\">ID</th>\n                        <th style=\"padding: 12px; text-align: left; border-bottom: 1px solid #ddd;\">Имя</th>\n                        <th style=\"padding: 12px; text-align: left; border-bottom: 1px solid #ddd;\">Фамилия</th>\n                        <th style=\"padding: 12px; text-align: left; border-bottom: 1px solid #ddd;\">Email</th>\n                        <th style=\"padding: 12px; text-align: left; border-bottom: 1px solid #ddd;\">Действие</th>\n                    </tr>\n                </thead>\n                <tbody>\n                    ");
					for (var user : page.getUsers()) {
						jteOutput.writeContent("\n                        <tr style=\"border-bottom: 1px solid #ddd;\">\n                            <td style=\"padding: 12px;\">");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(user.getId());
						jteOutput.writeContent("</td>\n                            <td style=\"padding: 12px;\">");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(user.getFirstName());
						jteOutput.writeContent("</td>\n                            <td style=\"padding: 12px;\">");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(user.getLastName());
						jteOutput.writeContent("</td>\n                            <td style=\"padding: 12px;\">");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(user.getEmail());
						jteOutput.writeContent("</td>\n                            <td style=\"padding: 12px;\"><a href=\"/users/");
						jteOutput.setContext("a", "href");
						jteOutput.writeUserContent(user.getId());
						jteOutput.setContext("a", null);
						jteOutput.writeContent("\" style=\"color: #007bff; text-decoration: none;\">Просмотр</a></td>\n                        </tr>\n                    ");
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
