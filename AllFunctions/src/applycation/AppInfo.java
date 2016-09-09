package applycation;

import android.graphics.drawable.Drawable;

public class AppInfo {
	public int versionCode = 0;
	// Ãû³Æ
	public String appname = "";
	// °ü
	public String packagename = "";
	public String versionName = "";
	// Í¼±ê
	public Drawable appicon = null;
	public int getVersionCode() {
		return versionCode;
	}
	public void setVersionCode(int versionCode) {
		this.versionCode = versionCode;
	}
	public String getAppname() {
		return appname;
	}
	public void setAppname(String appname) {
		this.appname = appname;
	}
	public String getPackagename() {
		return packagename;
	}
	public void setPackagename(String packagename) {
		this.packagename = packagename;
	}
	public String getVersionName() {
		return versionName;
	}
	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}
	public Drawable getAppicon() {
		return appicon;
	}
	public void setAppicon(Drawable appicon) {
		this.appicon = appicon;
	}
	
	
	
}