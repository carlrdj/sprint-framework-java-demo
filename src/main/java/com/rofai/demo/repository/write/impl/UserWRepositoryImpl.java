package com.rofai.demo.repository.write.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import com.rofai.demo.domain.User;
import com.rofai.demo.repository.read.UserRRepository;
import com.rofai.demo.repository.write.UserWRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserWRepositoryImpl implements UserWRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final Logger logger = LoggerFactory.getLogger(UserWRepositoryImpl.class);

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UUID createUser(User user) {
        UUID idGenerated = UUID.randomUUID();
        String sql = "INSERT INTO administration.user " + 
                    "(ui_iduser, vc_name, vc_surname) " + 
                    "VALUES(?, ?, ?)";

        try {
            jdbcTemplate.update(sql, new Object[] { 
                idGenerated, 
                user.getVc_name(), 
                user.getVc_surname() 
            });
            return null;
        } catch (Exception e) {
            logger.error("Exception:" + e);
            return idGenerated;
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateUser(User user) {
		String SQL = "UPDATE administration.user "+
                    "SET vc_name = ?, vc_surname = ?" +
                    "WHERE ui_iduser = ?";
		try {
            jdbcTemplate.update(SQL, new Object[] {
                user.getVc_name(), 
                user.getVc_surname(),
                user.getUi_iduser()
            });
            return true;
		} catch (Exception e) {
            logger.error("Exception:" + e);
			return false;
		}
    }
}