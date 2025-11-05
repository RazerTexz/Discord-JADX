package b.c.a.y.m;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import b.c.a.j;
import b.c.a.o;
import b.c.a.w.c.n;
import b.c.a.w.c.p;
import b.c.a.y.k.k;
import b.c.a.y.l.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* compiled from: TextLayer.java */
/* loaded from: classes.dex */
public class i extends b.c.a.y.m.b {
    public final Paint A;
    public final Paint B;
    public final Map<b.c.a.y.e, List<b.c.a.w.b.d>> C;
    public final LongSparseArray<String> D;
    public final n E;
    public final j F;
    public final b.c.a.d G;

    @Nullable
    public b.c.a.w.c.a<Integer, Integer> H;

    @Nullable
    public b.c.a.w.c.a<Integer, Integer> I;

    @Nullable
    public b.c.a.w.c.a<Integer, Integer> J;

    @Nullable
    public b.c.a.w.c.a<Integer, Integer> K;

    @Nullable
    public b.c.a.w.c.a<Float, Float> L;

    @Nullable
    public b.c.a.w.c.a<Float, Float> M;

    @Nullable
    public b.c.a.w.c.a<Float, Float> N;

    @Nullable
    public b.c.a.w.c.a<Float, Float> O;

    @Nullable
    public b.c.a.w.c.a<Float, Float> P;

    /* renamed from: x, reason: collision with root package name */
    public final StringBuilder f444x;

    /* renamed from: y, reason: collision with root package name */
    public final RectF f445y;

    /* renamed from: z, reason: collision with root package name */
    public final Matrix f446z;

    /* compiled from: TextLayer.java */
    public class a extends Paint {
        public a(i iVar, int i) {
            super(i);
            setStyle(Paint.Style.FILL);
        }
    }

    /* compiled from: TextLayer.java */
    public class b extends Paint {
        public b(i iVar, int i) {
            super(i);
            setStyle(Paint.Style.STROKE);
        }
    }

    public i(j jVar, e eVar) {
        b.c.a.y.k.b bVar;
        b.c.a.y.k.b bVar2;
        b.c.a.y.k.a aVar;
        b.c.a.y.k.a aVar2;
        super(jVar, eVar);
        this.f444x = new StringBuilder(2);
        this.f445y = new RectF();
        this.f446z = new Matrix();
        this.A = new a(this, 1);
        this.B = new b(this, 1);
        this.C = new HashMap();
        this.D = new LongSparseArray<>();
        this.F = jVar;
        this.G = eVar.f438b;
        n nVar = new n(eVar.q.a);
        this.E = nVar;
        nVar.a.add(this);
        e(nVar);
        k kVar = eVar.r;
        if (kVar != null && (aVar2 = kVar.a) != null) {
            b.c.a.w.c.a<Integer, Integer> aVarA = aVar2.a();
            this.H = aVarA;
            aVarA.a.add(this);
            e(this.H);
        }
        if (kVar != null && (aVar = kVar.f413b) != null) {
            b.c.a.w.c.a<Integer, Integer> aVarA2 = aVar.a();
            this.J = aVarA2;
            aVarA2.a.add(this);
            e(this.J);
        }
        if (kVar != null && (bVar2 = kVar.c) != null) {
            b.c.a.w.c.a<Float, Float> aVarA3 = bVar2.a();
            this.L = aVarA3;
            aVarA3.a.add(this);
            e(this.L);
        }
        if (kVar == null || (bVar = kVar.d) == null) {
            return;
        }
        b.c.a.w.c.a<Float, Float> aVarA4 = bVar.a();
        this.N = aVarA4;
        aVarA4.a.add(this);
        e(this.N);
    }

    @Override // b.c.a.y.m.b, b.c.a.w.b.e
    public void d(RectF rectF, Matrix matrix, boolean z2) {
        super.d(rectF, matrix, z2);
        rectF.set(0.0f, 0.0f, this.G.j.width(), this.G.j.height());
    }

