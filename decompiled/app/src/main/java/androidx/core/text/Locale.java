package androidx.core.text;

import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: Locale.kt */
/* renamed from: androidx.core.text.LocaleKt, reason: use source file name */
/* loaded from: classes.dex */
public final class Locale {
    @RequiresApi(17)
    public static final int getLayoutDirection(java.util.Locale locale) {
        Intrinsics3.checkNotNullParameter(locale, "<this>");
        return TextUtils.getLayoutDirectionFromLocale(locale);
    }
}
