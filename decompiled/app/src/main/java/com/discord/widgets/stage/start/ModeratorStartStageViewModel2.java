package com.discord.widgets.stage.start;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.permission.Permission;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.UserGuildMember;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.stage.start.ModeratorStartStageViewModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.Iterables2;
import p507d0.p580t._Collections;
import p637j0.p641k.Func1;
import p658rx.Observable;
import p658rx.functions.Func3;

/* compiled from: ModeratorStartStageViewModel.kt */
/* renamed from: com.discord.widgets.stage.start.ModeratorStartStageViewModel$Companion$observeStores$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class ModeratorStartStageViewModel2<T, R> implements Func1<Channel, Observable<? extends ModeratorStartStageViewModel.StoreState>> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ StoreGuildScheduledEvents $guildScheduledEventsStore;
    public final /* synthetic */ StorePermissions $permissionsStore;
    public final /* synthetic */ StoreVoiceParticipants $voiceParticipantsStore;

    /* compiled from: ModeratorStartStageViewModel.kt */
    /* renamed from: com.discord.widgets.stage.start.ModeratorStartStageViewModel$Companion$observeStores$1$1 */
    public static final class C100691<T1, T2, T3, R> implements Func3<Map<Long, ? extends StoreVoiceParticipants.VoiceUser>, List<? extends GuildScheduledEvent>, Long, ModeratorStartStageViewModel.StoreState> {
        public C100691() {
        }

        @Override // p658rx.functions.Func3
        public /* bridge */ /* synthetic */ ModeratorStartStageViewModel.StoreState call(Map<Long, ? extends StoreVoiceParticipants.VoiceUser> map, List<? extends GuildScheduledEvent> list, Long l) {
            return call2((Map<Long, StoreVoiceParticipants.VoiceUser>) map, (List<GuildScheduledEvent>) list, l);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final ModeratorStartStageViewModel.StoreState call2(Map<Long, StoreVoiceParticipants.VoiceUser> map, List<GuildScheduledEvent> list, Long l) {
            ArrayList arrayListM840a0 = outline.m840a0(list, "guildScheduledEvents");
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                T next = it.next();
                Long channelId = ((GuildScheduledEvent) next).getChannelId();
                if (channelId != null && channelId.longValue() == ModeratorStartStageViewModel2.this.$channelId) {
                    arrayListM840a0.add(next);
                }
            }
            List listSortedWith = _Collections.sortedWith(arrayListM840a0, new C10070x6c2c8d84());
            Collection<StoreVoiceParticipants.VoiceUser> collectionValues = map.values();
            ArrayList<StoreVoiceParticipants.VoiceUser> arrayList = new ArrayList();
            for (T t : collectionValues) {
                if (!((StoreVoiceParticipants.VoiceUser) t).isMe()) {
                    arrayList.add(t);
                }
            }
            ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
            for (StoreVoiceParticipants.VoiceUser voiceUser : arrayList) {
                arrayList2.add(new UserGuildMember(voiceUser.getUser(), voiceUser.getGuildMember()));
            }
            return new ModeratorStartStageViewModel.StoreState(listSortedWith, arrayList2, PermissionUtils.can(Permission.START_STAGE_EVENT, l));
        }
    }

    public ModeratorStartStageViewModel2(StoreVoiceParticipants storeVoiceParticipants, StoreGuildScheduledEvents storeGuildScheduledEvents, StorePermissions storePermissions, long j) {
        this.$voiceParticipantsStore = storeVoiceParticipants;
        this.$guildScheduledEventsStore = storeGuildScheduledEvents;
        this.$permissionsStore = storePermissions;
        this.$channelId = j;
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends ModeratorStartStageViewModel.StoreState> call(Channel channel) {
        return call2(channel);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends ModeratorStartStageViewModel.StoreState> call2(Channel channel) {
        return Observable.m11075i(ObservableExtensionsKt.leadingEdgeThrottle(this.$voiceParticipantsStore.get(channel.getId()), 250L, TimeUnit.MILLISECONDS), StoreGuildScheduledEvents.observeGuildScheduledEvents$default(this.$guildScheduledEventsStore, channel.getGuildId(), false, 2, null), this.$permissionsStore.observePermissionsForChannel(channel.getId()), new C100691());
    }
}
