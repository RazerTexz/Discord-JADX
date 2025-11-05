package b.i.c;

import android.content.Context;
import android.os.Build;

/* compiled from: FirebaseCommonRegistrar.java */
/* loaded from: classes3.dex */
public final /* synthetic */ class f implements b.i.c.x.g {
    public static final f a = new f();

    @Override // b.i.c.x.g
    public String a(Object obj) {
        Context context = (Context) obj;
        int i = Build.VERSION.SDK_INT;
        return context.getPackageManager().hasSystemFeature("android.hardware.type.television") ? "tv" : context.getPackageManager().hasSystemFeature("android.hardware.type.watch") ? "watch" : (i < 23 || !context.getPackageManager().hasSystemFeature("android.hardware.type.automotive")) ? (i < 26 || !context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) ? "" : "embedded" : "auto";
    }
}
