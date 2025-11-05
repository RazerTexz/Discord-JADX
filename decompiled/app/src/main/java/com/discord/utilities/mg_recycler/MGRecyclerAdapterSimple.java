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
import com.discord.utilities.recycler.DiffCreator;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.g0;
import d0.t.n;
import d0.z.d.m;
import d0.z.d.o;
import j0.p.a;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

/* compiled from: MGRecyclerAdapterSimple.kt */
/* loaded from: classes2.dex */
public abstract class MGRecyclerAdapterSimple<D extends MGRecyclerDataPayload> extends MGRecyclerAdapter<D> {
    private final boolean deferredDiffs;
    private final DiffCreator<List<D>, MGRecyclerViewHolder<MGRecyclerAdapterSimple<D>, D>> diffCreator;
    private Subscription diffingSubscription;
    private List<? extends D> internalData;
    private Function2<? super List<? extends D>, ? super List<? extends D>, Unit> onUpdated;

    /* compiled from: MGRecyclerAdapterSimple.kt */
    /* renamed from: com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple$setData$1, reason: invalid class name */
    public static final class AnonymousClass1<V> implements Callable<DiffUtil.DiffResult> {
        public final /* synthetic */ List $newData;
        public final /* synthetic */ List $oldData;

        public AnonymousClass1(List list, List list2) {
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

    /* compiled from: MGRecyclerAdapterSimple.kt */
    /* renamed from: com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple$setData$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<DiffUtil.DiffResult, Unit> {
        public final /* synthetic */ List $newData;
        public final /* synthetic */ List $oldData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(List list, List list2) {
            super(1);
            this.$oldData = list;
            this.$newData = list2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DiffUtil.DiffResult diffResult) {
            invoke2(diffResult);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DiffUtil.DiffResult diffResult) {
            MGRecyclerAdapterSimple.access$dispatchUpdates(MGRecyclerAdapterSimple.this, diffResult, this.$oldData, this.$newData);
        }
    }

    /* compiled from: MGRecyclerAdapterSimple.kt */
    /* renamed from: com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple$setData$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function1<Error, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            m.checkNotNullParameter(error, "error");
            MGRecyclerAdapterSimple mGRecyclerAdapterSimple = MGRecyclerAdapterSimple.this;
            Throwable throwable = error.getThrowable();
            m.checkNotNullExpressionValue(throwable, "error.throwable");
            MGRecyclerAdapterSimple.access$handleError(mGRecyclerAdapterSimple, throwable);
        }
    }

    /* compiled from: MGRecyclerAdapterSimple.kt */
    /* renamed from: com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple$setData$4, reason: invalid class name */
    public static final class AnonymousClass4 extends o implements Function1<Subscription, Unit> {
        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            m.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
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
        AppLog.g.e("Unable to configure recycler.", throwable, g0.mapOf(d0.o.to("adapterClass", getClass().getSimpleName())));
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
        m.checkNotNullParameter(data, "data");
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
        Observable observableX = Observable.D(new AnonymousClass1(list, data)).X(a.a());
        m.checkNotNullExpressionValue(observableX, "Observable\n            .…Schedulers.computation())");
        Observable observableUi = ObservableExtensionsKt.ui(observableX);
        Class<?> cls = getClass();
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(list, data);
        ObservableExtensionsKt.appSubscribe$default(observableUi, cls, (Context) null, new AnonymousClass4(), new AnonymousClass3(), (Function0) null, (Function0) null, anonymousClass2, 50, (Object) null);
    }

    public final void setOnUpdated(Function2<? super List<? extends D>, ? super List<? extends D>, Unit> onUpdated) {
        m.checkNotNullParameter(onUpdated, "onUpdated");
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
        m.checkNotNullParameter(recyclerView, "recycler");
        this.deferredDiffs = z2;
        this.internalData = n.emptyList();
        this.diffCreator = new DiffCreator<>(null);
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerAdapter
    public D getItem(int position) {
        return this.internalData.get(position);
    }
}
