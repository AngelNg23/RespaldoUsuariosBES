/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telcel.dashboard.repository;

import com.telcel.dashboard.entity.GruposBES;
import java.util.List;
import com.telcel.dashboard.entity.UsersBES;

/**
 *
 * @author Angel
 */
public interface UsersBESRepository {

    public List<UsersBES> findAllUsersWithGroup(String fechaFin);
    
    public List<GruposBES> findAllGroupsInBES();
    
}