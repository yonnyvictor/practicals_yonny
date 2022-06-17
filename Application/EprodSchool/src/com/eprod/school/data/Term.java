package com.eprod.school.data;

public class Term {
    private int id = 0;
    private String name = "";

    public Term() {
    }

    public Term(int id, String name) {
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
        Term term = (Term)o;
        if (this.getId() != term.getId()) {
            return false;
        }
        return this.getName().equals(term.getName());
    }

    public int hashCode() {
        int result = String.valueOf(this.getId()).hashCode();
        result = 141 * result + this.getName().hashCode();
        return result;
    }
}
