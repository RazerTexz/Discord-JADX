package com.discord.widgets.hubs;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.discord.widgets.guilds.create.WidgetGuildCreate;
import d0.z.d.Intrinsics3;

/* compiled from: WidgetHubAddServer.kt */
/* renamed from: com.discord.widgets.hubs.WidgetHubAddServer$launcher$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetHubAddServer4<O> implements ActivityResultCallback<ActivityResult> {
    public final /* synthetic */ WidgetHubAddServer this$0;

    public WidgetHubAddServer4(WidgetHubAddServer widgetHubAddServer) {
        this.this$0 = widgetHubAddServer;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public /* bridge */ /* synthetic */ void onActivityResult(ActivityResult activityResult) {
        onActivityResult2(activityResult);
    }

    /* renamed from: onActivityResult, reason: avoid collision after fix types in other method */
    public final void onActivityResult2(ActivityResult activityResult) {
        WidgetGuildCreate.Result result;
        Intrinsics3.checkNotNullExpressionValue(activityResult, "activityResult");
        Intent data = activityResult.getData();
        if (data != null) {
            if (!(activityResult.getResultCode() == -1)) {
                data = null;
            }
            if (data == null || (result = (WidgetGuildCreate.Result) data.getParcelableExtra("intent_args_key")) == null) {
                return;
            }
            WidgetHubAddServer.access$onServerClickListener(this.this$0, result.getGuildId(), true);
        }
    }
}
