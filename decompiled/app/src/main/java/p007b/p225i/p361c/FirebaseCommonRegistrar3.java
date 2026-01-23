package p007b.p225i.p361c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import p007b.p225i.p361c.p407x.LibraryVersionComponent2;

/* JADX INFO: renamed from: b.i.c.e, reason: use source file name */
/* JADX INFO: compiled from: FirebaseCommonRegistrar.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class FirebaseCommonRegistrar3 implements LibraryVersionComponent2 {

    /* JADX INFO: renamed from: a */
    public static final FirebaseCommonRegistrar3 f12131a = new FirebaseCommonRegistrar3();

    @Override // p007b.p225i.p361c.p407x.LibraryVersionComponent2
    /* JADX INFO: renamed from: a */
    public String mo6336a(Object obj) {
        ApplicationInfo applicationInfo = ((Context) obj).getApplicationInfo();
        return (applicationInfo == null || Build.VERSION.SDK_INT < 24) ? "" : String.valueOf(applicationInfo.minSdkVersion);
    }
}
