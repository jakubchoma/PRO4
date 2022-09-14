package cz.spsmb.ctvrtak.c_spring_konfigurace.main.java;

import java.util.Date;

public class Doc {
    private String name;
    private String location;
    private Type type;
    private Date created;
    private Date modified;

    public Doc() {
    }
    public Doc(String name, Type type, String location) {
        this.name = name;
        this.location = location;
        this.type = type;
        this.created = new Date();
        this.modified = this.created;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }


}
