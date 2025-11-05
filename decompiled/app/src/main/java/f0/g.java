package f0;

import com.adjust.sdk.Constants;
import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.z.d.e0;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okio.ByteString;

/* compiled from: CertificatePinner.kt */
/* loaded from: classes3.dex */
public final class g {
    public final Set<b> c;
    public final f0.e0.m.c d;

    /* renamed from: b, reason: collision with root package name */
    public static final a f3670b = new a(null);
    public static final g a = new g(d0.t.u.toSet(new ArrayList()), null, 2);

    /* compiled from: CertificatePinner.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final String a(Certificate certificate) {
            d0.z.d.m.checkParameterIsNotNull(certificate, "certificate");
            return "sha256/" + b((X509Certificate) certificate).f();
        }

        public final ByteString b(X509Certificate x509Certificate) {
            d0.z.d.m.checkParameterIsNotNull(x509Certificate, "$this$sha256Hash");
            ByteString.Companion companion = ByteString.INSTANCE;
            PublicKey publicKey = x509Certificate.getPublicKey();
            d0.z.d.m.checkExpressionValueIsNotNull(publicKey, "publicKey");
            byte[] encoded = publicKey.getEncoded();
            d0.z.d.m.checkExpressionValueIsNotNull(encoded, "publicKey.encoded");
            return ByteString.Companion.d(companion, encoded, 0, 0, 3).g(Constants.SHA256);
        }
    }

    /* compiled from: CertificatePinner.kt */
    public static final class b {
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            Objects.requireNonNull(bVar);
            if (!d0.z.d.m.areEqual((Object) null, (Object) null)) {
                return false;
            }
            Objects.requireNonNull(bVar);
            if (!d0.z.d.m.areEqual((Object) null, (Object) null)) {
                return false;
            }
            Objects.requireNonNull(bVar);
            return !(d0.z.d.m.areEqual((Object) null, (Object) null) ^ true);
        }

        public int hashCode() {
            throw null;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append((String) null);
            sb.append(MentionUtilsKt.SLASH_CHAR);
            throw null;
        }
    }

    public g(Set set, f0.e0.m.c cVar, int i) {
        int i2 = i & 2;
        d0.z.d.m.checkParameterIsNotNull(set, "pins");
        this.c = set;
        this.d = null;
    }

    public final void a(String str, Function0<? extends List<? extends X509Certificate>> function0) throws SSLPeerUnverifiedException {
        d0.z.d.m.checkParameterIsNotNull(str, "hostname");
        d0.z.d.m.checkParameterIsNotNull(function0, "cleanedPeerCertificatesFn");
        d0.z.d.m.checkParameterIsNotNull(str, "hostname");
        Set<b> set = this.c;
        List<b> listEmptyList = d0.t.n.emptyList();
        for (Object obj : set) {
            Objects.requireNonNull((b) obj);
            d0.z.d.m.checkParameterIsNotNull(str, "hostname");
            if (d0.g0.t.startsWith$default(null, "**.", false, 2, null)) {
                throw null;
            }
            if (d0.g0.t.startsWith$default(null, "*.", false, 2, null)) {
                throw null;
            }
            if (d0.z.d.m.areEqual(str, (Object) null)) {
                if (listEmptyList.isEmpty()) {
                    listEmptyList = new ArrayList();
                }
                e0.asMutableList(listEmptyList).add(obj);
            }
        }
        if (listEmptyList.isEmpty()) {
            return;
        }
        List<? extends X509Certificate> listInvoke = function0.invoke();
        for (X509Certificate x509Certificate : listInvoke) {
            Iterator it = listEmptyList.iterator();
            if (it.hasNext()) {
                Objects.requireNonNull((b) it.next());
                throw null;
            }
        }
        StringBuilder sbX = b.d.b.a.a.X("Certificate pinning failure!", "\n  Peer certificate chain:");
        for (X509Certificate x509Certificate2 : listInvoke) {
            sbX.append("\n    ");
            d0.z.d.m.checkParameterIsNotNull(x509Certificate2, "certificate");
            if (!(x509Certificate2 instanceof X509Certificate)) {
                throw new IllegalArgumentException("Certificate pinning requires X509 certificates".toString());
            }
            StringBuilder sb = new StringBuilder();
            sb.append("sha256/");
            d0.z.d.m.checkParameterIsNotNull(x509Certificate2, "$this$sha256Hash");
            ByteString.Companion companion = ByteString.INSTANCE;
            PublicKey publicKey = x509Certificate2.getPublicKey();
            d0.z.d.m.checkExpressionValueIsNotNull(publicKey, "publicKey");
            byte[] encoded = publicKey.getEncoded();
            d0.z.d.m.checkExpressionValueIsNotNull(encoded, "publicKey.encoded");
            sb.append(ByteString.Companion.d(companion, encoded, 0, 0, 3).g(Constants.SHA256).f());
            sbX.append(sb.toString());
            sbX.append(": ");
            Principal subjectDN = x509Certificate2.getSubjectDN();
            d0.z.d.m.checkExpressionValueIsNotNull(subjectDN, "element.subjectDN");
            sbX.append(subjectDN.getName());
        }
        sbX.append("\n  Pinned certificates for ");
        sbX.append(str);
        sbX.append(":");
        for (b bVar : listEmptyList) {
            sbX.append("\n    ");
            sbX.append(bVar);
        }
        String string = sbX.toString();
        d0.z.d.m.checkExpressionValueIsNotNull(string, "StringBuilder().apply(builderAction).toString()");
        throw new SSLPeerUnverifiedException(string);
    }

    public final g b(f0.e0.m.c cVar) {
        d0.z.d.m.checkParameterIsNotNull(cVar, "certificateChainCleaner");
        return d0.z.d.m.areEqual(this.d, cVar) ? this : new g(this.c, cVar);
    }

    public boolean equals(Object obj) {
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (d0.z.d.m.areEqual(gVar.c, this.c) && d0.z.d.m.areEqual(gVar.d, this.d)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (this.c.hashCode() + 1517) * 41;
        f0.e0.m.c cVar = this.d;
        return iHashCode + (cVar != null ? cVar.hashCode() : 0);
    }

    public g(Set<b> set, f0.e0.m.c cVar) {
        d0.z.d.m.checkParameterIsNotNull(set, "pins");
        this.c = set;
        this.d = cVar;
    }
}
