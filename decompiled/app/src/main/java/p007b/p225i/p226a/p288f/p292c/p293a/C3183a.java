package p007b.p225i.p226a.p288f.p292c.p293a;

import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import java.util.Arrays;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p288f.p292c.p293a.p294d.InterfaceC3188c;
import p007b.p225i.p226a.p288f.p292c.p293a.p296f.p297b.C3203f;
import p007b.p225i.p226a.p288f.p299e.p300h.C3266a;
import p007b.p225i.p226a.p288f.p313h.p316c.C3459h;
import p007b.p225i.p226a.p288f.p313h.p316c.C3466o;
import p007b.p225i.p226a.p288f.p313h.p317d.C3476d;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* renamed from: b.i.a.f.c.a.a */
/* loaded from: classes3.dex */
public final class C3183a {

    /* renamed from: a */
    public static final C3266a.g<C3466o> f9203a;

    /* renamed from: b */
    public static final C3266a.g<C3203f> f9204b;

    /* renamed from: c */
    public static final C3266a.a<C3466o, a> f9205c;

    /* renamed from: d */
    public static final C3266a.a<C3203f, GoogleSignInOptions> f9206d;

    /* renamed from: e */
    public static final C3266a<a> f9207e;

    /* renamed from: f */
    public static final C3266a<GoogleSignInOptions> f9208f;

    /* renamed from: g */
    public static final InterfaceC3188c f9209g;

    /* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
    @Deprecated
    /* renamed from: b.i.a.f.c.a.a$a */
    public static class a implements C3266a.d {

        /* renamed from: j */
        public static final a f9210j = new a(new C13228a());

        /* renamed from: k */
        public final String f9211k;

        /* renamed from: l */
        public final boolean f9212l;

        /* renamed from: m */
        @Nullable
        public final String f9213m;

        public a(C13228a c13228a) {
            this.f9211k = c13228a.f9214a;
            this.f9212l = c13228a.f9215b.booleanValue();
            this.f9213m = c13228a.f9216c;
        }

        public boolean equals(@Nullable Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return AnimatableValueParser.m524h0(this.f9211k, aVar.f9211k) && this.f9212l == aVar.f9212l && AnimatableValueParser.m524h0(this.f9213m, aVar.f9213m);
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.f9211k, Boolean.valueOf(this.f9212l), this.f9213m});
        }

        /* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
        @Deprecated
        /* renamed from: b.i.a.f.c.a.a$a$a, reason: collision with other inner class name */
        public static class C13228a {

            /* renamed from: a */
            public String f9214a;

            /* renamed from: b */
            public Boolean f9215b;

            /* renamed from: c */
            @Nullable
            public String f9216c;

            public C13228a() {
                this.f9215b = Boolean.FALSE;
            }

            public C13228a(a aVar) {
                this.f9215b = Boolean.FALSE;
                this.f9214a = aVar.f9211k;
                this.f9215b = Boolean.valueOf(aVar.f9212l);
                this.f9216c = aVar.f9213m;
            }
        }
    }

    static {
        C3266a.g<C3466o> gVar = new C3266a.g<>();
        f9203a = gVar;
        C3266a.g<C3203f> gVar2 = new C3266a.g<>();
        f9204b = gVar2;
        C3224h c3224h = new C3224h();
        f9205c = c3224h;
        C3225i c3225i = new C3225i();
        f9206d = c3225i;
        C3266a<C3185c> c3266a = C3184b.f9219c;
        f9207e = new C3266a<>("Auth.CREDENTIALS_API", c3224h, gVar);
        f9208f = new C3266a<>("Auth.GOOGLE_SIGN_IN_API", c3225i, gVar2);
        C3476d c3476d = C3184b.f9220d;
        f9209g = new C3459h();
    }
}
