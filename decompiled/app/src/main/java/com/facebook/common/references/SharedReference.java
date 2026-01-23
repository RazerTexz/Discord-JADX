package com.facebook.common.references;

import android.graphics.Bitmap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p109f.p115d.p120e.FLog;
import p007b.p109f.p115d.p123h.HasBitmap;
import p007b.p109f.p115d.p123h.ResourceReleaser;

/* JADX INFO: loaded from: classes.dex */
public class SharedReference<T> {

    /* JADX INFO: renamed from: a */
    public static final Map<Object, Integer> f19446a = new IdentityHashMap();

    /* JADX INFO: renamed from: b */
    public T f19447b;

    /* JADX INFO: renamed from: c */
    public int f19448c;

    /* JADX INFO: renamed from: d */
    public final ResourceReleaser<T> f19449d;

    public static class NullReferenceException extends RuntimeException {
        public NullReferenceException() {
            super("Null shared reference");
        }
    }

    public SharedReference(T t, ResourceReleaser<T> resourceReleaser) {
        Objects.requireNonNull(t);
        this.f19447b = t;
        Objects.requireNonNull(resourceReleaser);
        this.f19449d = resourceReleaser;
        this.f19448c = 1;
        if ((CloseableReference.f19439k == 3) && ((t instanceof Bitmap) || (t instanceof HasBitmap))) {
            return;
        }
        Map<Object, Integer> map = f19446a;
        synchronized (map) {
            Integer num = map.get(t);
            if (num == null) {
                map.put(t, 1);
            } else {
                map.put(t, Integer.valueOf(num.intValue() + 1));
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m8644a() {
        int i;
        T t;
        synchronized (this) {
            m8645b();
            AnimatableValueParser.m527i(Boolean.valueOf(this.f19448c > 0));
            i = this.f19448c - 1;
            this.f19448c = i;
        }
        if (i == 0) {
            synchronized (this) {
                t = this.f19447b;
                this.f19447b = null;
            }
            if (t != null) {
                this.f19449d.release(t);
                Map<Object, Integer> map = f19446a;
                synchronized (map) {
                    Integer num = map.get(t);
                    if (num == null) {
                        FLog.m988p("SharedReference", "No entry in sLiveObjects for value of type %s", t.getClass());
                    } else if (num.intValue() == 1) {
                        map.remove(t);
                    } else {
                        map.put(t, Integer.valueOf(num.intValue() - 1));
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m8645b() {
        boolean z2;
        synchronized (this) {
            z2 = this.f19448c > 0;
        }
        if (!(z2)) {
            throw new NullReferenceException();
        }
    }

    /* JADX INFO: renamed from: c */
    public synchronized T m8646c() {
        return this.f19447b;
    }
}
