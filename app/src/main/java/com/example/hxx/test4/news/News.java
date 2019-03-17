package com.example.hxx.test4.news;

import java.util.List;

public class News {

    private int code;
    private String msg;
    private List<Newslist> newslist;
    public void setCode(int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public String getMsg() {
        return msg;
    }

    public void setNewslist(List<Newslist> newslist) {
        this.newslist = newslist;
    }
    public List<Newslist> getNewslist() {
        return newslist;
    }
    public class Newslist {


        private String ctime;
        private String title;
        private String description;
        private String picUrl;
        private String url;
        public void setCtime(String ctime) {
            this.ctime = ctime;
        }
        public String getCtime() {
            return ctime;
        }

        public void setTitle(String title) {
            this.title = title;
        }
        public String getTitle() {
            return title;
        }

        public void setDescription(String description) {
            this.description = description;
        }
        public String getDescription() {
            return description;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }
        public String getPicUrl() {
            return picUrl;
        }

        public void setUrl(String url) {
            this.url = url;
        }
        public String getUrl() {
            return url;
        }

    }
}
