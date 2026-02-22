package guru.springframework.spring7restmvc.services;

import guru.springframework.spring7restmvc.model.CustomerDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerService {

    Optional<CustomerDTO> getCustomerById(UUID id);

    List<CustomerDTO> getCustomers();

    CustomerDTO saveNewCustomer(CustomerDTO customer);

    Optional<CustomerDTO> updateCustomerOnId(UUID customerId, CustomerDTO customer);

    Boolean deleteCustomerOnId(UUID customerId);

    Optional<CustomerDTO> patchCustomerOnId(UUID customerId, CustomerDTO customer);

}