    @Override // b.c.a.y.m.b, b.c.a.y.g
    public <T> void g(T t, @Nullable b.c.a.c0.c<T> cVar) {
        this.v.c(t, cVar);
        if (t == o.a) {
            b.c.a.w.c.a<Integer, Integer> aVar = this.I;
            if (aVar != null) {
                this.u.remove(aVar);
            }
            if (cVar == null) {
                this.I = null;
                return;
            }
            p pVar = new p(cVar, null);
            this.I = pVar;
            pVar.a.add(this);
            e(this.I);
            return;
        }
        if (t == o.f368b) {
            b.c.a.w.c.a<Integer, Integer> aVar2 = this.K;
            if (aVar2 != null) {
                this.u.remove(aVar2);
            }
            if (cVar == null) {
                this.K = null;
                return;
            }
            p pVar2 = new p(cVar, null);
            this.K = pVar2;
            pVar2.a.add(this);
            e(this.K);
            return;
        }
        if (t == o.o) {
            b.c.a.w.c.a<Float, Float> aVar3 = this.M;
            if (aVar3 != null) {
                this.u.remove(aVar3);
            }
            if (cVar == null) {
                this.M = null;
                return;
            }
            p pVar3 = new p(cVar, null);
            this.M = pVar3;
            pVar3.a.add(this);
            e(this.M);
            return;
        }
        if (t == o.p) {
            b.c.a.w.c.a<Float, Float> aVar4 = this.O;
            if (aVar4 != null) {
                this.u.remove(aVar4);
            }
            if (cVar == null) {
                this.O = null;
                return;
            }
            p pVar4 = new p(cVar, null);
            this.O = pVar4;
            pVar4.a.add(this);
            e(this.O);
            return;
        }
        if (t == o.B) {
            b.c.a.w.c.a<Float, Float> aVar5 = this.P;
            if (aVar5 != null) {
                this.u.remove(aVar5);
            }
            if (cVar == null) {
                this.P = null;
                return;
            }
            p pVar5 = new p(cVar, null);
            this.P = pVar5;
            pVar5.a.add(this);
            e(this.P);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v4, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v1, types: [T, java.lang.Object, java.lang.String] */
    @Override // b.c.a.y.m.b
    public void j(Canvas canvas, Matrix matrix, int i) {
        b.c.a.x.a aVar;
        String str;
        float fFloatValue;
        List<String> list;
        int i2;
        String str2;
        List<b.c.a.w.b.d> list2;
        float fFloatValue2;
        String str3;
        float f;
        int i3;
        canvas.save();
        if (!(this.F.k.g.size() > 0)) {
            canvas.setMatrix(matrix);
        }
        b.c.a.y.c cVarE = this.E.e();
        b.c.a.y.d dVar = this.G.e.get(cVarE.f405b);
        if (dVar == null) {
            canvas.restore();
            return;
        }
        b.c.a.w.c.a<Integer, Integer> aVar2 = this.I;
        if (aVar2 != null) {
            this.A.setColor(aVar2.e().intValue());
        } else {
            b.c.a.w.c.a<Integer, Integer> aVar3 = this.H;
            if (aVar3 != null) {
                this.A.setColor(aVar3.e().intValue());
            } else {
                this.A.setColor(cVarE.h);
            }
        }
        b.c.a.w.c.a<Integer, Integer> aVar4 = this.K;
        if (aVar4 != null) {
            this.B.setColor(aVar4.e().intValue());
        } else {
            b.c.a.w.c.a<Integer, Integer> aVar5 = this.J;
            if (aVar5 != null) {
                this.B.setColor(aVar5.e().intValue());
            } else {
                this.B.setColor(cVarE.i);
            }
        }
        b.c.a.w.c.a<Integer, Integer> aVar6 = this.v.j;
        int iIntValue = ((aVar6 == null ? 100 : aVar6.e().intValue()) * 255) / 100;
        this.A.setAlpha(iIntValue);
        this.B.setAlpha(iIntValue);
        b.c.a.w.c.a<Float, Float> aVar7 = this.M;
        if (aVar7 != null) {
            this.B.setStrokeWidth(aVar7.e().floatValue());
        } else {
            b.c.a.w.c.a<Float, Float> aVar8 = this.L;
            if (aVar8 != null) {
                this.B.setStrokeWidth(aVar8.e().floatValue());
            } else {
                this.B.setStrokeWidth(b.c.a.b0.g.c() * cVarE.j * b.c.a.b0.g.d(matrix));
            }
        }
        if (this.F.k.g.size() > 0) {
            b.c.a.w.c.a<Float, Float> aVar9 = this.P;
            float fFloatValue3 = (aVar9 != null ? aVar9.e().floatValue() : cVarE.c) / 100.0f;
            float fD = b.c.a.b0.g.d(matrix);
            String str4 = cVarE.a;
            float fC = b.c.a.b0.g.c() * cVarE.f;
            List<String> listT = t(str4);
            int size = listT.size();
            int i4 = 0;
            while (i4 < size) {
                String str5 = listT.get(i4);
                float fC2 = 0.0f;
                int i5 = 0;
                while (i5 < str5.length()) {
                    b.c.a.y.e eVar = this.G.g.get(b.c.a.y.e.a(str5.charAt(i5), dVar.a, dVar.c));
                    if (eVar == null) {
                        f = fC;
                        i3 = i4;
                        str3 = str5;
                    } else {
                        str3 = str5;
                        double d = eVar.c;
                        f = fC;
                        i3 = i4;
                        fC2 = (float) ((d * fFloatValue3 * b.c.a.b0.g.c() * fD) + fC2);
                    }
                    i5++;
                    str5 = str3;
                    fC = f;
                    i4 = i3;
                }
                float f2 = fC;
                int i6 = i4;
                String str6 = str5;
                canvas.save();
                q(cVarE.d, canvas, fC2);
                canvas.translate(0.0f, (i6 * f2) - (((size - 1) * f2) / 2.0f));
                int i7 = 0;
                while (i7 < str6.length()) {
                    String str7 = str6;
                    b.c.a.y.e eVar2 = this.G.g.get(b.c.a.y.e.a(str7.charAt(i7), dVar.a, dVar.c));
                    if (eVar2 == null) {
                        list = listT;
                        i2 = size;
                        str2 = str7;
                    } else {
                        if (this.C.containsKey(eVar2)) {
                            list2 = this.C.get(eVar2);
                            list = listT;
                            i2 = size;
                            str2 = str7;
                        } else {
                            List<m> list3 = eVar2.a;
                            int size2 = list3.size();
                            ArrayList arrayList = new ArrayList(size2);
                            list = listT;
                            int i8 = 0;
                            while (i8 < size2) {
                                arrayList.add(new b.c.a.w.b.d(this.F, this, list3.get(i8)));
                                i8++;
                                str7 = str7;
                                size = size;
                                list3 = list3;
                            }
                            i2 = size;
                            str2 = str7;
                            this.C.put(eVar2, arrayList);
                            list2 = arrayList;
                        }
                        int i9 = 0;
                        while (i9 < list2.size()) {
                            Path path = list2.get(i9).getPath();
                            path.computeBounds(this.f445y, false);
                            this.f446z.set(matrix);
                            List<b.c.a.w.b.d> list4 = list2;
                            this.f446z.preTranslate(0.0f, (-cVarE.g) * b.c.a.b0.g.c());
                            this.f446z.preScale(fFloatValue3, fFloatValue3);
                            path.transform(this.f446z);
                            if (cVarE.k) {
                                s(path, this.A, canvas);
                                s(path, this.B, canvas);
                            } else {
                                s(path, this.B, canvas);
                                s(path, this.A, canvas);
                            }
                            i9++;
                            list2 = list4;
                        }
                        float fC3 = b.c.a.b0.g.c() * ((float) eVar2.c) * fFloatValue3 * fD;
                        float f3 = cVarE.e / 10.0f;
                        b.c.a.w.c.a<Float, Float> aVar10 = this.O;
                        if (aVar10 != null) {
                            fFloatValue2 = aVar10.e().floatValue();
                        } else {
                            b.c.a.w.c.a<Float, Float> aVar11 = this.N;
                            if (aVar11 != null) {
                                fFloatValue2 = aVar11.e().floatValue();
                            }
                            canvas.translate((f3 * fD) + fC3, 0.0f);
                        }
                        f3 += fFloatValue2;
                        canvas.translate((f3 * fD) + fC3, 0.0f);
                    }
                    i7++;
                    listT = list;
                    str6 = str2;
                    size = i2;
                }
                canvas.restore();
                i4 = i6 + 1;
                fC = f2;
            }
        } else {
            float fD2 = b.c.a.b0.g.d(matrix);
            j jVar = this.F;
            ?? r6 = dVar.a;
            ?? r3 = dVar.c;
            Typeface typefaceCreate = null;
            if (jVar.getCallback() == null) {
                aVar = null;
            } else {
                if (jVar.v == null) {
                    jVar.v = new b.c.a.x.a(jVar.getCallback());
                }
                aVar = jVar.v;
            }
            if (aVar != null) {
                b.c.a.y.j<String> jVar2 = aVar.a;
                jVar2.a = r6;
                jVar2.f411b = r3;
                typefaceCreate = aVar.f397b.get(jVar2);
                if (typefaceCreate == null) {
                    Typeface typefaceCreateFromAsset = aVar.c.get(r6);
                    if (typefaceCreateFromAsset == null) {
                        StringBuilder sbX = b.d.b.a.a.X("fonts/", r6);
                        sbX.append(aVar.e);
                        typefaceCreateFromAsset = Typeface.createFromAsset(aVar.d, sbX.toString());
                        aVar.c.put(r6, typefaceCreateFromAsset);
                    }
                    boolean zContains = r3.contains("Italic");
                    boolean zContains2 = r3.contains("Bold");
                    int i10 = (zContains && zContains2) ? 3 : zContains ? 2 : zContains2 ? 1 : 0;
                    typefaceCreate = typefaceCreateFromAsset.getStyle() == i10 ? typefaceCreateFromAsset : Typeface.create(typefaceCreateFromAsset, i10);
                    aVar.f397b.put(aVar.a, typefaceCreate);
                }
            }
            if (typefaceCreate != null) {
                String str8 = cVarE.a;
                Objects.requireNonNull(this.F);
                this.A.setTypeface(typefaceCreate);
                b.c.a.w.c.a<Float, Float> aVar12 = this.P;
                this.A.setTextSize(b.c.a.b0.g.c() * (aVar12 != null ? aVar12.e().floatValue() : cVarE.c));
                this.B.setTypeface(this.A.getTypeface());
                this.B.setTextSize(this.A.getTextSize());
                float fC4 = b.c.a.b0.g.c() * cVarE.f;
                List<String> listT2 = t(str8);
                int size3 = listT2.size();
                for (int i11 = 0; i11 < size3; i11++) {
                    String str9 = listT2.get(i11);
                    q(cVarE.d, canvas, this.B.measureText(str9));
                    canvas.translate(0.0f, (i11 * fC4) - (((size3 - 1) * fC4) / 2.0f));
                    int length = 0;
                    while (length < str9.length()) {
                        int iCodePointAt = str9.codePointAt(length);
                        int iCharCount = Character.charCount(iCodePointAt) + length;
                        while (iCharCount < str9.length()) {
                            int iCodePointAt2 = str9.codePointAt(iCharCount);
                            if (!(Character.getType(iCodePointAt2) == 16 || Character.getType(iCodePointAt2) == 27 || Character.getType(iCodePointAt2) == 6 || Character.getType(iCodePointAt2) == 28 || Character.getType(iCodePointAt2) == 19)) {
                                break;
                            }
                            iCharCount += Character.charCount(iCodePointAt2);
                            iCodePointAt = (iCodePointAt * 31) + iCodePointAt2;
                        }
                        int i12 = size3;
                        float f4 = fC4;
                        long j = iCodePointAt;
                        if (this.D.containsKey(j)) {
                            str = this.D.get(j);
                        } else {
                            this.f444x.setLength(0);
                            int iCharCount2 = length;
                            while (iCharCount2 < iCharCount) {
                                int iCodePointAt3 = str9.codePointAt(iCharCount2);
                                this.f444x.appendCodePoint(iCodePointAt3);
                                iCharCount2 += Character.charCount(iCodePointAt3);
                            }
                            String string = this.f444x.toString();
                            this.D.put(j, string);
                            str = string;
                        }
                        length += str.length();
                        if (cVarE.k) {
                            r(str, this.A, canvas);
                            r(str, this.B, canvas);
                        } else {
                            r(str, this.B, canvas);
                            r(str, this.A, canvas);
                        }
                        float fMeasureText = this.A.measureText(str, 0, 1);
                        float f5 = cVarE.e / 10.0f;
                        b.c.a.w.c.a<Float, Float> aVar13 = this.O;
                        if (aVar13 != null) {
                            fFloatValue = aVar13.e().floatValue();
                        } else {
                            b.c.a.w.c.a<Float, Float> aVar14 = this.N;
                            if (aVar14 != null) {
                                fFloatValue = aVar14.e().floatValue();
                            } else {
                                canvas.translate((f5 * fD2) + fMeasureText, 0.0f);
                                fC4 = f4;
                                size3 = i12;
                            }
                        }
                        f5 += fFloatValue;
                        canvas.translate((f5 * fD2) + fMeasureText, 0.0f);
                        fC4 = f4;
                        size3 = i12;
                    }
                    canvas.setMatrix(matrix);
                }
            }
        }
        canvas.restore();
    }

    public final void q(int i, Canvas canvas, float f) {
        int iH = b.c.a.y.b.h(i);
        if (iH == 1) {
            canvas.translate(-f, 0.0f);
        } else {
            if (iH != 2) {
                return;
            }
            canvas.translate((-f) / 2.0f, 0.0f);
        }
    }

    public final void r(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    public final void s(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    public final List<String> t(String str) {
        return Arrays.asList(str.replaceAll("\r\n", "\r").replaceAll("\n", "\r").split("\r"));
    }
}
