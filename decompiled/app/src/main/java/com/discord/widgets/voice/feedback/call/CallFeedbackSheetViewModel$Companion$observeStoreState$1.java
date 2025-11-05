package com.discord.widgets.voice.feedback.call;

import androidx.core.app.NotificationCompat;
import com.discord.models.experiments.domain.Experiment;
import com.discord.widgets.voice.feedback.call.CallFeedbackSheetViewModel;
import j0.k.b;

/* compiled from: CallFeedbackSheetViewModel.kt */
/* loaded from: classes.dex */
public final class CallFeedbackSheetViewModel$Companion$observeStoreState$1<T, R> implements b<Experiment, CallFeedbackSheetViewModel.StoreState> {
    public static final CallFeedbackSheetViewModel$Companion$observeStoreState$1 INSTANCE = new CallFeedbackSheetViewModel$Companion$observeStoreState$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ CallFeedbackSheetViewModel.StoreState call(Experiment experiment) {
        return call2(experiment);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final CallFeedbackSheetViewModel.StoreState call2(Experiment experiment) {
        return new CallFeedbackSheetViewModel.StoreState(experiment != null && experiment.getBucket() == 1);
    }
}
