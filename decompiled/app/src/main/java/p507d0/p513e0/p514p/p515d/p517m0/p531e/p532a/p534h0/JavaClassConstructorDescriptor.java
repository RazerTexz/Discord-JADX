package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p534h0;

import java.util.List;
import kotlin.Tuples2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SourceElement;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.ClassConstructorDescriptorImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.FunctionDescriptorImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.DescriptorFactory;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;

/* compiled from: JavaClassConstructorDescriptor.java */
/* renamed from: d0.e0.p.d.m0.e.a.h0.c, reason: use source file name */
/* loaded from: classes3.dex */
public class JavaClassConstructorDescriptor extends ClassConstructorDescriptorImpl implements JavaCallableMemberDescriptor {

    /* renamed from: O */
    public Boolean f23260O;

    /* renamed from: P */
    public Boolean f23261P;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JavaClassConstructorDescriptor(ClassDescriptor classDescriptor, JavaClassConstructorDescriptor javaClassConstructorDescriptor, Annotations4 annotations4, boolean z2, CallableMemberDescriptor.a aVar, SourceElement sourceElement) {
        super(classDescriptor, javaClassConstructorDescriptor, annotations4, z2, aVar, sourceElement);
        if (classDescriptor == null) {
            m9456a(0);
            throw null;
        }
        if (annotations4 == null) {
            m9456a(1);
            throw null;
        }
        if (aVar == null) {
            m9456a(2);
            throw null;
        }
        if (sourceElement == null) {
            m9456a(3);
            throw null;
        }
        this.f23260O = null;
        this.f23261P = null;
    }

