package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.discord.widgets.guild_role_subscriptions.tier.model.Benefit;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
/* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$Companion$registerForResult$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierBenefit2<O> implements ActivityResultCallback<ActivityResult> {
    public final /* synthetic */ Function2 $onBenefitUpdate;

    public WidgetGuildRoleSubscriptionTierBenefit2(Function2 function2) {
        this.$onBenefitUpdate = function2;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public /* bridge */ /* synthetic */ void onActivityResult(ActivityResult activityResult) {
        onActivityResult2(activityResult);
    }

    /* renamed from: onActivityResult, reason: avoid collision after fix types in other method */
    public final void onActivityResult2(ActivityResult activityResult) {
        Intrinsics3.checkNotNullExpressionValue(activityResult, "activityResult");
        if (activityResult.getResultCode() == -1) {
            Intent data = activityResult.getData();
            Benefit benefit = data != null ? (Benefit) data.getParcelableExtra("RESULT_EXTRA_BENEFIT") : null;
            Intent data2 = activityResult.getData();
            Benefit benefit2 = data2 != null ? (Benefit) data2.getParcelableExtra("RESULT_EXTRA_EXISTING_BENEFIT") : null;
            if (benefit == null && benefit2 == null) {
                return;
            }
            this.$onBenefitUpdate.invoke(benefit2, benefit);
        }
    }
}
