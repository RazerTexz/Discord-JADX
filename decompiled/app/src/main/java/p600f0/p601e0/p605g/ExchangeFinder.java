package p600f0.p601e0.p605g;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.chat.input.MentionUtils;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.StreamResetException;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.MutableCollections;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.Address;
import p600f0.Call2;
import p600f0.EventListener;
import p600f0.HttpUrl;
import p600f0.Route;
import p600f0.p601e0.Util7;
import p600f0.p601e0.p604f.TaskQueue2;
import p600f0.p601e0.p605g.RouteSelector;
import p600f0.p601e0.p608j.ErrorCode2;

/* compiled from: ExchangeFinder.kt */
/* renamed from: f0.e0.g.d, reason: use source file name */
/* loaded from: classes3.dex */
public final class ExchangeFinder {

    /* renamed from: a */
    public RouteSelector.a f25454a;

    /* renamed from: b */
    public RouteSelector f25455b;

    /* renamed from: c */
    public int f25456c;

    /* renamed from: d */
    public int f25457d;

    /* renamed from: e */
    public int f25458e;

    /* renamed from: f */
    public Route f25459f;

    /* renamed from: g */
    public final RealConnectionPool f25460g;

    /* renamed from: h */
    public final Address f25461h;

    /* renamed from: i */
    public final RealCall f25462i;

    /* renamed from: j */
    public final EventListener f25463j;

