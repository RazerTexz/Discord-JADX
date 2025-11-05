package com.discord.widgets.settings.premium;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.a.a0.a;
import b.a.a.a0.c;
import b.a.d.g0;
import b.a.d.i0;
import b.a.d.j;
import b.a.k.b;
import b.d.b.a.a;
import com.android.billingclient.api.SkuDetails;
import com.discord.R;
import com.discord.api.premium.SubscriptionPlan;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetSettingsGiftingBinding;
import com.discord.i18n.RenderContext;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelEntitlement;
import com.discord.models.domain.ModelGift;
import com.discord.models.domain.ModelSku;
import com.discord.stores.StoreGifting;
import com.discord.stores.StoreStream;
import com.discord.utilities.KotlinExtensionsKt;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.billing.GooglePlayInAppSku;
import com.discord.utilities.billing.GooglePlayInAppSkuKt;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.gifting.GiftingUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.premium.BlockRussianPurchasesUtils;
import com.discord.utilities.recycler.SpaceBetweenItemDecoration;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.premium.GiftSelectView;
import com.discord.widgets.settings.premium.ClaimStatus;
import com.discord.widgets.settings.premium.SettingsGiftingViewModel;
import com.discord.widgets.settings.premium.WidgetOutboundPromoTerms;
import com.discord.widgets.settings.premium.WidgetSettingsGiftingAdapter;
import com.discord.widgets.settings.premium.WidgetSettingsPremium;
import com.google.android.material.textfield.TextInputLayout;
import d0.g0.t;
import d0.t.h0;
import d0.t.n;
import d0.t.p;
import d0.t.u;
import d0.t.z;
import d0.z.d.a0;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetSettingsGifting.kt */
/* loaded from: classes2.dex */
public final class WidgetSettingsGifting extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetSettingsGifting.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsGiftingBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int VIEW_INDEX_FAILURE = 1;
    public static final int VIEW_INDEX_LOADED = 2;
    public static final int VIEW_INDEX_LOADING = 0;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private Map<GiftSelectView, GooglePlayInAppSku> chooseGiftViews;
    private WidgetSettingsGiftingAdapter giftingAdapter;
    private WidgetSettingsGiftingOutboundPromosAdapter promosAdapter;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetSettingsGifting.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void launch$default(Companion companion, Context context, Traits.Location location, int i, Object obj) {
            if ((i & 2) != 0) {
                location = null;
            }
            companion.launch(context, location);
        }

        public final void launch(Context context, Traits.Location location) {
            m.checkNotNullParameter(context, "context");
            if (BlockRussianPurchasesUtils.INSTANCE.getINSTANCE().showDialog()) {
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("com.discord.intent.extra.EXTRA_LOCATION", location);
            j.d(context, WidgetSettingsGifting.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetSettingsGifting.kt */
    /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsGifting$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function2<Long, Long, Unit> {
        public AnonymousClass1() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, Long l2) {
            invoke(l.longValue(), l2);
            return Unit.a;
        }

        public final void invoke(long j, Long l) {
            WidgetSettingsGifting.access$getViewModel$p(WidgetSettingsGifting.this).handleSkuClicked(j, l);
        }
    }

    /* compiled from: WidgetSettingsGifting.kt */
    /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsGifting$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<String, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            m.checkNotNullParameter(str, "giftCode");
            Context context = WidgetSettingsGifting.this.getContext();
            Object systemService = context != null ? context.getSystemService("clipboard") : null;
            ClipboardManager clipboardManager = (ClipboardManager) (systemService instanceof ClipboardManager ? systemService : null);
            if (clipboardManager != null) {
                clipboardManager.setPrimaryClip(ClipData.newPlainText("", GiftingUtils.INSTANCE.generateGiftUrl(str)));
            }
            WidgetSettingsGifting.access$getViewModel$p(WidgetSettingsGifting.this).handleCopyClicked(str);
        }
    }

    /* compiled from: WidgetSettingsGifting.kt */
    /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsGifting$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function1<ModelGift, Unit> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelGift modelGift) {
            invoke2(modelGift);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelGift modelGift) {
            m.checkNotNullParameter(modelGift, "gift");
            StoreStream.INSTANCE.getGifting().revokeGiftCode(modelGift);
        }
    }

    /* compiled from: WidgetSettingsGifting.kt */
    /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsGifting$configureUI$4, reason: invalid class name */
    public static final class AnonymousClass4 extends o implements Function2<Long, Long, Unit> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        public AnonymousClass4() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, Long l2) {
            invoke(l.longValue(), l2);
            return Unit.a;
        }

        public final void invoke(long j, Long l) {
            StoreGifting.generateGiftCode$default(StoreStream.INSTANCE.getGifting(), j, l, null, null, 12, null);
        }
    }

    /* compiled from: WidgetSettingsGifting.kt */
    /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsGifting$handleEvent$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<ClaimStatus.Claimed, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ClaimStatus.Claimed claimed) {
            invoke2(claimed);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ClaimStatus.Claimed claimed) {
            m.checkNotNullParameter(claimed, "it");
            WidgetSettingsGifting.access$getViewModel$p(WidgetSettingsGifting.this).handleClaimedPromo(claimed);
        }
    }

    /* compiled from: WidgetSettingsGifting.kt */
    /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsGifting$handleGiftPurchaseEvent$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetSettingsGifting.this.requireAppActivity().setResult(-1);
        }
    }

    /* compiled from: WidgetSettingsGifting.kt */
    /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsGifting$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            StoreStream.INSTANCE.getEntitlements().fetchMyGiftEntitlements();
        }
    }

    /* compiled from: WidgetSettingsGifting.kt */
    /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsGifting$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<TextView, Unit> {
        public AnonymousClass2() {
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
            TextInputLayout textInputLayout = WidgetSettingsGifting.access$getBinding$p(WidgetSettingsGifting.this).k;
            m.checkNotNullExpressionValue(textInputLayout, "binding.settingsGiftingGiftCodeInputWrap");
            WidgetSettingsGifting.access$getViewModel$p(WidgetSettingsGifting.this).redeemGiftCode(t.replace$default(t.replace$default(ViewExtensions.getTextOrEmpty(textInputLayout), "https://discord.gift/", "", false, 4, (Object) null), "-", "", false, 4, (Object) null), WidgetSettingsGifting.this);
        }
    }

    /* compiled from: WidgetSettingsGifting.kt */
    /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsGifting$onViewBound$3, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass3 extends k implements Function1<SettingsGiftingViewModel.OutboundPromoItem, Unit> {
        public AnonymousClass3(SettingsGiftingViewModel settingsGiftingViewModel) {
            super(1, settingsGiftingViewModel, SettingsGiftingViewModel.class, "handlePromoMoreDetailsClicked", "handlePromoMoreDetailsClicked(Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$OutboundPromoItem;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SettingsGiftingViewModel.OutboundPromoItem outboundPromoItem) {
            invoke2(outboundPromoItem);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SettingsGiftingViewModel.OutboundPromoItem outboundPromoItem) {
            m.checkNotNullParameter(outboundPromoItem, "p1");
            ((SettingsGiftingViewModel) this.receiver).handlePromoMoreDetailsClicked(outboundPromoItem);
        }
    }

    /* compiled from: WidgetSettingsGifting.kt */
    /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsGifting$onViewBound$4, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass4 extends k implements Function1<SettingsGiftingViewModel.OutboundPromoItem, Unit> {
        public AnonymousClass4(SettingsGiftingViewModel settingsGiftingViewModel) {
            super(1, settingsGiftingViewModel, SettingsGiftingViewModel.class, "handlePromoButtonClicked", "handlePromoButtonClicked(Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$OutboundPromoItem;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SettingsGiftingViewModel.OutboundPromoItem outboundPromoItem) {
            invoke2(outboundPromoItem);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SettingsGiftingViewModel.OutboundPromoItem outboundPromoItem) {
            m.checkNotNullParameter(outboundPromoItem, "p1");
            ((SettingsGiftingViewModel) this.receiver).handlePromoButtonClicked(outboundPromoItem);
        }
    }

    /* compiled from: WidgetSettingsGifting.kt */
    /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsGifting$onViewBound$7, reason: invalid class name */
    public static final class AnonymousClass7 extends o implements Function1<RenderContext, Unit> {
        public static final AnonymousClass7 INSTANCE = new AnonymousClass7();

        /* compiled from: WidgetSettingsGifting.kt */
        /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsGifting$onViewBound$7$1, reason: invalid class name */
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
                WidgetSettingsPremium.Companion.launch$default(companion, context, 0, null, 4, null);
            }
        }

        public AnonymousClass7() {
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
            renderContext.b("onClick", AnonymousClass1.INSTANCE);
        }
    }

    /* compiled from: WidgetSettingsGifting.kt */
    /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsGifting$onViewBound$8, reason: invalid class name */
    public static final class AnonymousClass8 extends o implements Function1<RenderContext, Unit> {
        public static final AnonymousClass8 INSTANCE = new AnonymousClass8();

        /* compiled from: WidgetSettingsGifting.kt */
        /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsGifting$onViewBound$8$1, reason: invalid class name */
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
                WidgetSettingsPremium.Companion.launch$default(companion, context, 1, null, 4, null);
            }
        }

        public AnonymousClass8() {
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
            renderContext.b("onClick", AnonymousClass1.INSTANCE);
        }
    }

    /* compiled from: WidgetSettingsGifting.kt */
    /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsGifting$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends k implements Function1<SettingsGiftingViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetSettingsGifting widgetSettingsGifting) {
            super(1, widgetSettingsGifting, WidgetSettingsGifting.class, "configureUI", "configureUI(Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SettingsGiftingViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SettingsGiftingViewModel.ViewState viewState) {
            m.checkNotNullParameter(viewState, "p1");
            WidgetSettingsGifting.access$configureUI((WidgetSettingsGifting) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetSettingsGifting.kt */
    /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsGifting$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends k implements Function1<SettingsGiftingViewModel.GiftPurchaseEvent, Unit> {
        public AnonymousClass2(WidgetSettingsGifting widgetSettingsGifting) {
            super(1, widgetSettingsGifting, WidgetSettingsGifting.class, "handleGiftPurchaseEvent", "handleGiftPurchaseEvent(Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$GiftPurchaseEvent;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SettingsGiftingViewModel.GiftPurchaseEvent giftPurchaseEvent) {
            invoke2(giftPurchaseEvent);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SettingsGiftingViewModel.GiftPurchaseEvent giftPurchaseEvent) {
            m.checkNotNullParameter(giftPurchaseEvent, "p1");
            WidgetSettingsGifting.access$handleGiftPurchaseEvent((WidgetSettingsGifting) this.receiver, giftPurchaseEvent);
        }
    }

    /* compiled from: WidgetSettingsGifting.kt */
    /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsGifting$onViewBoundOrOnResume$3, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass3 extends k implements Function1<SettingsGiftingViewModel.Event, Unit> {
        public AnonymousClass3(WidgetSettingsGifting widgetSettingsGifting) {
            super(1, widgetSettingsGifting, WidgetSettingsGifting.class, "handleEvent", "handleEvent(Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SettingsGiftingViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SettingsGiftingViewModel.Event event) {
            m.checkNotNullParameter(event, "p1");
            WidgetSettingsGifting.access$handleEvent((WidgetSettingsGifting) this.receiver, event);
        }
    }

    /* compiled from: WidgetSettingsGifting.kt */
    /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsGifting$onViewBoundOrOnResume$4, reason: invalid class name */
    public static final class AnonymousClass4 extends o implements Function1<String, Unit> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            m.checkNotNullParameter(str, "giftCode");
            c.INSTANCE.a(str, "Settings - Gifting", 0L);
        }
    }

    public WidgetSettingsGifting() {
        super(R.layout.widget_settings_gifting);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettingsGifting$binding$2.INSTANCE, null, 2, null);
        WidgetSettingsGifting$viewModel$2 widgetSettingsGifting$viewModel$2 = WidgetSettingsGifting$viewModel$2.INSTANCE;
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(SettingsGiftingViewModel.class), new WidgetSettingsGifting$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetSettingsGifting$viewModel$2));
    }

    public static final /* synthetic */ void access$configureUI(WidgetSettingsGifting widgetSettingsGifting, SettingsGiftingViewModel.ViewState viewState) {
        widgetSettingsGifting.configureUI(viewState);
    }

    public static final /* synthetic */ void access$enableGiftingButtons(WidgetSettingsGifting widgetSettingsGifting) {
        widgetSettingsGifting.enableGiftingButtons();
    }

    public static final /* synthetic */ WidgetSettingsGiftingBinding access$getBinding$p(WidgetSettingsGifting widgetSettingsGifting) {
        return widgetSettingsGifting.getBinding();
    }

    public static final /* synthetic */ SettingsGiftingViewModel access$getViewModel$p(WidgetSettingsGifting widgetSettingsGifting) {
        return widgetSettingsGifting.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetSettingsGifting widgetSettingsGifting, SettingsGiftingViewModel.Event event) {
        widgetSettingsGifting.handleEvent(event);
    }

    public static final /* synthetic */ void access$handleGiftPurchaseEvent(WidgetSettingsGifting widgetSettingsGifting, SettingsGiftingViewModel.GiftPurchaseEvent giftPurchaseEvent) {
        widgetSettingsGifting.handleGiftPurchaseEvent(giftPurchaseEvent);
    }

    private final void addGiftItems(List<ModelEntitlement> entries, SettingsGiftingViewModel.ViewState.Loaded viewState, List<WidgetSettingsGiftingAdapter.GiftItem> listItems) {
        if (entries.isEmpty()) {
            return;
        }
        ModelEntitlement modelEntitlement = (ModelEntitlement) u.first((List) entries);
        Set<Long> expandedSkuOrPlanIds = viewState.getExpandedSkuOrPlanIds();
        SubscriptionPlan subscriptionPlan = modelEntitlement.getSubscriptionPlan();
        boolean zContains = expandedSkuOrPlanIds.contains(Long.valueOf(subscriptionPlan != null ? subscriptionPlan.getId() : modelEntitlement.getSku().getId()));
        ModelSku sku = modelEntitlement.getSku();
        SubscriptionPlan subscriptionPlan2 = modelEntitlement.getSubscriptionPlan();
        listItems.add(new WidgetSettingsGiftingAdapter.GiftItem(1, null, null, Boolean.valueOf(zContains), sku, Integer.valueOf(entries.size()), subscriptionPlan2 != null ? Long.valueOf(subscriptionPlan2.getId()) : null, null, null, 390, null));
        Iterator itWithIndex = p.withIndex(entries.iterator());
        boolean z2 = false;
        while (itWithIndex.hasNext()) {
            z zVar = (z) itWithIndex.next();
            int iComponent1 = zVar.component1();
            ModelEntitlement modelEntitlement2 = (ModelEntitlement) zVar.component2();
            Map<Long, List<ModelGift>> myPurchasedGifts = viewState.getMyPurchasedGifts();
            SubscriptionPlan subscriptionPlan3 = modelEntitlement2.getSubscriptionPlan();
            List<ModelGift> list = myPurchasedGifts.get(Long.valueOf(subscriptionPlan3 != null ? subscriptionPlan3.getId() : modelEntitlement2.getSkuId()));
            ModelGift modelGift = (iComponent1 < (list != null ? list.size() : -1) && list != null) ? list.get(iComponent1) : null;
            if (modelGift == null) {
                if (!z2) {
                    z2 = true;
                }
            }
            SubscriptionPlan subscriptionPlan4 = modelEntitlement2.getSubscriptionPlan();
            listItems.add(new WidgetSettingsGiftingAdapter.GiftItem(2, modelGift, modelEntitlement2, Boolean.valueOf(zContains), null, null, subscriptionPlan4 != null ? Long.valueOf(subscriptionPlan4.getId()) : null, Boolean.valueOf(iComponent1 == entries.size() - 1), Boolean.valueOf(modelGift != null && m.areEqual(modelGift.getCode(), viewState.getLastCopiedCode())), 48, null));
        }
    }

    private final void configureUI(SettingsGiftingViewModel.ViewState viewState) {
        if (viewState instanceof SettingsGiftingViewModel.ViewState.Loading) {
            AppViewFlipper appViewFlipper = getBinding().i;
            m.checkNotNullExpressionValue(appViewFlipper, "binding.settingsGiftingFlipper");
            appViewFlipper.setDisplayedChild(0);
            return;
        }
        if (viewState instanceof SettingsGiftingViewModel.ViewState.Failure) {
            AppViewFlipper appViewFlipper2 = getBinding().i;
            m.checkNotNullExpressionValue(appViewFlipper2, "binding.settingsGiftingFlipper");
            appViewFlipper2.setDisplayedChild(1);
            return;
        }
        if (viewState instanceof SettingsGiftingViewModel.ViewState.Loaded) {
            AppViewFlipper appViewFlipper3 = getBinding().i;
            m.checkNotNullExpressionValue(appViewFlipper3, "binding.settingsGiftingFlipper");
            appViewFlipper3.setDisplayedChild(2);
        }
        SettingsGiftingViewModel.ViewState.Loaded loaded = (SettingsGiftingViewModel.ViewState.Loaded) viewState;
        boolean z2 = loaded.getResolvingGiftState() instanceof SettingsGiftingViewModel.ResolvingGiftState.Resolving;
        CharSequence charSequenceK = loaded.getResolvingGiftState() instanceof SettingsGiftingViewModel.ResolvingGiftState.Error ? b.k(this, R.string.application_entitlement_code_redemption_invalid, new Object[0], null, 4) : null;
        ProgressBar progressBar = getBinding().j;
        m.checkNotNullExpressionValue(progressBar, "binding.settingsGiftingGiftCodeInputProgress");
        progressBar.setVisibility(z2 ? 0 : 8);
        TextInputLayout textInputLayout = getBinding().k;
        m.checkNotNullExpressionValue(textInputLayout, "binding.settingsGiftingGiftCodeInputWrap");
        ViewExtensions.setEnabledAlpha$default(textInputLayout, !z2, 0.0f, 2, null);
        TextInputLayout textInputLayout2 = getBinding().k;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.settingsGiftingGiftCodeInputWrap");
        EditText editText = textInputLayout2.getEditText();
        if (editText != null) {
            editText.setInputType(z2 ? 0 : 524288);
        }
        TextInputLayout textInputLayout3 = getBinding().k;
        m.checkNotNullExpressionValue(textInputLayout3, "binding.settingsGiftingGiftCodeInputWrap");
        textInputLayout3.setError(charSequenceK);
        boolean z3 = !loaded.getOutboundPromos().isEmpty();
        TextView textView = getBinding().r;
        m.checkNotNullExpressionValue(textView, "binding.settingsGiftingYourGiftsHeader");
        textView.setVisibility(z3 ? 0 : 8);
        RecyclerView recyclerView = getBinding().f2621s;
        m.checkNotNullExpressionValue(recyclerView, "binding.settingsGiftingYourGiftsRecycler");
        recyclerView.setVisibility(z3 ? 0 : 8);
        WidgetSettingsGiftingOutboundPromosAdapter widgetSettingsGiftingOutboundPromosAdapter = this.promosAdapter;
        if (widgetSettingsGiftingOutboundPromosAdapter == null) {
            m.throwUninitializedPropertyAccessException("promosAdapter");
        }
        widgetSettingsGiftingOutboundPromosAdapter.submitList(loaded.getOutboundPromos());
        WidgetSettingsGiftingAdapter widgetSettingsGiftingAdapter = this.giftingAdapter;
        if (widgetSettingsGiftingAdapter == null) {
            m.throwUninitializedPropertyAccessException("giftingAdapter");
        }
        widgetSettingsGiftingAdapter.configure(generateListItems(loaded), new AnonymousClass1(), new AnonymousClass2(), AnonymousClass3.INSTANCE, AnonymousClass4.INSTANCE);
    }

    private final void enableGiftingButtons() {
        Map<GiftSelectView, GooglePlayInAppSku> map = this.chooseGiftViews;
        if (map == null) {
            m.throwUninitializedPropertyAccessException("chooseGiftViews");
        }
        for (GiftSelectView giftSelectView : map.keySet()) {
            giftSelectView.binding.c.setOnClickListener(new b.a.y.m0.a(giftSelectView));
        }
    }

    private final List<WidgetSettingsGiftingAdapter.GiftItem> generateListItems(SettingsGiftingViewModel.ViewState.Loaded viewState) {
        ArrayList arrayList = new ArrayList();
        if (viewState.getMyEntitlements().isEmpty()) {
            arrayList.add(new WidgetSettingsGiftingAdapter.GiftItem(0, null, null, null, null, null, null, null, null, 510, null));
        } else {
            for (Map.Entry<Long, List<ModelEntitlement>> entry : viewState.getMyEntitlements().entrySet()) {
                entry.getKey().longValue();
                List<ModelEntitlement> value = entry.getValue();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Object obj : value) {
                    SubscriptionPlan subscriptionPlan = ((ModelEntitlement) obj).getSubscriptionPlan();
                    Long lValueOf = subscriptionPlan != null ? Long.valueOf(subscriptionPlan.getId()) : null;
                    Object arrayList2 = linkedHashMap.get(lValueOf);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                        linkedHashMap.put(lValueOf, arrayList2);
                    }
                    ((List) arrayList2).add(obj);
                }
                for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                    addGiftItems((List) entry2.getValue(), viewState, arrayList);
                }
            }
        }
        return arrayList;
    }

    private final WidgetSettingsGiftingBinding getBinding() {
        return (WidgetSettingsGiftingBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final SettingsGiftingViewModel getViewModel() {
        return (SettingsGiftingViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(SettingsGiftingViewModel.Event event) {
        Unit unit;
        if (event instanceof SettingsGiftingViewModel.Event.ShowPromoBottomSheet) {
            WidgetOutboundPromoTerms.Companion companion = WidgetOutboundPromoTerms.INSTANCE;
            String content = ((SettingsGiftingViewModel.Event.ShowPromoBottomSheet) event).getContent();
            FragmentManager parentFragmentManager = getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.show(content, parentFragmentManager);
            unit = Unit.a;
        } else {
            if (!(event instanceof SettingsGiftingViewModel.Event.ShowPromoDialog)) {
                throw new NoWhenBranchMatchedException();
            }
            WidgetClaimOutboundPromo.INSTANCE.showAndRegisterForClaimResult(((SettingsGiftingViewModel.Event.ShowPromoDialog) event).getClaimStatus(), this, new AnonymousClass1());
            unit = Unit.a;
        }
        KotlinExtensionsKt.getExhaustive(unit);
    }

    private final void handleGiftPurchaseEvent(SettingsGiftingViewModel.GiftPurchaseEvent event) {
        enableGiftingButtons();
        if (event instanceof SettingsGiftingViewModel.GiftPurchaseEvent.StartGiftPurchase) {
            DimmerView.setDimmed$default(getBinding().f2620b, true, false, 2, null);
            return;
        }
        if (event instanceof SettingsGiftingViewModel.GiftPurchaseEvent.NotInProgress) {
            DimmerView.setDimmed$default(getBinding().f2620b, false, false, 2, null);
            return;
        }
        if (event instanceof SettingsGiftingViewModel.GiftPurchaseEvent.ErrorGiftPurchase) {
            DimmerView.setDimmed$default(getBinding().f2620b, false, false, 2, null);
            b.a.d.m.i(this, ((SettingsGiftingViewModel.GiftPurchaseEvent.ErrorGiftPurchase) event).getMessage(), 0, 4);
            return;
        }
        if (event instanceof SettingsGiftingViewModel.GiftPurchaseEvent.CompleteGiftPurchase) {
            DimmerView.setDimmed$default(getBinding().f2620b, false, false, 2, null);
            a.Companion companion = b.a.a.a0.a.INSTANCE;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            AnonymousClass1 anonymousClass1 = new AnonymousClass1();
            SettingsGiftingViewModel.GiftPurchaseEvent.CompleteGiftPurchase completeGiftPurchase = (SettingsGiftingViewModel.GiftPurchaseEvent.CompleteGiftPurchase) event;
            String skuName = completeGiftPurchase.getSkuName();
            String newGiftCode = completeGiftPurchase.getNewGiftCode();
            Objects.requireNonNull(companion);
            m.checkNotNullParameter(parentFragmentManager, "fragmentManager");
            m.checkNotNullParameter(anonymousClass1, "onDismiss");
            m.checkNotNullParameter(skuName, "skuName");
            m.checkNotNullParameter(newGiftCode, "giftCode");
            b.a.a.a0.a aVar = new b.a.a.a0.a();
            aVar.onDismiss = anonymousClass1;
            Bundle bundle = new Bundle();
            bundle.putString("ARG_SKU_NAME", skuName);
            bundle.putString("ARG_GIFT_CODE", newGiftCode);
            aVar.setArguments(bundle);
            aVar.show(parentFragmentManager, b.a.a.a0.a.class.getSimpleName());
        }
    }

    public static final void launch(Context context, Traits.Location location) {
        INSTANCE.launch(context, location);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        this.chooseGiftViews = h0.mapOf(d0.o.to(getBinding().c, GooglePlayInAppSkuKt.getPremiumTier1Month()), d0.o.to(getBinding().d, GooglePlayInAppSkuKt.getPremiumTier1Year()), d0.o.to(getBinding().e, GooglePlayInAppSkuKt.getPremiumTier2Month()), d0.o.to(getBinding().f, GooglePlayInAppSkuKt.getPremiumTier2Year()));
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        getBinding().o.setOnClickListener(AnonymousClass1.INSTANCE);
        TextInputLayout textInputLayout = getBinding().k;
        m.checkNotNullExpressionValue(textInputLayout, "binding.settingsGiftingGiftCodeInputWrap");
        ViewExtensions.setOnImeActionDone$default(textInputLayout, false, new AnonymousClass2(), 1, null);
        getBinding().k.setErrorTextColor(ColorStateList.valueOf(ColorCompat.getColor(requireContext(), R.color.status_red_500)));
        WidgetSettingsGiftingOutboundPromosAdapter widgetSettingsGiftingOutboundPromosAdapter = new WidgetSettingsGiftingOutboundPromosAdapter(new AnonymousClass3(getViewModel()), new AnonymousClass4(getViewModel()));
        RecyclerView recyclerView = getBinding().f2621s;
        m.checkNotNullExpressionValue(recyclerView, "binding.settingsGiftingYourGiftsRecycler");
        recyclerView.setAdapter(widgetSettingsGiftingOutboundPromosAdapter);
        this.promosAdapter = widgetSettingsGiftingOutboundPromosAdapter;
        RecyclerView recyclerView2 = getBinding().f2621s;
        WidgetSettingsGiftingOutboundPromosAdapter widgetSettingsGiftingOutboundPromosAdapter2 = this.promosAdapter;
        if (widgetSettingsGiftingOutboundPromosAdapter2 == null) {
            m.throwUninitializedPropertyAccessException("promosAdapter");
        }
        recyclerView2.setAdapter(widgetSettingsGiftingOutboundPromosAdapter2);
        Context context = recyclerView2.getContext();
        m.checkNotNullExpressionValue(context, "context");
        RecyclerView.LayoutManager layoutManager = recyclerView2.getLayoutManager();
        Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        int orientation = ((LinearLayoutManager) layoutManager).getOrientation();
        WidgetSettingsGiftingOutboundPromosAdapter widgetSettingsGiftingOutboundPromosAdapter3 = this.promosAdapter;
        if (widgetSettingsGiftingOutboundPromosAdapter3 == null) {
            m.throwUninitializedPropertyAccessException("promosAdapter");
        }
        recyclerView2.addItemDecoration(new SpaceBetweenItemDecoration(context, orientation, widgetSettingsGiftingOutboundPromosAdapter3, DimenUtils.dpToPixels(16), 0, 16, null));
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView3 = getBinding().m;
        m.checkNotNullExpressionValue(recyclerView3, "binding.settingsGiftingGiftsYouPurchasedRecycler");
        this.giftingAdapter = (WidgetSettingsGiftingAdapter) companion.configure(new WidgetSettingsGiftingAdapter(recyclerView3));
        LinkifiedTextView linkifiedTextView = getBinding().g;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.premiumTier1GiftLearnMore");
        b.m(linkifiedTextView, R.string.premium_classic_payment_gift_blurb_mobile, new Object[0], AnonymousClass7.INSTANCE);
        LinkifiedTextView linkifiedTextView2 = getBinding().h;
        m.checkNotNullExpressionValue(linkifiedTextView2, "binding.premiumTier2GiftLearnMore");
        b.m(linkifiedTextView2, R.string.premium_payment_gift_blurb_mobile, new Object[0], AnonymousClass8.INSTANCE);
        Serializable serializableExtra = getMostRecentIntent().getSerializableExtra("com.discord.intent.extra.EXTRA_LOCATION");
        if (!(serializableExtra instanceof Traits.Location)) {
            serializableExtra = null;
        }
        WidgetSettingsGifting$onViewBound$chooseGiftCallback$1 widgetSettingsGifting$onViewBound$chooseGiftCallback$1 = new WidgetSettingsGifting$onViewBound$chooseGiftCallback$1(this, (Traits.Location) serializableExtra);
        Map<GiftSelectView, GooglePlayInAppSku> map = this.chooseGiftViews;
        if (map == null) {
            m.throwUninitializedPropertyAccessException("chooseGiftViews");
        }
        for (Map.Entry<GiftSelectView, GooglePlayInAppSku> entry : map.entrySet()) {
            GiftSelectView key = entry.getKey();
            GooglePlayInAppSku value = entry.getValue();
            Objects.requireNonNull(key);
            m.checkNotNullParameter(value, "inAppSku");
            m.checkNotNullParameter(widgetSettingsGifting$onViewBound$chooseGiftCallback$1, "onClickPlan");
            key.onClickPlan = widgetSettingsGifting$onViewBound$chooseGiftCallback$1;
            key.inAppSku = value;
            SkuDetails skuDetails = value.getSkuDetails();
            if (skuDetails != null) {
                TextView textView = key.binding.f;
                m.checkNotNullExpressionValue(textView, "binding.planItemName");
                textView.setText(skuDetails.a());
                TextView textView2 = key.binding.g;
                m.checkNotNullExpressionValue(textView2, "binding.planItemPrice");
                textView2.setText(skuDetails.b());
                TextView textView3 = key.binding.d;
                m.checkNotNullExpressionValue(textView3, "binding.planItemCurrentPlan");
                textView3.setVisibility(8);
                Integer iconForSku = GiftingUtils.INSTANCE.getIconForSku(value);
                if (iconForSku != null) {
                    key.binding.e.setImageResource(iconForSku.intValue());
                }
                TextView textView4 = key.binding.g;
                m.checkNotNullExpressionValue(textView4, "binding.planItemPrice");
                Context context2 = textView4.getContext();
                m.checkNotNullExpressionValue(context2, "binding.planItemPrice.context");
                int themedDrawableRes$default = DrawableCompat.getThemedDrawableRes$default(context2, R.attr.ic_navigate_next, 0, 2, (Object) null);
                TextView textView5 = key.binding.g;
                m.checkNotNullExpressionValue(textView5, "binding.planItemPrice");
                DrawableCompat.setCompoundDrawablesCompat$default(textView5, 0, 0, themedDrawableRes$default, 0, 11, (Object) null);
                key.binding.c.setOnClickListener(new b.a.y.m0.a(key));
            }
        }
        RecyclerView recyclerView4 = getBinding().m;
        m.checkNotNullExpressionValue(recyclerView4, "binding.settingsGiftingGiftsYouPurchasedRecycler");
        recyclerView4.setItemAnimator(null);
        getBinding().m.setHasFixedSize(false);
        for (TextView textView6 : n.listOf((Object[]) new TextView[]{getBinding().n, getBinding().l, getBinding().q, getBinding().p})) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            m.checkNotNullExpressionValue(textView6, "header");
            accessibilityUtils.setViewIsHeading(textView6);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<SettingsGiftingViewModel.ViewState> observableR = getViewModel().observeViewState().r();
        m.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetSettingsGifting.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(getViewModel().observeGiftPurchaseEvents(), this, null, 2, null), WidgetSettingsGifting.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetSettingsGifting.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass3(this), 62, (Object) null);
        getViewModel().setOnGiftCodeResolved(AnonymousClass4.INSTANCE);
        enableGiftingButtons();
    }
}
