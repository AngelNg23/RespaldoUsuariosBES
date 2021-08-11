package com.telcel.dashboard.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Id;
import lombok.Data;

@Data
public class UsersBES implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "STAFFID")
    private String staffID;
    @Column(name = "STAFFNAME")
    private String staffName;
    @Column(name = "STAFFSTATE")
    private String staffState;
    @Column(name = "GROUPNAME")
    private Date groupName;
    @Column(name = "CONTEOGRUPO")
    private Date conteoGrupo;

}
