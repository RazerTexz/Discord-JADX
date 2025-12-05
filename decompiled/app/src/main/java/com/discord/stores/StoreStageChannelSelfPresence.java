package com.discord.stores;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityParty;
import com.discord.api.activity.ActivityType;
import com.discord.api.voice.state.VoiceState;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.presence.ActivityUtils;
import com.discord.widgets.stage.StageRoles;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p641k.Func1;
import p658rx.Observable;
import p658rx.functions.Func2;
import p658rx.subjects.BehaviorSubject;

/* compiled from: StoreStageChannelSelfPresence.kt */
/* loaded from: classes2.dex */
public final class StoreStageChannelSelfPresence extends StoreV2 {
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private final BehaviorSubject<Unit> publishStateTrigger;
    private Activity stageChannelActivity;
    private final StoreStageChannels stageChannels;
    private final StoreUserPresence userPresence;
    private final StoreUserSettings userSettings;
    private final StoreUser userStore;
    private final StoreVoiceChannelSelected voiceChannelSelected;

    /* compiled from: StoreStageChannelSelfPresence.kt */
    /* renamed from: com.discord.stores.StoreStageChannelSelfPresence$init$1 */
    public static final class C64081 extends Lambda implements Function0<Integer> {
        public C64081() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Integer invoke() {
            return Integer.valueOf(invoke2());
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final int invoke2() {
            Map<Long, StageRoles> channelRolesInternal = StoreStageChannelSelfPresence.this.getStageChannels().getChannelRolesInternal(StoreStageChannelSelfPresence.this.getVoiceChannelSelected().getSelectedVoiceChannelId());
            return ((channelRolesInternal != null ? channelRolesInternal.size() : 0) / 100) + 1;
        }
    }

    /* compiled from: StoreStageChannelSelfPresence.kt */
    /* renamed from: com.discord.stores.StoreStageChannelSelfPresence$init$2 */
    public static final class C64092<T, R> implements Func1<Integer, Observable<? extends Boolean>> {

        /* compiled from: StoreStageChannelSelfPresence.kt */
        /* renamed from: com.discord.stores.StoreStageChannelSelfPresence$init$2$1, reason: invalid class name */
        public static final class AnonymousClass1<T1, T2, R> implements Func2<Unit, Boolean, Boolean> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Boolean call2(Unit unit, Boolean bool) {
                return bool;
            }

            @Override // p658rx.functions.Func2
            public /* bridge */ /* synthetic */ Boolean call(Unit unit, Boolean bool) {
                return call2(unit, bool);
            }
        }

