package p507d0.p513e0.p514p.p515d.p516l0;

import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.List;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ThrowingCaller.kt */
/* renamed from: d0.e0.p.d.l0.j, reason: use source file name */
/* loaded from: classes3.dex */
public final class ThrowingCaller implements Caller2 {

    /* renamed from: a */
    public static final ThrowingCaller f22446a = new ThrowingCaller();

    @Override // p507d0.p513e0.p514p.p515d.p516l0.Caller2
    public Object call(Object[] objArr) {
        Intrinsics3.checkNotNullParameter(objArr, "args");
        throw new UnsupportedOperationException("call/callBy are not supported for this declaration.");
    }

    public Void getMember() {
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p516l0.Caller2
    /* renamed from: getMember */
    public /* bridge */ /* synthetic */ Member mo11457getMember() {
        return (Member) getMember();
    }

    @Override // p507d0.p513e0.p514p.p515d.p516l0.Caller2
    public List<Type> getParameterTypes() {
        return Collections2.emptyList();
    }

    @Override // p507d0.p513e0.p514p.p515d.p516l0.Caller2
    public Type getReturnType() {
        Class cls = Void.TYPE;
        Intrinsics3.checkNotNullExpressionValue(cls, "Void.TYPE");
        return cls;
    }
}
