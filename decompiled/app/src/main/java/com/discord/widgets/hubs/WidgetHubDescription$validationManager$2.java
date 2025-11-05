package com.discord.widgets.hubs;

import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.k.b;
import com.discord.R;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.view.validators.BasicTextInputValidator;
import com.discord.utilities.view.validators.Input;
import com.discord.utilities.view.validators.InputValidator;
import com.discord.utilities.view.validators.ValidationManager;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetHubDescription.kt */
/* loaded from: classes2.dex */
public final class WidgetHubDescription$validationManager$2 extends o implements Function0<ValidationManager> {
    public final /* synthetic */ WidgetHubDescription this$0;

    /* compiled from: WidgetHubDescription.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubDescription$validationManager$2$1, reason: invalid class name */
    public static final class AnonymousClass1 implements InputValidator<LinearLayout> {
        public AnonymousClass1() {
        }

        @Override // com.discord.utilities.view.validators.InputValidator
        public /* bridge */ /* synthetic */ CharSequence getErrorMessage(LinearLayout linearLayout) {
            return getErrorMessage2(linearLayout);
        }

        /* renamed from: getErrorMessage, reason: avoid collision after fix types in other method */
        public CharSequence getErrorMessage2(LinearLayout view) {
            m.checkNotNullParameter(view, "view");
            if (WidgetHubDescription$validationManager$2.this.this$0.getViewModel().getCategory() != null) {
                return null;
            }
            return view.getContext().getString(R.string.billing_address_address_error_required);
        }
    }

    /* compiled from: WidgetHubDescription.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubDescription$validationManager$2$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function2<LinearLayout, CharSequence, Boolean> {
        public AnonymousClass2() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Boolean invoke(LinearLayout linearLayout, CharSequence charSequence) {
            return Boolean.valueOf(invoke2(linearLayout, charSequence));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(LinearLayout linearLayout, CharSequence charSequence) {
            m.checkNotNullParameter(linearLayout, "<anonymous parameter 0>");
            m.checkNotNullParameter(charSequence, "errorMessage");
            TextView textView = WidgetHubDescription$validationManager$2.this.this$0.getBinding().d;
            m.checkNotNullExpressionValue(textView, "binding.categoryError");
            b.a(textView, charSequence);
            return true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubDescription$validationManager$2(WidgetHubDescription widgetHubDescription) {
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
        TextInputLayout textInputLayout = this.this$0.getBinding().g;
        m.checkNotNullExpressionValue(textInputLayout, "binding.descriptionLayout");
        InputValidator[] inputValidatorArr = {BasicTextInputValidator.INSTANCE.createRequiredInputValidator(R.string.member_verification_form_required_item)};
        LinearLayout linearLayout = this.this$0.getBinding().e;
        m.checkNotNullExpressionValue(linearLayout, "binding.categoryLayout");
        return new ValidationManager(new Input.TextInputLayoutInput(ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, textInputLayout, inputValidatorArr), new Input.GenericInput("category", linearLayout, new AnonymousClass1(), new AnonymousClass2()));
    }
}
