package com.discord.widgets.settings.account.mfa;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates2;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsEnableMfaKeyBinding;
import com.discord.utilities.auth.AuthUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import d0.z.d.Intrinsics3;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetEnableMFAKey.kt */
/* loaded from: classes2.dex */
public final class WidgetEnableMFAKey extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetEnableMFAKey.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsEnableMfaKeyBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetEnableMFAKey.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ boolean access$isPackageInstalled(Companion companion, String str, PackageManager packageManager) {
            return companion.isPackageInstalled(str, packageManager);
        }

        private final boolean isPackageInstalled(String packageName, PackageManager packageManager) {
            try {
                packageManager.getPackageInfo(packageName, 0);
                return true;
            } catch (PackageManager.NameNotFoundException unused) {
                return false;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetEnableMFAKey.kt */
    /* renamed from: com.discord.widgets.settings.account.mfa.WidgetEnableMFAKey$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetEnableMFAKey widgetEnableMFAKey = WidgetEnableMFAKey.this;
            Intrinsics3.checkNotNullExpressionValue(view, "it");
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "it.context");
            WidgetEnableMFAKey.access$copyCodeToClipboard(widgetEnableMFAKey, context);
        }
    }

    /* compiled from: WidgetEnableMFAKey.kt */
    /* renamed from: com.discord.widgets.settings.account.mfa.WidgetEnableMFAKey$showLaunchTexts$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ PackageManager $pm;

        public AnonymousClass1(PackageManager packageManager) {
            this.$pm = packageManager;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Intrinsics3.checkNotNullExpressionValue(view, "it");
            Context context = view.getContext();
            Intent launchIntentForPackage = this.$pm.getLaunchIntentForPackage(AuthUtils.AUTHY_PACKAGE);
            if (launchIntentForPackage != null) {
                context.startActivity(launchIntentForPackage);
            }
        }
    }

    /* compiled from: WidgetEnableMFAKey.kt */
    /* renamed from: com.discord.widgets.settings.account.mfa.WidgetEnableMFAKey$showLaunchTexts$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ PackageManager $pm;

        public AnonymousClass2(PackageManager packageManager) {
            this.$pm = packageManager;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Intrinsics3.checkNotNullExpressionValue(view, "it");
            Context context = view.getContext();
            Intent launchIntentForPackage = this.$pm.getLaunchIntentForPackage(AuthUtils.GOOGLE_AUTHENTICATOR_PACKAGE);
            if (launchIntentForPackage != null) {
                context.startActivity(launchIntentForPackage);
            }
        }
    }

    public WidgetEnableMFAKey() {
        super(R.layout.widget_settings_enable_mfa_key);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetEnableMFAKey2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetEnableMFAViewModel.class), new WidgetEnableMFAKey$appActivityViewModels$$inlined$activityViewModels$1(this), new AppViewModelDelegates2(WidgetEnableMFAKey3.INSTANCE));
    }

    public static final /* synthetic */ void access$copyCodeToClipboard(WidgetEnableMFAKey widgetEnableMFAKey, Context context) {
        widgetEnableMFAKey.copyCodeToClipboard(context);
    }

    private final void copyCodeToClipboard(Context context) {
        AuthUtils authUtils = AuthUtils.INSTANCE;
        TextView textView = getBinding().f2618b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.enableMfaKeyCode");
        String strEncodeTotpSecret = authUtils.encodeTotpSecret(textView.getText().toString());
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
        ClipData clipDataNewPlainText = ClipData.newPlainText("two fa code", strEncodeTotpSecret);
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(clipDataNewPlainText);
        }
        AppToast.g(context, R.string.copied_text, 0, null, 12);
    }

    private final WidgetSettingsEnableMfaKeyBinding getBinding() {
        return (WidgetSettingsEnableMfaKeyBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetEnableMFAViewModel getViewModel() {
        return (WidgetEnableMFAViewModel) this.viewModel.getValue();
    }

    private final void showLaunchTexts() {
        PackageManager packageManager;
        FragmentActivity activity = getActivity();
        if (activity == null || (packageManager = activity.getPackageManager()) == null) {
            return;
        }
        Companion companion = INSTANCE;
        if (Companion.access$isPackageInstalled(companion, AuthUtils.AUTHY_PACKAGE, packageManager)) {
            TextView textView = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.enableMfaKeyLaunchAuthy");
            textView.setText(FormatUtils.k(this, R.string.launch_app, new Object[]{FormatUtils.k(this, R.string.two_fa_app_name_authy, new Object[0], null, 4)}, null, 4));
            TextView textView2 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.enableMfaKeyLaunchAuthy");
            textView2.setVisibility(0);
            getBinding().c.setOnClickListener(new AnonymousClass1(packageManager));
        }
        if (Companion.access$isPackageInstalled(companion, AuthUtils.GOOGLE_AUTHENTICATOR_PACKAGE, packageManager)) {
            TextView textView3 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.enableMfaKeyLaunchGoogleAuth");
            textView3.setText(FormatUtils.k(this, R.string.launch_app, new Object[]{FormatUtils.k(this, R.string.two_fa_app_name_google_authenticator, new Object[0], null, 4)}, null, 4));
            TextView textView4 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.enableMfaKeyLaunchGoogleAuth");
            textView4.setVisibility(0);
            getBinding().d.setOnClickListener(new AnonymousClass2(packageManager));
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextView textView = getBinding().f2618b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.enableMfaKeyCode");
        textView.setText(getViewModel().getTotpSecret());
        getBinding().f2618b.setOnClickListener(new AnonymousClass1());
        showLaunchTexts();
    }
}
