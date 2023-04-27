import java.util.Calendar;
import java.util.Locale;

public class FindDay {

	@SuppressWarnings("deprecation")
	public static String getDay(int day, int month, int year) {

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.DAY_OF_MONTH, day);
		cal.set(Calendar.YEAR, year);
		return cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US).toUpperCase();
	}

	public static void main(String[] args) {
		System.out.println(getDay(8, 14, 2017));
	}

}
