package com.discord.stores;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentActivity;
import b.d.b.a.a;
import com.discord.app.AppComponent;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.error.Error;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.widgets.home.WidgetHome;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import d0.e0.c;
import d0.g;
import d0.g0.w;
import d0.t.n;
import d0.t.u;
import d0.z.d.a0;
import d0.z.d.m;
import d0.z.d.o;
import j0.k.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* compiled from: StoreNotices.kt */
/* loaded from: classes2.dex */
public final class StoreNotices extends Store {
    public static final String IN_APP_NOTICE_TAG = "InAppNotif";
    public static final String NOTICE_POPUP_TAG = "Popup";
    public static final int PRIORITY_HIGH = 0;
    public static final int PRIORITY_INAPP_NOTIFICATION = 1;
    public static final int PRIORITY_PASSIVE_NOTICE = 10;
    public static final int PRIORITY_USER_SURVEY = 5;
    public static final long PROCESS_PERIOD_MS = 30000;
    public static final long PROCESS_THROTTLE_MS = 50;
    private final Clock clock;

    /* renamed from: firstUseTimestamp$delegate, reason: from kotlin metadata */
    private final Lazy firstUseTimestamp;
    private HashMap<Integer, Long> lastShownTimes;
    private final BehaviorSubject<Notice> noticePublisher;
    private final PriorityQueue<Notice> noticeQueue;
    private final Persister<HashMap<String, Long>> noticesSeenCache;
    private long pollRateMs;
    private final BehaviorSubject<Unit> processTrigger;
    private final StoreStream stream;

    /* compiled from: StoreNotices.kt */
    public static final /* data */ class Dialog {
        private final Map<String, Object> metadata;
        private final Type type;

        /* compiled from: StoreNotices.kt */
        public enum Type {
            REQUEST_RATING_MODAL,
            DELETE_CONNECTION_MODAL;

            public static /* synthetic */ PassiveNotice buildPassiveNotice$default(Type type, int i, long j, long j2, boolean z2, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = 10;
                }
                if ((i2 & 2) != 0) {
                    j = 31536000000L;
                }
                long j3 = j;
                if ((i2 & 4) != 0) {
                    j2 = 21600000;
                }
                return type.buildPassiveNotice(i, j3, j2, (i2 & 8) != 0 ? false : z2);
            }

            public final PassiveNotice buildPassiveNotice(int priority, long sinceLastPeriodMs, long delayPeriodMs, boolean persist) {
                return new PassiveNotice(name(), priority, persist, sinceLastPeriodMs, delayPeriodMs, new StoreNotices$Dialog$Type$buildPassiveNotice$1(this));
            }
        }

        public Dialog(Type type, Map<String, ? extends Object> map) {
            m.checkNotNullParameter(type, "type");
            this.type = type;
            this.metadata = map;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Dialog copy$default(Dialog dialog, Type type, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                type = dialog.type;
            }
            if ((i & 2) != 0) {
                map = dialog.metadata;
            }
            return dialog.copy(type, map);
        }

        /* renamed from: component1, reason: from getter */
        public final Type getType() {
            return this.type;
        }

        public final Map<String, Object> component2() {
            return this.metadata;
        }

