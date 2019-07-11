
import controller.ProductController;
import model.Product;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int choice;
        ProductController productController = new ProductController();
        do {
            menu();
            Scanner input = new Scanner(System.in);
            System.out.println("Nhap vao lua chon:");
            choice = input.nextInt();
            switch (choice) {
                case 1: {
                    Product[] listProduct = productController.findAll();
                    for (int i = 0; i < listProduct.length; i++) {
                        if (listProduct[i] != null) {
                            System.out.println("ID: " + listProduct[i].getId() + " NAME: " + listProduct[i].getName()+" PRICE: "+listProduct[i].getPrice());
                        }
                    }
                    break;
                }
                case 2: {
                    System.out.println("Nhap vao ID:");
                    int id = input.nextInt();
                    System.out.println("Nhap vao Ten San Pham:");
                    String name = new Scanner(System.in).nextLine();
                    System.out.println("Nhap vao gia:");
                    double price= input.nextDouble();
                    productController.addProduct(id,name,price);
                    break;
                }
                case 3: {
                    Product[] listProduct = productController.findAll();
                    if (listProduct.length > 0) {
                        System.out.println("Nhap ID san pham ban muon xoa: ");
                        int index = input.nextInt();
                        if(productController.removeProduct(index)){
                            System.out.println("Xoa thanh cong!");
                        }
                        else {
                            System.out.println("Xoa that bai");
                        }
                    }
                    break;
                }
                case 4: {
                    Product[] listProduct = productController.findAll();
                    if(listProduct.length > 0) {
                        System.out.println("Nhap ID san pham ban muon sua: ");
                        int id = input.nextInt();
                        System.out.println("Nhap ten san pham ban muon sua: ");
                        String name = new Scanner(System.in).nextLine();
                        System.out.println("Nhap gia san pham ban muon sua: ");
                        double price = input.nextDouble();

                        if(productController.updateProduct(id, name, price)){
                            System.out.println("Cap nhat thanh cong!");
                        }
                        else {
                            System.out.println("Cap nhat that bai!");
                        }
                    }
                    break;
                }
                case 5: {
                    Product[] listProduct = productController.findAll();
                    int index;
                    if (listProduct.length >0){
                        System.out.println("Nhap ten san pham ban muon tim");
                        String name = new Scanner(System.in).nextLine();
                        index = productController.searchProduct(name);
                        System.out.println("San pham can tim la " + listProduct[index].getName()+".Co gia la " +listProduct[index].getPrice());
                    }
                }
            }
        } while (choice != 0);
    }


    public static void menu() {
        System.out.println("\n");
        System.out.println("-----Quan ly san pham-----");
        System.out.println("1. Hien thi san pham");
        System.out.println("2. Them san pham");
        System.out.println("3. Xoa san pham");
        System.out.println("4. Sua san pham");
        System.out.println("5. Tim kiem san pham");
        System.out.println("0. Thoat");
    }
}
