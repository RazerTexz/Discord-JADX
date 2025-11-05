package com.discord.widgets.guilds.invite;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreInstantInvites;
import com.discord.widgets.guilds.invite.GuildInviteViewModel;
import j0.k.b;

/* compiled from: GuildInviteViewModel.kt */
/* loaded from: classes2.dex */
public final class GuildInviteViewModel$Companion$observeStoreState$1<T, R> implements b<StoreInstantInvites.InviteState, GuildInviteViewModel.StoreState> {
    public static final GuildInviteViewModel$Companion$observeStoreState$1 INSTANCE = new GuildInviteViewModel$Companion$observeStoreState$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ GuildInviteViewModel.StoreState call(StoreInstantInvites.InviteState inviteState) {
        return call2(inviteState);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final GuildInviteViewModel.StoreState call2(StoreInstantInvites.InviteState inviteState) {
        return inviteState instanceof StoreInstantInvites.InviteState.Loading ? GuildInviteViewModel.StoreState.Loading.INSTANCE : inviteState instanceof StoreInstantInvites.InviteState.Resolved ? new GuildInviteViewModel.StoreState.Loaded(((StoreInstantInvites.InviteState.Resolved) inviteState).getInvite()) : GuildInviteViewModel.StoreState.Invalid.INSTANCE;
    }
}
