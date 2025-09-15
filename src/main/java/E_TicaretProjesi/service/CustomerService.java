package E_TicaretProjesi.service;

import E_TicaretProjesi.dao.CustomerDAO;
import E_TicaretProjesi.exception.ExceptionMessagesConstants;
import E_TicaretProjesi.exception.PatikaStoreException;
import E_TicaretProjesi.model.Customer;
import E_TicaretProjesi.util.PasswordUtil;

public class CustomerService {


    private CustomerDAO customerDAO;


    public CustomerService() {
        customerDAO = new CustomerDAO();

    }

    public void save(String name, String email, String password) throws PatikaStoreException {

        boolean isExist = customerDAO.existByEmail(email);

        if(isExist){
            throw new PatikaStoreException(ExceptionMessagesConstants.CUSTOMER_EMAIL_ALREADY_EXISTS );
        }

        Customer customer = new Customer(name,email, PasswordUtil.hash(password));
        customerDAO.save(customer);
        System.out.println("Kayit Basarili");


    }

    public void login(String email, String password) throws PatikaStoreException {

        boolean isExist = customerDAO.existByEmail(email);

        if(!isExist){
            throw new PatikaStoreException(ExceptionMessagesConstants.CUSTOMER_EMAIL_DOES_NOT_EXISTS );
        }

        String hashedPassword = PasswordUtil.hash(password);

        Customer foundCustomer = customerDAO.findByEmail(email);

        if(foundCustomer != null){
            boolean passwordEquals = foundCustomer.getPassword().equals(hashedPassword);
            if (!passwordEquals){
                throw new PatikaStoreException(ExceptionMessagesConstants.CUSTOMER_PASSWORD_DOES_NOT_MATCH );
            } else{
                System.out.println("Kullanici sisteme giris yapti");
            }
        }

    }
}

