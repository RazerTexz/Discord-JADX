package androidx.core.graphics;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* compiled from: PorterDuff.kt */
/* renamed from: androidx.core.graphics.PorterDuffKt, reason: use source file name */
/* loaded from: classes.dex */
public final class PorterDuff {
    public static final PorterDuffColorFilter toColorFilter(PorterDuff.Mode mode, int i) {
        Intrinsics3.checkNotNullParameter(mode, "<this>");
        return new PorterDuffColorFilter(i, mode);
    }

    public static final PorterDuffXfermode toXfermode(PorterDuff.Mode mode) {
        Intrinsics3.checkNotNullParameter(mode, "<this>");
        return new PorterDuffXfermode(mode);
    }
}
