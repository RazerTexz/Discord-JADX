package com.discord.stores;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.core.app.NotificationCompat;
import com.discord.BuildConfig;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.subjects.BehaviorSubject;
import rx.subjects.SerializedSubject;

/* compiled from: StoreClientVersion.kt */
/* loaded from: classes2.dex */
public final class StoreClientVersion extends Store {
    private int clientMinVersion;
    private final int clientVersion = BuildConfig.VERSION_CODE;
    private final String clientMinVersionKey = "CLIENT_OUTDATED_KEY";
    private final SerializedSubject<Boolean, Boolean> clientOutdatedSubject = new SerializedSubject<>(BehaviorSubject.l0(Boolean.FALSE));

    /* compiled from: StoreClientVersion.kt */
    /* renamed from: com.discord.stores.StoreClientVersion$init$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Long, Observable<? extends Integer>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Integer> call(Long l) {
            return call2(l);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Integer> call2(Long l) {
            return RestAPI.INSTANCE.getApi().getClientVersion();
        }
    }

    /* compiled from: StoreClientVersion.kt */
    /* renamed from: com.discord.stores.StoreClientVersion$init$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
        public AnonymousClass2(StoreClientVersion storeClientVersion) {
            super(1, storeClientVersion, StoreClientVersion.class, "setClientMinVersion", "setClientMinVersion(I)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.a;
        }

        public final void invoke(int i) {
            StoreClientVersion.access$setClientMinVersion((StoreClientVersion) this.receiver, i);
        }
    }

    public static final /* synthetic */ void access$setClientMinVersion(StoreClientVersion storeClientVersion, int i) {
        storeClientVersion.setClientMinVersion(i);
    }

    private final synchronized void setClientMinVersion(int clientMinVersion) {
        if (this.clientMinVersion != clientMinVersion) {
            this.clientMinVersion = clientMinVersion;
            this.clientOutdatedSubject.k.onNext(Boolean.valueOf(this.clientVersion < clientMinVersion));
            SharedPreferences.Editor editorEdit = getPrefs().edit();
            Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
            editorEdit.putInt(this.clientMinVersionKey, clientMinVersion);
            editorEdit.apply();
        }
    }

    public final Observable<Boolean> getClientOutdated() {
        Observable<Boolean> observableR = ObservableExtensionsKt.computationLatest(this.clientOutdatedSubject).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "clientOutdatedSubject\n  …  .distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.Store
    public synchronized void init(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        super.init(context);
        int i = getPrefs().getInt(this.clientMinVersionKey, 0);
        this.clientMinVersion = i;
        setClientMinVersion(i);
        Observable<R> observableA = Observable.E(0L, 1L, TimeUnit.HOURS).A(AnonymousClass1.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableA, "Observable\n        .inte…ClientVersion()\n        }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationBuffered(observableA), getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(this), 62, (Object) null);
    }
}
