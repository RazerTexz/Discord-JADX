package b.c.a.w.b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import b.c.a.w.c.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BaseStrokeContent.java */
/* loaded from: classes.dex */
public abstract class a implements a.b, k, e {
    public final b.c.a.j e;
    public final b.c.a.y.m.b f;
    public final float[] h;
    public final Paint i;
    public final b.c.a.w.c.a<?, Float> j;
    public final b.c.a.w.c.a<?, Integer> k;
    public final List<b.c.a.w.c.a<?, Float>> l;

    @Nullable
    public final b.c.a.w.c.a<?, Float> m;

    @Nullable
    public b.c.a.w.c.a<ColorFilter, ColorFilter> n;
    public final PathMeasure a = new PathMeasure();

    /* renamed from: b, reason: collision with root package name */
    public final Path f376b = new Path();
    public final Path c = new Path();
    public final RectF d = new RectF();
    public final List<b> g = new ArrayList();

    /* compiled from: BaseStrokeContent.java */
    public static final class b {
        public final List<m> a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public final s f377b;

        public b(s sVar, C0062a c0062a) {
            this.f377b = sVar;
        }
    }

    public a(b.c.a.j jVar, b.c.a.y.m.b bVar, Paint.Cap cap, Paint.Join join, float f, b.c.a.y.k.d dVar, b.c.a.y.k.b bVar2, List<b.c.a.y.k.b> list, b.c.a.y.k.b bVar3) {
        b.c.a.w.a aVar = new b.c.a.w.a(1);
        this.i = aVar;
        this.e = jVar;
        this.f = bVar;
        aVar.setStyle(Paint.Style.STROKE);
        aVar.setStrokeCap(cap);
        aVar.setStrokeJoin(join);
        aVar.setStrokeMiter(f);
        this.k = dVar.a();
        this.j = bVar2.a();
        if (bVar3 == null) {
            this.m = null;
        } else {
            this.m = bVar3.a();
        }
        this.l = new ArrayList(list.size());
        this.h = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.l.add(list.get(i).a());
        }
        bVar.e(this.k);
        bVar.e(this.j);
        for (int i2 = 0; i2 < this.l.size(); i2++) {
            bVar.e(this.l.get(i2));
        }
        b.c.a.w.c.a<?, Float> aVar2 = this.m;
        if (aVar2 != null) {
            bVar.e(aVar2);
        }
        this.k.a.add(this);
        this.j.a.add(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.l.get(i3).a.add(this);
        }
        b.c.a.w.c.a<?, Float> aVar3 = this.m;
        if (aVar3 != null) {
            aVar3.a.add(this);
        }
    }

    @Override // b.c.a.w.c.a.b
    public void a() {
        this.e.invalidateSelf();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0052  */
    @Override // b.c.a.w.b.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(List<c> list, List<c> list2) {
        s sVar = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            c cVar = list.get(size);
            if (cVar instanceof s) {
                s sVar2 = (s) cVar;
                if (sVar2.c == 2) {
                    sVar = sVar2;
                }
            }
        }
        if (sVar != null) {
            sVar.f391b.add(this);
        }
        b bVar = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            c cVar2 = list2.get(size2);
            if (cVar2 instanceof s) {
                s sVar3 = (s) cVar2;
                if (sVar3.c == 2) {
                    if (bVar != null) {
                        this.g.add(bVar);
                    }
                    bVar = new b(sVar3, null);
                    sVar3.f391b.add(this);
                } else if (cVar2 instanceof m) {
                    if (bVar == null) {
                        bVar = new b(sVar, null);
                    }
                    bVar.a.add((m) cVar2);
                }
            }
        }
        if (bVar != null) {
            this.g.add(bVar);
        }
    }

    @Override // b.c.a.y.g
    public void c(b.c.a.y.f fVar, int i, List<b.c.a.y.f> list, b.c.a.y.f fVar2) {
        b.c.a.b0.f.f(fVar, i, list, fVar2, this);
    }

    @Override // b.c.a.w.b.e
    public void d(RectF rectF, Matrix matrix, boolean z2) {
        this.f376b.reset();
        for (int i = 0; i < this.g.size(); i++) {
            b bVar = this.g.get(i);
            for (int i2 = 0; i2 < bVar.a.size(); i2++) {
                this.f376b.addPath(bVar.a.get(i2).getPath(), matrix);
            }
        }
        this.f376b.computeBounds(this.d, false);
        float fJ = ((b.c.a.w.c.c) this.j).j();
        RectF rectF2 = this.d;
        float f = fJ / 2.0f;
        rectF2.set(rectF2.left - f, rectF2.top - f, rectF2.right + f, rectF2.bottom + f);
        rectF.set(this.d);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        b.c.a.c.a("StrokeContent#getBounds");
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x01ff  */
    @Override // b.c.a.w.b.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f(Canvas canvas, Matrix matrix, int i) {
        float[] fArr = b.c.a.b0.g.d;
        boolean z2 = false;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 37394.73f;
        fArr[3] = 39575.234f;
        matrix.mapPoints(fArr);
        if (fArr[0] == fArr[2] || fArr[1] == fArr[3]) {
            b.c.a.c.a("StrokeContent#draw");
            return;
        }
        b.c.a.w.c.e eVar = (b.c.a.w.c.e) this.k;
        float fJ = (i / 255.0f) * eVar.j(eVar.a(), eVar.c());
        float f = 100.0f;
        this.i.setAlpha(b.c.a.b0.f.c((int) ((fJ / 100.0f) * 255.0f), 0, 255));
        this.i.setStrokeWidth(b.c.a.b0.g.d(matrix) * ((b.c.a.w.c.c) this.j).j());
        if (this.i.getStrokeWidth() <= 0.0f) {
            b.c.a.c.a("StrokeContent#draw");
            return;
        }
        float f2 = 1.0f;
        if (this.l.isEmpty()) {
            b.c.a.c.a("StrokeContent#applyDashPattern");
        } else {
            float fD = b.c.a.b0.g.d(matrix);
            for (int i2 = 0; i2 < this.l.size(); i2++) {
                this.h[i2] = this.l.get(i2).e().floatValue();
                if (i2 % 2 == 0) {
                    float[] fArr2 = this.h;
                    if (fArr2[i2] < 1.0f) {
                        fArr2[i2] = 1.0f;
                    }
                } else {
                    float[] fArr3 = this.h;
                    if (fArr3[i2] < 0.1f) {
                        fArr3[i2] = 0.1f;
                    }
                }
                float[] fArr4 = this.h;
                fArr4[i2] = fArr4[i2] * fD;
            }
            b.c.a.w.c.a<?, Float> aVar = this.m;
            this.i.setPathEffect(new DashPathEffect(this.h, aVar == null ? 0.0f : aVar.e().floatValue() * fD));
            b.c.a.c.a("StrokeContent#applyDashPattern");
        }
        b.c.a.w.c.a<ColorFilter, ColorFilter> aVar2 = this.n;
        if (aVar2 != null) {
            this.i.setColorFilter(aVar2.e());
        }
        int i3 = 0;
        while (i3 < this.g.size()) {
            b bVar = this.g.get(i3);
            s sVar = bVar.f377b;
            if (sVar == null) {
                this.f376b.reset();
                for (int size = bVar.a.size() - 1; size >= 0; size--) {
                    this.f376b.addPath(bVar.a.get(size).getPath(), matrix);
                }
                b.c.a.c.a("StrokeContent#buildPath");
                canvas.drawPath(this.f376b, this.i);
                b.c.a.c.a("StrokeContent#drawPath");
            } else if (sVar == null) {
                b.c.a.c.a("StrokeContent#applyTrimPath");
            } else {
                this.f376b.reset();
                int size2 = bVar.a.size();
                while (true) {
                    size2--;
                    if (size2 < 0) {
                        break;
                    } else {
                        this.f376b.addPath(bVar.a.get(size2).getPath(), matrix);
                    }
                }
                this.a.setPath(this.f376b, z2);
                float length = this.a.getLength();
                while (this.a.nextContour()) {
                    length += this.a.getLength();
                }
                float fFloatValue = (bVar.f377b.f.e().floatValue() * length) / 360.0f;
                float fFloatValue2 = ((bVar.f377b.d.e().floatValue() * length) / f) + fFloatValue;
                float fFloatValue3 = ((bVar.f377b.e.e().floatValue() * length) / f) + fFloatValue;
                int size3 = bVar.a.size() - 1;
                float f3 = 0.0f;
                while (size3 >= 0) {
                    this.c.set(bVar.a.get(size3).getPath());
                    this.c.transform(matrix);
                    this.a.setPath(this.c, z2);
                    float length2 = this.a.getLength();
                    if (fFloatValue3 > length) {
                        float f4 = fFloatValue3 - length;
                        if (f4 >= f3 + length2 || f3 >= f4) {
                            float f5 = f3 + length2;
                            if (f5 >= fFloatValue2 && f3 <= fFloatValue3) {
                                if (f5 > fFloatValue3 || fFloatValue2 >= f3) {
                                    b.c.a.b0.g.a(this.c, fFloatValue2 < f3 ? 0.0f : (fFloatValue2 - f3) / length2, fFloatValue3 > f5 ? 1.0f : (fFloatValue3 - f3) / length2, 0.0f);
                                    canvas.drawPath(this.c, this.i);
                                } else {
                                    canvas.drawPath(this.c, this.i);
                                }
                            }
                        } else {
                            b.c.a.b0.g.a(this.c, fFloatValue2 > length ? (fFloatValue2 - length) / length2 : 0.0f, Math.min(f4 / length2, f2), 0.0f);
                            canvas.drawPath(this.c, this.i);
                        }
                    }
                    f3 += length2;
                    size3--;
                    z2 = false;
                    f2 = 1.0f;
                }
                b.c.a.c.a("StrokeContent#applyTrimPath");
            }
            i3++;
            z2 = false;
            f = 100.0f;
            f2 = 1.0f;
        }
        b.c.a.c.a("StrokeContent#draw");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.c.a.y.g
    @CallSuper
    public <T> void g(T t, @Nullable b.c.a.c0.c<T> cVar) {
        if (t == b.c.a.o.d) {
            b.c.a.w.c.a<?, Integer> aVar = this.k;
            b.c.a.c0.c<Integer> cVar2 = aVar.e;
            aVar.e = cVar;
            return;
        }
        if (t == b.c.a.o.o) {
            b.c.a.w.c.a<?, Float> aVar2 = this.j;
            b.c.a.c0.c<Float> cVar3 = aVar2.e;
            aVar2.e = cVar;
        } else if (t == b.c.a.o.C) {
            b.c.a.w.c.a<ColorFilter, ColorFilter> aVar3 = this.n;
            if (aVar3 != null) {
                this.f.u.remove(aVar3);
            }
            if (cVar == 0) {
                this.n = null;
                return;
            }
            b.c.a.w.c.p pVar = new b.c.a.w.c.p(cVar, null);
            this.n = pVar;
            pVar.a.add(this);
            this.f.e(this.n);
        }
    }
}
