package com.discord.widgets.auth;

import com.discord.utilities.auth.RegistrationFlowRepo;
import com.discord.views.phone.PhoneOrEmailInputView;
import com.discord.widgets.auth.WidgetAuthPhoneVerify;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p018d.AppScreen2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetAuthRegisterIdentity.kt */
/* renamed from: com.discord.widgets.auth.WidgetAuthRegisterIdentity$phoneVerifyLauncher$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetAuthRegisterIdentity7 extends Lambda implements Function1<WidgetAuthPhoneVerify.Result, Unit> {
    public final /* synthetic */ WidgetAuthRegisterIdentity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAuthRegisterIdentity7(WidgetAuthRegisterIdentity widgetAuthRegisterIdentity) {
        super(1);
        this.this$0 = widgetAuthRegisterIdentity;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetAuthPhoneVerify.Result result) {
        invoke2(result);
        return Unit.f27425a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetAuthPhoneVerify.Result result) {
        Intrinsics3.checkNotNullParameter(result, "result");
        if (!(result instanceof WidgetAuthPhoneVerify.Result.Token)) {
            if (result instanceof WidgetAuthPhoneVerify.Result.Cancelled) {
                WidgetAuthRegisterIdentity.access$setInputMode(this.this$0, PhoneOrEmailInputView.Mode.EMAIL);
            }
        } else {
            RegistrationFlowRepo.Companion companion = RegistrationFlowRepo.INSTANCE;
            RegistrationFlowRepo.trackTransition$default(companion.getINSTANCE(), "Phone Verification", "success", null, 4, null);
            companion.getINSTANCE().setPhoneToken(((WidgetAuthPhoneVerify.Result.Token) result).getToken());
            AppScreen2.m157e(this.this$0.requireContext(), WidgetAuthRegisterAccountInformation.class, null, 4);
        }
    }
}
