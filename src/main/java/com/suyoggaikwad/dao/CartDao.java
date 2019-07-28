package com.suyoggaikwad.dao;

import com.suyoggaikwad.dao.rowmappers.CartRowMapper;
import com.suyoggaikwad.dao.rowmappers.ItemRowMapper;
import com.suyoggaikwad.model.Cart;
import com.suyoggaikwad.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CartDao {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private void createDatasource(DataSource ds) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(ds);
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    public boolean addCartItem(List<Cart> cartItems) {
        SqlParameterSource sqlps = new MapSqlParameterSource("ID", cartItems.get(0).getUserId());
        String sqlQuery = "delete from cart where user_id = :ID";
        namedParameterJdbcTemplate.update(sqlQuery, sqlps);
        for(Cart cart: cartItems) {
            if(cart.getQuantity() > 0) {
                sqlps = new BeanPropertySqlParameterSource(cart);
                sqlQuery = "insert into cart values(:userId, :itemId, :itemName, :quantity, :price)";
                namedParameterJdbcTemplate.update(sqlQuery, sqlps);
            }
        }
        return true;
    }

    public List<Cart> getAllCartItems() {
        String sqlQuery = "select * from cart";
        List<Cart> list = namedParameterJdbcTemplate.query(sqlQuery, new CartRowMapper());
        return list;
    }

    public List<Cart> checkout(int userId) {
        SqlParameterSource sqlps = new MapSqlParameterSource("ID", userId);
        String sqlQuery = "select * from cart where user_id = :ID";
        List<Cart> cartList = namedParameterJdbcTemplate.query(sqlQuery, sqlps, new CartRowMapper());
        List<Item> items  = namedParameterJdbcTemplate.query("select * from item", new ItemRowMapper());
        Map<String, Integer> map = new HashMap<>();
        for(Item item: items) map.put(item.getName(), item.getQuantity());
        for (Cart cart: cartList) {
            if(map.containsKey(cart.getItemName())) {
                if(map.get(cart.getItemName()) >= cart.getQuantity()) {
                   continue;
                } else return new ArrayList<>();
            }
        }

        for(Cart cart: cartList) {
            int quantity = map.get(cart.getItemName()) - cart.getQuantity();
            sqlQuery = "update item set quantity = ? where id = ?";
            Object[] args = {quantity, cart.getItemId()};
            jdbcTemplate.update(sqlQuery, args);
        }
        sqlQuery = "delete from cart where user_id = :ID";
        namedParameterJdbcTemplate.update(sqlQuery, sqlps);
        return cartList;
    }
}
