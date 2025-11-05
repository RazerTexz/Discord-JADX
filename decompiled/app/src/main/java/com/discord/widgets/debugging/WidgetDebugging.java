package com.discord.widgets.debugging;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.LayoutRes;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.j;
import b.d.b.a.a;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.app.AppLog;
import com.discord.databinding.WidgetDebuggingAdapterItemBinding;
import com.discord.databinding.WidgetDebuggingBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.t.u;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
import j0.k.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Action2;
import rx.functions.Func2;
import rx.subjects.BehaviorSubject;

/* compiled from: WidgetDebugging.kt */
/* loaded from: classes2.dex */
public final class WidgetDebugging extends AppFragment {
    private static final int COLLAPSED_MAX_LINES = 2;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final BehaviorSubject<Boolean> filterSubject;
    private Adapter logsAdapter;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetDebugging.class, "binding", "getBinding()Lcom/discord/databinding/WidgetDebuggingBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: WidgetDebugging.kt */
    public static final class Adapter extends MGRecyclerAdapterSimple<AppLog.LoggedItem> {

        /* compiled from: WidgetDebugging.kt */
        /* renamed from: com.discord.widgets.debugging.WidgetDebugging$Adapter$1, reason: invalid class name */
        public static final class AnonymousClass1 extends o implements Function2<List<? extends AppLog.LoggedItem>, List<? extends AppLog.LoggedItem>, Unit> {
            public final /* synthetic */ RecyclerView $recycler;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(RecyclerView recyclerView) {
                super(2);
                this.$recycler = recyclerView;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends AppLog.LoggedItem> list, List<? extends AppLog.LoggedItem> list2) {
                invoke2((List<AppLog.LoggedItem>) list, (List<AppLog.LoggedItem>) list2);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<AppLog.LoggedItem> list, List<AppLog.LoggedItem> list2) {
                m.checkNotNullParameter(list, "<anonymous parameter 0>");
                m.checkNotNullParameter(list2, "<anonymous parameter 1>");
                RecyclerView.LayoutManager layoutManager = this.$recycler.getLayoutManager();
                Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                if (((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition() == 0) {
                    this.$recycler.scrollToPosition(0);
                }
            }
        }

        /* compiled from: WidgetDebugging.kt */
        public static final class Item extends MGRecyclerViewHolder<Adapter, AppLog.LoggedItem> {
            private final WidgetDebuggingAdapterItemBinding binding;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Item(@LayoutRes int i, Adapter adapter) {
                super(i, adapter);
                m.checkNotNullParameter(adapter, "adapter");
                View view = this.itemView;
                TextView textView = (TextView) view.findViewById(R.id.log_message);
                if (textView == null) {
                    throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.log_message)));
                }
                WidgetDebuggingAdapterItemBinding widgetDebuggingAdapterItemBinding = new WidgetDebuggingAdapterItemBinding((LinearLayout) view, textView);
                m.checkNotNullExpressionValue(widgetDebuggingAdapterItemBinding, "WidgetDebuggingAdapterItemBinding.bind(itemView)");
                this.binding = widgetDebuggingAdapterItemBinding;
            }

            public static final /* synthetic */ WidgetDebuggingAdapterItemBinding access$getBinding$p(Item item) {
                return item.binding;
            }

