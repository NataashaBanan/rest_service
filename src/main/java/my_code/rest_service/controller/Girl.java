package my_code.rest_service.controller;

public class Girl {
    private String id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public Girl(String str, String number){
        this.name = str;
        this.id = number;
    }
}
