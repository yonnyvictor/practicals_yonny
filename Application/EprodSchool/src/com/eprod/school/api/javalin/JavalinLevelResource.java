package com.eprod.school.api.javalin;

import com.eprod.school.api.AbstractLevelResource;
import com.eprod.school.dao.LevelDao;
import io.javalin.Javalin;
import io.javalin.apibuilder.ApiBuilder;
import org.jetbrains.annotations.NotNull;

public class JavalinLevelResource extends AbstractLevelResource implements JavalinConfiguration {

    public JavalinLevelResource(LevelDao levelDao) {
        super(levelDao);
    }

    @Override
    public void configure(@NotNull Javalin http) {
        http.routes(() -> ApiBuilder.path("levels", () -> {
            ApiBuilder.get(ctx -> ctx.json(this.retrieveItems()));

        })).exception(Exception.class, (e, ctx) -> ctx.json(new ExceptionWrapper(e)));
    }
}

