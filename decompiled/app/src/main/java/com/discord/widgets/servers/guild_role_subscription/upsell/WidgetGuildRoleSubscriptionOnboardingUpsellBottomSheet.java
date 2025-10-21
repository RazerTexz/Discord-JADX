package com.discord.widgets.servers.guild_role_subscription.upsell;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.core.os.Bundle2;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppLogger2;
import com.discord.databinding.WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheetBinding;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.servers.creator_monetization_eligibility.onboarding.WidgetServerSettingsCreatorMonetizationOnboarding;
import d0.LazyJVM;
import d0.Tuples;
import d0.z.d.Intrinsics3;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet.kt */
/* loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* compiled from: WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, long guildId) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet widgetGuildRoleSubscriptionOnboardingUpsellBottomSheet = new WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet();
            widgetGuildRoleSubscriptionOnboardingUpsellBottomSheet.setArguments(Bundle2.bundleOf(Tuples.to("com.discord.intent.extra.EXTRA_GUILD_ID", Long.valueOf(guildId))));
            widgetGuildRoleSubscriptionOnboardingUpsellBottomSheet.show(fragmentManager, WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet.class.getSimpleName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet.kt */
    /* renamed from: com.discord.widgets.servers.guild_role_subscription.upsell.WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet$onViewCreated$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsCreatorMonetizationOnboarding.Companion companion = WidgetServerSettingsCreatorMonetizationOnboarding.INSTANCE;
            Context contextRequireContext = WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet.this.requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            companion.launch(contextRequireContext, WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet.access$getGuildId$p(WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet.this));
            WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet.this.dismiss();
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet.kt */
    /* renamed from: com.discord.widgets.servers.guild_role_subscription.upsell.WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet$onViewCreated$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet.this.dismiss();
        }
    }

    public WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet2.INSTANCE, null, 2, null);
        this.guildId = LazyJVM.lazy(new WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet3(this));
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet widgetGuildRoleSubscriptionOnboardingUpsellBottomSheet) {
        return widgetGuildRoleSubscriptionOnboardingUpsellBottomSheet.getArgumentsOrDefault();
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet widgetGuildRoleSubscriptionOnboardingUpsellBottomSheet) {
        return widgetGuildRoleSubscriptionOnboardingUpsellBottomSheet.getGuildId();
    }

    private final WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheetBinding getBinding() {
        return (WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_guild_role_subscription_onboarding_upsell_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, com.discord.app.AppLogger.a
    public AppLogger2 getLoggingConfig() {
        return new AppLogger2(false, null, new WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet4(this), 3);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().c.setOnClickListener(new AnonymousClass1());
        getBinding().f2435b.setOnClickListener(new AnonymousClass2());
    }
}
