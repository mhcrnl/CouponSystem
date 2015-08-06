package facades;

import java.util.ArrayList;

import beans.*;
import exceptions.*;

public class AdminFacade implements ClientFacade
{
	// Create Data Base connections:
	// CompanyDBDAO to manipulate companies
	private CompanyDBDAO compDBDAO;
	// CustomerDBDAO to manipulate customers
	private CustomerDBDAO custDBDAO;
	// CouponDBDAO to manipulate coupons
	private CouponDBDAO coupDBDAO;
	
	// Constructor
	public AdminFacade()
	{
		// Instantiate db connections
		compDBDAO = new CompanyDBDAO();
		custDBDAO = new CustomerDBDAO();
		coupDBDAO = new CouponDBDAO();
	}
	
	/// Methods

	// Login method, on successful login returns ClientFacade object
	@Override
	public ClientFacade login(String name, String password) throws InvalidLoginException
	{
		// If username/password wrong - throw exception
		if(name != "admin" || password != "1234")
		{
			throw new InvalidLoginException();
		}
		// else - create and return new Facade Object
		return new AdminFacade();
	}
	
	// Create new company
	private void createCompany(Company newCompany) throws ObjectAlreadyExistException
	{
		boolean companyExist = false;
		// Create new AllayList of all existing companies
		ArrayList<Company> allCompanies = getAllCompanies();
		// Check that newCompany does not yet exist BY NAME
		for(Company existingCompany : allCompanies)
		{
			if(existingCompany.getCompName() == newCompany.getCompName())
				{
					companyExist = true;
					break;
				}
		}
		// if newCompany does not exist - add it
		if(!companyExist)
			compDBDAO.createCompany(newCompany);
		else
		{
			// throw exception
			throw new ObjectAlreadyExistException();
		}
	}
	// Removes company and all its coupons, if company exists
	private void removeCompany(Company company) throws ObjectDontExistException
	{
		boolean companyExist = false;
		// Create new AllayList of all existing companies
		ArrayList<Company> allCompanies = getAllCompanies();
		// Check that newCompany does not yet exist BY NAME
		for(Company existingCompany : allCompanies)
		{
			if(existingCompany.getCompName() == company.getCompName())
				{
					companyExist = true;
					break;
				}
		}
		// if Company exists - remove coupons, remove company
		if(companyExist)
		{
			// Get all company coupons
			ArrayList<Coupon> allCompanysCoupons = company.getCoupons();
			// Remove every coupon of a given company
			for(Coupon couponToRemove : allCompanysCoupons)
			{
				// TODO remove coupons from Customers
				coupDBDAO.removeCoupon(couponToRemove);
			}
			// Remove company
			compDBDAO.removeCompany(company);
		}
		else
		{
			// throw exception
			throw new ObjectDontExistException();
		}
	}
	// Update existing company
	private void updateCompany(Company company) throws ObjectDontExistException
	{
		boolean companyExist = false;
		// Create new AllayList of all existing companies
		ArrayList<Company> allCompanies = getAllCompanies();
		// Check that newCompany does not yet exist BY NAME
		for(Company existingCompany : allCompanies)
		{
			if(existingCompany.getCompName() == company.getCompName())
				{
					companyExist = true;
					break;
				}
		}
		// if Company exists - update it
		if(companyExist)
			compDBDAO.updateCompany(company);
		else
		{
			// throw exception
			throw new ObjectDontExistException();
		}
	}
	// Find Company by id
	private Company getCompany(int id)
	{
		return compDBDAO.getCompany(id);
	}
	// Returns Collection<Company> of all existing companies
	private ArrayList<Company> getAllCompanies()
	{
		return compDBDAO.getAllCompanies();
	}

	// Create new Customer
	private void createCustomer(Customer newCustomer) throws ObjectAlreadyExistException
	{
		boolean customerExist = false;
		// Create new AllayList of all existing Customers
		ArrayList<Customer> allCustomers = getAllCustomers();
		// Check that newCustomer does not yet exist BY NAME
		for(Customer existingCustomer : allCustomers)
		{
			if(existingCustomer.getCustName() == newCustomer.getCustName())
				{
					customerExist = true;
					break;
				}
		}
		// if newCompany does not exist - add it
		if(!customerExist)
			custDBDAO.createCompany(newCustomer);
		else
		{
			// throw exception
			throw new ObjectAlreadyExistException();
		}
	}
	// Removes customer and all his coupons, if exists
	private void removeCustomer(Customer customer) throws ObjectDontExistException
	{
		boolean customerExist = false;
		// Create new AllayList of all existing customer
		ArrayList<Customer> allCustomers = getAllCustomers();
		// Check that newCustomer does not yet exist BY NAME
		for(Customer existingCustomer : allCustomers)
		{
			if(existingCustomer.getCustName() == customer.getCustName())
				{
					customerExist = true;
					break;
				}
		}
		// if Customer exists - remove coupons, remove customer
		if(customerExist)
		{
			// Get all customer coupons
			ArrayList<Coupon> allCompanysCoupons = customer.getCoupons();
			// Remove every coupon of a given company
			for(Coupon couponToRemove : allCompanysCoupons)
			{
				// TODO remove coupons from Customers
			}
			// Remove customer
			custDBDAO.removeCustomer(customer);
		}
		else
		{
			// throw exception
			throw new ObjectDontExistException();
		}
	}
	// Update existing customer
	private void updateCustomer(Customer customer) throws ObjectDontExistException
	{
		boolean customerExist = false;
		// Create new AllayList of all existing customers
		ArrayList<Customer> allCustomers = getAllCustomers();
		// Check that customer does not yet exist BY NAME
		for(Customer existingCustomer : allCustomers)
		{
			if(existingCustomer.getCustName() == customer.getCustName())
				{
					customerExist = true;
					break;
				}
		}
		// if customer exists - update it
		if(customerExist)
			custDBDAO.updateCustomer(customer);
		else
		{
			// throw exception
			throw new ObjectDontExistException();
		}
	}
	// Find Customer by id
	private Customer getCustomer(int id)
	{
		return custDBDAO.getCustomer(id);
	}
	// Returns Collection<Customer> of all existing customers
	private ArrayList<Customer> getAllCustomers()
	{
		return custDBDAO.getAllCustomers();
	}
}
