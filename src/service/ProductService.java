package service;

import model.Product;
import repository.ProductRepository;

public class ProductService implements GeneralService<Product>{

    ProductRepository productRepository = new ProductRepository();

    @Override
    public Product[] findAll() {
        return productRepository.findAll();
    }

    @Override
    public void addProduct(int id,String name,double price) {
        productRepository.addProduct(id,name,price);
    }

    @Override
    public boolean removeProduct(int index) {
        productRepository.removeProduct(index);
        return true;
    }

    @Override
    public boolean updateProduct(int id, String name, double price) {
        productRepository.updateProduct(id, name, price);
        return true;
    }

    @Override
    public int searchProduct(String name) {
        return productRepository.searchProduct(name);
    }
}
