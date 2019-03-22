package models;

import daos.CarDAO;
import daos.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static daos.DBUtil.getConnection;

public class Runner {

    public static void main(String[] args) throws SQLException {
//        Connection conn = null;
//
//        try {
//            conn = DBUtil.getConnection();
//
//            System.out.println("Connection Established to MYSQL Database");
//
//        } catch (SQLException e) {
//
//            System.err.println(e.getMessage());
//
//        } finally {
//
//            conn.close();
//
//        }

        Connection conn = DBUtil.getConnection();
        CarDAO dao = new CarDAO(conn);
        Car car = new Car("Ford","Explorer", 1994, "Tan", "1254BB", 6);
        dao.create(car);
        conn.close();

    }


}

