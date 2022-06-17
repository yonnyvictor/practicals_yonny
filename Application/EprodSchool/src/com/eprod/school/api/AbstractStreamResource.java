package com.eprod.school.api;

import com.eprod.school.data.Stream;
import com.eprod.school.dao.StreamDao;

import java.util.List;

import com.eprod.school.data.Response;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractStreamResource implements StreamResource {
    private final StreamDao streamDao;

    public AbstractStreamResource(StreamDao streamDao) {
        this.streamDao = streamDao;
    }


    @Override
    public Response createItem(@NotNull Stream stream) {
        return this.streamDao.createItem(stream);
    }

    @Override
    public Response updateItem(@NotNull Stream stream) {
        return this.streamDao.updateItem(stream);
    }

    @Override
    public Response deleteItem(@NotNull Stream stream) {
        return this.streamDao.deleteItem(stream);
    }

    @Override
    public List<Stream> retrieveItems() {
        return this.streamDao.retrieveItems();
    }
}

