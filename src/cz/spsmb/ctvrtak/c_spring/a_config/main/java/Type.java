package cz.spsmb.ctvrtak.c_spring.a_config.main.java;

public class Type {
    private String name;
    private String desc;
    private String extension;

    public Type() {
    }
    public Type(String name, String desc, String extension) {
        this.name = name;
        this.desc = desc;
        this.extension = extension;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getExtension() {
        return extension;
    }
}
