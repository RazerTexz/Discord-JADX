package p007b.p008a.p058v;

import android.graphics.drawable.Drawable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import com.discord.tooltips.SparkleView;
import com.discord.utilities.views.ViewCoroutineScope;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.Result3;
import p507d0.p584w.p585h.Intrinsics2;
import p507d0.p584w.p586i.p587a.ContinuationImpl6;
import p507d0.p584w.p586i.p587a.DebugMetadata;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: SparkleView.kt */
/* renamed from: b.a.v.d, reason: use source file name */
/* loaded from: classes2.dex */
public final class SparkleView3 extends Animatable2Compat.AnimationCallback {

    /* renamed from: a */
    public final /* synthetic */ SparkleView f2002a;

    /* compiled from: SparkleView.kt */
    @DebugMetadata(m10084c = "com.discord.tooltips.SparkleView$startAnimation$1$onAnimationEnd$1", m10085f = "SparkleView.kt", m10086l = {61}, m10087m = "invokeSuspend")
    /* renamed from: b.a.v.d$a */
    public static final class a extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int label;

        public a(Continuation continuation) {
            super(2, continuation);
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return SparkleView3.this.new a(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            Continuation<? super Unit> continuation2 = continuation;
            Intrinsics3.checkNotNullParameter(continuation2, "completion");
            return SparkleView3.this.new a(continuation2).invokeSuspend(Unit.f27425a);
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                Result3.throwOnFailure(obj);
                this.label = 1;
                if (C3404f.m4234P(500L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Result3.throwOnFailure(obj);
            }
            AnimatedVectorDrawableCompat animatedVectorDrawableCompatM8510a = SparkleView.m8510a(SparkleView3.this.f2002a);
            if (animatedVectorDrawableCompatM8510a != null) {
                animatedVectorDrawableCompatM8510a.start();
            }
            return Unit.f27425a;
        }
    }

    public SparkleView3(SparkleView sparkleView) {
        this.f2002a = sparkleView;
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback
    public void onAnimationEnd(Drawable drawable) {
        Intrinsics3.checkNotNullParameter(drawable, "drawable");
        CoroutineScope coroutineScope = ViewCoroutineScope.getCoroutineScope(this.f2002a);
        if (coroutineScope != null) {
            C3404f.m4211H0(coroutineScope, null, null, new a(null), 3, null);
        }
    }
}
