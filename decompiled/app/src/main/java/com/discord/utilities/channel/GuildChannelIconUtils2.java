package com.discord.utilities.channel;

import androidx.annotation.DrawableRes;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.utilities.PermissionOverwriteUtils;
import com.discord.utilities.channel.GuildChannelIconUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: GuildChannelIconUtils.kt */
/* renamed from: com.discord.utilities.channel.GuildChannelIconUtilsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class GuildChannelIconUtils2 {
    public static final GuildChannelIconUtils getChannelType(Channel channel) {
        if (channel == null) {
            return GuildChannelIconUtils.Text.INSTANCE;
        }
        Object obj = null;
        if (ChannelUtils.m7695s(channel, null, 1)) {
            if (channel.getNsfw()) {
                return GuildChannelIconUtils.NSFW.ForumPost.INSTANCE;
            }
            List<PermissionOverwrite> listM7655v = channel.m7655v();
            if (listM7655v != null) {
                Iterator<T> it = listM7655v.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (((PermissionOverwrite) next).m8131e() == channel.getGuildId()) {
                        obj = next;
                        break;
                    }
                }
                PermissionOverwrite permissionOverwrite = (PermissionOverwrite) obj;
                if (permissionOverwrite != null && PermissionOverwriteUtils.denies(permissionOverwrite, Permission.VIEW_CHANNEL)) {
                    return GuildChannelIconUtils.Locked.ForumPost.INSTANCE;
                }
            }
            return GuildChannelIconUtils.ForumPost.INSTANCE;
        }
        int type = channel.getType();
        if (type == 2) {
            return channel.getNsfw() ? GuildChannelIconUtils.NSFW.Voice.INSTANCE : GuildChannelIconUtils.Voice.INSTANCE;
        }
        if (type == 5) {
            if (channel.getNsfw()) {
                return GuildChannelIconUtils.NSFW.Announcements.INSTANCE;
            }
            List<PermissionOverwrite> listM7655v2 = channel.m7655v();
            if (listM7655v2 != null) {
                Iterator<T> it2 = listM7655v2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Object next2 = it2.next();
                    if (((PermissionOverwrite) next2).m8131e() == channel.getGuildId()) {
                        obj = next2;
                        break;
                    }
                }
                PermissionOverwrite permissionOverwrite2 = (PermissionOverwrite) obj;
                if (permissionOverwrite2 != null && PermissionOverwriteUtils.denies(permissionOverwrite2, Permission.VIEW_CHANNEL)) {
                    return GuildChannelIconUtils.Locked.Announcements.INSTANCE;
                }
            }
            return GuildChannelIconUtils.Announcements.INSTANCE;
        }
        if (type == 14) {
            return GuildChannelIconUtils.Directory.INSTANCE;
        }
        if (type == 15) {
            if (channel.getNsfw()) {
                return GuildChannelIconUtils.NSFW.Forum.INSTANCE;
            }
            List<PermissionOverwrite> listM7655v3 = channel.m7655v();
            if (listM7655v3 != null) {
                Iterator<T> it3 = listM7655v3.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    }
                    Object next3 = it3.next();
                    if (((PermissionOverwrite) next3).m8131e() == channel.getGuildId()) {
                        obj = next3;
                        break;
                    }
                }
                PermissionOverwrite permissionOverwrite3 = (PermissionOverwrite) obj;
                if (permissionOverwrite3 != null && PermissionOverwriteUtils.denies(permissionOverwrite3, Permission.VIEW_CHANNEL)) {
                    return GuildChannelIconUtils.Locked.Forum.INSTANCE;
                }
            }
            return GuildChannelIconUtils.Forum.INSTANCE;
        }
        switch (type) {
            case 10:
                return channel.getNsfw() ? GuildChannelIconUtils.NSFW.Thread.INSTANCE : GuildChannelIconUtils.Thread.INSTANCE;
            case 11:
                return channel.getNsfw() ? GuildChannelIconUtils.NSFW.Thread.INSTANCE : GuildChannelIconUtils.Thread.INSTANCE;
            case 12:
                return GuildChannelIconUtils.Locked.Thread.INSTANCE;
            default:
                if (channel.getNsfw()) {
                    return GuildChannelIconUtils.NSFW.Text.INSTANCE;
                }
                List<PermissionOverwrite> listM7655v4 = channel.m7655v();
                if (listM7655v4 != null) {
                    Iterator<T> it4 = listM7655v4.iterator();
                    while (true) {
                        if (it4.hasNext()) {
                            Object next4 = it4.next();
                            if (((PermissionOverwrite) next4).m8131e() == channel.getGuildId()) {
                                obj = next4;
                            }
                        }
                    }
                    PermissionOverwrite permissionOverwrite4 = (PermissionOverwrite) obj;
                    if (permissionOverwrite4 != null && PermissionOverwriteUtils.denies(permissionOverwrite4, Permission.VIEW_CHANNEL)) {
                        return GuildChannelIconUtils.Locked.Text.INSTANCE;
                    }
                }
                return GuildChannelIconUtils.Text.INSTANCE;
        }
    }

    public static final int guildChannelIcon(Channel channel) {
        return mapGuildChannelTypeToIcon(getChannelType(channel));
    }

    @DrawableRes
    public static final int mapGuildChannelTypeToIcon(GuildChannelIconUtils guildChannelIconUtils) {
        Intrinsics3.checkNotNullParameter(guildChannelIconUtils, "guildChannelIconType");
        if (Intrinsics3.areEqual(guildChannelIconUtils, GuildChannelIconUtils.Text.INSTANCE)) {
            return C5419R.drawable.ic_channel_text;
        }
        if (guildChannelIconUtils instanceof GuildChannelIconUtils.Thread) {
            return C5419R.drawable.ic_thread;
        }
        if (guildChannelIconUtils instanceof GuildChannelIconUtils.Announcements) {
            return C5419R.drawable.ic_channel_announcements;
        }
        if (guildChannelIconUtils instanceof GuildChannelIconUtils.Forum) {
            return C5419R.drawable.ic_channel_forum;
        }
        if (!(guildChannelIconUtils instanceof GuildChannelIconUtils.ForumPost)) {
            if (guildChannelIconUtils instanceof GuildChannelIconUtils.NSFW.Text) {
                return C5419R.drawable.ic_channel_text_nsfw;
            }
            if (guildChannelIconUtils instanceof GuildChannelIconUtils.NSFW.Announcements) {
                return C5419R.drawable.ic_channel_announcements_nsfw;
            }
            if (guildChannelIconUtils instanceof GuildChannelIconUtils.NSFW.Thread) {
                return C5419R.drawable.ic_thread_locked;
            }
            if (guildChannelIconUtils instanceof GuildChannelIconUtils.NSFW.Voice) {
                return C5419R.drawable.ic_voice_nsfw;
            }
            if (guildChannelIconUtils instanceof GuildChannelIconUtils.NSFW.Forum) {
                return C5419R.drawable.ic_channel_forum_nsfw;
            }
            if (!(guildChannelIconUtils instanceof GuildChannelIconUtils.NSFW.ForumPost)) {
                if (guildChannelIconUtils instanceof GuildChannelIconUtils.Locked.Text) {
                    return C5419R.drawable.ic_channel_text_locked;
                }
                if (guildChannelIconUtils instanceof GuildChannelIconUtils.Locked.Announcements) {
                    return C5419R.drawable.ic_channel_announcements_locked;
                }
                if (guildChannelIconUtils instanceof GuildChannelIconUtils.Locked.Thread) {
                    return C5419R.drawable.ic_thread_locked;
                }
                if (guildChannelIconUtils instanceof GuildChannelIconUtils.Locked.Forum) {
                    return C5419R.drawable.ic_channel_forum_locked;
                }
                if (!(guildChannelIconUtils instanceof GuildChannelIconUtils.Locked.ForumPost)) {
                    if (guildChannelIconUtils instanceof GuildChannelIconUtils.Directory) {
                        return C5419R.drawable.ic_hub_24dp;
                    }
                    if (guildChannelIconUtils instanceof GuildChannelIconUtils.Voice) {
                        return C5419R.drawable.ic_channel_voice_grey_header_24dp;
                    }
                    throw new NoWhenBranchMatchedException();
                }
            }
        }
        return C5419R.drawable.ic_channel_forum_post;
    }
}
