package com.discord.utilities.textprocessing;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;
import androidx.core.app.NotificationCompat;
import com.discord.utilities.string.StringUtils2;
import d0.a0.MathJVM;
import d0.g0.CharJVM;
import d0.g0.StringsJVM;
import d0.g0._Strings;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SimpleRoundedBackgroundSpan.kt */
/* loaded from: classes2.dex */
public class SimpleRoundedBackgroundSpan extends ReplacementSpan {
    private final int backgroundColor;
    private final float cornerRadius;
    private final int edgeHorizontalMargin;
    private final int edgeHorizontalPadding;
    private final int endIndex;
    private final boolean isTrimEnabled;
    private final int startIndex;
    private final Integer textColor;
    private final int topOffset;
    private final Function1<String, String> transformSpannedText;

    public /* synthetic */ SimpleRoundedBackgroundSpan(int i, int i2, int i3, int i4, int i5, float f, Integer num, boolean z2, Function1 function1, int i6, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, i4, i5, f, (i7 & 64) != 0 ? null : num, (i7 & 128) != 0 ? true : z2, (i7 & 256) != 0 ? null : function1, (i7 & 512) != 0 ? 0 : i6);
    }

    private final float[] calculateCornerRadius(int start, int end, CharSequence text) {
        float f = start == this.startIndex ? this.cornerRadius : 0.0f;
        float f2 = isAtEndEdge(end, text) ? this.cornerRadius : 0.0f;
        return new float[]{f, f, f2, f2, f2, f2, f, f};
    }

    private final boolean isAtEndEdge(int end, CharSequence text) {
        Character orNull;
        int i = this.endIndex;
        if (end != i) {
            return this.isTrimEnabled && i - end == 1 && text != null && (orNull = _Strings.getOrNull(text, end)) != null && CharJVM.isWhitespace(orNull.charValue());
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0070  */
    @Override // android.text.style.ReplacementSpan
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x2, int top, int y2, int bottom, Paint paint) {
        float f;
        int i;
        Integer num;
        Intrinsics3.checkNotNullParameter(canvas, "canvas");
        Intrinsics3.checkNotNullParameter(paint, "paint");
        String strTransformOrEmpty = StringUtils2.transformOrEmpty(text != null ? text.subSequence(start, end).toString() : null, this.transformSpannedText);
        String str = StringsJVM.isBlank(strTransformOrEmpty) ^ true ? strTransformOrEmpty : null;
        if (str != null) {
            int i2 = this.edgeHorizontalPadding;
            float fMeasureText = paint.measureText(str);
            if (start == this.startIndex) {
                x2 += this.edgeHorizontalMargin;
                i = this.edgeHorizontalPadding;
            } else {
                if (x2 != 0.0f || top == 0) {
                    f = x2;
                    RectF rectF = new RectF(x2, top, fMeasureText + x2 + i2, bottom);
                    Path path = new Path();
                    path.addRoundRect(rectF, calculateCornerRadius(start, end, text), Path.Direction.CW);
                    Paint paint2 = new Paint(paint);
                    paint2.setColor(this.backgroundColor);
                    canvas.drawPath(path, paint2);
                    num = this.textColor;
                    if (num != null) {
                        paint.setColor(num.intValue());
                    }
                    canvas.drawText(str, f, y2 + this.topOffset, paint);
                }
                i = this.edgeHorizontalPadding;
            }
            f = i + x2;
            i2 += i;
            RectF rectF2 = new RectF(x2, top, fMeasureText + x2 + i2, bottom);
            Path path2 = new Path();
            path2.addRoundRect(rectF2, calculateCornerRadius(start, end, text), Path.Direction.CW);
            Paint paint22 = new Paint(paint);
            paint22.setColor(this.backgroundColor);
            canvas.drawPath(path2, paint22);
            num = this.textColor;
            if (num != null) {
            }
            canvas.drawText(str, f, y2 + this.topOffset, paint);
        }
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        Intrinsics3.checkNotNullParameter(paint, "paint");
        int iRoundToInt = MathJVM.roundToInt(paint.measureText(StringUtils2.transformOrEmpty(text != null ? text.subSequence(start, end).toString() : null, this.transformSpannedText)));
        if (start == this.startIndex) {
            iRoundToInt += this.edgeHorizontalMargin + this.edgeHorizontalPadding;
        }
        if (isAtEndEdge(end, text)) {
            iRoundToInt += this.edgeHorizontalMargin;
        }
        return iRoundToInt + this.edgeHorizontalPadding;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SimpleRoundedBackgroundSpan(int i, int i2, int i3, int i4, int i5, float f, Integer num, boolean z2, Function1<? super String, String> function1, int i6) {
        this.startIndex = i;
        this.endIndex = i2;
        this.edgeHorizontalPadding = i3;
        this.edgeHorizontalMargin = i4;
        this.backgroundColor = i5;
        this.cornerRadius = f;
        this.textColor = num;
        this.isTrimEnabled = z2;
        this.transformSpannedText = function1;
        this.topOffset = i6;
    }
}
