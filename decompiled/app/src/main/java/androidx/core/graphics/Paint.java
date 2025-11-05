package androidx.core.graphics;

import d0.z.d.Intrinsics3;

/* compiled from: Paint.kt */
/* renamed from: androidx.core.graphics.PaintKt, reason: use source file name */
/* loaded from: classes.dex */
public final class Paint {
    public static final boolean setBlendMode(android.graphics.Paint paint, BlendModeCompat blendModeCompat) {
        Intrinsics3.checkNotNullParameter(paint, "<this>");
        return PaintCompat.setBlendMode(paint, blendModeCompat);
    }
}
