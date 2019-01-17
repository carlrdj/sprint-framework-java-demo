package com.rofai.demo.repository.read.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import com.rofai.demo.domain.User;
import com.rofai.demo.repository.read.UserRRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRRepositoryImpl implements UserRRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
	private static final Logger logger = LoggerFactory.getLogger(UserRRepositoryImpl.class);

    @Override
    public User getUser(UUID ui_iduser) {
        User user = new User();
        String sql = "SELECT ui_iduser, vc_name, vc_surname FROM administration.user WHERE ui_iduser = ?";
        try {
            user = jdbcTemplate.queryForObject(sql, new Object[] { ui_iduser }, this::mapDataPersona);
        } catch (EmptyResultDataAccessException e) {
            logger.error("SQLException: ", e);
        }
        return user;
    }

    @Override
    public List<User> getUsers() {
        List<User> listUser = null;
        String sql = "SELECT ui_iduser, vc_name, vc_surname FROM administration.user";
        try {
            listUser = jdbcTemplate.query(sql, new Object[] {}, this::mapDataPersona);
        } catch (EmptyResultDataAccessException e) {
            logger.error("SQLException: ", e);
        }
        return listUser;
	}    

    /**
     * CRUEDA - 17-01-2019 - Mapping user table
     * Description: Get data user table
     */
    private User mapDataPersona(ResultSet rs, int i) throws SQLException {
        User user = new User();
        user.setUi_iduser(UUID.fromString(rs.getString("ui_iduser")));
        user.setVc_name(rs.getString("vc_name"));
        user.setVc_surname(rs.getString("vc_surname"));
        return user;
    }
}