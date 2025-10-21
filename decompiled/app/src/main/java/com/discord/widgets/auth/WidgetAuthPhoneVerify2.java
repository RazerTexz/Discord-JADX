package com.discord.widgets.auth;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.discord.widgets.auth.WidgetAuthPhoneVerify;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetAuthPhoneVerify.kt */
/* renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$Companion$registerForResult$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetAuthPhoneVerify2<O> implements ActivityResultCallback<ActivityResult> {
    public final /* synthetic */ Function1 $callback;

    public WidgetAuthPhoneVerify2(Function1 function1) {
        this.$callback = function1;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public /* bridge */ /* synthetic */ void onActivityResult(ActivityResult activityResult) {
        onActivityResult2(activityResult);
    }

    /* renamed from: onActivityResult, reason: avoid collision after fix types in other method */
    public final void onActivityResult2(ActivityResult activityResult) {
        Intrinsics3.checkNotNullExpressionValue(activityResult, "activityResult");
        if (activityResult.getResultCode() != -1) {
            if (activityResult.getResultCode() == 2) {
                this.$callback.invoke(WidgetAuthPhoneVerify.Result.Cancelled.INSTANCE);
            }
        } else {
            Intent data = activityResult.getData();
            String stringExtra = data != null ? data.getStringExtra("RESULT_EXTRA_TOKEN") : null;
            if (stringExtra != null) {
                this.$callback.invoke(new WidgetAuthPhoneVerify.Result.Token(stringExtra));
            }
        }
    }
}
