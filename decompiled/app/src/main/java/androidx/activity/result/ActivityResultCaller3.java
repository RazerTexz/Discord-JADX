package androidx.activity.result;

import kotlin.jvm.functions.Function1;

/* compiled from: ActivityResultCaller.kt */
/* renamed from: androidx.activity.result.ActivityResultCallerKt$registerForActivityResult$resultLauncher$1, reason: use source file name */
/* loaded from: classes.dex */
public final class ActivityResultCaller3<O> implements ActivityResultCallback<O> {
    public final /* synthetic */ Function1 $callback;

    public ActivityResultCaller3(Function1 function1) {
        this.$callback = function1;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public final void onActivityResult(O o) {
        this.$callback.invoke(o);
    }
}
