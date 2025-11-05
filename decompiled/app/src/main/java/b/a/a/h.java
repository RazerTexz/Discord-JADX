package b.a.a;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.f;
import b.a.d.g0;
import b.a.d.i0;
import b.a.k.b;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.button.MaterialButton;
import d0.z.d.a0;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetAccessibilityDetectionDialog.kt */
/* loaded from: classes.dex */
public final class h extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {b.d.b.a.a.d0(h.class, "binding", "getBinding()Lcom/discord/databinding/AllowAccessibilityDetectionDialogBinding;", 0)};

    /* renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* renamed from: m, reason: from kotlin metadata */
    public final Lazy viewModel;

    /* compiled from: java-style lambda group */
    /* loaded from: classes2.dex */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int j;
        public final /* synthetic */ Object k;

        public a(int i, Object obj) {
            this.j = i;
            this.k = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.j;
            if (i == 0) {
                h.g((h) this.k, false);
            } else {
                if (i != 1) {
                    throw null;
                }
                h.g((h) this.k, true);
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
    public static final /* synthetic */ class c extends d0.z.d.k implements Function1<View, b.a.i.a> {
        public static final c j = new c();

        public c() {
            super(1, b.a.i.a.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/AllowAccessibilityDetectionDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public b.a.i.a invoke(View view) {
            View view2 = view;
            d0.z.d.m.checkNotNullParameter(view2, "p1");
            int i = R.id.accessibility_detection_body_text;
            TextView textView = (TextView) view2.findViewById(R.id.accessibility_detection_body_text);
            if (textView != null) {
                i = R.id.accessibility_detection_disable;
                MaterialButton materialButton = (MaterialButton) view2.findViewById(R.id.accessibility_detection_disable);
                if (materialButton != null) {
                    i = R.id.accessibility_detection_enable;
                    MaterialButton materialButton2 = (MaterialButton) view2.findViewById(R.id.accessibility_detection_enable);
                    if (materialButton2 != null) {
                        i = R.id.view_dialog_confirmation_header;
                        TextView textView2 = (TextView) view2.findViewById(R.id.view_dialog_confirmation_header);
                        if (textView2 != null) {
                            return new b.a.i.a((LinearLayout) view2, textView, materialButton, materialButton2, textView2);
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* compiled from: WidgetAccessibilityDetectionDialog.kt */
    public static final class d extends d0.z.d.o implements Function0<p> {
        public static final d j = new d();

        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public p invoke() {
            return new p(null, null, 3);
        }
    }

    public h() {
        super(R.layout.allow_accessibility_detection_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, c.j, null, 2, null);
        d dVar = d.j;
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(p.class), new defpackage.k(0, g0Var), new i0(dVar));
    }

    public static final void g(h hVar, boolean z2) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(((p) hVar.viewModel.getValue()).j.setIsAccessibilityDetectionAllowed(z2), false, 1, null), p.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, q.j, 62, (Object) null);
        hVar.dismiss();
    }

    public final b.a.i.a h() {
        return (b.a.i.a) this.binding.getValue((Fragment) this, j[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        d0.z.d.m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        h().c.setOnClickListener(new a(0, this));
        h().d.setOnClickListener(new a(1, this));
        TextView textView = h().f72b;
        d0.z.d.m.checkNotNullExpressionValue(textView, "binding.accessibilityDetectionBodyText");
        b.n(textView, R.string.accessibility_detection_modal_body, new Object[]{f.a.a(360035966492L, null)}, null, 4);
    }
}
