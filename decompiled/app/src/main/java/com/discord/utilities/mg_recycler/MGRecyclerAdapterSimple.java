package com.discord.utilities.mg_recycler;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.recycler.DiffCreator;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.Tuples;
import p507d0.p580t.Collections2;
import p507d0.p580t.MapsJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p653p.Schedulers2;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: MGRecyclerAdapterSimple.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class MGRecyclerAdapterSimple<D extends MGRecyclerDataPayload> extends MGRecyclerAdapter<D> {
    private final boolean deferredDiffs;
    private final DiffCreator<List<D>, MGRecyclerViewHolder<MGRecyclerAdapterSimple<D>, D>> diffCreator;
    private Subscription diffingSubscription;
    private List<? extends D> internalData;
    private Function2<? super List<? extends D>, ? super List<? extends D>, Unit> onUpdated;

    /* JADX INFO: renamed from: com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple$setData$1 */
    /* JADX INFO: compiled from: MGRecyclerAdapterSimple.kt */
    public static final class CallableC68151<V> implements Callable<DiffUtil.DiffResult> {
        public final /* synthetic */ List $newData;
        public final /* synthetic */ List $oldData;

        public CallableC68151(List list, List list2) {
            this.$oldData = list;
            this.$newData = list2;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ DiffUtil.DiffResult call() {
            return call();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public final DiffUtil.DiffResult call() {
            return MGRecyclerAdapterSimple.access$getDiffCreator$p(MGRecyclerAdapterSimple.this).calculateDiffResult(this.$oldData, this.$newData);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple$setData$2 */
    /* JADX INFO: compiled from: MGRecyclerAdapterSimple.kt */
    public static final class C68162 extends Lambda implements Function1<DiffUtil.DiffResult, Unit> {
        public final /* synthetic */ List $newData;
        public final /* synthetic */ List $oldData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C68162(List list, List list2) {
            super(1);
            this.$oldData = list;
            this.$newData = list2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DiffUtil.DiffResult diffResult) {
            invoke2(diffResult);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DiffUtil.DiffResult diffResult) {
            MGRecyclerAdapterSimple.access$dispatchUpdates(MGRecyclerAdapterSimple.this, diffResult, this.$oldData, this.$newData);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple$setData$3 */
    /* JADX INFO: compiled from: MGRecyclerAdapterSimple.kt */
    public static final class C68173 extends Lambda implements Function1<Error, Unit> {
        public C68173() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            MGRecyclerAdapterSimple mGRecyclerAdapterSimple = MGRecyclerAdapterSimple.this;
            Throwable throwable = error.getThrowable();
            Intrinsics3.checkNotNullExpressionValue(throwable, "error.throwable");
            MGRecyclerAdapterSimple.access$handleError(mGRecyclerAdapterSimple, throwable);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple$setData$4 */
    /* JADX INFO: compiled from: MGRecyclerAdapterSimple.kt */
    public static final class C68184 extends Lambda implements Function1<Subscription, Unit> {
        public C68184() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            MGRecyclerAdapterSimple.access$setDiffingSubscription$p(MGRecyclerAdapterSimple.this, subscription);
        }
    }

    public MGRecyclerAdapterSimple(RecyclerView recyclerView) {
        this(recyclerView, false, 2, null);
    }

    public /* synthetic */ MGRecyclerAdapterSimple(RecyclerView recyclerView, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(recyclerView, (i & 2) != 0 ? true : z2);
    }

    public static final /* synthetic */ void access$dispatchUpdates(MGRecyclerAdapterSimple mGRecyclerAdapterSimple, DiffUtil.DiffResult diffResult, List list, List list2) {
        mGRecyclerAdapterSimple.dispatchUpdates(diffResult, list, list2);
    }

    public static final /* synthetic */ DiffCreator access$getDiffCreator$p(MGRecyclerAdapterSimple mGRecyclerAdapterSimple) {
        return mGRecyclerAdapterSimple.diffCreator;
    }

    public static final /* synthetic */ Subscription access$getDiffingSubscription$p(MGRecyclerAdapterSimple mGRecyclerAdapterSimple) {
        return mGRecyclerAdapterSimple.diffingSubscription;
    }

    public static final /* synthetic */ void access$handleError(MGRecyclerAdapterSimple mGRecyclerAdapterSimple, Throwable th) {
        mGRecyclerAdapterSimple.handleError(th);
    }

    public static final /* synthetic */ void access$setDiffingSubscription$p(MGRecyclerAdapterSimple mGRecyclerAdapterSimple, Subscription subscription) {
        mGRecyclerAdapterSimple.diffingSubscription = subscription;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    private final void dispatchUpdates(DiffUtil.DiffResult diffResult, List<? extends D> oldData, List<? extends D> newData) {
        this.internalData = newData;
        if (diffResult != null) {
            diffResult.dispatchUpdatesTo(this);
        } else {
            notifyDataSetChanged();
        }
        Function2<? super List<? extends D>, ? super List<? extends D>, Unit> function2 = this.onUpdated;
        if (function2 != null) {
            function2.invoke(oldData, newData);
        }
    }

    private final void handleError(Throwable throwable) {
        AppLog.f14950g.mo8364e("Unable to configure recycler.", throwable, MapsJVM.mapOf(Tuples.m10073to("adapterClass", getClass().getSimpleName())));
    }

    public final List<D> getInternalData() {
        return this.internalData;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerAdapter
    public /* bridge */ /* synthetic */ Object getItem(int i) {
        return getItem(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.internalData.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return getItem(position).getType();
    }

    public void setData(List<? extends D> data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        unsubscribeFromUpdates();
        List<? extends D> list = this.internalData;
        if (list.isEmpty()) {
            dispatchUpdates(null, list, data);
            return;
        }
        if (!this.deferredDiffs) {
            try {
                dispatchUpdates(this.diffCreator.calculateDiffResult(list, data), list, data);
                return;
            } catch (Throwable th) {
                handleError(th);
                return;
            }
        }
        Observable observableM11098X = Observable.m11060D(new CallableC68151(list, data)).m11098X(Schedulers2.m10873a());
        Intrinsics3.checkNotNullExpressionValue(observableM11098X, "Observable\n            .…Schedulers.computation())");
        Observable observableM8518ui = ObservableExtensionsKt.m8518ui(observableM11098X);
        Class<?> cls = getClass();
        C68162 c68162 = new C68162(list, data);
        ObservableExtensionsKt.appSubscribe$default(observableM8518ui, cls, (Context) null, new C68184(), new C68173(), (Function0) null, (Function0) null, c68162, 50, (Object) null);
    }

    public final void setOnUpdated(Function2<? super List<? extends D>, ? super List<? extends D>, Unit> onUpdated) {
        Intrinsics3.checkNotNullParameter(onUpdated, "onUpdated");
        this.onUpdated = onUpdated;
    }

    public final void unsubscribeFromUpdates() {
        Subscription subscription = this.diffingSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.diffingSubscription = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MGRecyclerAdapterSimple(RecyclerView recyclerView, boolean z2) {
        super(recyclerView);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        this.deferredDiffs = z2;
        this.internalData = Collections2.emptyList();
        this.diffCreator = new DiffCreator<>(null);
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerAdapter
    public D getItem(int position) {
        return this.internalData.get(position);
    }
}
