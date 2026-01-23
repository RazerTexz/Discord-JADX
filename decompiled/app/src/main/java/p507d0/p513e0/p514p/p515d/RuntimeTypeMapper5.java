package p507d0.p513e0.p514p.p515d;

import java.lang.reflect.Method;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.reflectClassUtil;
import p507d0.p580t._Arrays;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.h0, reason: use source file name */
/* JADX INFO: compiled from: RuntimeTypeMapper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class RuntimeTypeMapper5 {
    public static final String access$getSignature$p(Method method) {
        StringBuilder sb = new StringBuilder();
        sb.append(method.getName());
        Class<?>[] parameterTypes = method.getParameterTypes();
        Intrinsics3.checkNotNullExpressionValue(parameterTypes, "parameterTypes");
        sb.append(_Arrays.joinToString$default(parameterTypes, "", "(", ")", 0, (CharSequence) null, RuntimeTypeMapper4.f22360j, 24, (Object) null));
        Class<?> returnType = method.getReturnType();
        Intrinsics3.checkNotNullExpressionValue(returnType, "returnType");
        sb.append(reflectClassUtil.getDesc(returnType));
        return sb.toString();
    }
}
