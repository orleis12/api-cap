package co.com.capudc.commons;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public abstract class GenericServiceImpl<T, ID extends Serializable> implements GenericServiceAPI<T, ID> {

    @Override
    public T save(T entity) {

        return getDao().save(entity);
    }

    @Override
    public void delete(ID id) {
        getDao().deleteById(id);
    }

    @Override
    public T get(ID id) {
        Optional<T> obj = getDao().findById(id);
        if (obj.isPresent()) { // si encontro el objeto
            return obj.get();
        }
        return null;
    }

    @Override
    public List<T> getAll() {
        List<T> listaTotal = new ArrayList();
        getDao().findAll().forEach(obj -> listaTotal.add(obj));
        return listaTotal;
    }

    public abstract CrudRepository<T, ID> getDao(); // para saber cual es la claseDAO con la que estamos trabajando en el service

}
