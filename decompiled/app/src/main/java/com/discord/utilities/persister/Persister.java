package com.discord.utilities.persister;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.TimeElapsed;
import com.discord.widgets.chat.input.MentionUtils;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.p502io.Input;
import com.esotericsoftware.kryo.p502io.Output;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.Collections2;
import p507d0.p591y.Closeable;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;
import p658rx.subjects.BehaviorSubject;
import p658rx.subjects.SerializedSubject;
import p658rx.subjects.Subject;

/* compiled from: Persister.kt */
/* loaded from: classes2.dex */
public final class Persister<T> {
    private static Clock clock;

    @SuppressLint({"StaticFieldLeak"})
    private static Context context;
    private static boolean initialized;
    private static Preloader preferencesPreloader;
    private final T defaultValue;
    private final String key;
    private T value;
    private boolean valueDirty;
    private Subject<T, T> valueSubject;
    private boolean valueUnset;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static Function3<? super Integer, ? super String, ? super Exception, Unit> logger = Persister6.INSTANCE;
    private static Function1<? super Kryo, Unit> kryoConfig = Persister4.INSTANCE;
    private static final Persister5 kryos = new Persister5();
    private static final List<WeakReference<Persister<?>>> preferences = new CopyOnWriteArrayList();

    /* compiled from: Persister.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ long access$availableBytes(Companion companion) {
            return companion.availableBytes();
        }

        public static final /* synthetic */ void access$persistAll(Companion companion) {
            companion.persistAll();
        }

        private final long availableBytes() {
            Context contextAccess$getContext$cp = Persister.access$getContext$cp();
            if (contextAccess$getContext$cp == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("context");
            }
            Object systemService = contextAccess$getContext$cp.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            if (!(systemService instanceof ActivityManager)) {
                systemService = null;
            }
            ActivityManager activityManager = (ActivityManager) systemService;
            if (activityManager == null) {
                return RecyclerView.FOREVER_NS;
            }
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo.availMem;
        }

