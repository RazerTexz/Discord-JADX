package p007b.p085c.p086a.p091w.p092b;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import p007b.p085c.p086a.LottieDrawable;
import p007b.p085c.p086a.p089b0.Utils;
import p007b.p085c.p086a.p090c0.LottieValueCallback;
import p007b.p085c.p086a.p091w.LPaint;
import p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation;
import p007b.p085c.p086a.p091w.p093c.TransformKeyframeAnimation;
import p007b.p085c.p086a.p095y.KeyPath;
import p007b.p085c.p086a.p095y.KeyPathElement;
import p007b.p085c.p086a.p095y.p096k.AnimatableTransform;
import p007b.p085c.p086a.p095y.p097l.ContentModel2;
import p007b.p085c.p086a.p095y.p097l.ShapeGroup;
import p007b.p085c.p086a.p095y.p098m.BaseLayer2;

/* JADX INFO: renamed from: b.c.a.w.b.d, reason: use source file name */
/* JADX INFO: compiled from: ContentGroup.java */
/* JADX INFO: loaded from: classes.dex */
public class ContentGroup implements DrawingContent, PathContent, BaseKeyframeAnimation.b, KeyPathElement {

    /* JADX INFO: renamed from: a */
    public Paint f2482a;

    /* JADX INFO: renamed from: b */
    public RectF f2483b;

    /* JADX INFO: renamed from: c */
    public final Matrix f2484c;

    /* JADX INFO: renamed from: d */
    public final Path f2485d;

    /* JADX INFO: renamed from: e */
    public final RectF f2486e;

    /* JADX INFO: renamed from: f */
    public final String f2487f;

    /* JADX INFO: renamed from: g */
    public final boolean f2488g;

    /* JADX INFO: renamed from: h */
    public final List<Content2> f2489h;

    /* JADX INFO: renamed from: i */
    public final LottieDrawable f2490i;

    /* JADX INFO: renamed from: j */
    @Nullable
    public List<PathContent> f2491j;

    /* JADX INFO: renamed from: k */
    @Nullable
    public TransformKeyframeAnimation f2492k;

