package gaozhu.francis.entity;

import java.util.List;

/**
 * 功能分组实体类
 * @author FrancisGaozhu
 * @date 2018-07-04
 */
public class PrivGroup
{

    private String id;

    private String text;

    private int orderno;

    private List<Priv> privs;

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

    public int getOrderno()
    {
        return orderno;
    }

    public void setOrderno(int orderno)
    {
        this.orderno = orderno;
    }

    public List<Priv> getPrivs()
    {
        return privs;
    }

    public void setPrivs(List<Priv> privs)
    {
        this.privs = privs;
    }
}
