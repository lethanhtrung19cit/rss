package com.google.firebase.referencecode.retrofitrss;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "image", strict = false)
public class RssImage
{
    @Element
    private String url;

    @Element
    private String title;

    @Element
    private String link;

    @Override
    public String toString() {
        return "RssImage [url=" + getUrl() + ", title=" + getTitle() + ", link=" + getLink() + "]";
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
