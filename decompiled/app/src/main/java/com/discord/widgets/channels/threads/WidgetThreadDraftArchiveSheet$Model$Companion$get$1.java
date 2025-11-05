package com.discord.widgets.channels.threads;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreThreadDraft;
import com.discord.widgets.channels.threads.WidgetThreadDraftArchiveSheet;
import d0.z.d.m;
import rx.functions.Func3;

/* compiled from: WidgetThreadDraftArchiveSheet.kt */
/* loaded from: classes2.dex */
public final class WidgetThreadDraftArchiveSheet$Model$Companion$get$1<T1, T2, T3, R> implements Func3<StoreThreadDraft.ThreadDraftState, Guild, Channel, WidgetThreadDraftArchiveSheet.Model> {
    public static final WidgetThreadDraftArchiveSheet$Model$Companion$get$1 INSTANCE = new WidgetThreadDraftArchiveSheet$Model$Companion$get$1();

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ WidgetThreadDraftArchiveSheet.Model call(StoreThreadDraft.ThreadDraftState threadDraftState, Guild guild, Channel channel) {
        return call2(threadDraftState, guild, channel);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetThreadDraftArchiveSheet.Model call2(StoreThreadDraft.ThreadDraftState threadDraftState, Guild guild, Channel channel) {
        m.checkNotNullExpressionValue(threadDraftState, "draftState");
        return new WidgetThreadDraftArchiveSheet.Model(threadDraftState, guild, channel);
    }
}
