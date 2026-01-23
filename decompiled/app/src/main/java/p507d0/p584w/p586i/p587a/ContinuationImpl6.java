package p507d0.p584w.p586i.p587a;

import kotlin.coroutines.Continuation;
import p507d0.p592z.p594d.FunctionBase;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Reflection2;

/* JADX INFO: renamed from: d0.w.i.a.k, reason: use source file name */
/* JADX INFO: compiled from: ContinuationImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ContinuationImpl6 extends ContinuationImpl3 implements FunctionBase<Object> {
    private final int arity;

    public ContinuationImpl6(int i, Continuation<Object> continuation) {
        super(continuation);
        this.arity = i;
    }

    @Override // p507d0.p592z.p594d.FunctionBase
    public int getArity() {
        return this.arity;
    }

    @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        String strRenderLambdaToString = Reflection2.renderLambdaToString(this);
        Intrinsics3.checkNotNullExpressionValue(strRenderLambdaToString, "Reflection.renderLambdaToString(this)");
        return strRenderLambdaToString;
    }

    public ContinuationImpl6(int i) {
        this(i, null);
    }
}
