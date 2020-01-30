package com.cristianruizblog.loginSecurity.entity;

import javax.persistence.*;


@Entity
public class ShortSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    String definition;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }


}
