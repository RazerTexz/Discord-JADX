package com.discord.widgets.chat.list.adapter;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreInstantInvites;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemInvite;
import com.discord.widgets.chat.list.entries.InviteEntry;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;

/* compiled from: WidgetChatListAdapterItemInvite.kt */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemInvite$ModelProvider$get$1<T, R> implements b<StoreInstantInvites.InviteState, Observable<? extends WidgetChatListAdapterItemInvite.Model>> {
    public final /* synthetic */ InviteEntry $item;

    public WidgetChatListAdapterItemInvite$ModelProvider$get$1(InviteEntry inviteEntry) {
        this.$item = inviteEntry;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChatListAdapterItemInvite.Model> call(StoreInstantInvites.InviteState inviteState) {
        return call2(inviteState);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChatListAdapterItemInvite.Model> call2(StoreInstantInvites.InviteState inviteState) {
        return ((inviteState instanceof StoreInstantInvites.InviteState.Loading) || (inviteState instanceof StoreInstantInvites.InviteState.LoadFailed)) ? new k(WidgetChatListAdapterItemInvite.Model.Loading.INSTANCE) : inviteState instanceof StoreInstantInvites.InviteState.Resolved ? WidgetChatListAdapterItemInvite.ModelProvider.access$observeModel(WidgetChatListAdapterItemInvite.ModelProvider.INSTANCE, this.$item, ((StoreInstantInvites.InviteState.Resolved) inviteState).getInvite()) : WidgetChatListAdapterItemInvite.ModelProvider.access$getInvalidInvite(WidgetChatListAdapterItemInvite.ModelProvider.INSTANCE, this.$item);
    }
}
