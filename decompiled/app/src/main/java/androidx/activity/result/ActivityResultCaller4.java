package androidx.activity.result;

import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: androidx.activity.result.ActivityResultCallerKt$registerForActivityResult$resultLauncher$2, reason: use source file name */
/* JADX INFO: compiled from: ActivityResultCaller.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ActivityResultCaller4<O> implements ActivityResultCallback<O> {
    public final /* synthetic */ Function1 $callback;

    public ActivityResultCaller4(Function1 function1) {
        this.$callback = function1;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public final void onActivityResult(O o) {
        this.$callback.invoke(o);
    }
}
