package com.discord.widgets.hubs.events;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.directory.DirectoryEntryGuild2;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppLogger2;
import com.discord.databinding.WidgetHubEventsPageBinding;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.RestCallState5;
import com.discord.stores.utilities.RestCallState6;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.hubs.events.WidgetHubEventsPageAdapter2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.p580t.Collections2;
import p507d0.p580t.Iterables2;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;

/* compiled from: WidgetHubEventsPage.kt */
/* loaded from: classes2.dex */
public final class WidgetHubEventsPage extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetHubEventsPage.class, "binding", "getBinding()Lcom/discord/databinding/WidgetHubEventsPageBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final WidgetHubEventsPage3 listener;
    private final AppLogger2 loggingConfig;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetHubEventsPage.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, long guildId, long directoryChannelId) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetHubEventsPage widgetHubEventsPage = new WidgetHubEventsPage();
            widgetHubEventsPage.setArguments(AnimatableValueParser.m514e2(new WidgetHubEventsPage2(guildId, directoryChannelId)));
            widgetHubEventsPage.show(fragmentManager, WidgetHubEventsPage.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetHubEventsPage.kt */
    /* renamed from: com.discord.widgets.hubs.events.WidgetHubEventsPage$configUI$3 */
    public static final class C90533 extends Lambda implements Function1<RestCallState6<? extends List<? extends DirectoryEntryGuild2>>, Unit> {
        public C90533() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState6<? extends List<? extends DirectoryEntryGuild2>> restCallState6) {
            invoke2((RestCallState6<? extends List<DirectoryEntryGuild2>>) restCallState6);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState6<? extends List<DirectoryEntryGuild2>> restCallState6) {
            Intrinsics3.checkNotNullParameter(restCallState6, "it");
            WidgetHubEventsPage.this.getBinding().f17186b.smoothScrollToPosition(0);
            WidgetHubEventsPage.this.getViewModel().reset();
        }
    }

    /* compiled from: WidgetHubEventsPage.kt */
    /* renamed from: com.discord.widgets.hubs.events.WidgetHubEventsPage$onResume$1 */
    public static final /* synthetic */ class C90541 extends FunctionReferenceImpl implements Function1<WidgetHubEventsViewModel3, Unit> {
        public C90541(WidgetHubEventsPage widgetHubEventsPage) {
            super(1, widgetHubEventsPage, WidgetHubEventsPage.class, "configUI", "configUI(Lcom/discord/widgets/hubs/events/WidgetHubEventsState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetHubEventsViewModel3 widgetHubEventsViewModel3) {
            invoke2(widgetHubEventsViewModel3);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetHubEventsViewModel3 widgetHubEventsViewModel3) {
            Intrinsics3.checkNotNullParameter(widgetHubEventsViewModel3, "p1");
            WidgetHubEventsPage.access$configUI((WidgetHubEventsPage) this.receiver, widgetHubEventsViewModel3);
        }
    }

    public WidgetHubEventsPage() {
        super(false, 1, null);
        this.args = LazyJVM.lazy(new WidgetHubEventsPage$$special$$inlined$args$1(this, "intent_args_key"));
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetHubEventsPage5.INSTANCE, null, 2, null);
        WidgetHubEventsPage9 widgetHubEventsPage9 = new WidgetHubEventsPage9(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetHubEventsViewModel.class), new WidgetHubEventsPage$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetHubEventsPage9));
        this.listener = new WidgetHubEventsPage6(this);
        this.adapter = LazyJVM.lazy(new WidgetHubEventsPage4(this));
        this.loggingConfig = new AppLogger2(false, null, new WidgetHubEventsPage8(this), 3);
    }

    public static final /* synthetic */ void access$configUI(WidgetHubEventsPage widgetHubEventsPage, WidgetHubEventsViewModel3 widgetHubEventsViewModel3) {
        widgetHubEventsPage.configUI(widgetHubEventsViewModel3);
    }

    private final void configUI(WidgetHubEventsViewModel3 state) {
        if (!state.getEventsData().isEmpty() || (state.getEventsAsync() instanceof RestCallState6)) {
            WidgetHubEventsPageAdapter adapter = getAdapter();
            WidgetHubEventsPageAdapter2.Header header = WidgetHubEventsPageAdapter2.Header.INSTANCE;
            if (!state.getShowHeader()) {
                header = null;
            }
            List listListOfNotNull = Collections2.listOfNotNull(header);
            List<WidgetHubEventsViewModel2> eventsData = state.getEventsData();
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(eventsData, 10));
            Iterator<T> it = eventsData.iterator();
            while (it.hasNext()) {
                arrayList.add(new WidgetHubEventsPageAdapter2.Event((WidgetHubEventsViewModel2) it.next()));
            }
            adapter.setItems(_Collections.plus((Collection<? extends WidgetHubEventsPageAdapter2.Footer>) _Collections.plus((Collection) listListOfNotNull, (Iterable) arrayList), new WidgetHubEventsPageAdapter2.Footer(state.getEventsAsync())));
            TextView textView = getBinding().f17187c;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.title");
            Context context = getContext();
            textView.setText(context != null ? StringResourceUtils.getI18nPluralString(context, C5419R.plurals.guild_events_plural_number, state.getEventsData().size(), Integer.valueOf(state.getEventsData().size())) : null);
            RestCallState<List<DirectoryEntryGuild2>> eventsAsync = state.getEventsAsync();
            Context contextRequireContext = requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            RestCallState5.handleResponse$default(eventsAsync, contextRequireContext, null, null, new C90533(), 6, null);
        }
    }

    public final WidgetHubEventsPageAdapter getAdapter() {
        return (WidgetHubEventsPageAdapter) this.adapter.getValue();
    }

    public final WidgetHubEventsPage2 getArgs() {
        return (WidgetHubEventsPage2) this.args.getValue();
    }

    public final WidgetHubEventsPageBinding getBinding() {
        return (WidgetHubEventsPageBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_hub_events_page;
    }

    public final WidgetHubEventsPage3 getListener() {
        return this.listener;
    }

    @Override // com.discord.app.AppBottomSheet, com.discord.app.AppLogger.InterfaceC5455a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    public final WidgetHubEventsViewModel getViewModel() {
        return (WidgetHubEventsViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetHubEventsPage.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C90541(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = getBinding().f17186b;
        recyclerView.setAdapter(getAdapter());
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
    }
}
