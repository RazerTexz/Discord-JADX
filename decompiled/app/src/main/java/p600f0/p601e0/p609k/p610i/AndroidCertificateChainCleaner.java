package p600f0.p601e0.p609k.p610i;

import android.net.http.X509TrustManagerExtensions;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
import kotlin.TypeCastException;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.p601e0.p612m.CertificateChainCleaner;

/* compiled from: AndroidCertificateChainCleaner.kt */
/* renamed from: f0.e0.k.i.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class AndroidCertificateChainCleaner extends CertificateChainCleaner {

    /* renamed from: a */
    public final X509TrustManager f25786a;

    /* renamed from: b */
    public final X509TrustManagerExtensions f25787b;

    public AndroidCertificateChainCleaner(X509TrustManager x509TrustManager, X509TrustManagerExtensions x509TrustManagerExtensions) {
        Intrinsics3.checkParameterIsNotNull(x509TrustManager, "trustManager");
        Intrinsics3.checkParameterIsNotNull(x509TrustManagerExtensions, "x509TrustManagerExtensions");
        this.f25786a = x509TrustManager;
        this.f25787b = x509TrustManagerExtensions;
    }

    @Override // p600f0.p601e0.p612m.CertificateChainCleaner
    /* renamed from: a */
    public List<Certificate> mo10338a(List<? extends Certificate> list, String str) throws SSLPeerUnverifiedException {
        Intrinsics3.checkParameterIsNotNull(list, "chain");
        Intrinsics3.checkParameterIsNotNull(str, "hostname");
        Object[] array = list.toArray(new X509Certificate[0]);
        if (array == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        try {
            List<X509Certificate> listCheckServerTrusted = this.f25787b.checkServerTrusted((X509Certificate[]) array, "RSA", str);
            Intrinsics3.checkExpressionValueIsNotNull(listCheckServerTrusted, "x509TrustManagerExtensio…ficates, \"RSA\", hostname)");
            return listCheckServerTrusted;
        } catch (CertificateException e) {
            SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e.getMessage());
            sSLPeerUnverifiedException.initCause(e);
            throw sSLPeerUnverifiedException;
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof AndroidCertificateChainCleaner) && ((AndroidCertificateChainCleaner) obj).f25786a == this.f25786a;
    }

    public int hashCode() {
        return System.identityHashCode(this.f25786a);
    }
}
