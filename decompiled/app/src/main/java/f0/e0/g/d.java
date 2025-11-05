package f0.e0.g;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.t.r;
import f0.c0;
import f0.e0.g.m;
import f0.t;
import f0.w;
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

/* compiled from: ExchangeFinder.kt */
/* loaded from: classes3.dex */
public final class d {
    public m.a a;

    /* renamed from: b, reason: collision with root package name */
    public m f3615b;
    public int c;
    public int d;
    public int e;
    public c0 f;
    public final k g;
    public final f0.a h;
    public final e i;
    public final t j;

    public d(k kVar, f0.a aVar, e eVar, t tVar) {
        d0.z.d.m.checkParameterIsNotNull(kVar, "connectionPool");
        d0.z.d.m.checkParameterIsNotNull(aVar, "address");
        d0.z.d.m.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
        d0.z.d.m.checkParameterIsNotNull(tVar, "eventListener");
        this.g = kVar;
        this.h = aVar;
        this.i = eVar;
        this.j = tVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:170:0x02b2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final j a(int i, int i2, int i3, int i4, boolean z2, boolean z3) throws IOException {
        List<c0> list;
        String hostName;
        int port;
        boolean zContains;
        l lVar;
        boolean z4;
        Socket socketM;
        while (!this.i.v) {
            j jVar = this.i.p;
            if (jVar != null) {
                synchronized (jVar) {
                    socketM = (jVar.i || !b(jVar.q.a.a)) ? this.i.m() : null;
                }
                if (this.i.p != null) {
                    if (!(socketM == null)) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    z4 = z3;
                } else {
                    if (socketM != null) {
                        f0.e0.c.e(socketM);
                    }
                    t tVar = this.j;
                    e eVar = this.i;
                    Objects.requireNonNull(tVar);
                    d0.z.d.m.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
                    d0.z.d.m.checkParameterIsNotNull(jVar, "connection");
                    this.c = 0;
                    this.d = 0;
                    this.e = 0;
                    if (this.g.a(this.h, this.i, null, false)) {
                        c0 c0VarB = this.f;
                        try {
                            if (c0VarB != null) {
                                this.f = null;
                            } else {
                                m.a aVar = this.a;
                                if (aVar == null || !aVar.a()) {
                                    m mVar = this.f3615b;
                                    if (mVar == null) {
                                        f0.a aVar2 = this.h;
                                        e eVar2 = this.i;
                                        mVar = new m(aVar2, eVar2.f3618y.O, eVar2, this.j);
                                        this.f3615b = mVar;
                                    }
                                    if (!mVar.a()) {
                                        throw new NoSuchElementException();
                                    }
                                    ArrayList arrayList = new ArrayList();
                                    while (mVar.b()) {
                                        if (!mVar.b()) {
                                            StringBuilder sbU = b.d.b.a.a.U("No route to ");
                                            sbU.append(mVar.e.a.g);
                                            sbU.append("; exhausted proxy configurations: ");
                                            sbU.append(mVar.a);
                                            throw new SocketException(sbU.toString());
                                        }
                                        List<? extends Proxy> list2 = mVar.a;
                                        int i5 = mVar.f3622b;
                                        mVar.f3622b = i5 + 1;
                                        Proxy proxy = list2.get(i5);
                                        ArrayList arrayList2 = new ArrayList();
                                        mVar.c = arrayList2;
                                        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
                                            w wVar = mVar.e.a;
                                            hostName = wVar.g;
                                            port = wVar.h;
                                        } else {
                                            SocketAddress socketAddressAddress = proxy.address();
                                            if (!(socketAddressAddress instanceof InetSocketAddress)) {
                                                StringBuilder sbU2 = b.d.b.a.a.U("Proxy.address() is not an InetSocketAddress: ");
                                                sbU2.append(socketAddressAddress.getClass());
                                                throw new IllegalArgumentException(sbU2.toString().toString());
                                            }
                                            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
                                            d0.z.d.m.checkParameterIsNotNull(inetSocketAddress, "$this$socketHost");
                                            InetAddress address = inetSocketAddress.getAddress();
                                            if (address != null) {
                                                hostName = address.getHostAddress();
                                                d0.z.d.m.checkExpressionValueIsNotNull(hostName, "address.hostAddress");
                                            } else {
                                                hostName = inetSocketAddress.getHostName();
                                                d0.z.d.m.checkExpressionValueIsNotNull(hostName, "hostName");
                                            }
                                            port = inetSocketAddress.getPort();
                                        }
                                        if (1 > port || 65535 < port) {
                                            throw new SocketException("No route to " + hostName + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR + port + "; port is out of range");
                                        }
                                        if (proxy.type() == Proxy.Type.SOCKS) {
                                            arrayList2.add(InetSocketAddress.createUnresolved(hostName, port));
                                        } else {
                                            t tVar2 = mVar.h;
                                            f0.e eVar3 = mVar.g;
                                            Objects.requireNonNull(tVar2);
                                            d0.z.d.m.checkParameterIsNotNull(eVar3, NotificationCompat.CATEGORY_CALL);
                                            d0.z.d.m.checkParameterIsNotNull(hostName, "domainName");
                                            List<InetAddress> listA = mVar.e.d.a(hostName);
                                            if (listA.isEmpty()) {
                                                throw new UnknownHostException(mVar.e.d + " returned no addresses for " + hostName);
                                            }
                                            t tVar3 = mVar.h;
                                            f0.e eVar4 = mVar.g;
                                            Objects.requireNonNull(tVar3);
                                            d0.z.d.m.checkParameterIsNotNull(eVar4, NotificationCompat.CATEGORY_CALL);
                                            d0.z.d.m.checkParameterIsNotNull(hostName, "domainName");
                                            d0.z.d.m.checkParameterIsNotNull(listA, "inetAddressList");
                                            Iterator<InetAddress> it = listA.iterator();
                                            while (it.hasNext()) {
                                                arrayList2.add(new InetSocketAddress(it.next(), port));
                                            }
                                        }
                                        Iterator<? extends InetSocketAddress> it2 = mVar.c.iterator();
                                        while (it2.hasNext()) {
                                            c0 c0Var = new c0(mVar.e, proxy, it2.next());
                                            l lVar2 = mVar.f;
                                            synchronized (lVar2) {
                                                d0.z.d.m.checkParameterIsNotNull(c0Var, "route");
                                                zContains = lVar2.a.contains(c0Var);
                                            }
                                            if (zContains) {
                                                mVar.d.add(c0Var);
                                            } else {
                                                arrayList.add(c0Var);
                                            }
                                        }
                                        if (!arrayList.isEmpty()) {
                                            break;
                                        }
                                    }
                                    if (arrayList.isEmpty()) {
                                        r.addAll(arrayList, mVar.d);
                                        mVar.d.clear();
                                    }
                                    m.a aVar3 = new m.a(arrayList);
                                    this.a = aVar3;
                                    list = aVar3.f3623b;
                                    if (this.i.v) {
                                        throw new IOException("Canceled");
                                    }
                                    if (this.g.a(this.h, this.i, list, false)) {
                                        jVar = this.i.p;
                                        if (jVar == null) {
                                            d0.z.d.m.throwNpe();
                                        }
                                        this.j.a(this.i, jVar);
                                    } else {
                                        c0VarB = aVar3.b();
                                        j jVar2 = new j(this.g, c0VarB);
                                        this.i.f3617x = jVar2;
                                        jVar2.c(i, i2, i3, i4, z2, this.i, this.j);
                                        this.i.f3617x = null;
                                        lVar = this.i.f3618y.O;
                                        c0 c0Var2 = jVar2.q;
                                        synchronized (lVar) {
                                            d0.z.d.m.checkParameterIsNotNull(c0Var2, "route");
                                            lVar.a.remove(c0Var2);
                                        }
                                        if (this.g.a(this.h, this.i, list, true)) {
                                            j jVar3 = this.i.p;
                                            if (jVar3 == null) {
                                                d0.z.d.m.throwNpe();
                                            }
                                            this.f = c0VarB;
                                            f0.e0.c.e(jVar2.n());
                                            this.j.a(this.i, jVar3);
                                            jVar = jVar3;
                                        } else {
                                            synchronized (jVar2) {
                                                k kVar = this.g;
                                                Objects.requireNonNull(kVar);
                                                d0.z.d.m.checkParameterIsNotNull(jVar2, "connection");
                                                byte[] bArr = f0.e0.c.a;
                                                kVar.d.add(jVar2);
                                                f0.e0.f.c.d(kVar.f3621b, kVar.c, 0L, 2);
                                                this.i.f(jVar2);
                                            }
                                            t tVar4 = this.j;
                                            e eVar5 = this.i;
                                            Objects.requireNonNull(tVar4);
                                            d0.z.d.m.checkParameterIsNotNull(eVar5, NotificationCompat.CATEGORY_CALL);
                                            d0.z.d.m.checkParameterIsNotNull(jVar2, "connection");
                                            z4 = z3;
                                            jVar = jVar2;
                                        }
                                    }
                                } else {
                                    m.a aVar4 = this.a;
                                    if (aVar4 == null) {
                                        d0.z.d.m.throwNpe();
                                    }
                                    c0VarB = aVar4.b();
                                }
                            }
                            jVar2.c(i, i2, i3, i4, z2, this.i, this.j);
                            this.i.f3617x = null;
                            lVar = this.i.f3618y.O;
                            c0 c0Var22 = jVar2.q;
                            synchronized (lVar) {
                            }
                        } catch (Throwable th) {
                            this.i.f3617x = null;
                            throw th;
                        }
                        list = null;
                        j jVar22 = new j(this.g, c0VarB);
                        this.i.f3617x = jVar22;
                    } else {
                        jVar = this.i.p;
                        if (jVar == null) {
                            d0.z.d.m.throwNpe();
                        }
                        this.j.a(this.i, jVar);
                    }
                    z4 = z3;
                }
            } else {
                this.c = 0;
                this.d = 0;
                this.e = 0;
                if (this.g.a(this.h, this.i, null, false)) {
                }
                z4 = z3;
            }
            if (jVar.i(z4)) {
                return jVar;
            }
            jVar.l();
            if (this.f == null) {
                m.a aVar5 = this.a;
                if (aVar5 != null ? aVar5.a() : true) {
                    continue;
                } else {
                    m mVar2 = this.f3615b;
                    if (!(mVar2 != null ? mVar2.a() : true)) {
                        throw new IOException("exhausted all routes");
                    }
                }
            }
        }
        throw new IOException("Canceled");
    }

    public final boolean b(w wVar) {
        d0.z.d.m.checkParameterIsNotNull(wVar, "url");
        w wVar2 = this.h.a;
        return wVar.h == wVar2.h && d0.z.d.m.areEqual(wVar.g, wVar2.g);
    }

    public final void c(IOException iOException) {
        d0.z.d.m.checkParameterIsNotNull(iOException, "e");
        this.f = null;
        if ((iOException instanceof StreamResetException) && ((StreamResetException) iOException).errorCode == f0.e0.j.a.REFUSED_STREAM) {
            this.c++;
        } else if (iOException instanceof ConnectionShutdownException) {
            this.d++;
        } else {
            this.e++;
        }
    }
}