    /* renamed from: a */
    public static /* synthetic */ void m9456a(int i) {
        String str = (i == 11 || i == 18) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 11 || i == 18) ? 2 : 3];
        switch (i) {
            case 1:
            case 5:
            case 9:
            case 15:
                objArr[0] = "annotations";
                break;
            case 2:
            case 8:
            case 13:
                objArr[0] = "kind";
                break;
            case 3:
            case 6:
            case 10:
                objArr[0] = "source";
                break;
            case 4:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 7:
            case 12:
                objArr[0] = "newOwner";
                break;
            case 11:
            case 18:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor";
                break;
            case 14:
                objArr[0] = "sourceElement";
                break;
            case 16:
                objArr[0] = "enhancedValueParametersData";
                break;
            case 17:
                objArr[0] = "enhancedReturnType";
                break;
        }
        if (i == 11) {
            objArr[1] = "createSubstitutedCopy";
        } else if (i != 18) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
                objArr[2] = "createJavaConstructor";
                break;
            case 7:
            case 8:
            case 9:
            case 10:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 11:
            case 18:
                break;
            case 12:
            case 13:
            case 14:
            case 15:
                objArr[2] = "createDescriptor";
                break;
            case 16:
            case 17:
                objArr[2] = "enhance";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 11 && i != 18) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static JavaClassConstructorDescriptor createJavaConstructor(ClassDescriptor classDescriptor, Annotations4 annotations4, boolean z2, SourceElement sourceElement) {
        if (classDescriptor == null) {
            m9456a(4);
            throw null;
        }
        if (annotations4 == null) {
            m9456a(5);
            throw null;
        }
        if (sourceElement != null) {
            return new JavaClassConstructorDescriptor(classDescriptor, null, annotations4, z2, CallableMemberDescriptor.a.DECLARATION, sourceElement);
        }
        m9456a(6);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.ClassConstructorDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.FunctionDescriptorImpl
    /* renamed from: b */
    public /* bridge */ /* synthetic */ FunctionDescriptorImpl mo9373b(DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, CallableMemberDescriptor.a aVar, Name name, Annotations4 annotations4, SourceElement sourceElement) {
        return m9457f(declarationDescriptor, functionDescriptor, aVar, name, annotations4, sourceElement);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.ClassConstructorDescriptorImpl
    /* renamed from: e */
    public /* bridge */ /* synthetic */ ClassConstructorDescriptorImpl mo9408e(DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, CallableMemberDescriptor.a aVar, Name name, Annotations4 annotations4, SourceElement sourceElement) {
        return m9457f(declarationDescriptor, functionDescriptor, aVar, name, annotations4, sourceElement);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p534h0.JavaCallableMemberDescriptor
    public /* bridge */ /* synthetic */ JavaCallableMemberDescriptor enhance(KotlinType kotlinType, List list, KotlinType kotlinType2, Tuples2 tuples2) {
        return enhance(kotlinType, (List<util4>) list, kotlinType2, (Tuples2<CallableDescriptor.a<?>, ?>) tuples2);
    }

    /* renamed from: f */
    public JavaClassConstructorDescriptor m9457f(DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, CallableMemberDescriptor.a aVar, Name name, Annotations4 annotations4, SourceElement sourceElement) {
        if (declarationDescriptor == null) {
            m9456a(7);
            throw null;
        }
        if (aVar == null) {
            m9456a(8);
            throw null;
        }
        if (annotations4 == null) {
            m9456a(9);
            throw null;
        }
        if (sourceElement == null) {
            m9456a(10);
            throw null;
        }
        if (aVar != CallableMemberDescriptor.a.DECLARATION && aVar != CallableMemberDescriptor.a.SYNTHESIZED) {
            throw new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + "\nnewOwner: " + declarationDescriptor + "\nkind: " + aVar);
        }
        ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor;
        JavaClassConstructorDescriptor javaClassConstructorDescriptor = (JavaClassConstructorDescriptor) functionDescriptor;
        if (classDescriptor == null) {
            m9456a(12);
            throw null;
        }
        if (aVar == null) {
            m9456a(13);
            throw null;
        }
        if (sourceElement == null) {
            m9456a(14);
            throw null;
        }
        if (annotations4 == null) {
            m9456a(15);
            throw null;
        }
        JavaClassConstructorDescriptor javaClassConstructorDescriptor2 = new JavaClassConstructorDescriptor(classDescriptor, javaClassConstructorDescriptor, annotations4, this.f22874N, aVar, sourceElement);
        javaClassConstructorDescriptor2.setHasStableParameterNames(hasStableParameterNames());
        javaClassConstructorDescriptor2.setHasSynthesizedParameterNames(hasSynthesizedParameterNames());
        return javaClassConstructorDescriptor2;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.FunctionDescriptorImpl
    public boolean hasStableParameterNames() {
        return this.f23260O.booleanValue();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.FunctionDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor
    public boolean hasSynthesizedParameterNames() {
        return this.f23261P.booleanValue();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.FunctionDescriptorImpl
    public void setHasStableParameterNames(boolean z2) {
        this.f23260O = Boolean.valueOf(z2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.FunctionDescriptorImpl
    public void setHasSynthesizedParameterNames(boolean z2) {
        this.f23261P = Boolean.valueOf(z2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p534h0.JavaCallableMemberDescriptor
    public JavaClassConstructorDescriptor enhance(KotlinType kotlinType, List<util4> list, KotlinType kotlinType2, Tuples2<CallableDescriptor.a<?>, ?> tuples2) {
        if (list == null) {
            m9456a(16);
            throw null;
        }
        if (kotlinType2 == null) {
            m9456a(17);
            throw null;
        }
        JavaClassConstructorDescriptor javaClassConstructorDescriptorM9457f = m9457f(getContainingDeclaration(), null, getKind(), null, getAnnotations(), getSource());
        javaClassConstructorDescriptorM9457f.initialize(kotlinType != null ? DescriptorFactory.createExtensionReceiverParameterForCallable(javaClassConstructorDescriptorM9457f, kotlinType, Annotations4.f22735f.getEMPTY()) : null, getDispatchReceiverParameter(), getTypeParameters(), util3.copyValueParameters(list, getValueParameters(), javaClassConstructorDescriptorM9457f), kotlinType2, getModality(), getVisibility());
        if (tuples2 != null) {
            javaClassConstructorDescriptorM9457f.putInUserDataMap(tuples2.getFirst(), tuples2.getSecond());
        }
        return javaClassConstructorDescriptorM9457f;
    }
}
