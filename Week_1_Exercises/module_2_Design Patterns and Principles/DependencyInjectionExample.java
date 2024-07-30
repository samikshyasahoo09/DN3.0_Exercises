
interface CustomerRepository {
    String findCustomerById(int id);
}

//  Implement Concrete Repository
class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public String findCustomerById(int id) {
        // Simulate a customer lookup
        return "Customer with ID " + id;
    }
}

//  Define Service Class
class CustomerService {
    private CustomerRepository customerRepository;

    //  Implement Dependency Injection via Constructor
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public String getCustomerDetails(int id) {
        return customerRepository.findCustomerById(id);
    }
}

// Test the Dependency Injection Implementation
public class DependencyInjectionExample {
    public static void main(String[] args) {
        // Create a concrete repository instance
        CustomerRepository customerRepository = new CustomerRepositoryImpl();

        // Inject repository into service via constructor
        CustomerService customerService = new CustomerService(customerRepository);

        // Use the service to get customer details
        String customerDetails = customerService.getCustomerDetails(1);
        System.out.println(customerDetails);  
    }
}

