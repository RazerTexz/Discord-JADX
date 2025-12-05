package com.discord.widgets.servers.guildboost;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.discord.C5419R;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerBoostStatusBinding;
import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.billing.GooglePlayBillingManager;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.premium.GuildBoostUtils;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.simple_pager.SimplePager;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.servers.WidgetServerSettingsChannels;
import com.discord.widgets.servers.guildboost.GuildBoostViewModel;
import com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoost;
import com.discord.widgets.settings.premium.WidgetChoosePlan;
import com.discord.widgets.settings.premium.WidgetSettingsPremium;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppHelpDesk;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p018d.AppToast;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.Tuples;
import p507d0.p580t.Collections2;
import p507d0.p580t.MapsJVM;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;
import p658rx.Observable;
import p658rx.functions.Action2;

/* compiled from: WidgetGuildBoost.kt */
/* loaded from: classes2.dex */
public final class WidgetGuildBoost extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetGuildBoost.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerBoostStatusBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "GUILD_ID";
    private static final int VIEW_INDEX_LOADED = 2;
    private static final int VIEW_INDEX_LOADING = 0;
    private static final int VIEW_INDEX_LOAD_FAILED = 1;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ActivityResultLauncher<Intent> choosePlanLauncher;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;
    private List<? extends ImageView> levelBackgrounds;
    private List<? extends TextView> levelText;
    private PerksPagerAdapter pagerAdapter;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    private boolean wasPagerPageSet;

    /* compiled from: WidgetGuildBoost.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void create(Context context, long guildId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent().putExtra(WidgetGuildBoost.INTENT_EXTRA_GUILD_ID, guildId);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent().putExtra(INTENT_EXTRA_GUILD_ID, guildId)");
            AppScreen2.m156d(context, WidgetGuildBoost.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGuildBoost.kt */
    public static final class PerksPagerAdapter extends PagerAdapter {
        private long guildId;
        private int premiumTier;
        private int subscriptionCount;

        public PerksPagerAdapter(long j) {
            this.guildId = j;
        }

        public final void configureViews(ViewPager viewPager) {
            Intrinsics3.checkNotNullParameter(viewPager, "viewPager");
            int childCount = viewPager.getChildCount();
            if (childCount <= 0) {
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i + 1;
                View childAt = viewPager.getChildAt(i);
                Intrinsics3.checkNotNullExpressionValue(childAt, "getChildAt(index)");
                Object tag = childAt.getTag();
                Objects.requireNonNull(tag, "null cannot be cast to non-null type kotlin.Int");
                ((GuildBoostPerkView) childAt).configure(((Integer) tag).intValue(), this.premiumTier, this.guildId);
                if (i2 >= childCount) {
                    return;
                } else {
                    i = i2;
                }
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup container, int position, Object view) {
            Intrinsics3.checkNotNullParameter(container, "container");
            Intrinsics3.checkNotNullParameter(view, "view");
            container.removeView((View) view);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return 3;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        public final int getPremiumTier() {
            return this.premiumTier;
        }

        public final int getSubscriptionCount() {
            return this.subscriptionCount;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public /* bridge */ /* synthetic */ Object instantiateItem(ViewGroup viewGroup, int i) {
            return instantiateItem(viewGroup, i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object any) {
            Intrinsics3.checkNotNullParameter(view, "view");
            Intrinsics3.checkNotNullParameter(any, "any");
            return Intrinsics3.areEqual(view, any);
        }

        public final void setGuildId(long j) {
            this.guildId = j;
        }

        public final void setPremiumTier(int i) {
            this.premiumTier = i;
        }

        public final void setSubscriptionCount(int i) {
            this.subscriptionCount = i;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public View instantiateItem(ViewGroup container, int position) {
            Intrinsics3.checkNotNullParameter(container, "container");
            int i = position + 1;
            Context context = container.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "container.context");
            GuildBoostPerkView guildBoostPerkView = new GuildBoostPerkView(context, null, 0, 6, null);
            guildBoostPerkView.configure(i, this.premiumTier, this.guildId);
            guildBoostPerkView.setTag(Integer.valueOf(i));
            container.addView(guildBoostPerkView);
            return guildBoostPerkView;
        }
    }

    /* compiled from: WidgetGuildBoost.kt */
    /* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoost$configureUI$1 */
    public static final class ViewOnClickListenerC95061 implements View.OnClickListener {
        public ViewOnClickListenerC95061() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildBoost.access$getViewModel$p(WidgetGuildBoost.this).retryClicked();
        }
    }

    /* compiled from: WidgetGuildBoost.kt */
    /* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoost$configureUI$2 */
    public static final class C95072 extends Lambda implements Function0<Unit> {
        public C95072() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetSettingsPremium.Companion.launch$default(WidgetSettingsPremium.INSTANCE, WidgetGuildBoost.this.requireContext(), null, null, 6, null);
        }
    }

    /* compiled from: WidgetGuildBoost.kt */
    /* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoost$handleEvent$1 */
    public static final class C95081 extends Lambda implements Function1<View, Unit> {
        public C95081() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            WidgetSettingsPremium.Companion.launch$default(WidgetSettingsPremium.INSTANCE, WidgetGuildBoost.this.requireContext(), null, null, 6, null);
        }
    }

    /* compiled from: WidgetGuildBoost.kt */
    /* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoost$onViewBound$1 */
    public static final class C95091 implements ViewPager.OnPageChangeListener {
        public C95091() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            WidgetGuildBoost.access$configureLevelBubbles(WidgetGuildBoost.this, position + 1);
        }
    }

    /* compiled from: WidgetGuildBoost.kt */
    /* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoost$onViewBound$2 */
    public static final class C95102<T1, T2> implements Action2<MenuItem, Context> {
        public static final C95102 INSTANCE = new C95102();

        @Override // p658rx.functions.Action2
        public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
            call2(menuItem, context);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(MenuItem menuItem, Context context) {
            Intrinsics3.checkNotNullExpressionValue(menuItem, "menuItem");
            if (menuItem.getItemId() != C5419R.id.menu_premium_guild) {
                return;
            }
            WidgetSettingsGuildBoost.Companion companion = WidgetSettingsGuildBoost.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            companion.launch(context);
        }
    }

    /* compiled from: WidgetGuildBoost.kt */
    /* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoost$onViewBound$3 */
    public static final class C95113 extends Lambda implements Function1<RenderContext, Unit> {
        public static final C95113 INSTANCE = new C95113();

        /* compiled from: WidgetGuildBoost.kt */
        /* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoost$onViewBound$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics3.checkNotNullParameter(view, "view");
                WidgetSettingsGuildBoost.Companion companion = WidgetSettingsGuildBoost.INSTANCE;
                Context context = view.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "view.context");
                companion.launch(context);
            }
        }

        public C95113() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.m8423b("learnMore", AnonymousClass1.INSTANCE);
        }
    }

    /* compiled from: WidgetGuildBoost.kt */
    /* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoost$onViewBound$4 */
    public static final class C95124 extends Lambda implements Function1<RenderContext, Unit> {

        /* compiled from: WidgetGuildBoost.kt */
        /* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoost$onViewBound$4$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics3.checkNotNullParameter(view, "view");
                WidgetSettingsPremium.Companion companion = WidgetSettingsPremium.INSTANCE;
                Context context = view.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "view.context");
                WidgetSettingsPremium.Companion.launch$default(companion, context, null, null, 6, null);
            }
        }

        public C95124() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.boldColor = Integer.valueOf(ColorCompat.getColor(WidgetGuildBoost.this.requireContext(), C5419R.color.status_green_600));
            renderContext.m8423b("onLearnMore", AnonymousClass1.INSTANCE);
            renderContext.m8422a("protipHook", AnonymousClass2.INSTANCE);
        }

        /* compiled from: WidgetGuildBoost.kt */
        /* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoost$onViewBound$4$2, reason: invalid class name */
        public static final class AnonymousClass2 extends Lambda implements Function1<Hook, Unit> {
            public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

            public AnonymousClass2() {
                super(1);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Hook hook) {
                Intrinsics3.checkNotNullParameter(hook, "$receiver");
                hook.styles.add(new StyleSpan(1));
                hook.styles.add(new ForegroundColorSpan(-65536));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
                invoke2(hook);
                return Unit.f27425a;
            }
        }
    }

    /* compiled from: WidgetGuildBoost.kt */
    /* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoost$onViewBound$5 */
    public static final class ViewOnClickListenerC95135 implements View.OnClickListener {
        public ViewOnClickListenerC95135() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildBoost.access$getViewModel$p(WidgetGuildBoost.this).subscribeClicked(Traits.Location.Section.HEADER);
        }
    }

    /* compiled from: WidgetGuildBoost.kt */
    /* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoost$onViewBound$6 */
    public static final class ViewOnClickListenerC95146 implements View.OnClickListener {
        public ViewOnClickListenerC95146() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildBoost.access$getViewModel$p(WidgetGuildBoost.this).subscribeClicked(Traits.Location.Section.FOOTER);
        }
    }

    /* compiled from: WidgetGuildBoost.kt */
    /* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoost$onViewBoundOrOnResume$1 */
    public static final /* synthetic */ class C95151 extends FunctionReferenceImpl implements Function1<GuildBoostViewModel.ViewState, Unit> {
        public C95151(WidgetGuildBoost widgetGuildBoost) {
            super(1, widgetGuildBoost, WidgetGuildBoost.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildBoostViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildBoostViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetGuildBoost.access$configureUI((WidgetGuildBoost) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetGuildBoost.kt */
    /* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoost$onViewBoundOrOnResume$2 */
    public static final /* synthetic */ class C95162 extends FunctionReferenceImpl implements Function1<GuildBoostViewModel.Event, Unit> {
        public C95162(WidgetGuildBoost widgetGuildBoost) {
            super(1, widgetGuildBoost, WidgetGuildBoost.class, "handleEvent", "handleEvent(Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildBoostViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildBoostViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            WidgetGuildBoost.access$handleEvent((WidgetGuildBoost) this.receiver, event);
        }
    }

    public WidgetGuildBoost() {
        super(C5419R.layout.widget_server_boost_status);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildBoost2.INSTANCE, null, 2, null);
        WidgetGuildBoost5 widgetGuildBoost5 = new WidgetGuildBoost5(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildBoostViewModel.class), new WidgetGuildBoost$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetGuildBoost5));
        this.choosePlanLauncher = WidgetChoosePlan.INSTANCE.registerForResult(this, new WidgetGuildBoost3(this));
        this.guildId = LazyJVM.lazy(new WidgetGuildBoost4(this));
    }

    public static final /* synthetic */ void access$configureLevelBubbles(WidgetGuildBoost widgetGuildBoost, int i) {
        widgetGuildBoost.configureLevelBubbles(i);
    }

    public static final /* synthetic */ void access$configureUI(WidgetGuildBoost widgetGuildBoost, GuildBoostViewModel.ViewState viewState) {
        widgetGuildBoost.configureUI(viewState);
    }

    public static final /* synthetic */ void access$fetchData(WidgetGuildBoost widgetGuildBoost) {
        widgetGuildBoost.fetchData();
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetGuildBoost widgetGuildBoost) {
        return widgetGuildBoost.getGuildId();
    }

    public static final /* synthetic */ GuildBoostViewModel access$getViewModel$p(WidgetGuildBoost widgetGuildBoost) {
        return widgetGuildBoost.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetGuildBoost widgetGuildBoost, GuildBoostViewModel.Event event) {
        widgetGuildBoost.handleEvent(event);
    }

    private final void configureLevelBubbles(int currentSelected) {
        int i = 0;
        while (i <= 3) {
            List<? extends ImageView> list = this.levelBackgrounds;
            if (list == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("levelBackgrounds");
            }
            ImageView imageView = list.get(i);
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            layoutParams.height = DimenUtils.dpToPixels(currentSelected == i ? 32 : 20);
            layoutParams.width = DimenUtils.dpToPixels(currentSelected != i ? 20 : 32);
            imageView.setLayoutParams(layoutParams);
            List<? extends TextView> list2 = this.levelText;
            if (list2 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("levelText");
            }
            TextView textView = list2.get(i);
            if (textView != null) {
                textView.setTextColor(currentSelected == i ? ColorCompat.getThemedColor(textView, C5419R.attr.primary_000) : ColorCompat.getThemedColor(textView, C5419R.attr.primary_400));
            }
            i++;
        }
    }

    private final void configureProgressBar(long guildId, int premiumTier, int subscriptionCount) {
        ProgressBar progressBar = getBinding().f17478l.f1340b;
        Intrinsics3.checkNotNullExpressionValue(progressBar, "binding.progress.boostBarProgressBar");
        progressBar.setProgress(GuildBoostUtils.calculateTotalProgress$default(GuildBoostUtils.INSTANCE, guildId, premiumTier, subscriptionCount, null, null, 24, null));
        ProgressBar progressBar2 = getBinding().f17478l.f1340b;
        Intrinsics3.checkNotNullExpressionValue(progressBar2, "binding.progress.boostBarProgressBar");
        progressBar2.setContentDescription(getString(premiumTier != 0 ? premiumTier != 1 ? premiumTier != 2 ? premiumTier != 3 ? 0 : C5419R.string.premium_guild_tier_3 : C5419R.string.premium_guild_tier_2 : C5419R.string.premium_guild_tier_1 : C5419R.string.premium_guild_header_badge_no_tier));
        ImageView imageView = getBinding().f17478l.f1341c;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.progress.boostBarTier0Iv");
        imageView.setEnabled(subscriptionCount > 0);
        ImageView imageView2 = getBinding().f17478l.f1342d;
        Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.progress.boostBarTier1Iv");
        imageView2.setEnabled(premiumTier >= 1);
        ImageView imageView3 = getBinding().f17478l.f1344f;
        Intrinsics3.checkNotNullExpressionValue(imageView3, "binding.progress.boostBarTier2Iv");
        imageView3.setEnabled(premiumTier >= 2);
        ImageView imageView4 = getBinding().f17478l.f1346h;
        Intrinsics3.checkNotNullExpressionValue(imageView4, "binding.progress.boostBarTier3Iv");
        imageView4.setEnabled(premiumTier >= 3);
    }

    private final void configureToolbar(String guildName) {
        setActionBarTitle(C5419R.string.premium_guild_perks_modal_header);
        setActionBarSubtitle(guildName);
    }

    private final void configureUI(GuildBoostViewModel.ViewState viewState) {
        if (viewState instanceof GuildBoostViewModel.ViewState.Loading) {
            AppViewFlipper appViewFlipper = getBinding().f17468b;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.boostStatusFlipper");
            appViewFlipper.setDisplayedChild(0);
            return;
        }
        if (viewState instanceof GuildBoostViewModel.ViewState.Failure) {
            AppViewFlipper appViewFlipper2 = getBinding().f17468b;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper2, "binding.boostStatusFlipper");
            appViewFlipper2.setDisplayedChild(1);
            getBinding().f17474h.setOnClickListener(new ViewOnClickListenerC95061());
            return;
        }
        if (viewState instanceof GuildBoostViewModel.ViewState.Loaded) {
            AppViewFlipper appViewFlipper3 = getBinding().f17468b;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper3, "binding.boostStatusFlipper");
            appViewFlipper3.setDisplayedChild(2);
        }
        GuildBoostViewModel.ViewState.Loaded loaded = (GuildBoostViewModel.ViewState.Loaded) viewState;
        int premiumTier = loaded.getGuild().getPremiumTier();
        int premiumSubscriptionCount = loaded.getGuild().getPremiumSubscriptionCount();
        configureToolbar(loaded.getGuild().getName());
        configureProgressBar(loaded.getGuild().getId(), premiumTier, premiumSubscriptionCount);
        configureViewpager(premiumTier, premiumSubscriptionCount);
        getBinding().f17471e.m8595a(loaded.getMeUser().getPremiumTier(), new C95072());
        getBinding().f17472f.m8597a(loaded.getMeUser().getPremiumTier(), false);
        TextView textView = getBinding().f17470d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.boostStatusNumBoosts");
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        textView.setText(StringResourceUtils.getQuantityString(resources, requireContext(), C5419R.plurals.premium_guild_perks_modal_header_subscription_count_subscriptions, premiumSubscriptionCount, Integer.valueOf(premiumSubscriptionCount)));
    }

    private final void configureViewpager(int premiumTier, int subscriptionCount) {
        PerksPagerAdapter perksPagerAdapter = this.pagerAdapter;
        if (perksPagerAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("pagerAdapter");
        }
        perksPagerAdapter.setPremiumTier(premiumTier);
        PerksPagerAdapter perksPagerAdapter2 = this.pagerAdapter;
        if (perksPagerAdapter2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("pagerAdapter");
        }
        perksPagerAdapter2.setSubscriptionCount(subscriptionCount);
        PerksPagerAdapter perksPagerAdapter3 = this.pagerAdapter;
        if (perksPagerAdapter3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("pagerAdapter");
        }
        SimplePager simplePager = getBinding().f17477k;
        Intrinsics3.checkNotNullExpressionValue(simplePager, "binding.boostStatusViewpager");
        perksPagerAdapter3.configureViews(simplePager);
        if (this.wasPagerPageSet) {
            return;
        }
        getBinding().f17477k.setCurrentItem(Math.max(0, premiumTier - 1), false);
        configureLevelBubbles(Math.max(1, premiumTier));
        this.wasPagerPageSet = true;
    }

    public static final void create(Context context, long j) {
        INSTANCE.create(context, j);
    }

    private final void fetchData() {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        companion.getGuildBoosts().fetchUserGuildBoostState();
        companion.getSubscriptions().fetchSubscriptions();
        GooglePlayBillingManager.INSTANCE.queryPurchases();
    }

    private final WidgetServerBoostStatusBinding getBinding() {
        return (WidgetServerBoostStatusBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final GuildBoostViewModel getViewModel() {
        return (GuildBoostViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(GuildBoostViewModel.Event event) {
        if (event instanceof GuildBoostViewModel.Event.LaunchSubscriptionConfirmation) {
            AnalyticsTracker.INSTANCE.openModal(Traits.Location.Section.PREMIUM_GUILD_SUBSCRIPTION_CONFIRMATION, new Traits.Location(Traits.Location.Page.BOOST_MARKETING, Traits.Location.Section.HEADER, Traits.Location.Obj.BUTTON_CTA, Traits.Location.ObjType.BUY, null, 16, null));
            GuildBoostViewModel.Event.LaunchSubscriptionConfirmation launchSubscriptionConfirmation = (GuildBoostViewModel.Event.LaunchSubscriptionConfirmation) event;
            WidgetGuildBoostConfirmation.INSTANCE.create(requireContext(), launchSubscriptionConfirmation.getGuildId(), launchSubscriptionConfirmation.getSlotId());
            return;
        }
        if (event instanceof GuildBoostViewModel.Event.LaunchPurchaseSubscription) {
            GuildBoostViewModel.Event.LaunchPurchaseSubscription launchPurchaseSubscription = (GuildBoostViewModel.Event.LaunchPurchaseSubscription) event;
            WidgetChoosePlan.Companion.launch$default(WidgetChoosePlan.INSTANCE, requireContext(), this.choosePlanLauncher, WidgetChoosePlan.ViewType.BUY_PREMIUM_GUILD, launchPurchaseSubscription.getOldSkuName(), new Traits.Location(Traits.Location.Page.BOOST_MARKETING, launchPurchaseSubscription.getSection(), Traits.Location.Obj.BUTTON_CTA, Traits.Location.ObjType.BUY, null, 16, null), null, 32, null);
            return;
        }
        if (event instanceof GuildBoostViewModel.Event.ShowDesktopAlertDialog) {
            AnalyticsTracker.INSTANCE.openModal(Traits.Location.Section.ANDROID_CANNOT_MANAGE_SUBSCRIPTION, new Traits.Location(Traits.Location.Page.BOOST_MARKETING, Traits.Location.Section.HEADER, Traits.Location.Obj.BUTTON_CTA, Traits.Location.ObjType.BUY, null, 16, null));
            WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            WidgetNoticeDialog.Companion.show$default(companion, parentFragmentManager, getString(C5419R.string.premium_guild_subscription_out_of_slots_title), FormatUtils.m219k(this, C5419R.string.premium_guild_subscription_out_of_slots_purchase_on_desktop, new Object[]{AppHelpDesk.f507a.m149a(360055386693L, null)}, null, 4), getString(C5419R.string.premium_guild_subscription_header_subscribe_tooltip_close), null, null, null, null, null, null, null, null, 0, null, 16368, null);
            return;
        }
        if (event instanceof GuildBoostViewModel.Event.UnacknowledgedPurchase) {
            AppToast.m171i(this, C5419R.string.billing_error_purchase, 0, 4);
            GooglePlayBillingManager.INSTANCE.queryPurchases();
        } else if (event instanceof GuildBoostViewModel.Event.ShowBlockedPlanSwitchAlertDialog) {
            WidgetNoticeDialog.Companion companion2 = WidgetNoticeDialog.INSTANCE;
            FragmentManager parentFragmentManager2 = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
            GuildBoostViewModel.Event.ShowBlockedPlanSwitchAlertDialog showBlockedPlanSwitchAlertDialog = (GuildBoostViewModel.Event.ShowBlockedPlanSwitchAlertDialog) event;
            String string = getString(showBlockedPlanSwitchAlertDialog.getHeaderStringRes());
            String string2 = getString(showBlockedPlanSwitchAlertDialog.getBodyStringRes());
            Intrinsics3.checkNotNullExpressionValue(string2, "getString(event.bodyStringRes)");
            WidgetNoticeDialog.Companion.show$default(companion2, parentFragmentManager2, string, string2, getString(C5419R.string.billing_manage_subscription), getString(C5419R.string.cancel), MapsJVM.mapOf(Tuples.m10073to(Integer.valueOf(C5419R.id.notice_ok), new C95081())), null, null, null, null, null, null, 0, null, 16320, null);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        this.pagerAdapter = new PerksPagerAdapter(getGuildId());
        getBinding().f17477k.setWrapHeight(true);
        SimplePager simplePager = getBinding().f17477k;
        Intrinsics3.checkNotNullExpressionValue(simplePager, "binding.boostStatusViewpager");
        PerksPagerAdapter perksPagerAdapter = this.pagerAdapter;
        if (perksPagerAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("pagerAdapter");
        }
        simplePager.setAdapter(perksPagerAdapter);
        getBinding().f17477k.addOnPageChangeListener(new C95091());
        AppFragment.setActionBarOptionsMenu$default(this, C5419R.menu.menu_premium_guild, C95102.INSTANCE, null, 4, null);
        LinkifiedTextView linkifiedTextView = getBinding().f17469c;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.boostStatusLearnMore");
        FormatUtils.m221m(linkifiedTextView, C5419R.string.premium_guild_perks_modal_blurb_mobile_learn_more, new Object[]{"learnMode"}, C95113.INSTANCE);
        CharSequence i18nPluralString = StringResourceUtils.getI18nPluralString(requireContext(), C5419R.plurals.premium_guild_perks_modal_protip_mobile_numFreeGuildSubscriptions, 2, 2);
        LinkifiedTextView linkifiedTextView2 = getBinding().f17473g;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView2, "binding.boostStatusProtip");
        FormatUtils.m221m(linkifiedTextView2, C5419R.string.premium_guild_perks_modal_protip, new Object[]{i18nPluralString}, new C95124());
        ImageView imageView = getBinding().f17478l.f1341c;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.progress.boostBarTier0Iv");
        ImageView imageView2 = getBinding().f17478l.f1342d;
        Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.progress.boostBarTier1Iv");
        ImageView imageView3 = getBinding().f17478l.f1344f;
        Intrinsics3.checkNotNullExpressionValue(imageView3, "binding.progress.boostBarTier2Iv");
        ImageView imageView4 = getBinding().f17478l.f1346h;
        Intrinsics3.checkNotNullExpressionValue(imageView4, "binding.progress.boostBarTier3Iv");
        this.levelBackgrounds = Collections2.listOf((Object[]) new ImageView[]{imageView, imageView2, imageView3, imageView4});
        this.levelText = Collections2.listOf((Object[]) new TextView[]{null, getBinding().f17478l.f1343e, getBinding().f17478l.f1345g, getBinding().f17478l.f1347i});
        getBinding().f17475i.setOnClickListener(new ViewOnClickListenerC95135());
        getBinding().f17476j.setOnClickListener(new ViewOnClickListenerC95146());
        fetchData();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        AppActivity appActivity;
        super.onViewBoundOrOnResume();
        if ((getGuildId() == 0 || getGuildId() == -1) && (appActivity = getAppActivity()) != null) {
            appActivity.finish();
        }
        Observable<GuildBoostViewModel.ViewState> observableM11112r = getViewModel().observeViewState().m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11112r, this, null, 2, null), WidgetGuildBoost.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C95151(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetGuildBoost.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C95162(this), 62, (Object) null);
    }
}
