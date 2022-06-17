package com.eprod.school.api.javalin;

import com.eprod.school.api.AbstractStreamResource;
import com.eprod.school.data.Stream;
import com.eprod.school.dao.StreamDao;
import io.javalin.Javalin;
import io.javalin.apibuilder.ApiBuilder;
import org.jetbrains.annotations.NotNull;

public class JavalinStreamResource extends AbstractStreamResource implements JavalinConfiguration {
    public JavalinStreamResource(StreamDao streamDao) {
        super(streamDao);
    }

    @Override
    public void configure(@NotNull Javalin http) {
        http.routes(() -> ApiBuilder.path("streams", () -> {
            ApiBuilder.get(ctx -> ctx.json(this.retrieveItems()));

            ApiBuilder.path("/{action}", () -> ApiBuilder.post(ctx -> {
                Stream stream = ctx.bodyAsClass(Stream.class);
                switch (ctx.pathParam("action")) {
                    case "create": {
                        ctx.json(this.createItem(stream));
                        break;
                    }
                    case "update": {
                        ctx.json(this.updateItem(stream));
                        break;
                    }
                    case "delete": {
                        ctx.json(this.deleteItem(stream));
                    }
                }
            }));
        })).exception(Exception.class, (e, ctx) -> ctx.json(new ExceptionWrapper(e)));
    }
}

