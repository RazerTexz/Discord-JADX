package p007b.p109f.p161j.p162a.p165c;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import java.util.Objects;
import p007b.p109f.p161j.p162a.p163a.AnimatedDrawableBackend;
import p007b.p109f.p161j.p162a.p163a.AnimatedDrawableFrameInfo;
import p007b.p109f.p161j.p162a.p163a.AnimatedImage;
import p007b.p109f.p161j.p162a.p163a.AnimatedImageFrame;
import p007b.p109f.p161j.p162a.p163a.AnimatedImageResult;
import p007b.p109f.p161j.p162a.p166d.AnimatedDrawableUtil;

/* JADX INFO: renamed from: b.f.j.a.c.a, reason: use source file name */
/* JADX INFO: compiled from: AnimatedDrawableBackendImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class AnimatedDrawableBackendImpl implements AnimatedDrawableBackend {

    /* JADX INFO: renamed from: a */
    public final AnimatedDrawableUtil f3624a;

    /* JADX INFO: renamed from: b */
    public final AnimatedImageResult f3625b;

    /* JADX INFO: renamed from: c */
    public final AnimatedImage f3626c;

    /* JADX INFO: renamed from: d */
    public final Rect f3627d;

    /* JADX INFO: renamed from: e */
    public final int[] f3628e;

    /* JADX INFO: renamed from: f */
    public final AnimatedDrawableFrameInfo[] f3629f;

    /* JADX INFO: renamed from: g */
    public final Rect f3630g = new Rect();

    /* JADX INFO: renamed from: h */
    public final Rect f3631h = new Rect();

    /* JADX INFO: renamed from: i */
    public final boolean f3632i;

    /* JADX INFO: renamed from: j */
    public Bitmap f3633j;

    public AnimatedDrawableBackendImpl(AnimatedDrawableUtil animatedDrawableUtil, AnimatedImageResult animatedImageResult, Rect rect, boolean z2) {
        this.f3624a = animatedDrawableUtil;
        this.f3625b = animatedImageResult;
        AnimatedImage animatedImage = animatedImageResult.f3609a;
        this.f3626c = animatedImage;
        int[] iArrMo1183i = animatedImage.mo1183i();
        this.f3628e = iArrMo1183i;
        Objects.requireNonNull(animatedDrawableUtil);
        for (int i = 0; i < iArrMo1183i.length; i++) {
            if (iArrMo1183i[i] < 11) {
                iArrMo1183i[i] = 100;
            }
        }
        AnimatedDrawableUtil animatedDrawableUtil2 = this.f3624a;
        int[] iArr = this.f3628e;
        Objects.requireNonNull(animatedDrawableUtil2);
        for (int i2 : iArr) {
        }
        AnimatedDrawableUtil animatedDrawableUtil3 = this.f3624a;
        int[] iArr2 = this.f3628e;
        Objects.requireNonNull(animatedDrawableUtil3);
        int[] iArr3 = new int[iArr2.length];
        int i3 = 0;
        for (int i4 = 0; i4 < iArr2.length; i4++) {
            iArr3[i4] = i3;
            i3 += iArr2[i4];
        }
        this.f3627d = m1195a(this.f3626c, rect);
        this.f3632i = z2;
        this.f3629f = new AnimatedDrawableFrameInfo[this.f3626c.mo1177a()];
        for (int i5 = 0; i5 < this.f3626c.mo1177a(); i5++) {
            this.f3629f[i5] = this.f3626c.mo1182g(i5);
        }
    }

    /* JADX INFO: renamed from: a */
    public static Rect m1195a(AnimatedImage animatedImage, Rect rect) {
        return rect == null ? new Rect(0, 0, animatedImage.getWidth(), animatedImage.getHeight()) : new Rect(0, 0, Math.min(rect.width(), animatedImage.getWidth()), Math.min(rect.height(), animatedImage.getHeight()));
    }

    /* JADX INFO: renamed from: b */
    public int m1196b() {
        return this.f3626c.mo1177a();
    }

    /* JADX INFO: renamed from: c */
    public final synchronized Bitmap m1197c(int i, int i2) {
        Bitmap bitmap = this.f3633j;
        if (bitmap != null && (bitmap.getWidth() < i || this.f3633j.getHeight() < i2)) {
            synchronized (this) {
                Bitmap bitmap2 = this.f3633j;
                if (bitmap2 != null) {
                    bitmap2.recycle();
                    this.f3633j = null;
                }
            }
        }
        if (this.f3633j == null) {
            this.f3633j = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
        this.f3633j.eraseColor(0);
        return this.f3633j;
    }

    /* JADX INFO: renamed from: d */
    public void m1198d(int i, Canvas canvas) {
        AnimatedImageFrame animatedImageFrameMo1180e = this.f3626c.mo1180e(i);
        try {
            if (animatedImageFrameMo1180e.getWidth() > 0 && animatedImageFrameMo1180e.getHeight() > 0) {
                if (this.f3626c.mo1181f()) {
                    m1200f(canvas, animatedImageFrameMo1180e);
                } else {
                    m1199e(canvas, animatedImageFrameMo1180e);
                }
            }
        } finally {
            animatedImageFrameMo1180e.dispose();
        }
    }

    /* JADX INFO: renamed from: e */
    public final void m1199e(Canvas canvas, AnimatedImageFrame animatedImageFrame) {
        int width;
        int height;
        int iMo1186b;
        int iMo1187c;
        if (this.f3632i) {
            float fMax = Math.max(animatedImageFrame.getWidth() / Math.min(animatedImageFrame.getWidth(), canvas.getWidth()), animatedImageFrame.getHeight() / Math.min(animatedImageFrame.getHeight(), canvas.getHeight()));
            width = (int) (animatedImageFrame.getWidth() / fMax);
            height = (int) (animatedImageFrame.getHeight() / fMax);
            iMo1186b = (int) (animatedImageFrame.mo1186b() / fMax);
            iMo1187c = (int) (animatedImageFrame.mo1187c() / fMax);
        } else {
            width = animatedImageFrame.getWidth();
            height = animatedImageFrame.getHeight();
            iMo1186b = animatedImageFrame.mo1186b();
            iMo1187c = animatedImageFrame.mo1187c();
        }
        synchronized (this) {
            Bitmap bitmapM1197c = m1197c(width, height);
            this.f3633j = bitmapM1197c;
            animatedImageFrame.mo1185a(width, height, bitmapM1197c);
            canvas.save();
            canvas.translate(iMo1186b, iMo1187c);
            canvas.drawBitmap(this.f3633j, 0.0f, 0.0f, (Paint) null);
            canvas.restore();
        }
    }

    /* JADX INFO: renamed from: f */
    public final void m1200f(Canvas canvas, AnimatedImageFrame animatedImageFrame) {
        double dWidth = ((double) this.f3627d.width()) / ((double) this.f3626c.getWidth());
        double dHeight = ((double) this.f3627d.height()) / ((double) this.f3626c.getHeight());
        int iRound = (int) Math.round(((double) animatedImageFrame.getWidth()) * dWidth);
        int iRound2 = (int) Math.round(((double) animatedImageFrame.getHeight()) * dHeight);
        int iMo1186b = (int) (((double) animatedImageFrame.mo1186b()) * dWidth);
        int iMo1187c = (int) (((double) animatedImageFrame.mo1187c()) * dHeight);
        synchronized (this) {
            int iWidth = this.f3627d.width();
            int iHeight = this.f3627d.height();
            m1197c(iWidth, iHeight);
            Bitmap bitmap = this.f3633j;
            if (bitmap != null) {
                animatedImageFrame.mo1185a(iRound, iRound2, bitmap);
            }
            this.f3630g.set(0, 0, iWidth, iHeight);
            this.f3631h.set(iMo1186b, iMo1187c, iWidth + iMo1186b, iHeight + iMo1187c);
            Bitmap bitmap2 = this.f3633j;
            if (bitmap2 != null) {
                canvas.drawBitmap(bitmap2, this.f3630g, this.f3631h, (Paint) null);
            }
        }
    }
}
