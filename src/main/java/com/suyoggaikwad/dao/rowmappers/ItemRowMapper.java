package com.suyoggaikwad.dao.rowmappers;

import com.suyoggaikwad.model.Item;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        Item item = new Item();
        item.setId(rs.getInt("id"));
        item.setName(rs.getString("name"));
        item.setQuantity(rs.getInt("quantity"));
        item.setPrice(rs.getDouble("price"));
        item.setQuantityEntered(rs.getInt("quantity_entered"));
        item.setPriceIncurred(rs.getDouble("price_incurred"));
        return item;
    }
}
