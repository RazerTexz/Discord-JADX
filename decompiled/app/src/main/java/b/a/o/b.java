package b.a.o;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.UiThread;
import d0.t.u;
import d0.z.d.m;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: PanelsChildGestureRegionObserver.kt */
/* loaded from: classes.dex */
public final class b implements View.OnLayoutChangeListener {
    public final Map<Integer, Rect> j = new LinkedHashMap();
    public final Map<Integer, ViewTreeObserver.OnScrollChangedListener> k = new LinkedHashMap();
    public final Set<a> l = new LinkedHashSet();

    /* compiled from: PanelsChildGestureRegionObserver.kt */
    public interface a {
        void onGestureRegionsUpdate(List<Rect> list);
    }

    /* compiled from: PanelsChildGestureRegionObserver.kt */
    /* renamed from: b.a.o.b$b, reason: collision with other inner class name */
    public static final class C0039b {
        public static WeakReference<b> a = new WeakReference<>(null);

        @UiThread
        public static final b a() {
            b bVar = a.get();
            if (bVar != null) {
                return bVar;
            }
            b bVar2 = new b();
            a = new WeakReference<>(bVar2);
            return bVar2;
        }
    }

    /* compiled from: PanelsChildGestureRegionObserver.kt */
    public static final class c implements ViewTreeObserver.OnScrollChangedListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f252b;

        public c(View view) {
            this.f252b = view;
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public final void onScrollChanged() {
            b bVar = b.this;
            View view = this.f252b;
            bVar.onLayoutChange(view, view.getLeft(), this.f252b.getTop(), this.f252b.getRight(), this.f252b.getBottom(), 0, 0, 0, 0);
        }
    }

    public final void a() {
        List<Rect> list = u.toList(this.j.values());
        Iterator<T> it = this.l.iterator();
        while (it.hasNext()) {
            ((a) it.next()).onGestureRegionsUpdate(list);
        }
    }

    @UiThread
    public final void b(View view) {
        m.checkParameterIsNotNull(view, "view");
        if (!this.k.containsKey(Integer.valueOf(view.getId()))) {
            view.addOnLayoutChangeListener(this);
            c cVar = new c(view);
            view.getViewTreeObserver().addOnScrollChangedListener(cVar);
            this.k.put(Integer.valueOf(view.getId()), cVar);
            return;
        }
        String simpleName = b.class.getSimpleName();
        StringBuilder sbU = b.d.b.a.a.U("failed to register view with ID ");
        sbU.append(view.getId());
        sbU.append(". already registered");
        Log.w(simpleName, sbU.toString());
    }

    @UiThread
    public final void c(View view) {
        m.checkParameterIsNotNull(view, "view");
        ViewTreeObserver.OnScrollChangedListener onScrollChangedListenerRemove = this.k.remove(Integer.valueOf(view.getId()));
        if (onScrollChangedListenerRemove != null) {
            view.getViewTreeObserver().removeOnScrollChangedListener(onScrollChangedListenerRemove);
        }
        view.removeOnLayoutChangeListener(this);
        this.j.remove(Integer.valueOf(view.getId()));
        a();
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        m.checkParameterIsNotNull(view, "view");
        if (this.k.keySet().contains(Integer.valueOf(view.getId()))) {
            int[] iArr = {0, 0};
            view.getLocationInWindow(iArr);
            int i9 = iArr[0];
            int i10 = iArr[1];
            this.j.put(Integer.valueOf(view.getId()), new Rect(i9, i10, i3 + i9, i4 + i10));
            a();
        }
    }
}
