package b.a.v;

import android.graphics.drawable.Drawable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import b.i.a.f.e.o.f;
import com.discord.tooltips.SparkleView;
import com.discord.utilities.views.ViewCoroutineScopeKt;
import d0.l;
import d0.w.i.a.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: SparkleView.kt */
/* loaded from: classes2.dex */
public final class d extends Animatable2Compat.AnimationCallback {
    public final /* synthetic */ SparkleView a;

    /* compiled from: SparkleView.kt */
    @d0.w.i.a.e(c = "com.discord.tooltips.SparkleView$startAnimation$1$onAnimationEnd$1", f = "SparkleView.kt", l = {61}, m = "invokeSuspend")
    public static final class a extends k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int label;

        public a(Continuation continuation) {
            super(2, continuation);
        }

        @Override // d0.w.i.a.a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            m.checkNotNullParameter(continuation, "completion");
            return d.this.new a(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            Continuation<? super Unit> continuation2 = continuation;
            m.checkNotNullParameter(continuation2, "completion");
            return d.this.new a(continuation2).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.a
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = d0.w.h.c.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                l.throwOnFailure(obj);
                this.label = 1;
                if (f.P(500L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                l.throwOnFailure(obj);
            }
            AnimatedVectorDrawableCompat animatedVectorDrawableCompatA = SparkleView.a(d.this.a);
            if (animatedVectorDrawableCompatA != null) {
                animatedVectorDrawableCompatA.start();
            }
            return Unit.a;
        }
    }

    public d(SparkleView sparkleView) {
        this.a = sparkleView;
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback
    public void onAnimationEnd(Drawable drawable) {
        m.checkNotNullParameter(drawable, "drawable");
        CoroutineScope coroutineScope = ViewCoroutineScopeKt.getCoroutineScope(this.a);
        if (coroutineScope != null) {
            f.H0(coroutineScope, null, null, new a(null), 3, null);
        }
    }
}
