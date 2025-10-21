package com.discord.utilities.analytics;

import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreStream;

/* compiled from: AnalyticsUtils.kt */
/* renamed from: com.discord.utilities.analytics.AnalyticsUtilsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class AnalyticsUtils6 {
    public static final /* synthetic */ TrackGuild access$fill(TrackGuild trackGuild) {
        return fill(trackGuild);
    }

    private static final TrackGuild fill(TrackGuild trackGuild) {
        Long guildId;
        if (trackGuild != null && (guildId = trackGuild.getGuildId()) != null) {
            long jLongValue = guildId.longValue();
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Guild guild = companion.getGuilds().getGuild(jLongValue);
            if (guild != null) {
                long id2 = companion.getUsers().getMeSnapshot().getId();
                return TrackGuild.a(trackGuild, null, null, null, null, null, null, null, null, null, Boolean.valueOf(companion.getGuilds().getMember(jLongValue, id2) != null), null, Boolean.valueOf(guild.isOwner(id2)), 1535);
            }
        }
        return trackGuild;
    }
}
