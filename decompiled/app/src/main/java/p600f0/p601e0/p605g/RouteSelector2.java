package p600f0.p601e0.p605g;

import java.net.Proxy;
import java.net.URI;
import java.util.List;
import kotlin.jvm.functions.Function0;
import p507d0.p580t.CollectionsJVM;
import p507d0.p592z.p594d.Lambda;
import p600f0.HttpUrl;
import p600f0.p601e0.Util7;

/* JADX INFO: renamed from: f0.e0.g.n, reason: use source file name */
/* JADX INFO: compiled from: RouteSelector.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class RouteSelector2 extends Lambda implements Function0<List<? extends Proxy>> {
    public final /* synthetic */ Proxy $proxy;
    public final /* synthetic */ HttpUrl $url;
    public final /* synthetic */ RouteSelector this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RouteSelector2(RouteSelector routeSelector, Proxy proxy, HttpUrl httpUrl) {
        super(0);
        this.this$0 = routeSelector;
        this.$proxy = proxy;
        this.$url = httpUrl;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends Proxy> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends Proxy> invoke2() {
        Proxy proxy = this.$proxy;
        if (proxy != null) {
            return CollectionsJVM.listOf(proxy);
        }
        URI uriM10407i = this.$url.m10407i();
        if (uriM10407i.getHost() == null) {
            return Util7.m10132m(Proxy.NO_PROXY);
        }
        List<Proxy> listSelect = this.this$0.f25518e.f25363k.select(uriM10407i);
        return listSelect == null || listSelect.isEmpty() ? Util7.m10132m(Proxy.NO_PROXY) : Util7.m10145z(listSelect);
    }
}
