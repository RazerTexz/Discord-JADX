package p507d0.p513e0.p514p.p515d;

import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.reflectClassUtil;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: RuntimeTypeMapper.kt */
/* renamed from: d0.e0.p.d.g0, reason: use source file name */
/* loaded from: classes3.dex */
public final class RuntimeTypeMapper4 extends Lambda implements Function1<Class<?>, CharSequence> {

    /* renamed from: j */
    public static final RuntimeTypeMapper4 f22360j = new RuntimeTypeMapper4();

    public RuntimeTypeMapper4() {
        super(1);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CharSequence invoke2(Class<?> cls) {
        Intrinsics3.checkNotNullExpressionValue(cls, "it");
        return reflectClassUtil.getDesc(cls);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(Class<?> cls) {
        return invoke2(cls);
    }
}
