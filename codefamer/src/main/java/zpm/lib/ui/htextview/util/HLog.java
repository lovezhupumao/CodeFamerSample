package zpm.lib.ui.htextview.util;
import android.util.Log;

import zpm.lib.BuildConfig;


/**
 * Created by hanks on 15-12-14.
 */
public class HLog {
    public static void i(Object s){
        if(BuildConfig.DEBUG) {
            Log.i("HLog", s.toString());
        }
    }
}
