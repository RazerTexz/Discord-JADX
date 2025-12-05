package com.discord.widgets.playstation;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetPlaystationUpsellBottomSheetBinding;
import com.discord.i18n.RenderContext;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserConnections;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.platform.Platform;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetPlaystationIntegrationUpsellBottomSheet.kt */
/* loaded from: classes2.dex */
public final class WidgetPlaystationIntegrationUpsellBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetPlaystationIntegrationUpsellBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetPlaystationUpsellBottomSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* compiled from: WidgetPlaystationIntegrationUpsellBottomSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            new WidgetPlaystationIntegrationUpsellBottomSheet().show(fragmentManager, WidgetPlaystationIntegrationUpsellBottomSheet.class.getSimpleName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetPlaystationIntegrationUpsellBottomSheet.kt */
    /* renamed from: com.discord.widgets.playstation.WidgetPlaystationIntegrationUpsellBottomSheet$onViewCreated$2 */
    public static final class ViewOnClickListenerC91202 implements View.OnClickListener {
        public ViewOnClickListenerC91202() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetPlaystationIntegrationUpsellBottomSheet.access$logConfirm(WidgetPlaystationIntegrationUpsellBottomSheet.this);
            StoreUserConnections userConnections = StoreStream.INSTANCE.getUserConnections();
            String platformId = Platform.PLAYSTATION.getPlatformId();
            FragmentActivity fragmentActivityRequireActivity = WidgetPlaystationIntegrationUpsellBottomSheet.this.requireActivity();
            Intrinsics3.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
            userConnections.authorizeConnection(platformId, fragmentActivityRequireActivity, Traits.Location.Section.PLAYSTATION_UPSELL);
            WidgetPlaystationIntegrationUpsellBottomSheet.this.dismiss();
        }
    }

    /* compiled from: WidgetPlaystationIntegrationUpsellBottomSheet.kt */
    /* renamed from: com.discord.widgets.playstation.WidgetPlaystationIntegrationUpsellBottomSheet$onViewCreated$3 */
    public static final class ViewOnClickListenerC91213 implements View.OnClickListener {
        public ViewOnClickListenerC91213() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Dialog dialog = WidgetPlaystationIntegrationUpsellBottomSheet.this.getDialog();
            Intrinsics3.checkNotNull(dialog);
            dialog.cancel();
        }
    }

    public WidgetPlaystationIntegrationUpsellBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetPlaystationIntegrationUpsellBottomSheet2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$logConfirm(WidgetPlaystationIntegrationUpsellBottomSheet widgetPlaystationIntegrationUpsellBottomSheet) {
        widgetPlaystationIntegrationUpsellBottomSheet.logConfirm();
    }

    private final WidgetPlaystationUpsellBottomSheetBinding getBinding() {
        return (WidgetPlaystationUpsellBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void logConfirm() {
        AnalyticsTracker.INSTANCE.trackAccountLinkStep(Platform.PLAYSTATION.getPlatformId(), "playstation_connect_upsell");
    }

    private final void logDismiss() {
        AnalyticsTracker.INSTANCE.trackDismissibleContentDismissed("PLAYSTATION_CONNECT_UPSELL");
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_playstation_upsell_bottom_sheet;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialog) {
        Intrinsics3.checkNotNullParameter(dialog, "dialog");
        super.onCancel(dialog);
        logDismiss();
    }

    @Override // com.discord.app.AppBottomSheet
    public void onStateChanged(int state) {
        super.onStateChanged(state);
        if (state == 5) {
            logDismiss();
        }
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        TextView textView = getBinding().f17373d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.upsellHeader");
        textView.setText(FormatUtils.m213e(this, C5419R.string.user_activity_connect_platform, new Object[0], C91191.INSTANCE));
        getBinding().f17372c.setOnClickListener(new ViewOnClickListenerC91202());
        getBinding().f17371b.setOnClickListener(new ViewOnClickListenerC91213());
    }

    /* compiled from: WidgetPlaystationIntegrationUpsellBottomSheet.kt */
    /* renamed from: com.discord.widgets.playstation.WidgetPlaystationIntegrationUpsellBottomSheet$onViewCreated$1 */
    public static final class C91191 extends Lambda implements Function1<RenderContext, Unit> {
        public static final C91191 INSTANCE = new C91191();

        public C91191() {
            super(1);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.args.put("platform", Platform.PLAYSTATION.getProperName());
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }
    }
}
