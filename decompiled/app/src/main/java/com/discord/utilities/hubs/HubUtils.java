package com.discord.utilities.hubs;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.FragmentManager;
import com.discord.app.AppFragment;
import com.discord.widgets.hubs.WidgetHubAddServerConfirmationDialog;
import com.discord.widgets.hubs.WidgetHubAddServerConfirmationDialog2;
import com.discord.widgets.hubs.WidgetHubDescription2;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: HubUtils.kt */
/* renamed from: com.discord.utilities.hubs.HubUtilsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class HubUtils {

    /* compiled from: HubUtils.kt */
    /* renamed from: com.discord.utilities.hubs.HubUtilsKt$getAddServerActivityResultHandler$1 */
    public static final class C67731<O> implements ActivityResultCallback<ActivityResult> {
        public final /* synthetic */ AppFragment $this_getAddServerActivityResultHandler;

        public C67731(AppFragment appFragment) {
            this.$this_getAddServerActivityResultHandler = appFragment;
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
                WidgetHubDescription2 widgetHubDescription2 = (WidgetHubDescription2) data.getParcelableExtra("intent_args_key");
                if (widgetHubDescription2 != null) {
                    WidgetHubAddServerConfirmationDialog.Companion companion = WidgetHubAddServerConfirmationDialog.INSTANCE;
                    FragmentManager parentFragmentManager = this.$this_getAddServerActivityResultHandler.getParentFragmentManager();
                    Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                    companion.show(parentFragmentManager, new WidgetHubAddServerConfirmationDialog2(widgetHubDescription2.getGuildId(), widgetHubDescription2.getHubName()));
                }
            }
        }

        @Override // androidx.activity.result.ActivityResultCallback
        public /* bridge */ /* synthetic */ void onActivityResult(ActivityResult activityResult) {
            onActivityResult2(activityResult);
        }
    }

    public static final ActivityResultLauncher<Intent> getAddServerActivityResultHandler(AppFragment appFragment) {
        Intrinsics3.checkNotNullParameter(appFragment, "$this$getAddServerActivityResultHandler");
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = appFragment.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C67731(appFragment));
        Intrinsics3.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResul…      )\n          }\n    }");
        return activityResultLauncherRegisterForActivityResult;
    }
}
