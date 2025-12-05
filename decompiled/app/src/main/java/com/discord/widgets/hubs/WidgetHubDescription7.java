package com.discord.widgets.hubs;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.view.validators.BasicTextInputValidator;
import com.discord.utilities.view.validators.Input;
import com.discord.utilities.view.validators.InputValidator;
import com.discord.utilities.view.validators.ValidationManager;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import p007b.p008a.p027k.FormatUtils;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetHubDescription.kt */
/* renamed from: com.discord.widgets.hubs.WidgetHubDescription$validationManager$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetHubDescription7 extends Lambda implements Function0<ValidationManager> {
    public final /* synthetic */ WidgetHubDescription this$0;

    /* compiled from: WidgetHubDescription.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubDescription$validationManager$2$1 */
    public static final class C90121 implements InputValidator<LinearLayout> {
        public C90121() {
        }

        @Override // com.discord.utilities.view.validators.InputValidator
        public /* bridge */ /* synthetic */ CharSequence getErrorMessage(LinearLayout linearLayout) {
            return getErrorMessage2(linearLayout);
        }

        /* renamed from: getErrorMessage, reason: avoid collision after fix types in other method */
        public CharSequence getErrorMessage2(LinearLayout view) {
            Intrinsics3.checkNotNullParameter(view, "view");
            if (WidgetHubDescription7.this.this$0.getViewModel().getCategory() != null) {
                return null;
            }
            return view.getContext().getString(C5419R.string.billing_address_address_error_required);
        }
    }

    /* compiled from: WidgetHubDescription.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubDescription$validationManager$2$2 */
    public static final class C90132 extends Lambda implements Function2<LinearLayout, CharSequence, Boolean> {
        public C90132() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Boolean invoke(LinearLayout linearLayout, CharSequence charSequence) {
            return Boolean.valueOf(invoke2(linearLayout, charSequence));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(LinearLayout linearLayout, CharSequence charSequence) {
            Intrinsics3.checkNotNullParameter(linearLayout, "<anonymous parameter 0>");
            Intrinsics3.checkNotNullParameter(charSequence, "errorMessage");
            TextView textView = WidgetHubDescription7.this.this$0.getBinding().f17157d;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.categoryError");
            FormatUtils.m209a(textView, charSequence);
            return true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubDescription7(WidgetHubDescription widgetHubDescription) {
        super(0);
        this.this$0 = widgetHubDescription;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ValidationManager invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ValidationManager invoke() {
        TextInputLayout textInputLayout = this.this$0.getBinding().f17160g;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.descriptionLayout");
        InputValidator[] inputValidatorArr = {BasicTextInputValidator.INSTANCE.createRequiredInputValidator(C5419R.string.member_verification_form_required_item)};
        LinearLayout linearLayout = this.this$0.getBinding().f17158e;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.categoryLayout");
        return new ValidationManager(new Input.TextInputLayoutInput(ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, textInputLayout, inputValidatorArr), new Input.GenericInput("category", linearLayout, new C90121(), new C90132()));
    }
}
