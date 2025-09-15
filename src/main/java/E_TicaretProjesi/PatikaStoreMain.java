package E_TicaretProjesi;

import E_TicaretProjesi.exception.PatikaStoreException;
import E_TicaretProjesi.service.CustomerService;

import java.util.Scanner;

public class PatikaStoreMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("=== Patika Store Hosgeldiniz ===");
            System.out.println("1 - Musteri Kaydi");
            System.out.println("2 - Giris Yap");
            System.out.println("0 - Cikis");

            System.out.print("Yapmak istedginiz islemi seciniz: ");
            String choise = scanner.nextLine();

            try {
                switch (choise) {

                    case "1":
                        saveCustomer(scanner);
                        break;

                    case "2":
                        loginCustomer(scanner);
                        break;

                    case "0":
                        System.out.println("Cikis yapiliyor...");
                        return;

                    default:
                        System.out.println("Gecersiz Secim");

                }
            }catch (PatikaStoreException e){
                System.out.println(e.getMessage());
            }

        }
    }

    private static void loginCustomer(Scanner scanner) throws PatikaStoreException {
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Sifre: ");
        String password = scanner.nextLine();

        CustomerService customerService = new CustomerService();
        customerService.login(email,password);
    }

    private static void saveCustomer(Scanner scanner) throws PatikaStoreException {

        System.out.print("Isim: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Sifre: ");
        String password = scanner.nextLine();

        CustomerService customerService = new CustomerService();
        customerService.save(name,email,password);

    }
}
