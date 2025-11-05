package com.facebook.drawee.controller;

import android.content.Context;
import android.graphics.drawable.Animatable;
import b.c.a.a0.d;
import b.f.e.e;
import b.f.e.g;
import b.f.g.c.c;
import com.facebook.common.internal.Supplier;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public abstract class AbstractDraweeControllerBuilder<BUILDER extends AbstractDraweeControllerBuilder<BUILDER, REQUEST, IMAGE, INFO>, REQUEST, IMAGE, INFO> {
    public static final ControllerListener<Object> a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final NullPointerException f2888b = new NullPointerException("No image request was specified!");
    public static final AtomicLong c = new AtomicLong();
    public final Context d;
    public final Set<ControllerListener> e;
    public final Set<b.f.h.b.a.b> f;
    public Object g = null;
    public REQUEST h = null;
    public REQUEST[] i = null;
    public boolean j = true;
    public ControllerListener<? super INFO> k = null;
    public boolean l = false;
    public boolean m = false;
    public DraweeController n = null;

    public static class a extends c<Object> {
        @Override // b.f.g.c.c, com.facebook.drawee.controller.ControllerListener
        public void onFinalImageSet(String str, Object obj, Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    }

    public enum b {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    public AbstractDraweeControllerBuilder(Context context, Set<ControllerListener> set, Set<b.f.h.b.a.b> set2) {
        this.d = context;
        this.e = set;
        this.f = set2;
    }

    public AbstractDraweeController a() {
        d.C(this.i == null || this.h == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        d.C(true, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
        if (this.h == null) {
            REQUEST[] requestArr = this.i;
        }
        b.f.j.r.b.b();
        AbstractDraweeController abstractDraweeControllerD = d();
        abstractDraweeControllerD.r = false;
        abstractDraweeControllerD.f2886s = null;
        boolean z2 = this.l;
        if (z2) {
            if (abstractDraweeControllerD.g == null) {
                abstractDraweeControllerD.g = new b.f.g.b.d();
            }
            abstractDraweeControllerD.g.a = z2;
            if (abstractDraweeControllerD.h == null) {
                b.f.g.g.a aVar = new b.f.g.g.a(this.d);
                abstractDraweeControllerD.h = aVar;
                aVar.a = abstractDraweeControllerD;
            }
        }
        Set<ControllerListener> set = this.e;
        if (set != null) {
            Iterator<ControllerListener> it = set.iterator();
            while (it.hasNext()) {
                abstractDraweeControllerD.f(it.next());
            }
        }
        Set<b.f.h.b.a.b> set2 = this.f;
        if (set2 != null) {
            for (b.f.h.b.a.b<INFO> bVar : set2) {
                b.f.h.b.a.c<INFO> cVar = abstractDraweeControllerD.j;
                synchronized (cVar) {
                    cVar.j.add(bVar);
                }
            }
        }
        ControllerListener<? super INFO> controllerListener = this.k;
        if (controllerListener != null) {
            abstractDraweeControllerD.f(controllerListener);
        }
        if (this.m) {
            abstractDraweeControllerD.f(a);
        }
        b.f.j.r.b.b();
        return abstractDraweeControllerD;
    }

    public abstract DataSource<IMAGE> b(DraweeController draweeController, String str, REQUEST request, Object obj, b bVar);

    public Supplier<DataSource<IMAGE>> c(DraweeController draweeController, String str, REQUEST request) {
        return new b.f.g.c.b(this, draweeController, str, request, this.g, b.FULL_FETCH);
    }

    public abstract AbstractDraweeController d();

    public Supplier<DataSource<IMAGE>> e(DraweeController draweeController, String str) {
        Supplier<DataSource<IMAGE>> gVar;
        REQUEST request = this.h;
        if (request != null) {
            gVar = c(draweeController, str, request);
        } else {
            REQUEST[] requestArr = this.i;
            if (requestArr != null) {
                boolean z2 = this.j;
                ArrayList arrayList = new ArrayList(requestArr.length * 2);
                if (z2) {
                    for (REQUEST request2 : requestArr) {
                        arrayList.add(new b.f.g.c.b(this, draweeController, str, request2, this.g, b.BITMAP_MEMORY_CACHE));
                    }
                }
                for (REQUEST request3 : requestArr) {
                    arrayList.add(c(draweeController, str, request3));
                }
                gVar = new g<>(arrayList);
            } else {
                gVar = null;
            }
        }
        return gVar == null ? new e(f2888b) : gVar;
    }
}
