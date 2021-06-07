package com.google.firebase.referencecode.retrofitrss;

import java.util.List;

public class RssRoot {
    public String status ;
    public RssFeed feed ;
    public List<RssItem> items ;

    public RssRoot(String status, RssFeed feed, List<RssItem> items) {
        this.status = status;
        this.feed = feed;
        this.items = items;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public RssFeed getFeed() {
        return feed;
    }

    public void setFeed(RssFeed feed) {
        this.feed = feed;
    }

    public List<RssItem> getItems() {
        return items;
    }

    public void setItems(List<RssItem> items) {
        this.items = items;
    }
}
