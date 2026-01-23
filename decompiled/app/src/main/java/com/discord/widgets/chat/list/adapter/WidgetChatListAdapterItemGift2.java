package com.discord.widgets.chat.list.adapter;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreGifting;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGift;
import com.discord.widgets.chat.list.entries.GiftEntry;
import kotlin.NoWhenBranchMatchedException;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;

/* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGift$ModelProvider$get$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetChatListAdapterItemGift.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGift2<T, R> implements Func1<StoreGifting.GiftState, Observable<? extends WidgetChatListAdapterItemGift.Model>> {
    public final /* synthetic */ GiftEntry $item;

    public WidgetChatListAdapterItemGift2(GiftEntry giftEntry) {
        this.$item = giftEntry;
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChatListAdapterItemGift.Model> call(StoreGifting.GiftState giftState) {
        return call2(giftState);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChatListAdapterItemGift.Model> call2(StoreGifting.GiftState giftState) {
        if ((giftState instanceof StoreGifting.GiftState.Loading) || (giftState instanceof StoreGifting.GiftState.LoadFailed)) {
            return new ScalarSynchronousObservable(WidgetChatListAdapterItemGift.Model.Loading.INSTANCE);
        }
        if (giftState instanceof StoreGifting.GiftState.Revoking) {
            return WidgetChatListAdapterItemGift.ModelProvider.getResolvedGiftModel$default(WidgetChatListAdapterItemGift.ModelProvider.INSTANCE, ((StoreGifting.GiftState.Revoking) giftState).getGift(), false, 2, null);
        }
        if (giftState instanceof StoreGifting.GiftState.Resolved) {
            return WidgetChatListAdapterItemGift.ModelProvider.getResolvedGiftModel$default(WidgetChatListAdapterItemGift.ModelProvider.INSTANCE, ((StoreGifting.GiftState.Resolved) giftState).getGift(), false, 2, null);
        }
        if (giftState instanceof StoreGifting.GiftState.Redeeming) {
            return WidgetChatListAdapterItemGift.ModelProvider.access$getResolvedGiftModel(WidgetChatListAdapterItemGift.ModelProvider.INSTANCE, ((StoreGifting.GiftState.Redeeming) giftState).getGift(), true);
        }
        if (giftState instanceof StoreGifting.GiftState.RedeemedFailed) {
            return WidgetChatListAdapterItemGift.ModelProvider.getResolvedGiftModel$default(WidgetChatListAdapterItemGift.ModelProvider.INSTANCE, ((StoreGifting.GiftState.RedeemedFailed) giftState).getGift(), false, 2, null);
        }
        if (giftState instanceof StoreGifting.GiftState.Invalid) {
            return WidgetChatListAdapterItemGift.ModelProvider.access$getInvalidGift(WidgetChatListAdapterItemGift.ModelProvider.INSTANCE, this.$item);
        }
        throw new NoWhenBranchMatchedException();
    }
}
