package p007b.p225i.p361c.p369m.p370d.p373k;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.StatFs;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import com.adjust.sdk.Constants;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;
import p007b.p225i.p361c.p369m.p370d.Logger3;
import p007b.p225i.p361c.p369m.p370d.p379p.CodedOutputStream2;

/* compiled from: CommonUtils.java */
/* renamed from: b.i.c.m.d.k.h, reason: use source file name */
/* loaded from: classes3.dex */
public class CommonUtils {

    /* renamed from: a */
    public static final char[] f12297a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b */
    public static long f12298b = -1;

    /* renamed from: c */
    public static final Comparator<File> f12299c = new a();

    /* compiled from: CommonUtils.java */
    /* renamed from: b.i.c.m.d.k.h$a */
    public class a implements Comparator<File> {
        @Override // java.util.Comparator
        public int compare(File file, File file2) {
            return (int) (file.lastModified() - file2.lastModified());
        }
    }

    /* compiled from: CommonUtils.java */
    /* renamed from: b.i.c.m.d.k.h$b */
    public enum b {
        X86_32,
        X86_64,
        ARM_UNKNOWN,
        PPC,
        PPC64,
        ARMV6,
        ARMV7,
        UNKNOWN,
        ARMV7S,
        ARM64;


        /* renamed from: t */
        public static final Map<String, b> f12310t;

        static {
            b bVar = X86_32;
            b bVar2 = ARMV6;
            b bVar3 = ARMV7;
            b bVar4 = ARM64;
            HashMap map = new HashMap(4);
            f12310t = map;
            map.put("armeabi-v7a", bVar3);
            map.put("armeabi", bVar2);
            map.put("arm64-v8a", bVar4);
            map.put("x86", bVar);
        }
    }

    /* renamed from: a */
    public static long m6407a(String str) {
        long blockSize = new StatFs(str).getBlockSize();
        return (r0.getBlockCount() * blockSize) - (blockSize * r0.getAvailableBlocks());
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: b */
    public static boolean m6408b(Context context) {
        if (!(context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0)) {
            return true;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    /* renamed from: c */
    public static void m6409c(Closeable closeable, String str) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                if (Logger3.f12227a.m6370a(6)) {
                    Log.e("FirebaseCrashlytics", str, e);
                }
            }
        }
    }

