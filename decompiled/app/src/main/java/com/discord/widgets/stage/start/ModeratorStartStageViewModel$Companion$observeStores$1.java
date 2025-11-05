package com.discord.widgets.stage.start;

import androidx.core.app.NotificationCompat;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.permission.Permission;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.UserGuildMember;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.stage.start.ModeratorStartStageViewModel;
import d0.t.o;
import d0.t.u;
import j0.k.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.functions.Func3;

/* compiled from: ModeratorStartStageViewModel.kt */
/* loaded from: classes2.dex */
public final class ModeratorStartStageViewModel$Companion$observeStores$1<T, R> implements b<Channel, Observable<? extends ModeratorStartStageViewModel.StoreState>> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ StoreGuildScheduledEvents $guildScheduledEventsStore;
    public final /* synthetic */ StorePermissions $permissionsStore;
    public final /* synthetic */ StoreVoiceParticipants $voiceParticipantsStore;

    /* compiled from: ModeratorStartStageViewModel.kt */
    /* renamed from: com.discord.widgets.stage.start.ModeratorStartStageViewModel$Companion$observeStores$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, T3, R> implements Func3<Map<Long, ? extends StoreVoiceParticipants.VoiceUser>, List<? extends GuildScheduledEvent>, Long, ModeratorStartStageViewModel.StoreState> {
        public AnonymousClass1() {
        }

        @Override // rx.functions.Func3
        public /* bridge */ /* synthetic */ ModeratorStartStageViewModel.StoreState call(Map<Long, ? extends StoreVoiceParticipants.VoiceUser> map, List<? extends GuildScheduledEvent> list, Long l) {
            return call2((Map<Long, StoreVoiceParticipants.VoiceUser>) map, (List<GuildScheduledEvent>) list, l);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final ModeratorStartStageViewModel.StoreState call2(Map<Long, StoreVoiceParticipants.VoiceUser> map, List<GuildScheduledEvent> list, Long l) {
            ArrayList arrayListA0 = a.a0(list, "guildScheduledEvents");
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                T next = it.next();
                Long channelId = ((GuildScheduledEvent) next).getChannelId();
                if (channelId != null && channelId.longValue() == ModeratorStartStageViewModel$Companion$observeStores$1.this.$channelId) {
                    arrayListA0.add(next);
                }
            }
            List listSortedWith = u.sortedWith(arrayListA0, new ModeratorStartStageViewModel$Companion$observeStores$1$1$$special$$inlined$sortedBy$1());
            Collection<StoreVoiceParticipants.VoiceUser> collectionValues = map.values();
            ArrayList<StoreVoiceParticipants.VoiceUser> arrayList = new ArrayList();
            for (T t : collectionValues) {
                if (!((StoreVoiceParticipants.VoiceUser) t).isMe()) {
                    arrayList.add(t);
                }
            }
            ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(arrayList, 10));
            for (StoreVoiceParticipants.VoiceUser voiceUser : arrayList) {
                arrayList2.add(new UserGuildMember(voiceUser.getUser(), voiceUser.getGuildMember()));
            }
            return new ModeratorStartStageViewModel.StoreState(listSortedWith, arrayList2, PermissionUtils.can(Permission.START_STAGE_EVENT, l));
        }
    }

    public ModeratorStartStageViewModel$Companion$observeStores$1(StoreVoiceParticipants storeVoiceParticipants, StoreGuildScheduledEvents storeGuildScheduledEvents, StorePermissions storePermissions, long j) {
        this.$voiceParticipantsStore = storeVoiceParticipants;
        this.$guildScheduledEventsStore = storeGuildScheduledEvents;
        this.$permissionsStore = storePermissions;
        this.$channelId = j;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends ModeratorStartStageViewModel.StoreState> call(Channel channel) {
        return call2(channel);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends ModeratorStartStageViewModel.StoreState> call2(Channel channel) {
        return Observable.i(ObservableExtensionsKt.leadingEdgeThrottle(this.$voiceParticipantsStore.get(channel.getId()), 250L, TimeUnit.MILLISECONDS), StoreGuildScheduledEvents.observeGuildScheduledEvents$default(this.$guildScheduledEventsStore, channel.getGuildId(), false, 2, null), this.$permissionsStore.observePermissionsForChannel(channel.getId()), new AnonymousClass1());
    }
}
