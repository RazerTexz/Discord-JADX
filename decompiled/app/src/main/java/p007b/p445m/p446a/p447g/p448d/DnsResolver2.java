package p007b.p445m.p446a.p447g.p448d;

import java.net.InetAddress;
import java.net.UnknownHostException;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: b.m.a.g.d.d, reason: use source file name */
/* JADX INFO: compiled from: DnsResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DnsResolver2 implements DnsResolver {
    @Override // p007b.p445m.p446a.p447g.p448d.DnsResolver
    /* JADX INFO: renamed from: a */
    public InetAddress mo7143a(String str) throws UnknownHostException {
        Intrinsics3.checkParameterIsNotNull(str, "host");
        InetAddress byName = InetAddress.getByName(str);
        Intrinsics3.checkExpressionValueIsNotNull(byName, "InetAddress.getByName(host)");
        return byName;
    }
}
