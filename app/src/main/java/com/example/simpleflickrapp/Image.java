package com.example.simpleflickrapp;

public class Image {
    private String id;
    private String name;
    private String password;
    private String url;


    public Image() {
    }

    public Image(String id, String name, String password, String url) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
