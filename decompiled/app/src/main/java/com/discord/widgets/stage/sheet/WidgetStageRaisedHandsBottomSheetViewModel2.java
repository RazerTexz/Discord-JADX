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
import java.util.Map;
import kotlin.jvm.functions.Function1;
import p507d0.p578f0._Sequences2;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p641k.Func1;
import p658rx.Observable;
import p658rx.functions.Func4;

/* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheetViewModel$Companion$observeStoreState$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageRaisedHandsBottomSheetViewModel2<T, R> implements Func1<Channel, Observable<? extends WidgetStageRaisedHandsBottomSheetViewModel.StoreState>> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ Clock $clock;
    public final /* synthetic */ StoreGuilds $guildsStore;
    public final /* synthetic */ StoreStageChannels $stageChannels;
    public final /* synthetic */ StoreVoiceParticipants $voiceParticipants;

    /* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheetViewModel$Companion$observeStoreState$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
    public static final class AnonymousClass1<T1, T2, T3, T4, R> implements Func4<Map<Long, ? extends GuildRole>, Map<Long, ? extends GuildMember>, Map<Long, ? extends StoreVoiceParticipants.VoiceUser>, StageRoles, WidgetStageRaisedHandsBottomSheetViewModel.StoreState> {
        public final /* synthetic */ Channel $channel;

        /* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheetViewModel$Companion$observeStoreState$1$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
        public static final class C132941 extends Lambda implements Function1<StoreVoiceParticipants.VoiceUser, Boolean> {
            public static final C132941 INSTANCE = new C132941();

            public C132941() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(StoreVoiceParticipants.VoiceUser voiceUser) {
                return Boolean.valueOf(invoke2(voiceUser));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2(StoreVoiceParticipants.VoiceUser voiceUser) {
                Intrinsics3.checkNotNullParameter(voiceUser, "voiceUser");
                return voiceUser.getIsRequestingToSpeak();
            }
        }

        /* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheetViewModel$Companion$observeStoreState$1$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
        public static final class AnonymousClass2 extends Lambda implements Function1<StoreVoiceParticipants.VoiceUser, WidgetStageRaisedHandsBottomSheetAdapter.ListItem.Participant> {
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

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final WidgetStageRaisedHandsBottomSheetAdapter.ListItem.Participant invoke2(StoreVoiceParticipants.VoiceUser voiceUser) {
                UtcDateTime utcDateTime;
                Intrinsics3.checkNotNullParameter(voiceUser, "voiceUser");
                VoiceState voiceState = voiceUser.getVoiceState();
                if (voiceState == null || (utcDateTime = voiceState.getRequestToSpeakTimestamp()) == null) {
                    utcDateTime = new UtcDateTime(WidgetStageRaisedHandsBottomSheetViewModel2.this.$clock.currentTimeMillis());
                }
                GuildMember guildMember = (GuildMember) this.$members.get(Long.valueOf(voiceUser.getUser().getId()));
                Map map = this.$roles;
                Intrinsics3.checkNotNullExpressionValue(map, "roles");
                return new WidgetStageRaisedHandsBottomSheetAdapter.ListItem.Participant(voiceUser, utcDateTime, guildMember, RoleUtils.getHighestHoistedRole(map, (GuildMember) this.$members.get(Long.valueOf(voiceUser.getUser().getId()))));
            }
        }

        public AnonymousClass1(Channel channel) {
            this.$channel = channel;
        }

        @Override // p658rx.functions.Func4
        public /* bridge */ /* synthetic */ WidgetStageRaisedHandsBottomSheetViewModel.StoreState call(Map<Long, ? extends GuildRole> map, Map<Long, ? extends GuildMember> map2, Map<Long, ? extends StoreVoiceParticipants.VoiceUser> map3, StageRoles stageRoles) {
            return call2((Map<Long, GuildRole>) map, (Map<Long, GuildMember>) map2, (Map<Long, StoreVoiceParticipants.VoiceUser>) map3, stageRoles);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetStageRaisedHandsBottomSheetViewModel.StoreState call2(Map<Long, GuildRole> map, Map<Long, GuildMember> map2, Map<Long, StoreVoiceParticipants.VoiceUser> map3, StageRoles stageRoles) {
            Channel channel = this.$channel;
            Intrinsics3.checkNotNullExpressionValue(channel, "channel");
            Intrinsics3.checkNotNullExpressionValue(map, "roles");
            return new WidgetStageRaisedHandsBottomSheetViewModel.StoreState(channel, map, _Sequences2.toList(_Sequences2.sortedWith(_Sequences2.map(_Sequences2.filter(_Collections.asSequence(map3.values()), C132941.INSTANCE), new AnonymousClass2(map2, map)), new C10043x11f80e27())), stageRoles != null ? stageRoles.m11412unboximpl() : StageRoles.INSTANCE.m11414getAUDIENCE1LxfuJo(), null);
        }
    }

    public WidgetStageRaisedHandsBottomSheetViewModel2(StoreGuilds storeGuilds, StoreVoiceParticipants storeVoiceParticipants, long j, StoreStageChannels storeStageChannels, Clock clock) {
        this.$guildsStore = storeGuilds;
        this.$voiceParticipants = storeVoiceParticipants;
        this.$channelId = j;
        this.$stageChannels = storeStageChannels;
        this.$clock = clock;
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetStageRaisedHandsBottomSheetViewModel.StoreState> call(Channel channel) {
        return call2(channel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetStageRaisedHandsBottomSheetViewModel.StoreState> call2(Channel channel) {
        return Observable.m11073h(this.$guildsStore.observeRoles(channel.getGuildId()), this.$guildsStore.observeComputed(channel.getGuildId()), this.$voiceParticipants.get(this.$channelId), this.$stageChannels.observeMyRoles(this.$channelId), new AnonymousClass1(channel));
    }
}
