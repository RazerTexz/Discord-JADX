package p600f0;

import java.net.InetSocketAddress;
import java.net.Proxy;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: f0.c0, reason: use source file name */
/* JADX INFO: compiled from: Route.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Route {

    /* JADX INFO: renamed from: a */
    public final Address f25370a;

    /* JADX INFO: renamed from: b */
    public final Proxy f25371b;

    /* JADX INFO: renamed from: c */
    public final InetSocketAddress f25372c;

    public Route(Address address, Proxy proxy, InetSocketAddress inetSocketAddress) {
        Intrinsics3.checkParameterIsNotNull(address, "address");
        Intrinsics3.checkParameterIsNotNull(proxy, "proxy");
        Intrinsics3.checkParameterIsNotNull(inetSocketAddress, "socketAddress");
        this.f25370a = address;
        this.f25371b = proxy;
        this.f25372c = inetSocketAddress;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m10106a() {
        return this.f25370a.f25358f != null && this.f25371b.type() == Proxy.Type.HTTP;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Route) {
            Route route = (Route) obj;
            if (Intrinsics3.areEqual(route.f25370a, this.f25370a) && Intrinsics3.areEqual(route.f25371b, this.f25371b) && Intrinsics3.areEqual(route.f25372c, this.f25372c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f25372c.hashCode() + ((this.f25371b.hashCode() + ((this.f25370a.hashCode() + 527) * 31)) * 31);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("Route{");
        sbM833U.append(this.f25372c);
        sbM833U.append('}');
        return sbM833U.toString();
    }
}
