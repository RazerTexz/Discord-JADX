package androidx.core.text;

import android.text.TextUtils;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: String.kt */
/* renamed from: androidx.core.text.StringKt, reason: use source file name */
/* loaded from: classes.dex */
public final class String {
    public static final java.lang.String htmlEncode(java.lang.String str) {
        Intrinsics3.checkNotNullParameter(str, "<this>");
        java.lang.String strHtmlEncode = TextUtils.htmlEncode(str);
        Intrinsics3.checkNotNullExpressionValue(strHtmlEncode, "htmlEncode(this)");
        return strHtmlEncode;
    }
}
