package com.discord.widgets.auth;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import com.discord.C5419R;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetAuthUndeleteAccountBinding;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.ScreenTitleView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppScreen2;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: WidgetAuthUndeleteAccount.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthUndeleteAccount extends AppFragment {
    private static final String ARG_DISABLED_KEY = "ARG_DISABLED_KEY";
    private static final String RESULT_EXTRA_UNDELETE = "RESULT_EXTRA_UNDELETE";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetAuthUndeleteAccount.class, "binding", "getBinding()Lcom/discord/databinding/WidgetAuthUndeleteAccountBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: WidgetAuthUndeleteAccount.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, ActivityResultLauncher<Intent> launcher, boolean disabled) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(launcher, "launcher");
            Intent intentPutExtra = new Intent().putExtra(WidgetAuthUndeleteAccount.ARG_DISABLED_KEY, disabled);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent().putExtra(ARG_DISABLED_KEY, disabled)");
            AppScreen2.f524g.m160f(context, launcher, WidgetAuthUndeleteAccount.class, intentPutExtra);
        }

        public final ActivityResultLauncher<Intent> registerForResult(AppFragment fragment, Function0<Unit> callback) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(callback, "callback");
            ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new WidgetAuthUndeleteAccount2(callback));
            Intrinsics3.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…k()\n          }\n        }");
            return activityResultLauncherRegisterForActivityResult;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthUndeleteAccount$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetAuthUndeleteAccount.kt */
    public static final class ViewOnClickListenerC72391 implements View.OnClickListener {
        public static final ViewOnClickListenerC72391 INSTANCE = new ViewOnClickListenerC72391();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Intrinsics3.checkNotNullExpressionValue(view, "it");
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "it.context");
            AppScreen2.m155c(context, false, null, 4);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthUndeleteAccount$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetAuthUndeleteAccount.kt */
    public static final class ViewOnClickListenerC72402 implements View.OnClickListener {
        public ViewOnClickListenerC72402() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Intent intent = new Intent();
            intent.putExtra(WidgetAuthUndeleteAccount.RESULT_EXTRA_UNDELETE, true);
            AppActivity appActivity = WidgetAuthUndeleteAccount.this.getAppActivity();
            if (appActivity != null) {
                appActivity.setResult(-1, intent);
            }
            AppActivity appActivity2 = WidgetAuthUndeleteAccount.this.getAppActivity();
            if (appActivity2 != null) {
                appActivity2.finish();
            }
        }
    }

    public WidgetAuthUndeleteAccount() {
        super(C5419R.layout.widget_auth_undelete_account);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetAuthUndeleteAccount3.INSTANCE, null, 2, null);
    }

    private final WidgetAuthUndeleteAccountBinding getBinding() {
        return (WidgetAuthUndeleteAccountBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        if (getMostRecentIntent().getBooleanExtra(ARG_DISABLED_KEY, false)) {
            ScreenTitleView screenTitleView = getBinding().f15722d;
            String string = getString(C5419R.string.account_disabled_title);
            Intrinsics3.checkNotNullExpressionValue(string, "getString(R.string.account_disabled_title)");
            screenTitleView.setTitle(string);
            getBinding().f15722d.setSubtitle(getString(C5419R.string.account_disabled_description));
        } else {
            ScreenTitleView screenTitleView2 = getBinding().f15722d;
            String string2 = getString(C5419R.string.account_scheduled_for_deletion_title);
            Intrinsics3.checkNotNullExpressionValue(string2, "getString(R.string.accou…duled_for_deletion_title)");
            screenTitleView2.setTitle(string2);
            getBinding().f15722d.setSubtitle(getString(C5419R.string.account_scheduled_for_deletion_description));
        }
        getBinding().f15721c.setOnClickListener(ViewOnClickListenerC72391.INSTANCE);
        getBinding().f15720b.setOnClickListener(new ViewOnClickListenerC72402());
    }
}
