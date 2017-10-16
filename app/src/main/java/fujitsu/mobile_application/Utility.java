package fujitsu.mobile_application;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

//import android.provider.CalendarContract;

/**
 * @author Mukesh Y
 */
public class Utility {
    public static ArrayList<String> nameOfEvent = new ArrayList<String>();
    public static ArrayList<String> startDates = new ArrayList<String>();
    public static ArrayList<String> endDates = new ArrayList<String>();
    public static ArrayList<String> descriptions = new ArrayList<String>();


//    public void addEvent(String title, String location, long begin, long end){
//        Intent intent = new Intent(Intent.ACTION_INSERT)
//                .setData(CalendarContract.Events.CONTENT_URI)
//                .putExtra(CalendarContract.Events.TITLE, title)
//                .putExtra(CalendarContract.Events.EVENT_LOCATION, location)
//                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, begin)
//                .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, end);
//        if (intent.resolveActivity(getPackageManager() != null));
//        startActivity(intent);
//    }



    public static ArrayList<String> readCalendarEvent(Context context) {
//        Cursor cursor = context.get
//        Intent calIntent = new Intent(Intent.ACTION_INSERT);
//        calIntent.setData(CalendarContract.Events.CONTENT_URI);
//        calIntent.setType("vnd.android.cursor.item/event");
//        calIntent.putExtra(CalendarContract.Events.TITLE, "My House Party");
//        calIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, "My Beach House");
//        calIntent.putExtra(CalendarContract.Events.DESCRIPTION, "A Pig Roast on the Beach");
//        GregorianCalendar calDate = new GregorianCalendar(2017, 9, 26);
//        calIntent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true);
//        calIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
//                calDate.getTimeInMillis());
//        calIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
//                calDate.getTimeInMillis());
//        context.startActivity(calIntent);

        Cursor cursor = context.getContentResolver()
                .query(Uri.parse("content://com.android.calendar/events"),
                        new String[] { "calendar_id", "title", "description",
                                "dtstart", "dtend", "eventLocation" }, null,
                        null, null);
        cursor.moveToFirst();
        // fetching calendars name
        String CNames[] = new String[cursor.getCount()];

        // fetching calendars id
        nameOfEvent.clear();
        startDates.clear();
        endDates.clear();
        descriptions.clear();

        for (int i = 0; i < CNames.length; i++) {

            nameOfEvent.add(cursor.getString(1));
            startDates.add(getDate(Long.parseLong(cursor.getString(3))));
            endDates.add(getDate(Long.parseLong(cursor.getString(4))));
            descriptions.add(cursor.getString(2));
            CNames[i] = cursor.getString(1);
            cursor.moveToNext();

        }
        return nameOfEvent;
    }

    public static String getDate(long milliSeconds) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        return formatter.format(calendar.getTime());
    }
}
