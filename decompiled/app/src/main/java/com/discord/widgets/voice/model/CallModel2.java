package com.discord.widgets.voice.model;

import androidx.core.app.NotificationCompat;
import co.discord.media_engine.DeviceDescription4;
import com.discord.api.application.Application;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.models.embeddedactivities.EmbeddedActivity;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.guild.Guild;
import com.discord.rtcconnection.RtcConnection;
import com.discord.stores.StoreApplicationStreaming;
import com.discord.stores.StoreAudioManagerV2;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StoreMediaSettings;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.rx.ObservableCombineLatestOverloads2;
import com.discord.utilities.voice.VoiceChannelJoinabilityUtils;
import com.discord.utilities.voice.VoiceChannelJoinabilityUtils2;
import com.discord.widgets.voice.model.CallModel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function10;
import rx.Observable;

/* compiled from: CallModel.kt */
/* renamed from: com.discord.widgets.voice.model.CallModel$Companion$get$1, reason: use source file name */
/* loaded from: classes.dex */
public final class CallModel2<T, R> implements Func1<Channel, Observable<? extends CallModel>> {
    public final /* synthetic */ long $channelId;

    /* compiled from: CallModel.kt */
    /* renamed from: com.discord.widgets.voice.model.CallModel$Companion$get$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Map<Long, ? extends EmbeddedActivity>, Observable<? extends CallModel>> {
        public final /* synthetic */ Channel $channel;

        /* compiled from: CallModel.kt */
        /* renamed from: com.discord.widgets.voice.model.CallModel$Companion$get$1$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C03661<T, R> implements Func1<Experiment, Integer> {
            public static final C03661 INSTANCE = new C03661();

            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Integer call(Experiment experiment) {
                return call2(experiment);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Integer call2(Experiment experiment) {
                return Integer.valueOf(experiment != null ? experiment.getBucket() : 0);
            }
        }

        /* compiled from: CallModel.kt */
        /* renamed from: com.discord.widgets.voice.model.CallModel$Companion$get$1$1$2, reason: invalid class name */
        public static final class AnonymousClass2<T, R> implements Func1<Experiment, Integer> {
            public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Integer call(Experiment experiment) {
                return call2(experiment);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Integer call2(Experiment experiment) {
                return Integer.valueOf(experiment != null ? experiment.getBucket() : 0);
            }
        }

        /* compiled from: CallModel.kt */
        /* renamed from: com.discord.widgets.voice.model.CallModel$Companion$get$1$1$3, reason: invalid class name */
        public static final class AnonymousClass3 extends Lambda implements Function10<CallModel.Companion.Chunk, StoreApplicationStreaming.ActiveApplicationStream, RtcConnection.Metadata, Integer, Integer, VoiceChannelJoinabilityUtils2, Guild, Long, List<? extends GuildScheduledEvent>, Map<Long, ? extends Application>, CallModel> {
            public final /* synthetic */ Map $embeddedActivities;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass3(Map map) {
                super(10);
                this.$embeddedActivities = map;
            }