    /* renamed from: d */
    public static void m6410d(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: e */
    public static long m6411e(String str, String str2, int i) {
        return Long.parseLong(str.split(str2)[0].trim()) * i;
    }

    /* renamed from: f */
    public static String m6412f(String... strArr) {
        if (strArr.length != 0) {
            ArrayList arrayList = new ArrayList();
            for (String str : strArr) {
                if (str != null) {
                    arrayList.add(str.replace("-", "").toLowerCase(Locale.US));
                }
            }
            Collections.sort(arrayList);
            StringBuilder sb = new StringBuilder();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                sb.append((String) it.next());
            }
            String string = sb.toString();
            if (string.length() > 0) {
                return m6429w(string);
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0035, code lost:
    
        r2 = r3[1];
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.BufferedReader] */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String m6413g(File file, String str) throws Throwable {
        ?? Exists = file.exists();
        String str2 = null;
        str2 = null;
        str2 = null;
        Closeable closeable = null;
        try {
            if (Exists != 0) {
                try {
                    Exists = new BufferedReader(new FileReader(file), 1024);
                    while (true) {
                        try {
                            String line = Exists.readLine();
                            if (line == null) {
                                break;
                            }
                            String[] strArrSplit = Pattern.compile("\\s*:\\s*").split(line, 2);
                            if (strArrSplit.length > 1 && strArrSplit[0].equals(str)) {
                                break;
                            }
                        } catch (Exception e) {
                            e = e;
                            Logger3.f12227a.m6374e("Error parsing " + file, e);
                            m6409c(Exists, "Failed to close system file reader.");
                            return str2;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    Exists = 0;
                } catch (Throwable th) {
                    th = th;
                    m6409c(closeable, "Failed to close system file reader.");
                    throw th;
                }
                m6409c(Exists, "Failed to close system file reader.");
            }
            return str2;
        } catch (Throwable th2) {
            th = th2;
            closeable = Exists;
        }
    }

    /* renamed from: h */
    public static void m6414h(Flushable flushable, String str) {
        if (flushable != null) {
            try {
                ((CodedOutputStream2) flushable).flush();
            } catch (IOException e) {
                if (Logger3.f12227a.m6370a(6)) {
                    Log.e("FirebaseCrashlytics", str, e);
                }
            }
        }
    }

    /* renamed from: i */
    public static ActivityManager.RunningAppProcessInfo m6415i(String str, Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY)).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.processName.equals(str)) {
                    return runningAppProcessInfo;
                }
            }
        }
        return null;
    }

    /* renamed from: j */
    public static boolean m6416j(Context context, String str, boolean z2) {
        Resources resources;
        if (context != null && (resources = context.getResources()) != null) {
            int iM6420n = m6420n(context, str, "bool");
            if (iM6420n > 0) {
                return resources.getBoolean(iM6420n);
            }
            int iM6420n2 = m6420n(context, str, "string");
            if (iM6420n2 > 0) {
                return Boolean.parseBoolean(context.getString(iM6420n2));
            }
        }
        return z2;
    }

    /* renamed from: k */
    public static int m6417k(Context context) {
        boolean z2 = true;
        int i = m6425s(context) ? 1 : 0;
        if (m6427u(context)) {
            i |= 2;
        }
        if (!Debug.isDebuggerConnected() && !Debug.waitingForDebugger()) {
            z2 = false;
        }
        return z2 ? i | 4 : i;
    }

    /* renamed from: l */
    public static String m6418l(Context context) {
        int iM6420n = m6420n(context, "com.google.firebase.crashlytics.mapping_file_id", "string");
        if (iM6420n == 0) {
            iM6420n = m6420n(context, "com.crashlytics.android.build_id", "string");
        }
        if (iM6420n != 0) {
            return context.getResources().getString(iM6420n);
        }
        return null;
    }

    /* renamed from: m */
    public static boolean m6419m(Context context) {
        return (m6425s(context) || ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(8) == null) ? false : true;
    }

    /* renamed from: n */
    public static int m6420n(Context context, String str, String str2) {
        String packageName;
        Resources resources = context.getResources();
        int i = context.getApplicationContext().getApplicationInfo().icon;
        if (i > 0) {
            try {
                packageName = context.getResources().getResourcePackageName(i);
                if ("android".equals(packageName)) {
                    packageName = context.getPackageName();
                }
            } catch (Resources.NotFoundException unused) {
                packageName = context.getPackageName();
            }
        } else {
            packageName = context.getPackageName();
        }
        return resources.getIdentifier(str, str2, packageName);
    }

    /* renamed from: o */
    public static SharedPreferences m6421o(Context context) {
        return context.getSharedPreferences("com.google.firebase.crashlytics", 0);
    }

    /* renamed from: p */
    public static synchronized long m6422p() {
        if (f12298b == -1) {
            long jM6411e = 0;
            String strM6413g = m6413g(new File("/proc/meminfo"), "MemTotal");
            if (!TextUtils.isEmpty(strM6413g)) {
                String upperCase = strM6413g.toUpperCase(Locale.US);
                try {
                    if (upperCase.endsWith("KB")) {
                        jM6411e = m6411e(upperCase, "KB", 1024);
                    } else if (upperCase.endsWith("MB")) {
                        jM6411e = m6411e(upperCase, "MB", 1048576);
                    } else if (upperCase.endsWith("GB")) {
                        jM6411e = m6411e(upperCase, "GB", BasicMeasure.EXACTLY);
                    } else {
                        Logger3.f12227a.m6371b("Unexpected meminfo format while computing RAM: " + upperCase);
                    }
                } catch (NumberFormatException e) {
                    Logger3.f12227a.m6374e("Unexpected meminfo format while computing RAM: " + upperCase, e);
                }
            }
            f12298b = jM6411e;
        }
        return f12298b;
    }

    /* renamed from: q */
    public static String m6423q(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            int i3 = i * 2;
            char[] cArr2 = f12297a;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
        }
        return new String(cArr);
    }

    /* renamed from: r */
    public static void m6424r(Context context, View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    /* renamed from: s */
    public static boolean m6425s(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        String str = Build.PRODUCT;
        return "sdk".equals(str) || "google_sdk".equals(str) || string == null;
    }

    /* renamed from: t */
    public static boolean m6426t(String str) {
        return str == null || str.length() == 0;
    }

    /* renamed from: u */
    public static boolean m6427u(Context context) {
        boolean zM6425s = m6425s(context);
        String str = Build.TAGS;
        if ((zM6425s || str == null || !str.contains("test-keys")) && !new File("/system/app/Superuser.apk").exists()) {
            return !zM6425s && new File("/system/xbin/su").exists();
        }
        return true;
    }

    /* renamed from: v */
    public static String m6428v(int i) {
        if (i >= 0) {
            return String.format(Locale.US, "%1$10s", Integer.valueOf(i)).replace(' ', '0');
        }
        throw new IllegalArgumentException("value must be zero or greater");
    }

    /* renamed from: w */
    public static String m6429w(String str) {
        byte[] bytes = str.getBytes();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(Constants.SHA1);
            messageDigest.update(bytes);
            return m6423q(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            Logger3.f12227a.m6374e("Could not create hashing algorithm: " + Constants.SHA1 + ", returning empty string.", e);
            return "";
        }
    }

    /* renamed from: x */
    public static String m6430x(InputStream inputStream) throws IOException {
        Scanner scannerUseDelimiter = new Scanner(inputStream).useDelimiter("\\A");
        return scannerUseDelimiter.hasNext() ? scannerUseDelimiter.next() : "";
    }
}
