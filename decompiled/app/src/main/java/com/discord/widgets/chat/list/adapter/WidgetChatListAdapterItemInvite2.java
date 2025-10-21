package com.discord.widgets.chat.list.adapter;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreInstantInvites;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemInvite;
import com.discord.widgets.chat.list.entries.InviteEntry;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import rx.Observable;

/* compiled from: WidgetChatListAdapterItemInvite.kt */
/* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemInvite$ModelProvider$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemInvite2<T, R> implements Func1<StoreInstantInvites.InviteState, Observable<? extends WidgetChatListAdapterItemInvite.Model>> {
    public final /* synthetic */ InviteEntry $item;

    public WidgetChatListAdapterItemInvite2(InviteEntry inviteEntry) {
        this.$item = inviteEntry;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChatListAdapterItemInvite.Model> call(StoreInstantInvites.InviteState inviteState) {
        return call2(inviteState);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChatListAdapterItemInvite.Model> call2(StoreInstantInvites.InviteState inviteState) {
        return ((inviteState instanceof StoreInstantInvites.InviteState.Loading) || (inviteState instanceof StoreInstantInvites.InviteState.LoadFailed)) ? new ScalarSynchronousObservable(WidgetChatListAdapterItemInvite.Model.Loading.INSTANCE) : inviteState instanceof StoreInstantInvites.InviteState.Resolved ? WidgetChatListAdapterItemInvite.ModelProvider.access$observeModel(WidgetChatListAdapterItemInvite.ModelProvider.INSTANCE, this.$item, ((StoreInstantInvites.InviteState.Resolved) inviteState).getInvite()) : WidgetChatListAdapterItemInvite.ModelProvider.access$getInvalidInvite(WidgetChatListAdapterItemInvite.ModelProvider.INSTANCE, this.$item);
    }
}
