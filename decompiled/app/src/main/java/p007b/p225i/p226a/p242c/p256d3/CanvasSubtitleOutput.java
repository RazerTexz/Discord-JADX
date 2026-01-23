package p007b.p225i.p226a.p242c.p256d3;

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
import com.google.android.exoplayer2.p505ui.SubtitleView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.p245b3.Cue;
import p007b.p225i.p226a.p242c.p259f3.Util2;

/* JADX INFO: renamed from: b.i.a.c.d3.j, reason: use source file name */
/* JADX INFO: compiled from: CanvasSubtitleOutput.java */
/* JADX INFO: loaded from: classes3.dex */
public final class CanvasSubtitleOutput extends View implements SubtitleView.InterfaceC10760a {

    /* JADX INFO: renamed from: j */
    public final List<SubtitlePainter> f6343j;

    /* JADX INFO: renamed from: k */
    public List<Cue> f6344k;

    /* JADX INFO: renamed from: l */
    public int f6345l;

    /* JADX INFO: renamed from: m */
    public float f6346m;

    /* JADX INFO: renamed from: n */
    public CaptionStyleCompat f6347n;

    /* JADX INFO: renamed from: o */
    public float f6348o;

    public CanvasSubtitleOutput(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6343j = new ArrayList();
        this.f6344k = Collections.emptyList();
        this.f6345l = 0;
        this.f6346m = 0.0533f;
        this.f6347n = CaptionStyleCompat.f6349a;
        this.f6348o = 0.08f;
    }

