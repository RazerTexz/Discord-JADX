package com.discord.widgets.settings.developer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.app.AppLog;
import com.discord.databinding.IconListItemTextViewBinding;
import com.discord.databinding.WidgetSettingsDeveloperBinding;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreStream;
import com.discord.utilities.bugreports.BugReportManager;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.experiments.ExperimentRegistry;
import com.discord.utilities.experiments.ExperimentRegistry2;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import com.discord.utilities.views.SwipeableItemTouchHelper;
import com.discord.views.CheckedSetting;
import com.hammerandchisel.libdiscord.Discord;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p018d.AppToast;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.Iterables2;
import p507d0.p580t.MapsJVM;
import p507d0.p580t._Maps;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p641k.Func1;
import p658rx.Observable;
import p658rx.functions.Action1;

/* compiled from: WidgetSettingsDeveloper.kt */
/* loaded from: classes2.dex */
public final class WidgetSettingsDeveloper extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetSettingsDeveloper.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsDeveloperBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private ExperimentOverridesAdapter experimentOverridesAdapter;

    /* compiled from: WidgetSettingsDeveloper.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.m157e(context, WidgetSettingsDeveloper.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetSettingsDeveloper.kt */
    public static final class NoticeViewHolder extends SimpleRecyclerAdapter.ViewHolder<Tuples2<? extends String, ? extends Long>> {
        private final IconListItemTextViewBinding binding;
        public String noticeName;

        /* JADX WARN: Illegal instructions before constructor call */
        public NoticeViewHolder(IconListItemTextViewBinding iconListItemTextViewBinding) {
            Intrinsics3.checkNotNullParameter(iconListItemTextViewBinding, "binding");
            TextView textView = iconListItemTextViewBinding.f15165a;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.root");
            super(textView);
            this.binding = iconListItemTextViewBinding;
        }

        @Override // com.discord.utilities.views.SimpleRecyclerAdapter.ViewHolder
        public /* bridge */ /* synthetic */ void bind(Tuples2<? extends String, ? extends Long> tuples2) {
            bind2((Tuples2<String, Long>) tuples2);
        }

        public final String getNoticeName() {
            String str = this.noticeName;
            if (str == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("noticeName");
            }
            return str;
        }

        public final void setNoticeName(String str) {
            Intrinsics3.checkNotNullParameter(str, "<set-?>");
            this.noticeName = str;
        }

        @SuppressLint({"SetTextI18n"})
        /* renamed from: bind, reason: avoid collision after fix types in other method */
        public void bind2(Tuples2<String, Long> data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            String strComponent1 = data.component1();
            long jLongValue = data.component2().longValue();
            this.noticeName = strComponent1;
            TextView textView = this.binding.f15165a;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.root");
            Context context = textView.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "binding.root.context");
            CharSequence readableTimeString$default = TimeUtils.toReadableTimeString$default(context, jLongValue, null, 4, null);
            TextView textView2 = this.binding.f15165a;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.root");
            textView2.setText(strComponent1 + " @ " + readableTimeString$default);
        }
    }

    /* compiled from: WidgetSettingsDeveloper.kt */
    /* renamed from: com.discord.widgets.settings.developer.WidgetSettingsDeveloper$setupCrashes$1 */
    public static final class ViewOnClickListenerC98441 implements View.OnClickListener {
        public static final ViewOnClickListenerC98441 INSTANCE = new ViewOnClickListenerC98441();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            throw new RuntimeException("This is a developer triggered crash.");
        }
    }

    /* compiled from: WidgetSettingsDeveloper.kt */
    /* renamed from: com.discord.widgets.settings.developer.WidgetSettingsDeveloper$setupCrashes$2 */
    public static final class ViewOnClickListenerC98452 implements View.OnClickListener {
        public ViewOnClickListenerC98452() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            try {
                throw new RuntimeException("This is a developer triggered crash (caught).");
            } catch (Exception e) {
                Logger.e$default(AppLog.f14950g, "setupCrashes", e, null, 4, null);
                AppToast.m172j(WidgetSettingsDeveloper.this, "Done.", 0, 4);
            }
        }
    }

    /* compiled from: WidgetSettingsDeveloper.kt */
    /* renamed from: com.discord.widgets.settings.developer.WidgetSettingsDeveloper$setupCrashes$3 */
    public static final class ViewOnClickListenerC98463 implements View.OnClickListener {
        public ViewOnClickListenerC98463() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Context context = WidgetSettingsDeveloper.this.getContext();
            Objects.requireNonNull(context, "null cannot be cast to non-null type android.content.Context");
            new Discord(context).crash();
        }
    }

    /* compiled from: WidgetSettingsDeveloper.kt */
    /* renamed from: com.discord.widgets.settings.developer.WidgetSettingsDeveloper$setupCrashes$4 */
    public static final class ViewOnClickListenerC98474 implements View.OnClickListener {
        public ViewOnClickListenerC98474() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            StoreStream.INSTANCE.getGatewaySocket().simulateReconnectForTesting();
            AppToast.m172j(WidgetSettingsDeveloper.this, "Done.", 0, 4);
        }
    }

    /* compiled from: WidgetSettingsDeveloper.kt */
    /* renamed from: com.discord.widgets.settings.developer.WidgetSettingsDeveloper$setupExperimentSection$1 */
    public static final class C98481<T, R> implements Func1<Map<String, ? extends Integer>, List<? extends 1.1>> {
        public final /* synthetic */ StoreExperiments $experimentStore;

        public C98481(StoreExperiments storeExperiments) {
            this.$experimentStore = storeExperiments;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ List<? extends 1.1> call(Map<String, ? extends Integer> map) {
            return call2((Map<String, Integer>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final List<1.1> call2(Map<String, Integer> map) {
            Collection<ExperimentRegistry2> collectionValues = ExperimentRegistry.INSTANCE.getRegisteredExperiments().values();
            Intrinsics3.checkNotNullExpressionValue(collectionValues, "ExperimentRegistry\n     …nts\n              .values");
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(collectionValues, 10));
            Iterator<T> it = collectionValues.iterator();
            while (it.hasNext()) {
                arrayList.add(new WidgetSettingsDeveloper3((ExperimentRegistry2) it.next(), this, map));
            }
            return arrayList;
        }
    }

    /* compiled from: WidgetSettingsDeveloper.kt */
    /* renamed from: com.discord.widgets.settings.developer.WidgetSettingsDeveloper$setupExperimentSection$2 */
    public static final class C98502 extends Lambda implements Function1<List<? extends C98481.1.1>, Unit> {
        public C98502() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends C98481.1.1> list) {
            invoke2((List<C98481.1.1>) list);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<C98481.1.1> list) {
            ExperimentOverridesAdapter experimentOverridesAdapterAccess$getExperimentOverridesAdapter$p = WidgetSettingsDeveloper.access$getExperimentOverridesAdapter$p(WidgetSettingsDeveloper.this);
            Intrinsics3.checkNotNullExpressionValue(list, "data");
            experimentOverridesAdapterAccess$getExperimentOverridesAdapter$p.setData(list);
        }
    }

    /* compiled from: WidgetSettingsDeveloper.kt */
    /* renamed from: com.discord.widgets.settings.developer.WidgetSettingsDeveloper$setupNoticesSection$1 */
    public static final class C98511 extends Lambda implements Function0<ItemTouchHelper> {

        /* compiled from: WidgetSettingsDeveloper.kt */
        /* renamed from: com.discord.widgets.settings.developer.WidgetSettingsDeveloper$setupNoticesSection$1$1, reason: invalid class name */
        public static final class AnonymousClass1 extends SwipeableItemTouchHelper {
            public final /* synthetic */ SwipeableItemTouchHelper.SwipeRevealConfiguration $deleteConfig;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(SwipeableItemTouchHelper.SwipeRevealConfiguration swipeRevealConfiguration, SwipeableItemTouchHelper.SwipeRevealConfiguration swipeRevealConfiguration2, SwipeableItemTouchHelper.SwipeRevealConfiguration swipeRevealConfiguration3) {
                super(0, 0, swipeRevealConfiguration2, swipeRevealConfiguration3, 3, null);
                this.$deleteConfig = swipeRevealConfiguration;
            }

            @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                Intrinsics3.checkNotNullParameter(viewHolder, "viewHolder");
                if (viewHolder instanceof NoticeViewHolder) {
                    StoreStream.INSTANCE.getNotices().clearSeen(((NoticeViewHolder) viewHolder).getNoticeName());
                }
            }
        }

        public C98511() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ ItemTouchHelper invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ItemTouchHelper invoke() {
            SwipeableItemTouchHelper.SwipeRevealConfiguration swipeRevealConfiguration = new SwipeableItemTouchHelper.SwipeRevealConfiguration(ColorCompat.getColor(WidgetSettingsDeveloper.this, C5419R.color.status_red_500), ContextCompat.getDrawable(WidgetSettingsDeveloper.this.requireContext(), C5419R.drawable.ic_delete_white_24dp), DimenUtils.dpToPixels(8));
            return new ItemTouchHelper(new AnonymousClass1(swipeRevealConfiguration, swipeRevealConfiguration, swipeRevealConfiguration));
        }
    }

    /* compiled from: WidgetSettingsDeveloper.kt */
    /* renamed from: com.discord.widgets.settings.developer.WidgetSettingsDeveloper$setupNoticesSection$2 */
    public static final class C98522<T, R> implements Func1<HashMap<String, Long>, List<? extends Tuples2<? extends String, ? extends Long>>> {
        public static final C98522 INSTANCE = new C98522();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ List<? extends Tuples2<? extends String, ? extends Long>> call(HashMap<String, Long> map) {
            return call2(map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final List<Tuples2<String, Long>> call2(HashMap<String, Long> map) {
            Intrinsics3.checkNotNullExpressionValue(map, "noticesSeenMap");
            return _Maps.toList(MapsJVM.toSortedMap(map));
        }
    }

    /* compiled from: WidgetSettingsDeveloper.kt */
    /* renamed from: com.discord.widgets.settings.developer.WidgetSettingsDeveloper$setupNoticesSection$3 */
    public static final class C98533 extends Lambda implements Function1<List<? extends Tuples2<? extends String, ? extends Long>>, Unit> {
        public final /* synthetic */ SimpleRecyclerAdapter $noticesAdapter;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C98533(SimpleRecyclerAdapter simpleRecyclerAdapter) {
            super(1);
            this.$noticesAdapter = simpleRecyclerAdapter;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends Tuples2<? extends String, ? extends Long>> list) {
            invoke2((List<Tuples2<String, Long>>) list);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<Tuples2<String, Long>> list) {
            SimpleRecyclerAdapter simpleRecyclerAdapter = this.$noticesAdapter;
            Intrinsics3.checkNotNullExpressionValue(list, "noticesSeenMap");
            simpleRecyclerAdapter.setData(list);
        }
    }

    /* compiled from: WidgetSettingsDeveloper.kt */
    /* renamed from: com.discord.widgets.settings.developer.WidgetSettingsDeveloper$setupScreenshotDetector$1 */
    public static final class C98541<T> implements Action1<Boolean> {
        public final /* synthetic */ BugReportManager $bugReportProvider;

        public C98541(BugReportManager bugReportManager) {
            this.$bugReportProvider = bugReportManager;
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Boolean bool) {
            call2(bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Boolean bool) {
            BugReportManager bugReportManager = this.$bugReportProvider;
            Intrinsics3.checkNotNullExpressionValue(bool, "isChecked");
            bugReportManager.setBugReportingSettingEnabled(bool.booleanValue());
        }
    }

    public WidgetSettingsDeveloper() {
        super(C5419R.layout.widget_settings_developer);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSettingsDeveloper2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ ExperimentOverridesAdapter access$getExperimentOverridesAdapter$p(WidgetSettingsDeveloper widgetSettingsDeveloper) {
        ExperimentOverridesAdapter experimentOverridesAdapter = widgetSettingsDeveloper.experimentOverridesAdapter;
        if (experimentOverridesAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("experimentOverridesAdapter");
        }
        return experimentOverridesAdapter;
    }

    public static final /* synthetic */ void access$setExperimentOverridesAdapter$p(WidgetSettingsDeveloper widgetSettingsDeveloper, ExperimentOverridesAdapter experimentOverridesAdapter) {
        widgetSettingsDeveloper.experimentOverridesAdapter = experimentOverridesAdapter;
    }

    private final WidgetSettingsDeveloperBinding getBinding() {
        return (WidgetSettingsDeveloperBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void launch(Context context) {
        INSTANCE.launch(context);
    }

    private final void setupCrashes() {
        getBinding().f17938d.setOnClickListener(ViewOnClickListenerC98441.INSTANCE);
        getBinding().f17937c.setOnClickListener(new ViewOnClickListenerC98452());
        getBinding().f17936b.setOnClickListener(new ViewOnClickListenerC98463());
        getBinding().f17941g.setOnClickListener(new ViewOnClickListenerC98474());
    }

    private final void setupExperimentSection() {
        this.experimentOverridesAdapter = new ExperimentOverridesAdapter();
        RecyclerView recyclerView = getBinding().f17939e;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.developerSettingsExperiments");
        ExperimentOverridesAdapter experimentOverridesAdapter = this.experimentOverridesAdapter;
        if (experimentOverridesAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("experimentOverridesAdapter");
        }
        recyclerView.setAdapter(experimentOverridesAdapter);
        StoreExperiments experiments = StoreStream.INSTANCE.getExperiments();
        Observable<R> observableM11083G = experiments.observeOverrides().m11083G(new C98481(experiments));
        Intrinsics3.checkNotNullExpressionValue(observableM11083G, "experimentStore\n        …              }\n        }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableM11083G, this, null, 2, null), WidgetSettingsDeveloper.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C98502(), 62, (Object) null);
    }

    private final void setupNoticesSection() {
        SimpleRecyclerAdapter simpleRecyclerAdapter = new SimpleRecyclerAdapter(null, WidgetSettingsDeveloper4.INSTANCE, 1, null);
        RecyclerView recyclerView = getBinding().f17940f;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.developerSettingsNotices");
        recyclerView.setAdapter(simpleRecyclerAdapter);
        new C98511().invoke().attachToRecyclerView(getBinding().f17940f);
        Observable<R> observableM11083G = StoreStream.INSTANCE.getNotices().observeNoticesSeen().m11083G(C98522.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11083G, "StoreStream\n        .get…      .toList()\n        }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableM11083G), this, null, 2, null), WidgetSettingsDeveloper.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C98533(simpleRecyclerAdapter), 62, (Object) null);
    }

    private final void setupScreenshotDetector() {
        BugReportManager bugReportManager = BugReportManager.INSTANCE.get();
        CheckedSetting checkedSetting = getBinding().f17942h;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.settingsDeveloperScreenshotBugReporting");
        checkedSetting.setChecked(bugReportManager.getSettingsEnabled());
        getBinding().f17942h.setOnCheckedListener(new C98541(bugReportManager));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarDisplayHomeAsUpEnabled(true);
        setActionBarTitle(C5419R.string.developer_options);
        setupCrashes();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        setupScreenshotDetector();
        setupExperimentSection();
        setupNoticesSection();
    }
}
