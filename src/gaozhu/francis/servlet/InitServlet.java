package gaozhu.francis.servlet;

import gaozhu.francis.constants.AppStaticData;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class InitServlet extends HttpServlet
{



    @Override
    public void init() throws ServletException
    {
        super.init();
        try
        {
            AppStaticData.reloadAll();
        }
        catch(Exception ex)
        {

        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
