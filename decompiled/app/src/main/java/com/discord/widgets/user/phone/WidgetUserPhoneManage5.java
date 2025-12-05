package com.discord.widgets.user.phone;

import androidx.fragment.app.FragmentActivity;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetUserPhoneManage.kt */
/* renamed from: com.discord.widgets.user.phone.WidgetUserPhoneManage$phoneVerificationLauncher$1, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetUserPhoneManage5 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ WidgetUserPhoneManage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserPhoneManage5(WidgetUserPhoneManage widgetUserPhoneManage) {
        super(0);
        this.this$0 = widgetUserPhoneManage;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.f27425a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        FragmentActivity fragmentActivityRequireActivity = this.this$0.requireActivity();
        Intrinsics3.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        if (fragmentActivityRequireActivity.getCallingActivity() != null) {
            FragmentActivity activity = this.this$0.getActivity();
            if (activity != null) {
                activity.setResult(-1);
            }
            FragmentActivity activity2 = this.this$0.getActivity();
            if (activity2 != null) {
                activity2.finish();
            }
        }
    }
}
