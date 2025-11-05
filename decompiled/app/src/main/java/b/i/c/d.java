package b.i.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;

/* compiled from: FirebaseCommonRegistrar.java */
/* loaded from: classes3.dex */
public final /* synthetic */ class d implements b.i.c.x.g {
    public static final d a = new d();

    @Override // b.i.c.x.g
    public String a(Object obj) {
        ApplicationInfo applicationInfo = ((Context) obj).getApplicationInfo();
        return applicationInfo != null ? String.valueOf(applicationInfo.targetSdkVersion) : "";
    }
}
