package p507d0.p513e0.p514p.p515d.p516l0;

import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.List;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: Caller.kt */
/* renamed from: d0.e0.p.d.l0.d, reason: use source file name */
/* loaded from: classes3.dex */
public interface Caller2<M extends Member> {

    /* compiled from: Caller.kt */
    /* renamed from: d0.e0.p.d.l0.d$a */
    public static final class a {
        public static <M extends Member> void checkArguments(Caller2<? extends M> caller2, Object[] objArr) {
            Intrinsics3.checkNotNullParameter(objArr, "args");
            if (Caller3.getArity(caller2) == objArr.length) {
                return;
            }
            StringBuilder sbM833U = outline.m833U("Callable expects ");
            sbM833U.append(Caller3.getArity(caller2));
            sbM833U.append(" arguments, but ");
            throw new IllegalArgumentException(outline.m814B(sbM833U, objArr.length, " were provided."));
        }
    }

    Object call(Object[] objArr);

    /* renamed from: getMember */
    M mo11457getMember();

    List<Type> getParameterTypes();

    Type getReturnType();
}
