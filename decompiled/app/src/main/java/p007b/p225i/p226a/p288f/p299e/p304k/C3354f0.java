package p007b.p225i.p226a.p288f.p299e.p304k;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import p007b.p225i.p226a.p288f.p299e.p310p.C3411b;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* renamed from: b.i.a.f.e.k.f0 */
/* loaded from: classes3.dex */
public final class C3354f0 {

    /* renamed from: a */
    public static final Object f9519a = new Object();

    /* renamed from: b */
    public static boolean f9520b;

    /* renamed from: c */
    @Nullable
    public static String f9521c;

    /* renamed from: d */
    public static int f9522d;

    /* renamed from: a */
    public static void m4155a(Context context) {
        Bundle bundle;
        synchronized (f9519a) {
            if (f9520b) {
                return;
            }
            f9520b = true;
            try {
                bundle = C3411b.m4376a(context).m4373a(context.getPackageName(), 128).metaData;
            } catch (PackageManager.NameNotFoundException e) {
                Log.wtf("MetadataValueReader", "This should never happen.", e);
            }
            if (bundle == null) {
                return;
            }
            f9521c = bundle.getString("com.google.app.id");
            f9522d = bundle.getInt("com.google.android.gms.version");
        }
    }
}
