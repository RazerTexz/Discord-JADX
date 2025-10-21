package com.discord.widgets.auth;

import com.discord.samsung.SamsungConnectActivity;
import com.discord.utilities.KotlinExtensions;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetOauth2AuthorizeSamsung.kt */
/* renamed from: com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung$samsungConnectLauncher$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetOauth2AuthorizeSamsung5 extends Lambda implements Function1<SamsungConnectActivity.Result, Unit> {
    public final /* synthetic */ WidgetOauth2AuthorizeSamsung this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetOauth2AuthorizeSamsung5(WidgetOauth2AuthorizeSamsung widgetOauth2AuthorizeSamsung) {
        super(1);
        this.this$0 = widgetOauth2AuthorizeSamsung;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SamsungConnectActivity.Result result) {
        invoke2(result);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(SamsungConnectActivity.Result result) {
        Unit unit;
        Intrinsics3.checkNotNullParameter(result, "result");
        if (result instanceof SamsungConnectActivity.Result.Success) {
            WidgetOauth2AuthorizeSamsung.access$handleConnectActivitySuccess(this.this$0, (SamsungConnectActivity.Result.Success) result);
            unit = Unit.a;
        } else {
            if (!(result instanceof SamsungConnectActivity.Result.Failure)) {
                throw new NoWhenBranchMatchedException();
            }
            WidgetOauth2AuthorizeSamsung.access$handleConnectActivityFailure(this.this$0, (SamsungConnectActivity.Result.Failure) result);
            unit = Unit.a;
        }
        KotlinExtensions.getExhaustive(unit);
    }
}
