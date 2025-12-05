package com.discord.widgets.chat.input.expression;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.app.NotificationCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.p501rx.LeadingEdgeThrottle;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.views.StickyHeaderItemDecoration;
import com.discord.widgets.chat.input.ExpressionPickerItemDecoration;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p579g0.Indent;
import p507d0.p580t.Collections2;
import p507d0.p580t.SetsJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p642l.p643a.OnSubscribeLift;
import p658rx.Emitter;
import p658rx.Observable;
import p658rx.functions.Action1;

/* compiled from: WidgetExpressionPickerAdapter.kt */
/* loaded from: classes2.dex */
public abstract class WidgetExpressionPickerAdapter extends MGRecyclerAdapterSimple<MGRecyclerDataPayload> implements StickyHeaderItemDecoration.StickyHeaderAdapter {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int ITEM_TYPE_HEADER = 0;
    public List<Integer> headerIndices;
    private final Set<Integer> headerTypes;
    private ExpressionPickerItemDecoration itemDecoration;
    private RecyclerView.OnScrollListener onScrollListener;
    private Function1<? super Integer, Unit> onScrollPositionListener;
    public StickyHeadersManager stickyHeaderManager;

    /* compiled from: WidgetExpressionPickerAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public final int calculateNumOfColumns(int margin, float itemSize, int defaultNumColumns, Resources resources) {
            Intrinsics3.checkNotNullParameter(resources, "resources");
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            int i = (int) ((displayMetrics.widthPixels - margin) / itemSize);
            if (i != 0) {
                return i;
            }
            AppLog appLog = AppLog.f14950g;
            StringBuilder sbM833U = outline.m833U("\n          invalid dimensions while calculating numColumns\n          displayMetrics.widthPixels: ");
            sbM833U.append(displayMetrics.widthPixels);
            sbM833U.append("\n          total margin marginStart: ");
            sbM833U.append(margin);
            sbM833U.append("\n          itemSize: ");
            sbM833U.append(itemSize);
            sbM833U.append("\n        ");
            Logger.e$default(appLog, Indent.trimIndent(sbM833U.toString()), null, null, 6, null);
            return defaultNumColumns;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int calculateNumOfColumns(RecyclerView recyclerView, float itemSize, int defaultNumColumns) {
            Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
            ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
            int marginStart = layoutParams instanceof ViewGroup.MarginLayoutParams ? MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) layoutParams) : 0;
            ViewGroup.LayoutParams layoutParams2 = recyclerView.getLayoutParams();
            int marginEnd = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams) layoutParams2) : 0;
            Resources resources = recyclerView.getResources();
            Intrinsics3.checkNotNullExpressionValue(resources, "recyclerView.resources");
            return calculateNumOfColumns(marginStart + marginEnd, itemSize, defaultNumColumns, resources);
        }
    }

    /* compiled from: WidgetExpressionPickerAdapter.kt */
    public interface StickyHeaderViewHolder {
        void bind(int position, MGRecyclerDataPayload data);

        View getItemView();
    }

    /* compiled from: WidgetExpressionPickerAdapter.kt */
    public static final class StickyHeadersManager {
        private final View currentStickyHeaderView;
        private final StickyHeaderViewHolder stickyHeaderHolder;

        public StickyHeadersManager(WidgetExpressionPickerAdapter widgetExpressionPickerAdapter) {
            Intrinsics3.checkNotNullParameter(widgetExpressionPickerAdapter, "adapter");
            StickyHeaderViewHolder stickyHeaderViewHolderCreateStickyHeaderViewHolder = widgetExpressionPickerAdapter.createStickyHeaderViewHolder(widgetExpressionPickerAdapter);
            this.stickyHeaderHolder = stickyHeaderViewHolderCreateStickyHeaderViewHolder;
            this.currentStickyHeaderView = stickyHeaderViewHolderCreateStickyHeaderViewHolder.getItemView();
        }

        public final View getCurrentStickyHeaderView() {
            return this.currentStickyHeaderView;
        }

        public final StickyHeaderViewHolder getStickyHeaderHolder() {
            return this.stickyHeaderHolder;
        }

        public final void layoutViews(RecyclerView recyclerView) {
            Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
            View view = this.currentStickyHeaderView;
            if (view != null) {
                StickyHeaderItemDecoration.LayoutManager.layoutHeaderView(recyclerView, view);
            }
        }
    }

