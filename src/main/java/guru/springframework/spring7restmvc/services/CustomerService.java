package guru.springframework.spring7restmvc.services;

import guru.springframework.spring7restmvc.model.CustomerDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerService {

    List<CustomerDTO> getCustomers();
    Optional<CustomerDTO> getCustomerById(UUID id);

    CustomerDTO saveNewCustomer(CustomerDTO customer);

    void updateCustomerOnId(UUID customerId, CustomerDTO customer);

    void deleteCustomerOnId(UUID customerId);

    void patchCustomerOnId(UUID customerId, CustomerDTO customer);

}
