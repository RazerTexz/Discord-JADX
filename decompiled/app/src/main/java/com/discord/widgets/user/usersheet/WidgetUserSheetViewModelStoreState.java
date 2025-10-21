package com.discord.widgets.user.usersheet;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.role.GuildRole;
import com.discord.api.user.UserProfile;
import com.discord.api.voice.state.StageRequestToSpeakState;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreMediaSettings;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStageChannels;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserNotes;
import com.discord.stores.StoreUserPresence;
import com.discord.stores.StoreUserProfile;
import com.discord.stores.StoreUserRelationships;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.stores.StoreVoiceStates;
import com.discord.utilities.rx.LeadingEdgeThrottle;
import com.discord.utilities.rx.ObservableCombineLatestOverloads2;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.streams.StreamContextService;
import com.discord.widgets.guildcommunicationdisabled.start.GuildCommunicationDisabledGuildsFeatureFlag;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.user.presence.ModelRichPresence;
import com.discord.widgets.user.usersheet.WidgetUserSheetViewModel;
import d0.t.Collections2;
import d0.t.Maps6;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.a.OnSubscribeLift;
import j0.l.e.ScalarSynchronousObservable;
import j0.p.Schedulers2;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function4;
import rx.Observable;
import rx.Scheduler;
import rx.functions.Func4;

/* compiled from: WidgetUserSheetViewModelStoreState.kt */
/* loaded from: classes.dex */
public final class WidgetUserSheetViewModelStoreState {
    public static final WidgetUserSheetViewModelStoreState INSTANCE = new WidgetUserSheetViewModelStoreState();

    /* compiled from: WidgetUserSheetViewModelStoreState.kt */
    public static final /* data */ class BootstrapData {
        private final Channel channel;
        private final MeUser me;
        private final Channel selectedVoiceChannel;
        private final User user;

        public BootstrapData(User user, MeUser meUser, Channel channel, Channel channel2) {
            Intrinsics3.checkNotNullParameter(meUser, "me");
            this.user = user;
            this.me = meUser;
            this.channel = channel;
            this.selectedVoiceChannel = channel2;
        }

        public static /* synthetic */ BootstrapData copy$default(BootstrapData bootstrapData, User user, MeUser meUser, Channel channel, Channel channel2, int i, Object obj) {
            if ((i & 1) != 0) {
                user = bootstrapData.user;
            }
            if ((i & 2) != 0) {
                meUser = bootstrapData.me;
            }
            if ((i & 4) != 0) {
                channel = bootstrapData.channel;
            }
            if ((i & 8) != 0) {
                channel2 = bootstrapData.selectedVoiceChannel;
            }
            return bootstrapData.copy(user, meUser, channel, channel2);
        }

        /* renamed from: component1, reason: from getter */
        public final User getUser() {
            return this.user;
        }

        /* renamed from: component2, reason: from getter */
        public final MeUser getMe() {
            return this.me;
        }

        /* renamed from: component3, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* renamed from: component4, reason: from getter */
        public final Channel getSelectedVoiceChannel() {
            return this.selectedVoiceChannel;
        }

        public final BootstrapData copy(User user, MeUser me2, Channel channel, Channel selectedVoiceChannel) {
            Intrinsics3.checkNotNullParameter(me2, "me");
            return new BootstrapData(user, me2, channel, selectedVoiceChannel);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BootstrapData)) {
                return false;
            }
            BootstrapData bootstrapData = (BootstrapData) other;
            return Intrinsics3.areEqual(this.user, bootstrapData.user) && Intrinsics3.areEqual(this.me, bootstrapData.me) && Intrinsics3.areEqual(this.channel, bootstrapData.channel) && Intrinsics3.areEqual(this.selectedVoiceChannel, bootstrapData.selectedVoiceChannel);
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final MeUser getMe() {
            return this.me;
        }

        public final Channel getSelectedVoiceChannel() {
            return this.selectedVoiceChannel;
        }

        public final User getUser() {
            return this.user;
        }

