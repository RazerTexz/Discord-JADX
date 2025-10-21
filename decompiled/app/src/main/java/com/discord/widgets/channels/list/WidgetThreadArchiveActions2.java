package com.discord.widgets.channels.list;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.widgets.channels.list.WidgetThreadArchiveActions;
import rx.functions.Func3;

/* compiled from: WidgetThreadArchiveActions.kt */
/* renamed from: com.discord.widgets.channels.list.WidgetThreadArchiveActions$Model$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetThreadArchiveActions2<T1, T2, T3, R> implements Func3<Channel, Guild, Long, WidgetThreadArchiveActions.Model> {
    public static final WidgetThreadArchiveActions2 INSTANCE = new WidgetThreadArchiveActions2();

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ WidgetThreadArchiveActions.Model call(Channel channel, Guild guild, Long l) {
        return call2(channel, guild, l);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetThreadArchiveActions.Model call2(Channel channel, Guild guild, Long l) {
        if (channel != null) {
            return new WidgetThreadArchiveActions.Model(channel, guild, ThreadUtils.INSTANCE.isThreadModerator(Long.valueOf(l != null ? l.longValue() : 0L)));
        }
        return null;
    }
}
