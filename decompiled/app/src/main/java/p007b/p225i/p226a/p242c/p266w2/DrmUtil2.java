package p007b.p225i.p226a.p242c.p266w2;

import android.media.MediaDrm;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.Objects;
import p007b.p225i.p226a.p242c.p259f3.Util2;

/* compiled from: DrmUtil.java */
@RequiresApi(21)
/* renamed from: b.i.a.c.w2.w, reason: use source file name */
/* loaded from: classes3.dex */
public final class DrmUtil2 {
    @DoNotInline
    /* renamed from: a */
    public static boolean m3603a(@Nullable Throwable th) {
        return th instanceof MediaDrm.MediaDrmStateException;
    }

    @DoNotInline
    /* renamed from: b */
    public static int m3604b(Throwable th) {
        String[] strArrSplit;
        int length;
        String diagnosticInfo = ((MediaDrm.MediaDrmStateException) th).getDiagnosticInfo();
        int i = Util2.f6708a;
        int i2 = 0;
        if (diagnosticInfo != null && (length = (strArrSplit = diagnosticInfo.split("_", -1)).length) >= 2) {
            String str = strArrSplit[length - 1];
            boolean z2 = length >= 3 && "neg".equals(strArrSplit[length - 2]);
            try {
                Objects.requireNonNull(str);
                i2 = Integer.parseInt(str);
                if (z2) {
                    i2 = -i2;
                }
            } catch (NumberFormatException unused) {
            }
        }
        return Util2.m3008p(i2);
    }
}
