package com.discord.widgets.stage.sheet;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStageChannels;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.time.Clock;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheetAdapter;
import com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheetViewModel;
import d0.f0.q;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import j0.k.b;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.functions.Func4;

/* compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
/* loaded from: classes2.dex */
public final class WidgetStageRaisedHandsBottomSheetViewModel$Companion$observeStoreState$1<T, R> implements b<Channel, Observable<? extends WidgetStageRaisedHandsBottomSheetViewModel.StoreState>> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ Clock $clock;
    public final /* synthetic */ StoreGuilds $guildsStore;
    public final /* synthetic */ StoreStageChannels $stageChannels;
    public final /* synthetic */ StoreVoiceParticipants $voiceParticipants;

    /* compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
    /* renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheetViewModel$Companion$observeStoreState$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, T3, T4, R> implements Func4<Map<Long, ? extends GuildRole>, Map<Long, ? extends GuildMember>, Map<Long, ? extends StoreVoiceParticipants.VoiceUser>, StageRoles, WidgetStageRaisedHandsBottomSheetViewModel.StoreState> {
        public final /* synthetic */ Channel $channel;

        /* compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
        /* renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheetViewModel$Companion$observeStoreState$1$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C04661 extends o implements Function1<StoreVoiceParticipants.VoiceUser, Boolean> {
            public static final C04661 INSTANCE = new C04661();

            public C04661() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(StoreVoiceParticipants.VoiceUser voiceUser) {
                return Boolean.valueOf(invoke2(voiceUser));
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2(StoreVoiceParticipants.VoiceUser voiceUser) {
                m.checkNotNullParameter(voiceUser, "voiceUser");
                return voiceUser.getIsRequestingToSpeak();
            }
        }

        /* compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
        /* renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheetViewModel$Companion$observeStoreState$1$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends o implements Function1<StoreVoiceParticipants.VoiceUser, WidgetStageRaisedHandsBottomSheetAdapter.ListItem.Participant> {
            public final /* synthetic */ Map $members;
            public final /* synthetic */ Map $roles;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(Map map, Map map2) {
                super(1);
                this.$members = map;
                this.$roles = map2;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ WidgetStageRaisedHandsBottomSheetAdapter.ListItem.Participant invoke(StoreVoiceParticipants.VoiceUser voiceUser) {
                return invoke2(voiceUser);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final WidgetStageRaisedHandsBottomSheetAdapter.ListItem.Participant invoke2(StoreVoiceParticipants.VoiceUser voiceUser) {
                UtcDateTime utcDateTime;
                m.checkNotNullParameter(voiceUser, "voiceUser");
                VoiceState voiceState = voiceUser.getVoiceState();
                if (voiceState == null || (utcDateTime = voiceState.getRequestToSpeakTimestamp()) == null) {
                    utcDateTime = new UtcDateTime(WidgetStageRaisedHandsBottomSheetViewModel$Companion$observeStoreState$1.this.$clock.currentTimeMillis());
                }
                GuildMember guildMember = (GuildMember) this.$members.get(Long.valueOf(voiceUser.getUser().getId()));
                Map map = this.$roles;
                m.checkNotNullExpressionValue(map, "roles");
                return new WidgetStageRaisedHandsBottomSheetAdapter.ListItem.Participant(voiceUser, utcDateTime, guildMember, RoleUtils.getHighestHoistedRole(map, (GuildMember) this.$members.get(Long.valueOf(voiceUser.getUser().getId()))));
            }
        }

        public AnonymousClass1(Channel channel) {
            this.$channel = channel;
        }

        @Override // rx.functions.Func4
        public /* bridge */ /* synthetic */ WidgetStageRaisedHandsBottomSheetViewModel.StoreState call(Map<Long, ? extends GuildRole> map, Map<Long, ? extends GuildMember> map2, Map<Long, ? extends StoreVoiceParticipants.VoiceUser> map3, StageRoles stageRoles) {
            return call2((Map<Long, GuildRole>) map, (Map<Long, GuildMember>) map2, (Map<Long, StoreVoiceParticipants.VoiceUser>) map3, stageRoles);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetStageRaisedHandsBottomSheetViewModel.StoreState call2(Map<Long, GuildRole> map, Map<Long, GuildMember> map2, Map<Long, StoreVoiceParticipants.VoiceUser> map3, StageRoles stageRoles) {
            Channel channel = this.$channel;
            m.checkNotNullExpressionValue(channel, "channel");
            m.checkNotNullExpressionValue(map, "roles");
            return new WidgetStageRaisedHandsBottomSheetViewModel.StoreState(channel, map, q.toList(q.sortedWith(q.map(q.filter(u.asSequence(map3.values()), C04661.INSTANCE), new AnonymousClass2(map2, map)), new WidgetStageRaisedHandsBottomSheetViewModel$Companion$observeStoreState$1$1$$special$$inlined$sortedBy$1())), stageRoles != null ? stageRoles.m35unboximpl() : StageRoles.INSTANCE.m37getAUDIENCE1LxfuJo(), null);
        }
    }

    public WidgetStageRaisedHandsBottomSheetViewModel$Companion$observeStoreState$1(StoreGuilds storeGuilds, StoreVoiceParticipants storeVoiceParticipants, long j, StoreStageChannels storeStageChannels, Clock clock) {
        this.$guildsStore = storeGuilds;
        this.$voiceParticipants = storeVoiceParticipants;
        this.$channelId = j;
        this.$stageChannels = storeStageChannels;
        this.$clock = clock;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetStageRaisedHandsBottomSheetViewModel.StoreState> call(Channel channel) {
        return call2(channel);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetStageRaisedHandsBottomSheetViewModel.StoreState> call2(Channel channel) {
        return Observable.h(this.$guildsStore.observeRoles(channel.getGuildId()), this.$guildsStore.observeComputed(channel.getGuildId()), this.$voiceParticipants.get(this.$channelId), this.$stageChannels.observeMyRoles(this.$channelId), new AnonymousClass1(channel));
    }
}
