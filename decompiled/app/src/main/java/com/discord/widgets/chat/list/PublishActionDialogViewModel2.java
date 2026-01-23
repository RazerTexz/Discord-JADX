package com.discord.widgets.chat.list;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelChannelFollowerStats;
import com.discord.widgets.chat.list.PublishActionDialogViewModel;
import p637j0.p641k.Func1;

/* JADX INFO: renamed from: com.discord.widgets.chat.list.PublishActionDialogViewModel$Companion$observeChannelFollowerStatsStoreState$1, reason: use source file name */
/* JADX INFO: compiled from: PublishActionDialogViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PublishActionDialogViewModel2<T, R> implements Func1<ModelChannelFollowerStats, PublishActionDialogViewModel.StoreState> {
    public static final PublishActionDialogViewModel2 INSTANCE = new PublishActionDialogViewModel2();

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ PublishActionDialogViewModel.StoreState call(ModelChannelFollowerStats modelChannelFollowerStats) {
        return call2(modelChannelFollowerStats);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final PublishActionDialogViewModel.StoreState call2(ModelChannelFollowerStats modelChannelFollowerStats) {
        return new PublishActionDialogViewModel.StoreState(modelChannelFollowerStats);
    }
}
