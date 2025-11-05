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
import b.a.d.f0;
import b.a.d.j;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetHubDomainSearchBinding;
import com.discord.i18n.RenderContext;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.stores.utilities.Success;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import d0.g;
import d0.g0.w;
import d0.z.d.a0;
import d0.z.d.m;
import d0.z.d.o;
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
import rx.Observable;

/* compiled from: WidgetHubDomainSearch.kt */
/* loaded from: classes2.dex */
public final class WidgetHubDomainSearch extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetHubDomainSearch.class, "binding", "getBinding()Lcom/discord/databinding/WidgetHubDomainSearchBinding;", 0)};
    private final SimpleRecyclerAdapter<DomainGuildInfo, HubDomainViewHolder> adapter;

    /* renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetHubDomainSearch.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubDomainSearch$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
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

    /* compiled from: WidgetHubDomainSearch.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubDomainSearch$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetHubDomainSearch.access$searchForGuild(WidgetHubDomainSearch.this);
        }
    }

    /* compiled from: WidgetHubDomainSearch.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubDomainSearch$onViewBound$4, reason: invalid class name */
    public static final class AnonymousClass4 extends o implements Function1<TextView, Unit> {
        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
            invoke2(textView);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TextView textView) {
            m.checkNotNullParameter(textView, "it");
            WidgetHubDomainSearch.access$searchForGuild(WidgetHubDomainSearch.this);
        }
    }

    /* compiled from: WidgetHubDomainSearch.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubDomainSearch$onViewBound$5, reason: invalid class name */
    public static final class AnonymousClass5 extends o implements Function1<RenderContext, Unit> {

        /* compiled from: WidgetHubDomainSearch.kt */
        /* renamed from: com.discord.widgets.hubs.WidgetHubDomainSearch$onViewBound$5$1, reason: invalid class name */
        public static final class AnonymousClass1 extends o implements Function1<View, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                m.checkNotNullParameter(view, "it");
                j jVar = j.g;
                FragmentManager parentFragmentManager = WidgetHubDomainSearch.this.getParentFragmentManager();
                Context context = view.getContext();
                m.checkNotNullExpressionValue(context, "it.context");
                j.g(jVar, parentFragmentManager, context, WidgetHubWaitlist.class, 0, true, null, new HubWaitlistArgs(WidgetHubDomainSearch.this.getArgs().getEmail()), 40);
            }
        }

        public AnonymousClass5() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            m.checkNotNullParameter(renderContext, "$receiver");
            renderContext.b("onJoinWaitlist", new AnonymousClass1());
        }
    }

    /* compiled from: WidgetHubDomainSearch.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubDomainSearch$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<DomainsState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DomainsState domainsState) {
            invoke2(domainsState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DomainsState domainsState) {
            WidgetHubDomainSearch widgetHubDomainSearch = WidgetHubDomainSearch.this;
            m.checkNotNullExpressionValue(domainsState, "viewState");
            WidgetHubDomainSearch.access$updateView(widgetHubDomainSearch, domainsState);
        }
    }

    /* compiled from: WidgetHubDomainSearch.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubDomainSearch$updateView$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Success<? extends Object>, Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ DomainsState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context, DomainsState domainsState) {
            super(1);
            this.$context = context;
            this.$state = domainsState;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Success<? extends Object> success) {
            invoke2(success);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Success<? extends Object> success) {
            m.checkNotNullParameter(success, "it");
            j.g(j.g, WidgetHubDomainSearch.this.getParentFragmentManager(), this.$context, WidgetHubAuthentication.class, 0, true, null, new HubAuthenticationArgs(WidgetHubDomainSearch.this.getArgs().getEmail(), this.$state.getSelectedGuildId()), 40);
            WidgetHubDomainSearch.this.getViewModel().reset();
        }
    }

    public WidgetHubDomainSearch() {
        super(R.layout.widget_hub_domain_search);
        this.args = g.lazy(new WidgetHubDomainSearch$$special$$inlined$args$1(this, "intent_args_key"));
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetHubDomainSearch$binding$2.INSTANCE, null, 2, null);
        this.adapter = new SimpleRecyclerAdapter<>(null, new WidgetHubDomainSearch$adapter$1(this), 1, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetHubDomainsViewModel.class), new WidgetHubDomainSearch$appActivityViewModels$$inlined$activityViewModels$1(this), new f0(WidgetHubDomainSearch$viewModel$2.INSTANCE));
    }

    public static final /* synthetic */ void access$searchForGuild(WidgetHubDomainSearch widgetHubDomainSearch) {
        widgetHubDomainSearch.searchForGuild();
    }

    public static final /* synthetic */ void access$updateView(WidgetHubDomainSearch widgetHubDomainSearch, DomainsState domainsState) {
        widgetHubDomainSearch.updateView(domainsState);
    }

    private final void searchForGuild() {
        TextInputEditText textInputEditText = getBinding().h;
        m.checkNotNullExpressionValue(textInputEditText, "binding.searchBarText");
        String strValueOf = String.valueOf(textInputEditText.getText());
        Locale locale = Locale.getDefault();
        m.checkNotNullExpressionValue(locale, "Locale.getDefault()");
        String lowerCase = strValueOf.toLowerCase(locale);
        m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        List<DomainGuildInfo> guildInfos = getArgs().getGuildInfos();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = guildInfos.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            String name = ((DomainGuildInfo) next).getName();
            Locale locale2 = Locale.getDefault();
            m.checkNotNullExpressionValue(locale2, "Locale.getDefault()");
            Objects.requireNonNull(name, "null cannot be cast to non-null type java.lang.String");
            String lowerCase2 = name.toLowerCase(locale2);
            m.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
            if (w.contains$default((CharSequence) lowerCase2, (CharSequence) lowerCase, false, 2, (Object) null)) {
                arrayList.add(next);
            }
        }
        TextView textView = getBinding().d;
        m.checkNotNullExpressionValue(textView, "binding.emptyTitle");
        textView.setText(getString(arrayList.isEmpty() ? R.string.directory_search_no_results_title : R.string.directory_search_initial_title));
        LinearLayout linearLayout = getBinding().c;
        m.checkNotNullExpressionValue(linearLayout, "binding.emptyState");
        linearLayout.setVisibility(arrayList.isEmpty() ? 0 : 8);
        RecyclerView recyclerView = getBinding().e;
        m.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        recyclerView.setVisibility(arrayList.isEmpty() ^ true ? 0 : 8);
        this.adapter.setData(arrayList);
    }

    private final void updateView(DomainsState state) {
        Context context = getContext();
        if (context != null) {
            m.checkNotNullExpressionValue(context, "context ?: return");
            RestCallStateKt.handleResponse$default(state.getVerifyEmailAsync(), context, null, null, new AnonymousClass1(context, state), 6, null);
        }
    }

    public final SimpleRecyclerAdapter<DomainGuildInfo, HubDomainViewHolder> getAdapter() {
        return this.adapter;
    }

    public final HubDomainArgs getArgs() {
        return (HubDomainArgs) this.args.getValue();
    }

    public final WidgetHubDomainSearchBinding getBinding() {
        return (WidgetHubDomainSearchBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public final WidgetHubDomainsViewModel getViewModel() {
        return (WidgetHubDomainsViewModel) this.viewModel.getValue();
    }

    public final void onServerClickListener(DomainGuildInfo guildInfo) {
        m.checkNotNullParameter(guildInfo, "guildInfo");
        getViewModel().onGuildClicked(guildInfo.getId(), getArgs().getEmail());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().e.setAdapter(this.adapter);
        getBinding().g.setStartIconOnClickListener(new AnonymousClass2());
        getBinding().f.setOnClickListener(new AnonymousClass3());
        TextInputLayout textInputLayout = getBinding().g;
        m.checkNotNullExpressionValue(textInputLayout, "binding.searchBar");
        CharSequence charSequenceB = null;
        ViewExtensions.setOnImeActionDone$default(textInputLayout, false, new AnonymousClass4(), 1, null);
        LinkifiedTextView linkifiedTextView = getBinding().f2471b;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.emptyDescription");
        Context context = getContext();
        if (context != null) {
            charSequenceB = b.b(context, R.string.hub_email_connection_guild_select_subheader, new Object[0], new AnonymousClass5());
        }
        linkifiedTextView.setText(charSequenceB);
        TextInputEditText textInputEditText = getBinding().h;
        m.checkNotNullExpressionValue(textInputEditText, "binding.searchBarText");
        showKeyboard(textInputEditText);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<DomainsState> observableR = getViewModel().observeViewState().r();
        m.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetHubDomainSearch.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
