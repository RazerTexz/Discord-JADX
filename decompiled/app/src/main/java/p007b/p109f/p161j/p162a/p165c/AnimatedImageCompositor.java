package p007b.p109f.p161j.p162a.p165c;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import com.facebook.common.references.CloseableReference;
import p007b.p085c.p086a.p095y.C1563b;
import p007b.p109f.p161j.p162a.p163a.AnimatedDrawableBackend;
import p007b.p109f.p161j.p162a.p163a.AnimatedDrawableFrameInfo;
import p007b.p109f.p161j.p162a.p163a.AnimatedImageResult;
import p007b.p109f.p161j.p185t.BitmapTransformation;

/* JADX INFO: renamed from: b.f.j.a.c.d, reason: use source file name */
/* JADX INFO: compiled from: AnimatedImageCompositor.java */
/* JADX INFO: loaded from: classes2.dex */
public class AnimatedImageCompositor {

    /* JADX INFO: renamed from: a */
    public final AnimatedDrawableBackend f3641a;

    /* JADX INFO: renamed from: b */
    public final a f3642b;

    /* JADX INFO: renamed from: c */
    public final Paint f3643c;

    /* JADX INFO: renamed from: b.f.j.a.c.d$a */
    /* JADX INFO: compiled from: AnimatedImageCompositor.java */
    public interface a {
        /* JADX INFO: renamed from: a */
        void mo1162a(int i, Bitmap bitmap);

        /* JADX INFO: renamed from: b */
        CloseableReference<Bitmap> mo1163b(int i);
    }

    public AnimatedImageCompositor(AnimatedDrawableBackend animatedDrawableBackend, a aVar) {
        this.f3641a = animatedDrawableBackend;
        this.f3642b = aVar;
        Paint paint = new Paint();
        this.f3643c = paint;
        paint.setColor(0);
        paint.setStyle(Paint.Style.FILL);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    }

    /* JADX INFO: renamed from: a */
    public final void m1202a(Canvas canvas, AnimatedDrawableFrameInfo animatedDrawableFrameInfo) {
        canvas.drawRect(animatedDrawableFrameInfo.f3603a, animatedDrawableFrameInfo.f3604b, r0 + animatedDrawableFrameInfo.f3605c, r1 + animatedDrawableFrameInfo.f3606d, this.f3643c);
    }

    /* JADX INFO: renamed from: b */
    public final boolean m1203b(AnimatedDrawableFrameInfo animatedDrawableFrameInfo) {
        return animatedDrawableFrameInfo.f3603a == 0 && animatedDrawableFrameInfo.f3604b == 0 && animatedDrawableFrameInfo.f3605c == ((AnimatedDrawableBackendImpl) this.f3641a).f3627d.width() && animatedDrawableFrameInfo.f3606d == ((AnimatedDrawableBackendImpl) this.f3641a).f3627d.height();
    }

    /* JADX INFO: renamed from: c */
    public final boolean m1204c(int i) {
        if (i == 0) {
            return true;
        }
        AnimatedDrawableFrameInfo[] animatedDrawableFrameInfoArr = ((AnimatedDrawableBackendImpl) this.f3641a).f3629f;
        AnimatedDrawableFrameInfo animatedDrawableFrameInfo = animatedDrawableFrameInfoArr[i];
        AnimatedDrawableFrameInfo animatedDrawableFrameInfo2 = animatedDrawableFrameInfoArr[i - 1];
        if (animatedDrawableFrameInfo.f3607e == 2 && m1203b(animatedDrawableFrameInfo)) {
            return true;
        }
        return animatedDrawableFrameInfo2.f3608f == 2 && m1203b(animatedDrawableFrameInfo2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0077, code lost:
    
        r2 = r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002f  */
    /* JADX INFO: renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m1205d(int i, Bitmap bitmap) {
        BitmapTransformation bitmapTransformation;
        Canvas canvas = new Canvas(bitmap);
        int i2 = 0;
        canvas.drawColor(0, PorterDuff.Mode.SRC);
        if (m1204c(i)) {
            i2 = i;
        } else {
            int i3 = i - 1;
            while (true) {
                if (i3 < 0) {
                    break;
                }
                AnimatedDrawableFrameInfo animatedDrawableFrameInfo = ((AnimatedDrawableBackendImpl) this.f3641a).f3629f[i3];
                int i4 = animatedDrawableFrameInfo.f3608f;
                if (i4 != 1) {
                    int i5 = i4 == 2 ? m1203b(animatedDrawableFrameInfo) ? 2 : 1 : i4 == 3 ? 3 : 4;
                    int iM758h = C1563b.m758h(i5);
                    if (iM758h == 0) {
                        AnimatedDrawableFrameInfo animatedDrawableFrameInfo2 = ((AnimatedDrawableBackendImpl) this.f3641a).f3629f[i3];
                        CloseableReference<Bitmap> closeableReferenceMo1163b = this.f3642b.mo1163b(i3);
                        if (closeableReferenceMo1163b != null) {
                            try {
                                canvas.drawBitmap(closeableReferenceMo1163b.m8642u(), 0.0f, 0.0f, (Paint) null);
                                if (animatedDrawableFrameInfo2.f3608f == 2) {
                                    m1202a(canvas, animatedDrawableFrameInfo2);
                                }
                                i2 = i3 + 1;
                            } finally {
                                closeableReferenceMo1163b.close();
                            }
                        } else if (m1204c(i3)) {
                            break;
                        } else {
                            i3--;
                        }
                    } else if (iM758h == 1) {
                        i2 = i3 + 1;
                        break;
                    } else if (iM758h == 3) {
                        break;
                    } else {
                        i3--;
                    }
                }
            }
        }
        while (i2 < i) {
            AnimatedDrawableFrameInfo animatedDrawableFrameInfo3 = ((AnimatedDrawableBackendImpl) this.f3641a).f3629f[i2];
            int i6 = animatedDrawableFrameInfo3.f3608f;
            if (i6 != 3) {
                if (animatedDrawableFrameInfo3.f3607e == 2) {
                    m1202a(canvas, animatedDrawableFrameInfo3);
                }
                ((AnimatedDrawableBackendImpl) this.f3641a).m1198d(i2, canvas);
                this.f3642b.mo1162a(i2, bitmap);
                if (i6 == 2) {
                    m1202a(canvas, animatedDrawableFrameInfo3);
                }
            }
            i2++;
        }
        AnimatedDrawableFrameInfo animatedDrawableFrameInfo4 = ((AnimatedDrawableBackendImpl) this.f3641a).f3629f[i];
        if (animatedDrawableFrameInfo4.f3607e == 2) {
            m1202a(canvas, animatedDrawableFrameInfo4);
        }
        ((AnimatedDrawableBackendImpl) this.f3641a).m1198d(i, canvas);
        AnimatedImageResult animatedImageResult = ((AnimatedDrawableBackendImpl) this.f3641a).f3625b;
        if (animatedImageResult == null || (bitmapTransformation = animatedImageResult.f3612d) == null) {
            return;
        }
        bitmapTransformation.m1537a(bitmap);
    }
}
