package d0.e0.p.d.l0;

import d0.z.d.m;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.List;

/* compiled from: Caller.kt */
/* loaded from: classes3.dex */
public interface d<M extends Member> {

    /* compiled from: Caller.kt */
    public static final class a {
        public static <M extends Member> void checkArguments(d<? extends M> dVar, Object[] objArr) {
            m.checkNotNullParameter(objArr, "args");
            if (f.getArity(dVar) == objArr.length) {
                return;
            }
            StringBuilder sbU = b.d.b.a.a.U("Callable expects ");
            sbU.append(f.getArity(dVar));
            sbU.append(" arguments, but ");
            throw new IllegalArgumentException(b.d.b.a.a.B(sbU, objArr.length, " were provided."));
        }
    }

    Object call(Object[] objArr);

    /* renamed from: getMember */
    M mo80getMember();

    List<Type> getParameterTypes();

    Type getReturnType();
}
