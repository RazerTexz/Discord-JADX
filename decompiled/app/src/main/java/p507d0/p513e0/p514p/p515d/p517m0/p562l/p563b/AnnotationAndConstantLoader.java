package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b;

import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11682g;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11689n;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11692q;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11694s;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11696u;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.NameResolver;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.ProtoContainer;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.c, reason: use source file name */
/* JADX INFO: compiled from: AnnotationAndConstantLoader.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface AnnotationAndConstantLoader<A, C> {
    List<A> loadCallableAnnotations(ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind);

    List<A> loadClassAnnotations(ProtoContainer.a aVar);

    List<A> loadEnumEntryAnnotations(ProtoContainer protoContainer, C11682g c11682g);

    List<A> loadExtensionReceiverParameterAnnotations(ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind);

    List<A> loadPropertyBackingFieldAnnotations(ProtoContainer protoContainer, C11689n c11689n);

    C loadPropertyConstant(ProtoContainer protoContainer, C11689n c11689n, KotlinType kotlinType);

    List<A> loadPropertyDelegateFieldAnnotations(ProtoContainer protoContainer, C11689n c11689n);

    List<A> loadTypeAnnotations(C11692q c11692q, NameResolver nameResolver);

    List<A> loadTypeParameterAnnotations(C11694s c11694s, NameResolver nameResolver);

    List<A> loadValueParameterAnnotations(ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind, int i, C11696u c11696u);
}
