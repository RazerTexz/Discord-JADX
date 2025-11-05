package com.discord.stores;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityParty;
import com.discord.api.activity.ActivityType;
import com.discord.api.voice.state.VoiceState;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.presence.ActivityUtilsKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.stage.StageRoles;
import d0.z.d.m;
import d0.z.d.o;
import j0.k.b;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.functions.Func2;
import rx.subjects.BehaviorSubject;

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
    /* renamed from: com.discord.stores.StoreStageChannelSelfPresence$init$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Integer> {
        public AnonymousClass1() {
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
    /* renamed from: com.discord.stores.StoreStageChannelSelfPresence$init$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements b<Integer, Observable<? extends Boolean>> {

        /* compiled from: StoreStageChannelSelfPresence.kt */
        /* renamed from: com.discord.stores.StoreStageChannelSelfPresence$init$2$1, reason: invalid class name */
        public static final class AnonymousClass1<T1, T2, R> implements Func2<Unit, Boolean, Boolean> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Boolean call2(Unit unit, Boolean bool) {
                return bool;
            }

            @Override // rx.functions.Func2
            public /* bridge */ /* synthetic */ Boolean call(Unit unit, Boolean bool) {
                return call2(unit, bool);
            }
        }

        public AnonymousClass2() {
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Observable<? extends Boolean> call(Integer num) {
            return call2(num);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Boolean> call2(Integer num) {
            return Observable.j(ObservableExtensionsKt.leadingEdgeThrottle(StoreStageChannelSelfPresence.this.getPublishStateTrigger(), num.intValue(), TimeUnit.SECONDS), StoreStageChannelSelfPresence.this.getUserSettings().observeIsShowCurrentGameEnabled(), AnonymousClass1.INSTANCE);
        }
    }

    /* compiled from: StoreStageChannelSelfPresence.kt */
    /* renamed from: com.discord.stores.StoreStageChannelSelfPresence$init$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function1<Boolean, Unit> {

        /* compiled from: StoreStageChannelSelfPresence.kt */
        /* renamed from: com.discord.stores.StoreStageChannelSelfPresence$init$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends o implements Function0<Unit> {
            public final /* synthetic */ Boolean $showCurrentActivity;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Boolean bool) {
                super(0);
                this.$showCurrentActivity = bool;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreUserPresence userPresence = StoreStageChannelSelfPresence.this.getUserPresence();
                ActivityType activityType = ActivityType.LISTENING;
                Activity stageChannelActivity = StoreStageChannelSelfPresence.this.getStageChannelActivity();
                Boolean bool = this.$showCurrentActivity;
                m.checkNotNullExpressionValue(bool, "showCurrentActivity");
                if (!bool.booleanValue()) {
                    stageChannelActivity = null;
                }
                userPresence.updateActivity(activityType, stageChannelActivity, true);
            }
        }

        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            StoreStageChannelSelfPresence.this.getDispatcher().schedule(new AnonymousClass1(bool));
        }
    }

    public StoreStageChannelSelfPresence(ObservationDeck observationDeck, StoreUser storeUser, StoreUserPresence storeUserPresence, StoreStageChannels storeStageChannels, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreUserSettings storeUserSettings, Dispatcher dispatcher) {
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(storeUser, "userStore");
        m.checkNotNullParameter(storeUserPresence, "userPresence");
        m.checkNotNullParameter(storeStageChannels, "stageChannels");
        m.checkNotNullParameter(storeVoiceChannelSelected, "voiceChannelSelected");
        m.checkNotNullParameter(storeUserSettings, "userSettings");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        this.observationDeck = observationDeck;
        this.userStore = storeUser;
        this.userPresence = storeUserPresence;
        this.stageChannels = storeStageChannels;
        this.voiceChannelSelected = storeVoiceChannelSelected;
        this.userSettings = storeUserSettings;
        this.dispatcher = dispatcher;
        BehaviorSubject<Unit> behaviorSubjectK0 = BehaviorSubject.k0();
        m.checkNotNullExpressionValue(behaviorSubjectK0, "BehaviorSubject.create()");
        this.publishStateTrigger = behaviorSubjectK0;
    }

    @StoreThread
    private final void updateActivity() {
        ActivityParty party;
        ActivityParty party2;
        Activity activityCreateStageChannelListeningActivity = ActivityUtilsKt.createStageChannelListeningActivity();
        String id2 = (activityCreateStageChannelListeningActivity == null || (party2 = activityCreateStageChannelListeningActivity.getParty()) == null) ? null : party2.getId();
        Activity activity = this.stageChannelActivity;
        if (!(!m.areEqual(id2, (activity == null || (party = activity.getParty()) == null) ? null : party.getId()))) {
            String name = activityCreateStageChannelListeningActivity != null ? activityCreateStageChannelListeningActivity.getName() : null;
            if (!(!m.areEqual(name, this.stageChannelActivity != null ? r3.getName() : null))) {
                return;
            }
        }
        this.stageChannelActivity = activityCreateStageChannelListeningActivity;
        this.publishStateTrigger.onNext(Unit.a);
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

    @StoreThread
    public final void handleStageInstanceCreate() {
        updateActivity();
    }

    @StoreThread
    public final void handleStageInstanceDelete() {
        updateActivity();
    }

    @StoreThread
    public final void handleStageInstanceUpdate() {
        updateActivity();
    }

    @StoreThread
    public final void handleVoiceChannelSelected() {
        updateActivity();
    }

    @StoreThread
    public final void handleVoiceStateUpdate(VoiceState voiceState) {
        m.checkNotNullParameter(voiceState, "voiceState");
        if (voiceState.getUserId() == this.userStore.getMeSnapshot().getId()) {
            updateActivity();
        }
    }

    public final void init() {
        Observable observableY = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this.stageChannels, this.voiceChannelSelected}, false, null, null, new AnonymousClass1(), 14, null).r().Y(new AnonymousClass2());
        m.checkNotNullExpressionValue(observableY, "observationDeck.connectR…bled -> isEnabled }\n    }");
        ObservableExtensionsKt.appSubscribe$default(observableY, StoreStageChannelSelfPresence.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass3(), 62, (Object) null);
    }

    public final void setStageChannelActivity(Activity activity) {
        this.stageChannelActivity = activity;
    }
}
