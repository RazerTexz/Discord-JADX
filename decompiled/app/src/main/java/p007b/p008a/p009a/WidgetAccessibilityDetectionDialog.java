package p007b.p008a.p009a;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.button.MaterialButton;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p000.C12788k;
import p007b.p008a.p018d.AppHelpDesk;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p008a.p025i.AllowAccessibilityDetectionDialogBinding;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;

/* compiled from: WidgetAccessibilityDetectionDialog.kt */
/* renamed from: b.a.a.h, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetAccessibilityDetectionDialog extends AppDialog {

    /* renamed from: j */
    public static final /* synthetic */ KProperty[] f376j = {outline.m846d0(WidgetAccessibilityDetectionDialog.class, "binding", "getBinding()Lcom/discord/databinding/AllowAccessibilityDetectionDialogBinding;", 0)};

    /* renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* renamed from: m, reason: from kotlin metadata */
    public final Lazy viewModel;

    /* compiled from: java-style lambda group */
    /* renamed from: b.a.a.h$a */
    /* loaded from: classes2.dex */
    public static final class a implements View.OnClickListener {

        /* renamed from: j */
        public final /* synthetic */ int f380j;

        /* renamed from: k */
        public final /* synthetic */ Object f381k;

        public a(int i, Object obj) {
            this.f380j = i;
            this.f381k = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.f380j;
            if (i == 0) {
                WidgetAccessibilityDetectionDialog.m134g((WidgetAccessibilityDetectionDialog) this.f381k, false);
            } else {
                if (i != 1) {
                    throw null;
                }
                WidgetAccessibilityDetectionDialog.m134g((WidgetAccessibilityDetectionDialog) this.f381k, true);
            }
        }
    }

    /* compiled from: WidgetAccessibilityDetectionDialog.kt */
    /* renamed from: b.a.a.h$b, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: WidgetAccessibilityDetectionDialog.kt */
    /* renamed from: b.a.a.h$c */
    public static final /* synthetic */ class c extends FunctionReferenceImpl implements Function1<View, AllowAccessibilityDetectionDialogBinding> {

        /* renamed from: j */
        public static final c f382j = new c();

        public c() {
            super(1, AllowAccessibilityDetectionDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/AllowAccessibilityDetectionDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public AllowAccessibilityDetectionDialogBinding invoke(View view) {
            View view2 = view;
            Intrinsics3.checkNotNullParameter(view2, "p1");
            int i = C5419R.id.accessibility_detection_body_text;
            TextView textView = (TextView) view2.findViewById(C5419R.id.accessibility_detection_body_text);
            if (textView != null) {
                i = C5419R.id.accessibility_detection_disable;
                MaterialButton materialButton = (MaterialButton) view2.findViewById(C5419R.id.accessibility_detection_disable);
                if (materialButton != null) {
                    i = C5419R.id.accessibility_detection_enable;
                    MaterialButton materialButton2 = (MaterialButton) view2.findViewById(C5419R.id.accessibility_detection_enable);
                    if (materialButton2 != null) {
                        i = C5419R.id.view_dialog_confirmation_header;
                        TextView textView2 = (TextView) view2.findViewById(C5419R.id.view_dialog_confirmation_header);
                        if (textView2 != null) {
                            return new AllowAccessibilityDetectionDialogBinding((LinearLayout) view2, textView, materialButton, materialButton2, textView2);
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* compiled from: WidgetAccessibilityDetectionDialog.kt */
    /* renamed from: b.a.a.h$d */
    public static final class d extends Lambda implements Function0<WidgetAccessibilityDetectionDialogViewModel> {

        /* renamed from: j */
        public static final d f383j = new d();

        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public WidgetAccessibilityDetectionDialogViewModel invoke() {
            return new WidgetAccessibilityDetectionDialogViewModel(null, null, 3);
        }
    }

    public WidgetAccessibilityDetectionDialog() {
        super(C5419R.layout.allow_accessibility_detection_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, c.f382j, null, 2, null);
        d dVar = d.f383j;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetAccessibilityDetectionDialogViewModel.class), new C12788k(0, appViewModelDelegates3), new AppViewModelDelegates5(dVar));
    }

    /* renamed from: g */
    public static final void m134g(WidgetAccessibilityDetectionDialog widgetAccessibilityDetectionDialog, boolean z2) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(((WidgetAccessibilityDetectionDialogViewModel) widgetAccessibilityDetectionDialog.viewModel.getValue()).f419j.setIsAccessibilityDetectionAllowed(z2), false, 1, null), WidgetAccessibilityDetectionDialogViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, WidgetAccessibilityDetectionDialogViewModel2.f422j, 62, (Object) null);
        widgetAccessibilityDetectionDialog.dismiss();
    }

    /* renamed from: h */
    public final AllowAccessibilityDetectionDialogBinding m135h() {
        return (AllowAccessibilityDetectionDialogBinding) this.binding.getValue((Fragment) this, f376j[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        m135h().f656c.setOnClickListener(new a(0, this));
        m135h().f657d.setOnClickListener(new a(1, this));
        TextView textView = m135h().f655b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.accessibilityDetectionBodyText");
        FormatUtils.m222n(textView, C5419R.string.accessibility_detection_modal_body, new Object[]{AppHelpDesk.f507a.m149a(360035966492L, null)}, null, 4);
    }
}
