package beans;

public interface CompanyDAO {
	
	 void createConpany(Company company);
	 void removeConpany(Company company);
	 void updateConpany(Company company);
	 void getCompany(long id);
	 void getAllCompanies();
	 void getCoupons();
	 boolean login(String compName,String password);

}
