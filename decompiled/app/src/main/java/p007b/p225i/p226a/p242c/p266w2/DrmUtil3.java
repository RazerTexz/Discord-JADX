package p007b.p225i.p226a.p242c.p266w2;

import android.media.MediaDrmResetException;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* compiled from: DrmUtil.java */
@RequiresApi(23)
/* renamed from: b.i.a.c.w2.x, reason: use source file name */
/* loaded from: classes3.dex */
public final class DrmUtil3 {
    @DoNotInline
    /* renamed from: a */
    public static boolean m3605a(@Nullable Throwable th) {
        return th instanceof MediaDrmResetException;
    }
}
