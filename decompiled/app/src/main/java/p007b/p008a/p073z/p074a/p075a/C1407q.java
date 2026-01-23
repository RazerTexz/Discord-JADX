package p007b.p008a.p073z.p074a.p075a;

import com.discord.api.channel.Channel;
import com.discord.stores.StoreStream;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;

/* JADX INFO: renamed from: b.a.z.a.a.q */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C1407q implements Func1 {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ long f2106j;

    public /* synthetic */ C1407q(long j) {
        this.f2106j = j;
    }

    @Override // p637j0.p641k.Func1
    public final Object call(Object obj) {
        Channel channel = (Channel) obj;
        return channel == null ? new ScalarSynchronousObservable(null) : Observable.m11073h(StoreStream.getGuilds().observeGuild(channel.getGuildId()), StoreStream.getUsers().observeMe(), StoreStream.getPermissions().observePermissionsForChannel(this.f2106j), StoreStream.getGuilds().observeSortedRoles(channel.getGuildId()).m11099Y(new C1409s(channel)), new C1408r(channel));
    }
}
