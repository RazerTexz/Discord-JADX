package f0.e0.g;

import androidx.core.app.NotificationCompat;
import f0.c0;
import f0.t;
import f0.w;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

/* compiled from: RouteSelector.kt */
/* loaded from: classes3.dex */
public final class m {
    public List<? extends Proxy> a;

    /* renamed from: b, reason: collision with root package name */
    public int f3622b;
    public List<? extends InetSocketAddress> c;
    public final List<c0> d;
    public final f0.a e;
    public final l f;
    public final f0.e g;
    public final t h;

    /* compiled from: RouteSelector.kt */
    public static final class a {
        public int a;

        /* renamed from: b, reason: collision with root package name */
        public final List<c0> f3623b;

        public a(List<c0> list) {
            d0.z.d.m.checkParameterIsNotNull(list, "routes");
            this.f3623b = list;
        }

        public final boolean a() {
            return this.a < this.f3623b.size();
        }

        public final c0 b() {
            if (!a()) {
                throw new NoSuchElementException();
            }
            List<c0> list = this.f3623b;
            int i = this.a;
            this.a = i + 1;
            return list.get(i);
        }
    }

    public m(f0.a aVar, l lVar, f0.e eVar, t tVar) {
        d0.z.d.m.checkParameterIsNotNull(aVar, "address");
        d0.z.d.m.checkParameterIsNotNull(lVar, "routeDatabase");
        d0.z.d.m.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
        d0.z.d.m.checkParameterIsNotNull(tVar, "eventListener");
        this.e = aVar;
        this.f = lVar;
        this.g = eVar;
        this.h = tVar;
        this.a = d0.t.n.emptyList();
        this.c = d0.t.n.emptyList();
        this.d = new ArrayList();
        w wVar = aVar.a;
        n nVar = new n(this, aVar.j, wVar);
        Objects.requireNonNull(tVar);
        d0.z.d.m.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
        d0.z.d.m.checkParameterIsNotNull(wVar, "url");
        List<? extends Proxy> listInvoke2 = nVar.invoke2();
        this.a = listInvoke2;
        this.f3622b = 0;
        d0.z.d.m.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
        d0.z.d.m.checkParameterIsNotNull(wVar, "url");
        d0.z.d.m.checkParameterIsNotNull(listInvoke2, "proxies");
    }

    public final boolean a() {
        return b() || (this.d.isEmpty() ^ true);
    }

    public final boolean b() {
        return this.f3622b < this.a.size();
    }
}
