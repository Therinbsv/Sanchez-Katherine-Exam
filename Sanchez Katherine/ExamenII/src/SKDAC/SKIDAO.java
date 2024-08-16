package SKDAC;

import java.util.List;

public interface SKIDAO<T> {
    public boolean create ( T entity)   throws Exception;
    public List<T> readALL()            throws Exception;
    public boolean update ( T entity)   throws Exception;
    public boolean delete ( T entity)   throws Exception;
    
    public T readBy (Integer id)        throws Exception;
}
