package p007b.p225i.p226a.p288f.p313h.p323j;

import android.content.Context;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p339m.C4351a;

/* renamed from: b.i.a.f.h.j.s0 */
/* loaded from: classes3.dex */
public final class C3541s0 {

    /* renamed from: a */
    public static Object f9796a = new Object();

    /* renamed from: b */
    public static C4351a f9797b;

    /* renamed from: c */
    public static Boolean f9798c;

    /* renamed from: a */
    public static boolean m4499a(Context context) {
        Objects.requireNonNull(context, "null reference");
        Boolean bool = f9798c;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean zM4515a = C3555z0.m4515a(context, "com.google.android.gms.analytics.AnalyticsReceiver", false);
        f9798c = Boolean.valueOf(zM4515a);
        return zM4515a;
    }
}
