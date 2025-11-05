package com.discord.widgets.auth;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetAuthBirthday.kt */
/* loaded from: classes2.dex */
public final class WidgetAuthBirthday$Companion$registerForResult$1<O> implements ActivityResultCallback<ActivityResult> {
    public final /* synthetic */ Function1 $callback;

    public WidgetAuthBirthday$Companion$registerForResult$1(Function1 function1) {
        this.$callback = function1;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public /* bridge */ /* synthetic */ void onActivityResult(ActivityResult activityResult) {
        onActivityResult2(activityResult);
    }

    /* renamed from: onActivityResult, reason: avoid collision after fix types in other method */
    public final void onActivityResult2(ActivityResult activityResult) {
        m.checkNotNullExpressionValue(activityResult, "activityResult");
        Intent data = activityResult.getData();
        Long lValueOf = data != null ? Long.valueOf(data.getLongExtra("RESULT_EXTRA_BIRTHDAY", 0L)) : null;
        if (lValueOf != null) {
            this.$callback.invoke(lValueOf);
        }
    }
}
