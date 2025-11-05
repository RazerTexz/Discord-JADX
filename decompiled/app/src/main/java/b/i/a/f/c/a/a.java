package b.i.a.f.c.a;

import androidx.annotation.Nullable;
import b.c.a.a0.d;
import b.i.a.f.c.a.f.b.f;
import b.i.a.f.e.h.a;
import b.i.a.f.h.c.o;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* loaded from: classes3.dex */
public final class a {
    public static final a.g<o> a;

    /* renamed from: b, reason: collision with root package name */
    public static final a.g<f> f1332b;
    public static final a.AbstractC0112a<o, C0110a> c;
    public static final a.AbstractC0112a<f, GoogleSignInOptions> d;
    public static final b.i.a.f.e.h.a<C0110a> e;
    public static final b.i.a.f.e.h.a<GoogleSignInOptions> f;
    public static final b.i.a.f.c.a.d.c g;

    /* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
    @Deprecated
    /* renamed from: b.i.a.f.c.a.a$a, reason: collision with other inner class name */
    public static class C0110a implements a.d {
        public static final C0110a j = new C0110a(new C0111a());
        public final String k;
        public final boolean l;

        @Nullable
        public final String m;

        public C0110a(C0111a c0111a) {
            this.k = c0111a.a;
            this.l = c0111a.f1333b.booleanValue();
            this.m = c0111a.c;
        }

        public boolean equals(@Nullable Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C0110a)) {
                return false;
            }
            C0110a c0110a = (C0110a) obj;
            return d.h0(this.k, c0110a.k) && this.l == c0110a.l && d.h0(this.m, c0110a.m);
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.k, Boolean.valueOf(this.l), this.m});
        }

        /* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
        @Deprecated
        /* renamed from: b.i.a.f.c.a.a$a$a, reason: collision with other inner class name */
        public static class C0111a {
            public String a;

            /* renamed from: b, reason: collision with root package name */
            public Boolean f1333b;

            @Nullable
            public String c;

            public C0111a() {
                this.f1333b = Boolean.FALSE;
            }

            public C0111a(C0110a c0110a) {
                this.f1333b = Boolean.FALSE;
                this.a = c0110a.k;
                this.f1333b = Boolean.valueOf(c0110a.l);
                this.c = c0110a.m;
            }
        }
    }

    static {
        a.g<o> gVar = new a.g<>();
        a = gVar;
        a.g<f> gVar2 = new a.g<>();
        f1332b = gVar2;
        h hVar = new h();
        c = hVar;
        i iVar = new i();
        d = iVar;
        b.i.a.f.e.h.a<c> aVar = b.c;
        e = new b.i.a.f.e.h.a<>("Auth.CREDENTIALS_API", hVar, gVar);
        f = new b.i.a.f.e.h.a<>("Auth.GOOGLE_SIGN_IN_API", iVar, gVar2);
        b.i.a.f.h.d.d dVar = b.d;
        g = new b.i.a.f.h.c.h();
    }
}
