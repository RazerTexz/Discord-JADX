package com.discord.widgets.user.email;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetUserEmailUpdate.kt */
/* renamed from: com.discord.widgets.user.email.WidgetUserEmailUpdate$Companion$registerForResult$1, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetUserEmailUpdate2<O> implements ActivityResultCallback<ActivityResult> {
    public final /* synthetic */ Function0 $callback;

    public WidgetUserEmailUpdate2(Function0 function0) {
        this.$callback = function0;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public /* bridge */ /* synthetic */ void onActivityResult(ActivityResult activityResult) {
        onActivityResult2(activityResult);
    }

    /* renamed from: onActivityResult, reason: avoid collision after fix types in other method */
    public final void onActivityResult2(ActivityResult activityResult) {
        Intrinsics3.checkNotNullExpressionValue(activityResult, "activityResult");
        if (activityResult.getResultCode() == -1) {
            this.$callback.invoke();
        }
    }
}
