package p600f0.p601e0.p605g;

import java.security.cert.Certificate;
import java.util.List;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p600f0.Address;
import p600f0.CertificatePinner;
import p600f0.Handshake;
import p600f0.p601e0.p612m.CertificateChainCleaner;

/* compiled from: RealConnection.kt */
/* renamed from: f0.e0.g.g, reason: use source file name */
/* loaded from: classes3.dex */
public final class RealConnection extends Lambda implements Function0<List<? extends Certificate>> {
    public final /* synthetic */ Address $address;
    public final /* synthetic */ CertificatePinner $certificatePinner;
    public final /* synthetic */ Handshake $unverifiedHandshake;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RealConnection(CertificatePinner certificatePinner, Handshake handshake, Address address) {
        super(0);
        this.$certificatePinner = certificatePinner;
        this.$unverifiedHandshake = handshake;
        this.$address = address;
    }

    @Override // kotlin.jvm.functions.Function0
    public List<? extends Certificate> invoke() {
        CertificateChainCleaner certificateChainCleaner = this.$certificatePinner.f25906d;
        if (certificateChainCleaner == null) {
            Intrinsics3.throwNpe();
        }
        return certificateChainCleaner.mo10338a(this.$unverifiedHandshake.m10398c(), this.$address.f25353a.f25979g);
    }
}
