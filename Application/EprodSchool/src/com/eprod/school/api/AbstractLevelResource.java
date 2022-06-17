package com.eprod.school.api;

import com.eprod.school.data.Level;
import com.eprod.school.dao.LevelDao;

import java.util.List;

public abstract class AbstractLevelResource implements LevelResource {
    private final LevelDao levelDao;

    public AbstractLevelResource(LevelDao levelDao) {
        this.levelDao = levelDao;
    }

    @Override
    public List<Level> retrieveItems() {
        return this.levelDao.retrieveItems();
    }
}

