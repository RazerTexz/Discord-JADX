package com.discord.stores.updates;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.logging.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$ObjectRef;
import p007b.p100d.p104b.p105a.outline;
import p507d0.Tuples;
import p507d0.p580t.Maps6;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p641k.Func1;
import p658rx.Emitter;
import p658rx.Observable;
import p658rx.functions.Action0;
import p658rx.functions.Action1;

/* JADX INFO: compiled from: ObservationDeck.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ObservationDeck {
    private static final String LOG_CATEGORY = "ObservationDeck";
    private final LogLevel logLevel;
    private final Logger logger;
    private List<Observer> observers;
    private static final Function0<Unit> ON_UPDATE_EMPTY = ObservationDeck2.INSTANCE;

    /* JADX INFO: compiled from: ObservationDeck.kt */
    public enum LogLevel {
        NONE,
        ERROR,
        VERBOSE
    }

    /* JADX INFO: compiled from: ObservationDeck.kt */
    public static abstract class Observer {
        private boolean isStale;

        public abstract String getName();

        public abstract Set<UpdateSource> getObservingUpdates();

        public abstract Function0<Unit> getOnUpdate();

        /* JADX INFO: renamed from: isStale, reason: from getter */
        public final boolean getIsStale() {
            return this.isStale;
        }

        public final void markStale() {
            this.isStale = true;
            setOnUpdate(ObservationDeck.access$getON_UPDATE_EMPTY$cp());
        }

        public abstract void setOnUpdate(Function0<Unit> function0);

        public final String toDebugLogString() {
            StringBuilder sb = new StringBuilder();
            StringBuilder sbM833U = outline.m833U("Observer name: ");
            String name = getName();
            if (name == null) {
                name = "Unknown";
            }
            sbM833U.append(name);
            sbM833U.append('\n');
            sb.append(sbM833U.toString());
            sb.append(_Collections.joinToString$default(getObservingUpdates(), ", ", null, null, 0, null, null, 62, null));
            String string = sb.toString();
            Intrinsics3.checkNotNullExpressionValue(string, "stringBuilder.toString()");
            return string;
        }
    }

    /* JADX INFO: compiled from: ObservationDeck.kt */
    public interface UpdateSource {
    }

    /* JADX INFO: renamed from: com.discord.stores.updates.ObservationDeck$connectRx$1 */
    /* JADX INFO: compiled from: ObservationDeck.kt */
    public static final class C66321<T> implements Action1<Emitter<Unit>> {
        public final /* synthetic */ Ref$ObjectRef $observer;
        public final /* synthetic */ String $observerName;
        public final /* synthetic */ boolean $updateOnConnect;
        public final /* synthetic */ UpdateSource[] $updateSources;

        /* JADX INFO: renamed from: com.discord.stores.updates.ObservationDeck$connectRx$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: ObservationDeck.kt */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Emitter $emitter;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Emitter emitter) {
                super(0);
                this.$emitter = emitter;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.$emitter.onNext(Unit.f27425a);
            }
        }

        public C66321(Ref$ObjectRef ref$ObjectRef, boolean z2, String str, UpdateSource[] updateSourceArr) {
            this.$observer = ref$ObjectRef;
            this.$updateOnConnect = z2;
            this.$observerName = str;
            this.$updateSources = updateSourceArr;
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Emitter<Unit> emitter) {
            call2(emitter);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Emitter<Unit> emitter) {
            Ref$ObjectRef ref$ObjectRef = this.$observer;
            ObservationDeck observationDeck = ObservationDeck.this;
            boolean z2 = this.$updateOnConnect;
            String str = this.$observerName;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(emitter);
            UpdateSource[] updateSourceArr = this.$updateSources;
            ref$ObjectRef.element = (T) observationDeck.connect((UpdateSource[]) Arrays.copyOf(updateSourceArr, updateSourceArr.length), z2, str, anonymousClass1);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.updates.ObservationDeck$connectRx$2 */
    /* JADX INFO: compiled from: ObservationDeck.kt */
    public static final class C66332 implements Action0 {
        public final /* synthetic */ Ref$ObjectRef $observer;

        public C66332(Ref$ObjectRef ref$ObjectRef) {
            this.$observer = ref$ObjectRef;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p658rx.functions.Action0
        public final void call() {
            Observer observer = (Observer) this.$observer.element;
            if (observer != null) {
                ObservationDeck.this.disconnect(observer);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.updates.ObservationDeck$connectRx$3 */
    /* JADX INFO: compiled from: ObservationDeck.kt */
    public static final class C66343<T, R> implements Func1<Unit, T> {
        public final /* synthetic */ Function0 $generator;

        public C66343(Function0 function0) {
            this.$generator = function0;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Object call(Unit unit) {
            return call2(unit);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final T call2(Unit unit) {
            return (T) this.$generator.invoke();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.updates.ObservationDeck$logNotifyError$2 */
    /* JADX INFO: compiled from: ObservationDeck.kt */
    public static final class C66352 extends Lambda implements Function1<Observer, CharSequence> {
        public static final C66352 INSTANCE = new C66352();

        public C66352() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CharSequence invoke(Observer observer) {
            return invoke2(observer);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final CharSequence invoke2(Observer observer) {
            Intrinsics3.checkNotNullParameter(observer, "observer");
            return observer.toDebugLogString();
        }
    }

    public ObservationDeck() {
        this(null, null, 3, null);
    }

    public ObservationDeck(Logger logger, LogLevel logLevel) {
        Intrinsics3.checkNotNullParameter(logger, "logger");
        Intrinsics3.checkNotNullParameter(logLevel, "logLevel");
        this.logger = logger;
        this.logLevel = logLevel;
        this.observers = new ArrayList();
    }

    public static final /* synthetic */ Function0 access$getON_UPDATE_EMPTY$cp() {
        return ON_UPDATE_EMPTY;
    }

    public static /* synthetic */ Observer connect$default(ObservationDeck observationDeck, UpdateSource[] updateSourceArr, boolean z2, String str, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        if ((i & 4) != 0) {
            str = null;
        }
        return observationDeck.connect(updateSourceArr, z2, str, function0);
    }

    public static /* synthetic */ Observable connectRx$default(ObservationDeck observationDeck, UpdateSource[] updateSourceArr, boolean z2, Emitter.BackpressureMode backpressureMode, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        if ((i & 4) != 0) {
            backpressureMode = Emitter.BackpressureMode.LATEST;
        }
        if ((i & 8) != 0) {
            str = null;
        }
        return observationDeck.connectRx(updateSourceArr, z2, backpressureMode, str);
    }

    private final void logBreadcrumb(String message) {
        if (this.logLevel == LogLevel.VERBOSE) {
            this.logger.recordBreadcrumb(message, LOG_CATEGORY);
        }
    }

    private final void logNotifyError(Throwable throwable, Set<? extends UpdateSource> updates) {
        Logger logger = this.logger;
        Tuples2[] tuples2Arr = new Tuples2[2];
        tuples2Arr[0] = Tuples.m10073to("Update Sources", _Collections.joinToString$default(updates, ", ", null, null, 0, null, null, 62, null));
        List<Observer> list = this.observers;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            boolean z2 = true;
            if (!it.hasNext()) {
                tuples2Arr[1] = Tuples.m10073to("Observers", _Collections.joinToString$default(arrayList, "\n", null, null, 0, null, C66352.INSTANCE, 30, null));
                logger.mo8364e("ObservationDeck notify error", throwable, Maps6.mapOf(tuples2Arr));
                return;
            }
            Object next = it.next();
            Observer observer = (Observer) next;
            if ((updates instanceof Collection) && updates.isEmpty()) {
                z2 = false;
            } else {
                Iterator<T> it2 = updates.iterator();
                while (it2.hasNext()) {
                    if (observer.getObservingUpdates().contains((UpdateSource) it2.next())) {
                        break;
                    }
                }
                z2 = false;
            }
            if (z2) {
                arrayList.add(next);
            }
        }
    }

    public final synchronized Observer connect(UpdateSource[] updateSources, boolean updateOnConnect, String observerName, Function0<Unit> onUpdate) {
        ObservationDeck3 observationDeck3;
        Intrinsics3.checkNotNullParameter(updateSources, "updateSources");
        Intrinsics3.checkNotNullParameter(onUpdate, "onUpdate");
        observationDeck3 = new ObservationDeck3(updateSources, onUpdate, observerName);
        connect(observationDeck3, updateOnConnect);
        return observationDeck3;
    }

    public final synchronized Observable<Unit> connectRx(UpdateSource[] updateSources, boolean updateOnConnect, Emitter.BackpressureMode backpressureMode, String observerName) {
        Observable<Unit> observableM11117w;
        Intrinsics3.checkNotNullParameter(updateSources, "updateSources");
        Intrinsics3.checkNotNullParameter(backpressureMode, "backpressureMode");
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = null;
        observableM11117w = Observable.m11080o(new C66321(ref$ObjectRef, updateOnConnect, observerName, updateSources), backpressureMode).m11117w(new C66332(ref$ObjectRef));
        Intrinsics3.checkNotNullExpressionValue(observableM11117w, "Observable.create<Unit>(…rver?.let(::disconnect) }");
        return observableM11117w;
    }

    public final synchronized void disconnect(Observer observer) {
        Intrinsics3.checkNotNullParameter(observer, "observer");
        logBreadcrumb("disconnect START. observer: " + observer.getName());
        observer.markStale();
        logBreadcrumb("disconnect END. observer: " + observer.getName());
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x006e A[Catch: all -> 0x007d, TRY_LEAVE, TryCatch #2 {all -> 0x007d, blocks: (B:5:0x000e, B:7:0x0016, B:9:0x0025, B:10:0x0045, B:12:0x0049, B:22:0x006e, B:15:0x0051, B:16:0x0055, B:18:0x005b), top: B:44:0x000e, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0075 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void notify(Set<? extends UpdateSource> updates) {
        String str;
        boolean z2;
        Intrinsics3.checkNotNullParameter(updates, "updates");
        logBreadcrumb("notify START");
        int i = 0;
        while (i < this.observers.size()) {
            try {
                Observer observer = this.observers.get(i);
                if (observer.getIsStale()) {
                    logBreadcrumb("removing observer: " + observer.getName());
                    this.observers.remove(i);
                    i += -1;
                } else if ((updates instanceof Collection) && updates.isEmpty()) {
                    z2 = false;
                    if (!z2) {
                    }
                } else {
                    Iterator<T> it = updates.iterator();
                    while (it.hasNext()) {
                        if (observer.getObservingUpdates().contains((UpdateSource) it.next())) {
                            z2 = true;
                            break;
                        }
                    }
                    z2 = false;
                    if (!z2) {
                        observer.getOnUpdate().invoke();
                    }
                }
                i++;
            } catch (Throwable th) {
                try {
                    if (this.logLevel.compareTo(LogLevel.ERROR) < 0) {
                        throw th;
                    }
                    logNotifyError(th, updates);
                    str = "notify END";
                } catch (Throwable th2) {
                    logBreadcrumb("notify END");
                    throw th2;
                }
            }
        }
        str = "notify END";
        logBreadcrumb(str);
    }

    public static /* synthetic */ Observer connect$default(ObservationDeck observationDeck, Observer observer, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        return observationDeck.connect(observer, z2);
    }

    public /* synthetic */ ObservationDeck(Logger logger, LogLevel logLevel, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? AppLog.f14950g : logger, (i & 2) != 0 ? LogLevel.NONE : logLevel);
    }

    public static /* synthetic */ Observable connectRx$default(ObservationDeck observationDeck, UpdateSource[] updateSourceArr, boolean z2, Emitter.BackpressureMode backpressureMode, String str, Function0 function0, int i, Object obj) {
        boolean z3 = (i & 2) != 0 ? true : z2;
        if ((i & 4) != 0) {
            backpressureMode = Emitter.BackpressureMode.LATEST;
        }
        Emitter.BackpressureMode backpressureMode2 = backpressureMode;
        if ((i & 8) != 0) {
            str = null;
        }
        return observationDeck.connectRx(updateSourceArr, z3, backpressureMode2, str, function0);
    }

    public final synchronized Observer connect(Observer observer, boolean updateOnConnect) {
        Intrinsics3.checkNotNullParameter(observer, "observer");
        logBreadcrumb("connect START. observer: " + observer.getName());
        this.observers.add(observer);
        if (updateOnConnect) {
            observer.getOnUpdate().invoke();
        }
        logBreadcrumb("connect END. observer: " + observer.getName() + " -- isStale: " + observer.getIsStale());
        return observer;
    }

    public final synchronized <T> Observable<T> connectRx(UpdateSource[] updateSources, boolean updateOnConnect, Emitter.BackpressureMode backpressureMode, String observerName, Function0<? extends T> generator) {
        Observable<T> observable;
        Intrinsics3.checkNotNullParameter(updateSources, "updateSources");
        Intrinsics3.checkNotNullParameter(backpressureMode, "backpressureMode");
        Intrinsics3.checkNotNullParameter(generator, "generator");
        observable = (Observable<T>) connectRx((UpdateSource[]) Arrays.copyOf(updateSources, updateSources.length), updateOnConnect, backpressureMode, observerName).m11083G(new C66343(generator));
        Intrinsics3.checkNotNullExpressionValue(observable, "connectRx(\n        *upda…    ).map { generator() }");
        return observable;
    }
}
