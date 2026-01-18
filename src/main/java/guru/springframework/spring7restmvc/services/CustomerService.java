package guru.springframework.spring7restmvc.services;

import guru.springframework.spring7restmvc.model.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {

    List<Customer> getCustomers();
    Customer getCustomerById(UUID id);

    Customer saveNewCustomer(Customer customer);

    void updateCustomerOnId(UUID customerId, Customer customer);

    void deleteCustomerOnId(UUID customerId);

    void patchCustomerOnId(UUID customerId, Customer customer);

}
