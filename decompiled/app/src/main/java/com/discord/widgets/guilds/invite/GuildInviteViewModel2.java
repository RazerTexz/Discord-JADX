package com.discord.widgets.guilds.invite;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreInstantInvites;
import com.discord.widgets.guilds.invite.GuildInviteViewModel;
import p637j0.p641k.Func1;

/* compiled from: GuildInviteViewModel.kt */
/* renamed from: com.discord.widgets.guilds.invite.GuildInviteViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class GuildInviteViewModel2<T, R> implements Func1<StoreInstantInvites.InviteState, GuildInviteViewModel.StoreState> {
    public static final GuildInviteViewModel2 INSTANCE = new GuildInviteViewModel2();

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ GuildInviteViewModel.StoreState call(StoreInstantInvites.InviteState inviteState) {
        return call2(inviteState);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final GuildInviteViewModel.StoreState call2(StoreInstantInvites.InviteState inviteState) {
        return inviteState instanceof StoreInstantInvites.InviteState.Loading ? GuildInviteViewModel.StoreState.Loading.INSTANCE : inviteState instanceof StoreInstantInvites.InviteState.Resolved ? new GuildInviteViewModel.StoreState.Loaded(((StoreInstantInvites.InviteState.Resolved) inviteState).getInvite()) : GuildInviteViewModel.StoreState.Invalid.INSTANCE;
    }
}
