package p007b.p008a.p039o;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.UiThread;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: b.a.o.b, reason: use source file name */
/* JADX INFO: compiled from: PanelsChildGestureRegionObserver.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PanelsChildGestureRegionObserver implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: j */
    public final Map<Integer, Rect> f1573j = new LinkedHashMap();

    /* JADX INFO: renamed from: k */
    public final Map<Integer, ViewTreeObserver.OnScrollChangedListener> f1574k = new LinkedHashMap();

    /* JADX INFO: renamed from: l */
    public final Set<a> f1575l = new LinkedHashSet();

    /* JADX INFO: renamed from: b.a.o.b$a */
    /* JADX INFO: compiled from: PanelsChildGestureRegionObserver.kt */
    public interface a {
        void onGestureRegionsUpdate(List<Rect> list);
    }

    /* JADX INFO: renamed from: b.a.o.b$b */
    /* JADX INFO: compiled from: PanelsChildGestureRegionObserver.kt */
    public static final class b {

        /* JADX INFO: renamed from: a */
        public static WeakReference<PanelsChildGestureRegionObserver> f1576a = new WeakReference<>(null);

        @UiThread
        /* JADX INFO: renamed from: a */
        public static final PanelsChildGestureRegionObserver m232a() {
            PanelsChildGestureRegionObserver panelsChildGestureRegionObserver = f1576a.get();
            if (panelsChildGestureRegionObserver != null) {
                return panelsChildGestureRegionObserver;
            }
            PanelsChildGestureRegionObserver panelsChildGestureRegionObserver2 = new PanelsChildGestureRegionObserver();
            f1576a = new WeakReference<>(panelsChildGestureRegionObserver2);
            return panelsChildGestureRegionObserver2;
        }
    }

    /* JADX INFO: renamed from: b.a.o.b$c */
    /* JADX INFO: compiled from: PanelsChildGestureRegionObserver.kt */
    public static final class c implements ViewTreeObserver.OnScrollChangedListener {

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ View f1578b;

        public c(View view) {
            this.f1578b = view;
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public final void onScrollChanged() {
            PanelsChildGestureRegionObserver panelsChildGestureRegionObserver = PanelsChildGestureRegionObserver.this;
            View view = this.f1578b;
            panelsChildGestureRegionObserver.onLayoutChange(view, view.getLeft(), this.f1578b.getTop(), this.f1578b.getRight(), this.f1578b.getBottom(), 0, 0, 0, 0);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m229a() {
        List<Rect> list = _Collections.toList(this.f1573j.values());
        Iterator<T> it = this.f1575l.iterator();
        while (it.hasNext()) {
            ((a) it.next()).onGestureRegionsUpdate(list);
        }
    }

    @UiThread
    /* JADX INFO: renamed from: b */
    public final void m230b(View view) {
        Intrinsics3.checkParameterIsNotNull(view, "view");
        if (!this.f1574k.containsKey(Integer.valueOf(view.getId()))) {
            view.addOnLayoutChangeListener(this);
            c cVar = new c(view);
            view.getViewTreeObserver().addOnScrollChangedListener(cVar);
            this.f1574k.put(Integer.valueOf(view.getId()), cVar);
            return;
        }
        String simpleName = PanelsChildGestureRegionObserver.class.getSimpleName();
        StringBuilder sbM833U = outline.m833U("failed to register view with ID ");
        sbM833U.append(view.getId());
        sbM833U.append(". already registered");
        Log.w(simpleName, sbM833U.toString());
    }

    @UiThread
    /* JADX INFO: renamed from: c */
    public final void m231c(View view) {
        Intrinsics3.checkParameterIsNotNull(view, "view");
        ViewTreeObserver.OnScrollChangedListener onScrollChangedListenerRemove = this.f1574k.remove(Integer.valueOf(view.getId()));
        if (onScrollChangedListenerRemove != null) {
            view.getViewTreeObserver().removeOnScrollChangedListener(onScrollChangedListenerRemove);
        }
        view.removeOnLayoutChangeListener(this);
        this.f1573j.remove(Integer.valueOf(view.getId()));
        m229a();
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        Intrinsics3.checkParameterIsNotNull(view, "view");
        if (this.f1574k.keySet().contains(Integer.valueOf(view.getId()))) {
            int[] iArr = {0, 0};
            view.getLocationInWindow(iArr);
            int i9 = iArr[0];
            int i10 = iArr[1];
            this.f1573j.put(Integer.valueOf(view.getId()), new Rect(i9, i10, i3 + i9, i4 + i10));
            m229a();
        }
    }
}
