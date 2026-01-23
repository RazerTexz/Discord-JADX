package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ModuleDescriptor2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.NotFoundClasses;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11677b;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11679d;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11682g;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11684i;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11689n;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11692q;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11694s;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11696u;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.NameResolver;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.ProtoBufUtil;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.SerializerExtensionProtocol;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.ProtoContainer;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p580t.Collections2;
import p507d0.p580t.Iterables2;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.d, reason: use source file name */
/* JADX INFO: compiled from: AnnotationAndConstantLoaderImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AnnotationAndConstantLoaderImpl implements AnnotationAndConstantLoader<AnnotationDescriptor, AbstractC11815g<?>> {

    /* JADX INFO: renamed from: a */
    public final SerializerExtensionProtocol f24513a;

    /* JADX INFO: renamed from: b */
    public final AnnotationDeserializer f24514b;

    public AnnotationAndConstantLoaderImpl(ModuleDescriptor2 moduleDescriptor2, NotFoundClasses notFoundClasses, SerializerExtensionProtocol serializerExtensionProtocol) {
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "module");
        Intrinsics3.checkNotNullParameter(notFoundClasses, "notFoundClasses");
        Intrinsics3.checkNotNullParameter(serializerExtensionProtocol, "protocol");
        this.f24513a = serializerExtensionProtocol;
        this.f24514b = new AnnotationDeserializer(moduleDescriptor2, notFoundClasses);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.AnnotationAndConstantLoader
    public List<AnnotationDescriptor> loadCallableAnnotations(ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
        List listEmptyList;
        Intrinsics3.checkNotNullParameter(protoContainer, "container");
        Intrinsics3.checkNotNullParameter(messageLite, "proto");
        Intrinsics3.checkNotNullParameter(annotatedCallableKind, "kind");
        if (messageLite instanceof C11679d) {
            listEmptyList = (List) ((C11679d) messageLite).getExtension(this.f24513a.getConstructorAnnotation());
        } else if (messageLite instanceof C11684i) {
            listEmptyList = (List) ((C11684i) messageLite).getExtension(this.f24513a.getFunctionAnnotation());
        } else {
            if (!(messageLite instanceof C11689n)) {
                throw new IllegalStateException(Intrinsics3.stringPlus("Unknown message: ", messageLite).toString());
            }
            int iOrdinal = annotatedCallableKind.ordinal();
            if (iOrdinal == 1) {
                listEmptyList = (List) ((C11689n) messageLite).getExtension(this.f24513a.getPropertyAnnotation());
            } else if (iOrdinal == 2) {
                listEmptyList = (List) ((C11689n) messageLite).getExtension(this.f24513a.getPropertyGetterAnnotation());
            } else {
                if (iOrdinal != 3) {
                    throw new IllegalStateException("Unsupported callable kind with property proto".toString());
                }
                listEmptyList = (List) ((C11689n) messageLite).getExtension(this.f24513a.getPropertySetterAnnotation());
            }
        }
        if (listEmptyList == null) {
            listEmptyList = Collections2.emptyList();
        }
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listEmptyList, 10));
        Iterator it = listEmptyList.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f24514b.deserializeAnnotation((C11677b) it.next(), protoContainer.getNameResolver()));
        }
        return arrayList;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.AnnotationAndConstantLoader
    public List<AnnotationDescriptor> loadClassAnnotations(ProtoContainer.a aVar) {
        Intrinsics3.checkNotNullParameter(aVar, "container");
        List listEmptyList = (List) aVar.getClassProto().getExtension(this.f24513a.getClassAnnotation());
        if (listEmptyList == null) {
            listEmptyList = Collections2.emptyList();
        }
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listEmptyList, 10));
        Iterator it = listEmptyList.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f24514b.deserializeAnnotation((C11677b) it.next(), aVar.getNameResolver()));
        }
        return arrayList;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.AnnotationAndConstantLoader
    public List<AnnotationDescriptor> loadEnumEntryAnnotations(ProtoContainer protoContainer, C11682g c11682g) {
        Intrinsics3.checkNotNullParameter(protoContainer, "container");
        Intrinsics3.checkNotNullParameter(c11682g, "proto");
        List listEmptyList = (List) c11682g.getExtension(this.f24513a.getEnumEntryAnnotation());
        if (listEmptyList == null) {
            listEmptyList = Collections2.emptyList();
        }
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listEmptyList, 10));
        Iterator it = listEmptyList.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f24514b.deserializeAnnotation((C11677b) it.next(), protoContainer.getNameResolver()));
        }
        return arrayList;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.AnnotationAndConstantLoader
    public List<AnnotationDescriptor> loadExtensionReceiverParameterAnnotations(ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
        Intrinsics3.checkNotNullParameter(protoContainer, "container");
        Intrinsics3.checkNotNullParameter(messageLite, "proto");
        Intrinsics3.checkNotNullParameter(annotatedCallableKind, "kind");
        return Collections2.emptyList();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.AnnotationAndConstantLoader
    public List<AnnotationDescriptor> loadPropertyBackingFieldAnnotations(ProtoContainer protoContainer, C11689n c11689n) {
        Intrinsics3.checkNotNullParameter(protoContainer, "container");
        Intrinsics3.checkNotNullParameter(c11689n, "proto");
        return Collections2.emptyList();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.AnnotationAndConstantLoader
    public /* bridge */ /* synthetic */ AbstractC11815g<?> loadPropertyConstant(ProtoContainer protoContainer, C11689n c11689n, KotlinType kotlinType) {
        return loadPropertyConstant(protoContainer, c11689n, kotlinType);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.AnnotationAndConstantLoader
    public List<AnnotationDescriptor> loadPropertyDelegateFieldAnnotations(ProtoContainer protoContainer, C11689n c11689n) {
        Intrinsics3.checkNotNullParameter(protoContainer, "container");
        Intrinsics3.checkNotNullParameter(c11689n, "proto");
        return Collections2.emptyList();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.AnnotationAndConstantLoader
    public List<AnnotationDescriptor> loadTypeAnnotations(C11692q c11692q, NameResolver nameResolver) {
        Intrinsics3.checkNotNullParameter(c11692q, "proto");
        Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
        List listEmptyList = (List) c11692q.getExtension(this.f24513a.getTypeAnnotation());
        if (listEmptyList == null) {
            listEmptyList = Collections2.emptyList();
        }
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listEmptyList, 10));
        Iterator it = listEmptyList.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f24514b.deserializeAnnotation((C11677b) it.next(), nameResolver));
        }
        return arrayList;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.AnnotationAndConstantLoader
    public List<AnnotationDescriptor> loadTypeParameterAnnotations(C11694s c11694s, NameResolver nameResolver) {
        Intrinsics3.checkNotNullParameter(c11694s, "proto");
        Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
        List listEmptyList = (List) c11694s.getExtension(this.f24513a.getTypeParameterAnnotation());
        if (listEmptyList == null) {
            listEmptyList = Collections2.emptyList();
        }
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listEmptyList, 10));
        Iterator it = listEmptyList.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f24514b.deserializeAnnotation((C11677b) it.next(), nameResolver));
        }
        return arrayList;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.AnnotationAndConstantLoader
    public List<AnnotationDescriptor> loadValueParameterAnnotations(ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind, int i, C11696u c11696u) {
        Intrinsics3.checkNotNullParameter(protoContainer, "container");
        Intrinsics3.checkNotNullParameter(messageLite, "callableProto");
        Intrinsics3.checkNotNullParameter(annotatedCallableKind, "kind");
        Intrinsics3.checkNotNullParameter(c11696u, "proto");
        List listEmptyList = (List) c11696u.getExtension(this.f24513a.getParameterAnnotation());
        if (listEmptyList == null) {
            listEmptyList = Collections2.emptyList();
        }
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listEmptyList, 10));
        Iterator it = listEmptyList.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f24514b.deserializeAnnotation((C11677b) it.next(), protoContainer.getNameResolver()));
        }
        return arrayList;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.AnnotationAndConstantLoader
    public AbstractC11815g<?> loadPropertyConstant(ProtoContainer protoContainer, C11689n c11689n, KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(protoContainer, "container");
        Intrinsics3.checkNotNullParameter(c11689n, "proto");
        Intrinsics3.checkNotNullParameter(kotlinType, "expectedType");
        C11677b.b.c cVar = (C11677b.b.c) ProtoBufUtil.getExtensionOrNull(c11689n, this.f24513a.getCompileTimeValue());
        if (cVar == null) {
            return null;
        }
        return this.f24514b.resolveValue(kotlinType, cVar, protoContainer.getNameResolver());
    }
}
