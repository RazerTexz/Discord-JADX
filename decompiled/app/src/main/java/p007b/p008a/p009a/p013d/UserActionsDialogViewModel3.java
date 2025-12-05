package p007b.p008a.p009a.p013d;

import com.discord.api.channel.Channel;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreGuilds;
import p507d0.p580t.SetsJVM;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;

/* compiled from: UserActionsDialogViewModel.kt */
/* renamed from: b.a.a.d.d, reason: use source file name */
/* loaded from: classes.dex */
public final class UserActionsDialogViewModel3<T, R> implements Func1<Channel, Observable<? extends GuildMember>> {

    /* renamed from: j */
    public final /* synthetic */ StoreGuilds f326j;

    /* renamed from: k */
    public final /* synthetic */ long f327k;

    public UserActionsDialogViewModel3(StoreGuilds storeGuilds, long j) {
        this.f326j = storeGuilds;
        this.f327k = j;
    }

    @Override // p637j0.p641k.Func1
    public Observable<? extends GuildMember> call(Channel channel) {
        Channel channel2 = channel;
        return channel2 != null ? this.f326j.observeComputed(channel2.getGuildId(), SetsJVM.setOf(Long.valueOf(this.f327k))).m11083G(new UserActionsDialogViewModel2(this, channel2)) : new ScalarSynchronousObservable(null);
    }
}
