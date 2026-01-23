package com.discord.widgets.auth;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.discord.widgets.auth.WidgetAuthPhoneVerify;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$Companion$registerForResult$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetAuthPhoneVerify.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthPhoneVerify2<O> implements ActivityResultCallback<ActivityResult> {
    public final /* synthetic */ Function1 $callback;

    public WidgetAuthPhoneVerify2(Function1 function1) {
        this.$callback = function1;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public /* bridge */ /* synthetic */ void onActivityResult(ActivityResult activityResult) {
        onActivityResult2(activityResult);
    }

    /* JADX INFO: renamed from: onActivityResult, reason: avoid collision after fix types in other method */
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
