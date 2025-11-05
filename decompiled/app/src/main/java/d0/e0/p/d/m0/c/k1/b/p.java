package d0.e0.p.d.m0.c.k1.b;

import d0.e0.p.d.m0.c.k1.b.w;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Type;

/* compiled from: ReflectJavaField.kt */
/* loaded from: classes3.dex */
public final class p extends r implements d0.e0.p.d.m0.e.a.k0.n {
    public final Field a;

    public p(Field field) {
        d0.z.d.m.checkNotNullParameter(field, "member");
        this.a = field;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.n
    public boolean getHasConstantNotNullInitializer() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.k1.b.r
    public Field getMember() {
        return this.a;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.n
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.e.a.k0.x getType() {
        return getType();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.n
    public boolean isEnumEntry() {
        return getMember().isEnumConstant();
    }

    @Override // d0.e0.p.d.m0.c.k1.b.r
    public /* bridge */ /* synthetic */ Member getMember() {
        return getMember();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.n
    public w getType() {
        w.a aVar = w.a;
        Type genericType = getMember().getGenericType();
        d0.z.d.m.checkNotNullExpressionValue(genericType, "member.genericType");
        return aVar.create(genericType);
    }
}
