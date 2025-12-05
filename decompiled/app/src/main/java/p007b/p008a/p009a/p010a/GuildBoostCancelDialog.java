package p007b.p008a.p009a.p010a;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.app.AppViewFlipper;
import com.discord.models.domain.ModelSubscription;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.premium.GuildBoostUtils;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.LoadingButton;
import com.google.android.material.button.MaterialButton;
import java.text.DateFormat;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p000.C12788k;
import p007b.p008a.p009a.p010a.GuildBoostCancelViewModel3;
import p007b.p008a.p018d.AppToast;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p008a.p025i.GuildBoostCancelDialogBinding;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;
import p658rx.Observable;

/* compiled from: GuildBoostCancelDialog.kt */
/* renamed from: b.a.a.a.b, reason: use source file name */
/* loaded from: classes.dex */
public final class GuildBoostCancelDialog extends AppDialog {

    /* renamed from: j */
    public static final /* synthetic */ KProperty[] f175j = {outline.m846d0(GuildBoostCancelDialog.class, "binding", "getBinding()Lcom/discord/databinding/GuildBoostCancelDialogBinding;", 0)};

    /* renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* renamed from: m, reason: from kotlin metadata */
    public final Lazy viewModel;

    /* renamed from: n, reason: from kotlin metadata */
    public final Lazy slotId;

    /* compiled from: java-style lambda group */
    /* renamed from: b.a.a.a.b$a */
    /* loaded from: classes2.dex */
    public static final class a implements View.OnClickListener {

        /* renamed from: j */
        public final /* synthetic */ int f180j;

        /* renamed from: k */
        public final /* synthetic */ Object f181k;

