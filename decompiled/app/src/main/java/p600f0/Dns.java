package p600f0;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t._Arrays;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: Dns.kt */
/* renamed from: f0.r, reason: use source file name */
/* loaded from: classes3.dex */
public final class Dns implements Dns2 {
    @Override // p600f0.Dns2
    /* renamed from: a */
    public List<InetAddress> mo10392a(String str) throws UnknownHostException {
        Intrinsics3.checkParameterIsNotNull(str, "hostname");
        try {
            InetAddress[] allByName = InetAddress.getAllByName(str);
            Intrinsics3.checkExpressionValueIsNotNull(allByName, "InetAddress.getAllByName(hostname)");
            return _Arrays.toList(allByName);
        } catch (NullPointerException e) {
            UnknownHostException unknownHostException = new UnknownHostException(outline.m883w("Broken system behaviour for dns lookup of ", str));
            unknownHostException.initCause(e);
            throw unknownHostException;
        }
    }
}
