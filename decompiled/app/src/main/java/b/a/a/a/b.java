package b.a.a.a;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.a.a.f;
import b.a.d.g0;
import b.a.d.i0;
import b.a.i.t;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.app.AppViewFlipper;
import com.discord.models.domain.ModelSubscription;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.premium.GuildBoostUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.LoadingButton;
import com.google.android.material.button.MaterialButton;
import d0.z.d.a0;
import d0.z.d.m;
import d0.z.d.o;
import java.text.DateFormat;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: GuildBoostCancelDialog.kt */
/* loaded from: classes.dex */
public final class b extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {b.d.b.a.a.d0(b.class, "binding", "getBinding()Lcom/discord/databinding/GuildBoostCancelDialogBinding;", 0)};

    /* renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* renamed from: m, reason: from kotlin metadata */
    public final Lazy viewModel;

    /* renamed from: n, reason: from kotlin metadata */
    public final Lazy slotId;

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
                b.a.a.a.f fVar = (b.a.a.a.f) ((b) this.k).viewModel.getValue();
                f.c viewState = fVar.getViewState();
                if ((viewState instanceof f.c.C0012f) || (viewState instanceof f.c.a)) {
                    return;
                }
                if ((viewState instanceof f.c.e) || (viewState instanceof f.c.d) || (viewState instanceof f.c.b)) {
                    fVar.updateViewState(new f.c.C0011c(null, 1));
                    return;
                }
                return;
            }
            if (i != 1) {
                throw null;
            }
            b.a.a.a.f fVar2 = (b.a.a.a.f) ((b) this.k).viewModel.getValue();
            f.c viewState2 = fVar2.getViewState();
            if ((viewState2 instanceof f.c.C0012f) || (viewState2 instanceof f.c.a)) {
                return;
            }
            if (!(viewState2 instanceof f.c.e) && !(viewState2 instanceof f.c.d)) {
                if (viewState2 instanceof f.c.b) {
                    fVar2.updateViewState(new f.c.C0011c(null, 1));
                }
            } else {
                f.c viewState3 = fVar2.getViewState();
                ModelSubscription modelSubscription = viewState3 instanceof f.c.e ? ((f.c.e) viewState3).f : viewState3 instanceof f.c.d ? ((f.c.d) viewState3).f : null;
                if (modelSubscription != null) {
                    fVar2.updateViewState(new f.c.a(modelSubscription));
                    ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(GuildBoostUtils.INSTANCE.cancelGuildBoostSlot(fVar2.n, fVar2.k, modelSubscription, fVar2.l), fVar2, null, 2, null), b.a.a.a.f.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new g(fVar2, modelSubscription), 62, (Object) null);
                }
            }
        }
    }

    /* compiled from: GuildBoostCancelDialog.kt */
    /* renamed from: b.a.a.a.b$b, reason: collision with other inner class name and from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: GuildBoostCancelDialog.kt */
    public static final /* synthetic */ class c extends d0.z.d.k implements Function1<View, t> {
        public static final c j = new c();

        public c() {
            super(1, t.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/GuildBoostCancelDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public t invoke(View view) {
            View view2 = view;
            m.checkNotNullParameter(view2, "p1");
            int i = R.id.active_subscription_progress;
            ProgressBar progressBar = (ProgressBar) view2.findViewById(R.id.active_subscription_progress);
            if (progressBar != null) {
                i = R.id.guild_boost_cancel_body;
                TextView textView = (TextView) view2.findViewById(R.id.guild_boost_cancel_body);
                if (textView != null) {
                    i = R.id.guild_boost_cancel_confirm;
                    LoadingButton loadingButton = (LoadingButton) view2.findViewById(R.id.guild_boost_cancel_confirm);
                    if (loadingButton != null) {
                        i = R.id.guild_boost_cancel_error;
                        TextView textView2 = (TextView) view2.findViewById(R.id.guild_boost_cancel_error);
                        if (textView2 != null) {
                            i = R.id.guild_boost_cancel_flipper;
                            AppViewFlipper appViewFlipper = (AppViewFlipper) view2.findViewById(R.id.guild_boost_cancel_flipper);
                            if (appViewFlipper != null) {
                                i = R.id.guild_boost_cancel_header;
                                TextView textView3 = (TextView) view2.findViewById(R.id.guild_boost_cancel_header);
                                if (textView3 != null) {
                                    i = R.id.guild_boost_cancel_nevermind;
                                    MaterialButton materialButton = (MaterialButton) view2.findViewById(R.id.guild_boost_cancel_nevermind);
                                    if (materialButton != null) {
                                        i = R.id.notice_header_container;
                                        LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.notice_header_container);
                                        if (linearLayout != null) {
                                            return new t((LinearLayout) view2, progressBar, textView, loadingButton, textView2, appViewFlipper, textView3, materialButton, linearLayout);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* compiled from: GuildBoostCancelDialog.kt */
    public static final class d extends o implements Function1<f.c, Unit> {
        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(f.c cVar) {
            f.c cVar2 = cVar;
            b bVar = b.this;
            m.checkNotNullExpressionValue(cVar2, "it");
            KProperty[] kPropertyArr = b.j;
            TextView textView = bVar.g().d;
            m.checkNotNullExpressionValue(textView, "binding.guildBoostCancelError");
            textView.setVisibility(cVar2.a ? 0 : 8);
            MaterialButton materialButton = bVar.g().g;
            m.checkNotNullExpressionValue(materialButton, "binding.guildBoostCancelNevermind");
            materialButton.setVisibility(cVar2.f42b ? 0 : 8);
            MaterialButton materialButton2 = bVar.g().g;
            m.checkNotNullExpressionValue(materialButton2, "binding.guildBoostCancelNevermind");
            ViewExtensions.setEnabledAndAlpha$default(materialButton2, cVar2.c, 0.0f, 2, null);
            bVar.setCancelable(cVar2.e);
            bVar.g().c.setIsLoading(cVar2.d);
            AppViewFlipper appViewFlipper = bVar.g().e;
            m.checkNotNullExpressionValue(appViewFlipper, "binding.guildBoostCancelFlipper");
            appViewFlipper.setDisplayedChild(!(cVar2 instanceof f.c.C0012f) ? 1 : 0);
            if (cVar2 instanceof f.c.e) {
                TimeUtils timeUtils = TimeUtils.INSTANCE;
                f.c.e eVar = (f.c.e) cVar2;
                String currentPeriodEnd = eVar.f.getCurrentPeriodEnd();
                Context contextRequireContext = bVar.requireContext();
                m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                String strRenderUtcDate$default = TimeUtils.renderUtcDate$default(timeUtils, currentPeriodEnd, contextRequireContext, (String) null, (DateFormat) null, 0, 28, (Object) null);
                if (eVar.g) {
                    TextView textView2 = bVar.g().f201b;
                    m.checkNotNullExpressionValue(textView2, "binding.guildBoostCancelBody");
                    b.a.k.b.n(textView2, R.string.premium_guild_subscription_cancel_body_inventory, new Object[]{strRenderUtcDate$default}, null, 4);
                } else {
                    TextView textView3 = bVar.g().f201b;
                    m.checkNotNullExpressionValue(textView3, "binding.guildBoostCancelBody");
                    b.a.k.b.n(textView3, R.string.premium_guild_subscription_cancel_body_guild, new Object[]{strRenderUtcDate$default}, null, 4);
                }
                bVar.g().c.setBackgroundColor(ColorCompat.getColor(bVar, R.color.status_red_500));
            } else if (cVar2 instanceof f.c.b) {
                TextView textView4 = bVar.g().f;
                m.checkNotNullExpressionValue(textView4, "binding.guildBoostCancelHeader");
                textView4.setText(bVar.getString(R.string.premium_guild_subscription_cancel_title_pending_cancellation));
                TextView textView5 = bVar.g().f201b;
                m.checkNotNullExpressionValue(textView5, "binding.guildBoostCancelBody");
                TimeUtils timeUtils2 = TimeUtils.INSTANCE;
                String currentPeriodEnd2 = ((f.c.b) cVar2).f.getCurrentPeriodEnd();
                Context contextRequireContext2 = bVar.requireContext();
                m.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
                b.a.k.b.n(textView5, R.string.premium_guild_subscription_confirm_body, new Object[]{TimeUtils.renderUtcDate$default(timeUtils2, currentPeriodEnd2, contextRequireContext2, (String) null, (DateFormat) null, 0, 28, (Object) null)}, null, 4);
                bVar.g().c.setText(bVar.getString(R.string.okay));
                bVar.g().c.setBackgroundColor(ColorCompat.getThemedColor(bVar, R.attr.color_brand_500));
            } else if (cVar2 instanceof f.c.C0011c) {
                Integer num = ((f.c.C0011c) cVar2).f;
                if (num != null) {
                    b.a.d.m.g(bVar.requireContext(), num.intValue(), 0, null, 12);
                }
                bVar.dismiss();
            }
            return Unit.a;
        }
    }

    /* compiled from: GuildBoostCancelDialog.kt */
    public static final class e extends o implements Function0<Long> {
        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Long invoke() {
            Bundle arguments = b.this.getArguments();
            Long lValueOf = arguments != null ? Long.valueOf(arguments.getLong("extra_slot_id")) : null;
            Objects.requireNonNull(lValueOf, "null cannot be cast to non-null type com.discord.primitives.GuildBoostSlotId /* = kotlin.Long */");
            return Long.valueOf(lValueOf.longValue());
        }
    }

    /* compiled from: GuildBoostCancelDialog.kt */
    public static final class f extends o implements Function0<b.a.a.a.f> {
        public f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public b.a.a.a.f invoke() {
            return new b.a.a.a.f(((Number) b.this.slotId.getValue()).longValue(), null, null, null, null, 30);
        }
    }

    public b() {
        super(R.layout.guild_boost_cancel_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, c.j, null, 2, null);
        f fVar = new f();
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(b.a.a.a.f.class), new defpackage.k(2, g0Var), new i0(fVar));
        this.slotId = d0.g.lazy(new e());
    }

    public final t g() {
        return (t) this.binding.getValue((Fragment) this, j[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        g().g.setOnClickListener(new a(0, this));
        g().c.setOnClickListener(new a(1, this));
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<f.c> observableR = ((b.a.a.a.f) this.viewModel.getValue()).observeViewState().r();
        m.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), b.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new d(), 62, (Object) null);
    }
}
