package facades;

import exceptions.InvalidLoginException;

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
		// else - create new Facade Object
		AdminFacade adminLogin = new AdminFacade();
		// return Facade
		return new AdminFacade();
	}

	// Create new company
	
	
	
	
}
