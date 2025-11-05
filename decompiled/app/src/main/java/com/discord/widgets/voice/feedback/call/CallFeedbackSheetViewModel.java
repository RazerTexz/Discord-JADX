package com.discord.widgets.voice.feedback.call;

import a0.a.a.b;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.VisibleForTesting;
import b.a.d.d0;
import b.d.b.a.a;
import com.discord.R;
import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.feedback.FeedbackSheetViewModel;
import com.discord.widgets.voice.feedback.FeedbackIssue;
import com.discord.widgets.voice.feedback.FeedbackRating;
import com.discord.widgets.voice.feedback.PendingFeedback;
import d0.t.h0;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: CallFeedbackSheetViewModel.kt */
/* loaded from: classes.dex */
public final class CallFeedbackSheetViewModel extends d0<FeedbackSheetViewModel.ViewState> implements FeedbackSheetViewModel {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<FeedbackIssue> ISSUES_UI_OPTIONS;
    private static final Map<FeedbackIssue, Integer> REASON_CODES;
    private final PublishSubject<FeedbackSheetViewModel.Event> eventSubject;
    private final List<FeedbackIssue> issuesUiOptions;
    private StoreState mostRecentStoreState;
    private PendingFeedback.CallFeedback pendingCallFeedback;
    private final StoreAnalytics storeAnalytics;
    private final StoreExperiments storeExperiments;
    private boolean submitOnDismiss;
    private boolean submitted;

