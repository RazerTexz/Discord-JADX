package com.discord.widgets.auth;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetAuthBirthday.kt */
/* renamed from: com.discord.widgets.auth.WidgetAuthBirthday$Companion$registerForResult$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetAuthBirthday2<O> implements ActivityResultCallback<ActivityResult> {
    public final /* synthetic */ Function1 $callback;

    public WidgetAuthBirthday2(Function1 function1) {
        this.$callback = function1;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public /* bridge */ /* synthetic */ void onActivityResult(ActivityResult activityResult) {
        onActivityResult2(activityResult);
    }

    /* renamed from: onActivityResult, reason: avoid collision after fix types in other method */
    public final void onActivityResult2(ActivityResult activityResult) {
        Intrinsics3.checkNotNullExpressionValue(activityResult, "activityResult");
        Intent data = activityResult.getData();
        Long lValueOf = data != null ? Long.valueOf(data.getLongExtra("RESULT_EXTRA_BIRTHDAY", 0L)) : null;
        if (lValueOf != null) {
            this.$callback.invoke(lValueOf);
        }
    }
}
