package com.example.hxx.test4.user;

public class User {

    private int status;
    private String info;
    private Data data;
    public void setStatus(int status) {
        this.status = status;
    }
    public int getStatus() {
        return status;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    public String getInfo() {
        return info;
    }

    public void setData(Data data) {
        this.data = data;
    }
    public Data getData() {
        return data;
    }
    public class Data {

        private int id;
        private String username;
        private String password;
        private String avatar;
        private String token;
        public void setId(int id) {
            this.id = id;
        }
        public int getId() {
            return id;
        }

        public void setUsername(String username) {
            this.username = username;
        }
        public String getUsername() {
            return username;
        }

        public void setPassword(String password) {
            this.password = password;
        }
        public String getPassword() {
            return password;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }
        public String getAvatar() {
            return avatar;
        }

        public void setToken(String token) {
            this.token = token;
        }
        public String getToken() {
            return token;
        }

    }
}
