package com.discord.widgets.chat.input.expression;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.sticker.Sticker;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreChannelsSelected;
import com.discord.widgets.chat.input.expression.ExpressionTrayViewModel;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.Map;
import rx.functions.Func5;

/* compiled from: ExpressionTrayViewModel.kt */
/* renamed from: com.discord.widgets.chat.input.expression.ExpressionTrayViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class ExpressionTrayViewModel2<T1, T2, T3, T4, T5, R> implements Func5<ExpressionTrayTab, StoreChannelsSelected.ResolvedSelectedChannel, MeUser, Map<Long, ? extends Map<Long, ? extends Sticker>>, Map<Long, ? extends Guild>, ExpressionTrayViewModel.StoreState> {
    public static final ExpressionTrayViewModel2 INSTANCE = new ExpressionTrayViewModel2();

    @Override // rx.functions.Func5
    public /* bridge */ /* synthetic */ ExpressionTrayViewModel.StoreState call(ExpressionTrayTab expressionTrayTab, StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel, MeUser meUser, Map<Long, ? extends Map<Long, ? extends Sticker>> map, Map<Long, ? extends Guild> map2) {
        return call2(expressionTrayTab, resolvedSelectedChannel, meUser, (Map<Long, ? extends Map<Long, Sticker>>) map, (Map<Long, Guild>) map2);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final ExpressionTrayViewModel.StoreState call2(ExpressionTrayTab expressionTrayTab, StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel, MeUser meUser, Map<Long, ? extends Map<Long, Sticker>> map, Map<Long, Guild> map2) {
        Intrinsics3.checkNotNullExpressionValue(expressionTrayTab, "lastSelectedTab");
        Channel channelOrParent = resolvedSelectedChannel.getChannelOrParent();
        Long lValueOf = channelOrParent != null ? Long.valueOf(channelOrParent.getGuildId()) : null;
        Intrinsics3.checkNotNullExpressionValue(map, "guildStickers");
        return new ExpressionTrayViewModel.StoreState(expressionTrayTab, lValueOf, meUser, map, _Collections.toSet(map2.keySet()), resolvedSelectedChannel instanceof StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft);
    }
}
