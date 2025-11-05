package b.o.a.u;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import b.o.a.u.a;
import com.otaliastudios.cameraview.R;

/* compiled from: OverlayLayout.java */
@SuppressLint({"CustomViewStyleable"})
/* loaded from: classes3.dex */
public class c extends FrameLayout implements b.o.a.u.a {
    public static final String j;
    public static final b.o.a.b k;

    @VisibleForTesting
    public a.EnumC0177a l;
    public boolean m;

    /* compiled from: OverlayLayout.java */
    public static class a extends FrameLayout.LayoutParams {
        public boolean a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f1954b;
        public boolean c;

        public a(@NonNull Context context, @NonNull AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = false;
            this.f1954b = false;
            this.c = false;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.c.CameraView_Layout);
            try {
                this.a = typedArrayObtainStyledAttributes.getBoolean(R.c.CameraView_Layout_layout_drawOnPreview, false);
                this.f1954b = typedArrayObtainStyledAttributes.getBoolean(R.c.CameraView_Layout_layout_drawOnPictureSnapshot, false);
                this.c = typedArrayObtainStyledAttributes.getBoolean(R.c.CameraView_Layout_layout_drawOnVideoSnapshot, false);
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }

        @VisibleForTesting
        public boolean a(@NonNull a.EnumC0177a enumC0177a) {
            return (enumC0177a == a.EnumC0177a.PREVIEW && this.a) || (enumC0177a == a.EnumC0177a.VIDEO_SNAPSHOT && this.c) || (enumC0177a == a.EnumC0177a.PICTURE_SNAPSHOT && this.f1954b);
        }

        @NonNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            b.d.b.a.a.k0(a.class, sb, "[drawOnPreview:");
            sb.append(this.a);
            sb.append(",drawOnPictureSnapshot:");
            sb.append(this.f1954b);
            sb.append(",drawOnVideoSnapshot:");
            return b.d.b.a.a.O(sb, this.c, "]");
        }
    }

    static {
        String simpleName = c.class.getSimpleName();
        j = simpleName;
        k = new b.o.a.b(simpleName);
    }

    public c(@NonNull Context context) {
        super(context);
        this.l = a.EnumC0177a.PREVIEW;
        setWillNotDraw(false);
    }

    public void a(@NonNull a.EnumC0177a enumC0177a, @NonNull Canvas canvas) {
        synchronized (this) {
            this.l = enumC0177a;
            int iOrdinal = enumC0177a.ordinal();
            if (iOrdinal == 0) {
                super.draw(canvas);
            } else if (iOrdinal == 1 || iOrdinal == 2) {
                canvas.save();
                float width = canvas.getWidth() / getWidth();
                float height = canvas.getHeight() / getHeight();
                k.a(0, "draw", "target:", enumC0177a, "canvas:", canvas.getWidth() + "x" + canvas.getHeight(), "view:", getWidth() + "x" + getHeight(), "widthScale:", Float.valueOf(width), "heightScale:", Float.valueOf(height), "hardwareCanvasMode:", Boolean.valueOf(this.m));
                canvas.scale(width, height);
                dispatchDraw(canvas);
                canvas.restore();
            }
        }
    }

    public boolean b(@NonNull a.EnumC0177a enumC0177a) {
        for (int i = 0; i < getChildCount(); i++) {
            if (((a) getChildAt(i).getLayoutParams()).a(enumC0177a)) {
                return true;
            }
        }
        return false;
    }

    public a c(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
        k.a(1, "normal draw called.");
        a.EnumC0177a enumC0177a = a.EnumC0177a.PREVIEW;
        if (b(enumC0177a)) {
            a(enumC0177a, canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j2) {
        a aVar = (a) view.getLayoutParams();
        if (aVar.a(this.l)) {
            k.a(0, "Performing drawing for view:", view.getClass().getSimpleName(), "target:", this.l, "params:", aVar);
            return super.drawChild(canvas, view, j2);
        }
        k.a(0, "Skipping drawing for view:", view.getClass().getSimpleName(), "target:", this.l, "params:", aVar);
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return c(attributeSet);
    }

    public boolean getHardwareCanvasEnabled() {
        return this.m;
    }

    public void setHardwareCanvasEnabled(boolean z2) {
        this.m = z2;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return c(attributeSet);
    }
}
