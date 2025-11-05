package b.a.a.a;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.a.a.k;
import b.a.d.g0;
import b.a.d.i0;
import b.a.i.u;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.app.AppViewFlipper;
import com.discord.utilities.premium.GuildBoostUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.LoadingButton;
import com.google.android.material.button.MaterialButton;
import d0.z.d.a0;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: GuildBoostUncancelDialog.kt */
/* loaded from: classes.dex */
public final class a extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {b.d.b.a.a.d0(a.class, "binding", "getBinding()Lcom/discord/databinding/GuildBoostUncancelDialogBinding;", 0)};

    /* renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* renamed from: m, reason: from kotlin metadata */
    public final Lazy viewModel;

    /* renamed from: n, reason: from kotlin metadata */
    public final Lazy slotId;

    /* compiled from: java-style lambda group */
    /* renamed from: b.a.a.a.a$a, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC0008a implements View.OnClickListener {
        public final /* synthetic */ int j;
        public final /* synthetic */ Object k;

        public ViewOnClickListenerC0008a(int i, Object obj) {
            this.j = i;
            this.k = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.j;
            if (i == 0) {
                k kVar = (k) ((a) this.k).viewModel.getValue();
                k.c viewState = kVar.getViewState();
                if (m.areEqual(viewState, k.c.C0013c.a)) {
                    return;
                }
                if ((viewState instanceof k.c.b) || (viewState instanceof k.c.a)) {
                    kVar.updateViewState(new k.c.a(null, 1));
                    return;
                }
                return;
            }
            if (i != 1) {
                throw null;
            }
            k kVar2 = (k) ((a) this.k).viewModel.getValue();
            k.c viewState2 = kVar2.getViewState();
            if (m.areEqual(viewState2, k.c.C0013c.a)) {
                return;
            }
            if (!(viewState2 instanceof k.c.b)) {
                if ((viewState2 instanceof k.c.d) || (viewState2 instanceof k.c.a)) {
                    kVar2.updateViewState(new k.c.a(null, 1));
                    return;
                }
                return;
            }
            k.c viewState3 = kVar2.getViewState();
            Objects.requireNonNull(viewState3, "null cannot be cast to non-null type com.discord.dialogs.guildboost.GuildBoostUncancelViewModel.ViewState.Loaded");
            if (((k.c.b) viewState3).f43b) {
                return;
            }
            k.c viewState4 = kVar2.getViewState();
            if (!(viewState4 instanceof k.c.b)) {
                viewState4 = null;
            }
            k.c.b bVar = (k.c.b) viewState4;
            if (bVar != null) {
                kVar2.updateViewState(k.c.b.a(bVar, null, true, false, 5));
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(GuildBoostUtils.INSTANCE.uncancelGuildBoostSlot(kVar2.n, kVar2.k, bVar.a, kVar2.m), kVar2, null, 2, null), k.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new l(kVar2, bVar), 62, (Object) null);
            }
        }
    }

    /* compiled from: GuildBoostUncancelDialog.kt */
    /* renamed from: b.a.a.a.a$b, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: GuildBoostUncancelDialog.kt */
    public static final /* synthetic */ class c extends d0.z.d.k implements Function1<View, u> {
        public static final c j = new c();

        public c() {
            super(1, u.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/GuildBoostUncancelDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public u invoke(View view) {
            View view2 = view;
            m.checkNotNullParameter(view2, "p1");
            int i = R.id.guild_boost_uncancel_body;
            TextView textView = (TextView) view2.findViewById(R.id.guild_boost_uncancel_body);
            if (textView != null) {
                i = R.id.guild_boost_uncancel_confirm;
                LoadingButton loadingButton = (LoadingButton) view2.findViewById(R.id.guild_boost_uncancel_confirm);
                if (loadingButton != null) {
                    i = R.id.guild_boost_uncancel_error;
                    TextView textView2 = (TextView) view2.findViewById(R.id.guild_boost_uncancel_error);
                    if (textView2 != null) {
                        i = R.id.guild_boost_uncancel_flipper;
                        AppViewFlipper appViewFlipper = (AppViewFlipper) view2.findViewById(R.id.guild_boost_uncancel_flipper);
                        if (appViewFlipper != null) {
                            i = R.id.guild_boost_uncancel_header;
                            TextView textView3 = (TextView) view2.findViewById(R.id.guild_boost_uncancel_header);
                            if (textView3 != null) {
                                i = R.id.guild_boost_uncancel_image;
                                ImageView imageView = (ImageView) view2.findViewById(R.id.guild_boost_uncancel_image);
                                if (imageView != null) {
                                    i = R.id.guild_boost_uncancel_nevermind;
                                    MaterialButton materialButton = (MaterialButton) view2.findViewById(R.id.guild_boost_uncancel_nevermind);
                                    if (materialButton != null) {
                                        i = R.id.notice_header_container;
                                        LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.notice_header_container);
                                        if (linearLayout != null) {
                                            return new u((LinearLayout) view2, textView, loadingButton, textView2, appViewFlipper, textView3, imageView, materialButton, linearLayout);
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

    /* compiled from: GuildBoostUncancelDialog.kt */
    public static final class d extends o implements Function1<k.c, Unit> {
        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(k.c cVar) {
            k.c cVar2 = cVar;
            a aVar = a.this;
            m.checkNotNullExpressionValue(cVar2, "it");
            KProperty[] kPropertyArr = a.j;
            AppViewFlipper appViewFlipper = aVar.g().e;
            m.checkNotNullExpressionValue(appViewFlipper, "binding.guildBoostUncancelFlipper");
            appViewFlipper.setDisplayedChild(!(cVar2 instanceof k.c.C0013c) ? 1 : 0);
            TextView textView = aVar.g().d;
            m.checkNotNullExpressionValue(textView, "binding.guildBoostUncancelError");
            boolean z2 = cVar2 instanceof k.c.b;
            textView.setVisibility(z2 && ((k.c.b) cVar2).c ? 0 : 8);
            MaterialButton materialButton = aVar.g().h;
            m.checkNotNullExpressionValue(materialButton, "binding.guildBoostUncancelNevermind");
            materialButton.setVisibility(z2 ? 0 : 8);
            MaterialButton materialButton2 = aVar.g().h;
            m.checkNotNullExpressionValue(materialButton2, "binding.guildBoostUncancelNevermind");
            ViewExtensions.setEnabledAndAlpha$default(materialButton2, z2 && !((k.c.b) cVar2).f43b, 0.0f, 2, null);
            aVar.g().c.setIsLoading(z2 && ((k.c.b) cVar2).f43b);
            k.c.C0013c c0013c = k.c.C0013c.a;
            aVar.setCancelable((m.areEqual(cVar2, c0013c) ^ true) && z2 && !((k.c.b) cVar2).f43b);
            if (!m.areEqual(cVar2, c0013c)) {
                if (z2) {
                    TextView textView2 = aVar.g().f;
                    m.checkNotNullExpressionValue(textView2, "binding.guildBoostUncancelHeader");
                    textView2.setText(aVar.getString(R.string.premium_guild_subscription_inventory_uncancel_title_mobile));
                    TextView textView3 = aVar.g().f207b;
                    m.checkNotNullExpressionValue(textView3, "binding.guildBoostUncancelBody");
                    textView3.setText(aVar.getString(R.string.premium_guild_subscription_inventory_uncancel_description));
                } else if (m.areEqual(cVar2, k.c.d.a)) {
                    TextView textView4 = aVar.g().f;
                    m.checkNotNullExpressionValue(textView4, "binding.guildBoostUncancelHeader");
                    textView4.setText(aVar.getString(R.string.premium_guild_subscription_inventory_uncancel_confirm_title));
                    ImageView imageView = aVar.g().g;
                    m.checkNotNullExpressionValue(imageView, "binding.guildBoostUncancelImage");
                    imageView.setVisibility(0);
                    TextView textView5 = aVar.g().f207b;
                    m.checkNotNullExpressionValue(textView5, "binding.guildBoostUncancelBody");
                    textView5.setText(aVar.getString(R.string.premium_guild_subscription_inventory_uncancel_confirm_description));
                    aVar.g().c.setText(aVar.getString(R.string.okay));
                } else if (cVar2 instanceof k.c.a) {
                    Integer num = ((k.c.a) cVar2).a;
                    if (num != null) {
                        b.a.d.m.i(aVar, num.intValue(), 0, 4);
                    }
                    aVar.dismiss();
                }
            }
            return Unit.a;
        }
    }

    /* compiled from: GuildBoostUncancelDialog.kt */
    public static final class e extends o implements Function0<Long> {
        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Long invoke() {
            Bundle arguments = a.this.getArguments();
            Long lValueOf = arguments != null ? Long.valueOf(arguments.getLong("extra_slot_id")) : null;
            Objects.requireNonNull(lValueOf, "null cannot be cast to non-null type com.discord.primitives.GuildBoostSlotId /* = kotlin.Long */");
            return Long.valueOf(lValueOf.longValue());
        }
    }

    /* compiled from: GuildBoostUncancelDialog.kt */
    public static final class f extends o implements Function0<k> {
        public f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public k invoke() {
            return new k(((Number) a.this.slotId.getValue()).longValue(), null, null, null, null, 30);
        }
    }

    public a() {
        super(R.layout.guild_boost_uncancel_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, c.j, null, 2, null);
        f fVar = new f();
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(k.class), new defpackage.k(3, g0Var), new i0(fVar));
        this.slotId = d0.g.lazy(new e());
    }

    public final u g() {
        return (u) this.binding.getValue((Fragment) this, j[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        g().h.setOnClickListener(new ViewOnClickListenerC0008a(0, this));
        g().c.setOnClickListener(new ViewOnClickListenerC0008a(1, this));
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<k.c> observableR = ((k) this.viewModel.getValue()).observeViewState().r();
        m.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), a.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new d(), 62, (Object) null);
    }
}
