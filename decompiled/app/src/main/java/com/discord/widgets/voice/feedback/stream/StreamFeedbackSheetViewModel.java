package com.discord.widgets.voice.feedback.stream;

import android.content.Context;
import b.a.d.d0;
import b.d.b.a.a;
import com.discord.R;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.feedback.FeedbackSheetViewModel;
import com.discord.widgets.voice.feedback.FeedbackIssue;
import com.discord.widgets.voice.feedback.FeedbackRating;
import com.discord.widgets.voice.feedback.PendingFeedback;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Collection;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: StreamFeedbackSheetViewModel.kt */
/* loaded from: classes.dex */
public final class StreamFeedbackSheetViewModel extends d0<FeedbackSheetViewModel.ViewState> implements FeedbackSheetViewModel {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<FeedbackIssue> ISSUES_UI_OPTIONS = n.listOf((Object[]) new FeedbackIssue[]{FeedbackIssue.STREAM_REPORT_ENDED_BLACK, FeedbackIssue.STREAM_REPORT_ENDED_BLURRY, FeedbackIssue.STREAM_REPORT_ENDED_LAGGING, FeedbackIssue.STREAM_REPORT_ENDED_OUT_OF_SYNC, FeedbackIssue.STREAM_REPORT_ENDED_AUDIO_MISSING, FeedbackIssue.STREAM_REPORT_ENDED_AUDIO_POOR, FeedbackIssue.STREAM_REPORT_ENDED_STREAM_STOPPED_UNEXPECTEDLY});
    private final PublishSubject<FeedbackSheetViewModel.Event> eventSubject;
    private final List<FeedbackIssue> issuesUiOptions;
    private StoreState mostRecentStoreState;
    private PendingFeedback.StreamFeedback pendingStreamFeedback;
    private final StoreAnalytics storeAnalytics;
    private final StoreExperiments storeExperiments;
    private final ModelApplicationStream stream;
    private boolean submitOnDismiss;
    private boolean submitted;

    /* compiled from: StreamFeedbackSheetViewModel.kt */
    /* renamed from: com.discord.widgets.voice.feedback.stream.StreamFeedbackSheetViewModel$1, reason: invalid class name */
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
            StreamFeedbackSheetViewModel.access$setMostRecentStoreState$p(StreamFeedbackSheetViewModel.this, storeState);
        }
    }

    /* compiled from: StreamFeedbackSheetViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStoreState(Companion companion, StoreExperiments storeExperiments) {
            return companion.observeStoreState(storeExperiments);
        }

        private final Observable<StoreState> observeStoreState(StoreExperiments storeExperiments) {
            Observable observableG = storeExperiments.observeUserExperiment("2020-08_feedback_modal_helpdesk_link", true).G(StreamFeedbackSheetViewModel$Companion$observeStoreState$1.INSTANCE);
            m.checkNotNullExpressionValue(observableG, "storeExperiments\n       …            )\n          }");
            return observableG;
        }

        public final List<FeedbackIssue> getISSUES_UI_OPTIONS() {
            return StreamFeedbackSheetViewModel.access$getISSUES_UI_OPTIONS$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StreamFeedbackSheetViewModel.kt */
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

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ StreamFeedbackSheetViewModel(String str, String str2, StoreExperiments storeExperiments, StoreAnalytics storeAnalytics, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreExperiments experiments = (i & 4) != 0 ? StoreStream.INSTANCE.getExperiments() : storeExperiments;
        this(str, str2, experiments, (i & 8) != 0 ? StoreStream.INSTANCE.getAnalytics() : storeAnalytics, (i & 16) != 0 ? Companion.access$observeStoreState(INSTANCE, experiments) : observable);
    }

    public static final /* synthetic */ List access$getISSUES_UI_OPTIONS$cp() {
        return ISSUES_UI_OPTIONS;
    }

    public static final /* synthetic */ StoreState access$getMostRecentStoreState$p(StreamFeedbackSheetViewModel streamFeedbackSheetViewModel) {
        return streamFeedbackSheetViewModel.mostRecentStoreState;
    }

    public static final /* synthetic */ void access$setMostRecentStoreState$p(StreamFeedbackSheetViewModel streamFeedbackSheetViewModel, StoreState storeState) {
        streamFeedbackSheetViewModel.mostRecentStoreState = storeState;
    }

    private final FeedbackSheetViewModel.ViewState createViewState(FeedbackRating selectedFeedbackRating, List<? extends FeedbackIssue> feedbackIssues) {
        return new FeedbackSheetViewModel.ViewState(selectedFeedbackRating, feedbackIssues, R.string.stream_report_a_problem_post_stream, Integer.valueOf(R.string.stream_report_rating_body), R.string.stream_report_placeholder);
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
        PendingFeedback.StreamFeedback streamFeedbackCopy$default = PendingFeedback.StreamFeedback.copy$default(this.pendingStreamFeedback, null, null, feedbackIssue, null, null, 27, null);
        this.pendingStreamFeedback = streamFeedbackCopy$default;
        if (feedbackIssue == FeedbackIssue.OTHER) {
            this.submitOnDismiss = false;
            PublishSubject<FeedbackSheetViewModel.Event> publishSubject = this.eventSubject;
            StoreState storeState = this.mostRecentStoreState;
            publishSubject.k.onNext(new FeedbackSheetViewModel.Event.NavigateToIssueDetails(streamFeedbackCopy$default, storeState != null ? storeState.getShouldShowCxLinkForIssueDetails() : false));
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
        this.pendingStreamFeedback = PendingFeedback.StreamFeedback.copy$default(this.pendingStreamFeedback, null, feedbackRating, null, null, null, 29, null);
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
        this.storeAnalytics.trackStreamReportProblem(this.pendingStreamFeedback);
        emitSubmittedEvent(selectedFeedbackRating != FeedbackRating.NO_RESPONSE);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamFeedbackSheetViewModel(String str, String str2, StoreExperiments storeExperiments, StoreAnalytics storeAnalytics, Observable<StoreState> observable) {
        super(new FeedbackSheetViewModel.ViewState(FeedbackRating.NO_RESPONSE, n.emptyList(), R.string.stream_report_a_problem_post_stream, Integer.valueOf(R.string.stream_report_rating_body), R.string.stream_report_placeholder));
        m.checkNotNullParameter(str, "streamKey");
        m.checkNotNullParameter(storeExperiments, "storeExperiments");
        m.checkNotNullParameter(storeAnalytics, "storeAnalytics");
        m.checkNotNullParameter(observable, "storeStateObservable");
        this.storeExperiments = storeExperiments;
        this.storeAnalytics = storeAnalytics;
        this.eventSubject = PublishSubject.k0();
        this.submitOnDismiss = true;
        ModelApplicationStream modelApplicationStreamDecodeStreamKey = ModelApplicationStream.INSTANCE.decodeStreamKey(str);
        this.stream = modelApplicationStreamDecodeStreamKey;
        this.pendingStreamFeedback = new PendingFeedback.StreamFeedback(modelApplicationStreamDecodeStreamKey, null, null, str2, null, 22, null);
        this.issuesUiOptions = u.plus((Collection<? extends FeedbackIssue>) d0.t.m.shuffled(ISSUES_UI_OPTIONS), FeedbackIssue.OTHER);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), StreamFeedbackSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
