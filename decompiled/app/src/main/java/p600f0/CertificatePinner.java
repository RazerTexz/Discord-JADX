package p600f0;

import com.adjust.sdk.Constants;
import com.discord.widgets.chat.input.MentionUtils;
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
import p007b.p100d.p104b.p105a.outline;
import p507d0.p579g0.StringsJVM;
import p507d0.p580t.Collections2;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.TypeIntrinsics;
import p600f0.p601e0.p612m.CertificateChainCleaner;

/* JADX INFO: renamed from: f0.g, reason: use source file name */
/* JADX INFO: compiled from: CertificatePinner.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CertificatePinner {

    /* JADX INFO: renamed from: c */
    public final Set<b> f25905c;

    /* JADX INFO: renamed from: d */
    public final CertificateChainCleaner f25906d;

    /* JADX INFO: renamed from: b */
    public static final a f25904b = new a(null);

    /* JADX INFO: renamed from: a */
    public static final CertificatePinner f25903a = new CertificatePinner(_Collections.toSet(new ArrayList()), null, 2);

    /* JADX INFO: renamed from: f0.g$a */
    /* JADX INFO: compiled from: CertificatePinner.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* JADX INFO: renamed from: a */
        public final String m10370a(Certificate certificate) {
            Intrinsics3.checkParameterIsNotNull(certificate, "certificate");
            return "sha256/" + m10371b((X509Certificate) certificate).mo10500f();
        }

        /* JADX INFO: renamed from: b */
        public final ByteString m10371b(X509Certificate x509Certificate) {
            Intrinsics3.checkParameterIsNotNull(x509Certificate, "$this$sha256Hash");
            ByteString.Companion companion = ByteString.INSTANCE;
            PublicKey publicKey = x509Certificate.getPublicKey();
            Intrinsics3.checkExpressionValueIsNotNull(publicKey, "publicKey");
            byte[] encoded = publicKey.getEncoded();
            Intrinsics3.checkExpressionValueIsNotNull(encoded, "publicKey.encoded");
            return ByteString.Companion.m11009d(companion, encoded, 0, 0, 3).mo10501g(Constants.SHA256);
        }
    }

    /* JADX INFO: renamed from: f0.g$b */
    /* JADX INFO: compiled from: CertificatePinner.kt */
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
            if (!Intrinsics3.areEqual((Object) null, (Object) null)) {
                return false;
            }
            Objects.requireNonNull(bVar);
            if (!Intrinsics3.areEqual((Object) null, (Object) null)) {
                return false;
            }
            Objects.requireNonNull(bVar);
            return !(Intrinsics3.areEqual((Object) null, (Object) null) ^ true);
        }

        public int hashCode() {
            throw null;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append((String) null);
            sb.append(MentionUtils.SLASH_CHAR);
            throw null;
        }
    }

    public CertificatePinner(Set set, CertificateChainCleaner certificateChainCleaner, int i) {
        int i2 = i & 2;
        Intrinsics3.checkParameterIsNotNull(set, "pins");
        this.f25905c = set;
        this.f25906d = null;
    }

    /* JADX INFO: renamed from: a */
    public final void m10368a(String str, Function0<? extends List<? extends X509Certificate>> function0) throws SSLPeerUnverifiedException {
        Intrinsics3.checkParameterIsNotNull(str, "hostname");
        Intrinsics3.checkParameterIsNotNull(function0, "cleanedPeerCertificatesFn");
        Intrinsics3.checkParameterIsNotNull(str, "hostname");
        Set<b> set = this.f25905c;
        List<b> listEmptyList = Collections2.emptyList();
        for (Object obj : set) {
            Objects.requireNonNull((b) obj);
            Intrinsics3.checkParameterIsNotNull(str, "hostname");
            if (StringsJVM.startsWith$default(null, "**.", false, 2, null)) {
                throw null;
            }
            if (StringsJVM.startsWith$default(null, "*.", false, 2, null)) {
                throw null;
            }
            if (Intrinsics3.areEqual(str, (Object) null)) {
                if (listEmptyList.isEmpty()) {
                    listEmptyList = new ArrayList();
                }
                TypeIntrinsics.asMutableList(listEmptyList).add(obj);
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
        StringBuilder sbM836X = outline.m836X("Certificate pinning failure!", "\n  Peer certificate chain:");
        for (X509Certificate x509Certificate2 : listInvoke) {
            sbM836X.append("\n    ");
            Intrinsics3.checkParameterIsNotNull(x509Certificate2, "certificate");
            if (!(x509Certificate2 instanceof X509Certificate)) {
                throw new IllegalArgumentException("Certificate pinning requires X509 certificates".toString());
            }
            StringBuilder sb = new StringBuilder();
            sb.append("sha256/");
            Intrinsics3.checkParameterIsNotNull(x509Certificate2, "$this$sha256Hash");
            ByteString.Companion companion = ByteString.INSTANCE;
            PublicKey publicKey = x509Certificate2.getPublicKey();
            Intrinsics3.checkExpressionValueIsNotNull(publicKey, "publicKey");
            byte[] encoded = publicKey.getEncoded();
            Intrinsics3.checkExpressionValueIsNotNull(encoded, "publicKey.encoded");
            sb.append(ByteString.Companion.m11009d(companion, encoded, 0, 0, 3).mo10501g(Constants.SHA256).mo10500f());
            sbM836X.append(sb.toString());
            sbM836X.append(": ");
            Principal subjectDN = x509Certificate2.getSubjectDN();
            Intrinsics3.checkExpressionValueIsNotNull(subjectDN, "element.subjectDN");
            sbM836X.append(subjectDN.getName());
        }
        sbM836X.append("\n  Pinned certificates for ");
        sbM836X.append(str);
        sbM836X.append(":");
        for (b bVar : listEmptyList) {
            sbM836X.append("\n    ");
            sbM836X.append(bVar);
        }
        String string = sbM836X.toString();
        Intrinsics3.checkExpressionValueIsNotNull(string, "StringBuilder().apply(builderAction).toString()");
        throw new SSLPeerUnverifiedException(string);
    }

    /* JADX INFO: renamed from: b */
    public final CertificatePinner m10369b(CertificateChainCleaner certificateChainCleaner) {
        Intrinsics3.checkParameterIsNotNull(certificateChainCleaner, "certificateChainCleaner");
        return Intrinsics3.areEqual(this.f25906d, certificateChainCleaner) ? this : new CertificatePinner(this.f25905c, certificateChainCleaner);
    }

    public boolean equals(Object obj) {
        if (obj instanceof CertificatePinner) {
            CertificatePinner certificatePinner = (CertificatePinner) obj;
            if (Intrinsics3.areEqual(certificatePinner.f25905c, this.f25905c) && Intrinsics3.areEqual(certificatePinner.f25906d, this.f25906d)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (this.f25905c.hashCode() + 1517) * 41;
        CertificateChainCleaner certificateChainCleaner = this.f25906d;
        return iHashCode + (certificateChainCleaner != null ? certificateChainCleaner.hashCode() : 0);
    }

    public CertificatePinner(Set<b> set, CertificateChainCleaner certificateChainCleaner) {
        Intrinsics3.checkParameterIsNotNull(set, "pins");
        this.f25905c = set;
        this.f25906d = certificateChainCleaner;
    }
}
