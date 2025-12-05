package p507d0.p584w;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import p507d0.Result2;
import p507d0.p584w.p585h.IntrinsicsJvm;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: Continuation.kt */
/* renamed from: d0.w.e, reason: use source file name */
/* loaded from: classes3.dex */
public final class Continuation2 {
    public static final <R, T> void startCoroutine(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, Continuation<? super T> continuation) {
        Intrinsics3.checkNotNullParameter(function2, "$this$startCoroutine");
        Intrinsics3.checkNotNullParameter(continuation, "completion");
        Continuation continuationIntercepted = IntrinsicsJvm.intercepted(IntrinsicsJvm.createCoroutineUnintercepted(function2, r, continuation));
        Unit unit = Unit.f27425a;
        Result2.a aVar = Result2.f25169j;
        continuationIntercepted.resumeWith(Result2.m11474constructorimpl(unit));
    }
}
