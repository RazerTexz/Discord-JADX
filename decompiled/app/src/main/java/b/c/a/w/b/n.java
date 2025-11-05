package b.c.a.w.b;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import b.c.a.w.c.a;
import b.c.a.y.l.h;
import java.util.List;

/* compiled from: PolystarContent.java */
/* loaded from: classes.dex */
public class n implements m, a.b, k {

    /* renamed from: b, reason: collision with root package name */
    public final String f386b;
    public final b.c.a.j c;
    public final h.a d;
    public final boolean e;
    public final b.c.a.w.c.a<?, Float> f;
    public final b.c.a.w.c.a<?, PointF> g;
    public final b.c.a.w.c.a<?, Float> h;

    @Nullable
    public final b.c.a.w.c.a<?, Float> i;
    public final b.c.a.w.c.a<?, Float> j;

    @Nullable
    public final b.c.a.w.c.a<?, Float> k;
    public final b.c.a.w.c.a<?, Float> l;
    public boolean n;
    public final Path a = new Path();
    public b m = new b();

    public n(b.c.a.j jVar, b.c.a.y.m.b bVar, b.c.a.y.l.h hVar) {
        this.c = jVar;
        this.f386b = hVar.a;
        h.a aVar = hVar.f421b;
        this.d = aVar;
        this.e = hVar.j;
        b.c.a.w.c.a<Float, Float> aVarA = hVar.c.a();
        this.f = aVarA;
        b.c.a.w.c.a<PointF, PointF> aVarA2 = hVar.d.a();
        this.g = aVarA2;
        b.c.a.w.c.a<Float, Float> aVarA3 = hVar.e.a();
        this.h = aVarA3;
        b.c.a.w.c.a<Float, Float> aVarA4 = hVar.g.a();
        this.j = aVarA4;
        b.c.a.w.c.a<Float, Float> aVarA5 = hVar.i.a();
        this.l = aVarA5;
        h.a aVar2 = h.a.STAR;
        if (aVar == aVar2) {
            this.i = hVar.f.a();
            this.k = hVar.h.a();
        } else {
            this.i = null;
            this.k = null;
        }
        bVar.e(aVarA);
        bVar.e(aVarA2);
        bVar.e(aVarA3);
        bVar.e(aVarA4);
        bVar.e(aVarA5);
        if (aVar == aVar2) {
            bVar.e(this.i);
            bVar.e(this.k);
        }
        aVarA.a.add(this);
        aVarA2.a.add(this);
        aVarA3.a.add(this);
        aVarA4.a.add(this);
        aVarA5.a.add(this);
        if (aVar == aVar2) {
            this.i.a.add(this);
            this.k.a.add(this);
        }
    }

    @Override // b.c.a.w.c.a.b
    public void a() {
        this.n = false;
        this.c.invalidateSelf();
    }

    @Override // b.c.a.w.b.c
    public void b(List<c> list, List<c> list2) {
        for (int i = 0; i < list.size(); i++) {
            c cVar = list.get(i);
            if (cVar instanceof s) {
                s sVar = (s) cVar;
                if (sVar.c == 1) {
                    this.m.a.add(sVar);
                    sVar.f391b.add(this);
                }
            }
        }
    }

