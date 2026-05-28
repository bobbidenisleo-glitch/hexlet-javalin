package org.example.hexlet.controller;

import io.javalin.http.Context;
import static io.javalin.rendering.template.TemplateUtil.model;

public class CoursesController {

    public static void index(Context ctx) {
        ctx.render("courses/index.jte");
    }
}
