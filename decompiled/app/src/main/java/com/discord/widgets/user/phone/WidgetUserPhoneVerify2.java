package com.discord.widgets.user.phone;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.user.phone.WidgetUserPhoneVerify$Companion$registerForResult$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetUserPhoneVerify.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserPhoneVerify2<O> implements ActivityResultCallback<ActivityResult> {
    public final /* synthetic */ Function0 $callback;

    public WidgetUserPhoneVerify2(Function0 function0) {
        this.$callback = function0;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public /* bridge */ /* synthetic */ void onActivityResult(ActivityResult activityResult) {
        onActivityResult2(activityResult);
    }

    /* JADX INFO: renamed from: onActivityResult, reason: avoid collision after fix types in other method */
    public final void onActivityResult2(ActivityResult activityResult) {
        Intrinsics3.checkNotNullExpressionValue(activityResult, "activityResult");
        if (activityResult.getResultCode() == -1) {
            this.$callback.invoke();
        }
    }
}
