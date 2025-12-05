package p007b.p225i.p361c.p369m.p370d.p373k;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.FilenameFilter;
import p007b.p225i.p226a.p288f.p340n.C4358c0;
import p007b.p225i.p361c.FirebaseApp2;
import p007b.p225i.p361c.p369m.p370d.Logger3;

/* compiled from: DataCollectionArbiter.java */
/* renamed from: b.i.c.m.d.k.q0, reason: use source file name */
/* loaded from: classes3.dex */
public class DataCollectionArbiter {

    /* renamed from: a */
    public final SharedPreferences f12371a;

    /* renamed from: b */
    public final FirebaseApp2 f12372b;

    /* renamed from: c */
    public final Object f12373c;

    /* renamed from: d */
    public TaskCompletionSource<Void> f12374d;

    /* renamed from: e */
    public boolean f12375e;

    /* renamed from: f */
    public boolean f12376f;

    /* renamed from: g */
    @Nullable
    public Boolean f12377g;

    /* renamed from: h */
    public TaskCompletionSource<Void> f12378h;

    public DataCollectionArbiter(FirebaseApp2 firebaseApp2) {
        Boolean boolValueOf;
        Object obj = new Object();
        this.f12373c = obj;
        this.f12374d = new TaskCompletionSource<>();
        this.f12375e = false;
        this.f12376f = false;
        this.f12378h = new TaskCompletionSource<>();
        firebaseApp2.m6330a();
        Context context = firebaseApp2.f12118d;
        this.f12372b = firebaseApp2;
        SharedPreferences sharedPreferencesM6421o = CommonUtils.m6421o(context);
        this.f12371a = sharedPreferencesM6421o;
        if (sharedPreferencesM6421o.contains("firebase_crashlytics_collection_enabled")) {
            this.f12376f = false;
            boolValueOf = Boolean.valueOf(sharedPreferencesM6421o.getBoolean("firebase_crashlytics_collection_enabled", true));
        } else {
            boolValueOf = null;
        }
        this.f12377g = boolValueOf == null ? m6449a(context) : boolValueOf;
        synchronized (obj) {
            if (m6450b()) {
                this.f12374d.m9126b(null);
                this.f12375e = true;
            }
        }
    }

    @Nullable
    /* renamed from: a */
    public final Boolean m6449a(Context context) {
        PackageManager packageManager;
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            packageManager = context.getPackageManager();
        } catch (PackageManager.NameNotFoundException e) {
            if (Logger3.f12227a.m6370a(3)) {
                Log.d("FirebaseCrashlytics", "Unable to get PackageManager. Falling through", e);
            }
        }
        Boolean boolValueOf = (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_crashlytics_collection_enabled")) ? null : Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_crashlytics_collection_enabled"));
        if (boolValueOf == null) {
            this.f12376f = false;
            return null;
        }
        this.f12376f = true;
        return Boolean.valueOf(Boolean.TRUE.equals(boolValueOf));
    }

    /* renamed from: b */
    public synchronized boolean m6450b() {
        boolean zBooleanValue;
        Boolean bool = this.f12377g;
        zBooleanValue = bool != null ? bool.booleanValue() : this.f12372b.m6333g();
        Logger3.f12227a.m6371b(String.format("Crashlytics automatic data collection %s by %s.", zBooleanValue ? "ENABLED" : "DISABLED", this.f12377g == null ? "global Firebase setting" : this.f12376f ? "firebase_crashlytics_collection_enabled manifest flag" : "API"));
        return zBooleanValue;
    }

    /* renamed from: c */
    public Task<Void> m6451c() {
        C4358c0<Void> c4358c0;
        C4358c0<Void> c4358c02 = this.f12378h.f20845a;
        synchronized (this.f12373c) {
            c4358c0 = this.f12374d.f20845a;
        }
        FilenameFilter filenameFilter = Utils3.f12313a;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        Utils4 utils4 = new Utils4(taskCompletionSource);
        c4358c02.mo6013h(utils4);
        c4358c0.mo6013h(utils4);
        return taskCompletionSource.f20845a;
    }
}
