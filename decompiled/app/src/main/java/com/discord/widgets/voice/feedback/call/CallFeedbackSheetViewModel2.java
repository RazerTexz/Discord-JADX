package com.discord.widgets.voice.feedback.call;

import androidx.core.app.NotificationCompat;
import com.discord.models.experiments.domain.Experiment;
import com.discord.widgets.voice.feedback.call.CallFeedbackSheetViewModel;
import p637j0.p641k.Func1;

/* JADX INFO: renamed from: com.discord.widgets.voice.feedback.call.CallFeedbackSheetViewModel$Companion$observeStoreState$1, reason: use source file name */
/* JADX INFO: compiled from: CallFeedbackSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CallFeedbackSheetViewModel2<T, R> implements Func1<Experiment, CallFeedbackSheetViewModel.StoreState> {
    public static final CallFeedbackSheetViewModel2 INSTANCE = new CallFeedbackSheetViewModel2();

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ CallFeedbackSheetViewModel.StoreState call(Experiment experiment) {
        return call2(experiment);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final CallFeedbackSheetViewModel.StoreState call2(Experiment experiment) {
        return new CallFeedbackSheetViewModel.StoreState(experiment != null && experiment.getBucket() == 1);
    }
}
