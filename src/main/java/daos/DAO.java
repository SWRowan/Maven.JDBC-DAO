package daos;

import java.sql.Connection;
import java.util.List;

public abstract class DAO<T> {
    protected final Connection connection;

    protected DAO(Connection connection) {
        this.connection = connection;
    }

    public abstract T findById(int Id);

    public abstract List<T> findAll();

    public abstract T update(T dto);

    public abstract T create(T dto);

    public abstract void delete(int id);


}
