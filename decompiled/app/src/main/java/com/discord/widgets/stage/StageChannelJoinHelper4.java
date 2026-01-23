package com.discord.widgets.stage;

import com.discord.models.guild.Guild;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CancellableContinuation;
import p507d0.Result2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.stage.StageChannelJoinHelper$lurkAndJoinStageAsync$2$1, reason: use source file name */
/* JADX INFO: compiled from: StageChannelJoinHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StageChannelJoinHelper4 extends Lambda implements Function3<Guild, Long, Boolean, Unit> {
    public final /* synthetic */ CancellableContinuation $continuation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StageChannelJoinHelper4(CancellableContinuation cancellableContinuation) {
        super(3);
        this.$continuation = cancellableContinuation;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Guild guild, Long l, Boolean bool) {
        invoke(guild, l, bool.booleanValue());
        return Unit.f27425a;
    }

    public final void invoke(Guild guild, Long l, boolean z2) {
        Intrinsics3.checkNotNullParameter(guild, "<anonymous parameter 0>");
        CancellableContinuation cancellableContinuation = this.$continuation;
        Unit unit = Unit.f27425a;
        Result2.a aVar = Result2.f25169j;
        cancellableContinuation.resumeWith(Result2.m11474constructorimpl(unit));
    }
}
