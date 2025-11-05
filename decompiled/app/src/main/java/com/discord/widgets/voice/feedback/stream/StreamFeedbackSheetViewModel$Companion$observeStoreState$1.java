package com.discord.widgets.voice.feedback.stream;

import androidx.core.app.NotificationCompat;
import com.discord.models.experiments.domain.Experiment;
import com.discord.widgets.voice.feedback.stream.StreamFeedbackSheetViewModel;
import j0.k.b;

/* compiled from: StreamFeedbackSheetViewModel.kt */
/* loaded from: classes.dex */
public final class StreamFeedbackSheetViewModel$Companion$observeStoreState$1<T, R> implements b<Experiment, StreamFeedbackSheetViewModel.StoreState> {
    public static final StreamFeedbackSheetViewModel$Companion$observeStoreState$1 INSTANCE = new StreamFeedbackSheetViewModel$Companion$observeStoreState$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ StreamFeedbackSheetViewModel.StoreState call(Experiment experiment) {
        return call2(experiment);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final StreamFeedbackSheetViewModel.StoreState call2(Experiment experiment) {
        return new StreamFeedbackSheetViewModel.StoreState(experiment != null && experiment.getBucket() == 1);
    }
}
