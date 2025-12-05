package p007b.p225i.p226a.p242c.p266w2;

import android.media.DeniedByServerException;
import android.media.NotProvisionedException;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* compiled from: DrmUtil.java */
@RequiresApi(18)
/* renamed from: b.i.a.c.w2.v, reason: use source file name */
/* loaded from: classes3.dex */
public final class DrmUtil {
    @DoNotInline
    /* renamed from: a */
    public static boolean m3601a(@Nullable Throwable th) {
        return th instanceof DeniedByServerException;
    }

    @DoNotInline
    /* renamed from: b */
    public static boolean m3602b(@Nullable Throwable th) {
        return th instanceof NotProvisionedException;
    }
}
