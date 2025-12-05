package com.discord.widgets.settings.account.mfa;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsEnableMfaInputBinding;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppViewModelDelegates2;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;

/* compiled from: WidgetEnableMFAInput.kt */
/* loaded from: classes2.dex */
public final class WidgetEnableMFAInput extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetEnableMFAInput.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsEnableMfaInputBinding;", 0)};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetEnableMFAInput.kt */
    /* renamed from: com.discord.widgets.settings.account.mfa.WidgetEnableMFAInput$onViewBound$1 */
    public static final class C97881 extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ View $view;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C97881(View view) {
            super(1);
            this.$view = view;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "verificationCode");
            WidgetEnableMFAViewModel widgetEnableMFAViewModelAccess$getViewModel$p = WidgetEnableMFAInput.access$getViewModel$p(WidgetEnableMFAInput.this);
            Context context = this.$view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "view.context");
            widgetEnableMFAViewModelAccess$getViewModel$p.enableMFA(context, str);
        }
    }

    public WidgetEnableMFAInput() {
        super(C5419R.layout.widget_settings_enable_mfa_input);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetEnableMFAInput2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetEnableMFAViewModel.class), new C9786x16bb66e8(this), new AppViewModelDelegates2(WidgetEnableMFAInput3.INSTANCE));
    }

    public static final /* synthetic */ WidgetEnableMFAViewModel access$getViewModel$p(WidgetEnableMFAInput widgetEnableMFAInput) {
        return widgetEnableMFAInput.getViewModel();
    }

    private final WidgetSettingsEnableMfaInputBinding getBinding() {
        return (WidgetSettingsEnableMfaInputBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetEnableMFAViewModel getViewModel() {
        return (WidgetEnableMFAViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().f17946b.setOnCodeEntered(new C97881(view));
    }

    @Override // androidx.fragment.app.Fragment
    public void setMenuVisibility(boolean menuVisible) {
        Context context;
        ClipData primaryClip;
        super.setMenuVisibility(menuVisible);
        if (!menuVisible || (context = getContext()) == null) {
            return;
        }
        Intrinsics3.checkNotNullExpressionValue(context, "context ?: return");
        Object systemService = context.getSystemService("clipboard");
        if (!(systemService instanceof ClipboardManager)) {
            systemService = null;
        }
        ClipboardManager clipboardManager = (ClipboardManager) systemService;
        if (clipboardManager == null || (primaryClip = clipboardManager.getPrimaryClip()) == null) {
            return;
        }
        Intrinsics3.checkNotNullExpressionValue(primaryClip, "clipboard.primaryClip ?: return");
        if (primaryClip.getItemCount() > 0) {
            ClipData.Item itemAt = primaryClip.getItemAt(0);
            Intrinsics3.checkNotNullExpressionValue(itemAt, "clipData.getItemAt(0)");
            CharSequence text = itemAt.getText();
            if (text != null && text.length() == 6 && TextUtils.isDigitsOnly(text)) {
                getBinding().f17946b.setCode(text);
            }
        }
    }
}
