package p507d0.p513e0.p514p;

import java.lang.reflect.Type;
import kotlin.reflect.KType;
import p507d0.p513e0.TypesJVM5;
import p507d0.p513e0.p514p.p515d.KTypeImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.b, reason: use source file name */
/* JADX INFO: compiled from: ReflectJvmMapping.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ReflectJvmMapping {
    public static final Type getJavaType(KType kType) {
        Intrinsics3.checkNotNullParameter(kType, "$this$javaType");
        Type javaType = ((KTypeImpl) kType).getJavaType();
        return javaType != null ? javaType : TypesJVM5.getJavaType(kType);
    }
}