    public ExchangeFinder(RealConnectionPool realConnectionPool, Address address, RealCall realCall, EventListener eventListener) {
        Intrinsics3.checkParameterIsNotNull(realConnectionPool, "connectionPool");
        Intrinsics3.checkParameterIsNotNull(address, "address");
        Intrinsics3.checkParameterIsNotNull(realCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics3.checkParameterIsNotNull(eventListener, "eventListener");
        this.f25460g = realConnectionPool;
        this.f25461h = address;
        this.f25462i = realCall;
        this.f25463j = eventListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:170:0x02b2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0083  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final RealConnection4 m10177a(int i, int i2, int i3, int i4, boolean z2, boolean z3) throws IOException {
        List<Route> list;
        String hostName;
        int port;
        boolean zContains;
        RouteDatabase routeDatabase;
        boolean z4;
        Socket socketM10188m;
        while (!this.f25462i.f25477v) {
            RealConnection4 realConnection4 = this.f25462i.f25471p;
            if (realConnection4 != null) {
                synchronized (realConnection4) {
                    socketM10188m = (realConnection4.f25498i || !m10178b(realConnection4.f25506q.f25370a.f25353a)) ? this.f25462i.m10188m() : null;
                }
                if (this.f25462i.f25471p != null) {
                    if (!(socketM10188m == null)) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    z4 = z3;
                } else {
                    if (socketM10188m != null) {
                        Util7.m10124e(socketM10188m);
                    }
                    EventListener eventListener = this.f25463j;
                    RealCall realCall = this.f25462i;
                    Objects.requireNonNull(eventListener);
                    Intrinsics3.checkParameterIsNotNull(realCall, NotificationCompat.CATEGORY_CALL);
                    Intrinsics3.checkParameterIsNotNull(realConnection4, "connection");
                    this.f25456c = 0;
                    this.f25457d = 0;
                    this.f25458e = 0;
                    if (this.f25460g.m10207a(this.f25461h, this.f25462i, null, false)) {
                        Route routeM10212b = this.f25459f;
                        try {
                            if (routeM10212b != null) {
                                this.f25459f = null;
                            } else {
                                RouteSelector.a aVar = this.f25454a;
                                if (aVar == null || !aVar.m10211a()) {
                                    RouteSelector routeSelector = this.f25455b;
                                    if (routeSelector == null) {
                                        Address address = this.f25461h;
                                        RealCall realCall2 = this.f25462i;
                                        routeSelector = new RouteSelector(address, realCall2.f25480y.f26011O, realCall2, this.f25463j);
                                        this.f25455b = routeSelector;
                                    }
                                    if (!routeSelector.m10209a()) {
                                        throw new NoSuchElementException();
                                    }
                                    ArrayList arrayList = new ArrayList();
                                    while (routeSelector.m10210b()) {
                                        if (!routeSelector.m10210b()) {
                                            StringBuilder sbM833U = outline.m833U("No route to ");
                                            sbM833U.append(routeSelector.f25518e.f25353a.f25979g);
                                            sbM833U.append("; exhausted proxy configurations: ");
                                            sbM833U.append(routeSelector.f25514a);
                                            throw new SocketException(sbM833U.toString());
                                        }
                                        List<? extends Proxy> list2 = routeSelector.f25514a;
                                        int i5 = routeSelector.f25515b;
                                        routeSelector.f25515b = i5 + 1;
                                        Proxy proxy = list2.get(i5);
                                        ArrayList arrayList2 = new ArrayList();
                                        routeSelector.f25516c = arrayList2;
                                        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
                                            HttpUrl httpUrl = routeSelector.f25518e.f25353a;
                                            hostName = httpUrl.f25979g;
                                            port = httpUrl.f25980h;
                                        } else {
                                            SocketAddress socketAddressAddress = proxy.address();
                                            if (!(socketAddressAddress instanceof InetSocketAddress)) {
                                                StringBuilder sbM833U2 = outline.m833U("Proxy.address() is not an InetSocketAddress: ");
                                                sbM833U2.append(socketAddressAddress.getClass());
                                                throw new IllegalArgumentException(sbM833U2.toString().toString());
                                            }
                                            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
                                            Intrinsics3.checkParameterIsNotNull(inetSocketAddress, "$this$socketHost");
                                            InetAddress address2 = inetSocketAddress.getAddress();
                                            if (address2 != null) {
                                                hostName = address2.getHostAddress();
                                                Intrinsics3.checkExpressionValueIsNotNull(hostName, "address.hostAddress");
                                            } else {
                                                hostName = inetSocketAddress.getHostName();
                                                Intrinsics3.checkExpressionValueIsNotNull(hostName, "hostName");
                                            }
                                            port = inetSocketAddress.getPort();
                                        }
                                        if (1 > port || 65535 < port) {
                                            throw new SocketException("No route to " + hostName + MentionUtils.EMOJIS_AND_STICKERS_CHAR + port + "; port is out of range");
                                        }
                                        if (proxy.type() == Proxy.Type.SOCKS) {
                                            arrayList2.add(InetSocketAddress.createUnresolved(hostName, port));
                                        } else {
                                            EventListener eventListener2 = routeSelector.f25521h;
                                            Call2 call2 = routeSelector.f25520g;
                                            Objects.requireNonNull(eventListener2);
                                            Intrinsics3.checkParameterIsNotNull(call2, NotificationCompat.CATEGORY_CALL);
                                            Intrinsics3.checkParameterIsNotNull(hostName, "domainName");
                                            List<InetAddress> listMo10392a = routeSelector.f25518e.f25356d.mo10392a(hostName);
                                            if (listMo10392a.isEmpty()) {
                                                throw new UnknownHostException(routeSelector.f25518e.f25356d + " returned no addresses for " + hostName);
                                            }
                                            EventListener eventListener3 = routeSelector.f25521h;
                                            Call2 call22 = routeSelector.f25520g;
                                            Objects.requireNonNull(eventListener3);
                                            Intrinsics3.checkParameterIsNotNull(call22, NotificationCompat.CATEGORY_CALL);
                                            Intrinsics3.checkParameterIsNotNull(hostName, "domainName");
                                            Intrinsics3.checkParameterIsNotNull(listMo10392a, "inetAddressList");
                                            Iterator<InetAddress> it = listMo10392a.iterator();
                                            while (it.hasNext()) {
                                                arrayList2.add(new InetSocketAddress(it.next(), port));
                                            }
                                        }
                                        Iterator<? extends InetSocketAddress> it2 = routeSelector.f25516c.iterator();
                                        while (it2.hasNext()) {
                                            Route route = new Route(routeSelector.f25518e, proxy, it2.next());
                                            RouteDatabase routeDatabase2 = routeSelector.f25519f;
                                            synchronized (routeDatabase2) {
                                                Intrinsics3.checkParameterIsNotNull(route, "route");
                                                zContains = routeDatabase2.f25513a.contains(route);
                                            }
                                            if (zContains) {
                                                routeSelector.f25517d.add(route);
                                            } else {
                                                arrayList.add(route);
                                            }
                                        }
                                        if (!arrayList.isEmpty()) {
                                            break;
                                        }
                                    }
                                    if (arrayList.isEmpty()) {
                                        MutableCollections.addAll(arrayList, routeSelector.f25517d);
                                        routeSelector.f25517d.clear();
                                    }
                                    RouteSelector.a aVar2 = new RouteSelector.a(arrayList);
                                    this.f25454a = aVar2;
                                    list = aVar2.f25523b;
                                    if (this.f25462i.f25477v) {
                                        throw new IOException("Canceled");
                                    }
                                    if (this.f25460g.m10207a(this.f25461h, this.f25462i, list, false)) {
                                        realConnection4 = this.f25462i.f25471p;
                                        if (realConnection4 == null) {
                                            Intrinsics3.throwNpe();
                                        }
                                        this.f25463j.m10393a(this.f25462i, realConnection4);
                                    } else {
                                        routeM10212b = aVar2.m10212b();
                                        RealConnection4 realConnection42 = new RealConnection4(this.f25460g, routeM10212b);
                                        this.f25462i.f25479x = realConnection42;
                                        realConnection42.m10194c(i, i2, i3, i4, z2, this.f25462i, this.f25463j);
                                        this.f25462i.f25479x = null;
                                        routeDatabase = this.f25462i.f25480y.f26011O;
                                        Route route2 = realConnection42.f25506q;
                                        synchronized (routeDatabase) {
                                            Intrinsics3.checkParameterIsNotNull(route2, "route");
                                            routeDatabase.f25513a.remove(route2);
                                        }
                                        if (this.f25460g.m10207a(this.f25461h, this.f25462i, list, true)) {
                                            RealConnection4 realConnection43 = this.f25462i.f25471p;
                                            if (realConnection43 == null) {
                                                Intrinsics3.throwNpe();
                                            }
                                            this.f25459f = routeM10212b;
                                            Util7.m10124e(realConnection42.m10205n());
                                            this.f25463j.m10393a(this.f25462i, realConnection43);
                                            realConnection4 = realConnection43;
                                        } else {
                                            synchronized (realConnection42) {
                                                RealConnectionPool realConnectionPool = this.f25460g;
                                                Objects.requireNonNull(realConnectionPool);
                                                Intrinsics3.checkParameterIsNotNull(realConnection42, "connection");
                                                byte[] bArr = Util7.f25397a;
                                                realConnectionPool.f25510d.add(realConnection42);
                                                TaskQueue2.m10151d(realConnectionPool.f25508b, realConnectionPool.f25509c, 0L, 2);
                                                this.f25462i.m10181f(realConnection42);
                                            }
                                            EventListener eventListener4 = this.f25463j;
                                            RealCall realCall3 = this.f25462i;
                                            Objects.requireNonNull(eventListener4);
                                            Intrinsics3.checkParameterIsNotNull(realCall3, NotificationCompat.CATEGORY_CALL);
                                            Intrinsics3.checkParameterIsNotNull(realConnection42, "connection");
                                            z4 = z3;
                                            realConnection4 = realConnection42;
                                        }
                                    }
                                } else {
                                    RouteSelector.a aVar3 = this.f25454a;
                                    if (aVar3 == null) {
                                        Intrinsics3.throwNpe();
                                    }
                                    routeM10212b = aVar3.m10212b();
                                }
                            }
                            realConnection42.m10194c(i, i2, i3, i4, z2, this.f25462i, this.f25463j);
                            this.f25462i.f25479x = null;
                            routeDatabase = this.f25462i.f25480y.f26011O;
                            Route route22 = realConnection42.f25506q;
                            synchronized (routeDatabase) {
                            }
                        } catch (Throwable th) {
                            this.f25462i.f25479x = null;
                            throw th;
                        }
                        list = null;
                        RealConnection4 realConnection422 = new RealConnection4(this.f25460g, routeM10212b);
                        this.f25462i.f25479x = realConnection422;
                    } else {
                        realConnection4 = this.f25462i.f25471p;
                        if (realConnection4 == null) {
                            Intrinsics3.throwNpe();
                        }
                        this.f25463j.m10393a(this.f25462i, realConnection4);
                    }
                    z4 = z3;
                }
            } else {
                this.f25456c = 0;
                this.f25457d = 0;
                this.f25458e = 0;
                if (this.f25460g.m10207a(this.f25461h, this.f25462i, null, false)) {
                }
                z4 = z3;
            }
            if (realConnection4.m10200i(z4)) {
                return realConnection4;
            }
            realConnection4.m10203l();
            if (this.f25459f == null) {
                RouteSelector.a aVar4 = this.f25454a;
                if (aVar4 != null ? aVar4.m10211a() : true) {
                    continue;
                } else {
                    RouteSelector routeSelector2 = this.f25455b;
                    if (!(routeSelector2 != null ? routeSelector2.m10209a() : true)) {
                        throw new IOException("exhausted all routes");
                    }
                }
            }
        }
        throw new IOException("Canceled");
    }

    /* renamed from: b */
    public final boolean m10178b(HttpUrl httpUrl) {
        Intrinsics3.checkParameterIsNotNull(httpUrl, "url");
        HttpUrl httpUrl2 = this.f25461h.f25353a;
        return httpUrl.f25980h == httpUrl2.f25980h && Intrinsics3.areEqual(httpUrl.f25979g, httpUrl2.f25979g);
    }

    /* renamed from: c */
    public final void m10179c(IOException iOException) {
        Intrinsics3.checkParameterIsNotNull(iOException, "e");
        this.f25459f = null;
        if ((iOException instanceof StreamResetException) && ((StreamResetException) iOException).errorCode == ErrorCode2.REFUSED_STREAM) {
            this.f25456c++;
        } else if (iOException instanceof ConnectionShutdownException) {
            this.f25457d++;
        } else {
            this.f25458e++;
        }
    }
}
