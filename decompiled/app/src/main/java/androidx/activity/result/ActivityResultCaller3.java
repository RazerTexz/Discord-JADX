package androidx.activity.result;

import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: androidx.activity.result.ActivityResultCallerKt$registerForActivityResult$resultLauncher$1, reason: use source file name */
/* JADX INFO: compiled from: ActivityResultCaller.kt */
/* JADX INFO: loaded from: classes.dex */
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
