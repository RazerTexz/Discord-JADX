package com.discord.utilities.views;

import android.view.ViewTreeObserver;
import b.i.a.f.e.o.f;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ViewCoroutineScope.kt */
/* renamed from: com.discord.utilities.views.ViewCoroutineScopeKt$coroutineScope$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class ViewCoroutineScope2 implements ViewTreeObserver.OnWindowAttachListener {
    public final /* synthetic */ Ref$ObjectRef $scope;

    public ViewCoroutineScope2(Ref$ObjectRef ref$ObjectRef) {
        this.$scope = ref$ObjectRef;
    }

    @Override // android.view.ViewTreeObserver.OnWindowAttachListener
    public void onWindowAttached() {
    }

    @Override // android.view.ViewTreeObserver.OnWindowAttachListener
    public void onWindowDetached() {
        f.r((CoroutineScope) this.$scope.element, new CancellationException("view detached from window"));
    }
}
