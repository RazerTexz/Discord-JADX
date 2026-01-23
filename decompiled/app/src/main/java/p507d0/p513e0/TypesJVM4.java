package p507d0.p513e0;

import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.m, reason: use source file name */
/* JADX INFO: compiled from: TypesJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class TypesJVM4 extends FunctionReferenceImpl implements Function1<Class<? extends Object>, Class<?>> {

    /* JADX INFO: renamed from: j */
    public static final TypesJVM4 f22313j = new TypesJVM4();

    public TypesJVM4() {
        super(1, Class.class, "getComponentType", "getComponentType()Ljava/lang/Class;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Class<?> invoke2(Class<?> cls) {
        Intrinsics3.checkNotNullParameter(cls, "p1");
        return cls.getComponentType();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Class<?> invoke(Class<? extends Object> cls) {
        return invoke2((Class<?>) cls);
    }
}
