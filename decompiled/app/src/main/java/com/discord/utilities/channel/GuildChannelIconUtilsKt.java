package com.discord.utilities.channel;

import androidx.annotation.DrawableRes;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.utilities.PermissionOverwriteUtilsKt;
import com.discord.utilities.channel.GuildChannelIconType;
import d0.z.d.m;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: GuildChannelIconUtils.kt */
/* loaded from: classes2.dex */
public final class GuildChannelIconUtilsKt {
    public static final GuildChannelIconType getChannelType(Channel channel) {
        if (channel == null) {
            return GuildChannelIconType.Text.INSTANCE;
        }
        Object obj = null;
        if (ChannelUtils.s(channel, null, 1)) {
            if (channel.getNsfw()) {
                return GuildChannelIconType.NSFW.ForumPost.INSTANCE;
            }
            List<PermissionOverwrite> listV = channel.v();
            if (listV != null) {
                Iterator<T> it = listV.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (((PermissionOverwrite) next).e() == channel.getGuildId()) {
                        obj = next;
                        break;
                    }
                }
                PermissionOverwrite permissionOverwrite = (PermissionOverwrite) obj;
                if (permissionOverwrite != null && PermissionOverwriteUtilsKt.denies(permissionOverwrite, Permission.VIEW_CHANNEL)) {
                    return GuildChannelIconType.Locked.ForumPost.INSTANCE;
                }
            }
            return GuildChannelIconType.ForumPost.INSTANCE;
        }
        int type = channel.getType();
        if (type == 2) {
            return channel.getNsfw() ? GuildChannelIconType.NSFW.Voice.INSTANCE : GuildChannelIconType.Voice.INSTANCE;
        }
        if (type == 5) {
            if (channel.getNsfw()) {
                return GuildChannelIconType.NSFW.Announcements.INSTANCE;
            }
            List<PermissionOverwrite> listV2 = channel.v();
            if (listV2 != null) {
                Iterator<T> it2 = listV2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Object next2 = it2.next();
                    if (((PermissionOverwrite) next2).e() == channel.getGuildId()) {
                        obj = next2;
                        break;
                    }
                }
                PermissionOverwrite permissionOverwrite2 = (PermissionOverwrite) obj;
                if (permissionOverwrite2 != null && PermissionOverwriteUtilsKt.denies(permissionOverwrite2, Permission.VIEW_CHANNEL)) {
                    return GuildChannelIconType.Locked.Announcements.INSTANCE;
                }
            }
            return GuildChannelIconType.Announcements.INSTANCE;
        }
        if (type == 14) {
            return GuildChannelIconType.Directory.INSTANCE;
        }
        if (type == 15) {
            if (channel.getNsfw()) {
                return GuildChannelIconType.NSFW.Forum.INSTANCE;
            }
            List<PermissionOverwrite> listV3 = channel.v();
            if (listV3 != null) {
                Iterator<T> it3 = listV3.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    }
                    Object next3 = it3.next();
                    if (((PermissionOverwrite) next3).e() == channel.getGuildId()) {
                        obj = next3;
                        break;
                    }
                }
                PermissionOverwrite permissionOverwrite3 = (PermissionOverwrite) obj;
                if (permissionOverwrite3 != null && PermissionOverwriteUtilsKt.denies(permissionOverwrite3, Permission.VIEW_CHANNEL)) {
                    return GuildChannelIconType.Locked.Forum.INSTANCE;
                }
            }
            return GuildChannelIconType.Forum.INSTANCE;
        }
        switch (type) {
            case 10:
                return channel.getNsfw() ? GuildChannelIconType.NSFW.Thread.INSTANCE : GuildChannelIconType.Thread.INSTANCE;
            case 11:
                return channel.getNsfw() ? GuildChannelIconType.NSFW.Thread.INSTANCE : GuildChannelIconType.Thread.INSTANCE;
            case 12:
                return GuildChannelIconType.Locked.Thread.INSTANCE;
            default:
                if (channel.getNsfw()) {
                    return GuildChannelIconType.NSFW.Text.INSTANCE;
                }
                List<PermissionOverwrite> listV4 = channel.v();
                if (listV4 != null) {
                    Iterator<T> it4 = listV4.iterator();
                    while (true) {
                        if (it4.hasNext()) {
                            Object next4 = it4.next();
                            if (((PermissionOverwrite) next4).e() == channel.getGuildId()) {
                                obj = next4;
                            }
                        }
                    }
                    PermissionOverwrite permissionOverwrite4 = (PermissionOverwrite) obj;
                    if (permissionOverwrite4 != null && PermissionOverwriteUtilsKt.denies(permissionOverwrite4, Permission.VIEW_CHANNEL)) {
                        return GuildChannelIconType.Locked.Text.INSTANCE;
                    }
                }
                return GuildChannelIconType.Text.INSTANCE;
        }
    }

    public static final int guildChannelIcon(Channel channel) {
        return mapGuildChannelTypeToIcon(getChannelType(channel));
    }

    @DrawableRes
    public static final int mapGuildChannelTypeToIcon(GuildChannelIconType guildChannelIconType) {
        m.checkNotNullParameter(guildChannelIconType, "guildChannelIconType");
        if (m.areEqual(guildChannelIconType, GuildChannelIconType.Text.INSTANCE)) {
            return R.drawable.ic_channel_text;
        }
        if (guildChannelIconType instanceof GuildChannelIconType.Thread) {
            return R.drawable.ic_thread;
        }
        if (guildChannelIconType instanceof GuildChannelIconType.Announcements) {
            return R.drawable.ic_channel_announcements;
        }
        if (guildChannelIconType instanceof GuildChannelIconType.Forum) {
            return R.drawable.ic_channel_forum;
        }
        if (!(guildChannelIconType instanceof GuildChannelIconType.ForumPost)) {
            if (guildChannelIconType instanceof GuildChannelIconType.NSFW.Text) {
                return R.drawable.ic_channel_text_nsfw;
            }
            if (guildChannelIconType instanceof GuildChannelIconType.NSFW.Announcements) {
                return R.drawable.ic_channel_announcements_nsfw;
            }
            if (guildChannelIconType instanceof GuildChannelIconType.NSFW.Thread) {
                return R.drawable.ic_thread_locked;
            }
            if (guildChannelIconType instanceof GuildChannelIconType.NSFW.Voice) {
                return R.drawable.ic_voice_nsfw;
            }
            if (guildChannelIconType instanceof GuildChannelIconType.NSFW.Forum) {
                return R.drawable.ic_channel_forum_nsfw;
            }
            if (!(guildChannelIconType instanceof GuildChannelIconType.NSFW.ForumPost)) {
                if (guildChannelIconType instanceof GuildChannelIconType.Locked.Text) {
                    return R.drawable.ic_channel_text_locked;
                }
                if (guildChannelIconType instanceof GuildChannelIconType.Locked.Announcements) {
                    return R.drawable.ic_channel_announcements_locked;
                }
                if (guildChannelIconType instanceof GuildChannelIconType.Locked.Thread) {
                    return R.drawable.ic_thread_locked;
                }
                if (guildChannelIconType instanceof GuildChannelIconType.Locked.Forum) {
                    return R.drawable.ic_channel_forum_locked;
                }
                if (!(guildChannelIconType instanceof GuildChannelIconType.Locked.ForumPost)) {
                    if (guildChannelIconType instanceof GuildChannelIconType.Directory) {
                        return R.drawable.ic_hub_24dp;
                    }
                    if (guildChannelIconType instanceof GuildChannelIconType.Voice) {
                        return R.drawable.ic_channel_voice_grey_header_24dp;
                    }
                    throw new NoWhenBranchMatchedException();
                }
            }
        }
        return R.drawable.ic_channel_forum_post;
    }
}
