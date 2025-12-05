package com.discord.widgets.donut;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetDonutBetaPopupBinding;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppHelpDesk;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetDonutBetaPopup.kt */
/* loaded from: classes2.dex */
public final class WidgetDonutBetaPopup extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetDonutBetaPopup.class, "binding", "getBinding()Lcom/discord/databinding/WidgetDonutBetaPopupBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* compiled from: WidgetDonutBetaPopup.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(Context context, String source) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(source, "source");
            AnalyticsTracker.openModal$default("Project Donut Android Beta Required", source, null, 4, null);
            AppScreen2.m157e(context, WidgetDonutBetaPopup.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetDonutBetaPopup.kt */
    /* renamed from: com.discord.widgets.donut.WidgetDonutBetaPopup$onViewBound$1 */
    public static final class ViewOnClickListenerC83001 implements View.OnClickListener {
        public static final ViewOnClickListenerC83001 INSTANCE = new ViewOnClickListenerC83001();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            UriHandler.handle$default(UriHandler.INSTANCE, outline.m885x(view, "it", "it.context"), "https://play.google.com/apps/testing/com.discord", false, false, null, 28, null);
        }
    }

    /* compiled from: WidgetDonutBetaPopup.kt */
    /* renamed from: com.discord.widgets.donut.WidgetDonutBetaPopup$onViewBound$2 */
    public static final class ViewOnClickListenerC83012 implements View.OnClickListener {
        public ViewOnClickListenerC83012() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            FragmentActivity activity = WidgetDonutBetaPopup.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* compiled from: WidgetDonutBetaPopup.kt */
    /* renamed from: com.discord.widgets.donut.WidgetDonutBetaPopup$onViewBound$3 */
    public static final class ViewOnClickListenerC83023 implements View.OnClickListener {
        public ViewOnClickListenerC83023() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            FragmentActivity activity = WidgetDonutBetaPopup.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    public WidgetDonutBetaPopup() {
        super(C5419R.layout.widget_donut_beta_popup);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetDonutBetaPopup2.INSTANCE, null, 2, null);
    }

    private final WidgetDonutBetaPopupBinding getBinding() {
        return (WidgetDonutBetaPopupBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void show(Context context, String str) {
        INSTANCE.show(context, str);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        LinkifiedTextView linkifiedTextView = getBinding().f16486b;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.donutBetaBody");
        FormatUtils.m222n(linkifiedTextView, C5419R.string.donut_get_android_beta_body, new Object[]{AppHelpDesk.f507a.m149a(360003953831L, null)}, null, 4);
        getBinding().f16489e.setOnClickListener(ViewOnClickListenerC83001.INSTANCE);
        getBinding().f16488d.setOnClickListener(new ViewOnClickListenerC83012());
        getBinding().f16487c.setOnClickListener(new ViewOnClickListenerC83023());
    }
}
