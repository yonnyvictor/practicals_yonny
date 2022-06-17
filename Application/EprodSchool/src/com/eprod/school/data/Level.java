package com.eprod.school.data;

public class Level {
    private int id;
    private String name;
    private String category;

    public Level() {
    }

    public Level(int id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Level level = (Level)o;
        if (this.getId() != level.getId()) {
            return false;
        }
        return this.getName().equals(level.getName());
    }

    public int hashCode() {
        int result = String.valueOf(this.getId()).hashCode();
        result = 481 * result + this.getName().hashCode();
        return result;
    }
}

