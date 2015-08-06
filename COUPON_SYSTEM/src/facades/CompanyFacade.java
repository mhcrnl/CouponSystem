package facades;

import java.util.ArrayList;

import beans.*;
import exceptions.*;

public class CompanyFacade implements ClientFacade 
{
	// CouponDBDAO to manipulate coupons
	private CouponDBDAO coupDBDAO;
	// CompanyDBDAO for login ONLY
	private CompanyDBDAO compDBDAO;
	
	// Constructor
	public CompanyFacade()
	{
		// Instantiate db connections
		coupDBDAO = new CouponDBDAO();
		compDBDAO = new CompanyDBDAO();
	}
	
	// Methods
	
	// Login method, on successful login returns ClientFacade object
	// or throws an exception
	@Override
	public ClientFacade login(String name, String password) throws InvalidLoginException
	{
		// Check if company with this name exists
		ArrayList<Company> allCompanies = compDBDAO.getAllCompanies();
		for(Company existingCompany : allCompanies)
		{
			// If such company exist and password is right - return CompanyFacade
			if(existingCompany.getCompName() == name && existingCompany.getPassword() == password)
			{
				return new CompanyFacade();
			}
		}
		// If such company wasn't found - throw exception
		throw new InvalidLoginException();
	}
	
	// Create new coupon
	private void createCoupon(Coupon newCoupon) throws ObjectAlreadyExistException
	{
		boolean couponExist = false;
		// Create new AllayList of all existing coupons
		ArrayList<Coupon> allCoupons = getAllCoupons();
		// Check that newCoupon does not yet exist BY NAME
		for(Coupon existingCoupon : allCoupons)
		{
			if(existingCoupon.getTitle() == newCoupon.getTitle())
				{
					couponExist = true;
					break;
				}
		}
		// if newCoupon does not exist - add it
		if(!couponExist)
			coupDBDAO.createCoupon(newCoupon);
		else
		{
			// throw exception
			throw new ObjectAlreadyExistException();
		}
	}
	// Removes coupon, if it exists
	private void removeCoupon(Coupon coupon) throws ObjectDontExistException
	{
		boolean couponExist = false;
		// Create new AllayList of all existing coupons
		ArrayList<Coupon> allCoupons = getAllCoupons();
		// Check that newCoupon does not yet exist BY NAME
		for(Coupon existingCoupon : allCoupons)
		{
			if(existingCoupon.getTitle() == coupon.getTitle())
				{
					couponExist = true;
					break;
				}
		}
		// if Coupon exists - remove coupons, remove coupon
		if(couponExist)
		{
			// TODO remove coupon from every customer, that bought it
			// Remove coupon
			coupDBDAO.removeCoupon(coupon);
		}
		else
		{
			// throw exception
			throw new ObjectDontExistException();
		}
	}
	// Update existing coupon
	private void updateCoupon(Coupon coupon) throws ObjectDontExistException
	{
		boolean couponExist = false;
		// Create new AllayList of all existing coupons
		ArrayList<Coupon> allCoupons = getAllCoupons();
		// Check that newCoupon does not yet exist BY NAME
		for(Coupon existingCoupon : allCoupons)
		{
			if(existingCoupon.getCompName() == coupon.getCompName())
				{
					couponExist = true;
					break;
				}
		}
		// if Coupon exists - update it
		if(couponExist)
			coupDBDAO.updateCoupon(coupon);
		else
		{
			// throw exception
			throw new ObjectDontExistException();
		}
	}
	// Find Coupon by id, in company's coupons
	private Coupon getCoupon(int id)
	{
		// TODO 
		return coupDBDAO.getCoupon(id);
	}
	// Returns Collection<Coupon> of all existing coupons
	private ArrayList<Coupon> getAllCoupons()
	{
		return null;
	}
	

}
