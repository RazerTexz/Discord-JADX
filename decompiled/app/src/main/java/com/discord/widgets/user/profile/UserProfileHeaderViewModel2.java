package com.discord.widgets.user.profile;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreGuilds;
import java.util.Collection;
import java.util.Map;
import p507d0.p580t.Maps6;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;

/* compiled from: UserProfileHeaderViewModel.kt */
/* renamed from: com.discord.widgets.user.profile.UserProfileHeaderViewModel$Companion$observeComputedMembers$1, reason: use source file name */
/* loaded from: classes.dex */
public final class UserProfileHeaderViewModel2<T, R> implements Func1<Channel, Observable<? extends Map<Long, ? extends GuildMember>>> {
    public final /* synthetic */ StoreGuilds $storeGuilds;
    public final /* synthetic */ Collection $users;

    public UserProfileHeaderViewModel2(StoreGuilds storeGuilds, Collection collection) {
        this.$storeGuilds = storeGuilds;
        this.$users = collection;
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends Map<Long, ? extends GuildMember>> call(Channel channel) {
        return call2(channel);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Map<Long, GuildMember>> call2(Channel channel) {
        Observable<Map<Long, GuildMember>> observableObserveComputed;
        return (channel == null || (observableObserveComputed = this.$storeGuilds.observeComputed(channel.getGuildId(), this.$users)) == null) ? new ScalarSynchronousObservable(Maps6.emptyMap()) : observableObserveComputed;
    }
}
