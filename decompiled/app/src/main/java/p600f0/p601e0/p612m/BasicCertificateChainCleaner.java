package p600f0.p601e0.p612m;

import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.TypeCastException;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: BasicCertificateChainCleaner.kt */
/* renamed from: f0.e0.m.a, reason: use source file name */
/* loaded from: classes3.dex */
public final class BasicCertificateChainCleaner extends CertificateChainCleaner {

    /* renamed from: a */
    public final TrustRootIndex f25809a;

    public BasicCertificateChainCleaner(TrustRootIndex trustRootIndex) {
        Intrinsics3.checkParameterIsNotNull(trustRootIndex, "trustRootIndex");
        this.f25809a = trustRootIndex;
    }

    @Override // p600f0.p601e0.p612m.CertificateChainCleaner
    /* renamed from: a */
    public List<Certificate> mo10338a(List<? extends Certificate> list, String str) throws SSLPeerUnverifiedException {
        Intrinsics3.checkParameterIsNotNull(list, "chain");
        Intrinsics3.checkParameterIsNotNull(str, "hostname");
        ArrayDeque arrayDeque = new ArrayDeque(list);
        ArrayList arrayList = new ArrayList();
        Object objRemoveFirst = arrayDeque.removeFirst();
        Intrinsics3.checkExpressionValueIsNotNull(objRemoveFirst, "queue.removeFirst()");
        arrayList.add(objRemoveFirst);
        boolean z2 = false;
        for (int i = 0; i < 9; i++) {
            Object obj = arrayList.get(arrayList.size() - 1);
            if (obj == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.security.cert.X509Certificate");
            }
            X509Certificate x509Certificate = (X509Certificate) obj;
            X509Certificate x509CertificateMo10323a = this.f25809a.mo10323a(x509Certificate);
            if (x509CertificateMo10323a == null) {
                Iterator it = arrayDeque.iterator();
                Intrinsics3.checkExpressionValueIsNotNull(it, "queue.iterator()");
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next == null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.security.cert.X509Certificate");
                    }
                    X509Certificate x509Certificate2 = (X509Certificate) next;
                    if (m10342b(x509Certificate, x509Certificate2)) {
                        it.remove();
                        arrayList.add(x509Certificate2);
                    }
                }
                if (z2) {
                    return arrayList;
                }
                throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + x509Certificate);
            }
            if (arrayList.size() > 1 || (!Intrinsics3.areEqual(x509Certificate, x509CertificateMo10323a))) {
                arrayList.add(x509CertificateMo10323a);
            }
            if (m10342b(x509CertificateMo10323a, x509CertificateMo10323a)) {
                return arrayList;
            }
            z2 = true;
        }
        throw new SSLPeerUnverifiedException("Certificate chain too long: " + arrayList);
    }

    /* renamed from: b */
    public final boolean m10342b(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        if (!Intrinsics3.areEqual(x509Certificate.getIssuerDN(), x509Certificate2.getSubjectDN())) {
            return false;
        }
        try {
            x509Certificate.verify(x509Certificate2.getPublicKey());
            return true;
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof BasicCertificateChainCleaner) && Intrinsics3.areEqual(((BasicCertificateChainCleaner) obj).f25809a, this.f25809a);
    }

    public int hashCode() {
        return this.f25809a.hashCode();
    }
}
