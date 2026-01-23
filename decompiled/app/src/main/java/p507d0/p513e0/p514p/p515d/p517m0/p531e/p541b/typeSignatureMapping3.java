package p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b;

import p507d0.p513e0.p514p.p515d.p517m0.p518b.PrimitiveType;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.l, reason: use source file name */
/* JADX INFO: compiled from: typeSignatureMapping.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface typeSignatureMapping3<T> {
    T boxType(T t);

    T createFromString(String str);

    T createObjectType(String str);

    T createPrimitiveType(PrimitiveType primitiveType);

    T getJavaLangClassType();

    String toString(T t);
}
