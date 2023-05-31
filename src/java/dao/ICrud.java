/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;

/**
 *
 * @author Admin
 * @param <U>: type of id
 * @param <V>: type of object
 */
public interface ICrud <U,V>{
    List<V> read();
    V details(U id);
    void create(V newItem);
    void update(V editedItem);
    void delete(U id);
}
