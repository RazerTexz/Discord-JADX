package androidx.core.text;

import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import d0.z.d.m;
import java.util.Locale;

/* compiled from: Locale.kt */
/* loaded from: classes.dex */
public final class LocaleKt {
    @RequiresApi(17)
    public static final int getLayoutDirection(Locale locale) {
        m.checkNotNullParameter(locale, "<this>");
        return TextUtils.getLayoutDirectionFromLocale(locale);
    }
}
