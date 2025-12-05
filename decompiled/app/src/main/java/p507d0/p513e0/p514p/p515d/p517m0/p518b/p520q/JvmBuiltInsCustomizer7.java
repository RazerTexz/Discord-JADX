package p507d0.p513e0.p514p.p515d.p517m0.p518b.p520q;

import kotlin.jvm.internal.Ref$ObjectRef;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.p520q.JvmBuiltInsCustomizer2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.SignatureBuildingComponents;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.methodSignatureBuildingUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.DFS;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: JvmBuiltInsCustomizer.kt */
/* renamed from: d0.e0.p.d.m0.b.q.l, reason: use source file name */
/* loaded from: classes3.dex */
public final class JvmBuiltInsCustomizer7 extends DFS.b<ClassDescriptor, JvmBuiltInsCustomizer2.a> {

    /* renamed from: a */
    public final /* synthetic */ String f22663a;

    /* renamed from: b */
    public final /* synthetic */ Ref$ObjectRef<JvmBuiltInsCustomizer2.a> f22664b;

    public JvmBuiltInsCustomizer7(String str, Ref$ObjectRef<JvmBuiltInsCustomizer2.a> ref$ObjectRef) {
        this.f22663a = str;
        this.f22664b = ref$ObjectRef;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p576p.DFS.d
    public /* bridge */ /* synthetic */ boolean beforeChildren(Object obj) {
        return beforeChildren((ClassDescriptor) obj);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p576p.DFS.d
    public /* bridge */ /* synthetic */ Object result() {
        return result();
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [T, d0.e0.p.d.m0.b.q.g$a] */
    /* JADX WARN: Type inference failed for: r0v5, types: [T, d0.e0.p.d.m0.b.q.g$a] */
    /* JADX WARN: Type inference failed for: r0v6, types: [T, d0.e0.p.d.m0.b.q.g$a] */
    public boolean beforeChildren(ClassDescriptor classDescriptor) {
        Intrinsics3.checkNotNullParameter(classDescriptor, "javaClassDescriptor");
        String strSignature = methodSignatureBuildingUtils.signature(SignatureBuildingComponents.f23636a, classDescriptor, this.f22663a);
        JvmBuiltInsSignatures jvmBuiltInsSignatures = JvmBuiltInsSignatures.f22666a;
        if (jvmBuiltInsSignatures.getHIDDEN_METHOD_SIGNATURES().contains(strSignature)) {
            this.f22664b.element = JvmBuiltInsCustomizer2.a.HIDDEN;
        } else if (jvmBuiltInsSignatures.getVISIBLE_METHOD_SIGNATURES().contains(strSignature)) {
            this.f22664b.element = JvmBuiltInsCustomizer2.a.VISIBLE;
        } else if (jvmBuiltInsSignatures.getDROP_LIST_METHOD_SIGNATURES().contains(strSignature)) {
            this.f22664b.element = JvmBuiltInsCustomizer2.a.DROP;
        }
        return this.f22664b.element == null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p576p.DFS.d
    public JvmBuiltInsCustomizer2.a result() {
        JvmBuiltInsCustomizer2.a aVar = this.f22664b.element;
        return aVar == null ? JvmBuiltInsCustomizer2.a.NOT_CONSIDERED : aVar;
    }
}
