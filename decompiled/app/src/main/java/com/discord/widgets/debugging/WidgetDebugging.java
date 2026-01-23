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
import com.discord.C5419R;
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
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
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
import p007b.p008a.p018d.AppScreen2;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p641k.Func1;
import p658rx.Observable;
import p658rx.functions.Action1;
import p658rx.functions.Action2;
import p658rx.functions.Func2;
import p658rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetDebugging.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDebugging extends AppFragment {
    private static final int COLLAPSED_MAX_LINES = 2;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final BehaviorSubject<Boolean> filterSubject;
    private Adapter logsAdapter;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetDebugging.class, "binding", "getBinding()Lcom/discord/databinding/WidgetDebuggingBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: WidgetDebugging.kt */
    public static final class Adapter extends MGRecyclerAdapterSimple<AppLog.LoggedItem> {

        /* JADX INFO: renamed from: com.discord.widgets.debugging.WidgetDebugging$Adapter$1 */
        /* JADX INFO: compiled from: WidgetDebugging.kt */
        public static final class C82631 extends Lambda implements Function2<List<? extends AppLog.LoggedItem>, List<? extends AppLog.LoggedItem>, Unit> {
            public final /* synthetic */ RecyclerView $recycler;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C82631(RecyclerView recyclerView) {
                super(2);
                this.$recycler = recyclerView;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends AppLog.LoggedItem> list, List<? extends AppLog.LoggedItem> list2) {
                invoke2((List<AppLog.LoggedItem>) list, (List<AppLog.LoggedItem>) list2);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<AppLog.LoggedItem> list, List<AppLog.LoggedItem> list2) {
                Intrinsics3.checkNotNullParameter(list, "<anonymous parameter 0>");
                Intrinsics3.checkNotNullParameter(list2, "<anonymous parameter 1>");
                RecyclerView.LayoutManager layoutManager = this.$recycler.getLayoutManager();
                Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                if (((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition() == 0) {
                    this.$recycler.scrollToPosition(0);
                }
            }
        }

        /* JADX INFO: compiled from: WidgetDebugging.kt */
        public static final class Item extends MGRecyclerViewHolder<Adapter, AppLog.LoggedItem> {
            private final WidgetDebuggingAdapterItemBinding binding;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Item(@LayoutRes int i, Adapter adapter) {
                super(i, adapter);
                Intrinsics3.checkNotNullParameter(adapter, "adapter");
                View view = this.itemView;
                TextView textView = (TextView) view.findViewById(C5419R.id.log_message);
                if (textView == null) {
                    throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C5419R.id.log_message)));
                }
                WidgetDebuggingAdapterItemBinding widgetDebuggingAdapterItemBinding = new WidgetDebuggingAdapterItemBinding((LinearLayout) view, textView);
                Intrinsics3.checkNotNullExpressionValue(widgetDebuggingAdapterItemBinding, "WidgetDebuggingAdapterItemBinding.bind(itemView)");
                this.binding = widgetDebuggingAdapterItemBinding;
            }

            public static final /* synthetic */ WidgetDebuggingAdapterItemBinding access$getBinding$p(Item item) {
                return item.binding;
            }

            @ColorInt
            private final int getColor(Context context, int priority) {
                return priority != 2 ? priority != 3 ? priority != 5 ? priority != 6 ? ColorCompat.getThemedColor(context, C5419R.attr.primary_100) : ColorCompat.getColor(context, C5419R.color.status_red_500) : ColorCompat.getColor(context, C5419R.color.status_yellow_500) : ColorCompat.getColor(context, C5419R.color.status_green_600) : ColorCompat.getThemedColor(context, C5419R.attr.primary_300);
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
            public /* bridge */ /* synthetic */ void onConfigure(int i, AppLog.LoggedItem loggedItem) {
                onConfigure2(i, loggedItem);
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0046  */
            @SuppressLint({"SetTextI18n"})
            /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onConfigure2(int position, AppLog.LoggedItem data) {
                String string;
                Intrinsics3.checkNotNullParameter(data, "data");
                super.onConfigure(position, data);
                TextView textView = this.binding.f16448b;
                textView.setTextColor(getColor(outline.m821I(textView, "binding.logMessage", "binding.logMessage.context"), data.priority));
                TextView textView2 = this.binding.f16448b;
                Intrinsics3.checkNotNullExpressionValue(textView2, "binding.logMessage");
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
                TextView textView3 = this.binding.f16448b;
                Intrinsics3.checkNotNullExpressionValue(textView3, "binding.logMessage");
                textView3.setMaxLines(2);
                LinearLayout linearLayout = this.binding.f16447a;
                Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.root");
                ViewExtensions.setOnLongClickListenerConsumeClick(linearLayout, new WidgetDebugging2(this));
                this.itemView.setOnClickListener(new WidgetDebugging3(this));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Adapter(RecyclerView recyclerView) {
            super(recyclerView, false, 2, null);
            Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
            setOnUpdated(new C82631(recyclerView));
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
            Intrinsics3.checkNotNullParameter(parent, "parent");
            if (viewType == 0) {
                return new Item(C5419R.layout.widget_debugging_adapter_item, this);
            }
            throw invalidViewTypeException(viewType);
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple, com.discord.utilities.mg_recycler.MGRecyclerAdapter
        public AppLog.LoggedItem getItem(int position) {
            return getInternalData().get((getInternalData().size() - 1) - position);
        }
    }

    /* JADX INFO: compiled from: WidgetDebugging.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.m157e(context, WidgetDebugging.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetDebugging.kt */
    public static final /* data */ class Model {
        private final boolean isFiltered;
        private final List<AppLog.LoggedItem> logs;

        public Model(List<AppLog.LoggedItem> list, boolean z2) {
            Intrinsics3.checkNotNullParameter(list, "logs");
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

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsFiltered() {
            return this.isFiltered;
        }

        public final Model copy(List<AppLog.LoggedItem> logs, boolean isFiltered) {
            Intrinsics3.checkNotNullParameter(logs, "logs");
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
            return Intrinsics3.areEqual(this.logs, model.logs) && this.isFiltered == model.isFiltered;
        }

        public final List<AppLog.LoggedItem> getLogs() {
            return this.logs;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v3 */
        public int hashCode() {
            List<AppLog.LoggedItem> list = this.logs;
            int iHashCode = (list != null ? list.hashCode() : 0) * 31;
            boolean z2 = this.isFiltered;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return iHashCode + r1;
        }

        public final boolean isFiltered() {
            return this.isFiltered;
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("Model(logs=");
            sbM833U.append(this.logs);
            sbM833U.append(", isFiltered=");
            return outline.m827O(sbM833U, this.isFiltered, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.debugging.WidgetDebugging$configureUI$1 */
    /* JADX INFO: compiled from: WidgetDebugging.kt */
    public static final class C82641<T1, T2> implements Action2<MenuItem, Context> {
        public C82641() {
        }

        @Override // p658rx.functions.Action2
        public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
            call2(menuItem, context);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(MenuItem menuItem, Context context) {
            Intrinsics3.checkNotNullExpressionValue(menuItem, "menuItem");
            if (menuItem.getItemId() != C5419R.id.menu_debugging_filter) {
                return;
            }
            boolean z2 = !menuItem.isChecked();
            menuItem.setChecked(z2);
            WidgetDebugging.access$getFilterSubject$p(WidgetDebugging.this).onNext(Boolean.valueOf(z2));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.debugging.WidgetDebugging$configureUI$2 */
    /* JADX INFO: compiled from: WidgetDebugging.kt */
    public static final class C82652<T> implements Action1<Menu> {
        public final /* synthetic */ Model $model;

        public C82652(Model model) {
            this.$model = model;
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Menu menu) {
            call2(menu);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Menu menu) {
            MenuItem menuItemFindItem = menu.findItem(C5419R.id.menu_debugging_filter);
            Intrinsics3.checkNotNullExpressionValue(menuItemFindItem, "menu.findItem(R.id.menu_debugging_filter)");
            menuItemFindItem.setChecked(this.$model.isFiltered());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.debugging.WidgetDebugging$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetDebugging.kt */
    public static final class C82661<T, R> implements Func1<List<AppLog.LoggedItem>, Boolean> {
        public static final C82661 INSTANCE = new C82661();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Boolean call(List<AppLog.LoggedItem> list) {
            return call2(list);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(List<AppLog.LoggedItem> list) {
            Intrinsics3.checkNotNullExpressionValue(list, "it");
            return Boolean.valueOf(!list.isEmpty());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.debugging.WidgetDebugging$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetDebugging.kt */
    public static final class C82672<T1, T2, R> implements Func2<List<? extends AppLog.LoggedItem>, List<AppLog.LoggedItem>, List<? extends AppLog.LoggedItem>> {
        public static final C82672 INSTANCE = new C82672();

        @Override // p658rx.functions.Func2
        public /* bridge */ /* synthetic */ List<? extends AppLog.LoggedItem> call(List<? extends AppLog.LoggedItem> list, List<AppLog.LoggedItem> list2) {
            return call2((List<AppLog.LoggedItem>) list, list2);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final List<AppLog.LoggedItem> call2(List<AppLog.LoggedItem> list, List<AppLog.LoggedItem> list2) {
            Intrinsics3.checkNotNullExpressionValue(list, "existingLogs");
            Intrinsics3.checkNotNullExpressionValue(list2, "newLogs");
            return _Collections.plus((Collection) list, (Iterable) list2);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.debugging.WidgetDebugging$onViewBoundOrOnResume$3 */
    /* JADX INFO: compiled from: WidgetDebugging.kt */
    public static final class C82683<T1, T2, R> implements Func2<List<? extends AppLog.LoggedItem>, Boolean, Model> {
        public static final C82683 INSTANCE = new C82683();

        @Override // p658rx.functions.Func2
        public /* bridge */ /* synthetic */ Model call(List<? extends AppLog.LoggedItem> list, Boolean bool) {
            return call2((List<AppLog.LoggedItem>) list, bool);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final Model call2(List<AppLog.LoggedItem> list, Boolean bool) {
            Intrinsics3.checkNotNullExpressionValue(bool, "isFiltered");
            if (bool.booleanValue()) {
                ArrayList arrayListM840a0 = outline.m840a0(list, "logs");
                for (Object obj : list) {
                    if (((AppLog.LoggedItem) obj).priority > 2) {
                        arrayListM840a0.add(obj);
                    }
                }
                list = arrayListM840a0;
            }
            Intrinsics3.checkNotNullExpressionValue(list, "filteredLogs");
            return new Model(list, bool.booleanValue());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.debugging.WidgetDebugging$onViewBoundOrOnResume$4 */
    /* JADX INFO: compiled from: WidgetDebugging.kt */
    public static final /* synthetic */ class C82694 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public C82694(WidgetDebugging widgetDebugging) {
            super(1, widgetDebugging, WidgetDebugging.class, "configureUI", "configureUI(Lcom/discord/widgets/debugging/WidgetDebugging$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            Intrinsics3.checkNotNullParameter(model, "p1");
            WidgetDebugging.access$configureUI((WidgetDebugging) this.receiver, model);
        }
    }

    public WidgetDebugging() {
        super(C5419R.layout.widget_debugging);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetDebugging4.INSTANCE, null, 2, null);
        this.filterSubject = BehaviorSubject.m11130l0(Boolean.TRUE);
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
        setActionBarOptionsMenu(C5419R.menu.menu_debugging, new C82641(), new C82652(model));
    }

    private final WidgetDebuggingBinding getBinding() {
        return (WidgetDebuggingBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f16450b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.debuggingLogs");
        this.logsAdapter = (Adapter) companion.configure(new Adapter(recyclerView));
        RecyclerView recyclerView2 = getBinding().f16450b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.debuggingLogs");
        RecyclerView.LayoutManager layoutManager = recyclerView2.getLayoutManager();
        Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setSmoothScrollbarEnabled(true);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(C5419R.string.debug);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Objects.requireNonNull(AppLog.f14950g);
        Observable observableM11112r = ObservableExtensionsKt.computationBuffered(AppLog.logsSubject).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "logsSubject\n          .c…  .distinctUntilChanged()");
        Observable observableM11076j = Observable.m11076j(observableM11112r.m11101a(200L, TimeUnit.MILLISECONDS).m11118y(C82661.INSTANCE).m11091Q(new ArrayList(), C82672.INSTANCE), this.filterSubject.m11112r(), C82683.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11076j, "Observable\n        .comb…gs, isFiltered)\n        }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationBuffered(observableM11076j), this, null, 2, null), WidgetDebugging.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C82694(this), 62, (Object) null);
    }
}
