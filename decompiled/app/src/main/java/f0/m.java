package f0;

import f0.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import kotlin.TypeCastException;

/* compiled from: ConnectionSpec.kt */
/* loaded from: classes3.dex */
public final class m {
    public static final j[] a;

    /* renamed from: b, reason: collision with root package name */
    public static final j[] f3674b;
    public static final m c;
    public static final m d;
    public final boolean e;
    public final boolean f;
    public final String[] g;
    public final String[] h;

    /* compiled from: ConnectionSpec.kt */
    public static final class a {
        public boolean a;

        /* renamed from: b, reason: collision with root package name */
        public String[] f3675b;
        public String[] c;
        public boolean d;

        public a(boolean z2) {
            this.a = z2;
        }

        public final m a() {
            return new m(this.a, this.d, this.f3675b, this.c);
        }

        public final a b(String... strArr) throws CloneNotSupportedException {
            d0.z.d.m.checkParameterIsNotNull(strArr, "cipherSuites");
            if (!this.a) {
                throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
            }
            if (!(!(strArr.length == 0))) {
                throw new IllegalArgumentException("At least one cipher suite is required".toString());
            }
            Object objClone = strArr.clone();
            if (objClone == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
            }
            this.f3675b = (String[]) objClone;
            return this;
        }

        public final a c(j... jVarArr) throws CloneNotSupportedException {
            d0.z.d.m.checkParameterIsNotNull(jVarArr, "cipherSuites");
            if (!this.a) {
                throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
            }
            ArrayList arrayList = new ArrayList(jVarArr.length);
            for (j jVar : jVarArr) {
                arrayList.add(jVar.t);
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            String[] strArr = (String[]) array;
            b((String[]) Arrays.copyOf(strArr, strArr.length));
            return this;
        }

        public final a d(boolean z2) {
            if (!this.a) {
                throw new IllegalArgumentException("no TLS extensions for cleartext connections".toString());
            }
            this.d = z2;
            return this;
        }

        public final a e(String... strArr) throws CloneNotSupportedException {
            d0.z.d.m.checkParameterIsNotNull(strArr, "tlsVersions");
            if (!this.a) {
                throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
            }
            if (!(!(strArr.length == 0))) {
                throw new IllegalArgumentException("At least one TLS version is required".toString());
            }
            Object objClone = strArr.clone();
            if (objClone == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
            }
            this.c = (String[]) objClone;
            return this;
        }

        public final a f(d0... d0VarArr) throws CloneNotSupportedException {
            d0.z.d.m.checkParameterIsNotNull(d0VarArr, "tlsVersions");
            if (!this.a) {
                throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
            }
            ArrayList arrayList = new ArrayList(d0VarArr.length);
            for (d0 d0Var : d0VarArr) {
                arrayList.add(d0Var.f());
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            String[] strArr = (String[]) array;
            e((String[]) Arrays.copyOf(strArr, strArr.length));
            return this;
        }

        public a(m mVar) {
            d0.z.d.m.checkParameterIsNotNull(mVar, "connectionSpec");
            this.a = mVar.e;
            this.f3675b = mVar.g;
            this.c = mVar.h;
            this.d = mVar.f;
        }
    }

    static {
        j jVar = j.p;
        j jVar2 = j.q;
        j jVar3 = j.r;
        j jVar4 = j.j;
        j jVar5 = j.l;
        j jVar6 = j.k;
        j jVar7 = j.m;
        j jVar8 = j.o;
        j jVar9 = j.n;
        j[] jVarArr = {jVar, jVar2, jVar3, jVar4, jVar5, jVar6, jVar7, jVar8, jVar9};
        a = jVarArr;
        j[] jVarArr2 = {jVar, jVar2, jVar3, jVar4, jVar5, jVar6, jVar7, jVar8, jVar9, j.h, j.i, j.f, j.g, j.d, j.e, j.c};
        f3674b = jVarArr2;
        a aVar = new a(true);
        aVar.c((j[]) Arrays.copyOf(jVarArr, jVarArr.length));
        d0 d0Var = d0.TLS_1_3;
        d0 d0Var2 = d0.TLS_1_2;
        aVar.f(d0Var, d0Var2);
        aVar.d(true);
        aVar.a();
        a aVar2 = new a(true);
        aVar2.c((j[]) Arrays.copyOf(jVarArr2, jVarArr2.length));
        aVar2.f(d0Var, d0Var2);
        aVar2.d(true);
        c = aVar2.a();
        a aVar3 = new a(true);
        aVar3.c((j[]) Arrays.copyOf(jVarArr2, jVarArr2.length));
        aVar3.f(d0Var, d0Var2, d0.TLS_1_1, d0.TLS_1_0);
        aVar3.d(true);
        aVar3.a();
        d = new m(false, false, null, null);
    }

    public m(boolean z2, boolean z3, String[] strArr, String[] strArr2) {
        this.e = z2;
        this.f = z3;
        this.g = strArr;
        this.h = strArr2;
    }

    public final List<j> a() {
        String[] strArr = this.g;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(j.f3673s.b(str));
        }
        return d0.t.u.toList(arrayList);
    }

    public final boolean b(SSLSocket sSLSocket) {
        d0.z.d.m.checkParameterIsNotNull(sSLSocket, "socket");
        if (!this.e) {
            return false;
        }
        String[] strArr = this.h;
        if (strArr != null && !f0.e0.c.k(strArr, sSLSocket.getEnabledProtocols(), d0.u.a.naturalOrder())) {
            return false;
        }
        String[] strArr2 = this.g;
        if (strArr2 == null) {
            return true;
        }
        String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        j.b bVar = j.f3673s;
        Comparator<String> comparator = j.a;
        return f0.e0.c.k(strArr2, enabledCipherSuites, j.a);
    }

    public final List<d0> c() {
        String[] strArr = this.h;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(d0.p.a(str));
        }
        return d0.t.u.toList(arrayList);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof m)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        boolean z2 = this.e;
        m mVar = (m) obj;
        if (z2 != mVar.e) {
            return false;
        }
        return !z2 || (Arrays.equals(this.g, mVar.g) && Arrays.equals(this.h, mVar.h) && this.f == mVar.f);
    }

    public int hashCode() {
        if (!this.e) {
            return 17;
        }
        String[] strArr = this.g;
        int iHashCode = (527 + (strArr != null ? Arrays.hashCode(strArr) : 0)) * 31;
        String[] strArr2 = this.h;
        return ((iHashCode + (strArr2 != null ? Arrays.hashCode(strArr2) : 0)) * 31) + (!this.f ? 1 : 0);
    }

    public String toString() {
        if (!this.e) {
            return "ConnectionSpec()";
        }
        StringBuilder sbX = b.d.b.a.a.X("ConnectionSpec(", "cipherSuites=");
        sbX.append(Objects.toString(a(), "[all enabled]"));
        sbX.append(", ");
        sbX.append("tlsVersions=");
        sbX.append(Objects.toString(c(), "[all enabled]"));
        sbX.append(", ");
        sbX.append("supportsTlsExtensions=");
        sbX.append(this.f);
        sbX.append(')');
        return sbX.toString();
    }
}
