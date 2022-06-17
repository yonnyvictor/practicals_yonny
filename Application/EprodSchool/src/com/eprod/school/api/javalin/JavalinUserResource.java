package com.eprod.school.api.javalin;

import com.eprod.school.api.AbstractUserResource;
import com.eprod.school.api.Resource;
import com.eprod.school.dao.UserDao;
import com.eprod.school.data.User;
import io.javalin.Javalin;
import io.javalin.apibuilder.ApiBuilder;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;

public class JavalinUserResource extends AbstractUserResource implements JavalinConfiguration {

    public JavalinUserResource(@NotNull UserDao userDao) {
        super(userDao);
    }

    @Override
    public void configure(@NotNull Javalin http) {
        http.routes(() -> ApiBuilder.path("users", () -> {
            ApiBuilder.get(ctx -> ctx.json(this.retrieveItems()));

            ApiBuilder.path("/login", () -> ApiBuilder.post(ctx -> {
                User user = ctx.bodyAsClass(User.class);
                Optional<User> optional = this.retrieveItem(user.getUsername(), user.getPassword());
                if (optional.isPresent()) {
                    ctx.json(optional.get());
                } else {
                    ctx.result("{}");
                }
            }));

            ApiBuilder.path("/{action}", () -> ApiBuilder.post(ctx -> {
                User user = ctx.bodyAsClass(User.class);
                switch (ctx.pathParam("action")) {
                    case "create": {
                        ctx.json(this.createItem(user));
                        break;
                    }
                    case "update": {
                        ctx.json(this.updateItem(user));
                    }
                }
            }));

        })).exception(Exception.class, (e, ctx) -> ctx.json(new Resource.ExceptionWrapper(e)));
    }
}

