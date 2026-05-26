package gg.jte.generated.ondemand;
import org.example.hexlet.dto.MainPage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,13,13,13,18,18,21,21,21,30,30,30,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, MainPage page) {
		jteOutput.writeContent("\n<!DOCTYPE html>\n<html lang=\"ru\">\n<head>\n    <meta charset=\"utf-8\">\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n    <title>Hello Hexlet!</title>\n</head>\n<body>\n    <main>\n        <h1>Привет, Хекслет!</h1>\n        ");
		if (!page.isVisited()) {
			jteOutput.writeContent("\n            <div style=\"background-color: #e8f4f8; border: 1px solid #bce8f1; padding: 15px; margin: 20px 0; border-radius: 5px;\">\n                Это сообщение показывается только один раз. \n                Если вы хотите увидеть его снова, сотрите куки в панели разработчика.\n            </div>\n        ");
		}
		jteOutput.writeContent("\n        \n        <div>\n            <p>Куки \"visited\": ");
		jteOutput.setContext("p", null);
		jteOutput.writeUserContent(page.isVisited() ? "установлена (вы уже посещали сайт)" : "не установлена (первое посещение)");
		jteOutput.writeContent("</p>\n        </div>\n        \n        <div style=\"margin-top: 20px;\">\n            <a href=\"/\">Обновить страницу</a>\n        </div>\n    </main>\n</body>\n</html>\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		MainPage page = (MainPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
