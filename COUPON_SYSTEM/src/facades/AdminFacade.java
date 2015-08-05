package facades;

import exceptions.*;

public class AdminFacade implements ClientFacade
{
	// TODO DAO	
	AdminDAO adminConnection;
	
	// Constructor
	public AdminFacade()
	{
		adminConnection = new AdminDAO();
	}
	
	//Methods
	// TODO Login method, on successful login returns ClientFacade object
	@Override
	public ClientFacade login(String name, String password,
			String clientType) throws InvalidLoginException
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
	private void createCompany(Company newCompany)
	{
		// if newCompany does not exist - add it
		if(this.adminConnection.getCompany(newCompany.getId) == null)
			this.adminConnection.addCompany(newCompany);
	}
	// Removes company, if it exists
	private void removeCompany(Company company)
	{
		this.adminConnection.getCoupons
		this.adminConnection.removeCompany(company.id);
	}
	// 
	private void updateCompany(Company company)
	{
		
	}
	// Find Company by id or throw objectDontExistException
	private Company getCompany(int id) throws objectDontExistException
	{
		Company company = this.adminConnection.getCompany(id);

		return company;
	}
}
