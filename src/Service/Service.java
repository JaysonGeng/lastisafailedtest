package Service;

import DBHelper.DBManager;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Service {

    public Boolean login(String username, String password) {

        // ��ȡSql��ѯ���
        String logSql = "select * from user where username ='" + username
                + "' and password ='" + password + "'";

        // ��ȡDB����
        DBManager sql = DBManager.createInstance();
        sql.connectDB();

        // ����DB����
        try {
            ResultSet rs = sql.executeQuery(logSql);
            if (rs.next()) {
                sql.closeDB();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql.closeDB();
        return false;
    }

    public Boolean register(String username, String password) {

        // ��ȡSql��ѯ���
        String regSql = "insert into student values('"+ username+ "','"+ password+ "') ";

        // ��ȡDB����
        DBManager sql = DBManager.createInstance();
        sql.connectDB();

        int ret = sql.executeUpdate(regSql);
        if (ret != 0) {
            sql.closeDB();
            return true;
        }
        sql.closeDB();

        return false;
    }
}