    /* compiled from: WidgetExpressionPickerAdapter.kt */
    /* renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter$onAttachedToRecyclerView$1 */
    public static final class ViewOnLayoutChangeListenerC78431 implements View.OnLayoutChangeListener {
        public final /* synthetic */ RecyclerView $recyclerView;

        public ViewOnLayoutChangeListenerC78431(RecyclerView recyclerView) {
            this.$recyclerView = recyclerView;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            WidgetExpressionPickerAdapter.this.getStickyHeaderManager().layoutViews(this.$recyclerView);
        }
    }

    /* compiled from: WidgetExpressionPickerAdapter.kt */
    /* renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter$setupScrollObservables$1 */
    public static final class C78441<T> implements Action1<Emitter<Unit>> {

        /* compiled from: WidgetExpressionPickerAdapter.kt */
        /* renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter$setupScrollObservables$1$1, reason: invalid class name */
        public static final class AnonymousClass1 extends RecyclerView.OnScrollListener {
            public final /* synthetic */ Emitter $emitter;

            public AnonymousClass1(Emitter emitter) {
                this.$emitter = emitter;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
                super.onScrolled(recyclerView, dx, dy);
                this.$emitter.onNext(Unit.f27425a);
            }
        }

        public C78441() {
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Emitter<Unit> emitter) {
            call2(emitter);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Emitter<Unit> emitter) {
            Intrinsics3.checkNotNullParameter(emitter, "emitter");
            WidgetExpressionPickerAdapter.this.setOnScrollListener(new AnonymousClass1(emitter));
        }
    }

