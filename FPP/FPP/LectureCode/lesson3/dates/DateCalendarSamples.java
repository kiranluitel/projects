package lesson3.dates;
import java.text.*;
import java.util.*;


public class DateCalendarSamples {

    String datePattern;

    public DateCalendarSamples(String pattern) {
        datePattern = pattern;

        Locale locale = Locale.US;

        SimpleDateFormat formatter = new SimpleDateFormat(datePattern,locale);

        String dateString = formatter.format(new Date());
        System.out.println("Today's date: " + dateString);

    }
    public static void main(String [] args) {
        new DateCalendarSamples("MM-dd-yy");
        DateCalendarSamples dm = new DateCalendarSamples("M-dd-yy");
        dm.fromSlides();
        dm.testConversion();
        dm.testCalendar();
    } 
    
    public void fromSlides() {
    	//////////j2se5.0: can use String.format with printf options
		String format = "%tD";
		Date d = new Date();
		String formattedDate = String.format(format, d); // has form MM/dd/yy
		System.out.println(formattedDate);
    	
    	///////////pre – j2se5.0: use DateFormat and/or SimpleDateFormat

		d = new Date();
    	DateFormat f = 
    	DateFormat.getDateInstance(DateFormat.SHORT);
    	formattedDate = f.format(d); // form: MM/dd/yy
    	System.out.println(formattedDate);
    	

    	//for finer control, where locale is enough like US 
    	//use SimpleDateFormat
    	d = new Date();
    	SimpleDateFormat f1 = 
    	   (SimpleDateFormat)DateFormat.getDateInstance();
		String myFormat = "yyyy/MM/dd";
		f1.applyPattern(myFormat);
		formattedDate = f1.format(d);
		System.out.println(formattedDate);

    }

    public void testCalendar() {
        //gets today's time in this time zone and this locale
        Calendar cal = GregorianCalendar.getInstance();
        System.out.println("Default time zone: "+ cal.getTimeZone().getID());
        Date d = cal.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy",Locale.US);
        System.out.println("Current date = " + formatter.format(d));

        //creates a new date
        cal = new GregorianCalendar(1951, Calendar.JANUARY, 1);
        System.out.println("1951 date = "+ formatter.format(cal.getTime()));

        //test milliseconds methods
        long l = cal.getTime().getTime();
        d = new Date(l);
        System.out.println("date after getting it in milliseconds = " + formatter.format(d));
    }

    public void testConversion() {
        Date d = new Date(100000L);
        Locale loc = Locale.US;
        SimpleDateFormat twoDig = new SimpleDateFormat("MM-dd-yy", loc);
        SimpleDateFormat fourDig= new SimpleDateFormat("MM-dd-yyyy", loc);
        String s = twoDig.format(d);
        System.out.println("Here's Dec 31, 1969 in 2 digit format: "+twoDig.format(d));
        System.out.println("Here's Dec 31, 1969 in 4 digit format: "+fourDig.format(d));
    }

   
    public static void pause() {
        try {
            System.in.read();
        }
        catch(Exception e) {}
    }
}




