package p007b.p109f.p190m;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.StrictMode;
import android.util.Log;
import java.io.File;
import java.io.IOException;

/* compiled from: ApplicationSoSource.java */
/* renamed from: b.f.m.b, reason: use source file name */
/* loaded from: classes3.dex */
public class ApplicationSoSource extends SoSource {

    /* renamed from: a */
    public Context f4316a;

    /* renamed from: b */
    public int f4317b;

    /* renamed from: c */
    public DirectorySoSource f4318c;

    public ApplicationSoSource(Context context, int i) {
        Context applicationContext = context.getApplicationContext();
        this.f4316a = applicationContext;
        if (applicationContext == null) {
            Log.w("SoLoader", "context.getApplicationContext returned null, holding reference to original context.");
            this.f4316a = context;
        }
        this.f4317b = i;
        this.f4318c = new DirectorySoSource(new File(this.f4316a.getApplicationInfo().nativeLibraryDir), i);
    }

    /* renamed from: d */
    public static File m1567d(Context context) {
        return new File(context.getApplicationInfo().nativeLibraryDir);
    }

    @Override // p007b.p109f.p190m.SoSource
    /* renamed from: a */
    public int mo1568a(String str, int i, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        return this.f4318c.mo1568a(str, i, threadPolicy);
    }

    @Override // p007b.p109f.p190m.SoSource
    /* renamed from: b */
    public void mo1569b(int i) throws IOException {
        this.f4318c.mo1569b(i);
    }

    /* renamed from: c */
    public boolean m1570c() throws IOException {
        File file = this.f4318c.f4319a;
        Context contextM1571e = m1571e();
        File fileM1567d = m1567d(contextM1571e);
        if (file.equals(fileM1567d)) {
            return false;
        }
        Log.d("SoLoader", "Native library directory updated from " + file + " to " + fileM1567d);
        int i = this.f4317b | 1;
        this.f4317b = i;
        this.f4318c = new DirectorySoSource(fileM1567d, i);
        this.f4316a = contextM1571e;
        return true;
    }

    /* renamed from: e */
    public Context m1571e() {
        try {
            Context context = this.f4316a;
            return context.createPackageContext(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // p007b.p109f.p190m.SoSource
    public String toString() {
        return this.f4318c.toString();
    }
}
