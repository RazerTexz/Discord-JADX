package com.discord.tooltips;

import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.MainThread;
import androidx.core.view.ViewCompat;
import b.a.j.a;
import b.a.j.c;
import b.a.j.d;
import b.a.j.f;
import b.a.v.e;
import com.discord.floating_view_manager.FloatingViewGravity;
import d0.g;
import d0.z.d.m;
import d0.z.d.o;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: TooltipManager.kt */
/* loaded from: classes2.dex */
public class TooltipManager {

    /* renamed from: a, reason: from kotlin metadata */
    public Map<String, Integer> tooltipNameToTooltipViewIdMap;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final b.a.v.a acknowledgedTooltipsCache;

    /* renamed from: c, reason: from kotlin metadata */
    public final Set<String> shownTooltipNames;

    /* renamed from: d, reason: from kotlin metadata */
    public final int maxTooltipsPerColdStart;

    /* renamed from: e, reason: from kotlin metadata */
    public final b.a.j.a floatingViewManager;

    /* compiled from: TooltipManager.kt */
    public static final class a {
        public static WeakReference<TooltipManager> a;

        /* renamed from: b, reason: collision with root package name */
        public static final Lazy f2815b = g.lazy(C0322a.j);
        public static final Lazy c = g.lazy(b.j);
        public static final a d = null;

        /* compiled from: TooltipManager.kt */
        /* renamed from: com.discord.tooltips.TooltipManager$a$a, reason: collision with other inner class name */
        public static final class C0322a extends o implements Function0<b.a.v.a> {
            public static final C0322a j = new C0322a();

            public C0322a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public b.a.v.a invoke() {
                return new b.a.v.a(null, 1);
            }
        }

        /* compiled from: TooltipManager.kt */
        public static final class b extends o implements Function0<Set<String>> {
            public static final b j = new b();

            public b() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public Set<String> invoke() {
                return new LinkedHashSet();
            }
        }
    }

    /* compiled from: TooltipManager.kt */
    public static class b {
        private final String cacheKey;
        private final String tooltipName;

        public b(String str, String str2) {
            m.checkNotNullParameter(str2, "tooltipName");
            this.cacheKey = str;
            this.tooltipName = str2;
        }

        public final String getCacheKey() {
            return this.cacheKey;
        }

        public final String getTooltipName() {
            return this.tooltipName;
        }

