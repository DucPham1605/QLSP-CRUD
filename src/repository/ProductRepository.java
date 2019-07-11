package repository;

import model.Product;

public class ProductRepository implements GeneralRepository<Product> {

    Product[] listProduct = new Product[3];
    {
        listProduct[0] = new Product(1,"Samsung",999.000);
        listProduct[1] = new Product(2,"Iphone",998.000);
        listProduct[2] = new Product(3,"Asus",800.000);
    }

    @Override
    public Product[] findAll() {
        return listProduct;
    }

    @Override
    public void addProduct(int id,String name,double price) {
        Product[] listNewProduct = new Product[listProduct.length +1];
        for (int i = 0;i < listProduct.length; i++) {
            listNewProduct[i] = listProduct[i];
        }
        listNewProduct[listNewProduct.length-1] = new Product(id,name,price);
        listProduct = listNewProduct;
    }

    @Override
    public boolean removeProduct(int index) {
        for (int i = 0; i < listProduct.length; i++) {
            if (listProduct[i].getId() == index) {
                Product[] listNewProduct = new Product[listProduct.length-1];
                for (int j = i; j < listNewProduct.length; j++) {
                    listNewProduct[j] = listProduct[j+1];
                }
                listProduct = listNewProduct;
            }
        }
        return true;
    }

    @Override
    public boolean updateProduct(int id, String name,double price) {
        for (int i=0;i<listProduct.length;i++){
            if(listProduct[i].getId()== id){
                listProduct[i].setId(id);
                listProduct[i].setName(name);
                listProduct[i].setPrice(price);
            }
        }
        return true;
    }

    @Override
    public int searchProduct(String name) {
        int index = -1;
        for (int i = 0; i < listProduct.length; i++) {
           if( listProduct[i].getName().equals(name)){
            index = i;
            break;
            }
        }
        return index;

    }

}