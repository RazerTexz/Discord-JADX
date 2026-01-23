package p600f0.p601e0.p605g;

import androidx.core.app.NotificationCompat;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.Address;
import p600f0.Call2;
import p600f0.EventListener;
import p600f0.HttpUrl;
import p600f0.Route;

/* JADX INFO: renamed from: f0.e0.g.m, reason: use source file name */
/* JADX INFO: compiled from: RouteSelector.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class RouteSelector {

    /* JADX INFO: renamed from: a */
    public List<? extends Proxy> f25514a;

    /* JADX INFO: renamed from: b */
    public int f25515b;

    /* JADX INFO: renamed from: c */
    public List<? extends InetSocketAddress> f25516c;

    /* JADX INFO: renamed from: d */
    public final List<Route> f25517d;

    /* JADX INFO: renamed from: e */
    public final Address f25518e;

    /* JADX INFO: renamed from: f */
    public final RouteDatabase f25519f;

    /* JADX INFO: renamed from: g */
    public final Call2 f25520g;

    /* JADX INFO: renamed from: h */
    public final EventListener f25521h;

    /* JADX INFO: renamed from: f0.e0.g.m$a */
    /* JADX INFO: compiled from: RouteSelector.kt */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public int f25522a;

        /* JADX INFO: renamed from: b */
        public final List<Route> f25523b;

        public a(List<Route> list) {
            Intrinsics3.checkParameterIsNotNull(list, "routes");
            this.f25523b = list;
        }

        /* JADX INFO: renamed from: a */
        public final boolean m10211a() {
            return this.f25522a < this.f25523b.size();
        }

        /* JADX INFO: renamed from: b */
        public final Route m10212b() {
            if (!m10211a()) {
                throw new NoSuchElementException();
            }
            List<Route> list = this.f25523b;
            int i = this.f25522a;
            this.f25522a = i + 1;
            return list.get(i);
        }
    }

    public RouteSelector(Address address, RouteDatabase routeDatabase, Call2 call2, EventListener eventListener) {
        Intrinsics3.checkParameterIsNotNull(address, "address");
        Intrinsics3.checkParameterIsNotNull(routeDatabase, "routeDatabase");
        Intrinsics3.checkParameterIsNotNull(call2, NotificationCompat.CATEGORY_CALL);
        Intrinsics3.checkParameterIsNotNull(eventListener, "eventListener");
        this.f25518e = address;
        this.f25519f = routeDatabase;
        this.f25520g = call2;
        this.f25521h = eventListener;
        this.f25514a = Collections2.emptyList();
        this.f25516c = Collections2.emptyList();
        this.f25517d = new ArrayList();
        HttpUrl httpUrl = address.f25353a;
        RouteSelector2 routeSelector2 = new RouteSelector2(this, address.f25362j, httpUrl);
        Objects.requireNonNull(eventListener);
        Intrinsics3.checkParameterIsNotNull(call2, NotificationCompat.CATEGORY_CALL);
        Intrinsics3.checkParameterIsNotNull(httpUrl, "url");
        List<? extends Proxy> listInvoke2 = routeSelector2.invoke2();
        this.f25514a = listInvoke2;
        this.f25515b = 0;
        Intrinsics3.checkParameterIsNotNull(call2, NotificationCompat.CATEGORY_CALL);
        Intrinsics3.checkParameterIsNotNull(httpUrl, "url");
        Intrinsics3.checkParameterIsNotNull(listInvoke2, "proxies");
    }

    /* JADX INFO: renamed from: a */
    public final boolean m10209a() {
        return m10210b() || (this.f25517d.isEmpty() ^ true);
    }

    /* JADX INFO: renamed from: b */
    public final boolean m10210b() {
        return this.f25515b < this.f25514a.size();
    }
}
