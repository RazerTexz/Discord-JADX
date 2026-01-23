package p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ModuleDescriptor2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.NotFoundClasses;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SourceElement;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ValueParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.findClassInModule;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotationDescriptorImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p533g0.DescriptorResolverUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinJvmBinaryClass;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11819k;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11807a;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11818j;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11826r;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.ClassLiteralValue;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.ConstantValueFactory;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.AnnotationDeserializer;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.StorageManager;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.collections;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.c, reason: use source file name */
/* JADX INFO: compiled from: BinaryClassAnnotationAndConstantLoaderImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class BinaryClassAnnotationAndConstantLoaderImpl extends AbstractBinaryClassAnnotationAndConstantLoader<AnnotationDescriptor, AbstractC11815g<?>> {

    /* JADX INFO: renamed from: c */
    public final ModuleDescriptor2 f23585c;

    /* JADX INFO: renamed from: d */
    public final NotFoundClasses f23586d;

    /* JADX INFO: renamed from: e */
    public final AnnotationDeserializer f23587e;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.c$a */
    /* JADX INFO: compiled from: BinaryClassAnnotationAndConstantLoaderImpl.kt */
    public static final class a implements KotlinJvmBinaryClass.a {

        /* JADX INFO: renamed from: a */
        public final HashMap<Name, AbstractC11815g<?>> f23588a = new HashMap<>();

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ ClassDescriptor f23589b;

        /* JADX INFO: renamed from: c */
        public final /* synthetic */ BinaryClassAnnotationAndConstantLoaderImpl f23590c;

        /* JADX INFO: renamed from: d */
        public final /* synthetic */ List<AnnotationDescriptor> f23591d;

        /* JADX INFO: renamed from: e */
        public final /* synthetic */ SourceElement f23592e;

        /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: BinaryClassAnnotationAndConstantLoaderImpl.kt */
        public static final class C13315a implements KotlinJvmBinaryClass.a {

            /* JADX INFO: renamed from: a */
            public final /* synthetic */ KotlinJvmBinaryClass.a f23593a;

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ KotlinJvmBinaryClass.a f23594b;

            /* JADX INFO: renamed from: c */
            public final /* synthetic */ a f23595c;

            /* JADX INFO: renamed from: d */
            public final /* synthetic */ Name f23596d;

            /* JADX INFO: renamed from: e */
            public final /* synthetic */ ArrayList<AnnotationDescriptor> f23597e;

            public C13315a(KotlinJvmBinaryClass.a aVar, a aVar2, Name name, ArrayList<AnnotationDescriptor> arrayList) {
                this.f23594b = aVar;
                this.f23595c = aVar2;
                this.f23596d = name;
                this.f23597e = arrayList;
                this.f23593a = aVar;
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinJvmBinaryClass.a
            public void visit(Name name, Object obj) {
                this.f23593a.visit(name, obj);
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinJvmBinaryClass.a
            public KotlinJvmBinaryClass.a visitAnnotation(Name name, ClassId classId) {
                Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
                Intrinsics3.checkNotNullParameter(classId, "classId");
                return this.f23593a.visitAnnotation(name, classId);
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinJvmBinaryClass.a
            public KotlinJvmBinaryClass.b visitArray(Name name) {
                Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
                return this.f23593a.visitArray(name);
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinJvmBinaryClass.a
            public void visitClassLiteral(Name name, ClassLiteralValue classLiteralValue) {
                Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
                Intrinsics3.checkNotNullParameter(classLiteralValue, "value");
                this.f23593a.visitClassLiteral(name, classLiteralValue);
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinJvmBinaryClass.a
            public void visitEnd() {
                this.f23594b.visitEnd();
                a.access$getArguments$p(this.f23595c).put(this.f23596d, new C11807a((AnnotationDescriptor) _Collections.single((List) this.f23597e)));
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinJvmBinaryClass.a
            public void visitEnum(Name name, ClassId classId, Name name2) {
                Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
                Intrinsics3.checkNotNullParameter(classId, "enumClassId");
                Intrinsics3.checkNotNullParameter(name2, "enumEntryName");
                this.f23593a.visitEnum(name, classId, name2);
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.c$a$b */
        /* JADX INFO: compiled from: BinaryClassAnnotationAndConstantLoaderImpl.kt */
        public static final class b implements KotlinJvmBinaryClass.b {

            /* JADX INFO: renamed from: a */
            public final ArrayList<AbstractC11815g<?>> f23598a = new ArrayList<>();

            /* JADX INFO: renamed from: c */
            public final /* synthetic */ Name f23600c;

            /* JADX INFO: renamed from: d */
            public final /* synthetic */ ClassDescriptor f23601d;

            public b(Name name, ClassDescriptor classDescriptor) {
                this.f23600c = name;
                this.f23601d = classDescriptor;
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinJvmBinaryClass.b
            public void visit(Object obj) {
                this.f23598a.add(a.access$createConstant(a.this, this.f23600c, obj));
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinJvmBinaryClass.b
            public void visitClassLiteral(ClassLiteralValue classLiteralValue) {
                Intrinsics3.checkNotNullParameter(classLiteralValue, "value");
                this.f23598a.add(new C11826r(classLiteralValue));
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinJvmBinaryClass.b
            public void visitEnd() {
                ValueParameterDescriptor annotationParameterByName = DescriptorResolverUtils.getAnnotationParameterByName(this.f23600c, this.f23601d);
                if (annotationParameterByName != null) {
                    HashMap mapAccess$getArguments$p = a.access$getArguments$p(a.this);
                    Name name = this.f23600c;
                    ConstantValueFactory constantValueFactory = ConstantValueFactory.f24439a;
                    List<? extends AbstractC11815g<?>> listCompact = collections.compact(this.f23598a);
                    KotlinType type = annotationParameterByName.getType();
                    Intrinsics3.checkNotNullExpressionValue(type, "parameter.type");
                    mapAccess$getArguments$p.put(name, constantValueFactory.createArrayValue(listCompact, type));
                }
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinJvmBinaryClass.b
            public void visitEnum(ClassId classId, Name name) {
                Intrinsics3.checkNotNullParameter(classId, "enumClassId");
                Intrinsics3.checkNotNullParameter(name, "enumEntryName");
                this.f23598a.add(new C11818j(classId, name));
            }
        }

        public a(ClassDescriptor classDescriptor, BinaryClassAnnotationAndConstantLoaderImpl binaryClassAnnotationAndConstantLoaderImpl, List<AnnotationDescriptor> list, SourceElement sourceElement) {
            this.f23589b = classDescriptor;
            this.f23590c = binaryClassAnnotationAndConstantLoaderImpl;
            this.f23591d = list;
            this.f23592e = sourceElement;
        }

        public static final /* synthetic */ AbstractC11815g access$createConstant(a aVar, Name name, Object obj) {
            return aVar.m9544a(name, obj);
        }

        public static final /* synthetic */ HashMap access$getArguments$p(a aVar) {
            return aVar.f23588a;
        }

        /* JADX INFO: renamed from: a */
        public final AbstractC11815g<?> m9544a(Name name, Object obj) {
            AbstractC11815g<?> abstractC11815gCreateConstantValue = ConstantValueFactory.f24439a.createConstantValue(obj);
            return abstractC11815gCreateConstantValue == null ? AbstractC11819k.f24442b.create(Intrinsics3.stringPlus("Unsupported annotation argument: ", name)) : abstractC11815gCreateConstantValue;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinJvmBinaryClass.a
        public void visit(Name name, Object obj) {
            if (name != null) {
                this.f23588a.put(name, m9544a(name, obj));
            }
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinJvmBinaryClass.a
        public KotlinJvmBinaryClass.a visitAnnotation(Name name, ClassId classId) {
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(classId, "classId");
            ArrayList arrayList = new ArrayList();
            BinaryClassAnnotationAndConstantLoaderImpl binaryClassAnnotationAndConstantLoaderImpl = this.f23590c;
            SourceElement sourceElement = SourceElement.f23099a;
            Intrinsics3.checkNotNullExpressionValue(sourceElement, "NO_SOURCE");
            KotlinJvmBinaryClass.a aVarMo9535h = binaryClassAnnotationAndConstantLoaderImpl.mo9535h(classId, sourceElement, arrayList);
            Intrinsics3.checkNotNull(aVarMo9535h);
            return new C13315a(aVarMo9535h, this, name, arrayList);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinJvmBinaryClass.a
        public KotlinJvmBinaryClass.b visitArray(Name name) {
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            return new b(name, this.f23589b);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinJvmBinaryClass.a
        public void visitClassLiteral(Name name, ClassLiteralValue classLiteralValue) {
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(classLiteralValue, "value");
            this.f23588a.put(name, new C11826r(classLiteralValue));
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinJvmBinaryClass.a
        public void visitEnd() {
            this.f23591d.add(new AnnotationDescriptorImpl(this.f23589b.getDefaultType(), this.f23588a, this.f23592e));
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinJvmBinaryClass.a
        public void visitEnum(Name name, ClassId classId, Name name2) {
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(classId, "enumClassId");
            Intrinsics3.checkNotNullParameter(name2, "enumEntryName");
            this.f23588a.put(name, new C11818j(classId, name2));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BinaryClassAnnotationAndConstantLoaderImpl(ModuleDescriptor2 moduleDescriptor2, NotFoundClasses notFoundClasses, StorageManager storageManager, KotlinClassFinder kotlinClassFinder) {
        super(storageManager, kotlinClassFinder);
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "module");
        Intrinsics3.checkNotNullParameter(notFoundClasses, "notFoundClasses");
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(kotlinClassFinder, "kotlinClassFinder");
        this.f23585c = moduleDescriptor2;
        this.f23586d = notFoundClasses;
        this.f23587e = new AnnotationDeserializer(moduleDescriptor2, notFoundClasses);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.AbstractBinaryClassAnnotationAndConstantLoader
    /* JADX INFO: renamed from: h */
    public KotlinJvmBinaryClass.a mo9535h(ClassId classId, SourceElement sourceElement, List<AnnotationDescriptor> list) {
        Intrinsics3.checkNotNullParameter(classId, "annotationClassId");
        Intrinsics3.checkNotNullParameter(sourceElement, "source");
        Intrinsics3.checkNotNullParameter(list, "result");
        return new a(findClassInModule.findNonGenericClassAcrossDependencies(this.f23585c, classId, this.f23586d), this, list, sourceElement);
    }
}