    @Override // b.c.a.y.g
    public void c(b.c.a.y.f fVar, int i, List<b.c.a.y.f> list, b.c.a.y.f fVar2) {
        b.c.a.b0.f.f(fVar, i, list, fVar2, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.c.a.y.g
    public <T> void g(T t, @Nullable b.c.a.c0.c<T> cVar) {
        b.c.a.w.c.a<?, Float> aVar;
        b.c.a.w.c.a<?, Float> aVar2;
        if (t == b.c.a.o.f369s) {
            b.c.a.w.c.a<?, Float> aVar3 = this.f;
            b.c.a.c0.c<Float> cVar2 = aVar3.e;
            aVar3.e = cVar;
            return;
        }
        if (t == b.c.a.o.t) {
            b.c.a.w.c.a<?, Float> aVar4 = this.h;
            b.c.a.c0.c<Float> cVar3 = aVar4.e;
            aVar4.e = cVar;
            return;
        }
        if (t == b.c.a.o.j) {
            b.c.a.w.c.a<?, PointF> aVar5 = this.g;
            b.c.a.c0.c<PointF> cVar4 = aVar5.e;
            aVar5.e = cVar;
            return;
        }
        if (t == b.c.a.o.u && (aVar2 = this.i) != null) {
            b.c.a.c0.c<Float> cVar5 = aVar2.e;
            aVar2.e = cVar;
            return;
        }
        if (t == b.c.a.o.v) {
            b.c.a.w.c.a<?, Float> aVar6 = this.j;
            b.c.a.c0.c<Float> cVar6 = aVar6.e;
            aVar6.e = cVar;
        } else if (t == b.c.a.o.w && (aVar = this.k) != null) {
            b.c.a.c0.c<Float> cVar7 = aVar.e;
            aVar.e = cVar;
        } else if (t == b.c.a.o.f370x) {
            b.c.a.w.c.a<?, Float> aVar7 = this.l;
            b.c.a.c0.c<Float> cVar8 = aVar7.e;
            aVar7.e = cVar;
        }
    }

    @Override // b.c.a.w.b.c
    public String getName() {
        return this.f386b;
    }

    @Override // b.c.a.w.b.m
    public Path getPath() {
        float f;
        float f2;
        float fSin;
        double d;
        float fCos;
        float fA;
        float f3;
        float f4;
        float f5;
        float f6;
        double d2;
        float f7;
        float f8;
        double d3;
        double d4;
        double d5;
        if (this.n) {
            return this.a;
        }
        this.a.reset();
        if (this.e) {
            this.n = true;
            return this.a;
        }
        int iOrdinal = this.d.ordinal();
        if (iOrdinal == 0) {
            float fFloatValue = this.f.e().floatValue();
            double radians = Math.toRadians((this.h != null ? r2.e().floatValue() : 0.0d) - 90.0d);
            double d6 = fFloatValue;
            float f9 = (float) (6.283185307179586d / d6);
            float f10 = f9 / 2.0f;
            float f11 = fFloatValue - ((int) fFloatValue);
            if (f11 != 0.0f) {
                radians += (1.0f - f11) * f10;
            }
            float fFloatValue2 = this.j.e().floatValue();
            float fFloatValue3 = this.i.e().floatValue();
            b.c.a.w.c.a<?, Float> aVar = this.k;
            float fFloatValue4 = aVar != null ? aVar.e().floatValue() / 100.0f : 0.0f;
            b.c.a.w.c.a<?, Float> aVar2 = this.l;
            float fFloatValue5 = aVar2 != null ? aVar2.e().floatValue() / 100.0f : 0.0f;
            if (f11 != 0.0f) {
                fA = b.d.b.a.a.a(fFloatValue2, fFloatValue3, f11, fFloatValue3);
                double d7 = fA;
                f = fFloatValue3;
                f2 = fFloatValue4;
                fCos = (float) (Math.cos(radians) * d7);
                fSin = (float) (d7 * Math.sin(radians));
                this.a.moveTo(fCos, fSin);
                d = radians + ((f9 * f11) / 2.0f);
            } else {
                f = fFloatValue3;
                f2 = fFloatValue4;
                double d8 = fFloatValue2;
                float fCos2 = (float) (Math.cos(radians) * d8);
                fSin = (float) (Math.sin(radians) * d8);
                this.a.moveTo(fCos2, fSin);
                d = radians + f10;
                fCos = fCos2;
                fA = 0.0f;
            }
            double dCeil = Math.ceil(d6) * 2.0d;
            int i = 0;
            boolean z2 = false;
            while (true) {
                double d9 = i;
                if (d9 >= dCeil) {
                    break;
                }
                float f12 = z2 ? fFloatValue2 : f;
                if (fA == 0.0f || d9 != dCeil - 2.0d) {
                    f3 = f9;
                    f4 = f10;
                } else {
                    f3 = f9;
                    f4 = (f9 * f11) / 2.0f;
                }
                if (fA == 0.0f || d9 != dCeil - 1.0d) {
                    f5 = fA;
                    fA = f12;
                    f6 = f4;
                } else {
                    f6 = f4;
                    f5 = fA;
                }
                double d10 = fA;
                float fCos3 = (float) (Math.cos(d) * d10);
                float fSin2 = (float) (d10 * Math.sin(d));
                if (f2 == 0.0f && fFloatValue5 == 0.0f) {
                    this.a.lineTo(fCos3, fSin2);
                    f7 = fSin2;
                    d2 = d;
                    f8 = fFloatValue5;
                } else {
                    d2 = d;
                    float f13 = fSin;
                    double dAtan2 = (float) (Math.atan2(fSin, fCos) - 1.5707963267948966d);
                    float fCos4 = (float) Math.cos(dAtan2);
                    float fSin3 = (float) Math.sin(dAtan2);
                    f7 = fSin2;
                    f8 = fFloatValue5;
                    double dAtan22 = (float) (Math.atan2(fSin2, fCos3) - 1.5707963267948966d);
                    float fCos5 = (float) Math.cos(dAtan22);
                    float fSin4 = (float) Math.sin(dAtan22);
                    float f14 = z2 ? f2 : f8;
                    float f15 = z2 ? f8 : f2;
                    float f16 = (z2 ? f : fFloatValue2) * f14 * 0.47829f;
                    float f17 = fCos4 * f16;
                    float f18 = f16 * fSin3;
                    float f19 = (z2 ? fFloatValue2 : f) * f15 * 0.47829f;
                    float f20 = fCos5 * f19;
                    float f21 = f19 * fSin4;
                    if (f11 != 0.0f) {
                        if (i == 0) {
                            f17 *= f11;
                            f18 *= f11;
                        } else if (d9 == dCeil - 1.0d) {
                            f20 *= f11;
                            f21 *= f11;
                        }
                    }
                    this.a.cubicTo(fCos - f17, f13 - f18, fCos3 + f20, f7 + f21, fCos3, f7);
                }
                d = d2 + f6;
                z2 = !z2;
                i++;
                fCos = fCos3;
                fA = f5;
                f9 = f3;
                fSin = f7;
                fFloatValue5 = f8;
            }
            PointF pointFE = this.g.e();
            this.a.offset(pointFE.x, pointFE.y);
            this.a.close();
        } else if (iOrdinal == 1) {
            int iFloor = (int) Math.floor(this.f.e().floatValue());
            double radians2 = Math.toRadians((this.h != null ? r2.e().floatValue() : 0.0d) - 90.0d);
            double d11 = iFloor;
            float fFloatValue6 = this.l.e().floatValue() / 100.0f;
            float fFloatValue7 = this.j.e().floatValue();
            double d12 = fFloatValue7;
            float fCos6 = (float) (Math.cos(radians2) * d12);
            float fSin5 = (float) (Math.sin(radians2) * d12);
            this.a.moveTo(fCos6, fSin5);
            double d13 = (float) (6.283185307179586d / d11);
            double d14 = radians2 + d13;
            double dCeil2 = Math.ceil(d11);
            int i2 = 0;
            while (i2 < dCeil2) {
                float fCos7 = (float) (Math.cos(d14) * d12);
                double d15 = dCeil2;
                float fSin6 = (float) (Math.sin(d14) * d12);
                if (fFloatValue6 != 0.0f) {
                    d4 = d12;
                    d3 = d14;
                    double dAtan23 = (float) (Math.atan2(fSin5, fCos6) - 1.5707963267948966d);
                    float fCos8 = (float) Math.cos(dAtan23);
                    float fSin7 = (float) Math.sin(dAtan23);
                    d5 = d13;
                    double dAtan24 = (float) (Math.atan2(fSin6, fCos7) - 1.5707963267948966d);
                    float f22 = fFloatValue7 * fFloatValue6 * 0.25f;
                    this.a.cubicTo(fCos6 - (fCos8 * f22), fSin5 - (fSin7 * f22), fCos7 + (((float) Math.cos(dAtan24)) * f22), fSin6 + (f22 * ((float) Math.sin(dAtan24))), fCos7, fSin6);
                } else {
                    d3 = d14;
                    d4 = d12;
                    d5 = d13;
                    this.a.lineTo(fCos7, fSin6);
                }
                d14 = d3 + d5;
                i2++;
                fSin5 = fSin6;
                fCos6 = fCos7;
                dCeil2 = d15;
                d12 = d4;
                d13 = d5;
            }
            PointF pointFE2 = this.g.e();
            this.a.offset(pointFE2.x, pointFE2.y);
            this.a.close();
        }
        this.a.close();
        this.m.a(this.a);
        this.n = true;
        return this.a;
    }
}
