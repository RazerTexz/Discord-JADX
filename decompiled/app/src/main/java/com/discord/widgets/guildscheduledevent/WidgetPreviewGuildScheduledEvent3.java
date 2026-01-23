package com.discord.widgets.guildscheduledevent;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.discord.utilities.intent.IntentUtilsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetPreviewGuildScheduledEvent$Companion$registerForResult$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetPreviewGuildScheduledEvent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetPreviewGuildScheduledEvent3<O> implements ActivityResultCallback<ActivityResult> {
    public final /* synthetic */ Function3 $onEventCreated;
    public final /* synthetic */ Function0 $onQuit;

    public WidgetPreviewGuildScheduledEvent3(Function3 function3, Function0 function0) {
        this.$onEventCreated = function3;
        this.$onQuit = function0;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public /* bridge */ /* synthetic */ void onActivityResult(ActivityResult activityResult) {
        onActivityResult2(activityResult);
    }

    /* JADX INFO: renamed from: onActivityResult, reason: avoid collision after fix types in other method */
    public final void onActivityResult2(ActivityResult activityResult) {
        Function0 function0;
        Intrinsics3.checkNotNullExpressionValue(activityResult, "activityResult");
        int resultCode = activityResult.getResultCode();
        if (resultCode != -1) {
            if (resultCode == 2 && (function0 = this.$onQuit) != null) {
                return;
            }
            return;
        }
        Intent data = activityResult.getData();
        if (data != null) {
            Intrinsics3.checkNotNullExpressionValue(data, "it");
            this.$onEventCreated.invoke(IntentUtilsKt.getLongExtraOrNull(data, "com.discord.intent.extra.EXTRA_CHANNEL_ID"), Long.valueOf(data.getLongExtra("com.discord.intent.extra.EXTRA_GUILD_SCHEDULED_EVENT_ID", 0L)), Boolean.valueOf(data.getBooleanExtra(WidgetPreviewGuildScheduledEvent.EXTRA_EVENT_CREATED, false)));
        }
    }
}
