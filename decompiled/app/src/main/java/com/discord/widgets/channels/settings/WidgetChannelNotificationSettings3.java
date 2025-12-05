package com.discord.widgets.channels.settings;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.preview.GuildPreview;
import com.discord.models.domain.ModelMuteConfig;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.guild.Guild;
import com.discord.stores.NotificationTextUtils;
import com.discord.stores.StoreGuildProfiles;
import com.discord.stores.StoreThreadsJoined;
import com.discord.utilities.channel.ChannelNotificationSettingsUtils;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.widgets.channels.settings.WidgetChannelNotificationSettings;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.Func6;

/* compiled from: WidgetChannelNotificationSettings.kt */
/* renamed from: com.discord.widgets.channels.settings.WidgetChannelNotificationSettings$Model$Companion$get$1$$special$$inlined$let$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChannelNotificationSettings3<T1, T2, T3, T4, T5, T6, R> implements Func6<StoreThreadsJoined.JoinedThread, Channel, Guild, ModelNotificationSettings, StoreGuildProfiles.GuildProfileData, Boolean, WidgetChannelNotificationSettings.Model> {
    public final /* synthetic */ Channel $channel$inlined;

    public WidgetChannelNotificationSettings3(Channel channel) {
        this.$channel$inlined = channel;
    }

    @Override // p658rx.functions.Func6
    public /* bridge */ /* synthetic */ WidgetChannelNotificationSettings.Model call(StoreThreadsJoined.JoinedThread joinedThread, Channel channel, Guild guild, ModelNotificationSettings modelNotificationSettings, StoreGuildProfiles.GuildProfileData guildProfileData, Boolean bool) {
        return call2(joinedThread, channel, guild, modelNotificationSettings, guildProfileData, bool);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChannelNotificationSettings.Model call2(StoreThreadsJoined.JoinedThread joinedThread, Channel channel, Guild guild, ModelNotificationSettings modelNotificationSettings, StoreGuildProfiles.GuildProfileData guildProfileData, Boolean bool) {
        int iComputeNotificationSetting;
        String muteEndTime;
        String str;
        GuildPreview data;
        ModelMuteConfig muteConfig;
        if (guild == null) {
            return null;
        }
        NotificationTextUtils notificationTextUtils = NotificationTextUtils.INSTANCE;
        Integer numChannelMessageNotificationLevel = notificationTextUtils.channelMessageNotificationLevel(modelNotificationSettings, channel, guild);
        if (ChannelUtils.m7673H(this.$channel$inlined)) {
            int iComputeThreadNotificationSetting = ThreadUtils.INSTANCE.computeThreadNotificationSetting(joinedThread, notificationTextUtils.isGuildOrCategoryOrChannelMuted(modelNotificationSettings, channel), numChannelMessageNotificationLevel);
            iComputeNotificationSetting = iComputeThreadNotificationSetting != 4 ? iComputeThreadNotificationSetting != 8 ? ModelNotificationSettings.FREQUENCY_ALL : ModelNotificationSettings.FREQUENCY_NOTHING : ModelNotificationSettings.FREQUENCY_MENTIONS;
        } else {
            ChannelNotificationSettingsUtils channelNotificationSettingsUtils = ChannelNotificationSettingsUtils.INSTANCE;
            Channel channel2 = this.$channel$inlined;
            Intrinsics3.checkNotNullExpressionValue(modelNotificationSettings, "guildSettings");
            iComputeNotificationSetting = channelNotificationSettingsUtils.computeNotificationSetting(guild, channel2, modelNotificationSettings);
        }
        int i = iComputeNotificationSetting;
        ModelNotificationSettings.ChannelOverride channelOverride = modelNotificationSettings.getChannelOverride(this.$channel$inlined.getId());
        boolean z2 = !ChannelUtils.m7673H(this.$channel$inlined) ? channelOverride == null || !channelOverride.isMuted() : joinedThread == null || !joinedThread.getMuted();
        if (ChannelUtils.m7673H(this.$channel$inlined)) {
            if (joinedThread != null && (muteConfig = joinedThread.getMuteConfig()) != null) {
                muteEndTime = muteConfig.getEndTime();
                str = muteEndTime;
            }
            str = null;
        } else {
            if (channelOverride != null) {
                muteEndTime = channelOverride.getMuteEndTime();
                str = muteEndTime;
            }
            str = null;
        }
        boolean z3 = i == ModelNotificationSettings.FREQUENCY_UNSET;
        Integer numValueOf = channelOverride != null ? Integer.valueOf(channelOverride.getForumPostNotificationSetting()) : null;
        Integer approximateMemberCount = (guildProfileData == null || (data = guildProfileData.getData()) == null) ? null : data.getApproximateMemberCount();
        boolean z4 = approximateMemberCount != null && approximateMemberCount.intValue() > 2500;
        Channel channel3 = this.$channel$inlined;
        Intrinsics3.checkNotNullExpressionValue(modelNotificationSettings, "guildSettings");
        boolean zIsMuted = modelNotificationSettings.isMuted();
        Integer numValueOf2 = channelOverride != null ? Integer.valueOf(channelOverride.getFlags()) : null;
        Intrinsics3.checkNotNullExpressionValue(bool, "canAccessRedesignedForumChannels");
        return new WidgetChannelNotificationSettings.Model(channel3, z2, str, zIsMuted, i, numValueOf2, numValueOf, numChannelMessageNotificationLevel, z3, z4, bool.booleanValue());
    }
}
