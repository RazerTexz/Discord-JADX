package com.facebook.common.references;

import android.graphics.Bitmap;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p109f.p115d.p119d.Closeables;
import p007b.p109f.p115d.p120e.FLog;
import p007b.p109f.p115d.p123h.DefaultCloseableReference;
import p007b.p109f.p115d.p123h.FinalizerCloseableReference;
import p007b.p109f.p115d.p123h.HasBitmap;
import p007b.p109f.p115d.p123h.NoOpCloseableReference;
import p007b.p109f.p115d.p123h.RefCountCloseableReference;
import p007b.p109f.p115d.p123h.ResourceReleaser;

/* loaded from: classes.dex */
public abstract class CloseableReference<T> implements Cloneable, Closeable {

    /* renamed from: j */
    public static Class<CloseableReference> f19438j = CloseableReference.class;

    /* renamed from: k */
    public static int f19439k = 0;

    /* renamed from: l */
    public static final ResourceReleaser<Closeable> f19440l = new C10635a();

    /* renamed from: m */
    public static final InterfaceC10637c f19441m = new C10636b();

    /* renamed from: n */
    public boolean f19442n = false;

    /* renamed from: o */
    public final SharedReference<T> f19443o;

    /* renamed from: p */
    public final InterfaceC10637c f19444p;

    /* renamed from: q */
    public final Throwable f19445q;

    /* renamed from: com.facebook.common.references.CloseableReference$a */
    public static class C10635a implements ResourceReleaser<Closeable> {
        @Override // p007b.p109f.p115d.p123h.ResourceReleaser
        public void release(Closeable closeable) {
            try {
                Closeables.m965a(closeable, true);
            } catch (IOException unused) {
            }
        }
    }

    /* renamed from: com.facebook.common.references.CloseableReference$b */
    public static class C10636b implements InterfaceC10637c {
        @Override // com.facebook.common.references.CloseableReference.InterfaceC10637c
        /* renamed from: a */
        public void mo1252a(SharedReference<Object> sharedReference, Throwable th) {
            Object objM8646c = sharedReference.m8646c();
            Class<CloseableReference> cls = CloseableReference.f19438j;
            Class<CloseableReference> cls2 = CloseableReference.f19438j;
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(System.identityHashCode(this));
            objArr[1] = Integer.valueOf(System.identityHashCode(sharedReference));
            objArr[2] = objM8646c == null ? null : objM8646c.getClass().getName();
            FLog.m985m(cls2, "Finalized without closing: %x %x (type = %s)", objArr);
        }

        @Override // com.facebook.common.references.CloseableReference.InterfaceC10637c
        /* renamed from: b */
        public boolean mo1253b() {
            return false;
        }
    }

    /* renamed from: com.facebook.common.references.CloseableReference$c */
    public interface InterfaceC10637c {
        /* renamed from: a */
        void mo1252a(SharedReference<Object> sharedReference, Throwable th);

        /* renamed from: b */
        boolean mo1253b();
    }

    public CloseableReference(SharedReference<T> sharedReference, InterfaceC10637c interfaceC10637c, Throwable th) {
        Objects.requireNonNull(sharedReference);
        this.f19443o = sharedReference;
        synchronized (sharedReference) {
            sharedReference.m8645b();
            sharedReference.f19448c++;
        }
        this.f19444p = interfaceC10637c;
        this.f19445q = th;
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/io/Closeable;>(TT;)Lcom/facebook/common/references/CloseableReference<TT;>; */
    /* renamed from: A */
    public static CloseableReference m8632A(Closeable closeable) {
        return m8633D(closeable, f19440l);
    }

    /* renamed from: D */
    public static <T> CloseableReference<T> m8633D(T t, ResourceReleaser<T> resourceReleaser) {
        return m8634H(t, resourceReleaser, f19441m);
    }

    /* renamed from: H */
    public static <T> CloseableReference<T> m8634H(T t, ResourceReleaser<T> resourceReleaser, InterfaceC10637c interfaceC10637c) {
        if (t == null) {
            return null;
        }
        return m8635I(t, resourceReleaser, interfaceC10637c, interfaceC10637c.mo1253b() ? new Throwable() : null);
    }

    /* renamed from: I */
    public static <T> CloseableReference<T> m8635I(T t, ResourceReleaser<T> resourceReleaser, InterfaceC10637c interfaceC10637c, Throwable th) {
        if ((t instanceof Bitmap) || (t instanceof HasBitmap)) {
            int i = f19439k;
            if (i == 1) {
                return new FinalizerCloseableReference(t, resourceReleaser, interfaceC10637c, th);
            }
            if (i == 2) {
                return new RefCountCloseableReference(t, resourceReleaser, interfaceC10637c, th);
            }
            if (i == 3) {
                return new NoOpCloseableReference(t, resourceReleaser, interfaceC10637c, th);
            }
        }
        return new DefaultCloseableReference(t, resourceReleaser, interfaceC10637c, th);
    }

    /* renamed from: n */
    public static <T> CloseableReference<T> m8636n(CloseableReference<T> closeableReference) {
        if (closeableReference != null) {
            return closeableReference.m8641f();
        }
        return null;
    }

    /* renamed from: q */
    public static <T> List<CloseableReference<T>> m8637q(Collection<CloseableReference<T>> collection) {
        if (collection == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<CloseableReference<T>> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(m8636n(it.next()));
        }
        return arrayList;
    }

    /* renamed from: s */
    public static void m8638s(CloseableReference<?> closeableReference) {
        if (closeableReference != null) {
            closeableReference.close();
        }
    }

    /* renamed from: t */
    public static void m8639t(Iterable<? extends CloseableReference<?>> iterable) {
        if (iterable != null) {
            for (CloseableReference<?> closeableReference : iterable) {
                if (closeableReference != null) {
                    closeableReference.close();
                }
            }
        }
    }

    /* renamed from: y */
    public static boolean m8640y(CloseableReference<?> closeableReference) {
        return closeableReference != null && closeableReference.m8643x();
    }

    /* renamed from: b */
    public abstract CloseableReference<T> mo999b();

    public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        return mo999b();
    }

    public void close() {
        synchronized (this) {
            if (this.f19442n) {
                return;
            }
            this.f19442n = true;
            this.f19443o.m8644a();
        }
    }

    /* renamed from: f */
    public synchronized CloseableReference<T> m8641f() {
        if (!m8643x()) {
            return null;
        }
        return mo999b();
    }

    /* renamed from: u */
    public synchronized T m8642u() {
        T tM8646c;
        AnimatableValueParser.m419B(!this.f19442n);
        tM8646c = this.f19443o.m8646c();
        Objects.requireNonNull(tM8646c);
        return tM8646c;
    }

    /* renamed from: x */
    public synchronized boolean m8643x() {
        return !this.f19442n;
    }

    public CloseableReference(T t, ResourceReleaser<T> resourceReleaser, InterfaceC10637c interfaceC10637c, Throwable th) {
        this.f19443o = new SharedReference<>(t, resourceReleaser);
        this.f19444p = interfaceC10637c;
        this.f19445q = th;
    }
}