        public int hashCode() {
            User user = this.user;
            int iHashCode = (user != null ? user.hashCode() : 0) * 31;
            MeUser meUser = this.me;
            int iHashCode2 = (iHashCode + (meUser != null ? meUser.hashCode() : 0)) * 31;
            Channel channel = this.channel;
            int iHashCode3 = (iHashCode2 + (channel != null ? channel.hashCode() : 0)) * 31;
            Channel channel2 = this.selectedVoiceChannel;
            return iHashCode3 + (channel2 != null ? channel2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("BootstrapData(user=");
            sbU.append(this.user);
            sbU.append(", me=");
            sbU.append(this.me);
            sbU.append(", channel=");
            sbU.append(this.channel);
            sbU.append(", selectedVoiceChannel=");
            sbU.append(this.selectedVoiceChannel);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: WidgetUserSheetViewModelStoreState.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheetViewModelStoreState$observeStoreState$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function4<User, MeUser, Channel, Channel, BootstrapData> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(4, BootstrapData.class, "<init>", "<init>(Lcom/discord/models/user/User;Lcom/discord/models/user/MeUser;Lcom/discord/api/channel/Channel;Lcom/discord/api/channel/Channel;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ BootstrapData invoke(User user, MeUser meUser, Channel channel, Channel channel2) {
            return invoke2(user, meUser, channel, channel2);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final BootstrapData invoke2(User user, MeUser meUser, Channel channel, Channel channel2) {
            Intrinsics3.checkNotNullParameter(meUser, "p2");
            return new BootstrapData(user, meUser, channel, channel2);
        }
    }

    /* compiled from: WidgetUserSheetViewModelStoreState.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheetViewModelStoreState$observeStoreState$3, reason: invalid class name */
    public static final class AnonymousClass3<T, R> implements Func1<BootstrapData, Observable<? extends WidgetUserSheetViewModel.StoreState>> {
        public final /* synthetic */ Long $guildId;
        public final /* synthetic */ StoreGuilds $storeGuilds;
        public final /* synthetic */ StoreMediaSettings $storeMediaSettings;
        public final /* synthetic */ StorePermissions $storePermissions;
        public final /* synthetic */ StoreStageChannels $storeStageChannels;
        public final /* synthetic */ StoreUserNotes $storeUserNotes;
        public final /* synthetic */ StoreUserPresence $storeUserPresence;
        public final /* synthetic */ StoreUserProfile $storeUserProfile;
        public final /* synthetic */ StoreUserRelationships $storeUserRelationships;
        public final /* synthetic */ StoreVoiceStates $storeVoiceStates;
        public final /* synthetic */ StreamContextService $streamContextService;

        /* compiled from: WidgetUserSheetViewModelStoreState.kt */
        /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheetViewModelStoreState$observeStoreState$3$1, reason: invalid class name */
        public static final class AnonymousClass1<T, R> implements Func1 {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Object call(Object obj) {
                return call((Long) obj);
            }

            public final Void call(Long l) {
                return null;
            }
        }

        /* compiled from: WidgetUserSheetViewModelStoreState.kt */
        /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheetViewModelStoreState$observeStoreState$3$2, reason: invalid class name */
        public static final class AnonymousClass2 extends Lambda implements Function16<Map<Long, ? extends GuildMember>, Map<Long, ? extends GuildRole>, Map<Long, ? extends VoiceState>, Map<Long, ? extends VoiceState>, StoreMediaSettings.VoiceConfiguration, ModelRichPresence, Guild, Long, StreamContext, UserProfile, Integer, StoreUserNotes.UserNoteState, StageRoles, StageRequestToSpeakState, StageRoles, Boolean, WidgetUserSheetViewModel.StoreState> {
            public final /* synthetic */ Channel $channel;
            public final /* synthetic */ MeUser $me;
            public final /* synthetic */ Channel $selectedVoiceChannel;
            public final /* synthetic */ User $user;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(User user, MeUser meUser, Channel channel, Channel channel2) {
                super(16);
                this.$user = user;
                this.$me = meUser;
                this.$channel = channel;
                this.$selectedVoiceChannel = channel2;
            }

            @Override // kotlin.jvm.functions.Function16
            public /* bridge */ /* synthetic */ WidgetUserSheetViewModel.StoreState invoke(Map<Long, ? extends GuildMember> map, Map<Long, ? extends GuildRole> map2, Map<Long, ? extends VoiceState> map3, Map<Long, ? extends VoiceState> map4, StoreMediaSettings.VoiceConfiguration voiceConfiguration, ModelRichPresence modelRichPresence, Guild guild, Long l, StreamContext streamContext, UserProfile userProfile, Integer num, StoreUserNotes.UserNoteState userNoteState, StageRoles stageRoles, StageRequestToSpeakState stageRequestToSpeakState, StageRoles stageRoles2, Boolean bool) {
                return invoke((Map<Long, GuildMember>) map, (Map<Long, GuildRole>) map2, (Map<Long, VoiceState>) map3, (Map<Long, VoiceState>) map4, voiceConfiguration, modelRichPresence, guild, l, streamContext, userProfile, num, userNoteState, stageRoles, stageRequestToSpeakState, stageRoles2, bool.booleanValue());
            }

            public final WidgetUserSheetViewModel.StoreState invoke(Map<Long, GuildMember> map, Map<Long, GuildRole> map2, Map<Long, VoiceState> map3, Map<Long, VoiceState> map4, StoreMediaSettings.VoiceConfiguration voiceConfiguration, ModelRichPresence modelRichPresence, Guild guild, Long l, StreamContext streamContext, UserProfile userProfile, Integer num, StoreUserNotes.UserNoteState userNoteState, StageRoles stageRoles, StageRequestToSpeakState stageRequestToSpeakState, StageRoles stageRoles2, boolean z2) {
                Intrinsics3.checkNotNullParameter(map, "computedMembers");
                Intrinsics3.checkNotNullParameter(map2, "guildRoles");
                Intrinsics3.checkNotNullParameter(map3, "mySelectedVoiceChannelVoiceStates");
                Intrinsics3.checkNotNullParameter(map4, "currentChannelVoiceStates");
                Intrinsics3.checkNotNullParameter(voiceConfiguration, "voiceConfig");
                Intrinsics3.checkNotNullParameter(userProfile, "userProfile");
                Intrinsics3.checkNotNullParameter(userNoteState, "userNote");
                Intrinsics3.checkNotNullParameter(stageRequestToSpeakState, "userRequestToSpeakState");
                Boolean bool = (Boolean) outline.f(this.$user, voiceConfiguration.getMutedUsers());
                boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
                boolean zIsSelfMuted = voiceConfiguration.isSelfMuted();
                boolean zIsSelfDeafened = voiceConfiguration.isSelfDeafened();
                Float f = (Float) outline.f(this.$user, voiceConfiguration.getUserOutputVolumes());
                float fFloatValue = f != null ? f.floatValue() : 100.0f;
                User user = this.$user;
                MeUser meUser = this.$me;
                Channel channel = this.$channel;
                Channel channel2 = this.$selectedVoiceChannel;
                return new WidgetUserSheetViewModel.StoreState(user, meUser, channel, map, map2, map3, map4, zBooleanValue, zIsSelfMuted, zIsSelfDeafened, fFloatValue, modelRichPresence, guild, l, streamContext, userProfile, num, userNoteState, (channel2 == null || !ChannelUtils.D(channel2)) ? null : channel2, stageRoles, stageRequestToSpeakState, stageRoles2, z2, null);
            }
        }

        public AnonymousClass3(Long l, StoreGuilds storeGuilds, StoreVoiceStates storeVoiceStates, StoreUserPresence storeUserPresence, StorePermissions storePermissions, StreamContextService streamContextService, StoreStageChannels storeStageChannels, StoreMediaSettings storeMediaSettings, StoreUserProfile storeUserProfile, StoreUserRelationships storeUserRelationships, StoreUserNotes storeUserNotes) {
            this.$guildId = l;
            this.$storeGuilds = storeGuilds;
            this.$storeVoiceStates = storeVoiceStates;
            this.$storeUserPresence = storeUserPresence;
            this.$storePermissions = storePermissions;
            this.$streamContextService = streamContextService;
            this.$storeStageChannels = storeStageChannels;
            this.$storeMediaSettings = storeMediaSettings;
            this.$storeUserProfile = storeUserProfile;
            this.$storeUserRelationships = storeUserRelationships;
            this.$storeUserNotes = storeUserNotes;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends WidgetUserSheetViewModel.StoreState> call(BootstrapData bootstrapData) {
            return call2(bootstrapData);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0065  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0082  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00e6  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0112  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x0126  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x0131  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x0144  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x0150  */
        /* JADX WARN: Removed duplicated region for block: B:61:0x015d  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x0165  */
        /* JADX WARN: Removed duplicated region for block: B:66:0x0179  */
        /* renamed from: call, reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Observable<? extends WidgetUserSheetViewModel.StoreState> call2(BootstrapData bootstrapData) {
            Observable scalarSynchronousObservable;
            Observable scalarSynchronousObservable2;
            Observable<Guild> scalarSynchronousObservable3;
            Observable observable;
            Observable<Long> scalarSynchronousObservable4;
            MeUser meUser;
            Channel channel;
            Observable<StageRoles> scalarSynchronousObservable5;
            MeUser meUser2;
            Observable<StageRequestToSpeakState> scalarSynchronousObservable6;
            Observable<StageRoles> scalarSynchronousObservable7;
            Observable<Boolean> scalarSynchronousObservable8;
            Observable observableObserve;
            Observable observableObserve2;
            User user = bootstrapData.getUser();
            MeUser me2 = bootstrapData.getMe();
            Channel channel2 = bootstrapData.getChannel();
            Channel selectedVoiceChannel = bootstrapData.getSelectedVoiceChannel();
            if (user == null) {
                return Observable.d0(5L, TimeUnit.SECONDS).G(AnonymousClass1.INSTANCE);
            }
            Long lValueOf = this.$guildId;
            if (lValueOf == null) {
                lValueOf = channel2 != null ? Long.valueOf(channel2.getGuildId()) : null;
            }
            if (lValueOf != null) {
                lValueOf.longValue();
                Observable observableObserveComputed = this.$storeGuilds.observeComputed(lValueOf.longValue(), Collections2.listOf((Object[]) new Long[]{Long.valueOf(user.getId()), Long.valueOf(me2.getId())}));
                scalarSynchronousObservable = observableObserveComputed != null ? observableObserveComputed : new ScalarSynchronousObservable(Maps6.emptyMap());
            }
            if (lValueOf != null) {
                lValueOf.longValue();
                Observable observableObserveRoles = this.$storeGuilds.observeRoles(lValueOf.longValue());
                scalarSynchronousObservable2 = observableObserveRoles != null ? observableObserveRoles : new ScalarSynchronousObservable(Maps6.emptyMap());
            }
            Observable scalarSynchronousObservable9 = (selectedVoiceChannel == null || (observableObserve2 = this.$storeVoiceStates.observe(selectedVoiceChannel.getGuildId(), selectedVoiceChannel.getId())) == null) ? new ScalarSynchronousObservable(Maps6.emptyMap()) : observableObserve2;
            Observable scalarSynchronousObservable10 = (channel2 == null || (observableObserve = this.$storeVoiceStates.observe(channel2.getGuildId(), channel2.getId())) == null) ? new ScalarSynchronousObservable(Maps6.emptyMap()) : observableObserve;
            Observable<ModelRichPresence> observable2 = ModelRichPresence.INSTANCE.get(user.getId(), this.$storeUserPresence);
            if (lValueOf != null) {
                lValueOf.longValue();
                scalarSynchronousObservable3 = this.$storeGuilds.observeGuild(lValueOf.longValue());
                if (scalarSynchronousObservable3 == null) {
                    scalarSynchronousObservable3 = new ScalarSynchronousObservable<>(null);
                }
            }
            if (channel2 != null) {
                observable = scalarSynchronousObservable;
                scalarSynchronousObservable4 = this.$storePermissions.observePermissionsForChannel(channel2.getId());
                if (scalarSynchronousObservable4 == null) {
                }
                Observable<StreamContext> forUser = this.$streamContextService.getForUser(user.getId(), true);
                if (selectedVoiceChannel == null) {
                    meUser = me2;
                    channel = channel2;
                    scalarSynchronousObservable5 = this.$storeStageChannels.observeUserRoles(user.getId(), selectedVoiceChannel.getId());
                    if (scalarSynchronousObservable5 == null) {
                    }
                    if (selectedVoiceChannel != null) {
                        meUser2 = meUser;
                        scalarSynchronousObservable6 = this.$storeStageChannels.observeUserRequestToSpeakState(user.getId(), selectedVoiceChannel.getId());
                        if (scalarSynchronousObservable6 == null) {
                        }
                        if (selectedVoiceChannel != null || (scalarSynchronousObservable7 = this.$storeStageChannels.observeMyRoles(selectedVoiceChannel.getId())) == null) {
                            scalarSynchronousObservable7 = new ScalarSynchronousObservable<>(null);
                        }
                        if (lValueOf == null) {
                            lValueOf.longValue();
                            scalarSynchronousObservable8 = GuildCommunicationDisabledGuildsFeatureFlag.INSTANCE.getINSTANCE().observeCanGuildAccessCommunicationDisabled(lValueOf.longValue());
                            if (scalarSynchronousObservable8 == null) {
                                scalarSynchronousObservable8 = new ScalarSynchronousObservable(Boolean.FALSE);
                            }
                        }
                        Intrinsics3.checkNotNullExpressionValue(observable, "computedMembersObservable");
                        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable2, "guildRolesObservable");
                        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable9, "mySelectedVoiceChannelVoiceStatesObservable");
                        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable10, "currentChannelVoiceStatesObservable");
                        Observable<StoreMediaSettings.VoiceConfiguration> voiceConfig = this.$storeMediaSettings.getVoiceConfig();
                        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable3, "guildsObservable");
                        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable4, "permissionsObservable");
                        Observable<UserProfile> observableObserveUserProfile = this.$storeUserProfile.observeUserProfile(user.getId());
                        Observable<Integer> observableObserve3 = this.$storeUserRelationships.observe(user.getId());
                        Observable<StoreUserNotes.UserNoteState> observableObserveUserNote = this.$storeUserNotes.observeUserNote(user.getId());
                        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable5, "userStageRolesObservable");
                        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable6, "userStageRequestToSpeakStateObservable");
                        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable7, "myStageRolesObservable");
                        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable8, "canDisableCommunicationObservable");
                        return ObservableCombineLatestOverloads2.combineLatest(observable, scalarSynchronousObservable2, scalarSynchronousObservable9, scalarSynchronousObservable10, voiceConfig, observable2, scalarSynchronousObservable3, scalarSynchronousObservable4, forUser, observableObserveUserProfile, observableObserve3, observableObserveUserNote, scalarSynchronousObservable5, scalarSynchronousObservable6, scalarSynchronousObservable7, scalarSynchronousObservable8, new AnonymousClass2(user, meUser2, channel, selectedVoiceChannel));
                    }
                    meUser2 = meUser;
                    scalarSynchronousObservable6 = new ScalarSynchronousObservable(StageRequestToSpeakState.NONE);
                    if (selectedVoiceChannel != null) {
                        scalarSynchronousObservable7 = new ScalarSynchronousObservable<>(null);
                    }
                    if (lValueOf == null) {
                    }
                    Intrinsics3.checkNotNullExpressionValue(observable, "computedMembersObservable");
                    Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable2, "guildRolesObservable");
                    Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable9, "mySelectedVoiceChannelVoiceStatesObservable");
                    Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable10, "currentChannelVoiceStatesObservable");
                    Observable<StoreMediaSettings.VoiceConfiguration> voiceConfig2 = this.$storeMediaSettings.getVoiceConfig();
                    Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable3, "guildsObservable");
                    Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable4, "permissionsObservable");
                    Observable<UserProfile> observableObserveUserProfile2 = this.$storeUserProfile.observeUserProfile(user.getId());
                    Observable<Integer> observableObserve32 = this.$storeUserRelationships.observe(user.getId());
                    Observable<StoreUserNotes.UserNoteState> observableObserveUserNote2 = this.$storeUserNotes.observeUserNote(user.getId());
                    Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable5, "userStageRolesObservable");
                    Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable6, "userStageRequestToSpeakStateObservable");
                    Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable7, "myStageRolesObservable");
                    Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable8, "canDisableCommunicationObservable");
                    return ObservableCombineLatestOverloads2.combineLatest(observable, scalarSynchronousObservable2, scalarSynchronousObservable9, scalarSynchronousObservable10, voiceConfig2, observable2, scalarSynchronousObservable3, scalarSynchronousObservable4, forUser, observableObserveUserProfile2, observableObserve32, observableObserveUserNote2, scalarSynchronousObservable5, scalarSynchronousObservable6, scalarSynchronousObservable7, scalarSynchronousObservable8, new AnonymousClass2(user, meUser2, channel, selectedVoiceChannel));
                }
                meUser = me2;
                channel = channel2;
                scalarSynchronousObservable5 = new ScalarSynchronousObservable<>(null);
                if (selectedVoiceChannel != null) {
                }
                scalarSynchronousObservable6 = new ScalarSynchronousObservable(StageRequestToSpeakState.NONE);
                if (selectedVoiceChannel != null) {
                }
                if (lValueOf == null) {
                }
                Intrinsics3.checkNotNullExpressionValue(observable, "computedMembersObservable");
                Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable2, "guildRolesObservable");
                Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable9, "mySelectedVoiceChannelVoiceStatesObservable");
                Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable10, "currentChannelVoiceStatesObservable");
                Observable<StoreMediaSettings.VoiceConfiguration> voiceConfig22 = this.$storeMediaSettings.getVoiceConfig();
                Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable3, "guildsObservable");
                Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable4, "permissionsObservable");
                Observable<UserProfile> observableObserveUserProfile22 = this.$storeUserProfile.observeUserProfile(user.getId());
                Observable<Integer> observableObserve322 = this.$storeUserRelationships.observe(user.getId());
                Observable<StoreUserNotes.UserNoteState> observableObserveUserNote22 = this.$storeUserNotes.observeUserNote(user.getId());
                Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable5, "userStageRolesObservable");
                Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable6, "userStageRequestToSpeakStateObservable");
                Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable7, "myStageRolesObservable");
                Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable8, "canDisableCommunicationObservable");
                return ObservableCombineLatestOverloads2.combineLatest(observable, scalarSynchronousObservable2, scalarSynchronousObservable9, scalarSynchronousObservable10, voiceConfig22, observable2, scalarSynchronousObservable3, scalarSynchronousObservable4, forUser, observableObserveUserProfile22, observableObserve322, observableObserveUserNote22, scalarSynchronousObservable5, scalarSynchronousObservable6, scalarSynchronousObservable7, scalarSynchronousObservable8, new AnonymousClass2(user, meUser2, channel, selectedVoiceChannel));
            }
            observable = scalarSynchronousObservable;
            scalarSynchronousObservable4 = new ScalarSynchronousObservable<>(null);
            Observable<StreamContext> forUser2 = this.$streamContextService.getForUser(user.getId(), true);
            if (selectedVoiceChannel == null) {
            }
            scalarSynchronousObservable5 = new ScalarSynchronousObservable<>(null);
            if (selectedVoiceChannel != null) {
            }
            scalarSynchronousObservable6 = new ScalarSynchronousObservable(StageRequestToSpeakState.NONE);
            if (selectedVoiceChannel != null) {
            }
            if (lValueOf == null) {
            }
            Intrinsics3.checkNotNullExpressionValue(observable, "computedMembersObservable");
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable2, "guildRolesObservable");
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable9, "mySelectedVoiceChannelVoiceStatesObservable");
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable10, "currentChannelVoiceStatesObservable");
            Observable<StoreMediaSettings.VoiceConfiguration> voiceConfig222 = this.$storeMediaSettings.getVoiceConfig();
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable3, "guildsObservable");
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable4, "permissionsObservable");
            Observable<UserProfile> observableObserveUserProfile222 = this.$storeUserProfile.observeUserProfile(user.getId());
            Observable<Integer> observableObserve3222 = this.$storeUserRelationships.observe(user.getId());
            Observable<StoreUserNotes.UserNoteState> observableObserveUserNote222 = this.$storeUserNotes.observeUserNote(user.getId());
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable5, "userStageRolesObservable");
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable6, "userStageRequestToSpeakStateObservable");
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable7, "myStageRolesObservable");
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable8, "canDisableCommunicationObservable");
            return ObservableCombineLatestOverloads2.combineLatest(observable, scalarSynchronousObservable2, scalarSynchronousObservable9, scalarSynchronousObservable10, voiceConfig222, observable2, scalarSynchronousObservable3, scalarSynchronousObservable4, forUser2, observableObserveUserProfile222, observableObserve3222, observableObserveUserNote222, scalarSynchronousObservable5, scalarSynchronousObservable6, scalarSynchronousObservable7, scalarSynchronousObservable8, new AnonymousClass2(user, meUser2, channel, selectedVoiceChannel));
        }
    }

    private WidgetUserSheetViewModelStoreState() {
    }

    public static /* synthetic */ Observable observeStoreState$default(WidgetUserSheetViewModelStoreState widgetUserSheetViewModelStoreState, long j, Long l, Long l2, StoreUser storeUser, StoreChannels storeChannels, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreUserProfile storeUserProfile, StoreUserRelationships storeUserRelationships, StoreVoiceStates storeVoiceStates, StoreGuilds storeGuilds, StoreMediaSettings storeMediaSettings, StoreUserPresence storeUserPresence, StorePermissions storePermissions, StoreUserNotes storeUserNotes, StoreStageChannels storeStageChannels, StreamContextService streamContextService, Scheduler scheduler, int i, Object obj) {
        Scheduler scheduler2;
        StoreUser users = (i & 8) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser;
        StoreChannels channels = (i & 16) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels;
        StoreVoiceChannelSelected voiceChannelSelected = (i & 32) != 0 ? StoreStream.INSTANCE.getVoiceChannelSelected() : storeVoiceChannelSelected;
        StoreUserProfile userProfile = (i & 64) != 0 ? StoreStream.INSTANCE.getUserProfile() : storeUserProfile;
        StoreUserRelationships userRelationships = (i & 128) != 0 ? StoreStream.INSTANCE.getUserRelationships() : storeUserRelationships;
        StoreVoiceStates voiceStates = (i & 256) != 0 ? StoreStream.INSTANCE.getVoiceStates() : storeVoiceStates;
        StoreGuilds guilds = (i & 512) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds;
        StoreMediaSettings mediaSettings = (i & 1024) != 0 ? StoreStream.INSTANCE.getMediaSettings() : storeMediaSettings;
        StoreUserPresence presences = (i & 2048) != 0 ? StoreStream.INSTANCE.getPresences() : storeUserPresence;
        StorePermissions permissions = (i & 4096) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions;
        StoreUserNotes usersNotes = (i & 8192) != 0 ? StoreStream.INSTANCE.getUsersNotes() : storeUserNotes;
        StoreStageChannels stageChannels = (i & 16384) != 0 ? StoreStream.INSTANCE.getStageChannels() : storeStageChannels;
        StreamContextService streamContextService2 = (32768 & i) != 0 ? new StreamContextService(null, null, null, null, null, null, null, null, 255, null) : streamContextService;
        if ((i & 65536) != 0) {
            Scheduler schedulerA = Schedulers2.a();
            Intrinsics3.checkNotNullExpressionValue(schedulerA, "Schedulers.computation()");
            scheduler2 = schedulerA;
        } else {
            scheduler2 = scheduler;
        }
        return widgetUserSheetViewModelStoreState.observeStoreState(j, l, l2, users, channels, voiceChannelSelected, userProfile, userRelationships, voiceStates, guilds, mediaSettings, presences, permissions, usersNotes, stageChannels, streamContextService2, scheduler2);
    }

    public final Observable<WidgetUserSheetViewModel.StoreState> observeStoreState(long userId, Long channelId, Long guildId, StoreUser storeUser, StoreChannels storeChannels, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreUserProfile storeUserProfile, StoreUserRelationships storeUserRelationships, StoreVoiceStates storeVoiceStates, StoreGuilds storeGuilds, StoreMediaSettings storeMediaSettings, StoreUserPresence storeUserPresence, StorePermissions storePermissions, StoreUserNotes storeUserNotes, StoreStageChannels storeStageChannels, StreamContextService streamContextService, Scheduler storeStateRxScheduler) {
        Observable<Channel> scalarSynchronousObservable;
        Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
        Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
        Intrinsics3.checkNotNullParameter(storeVoiceChannelSelected, "storeVoiceChannelSelected");
        Intrinsics3.checkNotNullParameter(storeUserProfile, "storeUserProfile");
        Intrinsics3.checkNotNullParameter(storeUserRelationships, "storeUserRelationships");
        Intrinsics3.checkNotNullParameter(storeVoiceStates, "storeVoiceStates");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        Intrinsics3.checkNotNullParameter(storeMediaSettings, "storeMediaSettings");
        Intrinsics3.checkNotNullParameter(storeUserPresence, "storeUserPresence");
        Intrinsics3.checkNotNullParameter(storePermissions, "storePermissions");
        Intrinsics3.checkNotNullParameter(storeUserNotes, "storeUserNotes");
        Intrinsics3.checkNotNullParameter(storeStageChannels, "storeStageChannels");
        Intrinsics3.checkNotNullParameter(streamContextService, "streamContextService");
        Intrinsics3.checkNotNullParameter(storeStateRxScheduler, "storeStateRxScheduler");
        Observable<User> observableObserveUser = storeUser.observeUser(userId);
        Observable observableObserveMe$default = StoreUser.observeMe$default(storeUser, false, 1, null);
        if (channelId == null || (scalarSynchronousObservable = storeChannels.observeChannel(channelId.longValue())) == null) {
            scalarSynchronousObservable = new ScalarSynchronousObservable<>(null);
        }
        Observable<Channel> observableObserveSelectedChannel = storeVoiceChannelSelected.observeSelectedChannel();
        AnonymousClass2 anonymousClass2 = AnonymousClass2.INSTANCE;
        Object widgetUserSheetViewModelStoreState2 = anonymousClass2;
        if (anonymousClass2 != null) {
            widgetUserSheetViewModelStoreState2 = new WidgetUserSheetViewModelStoreState2(anonymousClass2);
        }
        Observable<WidgetUserSheetViewModel.StoreState> observableR = Observable.h0(new OnSubscribeLift(Observable.h(observableObserveUser, observableObserveMe$default, scalarSynchronousObservable, observableObserveSelectedChannel, (Func4) widgetUserSheetViewModelStoreState2).Y(new AnonymousClass3(guildId, storeGuilds, storeVoiceStates, storeUserPresence, storePermissions, streamContextService, storeStageChannels, storeMediaSettings, storeUserProfile, storeUserRelationships, storeUserNotes)).j, new LeadingEdgeThrottle(250L, TimeUnit.MILLISECONDS, storeStateRxScheduler))).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "Observable\n          .co…  .distinctUntilChanged()");
        return observableR;
    }
}
