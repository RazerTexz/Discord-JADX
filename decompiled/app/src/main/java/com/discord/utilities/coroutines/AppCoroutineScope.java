package com.discord.utilities.coroutines;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p584w.CoroutineContextImpl4;
import p507d0.p592z.p594d.Intrinsics3;
import p659s.p660a.Dispatchers;
import p659s.p660a.p661a.MainDispatchers;

/* JADX INFO: renamed from: com.discord.utilities.coroutines.AppCoroutineScopeKt, reason: use source file name */
/* JADX INFO: compiled from: AppCoroutineScope.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppCoroutineScope {
    public static final Job appLaunch(CoroutineScope coroutineScope, Class<?> cls, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics3.checkNotNullParameter(coroutineScope, "$this$appLaunch");
        Intrinsics3.checkNotNullParameter(cls, "errorClass");
        Intrinsics3.checkNotNullParameter(coroutineContext, "context");
        Intrinsics3.checkNotNullParameter(coroutineStart, "start");
        Intrinsics3.checkNotNullParameter(function2, "block");
        String simpleName = cls.getSimpleName();
        Intrinsics3.checkNotNullExpressionValue(simpleName, "errorClass.simpleName");
        return appLaunch(coroutineScope, simpleName, coroutineContext, coroutineStart, function2);
    }

    public static /* synthetic */ Job appLaunch$default(CoroutineScope coroutineScope, Class cls, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            coroutineContext = CoroutineContextImpl4.f25237j;
        }
        if ((i & 4) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return appLaunch(coroutineScope, (Class<?>) cls, coroutineContext, coroutineStart, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) function2);
    }

    public static final Job appLaunch(CoroutineScope coroutineScope, String str, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics3.checkNotNullParameter(coroutineScope, "$this$appLaunch");
        Intrinsics3.checkNotNullParameter(str, "errorTag");
        Intrinsics3.checkNotNullParameter(coroutineContext, "context");
        Intrinsics3.checkNotNullParameter(coroutineStart, "start");
        Intrinsics3.checkNotNullParameter(function2, "block");
        CoroutineDispatcher coroutineDispatcher = Dispatchers.f27866a;
        return C3404f.m4208G0(coroutineScope, MainDispatchers.f27700b.plus(new AppCoroutineScope2(str)).plus(coroutineContext), coroutineStart, function2);
    }

    public static /* synthetic */ Job appLaunch$default(CoroutineScope coroutineScope, String str, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            coroutineContext = CoroutineContextImpl4.f25237j;
        }
        if ((i & 4) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return appLaunch(coroutineScope, str, coroutineContext, coroutineStart, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) function2);
    }
}
