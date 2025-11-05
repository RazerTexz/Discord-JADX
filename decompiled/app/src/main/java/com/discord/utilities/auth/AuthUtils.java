package com.discord.utilities.auth;

import android.annotation.SuppressLint;
import android.util.Patterns;
import androidx.annotation.StringRes;
import androidx.core.app.NotificationCompat;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.utilities.phone.PhoneUtils;
import com.discord.utilities.string.StringUtils2;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.validators.BasicTextInputValidator;
import com.discord.utilities.view.validators.Input;
import com.discord.utilities.view.validators.InputValidator;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import com.google.android.material.textfield.TextInputLayout;
import d0.c0.Random2;
import d0.g0.StringNumberConversions;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Objects;
import kotlin.jvm.functions.Function1;

/* compiled from: AuthUtils.kt */
/* loaded from: classes2.dex */
public final class AuthUtils {
    public static final String AUTHY_PACKAGE = "com.authy.authy";
    public static final String GOOGLE_AUTHENTICATOR_PACKAGE = "com.google.android.apps.authenticator2";
    public static final AuthUtils INSTANCE = new AuthUtils();
    private static final int MAX_PASSWORD_LENGTH = 128;
    private static final int MIN_PASSWORD_LENGTH = 6;
    public static final String URL_AUTHY = "https://play.google.com/store/apps/details?id=com.authy.authy";
    public static final String URL_GOOGLE_AUTHENTICATOR = "https://play.google.com/store/apps/details?id=com.google.android.apps.authenticator2";
    private static final String URL_PLAY_STORE = "https://play.google.com/store/apps/details";

    /* compiled from: AuthUtils.kt */
    /* renamed from: com.discord.utilities.auth.AuthUtils$createDiscriminatorInputValidator$1, reason: invalid class name */
    public static final class AnonymousClass1 implements InputValidator<TextInputLayout> {
        public final /* synthetic */ int $invalidFormatResId;
        public final /* synthetic */ int $invalidValueResId;

        public AnonymousClass1(int i, int i2) {
            this.$invalidFormatResId = i;
            this.$invalidValueResId = i2;
        }

        @Override // com.discord.utilities.view.validators.InputValidator
        public /* bridge */ /* synthetic */ CharSequence getErrorMessage(TextInputLayout textInputLayout) {
            return getErrorMessage2(textInputLayout);
        }

        /* renamed from: getErrorMessage, reason: avoid collision after fix types in other method */
        public CharSequence getErrorMessage2(TextInputLayout view) {
            Intrinsics3.checkNotNullParameter(view, "view");
            String textOrEmpty = ViewExtensions.getTextOrEmpty(view);
            Integer intOrNull = StringNumberConversions.toIntOrNull(textOrEmpty);
            if (intOrNull == null || textOrEmpty.length() != 4) {
                return FormatUtils.j(view, this.$invalidFormatResId, new Object[0], null, 4);
            }
            if (intOrNull.intValue() <= 0) {
                return FormatUtils.j(view, this.$invalidValueResId, new Object[0], null, 4);
            }
            return null;
        }
    }

    /* compiled from: AuthUtils.kt */
    /* renamed from: com.discord.utilities.auth.AuthUtils$createEmailInputValidator$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<String, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(String str) {
            return Boolean.valueOf(invoke2(str));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "it");
            return AuthUtils.access$isValidEmail(AuthUtils.INSTANCE, str);
        }
    }

    /* compiled from: AuthUtils.kt */
    /* renamed from: com.discord.utilities.auth.AuthUtils$createPasswordInputValidator$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<String, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(String str) {
            return Boolean.valueOf(invoke2(str));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "it");
            return AuthUtils.INSTANCE.isValidPasswordLength(str);
        }
    }

    /* compiled from: AuthUtils.kt */
    /* renamed from: com.discord.utilities.auth.AuthUtils$createPhoneInputValidator$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<String, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(String str) {
            return Boolean.valueOf(invoke2(str));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "it");
            return PhoneUtils.INSTANCE.isValidPhoneFragment(str);
        }
    }

    private AuthUtils() {
    }

    public static final /* synthetic */ boolean access$isValidEmail(AuthUtils authUtils, String str) {
        return authUtils.isValidEmail(str);
    }

    private final boolean isValidEmail(String email) {
        return (email.length() > 0) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public final InputValidator<TextInputLayout> createDiscriminatorInputValidator(@StringRes int invalidFormatResId, @StringRes int invalidValueResId) {
        return new AnonymousClass1(invalidFormatResId, invalidValueResId);
    }

    public final BasicTextInputValidator createEmailInputValidator(@StringRes int messageResId) {
        return new BasicTextInputValidator(messageResId, AnonymousClass1.INSTANCE);
    }

    public final ValidationManager createEmailValidationManager(TextInputLayout emailInput) {
        Intrinsics3.checkNotNullParameter(emailInput, "emailInput");
        return new ValidationManager(new Input.TextInputLayoutInput(NotificationCompat.CATEGORY_EMAIL, emailInput, BasicTextInputValidator.INSTANCE.createRequiredInputValidator(R.string.email_required), createEmailInputValidator(R.string.email_invalid)));
    }

    public final BasicTextInputValidator createPasswordInputValidator(@StringRes int messageResId) {
        return new BasicTextInputValidator(messageResId, AnonymousClass1.INSTANCE);
    }

    public final BasicTextInputValidator createPhoneInputValidator(@StringRes int messageResId) {
        return new BasicTextInputValidator(messageResId, AnonymousClass1.INSTANCE);
    }

    @SuppressLint({"DefaultLocale"})
    public final String encodeTotpSecret(String secret) {
        Intrinsics3.checkNotNullParameter(secret, "secret");
        String strReplace$default = StringsJVM.replace$default(secret, " ", "", false, 4, (Object) null);
        Objects.requireNonNull(strReplace$default, "null cannot be cast to non-null type java.lang.String");
        String upperCase = strReplace$default.toUpperCase();
        Intrinsics3.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase()");
        Objects.requireNonNull(upperCase, "null cannot be cast to non-null type kotlin.CharSequence");
        return Strings4.trim(upperCase).toString();
    }

    @SuppressLint({"DefaultLocale"})
    public final String generateNewTotpKey() throws UnsupportedEncodingException {
        String strEncode = URLEncoder.encode(StringUtils2.encodeToBase32String(Random2.Random(ClockFactory.get().currentTimeMillis()).nextBytes(10)), "utf-8");
        Intrinsics3.checkNotNullExpressionValue(strEncode, "URLEncoder\n        .enco…oBase32String(), \"utf-8\")");
        String strReplace$default = StringsJVM.replace$default(strEncode, "=", "", false, 4, (Object) null);
        Objects.requireNonNull(strReplace$default, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = strReplace$default.toLowerCase();
        Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        Objects.requireNonNull(lowerCase, "null cannot be cast to non-null type kotlin.CharSequence");
        StringBuilder sb = new StringBuilder(Strings4.trim(lowerCase).toString());
        Iterator it = Collections2.listOf((Object[]) new Integer[]{12, 8, 4}).iterator();
        while (it.hasNext()) {
            sb.insert(((Number) it.next()).intValue(), " ");
        }
        String string = sb.toString();
        Intrinsics3.checkNotNullExpressionValue(string, "builder.toString()");
        return string;
    }

    public final boolean isValidPasswordLength(String password) {
        Intrinsics3.checkNotNullParameter(password, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
        int length = password.length();
        return 6 <= length && 128 >= length;
    }
}
