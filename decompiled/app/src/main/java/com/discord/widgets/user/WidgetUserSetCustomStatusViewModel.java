package com.discord.widgets.user;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import b.a.d.d0;
import b.d.b.a.a;
import com.discord.R;
import com.discord.models.domain.ModelCustomStatusSetting;
import com.discord.models.domain.ModelUserSettings;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.domain.emoji.EmojiSet;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import com.discord.models.domain.emoji.ModelEmojiUnicode;
import com.discord.stores.StoreEmoji;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeUtils;
import d0.g0.w;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Calendar;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: WidgetUserSetCustomStatusViewModel.kt */
/* loaded from: classes.dex */
public final class WidgetUserSetCustomStatusViewModel extends d0<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final FormState.Expiration DEFAULT_EXPIRATION = FormState.Expiration.TOMORROW;
    private final Clock clock;
    private final PublishSubject<Event> eventSubject;
    private final StoreUserSettings storeUserSettings;

    /* compiled from: WidgetUserSetCustomStatusViewModel.kt */
    /* renamed from: com.discord.widgets.user.WidgetUserSetCustomStatusViewModel$1, reason: invalid class name */
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
            WidgetUserSetCustomStatusViewModel.access$handleStoreState(WidgetUserSetCustomStatusViewModel.this, storeState);
        }
    }

    /* compiled from: WidgetUserSetCustomStatusViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStoreState(Companion companion, StoreUserSettings storeUserSettings, StoreEmoji storeEmoji) {
            return companion.observeStoreState(storeUserSettings, storeEmoji);
        }

        private final Observable<StoreState> observeStoreState(StoreUserSettings storeUserSettings, StoreEmoji storeEmoji) {
            Observable<StoreState> observableZ = Observable.j(storeUserSettings.observeCustomStatus(), storeEmoji.getEmojiSet(StoreEmoji.EmojiContext.Global.INSTANCE, false, false), WidgetUserSetCustomStatusViewModel$Companion$observeStoreState$1.INSTANCE).Z(1);
            m.checkNotNullExpressionValue(observableZ, "Observable.combineLatest…        )\n      }.take(1)");
            return observableZ;
        }

        public final FormState.Expiration getDEFAULT_EXPIRATION() {
            return WidgetUserSetCustomStatusViewModel.access$getDEFAULT_EXPIRATION$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetUserSetCustomStatusViewModel.kt */
    public static abstract class Event {

        /* compiled from: WidgetUserSetCustomStatusViewModel.kt */
        public static final /* data */ class SetStatusFailure extends Event {
            private final int failureMessageStringRes;

            public SetStatusFailure(int i) {
                super(null);
                this.failureMessageStringRes = i;
            }

            public static /* synthetic */ SetStatusFailure copy$default(SetStatusFailure setStatusFailure, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = setStatusFailure.failureMessageStringRes;
                }
                return setStatusFailure.copy(i);
            }

            /* renamed from: component1, reason: from getter */
            public final int getFailureMessageStringRes() {
                return this.failureMessageStringRes;
            }

            public final SetStatusFailure copy(int failureMessageStringRes) {
                return new SetStatusFailure(failureMessageStringRes);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof SetStatusFailure) && this.failureMessageStringRes == ((SetStatusFailure) other).failureMessageStringRes;
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
                return a.B(a.U("SetStatusFailure(failureMessageStringRes="), this.failureMessageStringRes, ")");
            }
        }

        /* compiled from: WidgetUserSetCustomStatusViewModel.kt */
        public static final /* data */ class SetStatusSuccess extends Event {
            private final int successMessageStringRes;

            public SetStatusSuccess(int i) {
                super(null);
                this.successMessageStringRes = i;
            }

            public static /* synthetic */ SetStatusSuccess copy$default(SetStatusSuccess setStatusSuccess, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = setStatusSuccess.successMessageStringRes;
                }
                return setStatusSuccess.copy(i);
            }

            /* renamed from: component1, reason: from getter */
            public final int getSuccessMessageStringRes() {
                return this.successMessageStringRes;
            }

            public final SetStatusSuccess copy(int successMessageStringRes) {
                return new SetStatusSuccess(successMessageStringRes);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof SetStatusSuccess) && this.successMessageStringRes == ((SetStatusSuccess) other).successMessageStringRes;
                }
                return true;
            }

            public final int getSuccessMessageStringRes() {
                return this.successMessageStringRes;
            }

            public int hashCode() {
                return this.successMessageStringRes;
            }

            public String toString() {
                return a.B(a.U("SetStatusSuccess(successMessageStringRes="), this.successMessageStringRes, ")");
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetUserSetCustomStatusViewModel.kt */
    public static final /* data */ class FormState {
        private final Emoji emoji;
        private final Expiration expiration;
        private final String text;

        /* compiled from: WidgetUserSetCustomStatusViewModel.kt */
        public enum Expiration {
            NEVER,
            IN_30_MINUTES,
            IN_1_HOUR,
            IN_4_HOURS,
            TOMORROW
        }

        public FormState(Emoji emoji, String str, Expiration expiration) {
            m.checkNotNullParameter(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            m.checkNotNullParameter(expiration, "expiration");
            this.emoji = emoji;
            this.text = str;
            this.expiration = expiration;
        }

        public static /* synthetic */ FormState copy$default(FormState formState, Emoji emoji, String str, Expiration expiration, int i, Object obj) {
            if ((i & 1) != 0) {
                emoji = formState.emoji;
            }
            if ((i & 2) != 0) {
                str = formState.text;
            }
            if ((i & 4) != 0) {
                expiration = formState.expiration;
            }
            return formState.copy(emoji, str, expiration);
        }

        /* renamed from: component1, reason: from getter */
        public final Emoji getEmoji() {
            return this.emoji;
        }

        /* renamed from: component2, reason: from getter */
        public final String getText() {
            return this.text;
        }

        /* renamed from: component3, reason: from getter */
        public final Expiration getExpiration() {
            return this.expiration;
        }

        public final FormState copy(Emoji emoji, String text, Expiration expiration) {
            m.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            m.checkNotNullParameter(expiration, "expiration");
            return new FormState(emoji, text, expiration);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FormState)) {
                return false;
            }
            FormState formState = (FormState) other;
            return m.areEqual(this.emoji, formState.emoji) && m.areEqual(this.text, formState.text) && m.areEqual(this.expiration, formState.expiration);
        }

        public final Emoji getEmoji() {
            return this.emoji;
        }

        public final Expiration getExpiration() {
            return this.expiration;
        }

        public final String getText() {
            return this.text;
        }

        public int hashCode() {
            Emoji emoji = this.emoji;
            int iHashCode = (emoji != null ? emoji.hashCode() : 0) * 31;
            String str = this.text;
            int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
            Expiration expiration = this.expiration;
            return iHashCode2 + (expiration != null ? expiration.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = a.U("FormState(emoji=");
            sbU.append(this.emoji);
            sbU.append(", text=");
            sbU.append(this.text);
            sbU.append(", expiration=");
            sbU.append(this.expiration);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: WidgetUserSetCustomStatusViewModel.kt */
    public static final /* data */ class StoreState {
        private final ModelCustomStatusSetting customStatusSetting;
        private final EmojiSet emojiSet;

        public StoreState(ModelCustomStatusSetting modelCustomStatusSetting, EmojiSet emojiSet) {
            m.checkNotNullParameter(modelCustomStatusSetting, "customStatusSetting");
            m.checkNotNullParameter(emojiSet, "emojiSet");
            this.customStatusSetting = modelCustomStatusSetting;
            this.emojiSet = emojiSet;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, ModelCustomStatusSetting modelCustomStatusSetting, EmojiSet emojiSet, int i, Object obj) {
            if ((i & 1) != 0) {
                modelCustomStatusSetting = storeState.customStatusSetting;
            }
            if ((i & 2) != 0) {
                emojiSet = storeState.emojiSet;
            }
            return storeState.copy(modelCustomStatusSetting, emojiSet);
        }

        /* renamed from: component1, reason: from getter */
        public final ModelCustomStatusSetting getCustomStatusSetting() {
            return this.customStatusSetting;
        }

        /* renamed from: component2, reason: from getter */
        public final EmojiSet getEmojiSet() {
            return this.emojiSet;
        }

        public final StoreState copy(ModelCustomStatusSetting customStatusSetting, EmojiSet emojiSet) {
            m.checkNotNullParameter(customStatusSetting, "customStatusSetting");
            m.checkNotNullParameter(emojiSet, "emojiSet");
            return new StoreState(customStatusSetting, emojiSet);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return m.areEqual(this.customStatusSetting, storeState.customStatusSetting) && m.areEqual(this.emojiSet, storeState.emojiSet);
        }

        public final ModelCustomStatusSetting getCustomStatusSetting() {
            return this.customStatusSetting;
        }

        public final EmojiSet getEmojiSet() {
            return this.emojiSet;
        }

        public int hashCode() {
            ModelCustomStatusSetting modelCustomStatusSetting = this.customStatusSetting;
            int iHashCode = (modelCustomStatusSetting != null ? modelCustomStatusSetting.hashCode() : 0) * 31;
            EmojiSet emojiSet = this.emojiSet;
            return iHashCode + (emojiSet != null ? emojiSet.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = a.U("StoreState(customStatusSetting=");
            sbU.append(this.customStatusSetting);
            sbU.append(", emojiSet=");
            sbU.append(this.emojiSet);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: WidgetUserSetCustomStatusViewModel.kt */
    public static abstract class ViewState {

        /* compiled from: WidgetUserSetCustomStatusViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final FormState formState;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(FormState formState) {
                super(null);
                m.checkNotNullParameter(formState, "formState");
                this.formState = formState;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, FormState formState, int i, Object obj) {
                if ((i & 1) != 0) {
                    formState = loaded.formState;
                }
                return loaded.copy(formState);
            }

            /* renamed from: component1, reason: from getter */
            public final FormState getFormState() {
                return this.formState;
            }

            public final Loaded copy(FormState formState) {
                m.checkNotNullParameter(formState, "formState");
                return new Loaded(formState);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && m.areEqual(this.formState, ((Loaded) other).formState);
                }
                return true;
            }

            public final FormState getFormState() {
                return this.formState;
            }

            public final boolean getShowStatusClear() {
                if (this.formState.getEmoji() == null) {
                    if (!(this.formState.getText().length() > 0)) {
                        return false;
                    }
                }
                return true;
            }

            public int hashCode() {
                FormState formState = this.formState;
                if (formState != null) {
                    return formState.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = a.U("Loaded(formState=");
                sbU.append(this.formState);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: WidgetUserSetCustomStatusViewModel.kt */
        public static final class Uninitialized extends ViewState {
            public static final Uninitialized INSTANCE = new Uninitialized();

            private Uninitialized() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            FormState.Expiration.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[FormState.Expiration.NEVER.ordinal()] = 1;
            iArr[FormState.Expiration.IN_30_MINUTES.ordinal()] = 2;
            iArr[FormState.Expiration.IN_1_HOUR.ordinal()] = 3;
            iArr[FormState.Expiration.IN_4_HOURS.ordinal()] = 4;
            iArr[FormState.Expiration.TOMORROW.ordinal()] = 5;
        }
    }

    /* compiled from: WidgetUserSetCustomStatusViewModel.kt */
    /* renamed from: com.discord.widgets.user.WidgetUserSetCustomStatusViewModel$saveStatus$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<ModelUserSettings, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelUserSettings modelUserSettings) {
            invoke2(modelUserSettings);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelUserSettings modelUserSettings) {
            m.checkNotNullParameter(modelUserSettings, "it");
            WidgetUserSetCustomStatusViewModel.access$emitSetStatusSuccessEvent(WidgetUserSetCustomStatusViewModel.this);
        }
    }

    /* compiled from: WidgetUserSetCustomStatusViewModel.kt */
    /* renamed from: com.discord.widgets.user.WidgetUserSetCustomStatusViewModel$saveStatus$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Error, Unit> {
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
            WidgetUserSetCustomStatusViewModel.access$emitSetStatusFailureEvent(WidgetUserSetCustomStatusViewModel.this);
        }
    }

    public WidgetUserSetCustomStatusViewModel() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetUserSetCustomStatusViewModel(StoreUserSettings storeUserSettings, Clock clock, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        storeUserSettings = (i & 1) != 0 ? StoreStream.INSTANCE.getUserSettings() : storeUserSettings;
        clock = (i & 2) != 0 ? ClockFactory.get() : clock;
        if ((i & 4) != 0) {
            Companion companion = INSTANCE;
            StoreStream.Companion companion2 = StoreStream.INSTANCE;
            observable = Companion.access$observeStoreState(companion, companion2.getUserSettings(), companion2.getEmojis());
        }
        this(storeUserSettings, clock, observable);
    }

    public static final /* synthetic */ void access$emitSetStatusFailureEvent(WidgetUserSetCustomStatusViewModel widgetUserSetCustomStatusViewModel) {
        widgetUserSetCustomStatusViewModel.emitSetStatusFailureEvent();
    }

    public static final /* synthetic */ void access$emitSetStatusSuccessEvent(WidgetUserSetCustomStatusViewModel widgetUserSetCustomStatusViewModel) {
        widgetUserSetCustomStatusViewModel.emitSetStatusSuccessEvent();
    }

    public static final /* synthetic */ FormState.Expiration access$getDEFAULT_EXPIRATION$cp() {
        return DEFAULT_EXPIRATION;
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetUserSetCustomStatusViewModel widgetUserSetCustomStatusViewModel, StoreState storeState) {
        widgetUserSetCustomStatusViewModel.handleStoreState(storeState);
    }

    private final void emitSetStatusFailureEvent() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new Event.SetStatusFailure(R.string.default_failure_to_perform_action_message));
    }

    private final void emitSetStatusSuccessEvent() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new Event.SetStatusSuccess(R.string.custom_status_update_success));
    }

    private final Emoji getEmojiFromSetting(ModelCustomStatusSetting customStatusSetting, EmojiSet emojiSet) {
        String emojiName;
        if (customStatusSetting == ModelCustomStatusSetting.INSTANCE.getCLEAR()) {
            return null;
        }
        Long emojiId = customStatusSetting.getEmojiId();
        if (emojiId == null || (emojiName = String.valueOf(emojiId.longValue())) == null) {
            emojiName = customStatusSetting.getEmojiName();
        }
        return emojiSet.emojiIndex.get(emojiName);
    }

    private final String getExpirationUTCDateString(FormState.Expiration expiresAt) {
        Long lValueOf;
        long jCurrentTimeMillis = this.clock.currentTimeMillis();
        int iOrdinal = expiresAt.ordinal();
        if (iOrdinal == 0) {
            lValueOf = null;
        } else if (iOrdinal == 1) {
            lValueOf = Long.valueOf(jCurrentTimeMillis + StoreGuildScheduledEvents.FETCH_GUILD_EVENTS_THRESHOLD);
        } else if (iOrdinal == 2) {
            lValueOf = Long.valueOf(jCurrentTimeMillis + 3600000);
        } else if (iOrdinal == 3) {
            lValueOf = Long.valueOf(jCurrentTimeMillis + 14400000);
        } else {
            if (iOrdinal != 4) {
                throw new NoWhenBranchMatchedException();
            }
            Calendar calendar = TimeUtils.toCalendar(jCurrentTimeMillis);
            calendar.add(5, 1);
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            lValueOf = Long.valueOf(calendar.getTimeInMillis());
        }
        return TimeUtils.toUTCDateTime$default(lValueOf, null, 2, null);
    }

    private final String getStatusTextFromSetting(ModelCustomStatusSetting customStatusSetting) {
        if (customStatusSetting != ModelCustomStatusSetting.INSTANCE.getCLEAR()) {
            return customStatusSetting.getText();
        }
        return null;
    }

    private final void handleStoreState(StoreState storeState) {
        if (getViewState() instanceof ViewState.Loaded) {
            return;
        }
        Emoji emojiFromSetting = getEmojiFromSetting(storeState.getCustomStatusSetting(), storeState.getEmojiSet());
        String statusTextFromSetting = getStatusTextFromSetting(storeState.getCustomStatusSetting());
        if (statusTextFromSetting == null) {
            statusTextFromSetting = "";
        }
        updateViewState(new ViewState.Loaded(new FormState(emojiFromSetting, statusTextFromSetting, DEFAULT_EXPIRATION)));
    }

    private final void updateFormState(FormState formState) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateViewState(loaded.copy(formState));
        }
    }

    public final void clearStatusTextAndEmoji() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateFormState(FormState.copy$default(loaded.getFormState(), null, "", null, 4, null));
        }
    }

    public final Clock getClock() {
        return this.clock;
    }

    public final StoreUserSettings getStoreUserSettings() {
        return this.storeUserSettings;
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void saveStatus() {
        ModelCustomStatusSetting modelCustomStatusSetting;
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            FormState formState = loaded.getFormState();
            String text = formState.getText();
            Objects.requireNonNull(text, "null cannot be cast to non-null type kotlin.CharSequence");
            String string = w.trim(text).toString();
            if (!(string.length() > 0)) {
                string = null;
            }
            FormState formState2 = string != null || formState.getEmoji() != null ? formState : null;
            if (formState2 != null) {
                Emoji emoji = formState2.getEmoji();
                if (!(emoji instanceof ModelEmojiCustom)) {
                    emoji = null;
                }
                ModelEmojiCustom modelEmojiCustom = (ModelEmojiCustom) emoji;
                Long lValueOf = modelEmojiCustom != null ? Long.valueOf(modelEmojiCustom.getId()) : null;
                Emoji emoji2 = formState2.getEmoji();
                if (!(emoji2 instanceof ModelEmojiUnicode)) {
                    emoji2 = null;
                }
                ModelEmojiUnicode modelEmojiUnicode = (ModelEmojiUnicode) emoji2;
                modelCustomStatusSetting = new ModelCustomStatusSetting(string, lValueOf, modelEmojiUnicode != null ? modelEmojiUnicode.getSurrogates() : null, getExpirationUTCDateString(formState2.getExpiration()));
            } else {
                modelCustomStatusSetting = null;
            }
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.storeUserSettings.updateCustomStatus(modelCustomStatusSetting), false, 1, null), this, null, 2, null), WidgetUserSetCustomStatusViewModel.class, (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new AnonymousClass1(), 54, (Object) null);
            if (modelCustomStatusSetting != null) {
                AnalyticsTracker.INSTANCE.customStatusUpdated(formState, new Traits.Location(null, "Account Panel", "Avatar", null, null, 25, null));
            }
        }
    }

    public final void setExpiration(FormState.Expiration expiration) {
        m.checkNotNullParameter(expiration, "expiration");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateFormState(FormState.copy$default(loaded.getFormState(), null, null, expiration, 3, null));
        }
    }

    public final void setStatusEmoji(Emoji emoji) {
        m.checkNotNullParameter(emoji, "emoji");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateFormState(FormState.copy$default(loaded.getFormState(), emoji, null, null, 6, null));
        }
    }

    public final void setStatusText(String text) {
        m.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateFormState(FormState.copy$default(loaded.getFormState(), null, text, null, 5, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserSetCustomStatusViewModel(StoreUserSettings storeUserSettings, Clock clock, Observable<StoreState> observable) {
        super(ViewState.Uninitialized.INSTANCE);
        m.checkNotNullParameter(storeUserSettings, "storeUserSettings");
        m.checkNotNullParameter(clock, "clock");
        m.checkNotNullParameter(observable, "storeObservable");
        this.storeUserSettings = storeUserSettings;
        this.clock = clock;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), WidgetUserSetCustomStatusViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        this.eventSubject = PublishSubject.k0();
    }
}
