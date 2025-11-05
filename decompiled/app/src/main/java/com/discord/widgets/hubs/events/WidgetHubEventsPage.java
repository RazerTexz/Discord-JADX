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
import b.a.d.g0;
import b.a.d.i0;
import b.c.a.a0.d;
import b.d.b.a.a;
import com.discord.R;
import com.discord.api.directory.DirectoryEntryEvent;
import com.discord.app.AppBottomSheet;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetHubEventsPageBinding;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.stores.utilities.Success;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.hubs.events.HubEventsPage;
import d0.g;
import d0.t.n;
import d0.t.u;
import d0.z.d.a0;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
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

/* compiled from: WidgetHubEventsPage.kt */
/* loaded from: classes2.dex */
public final class WidgetHubEventsPage extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetHubEventsPage.class, "binding", "getBinding()Lcom/discord/databinding/WidgetHubEventsPageBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final HubEventsEventListener listener;
    private final LoggingConfig loggingConfig;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetHubEventsPage.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, long guildId, long directoryChannelId) {
            m.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetHubEventsPage widgetHubEventsPage = new WidgetHubEventsPage();
            widgetHubEventsPage.setArguments(d.e2(new HubEventsArgs(guildId, directoryChannelId)));
            widgetHubEventsPage.show(fragmentManager, WidgetHubEventsPage.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetHubEventsPage.kt */
    /* renamed from: com.discord.widgets.hubs.events.WidgetHubEventsPage$configUI$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function1<Success<? extends List<? extends DirectoryEntryEvent>>, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Success<? extends List<? extends DirectoryEntryEvent>> success) {
            invoke2((Success<? extends List<DirectoryEntryEvent>>) success);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Success<? extends List<DirectoryEntryEvent>> success) {
            m.checkNotNullParameter(success, "it");
            WidgetHubEventsPage.this.getBinding().f2477b.smoothScrollToPosition(0);
            WidgetHubEventsPage.this.getViewModel().reset();
        }
    }

    /* compiled from: WidgetHubEventsPage.kt */
    /* renamed from: com.discord.widgets.hubs.events.WidgetHubEventsPage$onResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends k implements Function1<WidgetHubEventsState, Unit> {
        public AnonymousClass1(WidgetHubEventsPage widgetHubEventsPage) {
            super(1, widgetHubEventsPage, WidgetHubEventsPage.class, "configUI", "configUI(Lcom/discord/widgets/hubs/events/WidgetHubEventsState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetHubEventsState widgetHubEventsState) {
            invoke2(widgetHubEventsState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetHubEventsState widgetHubEventsState) {
            m.checkNotNullParameter(widgetHubEventsState, "p1");
            WidgetHubEventsPage.access$configUI((WidgetHubEventsPage) this.receiver, widgetHubEventsState);
        }
    }

    public WidgetHubEventsPage() {
        super(false, 1, null);
        this.args = g.lazy(new WidgetHubEventsPage$$special$$inlined$args$1(this, "intent_args_key"));
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetHubEventsPage$binding$2.INSTANCE, null, 2, null);
        WidgetHubEventsPage$viewModel$2 widgetHubEventsPage$viewModel$2 = new WidgetHubEventsPage$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetHubEventsViewModel.class), new WidgetHubEventsPage$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetHubEventsPage$viewModel$2));
        this.listener = new WidgetHubEventsPage$listener$1(this);
        this.adapter = g.lazy(new WidgetHubEventsPage$adapter$2(this));
        this.loggingConfig = new LoggingConfig(false, null, new WidgetHubEventsPage$loggingConfig$1(this), 3);
    }

    public static final /* synthetic */ void access$configUI(WidgetHubEventsPage widgetHubEventsPage, WidgetHubEventsState widgetHubEventsState) {
        widgetHubEventsPage.configUI(widgetHubEventsState);
    }

    private final void configUI(WidgetHubEventsState state) {
        if (!state.getEventsData().isEmpty() || (state.getEventsAsync() instanceof Success)) {
            WidgetHubEventsPageAdapter adapter = getAdapter();
            HubEventsPage.Header header = HubEventsPage.Header.INSTANCE;
            if (!state.getShowHeader()) {
                header = null;
            }
            List listListOfNotNull = n.listOfNotNull(header);
            List<HubGuildScheduledEventData> eventsData = state.getEventsData();
            ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(eventsData, 10));
            Iterator<T> it = eventsData.iterator();
            while (it.hasNext()) {
                arrayList.add(new HubEventsPage.Event((HubGuildScheduledEventData) it.next()));
            }
            adapter.setItems(u.plus((Collection<? extends HubEventsPage.Footer>) u.plus((Collection) listListOfNotNull, (Iterable) arrayList), new HubEventsPage.Footer(state.getEventsAsync())));
            TextView textView = getBinding().c;
            m.checkNotNullExpressionValue(textView, "binding.title");
            Context context = getContext();
            textView.setText(context != null ? StringResourceUtilsKt.getI18nPluralString(context, R.plurals.guild_events_plural_number, state.getEventsData().size(), Integer.valueOf(state.getEventsData().size())) : null);
            RestCallState<List<DirectoryEntryEvent>> eventsAsync = state.getEventsAsync();
            Context contextRequireContext = requireContext();
            m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            RestCallStateKt.handleResponse$default(eventsAsync, contextRequireContext, null, null, new AnonymousClass3(), 6, null);
        }
    }

    public final WidgetHubEventsPageAdapter getAdapter() {
        return (WidgetHubEventsPageAdapter) this.adapter.getValue();
    }

    public final HubEventsArgs getArgs() {
        return (HubEventsArgs) this.args.getValue();
    }

    public final WidgetHubEventsPageBinding getBinding() {
        return (WidgetHubEventsPageBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_hub_events_page;
    }

    public final HubEventsEventListener getListener() {
        return this.listener;
    }

    @Override // com.discord.app.AppBottomSheet, com.discord.app.AppLogger.a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    public final WidgetHubEventsViewModel getViewModel() {
        return (WidgetHubEventsViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetHubEventsPage.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = getBinding().f2477b;
        recyclerView.setAdapter(getAdapter());
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
    }
}
