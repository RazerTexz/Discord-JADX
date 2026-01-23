package p630i0;

import java.lang.annotation.Annotation;
import p007b.p100d.p104b.p105a.outline;

/* JADX INFO: renamed from: i0.b0, reason: use source file name */
/* JADX INFO: compiled from: SkipCallbackExecutorImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public final class SkipCallbackExecutorImpl implements SkipCallbackExecutor {

    /* JADX INFO: renamed from: a */
    public static final SkipCallbackExecutor f26482a = new SkipCallbackExecutorImpl();

    @Override // java.lang.annotation.Annotation
    public Class<? extends Annotation> annotationType() {
        return SkipCallbackExecutor.class;
    }

    @Override // java.lang.annotation.Annotation
    public boolean equals(Object obj) {
        return obj instanceof SkipCallbackExecutor;
    }

    @Override // java.lang.annotation.Annotation
    public int hashCode() {
        return 0;
    }

    @Override // java.lang.annotation.Annotation
    public String toString() {
        return outline.m867o(SkipCallbackExecutor.class, outline.m833U("@"), "()");
    }
}
