package com.discord.widgets.voice.feedback.call;

import androidx.core.app.NotificationCompat;
import com.discord.models.experiments.domain.Experiment;
import com.discord.widgets.voice.feedback.call.CallFeedbackSheetViewModel;
import j0.k.Func1;

/* compiled from: CallFeedbackSheetViewModel.kt */
/* renamed from: com.discord.widgets.voice.feedback.call.CallFeedbackSheetViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes.dex */
public final class CallFeedbackSheetViewModel2<T, R> implements Func1<Experiment, CallFeedbackSheetViewModel.StoreState> {
    public static final CallFeedbackSheetViewModel2 INSTANCE = new CallFeedbackSheetViewModel2();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ CallFeedbackSheetViewModel.StoreState call(Experiment experiment) {
        return call2(experiment);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final CallFeedbackSheetViewModel.StoreState call2(Experiment experiment) {
        return new CallFeedbackSheetViewModel.StoreState(experiment != null && experiment.getBucket() == 1);
    }
}
