package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Tuples2;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p512d0._Ranges;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.KotlinBuiltIns;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassConstructorDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ModuleDescriptor2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.NotFoundClasses;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SourceElement;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ValueParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.findClassInModule;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotationDescriptorImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11677b;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.Flags2;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.NameResolver;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.DescriptorUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11819k;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11807a;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11808a0;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11809b;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11811c;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11812d;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11813e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11817i;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11818j;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11820l;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11821m;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11826r;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11827s;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11830v;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11831w;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11832x;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11833y;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11834z;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.ConstantValueFactory;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.ErrorUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4;
import p507d0.p580t.Collections2;
import p507d0.p580t.Iterables2;
import p507d0.p580t.Iterators4;
import p507d0.p580t.Maps6;
import p507d0.p580t.MapsJVM;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e, reason: use source file name */
/* JADX INFO: compiled from: AnnotationDeserializer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AnnotationDeserializer {

    /* JADX INFO: renamed from: a */
    public final ModuleDescriptor2 f24518a;

    /* JADX INFO: renamed from: b */
    public final NotFoundClasses f24519b;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e$a */
    /* JADX INFO: compiled from: AnnotationDeserializer.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a */
        public static final /* synthetic */ int[] f24520a;

        static {
            C11677b.b.c.EnumC13321c.values();
            f24520a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        }
    }

    public AnnotationDeserializer(ModuleDescriptor2 moduleDescriptor2, NotFoundClasses notFoundClasses) {
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "module");
        Intrinsics3.checkNotNullParameter(notFoundClasses, "notFoundClasses");
        this.f24518a = moduleDescriptor2;
        this.f24519b = notFoundClasses;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m9952a(AbstractC11815g<?> abstractC11815g, KotlinType kotlinType, C11677b.b.c cVar) {
        C11677b.b.c.EnumC13321c type = cVar.getType();
        int i = type == null ? -1 : a.f24520a[type.ordinal()];
        if (i != 10) {
            if (i != 13) {
                return Intrinsics3.areEqual(abstractC11815g.getType(this.f24518a), kotlinType);
            }
            if (!((abstractC11815g instanceof C11809b) && ((C11809b) abstractC11815g).getValue().size() == cVar.getArrayElementList().size())) {
                throw new IllegalStateException(Intrinsics3.stringPlus("Deserialized ArrayValue should have the same number of elements as the original array value: ", abstractC11815g).toString());
            }
            KotlinType arrayElementType = this.f24518a.getBuiltIns().getArrayElementType(kotlinType);
            Intrinsics3.checkNotNullExpressionValue(arrayElementType, "builtIns.getArrayElementType(expectedType)");
            C11809b c11809b = (C11809b) abstractC11815g;
            Iterable indices = Collections2.getIndices(c11809b.getValue());
            if ((indices instanceof Collection) && ((Collection) indices).isEmpty()) {
                return true;
            }
            Iterator it = indices.iterator();
            while (it.hasNext()) {
                int iNextInt = ((Iterators4) it).nextInt();
                AbstractC11815g<?> abstractC11815g2 = c11809b.getValue().get(iNextInt);
                C11677b.b.c arrayElement = cVar.getArrayElement(iNextInt);
                Intrinsics3.checkNotNullExpressionValue(arrayElement, "value.getArrayElement(i)");
                if (!m9952a(abstractC11815g2, arrayElementType, arrayElement)) {
                }
            }
            return true;
        }
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        ClassDescriptor classDescriptor = declarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) declarationDescriptor : null;
        if (classDescriptor == null || KotlinBuiltIns.isKClass(classDescriptor)) {
            return true;
        }
        return false;
    }

    public final AnnotationDescriptor deserializeAnnotation(C11677b c11677b, NameResolver nameResolver) {
        Intrinsics3.checkNotNullParameter(c11677b, "proto");
        Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
        ClassDescriptor classDescriptorFindNonGenericClassAcrossDependencies = findClassInModule.findNonGenericClassAcrossDependencies(this.f24518a, NameResolverUtil.getClassId(nameResolver, c11677b.getId()), this.f24519b);
        Map mapEmptyMap = Maps6.emptyMap();
        if (c11677b.getArgumentCount() != 0 && !ErrorUtils.isError(classDescriptorFindNonGenericClassAcrossDependencies) && DescriptorUtils.isAnnotationClass(classDescriptorFindNonGenericClassAcrossDependencies)) {
            Collection<ClassConstructorDescriptor> constructors = classDescriptorFindNonGenericClassAcrossDependencies.getConstructors();
            Intrinsics3.checkNotNullExpressionValue(constructors, "annotationClass.constructors");
            ClassConstructorDescriptor classConstructorDescriptor = (ClassConstructorDescriptor) _Collections.singleOrNull(constructors);
            if (classConstructorDescriptor != null) {
                List<ValueParameterDescriptor> valueParameters = classConstructorDescriptor.getValueParameters();
                Intrinsics3.checkNotNullExpressionValue(valueParameters, "constructor.valueParameters");
                LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(valueParameters, 10)), 16));
                for (Object obj : valueParameters) {
                    linkedHashMap.put(((ValueParameterDescriptor) obj).getName(), obj);
                }
                List<C11677b.b> argumentList = c11677b.getArgumentList();
                ArrayList arrayListM840a0 = outline.m840a0(argumentList, "proto.argumentList");
                for (C11677b.b bVar : argumentList) {
                    Intrinsics3.checkNotNullExpressionValue(bVar, "it");
                    ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) linkedHashMap.get(NameResolverUtil.getName(nameResolver, bVar.getNameId()));
                    if (valueParameterDescriptor != null) {
                        Name name = NameResolverUtil.getName(nameResolver, bVar.getNameId());
                        KotlinType type = valueParameterDescriptor.getType();
                        Intrinsics3.checkNotNullExpressionValue(type, "parameter.type");
                        C11677b.b.c value = bVar.getValue();
                        Intrinsics3.checkNotNullExpressionValue(value, "proto.value");
                        AbstractC11815g<?> abstractC11815gResolveValue = resolveValue(type, value, nameResolver);
                        tuples2 = m9952a(abstractC11815gResolveValue, type, value) ? abstractC11815gResolveValue : null;
                        if (tuples2 == null) {
                            AbstractC11819k.a aVar = AbstractC11819k.f24442b;
                            StringBuilder sbM833U = outline.m833U("Unexpected argument value: actual type ");
                            sbM833U.append(value.getType());
                            sbM833U.append(" != expected type ");
                            sbM833U.append(type);
                            tuples2 = aVar.create(sbM833U.toString());
                        }
                        tuples2 = new Tuples2(name, tuples2);
                    }
                    if (tuples2 != null) {
                        arrayListM840a0.add(tuples2);
                    }
                }
                mapEmptyMap = Maps6.toMap(arrayListM840a0);
            }
        }
        return new AnnotationDescriptorImpl(classDescriptorFindNonGenericClassAcrossDependencies.getDefaultType(), mapEmptyMap, SourceElement.f23099a);
    }

    public final AbstractC11815g<?> resolveValue(KotlinType kotlinType, C11677b.b.c cVar, NameResolver nameResolver) {
        AbstractC11815g<?> c11832x;
        Intrinsics3.checkNotNullParameter(kotlinType, "expectedType");
        Intrinsics3.checkNotNullParameter(cVar, "value");
        Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
        Boolean bool = Flags2.f24029M.get(cVar.getFlags());
        Intrinsics3.checkNotNullExpressionValue(bool, "IS_UNSIGNED.get(value.flags)");
        boolean zBooleanValue = bool.booleanValue();
        C11677b.b.c.EnumC13321c type = cVar.getType();
        switch (type == null ? -1 : a.f24520a[type.ordinal()]) {
            case 1:
                byte intValue = (byte) cVar.getIntValue();
                c11832x = zBooleanValue ? new C11832x(intValue) : new C11812d(intValue);
                break;
            case 2:
                return new C11813e((char) cVar.getIntValue());
            case 3:
                short intValue2 = (short) cVar.getIntValue();
                c11832x = zBooleanValue ? new C11808a0(intValue2) : new C11830v(intValue2);
                break;
            case 4:
                int intValue3 = (int) cVar.getIntValue();
                return zBooleanValue ? new C11833y(intValue3) : new C11821m(intValue3);
            case 5:
                long intValue4 = cVar.getIntValue();
                return zBooleanValue ? new C11834z(intValue4) : new C11827s(intValue4);
            case 6:
                return new C11820l(cVar.getFloatValue());
            case 7:
                return new C11817i(cVar.getDoubleValue());
            case 8:
                return new C11811c(cVar.getIntValue() != 0);
            case 9:
                return new C11831w(nameResolver.getString(cVar.getStringValue()));
            case 10:
                return new C11826r(NameResolverUtil.getClassId(nameResolver, cVar.getClassId()), cVar.getArrayDimensionCount());
            case 11:
                return new C11818j(NameResolverUtil.getClassId(nameResolver, cVar.getClassId()), NameResolverUtil.getName(nameResolver, cVar.getEnumValueId()));
            case 12:
                C11677b annotation = cVar.getAnnotation();
                Intrinsics3.checkNotNullExpressionValue(annotation, "value.annotation");
                return new C11807a(deserializeAnnotation(annotation, nameResolver));
            case 13:
                ConstantValueFactory constantValueFactory = ConstantValueFactory.f24439a;
                List<C11677b.b.c> arrayElementList = cVar.getArrayElementList();
                Intrinsics3.checkNotNullExpressionValue(arrayElementList, "value.arrayElementList");
                ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(arrayElementList, 10));
                for (C11677b.b.c cVar2 : arrayElementList) {
                    KotlinType4 anyType = this.f24518a.getBuiltIns().getAnyType();
                    Intrinsics3.checkNotNullExpressionValue(anyType, "builtIns.anyType");
                    Intrinsics3.checkNotNullExpressionValue(cVar2, "it");
                    arrayList.add(resolveValue(anyType, cVar2, nameResolver));
                }
                return constantValueFactory.createArrayValue(arrayList, kotlinType);
            default:
                StringBuilder sbM833U = outline.m833U("Unsupported annotation argument type: ");
                sbM833U.append(cVar.getType());
                sbM833U.append(" (expected ");
                sbM833U.append(kotlinType);
                sbM833U.append(')');
                throw new IllegalStateException(sbM833U.toString().toString());
        }
        return c11832x;
    }
}
