package my_code.rest_service.controller;

import javax.persistence.*;

@Entity
public class Girl {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @Column(name = "name")
    private String name;

    public Girl() { }

    public Girl(String name){ this.name = name; }

    public Integer getId() { return id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
