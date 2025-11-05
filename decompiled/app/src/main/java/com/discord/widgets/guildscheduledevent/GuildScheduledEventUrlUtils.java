package com.discord.widgets.guildscheduledevent;

import com.discord.BuildConfig;
import com.discord.widgets.chat.input.MentionUtilsKt;

/* compiled from: GuildScheduledEventUrlUtils.kt */
/* loaded from: classes2.dex */
public final class GuildScheduledEventUrlUtils {
    public static final GuildScheduledEventUrlUtils INSTANCE = new GuildScheduledEventUrlUtils();

    private GuildScheduledEventUrlUtils() {
    }

    public final CharSequence getEventDetailsUrl(long guildId, long guildEventId) {
        return BuildConfig.HOST + "/events/" + guildId + MentionUtilsKt.SLASH_CHAR + guildEventId;
    }
}
