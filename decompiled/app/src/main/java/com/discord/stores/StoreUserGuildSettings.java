package com.discord.stores;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.thread.ThreadMember;
import com.discord.models.domain.ModelMuteConfig;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.domain.ModelPayload;
import com.discord.models.guild.Guild;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreThreadsJoined;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.widgets.chat.AutocompleteUtils;
import com.discord.widgets.forums.ForumUtils;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.Sets5;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;
import rx.Observable;
import rx.Subscription;
import rx.subjects.PublishSubject;

/* compiled from: StoreUserGuildSettings.kt */
/* loaded from: classes2.dex */
public final class StoreUserGuildSettings extends StoreV2 {
    private final StoreAnalytics analytics;
    private final Clock clock;
    private final Dispatcher dispatcher;
    private final PublishSubject<Event> eventSubject;
    private final Map<Long, ModelNotificationSettings> guildSettings;
    private final Persister<Map<Long, ModelNotificationSettings>> guildSettingsCache;
    private Map<Long, ? extends ModelNotificationSettings> guildSettingsSnapshot;
    private final HashSet<Long> guildsToHideMutedChannelsIn;
    private final Persister<Set<Long>> guildsToHideMutedChannelsInCache;
    private Set<Long> guildsToHideMutedChannelsInSnapshot;
    private final ObservationDeck observationDeck;
    private Subscription recomputeSettingsSubscription;
    private final RestAPI restApi;
    private final StoreChannels storeChannels;
    private final StoreThreadsJoined storeThreadsJoined;

    /* compiled from: StoreUserGuildSettings.kt */
    public static abstract class Event {

        /* compiled from: StoreUserGuildSettings.kt */
        public static final /* data */ class SettingsUpdated extends Event {
            private final SettingsUpdateType type;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SettingsUpdated(SettingsUpdateType settingsUpdateType) {
                super(null);
                Intrinsics3.checkNotNullParameter(settingsUpdateType, "type");
                this.type = settingsUpdateType;
            }

            public static /* synthetic */ SettingsUpdated copy$default(SettingsUpdated settingsUpdated, SettingsUpdateType settingsUpdateType, int i, Object obj) {
                if ((i & 1) != 0) {
                    settingsUpdateType = settingsUpdated.type;
                }
                return settingsUpdated.copy(settingsUpdateType);
            }

            /* renamed from: component1, reason: from getter */
            public final SettingsUpdateType getType() {
                return this.type;
            }

            public final SettingsUpdated copy(SettingsUpdateType type) {
                Intrinsics3.checkNotNullParameter(type, "type");
                return new SettingsUpdated(type);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof SettingsUpdated) && Intrinsics3.areEqual(this.type, ((SettingsUpdated) other).type);
                }
                return true;
            }

            public final SettingsUpdateType getType() {
                return this.type;
            }

