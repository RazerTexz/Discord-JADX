package com.discord.widgets.hubs;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetHubDomainSearchBinding;
import com.discord.i18n.RenderContext;
import com.discord.stores.utilities.RestCallState5;
import com.discord.stores.utilities.RestCallState6;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
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
import p507d0.p579g0.Strings4;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;
import p658rx.Observable;

/* JADX INFO: compiled from: WidgetHubDomainSearch.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubDomainSearch extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetHubDomainSearch.class, "binding", "getBinding()Lcom/discord/databinding/WidgetHubDomainSearchBinding;", 0)};
    private final SimpleRecyclerAdapter<WidgetHubDomains2, WidgetHubDomains4> adapter;

    /* JADX INFO: renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubDomainSearch$onViewBound$2 */
    /* JADX INFO: compiled from: WidgetHubDomainSearch.kt */
    public static final class ViewOnClickListenerC90202 implements View.OnClickListener {
        public ViewOnClickListenerC90202() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            FragmentActivity activity = WidgetHubDomainSearch.this.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
            WidgetHubDomainSearch widgetHubDomainSearch = WidgetHubDomainSearch.this;
            widgetHubDomainSearch.hideKeyboard(widgetHubDomainSearch.getView());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubDomainSearch$onViewBound$3 */
    /* JADX INFO: compiled from: WidgetHubDomainSearch.kt */
    public static final class ViewOnClickListenerC90213 implements View.OnClickListener {
        public ViewOnClickListenerC90213() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetHubDomainSearch.access$searchForGuild(WidgetHubDomainSearch.this);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubDomainSearch$onViewBound$4 */
    /* JADX INFO: compiled from: WidgetHubDomainSearch.kt */
    public static final class C90224 extends Lambda implements Function1<TextView, Unit> {
        public C90224() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
            invoke2(textView);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TextView textView) {
            Intrinsics3.checkNotNullParameter(textView, "it");
            WidgetHubDomainSearch.access$searchForGuild(WidgetHubDomainSearch.this);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubDomainSearch$onViewBound$5 */
    /* JADX INFO: compiled from: WidgetHubDomainSearch.kt */
    public static final class C90235 extends Lambda implements Function1<RenderContext, Unit> {

        /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubDomainSearch$onViewBound$5$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetHubDomainSearch.kt */
        public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics3.checkNotNullParameter(view, "it");
                AppScreen2 appScreen2 = AppScreen2.f524g;
                FragmentManager parentFragmentManager = WidgetHubDomainSearch.this.getParentFragmentManager();
                Context context = view.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "it.context");
                AppScreen2.m158g(appScreen2, parentFragmentManager, context, WidgetHubWaitlist.class, 0, true, null, new WidgetHubWaitlistViewModel2(WidgetHubDomainSearch.this.getArgs().getEmail()), 40);
            }
        }

        public C90235() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.m8423b("onJoinWaitlist", new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubDomainSearch$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetHubDomainSearch.kt */
    public static final class C90241 extends Lambda implements Function1<WidgetHubDomainsViewModel2, Unit> {
        public C90241() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetHubDomainsViewModel2 widgetHubDomainsViewModel2) {
            invoke2(widgetHubDomainsViewModel2);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetHubDomainsViewModel2 widgetHubDomainsViewModel2) {
            WidgetHubDomainSearch widgetHubDomainSearch = WidgetHubDomainSearch.this;
            Intrinsics3.checkNotNullExpressionValue(widgetHubDomainsViewModel2, "viewState");
            WidgetHubDomainSearch.access$updateView(widgetHubDomainSearch, widgetHubDomainsViewModel2);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubDomainSearch$updateView$1 */
    /* JADX INFO: compiled from: WidgetHubDomainSearch.kt */
    public static final class C90251 extends Lambda implements Function1<RestCallState6<? extends Object>, Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ WidgetHubDomainsViewModel2 $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C90251(Context context, WidgetHubDomainsViewModel2 widgetHubDomainsViewModel2) {
            super(1);
            this.$context = context;
            this.$state = widgetHubDomainsViewModel2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState6<? extends Object> restCallState6) {
            invoke2(restCallState6);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState6<? extends Object> restCallState6) {
            Intrinsics3.checkNotNullParameter(restCallState6, "it");
            AppScreen2.m158g(AppScreen2.f524g, WidgetHubDomainSearch.this.getParentFragmentManager(), this.$context, WidgetHubAuthentication.class, 0, true, null, new WidgetHubAuthenticationlViewModel2(WidgetHubDomainSearch.this.getArgs().getEmail(), this.$state.getSelectedGuildId()), 40);
            WidgetHubDomainSearch.this.getViewModel().reset();
        }
    }

    public WidgetHubDomainSearch() {
        super(C5419R.layout.widget_hub_domain_search);
        this.args = LazyJVM.lazy(new WidgetHubDomainSearch$$special$$inlined$args$1(this, "intent_args_key"));
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetHubDomainSearch3.INSTANCE, null, 2, null);
        this.adapter = new SimpleRecyclerAdapter<>(null, new WidgetHubDomainSearch2(this), 1, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetHubDomainsViewModel.class), new C9018xb5e5d61c(this), new AppViewModelDelegates2(WidgetHubDomainSearch4.INSTANCE));
    }

    public static final /* synthetic */ void access$searchForGuild(WidgetHubDomainSearch widgetHubDomainSearch) {
        widgetHubDomainSearch.searchForGuild();
    }

    public static final /* synthetic */ void access$updateView(WidgetHubDomainSearch widgetHubDomainSearch, WidgetHubDomainsViewModel2 widgetHubDomainsViewModel2) {
        widgetHubDomainSearch.updateView(widgetHubDomainsViewModel2);
    }

    private final void searchForGuild() {
        TextInputEditText textInputEditText = getBinding().f17169h;
        Intrinsics3.checkNotNullExpressionValue(textInputEditText, "binding.searchBarText");
        String strValueOf = String.valueOf(textInputEditText.getText());
        Locale locale = Locale.getDefault();
        Intrinsics3.checkNotNullExpressionValue(locale, "Locale.getDefault()");
        String lowerCase = strValueOf.toLowerCase(locale);
        Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        List<WidgetHubDomains2> guildInfos = getArgs().getGuildInfos();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = guildInfos.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            String name = ((WidgetHubDomains2) next).getName();
            Locale locale2 = Locale.getDefault();
            Intrinsics3.checkNotNullExpressionValue(locale2, "Locale.getDefault()");
            Objects.requireNonNull(name, "null cannot be cast to non-null type java.lang.String");
            String lowerCase2 = name.toLowerCase(locale2);
            Intrinsics3.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
            if (Strings4.contains$default((CharSequence) lowerCase2, (CharSequence) lowerCase, false, 2, (Object) null)) {
                arrayList.add(next);
            }
        }
        TextView textView = getBinding().f17165d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.emptyTitle");
        textView.setText(getString(arrayList.isEmpty() ? C5419R.string.directory_search_no_results_title : C5419R.string.directory_search_initial_title));
        LinearLayout linearLayout = getBinding().f17164c;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.emptyState");
        linearLayout.setVisibility(arrayList.isEmpty() ? 0 : 8);
        RecyclerView recyclerView = getBinding().f17166e;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        recyclerView.setVisibility(arrayList.isEmpty() ^ true ? 0 : 8);
        this.adapter.setData(arrayList);
    }

    private final void updateView(WidgetHubDomainsViewModel2 state) {
        Context context = getContext();
        if (context != null) {
            Intrinsics3.checkNotNullExpressionValue(context, "context ?: return");
            RestCallState5.handleResponse$default(state.getVerifyEmailAsync(), context, null, null, new C90251(context, state), 6, null);
        }
    }

    public final SimpleRecyclerAdapter<WidgetHubDomains2, WidgetHubDomains4> getAdapter() {
        return this.adapter;
    }

    public final WidgetHubDomains3 getArgs() {
        return (WidgetHubDomains3) this.args.getValue();
    }

    public final WidgetHubDomainSearchBinding getBinding() {
        return (WidgetHubDomainSearchBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
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
        getBinding().f17166e.setAdapter(this.adapter);
        getBinding().f17168g.setStartIconOnClickListener(new ViewOnClickListenerC90202());
        getBinding().f17167f.setOnClickListener(new ViewOnClickListenerC90213());
        TextInputLayout textInputLayout = getBinding().f17168g;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.searchBar");
        CharSequence charSequenceM210b = null;
        ViewExtensions.setOnImeActionDone$default(textInputLayout, false, new C90224(), 1, null);
        LinkifiedTextView linkifiedTextView = getBinding().f17163b;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.emptyDescription");
        Context context = getContext();
        if (context != null) {
            charSequenceM210b = FormatUtils.m210b(context, C5419R.string.hub_email_connection_guild_select_subheader, new Object[0], new C90235());
        }
        linkifiedTextView.setText(charSequenceM210b);
        TextInputEditText textInputEditText = getBinding().f17169h;
        Intrinsics3.checkNotNullExpressionValue(textInputEditText, "binding.searchBarText");
        showKeyboard(textInputEditText);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<WidgetHubDomainsViewModel2> observableM11112r = getViewModel().observeViewState().m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11112r, this, null, 2, null), WidgetHubDomainSearch.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C90241(), 62, (Object) null);
    }
}
