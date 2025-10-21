package com.discord.widgets.donut;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import b.a.d.AppHelpDesk;
import b.a.d.AppScreen2;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetDonutBetaPopupBinding;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetDonutBetaPopup.kt */
/* loaded from: classes2.dex */
public final class WidgetDonutBetaPopup extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetDonutBetaPopup.class, "binding", "getBinding()Lcom/discord/databinding/WidgetDonutBetaPopupBinding;", 0)};

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
            AppScreen2.e(context, WidgetDonutBetaPopup.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetDonutBetaPopup.kt */
    /* renamed from: com.discord.widgets.donut.WidgetDonutBetaPopup$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            UriHandler.handle$default(UriHandler.INSTANCE, outline.x(view, "it", "it.context"), "https://play.google.com/apps/testing/com.discord", false, false, null, 28, null);
        }
    }

    /* compiled from: WidgetDonutBetaPopup.kt */
    /* renamed from: com.discord.widgets.donut.WidgetDonutBetaPopup$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
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
    /* renamed from: com.discord.widgets.donut.WidgetDonutBetaPopup$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
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
        super(R.layout.widget_donut_beta_popup);
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
        LinkifiedTextView linkifiedTextView = getBinding().f2368b;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.donutBetaBody");
        FormatUtils.n(linkifiedTextView, R.string.donut_get_android_beta_body, new Object[]{AppHelpDesk.a.a(360003953831L, null)}, null, 4);
        getBinding().e.setOnClickListener(AnonymousClass1.INSTANCE);
        getBinding().d.setOnClickListener(new AnonymousClass2());
        getBinding().c.setOnClickListener(new AnonymousClass3());
    }
}
