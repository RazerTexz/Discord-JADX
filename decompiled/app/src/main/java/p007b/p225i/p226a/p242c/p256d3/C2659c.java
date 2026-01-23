package p007b.p225i.p226a.p242c.p256d3;

import android.animation.ValueAnimator;
import com.google.android.exoplayer2.p505ui.DefaultTimeBar;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.c.d3.c */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C2659c implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ DefaultTimeBar f6337a;

    public /* synthetic */ C2659c(DefaultTimeBar defaultTimeBar) {
        this.f6337a = defaultTimeBar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        DefaultTimeBar defaultTimeBar = this.f6337a;
        Objects.requireNonNull(defaultTimeBar);
        defaultTimeBar.f20077O = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        defaultTimeBar.invalidate(defaultTimeBar.f20086j);
    }
}
