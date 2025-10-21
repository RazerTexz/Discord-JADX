package kotlin.reflect;

import d0.e0.KAnnotatedElement;
import d0.e0.KClassifier;
import d0.e0.KTypeProjection;
import java.util.List;

/* compiled from: KType.kt */
/* loaded from: classes3.dex */
public interface KType extends KAnnotatedElement {
    List<KTypeProjection> getArguments();

    KClassifier getClassifier();
}
