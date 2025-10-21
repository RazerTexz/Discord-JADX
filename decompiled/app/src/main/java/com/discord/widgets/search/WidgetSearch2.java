package com.discord.widgets.search;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreSearch;
import com.discord.widgets.search.WidgetSearch;
import d0.z.d.Intrinsics3;
import rx.functions.Func4;

/* compiled from: WidgetSearch.kt */
/* renamed from: com.discord.widgets.search.WidgetSearch$Model$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetSearch2<T1, T2, T3, T4, R> implements Func4<Guild, Channel, StoreSearch.DisplayState, Boolean, WidgetSearch.Model> {
    public static final WidgetSearch2 INSTANCE = new WidgetSearch2();

    @Override // rx.functions.Func4
    public /* bridge */ /* synthetic */ WidgetSearch.Model call(Guild guild, Channel channel, StoreSearch.DisplayState displayState, Boolean bool) {
        return call2(guild, channel, displayState, bool);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetSearch.Model call2(Guild guild, Channel channel, StoreSearch.DisplayState displayState, Boolean bool) {
        if ((guild == null && channel == null) || displayState == null) {
            return null;
        }
        Intrinsics3.checkNotNullExpressionValue(bool, "isQueryValid");
        return new WidgetSearch.Model(guild, channel, displayState, bool.booleanValue());
    }
}
