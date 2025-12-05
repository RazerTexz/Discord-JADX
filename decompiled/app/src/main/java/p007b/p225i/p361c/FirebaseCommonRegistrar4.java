package p007b.p225i.p361c;

import android.content.Context;
import android.os.Build;
import p007b.p225i.p361c.p407x.LibraryVersionComponent2;

/* compiled from: FirebaseCommonRegistrar.java */
/* renamed from: b.i.c.f, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class FirebaseCommonRegistrar4 implements LibraryVersionComponent2 {

    /* renamed from: a */
    public static final FirebaseCommonRegistrar4 f12132a = new FirebaseCommonRegistrar4();

    @Override // p007b.p225i.p361c.p407x.LibraryVersionComponent2
    /* renamed from: a */
    public String mo6336a(Object obj) {
        Context context = (Context) obj;
        int i = Build.VERSION.SDK_INT;
        return context.getPackageManager().hasSystemFeature("android.hardware.type.television") ? "tv" : context.getPackageManager().hasSystemFeature("android.hardware.type.watch") ? "watch" : (i < 23 || !context.getPackageManager().hasSystemFeature("android.hardware.type.automotive")) ? (i < 26 || !context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) ? "" : "embedded" : "auto";
    }
}
