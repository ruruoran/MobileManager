package androidTest.java.com.merson.mobile.mobilemanager;

import com.merson.mobile.dao.NumberLocationDao;

import android.test.AndroidTestCase;
import android.util.Log;
import android.widget.Toast;

public class MyAndroidTestCase extends AndroidTestCase {

	//test��ͷ
	public void testinfo(){
		Log.i("Tag","123");
	}
	
	
	//���Ա������ߺ�������ز�ѯAPI�Ƿ�ok
	
	public void testQuery(){
		final String numberLocation = NumberLocationDao.getNumberLocation("13688889272", getContext());
	
		Toast.makeText(getContext(), numberLocation, Toast.LENGTH_SHORT).show();
		
		Log.i("TAG",numberLocation);
	}
	
}