            @Override // kotlin.jvm.functions.Function10
            public /* bridge */ /* synthetic */ CallModel invoke(CallModel.Companion.Chunk chunk, StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream, RtcConnection.Metadata metadata, Integer num, Integer num2, VoiceChannelJoinabilityUtils2 voiceChannelJoinabilityUtils2, Guild guild, Long l, List<? extends GuildScheduledEvent> list, Map<Long, ? extends Application> map) {
                return invoke(chunk, activeApplicationStream, metadata, num, num2, voiceChannelJoinabilityUtils2, guild, l.longValue(), (List<GuildScheduledEvent>) list, (Map<Long, Application>) map);
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x00a4  */
            /* JADX WARN: Removed duplicated region for block: B:23:0x00a7 A[SYNTHETIC] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final CallModel invoke(CallModel.Companion.Chunk chunk, StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream, RtcConnection.Metadata metadata, Integer num, Integer num2, VoiceChannelJoinabilityUtils2 voiceChannelJoinabilityUtils2, Guild guild, long j, List<GuildScheduledEvent> list, Map<Long, Application> map) {
                Iterator<T> it;
                boolean z2;
                Intrinsics3.checkNotNullParameter(chunk, "chunk");
                Intrinsics3.checkNotNullParameter(voiceChannelJoinabilityUtils2, "voiceChannelJoinability");
                Intrinsics3.checkNotNullParameter(list, "guildScheduledEvents");
                Intrinsics3.checkNotNullParameter(map, "applications");
                CallModel.Companion companion = CallModel.INSTANCE;
                Channel channel = AnonymousClass1.this.$channel;
                long myUserId = chunk.getMyUserId();
                long timeConnectedMs = chunk.getTimeConnectedMs();
                StoreMediaSettings.VoiceConfiguration voiceConfig = chunk.getVoiceConfig();
                Map<Long, StoreVoiceParticipants.VoiceUser> voiceParticipants = chunk.getVoiceParticipants();
                Long channelPermissions = chunk.getChannelPermissions();
                List<DeviceDescription4> videoDevices = chunk.getVideoDevices();
                boolean z3 = AnonymousClass1.this.$channel.getId() == j;
                DeviceDescription4 selectedVideoDevice = chunk.getSelectedVideoDevice();
                Intrinsics3.checkNotNullExpressionValue(num, "callFeedbackTriggerRateDenominator");
                int iIntValue = num.intValue();
                Intrinsics3.checkNotNullExpressionValue(num2, "streamFeedbackTriggerRateDenominator");
                int iIntValue2 = num2.intValue();
                StoreAudioManagerV2.State audioManagerState = chunk.getAudioManagerState();
                ArrayList arrayList = new ArrayList();
                for (Iterator<T> it2 = list.iterator(); it2.hasNext(); it2 = it) {
                    T next = it2.next();
                    Long channelId = ((GuildScheduledEvent) next).getChannelId();
                    if (channelId == null) {
                        it = it2;
                    } else {
                        it = it2;
                        z2 = channelId.longValue() == CallModel2.this.$channelId;
                        if (!z2) {
                            arrayList.add(next);
                        }
                    }
                    if (!z2) {
                    }
                }
                Map map2 = this.$embeddedActivities;
                Intrinsics3.checkNotNullExpressionValue(map2, "embeddedActivities");
                return CallModel.Companion.access$create(companion, channel, guild, myUserId, timeConnectedMs, voiceConfig, voiceParticipants, channelPermissions, videoDevices, z3, selectedVideoDevice, activeApplicationStream, metadata, iIntValue, iIntValue2, audioManagerState, voiceChannelJoinabilityUtils2, arrayList, map2, map);
            }
        }

        public AnonymousClass1(Channel channel) {
            this.$channel = channel;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends CallModel> call(Map<Long, ? extends EmbeddedActivity> map) {
            return call2((Map<Long, EmbeddedActivity>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends CallModel> call2(Map<Long, EmbeddedActivity> map) {
            Set<Long> setKeySet = map.keySet();
            Observable observableAccess$observeChunk = CallModel.Companion.access$observeChunk(CallModel.INSTANCE, this.$channel);
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<StoreApplicationStreaming.ActiveApplicationStream> observableObserveActiveStream = companion.getApplicationStreaming().observeActiveStream();
            Observable<RtcConnection.Metadata> observableObserveRtcConnectionMetadata = companion.getRtcConnection().observeRtcConnectionMetadata();
            Observable<R> observableG = companion.getExperiments().observeUserExperiment("2019-12_android_call_feedback_sheet_sample_rate_denominator", true).G(C03661.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableG, "StoreStream\n            …experiment?.bucket ?: 0 }");
            Observable<R> observableG2 = companion.getExperiments().observeUserExperiment("2020-09_stream_feedback_sheet_sample_rate_denominator", true).G(AnonymousClass2.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableG2, "StoreStream\n            …experiment?.bucket ?: 0 }");
            return ObservableCombineLatestOverloads2.combineLatest(observableAccess$observeChunk, observableObserveActiveStream, observableObserveRtcConnectionMetadata, observableG, observableG2, VoiceChannelJoinabilityUtils.observeJoinability$default(VoiceChannelJoinabilityUtils.INSTANCE, CallModel2.this.$channelId, null, null, null, null, null, null, 126, null), companion.getGuilds().observeFromChannelId(CallModel2.this.$channelId), companion.getVoiceChannelSelected().observeSelectedVoiceChannelId(), StoreGuildScheduledEvents.observeGuildScheduledEvents$default(companion.getGuildScheduledEvents(), this.$channel.getGuildId(), false, 2, null), companion.getApplication().observeApplications(setKeySet), new AnonymousClass3(map));
        }
    }

    public CallModel2(long j) {
        this.$channelId = j;
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends CallModel> call2(Channel channel) {
        return channel == null ? new ScalarSynchronousObservable(null) : StoreStream.INSTANCE.getEmbeddedActivities().observeEmbeddedActivitiesForChannel(this.$channelId).Y(new AnonymousClass1(channel));
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends CallModel> call(Channel channel) {
        return call2(channel);
    }
}