    public ContentGroup(LottieDrawable lottieDrawable, BaseLayer2 baseLayer2, ShapeGroup shapeGroup) {
        AnimatableTransform animatableTransform;
        String str = shapeGroup.f2812a;
        boolean z2 = shapeGroup.f2814c;
        List<ContentModel2> list = shapeGroup.f2813b;
        ArrayList arrayList = new ArrayList(list.size());
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            Content2 content2Mo775a = list.get(i2).mo775a(lottieDrawable, baseLayer2);
            if (content2Mo775a != null) {
                arrayList.add(content2Mo775a);
            }
        }
        List<ContentModel2> list2 = shapeGroup.f2813b;
        while (true) {
            if (i >= list2.size()) {
                animatableTransform = null;
                break;
            }
            ContentModel2 contentModel2 = list2.get(i);
            if (contentModel2 instanceof AnimatableTransform) {
                animatableTransform = (AnimatableTransform) contentModel2;
                break;
            }
            i++;
        }
        this(lottieDrawable, baseLayer2, str, z2, arrayList, animatableTransform);
    }

    @Override // p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation.b
    /* JADX INFO: renamed from: a */
    public void mo709a() {
        this.f2490i.invalidateSelf();
    }

    @Override // p007b.p085c.p086a.p091w.p092b.Content2
    /* JADX INFO: renamed from: b */
    public void mo710b(List<Content2> list, List<Content2> list2) {
        ArrayList arrayList = new ArrayList(this.f2489h.size() + list.size());
        arrayList.addAll(list);
        for (int size = this.f2489h.size() - 1; size >= 0; size--) {
            Content2 content2 = this.f2489h.get(size);
            content2.mo710b(arrayList, this.f2489h.subList(0, size));
            arrayList.add(content2);
        }
    }

    @Override // p007b.p085c.p086a.p095y.KeyPathElement
    /* JADX INFO: renamed from: c */
    public void mo711c(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        if (keyPath.m770e(this.f2487f, i)) {
            if (!"__container".equals(this.f2487f)) {
                keyPath2 = keyPath2.m766a(this.f2487f);
                if (keyPath.m768c(this.f2487f, i)) {
                    list.add(keyPath2.m772g(this));
                }
            }
            if (keyPath.m771f(this.f2487f, i)) {
                int iM769d = keyPath.m769d(this.f2487f, i) + i;
                for (int i2 = 0; i2 < this.f2489h.size(); i2++) {
                    Content2 content2 = this.f2489h.get(i2);
                    if (content2 instanceof KeyPathElement) {
                        ((KeyPathElement) content2).mo711c(keyPath, iM769d, list, keyPath2);
                    }
                }
            }
        }
    }

    @Override // p007b.p085c.p086a.p091w.p092b.DrawingContent
    /* JADX INFO: renamed from: d */
    public void mo712d(RectF rectF, Matrix matrix, boolean z2) {
        this.f2484c.set(matrix);
        TransformKeyframeAnimation transformKeyframeAnimation = this.f2492k;
        if (transformKeyframeAnimation != null) {
            this.f2484c.preConcat(transformKeyframeAnimation.m747e());
        }
        this.f2486e.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.f2489h.size() - 1; size >= 0; size--) {
            Content2 content2 = this.f2489h.get(size);
            if (content2 instanceof DrawingContent) {
                ((DrawingContent) content2).mo712d(this.f2486e, this.f2484c, z2);
                rectF.union(this.f2486e);
            }
        }
    }

    /* JADX INFO: renamed from: e */
    public List<PathContent> m716e() {
        if (this.f2491j == null) {
            this.f2491j = new ArrayList();
            for (int i = 0; i < this.f2489h.size(); i++) {
                Content2 content2 = this.f2489h.get(i);
                if (content2 instanceof PathContent) {
                    this.f2491j.add((PathContent) content2);
                }
            }
        }
        return this.f2491j;
    }

    @Override // p007b.p085c.p086a.p091w.p092b.DrawingContent
    /* JADX INFO: renamed from: f */
    public void mo713f(Canvas canvas, Matrix matrix, int i) {
        boolean z2;
        if (this.f2488g) {
            return;
        }
        this.f2484c.set(matrix);
        TransformKeyframeAnimation transformKeyframeAnimation = this.f2492k;
        if (transformKeyframeAnimation != null) {
            this.f2484c.preConcat(transformKeyframeAnimation.m747e());
            i = (int) (((((this.f2492k.f2636j == null ? 100 : r7.mo727e().intValue()) / 100.0f) * i) / 255.0f) * 255.0f);
        }
        boolean z3 = false;
        if (this.f2490i.f2366A) {
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i2 >= this.f2489h.size()) {
                    z2 = false;
                    break;
                } else {
                    if ((this.f2489h.get(i2) instanceof DrawingContent) && (i3 = i3 + 1) >= 2) {
                        z2 = true;
                        break;
                    }
                    i2++;
                }
            }
            if (z2 && i != 255) {
                z3 = true;
            }
        }
        if (z3) {
            this.f2483b.set(0.0f, 0.0f, 0.0f, 0.0f);
            mo712d(this.f2483b, this.f2484c, true);
            this.f2482a.setAlpha(i);
            Utils.m662f(canvas, this.f2483b, this.f2482a, 31);
        }
        if (z3) {
            i = 255;
        }
        for (int size = this.f2489h.size() - 1; size >= 0; size--) {
            Content2 content2 = this.f2489h.get(size);
            if (content2 instanceof DrawingContent) {
                ((DrawingContent) content2).mo713f(canvas, this.f2484c, i);
            }
        }
        if (z3) {
            canvas.restore();
        }
    }

    @Override // p007b.p085c.p086a.p095y.KeyPathElement
    /* JADX INFO: renamed from: g */
    public <T> void mo714g(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        TransformKeyframeAnimation transformKeyframeAnimation = this.f2492k;
        if (transformKeyframeAnimation != null) {
            transformKeyframeAnimation.m745c(t, lottieValueCallback);
        }
    }

    @Override // p007b.p085c.p086a.p091w.p092b.Content2
    public String getName() {
        return this.f2487f;
    }

    @Override // p007b.p085c.p086a.p091w.p092b.PathContent
    public Path getPath() {
        this.f2484c.reset();
        TransformKeyframeAnimation transformKeyframeAnimation = this.f2492k;
        if (transformKeyframeAnimation != null) {
            this.f2484c.set(transformKeyframeAnimation.m747e());
        }
        this.f2485d.reset();
        if (this.f2488g) {
            return this.f2485d;
        }
        for (int size = this.f2489h.size() - 1; size >= 0; size--) {
            Content2 content2 = this.f2489h.get(size);
            if (content2 instanceof PathContent) {
                this.f2485d.addPath(((PathContent) content2).getPath(), this.f2484c);
            }
        }
        return this.f2485d;
    }

    public ContentGroup(LottieDrawable lottieDrawable, BaseLayer2 baseLayer2, String str, boolean z2, List<Content2> list, @Nullable AnimatableTransform animatableTransform) {
        this.f2482a = new LPaint();
        this.f2483b = new RectF();
        this.f2484c = new Matrix();
        this.f2485d = new Path();
        this.f2486e = new RectF();
        this.f2487f = str;
        this.f2490i = lottieDrawable;
        this.f2488g = z2;
        this.f2489h = list;
        if (animatableTransform != null) {
            TransformKeyframeAnimation transformKeyframeAnimation = new TransformKeyframeAnimation(animatableTransform);
            this.f2492k = transformKeyframeAnimation;
            transformKeyframeAnimation.m743a(baseLayer2);
            this.f2492k.m744b(this);
        }
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            Content2 content2 = list.get(size);
            if (content2 instanceof GreedyContent) {
                arrayList.add((GreedyContent) content2);
            }
        }
        int size2 = arrayList.size();
        while (true) {
            size2--;
            if (size2 < 0) {
                return;
            } else {
                ((GreedyContent) arrayList.get(size2)).mo721e(list.listIterator(list.size()));
            }
        }
    }
}