            public int hashCode() {
                SettingsUpdateType settingsUpdateType = this.type;
                if (settingsUpdateType != null) {
                    return settingsUpdateType.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("SettingsUpdated(type=");
                sbU.append(this.type);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreUserGuildSettings.kt */
    public enum SettingsUpdateType {
        GUILD,
        CHANNEL,
        THREAD,
        CATEGORY
    }

    /* compiled from: StoreUserGuildSettings.kt */
    /* renamed from: com.discord.stores.StoreUserGuildSettings$handleGuildSettings$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Subscription, Unit> {
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
            Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            Subscription subscriptionAccess$getRecomputeSettingsSubscription$p = StoreUserGuildSettings.access$getRecomputeSettingsSubscription$p(StoreUserGuildSettings.this);
            if (subscriptionAccess$getRecomputeSettingsSubscription$p != null) {
                subscriptionAccess$getRecomputeSettingsSubscription$p.unsubscribe();
            }
            StoreUserGuildSettings.access$setRecomputeSettingsSubscription$p(StoreUserGuildSettings.this, subscription);
        }
    }

    /* compiled from: StoreUserGuildSettings.kt */
    /* renamed from: com.discord.stores.StoreUserGuildSettings$handleGuildSettings$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Long, Unit> {

        /* compiled from: StoreUserGuildSettings.kt */
        /* renamed from: com.discord.stores.StoreUserGuildSettings$handleGuildSettings$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreUserGuildSettings.access$recomputeMuteConfigs(StoreUserGuildSettings.this);
            }
        }

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            StoreUserGuildSettings.access$getDispatcher$p(StoreUserGuildSettings.this).schedule(new AnonymousClass1());
        }
    }

    /* compiled from: StoreUserGuildSettings.kt */
    /* renamed from: com.discord.stores.StoreUserGuildSettings$observeGuildSettings$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends ModelNotificationSettings>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends ModelNotificationSettings> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends ModelNotificationSettings> invoke2() {
            return StoreUserGuildSettings.this.getGuildSettings();
        }
    }

    /* compiled from: StoreUserGuildSettings.kt */
    /* renamed from: com.discord.stores.StoreUserGuildSettings$observeGuildSettings$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements Func1<Map<Long, ? extends ModelNotificationSettings>, ModelNotificationSettings> {
        public final /* synthetic */ long $guildId;

        public AnonymousClass2(long j) {
            this.$guildId = j;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ ModelNotificationSettings call(Map<Long, ? extends ModelNotificationSettings> map) {
            return call2(map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final ModelNotificationSettings call2(Map<Long, ? extends ModelNotificationSettings> map) {
            ModelNotificationSettings modelNotificationSettings = map.get(Long.valueOf(this.$guildId));
            return modelNotificationSettings != null ? modelNotificationSettings : new ModelNotificationSettings();
        }
    }

    /* compiled from: StoreUserGuildSettings.kt */
    /* renamed from: com.discord.stores.StoreUserGuildSettings$observeHideMutedChannels$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Set<? extends Long>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Set<? extends Long> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Set<? extends Long> invoke2() {
            return StoreUserGuildSettings.this.getGuildsToHideMutedChannelsIn();
        }
    }

    /* compiled from: StoreUserGuildSettings.kt */
    /* renamed from: com.discord.stores.StoreUserGuildSettings$observeHideMutedChannels$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements Func1<Set<? extends Long>, Boolean> {
        public final /* synthetic */ long $guildId;

        public AnonymousClass2(long j) {
            this.$guildId = j;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Boolean call(Set<? extends Long> set) {
            return call2((Set<Long>) set);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(Set<Long> set) {
            return Boolean.valueOf(set.contains(Long.valueOf(this.$guildId)));
        }
    }

    /* compiled from: StoreUserGuildSettings.kt */
    /* renamed from: com.discord.stores.StoreUserGuildSettings$observeMutedGuildIds$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Map<Long, ? extends ModelNotificationSettings>, List<? extends Long>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ List<? extends Long> call(Map<Long, ? extends ModelNotificationSettings> map) {
            return call2(map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final List<Long> call2(Map<Long, ? extends ModelNotificationSettings> map) {
            Collection<? extends ModelNotificationSettings> collectionValues = map.values();
            ArrayList arrayList = new ArrayList();
            for (T t : collectionValues) {
                if (((ModelNotificationSettings) t).isMuted()) {
                    arrayList.add(t);
                }
            }
            ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(Long.valueOf(((ModelNotificationSettings) it.next()).getGuildId()));
            }
            return arrayList2;
        }
    }

    /* compiled from: StoreUserGuildSettings.kt */
    /* renamed from: com.discord.stores.StoreUserGuildSettings$setChannelMuted$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ Context $context;
        public final /* synthetic */ ModelMuteConfig $muteConfig;
        public final /* synthetic */ boolean $muted;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, Context context, boolean z2, ModelMuteConfig modelMuteConfig) {
            super(0);
            this.$channelId = j;
            this.$context = context;
            this.$muted = z2;
            this.$muteConfig = modelMuteConfig;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Channel channelFindChannelByIdInternal$app_productionGoogleRelease = StoreUserGuildSettings.access$getStoreChannels$p(StoreUserGuildSettings.this).findChannelByIdInternal$app_productionGoogleRelease(this.$channelId);
            if (channelFindChannelByIdInternal$app_productionGoogleRelease != null) {
                SettingsUpdateType settingsUpdateTypeAccess$getSettingsUpdateType = StoreUserGuildSettings.access$getSettingsUpdateType(StoreUserGuildSettings.this, channelFindChannelByIdInternal$app_productionGoogleRelease);
                if (!ChannelUtils.H(channelFindChannelByIdInternal$app_productionGoogleRelease)) {
                    StoreUserGuildSettings.access$updateUserGuildSettings(StoreUserGuildSettings.this, this.$context, channelFindChannelByIdInternal$app_productionGoogleRelease.getGuildId(), new RestAPIParams.UserGuildSettings(channelFindChannelByIdInternal$app_productionGoogleRelease.getId(), new RestAPIParams.UserGuildSettings.ChannelOverride(Boolean.valueOf(this.$muted), this.$muteConfig, null, null, 12, null)), settingsUpdateTypeAccess$getSettingsUpdateType);
                } else {
                    StoreThreadsJoined.JoinedThread joinedThread = StoreUserGuildSettings.access$getStoreThreadsJoined$p(StoreUserGuildSettings.this).getJoinedThread(channelFindChannelByIdInternal$app_productionGoogleRelease.getId());
                    StoreUserGuildSettings.access$updateThreadMemberSettings(StoreUserGuildSettings.this, this.$context, channelFindChannelByIdInternal$app_productionGoogleRelease.getId(), channelFindChannelByIdInternal$app_productionGoogleRelease.getParentId(), new RestAPIParams.ThreadMemberSettings(null, Boolean.valueOf(this.$muted), this.$muteConfig, 1, null), joinedThread != null ? joinedThread.getFlags() : 0);
                }
            }
        }
    }

    /* compiled from: StoreUserGuildSettings.kt */
    /* renamed from: com.discord.stores.StoreUserGuildSettings$setHideMutedChannels$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ boolean $hideChannels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z2, long j) {
            super(0);
            this.$hideChannels = z2;
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (this.$hideChannels) {
                StoreUserGuildSettings.access$getGuildsToHideMutedChannelsIn$p(StoreUserGuildSettings.this).add(Long.valueOf(this.$guildId));
            } else {
                StoreUserGuildSettings.access$getGuildsToHideMutedChannelsIn$p(StoreUserGuildSettings.this).remove(Long.valueOf(this.$guildId));
            }
            StoreUserGuildSettings.this.markChanged();
        }
    }

    /* compiled from: StoreUserGuildSettings.kt */
    /* renamed from: com.discord.stores.StoreUserGuildSettings$updateThreadMemberSettings$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ThreadMember, Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ int $oldFlags;
        public final /* synthetic */ long $parentChannelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2, int i) {
            super(1);
            this.$channelId = j;
            this.$parentChannelId = j2;
            this.$oldFlags = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ThreadMember threadMember) {
            invoke2(threadMember);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ThreadMember threadMember) {
            Intrinsics3.checkNotNullParameter(threadMember, "threadMember");
            StoreUserGuildSettings.access$getAnalytics$p(StoreUserGuildSettings.this).onThreadNotificationSettingsUpdated(this.$channelId, this.$parentChannelId, threadMember.getFlags(), this.$oldFlags);
            PublishSubject publishSubjectAccess$getEventSubject$p = StoreUserGuildSettings.access$getEventSubject$p(StoreUserGuildSettings.this);
            publishSubjectAccess$getEventSubject$p.k.onNext(new Event.SettingsUpdated(SettingsUpdateType.THREAD));
        }
    }

    /* compiled from: StoreUserGuildSettings.kt */
    /* renamed from: com.discord.stores.StoreUserGuildSettings$updateUserGuildSettings$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ModelNotificationSettings, Unit> {
        public final /* synthetic */ Long $channelId;
        public final /* synthetic */ SettingsUpdateType $settingsUpdateType;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Long l, SettingsUpdateType settingsUpdateType) {
            super(1);
            this.$channelId = l;
            this.$settingsUpdateType = settingsUpdateType;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelNotificationSettings modelNotificationSettings) {
            invoke2(modelNotificationSettings);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelNotificationSettings modelNotificationSettings) {
            Intrinsics3.checkNotNullParameter(modelNotificationSettings, "notifSettings");
            StoreUserGuildSettings.access$getAnalytics$p(StoreUserGuildSettings.this).onNotificationSettingsUpdated(modelNotificationSettings, this.$channelId);
            PublishSubject publishSubjectAccess$getEventSubject$p = StoreUserGuildSettings.access$getEventSubject$p(StoreUserGuildSettings.this);
            publishSubjectAccess$getEventSubject$p.k.onNext(new Event.SettingsUpdated(this.$settingsUpdateType));
        }
    }

    public /* synthetic */ StoreUserGuildSettings(Dispatcher dispatcher, Clock clock, StoreAnalytics storeAnalytics, StoreChannels storeChannels, StoreThreadsJoined storeThreadsJoined, ObservationDeck observationDeck, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, clock, storeAnalytics, storeChannels, storeThreadsJoined, (i & 32) != 0 ? ObservationDeck4.get() : observationDeck, (i & 64) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    public static final /* synthetic */ StoreAnalytics access$getAnalytics$p(StoreUserGuildSettings storeUserGuildSettings) {
        return storeUserGuildSettings.analytics;
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreUserGuildSettings storeUserGuildSettings) {
        return storeUserGuildSettings.dispatcher;
    }

    public static final /* synthetic */ PublishSubject access$getEventSubject$p(StoreUserGuildSettings storeUserGuildSettings) {
        return storeUserGuildSettings.eventSubject;
    }

    public static final /* synthetic */ HashSet access$getGuildsToHideMutedChannelsIn$p(StoreUserGuildSettings storeUserGuildSettings) {
        return storeUserGuildSettings.guildsToHideMutedChannelsIn;
    }

    public static final /* synthetic */ Subscription access$getRecomputeSettingsSubscription$p(StoreUserGuildSettings storeUserGuildSettings) {
        return storeUserGuildSettings.recomputeSettingsSubscription;
    }

    public static final /* synthetic */ SettingsUpdateType access$getSettingsUpdateType(StoreUserGuildSettings storeUserGuildSettings, Channel channel) {
        return storeUserGuildSettings.getSettingsUpdateType(channel);
    }

    public static final /* synthetic */ StoreChannels access$getStoreChannels$p(StoreUserGuildSettings storeUserGuildSettings) {
        return storeUserGuildSettings.storeChannels;
    }

    public static final /* synthetic */ StoreThreadsJoined access$getStoreThreadsJoined$p(StoreUserGuildSettings storeUserGuildSettings) {
        return storeUserGuildSettings.storeThreadsJoined;
    }

    public static final /* synthetic */ void access$recomputeMuteConfigs(StoreUserGuildSettings storeUserGuildSettings) {
        storeUserGuildSettings.recomputeMuteConfigs();
    }

    public static final /* synthetic */ void access$setRecomputeSettingsSubscription$p(StoreUserGuildSettings storeUserGuildSettings, Subscription subscription) {
        storeUserGuildSettings.recomputeSettingsSubscription = subscription;
    }

    public static final /* synthetic */ void access$updateThreadMemberSettings(StoreUserGuildSettings storeUserGuildSettings, Context context, long j, long j2, RestAPIParams.ThreadMemberSettings threadMemberSettings, int i) {
        storeUserGuildSettings.updateThreadMemberSettings(context, j, j2, threadMemberSettings, i);
    }

    public static final /* synthetic */ void access$updateUserGuildSettings(StoreUserGuildSettings storeUserGuildSettings, Context context, long j, RestAPIParams.UserGuildSettings userGuildSettings, SettingsUpdateType settingsUpdateType) {
        storeUserGuildSettings.updateUserGuildSettings(context, j, userGuildSettings, settingsUpdateType);
    }

    private final SettingsUpdateType getSettingsUpdateType(Channel channel) {
        return ChannelUtils.H(channel) ? SettingsUpdateType.THREAD : ChannelUtils.F(channel) ? SettingsUpdateType.CHANNEL : SettingsUpdateType.CATEGORY;
    }

    @Store3
    private final void handleGuildSettings(List<? extends ModelNotificationSettings> guildSettingsList) {
        Subscription subscription = this.recomputeSettingsSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Iterator<? extends ModelNotificationSettings> it = guildSettingsList.iterator();
        while (it.hasNext()) {
            ModelNotificationSettings modelNotificationSettingsCopyAndRecomputeTransientFields = it.next().copyAndRecomputeTransientFields(this.clock);
            Map<Long, ModelNotificationSettings> map = this.guildSettings;
            Intrinsics3.checkNotNullExpressionValue(modelNotificationSettingsCopyAndRecomputeTransientFields, "computedSettings");
            if (!Intrinsics3.areEqual(modelNotificationSettingsCopyAndRecomputeTransientFields, map.get(Long.valueOf(modelNotificationSettingsCopyAndRecomputeTransientFields.getGuildId())))) {
                this.guildSettings.put(Long.valueOf(modelNotificationSettingsCopyAndRecomputeTransientFields.getGuildId()), modelNotificationSettingsCopyAndRecomputeTransientFields);
                markChanged();
            }
        }
        Iterator<ModelNotificationSettings> it2 = this.guildSettings.values().iterator();
        long jMin = Long.MAX_VALUE;
        while (it2.hasNext()) {
            jMin = Math.min(jMin, it2.next().getNextMuteEndTimeMs(this.clock));
        }
        if (jMin < RecyclerView.FOREVER_NS) {
            Observable<Long> observableE0 = Observable.e0(jMin - this.clock.currentTimeMillis(), TimeUnit.MILLISECONDS, this.dispatcher.getScheduler());
            Intrinsics3.checkNotNullExpressionValue(observableE0, "Observable.timer(\n      …patcher.scheduler\n      )");
            ObservableExtensionsKt.appSubscribe$default(observableE0, StoreUserGuildSettings.class, (Context) null, new AnonymousClass1(), (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 58, (Object) null);
        }
    }

    @Store3
    private final void recomputeMuteConfigs() {
        handleGuildSettingUpdated$app_productionGoogleRelease(new ArrayList(this.guildSettings.values()));
    }

    public static /* synthetic */ void setChannelMuted$default(StoreUserGuildSettings storeUserGuildSettings, Context context, long j, boolean z2, ModelMuteConfig modelMuteConfig, int i, Object obj) {
        if ((i & 8) != 0) {
            modelMuteConfig = null;
        }
        storeUserGuildSettings.setChannelMuted(context, j, z2, modelMuteConfig);
    }

    public static /* synthetic */ void setGuildMuted$default(StoreUserGuildSettings storeUserGuildSettings, Context context, long j, boolean z2, ModelMuteConfig modelMuteConfig, int i, Object obj) {
        if ((i & 8) != 0) {
            modelMuteConfig = null;
        }
        storeUserGuildSettings.setGuildMuted(context, j, z2, modelMuteConfig);
    }

    public static /* synthetic */ void setGuildToggles$default(StoreUserGuildSettings storeUserGuildSettings, Context context, Guild guild, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, int i, Object obj) {
        storeUserGuildSettings.setGuildToggles(context, guild, (i & 4) != 0 ? null : bool, (i & 8) != 0 ? null : bool2, (i & 16) != 0 ? null : bool3, (i & 32) != 0 ? null : bool4);
    }

    private final void updateThreadMemberSettings(Context context, long channelId, long parentChannelId, RestAPIParams.ThreadMemberSettings threadMemberSettings, int oldFlags) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(ObservableExtensionsKt.restSubscribeOn$default(this.restApi.updateThreadMemberSettings(channelId, threadMemberSettings), false, 1, null)), StoreUserGuildSettings.class, context, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(channelId, parentChannelId, oldFlags), 60, (Object) null);
    }

    private final void updateUserGuildSettings(Context context, long guildId, RestAPIParams.UserGuildSettings userGuildSettings, SettingsUpdateType settingsUpdateType) {
        Set<Long> setKeySet;
        Map<Long, RestAPIParams.UserGuildSettings.ChannelOverride> channelOverrides = userGuildSettings.getChannelOverrides();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(ObservableExtensionsKt.restSubscribeOn$default(this.restApi.updateUserGuildSettings(guildId, userGuildSettings), false, 1, null)), StoreUserGuildSettings.class, context, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1((channelOverrides == null || (setKeySet = channelOverrides.keySet()) == null) ? null : (Long) _Collections.firstOrNull(setKeySet), settingsUpdateType), 60, (Object) null);
    }

    public final Map<Long, ModelNotificationSettings> getGuildSettings() {
        return this.guildSettingsSnapshot;
    }

    @Store3
    public final Map<Long, ModelNotificationSettings> getGuildSettingsInternal$app_productionGoogleRelease() {
        return this.guildSettings;
    }

    public final Set<Long> getGuildsToHideMutedChannelsIn() {
        return this.guildsToHideMutedChannelsInSnapshot;
    }

    @Store3
    public final void handleConnectionOpen$app_productionGoogleRelease(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        ModelPayload.VersionedUserGuildSettings userGuildSettings = payload.getUserGuildSettings();
        Intrinsics3.checkNotNullExpressionValue(userGuildSettings, "payload.userGuildSettings");
        if (!userGuildSettings.isPartial()) {
            this.guildSettings.clear();
        }
        ModelPayload.VersionedUserGuildSettings userGuildSettings2 = payload.getUserGuildSettings();
        Intrinsics3.checkNotNullExpressionValue(userGuildSettings2, "payload.userGuildSettings");
        List<ModelNotificationSettings> entries = userGuildSettings2.getEntries();
        Intrinsics3.checkNotNullExpressionValue(entries, "payload.userGuildSettings.entries");
        handleGuildSettings(entries);
        markChanged();
    }

    @Store3
    public final void handleGuildSettingUpdated$app_productionGoogleRelease(List<? extends ModelNotificationSettings> guildSettingsList) {
        Intrinsics3.checkNotNullParameter(guildSettingsList, "guildSettingsList");
        handleGuildSettings(guildSettingsList);
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        super.init(context);
        this.guildsToHideMutedChannelsIn.addAll(this.guildsToHideMutedChannelsInCache.get());
        this.guildSettings.putAll(this.guildSettingsCache.get());
        markChanged();
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final Observable<Map<Long, ModelNotificationSettings>> observeGuildSettings() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final Observable<Boolean> observeHideMutedChannels(long guildId) {
        Observable<Boolean> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).G(new AnonymousClass2(guildId)).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<List<Long>> observeMutedGuildIds() {
        Observable<List<Long>> observableR = observeGuildSettings().G(AnonymousClass1.INSTANCE).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observeGuildSettings()\n …  .distinctUntilChanged()");
        return observableR;
    }

    public final void setChannelFrequency(Context context, Channel channel, int frequency) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(channel, "channel");
        SettingsUpdateType settingsUpdateType = getSettingsUpdateType(channel);
        if (!ChannelUtils.H(channel)) {
            updateUserGuildSettings(context, channel.getGuildId(), new RestAPIParams.UserGuildSettings(channel.getId(), new RestAPIParams.UserGuildSettings.ChannelOverride(Integer.valueOf(frequency), null)), settingsUpdateType);
            return;
        }
        int i = frequency == ModelNotificationSettings.FREQUENCY_NOTHING ? 8 : frequency == ModelNotificationSettings.FREQUENCY_MENTIONS ? 4 : 2;
        StoreThreadsJoined.JoinedThread joinedThread = this.storeThreadsJoined.getJoinedThread(channel.getId());
        updateThreadMemberSettings(context, channel.getId(), channel.getParentId(), new RestAPIParams.ThreadMemberSettings(Integer.valueOf(i), null, null, 6, null), joinedThread != null ? joinedThread.getFlags() : 0);
    }

    public final void setChannelMuted(Context context, long channelId, boolean muted, ModelMuteConfig muteConfig) {
        Intrinsics3.checkNotNullParameter(context, "context");
        this.dispatcher.schedule(new AnonymousClass1(channelId, context, muted, muteConfig));
    }

    public final void setChannelNotificationFlags(Context context, Channel channel, int flags) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(channel, "channel");
        if (ChannelUtils.q(channel) && ForumUtils.canAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, channel.getGuildId(), null, 2, null)) {
            updateUserGuildSettings(context, channel.getGuildId(), new RestAPIParams.UserGuildSettings(channel.getId(), new RestAPIParams.UserGuildSettings.ChannelOverride(null, Integer.valueOf(flags))), getSettingsUpdateType(channel));
        }
    }

    public final void setChannelNotificationsDefault(Context context, Channel channel) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(channel, "channel");
        if (ChannelUtils.H(channel)) {
            return;
        }
        updateUserGuildSettings(context, channel.getGuildId(), new RestAPIParams.UserGuildSettings(channel.getId(), new RestAPIParams.UserGuildSettings.ChannelOverride(Boolean.FALSE, null, Integer.valueOf(ModelNotificationSettings.FREQUENCY_UNSET), null, 8, null)), getSettingsUpdateType(channel));
    }

    public final void setGuildFrequency(Context context, Guild guild, int frequency) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(guild, "guild");
        updateUserGuildSettings(context, guild.getId(), new RestAPIParams.UserGuildSettings(null, null, null, null, null, Integer.valueOf(frequency), null, null, 223, null), SettingsUpdateType.GUILD);
    }

    public final void setGuildMuted(Context context, long guildId, boolean muted, ModelMuteConfig muteConfig) {
        Intrinsics3.checkNotNullParameter(context, "context");
        updateUserGuildSettings(context, guildId, new RestAPIParams.UserGuildSettings(null, null, Boolean.valueOf(muted), muteConfig, null, null, null, null, 243, null), SettingsUpdateType.GUILD);
    }

    public final void setGuildToggles(Context context, Guild guild, Boolean suppressingEveryone, Boolean suppressingRoles, Boolean muted, Boolean mobilePushEnabled) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(guild, "guild");
        updateUserGuildSettings(context, guild.getId(), new RestAPIParams.UserGuildSettings(suppressingEveryone, suppressingRoles, muted, null, mobilePushEnabled, null, null, null, 232, null), SettingsUpdateType.GUILD);
    }

    public final void setHideMutedChannels(long guildId, boolean hideChannels) {
        this.dispatcher.schedule(new AnonymousClass1(hideChannels, guildId));
    }

    public final void setNotifyHighlights(Context context, Guild guild, int notifyHighlights) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(guild, "guild");
        updateUserGuildSettings(context, guild.getId(), new RestAPIParams.UserGuildSettings(null, null, null, null, null, null, null, Integer.valueOf(notifyHighlights), Opcodes.LAND, null), SettingsUpdateType.GUILD);
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.guildSettingsSnapshot = new HashMap(this.guildSettings);
        Persister.set$default(this.guildSettingsCache, this.guildSettings, false, 2, null);
        this.guildsToHideMutedChannelsInSnapshot = new HashSet(this.guildsToHideMutedChannelsIn);
        this.guildsToHideMutedChannelsInCache.set(this.guildsToHideMutedChannelsIn, true);
    }

    public final Observable<ModelNotificationSettings> observeGuildSettings(long guildId) {
        Observable<ModelNotificationSettings> observableR = observeGuildSettings().G(new AnonymousClass2(guildId)).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observeGuildSettings()\n …  .distinctUntilChanged()");
        return observableR;
    }

    public StoreUserGuildSettings(Dispatcher dispatcher, Clock clock, StoreAnalytics storeAnalytics, StoreChannels storeChannels, StoreThreadsJoined storeThreadsJoined, ObservationDeck observationDeck, RestAPI restAPI) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        Intrinsics3.checkNotNullParameter(storeAnalytics, "analytics");
        Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
        Intrinsics3.checkNotNullParameter(storeThreadsJoined, "storeThreadsJoined");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(restAPI, "restApi");
        this.dispatcher = dispatcher;
        this.clock = clock;
        this.analytics = storeAnalytics;
        this.storeChannels = storeChannels;
        this.storeThreadsJoined = storeThreadsJoined;
        this.observationDeck = observationDeck;
        this.restApi = restAPI;
        this.guildSettings = new HashMap();
        this.guildsToHideMutedChannelsIn = new HashSet<>();
        this.guildSettingsSnapshot = Maps6.emptyMap();
        this.guildsToHideMutedChannelsInSnapshot = Sets5.emptySet();
        this.guildSettingsCache = new Persister<>("STORE_SETTINGS_USER_GUILD_V6", new HashMap());
        this.guildsToHideMutedChannelsInCache = new Persister<>("STORE_SHOW_HIDE_MUTED_CHANNELS_V2", new HashSet());
        this.eventSubject = PublishSubject.k0();
    }
}
