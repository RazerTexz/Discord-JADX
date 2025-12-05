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
import com.discord.C5419R;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefitType;
import com.discord.app.AppFragment;
import com.discord.app.AppLog;
import com.discord.databinding.WidgetGuildRoleSubscriptionTierBenefitBinding;
import com.discord.models.domain.emoji.Emoji;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
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
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p018d.AppToast;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.p512d0._Ranges;
import p507d0.p579g0.StringsJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;

/* compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
/* loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierBenefit extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetGuildRoleSubscriptionTierBenefit.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildRoleSubscriptionTierBenefitBinding;", 0)};

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
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(launcher, "launcher");
            Intrinsics3.checkNotNullParameter(benefitType, "benefitType");
            AppScreen2 appScreen2 = AppScreen2.f524g;
            Intent intent = new Intent();
            intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            intent.putExtra(WidgetGuildRoleSubscriptionTierBenefit.INTENT_EXTRA_EXISTING_BENEFIT, benefit);
            intent.putExtra(WidgetGuildRoleSubscriptionTierBenefit.INTENT_EXTRA_BENEFIT_TYPE, benefitType);
            intent.putExtra(WidgetGuildRoleSubscriptionTierBenefit.INTENT_EXTRA_TIER_NAME, tierName);
            appScreen2.m160f(context, launcher, WidgetGuildRoleSubscriptionTierBenefit.class, intent);
        }

        public final ActivityResultLauncher<Intent> registerForResult(AppFragment fragment, Function2<? super Benefit, ? super Benefit, Unit> onBenefitUpdate) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(onBenefitUpdate, "onBenefitUpdate");
            ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new WidgetGuildRoleSubscriptionTierBenefit2(onBenefitUpdate));
            Intrinsics3.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…  }\n          }\n        }");
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
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$configureUI$1 */
    public static final class ViewOnClickListenerC85281 implements View.OnClickListener {
        public final /* synthetic */ GuildRoleSubscriptionTierBenefitViewModel.ViewState $viewState;

        /* compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
        /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$configureUI$1$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AppFragment.hideKeyboard$default(WidgetGuildRoleSubscriptionTierBenefit.this, null, 1, null);
            }
        }

        public ViewOnClickListenerC85281(GuildRoleSubscriptionTierBenefitViewModel.ViewState viewState) {
            this.$viewState = viewState;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChannelPickerBottomSheet.Companion companion = WidgetChannelPickerBottomSheet.INSTANCE;
            WidgetGuildRoleSubscriptionTierBenefit widgetGuildRoleSubscriptionTierBenefit = WidgetGuildRoleSubscriptionTierBenefit.this;
            companion.launch(widgetGuildRoleSubscriptionTierBenefit, WidgetGuildRoleSubscriptionTierBenefit.REQUEST_KEY_CHANNEL_PICKER, WidgetGuildRoleSubscriptionTierBenefit.access$getGuildId$p(widgetGuildRoleSubscriptionTierBenefit), this.$viewState.getChannelId(), new AnonymousClass1(), true);
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$configureUIForChannelBenefit$1 */
    public static final class C85291 extends Lambda implements Function3<Long, String, Integer, Unit> {
        public C85291() {
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Long l, String str, Integer num) {
            invoke(l.longValue(), str, num.intValue());
            return Unit.f27425a;
        }

        public final void invoke(long j, String str, int i) {
            Intrinsics3.checkNotNullParameter(str, "channelName");
            WidgetGuildRoleSubscriptionTierBenefit.access$getViewModel$p(WidgetGuildRoleSubscriptionTierBenefit.this).updateChannel(j, str, Integer.valueOf(i));
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$configureUIForChannelBenefit$2 */
    public static final class C85302 extends Lambda implements Function0<Unit> {
        public C85302() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetCreateChannel.Companion.launch$default(WidgetCreateChannel.INSTANCE, WidgetGuildRoleSubscriptionTierBenefit.this.requireContext(), WidgetGuildRoleSubscriptionTierBenefit.access$getCreateChannelLauncher$p(WidgetGuildRoleSubscriptionTierBenefit.this), WidgetGuildRoleSubscriptionTierBenefit.access$getGuildId$p(WidgetGuildRoleSubscriptionTierBenefit.this), 0, null, true, true, true, true, 24, null);
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$configureUIForIntangibleBenefit$1 */
    public static final class C85311 extends Lambda implements Function1<Editable, Unit> {
        public C85311() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "it");
            WidgetGuildRoleSubscriptionTierBenefit.access$getViewModel$p(WidgetGuildRoleSubscriptionTierBenefit.this).updateName(editable.toString());
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$onViewBound$1 */
    public static final class ViewOnClickListenerC85321 implements View.OnClickListener {
        public ViewOnClickListenerC85321() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildRoleSubscriptionTierBenefit.access$getViewModel$p(WidgetGuildRoleSubscriptionTierBenefit.this).submitResult();
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$onViewBound$2 */
    public static final class ViewOnClickListenerC85332 implements View.OnClickListener {
        public ViewOnClickListenerC85332() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildRoleSubscriptionTierBenefit.access$cancel(WidgetGuildRoleSubscriptionTierBenefit.this);
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$onViewBound$3 */
    public static final class ViewOnClickListenerC85343 implements View.OnClickListener {

        /* compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
        /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$onViewBound$3$1, reason: invalid class name */
        public static final class AnonymousClass1 implements EmojiPickerListener {
            public AnonymousClass1() {
            }

            @Override // com.discord.widgets.chat.input.emoji.EmojiPickerListener
            public void onEmojiPicked(Emoji emoji) {
                Intrinsics3.checkNotNullParameter(emoji, "emoji");
                WidgetGuildRoleSubscriptionTierBenefit.access$getViewModel$p(WidgetGuildRoleSubscriptionTierBenefit.this).updateEmoji(emoji);
                AppFragment.hideKeyboard$default(WidgetGuildRoleSubscriptionTierBenefit.this, null, 1, null);
            }
        }

        /* compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
        /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$onViewBound$3$2, reason: invalid class name */
        public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
            public AnonymousClass2() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AppFragment.hideKeyboard$default(WidgetGuildRoleSubscriptionTierBenefit.this, null, 1, null);
            }
        }

        public ViewOnClickListenerC85343() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            FragmentManager parentFragmentManager = WidgetGuildRoleSubscriptionTierBenefit.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            EmojiPickerNavigator.launchBottomSheet(parentFragmentManager, new AnonymousClass1(), new EmojiPickerContextType.Guild(WidgetGuildRoleSubscriptionTierBenefit.access$getGuildId$p(WidgetGuildRoleSubscriptionTierBenefit.this)), new AnonymousClass2());
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$onViewBound$4 */
    public static final class C85354 extends Lambda implements Function1<Editable, Unit> {
        public C85354() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "it");
            WidgetGuildRoleSubscriptionTierBenefit.access$getViewModel$p(WidgetGuildRoleSubscriptionTierBenefit.this).updateDescription(editable.toString());
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$onViewBound$5 */
    public static final class ViewOnClickListenerC85365 implements View.OnClickListener {
        public ViewOnClickListenerC85365() {
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
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$onViewBoundOrOnResume$1 */
    public static final class C85371 extends Lambda implements Function1<GuildRoleSubscriptionTierBenefitViewModel.ViewState, Unit> {
        public C85371() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionTierBenefitViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionTierBenefitViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "it");
            WidgetGuildRoleSubscriptionTierBenefit.access$configureUI(WidgetGuildRoleSubscriptionTierBenefit.this, viewState);
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$onViewBoundOrOnResume$2 */
    public static final class C85382 extends Lambda implements Function1<GuildRoleSubscriptionTierBenefitViewModel.Event, Unit> {
        public C85382() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionTierBenefitViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionTierBenefitViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "it");
            WidgetGuildRoleSubscriptionTierBenefit.access$handleEvent(WidgetGuildRoleSubscriptionTierBenefit.this, event);
        }
    }

    public WidgetGuildRoleSubscriptionTierBenefit() {
        super(C5419R.layout.widget_guild_role_subscription_tier_benefit);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildRoleSubscriptionTierBenefit4.INSTANCE, null, 2, null);
        this.guildId = LazyJVM.lazy(new WidgetGuildRoleSubscriptionTierBenefit7(this));
        this.existingBenefit = LazyJVM.lazy(new WidgetGuildRoleSubscriptionTierBenefit6(this));
        this.benefitType = LazyJVM.lazy(new WidgetGuildRoleSubscriptionTierBenefit3(this));
        this.tierName = LazyJVM.lazy(new WidgetGuildRoleSubscriptionTierBenefit8(this));
        WidgetGuildRoleSubscriptionTierBenefit9 widgetGuildRoleSubscriptionTierBenefit9 = new WidgetGuildRoleSubscriptionTierBenefit9(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildRoleSubscriptionTierBenefitViewModel.class), new C8527x29c71454(appViewModelDelegates3), new AppViewModelDelegates5(widgetGuildRoleSubscriptionTierBenefit9));
        this.createChannelLauncher = WidgetCreateChannel.INSTANCE.registerForResult(this, new WidgetGuildRoleSubscriptionTierBenefit5(this));
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
        TextView textView = getBinding().f16952n;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionTierBenefitSubtitle");
        textView.setText(viewState.getTierName());
        Emoji emoji = viewState.getEmoji();
        String imageUri = emoji != null ? emoji.getImageUri(false, _Ranges.coerceAtMost(IconUtils.getMediaProxySize(getResources().getDimensionPixelSize(C5419R.dimen.guild_role_subscription_create_benefit_emoji_size)), 64), requireContext()) : null;
        SimpleDraweeView simpleDraweeView = getBinding().f16946h;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.guildRoleSubscriptionTierBenefitEmoji");
        MGImages.setImage$default(simpleDraweeView, imageUri, 0, 0, true, null, null, 108, null);
        if (emoji == null || (string = emoji.getFirstName()) == null) {
            string = getString(C5419R.string.guild_role_subscription_tier_benefits_emoji_placeholder);
            Intrinsics3.checkNotNullExpressionValue(string, "getString(R.string.guild…nefits_emoji_placeholder)");
        }
        TextView textView2 = getBinding().f16947i;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildRoleSubscriptionTierBenefitEmojiName");
        textView2.setText(string);
        TextInputLayout textInputLayout = getBinding().f16944f;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.guildRoleSubscri…ionTierBenefitDescription");
        ViewExtensions.setTextIfDifferent(textInputLayout, viewState.getDescription());
        String name = viewState.getName();
        if (!(name == null || StringsJVM.isBlank(name))) {
            TextView textView3 = getBinding().f16948j;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.guildRoleSubscriptionTierBenefitName");
            textView3.setText(viewState.getName());
            TextInputLayout textInputLayout2 = getBinding().f16942d;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.guildRoleSubscri…tangibleBenefitNameLayout");
            ViewExtensions.setTextIfDifferent(textInputLayout2, viewState.getName());
        }
        TextView textView4 = getBinding().f16948j;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.guildRoleSubscriptionTierBenefitName");
        Integer leadingNameIconResId = viewState.getLeadingNameIconResId();
        ViewExtensions.setCompoundDrawableWithIntrinsicBounds$default(textView4, leadingNameIconResId != null ? leadingNameIconResId.intValue() : 0, 0, C5419R.drawable.icon_carrot, 0, 10, null);
        if (getBenefitType() == GuildRoleSubscriptionBenefitType.CHANNEL) {
            getBinding().f16948j.setOnClickListener(new ViewOnClickListenerC85281(viewState));
        }
        MaterialButton materialButton = getBinding().f16950l;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.guildRoleSubscriptionTierBenefitSave");
        materialButton.setEnabled(viewState.getCanSubmitResult());
    }

    private final void configureUIForChannelBenefit() {
        WidgetChannelPickerBottomSheet.INSTANCE.registerForResult(this, REQUEST_KEY_CHANNEL_PICKER, new C85291(), new C85302());
        TextView textView = getBinding().f16940b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionBenefitChannelLabel");
        textView.setVisibility(0);
        TextView textView2 = getBinding().f16948j;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildRoleSubscriptionTierBenefitName");
        textView2.setVisibility(0);
        TextView textView3 = getBinding().f16954p;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.guildRoleSubscri…TierChannelBenefitWarning");
        textView3.setVisibility(0);
        TextView textView4 = getBinding().f16953o;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.guildRoleSubscriptionTierBenefitTitle");
        textView4.setText(getString(C5419R.string.guild_role_subscription_tier_exclusive_channel_title));
        TextInputEditText textInputEditText = getBinding().f16945g;
        Intrinsics3.checkNotNullExpressionValue(textInputEditText, "binding.guildRoleSubscri…enefitDescriptionEditText");
        textInputEditText.setHint(getString(C5419R.string.guild_role_subscription_channel_benefit_description_placeholder));
    }

    private final void configureUIForIntangibleBenefit() {
        TextView textView = getBinding().f16940b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionBenefitChannelLabel");
        textView.setVisibility(8);
        TextView textView2 = getBinding().f16948j;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildRoleSubscriptionTierBenefitName");
        textView2.setVisibility(8);
        TextView textView3 = getBinding().f16954p;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.guildRoleSubscri…TierChannelBenefitWarning");
        textView3.setVisibility(8);
        TextInputLayout textInputLayout = getBinding().f16942d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.guildRoleSubscri…tangibleBenefitNameLayout");
        textInputLayout.setVisibility(0);
        TextView textView4 = getBinding().f16941c;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.guildRoleSubscri…ntangibleBenefitNameLabel");
        textView4.setVisibility(0);
        TextInputLayout textInputLayout2 = getBinding().f16942d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.guildRoleSubscri…tangibleBenefitNameLayout");
        ViewExtensions.addBindedTextWatcher(textInputLayout2, this, new C85311());
        TextView textView5 = getBinding().f16953o;
        Intrinsics3.checkNotNullExpressionValue(textView5, "binding.guildRoleSubscriptionTierBenefitTitle");
        textView5.setText(getString(C5419R.string.guild_role_subscription_tier_additional_benefit_title));
        TextInputEditText textInputEditText = getBinding().f16945g;
        Intrinsics3.checkNotNullExpressionValue(textInputEditText, "binding.guildRoleSubscri…enefitDescriptionEditText");
        textInputEditText.setHint(getString(C5419R.string.f14678xecdcb48b));
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
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        int iOrdinal = getBenefitType().ordinal();
        if (iOrdinal == 0) {
            AppLog appLog = AppLog.f14950g;
            StringBuilder sbM833U = outline.m833U("Unknown benefit type: ");
            sbM833U.append(getBenefitType());
            Logger.e$default(appLog, sbM833U.toString(), null, null, 6, null);
            AppToast.m171i(this, C5419R.string.default_failure_to_perform_action_message, 0, 4);
            cancel();
        } else if (iOrdinal == 1) {
            configureUIForChannelBenefit();
        } else if (iOrdinal == 2) {
            configureUIForIntangibleBenefit();
        }
        getBinding().f16950l.setOnClickListener(new ViewOnClickListenerC85321());
        getBinding().f16943e.setOnClickListener(new ViewOnClickListenerC85332());
        getBinding().f16951m.setOnClickListener(new ViewOnClickListenerC85343());
        TextInputLayout textInputLayout = getBinding().f16944f;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.guildRoleSubscri…ionTierBenefitDescription");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new C85354());
        getBinding().f16949k.setOnClickListener(new ViewOnClickListenerC85365());
        MaterialButton materialButton = getBinding().f16949k;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.guildRoleSubscriptionTierBenefitRemove");
        materialButton.setVisibility(getExistingBenefit() != null ? 0 : 8);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetGuildRoleSubscriptionTierBenefit.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C85371(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetGuildRoleSubscriptionTierBenefit.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C85382(), 62, (Object) null);
    }
}
