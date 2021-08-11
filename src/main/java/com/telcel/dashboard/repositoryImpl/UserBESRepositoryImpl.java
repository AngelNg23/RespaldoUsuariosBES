/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telcel.dashboard.repositoryImpl;

import com.telcel.dashboard.entity.GruposBES;
import com.telcel.dashboard.entity.UsersBES;

import com.telcel.dashboard.repository.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Angel
 */
@Repository
public class UserBESRepositoryImpl implements UsersBESRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<UsersBES> findAllUsersWithGroup(String fechaFin) {

        StringBuilder sql = new StringBuilder();

        sql.append("SELECT sbi.staffid, sbi.staffname, sbi.staffstate, gi.groupname, COUNT(gi.groupname) AS conteoGrupo ");
        sql.append("FROM ICDPUB.T_UCP_STAFFBASICINFO sbi ");
        sql.append("LEFT JOIN ICDPUB.T_UCP_STAFFROLE sr ");
        sql.append("ON sr.STAFFID = sbi.STAFFID ");
        sql.append("LEFT JOIN ICDPUB.T_UCP_ROLE r ");
        sql.append("ON r.ROLEID = sr.ROLEID ");
        sql.append("LEFT JOIN ICDPUB.T_UCP_GROUPSTAFF gs ");
        sql.append("ON gs.STAFFID = sbi.STAFFID ");
        sql.append("LEFT JOIN ICDPUB.T_UCP_GROUPINFO gi ");
        sql.append("ON gi.GROUPID = gs.GROUPID ");
        sql.append("WHERE gi.groupname IN ('CACs R9', ");
        sql.append("'CACs Regionales R1', ");
        sql.append("'CACs Regionales R2', ");
        sql.append("'CACs Regionales R4', ");
        sql.append("'CACs Regionales R5', ");
        sql.append("'CACs Regionales R8', ");
        sql.append("'DEPTO ARQ DE INTEGRACION', ");
        sql.append("'DEPTO SISTEMAS DE ACTIVACIONES POSTPAGO DISTRIB', ");
        sql.append("'Mesa de Control Portabilidad R2', ");
        sql.append("'Telefónico R9', ");
        sql.append("'Telefónico Regionales R3', ");
        sql.append("'Telefónico Regionales R4', ");
        sql.append("'Telefónico Regionales R7' ");
        sql.append(") ");
        sql.append("GROUP BY sbi.staffid, sbi.staffname, sbi.staffstate, gi.groupname ");
        sql.append("ORDER BY sbi.staffid ASC ");

        List<UsersBES> ttSinAtencion = namedParameterJdbcTemplate.query(sql.toString(),
                new BeanPropertyRowMapper(UsersBES.class));
        return ttSinAtencion;
    }

    @Override
    public List<GruposBES> findAllGroupsInBES() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT GROUPID, GROUPNAME FROM ICDPUB.T_UCP_GROUPINFO ");
        sql.append("WHERE GROUPTYPEID = 000104 ");
        sql.append("ORDER BY GROUPNAME ASC  ");
        Map<String, String> paramMap = new HashMap<String, String>();       
        return namedParameterJdbcTemplate.query(sql.toString(), paramMap, new BeanPropertyRowMapper(GruposBES.class));
    }

}
