package com.discord.utilities.views;

import android.view.ViewTreeObserver;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: com.discord.utilities.views.ViewCoroutineScopeKt$coroutineScope$1, reason: use source file name */
/* JADX INFO: compiled from: ViewCoroutineScope.kt */
/* JADX INFO: loaded from: classes2.dex */
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
        C3404f.m4335r((CoroutineScope) this.$scope.element, new CancellationException("view detached from window"));
    }
}
