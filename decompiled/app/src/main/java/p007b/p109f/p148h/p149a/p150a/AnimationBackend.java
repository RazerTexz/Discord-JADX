package p007b.p109f.p148h.p149a.p150a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.IntRange;

/* compiled from: AnimationBackend.java */
/* renamed from: b.f.h.a.a.a, reason: use source file name */
/* loaded from: classes.dex */
public interface AnimationBackend extends AnimationInformation {
    void clear();

    /* renamed from: d */
    void mo1136d(ColorFilter colorFilter);

    /* renamed from: f */
    void mo1137f(@IntRange(from = 0, m76to = 255) int i);

    /* renamed from: g */
    int mo1138g();

    /* renamed from: h */
    void mo1139h(Rect rect);

    /* renamed from: i */
    int mo1140i();

    /* renamed from: j */
    boolean mo1141j(Drawable drawable, Canvas canvas, int i);
}
