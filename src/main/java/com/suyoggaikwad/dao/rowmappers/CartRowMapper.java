package com.suyoggaikwad.dao.rowmappers;

import com.suyoggaikwad.model.Cart;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CartRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        Cart cart = new Cart();
        cart.setUserId(rs.getInt("user_id"));
        cart.setItemId(rs.getInt("item_id"));
        cart.setQuantity(rs.getInt("quantity"));
        cart.setItemName(rs.getString("item_name"));
        cart.setPrice(rs.getDouble("price"));
        return cart;
    }
}
