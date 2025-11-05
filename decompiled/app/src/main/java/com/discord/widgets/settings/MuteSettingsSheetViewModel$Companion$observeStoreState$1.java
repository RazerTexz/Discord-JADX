package com.discord.widgets.settings;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreThreadsJoined;
import com.discord.widgets.settings.MuteSettingsSheetViewModel;
import java.util.Map;
import rx.functions.Func4;

/* compiled from: MuteSettingsSheetViewModel.kt */
/* loaded from: classes2.dex */
public final class MuteSettingsSheetViewModel$Companion$observeStoreState$1<T1, T2, T3, T4, R> implements Func4<Guild, Channel, Map<Long, ? extends ModelNotificationSettings>, StoreThreadsJoined.JoinedThread, MuteSettingsSheetViewModel.StoreState> {
    public static final MuteSettingsSheetViewModel$Companion$observeStoreState$1 INSTANCE = new MuteSettingsSheetViewModel$Companion$observeStoreState$1();

    @Override // rx.functions.Func4
    public /* bridge */ /* synthetic */ MuteSettingsSheetViewModel.StoreState call(Guild guild, Channel channel, Map<Long, ? extends ModelNotificationSettings> map, StoreThreadsJoined.JoinedThread joinedThread) {
        return call2(guild, channel, map, joinedThread);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x001c  */
    /* renamed from: call, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final MuteSettingsSheetViewModel.StoreState call2(Guild guild, Channel channel, Map<Long, ? extends ModelNotificationSettings> map, StoreThreadsJoined.JoinedThread joinedThread) {
        Long lValueOf;
        long guildId;
        if (guild != null) {
            guildId = guild.getId();
        } else {
            if (channel == null) {
                lValueOf = null;
                return new MuteSettingsSheetViewModel.StoreState(guild, channel, map.get(Long.valueOf(lValueOf == null ? lValueOf.longValue() : 0L)), joinedThread);
            }
            guildId = channel.getGuildId();
        }
        lValueOf = Long.valueOf(guildId);
        return new MuteSettingsSheetViewModel.StoreState(guild, channel, map.get(Long.valueOf(lValueOf == null ? lValueOf.longValue() : 0L)), joinedThread);
    }
}
