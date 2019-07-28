package com.suyoggaikwad.service;

import com.suyoggaikwad.dao.ItemDao;
import com.suyoggaikwad.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private ItemDao itemDao;

    @Autowired
    public ItemService(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    public List<Item> getItems() {
        return itemDao.getItems();
    }

}
