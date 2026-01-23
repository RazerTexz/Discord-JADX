package p007b.p008a.p009a.p012b;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.button.MaterialButton;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p025i.PremiumAndGuildBoostActivatedDialogBinding;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: b.a.a.b.g, reason: use source file name */
/* JADX INFO: compiled from: PremiumAndGuildBoostActivatedDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PremiumAndGuildBoostActivatedDialog extends AppDialog {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ KProperty[] f301j = {outline.m846d0(PremiumAndGuildBoostActivatedDialog.class, "binding", "getBinding()Lcom/discord/databinding/PremiumAndGuildBoostActivatedDialogBinding;", 0)};

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public Function0<Unit> onDismiss;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: b.a.a.b.g$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: PremiumAndGuildBoostActivatedDialog.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: renamed from: b.a.a.b.g$b */
    /* JADX INFO: compiled from: PremiumAndGuildBoostActivatedDialog.kt */
    public static final /* synthetic */ class b extends FunctionReferenceImpl implements Function1<View, PremiumAndGuildBoostActivatedDialogBinding> {

        /* JADX INFO: renamed from: j */
        public static final b f305j = new b();

        public b() {
            super(1, PremiumAndGuildBoostActivatedDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/PremiumAndGuildBoostActivatedDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public PremiumAndGuildBoostActivatedDialogBinding invoke(View view) {
            View view2 = view;
            Intrinsics3.checkNotNullParameter(view2, "p1");
            int i = C5419R.id.premium_activated_confirm;
            MaterialButton materialButton = (MaterialButton) view2.findViewById(C5419R.id.premium_activated_confirm);
            if (materialButton != null) {
                i = C5419R.id.premium_and_guild_boost_activated_text;
                TextView textView = (TextView) view2.findViewById(C5419R.id.premium_and_guild_boost_activated_text);
                if (textView != null) {
                    return new PremiumAndGuildBoostActivatedDialogBinding((LinearLayout) view2, materialButton, textView);
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* JADX INFO: renamed from: b.a.a.b.g$c */
    /* JADX INFO: compiled from: PremiumAndGuildBoostActivatedDialog.kt */
    public static final class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function0<Unit> function0 = PremiumAndGuildBoostActivatedDialog.this.onDismiss;
            if (function0 != null) {
                function0.invoke();
            }
            PremiumAndGuildBoostActivatedDialog.this.dismiss();
        }
    }

    public PremiumAndGuildBoostActivatedDialog() {
        super(C5419R.layout.premium_and_guild_boost_activated_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, b.f305j, null, 2, null);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        String string;
        super.onViewBoundOrOnResume();
        if (this.onDismiss == null) {
            dismiss();
        }
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString("extra_plan_text")) == null) {
            string = "";
        }
        Intrinsics3.checkNotNullExpressionValue(string, "arguments?.getString(EXTRA_PLAN_NAME) ?: \"\"");
        FragmentViewBindingDelegate fragmentViewBindingDelegate = this.binding;
        KProperty<?>[] kPropertyArr = f301j;
        TextView textView = ((PremiumAndGuildBoostActivatedDialogBinding) fragmentViewBindingDelegate.getValue((Fragment) this, kPropertyArr[0])).f807c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.premiumAndGuildBoostActivatedText");
        FormatUtils.m222n(textView, C5419R.string.billing_premium_and_premium_guild_plan_activated, new Object[]{string}, null, 4);
        requireDialog().setCanceledOnTouchOutside(true);
        ((PremiumAndGuildBoostActivatedDialogBinding) this.binding.getValue((Fragment) this, kPropertyArr[0])).f806b.setOnClickListener(new c());
    }
}
