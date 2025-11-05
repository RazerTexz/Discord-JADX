package com.discord.widgets.auth;

import android.view.View;
import android.widget.LinearLayout;
import b.a.d.AppToast;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.utilities.view.validators.Input;
import com.discord.utilities.view.validators.InputValidator;
import com.discord.utilities.view.validators.ValidationManager;
import d0.g0.StringNumberConversions;
import d0.g0.Strings4;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetOauth2Authorize.kt */
/* renamed from: com.discord.widgets.auth.WidgetOauth2Authorize$validationManager$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetOauth2Authorize9 extends Lambda implements Function0<ValidationManager> {
    public final /* synthetic */ WidgetOauth2Authorize this$0;

    /* compiled from: WidgetOauth2Authorize.kt */
    /* renamed from: com.discord.widgets.auth.WidgetOauth2Authorize$validationManager$2$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Input<View> {
        public AnonymousClass1(String str, View view, InputValidator[] inputValidatorArr) {
            super(str, view, inputValidatorArr);
        }

        @Override // com.discord.utilities.view.validators.Input
        public boolean setErrorMessage(CharSequence errorMessage) {
            if (errorMessage == null) {
                return false;
            }
            AppToast.h(getView().getContext(), FormatUtils.l(errorMessage, new Object[0], null, 2), 1, null, 8);
            return true;
        }
    }

    /* compiled from: WidgetOauth2Authorize.kt */
    /* renamed from: com.discord.widgets.auth.WidgetOauth2Authorize$validationManager$2$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Input<View> {
        public AnonymousClass2(String str, View view, InputValidator[] inputValidatorArr) {
            super(str, view, inputValidatorArr);
        }

        @Override // com.discord.utilities.view.validators.Input
        public boolean setErrorMessage(CharSequence errorMessage) {
            if (errorMessage == null) {
                return false;
            }
            Integer intOrNull = StringNumberConversions.toIntOrNull(errorMessage.toString());
            String string = (String) _Collections.getOrNull(Strings4.split$default((CharSequence) WidgetOauth2Authorize9.this.this$0.getOauth2ViewModel().getOauthAuthorize().getScope(), new char[]{' '}, false, 0, 6, (Object) null), intOrNull != null ? intOrNull.intValue() : -1);
            if (string == null) {
                StringBuilder sb = new StringBuilder();
                sb.append('[');
                sb.append(errorMessage);
                sb.append(']');
                string = sb.toString();
            }
            AppToast.h(getView().getContext(), FormatUtils.j(getView(), R.string.oauth2_request_invalid_scope, new Object[]{string}, null, 4), 1, null, 8);
            return true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetOauth2Authorize9(WidgetOauth2Authorize widgetOauth2Authorize) {
        super(0);
        this.this$0 = widgetOauth2Authorize;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ValidationManager invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ValidationManager invoke() {
        LinearLayout linearLayout = this.this$0.getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.oauthAuthorizeLoading");
        LinearLayout linearLayout2 = this.this$0.getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.oauthAuthorizeLoading");
        return new ValidationManager(new AnonymousClass1("_root", linearLayout, new InputValidator[0]), new AnonymousClass2("scope", linearLayout2, new InputValidator[0]));
    }
}
