package daos;

import models.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CarDAO extends DAO<Car> {

    private static final String INSERT = "INSERT into Car "+
            "(make, model, year, color, vin, ID) "+
            "values(?,?,?,?,?,?)";
    private static final String GET_ONE = "SELECT * FROM Car WHERE ID = ?";
    private static final String UPDATE = "UPDATE Car SET make = ?, model = ?, year = ?, color = ?, "+
            "vin = ? WHERE ID = ?";
    private static final String DELETE = "DELETE FROM Car WHERE ID = ?";


    public CarDAO(Connection connection) {
        super(connection);
    }

    public Car findById(int Id) {
        Car car = null;
        try(PreparedStatement pstmt = DBUtil.getConnection().prepareStatement(GET_ONE)){
            pstmt.setInt(1, Id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                car = new Car();
                car.setId(rs.getInt("ID"));
                car.setMake(rs.getString("make"));
                car.setModel(rs.getString("model"));
                car.setColor(rs.getString("color"));
                car.setVin(rs.getString("vin"));
                car.setYear(rs.getInt("year"));
            }
        } catch (SQLException e){
            DBUtil.showErrorMessage(e);
        }
        return car;
    }

    public List<Car> findAll() {
        return null;
    }

    public Car update(Car dto) {
        Car car = null;
        try(PreparedStatement pstmt = this.connection.prepareStatement(UPDATE)){
            helper(dto, pstmt);
            pstmt.executeUpdate();
            car = this.findById(dto.getId());
        }catch(SQLException e){
            DBUtil.showErrorMessage(e);
        }
        return car;
    }

    public Car create(Car dto) {
        int key = -1;
        try(PreparedStatement pstmt = this.connection.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS)){
            helper(dto, pstmt);
            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();

            if(rs != null && rs.next()){
                key = rs.getInt(1);
            }
        }catch (SQLException e){
            DBUtil.showErrorMessage(e);
        }
        return this.findById(key);
    }


    public void delete (int id){
            try (PreparedStatement pstmt = this.connection.prepareStatement(DELETE)) {
                pstmt.setInt(1, id);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                DBUtil.showErrorMessage(e);
            }

        }

    private void helper(Car dto, PreparedStatement pstmt) throws SQLException {
        pstmt.setString(1, dto.getMake());
        pstmt.setString(2, dto.getModel());
        pstmt.setInt(3, dto.getYear());
        pstmt.setString(4, dto.getColor());
        pstmt.setString(5, dto.getVin());
        pstmt.setInt(6, dto.getId());
    }
}
