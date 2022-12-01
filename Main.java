import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Store store = new Store();
    int choice;
    String search;
    String name;
    double price;
    Product newProduct;
    int matching;
    int percentage;

    do {
      System.out.println("1 - aggiungi prodotto");
      System.out.println("2 - stampa prodotto");
      System.out.println("3 - modifica prodotto");
      System.out.println("4 - cancella prodotto");
      System.out.println("5 - stampa magazzino");
      System.out.println("6 - sconta prodotti");
      System.out.println("7 - rincara prodotti");
      System.out.println("8 - restituisci prodotti sotto un certo prezzo");
      System.out.println("0 - esci");
      System.out.println("inserisci la scelta");
      choice = scanner.nextInt();

      switch (choice) {
        case 1:
          System.out.println("inserisci il nome");
          name = scanner.next();
          System.out.println("inserisci il prezzo");
          price = scanner.nextDouble();
          newProduct = new Product(name, price);
          if (store.addProduct(newProduct)) {
            System.out.println("prodotto aggiunto");
          } else {
            System.out.println("magazzino pieno");
          }
          break;

        case 2:
          System.out.println("inserisci il nome");
          search = scanner.next();
          matching = store.searchProduct(search);
          if (matching != -1) {
            System.out.println(store.getList()[matching]);
          } else {
            System.out.println("prodotto non trovato");
          }
          break;

        case 3:
          System.out.println("inserisci il nome");
          search = scanner.next();
          matching = store.searchProduct(search);
          if (matching != -1) {
            System.out.println("inserisci il nuovo nome");
            name = scanner.next();
            System.out.println("inserisci il nuovo prezzo");
            price = scanner.nextDouble();
            newProduct = new Product(name, price);
            store.editProduct(newProduct, matching);
          } else {
            System.out.println("prodotto non trovato");
          }

          break;

        case 4:
          System.out.println("inserisci il nome");
          search = scanner.next();
          matching = store.searchProduct(search);
          if (matching != -1) {
            store.deleteProduct(matching);
          } else {
            System.out.println("prodotto non trovato");
          }
          break;

        case 5:
          System.out.println(store);
          break;

        case 6:
          System.out.println("che percentuale vuoi scontare i prodotti?");
          percentage = scanner.nextInt();
          store.discountProducts(percentage);
          break;

        case 7:
          System.out.println("che percentuale vuoi rincarare i prodotti?");
          percentage = scanner.nextInt();
          store.increasePriceProducts(percentage);
          break;

        case 8:
          System.out.println("che prezzo?");
          price = scanner.nextInt();
          Product[] newList = store.productsUnderPrice(price);
          for (Product product : newList) {
            System.out.println(product);
          }
          break;

      }
    } while (choice != 0);

    scanner.close();
  }
}