        private final void persistAll() {
            Iterator<T> it = Persister.access$getPreferences$cp().iterator();
            while (it.hasNext()) {
                ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(((WeakReference) it.next()).get());
                Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable\n          .just(weakPreference.get())");
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationBuffered(scalarSynchronousObservable), Persister.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, Persister7.INSTANCE, 62, (Object) null);
            }
        }

        public final Function1<Kryo, Unit> getKryoConfig() {
            return Persister.access$getKryoConfig$cp();
        }

        public final Function3<Integer, String, Exception, Unit> getLogger() {
            return Persister.access$getLogger$cp();
        }

        public final void init(Context context, Clock clock, Observable<Boolean> persistenceStrategy) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(clock, "clock");
            Intrinsics3.checkNotNullParameter(persistenceStrategy, "persistenceStrategy");
            if (Persister.access$getInitialized$cp()) {
                return;
            }
            Persister.access$setInitialized$cp(true);
            Persister.access$setContext$cp(context);
            Persister.access$setClock$cp(clock);
            Persister.access$setPreferencesPreloader$cp(new Preloader(clock));
            Observable<Boolean> observableM11118y = persistenceStrategy.m11118y(Persister2.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableM11118y, "persistenceStrategy\n    …er { persist -> persist }");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationBuffered(observableM11118y), Persister.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, Persister3.INSTANCE, 62, (Object) null);
        }

        public final Observable<Boolean> isPreloaded() {
            Preloader preloaderAccess$getPreferencesPreloader$cp = Persister.access$getPreferencesPreloader$cp();
            if (preloaderAccess$getPreferencesPreloader$cp == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("preferencesPreloader");
            }
            return preloaderAccess$getPreferencesPreloader$cp.isPreloaded();
        }

        public final void reset() {
            Iterator<T> it = Persister.access$getPreferences$cp().iterator();
            while (it.hasNext()) {
                Persister persister = (Persister) ((WeakReference) it.next()).get();
                if (persister != null) {
                    Persister.clear$default(persister, false, 1, null);
                }
            }
        }

        public final void setKryoConfig(Function1<? super Kryo, Unit> function1) {
            Intrinsics3.checkNotNullParameter(function1, "<set-?>");
            Persister.access$setKryoConfig$cp(function1);
        }

        public final void setLogger(Function3<? super Integer, ? super String, ? super Exception, Unit> function3) {
            Intrinsics3.checkNotNullParameter(function3, "<set-?>");
            Persister.access$setLogger$cp(function3);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: Persister.kt */
    public static final class Preloader {
        private final List<String> preloadCacheKeys;
        private final SerializedSubject<Persister<?>, Persister<?>> preloadSubject;
        private final TimeElapsed preloadTime;

        /* compiled from: Persister.kt */
        /* renamed from: com.discord.utilities.persister.Persister$Preloader$1 */
        public static final class C68301<T, R> implements Func1<Persister<?>, Boolean> {
            public static final C68301 INSTANCE = new C68301();

            @Override // p637j0.p641k.Func1
            public /* bridge */ /* synthetic */ Boolean call(Persister<?> persister) {
                return call2(persister);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Boolean call2(Persister<?> persister) {
                return Boolean.valueOf(persister == null);
            }
        }

        /* compiled from: Persister.kt */
        /* renamed from: com.discord.utilities.persister.Persister$Preloader$2 */
        public static final class C68312 extends Lambda implements Function1<Persister<?>, Unit> {
            public C68312() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Persister<?> persister) {
                invoke2(persister);
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Persister<?> persister) {
                if (persister != null) {
                    Preloader.access$handlePreload(Preloader.this, persister);
                }
            }
        }

        public Preloader(Clock clock) {
            Intrinsics3.checkNotNullParameter(clock, "clock");
            this.preloadTime = new TimeElapsed(clock, 0L, 2, null);
            SerializedSubject<Persister<?>, Persister<?>> serializedSubject = new SerializedSubject<>(BehaviorSubject.m11129k0());
            this.preloadSubject = serializedSubject;
            this.preloadCacheKeys = Collections2.mutableListOf("STORE_USER_RELATIONSHIPS_V9", "STORE_CHANNELS_V26", "STORE_GUILDS_V34");
            Observable<Persister<?>> observableM11103b0 = serializedSubject.m11103b0(C68301.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableM11103b0, "preloadSubject\n          .takeUntil { it == null }");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationBuffered(observableM11103b0), Preloader.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C68312(), 62, (Object) null);
        }

        public static final /* synthetic */ void access$handlePreload(Preloader preloader, Persister persister) {
            preloader.handlePreload(persister);
        }

        private final synchronized <T> void handlePreload(Persister<T> persister) {
            if (this.preloadCacheKeys.contains(persister.getKey())) {
                this.preloadCacheKeys.remove(persister.getKey());
                persister.get();
            }
            if (this.preloadCacheKeys.isEmpty()) {
                this.preloadSubject.f27653k.onNext(null);
                Persister.INSTANCE.getLogger().invoke(4, "Preloaded preferences in " + this.preloadTime.getSeconds() + " seconds.", null);
            }
        }

        public final Observable<Boolean> isPreloaded() {
            Observable<Boolean> observableM11112r = this.preloadSubject.m11083G(Persister8.INSTANCE).m11112r();
            Intrinsics3.checkNotNullExpressionValue(observableM11112r, "preloadSubject\n         …  .distinctUntilChanged()");
            return observableM11112r;
        }

        public final synchronized <T> void preload(Persister<T> preference) {
            Intrinsics3.checkNotNullParameter(preference, "preference");
            if (this.preloadCacheKeys.contains(preference.getKey())) {
                this.preloadSubject.f27653k.onNext(preference);
            }
        }
    }

    /* compiled from: Persister.kt */
    /* renamed from: com.discord.utilities.persister.Persister$getObservable$1 */
    public static final class C68321 extends Lambda implements Function0<Subject<T, T>> {

        /* compiled from: Persister.kt */
        /* renamed from: com.discord.utilities.persister.Persister$getObservable$1$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1 {
            public final /* synthetic */ SerializedSubject $subject;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(SerializedSubject serializedSubject) {
                super(1);
                this.$subject = serializedSubject;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Void) obj);
                return Unit.f27425a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final void invoke(Void r2) {
                SerializedSubject serializedSubject = this.$subject;
                serializedSubject.f27653k.onNext(Persister.this.get());
            }
        }

        public C68321() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return invoke();
        }

        @Override // kotlin.jvm.functions.Function0
        public final Subject<T, T> invoke() {
            SerializedSubject serializedSubject = new SerializedSubject(BehaviorSubject.m11129k0());
            ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(null);
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable\n          .just(null)");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationBuffered(scalarSynchronousObservable), Persister.this.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(serializedSubject), 62, (Object) null);
            return serializedSubject;
        }
    }

    public Persister(String str, T t) {
        Intrinsics3.checkNotNullParameter(str, "key");
        Intrinsics3.checkNotNullParameter(t, "defaultValue");
        this.key = str;
        this.defaultValue = t;
        this.value = t;
        this.valueUnset = true;
        preferences.add(new WeakReference<>(this));
        Preloader preloader = preferencesPreloader;
        if (preloader == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("preferencesPreloader");
        }
        preloader.preload(this);
    }

    public static final /* synthetic */ Clock access$getClock$cp() {
        return clock;
    }

    public static final /* synthetic */ Context access$getContext$cp() {
        return context;
    }

    public static final /* synthetic */ boolean access$getInitialized$cp() {
        return initialized;
    }

    public static final /* synthetic */ Function1 access$getKryoConfig$cp() {
        return kryoConfig;
    }

    public static final /* synthetic */ Function3 access$getLogger$cp() {
        return logger;
    }

    public static final /* synthetic */ List access$getPreferences$cp() {
        return preferences;
    }

    public static final /* synthetic */ Preloader access$getPreferencesPreloader$cp() {
        return preferencesPreloader;
    }

    public static final /* synthetic */ void access$persist(Persister persister) {
        persister.persist();
    }

    public static final /* synthetic */ void access$setClock$cp(Clock clock2) {
        clock = clock2;
    }

    public static final /* synthetic */ void access$setContext$cp(Context context2) {
        context = context2;
    }

    public static final /* synthetic */ void access$setInitialized$cp(boolean z2) {
        initialized = z2;
    }

    public static final /* synthetic */ void access$setKryoConfig$cp(Function1 function1) {
        kryoConfig = function1;
    }

    public static final /* synthetic */ void access$setLogger$cp(Function3 function3) {
        logger = function3;
    }

    public static final /* synthetic */ void access$setPreferencesPreloader$cp(Preloader preloader) {
        preferencesPreloader = preloader;
    }

    public static /* synthetic */ Object clear$default(Persister persister, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        return persister.clear(z2);
    }

    public static /* synthetic */ Object getAndSet$default(Persister persister, boolean z2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        return persister.getAndSet(z2, function1);
    }

    private final File getFileInput() {
        StringBuilder sb = new StringBuilder();
        Context context2 = context;
        if (context2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("context");
        }
        sb.append(context2.getFilesDir());
        sb.append(MentionUtils.SLASH_CHAR);
        sb.append(this.key);
        return new File(sb.toString());
    }

    private final Input getFileInputStream() {
        File fileInput = getFileInput();
        if (!fileInput.exists() || fileInput.length() >= Companion.access$availableBytes(INSTANCE)) {
            return null;
        }
        return new Input(new FileInputStream(fileInput));
    }

    private final FileOutputStream getFileOutput() throws FileNotFoundException {
        Context context2 = context;
        if (context2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("context");
        }
        FileOutputStream fileOutputStreamOpenFileOutput = context2.openFileOutput(this.key, 0);
        Intrinsics3.checkNotNullExpressionValue(fileOutputStreamOpenFileOutput, "context.openFileOutput(key, Context.MODE_PRIVATE)");
        return fileOutputStreamOpenFileOutput;
    }

    private final T getFileValue() {
        T t;
        try {
            Input fileInputStream = getFileInputStream();
            if (fileInputStream != null) {
                try {
                    Kryo kryo = kryos.get();
                    if (kryo != null) {
                        Object classAndObject = kryo.readClassAndObject(fileInputStream);
                        t = !(classAndObject instanceof Object) ? (T) null : classAndObject;
                        if (t == null) {
                            t = this.value;
                            StringBuilder sb = new StringBuilder();
                            sb.append("Found " + classAndObject.getClass() + " for " + this.key + ", ");
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("but expecting ");
                            sb2.append(t.getClass());
                            sb2.append('\"');
                            sb.append(sb2.toString());
                            String string = sb.toString();
                            Intrinsics3.checkNotNullExpressionValue(string, "StringBuilder()\n        …              .toString()");
                            logger.invoke(6, "Unable to cast deserialized preference " + this.key + '.', new Exception(string));
                        }
                    } else {
                        t = this.value;
                    }
                    Closeable.closeFinally(fileInputStream, null);
                    if (t != null) {
                        return (T) t;
                    }
                } finally {
                }
            }
            return this.value;
        } catch (Exception e) {
            logger.invoke(5, outline.m820H(outline.m833U("Unable to deserialize preference "), this.key, '.'), new Exception(this.key, e));
            return this.value;
        }
    }

    private static /* synthetic */ void getFileValue$annotations() {
    }

    public static final Observable<Boolean> isPreloaded() {
        return INSTANCE.isPreloaded();
    }

    private final synchronized void persist() {
        if (this.valueDirty) {
            this.valueDirty = false;
            try {
                Output output = new Output(getFileOutput());
                try {
                    Kryo kryo = kryos.get();
                    if (kryo != null) {
                        kryo.writeClassAndObject(output, this.value);
                    }
                    Closeable.closeFinally(output, null);
                } finally {
                }
            } catch (Exception e) {
                logger.invoke(5, "Unable to serialize preference " + this.key + '.', new Exception(this.key, e));
            }
        }
    }

    public static final void reset() {
        INSTANCE.reset();
    }

    public static /* synthetic */ Object set$default(Persister persister, Object obj, boolean z2, int i, Object obj2) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        return persister.set(obj, z2);
    }

    public final T clear() {
        return (T) clear$default(this, false, 1, null);
    }

    public final T clear(boolean persist) {
        return set(this.defaultValue, persist);
    }

    public final synchronized T get() {
        if (this.valueUnset) {
            this.valueUnset = false;
            this.value = getFileValue();
        }
        return this.value;
    }

    public final T getAndSet(Function1<? super T, ? extends T> function1) {
        return (T) getAndSet$default(this, false, function1, 1, null);
    }

    public final synchronized T getAndSet(boolean persist, Function1<? super T, ? extends T> setter) {
        Intrinsics3.checkNotNullParameter(setter, "setter");
        return set(setter.invoke(get()), persist);
    }

    public final String getKey() {
        return this.key;
    }

    public final synchronized Observable<T> getObservable() {
        Subject<T, T> subjectInvoke;
        C68321 c68321 = new C68321();
        subjectInvoke = this.valueSubject;
        if (subjectInvoke == null) {
            subjectInvoke = c68321.invoke();
            this.valueSubject = subjectInvoke;
        }
        return subjectInvoke;
    }

    public final T set(T t) {
        return (T) set$default(this, t, false, 2, null);
    }

    public final synchronized T set(T newValue, boolean persist) {
        T t;
        Intrinsics3.checkNotNullParameter(newValue, "newValue");
        this.valueDirty = true;
        this.valueUnset = false;
        t = this.value;
        this.value = newValue;
        Subject<T, T> subject = this.valueSubject;
        if (subject != null) {
            subject.onNext(newValue);
        }
        if (persist) {
            persist();
        }
        return t;
    }
}
