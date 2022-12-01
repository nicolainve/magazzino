class UseStore {
  public static void main(String[] args) {
    Product[] list1 = new Product[3];
    Product product1 = new Product("q", 10);
    Product product2 = new Product("q", 4);
    Product product3 = new Product("q", 7);
    list1[0] = product1;
    list1[1] = product2;
    list1[2] = product3;
    Store store1 = new Store(list1);

    // Product[] list2 = store1.productsUnderPrice(8);
    Store store2 = store1.storeUnderPrice(8);
    System.out.println(store2);
  }
}
