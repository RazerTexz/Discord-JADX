package d0.z.d;

import java.io.Serializable;

/* compiled from: Lambda.kt */
/* loaded from: classes3.dex */
public abstract class o<R> implements i<R>, Serializable {
    private final int arity;

    public o(int i) {
        this.arity = i;
    }

    @Override // d0.z.d.i
    public int getArity() {
        return this.arity;
    }

    public String toString() {
        String strRenderLambdaToString = a0.renderLambdaToString((o) this);
        m.checkNotNullExpressionValue(strRenderLambdaToString, "Reflection.renderLambdaToString(this)");
        return strRenderLambdaToString;
    }
}
