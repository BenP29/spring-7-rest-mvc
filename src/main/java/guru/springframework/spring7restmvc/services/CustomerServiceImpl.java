package guru.springframework.spring7restmvc.services;

import guru.springframework.spring7restmvc.model.CustomerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    //private CustomerService customerService;

    private Map<UUID, CustomerDTO> customers;

    public CustomerServiceImpl() {

        customers = new HashMap<>();

        CustomerDTO cust1 = CustomerDTO.builder()
                .id(UUID.randomUUID())
                .name("Piet")
                .version(134)
                .createDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        CustomerDTO cust2 = CustomerDTO.builder()
                .id(UUID.randomUUID())
                .name("Jan")
                .version(132)
                .createDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        customers.put(cust1.getId(), cust1);
        customers.put(cust2.getId(), cust2);
    }

    @Override
    public List<CustomerDTO> getCustomers() {

        log.debug("in de getCustomers service - get All customers");

        return new ArrayList<>(customers.values());
    }

    @Override
    public Optional<CustomerDTO> getCustomerById(UUID id) {

        log.debug("In the getCustomerd Service -- get Csutomer by Id: " + id);

        return Optional.of(customers.get(id));
    }

    @Override
    public CustomerDTO saveNewCustomer(CustomerDTO customer) {

        CustomerDTO savedCustomer = CustomerDTO.builder()
                .id(UUID.randomUUID())
                .createDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .name(customer.getName())
                .version(customer.getVersion())
                .build();

        customers.put(customer.getId(), savedCustomer);

        return savedCustomer;
    }

    @Override
    public Optional<CustomerDTO> updateCustomerOnId(UUID customerId, CustomerDTO customer) {

        CustomerDTO existing = customers.get(customerId);
        existing.setName(customer.getName());
        existing.setVersion(customer.getVersion());

        return Optional.of(existing);
    }

    @Override
    public Boolean deleteCustomerOnId(UUID customerId) {

        customers.remove(customerId);
        return true;
    }

    @Override
    public Optional<CustomerDTO> patchCustomerOnId(UUID customerId, CustomerDTO customer) {

        CustomerDTO existing = customers.get(customerId);

        if (StringUtils.hasText(customer.getName())){
            existing.setName(customer.getName());
        }

        if (customer.getVersion() != null){
            existing.setVersion(customer.getVersion());
        }

        return Optional.of(existing);
    }
}
