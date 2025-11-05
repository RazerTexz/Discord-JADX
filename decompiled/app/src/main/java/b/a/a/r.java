package b.a.a;

import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.a.d.f;
import b.a.i.o4;
import b.d.b.a.a;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetBlockRussianPurchasesDialog.kt */
/* loaded from: classes.dex */
public final class r extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {a.d0(r.class, "binding", "getBinding()Lcom/discord/databinding/WidgetBlockRussianPurchasesDialogBinding;", 0)};

    /* renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* compiled from: WidgetBlockRussianPurchasesDialog.kt */
    /* renamed from: b.a.a.r$a, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: WidgetBlockRussianPurchasesDialog.kt */
    public static final /* synthetic */ class b extends d0.z.d.k implements Function1<View, o4> {
        public static final b j = new b();

        public b() {
            super(1, o4.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetBlockRussianPurchasesDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public o4 invoke(View view) {
            View view2 = view;
            d0.z.d.m.checkNotNullParameter(view2, "p1");
            int i = R.id.notice_body_container;
            LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.notice_body_container);
            if (linearLayout != null) {
                i = R.id.notice_body_text;
                LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view2.findViewById(R.id.notice_body_text);
                if (linkifiedTextView != null) {
                    i = R.id.notice_header;
                    TextView textView = (TextView) view2.findViewById(R.id.notice_header);
                    if (textView != null) {
                        i = R.id.notice_header_container;
                        LinearLayout linearLayout2 = (LinearLayout) view2.findViewById(R.id.notice_header_container);
                        if (linearLayout2 != null) {
                            i = R.id.notice_ok;
                            MaterialButton materialButton = (MaterialButton) view2.findViewById(R.id.notice_ok);
                            if (materialButton != null) {
                                return new o4((LinearLayout) view2, linearLayout, linkifiedTextView, textView, linearLayout2, materialButton);
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* compiled from: WidgetBlockRussianPurchasesDialog.kt */
    public static final class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            r.this.dismiss();
        }
    }

    public r() {
        super(R.layout.widget_block_russian_purchases_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, b.j, null, 2, null);
    }

    public final o4 g() {
        return (o4) this.binding.getValue((Fragment) this, j[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        d0.z.d.m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        LinkifiedTextView linkifiedTextView = g().f175b;
        d0.z.d.m.checkNotNullExpressionValue(linkifiedTextView, "binding.noticeBodyText");
        b.a.k.b.n(linkifiedTextView, R.string.region_blocked_payments_cta, new Object[]{f.a.a(4708041338391L, null)}, null, 4);
        LinkifiedTextView linkifiedTextView2 = g().f175b;
        d0.z.d.m.checkNotNullExpressionValue(linkifiedTextView2, "binding.noticeBodyText");
        linkifiedTextView2.setMovementMethod(LinkMovementMethod.getInstance());
        g().c.setOnClickListener(new c());
    }
}
