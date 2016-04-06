package androidTest.java.com.merson.mobile.mobilemanager;

import java.util.List;

import com.merson.mobile.bean.AppInfo;
import com.merson.mobile.utils.PackageUtils;

import android.test.AndroidTestCase;
import android.util.Log;
import android.widget.Toast;

public class myTestCase extends AndroidTestCase {

	public void test(){
		Toast.makeText(getContext(),"ok",Toast.LENGTH_LONG).show();
		  Log.i("tag", "tag");	}
	
	public void testStatFs1(){
		long size = PackageUtils.getAvailableROMSize();
		Log.i("tag",size+"");
	}
	
	
	public void testStatFs2(){
		long size = PackageUtils.getAvailableSDcardSize();
		Log.i("tag",size+"");
	}
	
	public void testgetAppinfolist(){
		final List<AppInfo> allAppInfo = PackageUtils.getAllAppInfo(getContext());
		for (AppInfo appInfo : allAppInfo) {
		}
		
	}
	
	
}


