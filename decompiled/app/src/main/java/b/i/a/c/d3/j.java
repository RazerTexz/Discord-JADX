package b.i.a.c.d3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import b.i.a.c.b3.b;
import b.i.a.c.f3.e0;
import com.google.android.exoplayer2.ui.SubtitleView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* compiled from: CanvasSubtitleOutput.java */
/* loaded from: classes3.dex */
public final class j extends View implements SubtitleView.a {
    public final List<n> j;
    public List<b.i.a.c.b3.b> k;
    public int l;
    public float m;
    public k n;
    public float o;

    public j(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = new ArrayList();
        this.k = Collections.emptyList();
        this.l = 0;
        this.m = 0.0533f;
        this.n = k.a;
        this.o = 0.08f;
    }

    @Override // com.google.android.exoplayer2.ui.SubtitleView.a
    public void a(List<b.i.a.c.b3.b> list, k kVar, float f, int i, float f2) {
        this.k = list;
        this.n = kVar;
        this.m = f;
        this.l = i;
        this.o = f2;
        while (this.j.size() < list.size()) {
            this.j.add(new n(getContext()));
        }
        invalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B:172:0x03e3  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x03e6  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x04a7  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x04a9  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void dispatchDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        boolean z2;
        int i4;
        int i5;
        int i6;
        int i7;
        float f;
        int i8;
        float f2;
        int i9;
        float f3;
        Canvas canvas2;
        boolean z3;
        int i10;
        int iMax;
        int iMin;
        int iRound;
        int i11;
        int i12;
        int i13;
        j jVar = this;
        Canvas canvas3 = canvas;
        List<b.i.a.c.b3.b> list = jVar.k;
        if (list.isEmpty()) {
            return;
        }
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int paddingBottom = height - getPaddingBottom();
        if (paddingBottom <= paddingTop || width <= paddingLeft) {
            return;
        }
        int i14 = paddingBottom - paddingTop;
        float fU1 = b.c.a.a0.d.U1(jVar.l, jVar.m, height, i14);
        if (fU1 <= 0.0f) {
            return;
        }
        int size = list.size();
        int i15 = 0;
        while (i15 < size) {
            b.i.a.c.b3.b bVarA = list.get(i15);
            if (bVarA.A != Integer.MIN_VALUE) {
                b.C0093b c0093bA = bVarA.a();
                c0093bA.h = -3.4028235E38f;
                c0093bA.i = Integer.MIN_VALUE;
                c0093bA.c = null;
                if (bVarA.q == 0) {
                    c0093bA.e = 1.0f - bVarA.p;
                    c0093bA.f = 0;
                } else {
                    c0093bA.e = (-bVarA.p) - 1.0f;
                    c0093bA.f = 1;
                }
                int i16 = bVarA.r;
                if (i16 == 0) {
                    c0093bA.g = 2;
                } else if (i16 == 2) {
                    c0093bA.g = 0;
                }
                bVarA = c0093bA.a();
            }
            float fU12 = b.c.a.a0.d.U1(bVarA.f840y, bVarA.f841z, height, i14);
            n nVar = jVar.j.get(i15);
            k kVar = jVar.n;
            List<b.i.a.c.b3.b> list2 = list;
            float f4 = jVar.o;
            Objects.requireNonNull(nVar);
            boolean z4 = bVarA.o == null;
            int i17 = height;
            if (!z4) {
                i = i14;
                i2 = ViewCompat.MEASURED_STATE_MASK;
            } else if (TextUtils.isEmpty(bVarA.l)) {
                canvas2 = canvas3;
                i4 = paddingLeft;
                i5 = paddingTop;
                i6 = width;
                i7 = paddingBottom;
                i = i14;
                f = fU1;
                i3 = size;
                i8 = i15;
                i15 = i8 + 1;
                canvas3 = canvas2;
                list = list2;
                i14 = i;
                height = i17;
                size = i3;
                paddingLeft = i4;
                paddingTop = i5;
                width = i6;
                paddingBottom = i7;
                fU1 = f;
                jVar = this;
            } else {
                i2 = bVarA.w ? bVarA.f839x : kVar.d;
                i = i14;
            }
            CharSequence charSequence = nVar.i;
            i3 = size;
            CharSequence charSequence2 = bVarA.l;
            if ((charSequence == charSequence2 || (charSequence != null && charSequence.equals(charSequence2))) && e0.a(nVar.j, bVarA.m) && nVar.k == bVarA.o && nVar.l == bVarA.p && nVar.m == bVarA.q && e0.a(Integer.valueOf(nVar.n), Integer.valueOf(bVarA.r)) && nVar.o == bVarA.f838s && e0.a(Integer.valueOf(nVar.p), Integer.valueOf(bVarA.t)) && nVar.q == bVarA.u && nVar.r == bVarA.v && nVar.f919s == kVar.f914b && nVar.t == kVar.c && nVar.u == i2 && nVar.w == kVar.e && nVar.v == kVar.f && e0.a(nVar.f.getTypeface(), kVar.g) && nVar.f920x == fU1 && nVar.f921y == fU12 && nVar.f922z == f4 && nVar.A == paddingLeft && nVar.B == paddingTop && nVar.C == width && nVar.D == paddingBottom) {
                nVar.a(canvas3, z4);
                canvas2 = canvas3;
                i4 = paddingLeft;
                i5 = paddingTop;
                i6 = width;
                i7 = paddingBottom;
                f = fU1;
                i8 = i15;
                i15 = i8 + 1;
                canvas3 = canvas2;
                list = list2;
                i14 = i;
                height = i17;
                size = i3;
                paddingLeft = i4;
                paddingTop = i5;
                width = i6;
                paddingBottom = i7;
                fU1 = f;
                jVar = this;
            } else {
                nVar.i = bVarA.l;
                nVar.j = bVarA.m;
                nVar.k = bVarA.o;
                nVar.l = bVarA.p;
                nVar.m = bVarA.q;
                nVar.n = bVarA.r;
                nVar.o = bVarA.f838s;
                nVar.p = bVarA.t;
                nVar.q = bVarA.u;
                nVar.r = bVarA.v;
                nVar.f919s = kVar.f914b;
                nVar.t = kVar.c;
                nVar.u = i2;
                nVar.w = kVar.e;
                nVar.v = kVar.f;
                nVar.f.setTypeface(kVar.g);
                nVar.f920x = fU1;
                nVar.f921y = fU12;
                nVar.f922z = f4;
                nVar.A = paddingLeft;
                nVar.B = paddingTop;
                nVar.C = width;
                nVar.D = paddingBottom;
                if (z4) {
                    Objects.requireNonNull(nVar.i);
                    CharSequence charSequence3 = nVar.i;
                    SpannableStringBuilder spannableStringBuilder = charSequence3 instanceof SpannableStringBuilder ? (SpannableStringBuilder) charSequence3 : new SpannableStringBuilder(nVar.i);
                    int i18 = nVar.C - nVar.A;
                    int i19 = nVar.D - nVar.B;
                    nVar.f.setTextSize(nVar.f920x);
                    int i20 = (int) ((nVar.f920x * 0.125f) + 0.5f);
                    int i21 = i20 * 2;
                    int i22 = i18 - i21;
                    float f5 = nVar.q;
                    if (f5 != -3.4028235E38f) {
                        i22 = (int) (i22 * f5);
                    }
                    if (i22 <= 0) {
                        Log.w("SubtitlePainter", "Skipped drawing subtitle cue (insufficient space)");
                        i4 = paddingLeft;
                        i5 = paddingTop;
                        i6 = width;
                        i7 = paddingBottom;
                        f = fU1;
                        i8 = i15;
                        Canvas canvas4 = canvas3;
                        z3 = z4;
                        canvas2 = canvas4;
                    } else {
                        i4 = paddingLeft;
                        i5 = paddingTop;
                        if (nVar.f921y > 0.0f) {
                            i6 = width;
                            i7 = paddingBottom;
                            i10 = 0;
                            spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) nVar.f921y), 0, spannableStringBuilder.length(), ItemTouchHelper.ACTION_MODE_DRAG_MASK);
                        } else {
                            i6 = width;
                            i7 = paddingBottom;
                            i10 = 0;
                        }
                        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
                        if (nVar.w == 1) {
                            ForegroundColorSpan[] foregroundColorSpanArr = (ForegroundColorSpan[]) spannableStringBuilder2.getSpans(i10, spannableStringBuilder2.length(), ForegroundColorSpan.class);
                            int i23 = 0;
                            for (int length = foregroundColorSpanArr.length; i23 < length; length = length) {
                                spannableStringBuilder2.removeSpan(foregroundColorSpanArr[i23]);
                                i23++;
                            }
                        }
                        if (Color.alpha(nVar.t) > 0) {
                            int i24 = nVar.w;
                            if (i24 == 0 || i24 == 2) {
                                f = fU1;
                                spannableStringBuilder.setSpan(new BackgroundColorSpan(nVar.t), 0, spannableStringBuilder.length(), ItemTouchHelper.ACTION_MODE_DRAG_MASK);
                            } else {
                                f = fU1;
                                spannableStringBuilder2.setSpan(new BackgroundColorSpan(nVar.t), 0, spannableStringBuilder2.length(), ItemTouchHelper.ACTION_MODE_DRAG_MASK);
                            }
                        } else {
                            f = fU1;
                        }
                        Layout.Alignment alignment = nVar.j;
                        if (alignment == null) {
                            alignment = Layout.Alignment.ALIGN_CENTER;
                        }
                        i8 = i15;
                        StaticLayout staticLayout = new StaticLayout(spannableStringBuilder, nVar.f, i22, alignment, nVar.d, nVar.e, true);
                        nVar.E = staticLayout;
                        int height2 = staticLayout.getHeight();
                        int lineCount = nVar.E.getLineCount();
                        int i25 = 0;
                        int iMax2 = 0;
                        while (i25 < lineCount) {
                            iMax2 = Math.max((int) Math.ceil(nVar.E.getLineWidth(i25)), iMax2);
                            i25++;
                            lineCount = lineCount;
                            z4 = z4;
                        }
                        z2 = z4;
                        if (nVar.q == -3.4028235E38f || iMax2 >= i22) {
                            i22 = iMax2;
                        }
                        int i26 = i22 + i21;
                        float f6 = nVar.o;
                        if (f6 != -3.4028235E38f) {
                            int iRound2 = Math.round(i18 * f6);
                            int i27 = nVar.A;
                            int i28 = iRound2 + i27;
                            int i29 = nVar.p;
                            if (i29 == 1) {
                                i28 = ((i28 * 2) - i26) / 2;
                            } else if (i29 == 2) {
                                i28 -= i26;
                            }
                            iMax = Math.max(i28, i27);
                            iMin = Math.min(i26 + iMax, nVar.C);
                        } else {
                            iMax = nVar.A + ((i18 - i26) / 2);
                            iMin = iMax + i26;
                        }
                        int i30 = iMin - iMax;
                        if (i30 <= 0) {
                            Log.w("SubtitlePainter", "Skipped drawing subtitle cue (invalid horizontal positioning)");
                            canvas2 = canvas;
                            z3 = z2;
                        } else {
                            float f7 = nVar.l;
                            if (f7 != -3.4028235E38f) {
                                if (nVar.m == 0) {
                                    iRound = Math.round(i19 * f7) + nVar.B;
                                    int i31 = nVar.n;
                                    if (i31 == 2) {
                                        iRound -= height2;
                                        i12 = iRound + height2;
                                        i13 = nVar.D;
                                        if (i12 <= i13) {
                                            iRound = i13 - height2;
                                        } else {
                                            i11 = nVar.B;
                                            if (iRound >= i11) {
                                            }
                                            Layout.Alignment alignment2 = alignment;
                                            nVar.E = new StaticLayout(spannableStringBuilder, nVar.f, i30, alignment2, nVar.d, nVar.e, true);
                                            nVar.F = new StaticLayout(spannableStringBuilder2, nVar.f, i30, alignment2, nVar.d, nVar.e, true);
                                            nVar.G = iMax;
                                            nVar.H = i11;
                                            nVar.I = i20;
                                        }
                                    } else {
                                        if (i31 == 1) {
                                            iRound = ((iRound * 2) - height2) / 2;
                                        }
                                        i12 = iRound + height2;
                                        i13 = nVar.D;
                                        if (i12 <= i13) {
                                        }
                                    }
                                } else {
                                    int lineBottom = nVar.E.getLineBottom(0) - nVar.E.getLineTop(0);
                                    float f8 = nVar.l;
                                    if (f8 >= 0.0f) {
                                        iRound = Math.round(f8 * lineBottom) + nVar.B;
                                        i12 = iRound + height2;
                                        i13 = nVar.D;
                                        if (i12 <= i13) {
                                        }
                                    } else {
                                        iRound = Math.round((f8 + 1.0f) * lineBottom) + nVar.D;
                                        iRound -= height2;
                                        i12 = iRound + height2;
                                        i13 = nVar.D;
                                        if (i12 <= i13) {
                                        }
                                    }
                                }
                                i15 = i8 + 1;
                                canvas3 = canvas2;
                                list = list2;
                                i14 = i;
                                height = i17;
                                size = i3;
                                paddingLeft = i4;
                                paddingTop = i5;
                                width = i6;
                                paddingBottom = i7;
                                fU1 = f;
                                jVar = this;
                            } else {
                                iRound = (nVar.D - height2) - ((int) (i19 * nVar.f922z));
                            }
                            i11 = iRound;
                            Layout.Alignment alignment22 = alignment;
                            nVar.E = new StaticLayout(spannableStringBuilder, nVar.f, i30, alignment22, nVar.d, nVar.e, true);
                            nVar.F = new StaticLayout(spannableStringBuilder2, nVar.f, i30, alignment22, nVar.d, nVar.e, true);
                            nVar.G = iMax;
                            nVar.H = i11;
                            nVar.I = i20;
                        }
                    }
                    nVar.a(canvas2, z3);
                    i15 = i8 + 1;
                    canvas3 = canvas2;
                    list = list2;
                    i14 = i;
                    height = i17;
                    size = i3;
                    paddingLeft = i4;
                    paddingTop = i5;
                    width = i6;
                    paddingBottom = i7;
                    fU1 = f;
                    jVar = this;
                } else {
                    z2 = z4;
                    i4 = paddingLeft;
                    i5 = paddingTop;
                    i6 = width;
                    i7 = paddingBottom;
                    f = fU1;
                    i8 = i15;
                    Objects.requireNonNull(nVar.k);
                    Bitmap bitmap = nVar.k;
                    int i32 = nVar.C;
                    int i33 = nVar.A;
                    int i34 = nVar.D;
                    int i35 = nVar.B;
                    float f9 = i32 - i33;
                    float f10 = (nVar.o * f9) + i33;
                    float f11 = i34 - i35;
                    float f12 = (nVar.l * f11) + i35;
                    int iRound3 = Math.round(f9 * nVar.q);
                    float f13 = nVar.r;
                    int iRound4 = f13 != -3.4028235E38f ? Math.round(f11 * f13) : Math.round((bitmap.getHeight() / bitmap.getWidth()) * iRound3);
                    int i36 = nVar.p;
                    if (i36 == 2) {
                        f2 = iRound3;
                    } else {
                        if (i36 == 1) {
                            f2 = iRound3 / 2;
                        }
                        int iRound5 = Math.round(f10);
                        i9 = nVar.n;
                        if (i9 != 2) {
                            f3 = iRound4;
                        } else {
                            if (i9 == 1) {
                                f3 = iRound4 / 2;
                            }
                            int iRound6 = Math.round(f12);
                            nVar.J = new Rect(iRound5, iRound6, iRound3 + iRound5, iRound4 + iRound6);
                        }
                        f12 -= f3;
                        int iRound62 = Math.round(f12);
                        nVar.J = new Rect(iRound5, iRound62, iRound3 + iRound5, iRound4 + iRound62);
                    }
                    f10 -= f2;
                    int iRound52 = Math.round(f10);
                    i9 = nVar.n;
                    if (i9 != 2) {
                    }
                    f12 -= f3;
                    int iRound622 = Math.round(f12);
                    nVar.J = new Rect(iRound52, iRound622, iRound3 + iRound52, iRound4 + iRound622);
                }
                canvas2 = canvas;
                z3 = z2;
                nVar.a(canvas2, z3);
                i15 = i8 + 1;
                canvas3 = canvas2;
                list = list2;
                i14 = i;
                height = i17;
                size = i3;
                paddingLeft = i4;
                paddingTop = i5;
                width = i6;
                paddingBottom = i7;
                fU1 = f;
                jVar = this;
            }
        }
    }
}
