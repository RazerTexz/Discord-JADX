package com.discord.widgets.guilds.invite;

import androidx.core.app.NotificationCompat;
import com.discord.models.experiments.domain.Experiment;
import d0.Tuples;
import java.util.List;
import kotlin.Tuples2;
import rx.functions.Func2;

/* compiled from: WidgetGuildInviteShare.kt */
/* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShare$Companion$launch$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildInviteShare2<T1, T2, R> implements Func2<Experiment, List<? extends InviteSuggestion>, Tuples2<? extends Experiment, ? extends List<? extends InviteSuggestion>>> {
    public static final WidgetGuildInviteShare2 INSTANCE = new WidgetGuildInviteShare2();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Tuples2<? extends Experiment, ? extends List<? extends InviteSuggestion>> call(Experiment experiment, List<? extends InviteSuggestion> list) {
        return call2(experiment, list);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Tuples2<Experiment, List<InviteSuggestion>> call2(Experiment experiment, List<? extends InviteSuggestion> list) {
        return Tuples.to(experiment, list);
    }
}
