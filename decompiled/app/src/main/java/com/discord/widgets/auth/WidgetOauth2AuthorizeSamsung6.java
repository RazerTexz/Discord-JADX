package com.discord.widgets.auth;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.discord.C5419R;
import com.discord.app.AppActivity;
import com.discord.samsung.SamsungConnectActivity;
import com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung;
import p007b.p008a.p018d.AppToast;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung$samsungDisclaimerLauncher$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetOauth2AuthorizeSamsung.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetOauth2AuthorizeSamsung6<O> implements ActivityResultCallback<ActivityResult> {
    public final /* synthetic */ WidgetOauth2AuthorizeSamsung this$0;

    public WidgetOauth2AuthorizeSamsung6(WidgetOauth2AuthorizeSamsung widgetOauth2AuthorizeSamsung) {
        this.this$0 = widgetOauth2AuthorizeSamsung;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public /* bridge */ /* synthetic */ void onActivityResult(ActivityResult activityResult) {
        onActivityResult2(activityResult);
    }

    /* JADX INFO: renamed from: onActivityResult, reason: avoid collision after fix types in other method */
    public final void onActivityResult2(ActivityResult activityResult) {
        Bundle extras;
        Bundle extras2;
        Intrinsics3.checkNotNullExpressionValue(activityResult, "activityResult");
        if (activityResult.getResultCode() == -1) {
            SamsungConnectActivity.m8504b(this.this$0.requireContext(), WidgetOauth2AuthorizeSamsung.access$getSamsungConnectLauncher$p(this.this$0), 5459);
            return;
        }
        Intent data = activityResult.getData();
        Object obj = (data == null || (extras2 = data.getExtras()) == null) ? null : extras2.get("error_message");
        Intent data2 = activityResult.getData();
        Object obj2 = (data2 == null || (extras = data2.getExtras()) == null) ? null : extras.get("error_code");
        WidgetOauth2AuthorizeSamsung.Companion.logW$default(WidgetOauth2AuthorizeSamsung.INSTANCE, "Connection requires disclaimer acceptance. [" + obj2 + "] " + obj, null, 2, null);
        AppToast.m171i(this.this$0, C5419R.string.failed, 0, 4);
        AppActivity appActivity = this.this$0.getAppActivity();
        if (appActivity != null) {
            appActivity.finish();
        }
    }
}
