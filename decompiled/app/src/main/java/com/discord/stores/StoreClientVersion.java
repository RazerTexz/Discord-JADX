package com.discord.stores;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.core.app.NotificationCompat;
import com.discord.BuildConfig;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;
import p658rx.Observable;
import p658rx.subjects.BehaviorSubject;
import p658rx.subjects.SerializedSubject;

/* compiled from: StoreClientVersion.kt */
/* loaded from: classes2.dex */
public final class StoreClientVersion extends Store {
    private int clientMinVersion;
    private final int clientVersion = BuildConfig.VERSION_CODE;
    private final String clientMinVersionKey = "CLIENT_OUTDATED_KEY";
    private final SerializedSubject<Boolean, Boolean> clientOutdatedSubject = new SerializedSubject<>(BehaviorSubject.m11130l0(Boolean.FALSE));

    /* compiled from: StoreClientVersion.kt */
    /* renamed from: com.discord.stores.StoreClientVersion$init$1 */
    public static final class C58471<T, R> implements Func1<Long, Observable<? extends Integer>> {
        public static final C58471 INSTANCE = new C58471();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Integer> call(Long l) {
            return call2(l);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Integer> call2(Long l) {
            return RestAPI.INSTANCE.getApi().getClientVersion();
        }
    }

    /* compiled from: StoreClientVersion.kt */
    /* renamed from: com.discord.stores.StoreClientVersion$init$2 */
    public static final /* synthetic */ class C58482 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
        public C58482(StoreClientVersion storeClientVersion) {
            super(1, storeClientVersion, StoreClientVersion.class, "setClientMinVersion", "setClientMinVersion(I)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.f27425a;
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
            this.clientOutdatedSubject.f27653k.onNext(Boolean.valueOf(this.clientVersion < clientMinVersion));
            SharedPreferences.Editor editorEdit = getPrefs().edit();
            Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
            editorEdit.putInt(this.clientMinVersionKey, clientMinVersion);
            editorEdit.apply();
        }
    }

    public final Observable<Boolean> getClientOutdated() {
        Observable<Boolean> observableM11112r = ObservableExtensionsKt.computationLatest(this.clientOutdatedSubject).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "clientOutdatedSubject\n  …  .distinctUntilChanged()");
        return observableM11112r;
    }

    @Override // com.discord.stores.Store
    public synchronized void init(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        super.init(context);
        int i = getPrefs().getInt(this.clientMinVersionKey, 0);
        this.clientMinVersion = i;
        setClientMinVersion(i);
        Observable<R> observableM11082A = Observable.m11061E(0L, 1L, TimeUnit.HOURS).m11082A(C58471.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11082A, "Observable\n        .inte…ClientVersion()\n        }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationBuffered(observableM11082A), getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C58482(this), 62, (Object) null);
    }
}
