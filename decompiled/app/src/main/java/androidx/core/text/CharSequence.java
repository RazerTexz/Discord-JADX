package androidx.core.text;

import android.text.TextUtils;
import d0.z.d.Intrinsics3;

/* compiled from: CharSequence.kt */
/* renamed from: androidx.core.text.CharSequenceKt, reason: use source file name */
/* loaded from: classes.dex */
public final class CharSequence {
    public static final boolean isDigitsOnly(java.lang.CharSequence charSequence) {
        Intrinsics3.checkNotNullParameter(charSequence, "<this>");
        return TextUtils.isDigitsOnly(charSequence);
    }

    public static final int trimmedLength(java.lang.CharSequence charSequence) {
        Intrinsics3.checkNotNullParameter(charSequence, "<this>");
        return TextUtils.getTrimmedLength(charSequence);
    }
}
