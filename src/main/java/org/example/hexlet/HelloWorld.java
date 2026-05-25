package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import static io.javalin.rendering.template.TemplateUtil.model;

import org.example.hexlet.model.Course;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;

import java.util.ArrayList;
import java.util.List;

public class HelloWorld {
    public static void main(String[] args) {
        // Создаём тестовые данные
        List<Course> courses = new ArrayList<>();
        courses.add(new Course(1L, "Java: Введение в ООП", "Изучите основы объектно-ориентированного программирования на Java"));
        courses.add(new Course(2L, "Java: Spring Boot", "Создавайте веб-приложения с помощью Spring Boot"));
        courses.add(new Course(3L, "JavaScript: React", "Освойте современную разработку интерфейсов на React"));
        
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });
        
        // Главная страница (список курсов)
        app.get("/courses", ctx -> {
            var header = "Курсы по программированию";
            var page = new CoursesPage(courses, header);
            ctx.render("index.jte", model("page", page));
        });
        
        // Страница конкретного курса
        app.get("/courses/{id}", ctx -> {
            Long id = Long.parseLong(ctx.pathParam("id"));
            Course course = courses.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
            
            if (course == null) {
                ctx.status(404).result("Курс не найден");
                return;
            }
            
            var page = new CoursePage(course);
            ctx.render("courses/show.jte", model("page", page));
        });
        
        app.start(7070);
    }
}
