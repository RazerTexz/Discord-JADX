package p000;

import android.text.TextPaint;
import android.text.style.BackgroundColorSpan;
import androidx.annotation.ColorInt;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: SpoilerSpan.kt */
/* loaded from: classes2.dex */
public final class SpoilerSpan extends BackgroundColorSpan {

    /* renamed from: j */
    public int f0j;

    /* renamed from: k */
    public int f1k;

    /* renamed from: l */
    public boolean f2l;

    public SpoilerSpan() {
        super(0);
        this.f0j = 0;
        this.f1k = 0;
        this.f2l = false;
    }

    @Override // android.text.style.BackgroundColorSpan
    public int getBackgroundColor() {
        return this.f2l ? this.f1k : this.f0j;
    }

    @Override // android.text.style.BackgroundColorSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        Intrinsics3.checkNotNullParameter(textPaint, "textPaint");
        if (this.f2l) {
            textPaint.bgColor = this.f1k;
            return;
        }
        int i = this.f0j;
        textPaint.bgColor = i;
        textPaint.setColor(i);
    }

    public SpoilerSpan(@ColorInt int i, @ColorInt int i2, boolean z2) {
        super(i);
        this.f0j = i;
        this.f1k = i2;
        this.f2l = z2;
    }
}
