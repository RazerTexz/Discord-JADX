package b.i.a.f.l;

import androidx.core.app.NotificationCompat;
import b.i.a.f.e.h.a;
import com.google.android.gms.common.api.Scope;

/* compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* loaded from: classes3.dex */
public final class c {
    public static final a.g<b.i.a.f.l.b.a> a;

    /* renamed from: b, reason: collision with root package name */
    public static final a.g<b.i.a.f.l.b.a> f1590b;
    public static final a.AbstractC0112a<b.i.a.f.l.b.a, a> c;
    public static final a.AbstractC0112a<b.i.a.f.l.b.a, g> d;

    static {
        a.g<b.i.a.f.l.b.a> gVar = new a.g<>();
        a = gVar;
        a.g<b.i.a.f.l.b.a> gVar2 = new a.g<>();
        f1590b = gVar2;
        e eVar = new e();
        c = eVar;
        d dVar = new d();
        d = dVar;
        new Scope("profile");
        new Scope(NotificationCompat.CATEGORY_EMAIL);
        b.c.a.a0.d.z(eVar, "Cannot construct an Api with a null ClientBuilder");
        b.c.a.a0.d.z(gVar, "Cannot construct an Api with a null ClientKey");
        b.c.a.a0.d.z(dVar, "Cannot construct an Api with a null ClientBuilder");
        b.c.a.a0.d.z(gVar2, "Cannot construct an Api with a null ClientKey");
    }
}
