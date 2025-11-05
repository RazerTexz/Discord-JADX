package com.discord.widgets.user.account;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.a.d.AppHelpDesk;
import b.a.d.AppScreen2;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetUserAccountVerifyBinding;
import com.discord.models.requiredaction.RequiredAction;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.user.account.WidgetUserAccountVerifyBase;
import d0.z.d.Intrinsics3;
import d0.z.d.PropertyReference0Impl;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetUserAccountVerify.kt */
/* loaded from: classes.dex */
public final class WidgetUserAccountVerify extends WidgetUserAccountVerifyBase {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetUserAccountVerify.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUserAccountVerifyBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* compiled from: WidgetUserAccountVerify.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, RequiredAction action) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(action, "action");
            Intent launchIntent = WidgetUserAccountVerifyBase.INSTANCE.getLaunchIntent(WidgetUserAccountVerifyBase.Mode.FORCED, action == RequiredAction.REQUIRE_VERIFIED_PHONE || action == RequiredAction.REQUIRE_VERIFIED_EMAIL || action == RequiredAction.REQUIRE_CAPTCHA, action == RequiredAction.REQUIRE_VERIFIED_EMAIL);
            AnalyticsTracker.openModal$default("Suspicious Activity", "", null, 4, null);
            AppScreen2.d(context, WidgetUserAccountVerify.class, launchIntent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetUserAccountVerify.kt */
    /* renamed from: com.discord.widgets.user.account.WidgetUserAccountVerify$onViewBound$1, reason: invalid class name */
    public final /* synthetic */ class AnonymousClass1 extends PropertyReference0Impl {
        public AnonymousClass1(WidgetUserAccountVerify widgetUserAccountVerify) {
            super(widgetUserAccountVerify, WidgetUserAccountVerify.class, "isForced", "isForced()Z", 0);
        }

        @Override // d0.z.d.PropertyReference0Impl, kotlin.reflect.KProperty6
        public Object get() {
            return Boolean.valueOf(((WidgetUserAccountVerify) this.receiver).isForced());
        }
    }

    public WidgetUserAccountVerify() {
        super(R.layout.widget_user_account_verify);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetUserAccountVerify2.INSTANCE, null, 2, null);
    }

    private final WidgetUserAccountVerifyBinding getBinding() {
        return (WidgetUserAccountVerifyBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.widgets.user.account.WidgetUserAccountVerifyBase, com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setOnBackPressed$default(this, new WidgetUserAccountVerify5(new AnonymousClass1(this)), 0, 2, null);
        WidgetUserAccountVerifyBinding binding = getBinding();
        TextView textView = binding.e;
        Intrinsics3.checkNotNullExpressionValue(textView, "verifyAccountTextBody");
        textView.setText(FormatUtils.k(this, R.string.verification_body, new Object[0], null, 4));
        LinkifiedTextView linkifiedTextView = binding.d;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "verifyAccountSupport");
        linkifiedTextView.setText(FormatUtils.k(this, R.string.verification_footer_support, new Object[]{AppHelpDesk.c()}, null, 4));
        RelativeLayout relativeLayout = binding.f2679b;
        relativeLayout.setVisibility(getIsEmailAllowed() ? 0 : 8);
        relativeLayout.setOnClickListener(new WidgetUserAccountVerify3(this));
        RelativeLayout relativeLayout2 = binding.c;
        relativeLayout2.setVisibility(getIsPhoneAllowed() ? 0 : 8);
        relativeLayout2.setOnClickListener(new WidgetUserAccountVerify4(this));
    }
}
