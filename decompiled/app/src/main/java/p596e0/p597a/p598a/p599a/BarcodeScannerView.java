package p596e0.p597a.p598a.p599a;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.ColorInt;
import androidx.core.view.ViewCompat;
import me.dm7.barcodescanner.core.C12923R;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* compiled from: BarcodeScannerView.java */
/* renamed from: e0.a.a.a.a, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class BarcodeScannerView extends FrameLayout implements Camera.PreviewCallback {

    /* renamed from: A */
    public float f25296A;

    /* renamed from: B */
    public int f25297B;

    /* renamed from: C */
    public float f25298C;

    /* renamed from: j */
    public CameraWrapper f25299j;

    /* renamed from: k */
    public CameraPreview2 f25300k;

    /* renamed from: l */
    public IViewFinder f25301l;

    /* renamed from: m */
    public Rect f25302m;

    /* renamed from: n */
    public CameraHandlerThread2 f25303n;

    /* renamed from: o */
    public Boolean f25304o;

    /* renamed from: p */
    public boolean f25305p;

    /* renamed from: q */
    public boolean f25306q;

    /* renamed from: r */
    public boolean f25307r;

    /* renamed from: s */
    @ColorInt
    public int f25308s;

    /* renamed from: t */
    @ColorInt
    public int f25309t;

    /* renamed from: u */
    public int f25310u;

    /* renamed from: v */
    public int f25311v;

    /* renamed from: w */
    public int f25312w;

    /* renamed from: x */
    public boolean f25313x;

    /* renamed from: y */
    public int f25314y;

    /* renamed from: z */
    public boolean f25315z;

    public BarcodeScannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f25305p = true;
        this.f25306q = true;
        this.f25307r = true;
        this.f25308s = getResources().getColor(C12923R.a.viewfinder_laser);
        this.f25309t = getResources().getColor(C12923R.a.viewfinder_border);
        this.f25310u = getResources().getColor(C12923R.a.viewfinder_mask);
        this.f25311v = getResources().getInteger(C12923R.b.viewfinder_border_width);
        this.f25312w = getResources().getInteger(C12923R.b.viewfinder_border_length);
        this.f25313x = false;
        this.f25314y = 0;
        this.f25315z = false;
        this.f25296A = 1.0f;
        this.f25297B = 0;
        this.f25298C = 0.1f;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C12923R.c.BarcodeScannerView, 0, 0);
        try {
            setShouldScaleToFill(typedArrayObtainStyledAttributes.getBoolean(C12923R.c.BarcodeScannerView_shouldScaleToFill, true));
            this.f25307r = typedArrayObtainStyledAttributes.getBoolean(C12923R.c.BarcodeScannerView_laserEnabled, this.f25307r);
            this.f25308s = typedArrayObtainStyledAttributes.getColor(C12923R.c.BarcodeScannerView_laserColor, this.f25308s);
            this.f25309t = typedArrayObtainStyledAttributes.getColor(C12923R.c.BarcodeScannerView_borderColor, this.f25309t);
            this.f25310u = typedArrayObtainStyledAttributes.getColor(C12923R.c.BarcodeScannerView_maskColor, this.f25310u);
            this.f25311v = typedArrayObtainStyledAttributes.getDimensionPixelSize(C12923R.c.BarcodeScannerView_borderWidth, this.f25311v);
            this.f25312w = typedArrayObtainStyledAttributes.getDimensionPixelSize(C12923R.c.BarcodeScannerView_borderLength, this.f25312w);
            this.f25313x = typedArrayObtainStyledAttributes.getBoolean(C12923R.c.BarcodeScannerView_roundedCorner, this.f25313x);
            this.f25314y = typedArrayObtainStyledAttributes.getDimensionPixelSize(C12923R.c.BarcodeScannerView_cornerRadius, this.f25314y);
            this.f25315z = typedArrayObtainStyledAttributes.getBoolean(C12923R.c.BarcodeScannerView_squaredFinder, this.f25315z);
            this.f25296A = typedArrayObtainStyledAttributes.getFloat(C12923R.c.BarcodeScannerView_borderAlpha, this.f25296A);
            this.f25297B = typedArrayObtainStyledAttributes.getDimensionPixelSize(C12923R.c.BarcodeScannerView_finderOffset, this.f25297B);
            typedArrayObtainStyledAttributes.recycle();
            ViewFinderView viewFinderView = new ViewFinderView(getContext());
            viewFinderView.setBorderColor(this.f25309t);
            viewFinderView.setLaserColor(this.f25308s);
            viewFinderView.setLaserEnabled(this.f25307r);
            viewFinderView.setBorderStrokeWidth(this.f25311v);
            viewFinderView.setBorderLineLength(this.f25312w);
            viewFinderView.setMaskColor(this.f25310u);
            viewFinderView.setBorderCornerRounded(this.f25313x);
            viewFinderView.setBorderCornerRadius(this.f25314y);
            viewFinderView.setSquareViewFinder(this.f25315z);
            viewFinderView.setViewFinderOffset(this.f25297B);
            this.f25301l = viewFinderView;
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* renamed from: a */
    public void m10094a() {
        if (this.f25299j != null) {
            this.f25300k.m10099e();
            CameraPreview2 cameraPreview2 = this.f25300k;
            cameraPreview2.f25321j = null;
            cameraPreview2.f25327p = null;
            this.f25299j.f25333a.release();
            this.f25299j = null;
        }
        CameraHandlerThread2 cameraHandlerThread2 = this.f25303n;
        if (cameraHandlerThread2 != null) {
            cameraHandlerThread2.quit();
            this.f25303n = null;
        }
    }

    public boolean getFlash() {
        CameraWrapper cameraWrapper = this.f25299j;
        return cameraWrapper != null && C3404f.m4196C0(cameraWrapper.f25333a) && this.f25299j.f25333a.getParameters().getFlashMode().equals("torch");
    }

    public int getRotationCount() {
        return this.f25300k.getDisplayOrientation() / 90;
    }

    public void setAspectTolerance(float f) {
        this.f25298C = f;
    }

    public void setAutoFocus(boolean z2) {
        this.f25305p = z2;
        CameraPreview2 cameraPreview2 = this.f25300k;
        if (cameraPreview2 != null) {
            cameraPreview2.setAutoFocus(z2);
        }
    }

    public void setBorderAlpha(float f) {
        this.f25296A = f;
        ((ViewFinderView) this.f25301l).setBorderAlpha(f);
        ViewFinderView viewFinderView = (ViewFinderView) this.f25301l;
        viewFinderView.m10100a();
        viewFinderView.invalidate();
    }

    public void setBorderColor(int i) {
        this.f25309t = i;
        ((ViewFinderView) this.f25301l).setBorderColor(i);
        ViewFinderView viewFinderView = (ViewFinderView) this.f25301l;
        viewFinderView.m10100a();
        viewFinderView.invalidate();
    }

    public void setBorderCornerRadius(int i) {
        this.f25314y = i;
        ((ViewFinderView) this.f25301l).setBorderCornerRadius(i);
        ViewFinderView viewFinderView = (ViewFinderView) this.f25301l;
        viewFinderView.m10100a();
        viewFinderView.invalidate();
    }

    public void setBorderLineLength(int i) {
        this.f25312w = i;
        ((ViewFinderView) this.f25301l).setBorderLineLength(i);
        ViewFinderView viewFinderView = (ViewFinderView) this.f25301l;
        viewFinderView.m10100a();
        viewFinderView.invalidate();
    }

    public void setBorderStrokeWidth(int i) {
        this.f25311v = i;
        ((ViewFinderView) this.f25301l).setBorderStrokeWidth(i);
        ViewFinderView viewFinderView = (ViewFinderView) this.f25301l;
        viewFinderView.m10100a();
        viewFinderView.invalidate();
    }

    public void setFlash(boolean z2) {
        this.f25304o = Boolean.valueOf(z2);
        CameraWrapper cameraWrapper = this.f25299j;
        if (cameraWrapper == null || !C3404f.m4196C0(cameraWrapper.f25333a)) {
            return;
        }
        Camera.Parameters parameters = this.f25299j.f25333a.getParameters();
        if (z2) {
            if (parameters.getFlashMode().equals("torch")) {
                return;
            } else {
                parameters.setFlashMode("torch");
            }
        } else if (parameters.getFlashMode().equals("off")) {
            return;
        } else {
            parameters.setFlashMode("off");
        }
        this.f25299j.f25333a.setParameters(parameters);
    }

    public void setIsBorderCornerRounded(boolean z2) {
        this.f25313x = z2;
        ((ViewFinderView) this.f25301l).setBorderCornerRounded(z2);
        ViewFinderView viewFinderView = (ViewFinderView) this.f25301l;
        viewFinderView.m10100a();
        viewFinderView.invalidate();
    }

    public void setLaserColor(int i) {
        this.f25308s = i;
        ((ViewFinderView) this.f25301l).setLaserColor(i);
        ViewFinderView viewFinderView = (ViewFinderView) this.f25301l;
        viewFinderView.m10100a();
        viewFinderView.invalidate();
    }

    public void setLaserEnabled(boolean z2) {
        this.f25307r = z2;
        ((ViewFinderView) this.f25301l).setLaserEnabled(z2);
        ViewFinderView viewFinderView = (ViewFinderView) this.f25301l;
        viewFinderView.m10100a();
        viewFinderView.invalidate();
    }

    public void setMaskColor(int i) {
        this.f25310u = i;
        ((ViewFinderView) this.f25301l).setMaskColor(i);
        ViewFinderView viewFinderView = (ViewFinderView) this.f25301l;
        viewFinderView.m10100a();
        viewFinderView.invalidate();
    }

    public void setShouldScaleToFill(boolean z2) {
        this.f25306q = z2;
    }

    public void setSquareViewFinder(boolean z2) {
        this.f25315z = z2;
        ((ViewFinderView) this.f25301l).setSquareViewFinder(z2);
        ViewFinderView viewFinderView = (ViewFinderView) this.f25301l;
        viewFinderView.m10100a();
        viewFinderView.invalidate();
    }

    public void setupCameraPreview(CameraWrapper cameraWrapper) {
        this.f25299j = cameraWrapper;
        if (cameraWrapper != null) {
            setupLayout(cameraWrapper);
            ViewFinderView viewFinderView = (ViewFinderView) this.f25301l;
            viewFinderView.m10100a();
            viewFinderView.invalidate();
            Boolean bool = this.f25304o;
            if (bool != null) {
                setFlash(bool.booleanValue());
            }
            setAutoFocus(this.f25305p);
        }
    }

    public final void setupLayout(CameraWrapper cameraWrapper) {
        removeAllViews();
        CameraPreview2 cameraPreview2 = new CameraPreview2(getContext(), cameraWrapper, this);
        this.f25300k = cameraPreview2;
        cameraPreview2.setAspectTolerance(this.f25298C);
        this.f25300k.setShouldScaleToFill(this.f25306q);
        if (this.f25306q) {
            addView(this.f25300k);
        } else {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            relativeLayout.setGravity(17);
            relativeLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            relativeLayout.addView(this.f25300k);
            addView(relativeLayout);
        }
        Object obj = this.f25301l;
        if (!(obj instanceof View)) {
            throw new IllegalArgumentException("IViewFinder object returned by 'createViewFinderView()' should be instance of android.view.View");
        }
        addView((View) obj);
    }
}
