package com.eprod.school.api;

import com.eprod.school.data.Level;

import java.util.List;

public interface LevelResource extends Resource {
    List<Level> retrieveItems();
}

