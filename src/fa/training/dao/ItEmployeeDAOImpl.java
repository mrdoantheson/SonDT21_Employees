package fa.training.dao;

import fa.training.entities.ITEmployee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ItEmployeeDAOImpl implements ItEmployeeDAO {
    @Override
    public List<ITEmployee> getAll() {
        return null;
    }

    @Override
    public boolean insert(ITEmployee itEmployee) {
        try (Connection connection = DBUtils.getConnection()) {
            String sqlStatement = "INSERT INTO " +
                    "ITEmployee(ITEmployees_Code, ITEmployees_Name ,ITEmployees_Age,ITEmployees_Salary) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sqlStatement);
            statement.setString(1, itEmployee.getCode());
            statement.setString(2, itEmployee.getName());
            statement.setInt(3, itEmployee.getAge());
            statement.setDouble(4, itEmployee.getSalary());

            int rowAffect = statement.executeUpdate();
            return rowAffect == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
