package p007b.p008a.p009a.p012b;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.button.MaterialButton;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p025i.GuildBoostUpgradeDialogBinding;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: UpgradeGuildBoostDialog.kt */
/* renamed from: b.a.a.b.a, reason: use source file name */
/* loaded from: classes.dex */
public final class UpgradeGuildBoostDialog extends AppDialog {

    /* renamed from: j */
    public static final /* synthetic */ KProperty[] f242j = {outline.m846d0(UpgradeGuildBoostDialog.class, "binding", "getBinding()Lcom/discord/databinding/GuildBoostUpgradeDialogBinding;", 0)};

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

        /* renamed from: j */
        public final /* synthetic */ int f249j;

        /* renamed from: k */
        public final /* synthetic */ Object f250k;

        public a(int i, Object obj) {
            this.f249j = i;
            this.f250k = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.f249j;
            if (i == 0) {
                Function0<Unit> function0 = ((UpgradeGuildBoostDialog) this.f250k).onContinueClickListener;
                if (function0 != null) {
                    function0.invoke();
                }
                ((UpgradeGuildBoostDialog) this.f250k).dismiss();
                return;
            }
            if (i != 1) {
                if (i != 2) {
                    throw null;
                }
                ((UpgradeGuildBoostDialog) this.f250k).dismiss();
            } else {
                Function0<Unit> function02 = ((UpgradeGuildBoostDialog) this.f250k).onUpgradeClickListener;
                if (function02 != null) {
                    function02.invoke();
                }
                ((UpgradeGuildBoostDialog) this.f250k).dismiss();
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

        /* renamed from: j */
        public static final c f251j = new c();

        public c() {
            super(1, GuildBoostUpgradeDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/GuildBoostUpgradeDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public GuildBoostUpgradeDialogBinding invoke(View view) {
            View view2 = view;
            Intrinsics3.checkNotNullParameter(view2, "p1");
            int i = C5419R.id.continue_button;
            TextView textView = (TextView) view2.findViewById(C5419R.id.continue_button);
            if (textView != null) {
                i = C5419R.id.premium_upsell_close;
                ImageView imageView = (ImageView) view2.findViewById(C5419R.id.premium_upsell_close);
                if (imageView != null) {
                    i = C5419R.id.premium_upsell_description;
                    TextView textView2 = (TextView) view2.findViewById(C5419R.id.premium_upsell_description);
                    if (textView2 != null) {
                        i = C5419R.id.premium_upsell_server_perk;
                        TextView textView3 = (TextView) view2.findViewById(C5419R.id.premium_upsell_server_perk);
                        if (textView3 != null) {
                            i = C5419R.id.upgrade_button;
                            MaterialButton materialButton = (MaterialButton) view2.findViewById(C5419R.id.upgrade_button);
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
        super(C5419R.layout.guild_boost_upgrade_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, c.f251j, null, 2, null);
    }

    /* renamed from: g */
    public final GuildBoostUpgradeDialogBinding m108g() {
        return (GuildBoostUpgradeDialogBinding) this.binding.getValue((Fragment) this, f242j[0]);
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
        TextView textView = m108g().f1303d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.premiumUpsellDescription");
        FormatUtils.m222n(textView, C5419R.string.premium_upsell_feature_pretext, new Object[]{this.upgradePrice}, null, 4);
        TextView textView2 = m108g().f1304e;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.premiumUpsellServerPerk");
        Context contextRequireContext = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        FormatUtils.m222n(textView2, C5419R.string.premium_upsell_feature_free_guild_subscription, new Object[]{StringResourceUtils.getI18nPluralString(contextRequireContext, C5419R.plurals.premium_upsell_feature_free_guild_subscription_numFreeGuildSubscriptions, 2, 2)}, null, 4);
        TextView textView3 = m108g().f1301b;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.continueButton");
        textView3.setVisibility(this.hasBoostPlan ^ true ? 0 : 8);
        m108g().f1301b.setOnClickListener(new a(0, this));
        m108g().f1305f.setOnClickListener(new a(1, this));
        m108g().f1302c.setOnClickListener(new a(2, this));
    }
}
