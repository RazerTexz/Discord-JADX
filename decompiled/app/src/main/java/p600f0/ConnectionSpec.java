package p600f0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import kotlin.TypeCastException;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t._Collections;
import p507d0.p582u.C12169a;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.CipherSuite;
import p600f0.p601e0.Util7;

/* compiled from: ConnectionSpec.kt */
/* renamed from: f0.m, reason: use source file name */
/* loaded from: classes3.dex */
public final class ConnectionSpec {

    /* renamed from: a */
    public static final CipherSuite[] f25930a;

    /* renamed from: b */
    public static final CipherSuite[] f25931b;

    /* renamed from: c */
    public static final ConnectionSpec f25932c;

    /* renamed from: d */
    public static final ConnectionSpec f25933d;

    /* renamed from: e */
    public final boolean f25934e;

    /* renamed from: f */
    public final boolean f25935f;

    /* renamed from: g */
    public final String[] f25936g;

    /* renamed from: h */
    public final String[] f25937h;

    /* compiled from: ConnectionSpec.kt */
    /* renamed from: f0.m$a */
    public static final class a {

        /* renamed from: a */
        public boolean f25938a;

        /* renamed from: b */
        public String[] f25939b;

        /* renamed from: c */
        public String[] f25940c;

        /* renamed from: d */
        public boolean f25941d;

        public a(boolean z2) {
            this.f25938a = z2;
        }

        /* renamed from: a */
        public final ConnectionSpec m10378a() {
            return new ConnectionSpec(this.f25938a, this.f25941d, this.f25939b, this.f25940c);
        }

        /* renamed from: b */
        public final a m10379b(String... strArr) throws CloneNotSupportedException {
            Intrinsics3.checkParameterIsNotNull(strArr, "cipherSuites");
            if (!this.f25938a) {
                throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
            }
            if (!(!(strArr.length == 0))) {
                throw new IllegalArgumentException("At least one cipher suite is required".toString());
            }
            Object objClone = strArr.clone();
            if (objClone == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
            }
            this.f25939b = (String[]) objClone;
            return this;
        }

        /* renamed from: c */
        public final a m10380c(CipherSuite... cipherSuiteArr) throws CloneNotSupportedException {
            Intrinsics3.checkParameterIsNotNull(cipherSuiteArr, "cipherSuites");
            if (!this.f25938a) {
                throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
            }
            ArrayList arrayList = new ArrayList(cipherSuiteArr.length);
            for (CipherSuite cipherSuite : cipherSuiteArr) {
                arrayList.add(cipherSuite.f25928t);
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            String[] strArr = (String[]) array;
            m10379b((String[]) Arrays.copyOf(strArr, strArr.length));
            return this;
        }

        /* renamed from: d */
        public final a m10381d(boolean z2) {
            if (!this.f25938a) {
                throw new IllegalArgumentException("no TLS extensions for cleartext connections".toString());
            }
            this.f25941d = z2;
            return this;
        }

        /* renamed from: e */
        public final a m10382e(String... strArr) throws CloneNotSupportedException {
            Intrinsics3.checkParameterIsNotNull(strArr, "tlsVersions");
            if (!this.f25938a) {
                throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
            }
            if (!(!(strArr.length == 0))) {
                throw new IllegalArgumentException("At least one TLS version is required".toString());
            }
            Object objClone = strArr.clone();
            if (objClone == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
            }
            this.f25940c = (String[]) objClone;
            return this;
        }

        /* renamed from: f */
        public final a m10383f(TlsVersion... tlsVersionArr) throws CloneNotSupportedException {
            Intrinsics3.checkParameterIsNotNull(tlsVersionArr, "tlsVersions");
            if (!this.f25938a) {
                throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
            }
            ArrayList arrayList = new ArrayList(tlsVersionArr.length);
            for (TlsVersion tlsVersion : tlsVersionArr) {
                arrayList.add(tlsVersion.m10109f());
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            String[] strArr = (String[]) array;
            m10382e((String[]) Arrays.copyOf(strArr, strArr.length));
            return this;
        }

        public a(ConnectionSpec connectionSpec) {
            Intrinsics3.checkParameterIsNotNull(connectionSpec, "connectionSpec");
            this.f25938a = connectionSpec.f25934e;
            this.f25939b = connectionSpec.f25936g;
            this.f25940c = connectionSpec.f25937h;
            this.f25941d = connectionSpec.f25935f;
        }
    }

    static {
        CipherSuite cipherSuite = CipherSuite.f25924p;
        CipherSuite cipherSuite2 = CipherSuite.f25925q;
        CipherSuite cipherSuite3 = CipherSuite.f25926r;
        CipherSuite cipherSuite4 = CipherSuite.f25918j;
        CipherSuite cipherSuite5 = CipherSuite.f25920l;
        CipherSuite cipherSuite6 = CipherSuite.f25919k;
        CipherSuite cipherSuite7 = CipherSuite.f25921m;
        CipherSuite cipherSuite8 = CipherSuite.f25923o;
        CipherSuite cipherSuite9 = CipherSuite.f25922n;
        CipherSuite[] cipherSuiteArr = {cipherSuite, cipherSuite2, cipherSuite3, cipherSuite4, cipherSuite5, cipherSuite6, cipherSuite7, cipherSuite8, cipherSuite9};
        f25930a = cipherSuiteArr;
        CipherSuite[] cipherSuiteArr2 = {cipherSuite, cipherSuite2, cipherSuite3, cipherSuite4, cipherSuite5, cipherSuite6, cipherSuite7, cipherSuite8, cipherSuite9, CipherSuite.f25916h, CipherSuite.f25917i, CipherSuite.f25914f, CipherSuite.f25915g, CipherSuite.f25912d, CipherSuite.f25913e, CipherSuite.f25911c};
        f25931b = cipherSuiteArr2;
        a aVar = new a(true);
        aVar.m10380c((CipherSuite[]) Arrays.copyOf(cipherSuiteArr, cipherSuiteArr.length));
        TlsVersion tlsVersion = TlsVersion.TLS_1_3;
        TlsVersion tlsVersion2 = TlsVersion.TLS_1_2;
        aVar.m10383f(tlsVersion, tlsVersion2);
        aVar.m10381d(true);
        aVar.m10378a();
        a aVar2 = new a(true);
        aVar2.m10380c((CipherSuite[]) Arrays.copyOf(cipherSuiteArr2, cipherSuiteArr2.length));
        aVar2.m10383f(tlsVersion, tlsVersion2);
        aVar2.m10381d(true);
        f25932c = aVar2.m10378a();
        a aVar3 = new a(true);
        aVar3.m10380c((CipherSuite[]) Arrays.copyOf(cipherSuiteArr2, cipherSuiteArr2.length));
        aVar3.m10383f(tlsVersion, tlsVersion2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0);
        aVar3.m10381d(true);
        aVar3.m10378a();
        f25933d = new ConnectionSpec(false, false, null, null);
    }

    public ConnectionSpec(boolean z2, boolean z3, String[] strArr, String[] strArr2) {
        this.f25934e = z2;
        this.f25935f = z3;
        this.f25936g = strArr;
        this.f25937h = strArr2;
    }

    /* renamed from: a */
    public final List<CipherSuite> m10375a() {
        String[] strArr = this.f25936g;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(CipherSuite.f25927s.m10373b(str));
        }
        return _Collections.toList(arrayList);
    }

