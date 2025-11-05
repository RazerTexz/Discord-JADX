package com.discord.widgets.voice.feedback.call;

import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreStream;
import com.discord.widgets.voice.feedback.FeedbackSubmitter;
import com.discord.widgets.voice.feedback.PendingFeedback;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;

/* compiled from: CallFeedbackSubmitter.kt */
/* loaded from: classes.dex */
public final class CallFeedbackSubmitter implements FeedbackSubmitter {
    private final StoreAnalytics analyticsStore;
    private PendingFeedback.CallFeedback pendingCallFeedback;

    public CallFeedbackSubmitter(PendingFeedback.CallFeedback callFeedback, StoreAnalytics storeAnalytics) {
        Intrinsics3.checkNotNullParameter(callFeedback, "pendingCallFeedback");
        Intrinsics3.checkNotNullParameter(storeAnalytics, "analyticsStore");
        this.pendingCallFeedback = callFeedback;
        this.analyticsStore = storeAnalytics;
    }

    public final PendingFeedback.CallFeedback getPendingCallFeedback() {
        return this.pendingCallFeedback;
    }

    public final void setPendingCallFeedback(PendingFeedback.CallFeedback callFeedback) {
        Intrinsics3.checkNotNullParameter(callFeedback, "<set-?>");
        this.pendingCallFeedback = callFeedback;
    }

    @Override // com.discord.widgets.voice.feedback.FeedbackSubmitter
    public void submit(String issueDetails) {
        this.analyticsStore.trackCallReportProblem(issueDetails != null ? PendingFeedback.CallFeedback.copy$default(this.pendingCallFeedback, 0L, null, null, null, null, null, null, issueDetails, Opcodes.LAND, null) : this.pendingCallFeedback);
    }

    public /* synthetic */ CallFeedbackSubmitter(PendingFeedback.CallFeedback callFeedback, StoreAnalytics storeAnalytics, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(callFeedback, (i & 2) != 0 ? StoreStream.INSTANCE.getAnalytics() : storeAnalytics);
    }
}
