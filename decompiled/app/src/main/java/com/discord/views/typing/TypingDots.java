package com.discord.views.typing;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.C5419R;
import p007b.p008a.p025i.TypingDotsViewBinding;
import p007b.p008a.p062y.p071r0.TypingDots2;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: TypingDots.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TypingDots extends ConstraintLayout {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ int f19342j = 0;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final TypingDotsViewBinding binding;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final int dotsAnimationTimeMs;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final long dotsAnimationStaggerTimeMs;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public boolean isRunning;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TypingDots(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(C5419R.layout.typing_dots_view, this);
        int i = C5419R.id.view_typing_dots_1;
        TypingDot typingDot = (TypingDot) findViewById(C5419R.id.view_typing_dots_1);
        if (typingDot != null) {
            i = C5419R.id.view_typing_dots_2;
            TypingDot typingDot2 = (TypingDot) findViewById(C5419R.id.view_typing_dots_2);
            if (typingDot2 != null) {
                i = C5419R.id.view_typing_dots_3;
                TypingDot typingDot3 = (TypingDot) findViewById(C5419R.id.view_typing_dots_3);
                if (typingDot3 != null) {
                    TypingDotsViewBinding typingDotsViewBinding = new TypingDotsViewBinding(this, typingDot, typingDot2, typingDot3);
                    Intrinsics3.checkNotNullExpressionValue(typingDotsViewBinding, "TypingDotsViewBinding.in…ater.from(context), this)");
                    this.binding = typingDotsViewBinding;
                    int integer = getResources().getInteger(C5419R.integer.animation_time_standard);
                    this.dotsAnimationTimeMs = integer;
                    this.dotsAnimationStaggerTimeMs = (long) (((double) integer) / 1.5d);
                    typingDot3.setOnScaleDownCompleteListener(new TypingDots2(this));
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    /* JADX INFO: renamed from: b */
    public static /* synthetic */ void m8618b(TypingDots typingDots, boolean z2, int i) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        typingDots.m8619a(z2);
    }

    /* JADX INFO: renamed from: a */
    public final void m8619a(boolean isReplay) {
        if (this.isRunning && !isReplay) {
            return;
        }
        long j = isReplay ? this.dotsAnimationStaggerTimeMs : 0L;
        this.binding.f1240b.m8617a(j);
        this.binding.f1241c.m8617a(this.dotsAnimationStaggerTimeMs + j);
        TypingDot typingDot = this.binding.f1242d;
        long j2 = this.dotsAnimationStaggerTimeMs;
        typingDot.m8617a(j + j2 + j2);
        this.isRunning = true;
    }

    /* JADX INFO: renamed from: c */
    public final void m8620c() {
        TypingDotsViewBinding typingDotsViewBinding = this.binding;
        for (TypingDot typingDot : Collections2.listOf((Object[]) new TypingDot[]{typingDotsViewBinding.f1240b, typingDotsViewBinding.f1241c, typingDotsViewBinding.f1242d})) {
            typingDot.scaleAndFadeUpAnimation.cancel();
            typingDot.scaleAndFadeDownAnimation.cancel();
        }
        this.isRunning = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m8620c();
    }
}
