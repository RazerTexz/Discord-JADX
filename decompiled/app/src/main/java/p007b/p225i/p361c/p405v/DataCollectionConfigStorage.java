package p007b.p225i.p361c.p405v;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import p007b.p225i.p361c.p396q.Publisher;

/* compiled from: DataCollectionConfigStorage.java */
/* renamed from: b.i.c.v.a, reason: use source file name */
/* loaded from: classes3.dex */
public class DataCollectionConfigStorage {

    /* renamed from: a */
    public final Context f13008a;

    /* renamed from: b */
    public final SharedPreferences f13009b;

    /* renamed from: c */
    public final Publisher f13010c;

    /* renamed from: d */
    public boolean f13011d;

    public DataCollectionConfigStorage(Context context, String str, Publisher publisher) {
        boolean z2;
        ApplicationInfo applicationInfo;
        Bundle bundle;
        context = Build.VERSION.SDK_INT >= 24 ? ContextCompat.createDeviceProtectedStorageContext(context) : context;
        this.f13008a = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.firebase.common.prefs:" + str, 0);
        this.f13009b = sharedPreferences;
        this.f13010c = publisher;
        boolean z3 = true;
        if (sharedPreferences.contains("firebase_data_collection_default_enabled")) {
            z2 = sharedPreferences.getBoolean("firebase_data_collection_default_enabled", true);
        } else {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128)) != null && (bundle = applicationInfo.metaData) != null && bundle.containsKey("firebase_data_collection_default_enabled")) {
                    z3 = applicationInfo.metaData.getBoolean("firebase_data_collection_default_enabled");
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
            z2 = z3;
        }
        this.f13011d = z2;
    }
}
