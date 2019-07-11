package controller;

import model.Product;
import service.ProductService;

public class ProductController {

    ProductService productService = new ProductService();

    public Product[] findAll() {
        return productService.findAll();
    }
    public void addProduct(int id,String name,double price){
        productService.addProduct(id,name,price);
    }

    public boolean removeProduct(int index) {
        productService.removeProduct(index);
        return true;
    }

    public boolean updateProduct(int id, String name, double price) {
        productService.updateProduct(id, name, price);
        return true;
    }

    public int searchProduct(String name) {
        return productService.searchProduct(name);
    }


}
