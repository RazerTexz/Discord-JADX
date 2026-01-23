package com.discord.utilities.views;

import android.view.View;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p592z.p594d.Intrinsics3;
import p659s.p660a.C13116h1;
import p659s.p660a.Dispatchers;
import p659s.p660a.p661a.MainDispatchers;

/* JADX INFO: renamed from: com.discord.utilities.views.ViewCoroutineScopeKt, reason: use source file name */
/* JADX INFO: compiled from: ViewCoroutineScope.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewCoroutineScope {
    private static final int SCOPE_TAG_KEY = -53661613;

    /* JADX WARN: Type inference failed for: r1v4, types: [T, kotlinx.coroutines.CoroutineScope] */
    /* JADX WARN: Type inference failed for: r3v2, types: [T, kotlinx.coroutines.CoroutineScope] */
    public static final CoroutineScope getCoroutineScope(View view) {
        Intrinsics3.checkNotNullParameter(view, "$this$coroutineScope");
        if (!view.isAttachedToWindow()) {
            return null;
        }
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        int i = SCOPE_TAG_KEY;
        Object tag = view.getTag(i);
        if (!(tag instanceof CoroutineScope)) {
            tag = null;
        }
        ?? r3 = (CoroutineScope) tag;
        ref$ObjectRef.element = r3;
        if (((CoroutineScope) r3) != null) {
            return (CoroutineScope) r3;
        }
        Job jobM4279d = C3404f.m4279d(null, 1);
        CoroutineDispatcher coroutineDispatcher = Dispatchers.f27866a;
        ref$ObjectRef.element = C3404f.m4275c(CoroutineContext.Element.C12790a.plus((C13116h1) jobM4279d, MainDispatchers.f27700b.mo11194H()));
        view.getViewTreeObserver().addOnWindowAttachListener(new ViewCoroutineScope2(ref$ObjectRef));
        view.setTag(i, (CoroutineScope) ref$ObjectRef.element);
        return (CoroutineScope) ref$ObjectRef.element;
    }
}
