package peaksoft.spring_security_db.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.spring_security_db.entity.Product;
import peaksoft.spring_security_db.reposirory.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    public List<Product>getAllProduct(){
        return repository.findAll();
    }

    public void save(Product product){
        repository.save(product);
    }

    public Product getById(long id){
        return repository.findById(id).get();
    }

    public void delete(long id){
         repository.deleteById(id);
    }
}
