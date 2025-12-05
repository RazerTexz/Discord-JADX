package kotlin.reflect;

import java.util.List;
import p507d0.p513e0.KAnnotatedElement;
import p507d0.p513e0.KClassifier;
import p507d0.p513e0.KTypeProjection;

/* compiled from: KType.kt */
/* loaded from: classes3.dex */
public interface KType extends KAnnotatedElement {
    List<KTypeProjection> getArguments();

    KClassifier getClassifier();
}
