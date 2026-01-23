package com.discord.widgets.voice.feedback;

import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AppViewModel;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.Observable;
import p658rx.subjects.PublishSubject;

/* JADX INFO: compiled from: IssueDetailsFormViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class IssueDetailsFormViewModel extends AppViewModel<Unit> {
    private final PublishSubject<Event> eventSubject;
    private final FeedbackSubmitter feedbackSubmitter;
    private final PendingFeedback pendingFeedback;
    private boolean submitted;

    /* JADX INFO: compiled from: IssueDetailsFormViewModel.kt */
    public static abstract class Event {

        /* JADX INFO: compiled from: IssueDetailsFormViewModel.kt */
        public static final class Close extends Event {
            public static final Close INSTANCE = new Close();

            private Close() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ IssueDetailsFormViewModel(PendingFeedback pendingFeedback, FeedbackSubmitter feedbackSubmitter, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(pendingFeedback, (i & 2) != 0 ? FeedbackSubmitterFactory.INSTANCE.create(pendingFeedback) : feedbackSubmitter);
    }

    public final Observable<Event> observeEvents() {
        return this.eventSubject;
    }

    @Override // p007b.p008a.p018d.AppViewModel, androidx.view.ViewModel
    public void onCleared() {
        super.onCleared();
        submitForm(null);
    }

    public final void submitForm(String issueDetails) {
        if (this.submitted) {
            return;
        }
        this.submitted = true;
        this.feedbackSubmitter.submit(issueDetails);
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.f27650k.onNext(Event.Close.INSTANCE);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IssueDetailsFormViewModel(PendingFeedback pendingFeedback, FeedbackSubmitter feedbackSubmitter) {
        super(Unit.f27425a);
        Intrinsics3.checkNotNullParameter(pendingFeedback, "pendingFeedback");
        Intrinsics3.checkNotNullParameter(feedbackSubmitter, "feedbackSubmitter");
        this.pendingFeedback = pendingFeedback;
        this.feedbackSubmitter = feedbackSubmitter;
        PublishSubject<Event> publishSubjectM11133k0 = PublishSubject.m11133k0();
        Intrinsics3.checkNotNullExpressionValue(publishSubjectM11133k0, "PublishSubject.create()");
        this.eventSubject = publishSubjectM11133k0;
    }
}
