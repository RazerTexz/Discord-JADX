package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b;

import java.util.ArrayList;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.ReflectJavaAnnotationArguments;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.annotationArguments3;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ReflectJavaAnnotationArguments.kt */
/* renamed from: d0.e0.p.d.m0.c.k1.b.h, reason: use source file name */
/* loaded from: classes3.dex */
public final class ReflectJavaAnnotationArguments3 extends ReflectJavaAnnotationArguments implements annotationArguments3 {

    /* renamed from: c */
    public final Object[] f23042c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReflectJavaAnnotationArguments3(Name name, Object[] objArr) {
        super(name);
        Intrinsics3.checkNotNullParameter(objArr, "values");
        this.f23042c = objArr;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.annotationArguments3
    public List<ReflectJavaAnnotationArguments> getElements() {
        Object[] objArr = this.f23042c;
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            ReflectJavaAnnotationArguments.a aVar = ReflectJavaAnnotationArguments.f23039a;
            Intrinsics3.checkNotNull(obj);
            arrayList.add(aVar.create(obj, null));
        }
        return arrayList;
    }
}
