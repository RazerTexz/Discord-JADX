package p007b.p225i.p361c;

import android.content.Context;
import com.google.firebase.FirebaseCommonRegistrar;
import p007b.p225i.p361c.p407x.LibraryVersionComponent2;

/* JADX INFO: renamed from: b.i.c.g, reason: use source file name */
/* JADX INFO: compiled from: FirebaseCommonRegistrar.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class FirebaseCommonRegistrar5 implements LibraryVersionComponent2 {

    /* JADX INFO: renamed from: a */
    public static final FirebaseCommonRegistrar5 f12133a = new FirebaseCommonRegistrar5();

    @Override // p007b.p225i.p361c.p407x.LibraryVersionComponent2
    /* JADX INFO: renamed from: a */
    public String mo6336a(Object obj) {
        Context context = (Context) obj;
        String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        return installerPackageName != null ? FirebaseCommonRegistrar.m9175a(installerPackageName) : "";
    }
}
