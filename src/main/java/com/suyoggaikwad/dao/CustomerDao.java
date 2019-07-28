package com.suyoggaikwad.dao;

import com.suyoggaikwad.dao.rowmappers.CustomerRowMapper;
import com.suyoggaikwad.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class CustomerDao {

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private void createDatasource(DataSource ds) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(ds);
    }

    public boolean registerCustomer(Customer customer) {
        SqlParameterSource sqlps = new BeanPropertySqlParameterSource(customer);
        String sqlQuery = "select * from customer where username = :username";
        try {
            Customer temp = (Customer) jdbcTemplate.queryForObject(sqlQuery, sqlps, new CustomerRowMapper());
        } catch (EmptyResultDataAccessException e) {
            sqlQuery = "insert into customer(username, password) values(:username, :password)";
            return jdbcTemplate.update(sqlQuery, sqlps) == 1;
        }
        return false;
    }

    public int validateCustomer(Customer customer) {
        SqlParameterSource sqlps = new BeanPropertySqlParameterSource(customer);
        String sqlQuery = "select * from customer where username = :username && password = :password";
        Customer temp = null;
        try {
            temp = (Customer) jdbcTemplate.queryForObject(sqlQuery, sqlps, new CustomerRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return -1;
        }
        return temp.getId();
    }


}
