package com.discord.utilities;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: Quad.kt */
/* renamed from: com.discord.utilities.QuadKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class Quad2 {
    public static final <T> List<T> toList(Quad<? extends T, ? extends T, ? extends T, ? extends T> quad) {
        Intrinsics3.checkNotNullParameter(quad, "$this$toList");
        return Collections2.listOf(quad.getFirst(), quad.getSecond(), quad.getThird(), quad.getFourth());
    }
}