    /* renamed from: b */
    public final boolean m10376b(SSLSocket sSLSocket) {
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "socket");
        if (!this.f25934e) {
            return false;
        }
        String[] strArr = this.f25937h;
        if (strArr != null && !Util7.m10130k(strArr, sSLSocket.getEnabledProtocols(), C12169a.naturalOrder())) {
            return false;
        }
        String[] strArr2 = this.f25936g;
        if (strArr2 == null) {
            return true;
        }
        String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        CipherSuite.b bVar = CipherSuite.f25927s;
        Comparator<String> comparator = CipherSuite.f25909a;
        return Util7.m10130k(strArr2, enabledCipherSuites, CipherSuite.f25909a);
    }

    /* renamed from: c */
    public final List<TlsVersion> m10377c() {
        String[] strArr = this.f25937h;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(TlsVersion.f25393p.m10110a(str));
        }
        return _Collections.toList(arrayList);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ConnectionSpec)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        boolean z2 = this.f25934e;
        ConnectionSpec connectionSpec = (ConnectionSpec) obj;
        if (z2 != connectionSpec.f25934e) {
            return false;
        }
        return !z2 || (Arrays.equals(this.f25936g, connectionSpec.f25936g) && Arrays.equals(this.f25937h, connectionSpec.f25937h) && this.f25935f == connectionSpec.f25935f);
    }

    public int hashCode() {
        if (!this.f25934e) {
            return 17;
        }
        String[] strArr = this.f25936g;
        int iHashCode = (527 + (strArr != null ? Arrays.hashCode(strArr) : 0)) * 31;
        String[] strArr2 = this.f25937h;
        return ((iHashCode + (strArr2 != null ? Arrays.hashCode(strArr2) : 0)) * 31) + (!this.f25935f ? 1 : 0);
    }

    public String toString() {
        if (!this.f25934e) {
            return "ConnectionSpec()";
        }
        StringBuilder sbM836X = outline.m836X("ConnectionSpec(", "cipherSuites=");
        sbM836X.append(Objects.toString(m10375a(), "[all enabled]"));
        sbM836X.append(", ");
        sbM836X.append("tlsVersions=");
        sbM836X.append(Objects.toString(m10377c(), "[all enabled]"));
        sbM836X.append(", ");
        sbM836X.append("supportsTlsExtensions=");
        sbM836X.append(this.f25935f);
        sbM836X.append(')');
        return sbM836X.toString();
    }
}
