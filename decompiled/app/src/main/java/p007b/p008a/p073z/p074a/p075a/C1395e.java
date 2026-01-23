package p007b.p008a.p073z.p074a.p075a;

import com.discord.api.channel.Channel;
import com.discord.stores.StoreStream;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import java.util.concurrent.TimeUnit;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;

/* JADX INFO: renamed from: b.a.z.a.a.e */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C1395e implements Func1 {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ long f2088j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ long f2089k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ Observable f2090l;

    public /* synthetic */ C1395e(long j, long j2, Observable observable) {
        this.f2088j = j;
        this.f2089k = j2;
        this.f2090l = observable;
    }

    @Override // p637j0.p641k.Func1
    public final Object call(Object obj) {
        long j = this.f2088j;
        long j2 = this.f2089k;
        Observable observable = this.f2090l;
        Channel channel = (Channel) obj;
        if (channel == null) {
            return new ScalarSynchronousObservable(null);
        }
        Observable observableM11073h = Observable.m11073h(StoreStream.getUsers().observeMe(), StoreStream.getGuilds().observeGuild(j), StoreStream.getPermissions().observePermissionsForChannel(j2), observable.m11110p(300L, TimeUnit.MILLISECONDS).m11099Y(new C1397g(j, channel)).m11112r(), new C1400j(channel));
        Intrinsics3.checkNotNullExpressionValue(observableM11073h, "observable");
        return ObservableExtensionsKt.computationBuffered(observableM11073h).m11112r();
    }
}
