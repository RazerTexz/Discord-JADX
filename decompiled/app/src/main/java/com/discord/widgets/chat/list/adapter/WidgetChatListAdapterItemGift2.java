package com.discord.widgets.chat.list.adapter;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreGifting;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGift;
import com.discord.widgets.chat.list.entries.GiftEntry;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import kotlin.NoWhenBranchMatchedException;
import rx.Observable;

/* compiled from: WidgetChatListAdapterItemGift.kt */
/* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGift$ModelProvider$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGift2<T, R> implements Func1<StoreGifting.GiftState, Observable<? extends WidgetChatListAdapterItemGift.Model>> {
    public final /* synthetic */ GiftEntry $item;

    public WidgetChatListAdapterItemGift2(GiftEntry giftEntry) {
        this.$item = giftEntry;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChatListAdapterItemGift.Model> call(StoreGifting.GiftState giftState) {
        return call2(giftState);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
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
