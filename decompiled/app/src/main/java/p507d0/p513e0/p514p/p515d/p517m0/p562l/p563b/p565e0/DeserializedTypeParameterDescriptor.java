package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SourceElement;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SupertypeLoopChecker;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractLazyTypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11692q;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11694s;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.protoTypeTableUtil;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.DescriptorUtils2;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.NameResolverUtil;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.ProtoEnumFlags;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.TypeDeserializer;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.context6;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.StorageManager;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p580t.CollectionsJVM;
import p507d0.p580t.Iterables2;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: DeserializedTypeParameterDescriptor.kt */
/* renamed from: d0.e0.p.d.m0.l.b.e0.m, reason: use source file name */
/* loaded from: classes3.dex */
public final class DeserializedTypeParameterDescriptor extends AbstractLazyTypeParameterDescriptor {

    /* renamed from: t */
    public final context6 f24622t;

    /* renamed from: u */
    public final C11694s f24623u;

    /* renamed from: v */
    public final DeserializedAnnotations f24624v;

    /* compiled from: DeserializedTypeParameterDescriptor.kt */
    /* renamed from: d0.e0.p.d.m0.l.b.e0.m$a */
    public static final class a extends Lambda implements Function0<List<? extends AnnotationDescriptor>> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends AnnotationDescriptor> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends AnnotationDescriptor> invoke2() {
            return _Collections.toList(DeserializedTypeParameterDescriptor.access$getC$p(DeserializedTypeParameterDescriptor.this).getComponents().getAnnotationAndConstantLoader().loadTypeParameterAnnotations(DeserializedTypeParameterDescriptor.this.getProto(), DeserializedTypeParameterDescriptor.access$getC$p(DeserializedTypeParameterDescriptor.this).getNameResolver()));
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public DeserializedTypeParameterDescriptor(context6 context6Var, C11694s c11694s, int i) {
        Intrinsics3.checkNotNullParameter(context6Var, "c");
        Intrinsics3.checkNotNullParameter(c11694s, "proto");
        StorageManager storageManager = context6Var.getStorageManager();
        DeclarationDescriptor containingDeclaration = context6Var.getContainingDeclaration();
        Name name = NameResolverUtil.getName(context6Var.getNameResolver(), c11694s.getName());
        ProtoEnumFlags protoEnumFlags = ProtoEnumFlags.f24700a;
        C11694s.c variance = c11694s.getVariance();
        Intrinsics3.checkNotNullExpressionValue(variance, "proto.variance");
        super(storageManager, containingDeclaration, name, protoEnumFlags.variance(variance), c11694s.getReified(), i, SourceElement.f23099a, SupertypeLoopChecker.a.f23103a);
        this.f24622t = context6Var;
        this.f24623u = c11694s;
        this.f24624v = new DeserializedAnnotations(context6Var.getStorageManager(), new a());
    }

    public static final /* synthetic */ context6 access$getC$p(DeserializedTypeParameterDescriptor deserializedTypeParameterDescriptor) {
        return deserializedTypeParameterDescriptor.f24622t;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractTypeParameterDescriptor
    /* renamed from: c */
    public void mo9400c(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "type");
        throw new IllegalStateException(Intrinsics3.stringPlus("There should be no cycles for deserialized type parameters, but found for: ", this));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractTypeParameterDescriptor
    /* renamed from: d */
    public List<KotlinType> mo9401d() {
        List<C11692q> listUpperBounds = protoTypeTableUtil.upperBounds(this.f24623u, this.f24622t.getTypeTable());
        if (listUpperBounds.isEmpty()) {
            return CollectionsJVM.listOf(DescriptorUtils2.getBuiltIns(this).getDefaultBound());
        }
        TypeDeserializer typeDeserializer = this.f24622t.getTypeDeserializer();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listUpperBounds, 10));
        Iterator<T> it = listUpperBounds.iterator();
        while (it.hasNext()) {
            arrayList.add(typeDeserializer.type((C11692q) it.next()));
        }
        return arrayList;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotatedImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations3
    public /* bridge */ /* synthetic */ Annotations4 getAnnotations() {
        return getAnnotations();
    }

    public final C11694s getProto() {
        return this.f24623u;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotatedImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations3
    public DeserializedAnnotations getAnnotations() {
        return this.f24624v;
    }
}
