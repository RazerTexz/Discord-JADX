package com.discord.utilities.debug;

import com.discord.utilities.debug.HistoricalProcessExitReason;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* compiled from: HistoricalProcessExitReason.kt */
/* renamed from: com.discord.utilities.debug.HistoricalProcessExitReason$lastReason$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class HistoricalProcessExitReason2 extends Lambda implements Function0<HistoricalProcessExitReason.Reason> {
    public static final HistoricalProcessExitReason2 INSTANCE = new HistoricalProcessExitReason2();

    public HistoricalProcessExitReason2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ HistoricalProcessExitReason.Reason invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final HistoricalProcessExitReason.Reason invoke() {
        return HistoricalProcessExitReason.access$createLastReason(HistoricalProcessExitReason.INSTANCE);
    }
}
