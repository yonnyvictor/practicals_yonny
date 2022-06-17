package com.eprod.school.api.javalin;

import com.eprod.school.api.AbstractRegistrationResource;
import com.eprod.school.dao.RegistrationDao;
import com.eprod.school.data.Registration;
import io.javalin.Javalin;
import io.javalin.apibuilder.ApiBuilder;
import org.jetbrains.annotations.NotNull;

public class JavalinRegistrationResource extends AbstractRegistrationResource implements JavalinConfiguration{

    public JavalinRegistrationResource(RegistrationDao registrationDao) {
        super(registrationDao);
    }

    @Override
    public void configure(@NotNull Javalin http) {
        http.routes(() -> ApiBuilder.path("registrations", () -> {

            ApiBuilder.path("/year/{year}", () -> ApiBuilder.get(ctx -> {
                int year = Integer.parseInt(ctx.pathParam("year"));
                ctx.json(this.retrieveItems(year));
            }));

            ApiBuilder.path("/{action}", () -> ApiBuilder.post(ctx -> {
                Registration registration = ctx.bodyAsClass(Registration.class);
                switch (ctx.pathParam("action")) {
                    case "create": {
                        ctx.json(this.createItem(registration));
                        break;
                    }
                    case "update": {
                        ctx.json(this.updateItem(registration));
                        break;
                    }
                    case "delete": {
                        ctx.json(this.deleteItem(registration));
                    }
                }
            }));
        })).exception(Exception.class, (e, ctx) -> ctx.json(new ExceptionWrapper(e)));
    }
}
