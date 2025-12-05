package androidx.core.graphics;

import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: Paint.kt */
/* renamed from: androidx.core.graphics.PaintKt, reason: use source file name */
/* loaded from: classes.dex */
public final class Paint {
    public static final boolean setBlendMode(android.graphics.Paint paint, BlendModeCompat blendModeCompat) {
        Intrinsics3.checkNotNullParameter(paint, "<this>");
        return PaintCompat.setBlendMode(paint, blendModeCompat);
    }
}
