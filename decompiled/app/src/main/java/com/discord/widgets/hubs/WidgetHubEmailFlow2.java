package com.discord.widgets.hubs;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.fragment.app.FragmentActivity;
import com.discord.stores.StoreStream;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetHubEmailFlow.kt */
/* renamed from: com.discord.widgets.hubs.WidgetHubEmailFlow$activityResultHandler$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetHubEmailFlow2<O> implements ActivityResultCallback<ActivityResult> {
    public final /* synthetic */ WidgetHubEmailFlow this$0;

    public WidgetHubEmailFlow2(WidgetHubEmailFlow widgetHubEmailFlow) {
        this.this$0 = widgetHubEmailFlow;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public /* bridge */ /* synthetic */ void onActivityResult(ActivityResult activityResult) {
        onActivityResult2(activityResult);
    }

    /* renamed from: onActivityResult, reason: avoid collision after fix types in other method */
    public final void onActivityResult2(ActivityResult activityResult) {
        Intent data;
        if (activityResult == null || (data = activityResult.getData()) == null) {
            return;
        }
        if (!(activityResult.getResultCode() == -1)) {
            data = null;
        }
        if (data != null) {
            Intrinsics3.checkNotNullParameter(data, "$this$getArgsFromIntent");
            WidgetHubDomains5 widgetHubDomains5 = (WidgetHubDomains5) data.getParcelableExtra("intent_args_key");
            if (widgetHubDomains5 != null) {
                if (widgetHubDomains5 instanceof WidgetHubWaitlist2) {
                    WidgetHubEmailFlow.access$getViewModel$p(this.this$0).setHubWaitlistResult((WidgetHubWaitlist2) widgetHubDomains5);
                    return;
                }
                if (!(widgetHubDomains5 instanceof WidgetHubAuthenticationlViewModel)) {
                    FragmentActivity activity = this.this$0.getActivity();
                    if (activity != null) {
                        activity.finish();
                        return;
                    }
                    return;
                }
                StoreStream.INSTANCE.getGuildSelected().set(((WidgetHubAuthenticationlViewModel) widgetHubDomains5).getGuildId());
                FragmentActivity activity2 = this.this$0.getActivity();
                if (activity2 != null) {
                    activity2.finish();
                }
            }
        }
    }
}
