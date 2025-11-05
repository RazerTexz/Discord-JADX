package com.discord.widgets.channels.list;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.a;
import com.discord.R;
import com.discord.databinding.WidgetChannelsListUnreadsBinding;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.layoutparams.LayoutParamsExtensionsKt;
import com.discord.utilities.views.ViewCoroutineScopeKt;
import com.google.android.material.appbar.AppBarLayout;
import d0.d0.f;
import d0.g;
import d0.l;
import d0.t.n;
import d0.t.u;
import d0.w.h.c;
import d0.w.i.a.e;
import d0.w.i.a.k;
import d0.z.d.m;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: WidgetChannelListUnreads.kt */
/* loaded from: classes2.dex */
public final class WidgetChannelListUnreads {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    private static final long FADE_DURATION_MS = 150;

    @Deprecated
    private static final int ITEM_OVER_SCROLL_COUNT = 3;
    private final AppBarLayout appBarLayout;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final Lazy binding;
    private List<? extends Object> data;
    private final Function0<Integer> getItemCount;
    private int mentionResId;
    private final RecyclerView recycler;
    private boolean unreadsEnabled;
    private boolean unreadsInitialized;
    private int unreadsResId;
    private final ViewStub unreadsStub;

    /* compiled from: WidgetChannelListUnreads.kt */
    /* renamed from: com.discord.widgets.channels.list.WidgetChannelListUnreads$1, reason: invalid class name */
    public static final class AnonymousClass1 extends RecyclerView.OnScrollListener {
        public AnonymousClass1() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            m.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == 0 || newState == 2) {
                WidgetChannelListUnreads.access$handleVisibleRangeUpdate(WidgetChannelListUnreads.this);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            m.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, dx, dy);
            if (AccessibilityUtils.INSTANCE.isReducedMotionEnabled()) {
                WidgetChannelListUnreads.access$handleVisibleRangeUpdate(WidgetChannelListUnreads.this);
            }
        }
    }

    /* compiled from: WidgetChannelListUnreads.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChannelListUnreads.kt */
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final int INVALID_INDEX = -1;
        public static final int TYPE_MENTION = 0;
        public static final int TYPE_UNREAD = 1;
        private final Indicator bottomIndicator;
        private final Indicator topIndicator;

        /* compiled from: WidgetChannelListUnreads.kt */
        public static final class Companion {
            private Companion() {
            }

            private final Indicator findIndicator(List<? extends Object> list, IntProgression intProgression, boolean z2, boolean z3) {
                int i;
                int first = intProgression.getFirst();
                int last = intProgression.getLast();
                int step = intProgression.getStep();
                if (step < 0 ? first >= last : first <= last) {
                    i = -1;
                    while (true) {
                        Object obj = list.get(first);
                        if (!(obj instanceof UnreadItem)) {
                            obj = null;
                        }
                        UnreadItem unreadItem = (UnreadItem) obj;
                        if (unreadItem != null) {
                            if (unreadItem.getMentionCount() > 0) {
                                return new Indicator(0, first);
                            }
                            if (z3 && !z2 && i == -1 && unreadItem.isUnread()) {
                                i = first;
                            }
                        }
                        if (first == last) {
                            break;
                        }
                        first += step;
                    }
                } else {
                    i = -1;
                }
                if (i != -1) {
                    return new Indicator(1, i);
                }
                return null;
            }

            public static /* synthetic */ Model get$default(Companion companion, IntRange intRange, List list, boolean z2, int i, Object obj) {
                if ((i & 4) != 0) {
                    z2 = true;
                }
                return companion.get(intRange, list, z2);
            }

            private final boolean hasUnread(List<? extends Object> list, IntRange intRange) {
                List listSlice = u.slice(list, intRange);
                if (!(listSlice instanceof Collection) || !listSlice.isEmpty()) {
                    for (Object obj : listSlice) {
                        if (!(obj instanceof UnreadItem)) {
                            obj = null;
                        }
                        UnreadItem unreadItem = (UnreadItem) obj;
                        if (unreadItem != null && unreadItem.isUnread()) {
                            return true;
                        }
                    }
                }
                return false;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Model get(IntRange visibleRange, List<? extends Object> items, boolean unreadsEnabled) {
                boolean z2;
                m.checkNotNullParameter(visibleRange, "visibleRange");
                m.checkNotNullParameter(items, "items");
                if (unreadsEnabled) {
                    try {
                        z2 = hasUnread(items, visibleRange);
                    } catch (IndexOutOfBoundsException unused) {
                        return new Model(null, null, 3, null);
                    }
                }
                return new Model(findIndicator(items, f.until(0, visibleRange.getFirst()), z2, unreadsEnabled), findIndicator(items, f.downTo(n.getLastIndex(items), visibleRange.getLast() + 1), z2, unreadsEnabled));
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* compiled from: WidgetChannelListUnreads.kt */
        public static final /* data */ class Indicator {
            private final int index;
            private final int type;

            public Indicator(int i, int i2) {
                this.type = i;
                this.index = i2;
            }

            public static /* synthetic */ Indicator copy$default(Indicator indicator, int i, int i2, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    i = indicator.type;
                }
                if ((i3 & 2) != 0) {
                    i2 = indicator.index;
                }
                return indicator.copy(i, i2);
            }

            /* renamed from: component1, reason: from getter */
            public final int getType() {
                return this.type;
            }

            /* renamed from: component2, reason: from getter */
            public final int getIndex() {
                return this.index;
            }

            public final Indicator copy(int type, int index) {
                return new Indicator(type, index);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Indicator)) {
                    return false;
                }
                Indicator indicator = (Indicator) other;
                return this.type == indicator.type && this.index == indicator.index;
            }

            public final int getIndex() {
                return this.index;
            }

            public final int getType() {
                return this.type;
            }

            public int hashCode() {
                return (this.type * 31) + this.index;
            }

            public String toString() {
                StringBuilder sbU = a.U("Indicator(type=");
                sbU.append(this.type);
                sbU.append(", index=");
                return a.B(sbU, this.index, ")");
            }
        }

        public Model() {
            this(null, null, 3, null);
        }

        public Model(Indicator indicator, Indicator indicator2) {
            this.topIndicator = indicator;
            this.bottomIndicator = indicator2;
        }

        public static /* synthetic */ Model copy$default(Model model, Indicator indicator, Indicator indicator2, int i, Object obj) {
            if ((i & 1) != 0) {
                indicator = model.topIndicator;
            }
            if ((i & 2) != 0) {
                indicator2 = model.bottomIndicator;
            }
            return model.copy(indicator, indicator2);
        }

        /* renamed from: component1, reason: from getter */
        public final Indicator getTopIndicator() {
            return this.topIndicator;
        }

        /* renamed from: component2, reason: from getter */
        public final Indicator getBottomIndicator() {
            return this.bottomIndicator;
        }

        public final Model copy(Indicator topIndicator, Indicator bottomIndicator) {
            return new Model(topIndicator, bottomIndicator);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return m.areEqual(this.topIndicator, model.topIndicator) && m.areEqual(this.bottomIndicator, model.bottomIndicator);
        }

        public final Indicator getBottomIndicator() {
            return this.bottomIndicator;
        }

        public final Indicator getTopIndicator() {
            return this.topIndicator;
        }

        public int hashCode() {
            Indicator indicator = this.topIndicator;
            int iHashCode = (indicator != null ? indicator.hashCode() : 0) * 31;
            Indicator indicator2 = this.bottomIndicator;
            return iHashCode + (indicator2 != null ? indicator2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = a.U("Model(topIndicator=");
            sbU.append(this.topIndicator);
            sbU.append(", bottomIndicator=");
            sbU.append(this.bottomIndicator);
            sbU.append(")");
            return sbU.toString();
        }

        public /* synthetic */ Model(Indicator indicator, Indicator indicator2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : indicator, (i & 2) != 0 ? null : indicator2);
        }
    }

    /* compiled from: WidgetChannelListUnreads.kt */
    public interface UnreadItem {
        int getMentionCount();

        boolean isUnread();
    }

    /* compiled from: WidgetChannelListUnreads.kt */
    /* renamed from: com.discord.widgets.channels.list.WidgetChannelListUnreads$handleVisibleRangeUpdate$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Model.Indicator $indicator;
        public final /* synthetic */ boolean $indicatorUpwards;

        public AnonymousClass1(Model.Indicator indicator, boolean z2) {
            this.$indicator = indicator;
            this.$indicatorUpwards = z2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChannelListUnreads.access$handleClick(WidgetChannelListUnreads.this, this.$indicator, this.$indicatorUpwards);
        }
    }

    /* compiled from: WidgetChannelListUnreads.kt */
    @e(c = "com.discord.widgets.channels.list.WidgetChannelListUnreads$onDatasetChanged$1", f = "WidgetChannelListUnreads.kt", l = {74}, m = "invokeSuspend")
    /* renamed from: com.discord.widgets.channels.list.WidgetChannelListUnreads$onDatasetChanged$1, reason: invalid class name */
    public static final class AnonymousClass1 extends k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int label;

        public AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // d0.w.i.a.a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            m.checkNotNullParameter(continuation, "completion");
            return WidgetChannelListUnreads.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.a
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = c.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                l.throwOnFailure(obj);
                this.label = 1;
                if (b.i.a.f.e.o.f.P(50L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                l.throwOnFailure(obj);
            }
            WidgetChannelListUnreads.access$handleVisibleRangeUpdate(WidgetChannelListUnreads.this);
            return Unit.a;
        }
    }

    public WidgetChannelListUnreads(ViewStub viewStub, RecyclerView recyclerView, AppBarLayout appBarLayout, Function0<Integer> function0, int i, int i2, boolean z2) {
        m.checkNotNullParameter(viewStub, "unreadsStub");
        m.checkNotNullParameter(recyclerView, "recycler");
        m.checkNotNullParameter(function0, "getItemCount");
        this.unreadsStub = viewStub;
        this.recycler = recyclerView;
        this.appBarLayout = appBarLayout;
        this.getItemCount = function0;
        this.mentionResId = i;
        this.unreadsResId = i2;
        this.unreadsEnabled = z2;
        this.binding = g.lazy(new WidgetChannelListUnreads$binding$2(this));
        this.data = n.emptyList();
        recyclerView.addOnScrollListener(new AnonymousClass1());
    }

    public static final /* synthetic */ ViewStub access$getUnreadsStub$p(WidgetChannelListUnreads widgetChannelListUnreads) {
        return widgetChannelListUnreads.unreadsStub;
    }

    public static final /* synthetic */ void access$handleClick(WidgetChannelListUnreads widgetChannelListUnreads, Model.Indicator indicator, boolean z2) {
        widgetChannelListUnreads.handleClick(indicator, z2);
    }

    public static final /* synthetic */ void access$handleVisibleRangeUpdate(WidgetChannelListUnreads widgetChannelListUnreads) {
        widgetChannelListUnreads.handleVisibleRangeUpdate();
    }

    private final WidgetChannelsListUnreadsBinding getBinding() {
        return (WidgetChannelsListUnreadsBinding) this.binding.getValue();
    }

    private final int getIcon(Model.Indicator indicator) {
        return indicator.getType() != 0 ? R.drawable.drawable_button_grey : R.drawable.drawable_button_red;
    }

    private final int getText(Model.Indicator indicator) {
        return indicator.getType() != 0 ? this.unreadsResId : this.mentionResId;
    }

    private final void handleClick(Model.Indicator indicator, boolean z2) {
        AppBarLayout appBarLayout;
        int iMax = z2 ? Math.max(indicator.getIndex() - 3, 0) : Math.min(indicator.getIndex() + 3, this.getItemCount.invoke().intValue() - 1);
        if (!z2 && (appBarLayout = this.appBarLayout) != null) {
            appBarLayout.setExpanded(false);
        }
        if (AccessibilityUtils.INSTANCE.isReducedMotionEnabled()) {
            this.recycler.scrollToPosition(iMax);
        } else {
            this.recycler.smoothScrollToPosition(iMax);
        }
    }

    private final void handleVisibleRangeUpdate() {
        RecyclerView.LayoutManager layoutManager = this.recycler.getLayoutManager();
        if (!(layoutManager instanceof LinearLayoutManager)) {
            layoutManager = null;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        if (linearLayoutManager != null) {
            Model model = Model.INSTANCE.get(new IntRange(linearLayoutManager.findFirstVisibleItemPosition(), linearLayoutManager.findLastVisibleItemPosition()), this.data, this.unreadsEnabled);
            Model.Indicator topIndicator = model.getTopIndicator();
            if (topIndicator == null) {
                topIndicator = model.getBottomIndicator();
            }
            boolean z2 = model.getTopIndicator() != null;
            if (topIndicator == null && this.unreadsInitialized) {
                ViewExtensions.fadeOut$default(getBinding().a, 150L, null, null, 6, null);
            } else if (topIndicator != null) {
                ViewExtensions.fadeIn$default(getBinding().a, 150L, null, null, null, 14, null);
                getBinding().a.setOnClickListener(new AnonymousClass1(topIndicator, z2));
                this.unreadsInitialized = true;
                onConfigureView(topIndicator, z2);
            }
        }
    }

    private final void onConfigureView(Model.Indicator indicator, boolean indicatorUpwards) {
        getBinding().c.setBackgroundResource(getIcon(indicator));
        getBinding().f2300b.setText(getText(indicator));
        TextView textView = getBinding().f2300b;
        m.checkNotNullExpressionValue(textView, "binding.channelsListUnreads");
        DrawableCompat.setCompoundDrawablesCompat$default(textView, 0, 0, indicatorUpwards ? R.drawable.ic_arrow_upward_white_16dp : R.drawable.ic_arrow_downward_white_16dp, 0, 11, (Object) null);
        FrameLayout frameLayout = getBinding().a;
        m.checkNotNullExpressionValue(frameLayout, "it");
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) marginLayoutParams;
            LayoutParamsExtensionsKt.removeRuleCompat(layoutParams2, indicatorUpwards ? 8 : 6);
            layoutParams2.addRule(indicatorUpwards ? 6 : 8, this.recycler.getId());
        } else {
            if (!(marginLayoutParams instanceof CoordinatorLayout.LayoutParams)) {
                throw new IllegalStateException("Unread Layout Params unrecognized");
            }
            CoordinatorLayout.LayoutParams layoutParams3 = (CoordinatorLayout.LayoutParams) marginLayoutParams;
            layoutParams3.anchorGravity = indicatorUpwards ? 48 : 80;
            layoutParams3.gravity = indicatorUpwards ? 80 : 48;
        }
        FrameLayout frameLayout2 = getBinding().a;
        m.checkNotNullExpressionValue(frameLayout2, "binding.root");
        frameLayout2.setLayoutParams(marginLayoutParams);
        FrameLayout frameLayout3 = getBinding().a;
        m.checkNotNullExpressionValue(frameLayout3, "binding.root");
        frameLayout3.setImportantForAccessibility(4);
    }

    public final int getMentionResId() {
        return this.mentionResId;
    }

    public final boolean getUnreadsEnabled() {
        return this.unreadsEnabled;
    }

    public final int getUnreadsResId() {
        return this.unreadsResId;
    }

    public final void onDatasetChanged(List<? extends Object> data) {
        m.checkNotNullParameter(data, "data");
        this.data = data;
        CoroutineScope coroutineScope = ViewCoroutineScopeKt.getCoroutineScope(this.recycler);
        if (coroutineScope != null) {
            b.i.a.f.e.o.f.H0(coroutineScope, null, null, new AnonymousClass1(null), 3, null);
        }
    }

    public final void setMentionResId(int i) {
        this.mentionResId = i;
    }

    public final void setUnreadsEnabled(boolean z2) {
        this.unreadsEnabled = z2;
    }

    public final void setUnreadsResId(int i) {
        this.unreadsResId = i;
    }

    public /* synthetic */ WidgetChannelListUnreads(ViewStub viewStub, RecyclerView recyclerView, AppBarLayout appBarLayout, Function0 function0, int i, int i2, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewStub, recyclerView, (i3 & 4) != 0 ? null : appBarLayout, function0, (i3 & 16) != 0 ? R.string.new_mentions : i, (i3 & 32) != 0 ? R.string.new_unreads : i2, (i3 & 64) != 0 ? true : z2);
    }
}
