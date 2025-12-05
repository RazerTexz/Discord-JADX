package p600f0;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import p507d0.p580t.Iterables2;
import p507d0.p592z.p594d.Lambda;
import p600f0.p601e0.p612m.CertificateChainCleaner;

/* compiled from: CertificatePinner.kt */
/* renamed from: f0.h, reason: use source file name */
/* loaded from: classes3.dex */
public final class CertificatePinner2 extends Lambda implements Function0<List<? extends X509Certificate>> {
    public final /* synthetic */ String $hostname;
    public final /* synthetic */ List $peerCertificates;
    public final /* synthetic */ CertificatePinner this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CertificatePinner2(CertificatePinner certificatePinner, List list, String str) {
        super(0);
        this.this$0 = certificatePinner;
        this.$peerCertificates = list;
        this.$hostname = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public List<? extends X509Certificate> invoke() {
        List<Certificate> listMo10338a;
        CertificateChainCleaner certificateChainCleaner = this.this$0.f25906d;
        if (certificateChainCleaner == null || (listMo10338a = certificateChainCleaner.mo10338a(this.$peerCertificates, this.$hostname)) == null) {
            listMo10338a = this.$peerCertificates;
        }
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listMo10338a, 10));
        for (Certificate certificate : listMo10338a) {
            if (certificate == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.security.cert.X509Certificate");
            }
            arrayList.add((X509Certificate) certificate);
        }
        return arrayList;
    }
}
