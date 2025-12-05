package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.message.Message;
import com.discord.api.permission.Permission;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreThreadsJoined;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.threads.ThreadUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: NotificationTextUtils.kt */
/* loaded from: classes2.dex */
public final class NotificationTextUtils {
    public static final NotificationTextUtils INSTANCE = new NotificationTextUtils();

    private NotificationTextUtils() {
    }

    private final boolean isNotificationAllowed(ModelNotificationSettings modelNotificationSettings, User user, Collection<Long> collection, Message message, Guild guild, Channel channel, Long l, long j) {
        if (modelNotificationSettings.isMobilePush() && !isGuildOrCategoryOrChannelMuted(modelNotificationSettings, channel)) {
            return shouldNotifyForLevel(channelMessageNotificationLevel(modelNotificationSettings, channel, guild), user, collection, message, channel, l, j, modelNotificationSettings.isSuppressEveryone(), modelNotificationSettings.isSuppressRoles());
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean isThreadNotificationAllowed(User me2, Collection<Long> myRoleIds, Message message, StoreThreadsJoined.JoinedThread joinedThread, ModelNotificationSettings guildSettings, Guild guild, Channel thread, Channel parentChannel) {
        boolean z2;
        boolean z3;
        if (isGuildOrCategoryOrChannelMuted(guildSettings, thread)) {
            return false;
        }
        int iComputeThreadNotificationSetting = ThreadUtils.INSTANCE.computeThreadNotificationSetting(joinedThread, isGuildOrCategoryOrChannelMuted(guildSettings, parentChannel), channelMessageNotificationLevel(guildSettings, parentChannel, guild));
        if (iComputeThreadNotificationSetting != 2) {
            if (iComputeThreadNotificationSetting == 8) {
                return false;
            }
            if (!Intrinsics3.areEqual(message.getMentionEveryone(), Boolean.TRUE)) {
                List<com.discord.api.user.User> listM8047t = message.m8047t();
                if (listM8047t == null) {
                    List<Long> listM8046s = message.m8046s();
                    if (listM8046s == null) {
                        return false;
                    }
                    if (listM8046s.isEmpty()) {
                        z2 = false;
                        if (z2) {
                            return false;
                        }
                    } else {
                        Iterator<T> it = listM8046s.iterator();
                        while (it.hasNext()) {
                            if (myRoleIds.contains(Long.valueOf(((Number) it.next()).longValue()))) {
                                z2 = true;
                                break;
                            }
                        }
                        z2 = false;
                        if (z2) {
                        }
                    }
                } else if (listM8047t.isEmpty()) {
                    z3 = false;
                    if (!z3) {
                    }
                } else {
                    Iterator<T> it2 = listM8047t.iterator();
                    while (it2.hasNext()) {
                        if (((com.discord.api.user.User) it2.next()).getId() == me2.getId()) {
                            z3 = true;
                            break;
                        }
                    }
                    z3 = false;
                    if (!z3) {
                    }
                }
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean messageContainsMention(User me2, Collection<Long> myRoleIds, Message message, boolean isSuppressEveryone, boolean isSuppressRoles) {
        List<Long> listM8046s;
        boolean z2;
        boolean z3;
        if (!Intrinsics3.areEqual(message.getMentionEveryone(), Boolean.TRUE) || isSuppressEveryone) {
            List<com.discord.api.user.User> listM8047t = message.m8047t();
            if (listM8047t == null) {
                if (isSuppressRoles || (listM8046s = message.m8046s()) == null) {
                    return false;
                }
                if (listM8046s.isEmpty()) {
                    z2 = false;
                    if (z2) {
                        return false;
                    }
                } else {
                    Iterator<T> it = listM8046s.iterator();
                    while (it.hasNext()) {
                        if (myRoleIds.contains(Long.valueOf(((Number) it.next()).longValue()))) {
                            z2 = true;
                            break;
                        }
                    }
                    z2 = false;
                    if (z2) {
                    }
                }
            } else if (listM8047t.isEmpty()) {
                z3 = false;
                if (!z3) {
                }
            } else {
                Iterator<T> it2 = listM8047t.iterator();
                while (it2.hasNext()) {
                    if (((com.discord.api.user.User) it2.next()).getId() == me2.getId()) {
                        z3 = true;
                        break;
                    }
                }
                z3 = false;
                if (!z3) {
                }
            }
        }
        return true;
    }

    public static /* synthetic */ boolean messageContainsMention$default(NotificationTextUtils notificationTextUtils, User user, Collection collection, Message message, boolean z2, boolean z3, int i, Object obj) {
        return notificationTextUtils.messageContainsMention(user, collection, message, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? false : z3);
    }

    private final Integer messageNotifications(ModelNotificationSettings modelNotificationSettings, long j) {
        ModelNotificationSettings.ChannelOverride channelOverride = modelNotificationSettings.getChannelOverride(j);
        if (channelOverride == null) {
            return null;
        }
        Integer numValueOf = Integer.valueOf(channelOverride.getMessageNotifications());
        if (numValueOf.intValue() == ModelNotificationSettings.FREQUENCY_UNSET) {
            return null;
        }
        return numValueOf;
    }

    private final boolean shouldNotifyForLevel(Integer msgNotifLevel, User me2, Collection<Long> myRoleIds, Message message, Channel channel, Long channelPermissions, long selectedVoiceChannelId, boolean isSuppressEveryone, boolean isSuppressRoles) {
        if (ChannelUtils.m7675J(channel) && !PermissionUtils.can(Permission.CONNECT, channelPermissions)) {
            return false;
        }
        int i = ModelNotificationSettings.FREQUENCY_ALL;
        if (msgNotifLevel == null || msgNotifLevel.intValue() != i) {
            int i2 = ModelNotificationSettings.FREQUENCY_MENTIONS;
            if (msgNotifLevel != null && msgNotifLevel.intValue() == i2) {
                return messageContainsMention(me2, myRoleIds, message, isSuppressEveryone, isSuppressRoles);
            }
            int i3 = ModelNotificationSettings.FREQUENCY_NOTHING;
            if (msgNotifLevel != null && msgNotifLevel.intValue() == i3) {
                return false;
            }
        } else if (ChannelUtils.m7675J(channel) && selectedVoiceChannelId != channel.getId() && !messageContainsMention(me2, myRoleIds, message, isSuppressEveryone, isSuppressRoles)) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ boolean shouldNotifyForLevel$default(NotificationTextUtils notificationTextUtils, Integer num, User user, Collection collection, Message message, Channel channel, Long l, long j, boolean z2, boolean z3, int i, Object obj) {
        return notificationTextUtils.shouldNotifyForLevel(num, user, collection, message, channel, l, j, (i & 128) != 0 ? false : z2, (i & 256) != 0 ? false : z3);
    }

    public final Integer channelMessageNotificationLevel(ModelNotificationSettings modelNotificationSettings, Channel channel, Guild guild) {
        Integer num = null;
        Integer numValueOf = guild != null ? Integer.valueOf(guild.getDefaultMessageNotifications()) : null;
        if (channel == null || modelNotificationSettings == null) {
            return numValueOf;
        }
        Integer numMessageNotifications = messageNotifications(modelNotificationSettings, channel.getId());
        if (numMessageNotifications == null) {
            numMessageNotifications = messageNotifications(modelNotificationSettings, channel.getParentId());
        }
        if (numMessageNotifications != null) {
            num = numMessageNotifications;
        } else {
            Integer numValueOf2 = Integer.valueOf(modelNotificationSettings.getMessageNotifications());
            if (numValueOf2.intValue() != ModelNotificationSettings.FREQUENCY_UNSET) {
                num = numValueOf2;
            }
        }
        return num != null ? num : numValueOf;
    }

    public final boolean isGuildOrCategoryOrChannelMuted(ModelNotificationSettings modelNotificationSettings, Channel channel) {
        if (modelNotificationSettings == null) {
            return false;
        }
        if (modelNotificationSettings.isMuted()) {
            return true;
        }
        if (channel == null) {
            return false;
        }
        ModelNotificationSettings.ChannelOverride channelOverride = modelNotificationSettings.getChannelOverride(channel.getParentId());
        if (channelOverride != null && channelOverride.isMuted()) {
            return true;
        }
        ModelNotificationSettings.ChannelOverride channelOverride2 = modelNotificationSettings.getChannelOverride(channel.getId());
        return channelOverride2 != null && channelOverride2.isMuted();
    }

    public final boolean shouldNotifyInAppPopup(User me2, Message msg, Channel channel, Map<Long, Integer> blockedRelationships, Channel parentChannel, Guild guild, Map<Long, ? extends Map<Long, GuildMember>> guildMembers, Map<Long, ? extends ModelNotificationSettings> guildSettings, Map<Long, StoreThreadsJoined.JoinedThread> joinedThreads, long selectedVoiceChannelId, Long channelPermissions) {
        com.discord.api.user.User author;
        List<Long> listEmptyList;
        Intrinsics3.checkNotNullParameter(me2, "me");
        Intrinsics3.checkNotNullParameter(msg, NotificationCompat.CATEGORY_MESSAGE);
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Intrinsics3.checkNotNullParameter(blockedRelationships, "blockedRelationships");
        Intrinsics3.checkNotNullParameter(guildMembers, "guildMembers");
        Intrinsics3.checkNotNullParameter(guildSettings, "guildSettings");
        Intrinsics3.checkNotNullParameter(joinedThreads, "joinedThreads");
        if (ChannelUtils.m7701y(channel) || (author = msg.getAuthor()) == null || author.getId() == 0 || author.getId() == me2.getId() || blockedRelationships.containsKey(Long.valueOf(author.getId()))) {
            return false;
        }
        Integer type = msg.getType();
        if (type != null && type.intValue() == 3) {
            return false;
        }
        Map map = (Map) outline.m843c(channel, guildMembers);
        GuildMember guildMember = map != null ? (GuildMember) outline.m849f(me2, map) : null;
        if (guildMember == null || (listEmptyList = guildMember.getRoles()) == null) {
            listEmptyList = Collections2.emptyList();
        }
        List<Long> list = listEmptyList;
        ModelNotificationSettings modelNotificationSettings = (ModelNotificationSettings) outline.m843c(channel, guildSettings);
        if (ChannelUtils.m7673H(channel)) {
            return isThreadNotificationAllowed(me2, list, msg, (StoreThreadsJoined.JoinedThread) outline.m845d(channel, joinedThreads), modelNotificationSettings, guild, channel, parentChannel);
        }
        if (modelNotificationSettings != null) {
            return isNotificationAllowed(modelNotificationSettings, me2, list, msg, guild, channel, channelPermissions, selectedVoiceChannelId);
        }
        return shouldNotifyForLevel$default(this, guild != null ? Integer.valueOf(guild.getDefaultMessageNotifications()) : null, me2, list, msg, channel, channelPermissions, selectedVoiceChannelId, false, false, 384, null);
    }
}
