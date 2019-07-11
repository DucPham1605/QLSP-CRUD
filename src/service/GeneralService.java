package service;

public interface GeneralService<T> {

    T[] findAll();

    void addProduct (int id,String name,double price);

    boolean removeProduct(int index);

    boolean updateProduct(int id,String name,double price);

    int searchProduct(String name);


}
