package androidx.core.graphics;

import android.graphics.Matrix;
import android.graphics.Shader;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: Shader.kt */
/* loaded from: classes.dex */
public final class ShaderKt {
    public static final void transform(Shader shader, Function1<? super Matrix, Unit> function1) {
        m.checkNotNullParameter(shader, "<this>");
        m.checkNotNullParameter(function1, "block");
        Matrix matrix = new Matrix();
        shader.getLocalMatrix(matrix);
        function1.invoke(matrix);
        shader.setLocalMatrix(matrix);
    }
}
