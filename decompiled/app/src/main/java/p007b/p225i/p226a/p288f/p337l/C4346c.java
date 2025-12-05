package p007b.p225i.p226a.p288f.p337l;

import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.api.Scope;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p288f.p299e.p300h.C3266a;
import p007b.p225i.p226a.p288f.p337l.p338b.C4336a;

/* compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* renamed from: b.i.a.f.l.c */
/* loaded from: classes3.dex */
public final class C4346c {

    /* renamed from: a */
    public static final C3266a.g<C4336a> f11454a;

    /* renamed from: b */
    public static final C3266a.g<C4336a> f11455b;

    /* renamed from: c */
    public static final C3266a.a<C4336a, C4335a> f11456c;

    /* renamed from: d */
    public static final C3266a.a<C4336a, C4350g> f11457d;

    static {
        C3266a.g<C4336a> gVar = new C3266a.g<>();
        f11454a = gVar;
        C3266a.g<C4336a> gVar2 = new C3266a.g<>();
        f11455b = gVar2;
        C4348e c4348e = new C4348e();
        f11456c = c4348e;
        C4347d c4347d = new C4347d();
        f11457d = c4347d;
        new Scope("profile");
        new Scope(NotificationCompat.CATEGORY_EMAIL);
        AnimatableValueParser.m595z(c4348e, "Cannot construct an Api with a null ClientBuilder");
        AnimatableValueParser.m595z(gVar, "Cannot construct an Api with a null ClientKey");
        AnimatableValueParser.m595z(c4347d, "Cannot construct an Api with a null ClientBuilder");
        AnimatableValueParser.m595z(gVar2, "Cannot construct an Api with a null ClientKey");
    }
}
