package p007b.p225i.p226a.p288f.p299e.p300h;

import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import java.util.Set;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p288f.p299e.p300h.AbstractC3268c;
import p007b.p225i.p226a.p288f.p299e.p300h.C3266a.d;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.InterfaceC3290f;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.InterfaceC3303l;
import p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b;
import p007b.p225i.p226a.p288f.p299e.p304k.C3347c;
import p007b.p225i.p226a.p288f.p299e.p304k.InterfaceC3355g;

/* compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* renamed from: b.i.a.f.e.h.a */
/* loaded from: classes3.dex */
public final class C3266a<O extends d> {

    /* renamed from: a */
    @Nullable
    public final a<?, O> f9323a;

    /* renamed from: b */
    @Nullable
    public final g<?> f9324b;

    /* renamed from: c */
    public final String f9325c;

    /* compiled from: com.google.android.gms:play-services-base@@17.3.0 */
    /* renamed from: b.i.a.f.e.h.a$a */
    public static abstract class a<T extends f, O> extends e<T, O> {
        @Deprecated
        /* renamed from: a */
        public T mo3996a(Context context, Looper looper, C3347c c3347c, O o, AbstractC3268c.a aVar, AbstractC3268c.b bVar) {
            return (T) mo3971b(context, looper, c3347c, o, aVar, bVar);
        }

        /* renamed from: b */
        public T mo3971b(Context context, Looper looper, C3347c c3347c, O o, InterfaceC3290f interfaceC3290f, InterfaceC3303l interfaceC3303l) {
            throw new UnsupportedOperationException("buildClient must be implemented");
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.3.0 */
    /* renamed from: b.i.a.f.e.h.a$b */
    public interface b {
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.3.0 */
    /* renamed from: b.i.a.f.e.h.a$c */
    public static class c<C extends b> {
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.3.0 */
    /* renamed from: b.i.a.f.e.h.a$d */
    public interface d {

        /* compiled from: com.google.android.gms:play-services-base@@17.3.0 */
        /* renamed from: b.i.a.f.e.h.a$d$a */
        public interface a extends d {
            /* renamed from: T */
            Account m4028T();
        }

        /* compiled from: com.google.android.gms:play-services-base@@17.3.0 */
        /* renamed from: b.i.a.f.e.h.a$d$b */
        public interface b extends d {
            /* renamed from: L */
            GoogleSignInAccount m4029L();
        }

        /* compiled from: com.google.android.gms:play-services-base@@17.3.0 */
        /* renamed from: b.i.a.f.e.h.a$d$c */
        public static final class c implements d {
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.3.0 */
    /* renamed from: b.i.a.f.e.h.a$e */
    public static abstract class e<T extends b, O> {
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.3.0 */
    /* renamed from: b.i.a.f.e.h.a$f */
    public interface f extends b {
        @NonNull
        /* renamed from: a */
        Set<Scope> mo4030a();

        /* renamed from: b */
        void m4031b(@Nullable InterfaceC3355g interfaceC3355g, @Nullable Set<Scope> set);

        /* renamed from: c */
        void m4032c(String str);

        /* renamed from: e */
        boolean m4033e();

        /* renamed from: f */
        String m4034f();

        /* renamed from: g */
        void m4035g(AbstractC3345b.c cVar);

        /* renamed from: h */
        void mo4036h();

        /* renamed from: i */
        void m4037i(AbstractC3345b.e eVar);

        /* renamed from: j */
        boolean m4038j();

        /* renamed from: k */
        boolean mo4039k();

        /* renamed from: l */
        int mo3982l();

        /* renamed from: m */
        Feature[] m4040m();

        @Nullable
        /* renamed from: n */
        String m4041n();

        /* renamed from: o */
        boolean mo4042o();
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.3.0 */
    /* renamed from: b.i.a.f.e.h.a$g */
    public static final class g<C extends f> extends c<C> {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <C extends f> C3266a(String str, a<C, O> aVar, g<C> gVar) {
        AnimatableValueParser.m595z(aVar, "Cannot construct an Api with a null ClientBuilder");
        AnimatableValueParser.m595z(gVar, "Cannot construct an Api with a null ClientKey");
        this.f9325c = str;
        this.f9323a = aVar;
        this.f9324b = gVar;
    }
}
