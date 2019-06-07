package gaozhu.francis.entity;

public class Priv
{
    private String id;
    private String gid;
    private String text;
    private String url;
    private int orderno;
    private String groupName;


    @Override
    public boolean equals(Object obj)
    {
        Priv p = (Priv)obj;
        return this.id.equals(p.getId());
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public int getOrderno()
    {
        return orderno;
    }

    public void setOrderno(int orderno)
    {
        this.orderno = orderno;
    }

    public String getGid()
    {
        return gid;
    }

    public void setGid(String gid)
    {
        this.gid = gid;
    }

    public String getGroupName()
    {
        return groupName;
    }

    public void setGroupName(String groupName)
    {
        this.groupName = groupName;
    }
}
