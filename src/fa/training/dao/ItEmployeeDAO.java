package fa.training.dao;

import fa.training.entities.ITEmployee;

import java.util.List;

public interface ItEmployeeDAO {
    List<ITEmployee> getAll();
    boolean insert(ITEmployee itEmployee);
}
