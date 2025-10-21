package com.discord.widgets.voice.feedback.stream;

import androidx.core.app.NotificationCompat;
import com.discord.models.experiments.domain.Experiment;
import com.discord.widgets.voice.feedback.stream.StreamFeedbackSheetViewModel;
import j0.k.Func1;

/* compiled from: StreamFeedbackSheetViewModel.kt */
/* renamed from: com.discord.widgets.voice.feedback.stream.StreamFeedbackSheetViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes.dex */
public final class StreamFeedbackSheetViewModel2<T, R> implements Func1<Experiment, StreamFeedbackSheetViewModel.StoreState> {
    public static final StreamFeedbackSheetViewModel2 INSTANCE = new StreamFeedbackSheetViewModel2();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ StreamFeedbackSheetViewModel.StoreState call(Experiment experiment) {
        return call2(experiment);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final StreamFeedbackSheetViewModel.StoreState call2(Experiment experiment) {
        return new StreamFeedbackSheetViewModel.StoreState(experiment != null && experiment.getBucket() == 1);
    }
}