    /* compiled from: CallFeedbackSheetViewModel.kt */
    /* renamed from: com.discord.widgets.voice.feedback.call.CallFeedbackSheetViewModel$1, reason: invalid class name */
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
            CallFeedbackSheetViewModel.access$setMostRecentStoreState$p(CallFeedbackSheetViewModel.this, storeState);
        }
    }

    /* compiled from: CallFeedbackSheetViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStoreState(Companion companion, StoreExperiments storeExperiments) {
            return companion.observeStoreState(storeExperiments);
        }

        @VisibleForTesting
        public static /* synthetic */ void getREASON_CODES$annotations() {
        }

        private final Observable<StoreState> observeStoreState(StoreExperiments storeExperiments) {
            Observable observableG = storeExperiments.observeUserExperiment("2020-08_feedback_modal_helpdesk_link", true).G(CallFeedbackSheetViewModel$Companion$observeStoreState$1.INSTANCE);
            m.checkNotNullExpressionValue(observableG, "storeExperiments\n       …            )\n          }");
            return observableG;
        }

        public final List<FeedbackIssue> getISSUES_UI_OPTIONS() {
            return CallFeedbackSheetViewModel.access$getISSUES_UI_OPTIONS$cp();
        }

        public final Map<FeedbackIssue, Integer> getREASON_CODES() {
            return CallFeedbackSheetViewModel.access$getREASON_CODES$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: CallFeedbackSheetViewModel.kt */
    public static final /* data */ class Config implements Parcelable {

        /* renamed from: CREATOR, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Long callDurationMs;
        private final long channelId;
        private final String mediaSessionId;
        private final String rtcConnectionId;

        /* compiled from: CallFeedbackSheetViewModel.kt */
        /* renamed from: com.discord.widgets.voice.feedback.call.CallFeedbackSheetViewModel$Config$CREATOR, reason: from kotlin metadata */
        public static final class Companion implements Parcelable.Creator<Config> {
            private Companion() {
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Config createFromParcel(Parcel parcel) {
                return createFromParcel(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Config[] newArray(int i) {
                return newArray(i);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Config createFromParcel(Parcel parcel) {
                m.checkNotNullParameter(parcel, "parcel");
                return new Config(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Config[] newArray(int size) {
                return new Config[size];
            }
        }

        public Config(long j, String str, String str2, Long l) {
            this.channelId = j;
            this.rtcConnectionId = str;
            this.mediaSessionId = str2;
            this.callDurationMs = l;
        }

        public static /* synthetic */ Config copy$default(Config config, long j, String str, String str2, Long l, int i, Object obj) {
            if ((i & 1) != 0) {
                j = config.channelId;
            }
            long j2 = j;
            if ((i & 2) != 0) {
                str = config.rtcConnectionId;
            }
            String str3 = str;
            if ((i & 4) != 0) {
                str2 = config.mediaSessionId;
            }
            String str4 = str2;
            if ((i & 8) != 0) {
                l = config.callDurationMs;
            }
            return config.copy(j2, str3, str4, l);
        }

        /* renamed from: component1, reason: from getter */
        public final long getChannelId() {
            return this.channelId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getRtcConnectionId() {
            return this.rtcConnectionId;
        }

        /* renamed from: component3, reason: from getter */
        public final String getMediaSessionId() {
            return this.mediaSessionId;
        }

        /* renamed from: component4, reason: from getter */
        public final Long getCallDurationMs() {
            return this.callDurationMs;
        }

        public final Config copy(long channelId, String rtcConnectionId, String mediaSessionId, Long callDurationMs) {
            return new Config(channelId, rtcConnectionId, mediaSessionId, callDurationMs);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Config)) {
                return false;
            }
            Config config = (Config) other;
            return this.channelId == config.channelId && m.areEqual(this.rtcConnectionId, config.rtcConnectionId) && m.areEqual(this.mediaSessionId, config.mediaSessionId) && m.areEqual(this.callDurationMs, config.callDurationMs);
        }

        public final Long getCallDurationMs() {
            return this.callDurationMs;
        }

        public final long getChannelId() {
            return this.channelId;
        }

        public final String getMediaSessionId() {
            return this.mediaSessionId;
        }

        public final String getRtcConnectionId() {
            return this.rtcConnectionId;
        }

        public int hashCode() {
            int iA = b.a(this.channelId) * 31;
            String str = this.rtcConnectionId;
            int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.mediaSessionId;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            Long l = this.callDurationMs;
            return iHashCode2 + (l != null ? l.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = a.U("Config(channelId=");
            sbU.append(this.channelId);
            sbU.append(", rtcConnectionId=");
            sbU.append(this.rtcConnectionId);
            sbU.append(", mediaSessionId=");
            sbU.append(this.mediaSessionId);
            sbU.append(", callDurationMs=");
            return a.G(sbU, this.callDurationMs, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            m.checkNotNullParameter(parcel, "parcel");
            parcel.writeLong(this.channelId);
            parcel.writeString(this.rtcConnectionId);
            parcel.writeString(this.mediaSessionId);
            parcel.writeValue(this.callDurationMs);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public Config(Parcel parcel) {
            m.checkNotNullParameter(parcel, "parcel");
            long j = parcel.readLong();
            String string = parcel.readString();
            String string2 = parcel.readString();
            Object value = parcel.readValue(Long.TYPE.getClassLoader());
            this(j, string, string2, (Long) (value instanceof Long ? value : null));
        }
    }

    /* compiled from: CallFeedbackSheetViewModel.kt */
    public static final /* data */ class StoreState {
        private final boolean shouldShowCxLinkForIssueDetails;

        public StoreState(boolean z2) {
            this.shouldShowCxLinkForIssueDetails = z2;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = storeState.shouldShowCxLinkForIssueDetails;
            }
            return storeState.copy(z2);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getShouldShowCxLinkForIssueDetails() {
            return this.shouldShowCxLinkForIssueDetails;
        }

        public final StoreState copy(boolean shouldShowCxLinkForIssueDetails) {
            return new StoreState(shouldShowCxLinkForIssueDetails);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof StoreState) && this.shouldShowCxLinkForIssueDetails == ((StoreState) other).shouldShowCxLinkForIssueDetails;
            }
            return true;
        }

        public final boolean getShouldShowCxLinkForIssueDetails() {
            return this.shouldShowCxLinkForIssueDetails;
        }

        public int hashCode() {
            boolean z2 = this.shouldShowCxLinkForIssueDetails;
            if (z2) {
                return 1;
            }
            return z2 ? 1 : 0;
        }

        public String toString() {
            return a.O(a.U("StoreState(shouldShowCxLinkForIssueDetails="), this.shouldShowCxLinkForIssueDetails, ")");
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            FeedbackRating.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[FeedbackRating.NO_RESPONSE.ordinal()] = 1;
            iArr[FeedbackRating.GOOD.ordinal()] = 2;
            FeedbackRating feedbackRating = FeedbackRating.NEUTRAL;
            iArr[feedbackRating.ordinal()] = 3;
            FeedbackRating feedbackRating2 = FeedbackRating.BAD;
            iArr[feedbackRating2.ordinal()] = 4;
            FeedbackRating.values();
            int[] iArr2 = new int[4];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[feedbackRating.ordinal()] = 1;
            iArr2[feedbackRating2.ordinal()] = 2;
        }
    }

    static {
        FeedbackIssue feedbackIssue = FeedbackIssue.COULD_NOT_HEAR_AUDIO;
        FeedbackIssue feedbackIssue2 = FeedbackIssue.NOBODY_COULD_HEAR_ME;
        FeedbackIssue feedbackIssue3 = FeedbackIssue.AUDIO_ECHOS;
        FeedbackIssue feedbackIssue4 = FeedbackIssue.AUDIO_ROBOTIC;
        FeedbackIssue feedbackIssue5 = FeedbackIssue.AUDIO_CUT_IN_AND_OUT;
        FeedbackIssue feedbackIssue6 = FeedbackIssue.VOLUME_TOO_LOW_OR_HIGH;
        FeedbackIssue feedbackIssue7 = FeedbackIssue.BACKGROUND_NOISE_TOO_LOUD;
        FeedbackIssue feedbackIssue8 = FeedbackIssue.SPEAKERPHONE_ISSUE;
        FeedbackIssue feedbackIssue9 = FeedbackIssue.HEADSET_OR_BLUETOOTH_ISSUE;
        ISSUES_UI_OPTIONS = n.listOf((Object[]) new FeedbackIssue[]{feedbackIssue, feedbackIssue2, feedbackIssue3, feedbackIssue4, feedbackIssue5, feedbackIssue6, feedbackIssue7, feedbackIssue8, feedbackIssue9});
        REASON_CODES = h0.mapOf(d0.o.to(FeedbackIssue.OTHER, 1), d0.o.to(feedbackIssue, 2), d0.o.to(feedbackIssue2, 3), d0.o.to(feedbackIssue3, 4), d0.o.to(feedbackIssue4, 5), d0.o.to(feedbackIssue5, 6), d0.o.to(feedbackIssue6, 7), d0.o.to(feedbackIssue7, 8), d0.o.to(feedbackIssue8, 9), d0.o.to(feedbackIssue9, 10));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ CallFeedbackSheetViewModel(Config config, StoreAnalytics storeAnalytics, StoreExperiments storeExperiments, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        storeAnalytics = (i & 2) != 0 ? StoreStream.INSTANCE.getAnalytics() : storeAnalytics;
        storeExperiments = (i & 4) != 0 ? StoreStream.INSTANCE.getExperiments() : storeExperiments;
        this(config, storeAnalytics, storeExperiments, (i & 8) != 0 ? Companion.access$observeStoreState(INSTANCE, storeExperiments) : observable);
    }

    public static final /* synthetic */ List access$getISSUES_UI_OPTIONS$cp() {
        return ISSUES_UI_OPTIONS;
    }

    public static final /* synthetic */ StoreState access$getMostRecentStoreState$p(CallFeedbackSheetViewModel callFeedbackSheetViewModel) {
        return callFeedbackSheetViewModel.mostRecentStoreState;
    }

    public static final /* synthetic */ Map access$getREASON_CODES$cp() {
        return REASON_CODES;
    }

    public static final /* synthetic */ void access$setMostRecentStoreState$p(CallFeedbackSheetViewModel callFeedbackSheetViewModel, StoreState storeState) {
        callFeedbackSheetViewModel.mostRecentStoreState = storeState;
    }

    private final FeedbackSheetViewModel.ViewState createViewState(FeedbackRating selectedFeedbackRating, List<? extends FeedbackIssue> feedbackIssues) {
        return new FeedbackSheetViewModel.ViewState(selectedFeedbackRating, feedbackIssues, R.string.call_feedback_sheet_title, Integer.valueOf(R.string.call_feedback_prompt), R.string.call_feedback_issue_section_header);
    }

    private final void emitSubmittedEvent(boolean showConfirmation) {
        PublishSubject<FeedbackSheetViewModel.Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new FeedbackSheetViewModel.Event.Submitted(showConfirmation));
    }

    @Override // com.discord.widgets.feedback.FeedbackSheetViewModel
    public Observable<FeedbackSheetViewModel.Event> observeEvents() {
        PublishSubject<FeedbackSheetViewModel.Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    @Override // b.a.d.d0, androidx.view.ViewModel
    public void onCleared() {
        super.onCleared();
        if (this.submitOnDismiss) {
            submitForm();
        }
    }

    @Override // com.discord.widgets.feedback.FeedbackSheetViewModel
    public void selectIssue(FeedbackIssue feedbackIssue, String reasonDescription) {
        PendingFeedback.CallFeedback callFeedbackCopy$default = PendingFeedback.CallFeedback.copy$default(this.pendingCallFeedback, 0L, null, null, null, null, REASON_CODES.get(feedbackIssue), reasonDescription, null, Opcodes.IF_ICMPEQ, null);
        this.pendingCallFeedback = callFeedbackCopy$default;
        if (feedbackIssue == FeedbackIssue.OTHER) {
            this.submitOnDismiss = false;
            PublishSubject<FeedbackSheetViewModel.Event> publishSubject = this.eventSubject;
            StoreState storeState = this.mostRecentStoreState;
            publishSubject.k.onNext(new FeedbackSheetViewModel.Event.NavigateToIssueDetails(callFeedbackCopy$default, storeState != null ? storeState.getShouldShowCxLinkForIssueDetails() : false));
            return;
        }
        int iOrdinal = requireViewState().getSelectedFeedbackRating().ordinal();
        if (iOrdinal == 1 || iOrdinal == 2) {
            submitForm();
        }
    }

    @Override // com.discord.widgets.feedback.FeedbackSheetViewModel
    public void selectRating(FeedbackRating feedbackRating) {
        m.checkNotNullParameter(feedbackRating, "feedbackRating");
        this.pendingCallFeedback = PendingFeedback.CallFeedback.copy$default(this.pendingCallFeedback, 0L, null, null, null, feedbackRating, null, null, null, 239, null);
        int iOrdinal = feedbackRating.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1 || iOrdinal == 2) {
                updateViewState(createViewState(feedbackRating, this.issuesUiOptions));
                return;
            } else if (iOrdinal != 3) {
                return;
            }
        }
        selectIssue(null, null);
        updateViewState(createViewState(feedbackRating, n.emptyList()));
        submitForm();
    }

    @Override // com.discord.widgets.feedback.FeedbackSheetViewModel
    public void submitForm() {
        if (this.submitted) {
            return;
        }
        this.submitted = true;
        FeedbackRating selectedFeedbackRating = requireViewState().getSelectedFeedbackRating();
        this.storeAnalytics.trackCallReportProblem(this.pendingCallFeedback);
        emitSubmittedEvent(selectedFeedbackRating != FeedbackRating.NO_RESPONSE);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallFeedbackSheetViewModel(Config config, StoreAnalytics storeAnalytics, StoreExperiments storeExperiments, Observable<StoreState> observable) {
        super(new FeedbackSheetViewModel.ViewState(FeedbackRating.NO_RESPONSE, n.emptyList(), R.string.call_feedback_sheet_title, Integer.valueOf(R.string.call_feedback_prompt), R.string.call_feedback_issue_section_header));
        m.checkNotNullParameter(config, "config");
        m.checkNotNullParameter(storeAnalytics, "storeAnalytics");
        m.checkNotNullParameter(storeExperiments, "storeExperiments");
        m.checkNotNullParameter(observable, "storeStateObservable");
        this.storeAnalytics = storeAnalytics;
        this.storeExperiments = storeExperiments;
        this.eventSubject = PublishSubject.k0();
        this.submitOnDismiss = true;
        this.pendingCallFeedback = new PendingFeedback.CallFeedback(config.getChannelId(), config.getRtcConnectionId(), config.getCallDurationMs(), config.getMediaSessionId(), null, null, null, null, 240, null);
        this.issuesUiOptions = u.plus((Collection<? extends FeedbackIssue>) d0.t.m.shuffled(ISSUES_UI_OPTIONS), FeedbackIssue.OTHER);
        storeAnalytics.trackShowCallFeedbackSheet(config.getChannelId());
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), CallFeedbackSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
