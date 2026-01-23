package com.discord.widgets.guild_automod;

import androidx.core.app.NotificationCompat;
import com.discord.models.message.Message;
import com.discord.widgets.guild_automod.ReportIssueWithAutoModViewModel;
import p637j0.p641k.Func1;

/* JADX INFO: renamed from: com.discord.widgets.guild_automod.ReportIssueWithAutoModViewModel$Companion$observeStores$1, reason: use source file name */
/* JADX INFO: compiled from: ReportIssueWithAutoModViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ReportIssueWithAutoModViewModel3<T, R> implements Func1<Message, ReportIssueWithAutoModViewModel.StoreState> {
    public static final ReportIssueWithAutoModViewModel3 INSTANCE = new ReportIssueWithAutoModViewModel3();

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ ReportIssueWithAutoModViewModel.StoreState call(Message message) {
        return call2(message);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final ReportIssueWithAutoModViewModel.StoreState call2(Message message) {
        return new ReportIssueWithAutoModViewModel.StoreState(message);
    }
}
