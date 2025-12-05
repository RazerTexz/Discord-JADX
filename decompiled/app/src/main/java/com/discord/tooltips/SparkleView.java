package com.discord.tooltips;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import com.discord.C5419R;
import kotlin.Lazy;
import p007b.p008a.p025i.SparkleViewBinding;
import p007b.p008a.p058v.SparkleView2;
import p007b.p008a.p058v.SparkleView3;
import p507d0.LazyJVM;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: SparkleView.kt */
/* loaded from: classes2.dex */
public final class SparkleView extends FrameLayout {

    /* renamed from: j, reason: from kotlin metadata */
    public final SparkleViewBinding binding;

    /* renamed from: k, reason: from kotlin metadata */
    public int sparkleAnimationResId;

    /* renamed from: l, reason: from kotlin metadata */
    public final Lazy sparkleDrawable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SparkleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(C5419R.layout.sparkle_view, this);
        ImageView imageView = (ImageView) findViewById(C5419R.id.sparkle_view_image);
        if (imageView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(C5419R.id.sparkle_view_image)));
        }
        SparkleViewBinding sparkleViewBinding = new SparkleViewBinding(this, imageView);
        Intrinsics3.checkNotNullExpressionValue(sparkleViewBinding, "SparkleViewBinding.infla…ater.from(context), this)");
        this.binding = sparkleViewBinding;
        this.sparkleAnimationResId = C5419R.drawable.sparkle_animated_vector;
        this.sparkleDrawable = LazyJVM.lazy(new SparkleView2(this));
        setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        imageView.setImageDrawable(getSparkleDrawable());
        AnimatedVectorDrawableCompat sparkleDrawable = getSparkleDrawable();
        if (sparkleDrawable != null) {
            sparkleDrawable.registerAnimationCallback(new SparkleView3(this));
        }
        AnimatedVectorDrawableCompat sparkleDrawable2 = getSparkleDrawable();
        if (sparkleDrawable2 != null) {
            sparkleDrawable2.start();
        }
    }

    /* renamed from: a */
    public static final /* synthetic */ AnimatedVectorDrawableCompat m8510a(SparkleView sparkleView) {
        return sparkleView.getSparkleDrawable();
    }

    private final AnimatedVectorDrawableCompat getSparkleDrawable() {
        return (AnimatedVectorDrawableCompat) this.sparkleDrawable.getValue();
    }

    /* renamed from: b */
    public final void m8511b() {
        AnimatedVectorDrawableCompat sparkleDrawable = getSparkleDrawable();
        if (sparkleDrawable != null) {
            sparkleDrawable.stop();
        }
    }
}
