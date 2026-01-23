package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b;

import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.ReflectJavaType;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11581n;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.javaTypes5;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.p, reason: use source file name */
/* JADX INFO: compiled from: ReflectJavaField.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ReflectJavaField extends ReflectJavaMember2 implements InterfaceC11581n {

    /* JADX INFO: renamed from: a */
    public final Field f23059a;

    public ReflectJavaField(Field field) {
        Intrinsics3.checkNotNullParameter(field, "member");
        this.f23059a = field;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11581n
    public boolean getHasConstantNotNullInitializer() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.ReflectJavaMember2
    public Field getMember() {
        return this.f23059a;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11581n
    public /* bridge */ /* synthetic */ javaTypes5 getType() {
        return getType();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11581n
    public boolean isEnumEntry() {
        return getMember().isEnumConstant();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.ReflectJavaMember2
    public /* bridge */ /* synthetic */ Member getMember() {
        return getMember();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11581n
    public ReflectJavaType getType() {
        ReflectJavaType.a aVar = ReflectJavaType.f23065a;
        Type genericType = getMember().getGenericType();
        Intrinsics3.checkNotNullExpressionValue(genericType, "member.genericType");
        return aVar.create(genericType);
    }
}
