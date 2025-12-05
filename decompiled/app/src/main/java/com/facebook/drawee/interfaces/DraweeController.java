package com.facebook.drawee.interfaces;

import android.graphics.drawable.Animatable;
import android.view.MotionEvent;

/* loaded from: classes.dex */
public interface DraweeController {
    /* renamed from: a */
    void mo8652a();

    /* renamed from: b */
    DraweeHierarchy mo8653b();

    /* renamed from: c */
    Animatable mo8654c();

    /* renamed from: d */
    void mo8655d();

    /* renamed from: e */
    void mo1045e(DraweeHierarchy draweeHierarchy);

    boolean onTouchEvent(MotionEvent motionEvent);
}
