package applycation;

import java.util.ArrayList;
import java.util.List;

import com.example.allfunctions.MainActivity;

import android.content.pm.PackageInfo;

public class AllApp {
	private ArrayList<AppInfo> appList;

	public ArrayList<AppInfo> getAppInfos() {
		appList = new ArrayList<AppInfo>();
//		List<PackageInfo> packages = getPackageManager()
//				.getInstalledPackages(0);
//		for (int i = 0; i < packages.size(); i++) {
//			PackageInfo packageInfo = packages.get(i);
//			AppInfo tmpInfo = new AppInfo();
//			tmpInfo.appname = packageInfo.applicationInfo.loadLabel(
//					getPackageManager()).toString();
//			tmpInfo.packagename = packageInfo.packageName;
//			tmpInfo.versionName = packageInfo.versionName;
//			tmpInfo.versionCode = packageInfo.versionCode;
//			tmpInfo.appicon = packageInfo.applicationInfo
//					.loadIcon(getPackageManager());
//			
//			tmpInfo.setAppname( packageInfo.applicationInfo.loadLabel(
//					getPackageManager()).toString());
//			
//			appList.add(tmpInfo);
			return appList;
//		}
	}

}
