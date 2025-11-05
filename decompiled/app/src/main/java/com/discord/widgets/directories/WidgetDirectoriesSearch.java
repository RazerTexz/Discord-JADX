package com.discord.widgets.directories;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppScreen2;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetDirectoriesSearchBinding;
import com.discord.i18n.RenderContext;
import com.discord.stores.utilities.RestCallState4;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.hubs.HubUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.directories.DirectoryChannelItem;
import com.discord.widgets.directories.WidgetDirectoriesSearchViewModel;
import com.discord.widgets.hubs.WidgetHubAddServer;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import d0.LazyJVM;
import d0.g0.StringsJVM;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* compiled from: WidgetDirectoriesSearch.kt */
/* loaded from: classes2.dex */
public final class WidgetDirectoriesSearch extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetDirectoriesSearch.class, "binding", "getBinding()Lcom/discord/databinding/WidgetDirectoriesSearchBinding;", 0)};
    private final ActivityResultLauncher<Intent> activityResult;
    private final WidgetDirectoryChannelAdapter adapter;

    /* renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetDirectoriesSearch.kt */
    /* renamed from: com.discord.widgets.directories.WidgetDirectoriesSearch$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<RenderContext, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.boldColor = Integer.valueOf(ColorCompat.getThemedColor(WidgetDirectoriesSearch.this.getContext(), R.attr.colorTextMuted));
        }
    }

    /* compiled from: WidgetDirectoriesSearch.kt */
    /* renamed from: com.discord.widgets.directories.WidgetDirectoriesSearch$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<RenderContext, Unit> {

        /* compiled from: WidgetDirectoriesSearch.kt */
        /* renamed from: com.discord.widgets.directories.WidgetDirectoriesSearch$configureUI$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
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
                Intrinsics3.checkNotNullParameter(view, "it");
                AppScreen2.g.f(WidgetDirectoriesSearch.this.requireContext(), WidgetDirectoriesSearch.access$getActivityResult$p(WidgetDirectoriesSearch.this), WidgetHubAddServer.class, null);
            }
        }

        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.b("addServerHook", new AnonymousClass1());
        }
    }

    /* compiled from: WidgetDirectoriesSearch.kt */
    /* renamed from: com.discord.widgets.directories.WidgetDirectoriesSearch$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ View $view;

        public AnonymousClass2(View view) {
            this.$view = view;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            FragmentActivity activity = WidgetDirectoriesSearch.this.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
            WidgetDirectoriesSearch.this.hideKeyboard(this.$view);
        }
    }

    /* compiled from: WidgetDirectoriesSearch.kt */
    /* renamed from: com.discord.widgets.directories.WidgetDirectoriesSearch$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetDirectoriesSearch.access$searchForDirectories(WidgetDirectoriesSearch.this);
        }
    }

    /* compiled from: WidgetDirectoriesSearch.kt */
    /* renamed from: com.discord.widgets.directories.WidgetDirectoriesSearch$onViewBound$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function1<TextView, Unit> {
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
            Intrinsics3.checkNotNullParameter(textView, "it");
            WidgetDirectoriesSearch.access$searchForDirectories(WidgetDirectoriesSearch.this);
        }
    }

    /* compiled from: WidgetDirectoriesSearch.kt */
    /* renamed from: com.discord.widgets.directories.WidgetDirectoriesSearch$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetDirectoriesSearchViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetDirectoriesSearchViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetDirectoriesSearchViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "it");
            WidgetDirectoriesSearch.access$configureUI(WidgetDirectoriesSearch.this, viewState);
        }
    }

    public WidgetDirectoriesSearch() {
        super(R.layout.widget_directories_search);
        this.args = LazyJVM.lazy(new WidgetDirectoriesSearch$$special$$inlined$args$1(this, "intent_args_key"));
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetDirectoriesSearch5.INSTANCE, null, 2, null);
        WidgetDirectoriesSearch6 widgetDirectoriesSearch6 = new WidgetDirectoriesSearch6(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetDirectoriesSearchViewModel.class), new WidgetDirectoriesSearch$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetDirectoriesSearch6));
        this.activityResult = HubUtils.getAddServerActivityResultHandler(this);
        this.adapter = new WidgetDirectoryChannelAdapter(new WidgetDirectoriesSearch3(this));
    }

    public static final /* synthetic */ void access$configureUI(WidgetDirectoriesSearch widgetDirectoriesSearch, WidgetDirectoriesSearchViewModel.ViewState viewState) {
        widgetDirectoriesSearch.configureUI(viewState);
    }

    public static final /* synthetic */ ActivityResultLauncher access$getActivityResult$p(WidgetDirectoriesSearch widgetDirectoriesSearch) {
        return widgetDirectoriesSearch.activityResult;
    }

    public static final /* synthetic */ void access$searchForDirectories(WidgetDirectoriesSearch widgetDirectoriesSearch) {
        widgetDirectoriesSearch.searchForDirectories();
    }

    private final void configureUI(WidgetDirectoriesSearchViewModel.ViewState state) {
        WidgetDirectoryChannelAdapter widgetDirectoryChannelAdapter = this.adapter;
        List<DirectoryEntryData> directoryEntryData = state.getDirectoryEntryData();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(directoryEntryData, 10));
        Iterator<T> it = directoryEntryData.iterator();
        while (it.hasNext()) {
            arrayList.add(new DirectoryChannelItem.DirectoryItem((DirectoryEntryData) it.next()));
        }
        widgetDirectoryChannelAdapter.setDirectoryChannelItems(arrayList);
        toggleList(!state.getDirectories().isEmpty());
        FloatingActionButton floatingActionButton = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(floatingActionButton, "binding.search");
        WidgetDirectoriesSearchViewModel viewModel = getViewModel();
        TextInputEditText textInputEditText = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(textInputEditText, "binding.searchBarText");
        floatingActionButton.setVisibility(viewModel.shouldNotSearch(String.valueOf(textInputEditText.getText())) ^ true ? 0 : 8);
        if (state.getDirectories().isEmpty() && (!Intrinsics3.areEqual(state.getDirectoriesState(), RestCallState4.INSTANCE))) {
            LinkifiedTextView linkifiedTextView = getBinding().f2363b;
            Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.emptyDescription");
            TextInputEditText textInputEditText2 = getBinding().h;
            Intrinsics3.checkNotNullExpressionValue(textInputEditText2, "binding.searchBarText");
            Editable text = textInputEditText2.getText();
            linkifiedTextView.setText(text == null || StringsJVM.isBlank(text) ? FormatUtils.e(this, R.string.guild_discovery_search_protip, new Object[0], new AnonymousClass2()) : !state.getHasAddGuildPermissions() ? FormatUtils.k(this, R.string.directory_search_no_results_no_add, new Object[0], null, 4) : FormatUtils.e(this, R.string.directory_search_no_results_subtitle, new Object[0], new AnonymousClass3()));
            TextView textView = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.emptyTitle");
            TextInputEditText textInputEditText3 = getBinding().h;
            Intrinsics3.checkNotNullExpressionValue(textInputEditText3, "binding.searchBarText");
            Editable text2 = textInputEditText3.getText();
            textView.setVisibility((text2 == null || StringsJVM.isBlank(text2)) ^ true ? 0 : 8);
        }
    }

    private final void searchForDirectories() {
        WidgetDirectoriesSearchViewModel viewModel = getViewModel();
        long channelId = getArgs().getChannelId();
        TextInputEditText textInputEditText = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(textInputEditText, "binding.searchBarText");
        viewModel.searchForDirectories(channelId, String.valueOf(textInputEditText.getText()));
        hideKeyboard(getView());
    }

    private final void toggleList(boolean showList) {
        RecyclerView recyclerView = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        recyclerView.setVisibility(showList ? 0 : 8);
        LinearLayout linearLayout = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.emptyState");
        linearLayout.setVisibility(showList ^ true ? 0 : 8);
    }

    public final WidgetDirectoryChannelAdapter getAdapter() {
        return this.adapter;
    }

    public final WidgetDirectoriesSearch2 getArgs() {
        return (WidgetDirectoriesSearch2) this.args.getValue();
    }

    public final WidgetDirectoriesSearchBinding getBinding() {
        return (WidgetDirectoriesSearchBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public final WidgetDirectoriesSearchViewModel getViewModel() {
        return (WidgetDirectoriesSearchViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        RecyclerView recyclerView = getBinding().e;
        recyclerView.setAdapter(this.adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        getBinding().g.setStartIconOnClickListener(new AnonymousClass2(view));
        getBinding().f.setOnClickListener(new AnonymousClass3());
        TextInputLayout textInputLayout = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.searchBar");
        ViewExtensions.setOnImeActionDone$default(textInputLayout, false, new AnonymousClass4(), 1, null);
        TextInputEditText textInputEditText = getBinding().h;
        textInputEditText.addTextChangedListener(new WidgetDirectoriesSearch$onViewBound$$inlined$apply$lambda$1(this));
        Intrinsics3.checkNotNullExpressionValue(textInputEditText, "this");
        showKeyboard(textInputEditText);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(ObservableExtensionsKt.ui(getViewModel().observeViewState()), this, null, 2, null), WidgetDirectoriesSearch.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
