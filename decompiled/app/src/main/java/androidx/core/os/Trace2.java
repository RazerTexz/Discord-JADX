package androidx.core.os;

import androidx.exifinterface.media.ExifInterface;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.InlineMarker;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: androidx.core.os.TraceKt, reason: use source file name */
/* JADX INFO: compiled from: Trace.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Trace2 {
    public static final <T> T trace(String str, Function0<? extends T> function0) {
        Intrinsics3.checkNotNullParameter(str, "sectionName");
        Intrinsics3.checkNotNullParameter(function0, "block");
        TraceCompat.beginSection(str);
        try {
            return function0.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            TraceCompat.endSection();
            InlineMarker.finallyEnd(1);
        }
    }
}
