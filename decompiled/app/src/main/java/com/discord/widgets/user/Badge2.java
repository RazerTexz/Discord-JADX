package com.discord.widgets.user;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p009a.p012b.MultiValuePropPremiumUpsellDialog;
import p007b.p008a.p018d.AppToast;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: Badge.kt */
/* renamed from: com.discord.widgets.user.Badge$Companion$onBadgeClick$1, reason: use source file name */
/* loaded from: classes.dex */
public final class Badge2 extends Lambda implements Function1<Badge, Unit> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ FragmentManager $fragmentManager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Badge2(FragmentManager fragmentManager, Context context) {
        super(1);
        this.$fragmentManager = fragmentManager;
        this.$context = context;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Badge badge) {
        invoke2(badge);
        return Unit.f27425a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Badge badge) {
        Intrinsics3.checkNotNullParameter(badge, "badge");
        if (badge.getShowPremiumUpSell()) {
            MultiValuePropPremiumUpsellDialog.Companion.m114a(MultiValuePropPremiumUpsellDialog.INSTANCE, this.$fragmentManager, 5, this.$context.getString(C5419R.string.premium_upsell_badge_active_mobile), null, null, "Profile Modal", "Badge", badge.getObjectType(), false, false, 792);
            return;
        }
        Context context = this.$context;
        CharSequence tooltip = badge.getTooltip();
        if (tooltip == null) {
            tooltip = badge.getText();
        }
        AppToast.m170h(context, tooltip, 0, null, 12);
    }
}
