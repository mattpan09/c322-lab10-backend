package edu.iu.habahram.ducksservice.model;

import jakarta.persistence.*;

@Entity
@Table(schema = "ducks")
public final class DuckData {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public DuckData(int id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public DuckData() {
    }

    public String toLine() {
        return String.format("%1$s,%2$s,%3$s", getId(), getName(), getType());
    }

    public String toLine(int id) {
        return String.format("%1$s,%2$s,%3$s", id, getName(), getType());
    }

    public static DuckData fromLine(String line) {
        String[] tokens = line.split(",");
        return new DuckData(Integer.parseInt(tokens[0]), tokens[1], tokens[2]);
    }

}
