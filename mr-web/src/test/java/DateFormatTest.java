import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lql
 * @date 2019/12/20 10:51
 */

public class DateFormatTest {
    @Test
    public void dateFormateTest() throws ParseException {
        String str="2019-1-1";
        String str2="2019-01-01";
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date date=dateFormat.parse(str2);
        str2=dateFormat.format(date);
        System.out.println(str2);
    }
}
