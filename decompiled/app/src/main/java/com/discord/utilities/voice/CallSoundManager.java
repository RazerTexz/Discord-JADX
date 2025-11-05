package com.discord.utilities.voice;

import android.content.Context;
import androidx.annotation.MainThread;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppComponent;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.user.MeUser;
import com.discord.rtcconnection.RtcConnection;
import com.discord.stores.StoreApplicationStreaming;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreRtcConnection;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.media.AppSound;
import com.discord.utilities.media.AppSoundManager;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.n;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

/* compiled from: CallSoundManager.kt */
/* loaded from: classes2.dex */
public final class CallSoundManager {
    private static final int JOIN_LEAVE_USER_LIMIT = 25;
    private String activeStreamKey;
    private Long activeStreamUserId;
    private int activeStreamViewerCount;
    private final AppComponent appComponent;
    private final AppSoundManager appSoundManager;
    private int numConnectedParticipants;
    private final IStoreStateGenerator storeStateGenerator;
    private Subscription storeStateSubscription;
    private List<Long> streamingUserIds;
    private Long voiceChannelId;

    /* compiled from: CallSoundManager.kt */
    public interface IStoreStateGenerator {
        Observable<StoreState> observeStoreState(long voiceChannelId);
    }

    /* compiled from: CallSoundManager.kt */
    public static final /* data */ class StoreState {
        private final StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream;
        private final MeUser me;
        private final RtcConnection.State rtcConnectionState;
        private final Channel selectedVoiceChannel;
        private final Map<String, List<Long>> streamSpectators;
        private final Map<Long, ModelApplicationStream> streamsByUser;
        private final Map<Long, StoreVoiceParticipants.VoiceUser> voiceParticipants;

        /* JADX WARN: Multi-variable type inference failed */
        public StoreState(Map<Long, StoreVoiceParticipants.VoiceUser> map, RtcConnection.State state, Map<Long, ? extends ModelApplicationStream> map2, Map<String, ? extends List<Long>> map3, StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream, MeUser meUser, Channel channel) {
            m.checkNotNullParameter(map, "voiceParticipants");
            m.checkNotNullParameter(state, "rtcConnectionState");
            m.checkNotNullParameter(map2, "streamsByUser");
            m.checkNotNullParameter(map3, "streamSpectators");
            m.checkNotNullParameter(meUser, "me");
            this.voiceParticipants = map;
            this.rtcConnectionState = state;
            this.streamsByUser = map2;
            this.streamSpectators = map3;
            this.activeApplicationStream = activeApplicationStream;
            this.me = meUser;
            this.selectedVoiceChannel = channel;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, Map map, RtcConnection.State state, Map map2, Map map3, StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream, MeUser meUser, Channel channel, int i, Object obj) {
            if ((i & 1) != 0) {
                map = storeState.voiceParticipants;
            }
            if ((i & 2) != 0) {
                state = storeState.rtcConnectionState;
            }
            RtcConnection.State state2 = state;
            if ((i & 4) != 0) {
                map2 = storeState.streamsByUser;
            }
            Map map4 = map2;
            if ((i & 8) != 0) {
                map3 = storeState.streamSpectators;
            }
            Map map5 = map3;
            if ((i & 16) != 0) {
                activeApplicationStream = storeState.activeApplicationStream;
            }
            StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream2 = activeApplicationStream;
            if ((i & 32) != 0) {
                meUser = storeState.me;
            }
            MeUser meUser2 = meUser;
            if ((i & 64) != 0) {
                channel = storeState.selectedVoiceChannel;
            }
            return storeState.copy(map, state2, map4, map5, activeApplicationStream2, meUser2, channel);
        }

        public final Map<Long, StoreVoiceParticipants.VoiceUser> component1() {
            return this.voiceParticipants;
        }

        /* renamed from: component2, reason: from getter */
        public final RtcConnection.State getRtcConnectionState() {
            return this.rtcConnectionState;
        }

        public final Map<Long, ModelApplicationStream> component3() {
            return this.streamsByUser;
        }

        public final Map<String, List<Long>> component4() {
            return this.streamSpectators;
        }

        /* renamed from: component5, reason: from getter */
        public final StoreApplicationStreaming.ActiveApplicationStream getActiveApplicationStream() {
            return this.activeApplicationStream;
        }

        /* renamed from: component6, reason: from getter */
        public final MeUser getMe() {
            return this.me;
        }

        /* renamed from: component7, reason: from getter */
        public final Channel getSelectedVoiceChannel() {
            return this.selectedVoiceChannel;
        }

        public final StoreState copy(Map<Long, StoreVoiceParticipants.VoiceUser> voiceParticipants, RtcConnection.State rtcConnectionState, Map<Long, ? extends ModelApplicationStream> streamsByUser, Map<String, ? extends List<Long>> streamSpectators, StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream, MeUser me2, Channel selectedVoiceChannel) {
            m.checkNotNullParameter(voiceParticipants, "voiceParticipants");
            m.checkNotNullParameter(rtcConnectionState, "rtcConnectionState");
            m.checkNotNullParameter(streamsByUser, "streamsByUser");
            m.checkNotNullParameter(streamSpectators, "streamSpectators");
            m.checkNotNullParameter(me2, "me");
            return new StoreState(voiceParticipants, rtcConnectionState, streamsByUser, streamSpectators, activeApplicationStream, me2, selectedVoiceChannel);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return m.areEqual(this.voiceParticipants, storeState.voiceParticipants) && m.areEqual(this.rtcConnectionState, storeState.rtcConnectionState) && m.areEqual(this.streamsByUser, storeState.streamsByUser) && m.areEqual(this.streamSpectators, storeState.streamSpectators) && m.areEqual(this.activeApplicationStream, storeState.activeApplicationStream) && m.areEqual(this.me, storeState.me) && m.areEqual(this.selectedVoiceChannel, storeState.selectedVoiceChannel);
        }

        public final StoreApplicationStreaming.ActiveApplicationStream getActiveApplicationStream() {
            return this.activeApplicationStream;
        }

        public final MeUser getMe() {
            return this.me;
        }

        public final RtcConnection.State getRtcConnectionState() {
            return this.rtcConnectionState;
        }

        public final Channel getSelectedVoiceChannel() {
            return this.selectedVoiceChannel;
        }

        public final Map<String, List<Long>> getStreamSpectators() {
            return this.streamSpectators;
        }

        public final Map<Long, ModelApplicationStream> getStreamsByUser() {
            return this.streamsByUser;
        }

        public final Map<Long, StoreVoiceParticipants.VoiceUser> getVoiceParticipants() {
            return this.voiceParticipants;
        }

        public int hashCode() {
            Map<Long, StoreVoiceParticipants.VoiceUser> map = this.voiceParticipants;
            int iHashCode = (map != null ? map.hashCode() : 0) * 31;
            RtcConnection.State state = this.rtcConnectionState;
            int iHashCode2 = (iHashCode + (state != null ? state.hashCode() : 0)) * 31;
            Map<Long, ModelApplicationStream> map2 = this.streamsByUser;
            int iHashCode3 = (iHashCode2 + (map2 != null ? map2.hashCode() : 0)) * 31;
            Map<String, List<Long>> map3 = this.streamSpectators;
            int iHashCode4 = (iHashCode3 + (map3 != null ? map3.hashCode() : 0)) * 31;
            StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream = this.activeApplicationStream;
            int iHashCode5 = (iHashCode4 + (activeApplicationStream != null ? activeApplicationStream.hashCode() : 0)) * 31;
            MeUser meUser = this.me;
            int iHashCode6 = (iHashCode5 + (meUser != null ? meUser.hashCode() : 0)) * 31;
            Channel channel = this.selectedVoiceChannel;
            return iHashCode6 + (channel != null ? channel.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = a.U("StoreState(voiceParticipants=");
            sbU.append(this.voiceParticipants);
            sbU.append(", rtcConnectionState=");
            sbU.append(this.rtcConnectionState);
            sbU.append(", streamsByUser=");
            sbU.append(this.streamsByUser);
            sbU.append(", streamSpectators=");
            sbU.append(this.streamSpectators);
            sbU.append(", activeApplicationStream=");
            sbU.append(this.activeApplicationStream);
            sbU.append(", me=");
            sbU.append(this.me);
            sbU.append(", selectedVoiceChannel=");
            sbU.append(this.selectedVoiceChannel);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: CallSoundManager.kt */
    public static final class StoreStateGenerator implements IStoreStateGenerator {
        private final StoreApplicationStreaming storeApplicationStreaming;
        private final StoreChannels storeChannels;
        private final StoreRtcConnection storeRtcConnection;
        private final StoreUser storeUser;
        private final StoreVoiceParticipants storeVoiceParticipants;

        public StoreStateGenerator() {
            this(null, null, null, null, null, 31, null);
        }

        public StoreStateGenerator(StoreVoiceParticipants storeVoiceParticipants, StoreRtcConnection storeRtcConnection, StoreApplicationStreaming storeApplicationStreaming, StoreUser storeUser, StoreChannels storeChannels) {
            m.checkNotNullParameter(storeVoiceParticipants, "storeVoiceParticipants");
            m.checkNotNullParameter(storeRtcConnection, "storeRtcConnection");
            m.checkNotNullParameter(storeApplicationStreaming, "storeApplicationStreaming");
            m.checkNotNullParameter(storeUser, "storeUser");
            m.checkNotNullParameter(storeChannels, "storeChannels");
            this.storeVoiceParticipants = storeVoiceParticipants;
            this.storeRtcConnection = storeRtcConnection;
            this.storeApplicationStreaming = storeApplicationStreaming;
            this.storeUser = storeUser;
            this.storeChannels = storeChannels;
        }

        @Override // com.discord.utilities.voice.CallSoundManager.IStoreStateGenerator
        public Observable<StoreState> observeStoreState(long voiceChannelId) {
            Observable<StoreState> observableE = Observable.e(this.storeVoiceParticipants.get(voiceChannelId), this.storeRtcConnection.getConnectionState(), this.storeApplicationStreaming.observeStreamsByUser(), this.storeApplicationStreaming.observeStreamSpectators(), this.storeApplicationStreaming.observeActiveStream(), StoreUser.observeMe$default(this.storeUser, false, 1, null), this.storeChannels.observeChannel(voiceChannelId), CallSoundManager$StoreStateGenerator$observeStoreState$1.INSTANCE);
            m.checkNotNullExpressionValue(observableE, "Observable.combineLatest…Channel\n        )\n      }");
            return observableE;
        }

        public /* synthetic */ StoreStateGenerator(StoreVoiceParticipants storeVoiceParticipants, StoreRtcConnection storeRtcConnection, StoreApplicationStreaming storeApplicationStreaming, StoreUser storeUser, StoreChannels storeChannels, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? StoreStream.INSTANCE.getVoiceParticipants() : storeVoiceParticipants, (i & 2) != 0 ? StoreStream.INSTANCE.getRtcConnection() : storeRtcConnection, (i & 4) != 0 ? StoreStream.INSTANCE.getApplicationStreaming() : storeApplicationStreaming, (i & 8) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser, (i & 16) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels);
        }
    }

    /* compiled from: CallSoundManager.kt */
    /* renamed from: com.discord.utilities.voice.CallSoundManager$subscribeToStoreState$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Subscription, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            m.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            CallSoundManager.access$setStoreStateSubscription$p(CallSoundManager.this, subscription);
        }
    }

    /* compiled from: CallSoundManager.kt */
    /* renamed from: com.discord.utilities.voice.CallSoundManager$subscribeToStoreState$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function0<Unit> {
        public AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            CallSoundManager.access$getAppSoundManager$p(CallSoundManager.this).stop(AppSound.INSTANCE.getSOUND_CALL_CALLING());
        }
    }

    /* compiled from: CallSoundManager.kt */
    /* renamed from: com.discord.utilities.voice.CallSoundManager$subscribeToStoreState$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function1<StoreState, Unit> {
        public final /* synthetic */ long $voiceChannelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(long j) {
            super(1);
            this.$voiceChannelId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            CallSoundManager callSoundManager = CallSoundManager.this;
            long j = this.$voiceChannelId;
            m.checkNotNullExpressionValue(storeState, "storeState");
            CallSoundManager.access$handleStoreState(callSoundManager, j, storeState);
        }
    }

    public CallSoundManager(AppComponent appComponent, AppSoundManager appSoundManager, IStoreStateGenerator iStoreStateGenerator) {
        m.checkNotNullParameter(appComponent, "appComponent");
        m.checkNotNullParameter(appSoundManager, "appSoundManager");
        m.checkNotNullParameter(iStoreStateGenerator, "storeStateGenerator");
        this.appComponent = appComponent;
        this.appSoundManager = appSoundManager;
        this.storeStateGenerator = iStoreStateGenerator;
        this.streamingUserIds = n.emptyList();
    }

    public static final /* synthetic */ AppSoundManager access$getAppSoundManager$p(CallSoundManager callSoundManager) {
        return callSoundManager.appSoundManager;
    }

    public static final /* synthetic */ Subscription access$getStoreStateSubscription$p(CallSoundManager callSoundManager) {
        return callSoundManager.storeStateSubscription;
    }

    public static final /* synthetic */ void access$handleStoreState(CallSoundManager callSoundManager, long j, StoreState storeState) {
        callSoundManager.handleStoreState(j, storeState);
    }

    public static final /* synthetic */ void access$setStoreStateSubscription$p(CallSoundManager callSoundManager, Subscription subscription) {
        callSoundManager.storeStateSubscription = subscription;
    }

    @MainThread
    private final void handleStoreState(long channelId, StoreState storeState) {
        boolean z2;
        boolean z3;
        boolean z4;
        Channel selectedVoiceChannel;
        StoreApplicationStreaming.ActiveApplicationStream.State state;
        int size;
        Long l = this.voiceChannelId;
        List<Long> list = this.streamingUserIds;
        int i = this.activeStreamViewerCount;
        String str = this.activeStreamKey;
        Long l2 = this.activeStreamUserId;
        int i2 = this.numConnectedParticipants;
        this.voiceChannelId = Long.valueOf(channelId);
        Collection<ModelApplicationStream> collectionValues = storeState.getStreamsByUser().values();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = collectionValues.iterator();
        while (true) {
            z2 = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((ModelApplicationStream) next).getChannelId() == channelId) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(d0.t.o.collectionSizeOrDefault(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(Long.valueOf(((ModelApplicationStream) it2.next()).getOwnerId()));
        }
        this.streamingUserIds = arrayList2;
        StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream = storeState.getActiveApplicationStream();
        if (activeApplicationStream == null || (state = activeApplicationStream.getState()) == null || !state.isStreamActive()) {
            this.activeStreamKey = null;
            this.activeStreamUserId = null;
            this.activeStreamViewerCount = 0;
        } else {
            this.activeStreamKey = activeApplicationStream.getStream().getEncodedStreamKey();
            this.activeStreamUserId = Long.valueOf(activeApplicationStream.getStream().getOwnerId());
            List<Long> list2 = storeState.getStreamSpectators().get(this.activeStreamKey);
            if (list2 != null) {
                ArrayList arrayList3 = new ArrayList();
                for (Object obj : list2) {
                    if (((Number) obj).longValue() != storeState.getMe().getId()) {
                        arrayList3.add(obj);
                    }
                }
                size = arrayList3.size();
            } else {
                size = 0;
            }
            this.activeStreamViewerCount = size;
        }
        String str2 = this.activeStreamKey;
        boolean z5 = str2 != null && m.areEqual(str2, str);
        List<Long> list3 = this.streamingUserIds;
        if ((list3 instanceof Collection) && list3.isEmpty()) {
            z3 = false;
        } else {
            Iterator<T> it3 = list3.iterator();
            while (it3.hasNext()) {
                if (!list.contains(Long.valueOf(((Number) it3.next()).longValue()))) {
                    z3 = true;
                    break;
                }
            }
            z3 = false;
        }
        if ((list instanceof Collection) && list.isEmpty()) {
            z4 = false;
        } else {
            Iterator<T> it4 = list.iterator();
            while (it4.hasNext()) {
                long jLongValue = ((Number) it4.next()).longValue();
                if (!this.streamingUserIds.contains(Long.valueOf(jLongValue)) && (jLongValue == storeState.getMe().getId() || (l2 != null && jLongValue == l2.longValue()))) {
                    z4 = true;
                    break;
                }
            }
            z4 = false;
        }
        boolean z6 = z5 && i <= 25 && this.activeStreamViewerCount > i;
        if (z5 && i <= 25 && this.activeStreamViewerCount < i) {
            z2 = true;
        }
        if (m.areEqual(this.voiceChannelId, l)) {
            if (z3) {
                this.appSoundManager.play(AppSound.INSTANCE.getSOUND_STREAM_STARTED());
            } else if (z4) {
                this.appSoundManager.play(AppSound.INSTANCE.getSOUND_STREAM_ENDED());
            } else if (z6) {
                this.appSoundManager.play(AppSound.INSTANCE.getSOUND_STREAM_USER_JOINED());
            } else if (z2) {
                this.appSoundManager.play(AppSound.INSTANCE.getSOUND_STREAM_USER_LEFT());
            }
        }
        Map<Long, StoreVoiceParticipants.VoiceUser> voiceParticipants = storeState.getVoiceParticipants();
        boolean zAreEqual = m.areEqual(storeState.getRtcConnectionState(), RtcConnection.State.f.a);
        Collection<StoreVoiceParticipants.VoiceUser> collectionValues2 = voiceParticipants.values();
        ArrayList arrayList4 = new ArrayList();
        for (Object obj2 : collectionValues2) {
            if (((StoreVoiceParticipants.VoiceUser) obj2).isConnected()) {
                arrayList4.add(obj2);
            }
        }
        this.numConnectedParticipants = arrayList4.size();
        Collection<StoreVoiceParticipants.VoiceUser> collectionValues3 = voiceParticipants.values();
        ArrayList arrayList5 = new ArrayList();
        for (Object obj3 : collectionValues3) {
            if (((StoreVoiceParticipants.VoiceUser) obj3).isRinging()) {
                arrayList5.add(obj3);
            }
        }
        int size2 = arrayList5.size();
        if (zAreEqual && (selectedVoiceChannel = storeState.getSelectedVoiceChannel()) != null && ChannelUtils.K(selectedVoiceChannel) && i2 <= 25) {
            int i3 = this.numConnectedParticipants;
            if (i3 > i2) {
                this.appSoundManager.play(AppSound.INSTANCE.getSOUND_USER_JOINED());
            } else if (i3 < i2) {
                this.appSoundManager.play(AppSound.INSTANCE.getSOUND_USER_LEFT());
            }
        }
        if (this.numConnectedParticipants < 2 && size2 > 0) {
            AppSoundManager appSoundManager = this.appSoundManager;
            AppSound.Companion companion = AppSound.INSTANCE;
            if (!appSoundManager.isPlaying(companion.getSOUND_CALL_CALLING()) && zAreEqual) {
                this.appSoundManager.play(companion.getSOUND_CALL_CALLING());
                return;
            }
        }
        if (!zAreEqual || size2 == 0 || this.numConnectedParticipants >= 2) {
            this.appSoundManager.stop(AppSound.INSTANCE.getSOUND_CALL_CALLING());
        }
    }

    public final void subscribeToStoreState(long voiceChannelId) {
        Subscription subscription = this.storeStateSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Observable<StoreState> observableR = this.storeStateGenerator.observeStoreState(voiceChannelId).r();
        m.checkNotNullExpressionValue(observableR, "storeStateGenerator\n    …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this.appComponent, null, 2, null), CallSoundManager.class, (Context) null, new AnonymousClass1(), (Function1) null, new AnonymousClass2(), (Function0) null, new AnonymousClass3(voiceChannelId), 42, (Object) null);
    }

    public /* synthetic */ CallSoundManager(AppComponent appComponent, AppSoundManager appSoundManager, IStoreStateGenerator iStoreStateGenerator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(appComponent, (i & 2) != 0 ? AppSoundManager.Provider.INSTANCE.get() : appSoundManager, (i & 4) != 0 ? new StoreStateGenerator(null, null, null, null, null, 31, null) : iStoreStateGenerator);
    }
}
