package com.facebook.drawee.span;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.imagepipeline.image.ImageInfo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import p007b.p109f.p132g.p138b.DraweeEventTracker;
import p007b.p109f.p132g.p139c.BaseControllerListener;
import p007b.p109f.p132g.p146i.DraweeSpan;

/* loaded from: classes.dex */
public class DraweeSpanStringBuilder extends SpannableStringBuilder {

    /* renamed from: j */
    public static final /* synthetic */ int f19512j = 0;

    /* renamed from: k */
    public final Set<DraweeSpan> f19513k = new HashSet();

    /* renamed from: l */
    public final C10645b f19514l = new C10645b(null);

    /* renamed from: m */
    public View f19515m;

    /* renamed from: com.facebook.drawee.span.DraweeSpanStringBuilder$b */
    public class C10645b implements Drawable.Callback {
        public C10645b(C10644a c10644a) {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            DraweeSpanStringBuilder draweeSpanStringBuilder = DraweeSpanStringBuilder.this;
            View view = draweeSpanStringBuilder.f19515m;
            if (view != null) {
                view.invalidate();
            } else {
                Objects.requireNonNull(draweeSpanStringBuilder);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            DraweeSpanStringBuilder draweeSpanStringBuilder = DraweeSpanStringBuilder.this;
            if (draweeSpanStringBuilder.f19515m == null) {
                Objects.requireNonNull(draweeSpanStringBuilder);
            } else {
                DraweeSpanStringBuilder.this.f19515m.postDelayed(runnable, j - SystemClock.uptimeMillis());
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            DraweeSpanStringBuilder draweeSpanStringBuilder = DraweeSpanStringBuilder.this;
            View view = draweeSpanStringBuilder.f19515m;
            if (view != null) {
                view.removeCallbacks(runnable);
            } else {
                Objects.requireNonNull(draweeSpanStringBuilder);
            }
        }
    }

    /* renamed from: com.facebook.drawee.span.DraweeSpanStringBuilder$c */
    public class C10646c extends BaseControllerListener<ImageInfo> {

        /* renamed from: a */
        public final DraweeSpan f19517a;

        /* renamed from: b */
        public final boolean f19518b;

        /* renamed from: c */
        public final int f19519c;

        public C10646c(DraweeSpan draweeSpan, boolean z2, int i) {
            this.f19517a = draweeSpan;
            this.f19518b = z2;
            this.f19519c = i;
        }

        @Override // p007b.p109f.p132g.p139c.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onFinalImageSet(String str, Object obj, Animatable animatable) {
            ImageInfo imageInfo = (ImageInfo) obj;
            if (!this.f19518b || imageInfo == null || this.f19517a.f3487p.m8690d() == null) {
                return;
            }
            Drawable drawableM8690d = this.f19517a.f3487p.m8690d();
            Rect bounds = drawableM8690d.getBounds();
            int i = this.f19519c;
            if (i == -1) {
                if (bounds.width() == imageInfo.getWidth() && bounds.height() == imageInfo.getHeight()) {
                    return;
                }
                drawableM8690d.setBounds(0, 0, imageInfo.getWidth(), imageInfo.getHeight());
                DraweeSpanStringBuilder draweeSpanStringBuilder = DraweeSpanStringBuilder.this;
                int i2 = DraweeSpanStringBuilder.f19512j;
                Objects.requireNonNull(draweeSpanStringBuilder);
                return;
            }
            int height = (int) ((i / imageInfo.getHeight()) * imageInfo.getWidth());
            if (bounds.width() == height && bounds.height() == this.f19519c) {
                return;
            }
            drawableM8690d.setBounds(0, 0, height, this.f19519c);
            DraweeSpanStringBuilder draweeSpanStringBuilder2 = DraweeSpanStringBuilder.this;
            int i3 = DraweeSpanStringBuilder.f19512j;
            Objects.requireNonNull(draweeSpanStringBuilder2);
        }
    }

    /* renamed from: a */
    public void m8684a(View view) {
        View view2 = this.f19515m;
        if (view2 != null && view2 == view2) {
            this.f19515m = null;
        }
        this.f19515m = view;
        Iterator<DraweeSpan> it = this.f19513k.iterator();
        while (it.hasNext()) {
            DraweeHolder draweeHolder = it.next().f3487p;
            draweeHolder.f19530f.m1084a(DraweeEventTracker.a.ON_HOLDER_ATTACH);
            draweeHolder.f19526b = true;
            draweeHolder.m8688b();
        }
    }

    /* renamed from: b */
    public void m8685b(View view) {
        if (view == this.f19515m) {
            this.f19515m = null;
        }
        Iterator<DraweeSpan> it = this.f19513k.iterator();
        while (it.hasNext()) {
            DraweeHolder draweeHolder = it.next().f3487p;
            draweeHolder.f19530f.m1084a(DraweeEventTracker.a.ON_HOLDER_DETACH);
            draweeHolder.f19526b = false;
            draweeHolder.m8688b();
        }
    }

    /* renamed from: c */
    public void m8686c(Context context, DraweeHierarchy draweeHierarchy, DraweeController draweeController, int i, int i2, int i3, int i4, boolean z2, int i5) {
        DraweeHolder draweeHolder = new DraweeHolder(draweeHierarchy);
        draweeHolder.m8693g(draweeController);
        if (i2 >= length()) {
            return;
        }
        Drawable drawableM8690d = draweeHolder.m8690d();
        if (drawableM8690d != null) {
            if (drawableM8690d.getBounds().isEmpty()) {
                drawableM8690d.setBounds(0, 0, i3, i4);
            }
            drawableM8690d.setCallback(this.f19514l);
        }
        DraweeSpan draweeSpan = new DraweeSpan(draweeHolder, i5);
        DraweeController draweeController2 = draweeHolder.f19529e;
        if (draweeController2 instanceof AbstractDraweeController) {
            ((AbstractDraweeController) draweeController2).m8656f(new C10646c(draweeSpan, z2, i4));
        }
        this.f19513k.add(draweeSpan);
        setSpan(draweeSpan, i, i2 + 1, 33);
    }
}
