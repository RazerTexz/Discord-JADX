package com.discord.widgets.user.account;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetUserAccountVerifyBinding;
import com.discord.models.requiredaction.RequiredAction;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.user.account.WidgetUserAccountVerifyBase;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppHelpDesk;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.PropertyReference0Impl;

/* JADX INFO: compiled from: WidgetUserAccountVerify.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserAccountVerify extends WidgetUserAccountVerifyBase {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetUserAccountVerify.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUserAccountVerifyBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: compiled from: WidgetUserAccountVerify.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, RequiredAction action) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(action, "action");
            Intent launchIntent = WidgetUserAccountVerifyBase.INSTANCE.getLaunchIntent(WidgetUserAccountVerifyBase.Mode.FORCED, action == RequiredAction.REQUIRE_VERIFIED_PHONE || action == RequiredAction.REQUIRE_VERIFIED_EMAIL || action == RequiredAction.REQUIRE_CAPTCHA, action == RequiredAction.REQUIRE_VERIFIED_EMAIL);
            AnalyticsTracker.openModal$default("Suspicious Activity", "", null, 4, null);
            AppScreen2.m156d(context, WidgetUserAccountVerify.class, launchIntent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.account.WidgetUserAccountVerify$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetUserAccountVerify.kt */
    public final /* synthetic */ class C102491 extends PropertyReference0Impl {
        public C102491(WidgetUserAccountVerify widgetUserAccountVerify) {
            super(widgetUserAccountVerify, WidgetUserAccountVerify.class, "isForced", "isForced()Z", 0);
        }

        @Override // p507d0.p592z.p594d.PropertyReference0Impl, kotlin.reflect.KProperty6
        public Object get() {
            return Boolean.valueOf(((WidgetUserAccountVerify) this.receiver).isForced());
        }
    }

    public WidgetUserAccountVerify() {
        super(C5419R.layout.widget_user_account_verify);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetUserAccountVerify2.INSTANCE, null, 2, null);
    }

    private final WidgetUserAccountVerifyBinding getBinding() {
        return (WidgetUserAccountVerifyBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.widgets.user.account.WidgetUserAccountVerifyBase, com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setOnBackPressed$default(this, new WidgetUserAccountVerify5(new C102491(this)), 0, 2, null);
        WidgetUserAccountVerifyBinding binding = getBinding();
        TextView textView = binding.f18324e;
        Intrinsics3.checkNotNullExpressionValue(textView, "verifyAccountTextBody");
        textView.setText(FormatUtils.m219k(this, C5419R.string.verification_body, new Object[0], null, 4));
        LinkifiedTextView linkifiedTextView = binding.f18323d;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "verifyAccountSupport");
        linkifiedTextView.setText(FormatUtils.m219k(this, C5419R.string.verification_footer_support, new Object[]{AppHelpDesk.m148c()}, null, 4));
        RelativeLayout relativeLayout = binding.f18321b;
        relativeLayout.setVisibility(getIsEmailAllowed() ? 0 : 8);
        relativeLayout.setOnClickListener(new WidgetUserAccountVerify3(this));
        RelativeLayout relativeLayout2 = binding.f18322c;
        relativeLayout2.setVisibility(getIsPhoneAllowed() ? 0 : 8);
        relativeLayout2.setOnClickListener(new WidgetUserAccountVerify4(this));
    }
}