            @ColorInt
            private final int getColor(Context context, int priority) {
                return priority != 2 ? priority != 3 ? priority != 5 ? priority != 6 ? ColorCompat.getThemedColor(context, R.attr.primary_100) : ColorCompat.getColor(context, R.color.status_red_500) : ColorCompat.getColor(context, R.color.status_yellow_500) : ColorCompat.getColor(context, R.color.status_green_600) : ColorCompat.getThemedColor(context, R.attr.primary_300);
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
            public /* bridge */ /* synthetic */ void onConfigure(int i, AppLog.LoggedItem loggedItem) {
                onConfigure2(i, loggedItem);
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0046  */
            @SuppressLint({"SetTextI18n"})
            /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onConfigure2(int position, AppLog.LoggedItem data) {
                String string;
                m.checkNotNullParameter(data, "data");
                super.onConfigure(position, (int) data);
                TextView textView = this.binding.f2361b;
                textView.setTextColor(getColor(a.I(textView, "binding.logMessage", "binding.logMessage.context"), data.priority));
                TextView textView2 = this.binding.f2361b;
                m.checkNotNullExpressionValue(textView2, "binding.logMessage");
                StringBuilder sb = new StringBuilder();
                sb.append(data.message);
                Throwable th = data.throwable;
                if (th != null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append('\n');
                    sb2.append(th);
                    string = sb2.toString();
                    if (string == null) {
                        string = "";
                    }
                }
                sb.append(string);
                textView2.setText(sb.toString());
                TextView textView3 = this.binding.f2361b;
                m.checkNotNullExpressionValue(textView3, "binding.logMessage");
                textView3.setMaxLines(2);
                LinearLayout linearLayout = this.binding.a;
                m.checkNotNullExpressionValue(linearLayout, "binding.root");
                ViewExtensions.setOnLongClickListenerConsumeClick(linearLayout, new WidgetDebugging$Adapter$Item$onConfigure$2(this));
                this.itemView.setOnClickListener(new WidgetDebugging$Adapter$Item$onConfigure$3(this));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Adapter(RecyclerView recyclerView) {
            super(recyclerView, false, 2, null);
            m.checkNotNullParameter(recyclerView, "recycler");
            setOnUpdated(new AnonymousClass1(recyclerView));
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple, com.discord.utilities.mg_recycler.MGRecyclerAdapter
        public /* bridge */ /* synthetic */ MGRecyclerDataPayload getItem(int i) {
            return getItem(i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return onCreateViewHolder(viewGroup, i);
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple, com.discord.utilities.mg_recycler.MGRecyclerAdapter
        public /* bridge */ /* synthetic */ Object getItem(int i) {
            return getItem(i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public MGRecyclerViewHolder<?, AppLog.LoggedItem> onCreateViewHolder(ViewGroup parent, int viewType) {
            m.checkNotNullParameter(parent, "parent");
            if (viewType == 0) {
                return new Item(R.layout.widget_debugging_adapter_item, this);
            }
            throw invalidViewTypeException(viewType);
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple, com.discord.utilities.mg_recycler.MGRecyclerAdapter
        public AppLog.LoggedItem getItem(int position) {
            return getInternalData().get((getInternalData().size() - 1) - position);
        }
    }

    /* compiled from: WidgetDebugging.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            m.checkNotNullParameter(context, "context");
            j.e(context, WidgetDebugging.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetDebugging.kt */
    public static final /* data */ class Model {
        private final boolean isFiltered;
        private final List<AppLog.LoggedItem> logs;

        public Model(List<AppLog.LoggedItem> list, boolean z2) {
            m.checkNotNullParameter(list, "logs");
            this.logs = list;
            this.isFiltered = z2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Model copy$default(Model model, List list, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = model.logs;
            }
            if ((i & 2) != 0) {
                z2 = model.isFiltered;
            }
            return model.copy(list, z2);
        }

        public final List<AppLog.LoggedItem> component1() {
            return this.logs;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsFiltered() {
            return this.isFiltered;
        }

        public final Model copy(List<AppLog.LoggedItem> logs, boolean isFiltered) {
            m.checkNotNullParameter(logs, "logs");
            return new Model(logs, isFiltered);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return m.areEqual(this.logs, model.logs) && this.isFiltered == model.isFiltered;
        }

        public final List<AppLog.LoggedItem> getLogs() {
            return this.logs;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            List<AppLog.LoggedItem> list = this.logs;
            int iHashCode = (list != null ? list.hashCode() : 0) * 31;
            boolean z2 = this.isFiltered;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode + i;
        }

        public final boolean isFiltered() {
            return this.isFiltered;
        }

        public String toString() {
            StringBuilder sbU = a.U("Model(logs=");
            sbU.append(this.logs);
            sbU.append(", isFiltered=");
            return a.O(sbU, this.isFiltered, ")");
        }
    }

    /* compiled from: WidgetDebugging.kt */
    /* renamed from: com.discord.widgets.debugging.WidgetDebugging$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2> implements Action2<MenuItem, Context> {
        public AnonymousClass1() {
        }

        @Override // rx.functions.Action2
        public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
            call2(menuItem, context);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(MenuItem menuItem, Context context) {
            m.checkNotNullExpressionValue(menuItem, "menuItem");
            if (menuItem.getItemId() != R.id.menu_debugging_filter) {
                return;
            }
            boolean z2 = !menuItem.isChecked();
            menuItem.setChecked(z2);
            WidgetDebugging.access$getFilterSubject$p(WidgetDebugging.this).onNext(Boolean.valueOf(z2));
        }
    }

    /* compiled from: WidgetDebugging.kt */
    /* renamed from: com.discord.widgets.debugging.WidgetDebugging$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements Action1<Menu> {
        public final /* synthetic */ Model $model;

        public AnonymousClass2(Model model) {
            this.$model = model;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Menu menu) {
            call2(menu);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Menu menu) {
            MenuItem menuItemFindItem = menu.findItem(R.id.menu_debugging_filter);
            m.checkNotNullExpressionValue(menuItemFindItem, "menu.findItem(R.id.menu_debugging_filter)");
            menuItemFindItem.setChecked(this.$model.isFiltered());
        }
    }

    /* compiled from: WidgetDebugging.kt */
    /* renamed from: com.discord.widgets.debugging.WidgetDebugging$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<List<AppLog.LoggedItem>, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Boolean call(List<AppLog.LoggedItem> list) {
            return call2(list);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(List<AppLog.LoggedItem> list) {
            m.checkNotNullExpressionValue(list, "it");
            return Boolean.valueOf(!list.isEmpty());
        }
    }

    /* compiled from: WidgetDebugging.kt */
    /* renamed from: com.discord.widgets.debugging.WidgetDebugging$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2<T1, T2, R> implements Func2<List<? extends AppLog.LoggedItem>, List<AppLog.LoggedItem>, List<? extends AppLog.LoggedItem>> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ List<? extends AppLog.LoggedItem> call(List<? extends AppLog.LoggedItem> list, List<AppLog.LoggedItem> list2) {
            return call2((List<AppLog.LoggedItem>) list, list2);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final List<AppLog.LoggedItem> call2(List<AppLog.LoggedItem> list, List<AppLog.LoggedItem> list2) {
            m.checkNotNullExpressionValue(list, "existingLogs");
            m.checkNotNullExpressionValue(list2, "newLogs");
            return u.plus((Collection) list, (Iterable) list2);
        }
    }

    /* compiled from: WidgetDebugging.kt */
    /* renamed from: com.discord.widgets.debugging.WidgetDebugging$onViewBoundOrOnResume$3, reason: invalid class name */
    public static final class AnonymousClass3<T1, T2, R> implements Func2<List<? extends AppLog.LoggedItem>, Boolean, Model> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ Model call(List<? extends AppLog.LoggedItem> list, Boolean bool) {
            return call2((List<AppLog.LoggedItem>) list, bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Model call2(List<AppLog.LoggedItem> list, Boolean bool) {
            m.checkNotNullExpressionValue(bool, "isFiltered");
            if (bool.booleanValue()) {
                ArrayList arrayListA0 = a.a0(list, "logs");
                for (Object obj : list) {
                    if (((AppLog.LoggedItem) obj).priority > 2) {
                        arrayListA0.add(obj);
                    }
                }
                list = arrayListA0;
            }
            m.checkNotNullExpressionValue(list, "filteredLogs");
            return new Model(list, bool.booleanValue());
        }
    }

    /* compiled from: WidgetDebugging.kt */
    /* renamed from: com.discord.widgets.debugging.WidgetDebugging$onViewBoundOrOnResume$4, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass4 extends k implements Function1<Model, Unit> {
        public AnonymousClass4(WidgetDebugging widgetDebugging) {
            super(1, widgetDebugging, WidgetDebugging.class, "configureUI", "configureUI(Lcom/discord/widgets/debugging/WidgetDebugging$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            m.checkNotNullParameter(model, "p1");
            WidgetDebugging.access$configureUI((WidgetDebugging) this.receiver, model);
        }
    }

    public WidgetDebugging() {
        super(R.layout.widget_debugging);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetDebugging$binding$2.INSTANCE, null, 2, null);
        this.filterSubject = BehaviorSubject.l0(Boolean.TRUE);
    }

    public static final /* synthetic */ void access$configureUI(WidgetDebugging widgetDebugging, Model model) {
        widgetDebugging.configureUI(model);
    }

    public static final /* synthetic */ BehaviorSubject access$getFilterSubject$p(WidgetDebugging widgetDebugging) {
        return widgetDebugging.filterSubject;
    }

    private final void configureUI(Model model) {
        Adapter adapter = this.logsAdapter;
        if (adapter != null) {
            adapter.setData(model.getLogs());
        }
        setActionBarOptionsMenu(R.menu.menu_debugging, new AnonymousClass1(), new AnonymousClass2(model));
    }

    private final WidgetDebuggingBinding getBinding() {
        return (WidgetDebuggingBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f2362b;
        m.checkNotNullExpressionValue(recyclerView, "binding.debuggingLogs");
        this.logsAdapter = (Adapter) companion.configure(new Adapter(recyclerView));
        RecyclerView recyclerView2 = getBinding().f2362b;
        m.checkNotNullExpressionValue(recyclerView2, "binding.debuggingLogs");
        RecyclerView.LayoutManager layoutManager = recyclerView2.getLayoutManager();
        Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setSmoothScrollbarEnabled(true);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(R.string.debug);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Objects.requireNonNull(AppLog.g);
        Observable observableR = ObservableExtensionsKt.computationBuffered(AppLog.logsSubject).r();
        m.checkNotNullExpressionValue(observableR, "logsSubject\n          .c…  .distinctUntilChanged()");
        Observable observableJ = Observable.j(observableR.a(200L, TimeUnit.MILLISECONDS).y(AnonymousClass1.INSTANCE).Q(new ArrayList(), AnonymousClass2.INSTANCE), this.filterSubject.r(), AnonymousClass3.INSTANCE);
        m.checkNotNullExpressionValue(observableJ, "Observable\n        .comb…gs, isFiltered)\n        }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationBuffered(observableJ), this, null, 2, null), WidgetDebugging.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass4(this), 62, (Object) null);
    }
}
