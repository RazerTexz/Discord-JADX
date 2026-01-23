package com.discord.widgets.auth;

import android.view.View;
import android.widget.LinearLayout;
import com.discord.C5419R;
import com.discord.utilities.view.validators.Input;
import com.discord.utilities.view.validators.InputValidator;
import com.discord.utilities.view.validators.ValidationManager;
import kotlin.jvm.functions.Function0;
import p007b.p008a.p018d.AppToast;
import p007b.p008a.p027k.FormatUtils;
import p507d0.p579g0.StringNumberConversions;
import p507d0.p579g0.Strings4;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.auth.WidgetOauth2Authorize$validationManager$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetOauth2Authorize.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetOauth2Authorize9 extends Lambda implements Function0<ValidationManager> {
    public final /* synthetic */ WidgetOauth2Authorize this$0;

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetOauth2Authorize$validationManager$2$1 */
    /* JADX INFO: compiled from: WidgetOauth2Authorize.kt */
    public static final class C72501 extends Input<View> {
        public C72501(String str, View view, InputValidator[] inputValidatorArr) {
            super(str, view, inputValidatorArr);
        }

        @Override // com.discord.utilities.view.validators.Input
        public boolean setErrorMessage(CharSequence errorMessage) {
            if (errorMessage == null) {
                return false;
            }
            AppToast.m170h(getView().getContext(), FormatUtils.m220l(errorMessage, new Object[0], null, 2), 1, null, 8);
            return true;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetOauth2Authorize$validationManager$2$2 */
    /* JADX INFO: compiled from: WidgetOauth2Authorize.kt */
    public static final class C72512 extends Input<View> {
        public C72512(String str, View view, InputValidator[] inputValidatorArr) {
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
            AppToast.m170h(getView().getContext(), FormatUtils.m218j(getView(), C5419R.string.oauth2_request_invalid_scope, new Object[]{string}, null, 4), 1, null, 8);
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
        LinearLayout linearLayout = this.this$0.getBinding().f17336h;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.oauthAuthorizeLoading");
        LinearLayout linearLayout2 = this.this$0.getBinding().f17336h;
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.oauthAuthorizeLoading");
        return new ValidationManager(new C72501("_root", linearLayout, new InputValidator[0]), new C72512("scope", linearLayout2, new InputValidator[0]));
    }
}
