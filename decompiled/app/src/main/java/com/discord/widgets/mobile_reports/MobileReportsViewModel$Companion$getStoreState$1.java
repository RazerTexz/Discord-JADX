package com.discord.widgets.mobile_reports;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.stageinstance.StageInstance;
import com.discord.models.guild.Guild;
import com.discord.models.message.Message;
import com.discord.stores.utilities.RestCallState;
import com.discord.widgets.mobile_reports.MobileReportArgs;
import com.discord.widgets.mobile_reports.MobileReportsViewModel;
import d0.z.d.m;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import rx.functions.Func8;

/* compiled from: MobileReportsViewModel.kt */
/* loaded from: classes2.dex */
public final class MobileReportsViewModel$Companion$getStoreState$1<T1, T2, T3, T4, T5, T6, T7, T8, R> implements Func8<Message, Channel, Guild, StageInstance, Map<Long, ? extends Integer>, RestCallState<? extends List<? extends DirectoryEntryGuild>>, GuildScheduledEvent, Guild, MobileReportsViewModel.StoreState> {
    public final /* synthetic */ MobileReportArgs $args;

    public MobileReportsViewModel$Companion$getStoreState$1(MobileReportArgs mobileReportArgs) {
        this.$args = mobileReportArgs;
    }

    @Override // rx.functions.Func8
    public /* bridge */ /* synthetic */ MobileReportsViewModel.StoreState call(Message message, Channel channel, Guild guild, StageInstance stageInstance, Map<Long, ? extends Integer> map, RestCallState<? extends List<? extends DirectoryEntryGuild>> restCallState, GuildScheduledEvent guildScheduledEvent, Guild guild2) {
        return call2(message, channel, guild, stageInstance, (Map<Long, Integer>) map, (RestCallState<? extends List<DirectoryEntryGuild>>) restCallState, guildScheduledEvent, guild2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final MobileReportsViewModel.StoreState call2(Message message, Channel channel, Guild guild, StageInstance stageInstance, Map<Long, Integer> map, RestCallState<? extends List<DirectoryEntryGuild>> restCallState, GuildScheduledEvent guildScheduledEvent, Guild guild2) {
        List<DirectoryEntryGuild> listInvoke;
        MobileReportArgs mobileReportArgs = this.$args;
        DirectoryEntryGuild directoryEntryGuild = null;
        if (!(mobileReportArgs instanceof MobileReportArgs.DirectoryServer)) {
            mobileReportArgs = null;
        }
        MobileReportArgs.DirectoryServer directoryServer = (MobileReportArgs.DirectoryServer) mobileReportArgs;
        Long lValueOf = directoryServer != null ? Long.valueOf(directoryServer.getGuildId()) : null;
        Guild guild3 = guild != null ? guild : guild2;
        m.checkNotNullExpressionValue(map, "blockedUsers");
        if (restCallState != null && (listInvoke = restCallState.invoke()) != null) {
            Iterator<T> it = listInvoke.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (lValueOf != null && ((DirectoryEntryGuild) next).getGuild().getId() == lValueOf.longValue()) {
                    directoryEntryGuild = next;
                    break;
                }
            }
            directoryEntryGuild = directoryEntryGuild;
        }
        return new MobileReportsViewModel.StoreState(message, channel, guild3, directoryEntryGuild, stageInstance, map, guildScheduledEvent);
    }
}
