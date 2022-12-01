class Store {
  private Product[] list;
  private int productsLength;
  private int maxProductsLength;

  public Store() {
    list = new Product[2];
    productsLength = 0;
    maxProductsLength = 10;
  }

  public Store(Product[] list) {
    this.list = list;
    productsLength = list.length;
    maxProductsLength = 10;
  }

  public Store(Product[] list, int maxProductsLength) {
    this.list = list;
    productsLength = list.length;
    this.maxProductsLength = maxProductsLength;
  }

  public Product[] getList() {
    return list;
  }

  public void setList(Product[] list) {
    this.list = list;
  }

  public int searchProduct(String name) {
    for (int i = 0; i < productsLength; i++) {
      if (list[i].getName().equals(name)) {
        return i;
      }
    }
    return -1;
  }

  public boolean addProduct(Product product) {
    boolean success = false;
    if (productsLength < maxProductsLength) {
      success = true;
      if (productsLength == list.length) {
        Product[] newList = new Product[list.length + 5];
        for (int i = 0; i < list.length; i++) {
          newList[i] = list[i];
        }
        newList[list.length] = product;
        setList(newList);
      }
      list[productsLength] = product;
      productsLength++;
    }
    return success;
  }

  public void editProduct(Product newProduct, int index) {
    list[index] = newProduct;
  }

  public void deleteProduct(int index) {
    for (int i = index; i < productsLength; i++) {
      list[i] = list[i + 1];
    }
    list[productsLength] = null;
    productsLength--;
  }

  public void increasePriceProducts(int percentage) {
    for (Product product : list) {
      product.setPrice(product.getPrice() + (product.getPrice() * percentage / 100));
    }
  }

  public void discountProducts(int percentage) {
    for (Product product : list) {
      product.setPrice(product.getPrice() - (product.getPrice() * percentage / 100));
    }
  }

  public Product[] productsUnderPrice(double price) {
    int count = 0;
    for (int i = 0; i < productsLength; i++) {
      if (list[i].getPrice() < price) {
        count++;
      }
    }
    Product[] listUnderPrice = new Product[count];
    int position = 0;
    for (int i = 0; i < productsLength; i++) {
      if (list[i].getPrice() < price) {
        listUnderPrice[position] = new Product(list[i]);
        position++;
      }
    }
    return listUnderPrice;
  }

  public Store storeUnderPrice(double price) {
    Product[] listUnderPrice = productsUnderPrice(price);
    return new Store(listUnderPrice);
  }

  public String toString() {
    String result = "";
    for (int i = 0; i < productsLength; i++) {
      result += list[i] + "\n";
    }
    return result;
  }
}
