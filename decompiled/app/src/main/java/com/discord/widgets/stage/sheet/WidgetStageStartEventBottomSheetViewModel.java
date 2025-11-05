package com.discord.widgets.stage.sheet;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import b.d.b.a.a;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.stageinstance.StageInstance;
import com.discord.api.stageinstance.StageInstancePrivacyLevel;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreStageInstances;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.stage.StageChannelAPI;
import d0.g0.w;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
/* loaded from: classes2.dex */
public final class WidgetStageStartEventBottomSheetViewModel extends d0<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long channelId;
    private final StoreChannels channelsStore;
    private final PublishSubject<Event> eventSubject;
    private final StoreStageInstances stageInstanceStore;
    private StoreState storeState;

    /* compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
    /* renamed from: com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheetViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<StoreState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            m.checkNotNullParameter(storeState, "storeState");
            WidgetStageStartEventBottomSheetViewModel.access$handleStoreState(WidgetStageStartEventBottomSheetViewModel.this, storeState);
        }
    }

    /* compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStoreState(Companion companion, long j, StoreChannels storeChannels, StoreStageInstances storeStageInstances) {
            return companion.observeStoreState(j, storeChannels, storeStageInstances);
        }

        private final Observable<StoreState> observeStoreState(long channelId, StoreChannels channelsStore, StoreStageInstances stageInstanceStore) {
            Observable<R> observableG = channelsStore.observeChannel(channelId).y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
            m.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
            Observable<StoreState> observableJ = Observable.j(observableG, stageInstanceStore.observeStageInstanceForChannel(channelId).z(), WidgetStageStartEventBottomSheetViewModel$Companion$observeStoreState$1.INSTANCE);
            m.checkNotNullExpressionValue(observableJ, "Observable.combineLatest… stageInstance)\n        }");
            return observableJ;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
    public static abstract class Event {

        /* compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
        public static final /* data */ class InvalidTopic extends Event {
            private final int failureMessageStringRes;

            public InvalidTopic(int i) {
                super(null);
                this.failureMessageStringRes = i;
            }

            public static /* synthetic */ InvalidTopic copy$default(InvalidTopic invalidTopic, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = invalidTopic.failureMessageStringRes;
                }
                return invalidTopic.copy(i);
            }

            /* renamed from: component1, reason: from getter */
            public final int getFailureMessageStringRes() {
                return this.failureMessageStringRes;
            }

            public final InvalidTopic copy(int failureMessageStringRes) {
                return new InvalidTopic(failureMessageStringRes);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof InvalidTopic) && this.failureMessageStringRes == ((InvalidTopic) other).failureMessageStringRes;
                }
                return true;
            }

            public final int getFailureMessageStringRes() {
                return this.failureMessageStringRes;
            }

            public int hashCode() {
                return this.failureMessageStringRes;
            }

            public String toString() {
                return a.B(a.U("InvalidTopic(failureMessageStringRes="), this.failureMessageStringRes, ")");
            }
        }

        /* compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
        public static final /* data */ class SetTopicFailure extends Event {
            private final int failureMessageStringRes;

            public SetTopicFailure(int i) {
                super(null);
                this.failureMessageStringRes = i;
            }

            public static /* synthetic */ SetTopicFailure copy$default(SetTopicFailure setTopicFailure, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = setTopicFailure.failureMessageStringRes;
                }
                return setTopicFailure.copy(i);
            }

            /* renamed from: component1, reason: from getter */
            public final int getFailureMessageStringRes() {
                return this.failureMessageStringRes;
            }

            public final SetTopicFailure copy(int failureMessageStringRes) {
                return new SetTopicFailure(failureMessageStringRes);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof SetTopicFailure) && this.failureMessageStringRes == ((SetTopicFailure) other).failureMessageStringRes;
                }
                return true;
            }

            public final int getFailureMessageStringRes() {
                return this.failureMessageStringRes;
            }

            public int hashCode() {
                return this.failureMessageStringRes;
            }

            public String toString() {
                return a.B(a.U("SetTopicFailure(failureMessageStringRes="), this.failureMessageStringRes, ")");
            }
        }

        /* compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
        public static final /* data */ class SetTopicSuccess extends Event {
            private final Channel channel;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SetTopicSuccess(Channel channel) {
                super(null);
                m.checkNotNullParameter(channel, "channel");
                this.channel = channel;
            }

            public static /* synthetic */ SetTopicSuccess copy$default(SetTopicSuccess setTopicSuccess, Channel channel, int i, Object obj) {
                if ((i & 1) != 0) {
                    channel = setTopicSuccess.channel;
                }
                return setTopicSuccess.copy(channel);
            }

            /* renamed from: component1, reason: from getter */
            public final Channel getChannel() {
                return this.channel;
            }

            public final SetTopicSuccess copy(Channel channel) {
                m.checkNotNullParameter(channel, "channel");
                return new SetTopicSuccess(channel);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof SetTopicSuccess) && m.areEqual(this.channel, ((SetTopicSuccess) other).channel);
                }
                return true;
            }

            public final Channel getChannel() {
                return this.channel;
            }

            public int hashCode() {
                Channel channel = this.channel;
                if (channel != null) {
                    return channel.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = a.U("SetTopicSuccess(channel=");
                sbU.append(this.channel);
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

    /* compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
    public static final /* data */ class StoreState {
        private final Channel channel;
        private final StageInstance stageInstance;

        public StoreState(Channel channel, StageInstance stageInstance) {
            m.checkNotNullParameter(channel, "channel");
            this.channel = channel;
            this.stageInstance = stageInstance;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, Channel channel, StageInstance stageInstance, int i, Object obj) {
            if ((i & 1) != 0) {
                channel = storeState.channel;
            }
            if ((i & 2) != 0) {
                stageInstance = storeState.stageInstance;
            }
            return storeState.copy(channel, stageInstance);
        }

        /* renamed from: component1, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* renamed from: component2, reason: from getter */
        public final StageInstance getStageInstance() {
            return this.stageInstance;
        }

        public final StoreState copy(Channel channel, StageInstance stageInstance) {
            m.checkNotNullParameter(channel, "channel");
            return new StoreState(channel, stageInstance);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return m.areEqual(this.channel, storeState.channel) && m.areEqual(this.stageInstance, storeState.stageInstance);
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final StageInstance getStageInstance() {
            return this.stageInstance;
        }

        public int hashCode() {
            Channel channel = this.channel;
            int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
            StageInstance stageInstance = this.stageInstance;
            return iHashCode + (stageInstance != null ? stageInstance.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = a.U("StoreState(channel=");
            sbU.append(this.channel);
            sbU.append(", stageInstance=");
            sbU.append(this.stageInstance);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
    public static abstract class ViewState {

        /* compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final Channel channel;
            private final StageInstance stageInstance;
            private final String topic;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(Channel channel, String str, StageInstance stageInstance) {
                super(null);
                m.checkNotNullParameter(channel, "channel");
                m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_TOPIC);
                this.channel = channel;
                this.topic = str;
                this.stageInstance = stageInstance;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, Channel channel, String str, StageInstance stageInstance, int i, Object obj) {
                if ((i & 1) != 0) {
                    channel = loaded.channel;
                }
                if ((i & 2) != 0) {
                    str = loaded.topic;
                }
                if ((i & 4) != 0) {
                    stageInstance = loaded.stageInstance;
                }
                return loaded.copy(channel, str, stageInstance);
            }

            /* renamed from: component1, reason: from getter */
            public final Channel getChannel() {
                return this.channel;
            }

            /* renamed from: component2, reason: from getter */
            public final String getTopic() {
                return this.topic;
            }

            /* renamed from: component3, reason: from getter */
            public final StageInstance getStageInstance() {
                return this.stageInstance;
            }

            public final Loaded copy(Channel channel, String topic, StageInstance stageInstance) {
                m.checkNotNullParameter(channel, "channel");
                m.checkNotNullParameter(topic, ModelAuditLogEntry.CHANGE_KEY_TOPIC);
                return new Loaded(channel, topic, stageInstance);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return m.areEqual(this.channel, loaded.channel) && m.areEqual(this.topic, loaded.topic) && m.areEqual(this.stageInstance, loaded.stageInstance);
            }

            public final Channel getChannel() {
                return this.channel;
            }

            public final StageInstance getStageInstance() {
                return this.stageInstance;
            }

            public final String getTopic() {
                return this.topic;
            }

            public int hashCode() {
                Channel channel = this.channel;
                int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
                String str = this.topic;
                int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
                StageInstance stageInstance = this.stageInstance;
                return iHashCode2 + (stageInstance != null ? stageInstance.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = a.U("Loaded(channel=");
                sbU.append(this.channel);
                sbU.append(", topic=");
                sbU.append(this.topic);
                sbU.append(", stageInstance=");
                sbU.append(this.stageInstance);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
    /* renamed from: com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheetViewModel$openStage$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Error, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            m.checkNotNullParameter(error, "it");
            WidgetStageStartEventBottomSheetViewModel.access$emitSetStatusFailureEvent(WidgetStageStartEventBottomSheetViewModel.this);
        }
    }

    /* compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
    /* renamed from: com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheetViewModel$openStage$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<StageInstance, Unit> {
        public final /* synthetic */ boolean $microphonePermissionGranted;
        public final /* synthetic */ ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(boolean z2, ViewState.Loaded loaded) {
            super(1);
            this.$microphonePermissionGranted = z2;
            this.$viewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StageInstance stageInstance) {
            invoke2(stageInstance);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StageInstance stageInstance) {
            m.checkNotNullParameter(stageInstance, "it");
            if (this.$microphonePermissionGranted) {
                WidgetStageStartEventBottomSheetViewModel.access$setSelfSpeaker(WidgetStageStartEventBottomSheetViewModel.this);
            }
            WidgetStageStartEventBottomSheetViewModel.access$emitSetStatusSuccessEvent(WidgetStageStartEventBottomSheetViewModel.this, this.$viewState.getChannel());
        }
    }

    /* compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
    /* renamed from: com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheetViewModel$openStage$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function1<Error, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            m.checkNotNullParameter(error, "it");
            WidgetStageStartEventBottomSheetViewModel.access$emitSetStatusFailureEvent(WidgetStageStartEventBottomSheetViewModel.this);
        }
    }

    /* compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
    /* renamed from: com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheetViewModel$openStage$4, reason: invalid class name */
    public static final class AnonymousClass4 extends o implements Function1<StageInstance, Unit> {
        public final /* synthetic */ ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(ViewState.Loaded loaded) {
            super(1);
            this.$viewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StageInstance stageInstance) {
            invoke2(stageInstance);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StageInstance stageInstance) {
            m.checkNotNullParameter(stageInstance, "it");
            WidgetStageStartEventBottomSheetViewModel.access$emitSetStatusSuccessEvent(WidgetStageStartEventBottomSheetViewModel.this, this.$viewState.getChannel());
        }
    }

    /* compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
    /* renamed from: com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheetViewModel$setSelfSpeaker$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Void, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
        }
    }

    /* compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
    /* renamed from: com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheetViewModel$setSelfSpeaker$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Error, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            m.checkNotNullParameter(error, "it");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetStageStartEventBottomSheetViewModel(long j, StoreChannels storeChannels, StoreStageInstances storeStageInstances, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreChannels channels = (i & 2) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels;
        StoreStageInstances stageInstances = (i & 4) != 0 ? StoreStream.INSTANCE.getStageInstances() : storeStageInstances;
        this(j, channels, stageInstances, (i & 8) != 0 ? Companion.access$observeStoreState(INSTANCE, j, channels, stageInstances) : observable);
    }

    public static final /* synthetic */ void access$emitSetStatusFailureEvent(WidgetStageStartEventBottomSheetViewModel widgetStageStartEventBottomSheetViewModel) {
        widgetStageStartEventBottomSheetViewModel.emitSetStatusFailureEvent();
    }

    public static final /* synthetic */ void access$emitSetStatusSuccessEvent(WidgetStageStartEventBottomSheetViewModel widgetStageStartEventBottomSheetViewModel, Channel channel) {
        widgetStageStartEventBottomSheetViewModel.emitSetStatusSuccessEvent(channel);
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetStageStartEventBottomSheetViewModel widgetStageStartEventBottomSheetViewModel, StoreState storeState) {
        widgetStageStartEventBottomSheetViewModel.handleStoreState(storeState);
    }

    public static final /* synthetic */ void access$setSelfSpeaker(WidgetStageStartEventBottomSheetViewModel widgetStageStartEventBottomSheetViewModel) {
        widgetStageStartEventBottomSheetViewModel.setSelfSpeaker();
    }

    private final void emitSetStatusFailureEvent() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new Event.SetTopicFailure(R.string.default_failure_to_perform_action_message));
    }

    private final void emitSetStatusSuccessEvent(Channel channel) {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new Event.SetTopicSuccess(channel));
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        String topic;
        this.storeState = storeState;
        Channel channel = storeState.getChannel();
        StageInstance stageInstance = storeState.getStageInstance();
        if (stageInstance == null || (topic = stageInstance.getTopic()) == null) {
            topic = "";
        }
        updateViewState(new ViewState.Loaded(channel, topic, storeState.getStageInstance()));
    }

    private final void setSelfSpeaker() {
        Channel channel;
        StoreState storeState = this.storeState;
        if (storeState == null || (channel = storeState.getChannel()) == null) {
            return;
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApiSerializeNulls().setMeSuppressed(channel, false), false, 1, null), WidgetStageStartEventBottomSheetViewModel.class, (Context) null, (Function1) null, AnonymousClass2.INSTANCE, (Function0) null, (Function0) null, AnonymousClass1.INSTANCE, 54, (Object) null);
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void openStage(boolean microphonePermissionGranted) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            String topic = loaded.getTopic();
            Objects.requireNonNull(topic, "null cannot be cast to non-null type kotlin.CharSequence");
            String string = w.trim(topic).toString();
            String str = string.length() > 0 ? string : null;
            if (str == null) {
                this.eventSubject.k.onNext(new Event.InvalidTopic(R.string.start_stage_channel_event_modal_topic_required));
            } else if (loaded.getStageInstance() == null) {
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(StageChannelAPI.startStageInstance$default(StageChannelAPI.INSTANCE, this.channelId, str, StageInstancePrivacyLevel.GUILD_ONLY, false, null, 16, null), false, 1, null), this, null, 2, null), WidgetStageStartEventBottomSheetViewModel.class, (Context) null, (Function1) null, new AnonymousClass1(), (Function0) null, (Function0) null, new AnonymousClass2(microphonePermissionGranted, loaded), 54, (Object) null);
            } else {
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(StageChannelAPI.updateStageInstance$default(StageChannelAPI.INSTANCE, this.channelId, str, null, 4, null), false, 1, null), this, null, 2, null), WidgetStageStartEventBottomSheetViewModel.class, (Context) null, (Function1) null, new AnonymousClass3(), (Function0) null, (Function0) null, new AnonymousClass4(loaded), 54, (Object) null);
            }
        }
    }

    public final void setTopic(String topic) {
        m.checkNotNullParameter(topic, ModelAuditLogEntry.CHANGE_KEY_TOPIC);
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateViewState(ViewState.Loaded.copy$default(loaded, null, topic, null, 5, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStageStartEventBottomSheetViewModel(long j, StoreChannels storeChannels, StoreStageInstances storeStageInstances, Observable<StoreState> observable) {
        super(null, 1, null);
        m.checkNotNullParameter(storeChannels, "channelsStore");
        m.checkNotNullParameter(storeStageInstances, "stageInstanceStore");
        m.checkNotNullParameter(observable, "storeStateObservable");
        this.channelId = j;
        this.channelsStore = storeChannels;
        this.stageInstanceStore = storeStageInstances;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), WidgetStageStartEventBottomSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        this.eventSubject = PublishSubject.k0();
    }
}
