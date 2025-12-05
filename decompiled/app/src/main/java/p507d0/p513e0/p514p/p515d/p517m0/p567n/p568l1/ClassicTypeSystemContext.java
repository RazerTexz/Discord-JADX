package p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.KotlinBuiltIns;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.PrimitiveType;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.StandardNames;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassKind;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ModalityUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqNameUnsafe;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.inlineClassesUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.IntegerLiteralTypeConstructor;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.DescriptorUtils2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractTypeChecker3;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.IntersectionTypeConstructor;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType6;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinTypeFactory;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.SpecialTypes3;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeProjection;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSystemCommonBackendContext;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.Variance;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.dynamicTypes;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.C11986o;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.EnumC11973b;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.EnumC11989r;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11974c;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11975d;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11976e;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11977f;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11979h;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11980i;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11981j;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11982k;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11983l;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11984m;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11987p;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p571o1.TypeUtils2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Reflection2;

/* compiled from: ClassicTypeSystemContext.kt */
/* renamed from: d0.e0.p.d.m0.n.l1.c, reason: use source file name */
/* loaded from: classes3.dex */
public interface ClassicTypeSystemContext extends TypeSystemCommonBackendContext, InterfaceC11987p {

    /* compiled from: ClassicTypeSystemContext.kt */
    /* renamed from: d0.e0.p.d.m0.n.l1.c$a */
    public static final class a {
        public static boolean areEqualTypeConstructors(ClassicTypeSystemContext classicTypeSystemContext, InterfaceC11983l interfaceC11983l, InterfaceC11983l interfaceC11983l2) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(interfaceC11983l, "c1");
            Intrinsics3.checkNotNullParameter(interfaceC11983l2, "c2");
            if (!(interfaceC11983l instanceof TypeConstructor)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC11983l + ", " + Reflection2.getOrCreateKotlinClass(interfaceC11983l.getClass())).toString());
            }
            if (interfaceC11983l2 instanceof TypeConstructor) {
                return Intrinsics3.areEqual(interfaceC11983l, interfaceC11983l2);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC11983l2 + ", " + Reflection2.getOrCreateKotlinClass(interfaceC11983l2.getClass())).toString());
        }

        public static int argumentsCount(ClassicTypeSystemContext classicTypeSystemContext, InterfaceC11979h interfaceC11979h) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(interfaceC11979h, "receiver");
            if (interfaceC11979h instanceof KotlinType) {
                return ((KotlinType) interfaceC11979h).getArguments().size();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC11979h + ", " + Reflection2.getOrCreateKotlinClass(interfaceC11979h.getClass())).toString());
        }

        public static InterfaceC11981j asArgumentList(ClassicTypeSystemContext classicTypeSystemContext, InterfaceC11980i interfaceC11980i) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(interfaceC11980i, "receiver");
            if (interfaceC11980i instanceof KotlinType4) {
                return (InterfaceC11981j) interfaceC11980i;
            }
            StringBuilder sbM838Z = outline.m838Z("ClassicTypeSystemContext couldn't handle: ", interfaceC11980i, ", ");
            sbM838Z.append(Reflection2.getOrCreateKotlinClass(interfaceC11980i.getClass()));
            throw new IllegalArgumentException(sbM838Z.toString().toString());
        }

        public static InterfaceC11974c asCapturedType(ClassicTypeSystemContext classicTypeSystemContext, InterfaceC11980i interfaceC11980i) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(interfaceC11980i, "receiver");
            if (interfaceC11980i instanceof KotlinType4) {
                if (interfaceC11980i instanceof NewCapturedType) {
                    return (NewCapturedType) interfaceC11980i;
                }
                return null;
            }
            StringBuilder sbM838Z = outline.m838Z("ClassicTypeSystemContext couldn't handle: ", interfaceC11980i, ", ");
            sbM838Z.append(Reflection2.getOrCreateKotlinClass(interfaceC11980i.getClass()));
            throw new IllegalArgumentException(sbM838Z.toString().toString());
        }

        public static InterfaceC11975d asDefinitelyNotNullType(ClassicTypeSystemContext classicTypeSystemContext, InterfaceC11980i interfaceC11980i) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(interfaceC11980i, "receiver");
            if (interfaceC11980i instanceof KotlinType4) {
                if (interfaceC11980i instanceof SpecialTypes3) {
                    return (SpecialTypes3) interfaceC11980i;
                }
                return null;
            }
            StringBuilder sbM838Z = outline.m838Z("ClassicTypeSystemContext couldn't handle: ", interfaceC11980i, ", ");
            sbM838Z.append(Reflection2.getOrCreateKotlinClass(interfaceC11980i.getClass()));
            throw new IllegalArgumentException(sbM838Z.toString().toString());
        }

        public static InterfaceC11976e asDynamicType(ClassicTypeSystemContext classicTypeSystemContext, InterfaceC11977f interfaceC11977f) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(interfaceC11977f, "receiver");
            if (interfaceC11977f instanceof KotlinType6) {
                if (interfaceC11977f instanceof dynamicTypes) {
                    return (dynamicTypes) interfaceC11977f;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC11977f + ", " + Reflection2.getOrCreateKotlinClass(interfaceC11977f.getClass())).toString());
        }

        public static InterfaceC11977f asFlexibleType(ClassicTypeSystemContext classicTypeSystemContext, InterfaceC11979h interfaceC11979h) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(interfaceC11979h, "receiver");
            if (interfaceC11979h instanceof KotlinType) {
                KotlinType3 kotlinType3Unwrap = ((KotlinType) interfaceC11979h).unwrap();
                if (kotlinType3Unwrap instanceof KotlinType6) {
                    return (KotlinType6) kotlinType3Unwrap;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC11979h + ", " + Reflection2.getOrCreateKotlinClass(interfaceC11979h.getClass())).toString());
        }

        public static InterfaceC11980i asSimpleType(ClassicTypeSystemContext classicTypeSystemContext, InterfaceC11979h interfaceC11979h) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(interfaceC11979h, "receiver");
            if (interfaceC11979h instanceof KotlinType) {
                KotlinType3 kotlinType3Unwrap = ((KotlinType) interfaceC11979h).unwrap();
                if (kotlinType3Unwrap instanceof KotlinType4) {
                    return (KotlinType4) kotlinType3Unwrap;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC11979h + ", " + Reflection2.getOrCreateKotlinClass(interfaceC11979h.getClass())).toString());
        }

        public static InterfaceC11982k asTypeArgument(ClassicTypeSystemContext classicTypeSystemContext, InterfaceC11979h interfaceC11979h) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(interfaceC11979h, "receiver");
            if (interfaceC11979h instanceof KotlinType) {
                return TypeUtils2.asTypeProjection((KotlinType) interfaceC11979h);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC11979h + ", " + Reflection2.getOrCreateKotlinClass(interfaceC11979h.getClass())).toString());
        }

        public static InterfaceC11980i captureFromArguments(ClassicTypeSystemContext classicTypeSystemContext, InterfaceC11980i interfaceC11980i, EnumC11973b enumC11973b) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(interfaceC11980i, "type");
            Intrinsics3.checkNotNullParameter(enumC11973b, "status");
            if (interfaceC11980i instanceof KotlinType4) {
                return NewCapturedType3.captureFromArguments((KotlinType4) interfaceC11980i, enumC11973b);
            }
            StringBuilder sbM838Z = outline.m838Z("ClassicTypeSystemContext couldn't handle: ", interfaceC11980i, ", ");
            sbM838Z.append(Reflection2.getOrCreateKotlinClass(interfaceC11980i.getClass()));
            throw new IllegalArgumentException(sbM838Z.toString().toString());
        }

        public static InterfaceC11979h createFlexibleType(ClassicTypeSystemContext classicTypeSystemContext, InterfaceC11980i interfaceC11980i, InterfaceC11980i interfaceC11980i2) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(interfaceC11980i, "lowerBound");
            Intrinsics3.checkNotNullParameter(interfaceC11980i2, "upperBound");
            if (!(interfaceC11980i instanceof KotlinType4)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + classicTypeSystemContext + ", " + Reflection2.getOrCreateKotlinClass(classicTypeSystemContext.getClass())).toString());
            }
            if (interfaceC11980i2 instanceof KotlinType4) {
                KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.f24748a;
                return KotlinTypeFactory.flexibleType((KotlinType4) interfaceC11980i, (KotlinType4) interfaceC11980i2);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + classicTypeSystemContext + ", " + Reflection2.getOrCreateKotlinClass(classicTypeSystemContext.getClass())).toString());
        }

        public static InterfaceC11982k getArgument(ClassicTypeSystemContext classicTypeSystemContext, InterfaceC11979h interfaceC11979h, int i) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(interfaceC11979h, "receiver");
            if (interfaceC11979h instanceof KotlinType) {
                return ((KotlinType) interfaceC11979h).getArguments().get(i);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC11979h + ", " + Reflection2.getOrCreateKotlinClass(interfaceC11979h.getClass())).toString());
        }

        public static FqNameUnsafe getClassFqNameUnsafe(ClassicTypeSystemContext classicTypeSystemContext, InterfaceC11983l interfaceC11983l) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(interfaceC11983l, "receiver");
            if (interfaceC11983l instanceof TypeConstructor) {
                ClassifierDescriptor declarationDescriptor = ((TypeConstructor) interfaceC11983l).getDeclarationDescriptor();
                Objects.requireNonNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                return DescriptorUtils2.getFqNameUnsafe((ClassDescriptor) declarationDescriptor);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC11983l + ", " + Reflection2.getOrCreateKotlinClass(interfaceC11983l.getClass())).toString());
        }

        public static InterfaceC11984m getParameter(ClassicTypeSystemContext classicTypeSystemContext, InterfaceC11983l interfaceC11983l, int i) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(interfaceC11983l, "receiver");
            if (interfaceC11983l instanceof TypeConstructor) {
                TypeParameterDescriptor typeParameterDescriptor = ((TypeConstructor) interfaceC11983l).getParameters().get(i);
                Intrinsics3.checkNotNullExpressionValue(typeParameterDescriptor, "this.parameters[index]");
                return typeParameterDescriptor;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC11983l + ", " + Reflection2.getOrCreateKotlinClass(interfaceC11983l.getClass())).toString());
        }

        public static PrimitiveType getPrimitiveArrayType(ClassicTypeSystemContext classicTypeSystemContext, InterfaceC11983l interfaceC11983l) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(interfaceC11983l, "receiver");
            if (interfaceC11983l instanceof TypeConstructor) {
                ClassifierDescriptor declarationDescriptor = ((TypeConstructor) interfaceC11983l).getDeclarationDescriptor();
                Objects.requireNonNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                return KotlinBuiltIns.getPrimitiveArrayType((ClassDescriptor) declarationDescriptor);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC11983l + ", " + Reflection2.getOrCreateKotlinClass(interfaceC11983l.getClass())).toString());
        }

        public static PrimitiveType getPrimitiveType(ClassicTypeSystemContext classicTypeSystemContext, InterfaceC11983l interfaceC11983l) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(interfaceC11983l, "receiver");
            if (interfaceC11983l instanceof TypeConstructor) {
                ClassifierDescriptor declarationDescriptor = ((TypeConstructor) interfaceC11983l).getDeclarationDescriptor();
                Objects.requireNonNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                return KotlinBuiltIns.getPrimitiveType((ClassDescriptor) declarationDescriptor);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC11983l + ", " + Reflection2.getOrCreateKotlinClass(interfaceC11983l.getClass())).toString());
        }

        public static InterfaceC11979h getRepresentativeUpperBound(ClassicTypeSystemContext classicTypeSystemContext, InterfaceC11984m interfaceC11984m) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(interfaceC11984m, "receiver");
            if (interfaceC11984m instanceof TypeParameterDescriptor) {
                return TypeUtils2.getRepresentativeUpperBound((TypeParameterDescriptor) interfaceC11984m);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC11984m + ", " + Reflection2.getOrCreateKotlinClass(interfaceC11984m.getClass())).toString());
        }

        public static InterfaceC11979h getSubstitutedUnderlyingType(ClassicTypeSystemContext classicTypeSystemContext, InterfaceC11979h interfaceC11979h) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(interfaceC11979h, "receiver");
            if (interfaceC11979h instanceof KotlinType) {
                return inlineClassesUtils.substitutedUnderlyingType((KotlinType) interfaceC11979h);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC11979h + ", " + Reflection2.getOrCreateKotlinClass(interfaceC11979h.getClass())).toString());
        }

        public static InterfaceC11979h getType(ClassicTypeSystemContext classicTypeSystemContext, InterfaceC11982k interfaceC11982k) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(interfaceC11982k, "receiver");
            if (interfaceC11982k instanceof TypeProjection) {
                return ((TypeProjection) interfaceC11982k).getType().unwrap();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC11982k + ", " + Reflection2.getOrCreateKotlinClass(interfaceC11982k.getClass())).toString());
        }

        public static InterfaceC11984m getTypeParameterClassifier(ClassicTypeSystemContext classicTypeSystemContext, InterfaceC11983l interfaceC11983l) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(interfaceC11983l, "receiver");
            if (interfaceC11983l instanceof TypeConstructor) {
                ClassifierDescriptor declarationDescriptor = ((TypeConstructor) interfaceC11983l).getDeclarationDescriptor();
                if (declarationDescriptor instanceof TypeParameterDescriptor) {
                    return (TypeParameterDescriptor) declarationDescriptor;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC11983l + ", " + Reflection2.getOrCreateKotlinClass(interfaceC11983l.getClass())).toString());
        }

        public static EnumC11989r getVariance(ClassicTypeSystemContext classicTypeSystemContext, InterfaceC11982k interfaceC11982k) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(interfaceC11982k, "receiver");
            if (interfaceC11982k instanceof TypeProjection) {
                Variance projectionKind = ((TypeProjection) interfaceC11982k).getProjectionKind();
                Intrinsics3.checkNotNullExpressionValue(projectionKind, "this.projectionKind");
                return C11986o.convertVariance(projectionKind);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC11982k + ", " + Reflection2.getOrCreateKotlinClass(interfaceC11982k.getClass())).toString());
        }

        public static boolean hasAnnotation(ClassicTypeSystemContext classicTypeSystemContext, InterfaceC11979h interfaceC11979h, FqName fqName) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(interfaceC11979h, "receiver");
            Intrinsics3.checkNotNullParameter(fqName, "fqName");
            if (interfaceC11979h instanceof KotlinType) {
                return ((KotlinType) interfaceC11979h).getAnnotations().hasAnnotation(fqName);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC11979h + ", " + Reflection2.getOrCreateKotlinClass(interfaceC11979h.getClass())).toString());
        }

        public static boolean identicalArguments(ClassicTypeSystemContext classicTypeSystemContext, InterfaceC11980i interfaceC11980i, InterfaceC11980i interfaceC11980i2) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(interfaceC11980i, "a");
            Intrinsics3.checkNotNullParameter(interfaceC11980i2, "b");
            if (!(interfaceC11980i instanceof KotlinType4)) {
                StringBuilder sbM838Z = outline.m838Z("ClassicTypeSystemContext couldn't handle: ", interfaceC11980i, ", ");
                sbM838Z.append(Reflection2.getOrCreateKotlinClass(interfaceC11980i.getClass()));
                throw new IllegalArgumentException(sbM838Z.toString().toString());
            }
            if (interfaceC11980i2 instanceof KotlinType4) {
                return ((KotlinType4) interfaceC11980i).getArguments() == ((KotlinType4) interfaceC11980i2).getArguments();
            }
            StringBuilder sbM838Z2 = outline.m838Z("ClassicTypeSystemContext couldn't handle: ", interfaceC11980i2, ", ");
            sbM838Z2.append(Reflection2.getOrCreateKotlinClass(interfaceC11980i2.getClass()));
            throw new IllegalArgumentException(sbM838Z2.toString().toString());
        }

        public static InterfaceC11979h intersectTypes(ClassicTypeSystemContext classicTypeSystemContext, List<? extends InterfaceC11979h> list) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(list, "types");
            return IntersectionType.intersectTypes(list);
        }

        public static boolean isAnyConstructor(ClassicTypeSystemContext classicTypeSystemContext, InterfaceC11983l interfaceC11983l) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(interfaceC11983l, "receiver");
            if (interfaceC11983l instanceof TypeConstructor) {
                return KotlinBuiltIns.isTypeConstructorForGivenClass((TypeConstructor) interfaceC11983l, StandardNames.a.f22532b);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC11983l + ", " + Reflection2.getOrCreateKotlinClass(interfaceC11983l.getClass())).toString());
        }

        public static boolean isClassTypeConstructor(ClassicTypeSystemContext classicTypeSystemContext, InterfaceC11983l interfaceC11983l) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(interfaceC11983l, "receiver");
            if (interfaceC11983l instanceof TypeConstructor) {
                return ((TypeConstructor) interfaceC11983l).getDeclarationDescriptor() instanceof ClassDescriptor;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC11983l + ", " + Reflection2.getOrCreateKotlinClass(interfaceC11983l.getClass())).toString());
        }

        public static boolean isCommonFinalClassConstructor(ClassicTypeSystemContext classicTypeSystemContext, InterfaceC11983l interfaceC11983l) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(interfaceC11983l, "receiver");
            if (interfaceC11983l instanceof TypeConstructor) {
                ClassifierDescriptor declarationDescriptor = ((TypeConstructor) interfaceC11983l).getDeclarationDescriptor();
                ClassDescriptor classDescriptor = declarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) declarationDescriptor : null;
                return (classDescriptor == null || !ModalityUtils.isFinalClass(classDescriptor) || classDescriptor.getKind() == ClassKind.ENUM_ENTRY || classDescriptor.getKind() == ClassKind.ANNOTATION_CLASS) ? false : true;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC11983l + ", " + Reflection2.getOrCreateKotlinClass(interfaceC11983l.getClass())).toString());
        }

        public static boolean isDenotable(ClassicTypeSystemContext classicTypeSystemContext, InterfaceC11983l interfaceC11983l) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(interfaceC11983l, "receiver");
            if (interfaceC11983l instanceof TypeConstructor) {
                return ((TypeConstructor) interfaceC11983l).isDenotable();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC11983l + ", " + Reflection2.getOrCreateKotlinClass(interfaceC11983l.getClass())).toString());
        }

        public static boolean isError(ClassicTypeSystemContext classicTypeSystemContext, InterfaceC11979h interfaceC11979h) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(interfaceC11979h, "receiver");
            if (interfaceC11979h instanceof KotlinType) {
                return KotlinType2.isError((KotlinType) interfaceC11979h);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC11979h + ", " + Reflection2.getOrCreateKotlinClass(interfaceC11979h.getClass())).toString());
        }

        public static boolean isInlineClass(ClassicTypeSystemContext classicTypeSystemContext, InterfaceC11983l interfaceC11983l) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(interfaceC11983l, "receiver");
            if (interfaceC11983l instanceof TypeConstructor) {
                ClassifierDescriptor declarationDescriptor = ((TypeConstructor) interfaceC11983l).getDeclarationDescriptor();
                ClassDescriptor classDescriptor = declarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) declarationDescriptor : null;
                return Intrinsics3.areEqual(classDescriptor != null ? Boolean.valueOf(inlineClassesUtils.isInlineClass(classDescriptor)) : null, Boolean.TRUE);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC11983l + ", " + Reflection2.getOrCreateKotlinClass(interfaceC11983l.getClass())).toString());
        }

        public static boolean isIntegerLiteralTypeConstructor(ClassicTypeSystemContext classicTypeSystemContext, InterfaceC11983l interfaceC11983l) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(interfaceC11983l, "receiver");
            if (interfaceC11983l instanceof TypeConstructor) {
                return interfaceC11983l instanceof IntegerLiteralTypeConstructor;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC11983l + ", " + Reflection2.getOrCreateKotlinClass(interfaceC11983l.getClass())).toString());
        }

        public static boolean isIntersection(ClassicTypeSystemContext classicTypeSystemContext, InterfaceC11983l interfaceC11983l) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(interfaceC11983l, "receiver");
            if (interfaceC11983l instanceof TypeConstructor) {
                return interfaceC11983l instanceof IntersectionTypeConstructor;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC11983l + ", " + Reflection2.getOrCreateKotlinClass(interfaceC11983l.getClass())).toString());
        }

        public static boolean isMarkedNullable(ClassicTypeSystemContext classicTypeSystemContext, InterfaceC11979h interfaceC11979h) {
            return InterfaceC11987p.a.isMarkedNullable(classicTypeSystemContext, interfaceC11979h);
        }

        public static boolean isNothingConstructor(ClassicTypeSystemContext classicTypeSystemContext, InterfaceC11983l interfaceC11983l) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(interfaceC11983l, "receiver");
            if (interfaceC11983l instanceof TypeConstructor) {
                return KotlinBuiltIns.isTypeConstructorForGivenClass((TypeConstructor) interfaceC11983l, StandardNames.a.f22534c);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC11983l + ", " + Reflection2.getOrCreateKotlinClass(interfaceC11983l.getClass())).toString());
        }

        public static boolean isNullableType(ClassicTypeSystemContext classicTypeSystemContext, InterfaceC11979h interfaceC11979h) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(interfaceC11979h, "receiver");
            if (interfaceC11979h instanceof KotlinType) {
                return TypeUtils.isNullableType((KotlinType) interfaceC11979h);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC11979h + ", " + Reflection2.getOrCreateKotlinClass(interfaceC11979h.getClass())).toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean isPrimitiveType(ClassicTypeSystemContext classicTypeSystemContext, InterfaceC11980i interfaceC11980i) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(interfaceC11980i, "receiver");
            if (interfaceC11980i instanceof KotlinType) {
                return KotlinBuiltIns.isPrimitiveType((KotlinType) interfaceC11980i);
            }
            StringBuilder sbM838Z = outline.m838Z("ClassicTypeSystemContext couldn't handle: ", interfaceC11980i, ", ");
            sbM838Z.append(Reflection2.getOrCreateKotlinClass(interfaceC11980i.getClass()));
            throw new IllegalArgumentException(sbM838Z.toString().toString());
        }

        public static boolean isProjectionNotNull(ClassicTypeSystemContext classicTypeSystemContext, InterfaceC11974c interfaceC11974c) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(interfaceC11974c, "receiver");
            if (interfaceC11974c instanceof NewCapturedType) {
                return ((NewCapturedType) interfaceC11974c).isProjectionNotNull();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC11974c + ", " + Reflection2.getOrCreateKotlinClass(interfaceC11974c.getClass())).toString());
        }

        public static boolean isStarProjection(ClassicTypeSystemContext classicTypeSystemContext, InterfaceC11982k interfaceC11982k) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(interfaceC11982k, "receiver");
            if (interfaceC11982k instanceof TypeProjection) {
                return ((TypeProjection) interfaceC11982k).isStarProjection();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC11982k + ", " + Reflection2.getOrCreateKotlinClass(interfaceC11982k.getClass())).toString());
        }

        public static boolean isStubType(ClassicTypeSystemContext classicTypeSystemContext, InterfaceC11980i interfaceC11980i) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(interfaceC11980i, "receiver");
            if (interfaceC11980i instanceof KotlinType4) {
                return false;
            }
            StringBuilder sbM838Z = outline.m838Z("ClassicTypeSystemContext couldn't handle: ", interfaceC11980i, ", ");
            sbM838Z.append(Reflection2.getOrCreateKotlinClass(interfaceC11980i.getClass()));
            throw new IllegalArgumentException(sbM838Z.toString().toString());
        }

        public static boolean isUnderKotlinPackage(ClassicTypeSystemContext classicTypeSystemContext, InterfaceC11983l interfaceC11983l) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(interfaceC11983l, "receiver");
            if (interfaceC11983l instanceof TypeConstructor) {
                ClassifierDescriptor declarationDescriptor = ((TypeConstructor) interfaceC11983l).getDeclarationDescriptor();
                return Intrinsics3.areEqual(declarationDescriptor == null ? null : Boolean.valueOf(KotlinBuiltIns.isUnderKotlinPackage(declarationDescriptor)), Boolean.TRUE);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC11983l + ", " + Reflection2.getOrCreateKotlinClass(interfaceC11983l.getClass())).toString());
        }

        public static InterfaceC11980i lowerBound(ClassicTypeSystemContext classicTypeSystemContext, InterfaceC11977f interfaceC11977f) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(interfaceC11977f, "receiver");
            if (interfaceC11977f instanceof KotlinType6) {
                return ((KotlinType6) interfaceC11977f).getLowerBound();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC11977f + ", " + Reflection2.getOrCreateKotlinClass(interfaceC11977f.getClass())).toString());
        }

        public static InterfaceC11980i lowerBoundIfFlexible(ClassicTypeSystemContext classicTypeSystemContext, InterfaceC11979h interfaceC11979h) {
            return InterfaceC11987p.a.lowerBoundIfFlexible(classicTypeSystemContext, interfaceC11979h);
        }

        public static InterfaceC11979h lowerType(ClassicTypeSystemContext classicTypeSystemContext, InterfaceC11974c interfaceC11974c) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(interfaceC11974c, "receiver");
            if (interfaceC11974c instanceof NewCapturedType) {
                return ((NewCapturedType) interfaceC11974c).getLowerType();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC11974c + ", " + Reflection2.getOrCreateKotlinClass(interfaceC11974c.getClass())).toString());
        }

        public static InterfaceC11979h makeDefinitelyNotNullOrNotNull(ClassicTypeSystemContext classicTypeSystemContext, InterfaceC11979h interfaceC11979h) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(interfaceC11979h, "receiver");
            if (interfaceC11979h instanceof KotlinType3) {
                return ClassicTypeSystemContext2.access$makeDefinitelyNotNullOrNotNullInternal((KotlinType3) interfaceC11979h);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC11979h + ", " + Reflection2.getOrCreateKotlinClass(interfaceC11979h.getClass())).toString());
        }

        public static InterfaceC11979h makeNullable(ClassicTypeSystemContext classicTypeSystemContext, InterfaceC11979h interfaceC11979h) {
            return TypeSystemCommonBackendContext.a.makeNullable(classicTypeSystemContext, interfaceC11979h);
        }

        public static AbstractTypeChecker3 newBaseTypeCheckerContext(ClassicTypeSystemContext classicTypeSystemContext, boolean z2, boolean z3) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            return new ClassicTypeCheckerContext(z2, z3, false, null, 12, null);
        }

        public static InterfaceC11980i original(ClassicTypeSystemContext classicTypeSystemContext, InterfaceC11975d interfaceC11975d) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(interfaceC11975d, "receiver");
            if (interfaceC11975d instanceof SpecialTypes3) {
                return ((SpecialTypes3) interfaceC11975d).getOriginal();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC11975d + ", " + Reflection2.getOrCreateKotlinClass(interfaceC11975d.getClass())).toString());
        }

        public static int parametersCount(ClassicTypeSystemContext classicTypeSystemContext, InterfaceC11983l interfaceC11983l) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(interfaceC11983l, "receiver");
            if (interfaceC11983l instanceof TypeConstructor) {
                return ((TypeConstructor) interfaceC11983l).getParameters().size();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC11983l + ", " + Reflection2.getOrCreateKotlinClass(interfaceC11983l.getClass())).toString());
        }

        public static Collection<InterfaceC11979h> possibleIntegerTypes(ClassicTypeSystemContext classicTypeSystemContext, InterfaceC11980i interfaceC11980i) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(interfaceC11980i, "receiver");
            InterfaceC11983l interfaceC11983lTypeConstructor = classicTypeSystemContext.typeConstructor(interfaceC11980i);
            if (interfaceC11983lTypeConstructor instanceof IntegerLiteralTypeConstructor) {
                return ((IntegerLiteralTypeConstructor) interfaceC11983lTypeConstructor).getPossibleTypes();
            }
            StringBuilder sbM838Z = outline.m838Z("ClassicTypeSystemContext couldn't handle: ", interfaceC11980i, ", ");
            sbM838Z.append(Reflection2.getOrCreateKotlinClass(interfaceC11980i.getClass()));
            throw new IllegalArgumentException(sbM838Z.toString().toString());
        }

        public static Collection<InterfaceC11979h> supertypes(ClassicTypeSystemContext classicTypeSystemContext, InterfaceC11983l interfaceC11983l) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(interfaceC11983l, "receiver");
            if (interfaceC11983l instanceof TypeConstructor) {
                Collection<KotlinType> supertypes = ((TypeConstructor) interfaceC11983l).getSupertypes();
                Intrinsics3.checkNotNullExpressionValue(supertypes, "this.supertypes");
                return supertypes;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC11983l + ", " + Reflection2.getOrCreateKotlinClass(interfaceC11983l.getClass())).toString());
        }

        public static InterfaceC11983l typeConstructor(ClassicTypeSystemContext classicTypeSystemContext, InterfaceC11979h interfaceC11979h) {
            return InterfaceC11987p.a.typeConstructor(classicTypeSystemContext, interfaceC11979h);
        }

        public static InterfaceC11980i upperBound(ClassicTypeSystemContext classicTypeSystemContext, InterfaceC11977f interfaceC11977f) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(interfaceC11977f, "receiver");
            if (interfaceC11977f instanceof KotlinType6) {
                return ((KotlinType6) interfaceC11977f).getUpperBound();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC11977f + ", " + Reflection2.getOrCreateKotlinClass(interfaceC11977f.getClass())).toString());
        }

        public static InterfaceC11980i upperBoundIfFlexible(ClassicTypeSystemContext classicTypeSystemContext, InterfaceC11979h interfaceC11979h) {
            return InterfaceC11987p.a.upperBoundIfFlexible(classicTypeSystemContext, interfaceC11979h);
        }

        public static InterfaceC11980i withNullability(ClassicTypeSystemContext classicTypeSystemContext, InterfaceC11980i interfaceC11980i, boolean z2) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(interfaceC11980i, "receiver");
            if (interfaceC11980i instanceof KotlinType4) {
                return ((KotlinType4) interfaceC11980i).makeNullableAsSpecified(z2);
            }
            StringBuilder sbM838Z = outline.m838Z("ClassicTypeSystemContext couldn't handle: ", interfaceC11980i, ", ");
            sbM838Z.append(Reflection2.getOrCreateKotlinClass(interfaceC11980i.getClass()));
            throw new IllegalArgumentException(sbM838Z.toString().toString());
        }

        public static boolean isMarkedNullable(ClassicTypeSystemContext classicTypeSystemContext, InterfaceC11980i interfaceC11980i) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(interfaceC11980i, "receiver");
            if (interfaceC11980i instanceof KotlinType4) {
                return ((KotlinType4) interfaceC11980i).isMarkedNullable();
            }
            StringBuilder sbM838Z = outline.m838Z("ClassicTypeSystemContext couldn't handle: ", interfaceC11980i, ", ");
            sbM838Z.append(Reflection2.getOrCreateKotlinClass(interfaceC11980i.getClass()));
            throw new IllegalArgumentException(sbM838Z.toString().toString());
        }

        public static InterfaceC11983l typeConstructor(ClassicTypeSystemContext classicTypeSystemContext, InterfaceC11980i interfaceC11980i) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(interfaceC11980i, "receiver");
            if (interfaceC11980i instanceof KotlinType4) {
                return ((KotlinType4) interfaceC11980i).getConstructor();
            }
            StringBuilder sbM838Z = outline.m838Z("ClassicTypeSystemContext couldn't handle: ", interfaceC11980i, ", ");
            sbM838Z.append(Reflection2.getOrCreateKotlinClass(interfaceC11980i.getClass()));
            throw new IllegalArgumentException(sbM838Z.toString().toString());
        }

        public static EnumC11989r getVariance(ClassicTypeSystemContext classicTypeSystemContext, InterfaceC11984m interfaceC11984m) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(interfaceC11984m, "receiver");
            if (interfaceC11984m instanceof TypeParameterDescriptor) {
                Variance variance = ((TypeParameterDescriptor) interfaceC11984m).getVariance();
                Intrinsics3.checkNotNullExpressionValue(variance, "this.variance");
                return C11986o.convertVariance(variance);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC11984m + ", " + Reflection2.getOrCreateKotlinClass(interfaceC11984m.getClass())).toString());
        }

        public static InterfaceC11979h withNullability(ClassicTypeSystemContext classicTypeSystemContext, InterfaceC11979h interfaceC11979h, boolean z2) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(interfaceC11979h, "receiver");
            if (interfaceC11979h instanceof InterfaceC11980i) {
                return classicTypeSystemContext.withNullability((InterfaceC11980i) interfaceC11979h, z2);
            }
            if (!(interfaceC11979h instanceof InterfaceC11977f)) {
                throw new IllegalStateException("sealed".toString());
            }
            InterfaceC11977f interfaceC11977f = (InterfaceC11977f) interfaceC11979h;
            return classicTypeSystemContext.createFlexibleType(classicTypeSystemContext.withNullability(classicTypeSystemContext.lowerBound(interfaceC11977f), z2), classicTypeSystemContext.withNullability(classicTypeSystemContext.upperBound(interfaceC11977f), z2));
        }
    }

    InterfaceC11980i asSimpleType(InterfaceC11979h interfaceC11979h);

    InterfaceC11979h createFlexibleType(InterfaceC11980i interfaceC11980i, InterfaceC11980i interfaceC11980i2);

    InterfaceC11980i lowerBound(InterfaceC11977f interfaceC11977f);

    InterfaceC11983l typeConstructor(InterfaceC11980i interfaceC11980i);

    InterfaceC11980i upperBound(InterfaceC11977f interfaceC11977f);

    InterfaceC11980i withNullability(InterfaceC11980i interfaceC11980i, boolean z2);
}
