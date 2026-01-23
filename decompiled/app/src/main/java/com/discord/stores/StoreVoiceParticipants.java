package com.discord.stores;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.stageinstance.StageInstance;
import com.discord.api.stageinstance.StageInstancePrivacyLevel;
import com.discord.api.voice.state.StageRequestToSpeakState;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.domain.ModelCall;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreMediaSettings;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreVideoStreams;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.streams.StreamContextService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p507d0.Tuples;
import p507d0.p580t.Collections2;
import p507d0.p580t.Iterables2;
import p507d0.p580t.Maps6;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;
import p658rx.functions.Action1;
import p658rx.functions.Func2;
import p658rx.functions.Func7;
import p658rx.functions.FuncN;
import p658rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: StoreVoiceParticipants.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreVoiceParticipants extends Store {
    private final BehaviorSubject<Long> selectedParticipantSubject;
    private final StoreStream stream;

    /* JADX INFO: compiled from: StoreVoiceParticipants.kt */
    public static final /* data */ class VoiceUser {
        private final boolean _isSpeaking;
        private final ModelApplicationStream applicationStream;
        private final Integer applicationStreamId;
        private final Integer callStreamId;
        private final GuildMember guildMember;
        private final boolean isBooster;
        private final boolean isDeafened;
        private final boolean isInvitedToSpeak;
        private final boolean isMe;
        private final boolean isMuted;
        private final boolean isRequestingToSpeak;
        private final boolean isRinging;
        private final boolean isSelfDeafened;
        private final boolean isSelfMuted;
        private final boolean isServerDeafened;
        private final boolean isServerMuted;
        private final boolean isSpeaking;
        private final String nickname;
        private final StreamContext streamContext;
        private final StoreVideoStreams.UserStreams streams;
        private final User user;
        private final StoreMediaSettings.VoiceConfiguration voiceConfiguration;
        private final VoiceState voiceState;
        private final String watchingStream;

        /* JADX WARN: Removed duplicated region for block: B:36:0x0077  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x009e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public VoiceUser(User user, VoiceState voiceState, boolean z2, StoreVideoStreams.UserStreams userStreams, boolean z3, GuildMember guildMember, String str, StreamContext streamContext, boolean z4, StoreMediaSettings.VoiceConfiguration voiceConfiguration, boolean z5) {
            boolean selfMute;
            boolean selfDeaf;
            Intrinsics3.checkNotNullParameter(user, "user");
            this.user = user;
            this.voiceState = voiceState;
            this.isRinging = z2;
            this.streams = userStreams;
            this.isMe = z3;
            this.guildMember = guildMember;
            this.watchingStream = str;
            this.streamContext = streamContext;
            this.isBooster = z4;
            this.voiceConfiguration = voiceConfiguration;
            this._isSpeaking = z5;
            this.isSpeaking = (voiceState == null || !z5 || voiceState.getMute() || voiceState.getDeaf()) ? false : true;
            this.nickname = guildMember != null ? guildMember.getNick() : null;
            this.callStreamId = userStreams != null ? userStreams.getCallStreamId() : null;
            this.applicationStreamId = userStreams != null ? userStreams.getApplicationStreamId() : null;
            this.applicationStream = streamContext != null ? streamContext.getStream() : null;
            boolean mute = voiceState != null ? voiceState.getMute() : false;
            this.isServerMuted = mute;
            if (z3) {
                selfMute = voiceConfiguration != null ? voiceConfiguration.isSelfMuted() : false;
            } else if (voiceState != null) {
                selfMute = voiceState.getSelfMute();
            }
            this.isSelfMuted = selfMute;
            this.isMuted = mute || selfMute;
            boolean deaf = voiceState != null ? voiceState.getDeaf() : false;
            this.isServerDeafened = deaf;
            if (z3) {
                selfDeaf = voiceConfiguration != null ? voiceConfiguration.isSelfDeafened() : false;
            } else if (voiceState != null) {
                selfDeaf = voiceState.getSelfDeaf();
            }
            this.isSelfDeafened = selfDeaf;
            this.isDeafened = deaf || selfDeaf;
            this.isRequestingToSpeak = AnimatableValueParser.m592y0(voiceState).getIsRequestingToSpeak();
            this.isInvitedToSpeak = AnimatableValueParser.m592y0(voiceState) == StageRequestToSpeakState.REQUESTED_TO_SPEAK_AND_AWAITING_USER_ACK;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        private final StoreMediaSettings.VoiceConfiguration getVoiceConfiguration() {
            return this.voiceConfiguration;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        private final boolean get_isSpeaking() {
            return this._isSpeaking;
        }

        public static /* synthetic */ VoiceUser copy$default(VoiceUser voiceUser, User user, VoiceState voiceState, boolean z2, StoreVideoStreams.UserStreams userStreams, boolean z3, GuildMember guildMember, String str, StreamContext streamContext, boolean z4, StoreMediaSettings.VoiceConfiguration voiceConfiguration, boolean z5, int i, Object obj) {
            return voiceUser.copy((i & 1) != 0 ? voiceUser.user : user, (i & 2) != 0 ? voiceUser.voiceState : voiceState, (i & 4) != 0 ? voiceUser.isRinging : z2, (i & 8) != 0 ? voiceUser.streams : userStreams, (i & 16) != 0 ? voiceUser.isMe : z3, (i & 32) != 0 ? voiceUser.guildMember : guildMember, (i & 64) != 0 ? voiceUser.watchingStream : str, (i & 128) != 0 ? voiceUser.streamContext : streamContext, (i & 256) != 0 ? voiceUser.isBooster : z4, (i & 512) != 0 ? voiceUser.voiceConfiguration : voiceConfiguration, (i & 1024) != 0 ? voiceUser._isSpeaking : z5);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final User getUser() {
            return this.user;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final VoiceState getVoiceState() {
            return this.voiceState;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getIsRinging() {
            return this.isRinging;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final StoreVideoStreams.UserStreams getStreams() {
            return this.streams;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getIsMe() {
            return this.isMe;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final GuildMember getGuildMember() {
            return this.guildMember;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getWatchingStream() {
            return this.watchingStream;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final StreamContext getStreamContext() {
            return this.streamContext;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final boolean getIsBooster() {
            return this.isBooster;
        }

        public final VoiceUser copy(User user, VoiceState voiceState, boolean isRinging, StoreVideoStreams.UserStreams streams, boolean isMe, GuildMember guildMember, String watchingStream, StreamContext streamContext, boolean isBooster, StoreMediaSettings.VoiceConfiguration voiceConfiguration, boolean _isSpeaking) {
            Intrinsics3.checkNotNullParameter(user, "user");
            return new VoiceUser(user, voiceState, isRinging, streams, isMe, guildMember, watchingStream, streamContext, isBooster, voiceConfiguration, _isSpeaking);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VoiceUser)) {
                return false;
            }
            VoiceUser voiceUser = (VoiceUser) other;
            return Intrinsics3.areEqual(this.user, voiceUser.user) && Intrinsics3.areEqual(this.voiceState, voiceUser.voiceState) && this.isRinging == voiceUser.isRinging && Intrinsics3.areEqual(this.streams, voiceUser.streams) && this.isMe == voiceUser.isMe && Intrinsics3.areEqual(this.guildMember, voiceUser.guildMember) && Intrinsics3.areEqual(this.watchingStream, voiceUser.watchingStream) && Intrinsics3.areEqual(this.streamContext, voiceUser.streamContext) && this.isBooster == voiceUser.isBooster && Intrinsics3.areEqual(this.voiceConfiguration, voiceUser.voiceConfiguration) && this._isSpeaking == voiceUser._isSpeaking;
        }

        public final ModelApplicationStream getApplicationStream() {
            return this.applicationStream;
        }

        public final Integer getApplicationStreamId() {
            return this.applicationStreamId;
        }

        public final Integer getCallStreamId() {
            return this.callStreamId;
        }

        public final String getDisplayName() {
            String str = this.nickname;
            return str != null ? str : this.user.getUsername();
        }

        public final GuildMember getGuildMember() {
            return this.guildMember;
        }

        public final String getNickname() {
            return this.nickname;
        }

        public final StreamContext getStreamContext() {
            return this.streamContext;
        }

        public final StoreVideoStreams.UserStreams getStreams() {
            return this.streams;
        }

        public final User getUser() {
            return this.user;
        }

        public final VoiceState getVoiceState() {
            return this.voiceState;
        }

        public final String getWatchingStream() {
            return this.watchingStream;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v20, types: [int] */
        /* JADX WARN: Type inference failed for: r2v22 */
        /* JADX WARN: Type inference failed for: r2v26 */
        /* JADX WARN: Type inference failed for: r2v28 */
        /* JADX WARN: Type inference failed for: r2v30 */
        /* JADX WARN: Type inference failed for: r2v31 */
        /* JADX WARN: Type inference failed for: r2v32 */
        /* JADX WARN: Type inference failed for: r2v4, types: [int] */
        /* JADX WARN: Type inference failed for: r2v9, types: [int] */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1, types: [int] */
        /* JADX WARN: Type inference failed for: r3v2 */
        public int hashCode() {
            User user = this.user;
            int iHashCode = (user != null ? user.hashCode() : 0) * 31;
            VoiceState voiceState = this.voiceState;
            int iHashCode2 = (iHashCode + (voiceState != null ? voiceState.hashCode() : 0)) * 31;
            boolean z2 = this.isRinging;
            ?? r2 = z2;
            if (z2) {
                r2 = 1;
            }
            int i = (iHashCode2 + r2) * 31;
            StoreVideoStreams.UserStreams userStreams = this.streams;
            int iHashCode3 = (i + (userStreams != null ? userStreams.hashCode() : 0)) * 31;
            boolean z3 = this.isMe;
            ?? r22 = z3;
            if (z3) {
                r22 = 1;
            }
            int i2 = (iHashCode3 + r22) * 31;
            GuildMember guildMember = this.guildMember;
            int iHashCode4 = (i2 + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
            String str = this.watchingStream;
            int iHashCode5 = (iHashCode4 + (str != null ? str.hashCode() : 0)) * 31;
            StreamContext streamContext = this.streamContext;
            int iHashCode6 = (iHashCode5 + (streamContext != null ? streamContext.hashCode() : 0)) * 31;
            boolean z4 = this.isBooster;
            ?? r23 = z4;
            if (z4) {
                r23 = 1;
            }
            int i3 = (iHashCode6 + r23) * 31;
            StoreMediaSettings.VoiceConfiguration voiceConfiguration = this.voiceConfiguration;
            int iHashCode7 = (i3 + (voiceConfiguration != null ? voiceConfiguration.hashCode() : 0)) * 31;
            boolean z5 = this._isSpeaking;
            return iHashCode7 + (z5 ? 1 : z5);
        }

        public final boolean isBooster() {
            return this.isBooster;
        }

        public final boolean isConnected() {
            return this.voiceState != null;
        }

        /* JADX INFO: renamed from: isDeafened, reason: from getter */
        public final boolean getIsDeafened() {
            return this.isDeafened;
        }

        /* JADX INFO: renamed from: isInvitedToSpeak, reason: from getter */
        public final boolean getIsInvitedToSpeak() {
            return this.isInvitedToSpeak;
        }

        public final boolean isMe() {
            return this.isMe;
        }

        /* JADX INFO: renamed from: isMuted, reason: from getter */
        public final boolean getIsMuted() {
            return this.isMuted;
        }

        /* JADX INFO: renamed from: isRequestingToSpeak, reason: from getter */
        public final boolean getIsRequestingToSpeak() {
            return this.isRequestingToSpeak;
        }

        public final boolean isRinging() {
            return this.isRinging;
        }

        /* JADX INFO: renamed from: isSpeaking, reason: from getter */
        public final boolean getIsSpeaking() {
            return this.isSpeaking;
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("VoiceUser(user=");
            sbM833U.append(this.user);
            sbM833U.append(", voiceState=");
            sbM833U.append(this.voiceState);
            sbM833U.append(", isRinging=");
            sbM833U.append(this.isRinging);
            sbM833U.append(", streams=");
            sbM833U.append(this.streams);
            sbM833U.append(", isMe=");
            sbM833U.append(this.isMe);
            sbM833U.append(", guildMember=");
            sbM833U.append(this.guildMember);
            sbM833U.append(", watchingStream=");
            sbM833U.append(this.watchingStream);
            sbM833U.append(", streamContext=");
            sbM833U.append(this.streamContext);
            sbM833U.append(", isBooster=");
            sbM833U.append(this.isBooster);
            sbM833U.append(", voiceConfiguration=");
            sbM833U.append(this.voiceConfiguration);
            sbM833U.append(", _isSpeaking=");
            return outline.m827O(sbM833U, this._isSpeaking, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreVoiceParticipants$get$1 */
    /* JADX INFO: compiled from: StoreVoiceParticipants.kt */
    public static final class C66231<T, R> implements Func1<Channel, Observable<? extends Map<Long, ? extends VoiceUser>>> {
        public final /* synthetic */ long $channelId;

        /* JADX INFO: renamed from: com.discord.stores.StoreVoiceParticipants$get$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreVoiceParticipants.kt */
        public static final class AnonymousClass1<T, R> implements Func1<Map<Long, ? extends VoiceState>, Observable<? extends Map<Long, ? extends VoiceUser>>> {
            public final /* synthetic */ Channel $channel;
            public final /* synthetic */ long $guildId;

            /* JADX INFO: renamed from: com.discord.stores.StoreVoiceParticipants$get$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: StoreVoiceParticipants.kt */
            public static final class C132671<T1, T2, R> implements Func2<MeUser, Collection<? extends User>, Tuples2<? extends MeUser, ? extends Collection<? extends User>>> {
                public static final C132671 INSTANCE = new C132671();

                @Override // p658rx.functions.Func2
                public /* bridge */ /* synthetic */ Tuples2<? extends MeUser, ? extends Collection<? extends User>> call(MeUser meUser, Collection<? extends User> collection) {
                    return call2(meUser, collection);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final Tuples2<MeUser, Collection<User>> call2(MeUser meUser, Collection<? extends User> collection) {
                    return Tuples.m10073to(meUser, collection);
                }
            }

            /* JADX INFO: renamed from: com.discord.stores.StoreVoiceParticipants$get$1$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: StoreVoiceParticipants.kt */
            public static final class AnonymousClass2<T, R> implements Func1<Tuples2<? extends MeUser, ? extends Collection<? extends User>>, Observable<? extends Map<Long, ? extends VoiceUser>>> {
                public final /* synthetic */ Map $voiceStates;

                /* JADX INFO: renamed from: com.discord.stores.StoreVoiceParticipants$get$1$1$2$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: StoreVoiceParticipants.kt */
                public static final class C132681<T, R> implements Func1<ModelCall, List<? extends Long>> {
                    public static final C132681 INSTANCE = new C132681();

                    @Override // p637j0.p641k.Func1
                    public /* bridge */ /* synthetic */ List<? extends Long> call(ModelCall modelCall) {
                        return call2(modelCall);
                    }

                    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                    public final List<Long> call2(ModelCall modelCall) {
                        List<Long> ringing;
                        return (modelCall == null || (ringing = modelCall.getRinging()) == null) ? Collections2.emptyList() : ringing;
                    }
                }

                /* JADX INFO: renamed from: com.discord.stores.StoreVoiceParticipants$get$1$1$2$2, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: StoreVoiceParticipants.kt */
                public static final class C132692<T1, T2, T3, T4, T5, T6, T7, R> implements Func7<Set<? extends Long>, List<? extends Long>, Map<Long, ? extends StoreVideoStreams.UserStreams>, Map<Long, ? extends GuildMember>, Map<String, ? extends List<? extends Long>>, StoreMediaSettings.VoiceConfiguration, Map<Long, ? extends StreamContext>, Map<Long, ? extends VoiceUser>> {
                    public final /* synthetic */ MeUser $meUser;
                    public final /* synthetic */ Collection $otherUsers;

                    public C132692(MeUser meUser, Collection collection) {
                        this.$meUser = meUser;
                        this.$otherUsers = collection;
                    }

                    @Override // p658rx.functions.Func7
                    public /* bridge */ /* synthetic */ Map<Long, ? extends VoiceUser> call(Set<? extends Long> set, List<? extends Long> list, Map<Long, ? extends StoreVideoStreams.UserStreams> map, Map<Long, ? extends GuildMember> map2, Map<String, ? extends List<? extends Long>> map3, StoreMediaSettings.VoiceConfiguration voiceConfiguration, Map<Long, ? extends StreamContext> map4) {
                        return call2((Set<Long>) set, (List<Long>) list, (Map<Long, StoreVideoStreams.UserStreams>) map, (Map<Long, GuildMember>) map2, (Map<String, ? extends List<Long>>) map3, voiceConfiguration, (Map<Long, StreamContext>) map4);
                    }

                    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                    public final Map<Long, VoiceUser> call2(Set<Long> set, List<Long> list, Map<Long, StoreVideoStreams.UserStreams> map, Map<Long, GuildMember> map2, Map<String, ? extends List<Long>> map3, StoreMediaSettings.VoiceConfiguration voiceConfiguration, Map<Long, StreamContext> map4) {
                        StoreVoiceParticipants storeVoiceParticipants = StoreVoiceParticipants.this;
                        MeUser meUser = this.$meUser;
                        Intrinsics3.checkNotNullExpressionValue(meUser, "meUser");
                        Collection collection = this.$otherUsers;
                        Intrinsics3.checkNotNullExpressionValue(collection, "otherUsers");
                        Map map5 = AnonymousClass2.this.$voiceStates;
                        Intrinsics3.checkNotNullExpressionValue(map5, "voiceStates");
                        Intrinsics3.checkNotNullExpressionValue(set, "speakingUsers");
                        Intrinsics3.checkNotNullExpressionValue(list, "ringingUsers");
                        Intrinsics3.checkNotNullExpressionValue(map, "videoStreams");
                        Intrinsics3.checkNotNullExpressionValue(map2, "guildMembers");
                        Intrinsics3.checkNotNullExpressionValue(map3, "streamSpectators");
                        Intrinsics3.checkNotNullExpressionValue(voiceConfiguration, "voiceConfig");
                        Intrinsics3.checkNotNullExpressionValue(map4, "streamContexts");
                        return StoreVoiceParticipants.access$create(storeVoiceParticipants, meUser, collection, map5, set, list, map, map2, map3, voiceConfiguration, map4);
                    }
                }

                public AnonymousClass2(Map map) {
                    this.$voiceStates = map;
                }

                @Override // p637j0.p641k.Func1
                public /* bridge */ /* synthetic */ Observable<? extends Map<Long, ? extends VoiceUser>> call(Tuples2<? extends MeUser, ? extends Collection<? extends User>> tuples2) {
                    return call2((Tuples2<MeUser, ? extends Collection<? extends User>>) tuples2);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final Observable<? extends Map<Long, VoiceUser>> call2(Tuples2<MeUser, ? extends Collection<? extends User>> tuples2) {
                    MeUser meUserComponent1 = tuples2.component1();
                    Collection<? extends User> collectionComponent2 = tuples2.component2();
                    Intrinsics3.checkNotNullExpressionValue(collectionComponent2, "otherUsers");
                    ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(collectionComponent2, 10));
                    Iterator<T> it = collectionComponent2.iterator();
                    while (it.hasNext()) {
                        arrayList.add(Long.valueOf(((User) it.next()).getId()));
                    }
                    return Observable.m11069e(ObservableExtensionsKt.leadingEdgeThrottle(StoreVoiceParticipants.this.getStream().getVoiceSpeaking().observeSpeakingUsers(), 250L, TimeUnit.MILLISECONDS), StoreVoiceParticipants.this.getStream().getCalls().get(C66231.this.$channelId).m11083G(C132681.INSTANCE), StoreVoiceParticipants.this.getStream().getVideoStreams().observeUserStreams(), ObservableExtensionsKt.leadingEdgeThrottle(StoreVoiceParticipants.this.getStream().getGuilds().observeComputed(AnonymousClass1.this.$guildId), 1L, TimeUnit.SECONDS), StoreVoiceParticipants.this.getStream().getApplicationStreaming().observeStreamSpectators(), StoreVoiceParticipants.this.getStream().getMediaSettings().getVoiceConfig(), StoreVoiceParticipants.access$getStreamContextsForUsers(StoreVoiceParticipants.this, _Collections.plus((Collection<? extends Long>) arrayList, Long.valueOf(meUserComponent1.getId()))), new C132692(meUserComponent1, collectionComponent2));
                }
            }

            public AnonymousClass1(Channel channel, long j) {
                this.$channel = channel;
                this.$guildId = j;
            }

            @Override // p637j0.p641k.Func1
            public /* bridge */ /* synthetic */ Observable<? extends Map<Long, ? extends VoiceUser>> call(Map<Long, ? extends VoiceState> map) {
                return call2((Map<Long, VoiceState>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Observable<? extends Map<Long, VoiceUser>> call2(Map<Long, VoiceState> map) {
                Observable observableObserveMe$default = StoreUser.observeMe$default(StoreVoiceParticipants.this.getStream().getUsers(), false, 1, null);
                StoreVoiceParticipants storeVoiceParticipants = StoreVoiceParticipants.this;
                Channel channel = this.$channel;
                Intrinsics3.checkNotNullExpressionValue(map, "voiceStates");
                return Observable.m11076j(observableObserveMe$default, StoreVoiceParticipants.access$getOtherVoiceUsers(storeVoiceParticipants, channel, map), C132671.INSTANCE).m11099Y(new AnonymousClass2(map));
            }
        }

        public C66231(long j) {
            this.$channelId = j;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Map<Long, ? extends VoiceUser>> call(Channel channel) {
            return call2(channel);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Map<Long, VoiceUser>> call2(Channel channel) {
            if (channel == null) {
                return new ScalarSynchronousObservable(Maps6.emptyMap());
            }
            long guildId = ChannelUtils.m7667B(channel) ? 0L : channel.getGuildId();
            return StoreVoiceParticipants.this.getStream().getVoiceStates().observe(guildId, channel.getId()).m11099Y(new AnonymousClass1(channel, guildId));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreVoiceParticipants$getOtherVoiceUsers$1 */
    /* JADX INFO: compiled from: StoreVoiceParticipants.kt */
    public static final class C66241<T, R> implements Func1<Long, Observable<? extends Collection<? extends User>>> {
        public final /* synthetic */ Channel $channel;
        public final /* synthetic */ Map $voiceStates;

        /* JADX INFO: renamed from: com.discord.stores.StoreVoiceParticipants$getOtherVoiceUsers$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreVoiceParticipants.kt */
        public static final class AnonymousClass1<T, R> implements Func1<Map<Long, ? extends GuildMember>, Set<? extends Long>> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            @Override // p637j0.p641k.Func1
            public /* bridge */ /* synthetic */ Set<? extends Long> call(Map<Long, ? extends GuildMember> map) {
                return call2((Map<Long, GuildMember>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Set<Long> call2(Map<Long, GuildMember> map) {
                return map.keySet();
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreVoiceParticipants$getOtherVoiceUsers$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: StoreVoiceParticipants.kt */
        public static final class AnonymousClass2<T, R> implements Func1<Set<? extends Long>, List<? extends Long>> {
            public final /* synthetic */ Long $meId;

            public AnonymousClass2(Long l) {
                this.$meId = l;
            }

            @Override // p637j0.p641k.Func1
            public /* bridge */ /* synthetic */ List<? extends Long> call(Set<? extends Long> set) {
                return call2((Set<Long>) set);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final List<Long> call2(Set<Long> set) {
                Intrinsics3.checkNotNullExpressionValue(set, "memberIds");
                ArrayList arrayList = new ArrayList();
                for (T t : set) {
                    long jLongValue = ((Number) t).longValue();
                    Long l = this.$meId;
                    if ((l == null || jLongValue != l.longValue()) && C66241.this.$voiceStates.containsKey(Long.valueOf(jLongValue))) {
                        arrayList.add(t);
                    }
                }
                return arrayList;
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreVoiceParticipants$getOtherVoiceUsers$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: StoreVoiceParticipants.kt */
        public static final class AnonymousClass3<T, R> implements Func1<List<? extends Long>, Observable<? extends Collection<? extends User>>> {

            /* JADX INFO: renamed from: com.discord.stores.StoreVoiceParticipants$getOtherVoiceUsers$1$3$1, reason: invalid class name */
            /* JADX INFO: compiled from: StoreVoiceParticipants.kt */
            public static final class AnonymousClass1<T> implements Action1<Map<Long, ? extends User>> {
                public AnonymousClass1() {
                }

                @Override // p658rx.functions.Action1
                public /* bridge */ /* synthetic */ void call(Map<Long, ? extends User> map) {
                    call2(map);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final void call2(Map<Long, ? extends User> map) {
                    StoreStream.Companion companion = StoreStream.INSTANCE;
                    StageInstance stageInstanceForChannel = companion.getStageInstances().getStageInstanceForChannel(C66241.this.$channel.getId());
                    if ((stageInstanceForChannel != null ? stageInstanceForChannel.getPrivacyLevel() : null) == StageInstancePrivacyLevel.PUBLIC) {
                        StoreGuildMemberRequester guildMemberRequester = companion.getGuildMemberRequester();
                        Iterator it = C66241.this.$voiceStates.keySet().iterator();
                        while (it.hasNext()) {
                            long jLongValue = ((Number) it.next()).longValue();
                            Intrinsics3.checkNotNullExpressionValue(map, "otherUsers");
                            if (!map.containsKey(Long.valueOf(jLongValue))) {
                                guildMemberRequester.queueRequest(C66241.this.$channel.getGuildId(), jLongValue);
                            }
                        }
                        guildMemberRequester.performQueuedRequests();
                    }
                }
            }

            /* JADX INFO: renamed from: com.discord.stores.StoreVoiceParticipants$getOtherVoiceUsers$1$3$2, reason: invalid class name */
            /* JADX INFO: compiled from: StoreVoiceParticipants.kt */
            public static final class AnonymousClass2<T, R> implements Func1<Map<Long, ? extends User>, Collection<? extends User>> {
                public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

                @Override // p637j0.p641k.Func1
                public /* bridge */ /* synthetic */ Collection<? extends User> call(Map<Long, ? extends User> map) {
                    return call2(map);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final Collection<User> call2(Map<Long, ? extends User> map) {
                    return map.values();
                }
            }

            public AnonymousClass3() {
            }

            @Override // p637j0.p641k.Func1
            public /* bridge */ /* synthetic */ Observable<? extends Collection<? extends User>> call(List<? extends Long> list) {
                return call2((List<Long>) list);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Observable<? extends Collection<User>> call2(List<Long> list) {
                StoreUser users = StoreStream.INSTANCE.getUsers();
                Intrinsics3.checkNotNullExpressionValue(list, "otherMemberIds");
                return users.observeUsers(list).m11115u(new AnonymousClass1()).m11083G(AnonymousClass2.INSTANCE);
            }
        }

        public C66241(Channel channel, Map map) {
            this.$channel = channel;
            this.$voiceStates = map;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Collection<? extends User>> call(Long l) {
            return call2(l);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Collection<User>> call2(Long l) {
            return StoreStream.INSTANCE.getGuilds().observeComputed(this.$channel.getGuildId()).m11083G(AnonymousClass1.INSTANCE).m11083G(new AnonymousClass2(l)).m11099Y(new AnonymousClass3());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreVoiceParticipants$getStreamContextsForUsers$1 */
    /* JADX INFO: compiled from: StoreVoiceParticipants.kt */
    public static final class C66251<R> implements FuncN<Map<Long, ? extends StreamContext>> {
        public final /* synthetic */ List $userIds;

        public C66251(List list) {
            this.$userIds = list;
        }

        @Override // p658rx.functions.FuncN
        public /* bridge */ /* synthetic */ Map<Long, ? extends StreamContext> call(Object[] objArr) {
            return call2(objArr);
        }

        @Override // p658rx.functions.FuncN
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends StreamContext> call2(Object[] objArr) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int i = 0;
            for (Object obj : this.$userIds) {
                int i2 = i + 1;
                if (i < 0) {
                    Collections2.throwIndexOverflow();
                }
                linkedHashMap.put(Long.valueOf(((Number) obj).longValue()), (StreamContext) objArr[i]);
                i = i2;
            }
            return linkedHashMap;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreVoiceParticipants$init$1 */
    /* JADX INFO: compiled from: StoreVoiceParticipants.kt */
    public static final class C66261 extends Lambda implements Function1<Long, Unit> {
        public C66261() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.f27425a;
        }

        public final void invoke(long j) {
            StoreVoiceParticipants.this.selectParticipant(null);
        }
    }

    public StoreVoiceParticipants(StoreStream storeStream) {
        Intrinsics3.checkNotNullParameter(storeStream, "stream");
        this.stream = storeStream;
        this.selectedParticipantSubject = BehaviorSubject.m11130l0(0L);
    }

    public static final /* synthetic */ Map access$create(StoreVoiceParticipants storeVoiceParticipants, MeUser meUser, Collection collection, Map map, Set set, Collection collection2, Map map2, Map map3, Map map4, StoreMediaSettings.VoiceConfiguration voiceConfiguration, Map map5) {
        return storeVoiceParticipants.create(meUser, collection, map, set, collection2, map2, map3, map4, voiceConfiguration, map5);
    }

    public static final /* synthetic */ Observable access$getOtherVoiceUsers(StoreVoiceParticipants storeVoiceParticipants, Channel channel, Map map) {
        return storeVoiceParticipants.getOtherVoiceUsers(channel, map);
    }

    public static final /* synthetic */ Observable access$getStreamContextsForUsers(StoreVoiceParticipants storeVoiceParticipants, List list) {
        return storeVoiceParticipants.getStreamContextsForUsers(list);
    }

    private final Map<Long, VoiceUser> create(MeUser meUser, Collection<? extends User> otherUsers, Map<Long, VoiceState> voiceStates, Set<Long> speakingUsers, Collection<Long> ringingUsers, Map<Long, StoreVideoStreams.UserStreams> videoStreams, Map<Long, GuildMember> guildMembers, Map<String, ? extends List<Long>> streamSpectators, StoreMediaSettings.VoiceConfiguration voiceConfiguration, Map<Long, StreamContext> streamContexts) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry<String, ? extends List<Long>> entry : streamSpectators.entrySet()) {
            if (entry.getValue().contains(Long.valueOf(meUser.getId()))) {
                linkedHashMap2.put(entry.getKey(), entry.getValue());
            }
        }
        ArrayList arrayList = new ArrayList(linkedHashMap2.size());
        Iterator it = linkedHashMap2.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add((String) ((Map.Entry) it.next()).getKey());
        }
        String str = (String) _Collections.firstOrNull((List) arrayList);
        VoiceState voiceState = voiceStates.get(Long.valueOf(meUser.getId()));
        boolean zContains = ringingUsers.contains(Long.valueOf(meUser.getId()));
        StoreVideoStreams.UserStreams userStreams = videoStreams.get(Long.valueOf(meUser.getId()));
        GuildMember guildMember = guildMembers.get(Long.valueOf(meUser.getId()));
        GuildMember guildMember2 = guildMembers.get(Long.valueOf(meUser.getId()));
        linkedHashMap.put(Long.valueOf(meUser.getId()), new VoiceUser(meUser, voiceState, zContains, userStreams, true, guildMember, str, null, (guildMember2 != null ? guildMember2.getPremiumSince() : null) != null, voiceConfiguration, speakingUsers.contains(Long.valueOf(meUser.getId()))));
        ArrayList<VoiceUser> arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(otherUsers, 10));
        for (User user : otherUsers) {
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            for (Map.Entry<String, ? extends List<Long>> entry2 : streamSpectators.entrySet()) {
                if (entry2.getValue().contains(Long.valueOf(user.getId()))) {
                    linkedHashMap3.put(entry2.getKey(), entry2.getValue());
                }
            }
            ArrayList arrayList3 = new ArrayList(linkedHashMap3.size());
            Iterator it2 = linkedHashMap3.entrySet().iterator();
            while (it2.hasNext()) {
                arrayList3.add((String) ((Map.Entry) it2.next()).getKey());
            }
            String str2 = (String) _Collections.firstOrNull((List) arrayList3);
            VoiceState voiceState2 = (VoiceState) outline.m849f(user, voiceStates);
            boolean zContains2 = ringingUsers.contains(Long.valueOf(user.getId()));
            StoreVideoStreams.UserStreams userStreams2 = (StoreVideoStreams.UserStreams) outline.m849f(user, videoStreams);
            GuildMember guildMember3 = (GuildMember) outline.m849f(user, guildMembers);
            StreamContext streamContext = (StreamContext) outline.m849f(user, streamContexts);
            GuildMember guildMember4 = (GuildMember) outline.m849f(user, guildMembers);
            arrayList2.add(new VoiceUser(user, voiceState2, zContains2, userStreams2, false, guildMember3, str2, streamContext, (guildMember4 != null ? guildMember4.getPremiumSince() : null) != null, voiceConfiguration, speakingUsers.contains(Long.valueOf(user.getId()))));
        }
        for (VoiceUser voiceUser : arrayList2) {
            linkedHashMap.put(Long.valueOf(voiceUser.getUser().getId()), voiceUser);
        }
        return linkedHashMap;
    }

    private final Observable<Collection<User>> getOtherVoiceUsers(Channel channel, Map<Long, VoiceState> voiceStates) {
        if (ChannelUtils.m7667B(channel)) {
            ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(ChannelUtils.m7683g(channel));
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(channel.getRecipients())");
            return scalarSynchronousObservable;
        }
        if (ChannelUtils.m7699w(channel)) {
            Observable observableM11099Y = StoreStream.INSTANCE.getUsers().observeMeId().m11099Y(new C66241(channel, voiceStates));
            Intrinsics3.checkNotNullExpressionValue(observableM11099Y, "StoreStream\n            …          }\n            }");
            return observableM11099Y;
        }
        ScalarSynchronousObservable scalarSynchronousObservable2 = new ScalarSynchronousObservable(Collections2.emptyList());
        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable2, "Observable.just(emptyList())");
        return scalarSynchronousObservable2;
    }

    private final Observable<Map<Long, StreamContext>> getStreamContextsForUsers(List<Long> userIds) {
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(userIds, 10));
        for (Iterator it = userIds.iterator(); it.hasNext(); it = it) {
            arrayList.add(new StreamContextService(null, null, null, null, null, null, null, null, 255, null).getForUser(((Number) it.next()).longValue(), true));
        }
        Observable<Map<Long, StreamContext>> observableM11065b = Observable.m11065b(arrayList, new C66251(userIds));
        Intrinsics3.checkNotNullExpressionValue(observableM11065b, "Observable\n        .comb…}\n          map\n        }");
        return observableM11065b;
    }

    public final Observable<Map<Long, VoiceUser>> get(long channelId) {
        Observable<R> observableM11099Y = StoreStream.INSTANCE.getChannels().observeChannel(channelId).m11099Y(new C66231(channelId));
        Intrinsics3.checkNotNullExpressionValue(observableM11099Y, "StoreStream\n        .get…  }\n          }\n        }");
        Observable<Map<Long, VoiceUser>> observableM11112r = ObservableExtensionsKt.computationLatest(observableM11099Y).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "StoreStream\n        .get…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final StoreStream getStream() {
        return this.stream;
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        super.init(context);
        ObservableExtensionsKt.appSubscribe$default(this.stream.getVoiceChannelSelected().observeSelectedVoiceChannelId(), StoreVoiceParticipants.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C66261(), 62, (Object) null);
    }

    public final void selectParticipant(Long userId) {
        this.selectedParticipantSubject.onNext(userId);
    }
}
