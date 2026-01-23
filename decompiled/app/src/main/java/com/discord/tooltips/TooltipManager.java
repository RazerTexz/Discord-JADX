package com.discord.tooltips;

import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.MainThread;
import androidx.core.view.ViewCompat;
import com.discord.floating_view_manager.FloatingViewGravity;
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
import p007b.p008a.p026j.FloatingViewManager;
import p007b.p008a.p026j.FloatingViewManager2;
import p007b.p008a.p026j.FloatingViewManager3;
import p007b.p008a.p026j.FloatingViewManager4;
import p007b.p008a.p026j.ViewOnLayoutChangeListenerC1101b;
import p007b.p008a.p026j.ViewOnLayoutChangeListenerC1102c;
import p007b.p008a.p058v.AcknowledgedTooltipsCache;
import p007b.p008a.p058v.TooltipManager2;
import p507d0.LazyJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Observable;

/* JADX INFO: compiled from: TooltipManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public class TooltipManager {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public Map<String, Integer> tooltipNameToTooltipViewIdMap;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final AcknowledgedTooltipsCache acknowledgedTooltipsCache;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final Set<String> shownTooltipNames;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final int maxTooltipsPerColdStart;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final FloatingViewManager floatingViewManager;

    /* JADX INFO: renamed from: com.discord.tooltips.TooltipManager$a */
    /* JADX INFO: compiled from: TooltipManager.kt */
    public static final class C6647a {

        /* JADX INFO: renamed from: a */
        public static WeakReference<TooltipManager> f18972a;

        /* JADX INFO: renamed from: b */
        public static final Lazy f18973b = LazyJVM.lazy(a.f18976j);

        /* JADX INFO: renamed from: c */
        public static final Lazy f18974c = LazyJVM.lazy(b.f18977j);

        /* JADX INFO: renamed from: d */
        public static final C6647a f18975d = null;

        /* JADX INFO: renamed from: com.discord.tooltips.TooltipManager$a$a */
        /* JADX INFO: compiled from: TooltipManager.kt */
        public static final class a extends Lambda implements Function0<AcknowledgedTooltipsCache> {

            /* JADX INFO: renamed from: j */
            public static final a f18976j = new a();

            public a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public AcknowledgedTooltipsCache invoke() {
                return new AcknowledgedTooltipsCache(null, 1);
            }
        }

        /* JADX INFO: renamed from: com.discord.tooltips.TooltipManager$a$b */
        /* JADX INFO: compiled from: TooltipManager.kt */
        public static final class b extends Lambda implements Function0<Set<String>> {

            /* JADX INFO: renamed from: j */
            public static final b f18977j = new b();

            public b() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public Set<String> invoke() {
                return new LinkedHashSet();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.tooltips.TooltipManager$b */
    /* JADX INFO: compiled from: TooltipManager.kt */
    public static class C6648b {
        private final String cacheKey;
        private final String tooltipName;

        public C6648b(String str, String str2) {
            Intrinsics3.checkNotNullParameter(str2, "tooltipName");
            this.cacheKey = str;
            this.tooltipName = str2;
        }

        public final String getCacheKey() {
            return this.cacheKey;
        }

        public final String getTooltipName() {
            return this.tooltipName;
        }

        public /* synthetic */ C6648b(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, str2);
        }
    }

    public TooltipManager(AcknowledgedTooltipsCache acknowledgedTooltipsCache, Set set, int i, FloatingViewManager floatingViewManager, int i2) {
        i = (i2 & 4) != 0 ? 1 : i;
        Intrinsics3.checkNotNullParameter(acknowledgedTooltipsCache, "acknowledgedTooltipsCache");
        Intrinsics3.checkNotNullParameter(set, "shownTooltipNames");
        Intrinsics3.checkNotNullParameter(floatingViewManager, "floatingViewManager");
        this.acknowledgedTooltipsCache = acknowledgedTooltipsCache;
        this.shownTooltipNames = set;
        this.maxTooltipsPerColdStart = i;
        this.floatingViewManager = floatingViewManager;
        floatingViewManager.f1454a = new TooltipManager2(this);
        this.tooltipNameToTooltipViewIdMap = new LinkedHashMap();
    }

    @MainThread
    /* JADX INFO: renamed from: a */
    public final void m8512a(C6648b tooltip) {
        Intrinsics3.checkNotNullParameter(tooltip, "tooltip");
        m8514c(tooltip);
        String cacheKey = tooltip.getCacheKey();
        if (cacheKey != null) {
            AcknowledgedTooltipsCache acknowledgedTooltipsCache = this.acknowledgedTooltipsCache;
            Objects.requireNonNull(acknowledgedTooltipsCache);
            Intrinsics3.checkNotNullParameter(cacheKey, "tooltipCacheKey");
            if (acknowledgedTooltipsCache.f1999a.getBoolean(cacheKey, false)) {
                return;
            }
            AcknowledgedTooltipsCache acknowledgedTooltipsCache2 = this.acknowledgedTooltipsCache;
            Objects.requireNonNull(acknowledgedTooltipsCache2);
            Intrinsics3.checkNotNullParameter(cacheKey, "tooltipCacheKey");
            SharedPreferences.Editor editorEdit = acknowledgedTooltipsCache2.f1999a.edit();
            Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
            editorEdit.putBoolean(cacheKey, true);
            editorEdit.apply();
        }
    }

    @MainThread
    /* JADX INFO: renamed from: b */
    public final boolean m8513b(C6648b tooltip, boolean ignoreMaxTooltips) {
        Intrinsics3.checkNotNullParameter(tooltip, "tooltip");
        String cacheKey = tooltip.getCacheKey();
        if (cacheKey != null) {
            AcknowledgedTooltipsCache acknowledgedTooltipsCache = this.acknowledgedTooltipsCache;
            Objects.requireNonNull(acknowledgedTooltipsCache);
            Intrinsics3.checkNotNullParameter(cacheKey, "tooltipCacheKey");
            boolean z2 = acknowledgedTooltipsCache.f1999a.getBoolean(cacheKey, false);
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
    /* JADX INFO: renamed from: c */
    public final void m8514c(C6648b tooltip) {
        Intrinsics3.checkNotNullParameter(tooltip, "tooltip");
        Integer num = this.tooltipNameToTooltipViewIdMap.get(tooltip.getTooltipName());
        if (num != null) {
            this.floatingViewManager.m208b(num.intValue());
        }
    }

    @MainThread
    /* JADX INFO: renamed from: d */
    public final void m8515d(View anchorView, View tooltipView, C6648b tooltip, FloatingViewGravity tooltipGravity, int xOffset, int yOffset, boolean ignoreMaxTooltips, Observable<Unit> componentPausedObservable) {
        Intrinsics3.checkNotNullParameter(anchorView, "anchorView");
        Intrinsics3.checkNotNullParameter(tooltipView, "tooltipView");
        Intrinsics3.checkNotNullParameter(tooltip, "tooltip");
        Intrinsics3.checkNotNullParameter(tooltipGravity, "tooltipGravity");
        Intrinsics3.checkNotNullParameter(componentPausedObservable, "componentPausedObservable");
        if (m8513b(tooltip, ignoreMaxTooltips)) {
            m8514c(tooltip);
            this.shownTooltipNames.add(tooltip.getTooltipName());
            this.tooltipNameToTooltipViewIdMap.put(tooltip.getTooltipName(), Integer.valueOf(tooltipView.getId()));
            FloatingViewManager floatingViewManager = this.floatingViewManager;
            Objects.requireNonNull(floatingViewManager);
            Intrinsics3.checkNotNullParameter(anchorView, "anchorView");
            Intrinsics3.checkNotNullParameter(tooltipView, "floatingView");
            Intrinsics3.checkNotNullParameter(tooltipGravity, "floatingViewGravity");
            Intrinsics3.checkNotNullParameter(componentPausedObservable, "componentPausedObservable");
            View rootView = anchorView.getRootView();
            Objects.requireNonNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup = (ViewGroup) rootView;
            tooltipView.setVisibility(4);
            if (!floatingViewManager.f1455b.containsKey(Integer.valueOf(tooltipView.getId()))) {
                viewGroup.addView(tooltipView);
            }
            if (!ViewCompat.isLaidOut(tooltipView) || tooltipView.isLayoutRequested()) {
                tooltipView.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC1101b(floatingViewManager, anchorView, tooltipView, tooltipGravity, xOffset, yOffset));
            } else if (!ViewCompat.isLaidOut(anchorView) || anchorView.isLayoutRequested()) {
                anchorView.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC1102c(floatingViewManager, anchorView, tooltipView, tooltipGravity, xOffset, yOffset));
            } else {
                FloatingViewManager.m207a(floatingViewManager, tooltipView, anchorView, tooltipGravity, xOffset, yOffset);
                tooltipView.setVisibility(0);
            }
            FloatingViewManager4 floatingViewManager4 = new FloatingViewManager4(floatingViewManager, tooltipView, anchorView, tooltipGravity, xOffset, yOffset);
            viewGroup.getViewTreeObserver().addOnPreDrawListener(floatingViewManager4);
            floatingViewManager.f1455b.put(Integer.valueOf(tooltipView.getId()), new FloatingViewManager.a(tooltipView, viewGroup, floatingViewManager4));
            componentPausedObservable.m11100Z(1).m11097W(new FloatingViewManager2(floatingViewManager, tooltipView), new FloatingViewManager3(floatingViewManager));
        }
    }
}
