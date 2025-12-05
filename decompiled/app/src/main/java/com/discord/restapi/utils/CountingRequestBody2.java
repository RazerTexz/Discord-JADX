package com.discord.restapi.utils;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;

/* compiled from: CountingRequestBody.kt */
/* renamed from: com.discord.restapi.utils.CountingRequestBody$writeTo$countingSink$1, reason: use source file name */
/* loaded from: classes.dex */
public final /* synthetic */ class CountingRequestBody2 extends FunctionReferenceImpl implements Function1<Long, Unit> {
    public CountingRequestBody2(CountingRequestBody countingRequestBody) {
        super(1, countingRequestBody, CountingRequestBody.class, "updateProgress", "updateProgress(J)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke(l.longValue());
        return Unit.f27425a;
    }

    public final void invoke(long j) {
        CountingRequestBody.access$updateProgress((CountingRequestBody) this.receiver, j);
    }
}
