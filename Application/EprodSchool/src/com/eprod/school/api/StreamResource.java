package com.eprod.school.api;

import com.eprod.school.data.Stream;
import com.eprod.school.data.Response;

import java.util.List;

import org.jetbrains.annotations.NotNull;

public interface StreamResource extends Resource{
    Response createItem(@NotNull Stream stream);

    Response updateItem(@NotNull Stream stream);

    Response deleteItem(@NotNull Stream stream);

    List<Stream> retrieveItems();
}

