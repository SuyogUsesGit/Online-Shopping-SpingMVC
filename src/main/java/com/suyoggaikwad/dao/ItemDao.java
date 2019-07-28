package com.suyoggaikwad.dao;

import com.suyoggaikwad.dao.rowmappers.ItemRowMapper;
import com.suyoggaikwad.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class ItemDao {

    NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public void createDatasource(DataSource ds) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(ds);
    }

    public List<Item> getItems() {
        String sqlQuery = "select * from item where quantity > 0";
        List<Item> items = jdbcTemplate.query(sqlQuery, new ItemRowMapper());
        return items;
    }

}
