package gaozhu.francis.entity;

import java.util.Date;

public class Manager
{
    private String id;
    private String name;
    private String rid;
    private Date birthday;
    private String loginname;
    private String loginpwd;
    private String state;
    private Role role;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Date getBirthday()
    {
        return birthday;
    }

    public void setBirthday(Date birthday)
    {
        this.birthday = birthday;
    }

    public String getLoginname()
    {
        return loginname;
    }

    public void setLoginname(String loginname)
    {
        this.loginname = loginname;
    }

    public String getLoginpwd()
    {
        return loginpwd;
    }

    public void setLoginpwd(String loginpwd)
    {
        this.loginpwd = loginpwd;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }


    public String getRid()
    {
        return rid;
    }

    public void setRid(String rid)
    {
        this.rid = rid;
    }

    public Role getRole()
    {
        return role;
    }

    public void setRole(Role role)
    {
        this.role = role;
    }
}
