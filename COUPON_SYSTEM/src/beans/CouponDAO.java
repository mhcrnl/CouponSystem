package beans;

public interface CouponDAO {

	 void createCoupon(Coupon Coupon);
	 void removeCoupon(Coupon Coupon);
	 void updateCoupon(Coupon Coupon);
	 void getCoupon(long id);
	 void getAllCoupons();
	 void getCouponByType();

}
