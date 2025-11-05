package b.c.a;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import androidx.annotation.ColorInt;

/* compiled from: SimpleColorFilter.java */
/* loaded from: classes.dex */
public class u extends PorterDuffColorFilter {
    public u(@ColorInt int i) {
        super(i, PorterDuff.Mode.SRC_ATOP);
    }
}
