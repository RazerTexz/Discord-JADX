package com.discord.widgets.voice.feedback;

import com.discord.widgets.guild_delete_feedback.GuildDeleteFeedbackSubmitter;
import com.discord.widgets.voice.feedback.PendingFeedback;
import com.discord.widgets.voice.feedback.call.CallFeedbackSubmitter;
import com.discord.widgets.voice.feedback.stream.StreamFeedbackSubmitter;
import d0.z.d.Intrinsics3;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: FeedbackSubmitterFactory.kt */
/* loaded from: classes.dex */
public final class FeedbackSubmitterFactory {
    public static final FeedbackSubmitterFactory INSTANCE = new FeedbackSubmitterFactory();

    private FeedbackSubmitterFactory() {
    }

    public final FeedbackSubmitter create(PendingFeedback pendingFeedback) {
        Intrinsics3.checkNotNullParameter(pendingFeedback, "pendingFeedback");
        if (pendingFeedback instanceof PendingFeedback.CallFeedback) {
            return new CallFeedbackSubmitter((PendingFeedback.CallFeedback) pendingFeedback, null, 2, null);
        }
        if (pendingFeedback instanceof PendingFeedback.StreamFeedback) {
            return new StreamFeedbackSubmitter((PendingFeedback.StreamFeedback) pendingFeedback, null, 2, null);
        }
        if (pendingFeedback instanceof PendingFeedback.GuildDeleteFeedback) {
            return new GuildDeleteFeedbackSubmitter((PendingFeedback.GuildDeleteFeedback) pendingFeedback);
        }
        throw new NoWhenBranchMatchedException();
    }
}
