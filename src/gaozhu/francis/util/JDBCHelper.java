package gaozhu.francis.util;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

/**
 * JDBC操作帮助类
 *
 *
 */
public final class JDBCHelper
{

    /** 配置文件路径 */
    private static final String DB_CONFIG_FILE_PATH = "/db_conf.properties";
    /** 登陆名称Key */
    private static final String DB_LOGIN_NAME_TAG = "login_name";
    /** 登陆密码Key */
    private static final String DB_LOGIN_PWD_TAG = "login_pwd";
    /** 数据库IP地址Key */
    private static final String DB_IP_TAG = "db_ip";
    /** 数据库访问端口Key */
    private static final String DB_PORT_TAG = "db_port";
    /** 数据库名称Key */
    private static final String DB_NAME_TAG = "db_name";
    /** 数据库访问端口Key */
    private static final String DB_DRIVER_TAG = "db_driver";
    /** 数据库类型Key */
    private static final String DB_TYPE_TAG = "db_type";

    /** 数据库连接字符串 */
    private static String DB_URL;
    /** 数据库连接用户名 */
    private static String DB_LOGIN_NAME;
    /** 数据库连接登陆密码 */
    private static String DB_LOGIN_PWD;


    private static Logger log = Logger.getLogger(JDBCHelper.class);


    /**
     * 生成按照时间开始的20位随机主键
     * @return
     */
    public static final String getPKL20()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String result = sdf.format(new Date());
        Random ran = new Random();
        while(20 > result.length())
        {
            result += ran.nextInt(10);
        }
        return result;
    }



    /**
     * 初始化块
     */
    static
    {

        try
        {
            InputStream is = JDBCHelper.class.getResourceAsStream(DB_CONFIG_FILE_PATH);
            Properties prop = new Properties();
            prop.load(is);
            DB_LOGIN_NAME = prop.getProperty(DB_LOGIN_NAME_TAG);
            DB_LOGIN_PWD = prop.getProperty(DB_LOGIN_PWD_TAG);
            DB_URL = getConnStr(prop.getProperty(DB_IP_TAG), prop.getProperty(DB_PORT_TAG), prop.getProperty(DB_NAME_TAG), prop.getProperty(DB_TYPE_TAG));
            Class.forName(prop.getProperty(DB_DRIVER_TAG));
        }
        catch (ClassNotFoundException ex)
        {
            log.error("jar包没有找到", ex);
        }
        catch (IOException e)
        {
            log.error("属性文件不存在", e);
        }

    }


    /**
     * 组装数据库连接字符串
     * @param ip IP地址
     * @param port 端口号
     * @param dbName 数据库名称
     * @param dbType 数据库类型
     * @return 数据库连接字符串组装结果
     */
    public static final String getConnStr(String ip, String port, String dbName, String dbType)
    {
        StringBuffer sbConnStr = new StringBuffer();

        switch (dbType)
        {
            case "oracle":
                sbConnStr.append("jdbc:oracle:thin:@").append(ip).append(":").append(port).append(":").append(dbName);
                break;

            case "mysql":
                sbConnStr.append("jdbc:mysql://").append(ip).append(":").append(port).append("/").append(dbName);
                break;

            case "sqlservler":
                break;

            default:
                break;
        }

        return sbConnStr.toString();
    }


    /**
     * 执行增删改，等“写”相关的操作
     * @param sql
     * @param params
     * @return
     */
    public static final int executeUpdate(String sql, Object... params)
    {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int result = 0;
        try
        {
            conn = DriverManager.getConnection(DB_URL, DB_LOGIN_NAME, DB_LOGIN_PWD);
            pstmt = conn.prepareStatement(sql);
            for(int i = 0; i < params.length; i ++)
            {
                pstmt.setObject(i + 1, params[i]);
            }
            result = pstmt.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            closeResource(conn, pstmt, null);
        }
        return result;
    }


    /**
     * 查询某个指定的值
     * @param sql 查询结果Sql
     * @param params 参数
     * @return 查询结果
     */
    public static final Object executeScalar(String sql, Object... params)
    {
        Object obj = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try
        {
            conn = DriverManager.getConnection(DB_URL, DB_LOGIN_NAME, DB_LOGIN_PWD);
            pstmt = conn.prepareStatement(sql);
            for(int i = 0; i < params.length; i ++)
            {
                pstmt.setObject(i + 1, params[i]);
            }
            rs = pstmt.executeQuery();
            if(rs.next())
            {
                obj = rs.getObject(1);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            closeResource(conn, pstmt, rs);
        }
        return obj;
    }


    /**
     * 执行通用查询到的方法
     * @param sql sql语句
     * @param params 参数
     * @return 查询结果
     */
    public static final List<Map<String, Object>> executeQuery(String sql, Object... params)
    {
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try
        {
            conn = DriverManager.getConnection(DB_URL, DB_LOGIN_NAME, DB_LOGIN_PWD);
            pstmt = conn.prepareStatement(sql);
            for(int i = 0; i < params.length; i ++)
            {
                pstmt.setObject(i + 1, params[i]);
            }
            rs = pstmt.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next())
            {
                Map<String, Object> map = new HashMap<String, Object>();

                for(int i = 0; i < rsmd.getColumnCount(); i ++)
                {
                    map.put(rsmd.getColumnLabel(i + 1), rs.getObject(i + 1));
                }
                result.add(map);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            closeResource(conn, pstmt, rs);
        }

        return result;
    }


    /**
     * 查询包装方法（返回对象）
     * @param sql SQL语句
     * @param clazz 封装结果的Class
     * @param params Sql语句参数
     * @param <T> 类型
     * @return 结果集合
     */
    public static final <T> List<T> executeQuery(String sql, Class<T> clazz, Object... params)
    {
        List<T> result = new ArrayList<T>();


        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try
        {
            conn = DriverManager.getConnection(DB_URL, DB_LOGIN_NAME, DB_LOGIN_PWD);
            pstmt = conn.prepareStatement(sql);
            for(int i = 0; i < params.length; i ++)
            {
                pstmt.setObject(i + 1, params[i]);
            }
            rs = pstmt.executeQuery();
            while(rs.next())
            {
                try
                {
                    T obj = clazz.getDeclaredConstructor().newInstance();
                    ResultSetMetaData rsmd = rs.getMetaData();
                    for(int i = 0; i < rsmd.getColumnCount(); i ++)
                    {
                        try
                        {
                            String columnName = rsmd.getColumnName(i + 1);
                            Field field = clazz.getDeclaredField(columnName);
                            field.setAccessible(true);
                            field.set(obj, rs.getObject(i + 1));
                        }
                        catch(NoSuchFieldException ex)
                        {
                            ex.printStackTrace();
                            continue;
                        }
                    }
                    result.add(obj);
                }
                catch (InstantiationException e)
                {
                    e.printStackTrace();
                }
                catch (IllegalAccessException e)
                {
                    e.printStackTrace();
                }
                catch (InvocationTargetException e)
                {
                    e.printStackTrace();
                }
                catch (NoSuchMethodException e)
                {
                    e.printStackTrace();
                }
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            closeResource(conn, pstmt, rs);
        }

        return result;
    }



    /**
     * 关闭数据库连接资源
     */
    public static void closeResource(Connection conn, PreparedStatement pstmt, ResultSet rs)
    {
        try
        {
            if(null != rs)
                rs.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }

        try
        {
            if(null != pstmt)
                pstmt.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }

        try
        {
            if(null != conn)
                conn.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }


}
