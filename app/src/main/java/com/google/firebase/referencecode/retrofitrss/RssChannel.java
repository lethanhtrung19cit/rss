package com.google.firebase.referencecode.retrofitrss;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "channel", strict = false)
public class RssChannel
{
    @Element
    private String title;

    @Element
    private RssImage image;

    //@ElementList(inline = true, required = false)
    //public List<RssItem> item;

    @Override
    public String toString() {
        return "Channel [image=" + getImage() + "]";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public RssImage getImage() {
        return image;
    }

    public void setImage(RssImage image) {
        this.image = image;
    }
}


