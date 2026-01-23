package p659s.p660a.p661a;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlinx.coroutines.CoroutineDispatcher;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p659s.p660a.AbstractC13142q0;
import p659s.p660a.C13161w1;
import p659s.p660a.CompletionState3;
import p659s.p660a.DispatchedTask;

/* JADX INFO: renamed from: s.a.a.g, reason: use source file name */
/* JADX INFO: compiled from: DispatchedContinuation.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DispatchedContinuation<T> extends DispatchedTask<T> implements CoroutineStackFrame, Continuation<T> {

    /* JADX INFO: renamed from: m */
    public static final AtomicReferenceFieldUpdater f27675m = AtomicReferenceFieldUpdater.newUpdater(DispatchedContinuation.class, Object.class, "_reusableCancellableContinuation");
    public volatile Object _reusableCancellableContinuation;

    /* JADX INFO: renamed from: n */
    public Object f27676n;

    /* JADX INFO: renamed from: o */
    public final CoroutineStackFrame f27677o;

    /* JADX INFO: renamed from: p */
    public final Object f27678p;

    /* JADX INFO: renamed from: q */
    public final CoroutineDispatcher f27679q;

    /* JADX INFO: renamed from: r */
    public final Continuation<T> f27680r;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [kotlin.coroutines.Continuation<? super T>, kotlin.coroutines.Continuation<T>] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type kotlin.coroutines.Continuation<? super T> to ?? for r4v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.instructions.args.InsnArg.wrapInstruction(InsnArg.java:138)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.inline(CodeShrinkVisitor.java:213)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:143)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:68)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:48)
        	at jadx.core.dex.visitors.regions.TernaryMod.replaceWithTernary(TernaryMod.java:347)
        	at jadx.core.dex.visitors.regions.TernaryMod.processOneBranchTernary(TernaryMod.java:273)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:77)
        	at jadx.core.dex.visitors.regions.TernaryMod.processRegion(TernaryMod.java:62)
        	at jadx.core.dex.visitors.regions.TernaryMod.enterRegion(TernaryMod.java:45)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:67)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.TernaryMod.process(TernaryMod.java:35)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.process(IfRegionVisitor.java:44)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:30)
        */
    public DispatchedContinuation(kotlinx.coroutines.CoroutineDispatcher r3, kotlin.coroutines.Continuation<? super T> r4) {
        /*
            r2 = this;
            r0 = -1
            r2.<init>(r0)
            r2.f27679q = r3
            r2.f27680r = r4
            s.a.a.t r3 = p659s.p660a.p661a.DispatchedContinuation2.f27681a
            r2.f27676n = r3
            boolean r3 = r4 instanceof kotlin.coroutines.jvm.internal.CoroutineStackFrame
            r0 = 0
            if (r3 != 0) goto L12
            r4 = r0
        L12:
            kotlin.coroutines.jvm.internal.CoroutineStackFrame r4 = (kotlin.coroutines.jvm.internal.CoroutineStackFrame) r4
            r2.f27677o = r4
            kotlin.coroutines.CoroutineContext r3 = r2.getContext()
            r4 = 0
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            kotlin.jvm.functions.Function2<java.lang.Object, kotlin.coroutines.CoroutineContext$Element, java.lang.Object> r1 = p659s.p660a.p661a.ThreadContext.f27659b
            java.lang.Object r3 = r3.fold(r4, r1)
            p507d0.p592z.p594d.Intrinsics3.checkNotNull(r3)
            r2.f27678p = r3
            r2._reusableCancellableContinuation = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p659s.p660a.p661a.DispatchedContinuation.<init>(kotlinx.coroutines.CoroutineDispatcher, kotlin.coroutines.Continuation):void");
    }

    @Override // p659s.p660a.DispatchedTask
    /* JADX INFO: renamed from: b */
    public void mo11145b(Object obj, Throwable th) {
        if (obj instanceof CompletionState3) {
            ((CompletionState3) obj).f27918b.invoke(th);
        }
    }

    @Override // p659s.p660a.DispatchedTask
    /* JADX INFO: renamed from: d */
    public Continuation<T> mo11146d() {
        return this;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.f27680r.getContext();
    }

    @Override // p659s.p660a.DispatchedTask
    /* JADX INFO: renamed from: m */
    public Object mo11147m() {
        Object obj = this.f27676n;
        this.f27676n = DispatchedContinuation2.f27681a;
        return obj;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        CoroutineContext context;
        Object objM11141b;
        CoroutineContext context2 = this.f27680r.getContext();
        Object objM4353v1 = C3404f.m4353v1(obj, null);
        if (this.f27679q.isDispatchNeeded(context2)) {
            this.f27676n = objM4353v1;
            this.f27864l = 0;
            this.f27679q.dispatch(context2, this);
            return;
        }
        C13161w1 c13161w1 = C13161w1.f27916b;
        AbstractC13142q0 abstractC13142q0M11353a = C13161w1.m11353a();
        if (abstractC13142q0M11353a.m11338N()) {
            this.f27676n = objM4353v1;
            this.f27864l = 0;
            abstractC13142q0M11353a.m11336J(this);
            return;
        }
        abstractC13142q0M11353a.m11337L(true);
        try {
            context = getContext();
            objM11141b = ThreadContext.m11141b(context, this.f27678p);
        } finally {
            try {
            } finally {
            }
        }
        try {
            this.f27680r.resumeWith(obj);
            while (abstractC13142q0M11353a.m11340R()) {
            }
        } finally {
            ThreadContext.m11140a(context, objM11141b);
        }
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("DispatchedContinuation[");
        sbM833U.append(this.f27679q);
        sbM833U.append(", ");
        sbM833U.append(C3404f.m4341s1(this.f27680r));
        sbM833U.append(']');
        return sbM833U.toString();
    }
}
