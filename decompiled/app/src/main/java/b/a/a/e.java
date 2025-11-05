package b.a.a;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.i.o1;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.dialogs.SimpleConfirmationDialogArgs;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.button.MaterialButton;
import d0.g;
import d0.z.d.a0;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: SimpleConfirmationDialog.kt */
/* loaded from: classes.dex */
public final class e extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {b.d.b.a.a.d0(e.class, "binding", "getBinding()Lcom/discord/databinding/SimpleConfirmationDialogBinding;", 0)};

    /* renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: l, reason: from kotlin metadata */
    public final Lazy args;

    /* renamed from: m, reason: from kotlin metadata */
    public View.OnClickListener positiveClickListener;

    /* renamed from: n, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* compiled from: java-style lambda group */
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
            if (i != 0) {
                if (i != 1) {
                    throw null;
                }
                ((e) this.k).dismiss();
            } else {
                View.OnClickListener onClickListener = ((e) this.k).positiveClickListener;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
                ((e) this.k).dismiss();
            }
        }
    }

    /* compiled from: ArgUtils.kt */
    public static final class b extends d0.z.d.o implements Function0<SimpleConfirmationDialogArgs> {
        public final /* synthetic */ String $argsKey;
        public final /* synthetic */ AppDialog $this_args;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(AppDialog appDialog, String str) {
            super(0);
            this.$this_args = appDialog;
            this.$argsKey = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public SimpleConfirmationDialogArgs invoke() {
            Bundle arguments = this.$this_args.getArguments();
            Object obj = arguments != null ? arguments.get(this.$argsKey) : null;
            SimpleConfirmationDialogArgs simpleConfirmationDialogArgs = (SimpleConfirmationDialogArgs) (obj instanceof SimpleConfirmationDialogArgs ? obj : null);
            if (simpleConfirmationDialogArgs != null) {
                return simpleConfirmationDialogArgs;
            }
            StringBuilder sbU = b.d.b.a.a.U("Missing args for class type ");
            b.d.b.a.a.l0(SimpleConfirmationDialogArgs.class, sbU, " + key ");
            throw new IllegalStateException(b.d.b.a.a.H(sbU, this.$argsKey, '!'));
        }
    }

    /* compiled from: SimpleConfirmationDialog.kt */
    /* renamed from: b.a.a.e$c, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final e a(FragmentManager fragmentManager, SimpleConfirmationDialogArgs simpleConfirmationDialogArgs, View.OnClickListener onClickListener) {
            d0.z.d.m.checkNotNullParameter(fragmentManager, "fragmentManager");
            d0.z.d.m.checkNotNullParameter(simpleConfirmationDialogArgs, "args");
            d0.z.d.m.checkNotNullParameter(onClickListener, "positiveClickListener");
            e eVar = new e();
            eVar.setArguments(b.c.a.a0.d.e2(simpleConfirmationDialogArgs));
            eVar.positiveClickListener = onClickListener;
            eVar.show(fragmentManager, a0.getOrCreateKotlinClass(e.class).toString());
            return eVar;
        }
    }

    /* compiled from: SimpleConfirmationDialog.kt */
    public static final /* synthetic */ class d extends d0.z.d.k implements Function1<View, o1> {
        public static final d j = new d();

        public d() {
            super(1, o1.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/SimpleConfirmationDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public o1 invoke(View view) {
            View view2 = view;
            d0.z.d.m.checkNotNullParameter(view2, "p1");
            int i = R.id.notice_header_container;
            LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.notice_header_container);
            if (linearLayout != null) {
                i = R.id.simple_confirmation_dialog_description;
                TextView textView = (TextView) view2.findViewById(R.id.simple_confirmation_dialog_description);
                if (textView != null) {
                    i = R.id.simple_confirmation_dialog_negative;
                    MaterialButton materialButton = (MaterialButton) view2.findViewById(R.id.simple_confirmation_dialog_negative);
                    if (materialButton != null) {
                        i = R.id.simple_confirmation_dialog_positive;
                        MaterialButton materialButton2 = (MaterialButton) view2.findViewById(R.id.simple_confirmation_dialog_positive);
                        if (materialButton2 != null) {
                            i = R.id.simple_confirmation_dialog_title;
                            TextView textView2 = (TextView) view2.findViewById(R.id.simple_confirmation_dialog_title);
                            if (textView2 != null) {
                                return new o1((LinearLayout) view2, linearLayout, textView, materialButton, materialButton2, textView2);
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    public e() {
        super(R.layout.simple_confirmation_dialog);
        this.args = g.lazy(new b(this, "intent_args_key"));
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, d.j, null, 2, null);
    }

    public final SimpleConfirmationDialogArgs g() {
        return (SimpleConfirmationDialogArgs) this.args.getValue();
    }

    public final o1 h() {
        return (o1) this.binding.getValue((Fragment) this, j[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        requireDialog().setCanceledOnTouchOutside(true);
        h().d.setOnClickListener(new a(0, this));
        h().d.setText(g().l);
        h().c.setOnClickListener(new a(1, this));
        MaterialButton materialButton = h().c;
        d0.z.d.m.checkNotNullExpressionValue(materialButton, "binding.simpleConfirmationDialogNegative");
        materialButton.setText(g().m);
        TextView textView = h().e;
        d0.z.d.m.checkNotNullExpressionValue(textView, "binding.simpleConfirmationDialogTitle");
        b.a.k.b.a(textView, g().j);
        TextView textView2 = h().f172b;
        d0.z.d.m.checkNotNullExpressionValue(textView2, "binding.simpleConfirmationDialogDescription");
        b.a.k.b.a(textView2, g().k);
    }
}
