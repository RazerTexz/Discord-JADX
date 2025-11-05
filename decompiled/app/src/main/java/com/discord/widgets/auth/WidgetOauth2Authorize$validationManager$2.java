package com.discord.widgets.auth;

import android.view.View;
import android.widget.LinearLayout;
import b.a.d.m;
import b.a.k.b;
import com.discord.R;
import com.discord.utilities.view.validators.Input;
import com.discord.utilities.view.validators.InputValidator;
import com.discord.utilities.view.validators.ValidationManager;
import d0.g0.s;
import d0.g0.w;
import d0.t.u;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetOauth2Authorize.kt */
/* loaded from: classes2.dex */
public final class WidgetOauth2Authorize$validationManager$2 extends o implements Function0<ValidationManager> {
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
            m.h(getView().getContext(), b.l(errorMessage, new Object[0], null, 2), 1, null, 8);
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
            Integer intOrNull = s.toIntOrNull(errorMessage.toString());
            String string = (String) u.getOrNull(w.split$default((CharSequence) WidgetOauth2Authorize$validationManager$2.this.this$0.getOauth2ViewModel().getOauthAuthorize().getScope(), new char[]{' '}, false, 0, 6, (Object) null), intOrNull != null ? intOrNull.intValue() : -1);
            if (string == null) {
                StringBuilder sb = new StringBuilder();
                sb.append('[');
                sb.append(errorMessage);
                sb.append(']');
                string = sb.toString();
            }
            m.h(getView().getContext(), b.j(getView(), R.string.oauth2_request_invalid_scope, new Object[]{string}, null, 4), 1, null, 8);
            return true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetOauth2Authorize$validationManager$2(WidgetOauth2Authorize widgetOauth2Authorize) {
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
        d0.z.d.m.checkNotNullExpressionValue(linearLayout, "binding.oauthAuthorizeLoading");
        LinearLayout linearLayout2 = this.this$0.getBinding().h;
        d0.z.d.m.checkNotNullExpressionValue(linearLayout2, "binding.oauthAuthorizeLoading");
        return new ValidationManager(new AnonymousClass1("_root", linearLayout, new InputValidator[0]), new AnonymousClass2("scope", linearLayout2, new InputValidator[0]));
    }
}