        public a(int i, Object obj) {
            this.f180j = i;
            this.f181k = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.f180j;
            if (i == 0) {
                GuildBoostCancelViewModel3 guildBoostCancelViewModel3 = (GuildBoostCancelViewModel3) ((GuildBoostCancelDialog) this.f181k).viewModel.getValue();
                GuildBoostCancelViewModel3.c viewState = guildBoostCancelViewModel3.getViewState();
                if ((viewState instanceof GuildBoostCancelViewModel3.c.f) || (viewState instanceof GuildBoostCancelViewModel3.c.a)) {
                    return;
                }
                if ((viewState instanceof GuildBoostCancelViewModel3.c.e) || (viewState instanceof GuildBoostCancelViewModel3.c.d) || (viewState instanceof GuildBoostCancelViewModel3.c.b)) {
                    guildBoostCancelViewModel3.updateViewState(new GuildBoostCancelViewModel3.c.C13204c(null, 1));
                    return;
                }
                return;
            }
            if (i != 1) {
                throw null;
            }
            GuildBoostCancelViewModel3 guildBoostCancelViewModel32 = (GuildBoostCancelViewModel3) ((GuildBoostCancelDialog) this.f181k).viewModel.getValue();
            GuildBoostCancelViewModel3.c viewState2 = guildBoostCancelViewModel32.getViewState();
            if ((viewState2 instanceof GuildBoostCancelViewModel3.c.f) || (viewState2 instanceof GuildBoostCancelViewModel3.c.a)) {
                return;
            }
            if (!(viewState2 instanceof GuildBoostCancelViewModel3.c.e) && !(viewState2 instanceof GuildBoostCancelViewModel3.c.d)) {
                if (viewState2 instanceof GuildBoostCancelViewModel3.c.b) {
                    guildBoostCancelViewModel32.updateViewState(new GuildBoostCancelViewModel3.c.C13204c(null, 1));
                }
            } else {
                GuildBoostCancelViewModel3.c viewState3 = guildBoostCancelViewModel32.getViewState();
                ModelSubscription modelSubscription = viewState3 instanceof GuildBoostCancelViewModel3.c.e ? ((GuildBoostCancelViewModel3.c.e) viewState3).f207f : viewState3 instanceof GuildBoostCancelViewModel3.c.d ? ((GuildBoostCancelViewModel3.c.d) viewState3).f206f : null;
                if (modelSubscription != null) {
                    guildBoostCancelViewModel32.updateViewState(new GuildBoostCancelViewModel3.c.a(modelSubscription));
                    ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(GuildBoostUtils.INSTANCE.cancelGuildBoostSlot(guildBoostCancelViewModel32.f195n, guildBoostCancelViewModel32.f192k, modelSubscription, guildBoostCancelViewModel32.f193l), guildBoostCancelViewModel32, null, 2, null), GuildBoostCancelViewModel3.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new GuildBoostCancelViewModel4(guildBoostCancelViewModel32, modelSubscription), 62, (Object) null);
                }
            }
        }
    }

    /* compiled from: GuildBoostCancelDialog.kt */
    /* renamed from: b.a.a.a.b$b, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: GuildBoostCancelDialog.kt */
    /* renamed from: b.a.a.a.b$c */
    public static final /* synthetic */ class c extends FunctionReferenceImpl implements Function1<View, GuildBoostCancelDialogBinding> {

        /* renamed from: j */
        public static final c f182j = new c();

        public c() {
            super(1, GuildBoostCancelDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/GuildBoostCancelDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public GuildBoostCancelDialogBinding invoke(View view) {
            View view2 = view;
            Intrinsics3.checkNotNullParameter(view2, "p1");
            int i = C5419R.id.active_subscription_progress;
            ProgressBar progressBar = (ProgressBar) view2.findViewById(C5419R.id.active_subscription_progress);
            if (progressBar != null) {
                i = C5419R.id.guild_boost_cancel_body;
                TextView textView = (TextView) view2.findViewById(C5419R.id.guild_boost_cancel_body);
                if (textView != null) {
                    i = C5419R.id.guild_boost_cancel_confirm;
                    LoadingButton loadingButton = (LoadingButton) view2.findViewById(C5419R.id.guild_boost_cancel_confirm);
                    if (loadingButton != null) {
                        i = C5419R.id.guild_boost_cancel_error;
                        TextView textView2 = (TextView) view2.findViewById(C5419R.id.guild_boost_cancel_error);
                        if (textView2 != null) {
                            i = C5419R.id.guild_boost_cancel_flipper;
                            AppViewFlipper appViewFlipper = (AppViewFlipper) view2.findViewById(C5419R.id.guild_boost_cancel_flipper);
                            if (appViewFlipper != null) {
                                i = C5419R.id.guild_boost_cancel_header;
                                TextView textView3 = (TextView) view2.findViewById(C5419R.id.guild_boost_cancel_header);
                                if (textView3 != null) {
                                    i = C5419R.id.guild_boost_cancel_nevermind;
                                    MaterialButton materialButton = (MaterialButton) view2.findViewById(C5419R.id.guild_boost_cancel_nevermind);
                                    if (materialButton != null) {
                                        i = C5419R.id.notice_header_container;
                                        LinearLayout linearLayout = (LinearLayout) view2.findViewById(C5419R.id.notice_header_container);
                                        if (linearLayout != null) {
                                            return new GuildBoostCancelDialogBinding((LinearLayout) view2, progressBar, textView, loadingButton, textView2, appViewFlipper, textView3, materialButton, linearLayout);
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
    /* renamed from: b.a.a.a.b$d */
    public static final class d extends Lambda implements Function1<GuildBoostCancelViewModel3.c, Unit> {
        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(GuildBoostCancelViewModel3.c cVar) {
            GuildBoostCancelViewModel3.c cVar2 = cVar;
            GuildBoostCancelDialog guildBoostCancelDialog = GuildBoostCancelDialog.this;
            Intrinsics3.checkNotNullExpressionValue(cVar2, "it");
            KProperty[] kPropertyArr = GuildBoostCancelDialog.f175j;
            TextView textView = guildBoostCancelDialog.m99g().f1234d;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildBoostCancelError");
            textView.setVisibility(cVar2.f198a ? 0 : 8);
            MaterialButton materialButton = guildBoostCancelDialog.m99g().f1237g;
            Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.guildBoostCancelNevermind");
            materialButton.setVisibility(cVar2.f199b ? 0 : 8);
            MaterialButton materialButton2 = guildBoostCancelDialog.m99g().f1237g;
            Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.guildBoostCancelNevermind");
            ViewExtensions.setEnabledAndAlpha$default(materialButton2, cVar2.f200c, 0.0f, 2, null);
            guildBoostCancelDialog.setCancelable(cVar2.f202e);
            guildBoostCancelDialog.m99g().f1233c.setIsLoading(cVar2.f201d);
            AppViewFlipper appViewFlipper = guildBoostCancelDialog.m99g().f1235e;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.guildBoostCancelFlipper");
            appViewFlipper.setDisplayedChild(!(cVar2 instanceof GuildBoostCancelViewModel3.c.f) ? 1 : 0);
            if (cVar2 instanceof GuildBoostCancelViewModel3.c.e) {
                TimeUtils timeUtils = TimeUtils.INSTANCE;
                GuildBoostCancelViewModel3.c.e eVar = (GuildBoostCancelViewModel3.c.e) cVar2;
                String currentPeriodEnd = eVar.f207f.getCurrentPeriodEnd();
                Context contextRequireContext = guildBoostCancelDialog.requireContext();
                Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                String strRenderUtcDate$default = TimeUtils.renderUtcDate$default(timeUtils, currentPeriodEnd, contextRequireContext, (String) null, (DateFormat) null, 0, 28, (Object) null);
                if (eVar.f208g) {
                    TextView textView2 = guildBoostCancelDialog.m99g().f1232b;
                    Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildBoostCancelBody");
                    FormatUtils.m222n(textView2, C5419R.string.premium_guild_subscription_cancel_body_inventory, new Object[]{strRenderUtcDate$default}, null, 4);
                } else {
                    TextView textView3 = guildBoostCancelDialog.m99g().f1232b;
                    Intrinsics3.checkNotNullExpressionValue(textView3, "binding.guildBoostCancelBody");
                    FormatUtils.m222n(textView3, C5419R.string.premium_guild_subscription_cancel_body_guild, new Object[]{strRenderUtcDate$default}, null, 4);
                }
                guildBoostCancelDialog.m99g().f1233c.setBackgroundColor(ColorCompat.getColor(guildBoostCancelDialog, C5419R.color.status_red_500));
            } else if (cVar2 instanceof GuildBoostCancelViewModel3.c.b) {
                TextView textView4 = guildBoostCancelDialog.m99g().f1236f;
                Intrinsics3.checkNotNullExpressionValue(textView4, "binding.guildBoostCancelHeader");
                textView4.setText(guildBoostCancelDialog.getString(C5419R.string.premium_guild_subscription_cancel_title_pending_cancellation));
                TextView textView5 = guildBoostCancelDialog.m99g().f1232b;
                Intrinsics3.checkNotNullExpressionValue(textView5, "binding.guildBoostCancelBody");
                TimeUtils timeUtils2 = TimeUtils.INSTANCE;
                String currentPeriodEnd2 = ((GuildBoostCancelViewModel3.c.b) cVar2).f204f.getCurrentPeriodEnd();
                Context contextRequireContext2 = guildBoostCancelDialog.requireContext();
                Intrinsics3.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
                FormatUtils.m222n(textView5, C5419R.string.premium_guild_subscription_confirm_body, new Object[]{TimeUtils.renderUtcDate$default(timeUtils2, currentPeriodEnd2, contextRequireContext2, (String) null, (DateFormat) null, 0, 28, (Object) null)}, null, 4);
                guildBoostCancelDialog.m99g().f1233c.setText(guildBoostCancelDialog.getString(C5419R.string.okay));
                guildBoostCancelDialog.m99g().f1233c.setBackgroundColor(ColorCompat.getThemedColor(guildBoostCancelDialog, C5419R.attr.color_brand_500));
            } else if (cVar2 instanceof GuildBoostCancelViewModel3.c.C13204c) {
                Integer num = ((GuildBoostCancelViewModel3.c.C13204c) cVar2).f205f;
                if (num != null) {
                    AppToast.m169g(guildBoostCancelDialog.requireContext(), num.intValue(), 0, null, 12);
                }
                guildBoostCancelDialog.dismiss();
            }
            return Unit.f27425a;
        }
    }

    /* compiled from: GuildBoostCancelDialog.kt */
    /* renamed from: b.a.a.a.b$e */
    public static final class e extends Lambda implements Function0<Long> {
        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Long invoke() {
            Bundle arguments = GuildBoostCancelDialog.this.getArguments();
            Long lValueOf = arguments != null ? Long.valueOf(arguments.getLong("extra_slot_id")) : null;
            Objects.requireNonNull(lValueOf, "null cannot be cast to non-null type com.discord.primitives.GuildBoostSlotId /* = kotlin.Long */");
            return Long.valueOf(lValueOf.longValue());
        }
    }

    /* compiled from: GuildBoostCancelDialog.kt */
    /* renamed from: b.a.a.a.b$f */
    public static final class f extends Lambda implements Function0<GuildBoostCancelViewModel3> {
        public f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public GuildBoostCancelViewModel3 invoke() {
            return new GuildBoostCancelViewModel3(((Number) GuildBoostCancelDialog.this.slotId.getValue()).longValue(), null, null, null, null, 30);
        }
    }

    public GuildBoostCancelDialog() {
        super(C5419R.layout.guild_boost_cancel_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, c.f182j, null, 2, null);
        f fVar = new f();
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildBoostCancelViewModel3.class), new C12788k(2, appViewModelDelegates3), new AppViewModelDelegates5(fVar));
        this.slotId = LazyJVM.lazy(new e());
    }

    /* renamed from: g */
    public final GuildBoostCancelDialogBinding m99g() {
        return (GuildBoostCancelDialogBinding) this.binding.getValue((Fragment) this, f175j[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        m99g().f1237g.setOnClickListener(new a(0, this));
        m99g().f1233c.setOnClickListener(new a(1, this));
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<GuildBoostCancelViewModel3.c> observableM11112r = ((GuildBoostCancelViewModel3) this.viewModel.getValue()).observeViewState().m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11112r, this, null, 2, null), GuildBoostCancelDialog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new d(), 62, (Object) null);
    }
}
