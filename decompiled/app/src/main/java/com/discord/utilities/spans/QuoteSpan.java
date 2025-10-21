package com.discord.utilities.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.annotation.Px;
import androidx.core.app.NotificationCompat;
import d0.z.d.Intrinsics3;

/* compiled from: QuoteSpan.kt */
/* loaded from: classes2.dex */
public final class QuoteSpan implements LeadingMarginSpan {
    private final int gapWidth;
    private final float radius;
    private final RectF rect = new RectF();
    private final int stripeColor;
    private final int stripeWidth;

    public QuoteSpan(@ColorInt int i, @IntRange(from = 0) @Px int i2, @IntRange(from = 0) @Px int i3) {
        this.stripeColor = i;
        this.stripeWidth = i2;
        this.gapWidth = i3;
        this.radius = i2;
    }

    private final void draw(Canvas c, Paint p) {
        Paint.Style style = p.getStyle();
        int color = p.getColor();
        p.setStyle(Paint.Style.FILL);
        p.setColor(this.stripeColor);
        RectF rectF = this.rect;
        float f = this.radius;
        c.drawRoundRect(rectF, f, f, p);
        p.setStyle(style);
        p.setColor(color);
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas c, Paint p, int x2, int dir, int top, int baseline, int bottom, CharSequence text, int start, int end, boolean first, Layout layout) {
        Intrinsics3.checkNotNullParameter(c, "c");
        Intrinsics3.checkNotNullParameter(p, "p");
        Intrinsics3.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        Intrinsics3.checkNotNullParameter(layout, "layout");
        if (text instanceof Spanned) {
            Spanned spanned = (Spanned) text;
            if (spanned.getSpanStart(this) == start) {
                RectF rectF = this.rect;
                rectF.left = x2;
                rectF.right = (dir * this.stripeWidth) + x2;
                rectF.top = top;
            }
            int spanEnd = spanned.getSpanEnd(this);
            if (spanEnd == end || (spanEnd - 1 == end && text.charAt(end) == '\n')) {
                this.rect.bottom = bottom;
                draw(c, p);
            }
        }
    }

    public final int getGapWidth() {
        return this.gapWidth;
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean first) {
        return this.stripeWidth + this.gapWidth;
    }

    public final int getStripeColor() {
        return this.stripeColor;
    }

    public final int getStripeWidth() {
        return this.stripeWidth;
    }
}
