package com.discord.widgets.voice.feedback;

import android.view.View;
import com.discord.widgets.voice.feedback.FeedbackView;

/* JADX INFO: renamed from: com.discord.widgets.voice.feedback.FeedbackView$IssueViewHolder$onConfigure$1, reason: use source file name */
/* JADX INFO: compiled from: FeedbackView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FeedbackView2 implements View.OnClickListener {
    public final /* synthetic */ FeedbackIssue $data;
    public final /* synthetic */ FeedbackView.IssueViewHolder this$0;

    public FeedbackView2(FeedbackView.IssueViewHolder issueViewHolder, FeedbackIssue feedbackIssue) {
        this.this$0 = issueViewHolder;
        this.$data = feedbackIssue;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        FeedbackView.IssueViewHolder.access$getAdapter$p(this.this$0).getOnIssueClick().invoke(this.$data);
    }
}
