package p007b.p008a.p021f;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.RelativeLayout;
import java.util.Objects;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: b.a.f.b, reason: use source file name */
/* JADX INFO: compiled from: Chip.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Chip3 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ RelativeLayout f615j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ ViewOnClickListenerC0895a f616k;

    public Chip3(RelativeLayout relativeLayout, ViewOnClickListenerC0895a viewOnClickListenerC0895a) {
        this.f615j = relativeLayout;
        this.f616k = viewOnClickListenerC0895a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ViewOnClickListenerC0895a viewOnClickListenerC0895a = this.f616k;
        RelativeLayout relativeLayout = this.f615j;
        Intrinsics3.checkNotNullExpressionValue(relativeLayout, "it");
        Drawable background = relativeLayout.getBackground();
        Intrinsics3.checkNotNullExpressionValue(background, "it.background");
        int i = this.f616k.f607p.f611c;
        Objects.requireNonNull(viewOnClickListenerC0895a);
        background.setColorFilter(i, PorterDuff.Mode.SRC_ATOP);
    }
}
