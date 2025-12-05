package com.facebook.drawee.controller;

import android.content.Context;
import android.graphics.drawable.Animatable;
import com.facebook.common.internal.Supplier;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p109f.p129e.DataSources;
import p007b.p109f.p129e.FirstAvailableDataSourceSupplier;
import p007b.p109f.p132g.p138b.RetryManager;
import p007b.p109f.p132g.p139c.AbstractDraweeControllerBuilder2;
import p007b.p109f.p132g.p139c.BaseControllerListener;
import p007b.p109f.p132g.p144g.GestureDetector;
import p007b.p109f.p148h.p158b.p159a.ControllerListener2;
import p007b.p109f.p148h.p158b.p159a.ForwardingControllerListener2;
import p007b.p109f.p161j.p183r.FrescoSystrace;

/* loaded from: classes.dex */
public abstract class AbstractDraweeControllerBuilder<BUILDER extends AbstractDraweeControllerBuilder<BUILDER, REQUEST, IMAGE, INFO>, REQUEST, IMAGE, INFO> {

    /* renamed from: a */
    public static final ControllerListener<Object> f19477a = new C10642a();

    /* renamed from: b */
    public static final NullPointerException f19478b = new NullPointerException("No image request was specified!");

    /* renamed from: c */
    public static final AtomicLong f19479c = new AtomicLong();

    /* renamed from: d */
    public final Context f19480d;

    /* renamed from: e */
    public final Set<ControllerListener> f19481e;

    /* renamed from: f */
    public final Set<ControllerListener2> f19482f;

    /* renamed from: g */
    public Object f19483g = null;

    /* renamed from: h */
    public REQUEST f19484h = null;

    /* renamed from: i */
    public REQUEST[] f19485i = null;

    /* renamed from: j */
    public boolean f19486j = true;

    /* renamed from: k */
    public ControllerListener<? super INFO> f19487k = null;

    /* renamed from: l */
    public boolean f19488l = false;

    /* renamed from: m */
    public boolean f19489m = false;

    /* renamed from: n */
    public DraweeController f19490n = null;

    /* renamed from: com.facebook.drawee.controller.AbstractDraweeControllerBuilder$a */
    public static class C10642a extends BaseControllerListener<Object> {
        @Override // p007b.p109f.p132g.p139c.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onFinalImageSet(String str, Object obj, Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    }

    /* renamed from: com.facebook.drawee.controller.AbstractDraweeControllerBuilder$b */
    public enum EnumC10643b {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    public AbstractDraweeControllerBuilder(Context context, Set<ControllerListener> set, Set<ControllerListener2> set2) {
        this.f19480d = context;
        this.f19481e = set;
        this.f19482f = set2;
    }

    /* renamed from: a */
    public AbstractDraweeController m8667a() {
        AnimatableValueParser.m423C(this.f19485i == null || this.f19484h == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        AnimatableValueParser.m423C(true, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
        if (this.f19484h == null) {
            REQUEST[] requestArr = this.f19485i;
        }
        FrescoSystrace.m1527b();
        AbstractDraweeController abstractDraweeControllerMo1057d = mo1057d();
        abstractDraweeControllerMo1057d.f19468r = false;
        abstractDraweeControllerMo1057d.f19469s = null;
        boolean z2 = this.f19488l;
        if (z2) {
            if (abstractDraweeControllerMo1057d.f19457g == null) {
                abstractDraweeControllerMo1057d.f19457g = new RetryManager();
            }
            abstractDraweeControllerMo1057d.f19457g.f3288a = z2;
            if (abstractDraweeControllerMo1057d.f19458h == null) {
                GestureDetector gestureDetector = new GestureDetector(this.f19480d);
                abstractDraweeControllerMo1057d.f19458h = gestureDetector;
                gestureDetector.f3480a = abstractDraweeControllerMo1057d;
            }
        }
        Set<ControllerListener> set = this.f19481e;
        if (set != null) {
            Iterator<ControllerListener> it = set.iterator();
            while (it.hasNext()) {
                abstractDraweeControllerMo1057d.m8656f(it.next());
            }
        }
        Set<ControllerListener2> set2 = this.f19482f;
        if (set2 != null) {
            for (ControllerListener2<INFO> controllerListener2 : set2) {
                ForwardingControllerListener2<INFO> forwardingControllerListener2 = abstractDraweeControllerMo1057d.f19460j;
                synchronized (forwardingControllerListener2) {
                    forwardingControllerListener2.f3568j.add(controllerListener2);
                }
            }
        }
        ControllerListener<? super INFO> controllerListener = this.f19487k;
        if (controllerListener != null) {
            abstractDraweeControllerMo1057d.m8656f(controllerListener);
        }
        if (this.f19489m) {
            abstractDraweeControllerMo1057d.m8656f(f19477a);
        }
        FrescoSystrace.m1527b();
        return abstractDraweeControllerMo1057d;
    }

    /* renamed from: b */
    public abstract DataSource<IMAGE> mo1056b(DraweeController draweeController, String str, REQUEST request, Object obj, EnumC10643b enumC10643b);

    /* renamed from: c */
    public Supplier<DataSource<IMAGE>> m8668c(DraweeController draweeController, String str, REQUEST request) {
        return new AbstractDraweeControllerBuilder2(this, draweeController, str, request, this.f19483g, EnumC10643b.FULL_FETCH);
    }

    /* renamed from: d */
    public abstract AbstractDraweeController mo1057d();

    /* renamed from: e */
    public Supplier<DataSource<IMAGE>> m8669e(DraweeController draweeController, String str) {
        Supplier<DataSource<IMAGE>> firstAvailableDataSourceSupplier;
        REQUEST request = this.f19484h;
        if (request != null) {
            firstAvailableDataSourceSupplier = m8668c(draweeController, str, request);
        } else {
            REQUEST[] requestArr = this.f19485i;
            if (requestArr != null) {
                boolean z2 = this.f19486j;
                ArrayList arrayList = new ArrayList(requestArr.length * 2);
                if (z2) {
                    for (REQUEST request2 : requestArr) {
                        arrayList.add(new AbstractDraweeControllerBuilder2(this, draweeController, str, request2, this.f19483g, EnumC10643b.BITMAP_MEMORY_CACHE));
                    }
                }
                for (REQUEST request3 : requestArr) {
                    arrayList.add(m8668c(draweeController, str, request3));
                }
                firstAvailableDataSourceSupplier = new FirstAvailableDataSourceSupplier<>(arrayList);
            } else {
                firstAvailableDataSourceSupplier = null;
            }
        }
        return firstAvailableDataSourceSupplier == null ? new DataSources(f19478b) : firstAvailableDataSourceSupplier;
    }
}
