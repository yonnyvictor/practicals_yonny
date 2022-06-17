package com.eprod.school.api.javalin;

import com.eprod.school.api.AbstractStudentResource;
import com.eprod.school.dao.StudentDao;
import com.eprod.school.data.Student;
import io.javalin.Javalin;
import io.javalin.apibuilder.ApiBuilder;
import org.jetbrains.annotations.NotNull;

public class JavalinStudentResource extends AbstractStudentResource implements JavalinConfiguration{

    public JavalinStudentResource(StudentDao studentDao) {
        super(studentDao);
    }

    @Override
    public void configure(@NotNull Javalin http) {
        http.routes(() -> ApiBuilder.path("students", () -> {
            ApiBuilder.get(ctx -> ctx.json(this.retrieveItems()));

            ApiBuilder.path("/{action}", () -> ApiBuilder.post(ctx -> {
                Student student = ctx.bodyAsClass(Student.class);
                switch (ctx.pathParam("action")) {
                    case "create": {
                        ctx.json(this.createItem(student));
                        break;
                    }
                    case "update": {
                        ctx.json(this.updateItem(student));
                        break;
                    }
                    case "delete": {
                        ctx.json(this.deleteItem(student));
                    }
                }
            }));
        })).exception(Exception.class, (e, ctx) -> ctx.json(new ExceptionWrapper(e)));
    }
}
