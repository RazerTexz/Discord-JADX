package com.discord.widgets.guildscheduledevent;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetGuildScheduledEventSettings.kt */
/* loaded from: classes2.dex */
public final class WidgetGuildScheduledEventSettings$Companion$registerForResult$1<O> implements ActivityResultCallback<ActivityResult> {
    public final /* synthetic */ Function0 $onFinished;
    public final /* synthetic */ Function0 $onQuit;

    public WidgetGuildScheduledEventSettings$Companion$registerForResult$1(Function0 function0, Function0 function02) {
        this.$onFinished = function0;
        this.$onQuit = function02;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public /* bridge */ /* synthetic */ void onActivityResult(ActivityResult activityResult) {
        onActivityResult2(activityResult);
    }

    /* renamed from: onActivityResult, reason: avoid collision after fix types in other method */
    public final void onActivityResult2(ActivityResult activityResult) {
        Intrinsics3.checkNotNullExpressionValue(activityResult, "result");
        int resultCode = activityResult.getResultCode();
        if (resultCode == -1) {
            this.$onFinished.invoke();
        } else {
            if (resultCode != 2) {
                return;
            }
            this.$onQuit.invoke();
        }
    }
}
