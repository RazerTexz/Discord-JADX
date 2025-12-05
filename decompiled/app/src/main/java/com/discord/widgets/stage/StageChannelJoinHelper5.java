package com.discord.widgets.stage;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CancellableContinuation;
import p507d0.Result2;
import p507d0.p592z.p594d.Lambda;

/* compiled from: StageChannelJoinHelper.kt */
/* renamed from: com.discord.widgets.stage.StageChannelJoinHelper$lurkAndJoinStageAsync$2$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class StageChannelJoinHelper5 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ CancellableContinuation $continuation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StageChannelJoinHelper5(CancellableContinuation cancellableContinuation) {
        super(0);
        this.$continuation = cancellableContinuation;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.f27425a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        CancellableContinuation cancellableContinuation = this.$continuation;
        Result2.a aVar = Result2.f25169j;
        cancellableContinuation.resumeWith(Result2.m11474constructorimpl(null));
    }
}
