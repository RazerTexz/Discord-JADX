package com.discord.widgets.captcha;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.discord.utilities.captcha.CaptchaHelper;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetCaptcha.kt */
/* renamed from: com.discord.widgets.captcha.WidgetCaptcha$Companion$registerForResult$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetCaptcha2<O> implements ActivityResultCallback<ActivityResult> {
    public final /* synthetic */ Function1 $callback;

    public WidgetCaptcha2(Function1 function1) {
        this.$callback = function1;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public /* bridge */ /* synthetic */ void onActivityResult(ActivityResult activityResult) {
        onActivityResult2(activityResult);
    }

    /* renamed from: onActivityResult, reason: avoid collision after fix types in other method */
    public final void onActivityResult2(ActivityResult activityResult) {
        Intrinsics3.checkNotNullExpressionValue(activityResult, "activityResult");
        if (activityResult.getResultCode() == -1) {
            Intent data = activityResult.getData();
            String stringExtra = data != null ? data.getStringExtra("RESULT_EXTRA_TOKEN") : null;
            Intent data2 = activityResult.getData();
            String stringExtra2 = data2 != null ? data2.getStringExtra("RESULT_EXTRA_RQTOKEN") : null;
            if (stringExtra != null) {
                this.$callback.invoke(new CaptchaHelper.CaptchaPayload(stringExtra, stringExtra2));
            }
        }
    }
}
