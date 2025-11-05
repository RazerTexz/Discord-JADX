package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.a.d.j;
import b.d.b.a.a;
import com.discord.R;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefitType;
import com.discord.app.AppFragment;
import com.discord.app.AppLog;
import com.discord.databinding.WidgetGuildRoleSubscriptionTierBenefitBinding;
import com.discord.models.domain.emoji.Emoji;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.channels.WidgetChannelPickerBottomSheet;
import com.discord.widgets.channels.WidgetCreateChannel;
import com.discord.widgets.chat.input.emoji.EmojiPickerContextType;
import com.discord.widgets.chat.input.emoji.EmojiPickerListener;
import com.discord.widgets.chat.input.emoji.EmojiPickerNavigator;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionTierBenefitViewModel;
import com.discord.widgets.guild_role_subscriptions.tier.model.Benefit;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import d0.d0.f;
import d0.g;
import d0.g0.t;
import d0.z.d.a0;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
/* loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierBenefit extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetGuildRoleSubscriptionTierBenefit.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildRoleSubscriptionTierBenefitBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_BENEFIT_TYPE = "INTENT_EXTRA_BENEFIT_TYPE";
    private static final String INTENT_EXTRA_EXISTING_BENEFIT = "INTENT_EXTRA_EXISTING_BENEFIT";
    private static final String INTENT_EXTRA_TIER_NAME = "INTENT_EXTRA_TIER_NAME";
    private static final int MAX_EMOJI_SIZE = 64;
    private static final String REQUEST_KEY_CHANNEL_PICKER = "REQUEST_KEY_CHANNEL_PICKER";
    private static final String RESULT_EXTRA_BENEFIT = "RESULT_EXTRA_BENEFIT";
    private static final String RESULT_EXTRA_EXISTING_BENEFIT = "RESULT_EXTRA_EXISTING_BENEFIT";

    /* renamed from: benefitType$delegate, reason: from kotlin metadata */
    private final Lazy benefitType;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ActivityResultLauncher<Intent> createChannelLauncher;

    /* renamed from: existingBenefit$delegate, reason: from kotlin metadata */
    private final Lazy existingBenefit;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* renamed from: tierName$delegate, reason: from kotlin metadata */
    private final Lazy tierName;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void launch$default(Companion companion, Context context, ActivityResultLauncher activityResultLauncher, long j, GuildRoleSubscriptionBenefitType guildRoleSubscriptionBenefitType, String str, Benefit benefit, int i, Object obj) {
            companion.launch(context, activityResultLauncher, j, guildRoleSubscriptionBenefitType, (i & 16) != 0 ? null : str, (i & 32) != 0 ? null : benefit);
        }

        public final void launch(Context context, ActivityResultLauncher<Intent> launcher, long guildId, GuildRoleSubscriptionBenefitType benefitType, String tierName, Benefit benefit) {
            m.checkNotNullParameter(context, "context");
            m.checkNotNullParameter(launcher, "launcher");
            m.checkNotNullParameter(benefitType, "benefitType");
            j jVar = j.g;
            Intent intent = new Intent();
            intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            intent.putExtra(WidgetGuildRoleSubscriptionTierBenefit.INTENT_EXTRA_EXISTING_BENEFIT, benefit);
            intent.putExtra(WidgetGuildRoleSubscriptionTierBenefit.INTENT_EXTRA_BENEFIT_TYPE, benefitType);
            intent.putExtra(WidgetGuildRoleSubscriptionTierBenefit.INTENT_EXTRA_TIER_NAME, tierName);
            jVar.f(context, launcher, WidgetGuildRoleSubscriptionTierBenefit.class, intent);
        }

        public final ActivityResultLauncher<Intent> registerForResult(AppFragment fragment, Function2<? super Benefit, ? super Benefit, Unit> onBenefitUpdate) {
            m.checkNotNullParameter(fragment, "fragment");
            m.checkNotNullParameter(onBenefitUpdate, "onBenefitUpdate");
            ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new WidgetGuildRoleSubscriptionTierBenefit$Companion$registerForResult$1(onBenefitUpdate));
            m.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…  }\n          }\n        }");
            return activityResultLauncherRegisterForActivityResult;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            GuildRoleSubscriptionBenefitType.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[GuildRoleSubscriptionBenefitType.CHANNEL.ordinal()] = 1;
            iArr[GuildRoleSubscriptionBenefitType.INTANGIBLE.ordinal()] = 2;
            iArr[GuildRoleSubscriptionBenefitType.UNKNOWN.ordinal()] = 3;
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ GuildRoleSubscriptionTierBenefitViewModel.ViewState $viewState;

        /* compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
        /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$configureUI$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C04111 extends o implements Function0<Unit> {
            public C04111() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AppFragment.hideKeyboard$default(WidgetGuildRoleSubscriptionTierBenefit.this, null, 1, null);
            }
        }

        public AnonymousClass1(GuildRoleSubscriptionTierBenefitViewModel.ViewState viewState) {
            this.$viewState = viewState;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChannelPickerBottomSheet.Companion companion = WidgetChannelPickerBottomSheet.INSTANCE;
            WidgetGuildRoleSubscriptionTierBenefit widgetGuildRoleSubscriptionTierBenefit = WidgetGuildRoleSubscriptionTierBenefit.this;
            companion.launch(widgetGuildRoleSubscriptionTierBenefit, WidgetGuildRoleSubscriptionTierBenefit.REQUEST_KEY_CHANNEL_PICKER, WidgetGuildRoleSubscriptionTierBenefit.access$getGuildId$p(widgetGuildRoleSubscriptionTierBenefit), this.$viewState.getChannelId(), new C04111(), true);
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$configureUIForChannelBenefit$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function3<Long, String, Integer, Unit> {
        public AnonymousClass1() {
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Long l, String str, Integer num) {
            invoke(l.longValue(), str, num.intValue());
            return Unit.a;
        }

        public final void invoke(long j, String str, int i) {
            m.checkNotNullParameter(str, "channelName");
            WidgetGuildRoleSubscriptionTierBenefit.access$getViewModel$p(WidgetGuildRoleSubscriptionTierBenefit.this).updateChannel(j, str, Integer.valueOf(i));
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$configureUIForChannelBenefit$2, reason: invalid class name */
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
            WidgetCreateChannel.Companion.launch$default(WidgetCreateChannel.INSTANCE, WidgetGuildRoleSubscriptionTierBenefit.this.requireContext(), WidgetGuildRoleSubscriptionTierBenefit.access$getCreateChannelLauncher$p(WidgetGuildRoleSubscriptionTierBenefit.this), WidgetGuildRoleSubscriptionTierBenefit.access$getGuildId$p(WidgetGuildRoleSubscriptionTierBenefit.this), 0, null, true, true, true, true, 24, null);
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$configureUIForIntangibleBenefit$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Editable, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            m.checkNotNullParameter(editable, "it");
            WidgetGuildRoleSubscriptionTierBenefit.access$getViewModel$p(WidgetGuildRoleSubscriptionTierBenefit.this).updateName(editable.toString());
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildRoleSubscriptionTierBenefit.access$getViewModel$p(WidgetGuildRoleSubscriptionTierBenefit.this).submitResult();
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildRoleSubscriptionTierBenefit.access$cancel(WidgetGuildRoleSubscriptionTierBenefit.this);
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {

        /* compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
        /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$onViewBound$3$1, reason: invalid class name */
        public static final class AnonymousClass1 implements EmojiPickerListener {
            public AnonymousClass1() {
            }

            @Override // com.discord.widgets.chat.input.emoji.EmojiPickerListener
            public void onEmojiPicked(Emoji emoji) {
                m.checkNotNullParameter(emoji, "emoji");
                WidgetGuildRoleSubscriptionTierBenefit.access$getViewModel$p(WidgetGuildRoleSubscriptionTierBenefit.this).updateEmoji(emoji);
                AppFragment.hideKeyboard$default(WidgetGuildRoleSubscriptionTierBenefit.this, null, 1, null);
            }
        }

        /* compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
        /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$onViewBound$3$2, reason: invalid class name */
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
                AppFragment.hideKeyboard$default(WidgetGuildRoleSubscriptionTierBenefit.this, null, 1, null);
            }
        }

        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            FragmentManager parentFragmentManager = WidgetGuildRoleSubscriptionTierBenefit.this.getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            EmojiPickerNavigator.launchBottomSheet(parentFragmentManager, new AnonymousClass1(), new EmojiPickerContextType.Guild(WidgetGuildRoleSubscriptionTierBenefit.access$getGuildId$p(WidgetGuildRoleSubscriptionTierBenefit.this)), new AnonymousClass2());
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$onViewBound$4, reason: invalid class name */
    public static final class AnonymousClass4 extends o implements Function1<Editable, Unit> {
        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            m.checkNotNullParameter(editable, "it");
            WidgetGuildRoleSubscriptionTierBenefit.access$getViewModel$p(WidgetGuildRoleSubscriptionTierBenefit.this).updateDescription(editable.toString());
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$onViewBound$5, reason: invalid class name */
    public static final class AnonymousClass5 implements View.OnClickListener {
        public AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            FragmentActivity fragmentActivityRequireActivity = WidgetGuildRoleSubscriptionTierBenefit.this.requireActivity();
            Intent intent = new Intent();
            intent.putExtra(WidgetGuildRoleSubscriptionTierBenefit.RESULT_EXTRA_EXISTING_BENEFIT, WidgetGuildRoleSubscriptionTierBenefit.access$getExistingBenefit$p(WidgetGuildRoleSubscriptionTierBenefit.this));
            fragmentActivityRequireActivity.setResult(-1, intent);
            AppFragment.hideKeyboard$default(WidgetGuildRoleSubscriptionTierBenefit.this, null, 1, null);
            fragmentActivityRequireActivity.finish();
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<GuildRoleSubscriptionTierBenefitViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionTierBenefitViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionTierBenefitViewModel.ViewState viewState) {
            m.checkNotNullParameter(viewState, "it");
            WidgetGuildRoleSubscriptionTierBenefit.access$configureUI(WidgetGuildRoleSubscriptionTierBenefit.this, viewState);
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<GuildRoleSubscriptionTierBenefitViewModel.Event, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionTierBenefitViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionTierBenefitViewModel.Event event) {
            m.checkNotNullParameter(event, "it");
            WidgetGuildRoleSubscriptionTierBenefit.access$handleEvent(WidgetGuildRoleSubscriptionTierBenefit.this, event);
        }
    }

    public WidgetGuildRoleSubscriptionTierBenefit() {
        super(R.layout.widget_guild_role_subscription_tier_benefit);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildRoleSubscriptionTierBenefit$binding$2.INSTANCE, null, 2, null);
        this.guildId = g.lazy(new WidgetGuildRoleSubscriptionTierBenefit$guildId$2(this));
        this.existingBenefit = g.lazy(new WidgetGuildRoleSubscriptionTierBenefit$existingBenefit$2(this));
        this.benefitType = g.lazy(new WidgetGuildRoleSubscriptionTierBenefit$benefitType$2(this));
        this.tierName = g.lazy(new WidgetGuildRoleSubscriptionTierBenefit$tierName$2(this));
        WidgetGuildRoleSubscriptionTierBenefit$viewModel$2 widgetGuildRoleSubscriptionTierBenefit$viewModel$2 = new WidgetGuildRoleSubscriptionTierBenefit$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(GuildRoleSubscriptionTierBenefitViewModel.class), new WidgetGuildRoleSubscriptionTierBenefit$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetGuildRoleSubscriptionTierBenefit$viewModel$2));
        this.createChannelLauncher = WidgetCreateChannel.INSTANCE.registerForResult(this, new WidgetGuildRoleSubscriptionTierBenefit$createChannelLauncher$1(this));
    }

    public static final /* synthetic */ void access$cancel(WidgetGuildRoleSubscriptionTierBenefit widgetGuildRoleSubscriptionTierBenefit) {
        widgetGuildRoleSubscriptionTierBenefit.cancel();
    }

    public static final /* synthetic */ void access$configureUI(WidgetGuildRoleSubscriptionTierBenefit widgetGuildRoleSubscriptionTierBenefit, GuildRoleSubscriptionTierBenefitViewModel.ViewState viewState) {
        widgetGuildRoleSubscriptionTierBenefit.configureUI(viewState);
    }

    public static final /* synthetic */ GuildRoleSubscriptionBenefitType access$getBenefitType$p(WidgetGuildRoleSubscriptionTierBenefit widgetGuildRoleSubscriptionTierBenefit) {
        return widgetGuildRoleSubscriptionTierBenefit.getBenefitType();
    }

    public static final /* synthetic */ ActivityResultLauncher access$getCreateChannelLauncher$p(WidgetGuildRoleSubscriptionTierBenefit widgetGuildRoleSubscriptionTierBenefit) {
        return widgetGuildRoleSubscriptionTierBenefit.createChannelLauncher;
    }

    public static final /* synthetic */ Benefit access$getExistingBenefit$p(WidgetGuildRoleSubscriptionTierBenefit widgetGuildRoleSubscriptionTierBenefit) {
        return widgetGuildRoleSubscriptionTierBenefit.getExistingBenefit();
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetGuildRoleSubscriptionTierBenefit widgetGuildRoleSubscriptionTierBenefit) {
        return widgetGuildRoleSubscriptionTierBenefit.getGuildId();
    }

    public static final /* synthetic */ String access$getTierName$p(WidgetGuildRoleSubscriptionTierBenefit widgetGuildRoleSubscriptionTierBenefit) {
        return widgetGuildRoleSubscriptionTierBenefit.getTierName();
    }

    public static final /* synthetic */ GuildRoleSubscriptionTierBenefitViewModel access$getViewModel$p(WidgetGuildRoleSubscriptionTierBenefit widgetGuildRoleSubscriptionTierBenefit) {
        return widgetGuildRoleSubscriptionTierBenefit.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetGuildRoleSubscriptionTierBenefit widgetGuildRoleSubscriptionTierBenefit, GuildRoleSubscriptionTierBenefitViewModel.Event event) {
        widgetGuildRoleSubscriptionTierBenefit.handleEvent(event);
    }

    private final void cancel() {
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        fragmentActivityRequireActivity.setResult(0);
        AppFragment.hideKeyboard$default(this, null, 1, null);
        fragmentActivityRequireActivity.finish();
    }

    private final void configureUI(GuildRoleSubscriptionTierBenefitViewModel.ViewState viewState) {
        String string;
        TextView textView = getBinding().n;
        m.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionTierBenefitSubtitle");
        textView.setText(viewState.getTierName());
        Emoji emoji = viewState.getEmoji();
        String imageUri = emoji != null ? emoji.getImageUri(false, f.coerceAtMost(IconUtils.getMediaProxySize(getResources().getDimensionPixelSize(R.dimen.guild_role_subscription_create_benefit_emoji_size)), 64), requireContext()) : null;
        SimpleDraweeView simpleDraweeView = getBinding().h;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.guildRoleSubscriptionTierBenefitEmoji");
        MGImages.setImage$default(simpleDraweeView, imageUri, 0, 0, true, null, null, 108, null);
        if (emoji == null || (string = emoji.getFirstName()) == null) {
            string = getString(R.string.guild_role_subscription_tier_benefits_emoji_placeholder);
            m.checkNotNullExpressionValue(string, "getString(R.string.guild…nefits_emoji_placeholder)");
        }
        TextView textView2 = getBinding().i;
        m.checkNotNullExpressionValue(textView2, "binding.guildRoleSubscriptionTierBenefitEmojiName");
        textView2.setText(string);
        TextInputLayout textInputLayout = getBinding().f;
        m.checkNotNullExpressionValue(textInputLayout, "binding.guildRoleSubscri…ionTierBenefitDescription");
        ViewExtensions.setTextIfDifferent(textInputLayout, viewState.getDescription());
        String name = viewState.getName();
        if (!(name == null || t.isBlank(name))) {
            TextView textView3 = getBinding().j;
            m.checkNotNullExpressionValue(textView3, "binding.guildRoleSubscriptionTierBenefitName");
            textView3.setText(viewState.getName());
            TextInputLayout textInputLayout2 = getBinding().d;
            m.checkNotNullExpressionValue(textInputLayout2, "binding.guildRoleSubscri…tangibleBenefitNameLayout");
            ViewExtensions.setTextIfDifferent(textInputLayout2, viewState.getName());
        }
        TextView textView4 = getBinding().j;
        m.checkNotNullExpressionValue(textView4, "binding.guildRoleSubscriptionTierBenefitName");
        Integer leadingNameIconResId = viewState.getLeadingNameIconResId();
        ViewExtensions.setCompoundDrawableWithIntrinsicBounds$default(textView4, leadingNameIconResId != null ? leadingNameIconResId.intValue() : 0, 0, R.drawable.icon_carrot, 0, 10, null);
        if (getBenefitType() == GuildRoleSubscriptionBenefitType.CHANNEL) {
            getBinding().j.setOnClickListener(new AnonymousClass1(viewState));
        }
        MaterialButton materialButton = getBinding().l;
        m.checkNotNullExpressionValue(materialButton, "binding.guildRoleSubscriptionTierBenefitSave");
        materialButton.setEnabled(viewState.getCanSubmitResult());
    }

    private final void configureUIForChannelBenefit() {
        WidgetChannelPickerBottomSheet.INSTANCE.registerForResult(this, REQUEST_KEY_CHANNEL_PICKER, new AnonymousClass1(), new AnonymousClass2());
        TextView textView = getBinding().f2438b;
        m.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionBenefitChannelLabel");
        textView.setVisibility(0);
        TextView textView2 = getBinding().j;
        m.checkNotNullExpressionValue(textView2, "binding.guildRoleSubscriptionTierBenefitName");
        textView2.setVisibility(0);
        TextView textView3 = getBinding().p;
        m.checkNotNullExpressionValue(textView3, "binding.guildRoleSubscri…TierChannelBenefitWarning");
        textView3.setVisibility(0);
        TextView textView4 = getBinding().o;
        m.checkNotNullExpressionValue(textView4, "binding.guildRoleSubscriptionTierBenefitTitle");
        textView4.setText(getString(R.string.guild_role_subscription_tier_exclusive_channel_title));
        TextInputEditText textInputEditText = getBinding().g;
        m.checkNotNullExpressionValue(textInputEditText, "binding.guildRoleSubscri…enefitDescriptionEditText");
        textInputEditText.setHint(getString(R.string.guild_role_subscription_channel_benefit_description_placeholder));
    }

    private final void configureUIForIntangibleBenefit() {
        TextView textView = getBinding().f2438b;
        m.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionBenefitChannelLabel");
        textView.setVisibility(8);
        TextView textView2 = getBinding().j;
        m.checkNotNullExpressionValue(textView2, "binding.guildRoleSubscriptionTierBenefitName");
        textView2.setVisibility(8);
        TextView textView3 = getBinding().p;
        m.checkNotNullExpressionValue(textView3, "binding.guildRoleSubscri…TierChannelBenefitWarning");
        textView3.setVisibility(8);
        TextInputLayout textInputLayout = getBinding().d;
        m.checkNotNullExpressionValue(textInputLayout, "binding.guildRoleSubscri…tangibleBenefitNameLayout");
        textInputLayout.setVisibility(0);
        TextView textView4 = getBinding().c;
        m.checkNotNullExpressionValue(textView4, "binding.guildRoleSubscri…ntangibleBenefitNameLabel");
        textView4.setVisibility(0);
        TextInputLayout textInputLayout2 = getBinding().d;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.guildRoleSubscri…tangibleBenefitNameLayout");
        ViewExtensions.addBindedTextWatcher(textInputLayout2, this, new AnonymousClass1());
        TextView textView5 = getBinding().o;
        m.checkNotNullExpressionValue(textView5, "binding.guildRoleSubscriptionTierBenefitTitle");
        textView5.setText(getString(R.string.guild_role_subscription_tier_additional_benefit_title));
        TextInputEditText textInputEditText = getBinding().g;
        m.checkNotNullExpressionValue(textInputEditText, "binding.guildRoleSubscri…enefitDescriptionEditText");
        textInputEditText.setHint(getString(R.string.guild_role_subscription_intangible_benefit_description_placeholder));
    }

    private final GuildRoleSubscriptionBenefitType getBenefitType() {
        return (GuildRoleSubscriptionBenefitType) this.benefitType.getValue();
    }

    private final WidgetGuildRoleSubscriptionTierBenefitBinding getBinding() {
        return (WidgetGuildRoleSubscriptionTierBenefitBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final Benefit getExistingBenefit() {
        return (Benefit) this.existingBenefit.getValue();
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final String getTierName() {
        return (String) this.tierName.getValue();
    }

    private final GuildRoleSubscriptionTierBenefitViewModel getViewModel() {
        return (GuildRoleSubscriptionTierBenefitViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(GuildRoleSubscriptionTierBenefitViewModel.Event event) {
        if (event instanceof GuildRoleSubscriptionTierBenefitViewModel.Event.SendResult) {
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            Intent intent = new Intent();
            intent.putExtra(RESULT_EXTRA_EXISTING_BENEFIT, getExistingBenefit());
            intent.putExtra(RESULT_EXTRA_BENEFIT, ((GuildRoleSubscriptionTierBenefitViewModel.Event.SendResult) event).getBenefit());
            fragmentActivityRequireActivity.setResult(-1, intent);
            AppFragment.hideKeyboard$default(this, null, 1, null);
            fragmentActivityRequireActivity.finish();
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        int iOrdinal = getBenefitType().ordinal();
        if (iOrdinal == 0) {
            AppLog appLog = AppLog.g;
            StringBuilder sbU = a.U("Unknown benefit type: ");
            sbU.append(getBenefitType());
            Logger.e$default(appLog, sbU.toString(), null, null, 6, null);
            b.a.d.m.i(this, R.string.default_failure_to_perform_action_message, 0, 4);
            cancel();
        } else if (iOrdinal == 1) {
            configureUIForChannelBenefit();
        } else if (iOrdinal == 2) {
            configureUIForIntangibleBenefit();
        }
        getBinding().l.setOnClickListener(new AnonymousClass1());
        getBinding().e.setOnClickListener(new AnonymousClass2());
        getBinding().m.setOnClickListener(new AnonymousClass3());
        TextInputLayout textInputLayout = getBinding().f;
        m.checkNotNullExpressionValue(textInputLayout, "binding.guildRoleSubscri…ionTierBenefitDescription");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new AnonymousClass4());
        getBinding().k.setOnClickListener(new AnonymousClass5());
        MaterialButton materialButton = getBinding().k;
        m.checkNotNullExpressionValue(materialButton, "binding.guildRoleSubscriptionTierBenefitRemove");
        materialButton.setVisibility(getExistingBenefit() != null ? 0 : 8);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetGuildRoleSubscriptionTierBenefit.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetGuildRoleSubscriptionTierBenefit.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
    }
}
