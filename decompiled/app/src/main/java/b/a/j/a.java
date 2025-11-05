package b.a.j;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.MainThread;
import com.discord.floating_view_manager.FloatingViewGravity;
import com.discord.utilities.logging.Logger;
import d0.z.d.m;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: FloatingViewManager.kt */
/* loaded from: classes.dex */
public final class a {
    public Function1<? super Integer, Unit> a;

    /* renamed from: b, reason: collision with root package name */
    public final Map<Integer, C0033a> f243b;
    public final Logger c;

    /* compiled from: FloatingViewManager.kt */
    /* renamed from: b.a.j.a$a, reason: collision with other inner class name */
    public static final class C0033a {
        public final View a;

        /* renamed from: b, reason: collision with root package name */
        public final ViewGroup f244b;
        public final ViewTreeObserver.OnPreDrawListener c;

        public C0033a(View view, ViewGroup viewGroup, ViewTreeObserver.OnPreDrawListener onPreDrawListener) {
            m.checkNotNullParameter(view, "floatingView");
            m.checkNotNullParameter(viewGroup, "ancestorViewGroup");
            m.checkNotNullParameter(onPreDrawListener, "ancestorPreDrawListener");
            this.a = view;
            this.f244b = viewGroup;
            this.c = onPreDrawListener;
        }
    }

    /* compiled from: FloatingViewManager.kt */
    public static final class b {
        public static WeakReference<a> a;
    }

    public a(Logger logger) {
        m.checkNotNullParameter(logger, "logger");
        this.c = logger;
        this.f243b = new LinkedHashMap();
    }

    public static final void a(a aVar, View view, View view2, FloatingViewGravity floatingViewGravity, int i, int i2) {
        int height;
        Objects.requireNonNull(aVar);
        int[] iArr = new int[2];
        view2.getLocationInWindow(iArr);
        int i3 = iArr[0];
        int i4 = iArr[1];
        int width = (((view2.getWidth() / 2) + i3) - (view.getWidth() / 2)) + i;
        int iOrdinal = floatingViewGravity.ordinal();
        if (iOrdinal == 0) {
            height = i4 - view.getHeight();
        } else if (iOrdinal == 1) {
            height = ((view2.getHeight() / 2) + i4) - (view.getHeight() / 2);
        } else {
            if (iOrdinal != 2) {
                throw new NoWhenBranchMatchedException();
            }
            height = view2.getHeight() + i4;
        }
        view.setX(width);
        view.setY(height + i2);
    }

    @MainThread
    public final void b(int i) {
        C0033a c0033a = this.f243b.get(Integer.valueOf(i));
        if (c0033a != null) {
            ViewGroup viewGroup = c0033a.f244b;
            View view = c0033a.a;
            ViewTreeObserver.OnPreDrawListener onPreDrawListener = c0033a.c;
            this.f243b.remove(Integer.valueOf(i));
            viewGroup.getViewTreeObserver().removeOnPreDrawListener(onPreDrawListener);
            viewGroup.removeView(view);
            Function1<? super Integer, Unit> function1 = this.a;
            if (function1 != null) {
                function1.invoke(Integer.valueOf(i));
            }
        }
    }
}
