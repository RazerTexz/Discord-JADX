package p007b.p008a.p009a;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.dialogs.SimpleConfirmationDialog2;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.button.MaterialButton;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p025i.SimpleConfirmationDialogBinding;
import p007b.p008a.p027k.FormatUtils;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;

/* compiled from: SimpleConfirmationDialog.kt */
/* renamed from: b.a.a.e, reason: use source file name */
/* loaded from: classes.dex */
public final class SimpleConfirmationDialog extends AppDialog {

    /* renamed from: j */
    public static final /* synthetic */ KProperty[] f344j = {outline.m846d0(SimpleConfirmationDialog.class, "binding", "getBinding()Lcom/discord/databinding/SimpleConfirmationDialogBinding;", 0)};

    /* renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: l, reason: from kotlin metadata */
    public final Lazy args;

    /* renamed from: m, reason: from kotlin metadata */
    public View.OnClickListener positiveClickListener;

    /* renamed from: n, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* compiled from: java-style lambda group */
    /* renamed from: b.a.a.e$a */
    public static final class a implements View.OnClickListener {

        /* renamed from: j */
        public final /* synthetic */ int f349j;

        /* renamed from: k */
        public final /* synthetic */ Object f350k;

        public a(int i, Object obj) {
            this.f349j = i;
            this.f350k = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.f349j;
            if (i != 0) {
                if (i != 1) {
                    throw null;
                }
                ((SimpleConfirmationDialog) this.f350k).dismiss();
            } else {
                View.OnClickListener onClickListener = ((SimpleConfirmationDialog) this.f350k).positiveClickListener;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
                ((SimpleConfirmationDialog) this.f350k).dismiss();
            }
        }
    }

    /* compiled from: ArgUtils.kt */
    /* renamed from: b.a.a.e$b */
    public static final class b extends Lambda implements Function0<SimpleConfirmationDialog2> {
        public final /* synthetic */ String $argsKey;
        public final /* synthetic */ AppDialog $this_args;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(AppDialog appDialog, String str) {
            super(0);
            this.$this_args = appDialog;
            this.$argsKey = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public SimpleConfirmationDialog2 invoke() {
            Bundle arguments = this.$this_args.getArguments();
            Object obj = arguments != null ? arguments.get(this.$argsKey) : null;
            SimpleConfirmationDialog2 simpleConfirmationDialog2 = (SimpleConfirmationDialog2) (obj instanceof SimpleConfirmationDialog2 ? obj : null);
            if (simpleConfirmationDialog2 != null) {
                return simpleConfirmationDialog2;
            }
            StringBuilder sbM833U = outline.m833U("Missing args for class type ");
            outline.m862l0(SimpleConfirmationDialog2.class, sbM833U, " + key ");
            throw new IllegalStateException(outline.m820H(sbM833U, this.$argsKey, '!'));
        }
    }

    /* compiled from: SimpleConfirmationDialog.kt */
    /* renamed from: b.a.a.e$c, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* renamed from: a */
        public final SimpleConfirmationDialog m128a(FragmentManager fragmentManager, SimpleConfirmationDialog2 simpleConfirmationDialog2, View.OnClickListener onClickListener) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(simpleConfirmationDialog2, "args");
            Intrinsics3.checkNotNullParameter(onClickListener, "positiveClickListener");
            SimpleConfirmationDialog simpleConfirmationDialog = new SimpleConfirmationDialog();
            simpleConfirmationDialog.setArguments(AnimatableValueParser.m514e2(simpleConfirmationDialog2));
            simpleConfirmationDialog.positiveClickListener = onClickListener;
            simpleConfirmationDialog.show(fragmentManager, Reflection2.getOrCreateKotlinClass(SimpleConfirmationDialog.class).toString());
            return simpleConfirmationDialog;
        }
    }

    /* compiled from: SimpleConfirmationDialog.kt */
    /* renamed from: b.a.a.e$d */
    public static final /* synthetic */ class d extends FunctionReferenceImpl implements Function1<View, SimpleConfirmationDialogBinding> {

        /* renamed from: j */
        public static final d f351j = new d();

        public d() {
            super(1, SimpleConfirmationDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/SimpleConfirmationDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public SimpleConfirmationDialogBinding invoke(View view) {
            View view2 = view;
            Intrinsics3.checkNotNullParameter(view2, "p1");
            int i = C5419R.id.notice_header_container;
            LinearLayout linearLayout = (LinearLayout) view2.findViewById(C5419R.id.notice_header_container);
            if (linearLayout != null) {
                i = C5419R.id.simple_confirmation_dialog_description;
                TextView textView = (TextView) view2.findViewById(C5419R.id.simple_confirmation_dialog_description);
                if (textView != null) {
                    i = C5419R.id.simple_confirmation_dialog_negative;
                    MaterialButton materialButton = (MaterialButton) view2.findViewById(C5419R.id.simple_confirmation_dialog_negative);
                    if (materialButton != null) {
                        i = C5419R.id.simple_confirmation_dialog_positive;
                        MaterialButton materialButton2 = (MaterialButton) view2.findViewById(C5419R.id.simple_confirmation_dialog_positive);
                        if (materialButton2 != null) {
                            i = C5419R.id.simple_confirmation_dialog_title;
                            TextView textView2 = (TextView) view2.findViewById(C5419R.id.simple_confirmation_dialog_title);
                            if (textView2 != null) {
                                return new SimpleConfirmationDialogBinding((LinearLayout) view2, linearLayout, textView, materialButton, materialButton2, textView2);
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    public SimpleConfirmationDialog() {
        super(C5419R.layout.simple_confirmation_dialog);
        this.args = LazyJVM.lazy(new b(this, "intent_args_key"));
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, d.f351j, null, 2, null);
    }

    /* renamed from: g */
    public final SimpleConfirmationDialog2 m126g() {
        return (SimpleConfirmationDialog2) this.args.getValue();
    }

    /* renamed from: h */
    public final SimpleConfirmationDialogBinding m127h() {
        return (SimpleConfirmationDialogBinding) this.binding.getValue((Fragment) this, f344j[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        requireDialog().setCanceledOnTouchOutside(true);
        m127h().f1100d.setOnClickListener(new a(0, this));
        m127h().f1100d.setText(m126g().f18506l);
        m127h().f1099c.setOnClickListener(new a(1, this));
        MaterialButton materialButton = m127h().f1099c;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.simpleConfirmationDialogNegative");
        materialButton.setText(m126g().f18507m);
        TextView textView = m127h().f1101e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.simpleConfirmationDialogTitle");
        FormatUtils.m209a(textView, m126g().f18504j);
        TextView textView2 = m127h().f1098b;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.simpleConfirmationDialogDescription");
        FormatUtils.m209a(textView2, m126g().f18505k);
    }
}
