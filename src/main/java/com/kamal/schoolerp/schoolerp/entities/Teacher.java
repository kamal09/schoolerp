package com.kamal.schoolerp.schoolerp.entities;

import javax.persistence.*;

/**
 * Created by kamal.hossain1542 on 3/13/2019.
 */

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    private Integer version;

    @Column(name = "teacher_id", length = 10)
    private String teacherId;

    @Column(name = "name", length = 50)
    private String Name;

    public Teacher() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
