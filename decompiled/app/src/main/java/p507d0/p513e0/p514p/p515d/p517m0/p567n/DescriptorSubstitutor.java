package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import java.util.HashMap;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SourceElement;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.TypeParameterDescriptorImpl;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.o, reason: use source file name */
/* JADX INFO: compiled from: DescriptorSubstitutor.java */
/* JADX INFO: loaded from: classes3.dex */
public class DescriptorSubstitutor {
    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m10022a(int i) {
        String str = i != 4 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i != 4 ? 3 : 2];
        switch (i) {
            case 1:
            case 6:
                objArr[0] = "originalSubstitution";
                break;
            case 2:
            case 7:
                objArr[0] = "newContainingDeclaration";
                break;
            case 3:
            case 8:
                objArr[0] = "result";
                break;
            case 4:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
                break;
            case 5:
            default:
                objArr[0] = "typeParameters";
                break;
        }
        if (i != 4) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
        } else {
            objArr[1] = "substituteTypeParameters";
        }
        if (i != 4) {
            objArr[2] = "substituteTypeParameters";
        }
        String str2 = String.format(str, objArr);
        if (i == 4) {
            throw new IllegalStateException(str2);
        }
    }

    public static TypeSubstitutor2 substituteTypeParameters(List<TypeParameterDescriptor> list, TypeSubstitution5 typeSubstitution5, DeclarationDescriptor declarationDescriptor, List<TypeParameterDescriptor> list2) {
        if (list == null) {
            m10022a(0);
            throw null;
        }
        if (typeSubstitution5 == null) {
            m10022a(1);
            throw null;
        }
        if (declarationDescriptor == null) {
            m10022a(2);
            throw null;
        }
        if (list2 == null) {
            m10022a(3);
            throw null;
        }
        TypeSubstitutor2 typeSubstitutor2SubstituteTypeParameters = substituteTypeParameters(list, typeSubstitution5, declarationDescriptor, list2, null);
        if (typeSubstitutor2SubstituteTypeParameters != null) {
            return typeSubstitutor2SubstituteTypeParameters;
        }
        throw new AssertionError("Substitution failed");
    }

    public static TypeSubstitutor2 substituteTypeParameters(List<TypeParameterDescriptor> list, TypeSubstitution5 typeSubstitution5, DeclarationDescriptor declarationDescriptor, List<TypeParameterDescriptor> list2, boolean[] zArr) {
        if (list == null) {
            m10022a(5);
            throw null;
        }
        if (typeSubstitution5 == null) {
            m10022a(6);
            throw null;
        }
        if (declarationDescriptor == null) {
            m10022a(7);
            throw null;
        }
        if (list2 != null) {
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            int i = 0;
            for (TypeParameterDescriptor typeParameterDescriptor : list) {
                TypeParameterDescriptorImpl typeParameterDescriptorImplCreateForFurtherModification = TypeParameterDescriptorImpl.createForFurtherModification(declarationDescriptor, typeParameterDescriptor.getAnnotations(), typeParameterDescriptor.isReified(), typeParameterDescriptor.getVariance(), typeParameterDescriptor.getName(), i, SourceElement.f23099a, typeParameterDescriptor.getStorageManager());
                map.put(typeParameterDescriptor.getTypeConstructor(), new TypeProjectionImpl(typeParameterDescriptorImplCreateForFurtherModification.getDefaultType()));
                map2.put(typeParameterDescriptor, typeParameterDescriptorImplCreateForFurtherModification);
                list2.add(typeParameterDescriptorImplCreateForFurtherModification);
                i++;
            }
            TypeSubstitutor2 typeSubstitutor2CreateChainedSubstitutor = TypeSubstitutor2.createChainedSubstitutor(typeSubstitution5, TypeSubstitution3.createByConstructorsMap(map));
            for (TypeParameterDescriptor typeParameterDescriptor2 : list) {
                TypeParameterDescriptorImpl typeParameterDescriptorImpl = (TypeParameterDescriptorImpl) map2.get(typeParameterDescriptor2);
                for (KotlinType kotlinType : typeParameterDescriptor2.getUpperBounds()) {
                    KotlinType kotlinTypeSubstitute = typeSubstitutor2CreateChainedSubstitutor.substitute(kotlinType, Variance.IN_VARIANCE);
                    if (kotlinTypeSubstitute == null) {
                        return null;
                    }
                    if (kotlinTypeSubstitute != kotlinType && zArr != null) {
                        zArr[0] = true;
                    }
                    typeParameterDescriptorImpl.addUpperBound(kotlinTypeSubstitute);
                }
                typeParameterDescriptorImpl.setInitialized();
            }
            return typeSubstitutor2CreateChainedSubstitutor;
        }
        m10022a(8);
        throw null;
    }
}
