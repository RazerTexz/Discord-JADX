package b.a.a.b;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.a.i.e1;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.button.MaterialButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: PremiumAndGuildBoostActivatedDialog.kt */
/* loaded from: classes.dex */
public final class g extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {b.d.b.a.a.d0(g.class, "binding", "getBinding()Lcom/discord/databinding/PremiumAndGuildBoostActivatedDialogBinding;", 0)};

    /* renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: l, reason: from kotlin metadata */
    public Function0<Unit> onDismiss;

    /* renamed from: m, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* compiled from: PremiumAndGuildBoostActivatedDialog.kt */
    /* renamed from: b.a.a.b.g$a, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: PremiumAndGuildBoostActivatedDialog.kt */
    public static final /* synthetic */ class b extends k implements Function1<View, e1> {
        public static final b j = new b();

        public b() {
            super(1, e1.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/PremiumAndGuildBoostActivatedDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public e1 invoke(View view) {
            View view2 = view;
            m.checkNotNullParameter(view2, "p1");
            int i = R.id.premium_activated_confirm;
            MaterialButton materialButton = (MaterialButton) view2.findViewById(R.id.premium_activated_confirm);
            if (materialButton != null) {
                i = R.id.premium_and_guild_boost_activated_text;
                TextView textView = (TextView) view2.findViewById(R.id.premium_and_guild_boost_activated_text);
                if (textView != null) {
                    return new e1((LinearLayout) view2, materialButton, textView);
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* compiled from: PremiumAndGuildBoostActivatedDialog.kt */
    public static final class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function0<Unit> function0 = g.this.onDismiss;
            if (function0 != null) {
                function0.invoke();
            }
            g.this.dismiss();
        }
    }

    public g() {
        super(R.layout.premium_and_guild_boost_activated_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, b.j, null, 2, null);
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
        m.checkNotNullExpressionValue(string, "arguments?.getString(EXTRA_PLAN_NAME) ?: \"\"");
        FragmentViewBindingDelegate fragmentViewBindingDelegate = this.binding;
        KProperty<?>[] kPropertyArr = j;
        TextView textView = ((e1) fragmentViewBindingDelegate.getValue((Fragment) this, kPropertyArr[0])).c;
        m.checkNotNullExpressionValue(textView, "binding.premiumAndGuildBoostActivatedText");
        b.a.k.b.n(textView, R.string.billing_premium_and_premium_guild_plan_activated, new Object[]{string}, null, 4);
        requireDialog().setCanceledOnTouchOutside(true);
        ((e1) this.binding.getValue((Fragment) this, kPropertyArr[0])).f103b.setOnClickListener(new c());
    }
}
