package androidx.core.graphics;

import android.graphics.Paint;
import d0.z.d.m;

/* compiled from: Paint.kt */
/* loaded from: classes.dex */
public final class PaintKt {
    public static final boolean setBlendMode(Paint paint, BlendModeCompat blendModeCompat) {
        m.checkNotNullParameter(paint, "<this>");
        return PaintCompat.setBlendMode(paint, blendModeCompat);
    }
}
