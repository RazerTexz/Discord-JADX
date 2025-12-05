package com.discord.widgets.auth;

import android.widget.CheckBox;
import com.discord.C5419R;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.validators.BasicTextInputValidator;
import com.discord.utilities.view.validators.Input;
import com.discord.utilities.view.validators.InputValidator;
import com.discord.utilities.view.validators.ValidationManager;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import p007b.p008a.p018d.AppToast;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetAuthBirthday.kt */
/* renamed from: com.discord.widgets.auth.WidgetAuthBirthday$validationManager$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetAuthBirthday5 extends Lambda implements Function0<ValidationManager> {
    public final /* synthetic */ WidgetAuthBirthday this$0;

    /* compiled from: WidgetAuthBirthday.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthBirthday$validationManager$2$1 */
    public static final class C71701 implements InputValidator<CheckBox> {
        public C71701() {
        }

        @Override // com.discord.utilities.view.validators.InputValidator
        public /* bridge */ /* synthetic */ CharSequence getErrorMessage(CheckBox checkBox) {
            return getErrorMessage2(checkBox);
        }

        /* renamed from: getErrorMessage, reason: avoid collision after fix types in other method */
        public CharSequence getErrorMessage2(CheckBox view) {
            Intrinsics3.checkNotNullParameter(view, "view");
            if ((WidgetAuthBirthday.access$isConsentRequired$p(WidgetAuthBirthday5.this.this$0) && view.isChecked()) || !WidgetAuthBirthday.access$isConsentRequired$p(WidgetAuthBirthday5.this.this$0)) {
                return null;
            }
            return view.getContext().getString(C5419R.string.terms_privacy_opt_in_tooltip);
        }
    }

    /* compiled from: WidgetAuthBirthday.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthBirthday$validationManager$2$2 */
    public static final class C71712 extends Lambda implements Function2<MaterialCheckBox, CharSequence, Boolean> {
        public static final C71712 INSTANCE = new C71712();

        public C71712() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Boolean invoke(MaterialCheckBox materialCheckBox, CharSequence charSequence) {
            return Boolean.valueOf(invoke2(materialCheckBox, charSequence));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(MaterialCheckBox materialCheckBox, CharSequence charSequence) {
            Intrinsics3.checkNotNullParameter(materialCheckBox, "checkBox");
            Intrinsics3.checkNotNullParameter(charSequence, "errorMessage");
            AppToast.m170h(materialCheckBox.getContext(), charSequence, 0, null, 12);
            ViewExtensions.hintWithRipple$default(materialCheckBox, 0L, 1, null);
            return true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAuthBirthday5(WidgetAuthBirthday widgetAuthBirthday) {
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
        TextInputLayout textInputLayout = WidgetAuthBirthday.access$getBinding$p(this.this$0).f15672c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.authRegisterBirthday");
        return new ValidationManager(new Input.TextInputLayoutInput("dateOfBirth", textInputLayout, BasicTextInputValidator.INSTANCE.createRequiredInputValidator(C5419R.string.age_gate_invalid_birthday)), new Input.GenericInput("tos", WidgetAuthBirthday.access$getBinding$p(this.this$0).f15674e, new C71701(), C71712.INSTANCE));
    }
}