    /* compiled from: WidgetExpressionPickerAdapter.kt */
    /* renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter$setupScrollObservables$2 */
    public static final class C78452 extends Lambda implements Function1<Unit, Unit> {
        public C78452() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
            invoke2(unit);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unit unit) {
            WidgetExpressionPickerAdapter.this.getOnScrollPositionListener().invoke(Integer.valueOf(WidgetExpressionPickerAdapter.this.getLayoutManager().findFirstVisibleItemPosition()));
        }
    }

    public /* synthetic */ WidgetExpressionPickerAdapter(RecyclerView recyclerView, Set set, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(recyclerView, (i & 2) != 0 ? SetsJVM.setOf(0) : set);
    }

    private final void setupScrollObservables() {
        Observable observableM11080o = Observable.m11080o(new C78441(), Emitter.BackpressureMode.LATEST);
        Observable observableM11074h0 = Observable.m11074h0(new OnSubscribeLift(observableM11080o.f27640j, new LeadingEdgeThrottle(250L, TimeUnit.MILLISECONDS)));
        Intrinsics3.checkNotNullExpressionValue(observableM11074h0, "Observable\n        .crea…, TimeUnit.MILLISECONDS))");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.m8518ui(observableM11074h0), getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C78452(), 62, (Object) null);
        RecyclerView.OnScrollListener onScrollListener = this.onScrollListener;
        if (onScrollListener != null) {
            getRecycler().addOnScrollListener(onScrollListener);
        }
    }

    public abstract StickyHeaderViewHolder createStickyHeaderViewHolder(WidgetExpressionPickerAdapter adapter);

    @Override // com.discord.utilities.views.StickyHeaderItemDecoration.StickyHeaderAdapter
    public View getAndBindHeaderView(int position) {
        MGRecyclerDataPayload mGRecyclerDataPayload = getInternalData().get(position);
        StickyHeadersManager stickyHeadersManager = this.stickyHeaderManager;
        if (stickyHeadersManager == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("stickyHeaderManager");
        }
        stickyHeadersManager.getStickyHeaderHolder().bind(position, mGRecyclerDataPayload);
        StickyHeadersManager stickyHeadersManager2 = this.stickyHeaderManager;
        if (stickyHeadersManager2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("stickyHeaderManager");
        }
        return stickyHeadersManager2.getCurrentStickyHeaderView();
    }

    public final List<Integer> getHeaderIndices() {
        List<Integer> list = this.headerIndices;
        if (list == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("headerIndices");
        }
        return list;
    }

    @Override // com.discord.utilities.views.StickyHeaderItemDecoration.StickyHeaderAdapter
    public Integer getHeaderPositionForItem(int itemPosition) {
        Integer numPrevious;
        List<Integer> list = this.headerIndices;
        if (list == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("headerIndices");
        }
        ListIterator<Integer> listIterator = list.listIterator(list.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                numPrevious = null;
                break;
            }
            numPrevious = listIterator.previous();
            if (itemPosition >= numPrevious.intValue()) {
                break;
            }
        }
        Integer num = numPrevious;
        if (num == null) {
            AppLog appLog = AppLog.f14950g;
            StringBuilder sbM833U = outline.m833U("failed to find header position for item in ");
            sbM833U.append(getClass().getName());
            Logger.w$default(appLog, sbM833U.toString(), null, 2, null);
        }
        return num;
    }

    public final Set<Integer> getHeaderTypes() {
        return this.headerTypes;
    }

    public final ExpressionPickerItemDecoration getItemDecoration() {
        return this.itemDecoration;
    }

    public abstract GridLayoutManager getLayoutManager();

    public abstract int getNumColumns();

    public final RecyclerView.OnScrollListener getOnScrollListener() {
        return this.onScrollListener;
    }

    public final Function1<Integer, Unit> getOnScrollPositionListener() {
        return this.onScrollPositionListener;
    }

    public final StickyHeadersManager getStickyHeaderManager() {
        StickyHeadersManager stickyHeadersManager = this.stickyHeaderManager;
        if (stickyHeadersManager == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("stickyHeaderManager");
        }
        return stickyHeadersManager;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        this.stickyHeaderManager = new StickyHeadersManager(this);
        recyclerView.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC78431(recyclerView));
    }

    public final void scrollToPosition(int position) {
        RecyclerView.OnScrollListener onScrollListener = this.onScrollListener;
        if (onScrollListener != null) {
            getRecycler().removeOnScrollListener(onScrollListener);
        }
        getLayoutManager().scrollToPositionWithOffset(position, 0);
        RecyclerView.OnScrollListener onScrollListener2 = this.onScrollListener;
        if (onScrollListener2 != null) {
            getRecycler().addOnScrollListener(onScrollListener2);
        }
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple
    public void setData(List<? extends MGRecyclerDataPayload> data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.setData(data);
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (Object obj : data) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            Integer numValueOf = this.headerTypes.contains(Integer.valueOf(((MGRecyclerDataPayload) obj).getType())) ? Integer.valueOf(i) : null;
            if (numValueOf != null) {
                arrayList.add(numValueOf);
            }
            i = i2;
        }
        this.headerIndices = arrayList;
        ExpressionPickerItemDecoration expressionPickerItemDecoration = this.itemDecoration;
        if (expressionPickerItemDecoration != null) {
            getRecycler().removeItemDecoration(expressionPickerItemDecoration);
        }
        int numColumns = getNumColumns();
        List<Integer> list = this.headerIndices;
        if (list == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("headerIndices");
        }
        ExpressionPickerItemDecoration expressionPickerItemDecoration2 = new ExpressionPickerItemDecoration(numColumns, list, DimenUtils.dpToPixels(8));
        getRecycler().addItemDecoration(expressionPickerItemDecoration2);
        this.itemDecoration = expressionPickerItemDecoration2;
    }

    public final void setHeaderIndices(List<Integer> list) {
        Intrinsics3.checkNotNullParameter(list, "<set-?>");
        this.headerIndices = list;
    }

    public final void setItemDecoration(ExpressionPickerItemDecoration expressionPickerItemDecoration) {
        this.itemDecoration = expressionPickerItemDecoration;
    }

    public final void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.onScrollListener = onScrollListener;
    }

    public final void setOnScrollPositionListener(Function1<? super Integer, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "<set-?>");
        this.onScrollPositionListener = function1;
    }

    public final void setStickyHeaderManager(StickyHeadersManager stickyHeadersManager) {
        Intrinsics3.checkNotNullParameter(stickyHeadersManager, "<set-?>");
        this.stickyHeaderManager = stickyHeadersManager;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetExpressionPickerAdapter(RecyclerView recyclerView, Set<Integer> set) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        Intrinsics3.checkNotNullParameter(set, "headerTypes");
        this.headerTypes = set;
        this.onScrollPositionListener = WidgetExpressionPickerAdapter2.INSTANCE;
        setupScrollObservables();
    }
}
