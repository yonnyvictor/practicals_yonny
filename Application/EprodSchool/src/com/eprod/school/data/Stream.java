package com.eprod.school.data;

public class Stream {
    private int id = 0;
    private String name = "";

    public Stream() {
    }

    public Stream(int id, String name) {
        this.id = id;
        this.name = name;
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

    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Stream stream = (Stream)o;
        if (this.getId() != stream.getId()) {
            return false;
        }
        return this.getName().equals(stream.getName());
    }

    public int hashCode() {
        int result = String.valueOf(this.getId()).hashCode();
        result = 41 * result + this.getName().hashCode();
        return result;
    }
}

