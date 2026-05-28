package gg.jte.generated.ondemand.layout;
import gg.jte.Content;
public final class JtepageGenerated {
	public static final String JTE_NAME = "layout/page.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,23,23,42,42,42,52,52,52,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Content content) {
		jteOutput.writeContent("\n<!DOCTYPE html>\n<html lang=\"ru\">\n<head>\n    <meta charset=\"utf-8\">\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n    <title>Hexlet Javalin</title>\n    <style>\n        * { margin: 0; padding: 0; box-sizing: border-box; }\n        body { font-family: Arial, sans-serif; line-height: 1.6; background-color: #f4f4f4; }\n        .container { max-width: 1200px; margin: 0 auto; padding: 20px; }\n        .header { background-color: #333; color: #fff; padding: 1rem 0; margin-bottom: 2rem; }\n        .header .container { display: flex; justify-content: space-between; align-items: center; }\n        .header h1 { font-size: 1.5rem; }\n        .header a { color: #fff; text-decoration: none; margin-left: 1rem; }\n        .header a:hover { text-decoration: underline; }\n        .main-content { background-color: #fff; border-radius: 8px; padding: 20px; box-shadow: 0 2px 4px rgba(0,0,0,0.1); min-height: 70vh; }\n        .footer { background-color: #333; color: #fff; text-align: center; padding: 1rem 0; margin-top: 2rem; }\n        .footer a { color: #fff; text-decoration: none; }\n        .footer a:hover { text-decoration: underline; }\n        \n        ");
		jteOutput.writeContent("\n        .alert { padding: 12px; border-radius: 4px; margin-bottom: 20px; }\n        .alert-success { background-color: #d4edda; color: #155724; border: 1px solid #c3e6cb; }\n        .alert-error { background-color: #f8d7da; color: #721c24; border: 1px solid #f5c6cb; }\n    </style>\n</head>\n<body>\n    <div class=\"header\">\n        <div class=\"container\">\n            <h1>Hexlet Javalin</h1>\n            <nav>\n                <a href=\"/\">Главная</a>\n                <a href=\"/users\">Пользователи</a>\n                <a href=\"/courses\">Курсы</a>\n            </nav>\n        </div>\n    </div>\n    <div class=\"container\">\n        <div class=\"main-content\">\n            ");
		jteOutput.setContext("div", null);
		jteOutput.writeUserContent(content);
		jteOutput.writeContent("\n        </div>\n    </div>\n    <div class=\"footer\">\n        <div class=\"container\">\n            <p>© 2025 Hexlet Javalin | <a href=\"https://github.com/bobbidenisleo-glitch\" target=\"_blank\">Мой GitHub</a></p>\n        </div>\n    </div>\n</body>\n</html>\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Content content = (Content)params.get("content");
		render(jteOutput, jteHtmlInterceptor, content);
	}
}
