package com.discord.widgets.hubs;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetHubDomainsBinding;
import com.discord.stores.utilities.RestCallState5;
import com.discord.stores.utilities.RestCallState6;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import com.google.android.material.button.MaterialButton;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p018d.AppViewModelDelegates2;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;
import p658rx.Observable;
import p658rx.functions.Action2;

/* compiled from: WidgetHubDomains.kt */
/* loaded from: classes2.dex */
public final class WidgetHubDomains extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetHubDomains.class, "binding", "getBinding()Lcom/discord/databinding/WidgetHubDomainsBinding;", 0)};
    private final SimpleRecyclerAdapter<WidgetHubDomains2, WidgetHubDomains4> adapter;

    /* renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetHubDomains.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubDomains$onViewBound$1 */
    public static final class C90291<T1, T2> implements Action2<MenuItem, Context> {
        public C90291() {
        }

        @Override // p658rx.functions.Action2
        public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
            call2(menuItem, context);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(MenuItem menuItem, Context context) {
            Intrinsics3.checkNotNullExpressionValue(menuItem, "item");
            if (menuItem.getItemId() == C5419R.id.search) {
                AppScreen2 appScreen2 = AppScreen2.f524g;
                FragmentManager parentFragmentManager = WidgetHubDomains.this.getParentFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(context, "context");
                AppScreen2.m158g(appScreen2, parentFragmentManager, context, WidgetHubDomainSearch.class, 0, true, null, null, 104);
            }
        }
    }

    /* compiled from: WidgetHubDomains.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubDomains$onViewBoundOrOnResume$1 */
    public static final class C90301 extends Lambda implements Function1<WidgetHubDomainsViewModel2, Unit> {
        public C90301() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetHubDomainsViewModel2 widgetHubDomainsViewModel2) {
            invoke2(widgetHubDomainsViewModel2);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetHubDomainsViewModel2 widgetHubDomainsViewModel2) {
            WidgetHubDomains widgetHubDomains = WidgetHubDomains.this;
            Intrinsics3.checkNotNullExpressionValue(widgetHubDomainsViewModel2, "viewState");
            WidgetHubDomains.access$updateView(widgetHubDomains, widgetHubDomainsViewModel2);
        }
    }

    /* compiled from: WidgetHubDomains.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubDomains$updateView$1 */
    public static final class C90311 extends Lambda implements Function1<RestCallState6<? extends Object>, Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ WidgetHubDomainsViewModel2 $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C90311(Context context, WidgetHubDomainsViewModel2 widgetHubDomainsViewModel2) {
            super(1);
            this.$context = context;
            this.$state = widgetHubDomainsViewModel2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState6<? extends Object> restCallState6) {
            invoke2(restCallState6);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState6<? extends Object> restCallState6) {
            Intrinsics3.checkNotNullParameter(restCallState6, "it");
            AppScreen2.m158g(AppScreen2.f524g, WidgetHubDomains.this.getParentFragmentManager(), this.$context, WidgetHubAuthentication.class, 0, true, null, new WidgetHubAuthenticationlViewModel2(WidgetHubDomains.this.getArgs().getEmail(), this.$state.getSelectedGuildId()), 40);
            WidgetHubDomains.this.getViewModel().reset();
        }
    }

    public WidgetHubDomains() {
        super(C5419R.layout.widget_hub_domains);
        this.args = LazyJVM.lazy(new WidgetHubDomains$$special$$inlined$args$1(this, "intent_args_key"));
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetHubDomains7.INSTANCE, null, 2, null);
        this.adapter = new SimpleRecyclerAdapter<>(null, new WidgetHubDomains6(this), 1, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetHubDomainsViewModel.class), new C9027x7a97847d(this), new AppViewModelDelegates2(WidgetHubDomains9.INSTANCE));
    }

    public static final /* synthetic */ void access$updateView(WidgetHubDomains widgetHubDomains, WidgetHubDomainsViewModel2 widgetHubDomainsViewModel2) {
        widgetHubDomains.updateView(widgetHubDomainsViewModel2);
    }

    private final void updateView(WidgetHubDomainsViewModel2 state) {
        Context context = getContext();
        if (context != null) {
            Intrinsics3.checkNotNullExpressionValue(context, "context ?: return");
            RestCallState5.handleResponse$default(state.getVerifyEmailAsync(), context, null, null, new C90311(context, state), 6, null);
        }
    }

    public final SimpleRecyclerAdapter<WidgetHubDomains2, WidgetHubDomains4> getAdapter() {
        return this.adapter;
    }

    public final WidgetHubDomains3 getArgs() {
        return (WidgetHubDomains3) this.args.getValue();
    }

    public final WidgetHubDomainsBinding getBinding() {
        return (WidgetHubDomainsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public final WidgetHubDomainsViewModel getViewModel() {
        return (WidgetHubDomainsViewModel) this.viewModel.getValue();
    }

    public final void onServerClickListener(WidgetHubDomains2 guildInfo) {
        Intrinsics3.checkNotNullParameter(guildInfo, "guildInfo");
        getViewModel().onGuildClicked(guildInfo.getId(), getArgs().getEmail());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        RecyclerView recyclerView = getBinding().f17171b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        recyclerView.setAdapter(this.adapter);
        this.adapter.setData(getArgs().getGuildInfos());
        AppFragment.setActionBarOptionsMenu$default(this, C5419R.menu.menu_search, new C90291(), null, 4, null);
        MaterialButton materialButton = getBinding().f17172c;
        Context context = materialButton.getContext();
        if (context != null) {
            materialButton.setText(FormatUtils.m216h(context, C5419R.string.hub_email_connection_guild_select_subheader, new Object[0], null, 4));
            materialButton.setOnClickListener(new WidgetHubDomains8(context, this));
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<WidgetHubDomainsViewModel2> observableM11112r = getViewModel().observeViewState().m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11112r, this, null, 2, null), WidgetHubDomains.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C90301(), 62, (Object) null);
    }
}
