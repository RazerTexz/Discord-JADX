package b.a.a.b;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.a.i.GuildBoostUpgradeDialogBinding;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: UpgradeGuildBoostDialog.kt */
/* renamed from: b.a.a.b.a, reason: use source file name */
/* loaded from: classes.dex */
public final class UpgradeGuildBoostDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {outline.d0(UpgradeGuildBoostDialog.class, "binding", "getBinding()Lcom/discord/databinding/GuildBoostUpgradeDialogBinding;", 0)};

    /* renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: l, reason: from kotlin metadata */
    public Function0<Unit> onContinueClickListener;

    /* renamed from: m, reason: from kotlin metadata */
    public Function0<Unit> onUpgradeClickListener;

    /* renamed from: n, reason: from kotlin metadata */
    public String upgradePrice;

    /* renamed from: o, reason: from kotlin metadata */
    public boolean hasBoostPlan;

    /* renamed from: p, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* compiled from: java-style lambda group */
    /* renamed from: b.a.a.b.a$a */
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
                Function0<Unit> function0 = ((UpgradeGuildBoostDialog) this.k).onContinueClickListener;
                if (function0 != null) {
                    function0.invoke();
                }
                ((UpgradeGuildBoostDialog) this.k).dismiss();
                return;
            }
            if (i != 1) {
                if (i != 2) {
                    throw null;
                }
                ((UpgradeGuildBoostDialog) this.k).dismiss();
            } else {
                Function0<Unit> function02 = ((UpgradeGuildBoostDialog) this.k).onUpgradeClickListener;
                if (function02 != null) {
                    function02.invoke();
                }
                ((UpgradeGuildBoostDialog) this.k).dismiss();
            }
        }
    }

    /* compiled from: UpgradeGuildBoostDialog.kt */
    /* renamed from: b.a.a.b.a$b, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: UpgradeGuildBoostDialog.kt */
    /* renamed from: b.a.a.b.a$c */
    public static final /* synthetic */ class c extends FunctionReferenceImpl implements Function1<View, GuildBoostUpgradeDialogBinding> {
        public static final c j = new c();

        public c() {
            super(1, GuildBoostUpgradeDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/GuildBoostUpgradeDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public GuildBoostUpgradeDialogBinding invoke(View view) {
            View view2 = view;
            Intrinsics3.checkNotNullParameter(view2, "p1");
            int i = R.id.continue_button;
            TextView textView = (TextView) view2.findViewById(R.id.continue_button);
            if (textView != null) {
                i = R.id.premium_upsell_close;
                ImageView imageView = (ImageView) view2.findViewById(R.id.premium_upsell_close);
                if (imageView != null) {
                    i = R.id.premium_upsell_description;
                    TextView textView2 = (TextView) view2.findViewById(R.id.premium_upsell_description);
                    if (textView2 != null) {
                        i = R.id.premium_upsell_server_perk;
                        TextView textView3 = (TextView) view2.findViewById(R.id.premium_upsell_server_perk);
                        if (textView3 != null) {
                            i = R.id.upgrade_button;
                            MaterialButton materialButton = (MaterialButton) view2.findViewById(R.id.upgrade_button);
                            if (materialButton != null) {
                                return new GuildBoostUpgradeDialogBinding((RelativeLayout) view2, textView, imageView, textView2, textView3, materialButton);
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    public UpgradeGuildBoostDialog() {
        super(R.layout.guild_boost_upgrade_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, c.j, null, 2, null);
    }

    public final GuildBoostUpgradeDialogBinding g() {
        return (GuildBoostUpgradeDialogBinding) this.binding.getValue((Fragment) this, j[0]);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialogRequireDialog = requireDialog();
        Intrinsics3.checkNotNullExpressionValue(dialogRequireDialog, "requireDialog()");
        Window window = dialogRequireDialog.getWindow();
        if (window != null) {
            window.setLayout(-1, -2);
        }
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        if (this.onContinueClickListener == null || this.onUpgradeClickListener == null) {
            dismiss();
        }
        requireDialog().setCanceledOnTouchOutside(true);
        TextView textView = g().d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.premiumUpsellDescription");
        FormatUtils.n(textView, R.string.premium_upsell_feature_pretext, new Object[]{this.upgradePrice}, null, 4);
        TextView textView2 = g().e;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.premiumUpsellServerPerk");
        Context contextRequireContext = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        FormatUtils.n(textView2, R.string.premium_upsell_feature_free_guild_subscription, new Object[]{StringResourceUtils.getI18nPluralString(contextRequireContext, R.plurals.premium_upsell_feature_free_guild_subscription_numFreeGuildSubscriptions, 2, 2)}, null, 4);
        TextView textView3 = g().f213b;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.continueButton");
        textView3.setVisibility(this.hasBoostPlan ^ true ? 0 : 8);
        g().f213b.setOnClickListener(new a(0, this));
        g().f.setOnClickListener(new a(1, this));
        g().c.setOnClickListener(new a(2, this));
    }
}
