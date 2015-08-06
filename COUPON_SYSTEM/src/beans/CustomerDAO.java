package beans;


public interface CustomerDAO {

	 void createCustomer(Customer customer);
	 void removeCustomer(Customer customer);
	 void updateCustomer(Customer customer);
	 void getCustomer(long id);
	 void getAllCustomers();
	 void getCoupons();
	 boolean login(String custName,String password);
}