        public /* synthetic */ b(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, str2);
        }
    }

    public TooltipManager(b.a.v.a aVar, Set set, int i, b.a.j.a aVar2, int i2) {
        i = (i2 & 4) != 0 ? 1 : i;
        m.checkNotNullParameter(aVar, "acknowledgedTooltipsCache");
        m.checkNotNullParameter(set, "shownTooltipNames");
        m.checkNotNullParameter(aVar2, "floatingViewManager");
        this.acknowledgedTooltipsCache = aVar;
        this.shownTooltipNames = set;
        this.maxTooltipsPerColdStart = i;
        this.floatingViewManager = aVar2;
        aVar2.a = new e(this);
        this.tooltipNameToTooltipViewIdMap = new LinkedHashMap();
    }

    @MainThread
    public final void a(b tooltip) {
        m.checkNotNullParameter(tooltip, "tooltip");
        c(tooltip);
        String cacheKey = tooltip.getCacheKey();
        if (cacheKey != null) {
            b.a.v.a aVar = this.acknowledgedTooltipsCache;
            Objects.requireNonNull(aVar);
            m.checkNotNullParameter(cacheKey, "tooltipCacheKey");
            if (aVar.a.getBoolean(cacheKey, false)) {
                return;
            }
            b.a.v.a aVar2 = this.acknowledgedTooltipsCache;
            Objects.requireNonNull(aVar2);
            m.checkNotNullParameter(cacheKey, "tooltipCacheKey");
            SharedPreferences.Editor editorEdit = aVar2.a.edit();
            m.checkNotNullExpressionValue(editorEdit, "editor");
            editorEdit.putBoolean(cacheKey, true);
            editorEdit.apply();
        }
    }

    @MainThread
    public final boolean b(b tooltip, boolean ignoreMaxTooltips) {
        m.checkNotNullParameter(tooltip, "tooltip");
        String cacheKey = tooltip.getCacheKey();
        if (cacheKey != null) {
            b.a.v.a aVar = this.acknowledgedTooltipsCache;
            Objects.requireNonNull(aVar);
            m.checkNotNullParameter(cacheKey, "tooltipCacheKey");
            boolean z2 = aVar.a.getBoolean(cacheKey, false);
            boolean zContains = this.shownTooltipNames.contains(tooltip.getTooltipName());
            int size = this.shownTooltipNames.size();
            if (z2) {
                return false;
            }
            if (!zContains && !ignoreMaxTooltips && size >= this.maxTooltipsPerColdStart) {
                return false;
            }
        }
        return true;
    }

    @MainThread
    public final void c(b tooltip) {
        m.checkNotNullParameter(tooltip, "tooltip");
        Integer num = this.tooltipNameToTooltipViewIdMap.get(tooltip.getTooltipName());
        if (num != null) {
            this.floatingViewManager.b(num.intValue());
        }
    }

    @MainThread
    public final void d(View anchorView, View tooltipView, b tooltip, FloatingViewGravity tooltipGravity, int xOffset, int yOffset, boolean ignoreMaxTooltips, Observable<Unit> componentPausedObservable) {
        m.checkNotNullParameter(anchorView, "anchorView");
        m.checkNotNullParameter(tooltipView, "tooltipView");
        m.checkNotNullParameter(tooltip, "tooltip");
        m.checkNotNullParameter(tooltipGravity, "tooltipGravity");
        m.checkNotNullParameter(componentPausedObservable, "componentPausedObservable");
        if (b(tooltip, ignoreMaxTooltips)) {
            c(tooltip);
            this.shownTooltipNames.add(tooltip.getTooltipName());
            this.tooltipNameToTooltipViewIdMap.put(tooltip.getTooltipName(), Integer.valueOf(tooltipView.getId()));
            b.a.j.a aVar = this.floatingViewManager;
            Objects.requireNonNull(aVar);
            m.checkNotNullParameter(anchorView, "anchorView");
            m.checkNotNullParameter(tooltipView, "floatingView");
            m.checkNotNullParameter(tooltipGravity, "floatingViewGravity");
            m.checkNotNullParameter(componentPausedObservable, "componentPausedObservable");
            View rootView = anchorView.getRootView();
            Objects.requireNonNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup = (ViewGroup) rootView;
            tooltipView.setVisibility(4);
            if (!aVar.f243b.containsKey(Integer.valueOf(tooltipView.getId()))) {
                viewGroup.addView(tooltipView);
            }
            if (!ViewCompat.isLaidOut(tooltipView) || tooltipView.isLayoutRequested()) {
                tooltipView.addOnLayoutChangeListener(new b.a.j.b(aVar, anchorView, tooltipView, tooltipGravity, xOffset, yOffset));
            } else if (!ViewCompat.isLaidOut(anchorView) || anchorView.isLayoutRequested()) {
                anchorView.addOnLayoutChangeListener(new c(aVar, anchorView, tooltipView, tooltipGravity, xOffset, yOffset));
            } else {
                b.a.j.a.a(aVar, tooltipView, anchorView, tooltipGravity, xOffset, yOffset);
                tooltipView.setVisibility(0);
            }
            f fVar = new f(aVar, tooltipView, anchorView, tooltipGravity, xOffset, yOffset);
            viewGroup.getViewTreeObserver().addOnPreDrawListener(fVar);
            aVar.f243b.put(Integer.valueOf(tooltipView.getId()), new a.C0033a(tooltipView, viewGroup, fVar));
            componentPausedObservable.Z(1).W(new d(aVar, tooltipView), new b.a.j.e(aVar));
        }
    }
}