    @Override // com.google.android.exoplayer2.p505ui.SubtitleView.InterfaceC10760a
    /* JADX INFO: renamed from: a */
    public void mo2758a(List<Cue> list, CaptionStyleCompat captionStyleCompat, float f, int i, float f2) {
        this.f6344k = list;
        this.f6347n = captionStyleCompat;
        this.f6346m = f;
        this.f6345l = i;
        this.f6348o = f2;
        while (this.f6343j.size() < list.size()) {
            this.f6343j.add(new SubtitlePainter(getContext()));
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
        CanvasSubtitleOutput canvasSubtitleOutput = this;
        Canvas canvas3 = canvas;
        List<Cue> list = canvasSubtitleOutput.f6344k;
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
        float fM479U1 = AnimatableValueParser.m479U1(canvasSubtitleOutput.f6345l, canvasSubtitleOutput.f6346m, height, i14);
        if (fM479U1 <= 0.0f) {
            return;
        }
        int size = list.size();
        int i15 = 0;
        while (i15 < size) {
            Cue cueM2606a = list.get(i15);
            if (cueM2606a.f5756A != Integer.MIN_VALUE) {
                Cue.b bVarM2605a = cueM2606a.m2605a();
                bVarM2605a.f5780h = -3.4028235E38f;
                bVarM2605a.f5781i = Integer.MIN_VALUE;
                bVarM2605a.f5775c = null;
                if (cueM2606a.f5763q == 0) {
                    bVarM2605a.f5777e = 1.0f - cueM2606a.f5762p;
                    bVarM2605a.f5778f = 0;
                } else {
                    bVarM2605a.f5777e = (-cueM2606a.f5762p) - 1.0f;
                    bVarM2605a.f5778f = 1;
                }
                int i16 = cueM2606a.f5764r;
                if (i16 == 0) {
                    bVarM2605a.f5779g = 2;
                } else if (i16 == 2) {
                    bVarM2605a.f5779g = 0;
                }
                cueM2606a = bVarM2605a.m2606a();
            }
            float fM479U12 = AnimatableValueParser.m479U1(cueM2606a.f5771y, cueM2606a.f5772z, height, i14);
            SubtitlePainter subtitlePainter = canvasSubtitleOutput.f6343j.get(i15);
            CaptionStyleCompat captionStyleCompat = canvasSubtitleOutput.f6347n;
            List<Cue> list2 = list;
            float f4 = canvasSubtitleOutput.f6348o;
            Objects.requireNonNull(subtitlePainter);
            boolean z4 = cueM2606a.f5761o == null;
            int i17 = height;
            if (!z4) {
                i = i14;
                i2 = ViewCompat.MEASURED_STATE_MASK;
            } else if (TextUtils.isEmpty(cueM2606a.f5758l)) {
                canvas2 = canvas3;
                i4 = paddingLeft;
                i5 = paddingTop;
                i6 = width;
                i7 = paddingBottom;
                i = i14;
                f = fM479U1;
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
                fM479U1 = f;
                canvasSubtitleOutput = this;
            } else {
                i2 = cueM2606a.f5769w ? cueM2606a.f5770x : captionStyleCompat.f6352d;
                i = i14;
            }
            CharSequence charSequence = subtitlePainter.f6384i;
            i3 = size;
            CharSequence charSequence2 = cueM2606a.f5758l;
            if ((charSequence == charSequence2 || (charSequence != null && charSequence.equals(charSequence2))) && Util2.m2993a(subtitlePainter.f6385j, cueM2606a.f5759m) && subtitlePainter.f6386k == cueM2606a.f5761o && subtitlePainter.f6387l == cueM2606a.f5762p && subtitlePainter.f6388m == cueM2606a.f5763q && Util2.m2993a(Integer.valueOf(subtitlePainter.f6389n), Integer.valueOf(cueM2606a.f5764r)) && subtitlePainter.f6390o == cueM2606a.f5765s && Util2.m2993a(Integer.valueOf(subtitlePainter.f6391p), Integer.valueOf(cueM2606a.f5766t)) && subtitlePainter.f6392q == cueM2606a.f5767u && subtitlePainter.f6393r == cueM2606a.f5768v && subtitlePainter.f6394s == captionStyleCompat.f6350b && subtitlePainter.f6395t == captionStyleCompat.f6351c && subtitlePainter.f6396u == i2 && subtitlePainter.f6398w == captionStyleCompat.f6353e && subtitlePainter.f6397v == captionStyleCompat.f6354f && Util2.m2993a(subtitlePainter.f6381f.getTypeface(), captionStyleCompat.f6355g) && subtitlePainter.f6399x == fM479U1 && subtitlePainter.f6400y == fM479U12 && subtitlePainter.f6401z == f4 && subtitlePainter.f6366A == paddingLeft && subtitlePainter.f6367B == paddingTop && subtitlePainter.f6368C == width && subtitlePainter.f6369D == paddingBottom) {
                subtitlePainter.m2760a(canvas3, z4);
                canvas2 = canvas3;
                i4 = paddingLeft;
                i5 = paddingTop;
                i6 = width;
                i7 = paddingBottom;
                f = fM479U1;
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
                fM479U1 = f;
                canvasSubtitleOutput = this;
            } else {
                subtitlePainter.f6384i = cueM2606a.f5758l;
                subtitlePainter.f6385j = cueM2606a.f5759m;
                subtitlePainter.f6386k = cueM2606a.f5761o;
                subtitlePainter.f6387l = cueM2606a.f5762p;
                subtitlePainter.f6388m = cueM2606a.f5763q;
                subtitlePainter.f6389n = cueM2606a.f5764r;
                subtitlePainter.f6390o = cueM2606a.f5765s;
                subtitlePainter.f6391p = cueM2606a.f5766t;
                subtitlePainter.f6392q = cueM2606a.f5767u;
                subtitlePainter.f6393r = cueM2606a.f5768v;
                subtitlePainter.f6394s = captionStyleCompat.f6350b;
                subtitlePainter.f6395t = captionStyleCompat.f6351c;
                subtitlePainter.f6396u = i2;
                subtitlePainter.f6398w = captionStyleCompat.f6353e;
                subtitlePainter.f6397v = captionStyleCompat.f6354f;
                subtitlePainter.f6381f.setTypeface(captionStyleCompat.f6355g);
                subtitlePainter.f6399x = fM479U1;
                subtitlePainter.f6400y = fM479U12;
                subtitlePainter.f6401z = f4;
                subtitlePainter.f6366A = paddingLeft;
                subtitlePainter.f6367B = paddingTop;
                subtitlePainter.f6368C = width;
                subtitlePainter.f6369D = paddingBottom;
                if (z4) {
                    Objects.requireNonNull(subtitlePainter.f6384i);
                    CharSequence charSequence3 = subtitlePainter.f6384i;
                    SpannableStringBuilder spannableStringBuilder = charSequence3 instanceof SpannableStringBuilder ? (SpannableStringBuilder) charSequence3 : new SpannableStringBuilder(subtitlePainter.f6384i);
                    int i18 = subtitlePainter.f6368C - subtitlePainter.f6366A;
                    int i19 = subtitlePainter.f6369D - subtitlePainter.f6367B;
                    subtitlePainter.f6381f.setTextSize(subtitlePainter.f6399x);
                    int i20 = (int) ((subtitlePainter.f6399x * 0.125f) + 0.5f);
                    int i21 = i20 * 2;
                    int i22 = i18 - i21;
                    float f5 = subtitlePainter.f6392q;
                    if (f5 != -3.4028235E38f) {
                        i22 = (int) (i22 * f5);
                    }
                    if (i22 <= 0) {
                        Log.w("SubtitlePainter", "Skipped drawing subtitle cue (insufficient space)");
                        i4 = paddingLeft;
                        i5 = paddingTop;
                        i6 = width;
                        i7 = paddingBottom;
                        f = fM479U1;
                        i8 = i15;
                        Canvas canvas4 = canvas3;
                        z3 = z4;
                        canvas2 = canvas4;
                    } else {
                        i4 = paddingLeft;
                        i5 = paddingTop;
                        if (subtitlePainter.f6400y > 0.0f) {
                            i6 = width;
                            i7 = paddingBottom;
                            i10 = 0;
                            spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) subtitlePainter.f6400y), 0, spannableStringBuilder.length(), ItemTouchHelper.ACTION_MODE_DRAG_MASK);
                        } else {
                            i6 = width;
                            i7 = paddingBottom;
                            i10 = 0;
                        }
                        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
                        if (subtitlePainter.f6398w == 1) {
                            ForegroundColorSpan[] foregroundColorSpanArr = (ForegroundColorSpan[]) spannableStringBuilder2.getSpans(i10, spannableStringBuilder2.length(), ForegroundColorSpan.class);
                            int i23 = 0;
                            for (int length = foregroundColorSpanArr.length; i23 < length; length = length) {
                                spannableStringBuilder2.removeSpan(foregroundColorSpanArr[i23]);
                                i23++;
                            }
                        }
                        if (Color.alpha(subtitlePainter.f6395t) > 0) {
                            int i24 = subtitlePainter.f6398w;
                            if (i24 == 0 || i24 == 2) {
                                f = fM479U1;
                                spannableStringBuilder.setSpan(new BackgroundColorSpan(subtitlePainter.f6395t), 0, spannableStringBuilder.length(), ItemTouchHelper.ACTION_MODE_DRAG_MASK);
                            } else {
                                f = fM479U1;
                                spannableStringBuilder2.setSpan(new BackgroundColorSpan(subtitlePainter.f6395t), 0, spannableStringBuilder2.length(), ItemTouchHelper.ACTION_MODE_DRAG_MASK);
                            }
                        } else {
                            f = fM479U1;
                        }
                        Layout.Alignment alignment = subtitlePainter.f6385j;
                        if (alignment == null) {
                            alignment = Layout.Alignment.ALIGN_CENTER;
                        }
                        i8 = i15;
                        StaticLayout staticLayout = new StaticLayout(spannableStringBuilder, subtitlePainter.f6381f, i22, alignment, subtitlePainter.f6379d, subtitlePainter.f6380e, true);
                        subtitlePainter.f6370E = staticLayout;
                        int height2 = staticLayout.getHeight();
                        int lineCount = subtitlePainter.f6370E.getLineCount();
                        int i25 = 0;
                        int iMax2 = 0;
                        while (i25 < lineCount) {
                            iMax2 = Math.max((int) Math.ceil(subtitlePainter.f6370E.getLineWidth(i25)), iMax2);
                            i25++;
                            lineCount = lineCount;
                            z4 = z4;
                        }
                        z2 = z4;
                        if (subtitlePainter.f6392q == -3.4028235E38f || iMax2 >= i22) {
                            i22 = iMax2;
                        }
                        int i26 = i22 + i21;
                        float f6 = subtitlePainter.f6390o;
                        if (f6 != -3.4028235E38f) {
                            int iRound2 = Math.round(i18 * f6);
                            int i27 = subtitlePainter.f6366A;
                            int i28 = iRound2 + i27;
                            int i29 = subtitlePainter.f6391p;
                            if (i29 == 1) {
                                i28 = ((i28 * 2) - i26) / 2;
                            } else if (i29 == 2) {
                                i28 -= i26;
                            }
                            iMax = Math.max(i28, i27);
                            iMin = Math.min(i26 + iMax, subtitlePainter.f6368C);
                        } else {
                            iMax = subtitlePainter.f6366A + ((i18 - i26) / 2);
                            iMin = iMax + i26;
                        }
                        int i30 = iMin - iMax;
                        if (i30 <= 0) {
                            Log.w("SubtitlePainter", "Skipped drawing subtitle cue (invalid horizontal positioning)");
                            canvas2 = canvas;
                            z3 = z2;
                        } else {
                            float f7 = subtitlePainter.f6387l;
                            if (f7 != -3.4028235E38f) {
                                if (subtitlePainter.f6388m == 0) {
                                    iRound = Math.round(i19 * f7) + subtitlePainter.f6367B;
                                    int i31 = subtitlePainter.f6389n;
                                    if (i31 == 2) {
                                        iRound -= height2;
                                        i12 = iRound + height2;
                                        i13 = subtitlePainter.f6369D;
                                        if (i12 <= i13) {
                                            iRound = i13 - height2;
                                        } else {
                                            i11 = subtitlePainter.f6367B;
                                            if (iRound >= i11) {
                                            }
                                            Layout.Alignment alignment2 = alignment;
                                            subtitlePainter.f6370E = new StaticLayout(spannableStringBuilder, subtitlePainter.f6381f, i30, alignment2, subtitlePainter.f6379d, subtitlePainter.f6380e, true);
                                            subtitlePainter.f6371F = new StaticLayout(spannableStringBuilder2, subtitlePainter.f6381f, i30, alignment2, subtitlePainter.f6379d, subtitlePainter.f6380e, true);
                                            subtitlePainter.f6372G = iMax;
                                            subtitlePainter.f6373H = i11;
                                            subtitlePainter.f6374I = i20;
                                        }
                                    } else {
                                        if (i31 == 1) {
                                            iRound = ((iRound * 2) - height2) / 2;
                                        }
                                        i12 = iRound + height2;
                                        i13 = subtitlePainter.f6369D;
                                        if (i12 <= i13) {
                                        }
                                    }
                                } else {
                                    int lineBottom = subtitlePainter.f6370E.getLineBottom(0) - subtitlePainter.f6370E.getLineTop(0);
                                    float f8 = subtitlePainter.f6387l;
                                    if (f8 >= 0.0f) {
                                        iRound = Math.round(f8 * lineBottom) + subtitlePainter.f6367B;
                                        i12 = iRound + height2;
                                        i13 = subtitlePainter.f6369D;
                                        if (i12 <= i13) {
                                        }
                                    } else {
                                        iRound = Math.round((f8 + 1.0f) * lineBottom) + subtitlePainter.f6369D;
                                        iRound -= height2;
                                        i12 = iRound + height2;
                                        i13 = subtitlePainter.f6369D;
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
                                fM479U1 = f;
                                canvasSubtitleOutput = this;
                            } else {
                                iRound = (subtitlePainter.f6369D - height2) - ((int) (i19 * subtitlePainter.f6401z));
                            }
                            i11 = iRound;
                            Layout.Alignment alignment22 = alignment;
                            subtitlePainter.f6370E = new StaticLayout(spannableStringBuilder, subtitlePainter.f6381f, i30, alignment22, subtitlePainter.f6379d, subtitlePainter.f6380e, true);
                            subtitlePainter.f6371F = new StaticLayout(spannableStringBuilder2, subtitlePainter.f6381f, i30, alignment22, subtitlePainter.f6379d, subtitlePainter.f6380e, true);
                            subtitlePainter.f6372G = iMax;
                            subtitlePainter.f6373H = i11;
                            subtitlePainter.f6374I = i20;
                        }
                    }
                    subtitlePainter.m2760a(canvas2, z3);
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
                    fM479U1 = f;
                    canvasSubtitleOutput = this;
                } else {
                    z2 = z4;
                    i4 = paddingLeft;
                    i5 = paddingTop;
                    i6 = width;
                    i7 = paddingBottom;
                    f = fM479U1;
                    i8 = i15;
                    Objects.requireNonNull(subtitlePainter.f6386k);
                    Bitmap bitmap = subtitlePainter.f6386k;
                    int i32 = subtitlePainter.f6368C;
                    int i33 = subtitlePainter.f6366A;
                    int i34 = subtitlePainter.f6369D;
                    int i35 = subtitlePainter.f6367B;
                    float f9 = i32 - i33;
                    float f10 = (subtitlePainter.f6390o * f9) + i33;
                    float f11 = i34 - i35;
                    float f12 = (subtitlePainter.f6387l * f11) + i35;
                    int iRound3 = Math.round(f9 * subtitlePainter.f6392q);
                    float f13 = subtitlePainter.f6393r;
                    int iRound4 = f13 != -3.4028235E38f ? Math.round(f11 * f13) : Math.round((bitmap.getHeight() / bitmap.getWidth()) * iRound3);
                    int i36 = subtitlePainter.f6391p;
                    if (i36 == 2) {
                        f2 = iRound3;
                    } else {
                        if (i36 == 1) {
                            f2 = iRound3 / 2;
                        }
                        int iRound5 = Math.round(f10);
                        i9 = subtitlePainter.f6389n;
                        if (i9 != 2) {
                            f3 = iRound4;
                        } else {
                            if (i9 == 1) {
                                f3 = iRound4 / 2;
                            }
                            int iRound6 = Math.round(f12);
                            subtitlePainter.f6375J = new Rect(iRound5, iRound6, iRound3 + iRound5, iRound4 + iRound6);
                        }
                        f12 -= f3;
                        int iRound62 = Math.round(f12);
                        subtitlePainter.f6375J = new Rect(iRound5, iRound62, iRound3 + iRound5, iRound4 + iRound62);
                    }
                    f10 -= f2;
                    int iRound52 = Math.round(f10);
                    i9 = subtitlePainter.f6389n;
                    if (i9 != 2) {
                    }
                    f12 -= f3;
                    int iRound622 = Math.round(f12);
                    subtitlePainter.f6375J = new Rect(iRound52, iRound622, iRound3 + iRound52, iRound4 + iRound622);
                }
                canvas2 = canvas;
                z3 = z2;
                subtitlePainter.m2760a(canvas2, z3);
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
                fM479U1 = f;
                canvasSubtitleOutput = this;
            }
        }
    }
}