        public C64092() {
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Boolean> call(Integer num) {
            return call2(num);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Boolean> call2(Integer num) {
            return Observable.m11076j(ObservableExtensionsKt.leadingEdgeThrottle(StoreStageChannelSelfPresence.this.getPublishStateTrigger(), num.intValue(), TimeUnit.SECONDS), StoreStageChannelSelfPresence.this.getUserSettings().observeIsShowCurrentGameEnabled(), AnonymousClass1.INSTANCE);
        }
    }

    /* compiled from: StoreStageChannelSelfPresence.kt */
    /* renamed from: com.discord.stores.StoreStageChannelSelfPresence$init$3 */
    public static final class C64103 extends Lambda implements Function1<Boolean, Unit> {

        /* compiled from: StoreStageChannelSelfPresence.kt */
        /* renamed from: com.discord.stores.StoreStageChannelSelfPresence$init$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Boolean $showCurrentActivity;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Boolean bool) {
                super(0);
                this.$showCurrentActivity = bool;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreUserPresence userPresence = StoreStageChannelSelfPresence.this.getUserPresence();
                ActivityType activityType = ActivityType.LISTENING;
                Activity stageChannelActivity = StoreStageChannelSelfPresence.this.getStageChannelActivity();
                Boolean bool = this.$showCurrentActivity;
                Intrinsics3.checkNotNullExpressionValue(bool, "showCurrentActivity");
                if (!bool.booleanValue()) {
                    stageChannelActivity = null;
                }
                userPresence.updateActivity(activityType, stageChannelActivity, true);
            }
        }

        public C64103() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            StoreStageChannelSelfPresence.this.getDispatcher().schedule(new AnonymousClass1(bool));
        }
    }

    public StoreStageChannelSelfPresence(ObservationDeck observationDeck, StoreUser storeUser, StoreUserPresence storeUserPresence, StoreStageChannels storeStageChannels, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreUserSettings storeUserSettings, Dispatcher dispatcher) {
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(storeUser, "userStore");
        Intrinsics3.checkNotNullParameter(storeUserPresence, "userPresence");
        Intrinsics3.checkNotNullParameter(storeStageChannels, "stageChannels");
        Intrinsics3.checkNotNullParameter(storeVoiceChannelSelected, "voiceChannelSelected");
        Intrinsics3.checkNotNullParameter(storeUserSettings, "userSettings");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        this.observationDeck = observationDeck;
        this.userStore = storeUser;
        this.userPresence = storeUserPresence;
        this.stageChannels = storeStageChannels;
        this.voiceChannelSelected = storeVoiceChannelSelected;
        this.userSettings = storeUserSettings;
        this.dispatcher = dispatcher;
        BehaviorSubject<Unit> behaviorSubjectM11129k0 = BehaviorSubject.m11129k0();
        Intrinsics3.checkNotNullExpressionValue(behaviorSubjectM11129k0, "BehaviorSubject.create()");
        this.publishStateTrigger = behaviorSubjectM11129k0;
    }

    @Store3
    private final void updateActivity() {
        ActivityParty party;
        ActivityParty party2;
        Activity activityCreateStageChannelListeningActivity = ActivityUtils.createStageChannelListeningActivity();
        String id2 = (activityCreateStageChannelListeningActivity == null || (party2 = activityCreateStageChannelListeningActivity.getParty()) == null) ? null : party2.getId();
        Activity activity = this.stageChannelActivity;
        if (!(!Intrinsics3.areEqual(id2, (activity == null || (party = activity.getParty()) == null) ? null : party.getId()))) {
            String name = activityCreateStageChannelListeningActivity != null ? activityCreateStageChannelListeningActivity.getName() : null;
            if (!(!Intrinsics3.areEqual(name, this.stageChannelActivity != null ? r3.getName() : null))) {
                return;
            }
        }
        this.stageChannelActivity = activityCreateStageChannelListeningActivity;
        this.publishStateTrigger.onNext(Unit.f27425a);
    }

    public final Dispatcher getDispatcher() {
        return this.dispatcher;
    }

    public final ObservationDeck getObservationDeck() {
        return this.observationDeck;
    }

    public final BehaviorSubject<Unit> getPublishStateTrigger() {
        return this.publishStateTrigger;
    }

    public final Activity getStageChannelActivity() {
        return this.stageChannelActivity;
    }

    public final StoreStageChannels getStageChannels() {
        return this.stageChannels;
    }

    public final StoreUserPresence getUserPresence() {
        return this.userPresence;
    }

    public final StoreUserSettings getUserSettings() {
        return this.userSettings;
    }

    public final StoreUser getUserStore() {
        return this.userStore;
    }

    public final StoreVoiceChannelSelected getVoiceChannelSelected() {
        return this.voiceChannelSelected;
    }

    @Store3
    public final void handleStageInstanceCreate() {
        updateActivity();
    }

    @Store3
    public final void handleStageInstanceDelete() {
        updateActivity();
    }

    @Store3
    public final void handleStageInstanceUpdate() {
        updateActivity();
    }

    @Store3
    public final void handleVoiceChannelSelected() {
        updateActivity();
    }

    @Store3
    public final void handleVoiceStateUpdate(VoiceState voiceState) {
        Intrinsics3.checkNotNullParameter(voiceState, "voiceState");
        if (voiceState.getUserId() == this.userStore.getMeSnapshot().getId()) {
            updateActivity();
        }
    }

    public final void init() {
        Observable observableM11099Y = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this.stageChannels, this.voiceChannelSelected}, false, null, null, new C64081(), 14, null).m11112r().m11099Y(new C64092());
        Intrinsics3.checkNotNullExpressionValue(observableM11099Y, "observationDeck.connectR…bled -> isEnabled }\n    }");
        ObservableExtensionsKt.appSubscribe$default(observableM11099Y, StoreStageChannelSelfPresence.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C64103(), 62, (Object) null);
    }

    public final void setStageChannelActivity(Activity activity) {
        this.stageChannelActivity = activity;
    }
}
