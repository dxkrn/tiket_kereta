package com.tiket_kereta;

import java.util.LinkedHashMap;

public class User {

    private LinkedHashMap<String, String> users = new LinkedHashMap<String, String>();
    private String username, password;

    public void addUser(String username, String password) {
        users.put(username, password);
    }

    public Boolean isContains(String username) {
        return users.containsKey(username);
    }

    public String getPassword(String username) {
        return users.get(username);
    }

    public int getSize() {
        return users.size();
    }

    public Boolean isEmpty() {
        return users.isEmpty();
    }

    public Boolean isNotEmpty() {
        return !(users.isEmpty());
    }


}
