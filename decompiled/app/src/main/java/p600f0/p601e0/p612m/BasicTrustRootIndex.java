package p600f0.p601e0.p612m;

import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: f0.e0.m.b, reason: use source file name */
/* JADX INFO: compiled from: BasicTrustRootIndex.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class BasicTrustRootIndex implements TrustRootIndex {

    /* JADX INFO: renamed from: a */
    public final Map<X500Principal, Set<X509Certificate>> f25810a;

    public BasicTrustRootIndex(X509Certificate... x509CertificateArr) {
        Intrinsics3.checkParameterIsNotNull(x509CertificateArr, "caCerts");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (X509Certificate x509Certificate : x509CertificateArr) {
            X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
            Intrinsics3.checkExpressionValueIsNotNull(subjectX500Principal, "caCert.subjectX500Principal");
            Object linkedHashSet = linkedHashMap.get(subjectX500Principal);
            if (linkedHashSet == null) {
                linkedHashSet = new LinkedHashSet();
                linkedHashMap.put(subjectX500Principal, linkedHashSet);
            }
            ((Set) linkedHashSet).add(x509Certificate);
        }
        this.f25810a = linkedHashMap;
    }

    @Override // p600f0.p601e0.p612m.TrustRootIndex
    /* JADX INFO: renamed from: a */
    public X509Certificate mo10323a(X509Certificate x509Certificate) {
        boolean z2;
        Intrinsics3.checkParameterIsNotNull(x509Certificate, "cert");
        Set<X509Certificate> set = this.f25810a.get(x509Certificate.getIssuerX500Principal());
        Object obj = null;
        if (set == null) {
            return null;
        }
        Iterator<T> it = set.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            try {
                x509Certificate.verify(((X509Certificate) next).getPublicKey());
                z2 = true;
            } catch (Exception unused) {
                z2 = false;
            }
            if (z2) {
                obj = next;
                break;
            }
        }
        return (X509Certificate) obj;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof BasicTrustRootIndex) && Intrinsics3.areEqual(((BasicTrustRootIndex) obj).f25810a, this.f25810a));
    }

    public int hashCode() {
        return this.f25810a.hashCode();
    }
}
