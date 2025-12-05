package p007b.p225i.p361c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import p007b.p225i.p361c.p407x.LibraryVersionComponent2;

/* compiled from: FirebaseCommonRegistrar.java */
/* renamed from: b.i.c.d, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class FirebaseCommonRegistrar2 implements LibraryVersionComponent2 {

    /* renamed from: a */
    public static final FirebaseCommonRegistrar2 f12130a = new FirebaseCommonRegistrar2();

    @Override // p007b.p225i.p361c.p407x.LibraryVersionComponent2
    /* renamed from: a */
    public String mo6336a(Object obj) {
        ApplicationInfo applicationInfo = ((Context) obj).getApplicationInfo();
        return applicationInfo != null ? String.valueOf(applicationInfo.targetSdkVersion) : "";
    }
}
