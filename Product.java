class Product {
  private String name;
  private double price;

  public Product() {
    setName("prodotto");
    setPrice(0);
  }

  public Product(String name, double price) {
    setName(name);
    setPrice(price);
  }

  public Product(Product product) {
    name = product.name;
    price = product.price;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public boolean equals(Product product) {
    return getName() == product.getName() && getPrice() == product.getPrice();
  }

  public String toString() {
    return "name: " + name + ", price: " + price;
  }
}
