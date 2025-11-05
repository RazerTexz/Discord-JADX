package com.discord.widgets.auth;

import android.widget.CheckBox;
import com.discord.R;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.validators.BasicTextInputValidator;
import com.discord.utilities.view.validators.Input;
import com.discord.utilities.view.validators.InputValidator;
import com.discord.utilities.view.validators.ValidationManager;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetAuthBirthday.kt */
/* loaded from: classes2.dex */
public final class WidgetAuthBirthday$validationManager$2 extends o implements Function0<ValidationManager> {
    public final /* synthetic */ WidgetAuthBirthday this$0;

    /* compiled from: WidgetAuthBirthday.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthBirthday$validationManager$2$1, reason: invalid class name */
    public static final class AnonymousClass1 implements InputValidator<CheckBox> {
        public AnonymousClass1() {
        }

        @Override // com.discord.utilities.view.validators.InputValidator
        public /* bridge */ /* synthetic */ CharSequence getErrorMessage(CheckBox checkBox) {
            return getErrorMessage2(checkBox);
        }

        /* renamed from: getErrorMessage, reason: avoid collision after fix types in other method */
        public CharSequence getErrorMessage2(CheckBox view) {
            m.checkNotNullParameter(view, "view");
            if ((WidgetAuthBirthday.access$isConsentRequired$p(WidgetAuthBirthday$validationManager$2.this.this$0) && view.isChecked()) || !WidgetAuthBirthday.access$isConsentRequired$p(WidgetAuthBirthday$validationManager$2.this.this$0)) {
                return null;
            }
            return view.getContext().getString(R.string.terms_privacy_opt_in_tooltip);
        }
    }

    /* compiled from: WidgetAuthBirthday.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthBirthday$validationManager$2$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function2<MaterialCheckBox, CharSequence, Boolean> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Boolean invoke(MaterialCheckBox materialCheckBox, CharSequence charSequence) {
            return Boolean.valueOf(invoke2(materialCheckBox, charSequence));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(MaterialCheckBox materialCheckBox, CharSequence charSequence) {
            m.checkNotNullParameter(materialCheckBox, "checkBox");
            m.checkNotNullParameter(charSequence, "errorMessage");
            b.a.d.m.h(materialCheckBox.getContext(), charSequence, 0, null, 12);
            ViewExtensions.hintWithRipple$default(materialCheckBox, 0L, 1, null);
            return true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAuthBirthday$validationManager$2(WidgetAuthBirthday widgetAuthBirthday) {
        super(0);
        this.this$0 = widgetAuthBirthday;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ValidationManager invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ValidationManager invoke() {
        TextInputLayout textInputLayout = WidgetAuthBirthday.access$getBinding$p(this.this$0).c;
        m.checkNotNullExpressionValue(textInputLayout, "binding.authRegisterBirthday");
        return new ValidationManager(new Input.TextInputLayoutInput("dateOfBirth", textInputLayout, BasicTextInputValidator.INSTANCE.createRequiredInputValidator(R.string.age_gate_invalid_birthday)), new Input.GenericInput("tos", WidgetAuthBirthday.access$getBinding$p(this.this$0).e, new AnonymousClass1(), AnonymousClass2.INSTANCE));
    }
}
