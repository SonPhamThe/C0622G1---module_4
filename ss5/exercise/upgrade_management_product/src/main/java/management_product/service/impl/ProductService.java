package management_product.service.impl;

import management_product.model.Product;
import management_product.repository.IProductRepo;
import management_product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProductService implements IProductService {
    @Autowired
    private IProductRepo productRepo;

    @Override
    public List<Product> displayALl() {
        return productRepo.displayAll();
    }
}
