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
import b.a.d.f;
import b.a.d.g0;
import b.a.d.i0;
import b.a.d.j;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R;
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
import com.discord.utilities.premium.GuildBoostUtils;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.simple_pager.SimplePager;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.servers.WidgetServerSettingsChannels;
import com.discord.widgets.servers.guildboost.GuildBoostViewModel;
import com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoost;
import com.discord.widgets.settings.premium.WidgetChoosePlan;
import com.discord.widgets.settings.premium.WidgetSettingsPremium;
import d0.g;
import d0.t.n;
import d0.z.d.a0;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.functions.Action2;

/* compiled from: WidgetGuildBoost.kt */
/* loaded from: classes2.dex */
public final class WidgetGuildBoost extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetGuildBoost.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerBoostStatusBinding;", 0)};

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
            m.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent().putExtra(WidgetGuildBoost.INTENT_EXTRA_GUILD_ID, guildId);
            m.checkNotNullExpressionValue(intentPutExtra, "Intent().putExtra(INTENT_EXTRA_GUILD_ID, guildId)");
            j.d(context, WidgetGuildBoost.class, intentPutExtra);
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
            m.checkNotNullParameter(viewPager, "viewPager");
            int childCount = viewPager.getChildCount();
            if (childCount <= 0) {
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i + 1;
                View childAt = viewPager.getChildAt(i);
                m.checkNotNullExpressionValue(childAt, "getChildAt(index)");
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
            m.checkNotNullParameter(container, "container");
            m.checkNotNullParameter(view, "view");
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
            m.checkNotNullParameter(view, "view");
            m.checkNotNullParameter(any, "any");
            return m.areEqual(view, any);
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
            m.checkNotNullParameter(container, "container");
            int i = position + 1;
            Context context = container.getContext();
            m.checkNotNullExpressionValue(context, "container.context");
            GuildBoostPerkView guildBoostPerkView = new GuildBoostPerkView(context, null, 0, 6, null);
            guildBoostPerkView.configure(i, this.premiumTier, this.guildId);
            guildBoostPerkView.setTag(Integer.valueOf(i));
            container.addView(guildBoostPerkView);
            return guildBoostPerkView;
        }
    }

    /* compiled from: WidgetGuildBoost.kt */
    /* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoost$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildBoost.access$getViewModel$p(WidgetGuildBoost.this).retryClicked();
        }
    }

    /* compiled from: WidgetGuildBoost.kt */
    /* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoost$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function0<Unit> {
        public AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetSettingsPremium.Companion.launch$default(WidgetSettingsPremium.INSTANCE, WidgetGuildBoost.this.requireContext(), null, null, 6, null);
        }
    }

    /* compiled from: WidgetGuildBoost.kt */
    /* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoost$handleEvent$1, reason: invalid class name */
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
            WidgetSettingsPremium.Companion.launch$default(WidgetSettingsPremium.INSTANCE, WidgetGuildBoost.this.requireContext(), null, null, 6, null);
        }
    }

    /* compiled from: WidgetGuildBoost.kt */
    /* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoost$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements ViewPager.OnPageChangeListener {
        public AnonymousClass1() {
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
    /* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoost$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2<T1, T2> implements Action2<MenuItem, Context> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // rx.functions.Action2
        public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
            call2(menuItem, context);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(MenuItem menuItem, Context context) {
            m.checkNotNullExpressionValue(menuItem, "menuItem");
            if (menuItem.getItemId() != R.id.menu_premium_guild) {
                return;
            }
            WidgetSettingsGuildBoost.Companion companion = WidgetSettingsGuildBoost.INSTANCE;
            m.checkNotNullExpressionValue(context, "context");
            companion.launch(context);
        }
    }

    /* compiled from: WidgetGuildBoost.kt */
    /* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoost$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function1<RenderContext, Unit> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        /* compiled from: WidgetGuildBoost.kt */
        /* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoost$onViewBound$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends o implements Function1<View, Unit> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

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
                m.checkNotNullParameter(view, "view");
                WidgetSettingsGuildBoost.Companion companion = WidgetSettingsGuildBoost.INSTANCE;
                Context context = view.getContext();
                m.checkNotNullExpressionValue(context, "view.context");
                companion.launch(context);
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
            m.checkNotNullParameter(renderContext, "$receiver");
            renderContext.b("learnMore", AnonymousClass1.INSTANCE);
        }
    }

    /* compiled from: WidgetGuildBoost.kt */
    /* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoost$onViewBound$4, reason: invalid class name */
    public static final class AnonymousClass4 extends o implements Function1<RenderContext, Unit> {

        /* compiled from: WidgetGuildBoost.kt */
        /* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoost$onViewBound$4$1, reason: invalid class name */
        public static final class AnonymousClass1 extends o implements Function1<View, Unit> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

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
                m.checkNotNullParameter(view, "view");
                WidgetSettingsPremium.Companion companion = WidgetSettingsPremium.INSTANCE;
                Context context = view.getContext();
                m.checkNotNullExpressionValue(context, "view.context");
                WidgetSettingsPremium.Companion.launch$default(companion, context, null, null, 6, null);
            }
        }

        public AnonymousClass4() {
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
            renderContext.boldColor = Integer.valueOf(ColorCompat.getColor(WidgetGuildBoost.this.requireContext(), R.color.status_green_600));
            renderContext.b("onLearnMore", AnonymousClass1.INSTANCE);
            renderContext.a("protipHook", AnonymousClass2.INSTANCE);
        }

        /* compiled from: WidgetGuildBoost.kt */
        /* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoost$onViewBound$4$2, reason: invalid class name */
        public static final class AnonymousClass2 extends o implements Function1<Hook, Unit> {
            public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

            public AnonymousClass2() {
                super(1);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Hook hook) {
                m.checkNotNullParameter(hook, "$receiver");
                hook.styles.add(new StyleSpan(1));
                hook.styles.add(new ForegroundColorSpan(-65536));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
                invoke2(hook);
                return Unit.a;
            }
        }
    }

    /* compiled from: WidgetGuildBoost.kt */
    /* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoost$onViewBound$5, reason: invalid class name */
    public static final class AnonymousClass5 implements View.OnClickListener {
        public AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildBoost.access$getViewModel$p(WidgetGuildBoost.this).subscribeClicked(Traits.Location.Section.HEADER);
        }
    }

    /* compiled from: WidgetGuildBoost.kt */
    /* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoost$onViewBound$6, reason: invalid class name */
    public static final class AnonymousClass6 implements View.OnClickListener {
        public AnonymousClass6() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildBoost.access$getViewModel$p(WidgetGuildBoost.this).subscribeClicked(Traits.Location.Section.FOOTER);
        }
    }

    /* compiled from: WidgetGuildBoost.kt */
    /* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoost$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends k implements Function1<GuildBoostViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetGuildBoost widgetGuildBoost) {
            super(1, widgetGuildBoost, WidgetGuildBoost.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildBoostViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildBoostViewModel.ViewState viewState) {
            m.checkNotNullParameter(viewState, "p1");
            WidgetGuildBoost.access$configureUI((WidgetGuildBoost) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetGuildBoost.kt */
    /* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoost$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends k implements Function1<GuildBoostViewModel.Event, Unit> {
        public AnonymousClass2(WidgetGuildBoost widgetGuildBoost) {
            super(1, widgetGuildBoost, WidgetGuildBoost.class, "handleEvent", "handleEvent(Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildBoostViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildBoostViewModel.Event event) {
            m.checkNotNullParameter(event, "p1");
            WidgetGuildBoost.access$handleEvent((WidgetGuildBoost) this.receiver, event);
        }
    }

    public WidgetGuildBoost() {
        super(R.layout.widget_server_boost_status);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildBoost$binding$2.INSTANCE, null, 2, null);
        WidgetGuildBoost$viewModel$2 widgetGuildBoost$viewModel$2 = new WidgetGuildBoost$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(GuildBoostViewModel.class), new WidgetGuildBoost$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetGuildBoost$viewModel$2));
        this.choosePlanLauncher = WidgetChoosePlan.INSTANCE.registerForResult(this, new WidgetGuildBoost$choosePlanLauncher$1(this));
        this.guildId = g.lazy(new WidgetGuildBoost$guildId$2(this));
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
                m.throwUninitializedPropertyAccessException("levelBackgrounds");
            }
            ImageView imageView = list.get(i);
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            layoutParams.height = DimenUtils.dpToPixels(currentSelected == i ? 32 : 20);
            layoutParams.width = DimenUtils.dpToPixels(currentSelected != i ? 20 : 32);
            imageView.setLayoutParams(layoutParams);
            List<? extends TextView> list2 = this.levelText;
            if (list2 == null) {
                m.throwUninitializedPropertyAccessException("levelText");
            }
            TextView textView = list2.get(i);
            if (textView != null) {
                textView.setTextColor(currentSelected == i ? ColorCompat.getThemedColor(textView, R.attr.primary_000) : ColorCompat.getThemedColor(textView, R.attr.primary_400));
            }
            i++;
        }
    }

    private final void configureProgressBar(long guildId, int premiumTier, int subscriptionCount) {
        ProgressBar progressBar = getBinding().l.f222b;
        m.checkNotNullExpressionValue(progressBar, "binding.progress.boostBarProgressBar");
        progressBar.setProgress(GuildBoostUtils.calculateTotalProgress$default(GuildBoostUtils.INSTANCE, guildId, premiumTier, subscriptionCount, null, null, 24, null));
        ProgressBar progressBar2 = getBinding().l.f222b;
        m.checkNotNullExpressionValue(progressBar2, "binding.progress.boostBarProgressBar");
        progressBar2.setContentDescription(getString(premiumTier != 0 ? premiumTier != 1 ? premiumTier != 2 ? premiumTier != 3 ? 0 : R.string.premium_guild_tier_3 : R.string.premium_guild_tier_2 : R.string.premium_guild_tier_1 : R.string.premium_guild_header_badge_no_tier));
        ImageView imageView = getBinding().l.c;
        m.checkNotNullExpressionValue(imageView, "binding.progress.boostBarTier0Iv");
        imageView.setEnabled(subscriptionCount > 0);
        ImageView imageView2 = getBinding().l.d;
        m.checkNotNullExpressionValue(imageView2, "binding.progress.boostBarTier1Iv");
        imageView2.setEnabled(premiumTier >= 1);
        ImageView imageView3 = getBinding().l.f;
        m.checkNotNullExpressionValue(imageView3, "binding.progress.boostBarTier2Iv");
        imageView3.setEnabled(premiumTier >= 2);
        ImageView imageView4 = getBinding().l.h;
        m.checkNotNullExpressionValue(imageView4, "binding.progress.boostBarTier3Iv");
        imageView4.setEnabled(premiumTier >= 3);
    }

    private final void configureToolbar(String guildName) {
        setActionBarTitle(R.string.premium_guild_perks_modal_header);
        setActionBarSubtitle(guildName);
    }

    private final void configureUI(GuildBoostViewModel.ViewState viewState) {
        if (viewState instanceof GuildBoostViewModel.ViewState.Loading) {
            AppViewFlipper appViewFlipper = getBinding().f2535b;
            m.checkNotNullExpressionValue(appViewFlipper, "binding.boostStatusFlipper");
            appViewFlipper.setDisplayedChild(0);
            return;
        }
        if (viewState instanceof GuildBoostViewModel.ViewState.Failure) {
            AppViewFlipper appViewFlipper2 = getBinding().f2535b;
            m.checkNotNullExpressionValue(appViewFlipper2, "binding.boostStatusFlipper");
            appViewFlipper2.setDisplayedChild(1);
            getBinding().h.setOnClickListener(new AnonymousClass1());
            return;
        }
        if (viewState instanceof GuildBoostViewModel.ViewState.Loaded) {
            AppViewFlipper appViewFlipper3 = getBinding().f2535b;
            m.checkNotNullExpressionValue(appViewFlipper3, "binding.boostStatusFlipper");
            appViewFlipper3.setDisplayedChild(2);
        }
        GuildBoostViewModel.ViewState.Loaded loaded = (GuildBoostViewModel.ViewState.Loaded) viewState;
        int premiumTier = loaded.getGuild().getPremiumTier();
        int premiumSubscriptionCount = loaded.getGuild().getPremiumSubscriptionCount();
        configureToolbar(loaded.getGuild().getName());
        configureProgressBar(loaded.getGuild().getId(), premiumTier, premiumSubscriptionCount);
        configureViewpager(premiumTier, premiumSubscriptionCount);
        getBinding().e.a(loaded.getMeUser().getPremiumTier(), new AnonymousClass2());
        getBinding().f.a(loaded.getMeUser().getPremiumTier(), false);
        TextView textView = getBinding().d;
        m.checkNotNullExpressionValue(textView, "binding.boostStatusNumBoosts");
        Resources resources = getResources();
        m.checkNotNullExpressionValue(resources, "resources");
        textView.setText(StringResourceUtilsKt.getQuantityString(resources, requireContext(), R.plurals.premium_guild_perks_modal_header_subscription_count_subscriptions, premiumSubscriptionCount, Integer.valueOf(premiumSubscriptionCount)));
    }

    private final void configureViewpager(int premiumTier, int subscriptionCount) {
        PerksPagerAdapter perksPagerAdapter = this.pagerAdapter;
        if (perksPagerAdapter == null) {
            m.throwUninitializedPropertyAccessException("pagerAdapter");
        }
        perksPagerAdapter.setPremiumTier(premiumTier);
        PerksPagerAdapter perksPagerAdapter2 = this.pagerAdapter;
        if (perksPagerAdapter2 == null) {
            m.throwUninitializedPropertyAccessException("pagerAdapter");
        }
        perksPagerAdapter2.setSubscriptionCount(subscriptionCount);
        PerksPagerAdapter perksPagerAdapter3 = this.pagerAdapter;
        if (perksPagerAdapter3 == null) {
            m.throwUninitializedPropertyAccessException("pagerAdapter");
        }
        SimplePager simplePager = getBinding().k;
        m.checkNotNullExpressionValue(simplePager, "binding.boostStatusViewpager");
        perksPagerAdapter3.configureViews(simplePager);
        if (this.wasPagerPageSet) {
            return;
        }
        getBinding().k.setCurrentItem(Math.max(0, premiumTier - 1), false);
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
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            WidgetNoticeDialog.Companion.show$default(companion, parentFragmentManager, getString(R.string.premium_guild_subscription_out_of_slots_title), b.k(this, R.string.premium_guild_subscription_out_of_slots_purchase_on_desktop, new Object[]{f.a.a(360055386693L, null)}, null, 4), getString(R.string.premium_guild_subscription_header_subscribe_tooltip_close), null, null, null, null, null, null, null, null, 0, null, 16368, null);
            return;
        }
        if (event instanceof GuildBoostViewModel.Event.UnacknowledgedPurchase) {
            b.a.d.m.i(this, R.string.billing_error_purchase, 0, 4);
            GooglePlayBillingManager.INSTANCE.queryPurchases();
        } else if (event instanceof GuildBoostViewModel.Event.ShowBlockedPlanSwitchAlertDialog) {
            WidgetNoticeDialog.Companion companion2 = WidgetNoticeDialog.INSTANCE;
            FragmentManager parentFragmentManager2 = getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
            GuildBoostViewModel.Event.ShowBlockedPlanSwitchAlertDialog showBlockedPlanSwitchAlertDialog = (GuildBoostViewModel.Event.ShowBlockedPlanSwitchAlertDialog) event;
            String string = getString(showBlockedPlanSwitchAlertDialog.getHeaderStringRes());
            String string2 = getString(showBlockedPlanSwitchAlertDialog.getBodyStringRes());
            m.checkNotNullExpressionValue(string2, "getString(event.bodyStringRes)");
            WidgetNoticeDialog.Companion.show$default(companion2, parentFragmentManager2, string, string2, getString(R.string.billing_manage_subscription), getString(R.string.cancel), d0.t.g0.mapOf(d0.o.to(Integer.valueOf(R.id.notice_ok), new AnonymousClass1())), null, null, null, null, null, null, 0, null, 16320, null);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        this.pagerAdapter = new PerksPagerAdapter(getGuildId());
        getBinding().k.setWrapHeight(true);
        SimplePager simplePager = getBinding().k;
        m.checkNotNullExpressionValue(simplePager, "binding.boostStatusViewpager");
        PerksPagerAdapter perksPagerAdapter = this.pagerAdapter;
        if (perksPagerAdapter == null) {
            m.throwUninitializedPropertyAccessException("pagerAdapter");
        }
        simplePager.setAdapter(perksPagerAdapter);
        getBinding().k.addOnPageChangeListener(new AnonymousClass1());
        AppFragment.setActionBarOptionsMenu$default(this, R.menu.menu_premium_guild, AnonymousClass2.INSTANCE, null, 4, null);
        LinkifiedTextView linkifiedTextView = getBinding().c;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.boostStatusLearnMore");
        b.m(linkifiedTextView, R.string.premium_guild_perks_modal_blurb_mobile_learn_more, new Object[]{"learnMode"}, AnonymousClass3.INSTANCE);
        CharSequence i18nPluralString = StringResourceUtilsKt.getI18nPluralString(requireContext(), R.plurals.premium_guild_perks_modal_protip_mobile_numFreeGuildSubscriptions, 2, 2);
        LinkifiedTextView linkifiedTextView2 = getBinding().g;
        m.checkNotNullExpressionValue(linkifiedTextView2, "binding.boostStatusProtip");
        b.m(linkifiedTextView2, R.string.premium_guild_perks_modal_protip, new Object[]{i18nPluralString}, new AnonymousClass4());
        ImageView imageView = getBinding().l.c;
        m.checkNotNullExpressionValue(imageView, "binding.progress.boostBarTier0Iv");
        ImageView imageView2 = getBinding().l.d;
        m.checkNotNullExpressionValue(imageView2, "binding.progress.boostBarTier1Iv");
        ImageView imageView3 = getBinding().l.f;
        m.checkNotNullExpressionValue(imageView3, "binding.progress.boostBarTier2Iv");
        ImageView imageView4 = getBinding().l.h;
        m.checkNotNullExpressionValue(imageView4, "binding.progress.boostBarTier3Iv");
        this.levelBackgrounds = n.listOf((Object[]) new ImageView[]{imageView, imageView2, imageView3, imageView4});
        this.levelText = n.listOf((Object[]) new TextView[]{null, getBinding().l.e, getBinding().l.g, getBinding().l.i});
        getBinding().i.setOnClickListener(new AnonymousClass5());
        getBinding().j.setOnClickListener(new AnonymousClass6());
        fetchData();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        AppActivity appActivity;
        super.onViewBoundOrOnResume();
        if ((getGuildId() == 0 || getGuildId() == -1) && (appActivity = getAppActivity()) != null) {
            appActivity.finish();
        }
        Observable<GuildBoostViewModel.ViewState> observableR = getViewModel().observeViewState().r();
        m.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetGuildBoost.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetGuildBoost.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(this), 62, (Object) null);
    }
}
