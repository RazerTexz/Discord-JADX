package com.discord.widgets.chat.list.adapter;

import androidx.core.app.NotificationCompat;
import com.discord.api.user.User;
import com.discord.models.domain.ModelGift;
import com.discord.models.domain.ModelLibraryApplication;
import com.discord.models.user.MeUser;
import com.discord.utilities.time.ClockFactory;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGift;
import java.util.Map;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.Func2;

/* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGift$ModelProvider$getResolvedGiftModel$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetChatListAdapterItemGift.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGift4<T1, T2, R> implements Func2<MeUser, Map<Long, ? extends ModelLibraryApplication>, WidgetChatListAdapterItemGift.Model> {
    public final /* synthetic */ ModelGift $gift;
    public final /* synthetic */ boolean $redeeming;

    public WidgetChatListAdapterItemGift4(ModelGift modelGift, boolean z2) {
        this.$gift = modelGift;
        this.$redeeming = z2;
    }

    @Override // p658rx.functions.Func2
    public /* bridge */ /* synthetic */ WidgetChatListAdapterItemGift.Model call(MeUser meUser, Map<Long, ? extends ModelLibraryApplication> map) {
        return call2(meUser, (Map<Long, ModelLibraryApplication>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChatListAdapterItemGift.Model call2(MeUser meUser, Map<Long, ModelLibraryApplication> map) {
        WidgetChatListAdapterItemGift.Model invalid;
        if (this.$gift.isExpired(ClockFactory.get().currentTimeMillis())) {
            User user = this.$gift.getUser();
            invalid = new WidgetChatListAdapterItemGift.Model.Invalid(user != null ? Long.valueOf(user.getId()) : null, meUser.getId());
        } else {
            ModelGift modelGift = this.$gift;
            Intrinsics3.checkNotNullExpressionValue(meUser, "me");
            invalid = new WidgetChatListAdapterItemGift.Model.Resolved(modelGift, meUser, map != null && map.containsKey(Long.valueOf(this.$gift.getSkuId())), this.$redeeming);
        }
        return invalid;
    }
}
