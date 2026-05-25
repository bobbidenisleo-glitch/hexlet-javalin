package gg.jte.generated.ondemand.courses;
import org.example.hexlet.dto.courses.CoursePage;
public final class JteshowGenerated {
	public static final String JTE_NAME = "courses/show.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,7,7,7,7,11,11,11,12,12,12,17,17,17,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, CoursePage page) {
		jteOutput.writeContent("\n<!doctype html>\n<html lang=\"ru\">\n<head>\n    <meta charset=\"utf-8\">\n    <title>");
		jteOutput.setContext("title", null);
		jteOutput.writeUserContent(page.getCourse().getName());
		jteOutput.writeContent("</title>\n</head>\n<body>\n    <main>\n        <h1>");
		jteOutput.setContext("h1", null);
		jteOutput.writeUserContent(page.getCourse().getName());
		jteOutput.writeContent("</h1>\n        <p>");
		jteOutput.setContext("p", null);
		jteOutput.writeUserContent(page.getCourse().getDescription());
		jteOutput.writeContent("</p>\n        <a href=\"/courses\">← Назад к списку курсов</a>\n    </main>\n</body>\n</html>\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		CoursePage page = (CoursePage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
