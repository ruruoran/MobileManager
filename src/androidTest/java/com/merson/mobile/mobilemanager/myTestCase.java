package androidTest.java.com.merson.mobile.mobilemanager;

import android.test.AndroidTestCase;
import android.util.Log;
import android.widget.Toast;

public class myTestCase extends AndroidTestCase {

	public void test(){
		Toast.makeText(getContext(),"ok",Toast.LENGTH_LONG).show();
		  Log.i("tag", "tag");	}
}
