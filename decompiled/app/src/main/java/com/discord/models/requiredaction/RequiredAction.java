package com.discord.models.requiredaction;

import d0.z.d.m;
import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: RequiredAction.kt */
/* loaded from: classes.dex */
public enum RequiredAction {
    AGREEMENTS,
    TOS_UPDATE_ACKNOWLEDGMENT,
    REQUIRE_VERIFIED_EMAIL,
    REQUIRE_VERIFIED_PHONE,
    REQUIRE_CAPTCHA,
    NONE;


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: RequiredAction.kt */
    public static final class Companion {
        private Companion() {
        }

        public final RequiredAction fromApiString(String requiredAction) {
            if (requiredAction != null) {
                try {
                    Locale locale = Locale.ROOT;
                    m.checkNotNullExpressionValue(locale, "Locale.ROOT");
                    String upperCase = requiredAction.toUpperCase(locale);
                    m.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase(locale)");
                    RequiredAction requiredActionValueOf = RequiredAction.valueOf(upperCase);
                    if (requiredActionValueOf != null) {
                        return requiredActionValueOf;
                    }
                } catch (IllegalArgumentException unused) {
                    return RequiredAction.NONE;
                } catch (NullPointerException unused2) {
                    return RequiredAction.NONE;
                }
            }
            return RequiredAction.NONE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
