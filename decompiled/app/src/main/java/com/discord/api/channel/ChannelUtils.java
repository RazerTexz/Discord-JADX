package com.discord.api.channel;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.guild.GuildFeature;
import com.discord.api.permission.Permission;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.api.role.GuildRole;
import com.discord.api.thread.ThreadMetadata;
import com.discord.api.user.User;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.presence.Presence;
import com.discord.models.user.CoreUser;
import com.discord.stores.StoreStream;
import com.discord.utilities.PermissionOverwriteUtils;
import com.discord.utilities.guilds.GuildUtils;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.user.UserUtils;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p507d0.p580t.Collections2;
import p507d0.p580t.Iterables2;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ChannelUtils.kt */
/* loaded from: classes.dex */
public final class ChannelUtils {
    private static final long HQ_DIRECTORY_CHANNEL_ID = 883060064561299456L;

    /* renamed from: A */
    public static final boolean m7666A(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "$this$isPinned");
        Intrinsics3.checkNotNullParameter(channel, "$this$hasFlag");
        Long flags = channel.getFlags();
        return ((flags != null ? flags.longValue() : 0L) & 2) == 2;
    }

    /* renamed from: B */
    public static final boolean m7667B(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "$this$isPrivate");
        return channel.getType() == 1 || channel.getType() == 3;
    }

    /* renamed from: C */
    public static final boolean m7668C(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "$this$isPrivateThread");
        return channel.getType() == 12;
    }

    /* renamed from: D */
    public static final boolean m7669D(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "$this$isStageVoiceChannel");
        return channel.getType() == 13;
    }

    /* renamed from: E */
    public static final boolean m7670E(Channel channel) {
        User user;
        Intrinsics3.checkNotNullParameter(channel, "$this$isSystemDM");
        if (channel.getType() == 1) {
            List<User> listM7659z = channel.m7659z();
            if (Intrinsics3.areEqual((listM7659z == null || (user = (User) _Collections.firstOrNull((List) listM7659z)) == null) ? null : user.getSystem(), Boolean.TRUE)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: F */
    public static final boolean m7671F(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "$this$isTextChannel");
        return m7667B(channel) || m7698v(channel);
    }

    /* renamed from: G */
    public static final boolean m7672G(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "$this$isTextOrVoiceChannel");
        return m7671F(channel) || m7675J(channel);
    }

    /* renamed from: H */
    public static final boolean m7673H(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "$this$isThread");
        return channel.getType() == 10 || channel.getType() == 11 || channel.getType() == 12;
    }

    /* renamed from: I */
    public static final boolean m7674I(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "$this$isThreaded");
        return channel.getType() == 0 || channel.getType() == 5 || channel.getType() == 15;
    }

    /* renamed from: J */
    public static final boolean m7675J(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "$this$isVoiceChannel");
        return channel.getType() == 2;
    }

    /* renamed from: K */
    public static final boolean m7676K(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "$this$shouldPlayJoinLeaveSounds");
        return m7675J(channel) || m7667B(channel);
    }

    /* renamed from: a */
    public static final com.discord.models.user.User m7677a(Channel channel) {
        List<User> listM7659z;
        List<User> listM7659z2;
        User user;
        Intrinsics3.checkNotNullParameter(channel, "$this$getDMRecipient");
        if (!m7689m(channel) || (listM7659z = channel.m7659z()) == null || listM7659z.size() != 1 || (listM7659z2 = channel.m7659z()) == null || (user = (User) _Collections.first((List) listM7659z2)) == null) {
            return null;
        }
        return new CoreUser(user);
    }

    /* renamed from: b */
    public static final Integer m7678b(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "$this$getDeletedMessage");
        if (m7687k(channel)) {
            return Integer.valueOf(C5419R.string.category_has_been_deleted);
        }
        if (m7673H(channel)) {
            return Integer.valueOf(C5419R.string.thread_has_been_deleted);
        }
        if (m7667B(channel)) {
            return null;
        }
        return Integer.valueOf(C5419R.string.channel_has_been_deleted);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0038  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final String m7679c(Channel channel) {
        String name;
        Intrinsics3.checkNotNullParameter(channel, "$this$getDisplayName");
        if (m7667B(channel)) {
            String name2 = channel.getName();
            if (name2 == null || name2.length() == 0) {
                List<User> listM7659z = channel.m7659z();
                name = listM7659z != null ? _Collections.joinToString$default(listM7659z, null, null, null, 0, null, ChannelUtils2.INSTANCE, 31, null) : null;
                if (name == null) {
                    return "";
                }
            }
        } else {
            name = channel.getName();
            if (name == null) {
                return "";
            }
        }
        return name;
    }

    /* renamed from: d */
    public static final String m7680d(Channel channel, Context context, boolean z2) {
        Intrinsics3.checkNotNullParameter(channel, "$this$getDisplayNameOrDefault");
        Intrinsics3.checkNotNullParameter(context, "context");
        String strM7679c = m7679c(channel);
        if (m7697u(channel) || m7685i(channel)) {
            if (strM7679c.length() == 0) {
                String string = context.getString(C5419R.string.invalid_text_channel);
                Intrinsics3.checkNotNullExpressionValue(string, "context.getString(R.string.invalid_text_channel)");
                return string;
            }
            if (z2) {
                StringBuilder sb = new StringBuilder();
                Intrinsics3.checkNotNullParameter(Channel.INSTANCE, "$this$DISPLAY_PREFIX_GUILD");
                sb.append("#");
                sb.append(strM7679c);
                return sb.toString();
            }
        } else if (m7699w(channel)) {
            if (strM7679c.length() == 0) {
                String string2 = context.getString(C5419R.string.invalid_voice_channel);
                Intrinsics3.checkNotNullExpressionValue(string2, "context.getString(R.string.invalid_voice_channel)");
                return string2;
            }
        } else if (m7692p(channel)) {
            if (strM7679c.length() == 0) {
                String string3 = context.getString(C5419R.string.unnamed);
                Intrinsics3.checkNotNullExpressionValue(string3, "context.getString(R.string.unnamed)");
                return string3;
            }
        } else if (m7689m(channel)) {
            if (strM7679c.length() == 0) {
                String string4 = context.getString(C5419R.string.direct_message);
                Intrinsics3.checkNotNullExpressionValue(string4, "context.getString(R.string.direct_message)");
                return string4;
            }
            if (z2) {
                StringBuilder sb2 = new StringBuilder();
                Intrinsics3.checkNotNullParameter(Channel.INSTANCE, "$this$DISPLAY_PREFIX_DM");
                sb2.append("@");
                sb2.append(strM7679c);
                return sb2.toString();
            }
        }
        return strM7679c;
    }

    /* renamed from: e */
    public static /* synthetic */ String m7681e(Channel channel, Context context, boolean z2, int i) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        return m7680d(channel, context, z2);
    }

    /* renamed from: f */
    public static final PermissionOverwrite m7682f(Channel channel, long j) {
        Intrinsics3.checkNotNullParameter(channel, "$this$getPermissionOverwriteForId");
        List<PermissionOverwrite> listM7655v = channel.m7655v();
        Object obj = null;
        if (listM7655v == null) {
            return null;
        }
        Iterator<T> it = listM7655v.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((PermissionOverwrite) next).m8131e() == j) {
                obj = next;
                break;
            }
        }
        return (PermissionOverwrite) obj;
    }

    /* renamed from: g */
    public static final List<com.discord.models.user.User> m7683g(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "$this$getRecipients");
        List<User> listM7659z = channel.m7659z();
        if (listM7659z == null) {
            return Collections2.emptyList();
        }
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listM7659z, 10));
        Iterator<T> it = listM7659z.iterator();
        while (it.hasNext()) {
            arrayList.add(new CoreUser((User) it.next()));
        }
        return arrayList;
    }

    /* renamed from: h */
    public static final Comparator<Channel> m7684h(Channel.Companion companion) {
        Intrinsics3.checkNotNullParameter(companion, "$this$getSortByNameAndType");
        return new ChannelUtils4(companion);
    }

    /* renamed from: i */
    public static final boolean m7685i(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "$this$isAnnouncementChannel");
        return channel.getType() == 5;
    }

    /* renamed from: j */
    public static final boolean m7686j(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "$this$isArchivedThread");
        ThreadMetadata threadMetadata = channel.getThreadMetadata();
        return threadMetadata != null && threadMetadata.getArchived();
    }

    /* renamed from: k */
    public static final boolean m7687k(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "$this$isCategory");
        return channel.getType() == 4;
    }

    /* renamed from: l */
    public static final boolean m7688l(int i) {
        return i == 0 || i == 5 || i == 10 || i == 11 || i == 12 || i == 14 || i == 15;
    }

    /* renamed from: m */
    public static final boolean m7689m(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "$this$isDM");
        return channel.getType() == 1;
    }

    /* renamed from: n */
    public static final boolean m7690n(Channel channel, Presence presence) {
        Intrinsics3.checkNotNullParameter(channel, "$this$isDMStatusVisible");
        com.discord.models.user.User userM7677a = m7677a(channel);
        return m7689m(channel) && !m7670E(channel) && (userM7677a != null ? UserUtils.INSTANCE.isStatusVisible(userM7677a, presence, true) : false);
    }

    /* renamed from: o */
    public static final boolean m7691o(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "$this$isDirectory");
        return channel.getType() == 14;
    }

    /* renamed from: p */
    public static final boolean m7692p(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "$this$isGroup");
        return channel.getType() == 3;
    }

    /* renamed from: q */
    public static final boolean m7693q(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "$this$isGuildForumChannel");
        return channel.getType() == 15;
    }

    /* renamed from: r */
    public static final boolean m7694r(Channel channel, Channel channel2) {
        Intrinsics3.checkNotNullParameter(channel, "$this$isGuildForumPost");
        return channel2 != null && channel2.getType() == 15;
    }

    /* renamed from: s */
    public static /* synthetic */ boolean m7695s(Channel channel, Channel channel2, int i) {
        return m7694r(channel, (i & 1) != 0 ? StoreStream.INSTANCE.getChannels().getChannel(channel.getParentId()) : null);
    }

    /* renamed from: t */
    public static final boolean m7696t(Channel channel, Guild guild, GuildRole guildRole, Map<Long, GuildRole> map) {
        Object next;
        Intrinsics3.checkNotNullParameter(channel, "$this$isGuildRoleSubscriptionChannel");
        if (guild != null && guild.hasFeature(GuildFeature.ROLE_SUBSCRIPTIONS_AVAILABLE_FOR_PURCHASE)) {
            List<PermissionOverwrite> listM7655v = channel.m7655v();
            if (listM7655v == null) {
                listM7655v = Collections2.emptyList();
            }
            for (PermissionOverwrite permissionOverwrite : listM7655v) {
                GuildRole guildRole2 = GuildUtils.getGuildRole(Long.valueOf(permissionOverwrite.m8131e()));
                if (guildRole2 != null && RoleUtils.isSubscriptionRolePurchasableOrHasSubscribers(guildRole2) && PermissionOverwriteUtils.grantsAccessTo(permissionOverwrite, channel)) {
                    return true;
                }
            }
            boolean zIsFullyGatedGuildRoleSubscriptionGuild = GuildUtils.isFullyGatedGuildRoleSubscriptionGuild(guild, guildRole);
            Iterator<T> it = listM7655v.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((PermissionOverwrite) next).m8131e() == guild.getId()) {
                    break;
                }
            }
            PermissionOverwrite permissionOverwrite2 = (PermissionOverwrite) next;
            boolean zDeniesAccessTo = permissionOverwrite2 != null ? PermissionOverwriteUtils.deniesAccessTo(permissionOverwrite2, channel) : false;
            if (map != null && !zDeniesAccessTo && zIsFullyGatedGuildRoleSubscriptionGuild) {
                for (GuildRole guildRole3 : map.values()) {
                    if (RoleUtils.isSubscriptionRolePurchasableOrHasSubscribers(guildRole3) && PermissionUtils.INSTANCE.canRole(Permission.VIEW_CHANNEL, guildRole3, null)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: u */
    public static final boolean m7697u(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "$this$isGuildTextChannel");
        return channel.getType() == 0 || channel.getType() == 15;
    }

    /* renamed from: v */
    public static final boolean m7698v(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "$this$isGuildTextyChannel");
        return m7688l(channel.getType());
    }

    /* renamed from: w */
    public static final boolean m7699w(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "$this$isGuildVocalChannel");
        return channel.getType() == 2 || channel.getType() == 13;
    }

    /* renamed from: x */
    public static final boolean m7700x(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "$this$isHQDirectoryChannel");
        return channel.getId() == HQ_DIRECTORY_CHANNEL_ID;
    }

    /* renamed from: y */
    public static final boolean m7701y(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "$this$isManaged");
        return channel.getApplicationId() != 0;
    }

    /* renamed from: z */
    public static final boolean m7702z(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "$this$isMultiUserDM");
        return channel.getType() == 3;
    }
}
