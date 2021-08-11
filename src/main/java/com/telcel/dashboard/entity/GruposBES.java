/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telcel.dashboard.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Id;
import lombok.Data;

/**
 *
 * @author Angel
 */

@Data
public class GruposBES implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "GROUPID")
    private String groupID;
    @Column(name = "GROUPNAME")
    private String groupName;
    
}