        public final Dialog copy(Type type, Map<String, ? extends Object> metadata) {
            m.checkNotNullParameter(type, "type");
            return new Dialog(type, metadata);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Dialog)) {
                return false;
            }
            Dialog dialog = (Dialog) other;
            return m.areEqual(this.type, dialog.type) && m.areEqual(this.metadata, dialog.metadata);
        }

        public final Map<String, Object> getMetadata() {
            return this.metadata;
        }

        public final Type getType() {
            return this.type;
        }

        public int hashCode() {
            Type type = this.type;
            int iHashCode = (type != null ? type.hashCode() : 0) * 31;
            Map<String, Object> map = this.metadata;
            return iHashCode + (map != null ? map.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = a.U("Dialog(type=");
            sbU.append(this.type);
            sbU.append(", metadata=");
            return a.M(sbU, this.metadata, ")");
        }

        public /* synthetic */ Dialog(Type type, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(type, (i & 2) != 0 ? null : map);
        }
    }

    /* compiled from: StoreNotices.kt */
    public static final /* data */ class InputDialog {
        private final Type type;

        /* compiled from: StoreNotices.kt */
        public enum Type {
            PASSWORD,
            TEXT_NO_SUGGESTIONS
        }

        public InputDialog(Type type) {
            m.checkNotNullParameter(type, "type");
            this.type = type;
        }

        public static /* synthetic */ InputDialog copy$default(InputDialog inputDialog, Type type, int i, Object obj) {
            if ((i & 1) != 0) {
                type = inputDialog.type;
            }
            return inputDialog.copy(type);
        }

        /* renamed from: component1, reason: from getter */
        public final Type getType() {
            return this.type;
        }

        public final InputDialog copy(Type type) {
            m.checkNotNullParameter(type, "type");
            return new InputDialog(type);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof InputDialog) && m.areEqual(this.type, ((InputDialog) other).type);
            }
            return true;
        }

        public final Type getType() {
            return this.type;
        }

        public int hashCode() {
            Type type = this.type;
            if (type != null) {
                return type.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = a.U("InputDialog(type=");
            sbU.append(this.type);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: StoreNotices.kt */
    public static class Notice {
        private final boolean autoMarkSeen;
        private final Clock clock;
        private final long delayPeriodMs;
        private boolean hasShown;
        private final String name;
        private final boolean persist;
        private final int priority;
        private final long requestedShowTimestamp;
        private final Function1<FragmentActivity, Boolean> show;
        private final long sinceLastPeriodMs;
        private final List<c<? extends AppComponent>> validScreens;

        /* JADX WARN: Multi-variable type inference failed */
        public Notice(String str, Clock clock, long j, int i, boolean z2, List<? extends c<? extends AppComponent>> list, long j2, boolean z3, long j3, Function1<? super FragmentActivity, Boolean> function1) {
            m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            m.checkNotNullParameter(clock, "clock");
            m.checkNotNullParameter(function1, "show");
            this.name = str;
            this.clock = clock;
            this.requestedShowTimestamp = j;
            this.priority = i;
            this.persist = z2;
            this.validScreens = list;
            this.delayPeriodMs = j2;
            this.autoMarkSeen = z3;
            this.sinceLastPeriodMs = j3;
            this.show = function1;
        }

        public static /* synthetic */ void getHasShown$annotations() {
        }

        public boolean canShow(Long lastSeenMs) {
            return lastSeenMs == null || this.clock.currentTimeMillis() - lastSeenMs.longValue() > this.sinceLastPeriodMs;
        }

        public final boolean getAutoMarkSeen() {
            return this.autoMarkSeen;
        }

        public final Clock getClock() {
            return this.clock;
        }

        public final long getDelayPeriodMs() {
            return this.delayPeriodMs;
        }

        public final boolean getHasShown() {
            return this.hasShown;
        }

        public final String getName() {
            return this.name;
        }

        public final boolean getPersist() {
            return this.persist;
        }

        public final int getPriority() {
            return this.priority;
        }

        public final long getRequestedShowTimestamp() {
            return this.requestedShowTimestamp;
        }

        public final Function1<FragmentActivity, Boolean> getShow() {
            return this.show;
        }

        public final long getSinceLastPeriodMs() {
            return this.sinceLastPeriodMs;
        }

        public final List<c<? extends AppComponent>> getValidScreens() {
            return this.validScreens;
        }

        public final boolean isInAppNotification() {
            return w.contains((CharSequence) this.name, (CharSequence) StoreNotices.IN_APP_NOTICE_TAG, true);
        }

        public final boolean isPopup() {
            return w.contains((CharSequence) this.name, (CharSequence) StoreNotices.NOTICE_POPUP_TAG, true);
        }

        public final void setHasShown(boolean z2) {
            this.hasShown = z2;
        }

        public boolean shouldShow(Map<Integer, Long> lastShownTimes) {
            m.checkNotNullParameter(lastShownTimes, "lastShownTimes");
            Long l = lastShownTimes.get(Integer.valueOf(this.priority));
            return this.delayPeriodMs < this.clock.currentTimeMillis() - (l != null ? l.longValue() : 0L);
        }

        @MainThread
        public final boolean show(FragmentActivity activity) {
            m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            if (this.hasShown || activity.isFinishing()) {
                return false;
            }
            Boolean boolInvoke = this.show.invoke(activity);
            this.hasShown = boolInvoke.booleanValue();
            return boolInvoke.booleanValue();
        }

        public String toString() {
            StringBuilder sbU = a.U("Notice<");
            sbU.append(this.name);
            sbU.append(">(pri=");
            sbU.append(this.priority);
            sbU.append(", ts=");
            sbU.append(this.requestedShowTimestamp);
            sbU.append(')');
            return sbU.toString();
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ Notice(String str, Clock clock, long j, int i, boolean z2, List list, long j2, boolean z3, long j3, Function1 function1, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            Clock clock2 = (i2 & 2) != 0 ? ClockFactory.get() : clock;
            this(str, clock2, (i2 & 4) != 0 ? clock2.currentTimeMillis() : j, (i2 & 8) != 0 ? 10 : i, (i2 & 16) != 0 ? false : z2, (i2 & 32) != 0 ? n.listOf((Object[]) new c[]{a0.getOrCreateKotlinClass(WidgetHome.class), a0.getOrCreateKotlinClass(WidgetCallFullscreen.class)}) : list, (i2 & 64) != 0 ? 15000L : j2, (i2 & 128) != 0 ? false : z3, (i2 & 256) != 0 ? 31536000000L : j3, function1);
        }
    }

    /* compiled from: StoreNotices.kt */
    public static class PassiveNotice extends Notice {
        public /* synthetic */ PassiveNotice(String str, int i, boolean z2, long j, long j2, Function1 function1, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, (i2 & 4) != 0 ? false : z2, (i2 & 8) != 0 ? 31536000000L : j, (i2 & 16) != 0 ? 21600000L : j2, function1);
        }

        @Override // com.discord.stores.StoreNotices.Notice
        public boolean shouldShow(Map<Integer, Long> lastShownTimes) {
            m.checkNotNullParameter(lastShownTimes, "lastShownTimes");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator<Map.Entry<Integer, Long>> it = lastShownTimes.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Integer, Long> next = it.next();
                if (next.getKey().intValue() <= getPriority()) {
                    linkedHashMap.put(next.getKey(), next.getValue());
                }
            }
            Long l = (Long) u.maxOrNull((Iterable) linkedHashMap.values());
            return getDelayPeriodMs() < getClock().currentTimeMillis() - (l != null ? l.longValue() : 0L);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PassiveNotice(String str, int i, boolean z2, long j, long j2, Function1<? super FragmentActivity, Boolean> function1) {
            super(str, null, 0L, i, z2, null, j2, false, j, function1, Opcodes.IF_ACMPNE, null);
            m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            m.checkNotNullParameter(function1, "show");
        }
    }

    /* compiled from: StoreNotices.kt */
    /* renamed from: com.discord.stores.StoreNotices$clearSeen$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<HashMap<String, Long>, HashMap<String, Long>> {
        public final /* synthetic */ String $noticeName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(1);
            this.$noticeName = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ HashMap<String, Long> invoke(HashMap<String, Long> map) {
            return invoke2(map);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final HashMap<String, Long> invoke2(HashMap<String, Long> map) {
            m.checkNotNullParameter(map, "cache");
            map.remove(this.$noticeName);
            return map;
        }
    }

    /* compiled from: StoreNotices.kt */
    /* renamed from: com.discord.stores.StoreNotices$init$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<Unit, Observable<? extends Long>> {
        public AnonymousClass1() {
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Observable<? extends Long> call(Unit unit) {
            return call2(unit);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Long> call2(Unit unit) {
            return Observable.E(0L, StoreNotices.access$getPollRateMs$p(StoreNotices.this), TimeUnit.MILLISECONDS);
        }
    }

    /* compiled from: StoreNotices.kt */
    /* renamed from: com.discord.stores.StoreNotices$init$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Long, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            StoreNotices.access$processNextNotice(StoreNotices.this);
        }
    }

    /* compiled from: StoreNotices.kt */
    /* renamed from: com.discord.stores.StoreNotices$init$3, reason: invalid class name */
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
            m.checkNotNullParameter(error, "it");
            AppLog appLog = AppLog.g;
            StringBuilder sbU = a.U("Could not process next notice: ");
            sbU.append(StoreNotices.access$getNoticeQueue$p(StoreNotices.this));
            Logger.e$default(appLog, sbU.toString(), error.getThrowable(), null, 4, null);
        }
    }

    public StoreNotices(Clock clock, StoreStream storeStream) {
        m.checkNotNullParameter(clock, "clock");
        m.checkNotNullParameter(storeStream, "stream");
        this.clock = clock;
        this.stream = storeStream;
        this.noticesSeenCache = new Persister<>("NOTICES_SHOWN_V2", new HashMap());
        this.noticeQueue = new PriorityQueue<>(11, d0.u.a.compareBy(StoreNotices$noticeQueue$1.INSTANCE, StoreNotices$noticeQueue$2.INSTANCE, StoreNotices$noticeQueue$3.INSTANCE));
        this.pollRateMs = 30000L;
        this.lastShownTimes = new HashMap<>();
        BehaviorSubject<Unit> behaviorSubjectK0 = BehaviorSubject.k0();
        m.checkNotNullExpressionValue(behaviorSubjectK0, "BehaviorSubject.create()");
        this.processTrigger = behaviorSubjectK0;
        BehaviorSubject<Notice> behaviorSubjectL0 = BehaviorSubject.l0(null);
        m.checkNotNullExpressionValue(behaviorSubjectL0, "BehaviorSubject.create(null as Notice?)");
        this.noticePublisher = behaviorSubjectL0;
        this.firstUseTimestamp = g.lazy(new StoreNotices$firstUseTimestamp$2(this));
    }

    public static final /* synthetic */ Clock access$getClock$p(StoreNotices storeNotices) {
        return storeNotices.clock;
    }

    public static final /* synthetic */ PriorityQueue access$getNoticeQueue$p(StoreNotices storeNotices) {
        return storeNotices.noticeQueue;
    }

    public static final /* synthetic */ long access$getPollRateMs$p(StoreNotices storeNotices) {
        return storeNotices.pollRateMs;
    }

    public static final /* synthetic */ void access$processNextNotice(StoreNotices storeNotices) {
        storeNotices.processNextNotice();
    }

    public static final /* synthetic */ void access$setPollRateMs$p(StoreNotices storeNotices, long j) {
        storeNotices.setPollRateMs(j);
    }

    public static /* synthetic */ void markSeen$default(StoreNotices storeNotices, String str, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = storeNotices.clock.currentTimeMillis();
        }
        storeNotices.markSeen(str, j);
    }

    private final synchronized void processNextNotice() {
        Object next;
        Iterator<T> it = this.noticeQueue.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((Notice) next).shouldShow(this.lastShownTimes)) {
                    break;
                }
            }
        }
        this.noticePublisher.onNext((Notice) next);
    }

    private final void setPollRateMs(long j) {
        this.pollRateMs = Math.max(500L, j);
    }

    public final synchronized void clearSeen(String noticeName) {
        m.checkNotNullParameter(noticeName, "noticeName");
        this.noticesSeenCache.getAndSet(true, new AnonymousClass1(noticeName));
    }

    public final long getFirstUseTimestamp() {
        return ((Number) this.firstUseTimestamp.getValue()).longValue();
    }

    public final Observable<Notice> getNotices() {
        Observable<Notice> observableR = this.noticePublisher.r();
        m.checkNotNullExpressionValue(observableR, "noticePublisher.distinctUntilChanged()");
        return observableR;
    }

    public final StoreStream getStream() {
        return this.stream;
    }

    public final synchronized boolean hasBeenSeen(String noticeName) {
        m.checkNotNullParameter(noticeName, "noticeName");
        return this.noticesSeenCache.get().get(noticeName) != null;
    }

    public final synchronized boolean hasSeen(String noticeName) {
        m.checkNotNullParameter(noticeName, "noticeName");
        return this.noticesSeenCache.get().containsKey(noticeName);
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        m.checkNotNullParameter(context, "context");
        super.init(context);
        AppLog appLog = AppLog.g;
        Logger.d$default(appLog, "Notices init", null, 2, null);
        Logger.d$default(appLog, "Notices prev seen: " + this.noticesSeenCache.get().entrySet(), null, 2, null);
        Observable observableP = this.processTrigger.Y(new AnonymousClass1()).p(50L, TimeUnit.MILLISECONDS);
        m.checkNotNullExpressionValue(observableP, "processTrigger\n        .…S, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationLatest(observableP), StoreNotices.class, (Context) null, (Function1) null, new AnonymousClass3(), (Function0) null, (Function0) null, new AnonymousClass2(), 54, (Object) null);
    }

    public final void markDialogSeen(String noticeDialogType) {
        m.checkNotNullParameter(noticeDialogType, "noticeDialogType");
        try {
            markSeen(Dialog.Type.valueOf(noticeDialogType));
        } catch (IllegalArgumentException unused) {
            markSeen$default(this, noticeDialogType, 0L, 2, null);
        }
    }

    public final synchronized void markInAppSeen() {
        PriorityQueue<Notice> priorityQueue = this.noticeQueue;
        ArrayList arrayList = new ArrayList();
        for (Object obj : priorityQueue) {
            if (w.contains$default((CharSequence) ((Notice) obj).getName(), (CharSequence) IN_APP_NOTICE_TAG, false, 2, (Object) null)) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            markSeen$default(this, ((Notice) it.next()).getName(), 0L, 2, null);
        }
    }

    public final synchronized void markSeen(String noticeName, long seenAtMs) {
        Object next;
        Object next2;
        m.checkNotNullParameter(noticeName, "noticeName");
        AppLog.i("Notice seen: " + noticeName + " @ " + seenAtMs);
        Iterator<T> it = this.noticeQueue.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (m.areEqual(((Notice) next).getName(), noticeName)) {
                    break;
                }
            }
        }
        Notice notice = (Notice) next;
        if (notice != null) {
            this.noticeQueue.remove(notice);
            if (notice.getDelayPeriodMs() <= this.pollRateMs) {
                Iterator<T> it2 = this.noticeQueue.iterator();
                if (it2.hasNext()) {
                    next2 = it2.next();
                    if (it2.hasNext()) {
                        long delayPeriodMs = ((Notice) next2).getDelayPeriodMs();
                        do {
                            Object next3 = it2.next();
                            long delayPeriodMs2 = ((Notice) next3).getDelayPeriodMs();
                            if (delayPeriodMs > delayPeriodMs2) {
                                next2 = next3;
                                delayPeriodMs = delayPeriodMs2;
                            }
                        } while (it2.hasNext());
                    }
                } else {
                    next2 = null;
                }
                Notice notice2 = (Notice) next2;
                setPollRateMs(notice2 != null ? notice2.getDelayPeriodMs() : 30000L);
            }
            this.lastShownTimes.put(Integer.valueOf(notice.getPriority()), Long.valueOf(seenAtMs));
            if (notice.getPersist()) {
                HashMap<String, Long> map = this.noticesSeenCache.get();
                map.put(notice.getName(), Long.valueOf(seenAtMs));
                this.noticesSeenCache.set(map, true);
                Logger.v$default(AppLog.g, "Notice seen saved: " + noticeName + " @ " + seenAtMs, null, 2, null);
            }
            this.noticePublisher.onNext(null);
        }
        this.processTrigger.onNext(Unit.a);
    }

    public final Observable<HashMap<String, Long>> observeNoticesSeen() {
        return this.noticesSeenCache.getObservable();
    }

    public final synchronized void requestToShow(Notice notice) {
        m.checkNotNullParameter(notice, "notice");
        if (notice.canShow(this.noticesSeenCache.get().get(notice.getName()))) {
            PriorityQueue<Notice> priorityQueue = this.noticeQueue;
            boolean z2 = true;
            if (!(priorityQueue instanceof Collection) || !priorityQueue.isEmpty()) {
                Iterator<T> it = priorityQueue.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (m.areEqual(((Notice) it.next()).getName(), notice.getName())) {
                        z2 = false;
                        break;
                    }
                }
            }
            if (z2) {
                this.noticeQueue.add(notice);
                AppLog.i("Notice Request: " + notice.getName());
                Logger.d$default(AppLog.g, "Notice queues: " + this.noticeQueue, null, 2, null);
                long delayPeriodMs = notice.getDelayPeriodMs();
                if (delayPeriodMs < this.pollRateMs) {
                    setPollRateMs(delayPeriodMs);
                }
                this.processTrigger.onNext(Unit.a);
            }
        }
    }

    public final void markSeen(Dialog.Type type) {
        m.checkNotNullParameter(type, "type");
        markSeen$default(this, type.name(), 0L, 2, null);
    }
}
