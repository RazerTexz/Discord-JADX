package p507d0.p513e0.p514p.p515d.p517m0.p573o;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.KotlinBuiltIns;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ReceiverParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ValueParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.DescriptorUtils2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p571o1.TypeUtils2;
import p507d0.p513e0.p514p.p515d.p517m0.p573o.AbstractC12024f;
import p507d0.p513e0.p514p.p515d.p517m0.p573o.AbstractC12029k;
import p507d0.p513e0.p514p.p515d.p517m0.p573o.AbstractC12030l;
import p507d0.p580t.Collections2;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: d0.e0.p.d.m0.o.i */
/* JADX INFO: compiled from: modifierChecks.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12027i extends AbstractC12019a {

    /* JADX INFO: renamed from: a */
    public static final C12027i f24917a = new C12027i();

    /* JADX INFO: renamed from: b */
    public static final List<C12022d> f24918b;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.o.i$a */
    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class a extends Lambda implements Function1<FunctionDescriptor, String> {

        /* JADX INFO: renamed from: j */
        public static final a f24919j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ String invoke(FunctionDescriptor functionDescriptor) {
            return invoke2(functionDescriptor);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final String invoke2(FunctionDescriptor functionDescriptor) {
            Boolean boolValueOf;
            Intrinsics3.checkNotNullParameter(functionDescriptor, "<this>");
            List<ValueParameterDescriptor> valueParameters = functionDescriptor.getValueParameters();
            Intrinsics3.checkNotNullExpressionValue(valueParameters, "valueParameters");
            ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) _Collections.lastOrNull((List) valueParameters);
            if (valueParameterDescriptor == null) {
                boolValueOf = null;
            } else {
                boolValueOf = Boolean.valueOf(!DescriptorUtils2.declaresOrInheritsDefaultValue(valueParameterDescriptor) && valueParameterDescriptor.getVarargElementType() == null);
            }
            boolean zAreEqual = Intrinsics3.areEqual(boolValueOf, Boolean.TRUE);
            C12027i c12027i = C12027i.f24917a;
            if (zAreEqual) {
                return null;
            }
            return "last parameter should not have a default value or be a vararg";
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.o.i$b */
    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class b extends Lambda implements Function1<FunctionDescriptor, String> {

        /* JADX INFO: renamed from: j */
        public static final b f24920j = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ String invoke(FunctionDescriptor functionDescriptor) {
            return invoke2(functionDescriptor);
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x0062  */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final String invoke2(FunctionDescriptor functionDescriptor) {
            boolean z2;
            boolean z3;
            Intrinsics3.checkNotNullParameter(functionDescriptor, "<this>");
            C12027i c12027i = C12027i.f24917a;
            DeclarationDescriptor containingDeclaration = functionDescriptor.getContainingDeclaration();
            Intrinsics3.checkNotNullExpressionValue(containingDeclaration, "containingDeclaration");
            if (!((containingDeclaration instanceof ClassDescriptor) && KotlinBuiltIns.isAny((ClassDescriptor) containingDeclaration))) {
                Collection<? extends FunctionDescriptor> overriddenDescriptors = functionDescriptor.getOverriddenDescriptors();
                Intrinsics3.checkNotNullExpressionValue(overriddenDescriptors, "overriddenDescriptors");
                if (overriddenDescriptors.isEmpty()) {
                    z3 = false;
                    z2 = z3;
                } else {
                    Iterator<T> it = overriddenDescriptors.iterator();
                    while (it.hasNext()) {
                        DeclarationDescriptor containingDeclaration2 = ((FunctionDescriptor) it.next()).getContainingDeclaration();
                        Intrinsics3.checkNotNullExpressionValue(containingDeclaration2, "it.containingDeclaration");
                        if ((containingDeclaration2 instanceof ClassDescriptor) && KotlinBuiltIns.isAny((ClassDescriptor) containingDeclaration2)) {
                            z3 = true;
                            break;
                        }
                    }
                    z3 = false;
                    if (z3) {
                    }
                }
            }
            if (z2) {
                return null;
            }
            return "must override ''equals()'' in Any";
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.o.i$c */
    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class c extends Lambda implements Function1<FunctionDescriptor, String> {

        /* JADX INFO: renamed from: j */
        public static final c f24921j = new c();

        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ String invoke(FunctionDescriptor functionDescriptor) {
            return invoke2(functionDescriptor);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final String invoke2(FunctionDescriptor functionDescriptor) {
            boolean zIsSubtypeOf;
            Intrinsics3.checkNotNullParameter(functionDescriptor, "<this>");
            ReceiverParameterDescriptor dispatchReceiverParameter = functionDescriptor.getDispatchReceiverParameter();
            if (dispatchReceiverParameter == null) {
                dispatchReceiverParameter = functionDescriptor.getExtensionReceiverParameter();
            }
            C12027i c12027i = C12027i.f24917a;
            boolean z2 = false;
            if (dispatchReceiverParameter != null) {
                KotlinType returnType = functionDescriptor.getReturnType();
                if (returnType == null) {
                    zIsSubtypeOf = false;
                } else {
                    KotlinType type = dispatchReceiverParameter.getType();
                    Intrinsics3.checkNotNullExpressionValue(type, "receiver.type");
                    zIsSubtypeOf = TypeUtils2.isSubtypeOf(returnType, type);
                }
                if (zIsSubtypeOf) {
                    z2 = true;
                }
            }
            if (z2) {
                return null;
            }
            return "receiver must be a supertype of the return type";
        }
    }

    static {
        Name name = OperatorNameConventions.f24938i;
        AbstractC12024f.b bVar = AbstractC12024f.b.f24914b;
        InterfaceC12020b[] interfaceC12020bArr = {bVar, new AbstractC12030l.a(1)};
        Name name2 = OperatorNameConventions.f24939j;
        InterfaceC12020b[] interfaceC12020bArr2 = {bVar, new AbstractC12030l.a(2)};
        Name name3 = OperatorNameConventions.f24930a;
        C12026h c12026h = C12026h.f24916a;
        C12023e c12023e = C12023e.f24911a;
        Name name4 = OperatorNameConventions.f24935f;
        AbstractC12030l.d dVar = AbstractC12030l.d.f24969b;
        AbstractC12029k.a aVar = AbstractC12029k.a.f24959d;
        Name name5 = OperatorNameConventions.f24937h;
        AbstractC12030l.c cVar = AbstractC12030l.c.f24968b;
        f24918b = Collections2.listOf((Object[]) new C12022d[]{new C12022d(name, interfaceC12020bArr, (Function1) null, 4, (DefaultConstructorMarker) null), new C12022d(name2, interfaceC12020bArr2, a.f24919j), new C12022d(name3, new InterfaceC12020b[]{bVar, c12026h, new AbstractC12030l.a(2), c12023e}, (Function1) null, 4, (DefaultConstructorMarker) null), new C12022d(OperatorNameConventions.f24931b, new InterfaceC12020b[]{bVar, c12026h, new AbstractC12030l.a(3), c12023e}, (Function1) null, 4, (DefaultConstructorMarker) null), new C12022d(OperatorNameConventions.f24932c, new InterfaceC12020b[]{bVar, c12026h, new AbstractC12030l.b(2), c12023e}, (Function1) null, 4, (DefaultConstructorMarker) null), new C12022d(OperatorNameConventions.f24936g, new InterfaceC12020b[]{bVar}, (Function1) null, 4, (DefaultConstructorMarker) null), new C12022d(name4, new InterfaceC12020b[]{bVar, dVar, c12026h, aVar}, (Function1) null, 4, (DefaultConstructorMarker) null), new C12022d(name5, new InterfaceC12020b[]{bVar, cVar}, (Function1) null, 4, (DefaultConstructorMarker) null), new C12022d(OperatorNameConventions.f24940k, new InterfaceC12020b[]{bVar, cVar}, (Function1) null, 4, (DefaultConstructorMarker) null), new C12022d(OperatorNameConventions.f24941l, new InterfaceC12020b[]{bVar, cVar, aVar}, (Function1) null, 4, (DefaultConstructorMarker) null), new C12022d(OperatorNameConventions.f24954y, new InterfaceC12020b[]{bVar, dVar, c12026h}, (Function1) null, 4, (DefaultConstructorMarker) null), new C12022d(OperatorNameConventions.f24933d, new InterfaceC12020b[]{AbstractC12024f.a.f24913b}, b.f24920j), new C12022d(OperatorNameConventions.f24934e, new InterfaceC12020b[]{bVar, AbstractC12029k.b.f24961d, dVar, c12026h}, (Function1) null, 4, (DefaultConstructorMarker) null), new C12022d(OperatorNameConventions.f24928G, new InterfaceC12020b[]{bVar, dVar, c12026h}, (Function1) null, 4, (DefaultConstructorMarker) null), new C12022d(OperatorNameConventions.f24927F, new InterfaceC12020b[]{bVar, cVar}, (Function1) null, 4, (DefaultConstructorMarker) null), new C12022d(Collections2.listOf((Object[]) new Name[]{OperatorNameConventions.f24943n, OperatorNameConventions.f24944o}), new InterfaceC12020b[]{bVar}, c.f24921j), new C12022d(OperatorNameConventions.f24929H, new InterfaceC12020b[]{bVar, AbstractC12029k.c.f24963d, dVar, c12026h}, (Function1) null, 4, (DefaultConstructorMarker) null), new C12022d(OperatorNameConventions.f24942m, new InterfaceC12020b[]{bVar, cVar}, (Function1) null, 4, (DefaultConstructorMarker) null)});
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p573o.AbstractC12019a
    public List<C12022d> getChecks$descriptors() {
        return f24918b;
    }
}
