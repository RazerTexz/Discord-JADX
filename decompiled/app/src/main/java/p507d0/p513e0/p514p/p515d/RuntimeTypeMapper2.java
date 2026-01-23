package p507d0.p513e0.p514p.p515d;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p513e0.p514p.p515d.RuntimeTypeMapper;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibilities;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageFragmentDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.reflectClassUtil;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.JvmAbi;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.JvmPackagePartSource;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11678c;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11689n;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.JvmProtoBuf;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.JvmMemberSignature;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.JvmProtoBufUtil;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.NameResolver;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.ProtoBufUtil;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.TypeTable;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.NameUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedContainerSource2;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberDescriptor4;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.e, reason: use source file name */
/* JADX INFO: compiled from: RuntimeTypeMapper.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class RuntimeTypeMapper2 {

    /* JADX INFO: renamed from: d0.e0.p.d.e$a */
    /* JADX INFO: compiled from: RuntimeTypeMapper.kt */
    public static final class a extends RuntimeTypeMapper2 {

        /* JADX INFO: renamed from: a */
        public final Field f22337a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Field field) {
            super(null);
            Intrinsics3.checkNotNullParameter(field, "field");
            this.f22337a = field;
        }

        @Override // p507d0.p513e0.p514p.p515d.RuntimeTypeMapper2
        public String asString() {
            StringBuilder sb = new StringBuilder();
            String name = this.f22337a.getName();
            Intrinsics3.checkNotNullExpressionValue(name, "field.name");
            sb.append(JvmAbi.getterName(name));
            sb.append("()");
            Class<?> type = this.f22337a.getType();
            Intrinsics3.checkNotNullExpressionValue(type, "field.type");
            sb.append(reflectClassUtil.getDesc(type));
            return sb.toString();
        }

        public final Field getField() {
            return this.f22337a;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.e$b */
    /* JADX INFO: compiled from: RuntimeTypeMapper.kt */
    public static final class b extends RuntimeTypeMapper2 {

        /* JADX INFO: renamed from: a */
        public final Method f22338a;

        /* JADX INFO: renamed from: b */
        public final Method f22339b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Method method, Method method2) {
            super(null);
            Intrinsics3.checkNotNullParameter(method, "getterMethod");
            this.f22338a = method;
            this.f22339b = method2;
        }

        @Override // p507d0.p513e0.p514p.p515d.RuntimeTypeMapper2
        public String asString() {
            return RuntimeTypeMapper5.access$getSignature$p(this.f22338a);
        }

        public final Method getGetterMethod() {
            return this.f22338a;
        }

        public final Method getSetterMethod() {
            return this.f22339b;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.e$c */
    /* JADX INFO: compiled from: RuntimeTypeMapper.kt */
    public static final class c extends RuntimeTypeMapper2 {

        /* JADX INFO: renamed from: a */
        public final String f22340a;

        /* JADX INFO: renamed from: b */
        public final PropertyDescriptor f22341b;

        /* JADX INFO: renamed from: c */
        public final C11689n f22342c;

        /* JADX INFO: renamed from: d */
        public final JvmProtoBuf.d f22343d;

        /* JADX INFO: renamed from: e */
        public final NameResolver f22344e;

        /* JADX INFO: renamed from: f */
        public final TypeTable f22345f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0109  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public c(PropertyDescriptor propertyDescriptor, C11689n c11689n, JvmProtoBuf.d dVar, NameResolver nameResolver, TypeTable typeTable) {
            String string;
            String strM823K;
            super(null);
            Intrinsics3.checkNotNullParameter(propertyDescriptor, "descriptor");
            Intrinsics3.checkNotNullParameter(c11689n, "proto");
            Intrinsics3.checkNotNullParameter(dVar, "signature");
            Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
            Intrinsics3.checkNotNullParameter(typeTable, "typeTable");
            this.f22341b = propertyDescriptor;
            this.f22342c = c11689n;
            this.f22343d = dVar;
            this.f22344e = nameResolver;
            this.f22345f = typeTable;
            if (dVar.hasGetter()) {
                StringBuilder sb = new StringBuilder();
                JvmProtoBuf.c getter = dVar.getGetter();
                Intrinsics3.checkNotNullExpressionValue(getter, "signature.getter");
                sb.append(nameResolver.getString(getter.getName()));
                JvmProtoBuf.c getter2 = dVar.getGetter();
                Intrinsics3.checkNotNullExpressionValue(getter2, "signature.getter");
                sb.append(nameResolver.getString(getter2.getDesc()));
                strM823K = sb.toString();
            } else {
                JvmMemberSignature.a jvmFieldSignature$default = JvmProtoBufUtil.getJvmFieldSignature$default(JvmProtoBufUtil.f23720a, c11689n, nameResolver, typeTable, false, 8, null);
                if (jvmFieldSignature$default == null) {
                    throw new KotlinReflectionInternalError("No field signature for property: " + propertyDescriptor);
                }
                String strComponent1 = jvmFieldSignature$default.component1();
                String strComponent2 = jvmFieldSignature$default.component2();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(JvmAbi.getterName(strComponent1));
                DeclarationDescriptor containingDeclaration = propertyDescriptor.getContainingDeclaration();
                Intrinsics3.checkNotNullExpressionValue(containingDeclaration, "descriptor.containingDeclaration");
                if (Intrinsics3.areEqual(propertyDescriptor.getVisibility(), DescriptorVisibilities.f23086d) && (containingDeclaration instanceof DeserializedClassDescriptor)) {
                    C11678c classProto = ((DeserializedClassDescriptor) containingDeclaration).getClassProto();
                    GeneratedMessageLite.f<C11678c, Integer> fVar = JvmProtoBuf.f23659i;
                    Intrinsics3.checkNotNullExpressionValue(fVar, "JvmProtoBuf.classModuleName");
                    Integer num = (Integer) ProtoBufUtil.getExtensionOrNull(classProto, fVar);
                    String string2 = (num == null || (string2 = nameResolver.getString(num.intValue())) == null) ? "main" : string2;
                    StringBuilder sbM833U = outline.m833U("$");
                    sbM833U.append(NameUtils.sanitizeAsJavaIdentifier(string2));
                    string = sbM833U.toString();
                } else if (Intrinsics3.areEqual(propertyDescriptor.getVisibility(), DescriptorVisibilities.f23083a) && (containingDeclaration instanceof PackageFragmentDescriptor)) {
                    Objects.requireNonNull(propertyDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.descriptors.DeserializedPropertyDescriptor");
                    DeserializedContainerSource2 containerSource = ((DeserializedMemberDescriptor4) propertyDescriptor).getContainerSource();
                    if (containerSource instanceof JvmPackagePartSource) {
                        JvmPackagePartSource jvmPackagePartSource = (JvmPackagePartSource) containerSource;
                        if (jvmPackagePartSource.getFacadeClassName() != null) {
                            StringBuilder sbM833U2 = outline.m833U("$");
                            sbM833U2.append(jvmPackagePartSource.getSimpleName().asString());
                            string = sbM833U2.toString();
                        }
                    }
                } else {
                    string = "";
                }
                strM823K = outline.m823K(sb2, string, "()", strComponent2);
            }
            this.f22340a = strM823K;
        }

        @Override // p507d0.p513e0.p514p.p515d.RuntimeTypeMapper2
        public String asString() {
            return this.f22340a;
        }

        public final PropertyDescriptor getDescriptor() {
            return this.f22341b;
        }

        public final NameResolver getNameResolver() {
            return this.f22344e;
        }

        public final C11689n getProto() {
            return this.f22342c;
        }

        public final JvmProtoBuf.d getSignature() {
            return this.f22343d;
        }

        public final TypeTable getTypeTable() {
            return this.f22345f;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.e$d */
    /* JADX INFO: compiled from: RuntimeTypeMapper.kt */
    public static final class d extends RuntimeTypeMapper2 {

        /* JADX INFO: renamed from: a */
        public final RuntimeTypeMapper.e f22346a;

        /* JADX INFO: renamed from: b */
        public final RuntimeTypeMapper.e f22347b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(RuntimeTypeMapper.e eVar, RuntimeTypeMapper.e eVar2) {
            super(null);
            Intrinsics3.checkNotNullParameter(eVar, "getterSignature");
            this.f22346a = eVar;
            this.f22347b = eVar2;
        }

        @Override // p507d0.p513e0.p514p.p515d.RuntimeTypeMapper2
        public String asString() {
            return this.f22346a.asString();
        }

        public final RuntimeTypeMapper.e getGetterSignature() {
            return this.f22346a;
        }

        public final RuntimeTypeMapper.e getSetterSignature() {
            return this.f22347b;
        }
    }

    public RuntimeTypeMapper2(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public abstract String asString();
}
