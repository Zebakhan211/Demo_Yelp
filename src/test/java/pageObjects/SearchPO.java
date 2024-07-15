package pageObjects;

public class SearchPO {
	
	public static String restaurant_xpath = "//android.widget.TextView[@resource-id=\"com.yelp.android:id/category_title\" and @text=\"Restaurants\"]";
	public static String sort_xpath = "//android.widget.TextView[@resource-id=\"com.yelp.android:id/pill_text\" and @text=\"Sort\"]";
	public static String distance_xpath = "(//android.view.View[@resource-id=\"com.yelp.android:id/group_radiobutton\"])[2]";

}
