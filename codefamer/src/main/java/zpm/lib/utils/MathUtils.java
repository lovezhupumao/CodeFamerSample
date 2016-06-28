package zpm.lib.utils;

import android.annotation.SuppressLint;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class MathUtils {
	/**
	 * 时间格式化:yyyy-MM-dd-HH:mm:ss
	 */
	@SuppressLint("SimpleDateFormat")
	public static String timeFormat(long time){
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        Date d1=new Date(time);  
        return format.format(d1);  
	}
}
