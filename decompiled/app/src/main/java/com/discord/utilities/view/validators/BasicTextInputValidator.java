package com.discord.utilities.view.validators;

import androidx.annotation.StringRes;
import b.a.k.FormatUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: BasicTextInputValidator.kt */
/* loaded from: classes2.dex */
public final class BasicTextInputValidator implements InputValidator<TextInputLayout> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Function1<String, Boolean> inputPredicate;
    private final int messageResId;

    /* compiled from: BasicTextInputValidator.kt */
    public static final class Companion {
        private Companion() {
        }

        public final BasicTextInputValidator createRequiredInputValidator(@StringRes int messageResId) {
            return new BasicTextInputValidator(messageResId, BasicTextInputValidator2.INSTANCE);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BasicTextInputValidator(@StringRes int i, Function1<? super String, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(function1, "inputPredicate");
        this.messageResId = i;
        this.inputPredicate = function1;
    }

    @Override // com.discord.utilities.view.validators.InputValidator
    public /* bridge */ /* synthetic */ CharSequence getErrorMessage(TextInputLayout textInputLayout) {
        return getErrorMessage2(textInputLayout);
    }

    public final int getMessageResId() {
        return this.messageResId;
    }

    /* renamed from: getErrorMessage, reason: avoid collision after fix types in other method */
    public CharSequence getErrorMessage2(TextInputLayout view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        if (this.inputPredicate.invoke(ViewExtensions.getTextOrEmpty(view)).booleanValue()) {
            return null;
        }
        return FormatUtils.j(view, this.messageResId, new Object[0], null, 4);
    }
}
